package org.r3.ws.system.eventlog;

import javax.ws.rs.QueryParam;

import org.r3.db.DTOBase;
import org.r3.db.system.eventlog.EventLogFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class EventLogQueryActionForm extends DataTableQueryActionForm
{	
	@QueryParam("usecaseambit")
    private String usecaseambit;
		
	public String getUsecaseambit()
	{
		return DTOBase.nullOnEmpty(usecaseambit);
	}

	public void setUsecaseambit(String sitetype)
	{
		this.usecaseambit = sitetype;
	}
	
	@QueryParam("usecase")
    private String usecase;
		
	public String getUsecase()
	{
		return DTOBase.nullOnEmpty(usecase);
	}

	public void setUsecase(String sitetype)
	{
		this.usecase = sitetype;
	}
	
	@QueryParam("refentityid")
    private String refentityid;
		
	public String getRefentityid()
	{
		return DTOBase.nullOnEmpty(refentityid);
	}

	public void setRefentityid(String sitetype)
	{
		this.refentityid = sitetype;
	}
	
	@QueryParam("so")
    private String so;
		
	public String getSo()
	{
		return DTOBase.nullOnEmpty(so);
	}

	public void setSo(String sitetype)
	{
		this.so = sitetype;
	}
	
	@QueryParam("gb")
    private String gb;
		
	public String getGb()
	{
		return DTOBase.nullOnEmpty(gb);
	}

	public void setGb(String sitetype)
	{
		this.gb = sitetype;
	}
	
	public EventLogFilter getStatsSearchCondition(String aDomain)
	{
		EventLogFilter filter = new EventLogFilter();
		String so = getSo();
		if (so != null)
			filter.setOrderByClause(so);
				
		String gb = getGb();
		if (gb != null)
			filter.setGroupByClause(gb);
		else 
			filter.setGroupByClause(" usecaseambit, usecase, refentityid1 ");

		filter.or().andSiteEqualTo(aDomain).andUsecaseambitEqualTo(getUsecaseambit()).andUsecaseEqualTo(getUsecase()).andRefentityid1EqualTo(getRefentityid());		
		return filter;
	}

}
