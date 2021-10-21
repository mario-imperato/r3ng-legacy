//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.calendarperiod;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "SystemCalendarPeriodDTOBase")
public class SystemCalendarPeriodDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.Integer  periodindex;
    protected java.lang.String  periodtype;
    protected java.sql.Date  periodstart;
    protected java.sql.Date  periodend;
    protected java.lang.Integer  periodyear;
    protected java.lang.Integer  periodyindex;
    protected java.lang.String  perioddescr;

    public static final java.lang.Integer PERIODINDEX_DEFAULT  =  null;
    public static final java.lang.String PERIODTYPE_DEFAULT  =  null;
    public static final java.sql.Date PERIODSTART_DEFAULT  =  null;
    public static final java.sql.Date PERIODEND_DEFAULT  =  null;
    public static final java.lang.Integer PERIODYEAR_DEFAULT  =  null;
    public static final java.lang.Integer PERIODYINDEX_DEFAULT  =  null;
    public static final java.lang.String PERIODDESCR_DEFAULT  =  null;

    public static final int PERIODINDEX_DIRTYGROUP  =  0;
    public static final int PERIODINDEX_DIRTYMASK   =  1;
    public static final int PERIODTYPE_DIRTYGROUP  =  0;
    public static final int PERIODTYPE_DIRTYMASK   =  2;
    public static final int PERIODSTART_DIRTYGROUP  =  0;
    public static final int PERIODSTART_DIRTYMASK   =  4;
    public static final int PERIODEND_DIRTYGROUP  =  0;
    public static final int PERIODEND_DIRTYMASK   =  8;
    public static final int PERIODYEAR_DIRTYGROUP  =  0;
    public static final int PERIODYEAR_DIRTYMASK   =  16;
    public static final int PERIODYINDEX_DIRTYGROUP  =  0;
    public static final int PERIODYINDEX_DIRTYMASK   =  32;
    public static final int PERIODDESCR_DIRTYGROUP  =  0;
    public static final int PERIODDESCR_DIRTYMASK   =  64;


    /**
      * DataBean constructor.
      */
    public SystemCalendarPeriodDTOBase()
    {
       dirtyFlagsArray = new int[7 / 30 + 1];
       clearDirtyFlags();

       periodindex = PERIODINDEX_DEFAULT;
       periodtype = PERIODTYPE_DEFAULT;
       periodstart = PERIODSTART_DEFAULT;
       periodend = PERIODEND_DEFAULT;
       periodyear = PERIODYEAR_DEFAULT;
       periodyindex = PERIODYINDEX_DEFAULT;
       perioddescr = PERIODDESCR_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public SystemCalendarPeriodDTOBase(SystemCalendarPeriodDTOBase another)
    {

       periodindex = another.getPeriodindex();
       periodtype = another.getPeriodtype();
       periodstart = another.getPeriodstart();
       periodend = another.getPeriodend();
       periodyear = another.getPeriodyear();
       periodyindex = another.getPeriodyindex();
       perioddescr = another.getPerioddescr();

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
        stb.append(periodindex);
        stb.append(", ");
        stb.append(periodtype);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (perioddescr != null)
        {
        stb.append(perioddescr);
        notNull = true;        
        }
        if (notNull)
            return stb.toString();
            
        return null;
    }

    /**
      * DataBean Getter And Setter Accessor
      */

    // periodindex getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPeriodindexDirty()  { return checkFieldDirtiness(PERIODINDEX_DIRTYGROUP, PERIODINDEX_DIRTYMASK); }

    public java.lang.Integer   getPeriodindex() { return periodindex; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "periodindex")
    public String getPeriodindexAsString() { return integerAsString(periodindex); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getPeriodindexAsInt()    { return periodindex != null ? periodindex.intValue() : 0; }

    // periodindex setter methods.
    
    protected void markPeriodindexAsDirty(boolean aFlag)  { markFieldAsDirty(PERIODINDEX_DIRTYGROUP, PERIODINDEX_DIRTYMASK, aFlag); }


    public void setPeriodindex(java.lang.Integer  p)
    {
        markPeriodindexAsDirty(!equalsObject(periodindex, p));
    	periodindex = p;
    }
    public void setPeriodindex(int p)
    {
    	setPeriodindex(new java.lang.Integer(p));
    }
    public void setPeriodindex()
    {
    	setPeriodindex(0);
    }
    public void setPeriodindex(String  p)
    {
    	setPeriodindex(stringAsInteger(p));
    }

    // periodtype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPeriodtypeDirty()  { return checkFieldDirtiness(PERIODTYPE_DIRTYGROUP, PERIODTYPE_DIRTYMASK); }

    public java.lang.String   getPeriodtype()         { return periodtype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "periodtype")
    public java.lang.String   getPeriodtypeAsString() { return (periodtype == null) ? "" : periodtype; }

    // periodtype setter methods.
    
    protected void markPeriodtypeAsDirty(boolean aFlag)  { markFieldAsDirty(PERIODTYPE_DIRTYGROUP, PERIODTYPE_DIRTYMASK, aFlag); }


    public void setPeriodtype(String  p)
    {
       setPeriodtype(p, DTOCasingStyle.none);
    }
    
    public void setPeriodtype(String  p, DTOCasingStyle casingStyle)
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
       markPeriodtypeAsDirty(!equalsObject(periodtype, p));
       periodtype = p;
    }

    // periodstart getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPeriodstartDirty()  { return checkFieldDirtiness(PERIODSTART_DIRTYGROUP, PERIODSTART_DIRTYMASK); }

    public java.sql.Date   getPeriodstart() { return periodstart; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "periodstart")
    public String getPeriodstartAsString() { return dateAsString(periodstart, getDateFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getPeriodstartAsString(java.text.DateFormat aDateFormat) { return dateAsString(periodstart, aDateFormat); }

    // periodstart setter methods.
    
    protected void markPeriodstartAsDirty(boolean aFlag)  { markFieldAsDirty(PERIODSTART_DIRTYGROUP, PERIODSTART_DIRTYMASK, aFlag); }


    public void setPeriodstart(java.sql.Date  p)
    {
         markPeriodstartAsDirty(!equalsObject(periodstart, p));
    	 periodstart = p;
    }
    public void setPeriodstart(String p, java.text.DateFormat aDateFormat)
    {
    	setPeriodstart(stringAsDate(p, aDateFormat));
    }

    // periodend getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPeriodendDirty()  { return checkFieldDirtiness(PERIODEND_DIRTYGROUP, PERIODEND_DIRTYMASK); }

    public java.sql.Date   getPeriodend() { return periodend; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "periodend")
    public String getPeriodendAsString() { return dateAsString(periodend, getDateFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getPeriodendAsString(java.text.DateFormat aDateFormat) { return dateAsString(periodend, aDateFormat); }

    // periodend setter methods.
    
    protected void markPeriodendAsDirty(boolean aFlag)  { markFieldAsDirty(PERIODEND_DIRTYGROUP, PERIODEND_DIRTYMASK, aFlag); }


    public void setPeriodend(java.sql.Date  p)
    {
         markPeriodendAsDirty(!equalsObject(periodend, p));
    	 periodend = p;
    }
    public void setPeriodend(String p, java.text.DateFormat aDateFormat)
    {
    	setPeriodend(stringAsDate(p, aDateFormat));
    }

    // periodyear getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPeriodyearDirty()  { return checkFieldDirtiness(PERIODYEAR_DIRTYGROUP, PERIODYEAR_DIRTYMASK); }

    public java.lang.Integer   getPeriodyear() { return periodyear; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "periodyear")
    public String getPeriodyearAsString() { return integerAsString(periodyear); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getPeriodyearAsInt()    { return periodyear != null ? periodyear.intValue() : 0; }

    // periodyear setter methods.
    
    protected void markPeriodyearAsDirty(boolean aFlag)  { markFieldAsDirty(PERIODYEAR_DIRTYGROUP, PERIODYEAR_DIRTYMASK, aFlag); }


    public void setPeriodyear(java.lang.Integer  p)
    {
        markPeriodyearAsDirty(!equalsObject(periodyear, p));
    	periodyear = p;
    }
    public void setPeriodyear(int p)
    {
    	setPeriodyear(new java.lang.Integer(p));
    }
    public void setPeriodyear()
    {
    	setPeriodyear(0);
    }
    public void setPeriodyear(String  p)
    {
    	setPeriodyear(stringAsInteger(p));
    }

    // periodyindex getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPeriodyindexDirty()  { return checkFieldDirtiness(PERIODYINDEX_DIRTYGROUP, PERIODYINDEX_DIRTYMASK); }

    public java.lang.Integer   getPeriodyindex() { return periodyindex; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "periodyindex")
    public String getPeriodyindexAsString() { return integerAsString(periodyindex); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getPeriodyindexAsInt()    { return periodyindex != null ? periodyindex.intValue() : 0; }

    // periodyindex setter methods.
    
    protected void markPeriodyindexAsDirty(boolean aFlag)  { markFieldAsDirty(PERIODYINDEX_DIRTYGROUP, PERIODYINDEX_DIRTYMASK, aFlag); }


    public void setPeriodyindex(java.lang.Integer  p)
    {
        markPeriodyindexAsDirty(!equalsObject(periodyindex, p));
    	periodyindex = p;
    }
    public void setPeriodyindex(int p)
    {
    	setPeriodyindex(new java.lang.Integer(p));
    }
    public void setPeriodyindex()
    {
    	setPeriodyindex(0);
    }
    public void setPeriodyindex(String  p)
    {
    	setPeriodyindex(stringAsInteger(p));
    }

    // perioddescr getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPerioddescrDirty()  { return checkFieldDirtiness(PERIODDESCR_DIRTYGROUP, PERIODDESCR_DIRTYMASK); }

    public java.lang.String   getPerioddescr()         { return perioddescr; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "perioddescr")
    public java.lang.String   getPerioddescrAsString() { return (perioddescr == null) ? "" : perioddescr; }

    // perioddescr setter methods.
    
    protected void markPerioddescrAsDirty(boolean aFlag)  { markFieldAsDirty(PERIODDESCR_DIRTYGROUP, PERIODDESCR_DIRTYMASK, aFlag); }


    public void setPerioddescr(String  p)
    {
       setPerioddescr(p, DTOCasingStyle.none);
    }
    
    public void setPerioddescr(String  p, DTOCasingStyle casingStyle)
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
       markPerioddescrAsDirty(!equalsObject(perioddescr, p));
       perioddescr = p;
    }

}
