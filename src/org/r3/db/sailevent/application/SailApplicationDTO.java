//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.application;

import org.r3.db.DTOBase;
import org.r3.db.actor.actor.ActorDTO;
import org.r3.db.sailevent.appdata.SailApplicationDataDataTableAdapter;

public class SailApplicationDTO extends SailApplicationDTOBase
{
	public enum CompletionStatus { r3ea_empty, r3ea_draft, r3ea_commit };
	public enum VerificationStatus { r3ea_unknown, r3ea_notcompl, r3ea_error, r3ea_accepted, r3ea_paympend, r3ea_suspend };
	
	public enum ApplicationSection { 
		r3ea_boatinfo, r3ea_classinfo, r3ea_ownerinfo, r3ea_crewinfo, r3ea_docinfo, r3ea_authorinfo, r3ea_payinfo, r3ea_summaryinfo, 
		r3ea_adminchecks, r3ea_adminraceinfo, r3ea_attsheet
	}
	
	public enum DocumentType { r3ea_dtircstd, r3ea_dtorcintl, r3ea_dtircclub, r3ea_dtorcclub, r3ea_dtinsur, r3ea_dtadv, r3ea_dtboatimg, r3ea_doc, r3ea_dtreqprovrate, r3ea_dtcovidowner, r3ea_dtcovidcrew };
	
    public SailApplicationDTO()
    {
        super();
    }

    public SailApplicationDTO(SailApplicationDTO another)
    {
        super(another);
    }

    public static CompletionStatus getCompletionstatusAsEnum(String s)
    {
    	if (s != null)
    		return CompletionStatus.valueOf(s);
    	
    	return null;
    }
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public CompletionStatus getCompletionstatusAsEnum()
    {
    	return getCompletionstatusAsEnum(getCompletionstatus());
    }

    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isApplicationEmpty()
    {
    	CompletionStatus c = getCompletionstatusAsEnum();
    	return c != null && c == CompletionStatus.r3ea_empty;
    }

    private String nickname;
    
	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public void clearBoatimagefields()
	{
		setBoatimageid(null);
		
	    setBoatimageurl(null);
        setBoatimageheight(0);
        setBoatimagewidth(0);

	    setBoaticonurl(null);
        setBoaticonheight(0);
        setBoaticonwidth(0);
	}
	
	private ActorDTO owner;

	public ActorDTO getOwner()
	{
		return owner;
	}

	public void setOwner(ActorDTO owner)
	{
		this.owner = owner;
	}

	private ActorDTO helmsman;

	public ActorDTO getHelmsman()
	{
		return helmsman;
	}

	public void setHelmsman(ActorDTO anHelmsman)
	{
		this.helmsman = anHelmsman;
	}
	
	private SailApplicationDataDataTableAdapter properties;
	
	public void setProperties(SailApplicationDataDataTableAdapter listOfProperties)
	{
		properties = listOfProperties;
	}

	public SailApplicationDataDataTableAdapter getProperties()
	{
		return properties;
	}

	public void setCompleted()
	{
		setCommittimestamp(DTOBase.currentTimestamp());
		setCompletionstatus(CompletionStatus.r3ea_commit.toString());		
	}

}
