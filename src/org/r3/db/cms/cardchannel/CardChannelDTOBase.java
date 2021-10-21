//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardchannel;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "CardChannelDTOBase")
public class CardChannelDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  channelid;
    protected java.lang.String  site;
    protected java.lang.String  cardid;

    public static final java.lang.String CHANNELID_DEFAULT  =  null;
    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String CARDID_DEFAULT  =  null;

    public static final int CHANNELID_DIRTYGROUP  =  0;
    public static final int CHANNELID_DIRTYMASK   =  1;
    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  2;
    public static final int CARDID_DIRTYGROUP  =  0;
    public static final int CARDID_DIRTYMASK   =  4;


    /**
      * DataBean constructor.
      */
    public CardChannelDTOBase()
    {
       dirtyFlagsArray = new int[3 / 30 + 1];
       clearDirtyFlags();

       channelid = CHANNELID_DEFAULT;
       site = SITE_DEFAULT;
       cardid = CARDID_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public CardChannelDTOBase(CardChannelDTOBase another)
    {

       channelid = another.getChannelid();
       site = another.getSite();
       cardid = another.getCardid();

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
        stb.append(", ");
        stb.append(site);
        stb.append(", ");
        stb.append(cardid);
        return stb.toString();
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

    // site getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSiteDirty()  { return checkFieldDirtiness(SITE_DIRTYGROUP, SITE_DIRTYMASK); }

    public java.lang.String   getSite()         { return site; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "site")
    public java.lang.String   getSiteAsString() { return (site == null) ? "" : site; }

    // site setter methods.
    
    protected void markSiteAsDirty(boolean aFlag)  { markFieldAsDirty(SITE_DIRTYGROUP, SITE_DIRTYMASK, aFlag); }


    public void setSite(String  p)
    {
       setSite(p, DTOCasingStyle.none);
    }
    
    public void setSite(String  p, DTOCasingStyle casingStyle)
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
       markSiteAsDirty(!equalsObject(site, p));
       site = p;
    }

    // cardid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCardidDirty()  { return checkFieldDirtiness(CARDID_DIRTYGROUP, CARDID_DIRTYMASK); }

    public java.lang.String   getCardid()         { return cardid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "cardid")
    public java.lang.String   getCardidAsString() { return (cardid == null) ? "" : cardid; }

    // cardid setter methods.
    
    protected void markCardidAsDirty(boolean aFlag)  { markFieldAsDirty(CARDID_DIRTYGROUP, CARDID_DIRTYMASK, aFlag); }


    public void setCardid(String  p)
    {
       setCardid(p, DTOCasingStyle.none);
    }
    
    public void setCardid(String  p, DTOCasingStyle casingStyle)
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
       markCardidAsDirty(!equalsObject(cardid, p));
       cardid = p;
    }

}
