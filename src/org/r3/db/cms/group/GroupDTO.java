//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.group;

public class GroupDTO extends GroupDTOBase
{
    public GroupDTO()
    {
        super();
    }

    public GroupDTO(GroupDTO another)
    {
        super(another);
    }

    @Override
    public String getDtokey()
    {
        return groupid;
    }
}
