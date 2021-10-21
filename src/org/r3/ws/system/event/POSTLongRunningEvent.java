package org.r3.ws.system.event;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.queues.model.Queue;
import org.r3.db.system.queues.model.QueueException;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTLongRunningEvent extends ServicePattern
{
	public POSTLongRunningEvent(ServletContext ctx, ServiceEnvironment serviceEnvironment)
	{
		super(ctx, serviceEnvironment);
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		try
		{
			Queue q = Queue.newInstance(pcfg, aSession, "eventqueue");
			QM_LongRunningEvent qm = new QM_LongRunningEvent();
			q.put(qm);
		}
		catch (QueueException e)
		{
			e.printStackTrace();
			throw new ServicePatternException(e.getMessage());
		}
		
		return RestServiceDTO.SuccessDTO;
	}

}
