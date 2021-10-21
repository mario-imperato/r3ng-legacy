package org.r3.ws.actors.actor;

import javax.ws.rs.QueryParam;

import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.actor.actor.ActorCriteria;
import org.r3.db.actor.actor.ActorFilter;
import org.r3.db.utils.DataTableQueryActionForm;
import org.r3.db.utils.SQLStringUtils;
import org.r3.db.utils.SQLStringUtils.LikeMode;


public class ActorQueryActionForm extends DataTableQueryActionForm
{
	
	@QueryParam("firstname")
    private String firstname;

    public String getFirstname()
    {
   		return DTOBase.nullOnEmpty(firstname);
    }

	@QueryParam("lastname")
    private String lastname;

    public String getLastname()
    {    	
   	    return DTOBase.nullOnEmpty(lastname);
    }

	@QueryParam("email")
    private String email;

    public String getEmail()
    {    	
    	return DTOBase.nullOnEmpty(email);
    }

	@QueryParam("cellphone")
    private String cellphone;

    public String getCellphone()
    {    	
    	return DTOBase.nullOnEmpty(cellphone);
    }

	@QueryParam("logincontact")
    private String logincontact;

    public String getLogincontact()
    {    	
    	return DTOBase.nullOnEmpty(logincontact);
    }

    public boolean getLogincontactAsBoolean()
    {    	
    	return DTOBase.getBTrueFalseAsBoolean(logincontact);
    }

	@QueryParam("groupid")
    private String[] groupid;

    public String[] getGroupid()
    {    	
    	return DTOBase.nullOnEmpty(groupid);
    }

    public boolean isGroupidMultiple()
    {
        return getGroupid() != null;
    }
    
	@QueryParam("notingroupid")
    private String notingroupid;

    public String getNotingroupid()
    {    	
    	return DTOBase.nullOnEmpty(notingroupid);
    }

	@QueryParam("csvformat")
    private String csvformat;

    public String getCsvformat()
    {    	
    	return DTOBase.nullOnEmpty(csvformat);
    }

	public ActorFilter getSearchCondition(String aSite)
	{
		ActorFilter filter = new ActorFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" lastname asc ");
		else filter.setOrderByClause(getSortingCondition());
				
		ActorCriteria criteria = filter.or().andEventidEqualTo(aSite);
		
		criteria.andMailOrNameLike(getsSearch());
		
		if (getFirstname() != null)
		{
			criteria.andFirstnameLike(SQLStringUtils.getStringForLikeMode(getFirstname(), LikeMode.FullLike));
		}

		if (getLastname() != null)
		{
			criteria.andLastnameLike(SQLStringUtils.getStringForLikeMode(getLastname(), LikeMode.FullLike));
		}

		if (getEmail() != null)
		{
			criteria.andEmailLike(SQLStringUtils.getStringForLikeMode(getEmail(), LikeMode.FullLike));
		}
		
		if (getLogincontactAsBoolean())
		{
		    criteria.andUseridIsNotNull();	
		}
		
		if (getGroupid() != null)
		{
			if (isGroupidMultiple())
			{
				criteria.andActorInGroup(aSite, getGroupid());
			}
			else criteria.andActorInGroup(aSite, getGroupid()[0]);			
		}

		if (getNotingroupid() != null)
		{
			criteria.andActorNotInGroup(aSite, getNotingroupid());			
		}

		criteria.andRecstatusNotEqualTo(RecordStatus.sys_recdeleted.toString());
		
		return filter;
	}
}
