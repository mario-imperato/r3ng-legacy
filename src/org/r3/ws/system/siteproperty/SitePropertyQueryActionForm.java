package org.r3.ws.system.siteproperty;

import javax.ws.rs.QueryParam;

import org.r3.db.DTOBase;
import org.r3.db.system.siteproperty.SitePropertyCriteria;
import org.r3.db.system.siteproperty.SitePropertyFilter;
import org.r3.db.utils.DataTableQueryActionForm;
import org.r3.db.utils.SQLStringUtils;


public class SitePropertyQueryActionForm extends DataTableQueryActionForm
{
	@QueryParam("propertyscope")
    private String propertyscope;

    public String getPropertyscope()
    {
   		return DTOBase.nullOnEmpty(propertyscope);
    }

	@QueryParam("propertyscopeexact")
    private String propertyscopeexact;

    public String getPropertyscopeexact()
    {
   		return DTOBase.nullOnEmpty(propertyscopeexact);
    }

    public boolean getPropertyscopeexactAsBoolean()
    {
    	String s = getPropertyscopeexact();
    	if (s != null)
    		return DTOBase.getBTrueFalseAsBoolean(s);
    	
    	return true;
    }
    
	@QueryParam("propertykey")
    private String propertykey;

    public String getPropertykey()
    {    	
   	    return DTOBase.nullOnEmpty(propertykey);
    }
    
	public SitePropertyFilter getSearchCondition(String aSite)
	{
		SitePropertyFilter filter = new SitePropertyFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" propertykey asc ");
		else filter.setOrderByClause(getSortingCondition());
				
		SitePropertyCriteria c = filter.or()
		   .andSiteEqualTo(aSite, true);
		
		if (getPropertyscopeexactAsBoolean())
			 c.andPropertyscopeEqualTo(getPropertyscope());
		else
		{
			c.andPropertyscopeLike(SQLStringUtils.getStringForLikeMode(getPropertyscope(), SQLStringUtils.LikeMode.LeftLike));
		}
		
		c.andPropertykeyLike(SQLStringUtils.getStringForLikeMode(getPropertykey(), SQLStringUtils.LikeMode.LeftLike));
		
		return filter;
	}
}
