//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.wbsnodeteammemberprofileview;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "WBSNodeTeamMemberProfileViewDTOBase")
public class WBSNodeTeamMemberProfileViewDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  profileid;
    protected java.lang.String  wbsnodeid;
    protected java.lang.Float  effort;
    protected java.lang.String  uniteffort;
    protected java.lang.String  recstatus;
    protected java.lang.String  site;
    protected java.lang.String  wbsid;
    protected java.lang.String  nodetype;
    protected java.lang.Integer  nodeorder;
    protected java.lang.String  nodesect;
    protected java.lang.String  nodename;
    protected java.lang.String  nodestatus;

    public static final java.lang.String PROFILEID_DEFAULT  =  null;
    public static final java.lang.String WBSNODEID_DEFAULT  =  null;
    public static final java.lang.Float EFFORT_DEFAULT  =  null;
    public static final java.lang.String UNITEFFORT_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String WBSID_DEFAULT  =  null;
    public static final java.lang.String NODETYPE_DEFAULT  =  null;
    public static final java.lang.Integer NODEORDER_DEFAULT  =  null;
    public static final java.lang.String NODESECT_DEFAULT  =  null;
    public static final java.lang.String NODENAME_DEFAULT  =  null;
    public static final java.lang.String NODESTATUS_DEFAULT  =  null;

    public static final int PROFILEID_DIRTYGROUP  =  0;
    public static final int PROFILEID_DIRTYMASK   =  1;
    public static final int WBSNODEID_DIRTYGROUP  =  0;
    public static final int WBSNODEID_DIRTYMASK   =  2;
    public static final int EFFORT_DIRTYGROUP  =  0;
    public static final int EFFORT_DIRTYMASK   =  4;
    public static final int UNITEFFORT_DIRTYGROUP  =  0;
    public static final int UNITEFFORT_DIRTYMASK   =  8;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  16;
    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  32;
    public static final int WBSID_DIRTYGROUP  =  0;
    public static final int WBSID_DIRTYMASK   =  64;
    public static final int NODETYPE_DIRTYGROUP  =  0;
    public static final int NODETYPE_DIRTYMASK   =  128;
    public static final int NODEORDER_DIRTYGROUP  =  0;
    public static final int NODEORDER_DIRTYMASK   =  256;
    public static final int NODESECT_DIRTYGROUP  =  0;
    public static final int NODESECT_DIRTYMASK   =  512;
    public static final int NODENAME_DIRTYGROUP  =  0;
    public static final int NODENAME_DIRTYMASK   =  1024;
    public static final int NODESTATUS_DIRTYGROUP  =  0;
    public static final int NODESTATUS_DIRTYMASK   =  2048;


    /**
      * DataBean constructor.
      */
    public WBSNodeTeamMemberProfileViewDTOBase()
    {
       dirtyFlagsArray = new int[12 / 30 + 1];
       clearDirtyFlags();

       profileid = PROFILEID_DEFAULT;
       wbsnodeid = WBSNODEID_DEFAULT;
       effort = EFFORT_DEFAULT;
       uniteffort = UNITEFFORT_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       site = SITE_DEFAULT;
       wbsid = WBSID_DEFAULT;
       nodetype = NODETYPE_DEFAULT;
       nodeorder = NODEORDER_DEFAULT;
       nodesect = NODESECT_DEFAULT;
       nodename = NODENAME_DEFAULT;
       nodestatus = NODESTATUS_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public WBSNodeTeamMemberProfileViewDTOBase(WBSNodeTeamMemberProfileViewDTOBase another)
    {

       profileid = another.getProfileid();
       wbsnodeid = another.getWbsnodeid();
       effort = another.getEffort();
       uniteffort = another.getUniteffort();
       recstatus = another.getRecstatus();
       site = another.getSite();
       wbsid = another.getWbsid();
       nodetype = another.getNodetype();
       nodeorder = another.getNodeorder();
       nodesect = another.getNodesect();
       nodename = another.getNodename();
       nodestatus = another.getNodestatus();

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



    /**
      * DataBean Getter And Setter Accessor
      */

    // profileid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isProfileidDirty()  { return checkFieldDirtiness(PROFILEID_DIRTYGROUP, PROFILEID_DIRTYMASK); }

    public java.lang.String   getProfileid()         { return profileid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "profileid")
    public java.lang.String   getProfileidAsString() { return (profileid == null) ? "" : profileid; }

    // profileid setter methods.
    
    protected void markProfileidAsDirty(boolean aFlag)  { markFieldAsDirty(PROFILEID_DIRTYGROUP, PROFILEID_DIRTYMASK, aFlag); }


    public void setProfileid(String  p)
    {
       setProfileid(p, DTOCasingStyle.none);
    }
    
    public void setProfileid(String  p, DTOCasingStyle casingStyle)
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
       markProfileidAsDirty(!equalsObject(profileid, p));
       profileid = p;
    }

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

    // effort getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEffortDirty()  { return checkFieldDirtiness(EFFORT_DIRTYGROUP, EFFORT_DIRTYMASK); }

    public java.lang.Float   getEffort() { return effort; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "effort")
    public String getEffortAsString() { return floatAsString(effort); }

    // effort setter methods.
    
    protected void markEffortAsDirty(boolean aFlag)  { markFieldAsDirty(EFFORT_DIRTYGROUP, EFFORT_DIRTYMASK, aFlag); }


    public void setEffort(java.lang.Float  p)
    {
    	markEffortAsDirty(!equalsObject(effort, p));
    	effort = p;
    }
    public void setEffort()
    {
    	setEffort((java.lang.Float)null);
    }
    public void setEffort(String  p)
    {
    	setEffort(stringAsFloat(p));
    }

    // uniteffort getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isUniteffortDirty()  { return checkFieldDirtiness(UNITEFFORT_DIRTYGROUP, UNITEFFORT_DIRTYMASK); }

    public java.lang.String   getUniteffort()         { return uniteffort; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "uniteffort")
    public java.lang.String   getUniteffortAsString() { return (uniteffort == null) ? "" : uniteffort; }

    // uniteffort setter methods.
    
    protected void markUniteffortAsDirty(boolean aFlag)  { markFieldAsDirty(UNITEFFORT_DIRTYGROUP, UNITEFFORT_DIRTYMASK, aFlag); }


    public void setUniteffort(String  p)
    {
       setUniteffort(p, DTOCasingStyle.none);
    }
    
    public void setUniteffort(String  p, DTOCasingStyle casingStyle)
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
       markUniteffortAsDirty(!equalsObject(uniteffort, p));
       uniteffort = p;
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

    // nodestatus getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNodestatusDirty()  { return checkFieldDirtiness(NODESTATUS_DIRTYGROUP, NODESTATUS_DIRTYMASK); }

    public java.lang.String   getNodestatus()         { return nodestatus; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "nodestatus")
    public java.lang.String   getNodestatusAsString() { return (nodestatus == null) ? "" : nodestatus; }

    // nodestatus setter methods.
    
    protected void markNodestatusAsDirty(boolean aFlag)  { markFieldAsDirty(NODESTATUS_DIRTYGROUP, NODESTATUS_DIRTYMASK, aFlag); }


    public void setNodestatus(String  p)
    {
       setNodestatus(p, DTOCasingStyle.none);
    }
    
    public void setNodestatus(String  p, DTOCasingStyle casingStyle)
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
       markNodestatusAsDirty(!equalsObject(nodestatus, p));
       nodestatus = p;
    }

}
