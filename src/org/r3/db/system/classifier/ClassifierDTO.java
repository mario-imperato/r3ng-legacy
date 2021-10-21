//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.classifier;

public class ClassifierDTO extends ClassifierDTOBase
{
    public ClassifierDTO()
    {
        super();
    }

    public ClassifierDTO(ClassifierDTO another)
    {
        super(another);
    }

    @Override
    public String getDtokey()
    {
        StringBuilder stb = new StringBuilder();
        stb.append(site);
        stb.append("_");
        stb.append(clsid);
        return stb.toString();
    }
}
