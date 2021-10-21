//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.agenda.agendaentry;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "AgendaEntryDTOBase")
public class AgendaEntryDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  agendaentryid;
    protected java.lang.String  agendaid;
    protected java.lang.String  entrydescr;
    protected java.lang.String  entrytype;
    protected java.lang.String  entrytyperefid;
    protected java.lang.String  alldayflag;
    protected java.sql.Date  startdate;
    protected java.lang.String  starttime;
    protected java.sql.Date  enddate;
    protected java.lang.String  endtime;

    public static final java.lang.String AGENDAENTRYID_DEFAULT  =  null;
    public static final java.lang.String AGENDAID_DEFAULT  =  null;
    public static final java.lang.String ENTRYDESCR_DEFAULT  =  null;
    public static final java.lang.String ENTRYTYPE_DEFAULT  =  null;
    public static final java.lang.String ENTRYTYPEREFID_DEFAULT  =  null;
    public static final java.lang.String ALLDAYFLAG_DEFAULT  =  null;
    public static final java.sql.Date STARTDATE_DEFAULT  =  null;
    public static final java.lang.String STARTTIME_DEFAULT  =  null;
    public static final java.sql.Date ENDDATE_DEFAULT  =  null;
    public static final java.lang.String ENDTIME_DEFAULT  =  null;

    public static final int AGENDAENTRYID_DIRTYGROUP  =  0;
    public static final int AGENDAENTRYID_DIRTYMASK   =  1;
    public static final int AGENDAID_DIRTYGROUP  =  0;
    public static final int AGENDAID_DIRTYMASK   =  2;
    public static final int ENTRYDESCR_DIRTYGROUP  =  0;
    public static final int ENTRYDESCR_DIRTYMASK   =  4;
    public static final int ENTRYTYPE_DIRTYGROUP  =  0;
    public static final int ENTRYTYPE_DIRTYMASK   =  8;
    public static final int ENTRYTYPEREFID_DIRTYGROUP  =  0;
    public static final int ENTRYTYPEREFID_DIRTYMASK   =  16;
    public static final int ALLDAYFLAG_DIRTYGROUP  =  0;
    public static final int ALLDAYFLAG_DIRTYMASK   =  32;
    public static final int STARTDATE_DIRTYGROUP  =  0;
    public static final int STARTDATE_DIRTYMASK   =  64;
    public static final int STARTTIME_DIRTYGROUP  =  0;
    public static final int STARTTIME_DIRTYMASK   =  128;
    public static final int ENDDATE_DIRTYGROUP  =  0;
    public static final int ENDDATE_DIRTYMASK   =  256;
    public static final int ENDTIME_DIRTYGROUP  =  0;
    public static final int ENDTIME_DIRTYMASK   =  512;


    /**
      * DataBean constructor.
      */
    public AgendaEntryDTOBase()
    {
       dirtyFlagsArray = new int[10 / 30 + 1];
       clearDirtyFlags();

       agendaentryid = AGENDAENTRYID_DEFAULT;
       agendaid = AGENDAID_DEFAULT;
       entrydescr = ENTRYDESCR_DEFAULT;
       entrytype = ENTRYTYPE_DEFAULT;
       entrytyperefid = ENTRYTYPEREFID_DEFAULT;
       alldayflag = ALLDAYFLAG_DEFAULT;
       startdate = STARTDATE_DEFAULT;
       starttime = STARTTIME_DEFAULT;
       enddate = ENDDATE_DEFAULT;
       endtime = ENDTIME_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public AgendaEntryDTOBase(AgendaEntryDTOBase another)
    {

       agendaentryid = another.getAgendaentryid();
       agendaid = another.getAgendaid();
       entrydescr = another.getEntrydescr();
       entrytype = another.getEntrytype();
       entrytyperefid = another.getEntrytyperefid();
       alldayflag = another.getAlldayflag();
       startdate = another.getStartdate();
       starttime = another.getStarttime();
       enddate = another.getEnddate();
       endtime = another.getEndtime();

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
        stb.append(agendaentryid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (entrydescr != null)
        {
        stb.append(entrydescr);
        notNull = true;        
        }
        if (notNull)
            return stb.toString();
            
        return null;
    }

    /**
      * DataBean Getter And Setter Accessor
      */

    // agendaentryid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isAgendaentryidDirty()  { return checkFieldDirtiness(AGENDAENTRYID_DIRTYGROUP, AGENDAENTRYID_DIRTYMASK); }

    public java.lang.String   getAgendaentryid()         { return agendaentryid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "agendaentryid")
    public java.lang.String   getAgendaentryidAsString() { return (agendaentryid == null) ? "" : agendaentryid; }

    // agendaentryid setter methods.
    
    protected void markAgendaentryidAsDirty(boolean aFlag)  { markFieldAsDirty(AGENDAENTRYID_DIRTYGROUP, AGENDAENTRYID_DIRTYMASK, aFlag); }


    public void setAgendaentryid(String  p)
    {
       setAgendaentryid(p, DTOCasingStyle.none);
    }
    
    public void setAgendaentryid(String  p, DTOCasingStyle casingStyle)
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
       markAgendaentryidAsDirty(!equalsObject(agendaentryid, p));
       agendaentryid = p;
    }

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

    // entrydescr getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEntrydescrDirty()  { return checkFieldDirtiness(ENTRYDESCR_DIRTYGROUP, ENTRYDESCR_DIRTYMASK); }

    public java.lang.String   getEntrydescr()         { return entrydescr; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "entrydescr")
    public java.lang.String   getEntrydescrAsString() { return (entrydescr == null) ? "" : entrydescr; }

    // entrydescr setter methods.
    
    protected void markEntrydescrAsDirty(boolean aFlag)  { markFieldAsDirty(ENTRYDESCR_DIRTYGROUP, ENTRYDESCR_DIRTYMASK, aFlag); }


    public void setEntrydescr(String  p)
    {
       setEntrydescr(p, DTOCasingStyle.none);
    }
    
    public void setEntrydescr(String  p, DTOCasingStyle casingStyle)
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
       markEntrydescrAsDirty(!equalsObject(entrydescr, p));
       entrydescr = p;
    }

    // entrytype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEntrytypeDirty()  { return checkFieldDirtiness(ENTRYTYPE_DIRTYGROUP, ENTRYTYPE_DIRTYMASK); }

    public java.lang.String   getEntrytype()         { return entrytype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "entrytype")
    public java.lang.String   getEntrytypeAsString() { return (entrytype == null) ? "" : entrytype; }

    // entrytype setter methods.
    
    protected void markEntrytypeAsDirty(boolean aFlag)  { markFieldAsDirty(ENTRYTYPE_DIRTYGROUP, ENTRYTYPE_DIRTYMASK, aFlag); }


    public void setEntrytype(String  p)
    {
       setEntrytype(p, DTOCasingStyle.none);
    }
    
    public void setEntrytype(String  p, DTOCasingStyle casingStyle)
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
       markEntrytypeAsDirty(!equalsObject(entrytype, p));
       entrytype = p;
    }

    // entrytyperefid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEntrytyperefidDirty()  { return checkFieldDirtiness(ENTRYTYPEREFID_DIRTYGROUP, ENTRYTYPEREFID_DIRTYMASK); }

    public java.lang.String   getEntrytyperefid()         { return entrytyperefid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "entrytyperefid")
    public java.lang.String   getEntrytyperefidAsString() { return (entrytyperefid == null) ? "" : entrytyperefid; }

    // entrytyperefid setter methods.
    
    protected void markEntrytyperefidAsDirty(boolean aFlag)  { markFieldAsDirty(ENTRYTYPEREFID_DIRTYGROUP, ENTRYTYPEREFID_DIRTYMASK, aFlag); }


    public void setEntrytyperefid(String  p)
    {
       setEntrytyperefid(p, DTOCasingStyle.none);
    }
    
    public void setEntrytyperefid(String  p, DTOCasingStyle casingStyle)
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
       markEntrytyperefidAsDirty(!equalsObject(entrytyperefid, p));
       entrytyperefid = p;
    }

    // alldayflag getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isAlldayflagDirty()  { return checkFieldDirtiness(ALLDAYFLAG_DIRTYGROUP, ALLDAYFLAG_DIRTYMASK); }

    public java.lang.String   getAlldayflag()         { return alldayflag; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "alldayflag")
    public java.lang.String   getAlldayflagAsString() { return (alldayflag == null) ? "" : alldayflag; }

    // alldayflag setter methods.
    
    protected void markAlldayflagAsDirty(boolean aFlag)  { markFieldAsDirty(ALLDAYFLAG_DIRTYGROUP, ALLDAYFLAG_DIRTYMASK, aFlag); }


    public void setAlldayflag(String  p)
    {
       setAlldayflag(p, DTOCasingStyle.none);
    }
    
    public void setAlldayflag(String  p, DTOCasingStyle casingStyle)
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
       markAlldayflagAsDirty(!equalsObject(alldayflag, p));
       alldayflag = p;
    }

    // startdate getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isStartdateDirty()  { return checkFieldDirtiness(STARTDATE_DIRTYGROUP, STARTDATE_DIRTYMASK); }

    public java.sql.Date   getStartdate() { return startdate; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "startdate")
    public String getStartdateAsString() { return dateAsString(startdate, getDateFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getStartdateAsString(java.text.DateFormat aDateFormat) { return dateAsString(startdate, aDateFormat); }

    // startdate setter methods.
    
    protected void markStartdateAsDirty(boolean aFlag)  { markFieldAsDirty(STARTDATE_DIRTYGROUP, STARTDATE_DIRTYMASK, aFlag); }


    public void setStartdate(java.sql.Date  p)
    {
         markStartdateAsDirty(!equalsObject(startdate, p));
    	 startdate = p;
    }
    public void setStartdate(String p, java.text.DateFormat aDateFormat)
    {
    	setStartdate(stringAsDate(p, aDateFormat));
    }

    // starttime getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isStarttimeDirty()  { return checkFieldDirtiness(STARTTIME_DIRTYGROUP, STARTTIME_DIRTYMASK); }

    public java.lang.String   getStarttime()         { return starttime; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "starttime")
    public java.lang.String   getStarttimeAsString() { return (starttime == null) ? "" : starttime; }

    // starttime setter methods.
    
    protected void markStarttimeAsDirty(boolean aFlag)  { markFieldAsDirty(STARTTIME_DIRTYGROUP, STARTTIME_DIRTYMASK, aFlag); }


    public void setStarttime(String  p)
    {
       setStarttime(p, DTOCasingStyle.none);
    }
    
    public void setStarttime(String  p, DTOCasingStyle casingStyle)
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
       markStarttimeAsDirty(!equalsObject(starttime, p));
       starttime = p;
    }

    // enddate getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEnddateDirty()  { return checkFieldDirtiness(ENDDATE_DIRTYGROUP, ENDDATE_DIRTYMASK); }

    public java.sql.Date   getEnddate() { return enddate; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "enddate")
    public String getEnddateAsString() { return dateAsString(enddate, getDateFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getEnddateAsString(java.text.DateFormat aDateFormat) { return dateAsString(enddate, aDateFormat); }

    // enddate setter methods.
    
    protected void markEnddateAsDirty(boolean aFlag)  { markFieldAsDirty(ENDDATE_DIRTYGROUP, ENDDATE_DIRTYMASK, aFlag); }


    public void setEnddate(java.sql.Date  p)
    {
         markEnddateAsDirty(!equalsObject(enddate, p));
    	 enddate = p;
    }
    public void setEnddate(String p, java.text.DateFormat aDateFormat)
    {
    	setEnddate(stringAsDate(p, aDateFormat));
    }

    // endtime getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEndtimeDirty()  { return checkFieldDirtiness(ENDTIME_DIRTYGROUP, ENDTIME_DIRTYMASK); }

    public java.lang.String   getEndtime()         { return endtime; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "endtime")
    public java.lang.String   getEndtimeAsString() { return (endtime == null) ? "" : endtime; }

    // endtime setter methods.
    
    protected void markEndtimeAsDirty(boolean aFlag)  { markFieldAsDirty(ENDTIME_DIRTYGROUP, ENDTIME_DIRTYMASK, aFlag); }


    public void setEndtime(String  p)
    {
       setEndtime(p, DTOCasingStyle.none);
    }
    
    public void setEndtime(String  p, DTOCasingStyle casingStyle)
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
       markEndtimeAsDirty(!equalsObject(endtime, p));
       endtime = p;
    }

}
