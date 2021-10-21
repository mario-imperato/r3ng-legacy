//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.siteportletcfg;


public class SitePortletConfigDTO extends SitePortletConfigDTOBase
{
	public enum PortletOnUserStatusActivation
	{
		userlogged, usernotlogged, always;
		
		public static PortletOnUserStatusActivation getValue4(String s, PortletOnUserStatusActivation defaultValue)
		{
			if (s != null && s.length() > 0)
				return PortletOnUserStatusActivation.valueOf(s);
			
			return defaultValue;
		}
	}
	
	public static SitePortletConfigDTO NullPortlet = new SitePortletConfigDTO();
	
    public SitePortletConfigDTO()
    {
        super();
    }

    public SitePortletConfigDTO(SitePortletConfigDTO another)
    {
        super(another);
    }

    public String getHTML4Position(String positionId, boolean isUserLogged)
	{
       	StringBuilder stb = new StringBuilder();
    	
    	PortletOnUserStatusActivation oua = PortletOnUserStatusActivation.getValue4(getDataonuserstatus(), PortletOnUserStatusActivation.always);
    	if (oua == PortletOnUserStatusActivation.always || 
    		 (oua == PortletOnUserStatusActivation.userlogged && isUserLogged) || 
    		 (oua == PortletOnUserStatusActivation.usernotlogged && !isUserLogged))
    	{	

   		if (getJsclassname() != null)
    	    stb.append(" class='").append(getJsclassname()).append("' ");
    	
    	if (getDatacardid() != null)
    		stb.append(" data-cardid='").append(getDatacardid()).append("' ");

    	if (getDataoptions() != null)
    		stb.append(" data-options='").append(getDataoptions()).append("' ");
    	
    	}
    	
    	return stb.toString();	    
	}
}
