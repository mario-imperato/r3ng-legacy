//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.team;

public class TeamDTO extends TeamDTOBase
{
	public enum TeamStatus { team_empty, team_building, team_verifying, team_reporting, team_validating, team_close };
	
    public TeamDTO()
    {
        super();
    }

    public TeamDTO(TeamDTO another)
    {
        super(another);
    }

    public String getBusinesskey()
    {
        StringBuilder stb = new StringBuilder();       
        stb.append(teamid);
        return stb.toString();
    }
}
