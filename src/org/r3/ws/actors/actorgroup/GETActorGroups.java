package org.r3.ws.actors.actorgroup;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.actor.group.ActorGroupDataTableAdapter;
import org.r3.db.actor.group.ActorGroupFilter;
import org.r3.db.actor.group.ActorGroupPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETActorGroups extends ServicePattern
{
    private ActorGroupQueryActionForm queryForm;
    
	public GETActorGroups(ServletContext ctx,  ServiceEnvironment serviceEnvironment, ActorGroupQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		ActorGroupPersistence p = ActorGroupPersistence.createPersistenceObject(pcfg, aSession);				
		ActorGroupFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId());
		
		ActorGroupDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		return dt;
	}



}
