package org.r3.ws.mongocms.post;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.r3.db.mongo.postcommentcollection.PostCommentCollectionDTO;
import org.r3.db.utils.DataTableQueryActionForm;


public class PostCommentQueryActionForm extends DataTableQueryActionForm
{
	
	public Query<PostCommentCollectionDTO>  getSearchCondition(Datastore ds, String targetSite, ObjectId aPostId)
	{
		Query<PostCommentCollectionDTO> filter = ds.createQuery(PostCommentCollectionDTO.class);						
		filter.field(PostCommentCollectionDTO.SITE).equal(targetSite);
		
		filter.field(PostCommentCollectionDTO.POSTID).equal(aPostId);	
		
		if (isDefaultSorting())
		     filter.order(" -commentid ");
		else filter.order(getMongoSortingCondition());
		
		return filter;
	}
}
