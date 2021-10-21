//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.project.resourcetimesheetview;

public class ResourceTimesheetViewPersistence extends ResourceTimesheetViewPersistenceBase
{
	public enum ReportType 
	{ 
		base, periodindex_profileid;
		
	    public static String getGropuByClauseByReportType(String aReportType)
	    {
	    	return getGropuByClauseByReportType(valueOfWithDefault(aReportType, ReportType.base));
	    }
	    
	    public static String getGropuByClauseByReportType(ReportType aReportType)
	    {
	    	String gc = null;
	    	
	    	switch(aReportType) 
	    	{
	    	case base:
	    		break; 
	    		
	    	case periodindex_profileid:
	    		gc = "teamid, profileid";
	    		break;
	    	}
	    	
	        return gc;
	    }	    
	    
		public static ReportType valueOfWithDefault(String s, ReportType aDefaultValue)
		{
			if (s != null)
			{
				try
				{
					return valueOf(s);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}

			return aDefaultValue;
		}
	    
	};
	
	public static ResourceTimesheetViewPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg,
			org.apache.ibatis.session.SqlSession aSession)
	{
		ResourceTimesheetViewPersistence p = new ResourceTimesheetViewPersistence();
		p.setMapper(aSession.getMapper(ResourceTimesheetViewMapper.class));
		return p;
	}	  

}
