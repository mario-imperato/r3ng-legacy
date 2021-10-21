package org.r3.ws.mongocms.post;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.r3.db.DTOBase;
import org.r3.db.mongo.postcollection.PostCollectionDTO;
import org.r3.db.utils.DataTableQueryActionForm;
import org.r3.db.utils.MongoUtils;


public class PostQueryActionForm extends DataTableQueryActionForm
{
	@QueryParam("postid")
    private String postid;

    public String getPostid()
    {    	
    	return DTOBase.nullOnEmpty(postid);
    }
    
	@QueryParam("timelineid")
    private String timelineid;

    public String getTimelineid()
    {    	
    	return DTOBase.nullOnEmpty(timelineid);
    }
    
	@QueryParam("contentclass")
    private String contentclass;

    public String getContentclass()
    {    	
    	String s = getsSearch();
    	if (s == null)    		
    		return DTOBase.nullOnEmpty(contentclass);
    	
    	return s;
    }
    
	@QueryParam("status")
    private String status;

    public String getStatus()
    {    	
    	return DTOBase.nullOnEmpty(status);
    }

	@QueryParam("groups")
    private String groups;

    public String getGroups()
    {    	
   		return DTOBase.nullOnEmpty(groups);
    }

    public List<String> getGroupsAsList()
    {    	
   		return DTOBase.string2List(groups, ",");
    }
    
	@QueryParam("includecomments")
    private String includecomments;

    public String getIncludecomments()
    {    	
    	return DTOBase.nullOnEmpty(includecomments);
    }

    public boolean getIncludecommentsAsBoolean()
    {    	
    	return DTOBase.getBTrueFalseAsBoolean(DTOBase.nullOnEmpty(includecomments));
    }

//
//	@QueryParam("categoryid")
//    private String categoryid;
//
//    public String getCategoryid()
//    {    	
//    	String s = getsSearch();
//    	if (s == null)
//    	    return DTOBase.nullOnEmpty(categoryid);
//    	
//    	return s;
//    }

	public Query<PostCollectionDTO>  getSearchCondition(Datastore ds, String targetSite)
	{
		Query<PostCollectionDTO> filter = ds.createQuery(PostCollectionDTO.class);						
		filter.field(PostCollectionDTO.SITE).equal(targetSite);
		
		if (getPostid() != null)
		{
		filter.field(PostCollectionDTO.POSTID).equal(MongoUtils.getObjectIdFromString(getPostid()));	
		}
		
		if (getContentclass() != null)
		{
			filter.field(PostCollectionDTO.CONTENTCLASS).equal(getContentclass());				
		}

		if (getTimelineid() != null)
		{
			filter.field(PostCollectionDTO.TIMELINE).equal(getTimelineid());				
		}

		if (getStatus() != null)
		{
			filter.field(PostCollectionDTO.STATUS).equal(getStatus());
		}
		
		if (getGroups() != null)
		{
			filter.field(PostCollectionDTO.GROUPS).equal(getGroupsAsList());				
		}
		
		if (isDefaultSorting())
		     filter.order(" -postid ");
		else filter.order(getMongoSortingCondition());
		
		return filter;
	}
}
