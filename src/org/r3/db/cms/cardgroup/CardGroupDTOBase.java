//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardgroup;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "CardGroupDTOBase")
public class CardGroupDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  site;
    protected java.lang.String  cardid;
    protected java.lang.String  groupid;
    protected java.sql.Timestamp  validto;
    protected java.sql.Timestamp  validfrom;
    protected java.lang.String  recstatus;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String CARDID_DEFAULT  =  null;
    public static final java.lang.String GROUPID_DEFAULT  =  null;
    public static final java.sql.Timestamp VALIDTO_DEFAULT  =  null;
    public static final java.sql.Timestamp VALIDFROM_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  1;
    public static final int CARDID_DIRTYGROUP  =  0;
    public static final int CARDID_DIRTYMASK   =  2;
    public static final int GROUPID_DIRTYGROUP  =  0;
    public static final int GROUPID_DIRTYMASK   =  4;
    public static final int VALIDTO_DIRTYGROUP  =  0;
    public static final int VALIDTO_DIRTYMASK   =  8;
    public static final int VALIDFROM_DIRTYGROUP  =  0;
    public static final int VALIDFROM_DIRTYMASK   =  16;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  32;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  64;


    /**
      * DataBean constructor.
      */
    public CardGroupDTOBase()
    {
       dirtyFlagsArray = new int[7 / 30 + 1];
       clearDirtyFlags();

       site = SITE_DEFAULT;
       cardid = CARDID_DEFAULT;
       groupid = GROUPID_DEFAULT;
       validto = VALIDTO_DEFAULT;
       validfrom = VALIDFROM_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public CardGroupDTOBase(CardGroupDTOBase another)
    {

       site = another.getSite();
       cardid = another.getCardid();
       groupid = another.getGroupid();
       validto = another.getValidto();
       validfrom = another.getValidfrom();
       recstatus = another.getRecstatus();
       rectimestamp = another.getRectimestamp();

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
        stb.append(site);
        stb.append(", ");
        stb.append(cardid);
        stb.append(", ");
        stb.append(groupid);
        return stb.toString();
    }


    /**
      * DataBean Getter And Setter Accessor
      */

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

    // groupid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isGroupidDirty()  { return checkFieldDirtiness(GROUPID_DIRTYGROUP, GROUPID_DIRTYMASK); }

    public java.lang.String   getGroupid()         { return groupid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "groupid")
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

    // validto getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isValidtoDirty()  { return checkFieldDirtiness(VALIDTO_DIRTYGROUP, VALIDTO_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getValidto() { return validto; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "validto")
    public String getValidtoAsString() { return timestampAsString(validto, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getValidtoAsString(java.text.DateFormat aDateFormat) { return timestampAsString(validto, aDateFormat); }

    // validto setter methods.
    
    protected void markValidtoAsDirty(boolean aFlag)  { markFieldAsDirty(VALIDTO_DIRTYGROUP, VALIDTO_DIRTYMASK, aFlag); }


    public void setValidto(java.sql.Timestamp  p)
    {
        markValidtoAsDirty(!equalsObject(validto, p));
    	validto = p;
    }
    public void setValidto(String  p, java.text.DateFormat aDateFormat)
    {
    	setValidto(stringAsTimestamp(p, aDateFormat));
    }

    // validfrom getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isValidfromDirty()  { return checkFieldDirtiness(VALIDFROM_DIRTYGROUP, VALIDFROM_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getValidfrom() { return validfrom; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "validfrom")
    public String getValidfromAsString() { return timestampAsString(validfrom, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getValidfromAsString(java.text.DateFormat aDateFormat) { return timestampAsString(validfrom, aDateFormat); }

    // validfrom setter methods.
    
    protected void markValidfromAsDirty(boolean aFlag)  { markFieldAsDirty(VALIDFROM_DIRTYGROUP, VALIDFROM_DIRTYMASK, aFlag); }


    public void setValidfrom(java.sql.Timestamp  p)
    {
        markValidfromAsDirty(!equalsObject(validfrom, p));
    	validfrom = p;
    }
    public void setValidfrom(String  p, java.text.DateFormat aDateFormat)
    {
    	setValidfrom(stringAsTimestamp(p, aDateFormat));
    }

    // recstatus getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRecstatusDirty()  { return checkFieldDirtiness(RECSTATUS_DIRTYGROUP, RECSTATUS_DIRTYMASK); }

    public java.lang.String   getRecstatus()         { return recstatus; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "recstatus")
    public java.lang.String   getRecstatusAsString() { return (recstatus == null) ? "" : recstatus; }

    // recstatus setter methods.
    
    protected void markRecstatusAsDirty(boolean aFlag)  { markFieldAsDirty(RECSTATUS_DIRTYGROUP, RECSTATUS_DIRTYMASK, aFlag); }


    public void setRecstatus(String  p)
    {
       setRecstatus(p, DTOCasingStyle.none);
    }
    
    public void setRecstatus(String  p, DTOCasingStyle casingStyle)
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
       markRecstatusAsDirty(!equalsObject(recstatus, p));
       recstatus = p;
    }

    // rectimestamp getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRectimestampDirty()  { return checkFieldDirtiness(RECTIMESTAMP_DIRTYGROUP, RECTIMESTAMP_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getRectimestamp() { return rectimestamp; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "rectimestamp")
    public String getRectimestampAsString() { return timestampAsString(rectimestamp, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getRectimestampAsString(java.text.DateFormat aDateFormat) { return timestampAsString(rectimestamp, aDateFormat); }

    // rectimestamp setter methods.
    
    protected void markRectimestampAsDirty(boolean aFlag)  { markFieldAsDirty(RECTIMESTAMP_DIRTYGROUP, RECTIMESTAMP_DIRTYMASK, aFlag); }


    public void setRectimestamp(java.sql.Timestamp  p)
    {
        markRectimestampAsDirty(!equalsObject(rectimestamp, p));
    	rectimestamp = p;
    }
    public void setRectimestamp(String  p, java.text.DateFormat aDateFormat)
    {
    	setRectimestamp(stringAsTimestamp(p, aDateFormat));
    }

}
