//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.wbs.wbsnode;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "WBSNodeDTOBase")
public class WBSNodeDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  wbsnodeid;
    protected java.lang.String  site;
    protected java.lang.String  wbsid;
    protected java.lang.String  nodetype;
    protected java.lang.Integer  nodeorder;
    protected java.lang.String  nodesect;
    protected java.lang.String  nodename;
    protected java.lang.String  nodesummary;
    protected java.lang.String  nodetext;
    protected java.lang.String  nodeparentid;
    protected java.lang.String  nodepath;
    protected java.lang.String  assignedto;
    protected java.lang.Integer  duration;
    protected java.sql.Date  startdate;
    protected java.sql.Date  enddate;
    protected java.lang.String  completiontype;
    protected java.lang.String  completionstatus;
    protected java.lang.String  completiondescr;
    protected java.lang.Float  completion;
    protected java.lang.Float  completionfrom;
    protected java.lang.Float  completionto;
    protected java.sql.Timestamp  completiondate;
    protected java.lang.Integer  completioneffort;
    protected java.lang.String  completioneffunit;
    protected java.lang.Float  economicvalue;
    protected java.lang.Float  economicvalue2;
    protected java.lang.Float  economicvalue3;
    protected java.lang.String  remarks;
    protected java.lang.String  stereotype;
    protected java.lang.String  recstatus;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String WBSNODEID_DEFAULT  =  null;
    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String WBSID_DEFAULT  =  null;
    public static final java.lang.String NODETYPE_DEFAULT  =  null;
    public static final java.lang.Integer NODEORDER_DEFAULT  =  null;
    public static final java.lang.String NODESECT_DEFAULT  =  null;
    public static final java.lang.String NODENAME_DEFAULT  =  null;
    public static final java.lang.String NODESUMMARY_DEFAULT  =  null;
    public static final java.lang.String NODETEXT_DEFAULT  =  null;
    public static final java.lang.String NODEPARENTID_DEFAULT  =  null;
    public static final java.lang.String NODEPATH_DEFAULT  =  null;
    public static final java.lang.String ASSIGNEDTO_DEFAULT  =  null;
    public static final java.lang.Integer DURATION_DEFAULT  =  null;
    public static final java.sql.Date STARTDATE_DEFAULT  =  null;
    public static final java.sql.Date ENDDATE_DEFAULT  =  null;
    public static final java.lang.String COMPLETIONTYPE_DEFAULT  =  null;
    public static final java.lang.String COMPLETIONSTATUS_DEFAULT  =  null;
    public static final java.lang.String COMPLETIONDESCR_DEFAULT  =  null;
    public static final java.lang.Float COMPLETION_DEFAULT  =  null;
    public static final java.lang.Float COMPLETIONFROM_DEFAULT  =  null;
    public static final java.lang.Float COMPLETIONTO_DEFAULT  =  null;
    public static final java.sql.Timestamp COMPLETIONDATE_DEFAULT  =  null;
    public static final java.lang.Integer COMPLETIONEFFORT_DEFAULT  =  null;
    public static final java.lang.String COMPLETIONEFFUNIT_DEFAULT  =  null;
    public static final java.lang.Float ECONOMICVALUE_DEFAULT  =  null;
    public static final java.lang.Float ECONOMICVALUE2_DEFAULT  =  null;
    public static final java.lang.Float ECONOMICVALUE3_DEFAULT  =  null;
    public static final java.lang.String REMARKS_DEFAULT  =  null;
    public static final java.lang.String STEREOTYPE_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int WBSNODEID_DIRTYGROUP  =  0;
    public static final int WBSNODEID_DIRTYMASK   =  1;
    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  2;
    public static final int WBSID_DIRTYGROUP  =  0;
    public static final int WBSID_DIRTYMASK   =  4;
    public static final int NODETYPE_DIRTYGROUP  =  0;
    public static final int NODETYPE_DIRTYMASK   =  8;
    public static final int NODEORDER_DIRTYGROUP  =  0;
    public static final int NODEORDER_DIRTYMASK   =  16;
    public static final int NODESECT_DIRTYGROUP  =  0;
    public static final int NODESECT_DIRTYMASK   =  32;
    public static final int NODENAME_DIRTYGROUP  =  0;
    public static final int NODENAME_DIRTYMASK   =  64;
    public static final int NODESUMMARY_DIRTYGROUP  =  0;
    public static final int NODESUMMARY_DIRTYMASK   =  128;
    public static final int NODETEXT_DIRTYGROUP  =  0;
    public static final int NODETEXT_DIRTYMASK   =  256;
    public static final int NODEPARENTID_DIRTYGROUP  =  0;
    public static final int NODEPARENTID_DIRTYMASK   =  512;
    public static final int NODEPATH_DIRTYGROUP  =  0;
    public static final int NODEPATH_DIRTYMASK   =  1024;
    public static final int ASSIGNEDTO_DIRTYGROUP  =  0;
    public static final int ASSIGNEDTO_DIRTYMASK   =  2048;
    public static final int DURATION_DIRTYGROUP  =  0;
    public static final int DURATION_DIRTYMASK   =  4096;
    public static final int STARTDATE_DIRTYGROUP  =  0;
    public static final int STARTDATE_DIRTYMASK   =  8192;
    public static final int ENDDATE_DIRTYGROUP  =  0;
    public static final int ENDDATE_DIRTYMASK   =  16384;
    public static final int COMPLETIONTYPE_DIRTYGROUP  =  0;
    public static final int COMPLETIONTYPE_DIRTYMASK   =  32768;
    public static final int COMPLETIONSTATUS_DIRTYGROUP  =  0;
    public static final int COMPLETIONSTATUS_DIRTYMASK   =  65536;
    public static final int COMPLETIONDESCR_DIRTYGROUP  =  0;
    public static final int COMPLETIONDESCR_DIRTYMASK   =  131072;
    public static final int COMPLETION_DIRTYGROUP  =  0;
    public static final int COMPLETION_DIRTYMASK   =  262144;
    public static final int COMPLETIONFROM_DIRTYGROUP  =  0;
    public static final int COMPLETIONFROM_DIRTYMASK   =  524288;
    public static final int COMPLETIONTO_DIRTYGROUP  =  0;
    public static final int COMPLETIONTO_DIRTYMASK   =  1048576;
    public static final int COMPLETIONDATE_DIRTYGROUP  =  0;
    public static final int COMPLETIONDATE_DIRTYMASK   =  2097152;
    public static final int COMPLETIONEFFORT_DIRTYGROUP  =  0;
    public static final int COMPLETIONEFFORT_DIRTYMASK   =  4194304;
    public static final int COMPLETIONEFFUNIT_DIRTYGROUP  =  0;
    public static final int COMPLETIONEFFUNIT_DIRTYMASK   =  8388608;
    public static final int ECONOMICVALUE_DIRTYGROUP  =  0;
    public static final int ECONOMICVALUE_DIRTYMASK   =  16777216;
    public static final int ECONOMICVALUE2_DIRTYGROUP  =  0;
    public static final int ECONOMICVALUE2_DIRTYMASK   =  33554432;
    public static final int ECONOMICVALUE3_DIRTYGROUP  =  0;
    public static final int ECONOMICVALUE3_DIRTYMASK   =  67108864;
    public static final int REMARKS_DIRTYGROUP  =  0;
    public static final int REMARKS_DIRTYMASK   =  134217728;
    public static final int STEREOTYPE_DIRTYGROUP  =  0;
    public static final int STEREOTYPE_DIRTYMASK   =  268435456;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  536870912;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  1;
    public static final int RECTIMESTAMP_DIRTYMASK   =  1;


    /**
      * DataBean constructor.
      */
    public WBSNodeDTOBase()
    {
       dirtyFlagsArray = new int[31 / 30 + 1];
       clearDirtyFlags();

       wbsnodeid = WBSNODEID_DEFAULT;
       site = SITE_DEFAULT;
       wbsid = WBSID_DEFAULT;
       nodetype = NODETYPE_DEFAULT;
       nodeorder = NODEORDER_DEFAULT;
       nodesect = NODESECT_DEFAULT;
       nodename = NODENAME_DEFAULT;
       nodesummary = NODESUMMARY_DEFAULT;
       nodetext = NODETEXT_DEFAULT;
       nodeparentid = NODEPARENTID_DEFAULT;
       nodepath = NODEPATH_DEFAULT;
       assignedto = ASSIGNEDTO_DEFAULT;
       duration = DURATION_DEFAULT;
       startdate = STARTDATE_DEFAULT;
       enddate = ENDDATE_DEFAULT;
       completiontype = COMPLETIONTYPE_DEFAULT;
       completionstatus = COMPLETIONSTATUS_DEFAULT;
       completiondescr = COMPLETIONDESCR_DEFAULT;
       completion = COMPLETION_DEFAULT;
       completionfrom = COMPLETIONFROM_DEFAULT;
       completionto = COMPLETIONTO_DEFAULT;
       completiondate = COMPLETIONDATE_DEFAULT;
       completioneffort = COMPLETIONEFFORT_DEFAULT;
       completioneffunit = COMPLETIONEFFUNIT_DEFAULT;
       economicvalue = ECONOMICVALUE_DEFAULT;
       economicvalue2 = ECONOMICVALUE2_DEFAULT;
       economicvalue3 = ECONOMICVALUE3_DEFAULT;
       remarks = REMARKS_DEFAULT;
       stereotype = STEREOTYPE_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public WBSNodeDTOBase(WBSNodeDTOBase another)
    {

       wbsnodeid = another.getWbsnodeid();
       site = another.getSite();
       wbsid = another.getWbsid();
       nodetype = another.getNodetype();
       nodeorder = another.getNodeorder();
       nodesect = another.getNodesect();
       nodename = another.getNodename();
       nodesummary = another.getNodesummary();
       nodetext = another.getNodetext();
       nodeparentid = another.getNodeparentid();
       nodepath = another.getNodepath();
       assignedto = another.getAssignedto();
       duration = another.getDuration();
       startdate = another.getStartdate();
       enddate = another.getEnddate();
       completiontype = another.getCompletiontype();
       completionstatus = another.getCompletionstatus();
       completiondescr = another.getCompletiondescr();
       completion = another.getCompletion();
       completionfrom = another.getCompletionfrom();
       completionto = another.getCompletionto();
       completiondate = another.getCompletiondate();
       completioneffort = another.getCompletioneffort();
       completioneffunit = another.getCompletioneffunit();
       economicvalue = another.getEconomicvalue();
       economicvalue2 = another.getEconomicvalue2();
       economicvalue3 = another.getEconomicvalue3();
       remarks = another.getRemarks();
       stereotype = another.getStereotype();
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
        stb.append(wbsnodeid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (nodename != null)
        {
        stb.append(nodename);
        notNull = true;        
        }
        if (notNull)
            return stb.toString();
            
        return null;
    }

    /**
      * DataBean Getter And Setter Accessor
      */

    // wbsnodeid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isWbsnodeidDirty()  { return checkFieldDirtiness(WBSNODEID_DIRTYGROUP, WBSNODEID_DIRTYMASK); }

    public java.lang.String   getWbsnodeid()         { return wbsnodeid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "wbsnodeid")
    public java.lang.String   getWbsnodeidAsString() { return (wbsnodeid == null) ? "" : wbsnodeid; }

    // wbsnodeid setter methods.
    
    protected void markWbsnodeidAsDirty(boolean aFlag)  { markFieldAsDirty(WBSNODEID_DIRTYGROUP, WBSNODEID_DIRTYMASK, aFlag); }


    public void setWbsnodeid(String  p)
    {
       setWbsnodeid(p, DTOCasingStyle.none);
    }
    
    public void setWbsnodeid(String  p, DTOCasingStyle casingStyle)
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
       markWbsnodeidAsDirty(!equalsObject(wbsnodeid, p));
       wbsnodeid = p;
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

    // wbsid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isWbsidDirty()  { return checkFieldDirtiness(WBSID_DIRTYGROUP, WBSID_DIRTYMASK); }

    public java.lang.String   getWbsid()         { return wbsid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "wbsid")
    public java.lang.String   getWbsidAsString() { return (wbsid == null) ? "" : wbsid; }

    // wbsid setter methods.
    
    protected void markWbsidAsDirty(boolean aFlag)  { markFieldAsDirty(WBSID_DIRTYGROUP, WBSID_DIRTYMASK, aFlag); }


    public void setWbsid(String  p)
    {
       setWbsid(p, DTOCasingStyle.none);
    }
    
    public void setWbsid(String  p, DTOCasingStyle casingStyle)
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
       markWbsidAsDirty(!equalsObject(wbsid, p));
       wbsid = p;
    }

    // nodetype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNodetypeDirty()  { return checkFieldDirtiness(NODETYPE_DIRTYGROUP, NODETYPE_DIRTYMASK); }

    public java.lang.String   getNodetype()         { return nodetype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "nodetype")
    public java.lang.String   getNodetypeAsString() { return (nodetype == null) ? "" : nodetype; }

    // nodetype setter methods.
    
    protected void markNodetypeAsDirty(boolean aFlag)  { markFieldAsDirty(NODETYPE_DIRTYGROUP, NODETYPE_DIRTYMASK, aFlag); }


    public void setNodetype(String  p)
    {
       setNodetype(p, DTOCasingStyle.none);
    }
    
    public void setNodetype(String  p, DTOCasingStyle casingStyle)
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
       markNodetypeAsDirty(!equalsObject(nodetype, p));
       nodetype = p;
    }

    // nodeorder getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNodeorderDirty()  { return checkFieldDirtiness(NODEORDER_DIRTYGROUP, NODEORDER_DIRTYMASK); }

    public java.lang.Integer   getNodeorder() { return nodeorder; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "nodeorder")
    public String getNodeorderAsString() { return integerAsString(nodeorder); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getNodeorderAsInt()    { return nodeorder != null ? nodeorder.intValue() : 0; }

    // nodeorder setter methods.
    
    protected void markNodeorderAsDirty(boolean aFlag)  { markFieldAsDirty(NODEORDER_DIRTYGROUP, NODEORDER_DIRTYMASK, aFlag); }


    public void setNodeorder(java.lang.Integer  p)
    {
        markNodeorderAsDirty(!equalsObject(nodeorder, p));
    	nodeorder = p;
    }
    public void setNodeorder(int p)
    {
    	setNodeorder(new java.lang.Integer(p));
    }
    public void setNodeorder()
    {
    	setNodeorder(0);
    }
    public void setNodeorder(String  p)
    {
    	setNodeorder(stringAsInteger(p));
    }

    // nodesect getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNodesectDirty()  { return checkFieldDirtiness(NODESECT_DIRTYGROUP, NODESECT_DIRTYMASK); }

    public java.lang.String   getNodesect()         { return nodesect; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "nodesect")
    public java.lang.String   getNodesectAsString() { return (nodesect == null) ? "" : nodesect; }

    // nodesect setter methods.
    
    protected void markNodesectAsDirty(boolean aFlag)  { markFieldAsDirty(NODESECT_DIRTYGROUP, NODESECT_DIRTYMASK, aFlag); }


    public void setNodesect(String  p)
    {
       setNodesect(p, DTOCasingStyle.none);
    }
    
    public void setNodesect(String  p, DTOCasingStyle casingStyle)
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
       markNodesectAsDirty(!equalsObject(nodesect, p));
       nodesect = p;
    }

    // nodename getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNodenameDirty()  { return checkFieldDirtiness(NODENAME_DIRTYGROUP, NODENAME_DIRTYMASK); }

    public java.lang.String   getNodename()         { return nodename; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "nodename")
    public java.lang.String   getNodenameAsString() { return (nodename == null) ? "" : nodename; }

    // nodename setter methods.
    
    protected void markNodenameAsDirty(boolean aFlag)  { markFieldAsDirty(NODENAME_DIRTYGROUP, NODENAME_DIRTYMASK, aFlag); }


    public void setNodename(String  p)
    {
       setNodename(p, DTOCasingStyle.none);
    }
    
    public void setNodename(String  p, DTOCasingStyle casingStyle)
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
       markNodenameAsDirty(!equalsObject(nodename, p));
       nodename = p;
    }

    // nodesummary getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNodesummaryDirty()  { return checkFieldDirtiness(NODESUMMARY_DIRTYGROUP, NODESUMMARY_DIRTYMASK); }

    public java.lang.String   getNodesummary()         { return nodesummary; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "nodesummary")
    public java.lang.String   getNodesummaryAsString() { return (nodesummary == null) ? "" : nodesummary; }

    // nodesummary setter methods.
    
    protected void markNodesummaryAsDirty(boolean aFlag)  { markFieldAsDirty(NODESUMMARY_DIRTYGROUP, NODESUMMARY_DIRTYMASK, aFlag); }


    public void setNodesummary(String  p)
    {
       setNodesummary(p, DTOCasingStyle.none);
    }
    
    public void setNodesummary(String  p, DTOCasingStyle casingStyle)
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
       markNodesummaryAsDirty(!equalsObject(nodesummary, p));
       nodesummary = p;
    }

    // nodetext getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNodetextDirty()  { return checkFieldDirtiness(NODETEXT_DIRTYGROUP, NODETEXT_DIRTYMASK); }

    public java.lang.String   getNodetext()         { return nodetext; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "nodetext")
    public java.lang.String   getNodetextAsString() { return (nodetext == null) ? "" : nodetext; }

    // nodetext setter methods.
    
    protected void markNodetextAsDirty(boolean aFlag)  { markFieldAsDirty(NODETEXT_DIRTYGROUP, NODETEXT_DIRTYMASK, aFlag); }


    public void setNodetext(String  p)
    {
       setNodetext(p, DTOCasingStyle.none);
    }
    
    public void setNodetext(String  p, DTOCasingStyle casingStyle)
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
       markNodetextAsDirty(!equalsObject(nodetext, p));
       nodetext = p;
    }

    // nodeparentid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNodeparentidDirty()  { return checkFieldDirtiness(NODEPARENTID_DIRTYGROUP, NODEPARENTID_DIRTYMASK); }

    public java.lang.String   getNodeparentid()         { return nodeparentid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "nodeparentid")
    public java.lang.String   getNodeparentidAsString() { return (nodeparentid == null) ? "" : nodeparentid; }

    // nodeparentid setter methods.
    
    protected void markNodeparentidAsDirty(boolean aFlag)  { markFieldAsDirty(NODEPARENTID_DIRTYGROUP, NODEPARENTID_DIRTYMASK, aFlag); }


    public void setNodeparentid(String  p)
    {
       setNodeparentid(p, DTOCasingStyle.none);
    }
    
    public void setNodeparentid(String  p, DTOCasingStyle casingStyle)
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
       markNodeparentidAsDirty(!equalsObject(nodeparentid, p));
       nodeparentid = p;
    }

    // nodepath getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNodepathDirty()  { return checkFieldDirtiness(NODEPATH_DIRTYGROUP, NODEPATH_DIRTYMASK); }

    public java.lang.String   getNodepath()         { return nodepath; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "nodepath")
    public java.lang.String   getNodepathAsString() { return (nodepath == null) ? "" : nodepath; }

    // nodepath setter methods.
    
    protected void markNodepathAsDirty(boolean aFlag)  { markFieldAsDirty(NODEPATH_DIRTYGROUP, NODEPATH_DIRTYMASK, aFlag); }


    public void setNodepath(String  p)
    {
       setNodepath(p, DTOCasingStyle.none);
    }
    
    public void setNodepath(String  p, DTOCasingStyle casingStyle)
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
       markNodepathAsDirty(!equalsObject(nodepath, p));
       nodepath = p;
    }

    // assignedto getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isAssignedtoDirty()  { return checkFieldDirtiness(ASSIGNEDTO_DIRTYGROUP, ASSIGNEDTO_DIRTYMASK); }

    public java.lang.String   getAssignedto()         { return assignedto; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "assignedto")
    public java.lang.String   getAssignedtoAsString() { return (assignedto == null) ? "" : assignedto; }

    // assignedto setter methods.
    
    protected void markAssignedtoAsDirty(boolean aFlag)  { markFieldAsDirty(ASSIGNEDTO_DIRTYGROUP, ASSIGNEDTO_DIRTYMASK, aFlag); }


    public void setAssignedto(String  p)
    {
       setAssignedto(p, DTOCasingStyle.none);
    }
    
    public void setAssignedto(String  p, DTOCasingStyle casingStyle)
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
       markAssignedtoAsDirty(!equalsObject(assignedto, p));
       assignedto = p;
    }

    // duration getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isDurationDirty()  { return checkFieldDirtiness(DURATION_DIRTYGROUP, DURATION_DIRTYMASK); }

    public java.lang.Integer   getDuration() { return duration; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "duration")
    public String getDurationAsString() { return integerAsString(duration); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getDurationAsInt()    { return duration != null ? duration.intValue() : 0; }

    // duration setter methods.
    
    protected void markDurationAsDirty(boolean aFlag)  { markFieldAsDirty(DURATION_DIRTYGROUP, DURATION_DIRTYMASK, aFlag); }


    public void setDuration(java.lang.Integer  p)
    {
        markDurationAsDirty(!equalsObject(duration, p));
    	duration = p;
    }
    public void setDuration(int p)
    {
    	setDuration(new java.lang.Integer(p));
    }
    public void setDuration()
    {
    	setDuration(0);
    }
    public void setDuration(String  p)
    {
    	setDuration(stringAsInteger(p));
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

    // completiontype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCompletiontypeDirty()  { return checkFieldDirtiness(COMPLETIONTYPE_DIRTYGROUP, COMPLETIONTYPE_DIRTYMASK); }

    public java.lang.String   getCompletiontype()         { return completiontype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "completiontype")
    public java.lang.String   getCompletiontypeAsString() { return (completiontype == null) ? "" : completiontype; }

    // completiontype setter methods.
    
    protected void markCompletiontypeAsDirty(boolean aFlag)  { markFieldAsDirty(COMPLETIONTYPE_DIRTYGROUP, COMPLETIONTYPE_DIRTYMASK, aFlag); }


    public void setCompletiontype(String  p)
    {
       setCompletiontype(p, DTOCasingStyle.none);
    }
    
    public void setCompletiontype(String  p, DTOCasingStyle casingStyle)
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
       markCompletiontypeAsDirty(!equalsObject(completiontype, p));
       completiontype = p;
    }

    // completionstatus getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCompletionstatusDirty()  { return checkFieldDirtiness(COMPLETIONSTATUS_DIRTYGROUP, COMPLETIONSTATUS_DIRTYMASK); }

    public java.lang.String   getCompletionstatus()         { return completionstatus; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "completionstatus")
    public java.lang.String   getCompletionstatusAsString() { return (completionstatus == null) ? "" : completionstatus; }

    // completionstatus setter methods.
    
    protected void markCompletionstatusAsDirty(boolean aFlag)  { markFieldAsDirty(COMPLETIONSTATUS_DIRTYGROUP, COMPLETIONSTATUS_DIRTYMASK, aFlag); }


    public void setCompletionstatus(String  p)
    {
       setCompletionstatus(p, DTOCasingStyle.none);
    }
    
    public void setCompletionstatus(String  p, DTOCasingStyle casingStyle)
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
       markCompletionstatusAsDirty(!equalsObject(completionstatus, p));
       completionstatus = p;
    }

    // completiondescr getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCompletiondescrDirty()  { return checkFieldDirtiness(COMPLETIONDESCR_DIRTYGROUP, COMPLETIONDESCR_DIRTYMASK); }

    public java.lang.String   getCompletiondescr()         { return completiondescr; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "completiondescr")
    public java.lang.String   getCompletiondescrAsString() { return (completiondescr == null) ? "" : completiondescr; }

    // completiondescr setter methods.
    
    protected void markCompletiondescrAsDirty(boolean aFlag)  { markFieldAsDirty(COMPLETIONDESCR_DIRTYGROUP, COMPLETIONDESCR_DIRTYMASK, aFlag); }


    public void setCompletiondescr(String  p)
    {
       setCompletiondescr(p, DTOCasingStyle.none);
    }
    
    public void setCompletiondescr(String  p, DTOCasingStyle casingStyle)
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
       markCompletiondescrAsDirty(!equalsObject(completiondescr, p));
       completiondescr = p;
    }

    // completion getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCompletionDirty()  { return checkFieldDirtiness(COMPLETION_DIRTYGROUP, COMPLETION_DIRTYMASK); }

    public java.lang.Float   getCompletion() { return completion; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "completion")
    public String getCompletionAsString() { return floatAsString(completion); }

    // completion setter methods.
    
    protected void markCompletionAsDirty(boolean aFlag)  { markFieldAsDirty(COMPLETION_DIRTYGROUP, COMPLETION_DIRTYMASK, aFlag); }


    public void setCompletion(java.lang.Float  p)
    {
    	markCompletionAsDirty(!equalsObject(completion, p));
    	completion = p;
    }
    public void setCompletion()
    {
    	setCompletion((java.lang.Float)null);
    }
    public void setCompletion(String  p)
    {
    	setCompletion(stringAsFloat(p));
    }

    // completionfrom getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCompletionfromDirty()  { return checkFieldDirtiness(COMPLETIONFROM_DIRTYGROUP, COMPLETIONFROM_DIRTYMASK); }

    public java.lang.Float   getCompletionfrom() { return completionfrom; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "completionfrom")
    public String getCompletionfromAsString() { return floatAsString(completionfrom); }

    // completionfrom setter methods.
    
    protected void markCompletionfromAsDirty(boolean aFlag)  { markFieldAsDirty(COMPLETIONFROM_DIRTYGROUP, COMPLETIONFROM_DIRTYMASK, aFlag); }


    public void setCompletionfrom(java.lang.Float  p)
    {
    	markCompletionfromAsDirty(!equalsObject(completionfrom, p));
    	completionfrom = p;
    }
    public void setCompletionfrom()
    {
    	setCompletionfrom((java.lang.Float)null);
    }
    public void setCompletionfrom(String  p)
    {
    	setCompletionfrom(stringAsFloat(p));
    }

    // completionto getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCompletiontoDirty()  { return checkFieldDirtiness(COMPLETIONTO_DIRTYGROUP, COMPLETIONTO_DIRTYMASK); }

    public java.lang.Float   getCompletionto() { return completionto; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "completionto")
    public String getCompletiontoAsString() { return floatAsString(completionto); }

    // completionto setter methods.
    
    protected void markCompletiontoAsDirty(boolean aFlag)  { markFieldAsDirty(COMPLETIONTO_DIRTYGROUP, COMPLETIONTO_DIRTYMASK, aFlag); }


    public void setCompletionto(java.lang.Float  p)
    {
    	markCompletiontoAsDirty(!equalsObject(completionto, p));
    	completionto = p;
    }
    public void setCompletionto()
    {
    	setCompletionto((java.lang.Float)null);
    }
    public void setCompletionto(String  p)
    {
    	setCompletionto(stringAsFloat(p));
    }

    // completiondate getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCompletiondateDirty()  { return checkFieldDirtiness(COMPLETIONDATE_DIRTYGROUP, COMPLETIONDATE_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getCompletiondate() { return completiondate; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "completiondate")
    public String getCompletiondateAsString() { return timestampAsString(completiondate, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getCompletiondateAsString(java.text.DateFormat aDateFormat) { return timestampAsString(completiondate, aDateFormat); }

    // completiondate setter methods.
    
    protected void markCompletiondateAsDirty(boolean aFlag)  { markFieldAsDirty(COMPLETIONDATE_DIRTYGROUP, COMPLETIONDATE_DIRTYMASK, aFlag); }


    public void setCompletiondate(java.sql.Timestamp  p)
    {
        markCompletiondateAsDirty(!equalsObject(completiondate, p));
    	completiondate = p;
    }
    public void setCompletiondate(String  p, java.text.DateFormat aDateFormat)
    {
    	setCompletiondate(stringAsTimestamp(p, aDateFormat));
    }

    // completioneffort getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCompletioneffortDirty()  { return checkFieldDirtiness(COMPLETIONEFFORT_DIRTYGROUP, COMPLETIONEFFORT_DIRTYMASK); }

    public java.lang.Integer   getCompletioneffort() { return completioneffort; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "completioneffort")
    public String getCompletioneffortAsString() { return integerAsString(completioneffort); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getCompletioneffortAsInt()    { return completioneffort != null ? completioneffort.intValue() : 0; }

    // completioneffort setter methods.
    
    protected void markCompletioneffortAsDirty(boolean aFlag)  { markFieldAsDirty(COMPLETIONEFFORT_DIRTYGROUP, COMPLETIONEFFORT_DIRTYMASK, aFlag); }


    public void setCompletioneffort(java.lang.Integer  p)
    {
        markCompletioneffortAsDirty(!equalsObject(completioneffort, p));
    	completioneffort = p;
    }
    public void setCompletioneffort(int p)
    {
    	setCompletioneffort(new java.lang.Integer(p));
    }
    public void setCompletioneffort()
    {
    	setCompletioneffort(0);
    }
    public void setCompletioneffort(String  p)
    {
    	setCompletioneffort(stringAsInteger(p));
    }

    // completioneffunit getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCompletioneffunitDirty()  { return checkFieldDirtiness(COMPLETIONEFFUNIT_DIRTYGROUP, COMPLETIONEFFUNIT_DIRTYMASK); }

    public java.lang.String   getCompletioneffunit()         { return completioneffunit; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "completioneffunit")
    public java.lang.String   getCompletioneffunitAsString() { return (completioneffunit == null) ? "" : completioneffunit; }

    // completioneffunit setter methods.
    
    protected void markCompletioneffunitAsDirty(boolean aFlag)  { markFieldAsDirty(COMPLETIONEFFUNIT_DIRTYGROUP, COMPLETIONEFFUNIT_DIRTYMASK, aFlag); }


    public void setCompletioneffunit(String  p)
    {
       setCompletioneffunit(p, DTOCasingStyle.none);
    }
    
    public void setCompletioneffunit(String  p, DTOCasingStyle casingStyle)
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
       markCompletioneffunitAsDirty(!equalsObject(completioneffunit, p));
       completioneffunit = p;
    }

    // economicvalue getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEconomicvalueDirty()  { return checkFieldDirtiness(ECONOMICVALUE_DIRTYGROUP, ECONOMICVALUE_DIRTYMASK); }

    public java.lang.Float   getEconomicvalue() { return economicvalue; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "economicvalue")
    public String getEconomicvalueAsString() { return floatAsString(economicvalue); }

    // economicvalue setter methods.
    
    protected void markEconomicvalueAsDirty(boolean aFlag)  { markFieldAsDirty(ECONOMICVALUE_DIRTYGROUP, ECONOMICVALUE_DIRTYMASK, aFlag); }


    public void setEconomicvalue(java.lang.Float  p)
    {
    	markEconomicvalueAsDirty(!equalsObject(economicvalue, p));
    	economicvalue = p;
    }
    public void setEconomicvalue()
    {
    	setEconomicvalue((java.lang.Float)null);
    }
    public void setEconomicvalue(String  p)
    {
    	setEconomicvalue(stringAsFloat(p));
    }

    // economicvalue2 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEconomicvalue2Dirty()  { return checkFieldDirtiness(ECONOMICVALUE2_DIRTYGROUP, ECONOMICVALUE2_DIRTYMASK); }

    public java.lang.Float   getEconomicvalue2() { return economicvalue2; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "economicvalue2")
    public String getEconomicvalue2AsString() { return floatAsString(economicvalue2); }

    // economicvalue2 setter methods.
    
    protected void markEconomicvalue2AsDirty(boolean aFlag)  { markFieldAsDirty(ECONOMICVALUE2_DIRTYGROUP, ECONOMICVALUE2_DIRTYMASK, aFlag); }


    public void setEconomicvalue2(java.lang.Float  p)
    {
    	markEconomicvalue2AsDirty(!equalsObject(economicvalue2, p));
    	economicvalue2 = p;
    }
    public void setEconomicvalue2()
    {
    	setEconomicvalue2((java.lang.Float)null);
    }
    public void setEconomicvalue2(String  p)
    {
    	setEconomicvalue2(stringAsFloat(p));
    }

    // economicvalue3 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEconomicvalue3Dirty()  { return checkFieldDirtiness(ECONOMICVALUE3_DIRTYGROUP, ECONOMICVALUE3_DIRTYMASK); }

    public java.lang.Float   getEconomicvalue3() { return economicvalue3; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "economicvalue3")
    public String getEconomicvalue3AsString() { return floatAsString(economicvalue3); }

    // economicvalue3 setter methods.
    
    protected void markEconomicvalue3AsDirty(boolean aFlag)  { markFieldAsDirty(ECONOMICVALUE3_DIRTYGROUP, ECONOMICVALUE3_DIRTYMASK, aFlag); }


    public void setEconomicvalue3(java.lang.Float  p)
    {
    	markEconomicvalue3AsDirty(!equalsObject(economicvalue3, p));
    	economicvalue3 = p;
    }
    public void setEconomicvalue3()
    {
    	setEconomicvalue3((java.lang.Float)null);
    }
    public void setEconomicvalue3(String  p)
    {
    	setEconomicvalue3(stringAsFloat(p));
    }

    // remarks getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRemarksDirty()  { return checkFieldDirtiness(REMARKS_DIRTYGROUP, REMARKS_DIRTYMASK); }

    public java.lang.String   getRemarks()         { return remarks; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "remarks")
    public java.lang.String   getRemarksAsString() { return (remarks == null) ? "" : remarks; }

    // remarks setter methods.
    
    protected void markRemarksAsDirty(boolean aFlag)  { markFieldAsDirty(REMARKS_DIRTYGROUP, REMARKS_DIRTYMASK, aFlag); }


    public void setRemarks(String  p)
    {
       setRemarks(p, DTOCasingStyle.none);
    }
    
    public void setRemarks(String  p, DTOCasingStyle casingStyle)
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
       markRemarksAsDirty(!equalsObject(remarks, p));
       remarks = p;
    }

    // stereotype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isStereotypeDirty()  { return checkFieldDirtiness(STEREOTYPE_DIRTYGROUP, STEREOTYPE_DIRTYMASK); }

    public java.lang.String   getStereotype()         { return stereotype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "stereotype")
    public java.lang.String   getStereotypeAsString() { return (stereotype == null) ? "" : stereotype; }

    // stereotype setter methods.
    
    protected void markStereotypeAsDirty(boolean aFlag)  { markFieldAsDirty(STEREOTYPE_DIRTYGROUP, STEREOTYPE_DIRTYMASK, aFlag); }


    public void setStereotype(String  p)
    {
       setStereotype(p, DTOCasingStyle.none);
    }
    
    public void setStereotype(String  p, DTOCasingStyle casingStyle)
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
       markStereotypeAsDirty(!equalsObject(stereotype, p));
       stereotype = p;
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
