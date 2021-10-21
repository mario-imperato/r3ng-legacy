//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.user.user;

import org.r3.db.actor.actor.ActorDTO;
import org.r3.system.util.Codecs;

public class UserDTO extends UserDTOBase
{
	public enum UserType { root, user, guest, avatar };

	public enum UserConsent { 
		
		none, nonblocking, required, provided;
		
		public static UserConsent getValue4(String s, UserConsent aDefaultValue)
		{
			if (s != null && s.length() > 0)
				return valueOf(s);
			
			return aDefaultValue;
		}
	}
	
    public UserDTO()
    {
        super();
    }

    public UserDTO(UserDTO another)
    {
        super(another);
    }
    
    public boolean matchesPassword(String aClearPassword)
    {
    	boolean rc = false;
    	
    	String encodedPasswd = Codecs.digestAsString(aClearPassword);
    	if (getPassword() != null && getPassword().equalsIgnoreCase(encodedPasswd))
    		 rc = true;
    	
    	return rc;
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

	public boolean isBlocked()
	{
		if (recstatus != null && RecordStatus.valueOf(recstatus) == RecordStatus.sys_recblock)
			return true;
        
		return false;
	}

	// Il campo actorId contiene eventualmente l'attore che corrisponde allo userid.
    private String actorid;

	public String getActorid()
	{
		return actorid;
	}

	public void setActorid(String actorid)
	{
		this.actorid = actorid;
	}
    
	public ActorDTO getActorDTO4CurrentUser(String aSite)
	{
		ActorDTO dto = new ActorDTO();
		dto.setEventid(aSite);
		
		// Il metodo e' usato in insert e quindi non assegno l'id utente.
		// dto.setActorid(getUserid());
		dto.setUserid(getUserid());
		dto.setFirstname(getFirstname());
		dto.setLastname(getLastname());
		dto.setEmail(getEmail());
		dto.setRecstatus(RecordStatus.sys_recact.toString());
		
		return  dto;
	}
	
	@Override
	public String getDtodescr()
	{
		boolean notNull = false;
		StringBuilder stb = new StringBuilder();
		if (this.firstname != null)
		{
			stb.append(firstname);
			notNull = true;
		}

		if (this.lastname != null)
		{
			if (notNull)
				stb.append(" ");

			stb.append(lastname);
			notNull = true;
		}

		if (notNull)
			return stb.toString();

		return null;
	}
	
	public boolean hasConsentBeenProvided() 
	{		
		if (UserConsent.getValue4(userconsent, UserConsent.none) == UserConsent.provided)
			return true;
		
		return false;
	}
}
