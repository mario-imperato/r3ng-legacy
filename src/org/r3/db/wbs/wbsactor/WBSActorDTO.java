//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.wbs.wbsactor;

public class WBSActorDTO extends WBSActorDTOBase
{
	public enum WBSActorRole { 
		user, manager, sponsor, coach
	}
	
    public WBSActorDTO()
    {
        super();
    }

    public WBSActorDTO(WBSActorDTO another)
    {
        super(another);
    }

}
