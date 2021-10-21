package org.r3.ws.user.user;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.actor.actor.ActorDTO;
import org.r3.db.actor.actor.ActorPersistence;
import org.r3.db.actor.relactorgroup.ActorGroupRelationPersistence;
import org.r3.db.mongo.usercollection.UserCollectionDTO;
import org.r3.db.mongo.usercollection.UserCollectionPersistence;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.user.user.UserDTO;
import org.r3.db.system.user.user.UserPersistence;
import org.r3.db.system.user.userrole.UserRoleDTO;
import org.r3.db.system.user.userrole.UserRolePersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTUser extends ServicePattern
{
    private UserActionForm actionForm;
    private String userId;
    
	public PUTUser(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aUserId, UserActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		userId = aUserId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		UserPersistence p = UserPersistence.createPersistenceObject(pcfg, aSession);		
				
		UserDTO dto1 = actionForm.getDTO4Update(userId);		
	    p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());

	    UserRolePersistence p2 = UserRolePersistence.createPersistenceObject(pcfg, aSession);
	    p2.deleteRolesBySiteUserid(senv.getRequestSiteId(), userId, pcfg.getPersistenceConfigInfo());
	    
	    String[] ar = actionForm.getAuthrole();
	    if (ar != null && ar.length > 0)
	    {
	       for(int i = 0; i < ar.length; i++)
	       {
	    	   UserRoleDTO urDto = new UserRoleDTO();
	    	   urDto.setSite(senv.getRequestSiteId());
	    	   urDto.setRoleid(ar[i]);
	    	   urDto.setUserid(userId);
	    	   p2.insert(urDto, pcfg.getPersistenceConfigInfo());
	       }
	    }
	    
	    ActorPersistence ap = ActorPersistence.createPersistenceObject(pcfg, aSession);
	    ActorGroupRelationPersistence relActor = ActorGroupRelationPersistence.createPersistenceObject(pcfg, aSession);
	    
	    ActorDTO currentActor4UserDto = ap.selectByEventidUserid(senv.getRequestSiteId(), dto1.getUserid(), pcfg.getPersistenceConfigInfo());
	    ActorDTO newActor4UserDto = null;
	    if (actionForm.getCreatesiteactorAsBoolean())
	    {	    		    		    	
			if (currentActor4UserDto == null)
			{
				currentActor4UserDto = dto1.getActorDTO4CurrentUser(senv.getRequestSiteId());
				ap.insert(currentActor4UserDto, pcfg.getPersistenceConfigInfo());
				relActor.insertActorIntoGroup(senv.getRequestSiteId(), "ACGLOGIN", currentActor4UserDto.getActorid(), pcfg.getPersistenceConfigInfo());

				
			}
	    }
	    else
	    {	
	    	if (currentActor4UserDto != null)
	    	{
	    		currentActor4UserDto.setUserid(null);
	    		ap.updateByPrimaryKey(currentActor4UserDto, pcfg.getPersistenceConfigInfo());
	    		
	    	    relActor.deleteByEventidGroupidActorid(senv.getRequestSiteId(), "ACGLOGIN", currentActor4UserDto.getActorid(), pcfg.getPersistenceConfigInfo());
	    	}
	    }
	    
	    // Aggiorno il record corrispondente nella collection Mongo se disponibile
	    if (pcfg.isMongoDbAvailable())
	    {
	    	MongoPersistenceContext mpctx = pcfg.getMongoPersistenceContext();
	    	Datastore datastore = mpctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
	    	
	    	UpdateOperations<UserCollectionDTO> uop = datastore.createUpdateOperations(UserCollectionDTO.class);
	    	actionForm.getUserCollectionDTO4Update(userId, uop);
	    	
	    	UserCollectionPersistence ucp = UserCollectionPersistence.createPersistenceObject(mpctx);
	    	ucp.updateByUserid(datastore, uop, userId , true);	    	
	    }
	    
//	    UserRolePersistence p2 = UserRolePersistence.createPersistenceObject(pcfg, aSession);
//	    UserRoleFilter userFilter = new UserRoleFilter();
//	    userFilter.or().andUseridEqualTo(userId);
//	    p2.delete(userFilter, pcfg.getPersistenceConfigInfo());
//	    
//	    String[] ruolipostaliz = actionForm.getRoles();
//	    if (ruolipostaliz != null && ruolipostaliz.length > 0)
//	    {
//	    	UserRoleDTO dto2 = new UserRoleDTO();
//	    	dto2.setUserid(dto1.getUserid());
//	    	for(String r : ruolipostaliz)
//	    	{
//	    		dto2.setRoleid(r);
//	    		p2.insert(dto2, pcfg.getPersistenceConfigInfo());
//	    	}	         
//	    }
	    
	    LUTManager.getLUTManager().invalidateLUT(LUTName.userprofile);
	    
		return dto1;
	}
}
