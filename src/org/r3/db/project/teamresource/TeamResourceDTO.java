//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.teamresource;

public class TeamResourceDTO extends TeamResourceDTOBase
{
	public enum ResourceStatus { complete, incomplete };
	
    public TeamResourceDTO()
    {
        super();
    }

    public TeamResourceDTO(TeamResourceDTO another)
    {
        super(another);
    }

}
