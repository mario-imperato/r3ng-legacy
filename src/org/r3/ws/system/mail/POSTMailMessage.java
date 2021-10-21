package org.r3.ws.system.mail;


import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.PersistenceContext;
import org.r3.db.actor.actor.ActorPersistence;
import org.r3.db.system.outmailattachment.OutMailAttachmentDTO;
import org.r3.db.system.outmailattachment.OutMailAttachmentFilter;
import org.r3.db.system.outmailattachment.OutMailAttachmentPersistence;
import org.r3.db.system.outmailspooler.OutMailSpoolerDTO;
import org.r3.db.system.outmailspooler.OutMailSpoolerPersistence;
import org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDTO;
import org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientPersistence;
import org.r3.db.system.queues.model.Queue;
import org.r3.db.system.queues.model.QueueException;
import org.r3.db.system.siteproperty.SitePropertyPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.ws.system.event.QM_SendNewMailMessageEvent;

public class POSTMailMessage extends ServicePattern
{
	private NewMailMessageActionForm actionForm;

	public POSTMailMessage(ServletContext ctx, ServiceEnvironment serviceEnvironment, NewMailMessageActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		OutMailSpoolerPersistence p = OutMailSpoolerPersistence.createPersistenceObject(pcfg, aSession);

		OutMailSpoolerDTO dto1 = actionForm.getDTO4Insert(senv.getRequestSiteId());
		p.insert(dto1, pcfg.getPersistenceConfigInfo());

		OutMailAttachmentPersistence attachmentPersistence = OutMailAttachmentPersistence.createPersistenceObject(pcfg, aSession);
		OutMailAttachmentDTO dto = new OutMailAttachmentDTO();
		dto.setMessageid(dto1.getMessageid());
		
		OutMailAttachmentFilter f = new OutMailAttachmentFilter();
		f.or().andAttachmentgroupidEqualTo(actionForm.getAttachmentgroupid());
		int numberOfAttachments = attachmentPersistence.update(dto, f, pcfg.getPersistenceConfigInfo());		
		
		dto1.setNumberofattachments(numberOfAttachments);
		p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());
		
		ActorPersistence itemPersistence = ActorPersistence.createPersistenceObject(pcfg, aSession);
		int numberOfActors = 0;
		
		String[] listOfActorGroups = actionForm.getActorgroup();
		if (actionForm.isSend2All() || (listOfActorGroups != null && listOfActorGroups.length > 0))
		{
			numberOfActors += itemPersistence.insertActorsIntoMail(senv.getRequestSiteId(), dto1.getMessageid(),
				listOfActorGroups, pcfg.getPersistenceConfigInfo());
		}
		
		String[] specificRecipients = actionForm.getMsgtoRecipients();
		if (specificRecipients != null && specificRecipients.length > 0)
		{
			numberOfActors += specificRecipients.length;
			
			OutMailSpoolerRecipientPersistence pr = OutMailSpoolerRecipientPersistence.createPersistenceObject(pcfg, aSession);			
			for(String s : specificRecipients)
			{
				OutMailSpoolerRecipientDTO dtor = new OutMailSpoolerRecipientDTO();
				dtor.setSite(senv.getRequestSiteId());
				dtor.setMessageid(dto1.getMessageid());
				dtor.setRecstatus(RecordStatus.sys_recact.toString());
				dtor.setMsgto(s);
				pr.insert(dtor, pcfg.getPersistenceConfigInfo());
			}
		}
		
		dto1.setNumberoftargets(numberOfActors);
		
		// Nel caso in cui non ci sono attori inserisco una descrizione di errore generica. 
		if (numberOfActors == 0)
		{
			dto1.setRecstatus(RecordStatus.sys_recprocessed.toString());
		}
		
		p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());

		SitePropertyPersistence sitePropertyPersistence = SitePropertyPersistence.createPersistenceObject(pcfg, aSession);

		if (numberOfActors > 0)
		{
			try
			{
				Queue q = Queue.newInstance(pcfg, aSession, "eventqueue");
				QM_SendNewMailMessageEvent qm = new QM_SendNewMailMessageEvent(senv.getRequestSiteId(), dto1.getMessageid());
				q.put(qm);
			}
			catch (QueueException e)
			{
				e.printStackTrace();
				throw new ServicePatternException(e.getMessage());
			}

		}

		return dto1;
	}

}
