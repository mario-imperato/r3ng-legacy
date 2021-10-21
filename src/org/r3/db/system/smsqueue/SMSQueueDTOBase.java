//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.smsqueue;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "SMSQueueDTOBase")
public class SMSQueueDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  site;
    protected java.lang.String  smsid;
    protected java.lang.String  smstext;
    protected java.lang.String  smssender;
    protected java.lang.String  smsopts;
    protected java.sql.Timestamp  smssendat;
    protected java.lang.Integer  numberofretries;
    protected java.lang.Integer  numberoftargets;
    protected java.lang.Integer  numberofsentitems;
    protected java.lang.String  gtwayresponsecode;
    protected java.lang.String  gtwayresponsereason;
    protected java.lang.String  recstatus;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String SMSID_DEFAULT  =  null;
    public static final java.lang.String SMSTEXT_DEFAULT  =  null;
    public static final java.lang.String SMSSENDER_DEFAULT  =  null;
    public static final java.lang.String SMSOPTS_DEFAULT  =  null;
    public static final java.sql.Timestamp SMSSENDAT_DEFAULT  =  null;
    public static final java.lang.Integer NUMBEROFRETRIES_DEFAULT  =  null;
    public static final java.lang.Integer NUMBEROFTARGETS_DEFAULT  =  null;
    public static final java.lang.Integer NUMBEROFSENTITEMS_DEFAULT  =  null;
    public static final java.lang.String GTWAYRESPONSECODE_DEFAULT  =  null;
    public static final java.lang.String GTWAYRESPONSEREASON_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  1;
    public static final int SMSID_DIRTYGROUP  =  0;
    public static final int SMSID_DIRTYMASK   =  2;
    public static final int SMSTEXT_DIRTYGROUP  =  0;
    public static final int SMSTEXT_DIRTYMASK   =  4;
    public static final int SMSSENDER_DIRTYGROUP  =  0;
    public static final int SMSSENDER_DIRTYMASK   =  8;
    public static final int SMSOPTS_DIRTYGROUP  =  0;
    public static final int SMSOPTS_DIRTYMASK   =  16;
    public static final int SMSSENDAT_DIRTYGROUP  =  0;
    public static final int SMSSENDAT_DIRTYMASK   =  32;
    public static final int NUMBEROFRETRIES_DIRTYGROUP  =  0;
    public static final int NUMBEROFRETRIES_DIRTYMASK   =  64;
    public static final int NUMBEROFTARGETS_DIRTYGROUP  =  0;
    public static final int NUMBEROFTARGETS_DIRTYMASK   =  128;
    public static final int NUMBEROFSENTITEMS_DIRTYGROUP  =  0;
    public static final int NUMBEROFSENTITEMS_DIRTYMASK   =  256;
    public static final int GTWAYRESPONSECODE_DIRTYGROUP  =  0;
    public static final int GTWAYRESPONSECODE_DIRTYMASK   =  512;
    public static final int GTWAYRESPONSEREASON_DIRTYGROUP  =  0;
    public static final int GTWAYRESPONSEREASON_DIRTYMASK   =  1024;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  2048;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  4096;


    /**
      * DataBean constructor.
      */
    public SMSQueueDTOBase()
    {
       dirtyFlagsArray = new int[13 / 30 + 1];
       clearDirtyFlags();

       site = SITE_DEFAULT;
       smsid = SMSID_DEFAULT;
       smstext = SMSTEXT_DEFAULT;
       smssender = SMSSENDER_DEFAULT;
       smsopts = SMSOPTS_DEFAULT;
       smssendat = SMSSENDAT_DEFAULT;
       numberofretries = NUMBEROFRETRIES_DEFAULT;
       numberoftargets = NUMBEROFTARGETS_DEFAULT;
       numberofsentitems = NUMBEROFSENTITEMS_DEFAULT;
       gtwayresponsecode = GTWAYRESPONSECODE_DEFAULT;
       gtwayresponsereason = GTWAYRESPONSEREASON_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public SMSQueueDTOBase(SMSQueueDTOBase another)
    {

       site = another.getSite();
       smsid = another.getSmsid();
       smstext = another.getSmstext();
       smssender = another.getSmssender();
       smsopts = another.getSmsopts();
       smssendat = another.getSmssendat();
       numberofretries = another.getNumberofretries();
       numberoftargets = another.getNumberoftargets();
       numberofsentitems = another.getNumberofsentitems();
       gtwayresponsecode = another.getGtwayresponsecode();
       gtwayresponsereason = another.getGtwayresponsereason();
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
        stb.append(smsid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (smstext != null)
        {
        stb.append(smstext);
        notNull = true;        
        }
        if (notNull)
            return stb.toString();
            
        return null;
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

    // smsid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSmsidDirty()  { return checkFieldDirtiness(SMSID_DIRTYGROUP, SMSID_DIRTYMASK); }

    public java.lang.String   getSmsid()         { return smsid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getSmsidAsString() { return (smsid == null) ? "" : smsid; }

    // smsid setter methods.
    
    protected void markSmsidAsDirty(boolean aFlag)  { markFieldAsDirty(SMSID_DIRTYGROUP, SMSID_DIRTYMASK, aFlag); }


    public void setSmsid(String  p)
    {
       setSmsid(p, DTOCasingStyle.none);
    }
    
    public void setSmsid(String  p, DTOCasingStyle casingStyle)
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
       markSmsidAsDirty(!equalsObject(smsid, p));
       smsid = p;
    }

    // smstext getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSmstextDirty()  { return checkFieldDirtiness(SMSTEXT_DIRTYGROUP, SMSTEXT_DIRTYMASK); }

    public java.lang.String   getSmstext()         { return smstext; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getSmstextAsString() { return (smstext == null) ? "" : smstext; }

    // smstext setter methods.
    
    protected void markSmstextAsDirty(boolean aFlag)  { markFieldAsDirty(SMSTEXT_DIRTYGROUP, SMSTEXT_DIRTYMASK, aFlag); }


    public void setSmstext(String  p)
    {
       setSmstext(p, DTOCasingStyle.none);
    }
    
    public void setSmstext(String  p, DTOCasingStyle casingStyle)
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
       markSmstextAsDirty(!equalsObject(smstext, p));
       smstext = p;
    }

    // smssender getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSmssenderDirty()  { return checkFieldDirtiness(SMSSENDER_DIRTYGROUP, SMSSENDER_DIRTYMASK); }

    public java.lang.String   getSmssender()         { return smssender; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getSmssenderAsString() { return (smssender == null) ? "" : smssender; }

    // smssender setter methods.
    
    protected void markSmssenderAsDirty(boolean aFlag)  { markFieldAsDirty(SMSSENDER_DIRTYGROUP, SMSSENDER_DIRTYMASK, aFlag); }


    public void setSmssender(String  p)
    {
       setSmssender(p, DTOCasingStyle.none);
    }
    
    public void setSmssender(String  p, DTOCasingStyle casingStyle)
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
       markSmssenderAsDirty(!equalsObject(smssender, p));
       smssender = p;
    }

    // smsopts getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSmsoptsDirty()  { return checkFieldDirtiness(SMSOPTS_DIRTYGROUP, SMSOPTS_DIRTYMASK); }

    public java.lang.String   getSmsopts()         { return smsopts; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getSmsoptsAsString() { return (smsopts == null) ? "" : smsopts; }

    // smsopts setter methods.
    
    protected void markSmsoptsAsDirty(boolean aFlag)  { markFieldAsDirty(SMSOPTS_DIRTYGROUP, SMSOPTS_DIRTYMASK, aFlag); }


    public void setSmsopts(String  p)
    {
       setSmsopts(p, DTOCasingStyle.none);
    }
    
    public void setSmsopts(String  p, DTOCasingStyle casingStyle)
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
       markSmsoptsAsDirty(!equalsObject(smsopts, p));
       smsopts = p;
    }

    // smssendat getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSmssendatDirty()  { return checkFieldDirtiness(SMSSENDAT_DIRTYGROUP, SMSSENDAT_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getSmssendat() { return smssendat; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getSmssendatAsString() { return timestampAsString(smssendat, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getSmssendatAsString(java.text.DateFormat aDateFormat) { return timestampAsString(smssendat, aDateFormat); }

    // smssendat setter methods.
    
    protected void markSmssendatAsDirty(boolean aFlag)  { markFieldAsDirty(SMSSENDAT_DIRTYGROUP, SMSSENDAT_DIRTYMASK, aFlag); }


    public void setSmssendat(java.sql.Timestamp  p)
    {
        markSmssendatAsDirty(!equalsObject(smssendat, p));
    	smssendat = p;
    }
    public void setSmssendat(String  p, java.text.DateFormat aDateFormat)
    {
    	setSmssendat(stringAsTimestamp(p, aDateFormat));
    }

    // numberofretries getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNumberofretriesDirty()  { return checkFieldDirtiness(NUMBEROFRETRIES_DIRTYGROUP, NUMBEROFRETRIES_DIRTYMASK); }

    public java.lang.Integer   getNumberofretries() { return numberofretries; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getNumberofretriesAsString() { return integerAsString(numberofretries); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getNumberofretriesAsInt()    { return numberofretries != null ? numberofretries.intValue() : 0; }

    // numberofretries setter methods.
    
    protected void markNumberofretriesAsDirty(boolean aFlag)  { markFieldAsDirty(NUMBEROFRETRIES_DIRTYGROUP, NUMBEROFRETRIES_DIRTYMASK, aFlag); }


    public void setNumberofretries(java.lang.Integer  p)
    {
        markNumberofretriesAsDirty(!equalsObject(numberofretries, p));
    	numberofretries = p;
    }
    public void setNumberofretries(int p)
    {
    	setNumberofretries(new java.lang.Integer(p));
    }
    public void setNumberofretries()
    {
    	setNumberofretries(0);
    }
    public void setNumberofretries(String  p)
    {
    	setNumberofretries(stringAsInteger(p));
    }

    // numberoftargets getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNumberoftargetsDirty()  { return checkFieldDirtiness(NUMBEROFTARGETS_DIRTYGROUP, NUMBEROFTARGETS_DIRTYMASK); }

    public java.lang.Integer   getNumberoftargets() { return numberoftargets; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getNumberoftargetsAsString() { return integerAsString(numberoftargets); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getNumberoftargetsAsInt()    { return numberoftargets != null ? numberoftargets.intValue() : 0; }

    // numberoftargets setter methods.
    
    protected void markNumberoftargetsAsDirty(boolean aFlag)  { markFieldAsDirty(NUMBEROFTARGETS_DIRTYGROUP, NUMBEROFTARGETS_DIRTYMASK, aFlag); }


    public void setNumberoftargets(java.lang.Integer  p)
    {
        markNumberoftargetsAsDirty(!equalsObject(numberoftargets, p));
    	numberoftargets = p;
    }
    public void setNumberoftargets(int p)
    {
    	setNumberoftargets(new java.lang.Integer(p));
    }
    public void setNumberoftargets()
    {
    	setNumberoftargets(0);
    }
    public void setNumberoftargets(String  p)
    {
    	setNumberoftargets(stringAsInteger(p));
    }

    // numberofsentitems getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNumberofsentitemsDirty()  { return checkFieldDirtiness(NUMBEROFSENTITEMS_DIRTYGROUP, NUMBEROFSENTITEMS_DIRTYMASK); }

    public java.lang.Integer   getNumberofsentitems() { return numberofsentitems; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getNumberofsentitemsAsString() { return integerAsString(numberofsentitems); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getNumberofsentitemsAsInt()    { return numberofsentitems != null ? numberofsentitems.intValue() : 0; }

    // numberofsentitems setter methods.
    
    protected void markNumberofsentitemsAsDirty(boolean aFlag)  { markFieldAsDirty(NUMBEROFSENTITEMS_DIRTYGROUP, NUMBEROFSENTITEMS_DIRTYMASK, aFlag); }


    public void setNumberofsentitems(java.lang.Integer  p)
    {
        markNumberofsentitemsAsDirty(!equalsObject(numberofsentitems, p));
    	numberofsentitems = p;
    }
    public void setNumberofsentitems(int p)
    {
    	setNumberofsentitems(new java.lang.Integer(p));
    }
    public void setNumberofsentitems()
    {
    	setNumberofsentitems(0);
    }
    public void setNumberofsentitems(String  p)
    {
    	setNumberofsentitems(stringAsInteger(p));
    }

    // gtwayresponsecode getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isGtwayresponsecodeDirty()  { return checkFieldDirtiness(GTWAYRESPONSECODE_DIRTYGROUP, GTWAYRESPONSECODE_DIRTYMASK); }

    public java.lang.String   getGtwayresponsecode()         { return gtwayresponsecode; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getGtwayresponsecodeAsString() { return (gtwayresponsecode == null) ? "" : gtwayresponsecode; }

    // gtwayresponsecode setter methods.
    
    protected void markGtwayresponsecodeAsDirty(boolean aFlag)  { markFieldAsDirty(GTWAYRESPONSECODE_DIRTYGROUP, GTWAYRESPONSECODE_DIRTYMASK, aFlag); }


    public void setGtwayresponsecode(String  p)
    {
       setGtwayresponsecode(p, DTOCasingStyle.none);
    }
    
    public void setGtwayresponsecode(String  p, DTOCasingStyle casingStyle)
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
       markGtwayresponsecodeAsDirty(!equalsObject(gtwayresponsecode, p));
       gtwayresponsecode = p;
    }

    // gtwayresponsereason getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isGtwayresponsereasonDirty()  { return checkFieldDirtiness(GTWAYRESPONSEREASON_DIRTYGROUP, GTWAYRESPONSEREASON_DIRTYMASK); }

    public java.lang.String   getGtwayresponsereason()         { return gtwayresponsereason; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getGtwayresponsereasonAsString() { return (gtwayresponsereason == null) ? "" : gtwayresponsereason; }

    // gtwayresponsereason setter methods.
    
    protected void markGtwayresponsereasonAsDirty(boolean aFlag)  { markFieldAsDirty(GTWAYRESPONSEREASON_DIRTYGROUP, GTWAYRESPONSEREASON_DIRTYMASK, aFlag); }


    public void setGtwayresponsereason(String  p)
    {
       setGtwayresponsereason(p, DTOCasingStyle.none);
    }
    
    public void setGtwayresponsereason(String  p, DTOCasingStyle casingStyle)
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
       markGtwayresponsereasonAsDirty(!equalsObject(gtwayresponsereason, p));
       gtwayresponsereason = p;
    }

    // recstatus getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRecstatusDirty()  { return checkFieldDirtiness(RECSTATUS_DIRTYGROUP, RECSTATUS_DIRTYMASK); }

    public java.lang.String   getRecstatus()         { return recstatus; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
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
