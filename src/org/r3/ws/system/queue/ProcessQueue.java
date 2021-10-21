package org.r3.ws.system.queue;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.queues.model.QueueProcessor;
import org.r3.db.system.queues.model.QueueProcessorContext;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.util.velocity.VelocityTemplateModel;

public class ProcessQueue extends ServicePattern
{
    private String queueName;
    private VelocityTemplateModel m;
    
	public ProcessQueue(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aQueueName)
	{
		super(ctx, serviceEnvironment);
		queueName = aQueueName;
		m = VelocityTemplateModel.getVelocityPlugInModel(ctx);
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		QueueProcessor qp = new QueueProcessor();
		qp.setQueueName(queueName);
		
		QueueProcessorContext qpc = new QueueProcessorContext();
		qpc.setPcfg(pcfg);
		
		// Viene Messa a false in quanto viene chiusa dal PostDetailPattern. Ogni processore però deve eseguire il commit
		// in quanto se no finisce tutto in un'unica transazione.
		qpc.setProcessSession(aSession, false);
		qpc.setQueueSession(pcfg.openSession(), true);
		qpc.setVelocityEngine(m);
		
		qp.process(qpc);
		
		return RestServiceDTO.SuccessDTO;
	}


}
