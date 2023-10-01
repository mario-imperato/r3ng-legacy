package org.r3.db.system.lut;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.attachmenttype.AttachmentTypeLUT;
import org.r3.db.cms.pageview.PageViewLUT;
import org.r3.db.sailevent.event.SailEventLUT;
import org.r3.db.system.calendar.SystemCalendarLUT;
import org.r3.db.system.calendarperiod.SystemCalendarPeriodMonthlyLUT;
import org.r3.db.system.calendarperiod.SystemCalendarPeriodQuarterlyLUT;
import org.r3.db.system.calendarperiod.SystemCalendarPeriodWeeklyLUT;
import org.r3.db.system.calendarperiod.SystemCalendarPeriodYearlyLUT;
import org.r3.db.system.classifieritem.ClassifierItemLUT;
import org.r3.db.system.metadata.tmetadataview.TableColumnsMetadataLUT;
import org.r3.db.system.site.SiteLUT;
import org.r3.db.system.sitecmspropertyview.SiteCMSPropertyLUT;
import org.r3.db.system.siteportletcfg.SitePortletConfigLUT;
import org.r3.db.system.siteproperty.SitePropertyLUT;
import org.r3.db.system.user.userprofileview.UserProfileViewLUT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LUTManager
{
	private static Logger logger = LoggerFactory.getLogger(LUTManager.class);
	private static LUTManager lutManager;
	
	public static LUTManager getLUTManager()
	{
	     return lutManager;	
	}
	
	public static void initializeLUTManager()
	{
	     LUTManager aLutM = new LUTManager();
	     lutManager = aLutM;
	}
	
	public enum LUTName 
	{
		userprofile, authrole, site, sailevent, siteproperty, siteportletconfig,
		sys_recstatus, locale, cms_attachtype, country, unitofmeasure, currency,
		
		r3ea_completion, r3ea_verificat, r3ea_sailmat, r3ea_crociera, r3ea_boatgroup, r3ea_boatgroup2, r3ea_apptype, r3ea_ratings, r3ea_crewrole, r3ea_authoriz,
		r3ea_doctype, r3ea_ranktype, r3ea_mooringloc, r3ea_admincks, r3ea_racegroups, fivcardstatus, r3ea_calendar, r3ea_orcgranc, r3ea_boatelse,
		
		cms_category, cms_group, cms_page, cms_channel, portlets,
		
		m_contentclass, timeline,
		
		actor_expformat, uicfgmenus, uicfgmenusi,
		classifiers, r3ea_sinott, sitecmsproperties, calendar, calendar_period,
		calendar_monthly, calendar_weekly, calendar_quarterly, calendar_yearly,
		
		skillprofile, skillambit, ita,
		table_metadata
	};
	
	public enum LUTLanguage { it, en, pt };
	
    private HashMap<String, LUT> lutMap;
    
    public LUTManager()
    {
        init();	
    }
    
    /*
     * LUTNames non immessi nella Map.
     * tasks_esiti, kit_posetich, jobstatus, jobschedtype, jobschddmode, jobgroup, jobexecstatus, ita, dsp_status
     */
    private void init()
    {
    	lutMap = new HashMap<String, LUT>();    	
    	
    	lutMap.put(LUTName.calendar.toString(), new SystemCalendarLUT(LUT.DEFAULT_VALIDITY_1DAY));

    	lutMap.put(LUTName.calendar_monthly.toString(), new SystemCalendarPeriodMonthlyLUT());
    	lutMap.put(LUTName.calendar_weekly.toString(), new SystemCalendarPeriodWeeklyLUT());
    	lutMap.put(LUTName.calendar_quarterly.toString(), new SystemCalendarPeriodQuarterlyLUT());
    	lutMap.put(LUTName.calendar_yearly.toString(), new SystemCalendarPeriodYearlyLUT());
    	
    	lutMap.put(LUTName.site.toString(), new SiteLUT());
    	lutMap.put(LUTName.userprofile.toString(), new UserProfileViewLUT());
    	lutMap.put(LUTName.sailevent.toString(), new SailEventLUT());	
    	lutMap.put(LUTName.siteproperty.toString(), new SitePropertyLUT());
    	lutMap.put(LUTName.cms_attachtype.toString(), new AttachmentTypeLUT(LUTName.cms_attachtype.toString()));
    	lutMap.put(LUTName.siteportletconfig.toString(), new SitePortletConfigLUT());    	
    	lutMap.put(LUTName.sitecmsproperties.toString(), new SiteCMSPropertyLUT());
    	lutMap.put(LUTName.actor_expformat.toString(), new ClassifierItemLUT(LUTName.actor_expformat.toString()));
    	
    	lutMap.put(getLutName4Language(LUTName.cms_page,"pt"), new PageViewLUT("pt"));    	
    	lutMap.put(LUTName.cms_page.toString(), new PageViewLUT("it"));    	
    	lutMap.put(LUTName.table_metadata.toString(), new TableColumnsMetadataLUT());
    }
    
    private static String getLutName4Language(LUTName alutName, String forLanguage)
    {
        String s = null;
        if (forLanguage != null)
        {
        	 s = new StringBuilder().append(alutName.toString()).append('$').append(forLanguage).toString();
        }
        else s = alutName.toString();
        
        return s;
    }
        
    public LUT getLUT(LUTName alutName, String forLanguage)
    {
    	LUT foundLut = null;
    	if (forLanguage != null)
    	{
    	    foundLut = lutMap.get(getLutName4Language(alutName, forLanguage));
    	}
    	
    	if (foundLut == null)
    	  foundLut = lutMap.get(alutName.toString());
    	
    	return foundLut;
    }

    public void setExpired(LUTName alutName)
    {
    	LUT theLut = lutMap.get(alutName.toString()); 
    	setExpired(theLut);
		
		// Cerco eventuali LUT sui casi disponibili.
    	for(LUTLanguage l : LUTLanguage.values())
    	{
    		theLut = lutMap.get(getLutName4Language(alutName, l.toString()));
    		setExpired(theLut);
    	}
    }

    private void setExpired(LUT theLut)
    {
    	if (theLut != null)
    	{
			theLut.setExpired();
    	}
    }
    
    private void reload(LUT theLut, java.sql.Timestamp reloadTimestamp)
    {
    	if (theLut != null && !theLut.hasBeenLoadedSince(reloadTimestamp))
    	{
			try
			{
				logger.info("Reloading LUT: " + theLut);
				theLut.reload();
			}
			catch (LUTException e)
			{
				e.printStackTrace();
			}
    	}    		
    }
    
    public void reload(LUTName alutName, java.sql.Timestamp reloadTimestamp)
    {
    	LUT theLut = lutMap.get(alutName.toString()); 
    	reload(theLut, reloadTimestamp);
		
		// Cerco eventuali LUT sui casi disponibili.
    	for(LUTLanguage l : LUTLanguage.values())
    	{
    		theLut = lutMap.get(getLutName4Language(alutName, l.toString()));
        	reload(theLut, reloadTimestamp);
    	}    	
    }
    
    public void invalidateLUT(String alutName)
    {
        LUTName l = LUTName.valueOf(alutName);
        invalidateLUT(l);
    }
    
	public void invalidateLUT(LUTName alutName)
	{
		PersistenceContext pcfg = PersistenceContext.getPersistenceContext();
		SqlSession session = pcfg.openSession();

		try
		{
			LUTDictionaryPersistence p = LUTDictionaryPersistence.createPersistenceObject(pcfg, session);
			int numberOfRowsAffected = p.invalidateLUT(alutName.toString(), pcfg.getPersistenceConfigInfo());		
			setExpired(alutName);
	    	
	    	session.commit();
		}
		finally
		{
			session.close();
		}
	}


	public void reload(PersistenceContext pcfg, SqlSession aSession)
	{
		LUTDictionaryPersistence lutDictionary = LUTDictionaryPersistence.createPersistenceObject(pcfg, aSession);
		LUTDictionaryFilter lutFilter = new LUTDictionaryFilter();
		List<LUTDictionaryDTO> listOfLutItems = lutDictionary.select(lutFilter, pcfg.getPersistenceConfigInfo());
		
		if (listOfLutItems != null && listOfLutItems.size() > 0)
		{
		    for(LUTDictionaryDTO dto : listOfLutItems)
		    {
		    	try
		    	{
		    		if (lutMap.get(dto.getLutid()) != null)
		    		{
		    			LUTName theLutName = LUTName.valueOf(dto.getLutid());		    		
			    		reload(theLutName, dto.getRectimestamp());		    			
		    		}
		    	}
		    	catch(Exception e)
		    	{
		    		e.printStackTrace();
		    	}		    	
		    }
		    
		    aSession.commit();
		}				
	}
	
	public void invalidate(PersistenceContext pcfg, SqlSession aSession)
	{
		LUTDictionaryPersistence lutDictionary = LUTDictionaryPersistence.createPersistenceObject(pcfg, aSession);
		LUTDictionaryFilter lutFilter = new LUTDictionaryFilter();
		int numberOfRowsAffected = lutDictionary.invalidate(lutFilter, pcfg.getPersistenceConfigInfo());

		List<LUTDictionaryDTO> listOfLutItems = lutDictionary.select(lutFilter,
				pcfg.getPersistenceConfigInfo());

		if (listOfLutItems != null && listOfLutItems.size() > 0)
		{
			for (LUTDictionaryDTO dto : listOfLutItems)
			{
				if (lutMap.get(dto.getLutid()) != null)
				{
					try
					{
						LUTName theLutName = LUTName.valueOf(dto.getLutid());
						setExpired(theLutName);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			}

			aSession.commit();
		}
	}
	
//    public void setInContext(ServletContext ctx)
//    {
//        ctx.setAttribute("__LUTMANAGER_", this);
//    }
//
//    // Convenience method to access a LUTSet in the servlet context.
//    public static LUTManager getLUTManager(ServletContext ctx)
//    {
//        Object o = ctx.getAttribute("__LUTMANAGER_");
//        if (o == null)
//        {
//            System.err.println("Could not find velocityPlugInModel Object");
//        }
//        else
//        {
//            if (o instanceof LUTManager)
//                return (LUTManager) o;
//            else
//            {
//           	 System.err.println("Object is not an instance of LUTManager");
//            }
//        }
//
//        return null;
//    }

}
