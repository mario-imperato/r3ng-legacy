//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.fileimport.fileimportdata;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "FileImportDataDTOBase")
public class FileImportDataDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.Integer  importdataid;
    protected java.lang.String  site;
    protected java.lang.String  importid;
    protected java.lang.String  recordtype;
    protected java.lang.Integer  recordnumber;
    protected java.lang.String  col1;
    protected java.lang.String  col2;
    protected java.lang.String  col3;
    protected java.lang.String  col4;
    protected java.lang.String  col5;
    protected java.lang.String  col6;
    protected java.lang.String  col7;
    protected java.lang.String  col8;
    protected java.lang.String  col9;
    protected java.lang.String  cola;
    protected java.lang.String  colb;
    protected java.lang.String  colc;
    protected java.lang.String  cold;
    protected java.lang.String  cole;
    protected java.lang.String  colf;
    protected java.lang.String  recstatus;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.Integer IMPORTDATAID_DEFAULT  =  null;
    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String IMPORTID_DEFAULT  =  null;
    public static final java.lang.String RECORDTYPE_DEFAULT  =  null;
    public static final java.lang.Integer RECORDNUMBER_DEFAULT  =  null;
    public static final java.lang.String COL1_DEFAULT  =  null;
    public static final java.lang.String COL2_DEFAULT  =  null;
    public static final java.lang.String COL3_DEFAULT  =  null;
    public static final java.lang.String COL4_DEFAULT  =  null;
    public static final java.lang.String COL5_DEFAULT  =  null;
    public static final java.lang.String COL6_DEFAULT  =  null;
    public static final java.lang.String COL7_DEFAULT  =  null;
    public static final java.lang.String COL8_DEFAULT  =  null;
    public static final java.lang.String COL9_DEFAULT  =  null;
    public static final java.lang.String COLA_DEFAULT  =  null;
    public static final java.lang.String COLB_DEFAULT  =  null;
    public static final java.lang.String COLC_DEFAULT  =  null;
    public static final java.lang.String COLD_DEFAULT  =  null;
    public static final java.lang.String COLE_DEFAULT  =  null;
    public static final java.lang.String COLF_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int IMPORTDATAID_DIRTYGROUP  =  0;
    public static final int IMPORTDATAID_DIRTYMASK   =  1;
    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  2;
    public static final int IMPORTID_DIRTYGROUP  =  0;
    public static final int IMPORTID_DIRTYMASK   =  4;
    public static final int RECORDTYPE_DIRTYGROUP  =  0;
    public static final int RECORDTYPE_DIRTYMASK   =  8;
    public static final int RECORDNUMBER_DIRTYGROUP  =  0;
    public static final int RECORDNUMBER_DIRTYMASK   =  16;
    public static final int COL1_DIRTYGROUP  =  0;
    public static final int COL1_DIRTYMASK   =  32;
    public static final int COL2_DIRTYGROUP  =  0;
    public static final int COL2_DIRTYMASK   =  64;
    public static final int COL3_DIRTYGROUP  =  0;
    public static final int COL3_DIRTYMASK   =  128;
    public static final int COL4_DIRTYGROUP  =  0;
    public static final int COL4_DIRTYMASK   =  256;
    public static final int COL5_DIRTYGROUP  =  0;
    public static final int COL5_DIRTYMASK   =  512;
    public static final int COL6_DIRTYGROUP  =  0;
    public static final int COL6_DIRTYMASK   =  1024;
    public static final int COL7_DIRTYGROUP  =  0;
    public static final int COL7_DIRTYMASK   =  2048;
    public static final int COL8_DIRTYGROUP  =  0;
    public static final int COL8_DIRTYMASK   =  4096;
    public static final int COL9_DIRTYGROUP  =  0;
    public static final int COL9_DIRTYMASK   =  8192;
    public static final int COLA_DIRTYGROUP  =  0;
    public static final int COLA_DIRTYMASK   =  16384;
    public static final int COLB_DIRTYGROUP  =  0;
    public static final int COLB_DIRTYMASK   =  32768;
    public static final int COLC_DIRTYGROUP  =  0;
    public static final int COLC_DIRTYMASK   =  65536;
    public static final int COLD_DIRTYGROUP  =  0;
    public static final int COLD_DIRTYMASK   =  131072;
    public static final int COLE_DIRTYGROUP  =  0;
    public static final int COLE_DIRTYMASK   =  262144;
    public static final int COLF_DIRTYGROUP  =  0;
    public static final int COLF_DIRTYMASK   =  524288;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  1048576;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  2097152;


    /**
      * DataBean constructor.
      */
    public FileImportDataDTOBase()
    {
       dirtyFlagsArray = new int[22 / 30 + 1];
       clearDirtyFlags();

       importdataid = IMPORTDATAID_DEFAULT;
       site = SITE_DEFAULT;
       importid = IMPORTID_DEFAULT;
       recordtype = RECORDTYPE_DEFAULT;
       recordnumber = RECORDNUMBER_DEFAULT;
       col1 = COL1_DEFAULT;
       col2 = COL2_DEFAULT;
       col3 = COL3_DEFAULT;
       col4 = COL4_DEFAULT;
       col5 = COL5_DEFAULT;
       col6 = COL6_DEFAULT;
       col7 = COL7_DEFAULT;
       col8 = COL8_DEFAULT;
       col9 = COL9_DEFAULT;
       cola = COLA_DEFAULT;
       colb = COLB_DEFAULT;
       colc = COLC_DEFAULT;
       cold = COLD_DEFAULT;
       cole = COLE_DEFAULT;
       colf = COLF_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public FileImportDataDTOBase(FileImportDataDTOBase another)
    {

       importdataid = another.getImportdataid();
       site = another.getSite();
       importid = another.getImportid();
       recordtype = another.getRecordtype();
       recordnumber = another.getRecordnumber();
       col1 = another.getCol1();
       col2 = another.getCol2();
       col3 = another.getCol3();
       col4 = another.getCol4();
       col5 = another.getCol5();
       col6 = another.getCol6();
       col7 = another.getCol7();
       col8 = another.getCol8();
       col9 = another.getCol9();
       cola = another.getCola();
       colb = another.getColb();
       colc = another.getColc();
       cold = another.getCold();
       cole = another.getCole();
       colf = another.getColf();
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
        stb.append(importdataid);
        return stb.toString();
    }


    /**
      * DataBean Getter And Setter Accessor
      */

    // importdataid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isImportdataidDirty()  { return checkFieldDirtiness(IMPORTDATAID_DIRTYGROUP, IMPORTDATAID_DIRTYMASK); }

    public java.lang.Integer   getImportdataid() { return importdataid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "importdataid")
    public String getImportdataidAsString() { return integerAsString(importdataid); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getImportdataidAsInt()    { return importdataid != null ? importdataid.intValue() : 0; }

    // importdataid setter methods.
    
    protected void markImportdataidAsDirty(boolean aFlag)  { markFieldAsDirty(IMPORTDATAID_DIRTYGROUP, IMPORTDATAID_DIRTYMASK, aFlag); }


    public void setImportdataid(java.lang.Integer  p)
    {
        markImportdataidAsDirty(!equalsObject(importdataid, p));
    	importdataid = p;
    }
    public void setImportdataid(int p)
    {
    	setImportdataid(new java.lang.Integer(p));
    }
    public void setImportdataid()
    {
    	setImportdataid(0);
    }
    public void setImportdataid(String  p)
    {
    	setImportdataid(stringAsInteger(p));
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

    // importid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isImportidDirty()  { return checkFieldDirtiness(IMPORTID_DIRTYGROUP, IMPORTID_DIRTYMASK); }

    public java.lang.String   getImportid()         { return importid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "importid")
    public java.lang.String   getImportidAsString() { return (importid == null) ? "" : importid; }

    // importid setter methods.
    
    protected void markImportidAsDirty(boolean aFlag)  { markFieldAsDirty(IMPORTID_DIRTYGROUP, IMPORTID_DIRTYMASK, aFlag); }


    public void setImportid(String  p)
    {
       setImportid(p, DTOCasingStyle.none);
    }
    
    public void setImportid(String  p, DTOCasingStyle casingStyle)
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
       markImportidAsDirty(!equalsObject(importid, p));
       importid = p;
    }

    // recordtype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRecordtypeDirty()  { return checkFieldDirtiness(RECORDTYPE_DIRTYGROUP, RECORDTYPE_DIRTYMASK); }

    public java.lang.String   getRecordtype()         { return recordtype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "recordtype")
    public java.lang.String   getRecordtypeAsString() { return (recordtype == null) ? "" : recordtype; }

    // recordtype setter methods.
    
    protected void markRecordtypeAsDirty(boolean aFlag)  { markFieldAsDirty(RECORDTYPE_DIRTYGROUP, RECORDTYPE_DIRTYMASK, aFlag); }


    public void setRecordtype(String  p)
    {
       setRecordtype(p, DTOCasingStyle.none);
    }
    
    public void setRecordtype(String  p, DTOCasingStyle casingStyle)
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
       markRecordtypeAsDirty(!equalsObject(recordtype, p));
       recordtype = p;
    }

    // recordnumber getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRecordnumberDirty()  { return checkFieldDirtiness(RECORDNUMBER_DIRTYGROUP, RECORDNUMBER_DIRTYMASK); }

    public java.lang.Integer   getRecordnumber() { return recordnumber; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "recordnumber")
    public String getRecordnumberAsString() { return integerAsString(recordnumber); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getRecordnumberAsInt()    { return recordnumber != null ? recordnumber.intValue() : 0; }

    // recordnumber setter methods.
    
    protected void markRecordnumberAsDirty(boolean aFlag)  { markFieldAsDirty(RECORDNUMBER_DIRTYGROUP, RECORDNUMBER_DIRTYMASK, aFlag); }


    public void setRecordnumber(java.lang.Integer  p)
    {
        markRecordnumberAsDirty(!equalsObject(recordnumber, p));
    	recordnumber = p;
    }
    public void setRecordnumber(int p)
    {
    	setRecordnumber(new java.lang.Integer(p));
    }
    public void setRecordnumber()
    {
    	setRecordnumber(0);
    }
    public void setRecordnumber(String  p)
    {
    	setRecordnumber(stringAsInteger(p));
    }

    // col1 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCol1Dirty()  { return checkFieldDirtiness(COL1_DIRTYGROUP, COL1_DIRTYMASK); }

    public java.lang.String   getCol1()         { return col1; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "col1")
    public java.lang.String   getCol1AsString() { return (col1 == null) ? "" : col1; }

    // col1 setter methods.
    
    protected void markCol1AsDirty(boolean aFlag)  { markFieldAsDirty(COL1_DIRTYGROUP, COL1_DIRTYMASK, aFlag); }


    public void setCol1(String  p)
    {
       setCol1(p, DTOCasingStyle.none);
    }
    
    public void setCol1(String  p, DTOCasingStyle casingStyle)
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
       markCol1AsDirty(!equalsObject(col1, p));
       col1 = p;
    }

    // col2 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCol2Dirty()  { return checkFieldDirtiness(COL2_DIRTYGROUP, COL2_DIRTYMASK); }

    public java.lang.String   getCol2()         { return col2; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "col2")
    public java.lang.String   getCol2AsString() { return (col2 == null) ? "" : col2; }

    // col2 setter methods.
    
    protected void markCol2AsDirty(boolean aFlag)  { markFieldAsDirty(COL2_DIRTYGROUP, COL2_DIRTYMASK, aFlag); }


    public void setCol2(String  p)
    {
       setCol2(p, DTOCasingStyle.none);
    }
    
    public void setCol2(String  p, DTOCasingStyle casingStyle)
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
       markCol2AsDirty(!equalsObject(col2, p));
       col2 = p;
    }

    // col3 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCol3Dirty()  { return checkFieldDirtiness(COL3_DIRTYGROUP, COL3_DIRTYMASK); }

    public java.lang.String   getCol3()         { return col3; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "col3")
    public java.lang.String   getCol3AsString() { return (col3 == null) ? "" : col3; }

    // col3 setter methods.
    
    protected void markCol3AsDirty(boolean aFlag)  { markFieldAsDirty(COL3_DIRTYGROUP, COL3_DIRTYMASK, aFlag); }


    public void setCol3(String  p)
    {
       setCol3(p, DTOCasingStyle.none);
    }
    
    public void setCol3(String  p, DTOCasingStyle casingStyle)
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
       markCol3AsDirty(!equalsObject(col3, p));
       col3 = p;
    }

    // col4 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCol4Dirty()  { return checkFieldDirtiness(COL4_DIRTYGROUP, COL4_DIRTYMASK); }

    public java.lang.String   getCol4()         { return col4; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "col4")
    public java.lang.String   getCol4AsString() { return (col4 == null) ? "" : col4; }

    // col4 setter methods.
    
    protected void markCol4AsDirty(boolean aFlag)  { markFieldAsDirty(COL4_DIRTYGROUP, COL4_DIRTYMASK, aFlag); }


    public void setCol4(String  p)
    {
       setCol4(p, DTOCasingStyle.none);
    }
    
    public void setCol4(String  p, DTOCasingStyle casingStyle)
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
       markCol4AsDirty(!equalsObject(col4, p));
       col4 = p;
    }

    // col5 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCol5Dirty()  { return checkFieldDirtiness(COL5_DIRTYGROUP, COL5_DIRTYMASK); }

    public java.lang.String   getCol5()         { return col5; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "col5")
    public java.lang.String   getCol5AsString() { return (col5 == null) ? "" : col5; }

    // col5 setter methods.
    
    protected void markCol5AsDirty(boolean aFlag)  { markFieldAsDirty(COL5_DIRTYGROUP, COL5_DIRTYMASK, aFlag); }


    public void setCol5(String  p)
    {
       setCol5(p, DTOCasingStyle.none);
    }
    
    public void setCol5(String  p, DTOCasingStyle casingStyle)
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
       markCol5AsDirty(!equalsObject(col5, p));
       col5 = p;
    }

    // col6 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCol6Dirty()  { return checkFieldDirtiness(COL6_DIRTYGROUP, COL6_DIRTYMASK); }

    public java.lang.String   getCol6()         { return col6; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "col6")
    public java.lang.String   getCol6AsString() { return (col6 == null) ? "" : col6; }

    // col6 setter methods.
    
    protected void markCol6AsDirty(boolean aFlag)  { markFieldAsDirty(COL6_DIRTYGROUP, COL6_DIRTYMASK, aFlag); }


    public void setCol6(String  p)
    {
       setCol6(p, DTOCasingStyle.none);
    }
    
    public void setCol6(String  p, DTOCasingStyle casingStyle)
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
       markCol6AsDirty(!equalsObject(col6, p));
       col6 = p;
    }

    // col7 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCol7Dirty()  { return checkFieldDirtiness(COL7_DIRTYGROUP, COL7_DIRTYMASK); }

    public java.lang.String   getCol7()         { return col7; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "col7")
    public java.lang.String   getCol7AsString() { return (col7 == null) ? "" : col7; }

    // col7 setter methods.
    
    protected void markCol7AsDirty(boolean aFlag)  { markFieldAsDirty(COL7_DIRTYGROUP, COL7_DIRTYMASK, aFlag); }


    public void setCol7(String  p)
    {
       setCol7(p, DTOCasingStyle.none);
    }
    
    public void setCol7(String  p, DTOCasingStyle casingStyle)
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
       markCol7AsDirty(!equalsObject(col7, p));
       col7 = p;
    }

    // col8 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCol8Dirty()  { return checkFieldDirtiness(COL8_DIRTYGROUP, COL8_DIRTYMASK); }

    public java.lang.String   getCol8()         { return col8; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "col8")
    public java.lang.String   getCol8AsString() { return (col8 == null) ? "" : col8; }

    // col8 setter methods.
    
    protected void markCol8AsDirty(boolean aFlag)  { markFieldAsDirty(COL8_DIRTYGROUP, COL8_DIRTYMASK, aFlag); }


    public void setCol8(String  p)
    {
       setCol8(p, DTOCasingStyle.none);
    }
    
    public void setCol8(String  p, DTOCasingStyle casingStyle)
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
       markCol8AsDirty(!equalsObject(col8, p));
       col8 = p;
    }

    // col9 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCol9Dirty()  { return checkFieldDirtiness(COL9_DIRTYGROUP, COL9_DIRTYMASK); }

    public java.lang.String   getCol9()         { return col9; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "col9")
    public java.lang.String   getCol9AsString() { return (col9 == null) ? "" : col9; }

    // col9 setter methods.
    
    protected void markCol9AsDirty(boolean aFlag)  { markFieldAsDirty(COL9_DIRTYGROUP, COL9_DIRTYMASK, aFlag); }


    public void setCol9(String  p)
    {
       setCol9(p, DTOCasingStyle.none);
    }
    
    public void setCol9(String  p, DTOCasingStyle casingStyle)
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
       markCol9AsDirty(!equalsObject(col9, p));
       col9 = p;
    }

    // cola getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isColaDirty()  { return checkFieldDirtiness(COLA_DIRTYGROUP, COLA_DIRTYMASK); }

    public java.lang.String   getCola()         { return cola; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "cola")
    public java.lang.String   getColaAsString() { return (cola == null) ? "" : cola; }

    // cola setter methods.
    
    protected void markColaAsDirty(boolean aFlag)  { markFieldAsDirty(COLA_DIRTYGROUP, COLA_DIRTYMASK, aFlag); }


    public void setCola(String  p)
    {
       setCola(p, DTOCasingStyle.none);
    }
    
    public void setCola(String  p, DTOCasingStyle casingStyle)
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
       markColaAsDirty(!equalsObject(cola, p));
       cola = p;
    }

    // colb getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isColbDirty()  { return checkFieldDirtiness(COLB_DIRTYGROUP, COLB_DIRTYMASK); }

    public java.lang.String   getColb()         { return colb; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "colb")
    public java.lang.String   getColbAsString() { return (colb == null) ? "" : colb; }

    // colb setter methods.
    
    protected void markColbAsDirty(boolean aFlag)  { markFieldAsDirty(COLB_DIRTYGROUP, COLB_DIRTYMASK, aFlag); }


    public void setColb(String  p)
    {
       setColb(p, DTOCasingStyle.none);
    }
    
    public void setColb(String  p, DTOCasingStyle casingStyle)
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
       markColbAsDirty(!equalsObject(colb, p));
       colb = p;
    }

    // colc getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isColcDirty()  { return checkFieldDirtiness(COLC_DIRTYGROUP, COLC_DIRTYMASK); }

    public java.lang.String   getColc()         { return colc; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "colc")
    public java.lang.String   getColcAsString() { return (colc == null) ? "" : colc; }

    // colc setter methods.
    
    protected void markColcAsDirty(boolean aFlag)  { markFieldAsDirty(COLC_DIRTYGROUP, COLC_DIRTYMASK, aFlag); }


    public void setColc(String  p)
    {
       setColc(p, DTOCasingStyle.none);
    }
    
    public void setColc(String  p, DTOCasingStyle casingStyle)
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
       markColcAsDirty(!equalsObject(colc, p));
       colc = p;
    }

    // cold getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isColdDirty()  { return checkFieldDirtiness(COLD_DIRTYGROUP, COLD_DIRTYMASK); }

    public java.lang.String   getCold()         { return cold; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "cold")
    public java.lang.String   getColdAsString() { return (cold == null) ? "" : cold; }

    // cold setter methods.
    
    protected void markColdAsDirty(boolean aFlag)  { markFieldAsDirty(COLD_DIRTYGROUP, COLD_DIRTYMASK, aFlag); }


    public void setCold(String  p)
    {
       setCold(p, DTOCasingStyle.none);
    }
    
    public void setCold(String  p, DTOCasingStyle casingStyle)
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
       markColdAsDirty(!equalsObject(cold, p));
       cold = p;
    }

    // cole getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isColeDirty()  { return checkFieldDirtiness(COLE_DIRTYGROUP, COLE_DIRTYMASK); }

    public java.lang.String   getCole()         { return cole; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "cole")
    public java.lang.String   getColeAsString() { return (cole == null) ? "" : cole; }

    // cole setter methods.
    
    protected void markColeAsDirty(boolean aFlag)  { markFieldAsDirty(COLE_DIRTYGROUP, COLE_DIRTYMASK, aFlag); }


    public void setCole(String  p)
    {
       setCole(p, DTOCasingStyle.none);
    }
    
    public void setCole(String  p, DTOCasingStyle casingStyle)
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
       markColeAsDirty(!equalsObject(cole, p));
       cole = p;
    }

    // colf getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isColfDirty()  { return checkFieldDirtiness(COLF_DIRTYGROUP, COLF_DIRTYMASK); }

    public java.lang.String   getColf()         { return colf; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "colf")
    public java.lang.String   getColfAsString() { return (colf == null) ? "" : colf; }

    // colf setter methods.
    
    protected void markColfAsDirty(boolean aFlag)  { markFieldAsDirty(COLF_DIRTYGROUP, COLF_DIRTYMASK, aFlag); }


    public void setColf(String  p)
    {
       setColf(p, DTOCasingStyle.none);
    }
    
    public void setColf(String  p, DTOCasingStyle casingStyle)
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
       markColfAsDirty(!equalsObject(colf, p));
       colf = p;
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
