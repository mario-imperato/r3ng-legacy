//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.bbs.bbsthreadnode;

public class BBSThreadNodeDTO extends BBSThreadNodeDTOBase
{	
    public BBSThreadNodeDTO()
    {
        super();
    }

    public BBSThreadNodeDTO(BBSThreadNodeDTO another)
    {
        super(another);
    }

    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient    
    public int getNodeDepth()
    {
        if (nodepath == null)
        	return -1;
        
        // Tolgo il punto iniziale e considero l'id da 15 e il punto finale.
        return (nodepath.length() - 1) / 16;
    }
        
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient    
    public boolean isRoot()
    {
    	return nodeparentid == null;
    } 

    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient    
    public String getChildrenNodepathPrefix()
    {
    	StringBuilder np = new StringBuilder();
    	np.append(getNodepath()).append(threadnodeid).append('.');

    	return np.toString();
    } 


}
