//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.user.usersession;

import org.r3.db.system.user.user.UserDTO;
import org.r3.db.system.user.user.UserDTO.UserConsent;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.system.util.Codecs;

public class UserSessionDTO extends UserSessionDTOBase
{
    public UserSessionDTO()
    {
        super();
    }

    public UserSessionDTO(UserSessionDTO another)
    {
        super(another);
    }

    public UserSessionDTO(UserDTO aUser)
    {
    	java.util.Date d = new java.util.Date();
    	
    	StringBuilder stb = new StringBuilder();
    	stb.append(d.getTime()).append(aUser.getUserid());
		setSessionid(Codecs.digestAsString(stb.toString()));
		setUserid(aUser.getUserid());
		if (aUser.hasConsentBeenProvided())
			  setConsentmode(UserConsent.provided.toString());
		else  setConsentmode(UserConsent.nonblocking.toString());
    }

    public UserSessionDTO(UserProfileViewDTO aUser)
    {
    	java.util.Date d = new java.util.Date();
    	
    	StringBuilder stb = new StringBuilder();
    	stb.append(d.getTime()).append(aUser.getUserid());
		setSessionid(Codecs.digestAsString(stb.toString()));
		setUserid(aUser.getUserid());
		if (aUser.hasConsentBeenProvided())
			  setConsentmode(UserConsent.provided.toString());
		else  setConsentmode(UserConsent.nonblocking.toString());
    }
    
	public boolean hasConsentBeenProvidedOrNotRequired() 
	{		
		boolean rc = false;
		
		switch(UserConsent.getValue4(consentmode, UserConsent.none))
		{
		case none:
			rc = true;
			break;
			
		case nonblocking:
		case required:
			break;
			
		case provided:
			rc = true;
			break;			
		}
		
		return rc;
	}
}
