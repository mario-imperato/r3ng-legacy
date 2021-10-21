//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.siteresource;

public class SiteResourceDTO extends SiteResourceDTOBase
{
	public enum ResourceType {
		actor
	}
	
    public SiteResourceDTO()
    {
        super();
    }

    public SiteResourceDTO(SiteResourceDTO another)
    {
        super(another);
    }

}
