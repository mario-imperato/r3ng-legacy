package org.r3.ws.user.usercollection;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.r3.db.mongo.usercollection.UserCollectionDTO;
import org.r3.db.utils.DataTableQueryActionForm;


public class UserCollectionQueryActionForm extends DataTableQueryActionForm
{    
	
	public Query<UserCollectionDTO> getSiteMembers(Datastore ds, String aSite, String aSiteDomain)
	{
		// ;
		Query<UserCollectionDTO> query = ds.createQuery(UserCollectionDTO.class);
		
		query.field(UserCollectionDTO.FAVSITES).equal(aSite);
				
		return query;
	}
}
