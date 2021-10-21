package org.r3.ws.mongocms.post;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.geo.GeoJson;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.DTOBase;
import org.r3.db.mongo.MongoImageIconDTO;
import org.r3.db.mongo.postcollection.PostCollectionDTO;
import org.r3.db.mongo.postcollection.PostCollectionDTO.StatusType;
import org.r3.db.mongo.postcollection.PostCollectionDTOBase.CommentsDTO;
import org.r3.db.mongo.postcollection.PostCollectionDTOBase.TextbodyDTO;
import org.r3.db.mongo.postcommentcollection.PostCommentCollectionDTO;
import org.r3.db.utils.MongoUtils;
import org.r3.ws.mongocms.post.PostComment_PUT.UpdateVerb;


public class PostActionForm
{
	@FormParam("title")
    private String title;

    public String getTitle()
    {    	
    	String s = DTOBase.nullOnEmpty(title);
    	if (s != null && s.length() > 80)
    		s = s.substring(0, 80);
    	
    	return s;
    }
    
	@FormParam("timeline")
    private String timeline;

    public String getTimeline()
    {    	
    	return DTOBase.nullOnEmpty(timeline);
    }
    
	@FormParam("contentclassgrp")
    private String[] contentclassgrp;

    public String[] getContentclassgrp()
    {    	
    	return DTOBase.nullOnEmpty(contentclassgrp);
    }
    
	private List<String> getContentclassgrpAsList()
	{
		String[] cgs = getContentclassgrp();
		if (cgs != null)
		{
			List<String> l = new ArrayList<String>();
			for(String s : cgs)
			{
				l.add(s);
			}
			
			return l;
		}
		
		return null;
	}
	
	@FormParam("contentcategory")
    private String contentcategory;

    public String getContentcategory()
    {    	
    	return DTOBase.nullOnEmpty(contentcategory);
    }
    
	@FormParam("contentclass")
    private String contentclass;

    public String getContentclass()
    {    	
    	return DTOBase.nullOnEmpty(contentclass);
    }
    
	@FormParam("content")
    private String content;

    public String getContent()
    {    	
    	return DTOBase.nullOnEmpty(content);
    }
    	
