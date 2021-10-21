//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.user.userprofileview;

import java.util.ArrayList;
import java.util.List;

import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.site.SiteDTO;
import org.r3.db.system.site.SiteLUT;
import org.r3.db.system.user.user.UserDTO.UserConsent;
import org.r3.db.system.user.user.UserDTO.UserType;
import org.r3.system.AuthFunction;

public class UserProfileViewDTO extends UserProfileViewDTOBase
{
    public UserProfileViewDTO()
    {
        super();
    }

    public UserProfileViewDTO(UserProfileViewDTO another)
    {
        super(another);
        sitePermissions = another.sitePermissions;
    }

    private List<SitePermissionDTO>     sitePermissions;
    
    public List<SitePermissionDTO> getSitePermissions()
	{
		return sitePermissions;
	}

	public void setSitePermissions(List<SitePermissionDTO> roles)
	{
		this.sitePermissions = roles;
	}

    public UserType getUsertypeEnum()
    {    	
    	return getUsertypeEnum(getUsertype());
    }
    
    public static UserType getUsertypeEnum(String aUserType)
    {
    	if (aUserType != null)
    		return UserType.valueOf(aUserType);
    	
    	return null;
    }
 
	public boolean isInRole(String aSite, AuthFunction f)
	{
		if (f.isPublic())
		{
		    return true;	
		}
		
        if (sitePermissions == null || sitePermissions.size() == 0)
        	return false;
        
        for(SitePermissionDTO sp : sitePermissions)
        {
            if (sp.getSite().equalsIgnoreCase(aSite))
            	return sp.isInRole(f);
        }
                
		return false;
	}

	public boolean hasRole(String aSite, String r)
	{
        if (sitePermissions == null || sitePermissions.size() == 0)
        	return false;
        
        for(SitePermissionDTO sp : sitePermissions)
        {
            if (sp.getSite().equalsIgnoreCase(aSite))
            	return sp.hasRole(r);
        }
        
        return false;
	}

	public List<SiteDTO> findSitesWithRole(String csvRoles, String csvSiteTypeFilter)
	{
		List<SiteDTO> sites = null;
		
        if (sitePermissions == null || sitePermissions.size() == 0)
        	return sites;
        
        String[] listOfRoles = csvRoles.split(",");
        
        SiteLUT siteLUT = (SiteLUT)(LUTManager.getLUTManager().getLUT(LUTName.site, null));        
        for(SitePermissionDTO sp : sitePermissions)
        {
        	if (sp.hasRoles(listOfRoles))
        	{        		
        		SiteDTO theSite = siteLUT.getItem(sp.getSite());
        		if (theSite != null)
        		{
        		if (sites == null)
        		{
        			sites = new ArrayList<SiteDTO>();
        		}
        		sites.add(theSite);
        		}        		        		
        	}        	
        }
        
    	return sites;
	}
	
	public boolean isGuest()
	{
		if (this.usertype != null && !this.usertype.equalsIgnoreCase("guest"))
			return false;
		
		return true;
	}

	public boolean hasConsentBeenProvided() 
	{		
		if (UserConsent.getValue4(userconsent, UserConsent.none) == UserConsent.provided)
			return true;
		
		return false;
	}

}
