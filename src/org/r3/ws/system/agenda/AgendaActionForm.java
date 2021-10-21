package org.r3.ws.system.agenda;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.agenda.agendaentry.AgendaEntryDTO;
import org.r3.system.rest.SecurityTokenActionForm;
import org.r3.ws.system.agenda.WsAgenda.CalendarUpdateAction;

public class AgendaActionForm extends SecurityTokenActionForm
{

	@FormParam("title")
    private String title;

    public String getTitle()
    {    	
    	return DTOBase.nullOnEmpty(title);
    }

	@FormParam("allday")
    private String allday;

    public String getAllday()
    {    	
    	return DTOBase.nullOnEmpty(allday);
    }

    public boolean getAlldayAsBoolean()
    {    	
    	return DTOBase.getBTrueFalseAsBoolean(allday);
    }
    
    @FormParam("startdate_date")
    private String startdate_date;

    public String getStartdate_date()
    {    	
    	return DTOBase.nullOnEmpty(startdate_date);
    }
    
    @FormParam("startdate_time")
    private String startdate_time;

    public String getStartdate_time()
    {   
    	if (getAlldayAsBoolean())
    		return null;
    	
    	return DTOBase.nullOnEmpty(startdate_time);
    }

    @FormParam("enddate_date")
    private String enddate_date;

    public String getEnddate_date()
    {    	
    	String s = DTOBase.nullOnEmpty(enddate_date);
    	if (s != null)
    		return s;
    	
    	return getStartdate_date();
    }
    
    @FormParam("enddate_time")
    private String enddate_time;

    public String getEnddate_time()
    {    	
    	if (getAlldayAsBoolean())
    		return null;
    	
    	return DTOBase.nullOnEmpty(enddate_time);
    }

	private java.sql.Date getStartdateAsDate()
	{		
		return DTOBase.stringAsDate(getStartdate_date(), DTOBase.printDateFormat);						
	}

	private java.sql.Date getEnddateAsDate()
	{
		return DTOBase.stringAsDate(getEnddate_date(), DTOBase.printDateFormat);
	}

	public AgendaEntryDTO getDTO4Insert(String aSite, String anAgendaId)
	{
		AgendaEntryDTO dto = new AgendaEntryDTO();

		dto.setAgendaid(anAgendaId);
		dto.setEntrydescr(getTitle());
		dto.setStartdate(getStartdateAsDate());
		dto.setStarttime(getStartdate_time());
		dto.setAlldayflag(getAllday());
		dto.setEnddate(getEnddateAsDate());
		dto.setEndtime(getEnddate_time());		
		
		return  dto;
	}

	public AgendaEntryDTO getDTO4Update(String aSite, String anAgendaId, String anAgendaEntryId, CalendarUpdateAction updateAction)
	{
		AgendaEntryDTO dto = new AgendaEntryDTO();

		dto.setAgendaid(anAgendaId);	
		dto.setAgendaentryid(anAgendaEntryId);
		
		
		switch(updateAction)
		{
		case update:
			dto.setEntrydescr(getTitle());
			dto.setAlldayflag(getAllday());
			dto.setStartdate(getStartdateAsDate());
			dto.setStarttime(getStartdate_time());
			
			dto.setEnddate(getEnddateAsDate());
			dto.setEndtime(getEnddate_time());		
            break;
            
		case move:
			// Il move debbo verificare lo spostamento in modalità allday..
			dto.setStartdate(getStartdateAsDate());
			dto.setStarttime(getStartdate_time());
			
			dto.setEnddate(getEnddateAsDate());
			dto.setEndtime(getEnddate_time());		
			break;
			
		case resize:
			dto.setStartdate(getStartdateAsDate());
			dto.setStarttime(getStartdate_time());
			
			dto.setEnddate(getEnddateAsDate());
			dto.setEndtime(getEnddate_time());		
		}
		
		return  dto;
	}

//	public FullCalendarWidgetDTO getDTO4Insert4FullCalendarWidget(
//			String aSite, String anAgendaId)
//	{
//		FullCalendarWidgetDTO dto = new FullCalendarWidgetDTO();
//		dto.setSite(aSite);
//		dto.setAgendaid(anAgendaId);
//		dto.setTitle(getTitle());
//		dto.setStartdate(getStartdateAsDate());
//		dto.setStarttime(getStartdate_time());
//		
//		dto.setEnddate(getEnddateAsDate());
//		dto.setEndtime(getEnddate_time());		
//		
//		return  dto;
//
//	}
//
//	public FullCalendarWidgetDTO getDTO4Update4FullCalendarWidget(
//			String aSite,  String anAgendaId, String aCalendarId,
//			CalendarUpdateAction updateAction)
//	{
//		FullCalendarWidgetDTO dto = new FullCalendarWidgetDTO();
//		dto.setSite(aSite);
//		dto.setAgendaid(anAgendaId);	
//		dto.setId(aCalendarId);
//		
//		switch(updateAction)
//		{
//		case update:
//			dto.setTitle(getTitle());
//			dto.setStartdate(getStartdateAsDate());
//			dto.setStarttime(getStartdate_time());
//			
//			dto.setEnddate(getEnddateAsDate());
//			dto.setEndtime(getEnddate_time());		
//            break;
//            
//		case move:
//			dto.setStartdate(getStartdateAsDate());
//			dto.setStarttime(getStartdate_time());
//			
//			dto.setEnddate(getEnddateAsDate());
//			dto.setEndtime(getEnddate_time());		
//			break;
//			
//		case resize:
//			dto.setStartdate(getStartdateAsDate());
//			dto.setStarttime(getStartdate_time());
//			
//			dto.setEnddate(getEnddateAsDate());
//			dto.setEndtime(getEnddate_time());		
//		}
//		
//		return  dto;
//	}

	
}
