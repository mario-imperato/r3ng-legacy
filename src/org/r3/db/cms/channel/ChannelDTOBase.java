//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.channel;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "ChannelDTOBase")
public class ChannelDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  channelid;
    protected java.lang.String  channelname;

    public static final java.lang.String CHANNELID_DEFAULT  =  null;
    public static final java.lang.String CHANNELNAME_DEFAULT  =  null;

    public static final int CHANNELID_DIRTYGROUP  =  0;
    public static final int CHANNELID_DIRTYMASK   =  1;
    public static final int CHANNELNAME_DIRTYGROUP  =  0;
    public static final int CHANNELNAME_DIRTYMASK   =  2;


    /**
      * DataBean constructor.
      */
    public ChannelDTOBase()
    {
       dirtyFlagsArray = new int[2 / 30 + 1];
       clearDirtyFlags();

       channelid = CHANNELID_DEFAULT;
       channelname = CHANNELNAME_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public ChannelDTOBase(ChannelDTOBase another)
    {

       channelid = another.getChannelid();
       channelname = another.getChannelname();

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
        stb.append(channelid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (channelname != null)
        {
        stb.append(channelname);
        notNull = true;        
        }
        if (notNull)
            return stb.toString();
            
        return null;
    }

    /**
      * DataBean Getter And Setter Accessor
      */

    // channelid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isChannelidDirty()  { return checkFieldDirtiness(CHANNELID_DIRTYGROUP, CHANNELID_DIRTYMASK); }

    public java.lang.String   getChannelid()         { return channelid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "channelid")
    public java.lang.String   getChannelidAsString() { return (channelid == null) ? "" : channelid; }

    // channelid setter methods.
    
    protected void markChannelidAsDirty(boolean aFlag)  { markFieldAsDirty(CHANNELID_DIRTYGROUP, CHANNELID_DIRTYMASK, aFlag); }


    public void setChannelid(String  p)
    {
       setChannelid(p, DTOCasingStyle.none);
    }
    
    public void setChannelid(String  p, DTOCasingStyle casingStyle)
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
       markChannelidAsDirty(!equalsObject(channelid, p));
       channelid = p;
    }

    // channelname getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isChannelnameDirty()  { return checkFieldDirtiness(CHANNELNAME_DIRTYGROUP, CHANNELNAME_DIRTYMASK); }

    public java.lang.String   getChannelname()         { return channelname; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "channelname")
    public java.lang.String   getChannelnameAsString() { return (channelname == null) ? "" : channelname; }

    // channelname setter methods.
    
    protected void markChannelnameAsDirty(boolean aFlag)  { markFieldAsDirty(CHANNELNAME_DIRTYGROUP, CHANNELNAME_DIRTYMASK, aFlag); }


    public void setChannelname(String  p)
    {
       setChannelname(p, DTOCasingStyle.none);
    }
    
    public void setChannelname(String  p, DTOCasingStyle casingStyle)
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
       markChannelnameAsDirty(!equalsObject(channelname, p));
       channelname = p;
    }

}
