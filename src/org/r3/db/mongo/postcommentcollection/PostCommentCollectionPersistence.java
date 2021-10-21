//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.postcommentcollection;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.r3.db.utils.MongoUtils;

import com.mongodb.WriteResult;

public class PostCommentCollectionPersistence extends PostCommentCollectionPersistenceBase
{
  public static PostCommentCollectionPersistence createPersistenceObject(org.r3.db.MongoPersistenceContext pcfg)
  {
      PostCommentCollectionPersistence p = new PostCommentCollectionPersistence();
      return p;
  }


	public int removeBySitePostid(Datastore ds, String aSite, String aPostid) 
	{
		Query<PostCommentCollectionDTO> query = ds.createQuery(PostCommentCollectionDTO.class);
		query.field(PostCommentCollectionDTO.SITE).equal(aSite)
		     .field(PostCommentCollectionDTO.POSTID).equal(MongoUtils.getObjectIdFromString(aPostid));
		
		WriteResult res = ds.delete(query);		
		return res.getN();		
	}
	
}


