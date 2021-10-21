package org.r3.db.mongo.usercollection;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.DTOBase;
import org.r3.db.MongoPersistenceContext;

public class UserCollectionPersistence extends UserCollectionPersistenceBase
{

	public static UserCollectionPersistence createPersistenceObject(MongoPersistenceContext pcfg)
	{
		UserCollectionPersistence p = new UserCollectionPersistence();
		return p;
	}

	public void addSite2Favsite(Datastore mongoDatastore, String userid, String requestSiteId)
	{
		UpdateOperations<UserCollectionDTO> uop = mongoDatastore.createUpdateOperations(UserCollectionDTO.class);
		uop.add(UserCollectionDTO.FAVSITES, requestSiteId);
		
		updateByUserid(mongoDatastore, uop, userid, true);
		
	}

	public void removeSiteFromFavsite(Datastore mongoDatastore, String userid, String requestSiteId)
	{
		UpdateOperations<UserCollectionDTO> uop = mongoDatastore.createUpdateOperations(UserCollectionDTO.class);
		uop.removeAll(UserCollectionDTO.FAVSITES, requestSiteId);
		
		updateByUserid(mongoDatastore, uop, userid, true);		
	}	
	
	public void updateUserAnalyticsOnPostInsert(Datastore mongoDatastore, String userid, String anAuthorid, String anAuthorType)
	{
		UpdateOperations<UserCollectionDTO> uop = mongoDatastore.createUpdateOperations(UserCollectionDTO.class);
		
		uop.set(UserCollectionDTO.USERANA_LASTPOSTACTION, DTOBase.currentTimestamp());
		uop.inc(UserCollectionDTO.USERANA_NUMBEROFPOSTS, 1);
		uop.set(UserCollectionDTO.USERANA_LASTPOSTAUTHORID, anAuthorid);
		uop.set(UserCollectionDTO.USERANA_LASTPOSTAUTHORTYPE, anAuthorType);
		
		updateByUserid(mongoDatastore, uop, userid, true);		
	}

	public void updateUserAnalyticsOnPostUpdateRemove(Datastore mongoDatastore, String userid)
	{
		UpdateOperations<UserCollectionDTO> uop = mongoDatastore.createUpdateOperations(UserCollectionDTO.class);		
		uop.set(UserCollectionDTO.USERANA_LASTPOSTACTION, DTOBase.currentTimestamp());		
		updateByUserid(mongoDatastore, uop, userid, true);		
	}
	
	public void updateUserAnalyticsOnCommentInsert(Datastore mongoDatastore, String userid, String anAuthorid, String anAuthorType)
	{
		UpdateOperations<UserCollectionDTO> uop = mongoDatastore.createUpdateOperations(UserCollectionDTO.class);
		
		uop.set(UserCollectionDTO.USERANA_LASTCOMMENTACTION, DTOBase.currentTimestamp());
		uop.inc(UserCollectionDTO.USERANA_NUMBEROFCOMMENTS, 1);
		uop.set(UserCollectionDTO.USERANA_LASTPOSTAUTHORID, anAuthorid);
		uop.set(UserCollectionDTO.USERANA_LASTPOSTAUTHORTYPE, anAuthorType);
		
		updateByUserid(mongoDatastore, uop, userid, true);		
	}

	public void updateUserAnalyticsOnCommentUpdateRemove(Datastore mongoDatastore, String userid)
	{
		UpdateOperations<UserCollectionDTO> uop = mongoDatastore.createUpdateOperations(UserCollectionDTO.class);		
		uop.set(UserCollectionDTO.USERANA_LASTCOMMENTACTION, DTOBase.currentTimestamp());		
		updateByUserid(mongoDatastore, uop, userid, true);		
	}

}
