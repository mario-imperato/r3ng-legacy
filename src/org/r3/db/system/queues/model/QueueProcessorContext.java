package org.r3.db.system.queues.model;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.system.util.velocity.VelocityTemplateModel;

public class QueueProcessorContext
{
	private PersistenceContext pcfg;
	
	private SqlSession queueSession;
	private boolean queueSessionManaged;
	
	private SqlSession processSession;
	private boolean processSessionManaged;
	
	private VelocityTemplateModel velocityEngine;
	
	public PersistenceContext getPcfg()
	{
		return pcfg;
	}

	public void setPcfg(PersistenceContext pcfg)
	{
		this.pcfg = pcfg;
	}

	public SqlSession getQueueSession()
	{
		if (queueSession == null)
			return processSession;
		
		return queueSession;
	}

	public void setQueueSession(SqlSession queueSession, boolean managedFlag)
	{
		this.queueSession = queueSession;
		queueSessionManaged = managedFlag;
	}

	public SqlSession getProcessSession()
	{
		return processSession;
	}

	public void setProcessSession(SqlSession processSession, boolean managedFlag)
	{
		this.processSession = processSession;
		processSessionManaged = managedFlag;
	}

	public VelocityTemplateModel getVelocityEngine()
	{
		return velocityEngine;
	}

	public void setVelocityEngine(VelocityTemplateModel velocityEngine)
	{
		this.velocityEngine = velocityEngine;
	}

	public void close()
	{
		if (queueSessionManaged && queueSession != null)
			queueSession.close();
		
		if (processSessionManaged && processSession != null)
			processSession.close();		
	}
}
