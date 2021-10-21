//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.actor.actor;

import org.r3.db.DTOBase;
import org.r3.db.actor.group.ActorGroupDataTableAdapter;


public class ActorDTO extends ActorDTOBase
{
    public ActorDTO()
    {
        super();
    }

    public ActorDTO(ActorDTO another)
    {
        super(another);
    }

    private ActorGroupDataTableAdapter groups;

	public ActorGroupDataTableAdapter getGroups()
	{
		return groups;
	}

	public void setGroups(ActorGroupDataTableAdapter groups)
	{
		this.groups = groups;
	}

	
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient	
	public boolean isEmailPresent()
	{
        String s = DTOBase.nullOnEmpty(getEmail());
		return s != null;
	}
    
	public String getBusinesskey()
	{
		return getActorid();
	}
}
