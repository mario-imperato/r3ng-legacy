package org.r3.ws.system.event;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.dms.model.DMSContext;
import org.r3.db.dms.model.DMSFileHelper;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.outmailattachment.OutMailAttachmentDTO;
import org.r3.db.system.outmailattachment.OutMailAttachmentPersistence;
import org.r3.db.system.outmailspooler.OutMailSpoolerDTO;
import org.r3.db.system.outmailspooler.OutMailSpoolerPersistence;
import org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDTO;
import org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientPersistence;
import org.r3.db.system.queues.model.QueueMessage;
import org.r3.db.system.queues.model.QueueMessageProcessorException;
import org.r3.db.system.queues.model.QueueProcessorContext;
import org.r3.db.system.queues.simplemail.MailRecipient;
import org.r3.db.system.queues.simplemail.SimpleNotifier;
import org.r3.db.system.siteproperty.SitePropertyDTO;
import org.r3.db.system.siteproperty.SitePropertyDTO.PropertyScope;
import org.r3.db.system.siteproperty.SitePropertyLUT;

public class QPM_SendNewMailMessageEvent extends QPM_QueueEventProcessor
{	
	private static final int processingBatchSize = 10;
	
	@Override
	public boolean process(QueueProcessorContext processContext, QueueMessage aQueueMessage) throws QueueMessageProcessorException
	{
		boolean processingComplete = true;
		
		QM_SendNewMailMessageEvent qm = (QM_SendNewMailMessageEvent) aQueueMessage;
		String smsId = qm.getRefentita();
		logger.info(String.format("Process Event: %s for %s", qm.getEvent().toString(), qm.getSiteContext()));
				
		SqlSession session = processContext.getProcessSession();
		PersistenceContext pcfg = processContext.getPcfg();
						
		try
		{
			OutMailSpoolerPersistence p = OutMailSpoolerPersistence.createPersistenceObject(pcfg, session);
			OutMailSpoolerDTO dto = p.selectBySiteMessageid(qm.getSiteContext(), smsId, pcfg.getPersistenceConfigInfo());
			if (dto != null)
			{
				List<OutMailAttachmentDTO> listOfAttachments = null;
				
				if (dto.getNumberofattachments() > 0)
				{
				   OutMailAttachmentPersistence attach = OutMailAttachmentPersistence.createPersistenceObject(pcfg, session);
				   listOfAttachments = attach.selectByMessageid(dto.getMessageid(), pcfg.getPersistenceConfigInfo());
				}
				
				OutMailSpoolerRecipientPersistence pr = OutMailSpoolerRecipientPersistence.createPersistenceObject(pcfg, session);
				List<OutMailSpoolerRecipientDTO> listOfRecipients = pr.selectActiveRecipientByMessageId(qm.getSiteContext(), smsId, processingBatchSize, pcfg.getPersistenceConfigInfo());
				
				if (listOfRecipients != null && listOfRecipients.size() > 0)
				{					
					if (listOfRecipients.size() == processingBatchSize)
					       processingComplete = false;

					enqueueMailToRecipients(pcfg, session, dto, listOfRecipients, listOfAttachments);
					
					// Do whatever to process.
					for(OutMailSpoolerRecipientDTO rdto : listOfRecipients)
					{
						pr.updateRecstatusByRecipientid(rdto.getRecipientid(), "sys_recprocessed",  pcfg.getPersistenceConfigInfo());
					}
				}
			}
			
			if (processingComplete)
			{
				p.updateRecstatusBySiteMessageid(qm.getSiteContext(), smsId, "sys_recprocessed",  pcfg.getPersistenceConfigInfo());
			}
			
			session.commit();
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
			session.rollback();
		}
		
		return processingComplete;
	}

	private void enqueueMailToRecipients(PersistenceContext ctx, SqlSession aSession, OutMailSpoolerDTO mailDto, List<OutMailSpoolerRecipientDTO> listOfRecipientsDto, List<OutMailAttachmentDTO> listOfOutMailAttachmentDTO) throws Exception
	{        	
		String messageBody = mailDto.getMsgtext();
		
		SitePropertyLUT sitePropertyLut = (SitePropertyLUT)LUTManager.getLUTManager().getLUT(LUTName.siteproperty, null); 
        SimpleNotifier wm = new SimpleNotifier(); 

        String messageSender = sitePropertyLut.getDtodescr(mailDto.getSite(), PropertyScope.mail, SitePropertyDTO.SMTPAUTHACCOUNT);
        wm.setMessageSender(messageSender);
        wm.setMessageTitle(mailDto.getMsgtitle());
        
        List<MailRecipient> listOfRecipients = new ArrayList<MailRecipient>();
        for(OutMailSpoolerRecipientDTO dto : listOfRecipientsDto)
        {
            MailRecipient recipient = MailRecipient.newRecipient(dto.getMsgto(), mailDto.areRecipientsUndisclosed() ? MailRecipient.BCC_RECIPIENT: MailRecipient.TO_RECIPIENT);     
            listOfRecipients.add(recipient);
        }               

        if (mailDto.areRecipientsUndisclosed())
        {
        	MailRecipient recipient = MailRecipient.newRecipient("regattacubed@gmail.com", MailRecipient.TO_RECIPIENT);     
            listOfRecipients.add(recipient);
        }
        
        addRecipients(listOfRecipients, mailDto.getMsgbccRecipients(), MailRecipient.BCC_RECIPIENT);
        addRecipients(listOfRecipients, mailDto.getMsgccRecipients(), MailRecipient.CC_RECIPIENT);
        
        List<String> listOfAttachmentsAsFilenames = null;
        if (listOfOutMailAttachmentDTO != null && listOfOutMailAttachmentDTO.size() > 0)
        {
           listOfAttachmentsAsFilenames = new ArrayList<String>();        	
           DMSContext dmsContext = new DMSContext(ctx, aSession);
           
           for(OutMailAttachmentDTO d : listOfOutMailAttachmentDTO)	
           {        	   
        	   File f = DMSFileHelper.getDMSFileAsFile(dmsContext, d.getAttachmenturl());
        	   if (f != null)
        		   listOfAttachmentsAsFilenames.add(f.getAbsolutePath());
        	   else 
        		   logger.info(String.format("Cannot Find Attachment URL: %s", d.getAttachmenturl()));
           }
        }
        
        wm.notify(ctx, aSession, mailDto.getSite(), messageBody, listOfRecipients, listOfAttachmentsAsFilenames, 2);	
	}

	private List<MailRecipient> addRecipients(List<MailRecipient> aListOfRecipients, String[] aListOfEmail, int recipientType)
	{
		if (aListOfEmail != null && aListOfEmail.length > 0)
        {
        	for(String s : aListOfEmail)
            {
                MailRecipient recipient = MailRecipient.newRecipient(s, MailRecipient.BCC_RECIPIENT);     
                aListOfRecipients.add(recipient);
            } 
        }
		
		return aListOfRecipients;
	}
}
