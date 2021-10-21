package org.r3.ws.system.sms;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.PersistenceContext;
import org.r3.db.actor.actor.ActorPersistence;
import org.r3.db.system.queues.model.Queue;
import org.r3.db.system.queues.model.QueueException;
import org.r3.db.system.siteproperty.SitePropertyDTO;
import org.r3.db.system.siteproperty.SitePropertyPersistence;
import org.r3.db.system.smsqueue.SMSQueueDTO;
import org.r3.db.system.smsqueue.SMSQueuePersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.ws.system.event.QM_SendSMSEvent;

public class POSTSMS extends ServicePattern
{
	private SMSActionForm actionForm;

	public POSTSMS(ServletContext ctx, ServiceEnvironment serviceEnvironment, SMSActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		SMSQueuePersistence p = SMSQueuePersistence.createPersistenceObject(pcfg, aSession);

		SMSQueueDTO dto1 = actionForm.getDTO4Insert(senv.getRequestSiteId());
		p.insert(dto1, pcfg.getPersistenceConfigInfo());

		ActorPersistence itemPersistence = ActorPersistence.createPersistenceObject(pcfg, aSession);
		int numberOfActors = itemPersistence.insertActorsIntoSMS(senv.getRequestSiteId(), dto1.getSmsid(),
						actionForm.getActorgroup(), pcfg.getPersistenceConfigInfo());

		dto1.setNumberoftargets(numberOfActors);
		
		// Nel caso in cui non ci sono attori inserisco una descrizione di errore generica. 
		if (numberOfActors == 0)
		{
			dto1.setRecstatus(RecordStatus.sys_recprocessed.toString());
			dto1.setGtwayresponsecode("-1");
			dto1.setGtwayresponsereason("Nessun contatto selezionato");
		}
		
		p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());

		SitePropertyPersistence sitePropertyPersistence = SitePropertyPersistence.createPersistenceObject(pcfg, aSession);

		sitePropertyPersistence.insertOrUpdate(senv.getRequestSiteId(), SitePropertyDTO.SMS_PKG, SitePropertyDTO.SMS_SENDER, dto1.getSmssender(), pcfg.getPersistenceConfigInfo());
		sitePropertyPersistence.insertOrUpdate(senv.getRequestSiteId(), SitePropertyDTO.SMS_PKG, SitePropertyDTO.SMS_LOGIN, actionForm.getSmslogin(), pcfg.getPersistenceConfigInfo());
		sitePropertyPersistence.insertOrUpdate(senv.getRequestSiteId(), SitePropertyDTO.SMS_PKG, SitePropertyDTO.SMS_PASSWD, actionForm.getSmspasswd(), pcfg.getPersistenceConfigInfo());

		if (numberOfActors > 0)
		{
			try
			{
				Queue q = Queue.newInstance(pcfg, aSession, "eventqueue");
				QM_SendSMSEvent qm = new QM_SendSMSEvent(senv.getRequestSiteId(), dto1.getSmsid(), actionForm.getSmslogin(),
								actionForm.getSmspasswd());
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