    public Document getContentAsDocument()
    {
		String nt = getContent();
		if (nt != null)
		{
			try
			{
			    Document d = Document.parse(nt);
			    return d;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return null;
    }
    
    @FormParam("photo")
    private String photo;

    public String getPhoto()
    {    	
    	return DTOBase.nullOnEmpty(photo);
    }
    	
    public MongoImageIconDTO getPhotoAsMongoImageIconDTO()
    {
		String nt = getPhoto();
		if (nt != null)
		{
			try
			{
				MongoImageIconDTO mimg = MongoImageIconDTO.newInstanceFromJSONString(nt);
			    return mimg;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return null;
    }
    
	@FormParam("postparentid")
    private String postparentid;

    public String getPostparentid()
    {    	
    	return DTOBase.nullOnEmpty(postparentid);
    }
    
	@FormParam("postfiles")
    private String postfiles;

    public String getPostfiles()
    {    	
    	return DTOBase.nullOnEmpty(postfiles);
    }

    public String[] getListOfPostFiles()
    {    	
    	String s = DTOBase.nullOnEmpty(postfiles);
    	if (s != null)
    		return s.split(",");
    	
    	return null;
    }

    @FormParam("author")
    private String author;

    public String getAuthor()
    {    	
    	return DTOBase.nullOnEmpty(author);
    }

    @FormParam("authorname")
    private String authorname;

    public String getAuthorname()
    {    	
    	return DTOBase.nullOnEmpty(authorname);
    }

    @FormParam("authortype")
    private String authortype;

    public String getAuthortype()
    {    	
    	return DTOBase.nullOnEmpty(authortype);
    }

    @FormParam("shakeit")
    private String shakeit;

    public String getShakeit()
    {    	
    	return DTOBase.nullOnEmpty(shakeit);
    }
    
    public boolean has2BeShaked()
    {
    	String s = getShakeit();
    	if (s != null)
    	{
    		return s.equalsIgnoreCase("true");
    	}
    	
    	return false;
    }

	@FormParam("summary")
    private String summary;

    public String getSummary()
    {    	
    	return DTOBase.nullOnEmpty(summary);
    }

	@FormParam("textbody")
    private String textbody;

    public String getTextbody()
    {    	
    	return DTOBase.nullOnEmpty(textbody);
    }

	@FormParam("geolat")
    private String geolat;

    public String getGeolat()
    {    	
    	return DTOBase.nullOnEmpty(geolat);
    }
    
	@FormParam("geolong")
    private String geolong;

    public String getGeolong()
    {    	
    	return DTOBase.nullOnEmpty(geolong);
    }

	@FormParam("geoacc")
    private String geoacc;

    public String getGeoacc()
    {    	
    	return DTOBase.nullOnEmpty(geoacc);
    }

	@FormParam("publish2facebook")
    private String publish2facebook;

    public String getPublish2facebook()
    {    	
    	return DTOBase.nullOnEmpty(publish2facebook);
    }
	
    public boolean getPublish2facebookAsBoolean()
    {    	
    	String s = getPublish2facebook();
    	return DTOBase.getBTrueFalseAsBoolean(s);
    }

    public org.mongodb.morphia.geo.Point getGeoLocation()
    {
    	org.mongodb.morphia.geo.Point p = null;
    	
    	String latitude  = getGeolat();
    	String longitude = getGeolong();
    	
    	if (latitude != null && longitude != null)
    	{
    		p = GeoJson.point(Double.parseDouble(latitude), Double.parseDouble(longitude));
    	}
    	
    	return p;
    }
    
//	public BBSThreadNodeDTO getDTO4Update(BBSThreadNodeDTO dto, String aSite, String aTopicId, String aThreadId, String aThreadNodeId)
//	{
//		if (dto == null)
//		{
//			 dto = new BBSThreadNodeDTO();
//			 dto.setThreadnodeid(aThreadNodeId);			
//		}
//		else dto.clearDirtyFlags();
//
//		dto.setSite(aSite);
//		dto.setThreadid(aThreadId);
//		
//		dto.setNodetitle(getNodetitle());
//		dto.setNodetext(getNodetext());
//		dto.setRectimestamp(DTOBase.currentTimestamp());
//		dto.setRecstatus(RecordStatus.sys_recact.toString());
//		return  dto;
//	}

	public PostCollectionDTO getDTO4Insert(String requestSiteId, String aDomain, String userid, String lastname)
	{
		PostCollectionDTO dto = new PostCollectionDTO();
		dto.setSite(requestSiteId);
		dto.setDomain(aDomain);
		dto.setTimeline(getTimeline());
		dto.setLastmodified(new java.util.Date());
		dto.setAuthor(getAuthor());
		dto.setAuthorname(getAuthorname());
		dto.setAuthortype(getAuthortype());
		dto.setUserid(userid);
		dto.setContentcategory(getContentcategory());	
		dto.setContentclass(getContentclass());	
		
		org.mongodb.morphia.geo.Point geoLocation = getGeoLocation();
		if (geoLocation != null)
			dto.setGeolocation(geoLocation);
		
		// dto.setContent(getContentAsDocument());
		dto.setTitle(getTitle());
		// dto.setPhoto(getPhotoAsMongoImageIconDTO());
		return dto;
	}
	

	public PostCollectionDTO getDTO4InsertFromTimeline(String requestSiteId, String aDomain, String userid, String lastname)
	{
		PostCollectionDTO dto = new PostCollectionDTO();
		dto.setSite(requestSiteId);
		dto.setDomain(aDomain);
		dto.setTimeline(getTimeline());
		dto.setLastmodified(new java.util.Date());
		dto.setAuthor(getAuthor());
		dto.setAuthorname(getAuthorname());
		dto.setAuthortype(getAuthortype());
		dto.setUserid(userid);
		dto.setContentcategory(getContentcategory());
		dto.setContentclass(getContentclass());
		dto.setContent(getContentAsDocument());
		dto.setTitle(getTitle());
		dto.setPhoto(getPhotoAsMongoImageIconDTO());
        dto.setStatus(PostCollectionDTO.StatusType.published.toString());

		org.mongodb.morphia.geo.Point geoLocation = getGeoLocation();
		if (geoLocation != null)
			dto.setGeolocation(geoLocation);
		
		return dto;
	}

	public UpdateOperations<PostCollectionDTO> getUpdateOperationFromTimeline(Datastore mongoDatastore, PostCollectionDTO aPost)
	{
        UpdateOperations<PostCollectionDTO> uop = mongoDatastore.createUpdateOperations(PostCollectionDTO.class);
        aPost.setLastmodified4Update(uop, new java.util.Date());
        aPost.setContent4Update(uop, getContentAsDocument());
		aPost.setTitle4Update(uop, getTitle());
				
		return  uop;
	}
	
	public UpdateOperations<PostCollectionDTO> getUpdateGeneralInfoOperation(Datastore mongoDatastore, PostCollectionDTO aPost)
	{
        UpdateOperations<PostCollectionDTO> uop = mongoDatastore.createUpdateOperations(PostCollectionDTO.class);
        aPost.setLastmodified4Update(uop, new java.util.Date());
       
        // aPost.setContent4Update(uop, getContentAsDocument());
		aPost.setTitle4Update(uop, getTitle());
		return  uop;
	}

	public UpdateOperations<PostCollectionDTO> getUpdatePublishingInfoOperation(Datastore mongoDatastore, PostCollectionDTO aPost, StatusType aStatus)
	{
        UpdateOperations<PostCollectionDTO> uop = mongoDatastore.createUpdateOperations(PostCollectionDTO.class);
        aPost.setLastmodified4Update(uop, new java.util.Date());
        aPost.setTimeline4Update(uop, getTimeline());
        
        List<String> contentClassGrp = getContentclassgrpAsList();
        if (contentClassGrp != null)
        	  aPost.setGroups4Update(uop,  getContentclassgrpAsList());
        else  aPost.unsetGroups4Update(uop);
        	
        aPost.setStatus4Update(uop, aStatus.toString());
		return  uop;
	}
	
	
	public UpdateOperations<PostCollectionDTO> getUpdateTextBodyOperation(Datastore mongoDatastore, PostCollectionDTO aPost, String aLanguageCode)
	{
        UpdateOperations<PostCollectionDTO> uop = mongoDatastore.createUpdateOperations(PostCollectionDTO.class);
        
        List<TextbodyDTO> listOfTextBodies = aPost.getTextbody();
        if (listOfTextBodies == null)
        	listOfTextBodies = new ArrayList<TextbodyDTO>();
        
        boolean tbpresent = false;
        for(int i = 0; i < listOfTextBodies.size(); i++)
        {
        	TextbodyDTO dto = listOfTextBodies.get(i);
        	if (dto.getLanguage().equalsIgnoreCase(aLanguageCode))
        	{
        		dto.setTitle(getTitle());
        		dto.setSummary(getSummary());
        		dto.setBody(getTextbody());
        		tbpresent = true;
        		break;
        	}
        }
        
        if (!tbpresent)
        {
        	TextbodyDTO dto = new TextbodyDTO();
            dto.setLanguage(aLanguageCode);
            dto.setTitle(getTitle());
        	dto.setSummary(getSummary());
    		dto.setBody(getTextbody());
    		listOfTextBodies.add(dto);
        }
        
        aPost.setLastmodified4Update(uop, new java.util.Date());
		aPost.setTextbody4Update(uop, listOfTextBodies);
		return  uop;
	}

	public UpdateOperations<PostCollectionDTO> getUpdateOperation4Content(Datastore mongoDatastore, PostCollectionDTO aPost)
	{
        UpdateOperations<PostCollectionDTO> uop = mongoDatastore.createUpdateOperations(PostCollectionDTO.class);
        aPost.setLastmodified4Update(uop, new java.util.Date());
        aPost.setContent4Update(uop, getContentAsDocument());
		aPost.setTitle4Update(uop, getTitle());
		return  uop;
	}
	
	public PostCommentCollectionDTO getDTO4InsertComment(String requestSiteId, String requestSiteDomain, 
			String postId, String timelineId, String userid, String lastname)
	{
		PostCommentCollectionDTO dto = new PostCommentCollectionDTO();
		dto.setSite(requestSiteId);
		dto.setDomain(requestSiteDomain);
		dto.setTimeline(timelineId);
		dto.setPostid(MongoUtils.getObjectIdFromString(postId));
		dto.setLastmodified(new java.util.Date());
		dto.setAuthor(getAuthor());
		dto.setAuthorname(getAuthorname());
		dto.setAuthortype(getAuthortype());
		dto.setUserid(userid);
		dto.setContentcategory(getContentcategory());
		dto.setContentclass(getContentclass());
		dto.setContent(getContentAsDocument());
		dto.setTitle(getTitle());
		
		if (has2BeShaked())
		{
			dto.setShakedate(DTOBase.currentTimestamp());
			dto.setShakeevent(new ObjectId());
		}
		
		return dto;
	}	
	
	public UpdateOperations<PostCollectionDTO> getAddComment2PostOperation(Datastore mongoDatastore, PostCommentCollectionDTO dto)
	{
		UpdateOperations<PostCollectionDTO> uop = mongoDatastore.createUpdateOperations(PostCollectionDTO.class);
		
		CommentsDTO dto1 = new CommentsDTO();
		dto1.setCommentid(dto.getCommentid());
		dto1.setLastmodified(new java.util.Date());
		dto1.setAuthor(dto.getAuthor());
		dto1.setAuthorname(dto.getAuthorname());
		dto1.setAuthortype(dto.getAuthortype());
		dto1.setUserid(dto.getUserid());
		dto1.setContentcategory(getContentcategory());
		dto1.setContentclass(dto.getContentclass());
		dto1.setContent(dto.getContent());
		dto1.setTitle(dto.getTitle());

		dto1.setShakedate(dto.getShakedate());
		dto1.setShakeevent(dto.getShakeevent());

	    uop.add(PostCollectionDTO.COMMENTS, dto1);   
		return uop;
	}

	public PostCommentCollectionDTO getDTO4UpdateComment(UpdateVerb aVerb, String requestSiteId, String requestSiteDomain, String timelineId,
			String postId, String commentId, String userid, String lastname)
	{
		PostCommentCollectionDTO dto = getDTO4InsertComment(requestSiteId, requestSiteDomain, timelineId, postId, userid, lastname);
		dto.setCommentid(commentId);
		return dto;
	}

	public PostCommentCollectionDTO getDTO4UpdateComment(
			Datastore mongoDatastore, 
			UpdateVerb updateVerb, 
			PostCommentCollectionDTO commentDTO, 
			String userid, String lastname)
	{
		UpdateOperations<PostCommentCollectionDTO> uop = mongoDatastore.createUpdateOperations(PostCommentCollectionDTO.class);
		
		switch(updateVerb)
		{
		case update: 
			commentDTO.setLastmodified4Update(uop, new java.util.Date());
			commentDTO.setContent4Update(uop, getContentAsDocument());
			commentDTO.setTitle4Update(uop, getTitle());										
			break;
		case shake:
			commentDTO.setShakedate4Update(uop, DTOBase.currentTimestamp());
			commentDTO.setShakeevent4Update(uop, new ObjectId());
			break;
		case unshake: 
			commentDTO.setShakedate4Update(uop, DTOBase.currentTimestamp());
			commentDTO.unsetShakeevent4Update(uop);
			break;
		}
		return commentDTO;
	}






}
