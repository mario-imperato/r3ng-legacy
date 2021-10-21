package org.r3.ws.user.user;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.actor.actor.ActorDTO;
import org.r3.db.actor.actor.ActorPersistence;
import org.r3.db.actor.relactorgroup.ActorGroupRelationPersistence;
import org.r3.db.mongo.usercollection.UserCollectionPersistence;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.script.RunSqlPersistence;
import org.r3.db.system.user.user.UserDTO;
import org.r3.db.system.user.user.UserPersistence;
import org.r3.db.system.user.userrole.UserRoleDTO;
import org.r3.db.system.user.userrole.UserRolePersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.util.velocity.VelocityTemplateModel;

public class POSTUser extends ServicePattern
{
	private VelocityTemplateModel velocityEngine;
    private UserActionForm actionForm;
    
	public POSTUser(ServletContext ctx,  ServiceEnvironment serviceEnvironment, UserActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		velocityEngine = VelocityTemplateModel.getVelocityPlugInModel(ctx);		
	}

	// 25/01/2017 14:32:18 - Inserito il rethrow della ServicePatternException	
	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		UserPersistence p = UserPersistence.createPersistenceObject(pcfg, aSession);
		UserDTO userDTO = p.selectByNickname(actionForm.getNickname(), pcfg.getPersistenceConfigInfo());
		if (userDTO != null)
			return new RestServiceDTO(Status.fail, "USR_ERROR_DUPUSER", "Username gia' presenta a sistema");

		// Verifico se esistono utenti con la stessa mail e stato attivo.
		List<UserDTO> l = p.selectByEMailRecstatus(actionForm.getEmail(), RecordStatus.sys_recact, pcfg.getPersistenceConfigInfo());
		if (l != null && l.size() > 0)
			return new RestServiceDTO(Status.fail, "USR_ERROR_DUPUSER", "Utente gia' presente a sistema");
		
		UserDTO dto1 = actionForm.getDTO4Insert();		
	    p.insert(dto1, pcfg.getPersistenceConfigInfo());
	    
	    UserRolePersistence p2 = UserRolePersistence.createPersistenceObject(pcfg, aSession);	    
	    String[] ar = actionForm.getAuthrole();
	    if (ar != null && ar.length > 0)
	    {
	       for(int i = 0; i < ar.length; i++)
	       {
	    	   UserRoleDTO urDto = new UserRoleDTO();
	    	   urDto.setSite(senv.getRequestSiteId());
	    	   urDto.setRoleid(ar[i]);
	    	   urDto.setUserid(dto1.getUserid());
	    	   p2.insert(urDto, pcfg.getPersistenceConfigInfo());
	       }
	    }

		if (actionForm.getCreatesiteactorAsBoolean())
		{
			ActorPersistence ap = ActorPersistence.createPersistenceObject(pcfg, aSession);
			ActorDTO adto = dto1.getActorDTO4CurrentUser(senv.getRequestSiteId());
			ap.insert(adto, pcfg.getPersistenceConfigInfo());
			
			ActorGroupRelationPersistence relActor = ActorGroupRelationPersistence.createPersistenceObject(pcfg, aSession);			
			relActor.insertActorIntoGroup(senv.getRequestSiteId(), "ACGLOGIN", adto.getActorid(), pcfg.getPersistenceConfigInfo());			
		}
	    
	    try
		{
			RunSqlPersistence scriptPersistence = 
			RunSqlPersistence.createPersistenceObject(aSession, velocityEngine, "UserRegistrationSQLScript");
							
			scriptPersistence.addParameter("userDTO", dto1);							
			scriptPersistence.execute(pcfg, aSession);			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new ServicePatternException(e);
		}	    

	    // Inserisco il record corrispondente nella collection Mongo se disponibile
	    if (pcfg.isMongoDbAvailable())
	    {
	    	MongoPersistenceContext mpctx = pcfg.getMongoPersistenceContext();
	    	Datastore datastore = mpctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
	    	UserCollectionPersistence ucp = UserCollectionPersistence.createPersistenceObject(mpctx);
	    	ucp.insert(actionForm.getUserCollectionDTO4Insert(dto1.getUserid()), datastore);	    	
	    }
	    
//	    UserRolePersistence p2 = UserRolePersistence.createPersistenceObject(pcfg, aSession);
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
