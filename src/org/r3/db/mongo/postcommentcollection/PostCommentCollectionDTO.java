//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//

package org.r3.db.mongo.postcommentcollection;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.mongo.postcollection.PostCollectionDTO.AuthorType;

/*
 * Please Define in MongoDbSchemaInfo: public static final String MongoDbTimelineCommentCollectionName = "r3_timelinecommentcollection";
 */
@Entity(value = MongoDbSchemaInfo.MongoDbPostCommentCollectionName, noClassnameStored = true)
public class PostCommentCollectionDTO extends PostCommentCollectionDTOBase
{
	public PostCommentCollectionDTO()
	{
		super();
	}

	public void setAuthortype(AuthorType anAuthorType)
	{
		setAuthortype(anAuthorType.toString());
	}
	
	 public void unsetShakeevent4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext)
	 {
		  setShakeevent((ObjectId) null);
		  anUpdateContext.unset(SHAKEEVENT);
	 }  

}
