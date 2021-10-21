package org.r3.ws.project.resource;

import javax.ws.rs.QueryParam;

import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.project.resource.ResourceCriteria;
import org.r3.db.project.resource.ResourceFilter;
import org.r3.db.utils.DataTableQueryActionForm;
import org.r3.db.utils.SQLStringUtils;
import org.r3.db.utils.SQLStringUtils.LikeMode;


public class ResourceQueryActionForm extends DataTableQueryActionForm
{
	@QueryParam("ssn")
    private String ssn;

    public String getSsn()
    {    	
    	return DTOBase.nullOnEmpty(ssn);
    }
    
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

	public ResourceFilter getSearchCondition(String aSite, String aSiteDomain, boolean limit2Site)
	{
		ResourceFilter filter = new ResourceFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" resourcedescr asc ");
		else filter.setOrderByClause(getSortingCondition());
				
		ResourceCriteria criteria = filter.or();
		
		if (limit2Site)
			criteria.andSiteEqualTo(aSite);
		
		if (aSiteDomain != null)
			criteria.andSitedomainEqualTo(aSiteDomain);
			
		criteria.andMailOrNameLike(getsSearch());
		criteria.andSsnEqualTo(getSsn());
		
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
		
		criteria.andRecstatusNotEqualTo(RecordStatus.sys_recdeleted.toString());
		
		return filter;
	}
}
