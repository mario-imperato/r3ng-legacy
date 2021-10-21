//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.agenda.agenda;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "AgendaDTOBase")
public class AgendaDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  agendaid;
    protected java.lang.String  actorid;

    public static final java.lang.String AGENDAID_DEFAULT  =  null;
    public static final java.lang.String ACTORID_DEFAULT  =  null;

    public static final int AGENDAID_DIRTYGROUP  =  0;
    public static final int AGENDAID_DIRTYMASK   =  1;
    public static final int ACTORID_DIRTYGROUP  =  0;
    public static final int ACTORID_DIRTYMASK   =  2;


    /**
      * DataBean constructor.
      */
    public AgendaDTOBase()
    {
       dirtyFlagsArray = new int[2 / 30 + 1];
       clearDirtyFlags();

       agendaid = AGENDAID_DEFAULT;
       actorid = ACTORID_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public AgendaDTOBase(AgendaDTOBase another)
    {

       agendaid = another.getAgendaid();
       actorid = another.getActorid();

       dirtyFlagsArray = another.getCopyOfDirtyFlags();
    }

    public void clearDirtyFlags()
    {
       for(int i = 0; i < dirtyFlagsArray.length; i++)
            dirtyFlagsArray[i] = 0;
    }

    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient
    public int[] getCopyOfDirtyFlags()
    {
       int[] copyOf = new int[dirtyFlagsArray.length];
       for(int i = 0; i < dirtyFlagsArray.length; i++)
            copyOf[i] = dirtyFlagsArray[i];

       return copyOf;
    }

    protected void markFieldAsDirty(int mainIndex, int bitwiseIndex, boolean aFlag)
    {
       if (aFlag)
          dirtyFlagsArray[mainIndex] = dirtyFlagsArray[mainIndex] | bitwiseIndex;
       else
          dirtyFlagsArray[mainIndex] = dirtyFlagsArray[mainIndex] & ~bitwiseIndex;
    }

    protected boolean checkFieldDirtiness(int mainIndex, int bitwiseIndex)
    {
       return (dirtyFlagsArray[mainIndex] & bitwiseIndex) != 0;
    }

    public String getDtokey()
    {
        StringBuilder stb = new StringBuilder();
        stb.append(agendaid);
        return stb.toString();
    }


    /**
      * DataBean Getter And Setter Accessor
      */

    // agendaid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isAgendaidDirty()  { return checkFieldDirtiness(AGENDAID_DIRTYGROUP, AGENDAID_DIRTYMASK); }

    public java.lang.String   getAgendaid()         { return agendaid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "agendaid")
    public java.lang.String   getAgendaidAsString() { return (agendaid == null) ? "" : agendaid; }

    // agendaid setter methods.
    
    protected void markAgendaidAsDirty(boolean aFlag)  { markFieldAsDirty(AGENDAID_DIRTYGROUP, AGENDAID_DIRTYMASK, aFlag); }


    public void setAgendaid(String  p)
    {
       setAgendaid(p, DTOCasingStyle.none);
    }
    
    public void setAgendaid(String  p, DTOCasingStyle casingStyle)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
    	 	else switch(casingStyle) 
    	 	{
    	 	   case none: 
    	 	   break;
    	 	   case uppercase:
    	 	      p = p.toUpperCase();
    	 	   break;
    	 	   case lowercase:
    	 	      p = p.toLowerCase();
    	 	   break;
    	 	}

       }
       markAgendaidAsDirty(!equalsObject(agendaid, p));
       agendaid = p;
    }

    // actorid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isActoridDirty()  { return checkFieldDirtiness(ACTORID_DIRTYGROUP, ACTORID_DIRTYMASK); }

    public java.lang.String   getActorid()         { return actorid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "actorid")
    public java.lang.String   getActoridAsString() { return (actorid == null) ? "" : actorid; }

    // actorid setter methods.
    
    protected void markActoridAsDirty(boolean aFlag)  { markFieldAsDirty(ACTORID_DIRTYGROUP, ACTORID_DIRTYMASK, aFlag); }


    public void setActorid(String  p)
    {
       setActorid(p, DTOCasingStyle.none);
    }
    
    public void setActorid(String  p, DTOCasingStyle casingStyle)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
    	 	else switch(casingStyle) 
    	 	{
    	 	   case none: 
    	 	   break;
    	 	   case uppercase:
    	 	      p = p.toUpperCase();
    	 	   break;
    	 	   case lowercase:
    	 	      p = p.toLowerCase();
    	 	   break;
    	 	}

       }
       markActoridAsDirty(!equalsObject(actorid, p));
       actorid = p;
    }

}
