//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.rankinginstancedetailview;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "RankingInstanceDetailViewDTOBase")
public class RankingInstanceDetailViewDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.Integer  rankentryid;
    protected java.lang.String  eventid;
    protected java.lang.String  instanceid;
    protected java.lang.String  applicationid;
    protected java.lang.Integer  pos;
    protected java.lang.String  sailnumber;
    protected java.lang.String  yachtname;
    protected java.lang.String  owner;
    protected java.lang.String  club;
    protected java.lang.String  model;
    protected java.lang.String  racegroup;
    protected java.lang.String  division;
    protected java.lang.String  timoniere;
    protected java.sql.Timestamp  arrivaldate;
    protected java.lang.Integer  realtime;
    protected java.lang.Integer  drealtime;
    protected java.lang.Integer  correctedtime;
    protected java.lang.String  annotation;
    protected java.lang.String  perctempen;
    protected java.lang.Float  score;
    protected java.lang.Integer  maxraces;
    protected java.lang.Float  scorer01;
    protected java.lang.Float  scorer02;
    protected java.lang.Float  scorer03;
    protected java.lang.Float  scorer04;
    protected java.lang.Float  scorer05;
    protected java.lang.Float  scorer06;
    protected java.lang.Float  scorer07;
    protected java.lang.Float  scorer08;
    protected java.lang.Float  scorer09;
    protected java.lang.Float  scorer10;
    protected java.lang.Float  scorer11;
    protected java.lang.Float  scorer12;
    protected java.lang.Float  scorer13;
    protected java.lang.Float  scorer14;
    protected java.lang.Float  scorer15;
    protected java.lang.String  scorern01;
    protected java.lang.String  scorern02;
    protected java.lang.String  scorern03;
    protected java.lang.String  scorern04;
    protected java.lang.String  scorern05;
    protected java.lang.String  scorern06;
    protected java.lang.String  scorern07;
    protected java.lang.String  scorern08;
    protected java.lang.String  scorern09;
    protected java.lang.String  scorern10;
    protected java.lang.String  scorern11;
    protected java.lang.String  scorern12;
    protected java.lang.String  scorern13;
    protected java.lang.String  scorern14;
    protected java.lang.String  scorern15;
    protected java.sql.Timestamp  rectimestamp;
    protected java.lang.Float  yachtbsf;
    protected java.lang.Float  yachtgph;

    public static final java.lang.Integer RANKENTRYID_DEFAULT  =  null;
    public static final java.lang.String EVENTID_DEFAULT  =  null;
    public static final java.lang.String INSTANCEID_DEFAULT  =  null;
    public static final java.lang.String APPLICATIONID_DEFAULT  =  null;
    public static final java.lang.Integer POS_DEFAULT  =  null;
    public static final java.lang.String SAILNUMBER_DEFAULT  =  null;
    public static final java.lang.String YACHTNAME_DEFAULT  =  null;
    public static final java.lang.String OWNER_DEFAULT  =  null;
    public static final java.lang.String CLUB_DEFAULT  =  null;
    public static final java.lang.String MODEL_DEFAULT  =  null;
    public static final java.lang.String RACEGROUP_DEFAULT  =  null;
    public static final java.lang.String DIVISION_DEFAULT  =  null;
    public static final java.lang.String TIMONIERE_DEFAULT  =  null;
    public static final java.sql.Timestamp ARRIVALDATE_DEFAULT  =  null;
    public static final java.lang.Integer REALTIME_DEFAULT  =  null;
    public static final java.lang.Integer DREALTIME_DEFAULT  =  null;
    public static final java.lang.Integer CORRECTEDTIME_DEFAULT  =  null;
    public static final java.lang.String ANNOTATION_DEFAULT  =  null;
    public static final java.lang.String PERCTEMPEN_DEFAULT  =  null;
    public static final java.lang.Float SCORE_DEFAULT  =  null;
    public static final java.lang.Integer MAXRACES_DEFAULT  =  null;
    public static final java.lang.Float SCORER01_DEFAULT  =  null;
    public static final java.lang.Float SCORER02_DEFAULT  =  null;
    public static final java.lang.Float SCORER03_DEFAULT  =  null;
    public static final java.lang.Float SCORER04_DEFAULT  =  null;
    public static final java.lang.Float SCORER05_DEFAULT  =  null;
    public static final java.lang.Float SCORER06_DEFAULT  =  null;
    public static final java.lang.Float SCORER07_DEFAULT  =  null;
    public static final java.lang.Float SCORER08_DEFAULT  =  null;
    public static final java.lang.Float SCORER09_DEFAULT  =  null;
    public static final java.lang.Float SCORER10_DEFAULT  =  null;
    public static final java.lang.Float SCORER11_DEFAULT  =  null;
    public static final java.lang.Float SCORER12_DEFAULT  =  null;
    public static final java.lang.Float SCORER13_DEFAULT  =  null;
    public static final java.lang.Float SCORER14_DEFAULT  =  null;
    public static final java.lang.Float SCORER15_DEFAULT  =  null;
    public static final java.lang.String SCORERN01_DEFAULT  =  null;
    public static final java.lang.String SCORERN02_DEFAULT  =  null;
    public static final java.lang.String SCORERN03_DEFAULT  =  null;
    public static final java.lang.String SCORERN04_DEFAULT  =  null;
    public static final java.lang.String SCORERN05_DEFAULT  =  null;
    public static final java.lang.String SCORERN06_DEFAULT  =  null;
    public static final java.lang.String SCORERN07_DEFAULT  =  null;
    public static final java.lang.String SCORERN08_DEFAULT  =  null;
    public static final java.lang.String SCORERN09_DEFAULT  =  null;
    public static final java.lang.String SCORERN10_DEFAULT  =  null;
    public static final java.lang.String SCORERN11_DEFAULT  =  null;
    public static final java.lang.String SCORERN12_DEFAULT  =  null;
    public static final java.lang.String SCORERN13_DEFAULT  =  null;
    public static final java.lang.String SCORERN14_DEFAULT  =  null;
    public static final java.lang.String SCORERN15_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;
    public static final java.lang.Float YACHTBSF_DEFAULT  =  null;
    public static final java.lang.Float YACHTGPH_DEFAULT  =  null;

    public static final int RANKENTRYID_DIRTYGROUP  =  0;
    public static final int RANKENTRYID_DIRTYMASK   =  1;
    public static final int EVENTID_DIRTYGROUP  =  0;
    public static final int EVENTID_DIRTYMASK   =  2;
    public static final int INSTANCEID_DIRTYGROUP  =  0;
    public static final int INSTANCEID_DIRTYMASK   =  4;
    public static final int APPLICATIONID_DIRTYGROUP  =  0;
    public static final int APPLICATIONID_DIRTYMASK   =  8;
    public static final int POS_DIRTYGROUP  =  0;
    public static final int POS_DIRTYMASK   =  16;
    public static final int SAILNUMBER_DIRTYGROUP  =  0;
    public static final int SAILNUMBER_DIRTYMASK   =  32;
    public static final int YACHTNAME_DIRTYGROUP  =  0;
    public static final int YACHTNAME_DIRTYMASK   =  64;
    public static final int OWNER_DIRTYGROUP  =  0;
    public static final int OWNER_DIRTYMASK   =  128;
    public static final int CLUB_DIRTYGROUP  =  0;
    public static final int CLUB_DIRTYMASK   =  256;
    public static final int MODEL_DIRTYGROUP  =  0;
    public static final int MODEL_DIRTYMASK   =  512;
    public static final int RACEGROUP_DIRTYGROUP  =  0;
    public static final int RACEGROUP_DIRTYMASK   =  1024;
    public static final int DIVISION_DIRTYGROUP  =  0;
    public static final int DIVISION_DIRTYMASK   =  2048;
    public static final int TIMONIERE_DIRTYGROUP  =  0;
    public static final int TIMONIERE_DIRTYMASK   =  4096;
    public static final int ARRIVALDATE_DIRTYGROUP  =  0;
    public static final int ARRIVALDATE_DIRTYMASK   =  8192;
    public static final int REALTIME_DIRTYGROUP  =  0;
    public static final int REALTIME_DIRTYMASK   =  16384;
    public static final int DREALTIME_DIRTYGROUP  =  0;
    public static final int DREALTIME_DIRTYMASK   =  32768;
    public static final int CORRECTEDTIME_DIRTYGROUP  =  0;
    public static final int CORRECTEDTIME_DIRTYMASK   =  65536;
    public static final int ANNOTATION_DIRTYGROUP  =  0;
    public static final int ANNOTATION_DIRTYMASK   =  131072;
    public static final int PERCTEMPEN_DIRTYGROUP  =  0;
    public static final int PERCTEMPEN_DIRTYMASK   =  262144;
    public static final int SCORE_DIRTYGROUP  =  0;
    public static final int SCORE_DIRTYMASK   =  524288;
    public static final int MAXRACES_DIRTYGROUP  =  0;
    public static final int MAXRACES_DIRTYMASK   =  1048576;
    public static final int SCORER01_DIRTYGROUP  =  0;
    public static final int SCORER01_DIRTYMASK   =  2097152;
    public static final int SCORER02_DIRTYGROUP  =  0;
    public static final int SCORER02_DIRTYMASK   =  4194304;
    public static final int SCORER03_DIRTYGROUP  =  0;
    public static final int SCORER03_DIRTYMASK   =  8388608;
    public static final int SCORER04_DIRTYGROUP  =  0;
    public static final int SCORER04_DIRTYMASK   =  16777216;
    public static final int SCORER05_DIRTYGROUP  =  0;
    public static final int SCORER05_DIRTYMASK   =  33554432;
    public static final int SCORER06_DIRTYGROUP  =  0;
    public static final int SCORER06_DIRTYMASK   =  67108864;
    public static final int SCORER07_DIRTYGROUP  =  0;
    public static final int SCORER07_DIRTYMASK   =  134217728;
    public static final int SCORER08_DIRTYGROUP  =  0;
    public static final int SCORER08_DIRTYMASK   =  268435456;
    public static final int SCORER09_DIRTYGROUP  =  0;
    public static final int SCORER09_DIRTYMASK   =  536870912;
    public static final int SCORER10_DIRTYGROUP  =  1;
    public static final int SCORER10_DIRTYMASK   =  1;
    public static final int SCORER11_DIRTYGROUP  =  1;
    public static final int SCORER11_DIRTYMASK   =  2;
    public static final int SCORER12_DIRTYGROUP  =  1;
    public static final int SCORER12_DIRTYMASK   =  4;
    public static final int SCORER13_DIRTYGROUP  =  1;
    public static final int SCORER13_DIRTYMASK   =  8;
    public static final int SCORER14_DIRTYGROUP  =  1;
    public static final int SCORER14_DIRTYMASK   =  16;
    public static final int SCORER15_DIRTYGROUP  =  1;
    public static final int SCORER15_DIRTYMASK   =  32;
    public static final int SCORERN01_DIRTYGROUP  =  1;
    public static final int SCORERN01_DIRTYMASK   =  64;
    public static final int SCORERN02_DIRTYGROUP  =  1;
    public static final int SCORERN02_DIRTYMASK   =  128;
    public static final int SCORERN03_DIRTYGROUP  =  1;
    public static final int SCORERN03_DIRTYMASK   =  256;
    public static final int SCORERN04_DIRTYGROUP  =  1;
    public static final int SCORERN04_DIRTYMASK   =  512;
    public static final int SCORERN05_DIRTYGROUP  =  1;
    public static final int SCORERN05_DIRTYMASK   =  1024;
    public static final int SCORERN06_DIRTYGROUP  =  1;
    public static final int SCORERN06_DIRTYMASK   =  2048;
    public static final int SCORERN07_DIRTYGROUP  =  1;
    public static final int SCORERN07_DIRTYMASK   =  4096;
    public static final int SCORERN08_DIRTYGROUP  =  1;
    public static final int SCORERN08_DIRTYMASK   =  8192;
    public static final int SCORERN09_DIRTYGROUP  =  1;
    public static final int SCORERN09_DIRTYMASK   =  16384;
    public static final int SCORERN10_DIRTYGROUP  =  1;
    public static final int SCORERN10_DIRTYMASK   =  32768;
    public static final int SCORERN11_DIRTYGROUP  =  1;
    public static final int SCORERN11_DIRTYMASK   =  65536;
    public static final int SCORERN12_DIRTYGROUP  =  1;
    public static final int SCORERN12_DIRTYMASK   =  131072;
    public static final int SCORERN13_DIRTYGROUP  =  1;
    public static final int SCORERN13_DIRTYMASK   =  262144;
    public static final int SCORERN14_DIRTYGROUP  =  1;
    public static final int SCORERN14_DIRTYMASK   =  524288;
    public static final int SCORERN15_DIRTYGROUP  =  1;
    public static final int SCORERN15_DIRTYMASK   =  1048576;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  1;
    public static final int RECTIMESTAMP_DIRTYMASK   =  2097152;
    public static final int YACHTBSF_DIRTYGROUP  =  1;
    public static final int YACHTBSF_DIRTYMASK   =  4194304;
    public static final int YACHTGPH_DIRTYGROUP  =  1;
    public static final int YACHTGPH_DIRTYMASK   =  8388608;


    /**
      * DataBean constructor.
      */
    public RankingInstanceDetailViewDTOBase()
    {
       dirtyFlagsArray = new int[54 / 30 + 1];
       clearDirtyFlags();

       rankentryid = RANKENTRYID_DEFAULT;
       eventid = EVENTID_DEFAULT;
       instanceid = INSTANCEID_DEFAULT;
       applicationid = APPLICATIONID_DEFAULT;
       pos = POS_DEFAULT;
       sailnumber = SAILNUMBER_DEFAULT;
       yachtname = YACHTNAME_DEFAULT;
       owner = OWNER_DEFAULT;
       club = CLUB_DEFAULT;
       model = MODEL_DEFAULT;
       racegroup = RACEGROUP_DEFAULT;
       division = DIVISION_DEFAULT;
       timoniere = TIMONIERE_DEFAULT;
       arrivaldate = ARRIVALDATE_DEFAULT;
       realtime = REALTIME_DEFAULT;
       drealtime = DREALTIME_DEFAULT;
       correctedtime = CORRECTEDTIME_DEFAULT;
       annotation = ANNOTATION_DEFAULT;
       perctempen = PERCTEMPEN_DEFAULT;
       score = SCORE_DEFAULT;
       maxraces = MAXRACES_DEFAULT;
       scorer01 = SCORER01_DEFAULT;
       scorer02 = SCORER02_DEFAULT;
       scorer03 = SCORER03_DEFAULT;
       scorer04 = SCORER04_DEFAULT;
       scorer05 = SCORER05_DEFAULT;
       scorer06 = SCORER06_DEFAULT;
       scorer07 = SCORER07_DEFAULT;
       scorer08 = SCORER08_DEFAULT;
       scorer09 = SCORER09_DEFAULT;
       scorer10 = SCORER10_DEFAULT;
       scorer11 = SCORER11_DEFAULT;
       scorer12 = SCORER12_DEFAULT;
       scorer13 = SCORER13_DEFAULT;
       scorer14 = SCORER14_DEFAULT;
       scorer15 = SCORER15_DEFAULT;
       scorern01 = SCORERN01_DEFAULT;
       scorern02 = SCORERN02_DEFAULT;
       scorern03 = SCORERN03_DEFAULT;
       scorern04 = SCORERN04_DEFAULT;
       scorern05 = SCORERN05_DEFAULT;
       scorern06 = SCORERN06_DEFAULT;
       scorern07 = SCORERN07_DEFAULT;
       scorern08 = SCORERN08_DEFAULT;
       scorern09 = SCORERN09_DEFAULT;
       scorern10 = SCORERN10_DEFAULT;
       scorern11 = SCORERN11_DEFAULT;
       scorern12 = SCORERN12_DEFAULT;
       scorern13 = SCORERN13_DEFAULT;
       scorern14 = SCORERN14_DEFAULT;
       scorern15 = SCORERN15_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
       yachtbsf = YACHTBSF_DEFAULT;
       yachtgph = YACHTGPH_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public RankingInstanceDetailViewDTOBase(RankingInstanceDetailViewDTOBase another)
    {

       rankentryid = another.getRankentryid();
       eventid = another.getEventid();
       instanceid = another.getInstanceid();
       applicationid = another.getApplicationid();
       pos = another.getPos();
       sailnumber = another.getSailnumber();
       yachtname = another.getYachtname();
       owner = another.getOwner();
       club = another.getClub();
       model = another.getModel();
       racegroup = another.getRacegroup();
       division = another.getDivision();
       timoniere = another.getTimoniere();
       arrivaldate = another.getArrivaldate();
       realtime = another.getRealtime();
       drealtime = another.getDrealtime();
       correctedtime = another.getCorrectedtime();
       annotation = another.getAnnotation();
       perctempen = another.getPerctempen();
       score = another.getScore();
       maxraces = another.getMaxraces();
       scorer01 = another.getScorer01();
       scorer02 = another.getScorer02();
       scorer03 = another.getScorer03();
       scorer04 = another.getScorer04();
       scorer05 = another.getScorer05();
       scorer06 = another.getScorer06();
       scorer07 = another.getScorer07();
       scorer08 = another.getScorer08();
       scorer09 = another.getScorer09();
       scorer10 = another.getScorer10();
       scorer11 = another.getScorer11();
       scorer12 = another.getScorer12();
       scorer13 = another.getScorer13();
       scorer14 = another.getScorer14();
       scorer15 = another.getScorer15();
       scorern01 = another.getScorern01();
       scorern02 = another.getScorern02();
       scorern03 = another.getScorern03();
       scorern04 = another.getScorern04();
       scorern05 = another.getScorern05();
       scorern06 = another.getScorern06();
       scorern07 = another.getScorern07();
       scorern08 = another.getScorern08();
       scorern09 = another.getScorern09();
       scorern10 = another.getScorern10();
       scorern11 = another.getScorern11();
       scorern12 = another.getScorern12();
       scorern13 = another.getScorern13();
       scorern14 = another.getScorern14();
       scorern15 = another.getScorern15();
       rectimestamp = another.getRectimestamp();
       yachtbsf = another.getYachtbsf();
       yachtgph = another.getYachtgph();

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

    // rankentryid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRankentryidDirty()  { return checkFieldDirtiness(RANKENTRYID_DIRTYGROUP, RANKENTRYID_DIRTYMASK); }

    public java.lang.Integer   getRankentryid() { return rankentryid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "rankentryid")
    public String getRankentryidAsString() { return integerAsString(rankentryid); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getRankentryidAsInt()    { return rankentryid != null ? rankentryid.intValue() : 0; }

    // rankentryid setter methods.
    
    protected void markRankentryidAsDirty(boolean aFlag)  { markFieldAsDirty(RANKENTRYID_DIRTYGROUP, RANKENTRYID_DIRTYMASK, aFlag); }


    public void setRankentryid(java.lang.Integer  p)
    {
        markRankentryidAsDirty(!equalsObject(rankentryid, p));
    	rankentryid = p;
    }
    public void setRankentryid(int p)
    {
    	setRankentryid(new java.lang.Integer(p));
    }
    public void setRankentryid()
    {
    	setRankentryid(0);
    }
    public void setRankentryid(String  p)
    {
    	setRankentryid(stringAsInteger(p));
    }

    // eventid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEventidDirty()  { return checkFieldDirtiness(EVENTID_DIRTYGROUP, EVENTID_DIRTYMASK); }

    public java.lang.String   getEventid()         { return eventid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "eventid")
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

    // instanceid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isInstanceidDirty()  { return checkFieldDirtiness(INSTANCEID_DIRTYGROUP, INSTANCEID_DIRTYMASK); }

    public java.lang.String   getInstanceid()         { return instanceid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "instanceid")
    public java.lang.String   getInstanceidAsString() { return (instanceid == null) ? "" : instanceid; }

    // instanceid setter methods.
    
    protected void markInstanceidAsDirty(boolean aFlag)  { markFieldAsDirty(INSTANCEID_DIRTYGROUP, INSTANCEID_DIRTYMASK, aFlag); }


    public void setInstanceid(String  p)
    {
       setInstanceid(p, DTOCasingStyle.none);
    }
    
    public void setInstanceid(String  p, DTOCasingStyle casingStyle)
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
       markInstanceidAsDirty(!equalsObject(instanceid, p));
       instanceid = p;
    }

    // applicationid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isApplicationidDirty()  { return checkFieldDirtiness(APPLICATIONID_DIRTYGROUP, APPLICATIONID_DIRTYMASK); }

    public java.lang.String   getApplicationid()         { return applicationid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "applicationid")
    public java.lang.String   getApplicationidAsString() { return (applicationid == null) ? "" : applicationid; }

    // applicationid setter methods.
    
    protected void markApplicationidAsDirty(boolean aFlag)  { markFieldAsDirty(APPLICATIONID_DIRTYGROUP, APPLICATIONID_DIRTYMASK, aFlag); }


    public void setApplicationid(String  p)
    {
       setApplicationid(p, DTOCasingStyle.none);
    }
    
    public void setApplicationid(String  p, DTOCasingStyle casingStyle)
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
       markApplicationidAsDirty(!equalsObject(applicationid, p));
       applicationid = p;
    }

    // pos getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPosDirty()  { return checkFieldDirtiness(POS_DIRTYGROUP, POS_DIRTYMASK); }

    public java.lang.Integer   getPos() { return pos; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "pos")
    public String getPosAsString() { return integerAsString(pos); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getPosAsInt()    { return pos != null ? pos.intValue() : 0; }

    // pos setter methods.
    
    protected void markPosAsDirty(boolean aFlag)  { markFieldAsDirty(POS_DIRTYGROUP, POS_DIRTYMASK, aFlag); }


    public void setPos(java.lang.Integer  p)
    {
        markPosAsDirty(!equalsObject(pos, p));
    	pos = p;
    }
    public void setPos(int p)
    {
    	setPos(new java.lang.Integer(p));
    }
    public void setPos()
    {
    	setPos(0);
    }
    public void setPos(String  p)
    {
    	setPos(stringAsInteger(p));
    }

    // sailnumber getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSailnumberDirty()  { return checkFieldDirtiness(SAILNUMBER_DIRTYGROUP, SAILNUMBER_DIRTYMASK); }

    public java.lang.String   getSailnumber()         { return sailnumber; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "sailnumber")
    public java.lang.String   getSailnumberAsString() { return (sailnumber == null) ? "" : sailnumber; }

    // sailnumber setter methods.
    
    protected void markSailnumberAsDirty(boolean aFlag)  { markFieldAsDirty(SAILNUMBER_DIRTYGROUP, SAILNUMBER_DIRTYMASK, aFlag); }


    public void setSailnumber(String  p)
    {
       setSailnumber(p, DTOCasingStyle.none);
    }
    
    public void setSailnumber(String  p, DTOCasingStyle casingStyle)
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
       markSailnumberAsDirty(!equalsObject(sailnumber, p));
       sailnumber = p;
    }

    // yachtname getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isYachtnameDirty()  { return checkFieldDirtiness(YACHTNAME_DIRTYGROUP, YACHTNAME_DIRTYMASK); }

    public java.lang.String   getYachtname()         { return yachtname; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "yachtname")
    public java.lang.String   getYachtnameAsString() { return (yachtname == null) ? "" : yachtname; }

    // yachtname setter methods.
    
    protected void markYachtnameAsDirty(boolean aFlag)  { markFieldAsDirty(YACHTNAME_DIRTYGROUP, YACHTNAME_DIRTYMASK, aFlag); }


    public void setYachtname(String  p)
    {
       setYachtname(p, DTOCasingStyle.none);
    }
    
    public void setYachtname(String  p, DTOCasingStyle casingStyle)
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
       markYachtnameAsDirty(!equalsObject(yachtname, p));
       yachtname = p;
    }

    // owner getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isOwnerDirty()  { return checkFieldDirtiness(OWNER_DIRTYGROUP, OWNER_DIRTYMASK); }

    public java.lang.String   getOwner()         { return owner; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "owner")
    public java.lang.String   getOwnerAsString() { return (owner == null) ? "" : owner; }

    // owner setter methods.
    
    protected void markOwnerAsDirty(boolean aFlag)  { markFieldAsDirty(OWNER_DIRTYGROUP, OWNER_DIRTYMASK, aFlag); }


    public void setOwner(String  p)
    {
       setOwner(p, DTOCasingStyle.none);
    }
    
    public void setOwner(String  p, DTOCasingStyle casingStyle)
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
       markOwnerAsDirty(!equalsObject(owner, p));
       owner = p;
    }

    // club getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isClubDirty()  { return checkFieldDirtiness(CLUB_DIRTYGROUP, CLUB_DIRTYMASK); }

    public java.lang.String   getClub()         { return club; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "club")
    public java.lang.String   getClubAsString() { return (club == null) ? "" : club; }

    // club setter methods.
    
    protected void markClubAsDirty(boolean aFlag)  { markFieldAsDirty(CLUB_DIRTYGROUP, CLUB_DIRTYMASK, aFlag); }


    public void setClub(String  p)
    {
       setClub(p, DTOCasingStyle.none);
    }
    
    public void setClub(String  p, DTOCasingStyle casingStyle)
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
       markClubAsDirty(!equalsObject(club, p));
       club = p;
    }

    // model getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isModelDirty()  { return checkFieldDirtiness(MODEL_DIRTYGROUP, MODEL_DIRTYMASK); }

    public java.lang.String   getModel()         { return model; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "model")
    public java.lang.String   getModelAsString() { return (model == null) ? "" : model; }

    // model setter methods.
    
    protected void markModelAsDirty(boolean aFlag)  { markFieldAsDirty(MODEL_DIRTYGROUP, MODEL_DIRTYMASK, aFlag); }


    public void setModel(String  p)
    {
       setModel(p, DTOCasingStyle.none);
    }
    
    public void setModel(String  p, DTOCasingStyle casingStyle)
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
       markModelAsDirty(!equalsObject(model, p));
       model = p;
    }

    // racegroup getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRacegroupDirty()  { return checkFieldDirtiness(RACEGROUP_DIRTYGROUP, RACEGROUP_DIRTYMASK); }

    public java.lang.String   getRacegroup()         { return racegroup; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "racegroup")
    public java.lang.String   getRacegroupAsString() { return (racegroup == null) ? "" : racegroup; }

    // racegroup setter methods.
    
    protected void markRacegroupAsDirty(boolean aFlag)  { markFieldAsDirty(RACEGROUP_DIRTYGROUP, RACEGROUP_DIRTYMASK, aFlag); }


    public void setRacegroup(String  p)
    {
       setRacegroup(p, DTOCasingStyle.none);
    }
    
    public void setRacegroup(String  p, DTOCasingStyle casingStyle)
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
       markRacegroupAsDirty(!equalsObject(racegroup, p));
       racegroup = p;
    }

    // division getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isDivisionDirty()  { return checkFieldDirtiness(DIVISION_DIRTYGROUP, DIVISION_DIRTYMASK); }

    public java.lang.String   getDivision()         { return division; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "division")
    public java.lang.String   getDivisionAsString() { return (division == null) ? "" : division; }

    // division setter methods.
    
    protected void markDivisionAsDirty(boolean aFlag)  { markFieldAsDirty(DIVISION_DIRTYGROUP, DIVISION_DIRTYMASK, aFlag); }


    public void setDivision(String  p)
    {
       setDivision(p, DTOCasingStyle.none);
    }
    
    public void setDivision(String  p, DTOCasingStyle casingStyle)
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
       markDivisionAsDirty(!equalsObject(division, p));
       division = p;
    }

    // timoniere getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isTimoniereDirty()  { return checkFieldDirtiness(TIMONIERE_DIRTYGROUP, TIMONIERE_DIRTYMASK); }

    public java.lang.String   getTimoniere()         { return timoniere; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "timoniere")
    public java.lang.String   getTimoniereAsString() { return (timoniere == null) ? "" : timoniere; }

    // timoniere setter methods.
    
    protected void markTimoniereAsDirty(boolean aFlag)  { markFieldAsDirty(TIMONIERE_DIRTYGROUP, TIMONIERE_DIRTYMASK, aFlag); }


    public void setTimoniere(String  p)
    {
       setTimoniere(p, DTOCasingStyle.none);
    }
    
    public void setTimoniere(String  p, DTOCasingStyle casingStyle)
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
       markTimoniereAsDirty(!equalsObject(timoniere, p));
       timoniere = p;
    }

    // arrivaldate getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isArrivaldateDirty()  { return checkFieldDirtiness(ARRIVALDATE_DIRTYGROUP, ARRIVALDATE_DIRTYMASK); }

    @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getArrivaldate() { return arrivaldate; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "arrivaldate")
    public String getArrivaldateAsString() { return timestampAsString(arrivaldate, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getArrivaldateAsString(java.text.DateFormat aDateFormat) { return timestampAsString(arrivaldate, aDateFormat); }

    // arrivaldate setter methods.
    
    protected void markArrivaldateAsDirty(boolean aFlag)  { markFieldAsDirty(ARRIVALDATE_DIRTYGROUP, ARRIVALDATE_DIRTYMASK, aFlag); }


    public void setArrivaldate(java.sql.Timestamp  p)
    {
        markArrivaldateAsDirty(!equalsObject(arrivaldate, p));
    	arrivaldate = p;
    }
    public void setArrivaldate(String  p, java.text.DateFormat aDateFormat)
    {
    	setArrivaldate(stringAsTimestamp(p, aDateFormat));
    }

    // realtime getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRealtimeDirty()  { return checkFieldDirtiness(REALTIME_DIRTYGROUP, REALTIME_DIRTYMASK); }

    public java.lang.Integer   getRealtime() { return realtime; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "realtime")
    public String getRealtimeAsString() { return integerAsString(realtime); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getRealtimeAsInt()    { return realtime != null ? realtime.intValue() : 0; }

    // realtime setter methods.
    
    protected void markRealtimeAsDirty(boolean aFlag)  { markFieldAsDirty(REALTIME_DIRTYGROUP, REALTIME_DIRTYMASK, aFlag); }


    public void setRealtime(java.lang.Integer  p)
    {
        markRealtimeAsDirty(!equalsObject(realtime, p));
    	realtime = p;
    }
    public void setRealtime(int p)
    {
    	setRealtime(new java.lang.Integer(p));
    }
    public void setRealtime()
    {
    	setRealtime(0);
    }
    public void setRealtime(String  p)
    {
    	setRealtime(stringAsInteger(p));
    }

    // drealtime getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isDrealtimeDirty()  { return checkFieldDirtiness(DREALTIME_DIRTYGROUP, DREALTIME_DIRTYMASK); }

    public java.lang.Integer   getDrealtime() { return drealtime; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "drealtime")
    public String getDrealtimeAsString() { return integerAsString(drealtime); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getDrealtimeAsInt()    { return drealtime != null ? drealtime.intValue() : 0; }

    // drealtime setter methods.
    
    protected void markDrealtimeAsDirty(boolean aFlag)  { markFieldAsDirty(DREALTIME_DIRTYGROUP, DREALTIME_DIRTYMASK, aFlag); }


    public void setDrealtime(java.lang.Integer  p)
    {
        markDrealtimeAsDirty(!equalsObject(drealtime, p));
    	drealtime = p;
    }
    public void setDrealtime(int p)
    {
    	setDrealtime(new java.lang.Integer(p));
    }
    public void setDrealtime()
    {
    	setDrealtime(0);
    }
    public void setDrealtime(String  p)
    {
    	setDrealtime(stringAsInteger(p));
    }

    // correctedtime getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCorrectedtimeDirty()  { return checkFieldDirtiness(CORRECTEDTIME_DIRTYGROUP, CORRECTEDTIME_DIRTYMASK); }

    public java.lang.Integer   getCorrectedtime() { return correctedtime; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "correctedtime")
    public String getCorrectedtimeAsString() { return integerAsString(correctedtime); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getCorrectedtimeAsInt()    { return correctedtime != null ? correctedtime.intValue() : 0; }

    // correctedtime setter methods.
    
    protected void markCorrectedtimeAsDirty(boolean aFlag)  { markFieldAsDirty(CORRECTEDTIME_DIRTYGROUP, CORRECTEDTIME_DIRTYMASK, aFlag); }


    public void setCorrectedtime(java.lang.Integer  p)
    {
        markCorrectedtimeAsDirty(!equalsObject(correctedtime, p));
    	correctedtime = p;
    }
    public void setCorrectedtime(int p)
    {
    	setCorrectedtime(new java.lang.Integer(p));
    }
    public void setCorrectedtime()
    {
    	setCorrectedtime(0);
    }
    public void setCorrectedtime(String  p)
    {
    	setCorrectedtime(stringAsInteger(p));
    }

    // annotation getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isAnnotationDirty()  { return checkFieldDirtiness(ANNOTATION_DIRTYGROUP, ANNOTATION_DIRTYMASK); }

    public java.lang.String   getAnnotation()         { return annotation; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "annotation")
    public java.lang.String   getAnnotationAsString() { return (annotation == null) ? "" : annotation; }

    // annotation setter methods.
    
    protected void markAnnotationAsDirty(boolean aFlag)  { markFieldAsDirty(ANNOTATION_DIRTYGROUP, ANNOTATION_DIRTYMASK, aFlag); }


    public void setAnnotation(String  p)
    {
       setAnnotation(p, DTOCasingStyle.none);
    }
    
    public void setAnnotation(String  p, DTOCasingStyle casingStyle)
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
       markAnnotationAsDirty(!equalsObject(annotation, p));
       annotation = p;
    }

    // perctempen getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPerctempenDirty()  { return checkFieldDirtiness(PERCTEMPEN_DIRTYGROUP, PERCTEMPEN_DIRTYMASK); }

    public java.lang.String   getPerctempen()         { return perctempen; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "perctempen")
    public java.lang.String   getPerctempenAsString() { return (perctempen == null) ? "" : perctempen; }

    // perctempen setter methods.
    
    protected void markPerctempenAsDirty(boolean aFlag)  { markFieldAsDirty(PERCTEMPEN_DIRTYGROUP, PERCTEMPEN_DIRTYMASK, aFlag); }


    public void setPerctempen(String  p)
    {
       setPerctempen(p, DTOCasingStyle.none);
    }
    
    public void setPerctempen(String  p, DTOCasingStyle casingStyle)
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
       markPerctempenAsDirty(!equalsObject(perctempen, p));
       perctempen = p;
    }

    // score getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScoreDirty()  { return checkFieldDirtiness(SCORE_DIRTYGROUP, SCORE_DIRTYMASK); }

    public java.lang.Float   getScore() { return score; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "score")
    public String getScoreAsString() { return floatAsString(score); }

    // score setter methods.
    
    protected void markScoreAsDirty(boolean aFlag)  { markFieldAsDirty(SCORE_DIRTYGROUP, SCORE_DIRTYMASK, aFlag); }


    public void setScore(java.lang.Float  p)
    {
    	markScoreAsDirty(!equalsObject(score, p));
    	score = p;
    }
    public void setScore()
    {
    	setScore((java.lang.Float)null);
    }
    public void setScore(String  p)
    {
    	setScore(stringAsFloat(p));
    }

    // maxraces getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isMaxracesDirty()  { return checkFieldDirtiness(MAXRACES_DIRTYGROUP, MAXRACES_DIRTYMASK); }

    public java.lang.Integer   getMaxraces() { return maxraces; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "maxraces")
    public String getMaxracesAsString() { return integerAsString(maxraces); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getMaxracesAsInt()    { return maxraces != null ? maxraces.intValue() : 0; }

    // maxraces setter methods.
    
    protected void markMaxracesAsDirty(boolean aFlag)  { markFieldAsDirty(MAXRACES_DIRTYGROUP, MAXRACES_DIRTYMASK, aFlag); }


    public void setMaxraces(java.lang.Integer  p)
    {
        markMaxracesAsDirty(!equalsObject(maxraces, p));
    	maxraces = p;
    }
    public void setMaxraces(int p)
    {
    	setMaxraces(new java.lang.Integer(p));
    }
    public void setMaxraces()
    {
    	setMaxraces(0);
    }
    public void setMaxraces(String  p)
    {
    	setMaxraces(stringAsInteger(p));
    }

    // scorer01 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorer01Dirty()  { return checkFieldDirtiness(SCORER01_DIRTYGROUP, SCORER01_DIRTYMASK); }

    public java.lang.Float   getScorer01() { return scorer01; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorer01")
    public String getScorer01AsString() { return floatAsString(scorer01); }

    // scorer01 setter methods.
    
    protected void markScorer01AsDirty(boolean aFlag)  { markFieldAsDirty(SCORER01_DIRTYGROUP, SCORER01_DIRTYMASK, aFlag); }


    public void setScorer01(java.lang.Float  p)
    {
    	markScorer01AsDirty(!equalsObject(scorer01, p));
    	scorer01 = p;
    }
    public void setScorer01()
    {
    	setScorer01((java.lang.Float)null);
    }
    public void setScorer01(String  p)
    {
    	setScorer01(stringAsFloat(p));
    }

    // scorer02 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorer02Dirty()  { return checkFieldDirtiness(SCORER02_DIRTYGROUP, SCORER02_DIRTYMASK); }

    public java.lang.Float   getScorer02() { return scorer02; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorer02")
    public String getScorer02AsString() { return floatAsString(scorer02); }

    // scorer02 setter methods.
    
    protected void markScorer02AsDirty(boolean aFlag)  { markFieldAsDirty(SCORER02_DIRTYGROUP, SCORER02_DIRTYMASK, aFlag); }


    public void setScorer02(java.lang.Float  p)
    {
    	markScorer02AsDirty(!equalsObject(scorer02, p));
    	scorer02 = p;
    }
    public void setScorer02()
    {
    	setScorer02((java.lang.Float)null);
    }
    public void setScorer02(String  p)
    {
    	setScorer02(stringAsFloat(p));
    }

    // scorer03 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorer03Dirty()  { return checkFieldDirtiness(SCORER03_DIRTYGROUP, SCORER03_DIRTYMASK); }

    public java.lang.Float   getScorer03() { return scorer03; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorer03")
    public String getScorer03AsString() { return floatAsString(scorer03); }

    // scorer03 setter methods.
    
    protected void markScorer03AsDirty(boolean aFlag)  { markFieldAsDirty(SCORER03_DIRTYGROUP, SCORER03_DIRTYMASK, aFlag); }


    public void setScorer03(java.lang.Float  p)
    {
    	markScorer03AsDirty(!equalsObject(scorer03, p));
    	scorer03 = p;
    }
    public void setScorer03()
    {
    	setScorer03((java.lang.Float)null);
    }
    public void setScorer03(String  p)
    {
    	setScorer03(stringAsFloat(p));
    }

    // scorer04 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorer04Dirty()  { return checkFieldDirtiness(SCORER04_DIRTYGROUP, SCORER04_DIRTYMASK); }

    public java.lang.Float   getScorer04() { return scorer04; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorer04")
    public String getScorer04AsString() { return floatAsString(scorer04); }

    // scorer04 setter methods.
    
    protected void markScorer04AsDirty(boolean aFlag)  { markFieldAsDirty(SCORER04_DIRTYGROUP, SCORER04_DIRTYMASK, aFlag); }


    public void setScorer04(java.lang.Float  p)
    {
    	markScorer04AsDirty(!equalsObject(scorer04, p));
    	scorer04 = p;
    }
    public void setScorer04()
    {
    	setScorer04((java.lang.Float)null);
    }
    public void setScorer04(String  p)
    {
    	setScorer04(stringAsFloat(p));
    }

    // scorer05 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorer05Dirty()  { return checkFieldDirtiness(SCORER05_DIRTYGROUP, SCORER05_DIRTYMASK); }

    public java.lang.Float   getScorer05() { return scorer05; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorer05")
    public String getScorer05AsString() { return floatAsString(scorer05); }

    // scorer05 setter methods.
    
    protected void markScorer05AsDirty(boolean aFlag)  { markFieldAsDirty(SCORER05_DIRTYGROUP, SCORER05_DIRTYMASK, aFlag); }


    public void setScorer05(java.lang.Float  p)
    {
    	markScorer05AsDirty(!equalsObject(scorer05, p));
    	scorer05 = p;
    }
    public void setScorer05()
    {
    	setScorer05((java.lang.Float)null);
    }
    public void setScorer05(String  p)
    {
    	setScorer05(stringAsFloat(p));
    }

    // scorer06 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorer06Dirty()  { return checkFieldDirtiness(SCORER06_DIRTYGROUP, SCORER06_DIRTYMASK); }

    public java.lang.Float   getScorer06() { return scorer06; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorer06")
    public String getScorer06AsString() { return floatAsString(scorer06); }

    // scorer06 setter methods.
    
    protected void markScorer06AsDirty(boolean aFlag)  { markFieldAsDirty(SCORER06_DIRTYGROUP, SCORER06_DIRTYMASK, aFlag); }


    public void setScorer06(java.lang.Float  p)
    {
    	markScorer06AsDirty(!equalsObject(scorer06, p));
    	scorer06 = p;
    }
    public void setScorer06()
    {
    	setScorer06((java.lang.Float)null);
    }
    public void setScorer06(String  p)
    {
    	setScorer06(stringAsFloat(p));
    }

    // scorer07 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorer07Dirty()  { return checkFieldDirtiness(SCORER07_DIRTYGROUP, SCORER07_DIRTYMASK); }

    public java.lang.Float   getScorer07() { return scorer07; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorer07")
    public String getScorer07AsString() { return floatAsString(scorer07); }

    // scorer07 setter methods.
    
    protected void markScorer07AsDirty(boolean aFlag)  { markFieldAsDirty(SCORER07_DIRTYGROUP, SCORER07_DIRTYMASK, aFlag); }


    public void setScorer07(java.lang.Float  p)
    {
    	markScorer07AsDirty(!equalsObject(scorer07, p));
    	scorer07 = p;
    }
    public void setScorer07()
    {
    	setScorer07((java.lang.Float)null);
    }
    public void setScorer07(String  p)
    {
    	setScorer07(stringAsFloat(p));
    }

    // scorer08 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorer08Dirty()  { return checkFieldDirtiness(SCORER08_DIRTYGROUP, SCORER08_DIRTYMASK); }

    public java.lang.Float   getScorer08() { return scorer08; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorer08")
    public String getScorer08AsString() { return floatAsString(scorer08); }

    // scorer08 setter methods.
    
    protected void markScorer08AsDirty(boolean aFlag)  { markFieldAsDirty(SCORER08_DIRTYGROUP, SCORER08_DIRTYMASK, aFlag); }


    public void setScorer08(java.lang.Float  p)
    {
    	markScorer08AsDirty(!equalsObject(scorer08, p));
    	scorer08 = p;
    }
    public void setScorer08()
    {
    	setScorer08((java.lang.Float)null);
    }
    public void setScorer08(String  p)
    {
    	setScorer08(stringAsFloat(p));
    }

    // scorer09 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorer09Dirty()  { return checkFieldDirtiness(SCORER09_DIRTYGROUP, SCORER09_DIRTYMASK); }

    public java.lang.Float   getScorer09() { return scorer09; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorer09")
    public String getScorer09AsString() { return floatAsString(scorer09); }

    // scorer09 setter methods.
    
    protected void markScorer09AsDirty(boolean aFlag)  { markFieldAsDirty(SCORER09_DIRTYGROUP, SCORER09_DIRTYMASK, aFlag); }


    public void setScorer09(java.lang.Float  p)
    {
    	markScorer09AsDirty(!equalsObject(scorer09, p));
    	scorer09 = p;
    }
    public void setScorer09()
    {
    	setScorer09((java.lang.Float)null);
    }
    public void setScorer09(String  p)
    {
    	setScorer09(stringAsFloat(p));
    }

    // scorer10 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorer10Dirty()  { return checkFieldDirtiness(SCORER10_DIRTYGROUP, SCORER10_DIRTYMASK); }

    public java.lang.Float   getScorer10() { return scorer10; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorer10")
    public String getScorer10AsString() { return floatAsString(scorer10); }

    // scorer10 setter methods.
    
    protected void markScorer10AsDirty(boolean aFlag)  { markFieldAsDirty(SCORER10_DIRTYGROUP, SCORER10_DIRTYMASK, aFlag); }


    public void setScorer10(java.lang.Float  p)
    {
    	markScorer10AsDirty(!equalsObject(scorer10, p));
    	scorer10 = p;
    }
    public void setScorer10()
    {
    	setScorer10((java.lang.Float)null);
    }
    public void setScorer10(String  p)
    {
    	setScorer10(stringAsFloat(p));
    }

    // scorer11 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorer11Dirty()  { return checkFieldDirtiness(SCORER11_DIRTYGROUP, SCORER11_DIRTYMASK); }

    public java.lang.Float   getScorer11() { return scorer11; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorer11")
    public String getScorer11AsString() { return floatAsString(scorer11); }

    // scorer11 setter methods.
    
    protected void markScorer11AsDirty(boolean aFlag)  { markFieldAsDirty(SCORER11_DIRTYGROUP, SCORER11_DIRTYMASK, aFlag); }


    public void setScorer11(java.lang.Float  p)
    {
    	markScorer11AsDirty(!equalsObject(scorer11, p));
    	scorer11 = p;
    }
    public void setScorer11()
    {
    	setScorer11((java.lang.Float)null);
    }
    public void setScorer11(String  p)
    {
    	setScorer11(stringAsFloat(p));
    }

    // scorer12 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorer12Dirty()  { return checkFieldDirtiness(SCORER12_DIRTYGROUP, SCORER12_DIRTYMASK); }

    public java.lang.Float   getScorer12() { return scorer12; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorer12")
    public String getScorer12AsString() { return floatAsString(scorer12); }

    // scorer12 setter methods.
    
    protected void markScorer12AsDirty(boolean aFlag)  { markFieldAsDirty(SCORER12_DIRTYGROUP, SCORER12_DIRTYMASK, aFlag); }


    public void setScorer12(java.lang.Float  p)
    {
    	markScorer12AsDirty(!equalsObject(scorer12, p));
    	scorer12 = p;
    }
    public void setScorer12()
    {
    	setScorer12((java.lang.Float)null);
    }
    public void setScorer12(String  p)
    {
    	setScorer12(stringAsFloat(p));
    }

    // scorer13 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorer13Dirty()  { return checkFieldDirtiness(SCORER13_DIRTYGROUP, SCORER13_DIRTYMASK); }

    public java.lang.Float   getScorer13() { return scorer13; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorer13")
    public String getScorer13AsString() { return floatAsString(scorer13); }

    // scorer13 setter methods.
    
    protected void markScorer13AsDirty(boolean aFlag)  { markFieldAsDirty(SCORER13_DIRTYGROUP, SCORER13_DIRTYMASK, aFlag); }


    public void setScorer13(java.lang.Float  p)
    {
    	markScorer13AsDirty(!equalsObject(scorer13, p));
    	scorer13 = p;
    }
    public void setScorer13()
    {
    	setScorer13((java.lang.Float)null);
    }
    public void setScorer13(String  p)
    {
    	setScorer13(stringAsFloat(p));
    }

    // scorer14 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorer14Dirty()  { return checkFieldDirtiness(SCORER14_DIRTYGROUP, SCORER14_DIRTYMASK); }

    public java.lang.Float   getScorer14() { return scorer14; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorer14")
    public String getScorer14AsString() { return floatAsString(scorer14); }

    // scorer14 setter methods.
    
    protected void markScorer14AsDirty(boolean aFlag)  { markFieldAsDirty(SCORER14_DIRTYGROUP, SCORER14_DIRTYMASK, aFlag); }


    public void setScorer14(java.lang.Float  p)
    {
    	markScorer14AsDirty(!equalsObject(scorer14, p));
    	scorer14 = p;
    }
    public void setScorer14()
    {
    	setScorer14((java.lang.Float)null);
    }
    public void setScorer14(String  p)
    {
    	setScorer14(stringAsFloat(p));
    }

    // scorer15 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorer15Dirty()  { return checkFieldDirtiness(SCORER15_DIRTYGROUP, SCORER15_DIRTYMASK); }

    public java.lang.Float   getScorer15() { return scorer15; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorer15")
    public String getScorer15AsString() { return floatAsString(scorer15); }

    // scorer15 setter methods.
    
    protected void markScorer15AsDirty(boolean aFlag)  { markFieldAsDirty(SCORER15_DIRTYGROUP, SCORER15_DIRTYMASK, aFlag); }


    public void setScorer15(java.lang.Float  p)
    {
    	markScorer15AsDirty(!equalsObject(scorer15, p));
    	scorer15 = p;
    }
    public void setScorer15()
    {
    	setScorer15((java.lang.Float)null);
    }
    public void setScorer15(String  p)
    {
    	setScorer15(stringAsFloat(p));
    }

    // scorern01 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorern01Dirty()  { return checkFieldDirtiness(SCORERN01_DIRTYGROUP, SCORERN01_DIRTYMASK); }

    public java.lang.String   getScorern01()         { return scorern01; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorern01")
    public java.lang.String   getScorern01AsString() { return (scorern01 == null) ? "" : scorern01; }

    // scorern01 setter methods.
    
    protected void markScorern01AsDirty(boolean aFlag)  { markFieldAsDirty(SCORERN01_DIRTYGROUP, SCORERN01_DIRTYMASK, aFlag); }


    public void setScorern01(String  p)
    {
       setScorern01(p, DTOCasingStyle.none);
    }
    
    public void setScorern01(String  p, DTOCasingStyle casingStyle)
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
       markScorern01AsDirty(!equalsObject(scorern01, p));
       scorern01 = p;
    }

    // scorern02 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorern02Dirty()  { return checkFieldDirtiness(SCORERN02_DIRTYGROUP, SCORERN02_DIRTYMASK); }

    public java.lang.String   getScorern02()         { return scorern02; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorern02")
    public java.lang.String   getScorern02AsString() { return (scorern02 == null) ? "" : scorern02; }

    // scorern02 setter methods.
    
    protected void markScorern02AsDirty(boolean aFlag)  { markFieldAsDirty(SCORERN02_DIRTYGROUP, SCORERN02_DIRTYMASK, aFlag); }


    public void setScorern02(String  p)
    {
       setScorern02(p, DTOCasingStyle.none);
    }
    
    public void setScorern02(String  p, DTOCasingStyle casingStyle)
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
       markScorern02AsDirty(!equalsObject(scorern02, p));
       scorern02 = p;
    }

    // scorern03 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorern03Dirty()  { return checkFieldDirtiness(SCORERN03_DIRTYGROUP, SCORERN03_DIRTYMASK); }

    public java.lang.String   getScorern03()         { return scorern03; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorern03")
    public java.lang.String   getScorern03AsString() { return (scorern03 == null) ? "" : scorern03; }

    // scorern03 setter methods.
    
    protected void markScorern03AsDirty(boolean aFlag)  { markFieldAsDirty(SCORERN03_DIRTYGROUP, SCORERN03_DIRTYMASK, aFlag); }


    public void setScorern03(String  p)
    {
       setScorern03(p, DTOCasingStyle.none);
    }
    
    public void setScorern03(String  p, DTOCasingStyle casingStyle)
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
       markScorern03AsDirty(!equalsObject(scorern03, p));
       scorern03 = p;
    }

    // scorern04 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorern04Dirty()  { return checkFieldDirtiness(SCORERN04_DIRTYGROUP, SCORERN04_DIRTYMASK); }

    public java.lang.String   getScorern04()         { return scorern04; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorern04")
    public java.lang.String   getScorern04AsString() { return (scorern04 == null) ? "" : scorern04; }

    // scorern04 setter methods.
    
    protected void markScorern04AsDirty(boolean aFlag)  { markFieldAsDirty(SCORERN04_DIRTYGROUP, SCORERN04_DIRTYMASK, aFlag); }


    public void setScorern04(String  p)
    {
       setScorern04(p, DTOCasingStyle.none);
    }
    
    public void setScorern04(String  p, DTOCasingStyle casingStyle)
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
       markScorern04AsDirty(!equalsObject(scorern04, p));
       scorern04 = p;
    }

    // scorern05 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorern05Dirty()  { return checkFieldDirtiness(SCORERN05_DIRTYGROUP, SCORERN05_DIRTYMASK); }

    public java.lang.String   getScorern05()         { return scorern05; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorern05")
    public java.lang.String   getScorern05AsString() { return (scorern05 == null) ? "" : scorern05; }

    // scorern05 setter methods.
    
    protected void markScorern05AsDirty(boolean aFlag)  { markFieldAsDirty(SCORERN05_DIRTYGROUP, SCORERN05_DIRTYMASK, aFlag); }


    public void setScorern05(String  p)
    {
       setScorern05(p, DTOCasingStyle.none);
    }
    
    public void setScorern05(String  p, DTOCasingStyle casingStyle)
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
       markScorern05AsDirty(!equalsObject(scorern05, p));
       scorern05 = p;
    }

    // scorern06 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorern06Dirty()  { return checkFieldDirtiness(SCORERN06_DIRTYGROUP, SCORERN06_DIRTYMASK); }

    public java.lang.String   getScorern06()         { return scorern06; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorern06")
    public java.lang.String   getScorern06AsString() { return (scorern06 == null) ? "" : scorern06; }

    // scorern06 setter methods.
    
    protected void markScorern06AsDirty(boolean aFlag)  { markFieldAsDirty(SCORERN06_DIRTYGROUP, SCORERN06_DIRTYMASK, aFlag); }


    public void setScorern06(String  p)
    {
       setScorern06(p, DTOCasingStyle.none);
    }
    
    public void setScorern06(String  p, DTOCasingStyle casingStyle)
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
       markScorern06AsDirty(!equalsObject(scorern06, p));
       scorern06 = p;
    }

    // scorern07 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorern07Dirty()  { return checkFieldDirtiness(SCORERN07_DIRTYGROUP, SCORERN07_DIRTYMASK); }

    public java.lang.String   getScorern07()         { return scorern07; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorern07")
    public java.lang.String   getScorern07AsString() { return (scorern07 == null) ? "" : scorern07; }

    // scorern07 setter methods.
    
    protected void markScorern07AsDirty(boolean aFlag)  { markFieldAsDirty(SCORERN07_DIRTYGROUP, SCORERN07_DIRTYMASK, aFlag); }


    public void setScorern07(String  p)
    {
       setScorern07(p, DTOCasingStyle.none);
    }
    
    public void setScorern07(String  p, DTOCasingStyle casingStyle)
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
       markScorern07AsDirty(!equalsObject(scorern07, p));
       scorern07 = p;
    }

    // scorern08 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorern08Dirty()  { return checkFieldDirtiness(SCORERN08_DIRTYGROUP, SCORERN08_DIRTYMASK); }

    public java.lang.String   getScorern08()         { return scorern08; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorern08")
    public java.lang.String   getScorern08AsString() { return (scorern08 == null) ? "" : scorern08; }

    // scorern08 setter methods.
    
    protected void markScorern08AsDirty(boolean aFlag)  { markFieldAsDirty(SCORERN08_DIRTYGROUP, SCORERN08_DIRTYMASK, aFlag); }


    public void setScorern08(String  p)
    {
       setScorern08(p, DTOCasingStyle.none);
    }
    
    public void setScorern08(String  p, DTOCasingStyle casingStyle)
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
       markScorern08AsDirty(!equalsObject(scorern08, p));
       scorern08 = p;
    }

    // scorern09 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorern09Dirty()  { return checkFieldDirtiness(SCORERN09_DIRTYGROUP, SCORERN09_DIRTYMASK); }

    public java.lang.String   getScorern09()         { return scorern09; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorern09")
    public java.lang.String   getScorern09AsString() { return (scorern09 == null) ? "" : scorern09; }

    // scorern09 setter methods.
    
    protected void markScorern09AsDirty(boolean aFlag)  { markFieldAsDirty(SCORERN09_DIRTYGROUP, SCORERN09_DIRTYMASK, aFlag); }


    public void setScorern09(String  p)
    {
       setScorern09(p, DTOCasingStyle.none);
    }
    
    public void setScorern09(String  p, DTOCasingStyle casingStyle)
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
       markScorern09AsDirty(!equalsObject(scorern09, p));
       scorern09 = p;
    }

    // scorern10 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorern10Dirty()  { return checkFieldDirtiness(SCORERN10_DIRTYGROUP, SCORERN10_DIRTYMASK); }

    public java.lang.String   getScorern10()         { return scorern10; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorern10")
    public java.lang.String   getScorern10AsString() { return (scorern10 == null) ? "" : scorern10; }

    // scorern10 setter methods.
    
    protected void markScorern10AsDirty(boolean aFlag)  { markFieldAsDirty(SCORERN10_DIRTYGROUP, SCORERN10_DIRTYMASK, aFlag); }


    public void setScorern10(String  p)
    {
       setScorern10(p, DTOCasingStyle.none);
    }
    
    public void setScorern10(String  p, DTOCasingStyle casingStyle)
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
       markScorern10AsDirty(!equalsObject(scorern10, p));
       scorern10 = p;
    }

    // scorern11 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorern11Dirty()  { return checkFieldDirtiness(SCORERN11_DIRTYGROUP, SCORERN11_DIRTYMASK); }

    public java.lang.String   getScorern11()         { return scorern11; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorern11")
    public java.lang.String   getScorern11AsString() { return (scorern11 == null) ? "" : scorern11; }

    // scorern11 setter methods.
    
    protected void markScorern11AsDirty(boolean aFlag)  { markFieldAsDirty(SCORERN11_DIRTYGROUP, SCORERN11_DIRTYMASK, aFlag); }


    public void setScorern11(String  p)
    {
       setScorern11(p, DTOCasingStyle.none);
    }
    
    public void setScorern11(String  p, DTOCasingStyle casingStyle)
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
       markScorern11AsDirty(!equalsObject(scorern11, p));
       scorern11 = p;
    }

    // scorern12 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorern12Dirty()  { return checkFieldDirtiness(SCORERN12_DIRTYGROUP, SCORERN12_DIRTYMASK); }

    public java.lang.String   getScorern12()         { return scorern12; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorern12")
    public java.lang.String   getScorern12AsString() { return (scorern12 == null) ? "" : scorern12; }

    // scorern12 setter methods.
    
    protected void markScorern12AsDirty(boolean aFlag)  { markFieldAsDirty(SCORERN12_DIRTYGROUP, SCORERN12_DIRTYMASK, aFlag); }


    public void setScorern12(String  p)
    {
       setScorern12(p, DTOCasingStyle.none);
    }
    
    public void setScorern12(String  p, DTOCasingStyle casingStyle)
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
       markScorern12AsDirty(!equalsObject(scorern12, p));
       scorern12 = p;
    }

    // scorern13 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorern13Dirty()  { return checkFieldDirtiness(SCORERN13_DIRTYGROUP, SCORERN13_DIRTYMASK); }

    public java.lang.String   getScorern13()         { return scorern13; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorern13")
    public java.lang.String   getScorern13AsString() { return (scorern13 == null) ? "" : scorern13; }

    // scorern13 setter methods.
    
    protected void markScorern13AsDirty(boolean aFlag)  { markFieldAsDirty(SCORERN13_DIRTYGROUP, SCORERN13_DIRTYMASK, aFlag); }


    public void setScorern13(String  p)
    {
       setScorern13(p, DTOCasingStyle.none);
    }
    
    public void setScorern13(String  p, DTOCasingStyle casingStyle)
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
       markScorern13AsDirty(!equalsObject(scorern13, p));
       scorern13 = p;
    }

    // scorern14 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorern14Dirty()  { return checkFieldDirtiness(SCORERN14_DIRTYGROUP, SCORERN14_DIRTYMASK); }

    public java.lang.String   getScorern14()         { return scorern14; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorern14")
    public java.lang.String   getScorern14AsString() { return (scorern14 == null) ? "" : scorern14; }

    // scorern14 setter methods.
    
    protected void markScorern14AsDirty(boolean aFlag)  { markFieldAsDirty(SCORERN14_DIRTYGROUP, SCORERN14_DIRTYMASK, aFlag); }


    public void setScorern14(String  p)
    {
       setScorern14(p, DTOCasingStyle.none);
    }
    
    public void setScorern14(String  p, DTOCasingStyle casingStyle)
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
       markScorern14AsDirty(!equalsObject(scorern14, p));
       scorern14 = p;
    }

    // scorern15 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isScorern15Dirty()  { return checkFieldDirtiness(SCORERN15_DIRTYGROUP, SCORERN15_DIRTYMASK); }

    public java.lang.String   getScorern15()         { return scorern15; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "scorern15")
    public java.lang.String   getScorern15AsString() { return (scorern15 == null) ? "" : scorern15; }

    // scorern15 setter methods.
    
    protected void markScorern15AsDirty(boolean aFlag)  { markFieldAsDirty(SCORERN15_DIRTYGROUP, SCORERN15_DIRTYMASK, aFlag); }


    public void setScorern15(String  p)
    {
       setScorern15(p, DTOCasingStyle.none);
    }
    
    public void setScorern15(String  p, DTOCasingStyle casingStyle)
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
       markScorern15AsDirty(!equalsObject(scorern15, p));
       scorern15 = p;
    }

    // rectimestamp getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRectimestampDirty()  { return checkFieldDirtiness(RECTIMESTAMP_DIRTYGROUP, RECTIMESTAMP_DIRTYMASK); }

    @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
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

    // yachtbsf getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isYachtbsfDirty()  { return checkFieldDirtiness(YACHTBSF_DIRTYGROUP, YACHTBSF_DIRTYMASK); }

    public java.lang.Float   getYachtbsf() { return yachtbsf; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "yachtbsf")
    public String getYachtbsfAsString() { return floatAsString(yachtbsf); }

    // yachtbsf setter methods.
    
    protected void markYachtbsfAsDirty(boolean aFlag)  { markFieldAsDirty(YACHTBSF_DIRTYGROUP, YACHTBSF_DIRTYMASK, aFlag); }


    public void setYachtbsf(java.lang.Float  p)
    {
    	markYachtbsfAsDirty(!equalsObject(yachtbsf, p));
    	yachtbsf = p;
    }
    public void setYachtbsf()
    {
    	setYachtbsf((java.lang.Float)null);
    }
    public void setYachtbsf(String  p)
    {
    	setYachtbsf(stringAsFloat(p));
    }

    // yachtgph getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isYachtgphDirty()  { return checkFieldDirtiness(YACHTGPH_DIRTYGROUP, YACHTGPH_DIRTYMASK); }

    public java.lang.Float   getYachtgph() { return yachtgph; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "yachtgph")
    public String getYachtgphAsString() { return floatAsString(yachtgph); }

    // yachtgph setter methods.
    
    protected void markYachtgphAsDirty(boolean aFlag)  { markFieldAsDirty(YACHTGPH_DIRTYGROUP, YACHTGPH_DIRTYMASK, aFlag); }


    public void setYachtgph(java.lang.Float  p)
    {
    	markYachtgphAsDirty(!equalsObject(yachtgph, p));
    	yachtgph = p;
    }
    public void setYachtgph()
    {
    	setYachtgph((java.lang.Float)null);
    }
    public void setYachtgph(String  p)
    {
    	setYachtgph(stringAsFloat(p));
    }

}
