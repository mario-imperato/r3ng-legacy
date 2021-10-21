//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.actor.group;

public class ActorGroupDTO extends ActorGroupDTOBase
{
	public enum GroupNature { system, user };
	public enum GroupProfile { deletable, visible, gmenubar };
	
	public enum SpecialInterestGroup { ACGLOGIN };
	
    public ActorGroupDTO()
    {
        super();
    }

    public ActorGroupDTO(ActorGroupDTO another)
    {
        super(another);
    }

    @Override
    public String getDtokey()
    {
        StringBuilder stb = new StringBuilder();
        stb.append(groupid);
        return stb.toString();
    }
}
