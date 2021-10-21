package org.r3.ws.system.event;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.PersistenceContext;
import org.r3.db.system.queues.model.QueueMessage;
import org.r3.db.system.queues.model.QueueMessageProcessorException;
import org.r3.db.system.queues.model.QueueProcessorContext;
import org.r3.db.system.siteproperty.SitePropertyDTO;
import org.r3.db.system.siteproperty.SitePropertyPersistence;
import org.r3.db.system.smsqueue.SMSQueueDTO;
import org.r3.db.system.smsqueue.SMSQueuePersistence;
import org.r3.db.system.smsqueueitem.SMSQueueItemDTO;
import org.r3.db.system.smsqueueitem.SMSQueueItemPersistence;
import org.r3.ws.system.event.smsbizclient.SMSBizClient;
import org.r3.ws.system.event.smsbizclient.SMSBizClient.SMSBizClientProperties;
import org.r3.ws.system.event.smsbizclient.SMSBizClient.SMSBizClientResponse;

public class QPM_SendSMSEvent extends QPM_QueueEventProcessor
{	
	@Override
	public boolean process(QueueProcessorContext processContext, QueueMessage aQueueMessage) throws QueueMessageProcessorException
	{
		boolean logHttpResponsesFlag = true;
		
		QM_SendSMSEvent qm = (QM_SendSMSEvent) aQueueMessage;
		String smsId = qm.getRefentita();
		logger.info(String.format("Process Event: %s for %s with %s, %s", qm.getEvent().toString(), qm.getSiteContext(), qm.getSmsLogin(), qm.getSmsPassword()));
				
		SqlSession session = processContext.getProcessSession();
		PersistenceContext pcfg = processContext.getPcfg();
				
		SMSBizClientProperties smsBizClientProperties = getSmsBizClientProperties(qm.getSiteContext(), session, pcfg);
		
		SMSQueuePersistence smsPersistence = SMSQueuePersistence.createPersistenceObject(pcfg, session);
		SMSQueueDTO dto = smsPersistence.selectBySiteSmsid(qm.getSiteContext(), smsId, pcfg.getPersistenceConfigInfo());
		if (dto == null)
		{
		    logger.error("Could not find SMS by Id: " + dto.getSmsid());	
		}
		else
		{
			SMSQueueItemPersistence smsItemPersistence = SMSQueueItemPersistence.createPersistenceObject(pcfg, session);
			List<SMSQueueItemDTO> listOfItems = smsItemPersistence.selectBySiteSmsid(qm.getSiteContext(), smsId, pcfg.getPersistenceConfigInfo());			
            String dest = getPhoneNumbersAsCSV(dto, listOfItems);			
            if (dest != null)
            {
            	SMSBizClient smsClient = 
            		SMSBizClient.newInstance(smsBizClientProperties.smsHost, smsBizClientProperties.smsPort, smsBizClientProperties.smsUrl, qm.getSmsLogin(), qm.getSmsPassword());
            	
            	SMSBizClientResponse response = smsClient.sendSMS(dto.getSmssender(), dest, dto.getSmstext(), dto.IsNotificaRicezioneMode(), dto.isFlashMode());
            	if (response.isSuccess())
            	{
            		dto.setGtwayresponsecode("OK");
            	}
            	else
            	{
            		dto.setGtwayresponsecode(response.getErrorCode());
            		dto.setGtwayresponsereason(response.getErrorReason());
            	}
            }
            
            dto.setRecstatus(RecordStatus.sys_recprocessed.toString());
            smsPersistence.updateByPrimaryKey(dto, pcfg.getPersistenceConfigInfo());
		}
		return true;
	}

	private String getPhoneNumbersAsCSV(SMSQueueDTO dto, List<SMSQueueItemDTO> listOfItems)
	{
		if (listOfItems == null || listOfItems.size() == 0)	
		{
		    logger.error("No Items found in SMS Id: " + dto.getSmsid());					
		}
		
		StringBuilder stb = new StringBuilder();
		String prevPhoneNumber = null;

		int numberOfDuplicates = 0;
		int numberOfNumbersAdded = 0;

		for(SMSQueueItemDTO itemDto : listOfItems)
		{
			if (prevPhoneNumber != null && prevPhoneNumber.equalsIgnoreCase(itemDto.getPhonenumber()))
			{
				numberOfDuplicates++;
				continue;
			}
			
			if (numberOfNumbersAdded > 0)
				stb.append(",");
			
			stb.append(itemDto.getPhonenumber());
			prevPhoneNumber = itemDto.getPhonenumber();
			
			numberOfNumbersAdded++;
		}

		if (numberOfDuplicates > 0)
		{
			logger.info(String.format("Sms [%s] - found %d duplicates ", dto.getSmsid(), numberOfDuplicates));
		}
		
		if (numberOfNumbersAdded > 0)
		{
			dto.setNumberofsentitems(numberOfNumbersAdded);
			return stb.toString();			
		}
		else
		{
		    logger.error(String.format("Sms [%s] - No Phone Numbers Added to List In " + dto.getSmsid()));										
		}
		
		return null;
	}

	private SMSBizClientProperties getSmsBizClientProperties(String aSite, SqlSession session, PersistenceContext pctx)
	{
		SitePropertyPersistence sitePropertyPersistence =  SitePropertyPersistence.createPersistenceObject(pctx, session);
		List<SitePropertyDTO> listOf = sitePropertyPersistence.selectPropertiesInPropertyScope(aSite, SitePropertyDTO.SMS_SYSTEM_PKG, null, pctx.getPersistenceConfigInfo());
		
		SMSBizClientProperties SMSProps = new SMSBizClientProperties();		
		
		if (listOf != null)
		{
			for(SitePropertyDTO dto : listOf)
			{
				if (dto.getPropertykey().equalsIgnoreCase(SitePropertyDTO.SMS_URL))
				{
					SMSProps.smsUrl = dto.getPropertyvalue();			        
				}
				
				if (dto.getPropertykey().equalsIgnoreCase(SitePropertyDTO.SMS_HOST))
				{
					SMSProps.smsHost = dto.getPropertyvalue();			        
				}
				
				if (dto.getPropertykey().equalsIgnoreCase(SitePropertyDTO.SMS_PORT))
				{
					SMSProps.smsPort = dto.getPropertyvalueAsInt();			        
				}					
			}
		}
		
		return SMSProps;
	}


}
