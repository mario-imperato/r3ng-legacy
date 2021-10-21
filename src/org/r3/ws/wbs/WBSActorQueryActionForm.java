package org.r3.ws.wbs;

import javax.ws.rs.QueryParam;

import org.r3.db.DTOBase;
import org.r3.db.utils.DataTableQueryActionForm;
import org.r3.db.wbs.wbsactor.WBSActorDTO.WBSActorRole;
import org.r3.db.wbs.wbsactor.WBSActorFilter;


public class WBSActorQueryActionForm extends DataTableQueryActionForm
{    
	@QueryParam("wbsmanagers")
	private String wbsmanagers;
	
	public String getWbsmanagers()
	{
	    return DTOBase.nullOnEmpty(wbsmanagers);	
	}

	public boolean getWbsmanagersAsBoolean()
	{
	    return DTOBase.getBTrueFalseAsBoolean(getWbsmanagers());
	}

	public WBSActorFilter getSearchCondition(String aSite, String aWbsId)
	{
		WBSActorFilter filter = new WBSActorFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" wbsactorid desc ");
		else filter.setOrderByClause(getSortingCondition());
				
		if (getWbsmanagersAsBoolean())
		{
			filter.or().andSiteEqualTo(aSite).andWbsidEqualTo(aWbsId);
			filter.or().andSiteEqualTo(aSite).andActorroleEqualTo(WBSActorRole.sponsor.toString());
		}
		
		return filter;
	}
}
