package org.r3.ws.actors.actorgroup;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.user.user.UserDataTableAdapter;
import org.r3.db.system.user.user.UserFilter;
import org.r3.db.system.user.user.UserPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETUsersInActorGroup extends ServicePattern
{
    private ActorGroupQueryActionForm queryForm;
    private String groupId;
    
	public GETUsersInActorGroup(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aGroupId, ActorGroupQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		groupId = aGroupId;
		queryForm = aQueryForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		UserPersistence p = UserPersistence.createPersistenceObject(pcfg, aSession);				
		UserFilter filter = queryForm.getSearchCondition4UsersInGroup(senv.getRequestSiteId(), groupId);
		
		UserDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		return dt;
	}



}
