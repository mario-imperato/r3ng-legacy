//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.actor.relactorgroup;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "ActorGroupRelationDTOBase")
public class ActorGroupRelationDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  eventid;
    protected java.lang.String  groupid;
    protected java.lang.String  actorid;

    public static final java.lang.String EVENTID_DEFAULT  =  null;
    public static final java.lang.String GROUPID_DEFAULT  =  null;
    public static final java.lang.String ACTORID_DEFAULT  =  null;

    public static final int EVENTID_DIRTYGROUP  =  0;
    public static final int EVENTID_DIRTYMASK   =  1;
    public static final int GROUPID_DIRTYGROUP  =  0;
    public static final int GROUPID_DIRTYMASK   =  2;
    public static final int ACTORID_DIRTYGROUP  =  0;
    public static final int ACTORID_DIRTYMASK   =  4;


    /**
      * DataBean constructor.
      */
    public ActorGroupRelationDTOBase()
    {
       dirtyFlagsArray = new int[3 / 30 + 1];
       clearDirtyFlags();

       eventid = EVENTID_DEFAULT;
       groupid = GROUPID_DEFAULT;
       actorid = ACTORID_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public ActorGroupRelationDTOBase(ActorGroupRelationDTOBase another)
    {

       eventid = another.getEventid();
       groupid = another.getGroupid();
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
        stb.append(eventid);
        stb.append(", ");
        stb.append(groupid);
        stb.append(", ");
        stb.append(actorid);
        return stb.toString();
    }


    /**
      * DataBean Getter And Setter Accessor
      */

    // eventid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEventidDirty()  { return checkFieldDirtiness(EVENTID_DIRTYGROUP, EVENTID_DIRTYMASK); }

    public java.lang.String   getEventid()         { return eventid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getEventidAsString() { return (eventid == null) ? "" : eventid; }

    // eventid setter methods.
    
    protected void markEventidAsDirty(boolean aFlag)  { markFieldAsDirty(EVENTID_DIRTYGROUP, EVENTID_DIRTYMASK, aFlag); }


    public void setEventid(String  p)
    {
       setEventid(p, DTOCasingStyle.none);
    }
    
    public void setEventid(String  p, DTOCasingStyle casingStyle)
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
       markEventidAsDirty(!equalsObject(eventid, p));
       eventid = p;
    }

    // groupid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isGroupidDirty()  { return checkFieldDirtiness(GROUPID_DIRTYGROUP, GROUPID_DIRTYMASK); }

    public java.lang.String   getGroupid()         { return groupid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getGroupidAsString() { return (groupid == null) ? "" : groupid; }

    // groupid setter methods.
    
    protected void markGroupidAsDirty(boolean aFlag)  { markFieldAsDirty(GROUPID_DIRTYGROUP, GROUPID_DIRTYMASK, aFlag); }


    public void setGroupid(String  p)
    {
       setGroupid(p, DTOCasingStyle.none);
    }
    
    public void setGroupid(String  p, DTOCasingStyle casingStyle)
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
       markGroupidAsDirty(!equalsObject(groupid, p));
       groupid = p;
    }

    // actorid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isActoridDirty()  { return checkFieldDirtiness(ACTORID_DIRTYGROUP, ACTORID_DIRTYMASK); }

    public java.lang.String   getActorid()         { return actorid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
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
