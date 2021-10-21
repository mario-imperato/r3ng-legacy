//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.resource;

public class ResourceDTO extends ResourceDTOBase
{
	public enum ResourceType {
		hr
	}
	
    public ResourceDTO()
    {
        super();
    }

    public ResourceDTO(ResourceDTO another)
    {
        super(another);
    }

}
