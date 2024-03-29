//
// generated by jGAMe Software - GPA Gruppo Progetti Avanzati s.r.l. 2016-2017
//
//
// README Section
//


package org.r3.db.sailevent.attendancesheetview;

import org.r3.db.utils.*;

public class SailAttendanceSheetViewDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  eventid;
    protected java.lang.String  applicationid;
    protected java.lang.String  yachtname;
    protected java.lang.String  plate;
    protected java.lang.String  sailnumber;
    protected java.lang.String  completionstatus;
    protected java.lang.String  sheetid;
    protected java.lang.String  attendanceyesparam;
    protected java.lang.String  attendanceyes;
    protected java.lang.String  crewregularparam;
    protected java.lang.String  crewregular;

    public static final java.lang.String EVENTID_DEFAULT  =  null;
    public static final java.lang.String APPLICATIONID_DEFAULT  =  null;
    public static final java.lang.String YACHTNAME_DEFAULT  =  null;
    public static final java.lang.String PLATE_DEFAULT  =  null;
    public static final java.lang.String SAILNUMBER_DEFAULT  =  null;
    public static final java.lang.String COMPLETIONSTATUS_DEFAULT  =  null;
    public static final java.lang.String SHEETID_DEFAULT  =  null;
    public static final java.lang.String ATTENDANCEYESPARAM_DEFAULT  =  null;
    public static final java.lang.String ATTENDANCEYES_DEFAULT  =  null;
    public static final java.lang.String CREWREGULARPARAM_DEFAULT  =  null;
    public static final java.lang.String CREWREGULAR_DEFAULT  =  null;

    public static final int EVENTID_DIRTYGROUP  =  0;
    public static final int EVENTID_DIRTYMASK   =  1;
    public static final int APPLICATIONID_DIRTYGROUP  =  0;
    public static final int APPLICATIONID_DIRTYMASK   =  2;
    public static final int YACHTNAME_DIRTYGROUP  =  0;
    public static final int YACHTNAME_DIRTYMASK   =  4;
    public static final int PLATE_DIRTYGROUP  =  0;
    public static final int PLATE_DIRTYMASK   =  8;
    public static final int SAILNUMBER_DIRTYGROUP  =  0;
    public static final int SAILNUMBER_DIRTYMASK   =  16;
    public static final int COMPLETIONSTATUS_DIRTYGROUP  =  0;
    public static final int COMPLETIONSTATUS_DIRTYMASK   =  32;
    public static final int SHEETID_DIRTYGROUP  =  0;
    public static final int SHEETID_DIRTYMASK   =  64;
    public static final int ATTENDANCEYESPARAM_DIRTYGROUP  =  0;
    public static final int ATTENDANCEYESPARAM_DIRTYMASK   =  128;
    public static final int ATTENDANCEYES_DIRTYGROUP  =  0;
    public static final int ATTENDANCEYES_DIRTYMASK   =  256;
    public static final int CREWREGULARPARAM_DIRTYGROUP  =  0;
    public static final int CREWREGULARPARAM_DIRTYMASK   =  512;
    public static final int CREWREGULAR_DIRTYGROUP  =  0;
    public static final int CREWREGULAR_DIRTYMASK   =  1024;


    /**
      * DataBean constructor.
      */
    public SailAttendanceSheetViewDTOBase()
    {
       dirtyFlagsArray = new int[11 / 30 + 1];
       clearDirtyFlags();

       eventid = EVENTID_DEFAULT;
       applicationid = APPLICATIONID_DEFAULT;
       yachtname = YACHTNAME_DEFAULT;
       plate = PLATE_DEFAULT;
       sailnumber = SAILNUMBER_DEFAULT;
       completionstatus = COMPLETIONSTATUS_DEFAULT;
       sheetid = SHEETID_DEFAULT;
       attendanceyesparam = ATTENDANCEYESPARAM_DEFAULT;
       attendanceyes = ATTENDANCEYES_DEFAULT;
       crewregularparam = CREWREGULARPARAM_DEFAULT;
       crewregular = CREWREGULAR_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public SailAttendanceSheetViewDTOBase(SailAttendanceSheetViewDTOBase another)
    {

       eventid = another.getEventid();
       applicationid = another.getApplicationid();
       yachtname = another.getYachtname();
       plate = another.getPlate();
       sailnumber = another.getSailnumber();
       completionstatus = another.getCompletionstatus();
       sheetid = another.getSheetid();
       attendanceyesparam = another.getAttendanceyesparam();
       attendanceyes = another.getAttendanceyes();
       crewregularparam = another.getCrewregularparam();
       crewregular = another.getCrewregular();

       dirtyFlagsArray = another.getCopyOfDirtyFlags();
    }

    public void clearDirtyFlags()
    {
       for(int i = 0; i < dirtyFlagsArray.length; i++)
            dirtyFlagsArray[i] = 0;
    }

    @com.fasterxml.jackson.annotation.JsonIgnore
    public int[] getCopyOfDirtyFlags()
    {
       int[] copyOf = new int[dirtyFlagsArray.length];
       for(int i = 0; i < dirtyFlagsArray.length; i++)
            copyOf[i] = dirtyFlagsArray[i];

       return copyOf;
    }

    @com.fasterxml.jackson.annotation.JsonIgnore
    public boolean isDirty()
    {
    	for(int i = 0; i < dirtyFlagsArray.length; i++)
    	if (dirtyFlagsArray[i] != 0)
    		return true;
    	
    	return false;
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

    // eventid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    public boolean isEventidDirty()  { return checkFieldDirtiness(EVENTID_DIRTYGROUP, EVENTID_DIRTYMASK); }

    public java.lang.String   getEventid()         { return eventid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
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

    // applicationid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    public boolean isApplicationidDirty()  { return checkFieldDirtiness(APPLICATIONID_DIRTYGROUP, APPLICATIONID_DIRTYMASK); }

    public java.lang.String   getApplicationid()         { return applicationid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
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

    // yachtname getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    public boolean isYachtnameDirty()  { return checkFieldDirtiness(YACHTNAME_DIRTYGROUP, YACHTNAME_DIRTYMASK); }

    public java.lang.String   getYachtname()         { return yachtname; }
    @com.fasterxml.jackson.annotation.JsonIgnore
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

    // plate getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    public boolean isPlateDirty()  { return checkFieldDirtiness(PLATE_DIRTYGROUP, PLATE_DIRTYMASK); }

    public java.lang.String   getPlate()         { return plate; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    public java.lang.String   getPlateAsString() { return (plate == null) ? "" : plate; }

    // plate setter methods.
    
    protected void markPlateAsDirty(boolean aFlag)  { markFieldAsDirty(PLATE_DIRTYGROUP, PLATE_DIRTYMASK, aFlag); }


    public void setPlate(String  p)
    {
       setPlate(p, DTOCasingStyle.none);
    }
    
    public void setPlate(String  p, DTOCasingStyle casingStyle)
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
       markPlateAsDirty(!equalsObject(plate, p));
       plate = p;
    }

    // sailnumber getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    public boolean isSailnumberDirty()  { return checkFieldDirtiness(SAILNUMBER_DIRTYGROUP, SAILNUMBER_DIRTYMASK); }

    public java.lang.String   getSailnumber()         { return sailnumber; }
    @com.fasterxml.jackson.annotation.JsonIgnore
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

    // completionstatus getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    public boolean isCompletionstatusDirty()  { return checkFieldDirtiness(COMPLETIONSTATUS_DIRTYGROUP, COMPLETIONSTATUS_DIRTYMASK); }

    public java.lang.String   getCompletionstatus()         { return completionstatus; }
    @com.fasterxml.jackson.annotation.JsonIgnore
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

    // sheetid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    public boolean isSheetidDirty()  { return checkFieldDirtiness(SHEETID_DIRTYGROUP, SHEETID_DIRTYMASK); }

    public java.lang.String   getSheetid()         { return sheetid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    public java.lang.String   getSheetidAsString() { return (sheetid == null) ? "" : sheetid; }

    // sheetid setter methods.
    
    protected void markSheetidAsDirty(boolean aFlag)  { markFieldAsDirty(SHEETID_DIRTYGROUP, SHEETID_DIRTYMASK, aFlag); }


    public void setSheetid(String  p)
    {
       setSheetid(p, DTOCasingStyle.none);
    }
    
    public void setSheetid(String  p, DTOCasingStyle casingStyle)
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
       markSheetidAsDirty(!equalsObject(sheetid, p));
       sheetid = p;
    }

    // attendanceyesparam getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    public boolean isAttendanceyesparamDirty()  { return checkFieldDirtiness(ATTENDANCEYESPARAM_DIRTYGROUP, ATTENDANCEYESPARAM_DIRTYMASK); }

    public java.lang.String   getAttendanceyesparam()         { return attendanceyesparam; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    public java.lang.String   getAttendanceyesparamAsString() { return (attendanceyesparam == null) ? "" : attendanceyesparam; }

    // attendanceyesparam setter methods.
    
    protected void markAttendanceyesparamAsDirty(boolean aFlag)  { markFieldAsDirty(ATTENDANCEYESPARAM_DIRTYGROUP, ATTENDANCEYESPARAM_DIRTYMASK, aFlag); }


    public void setAttendanceyesparam(String  p)
    {
       setAttendanceyesparam(p, DTOCasingStyle.none);
    }
    
    public void setAttendanceyesparam(String  p, DTOCasingStyle casingStyle)
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
       markAttendanceyesparamAsDirty(!equalsObject(attendanceyesparam, p));
       attendanceyesparam = p;
    }

    // attendanceyes getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    public boolean isAttendanceyesDirty()  { return checkFieldDirtiness(ATTENDANCEYES_DIRTYGROUP, ATTENDANCEYES_DIRTYMASK); }

    public java.lang.String   getAttendanceyes()         { return attendanceyes; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    public java.lang.String   getAttendanceyesAsString() { return (attendanceyes == null) ? "" : attendanceyes; }

    // attendanceyes setter methods.
    
    protected void markAttendanceyesAsDirty(boolean aFlag)  { markFieldAsDirty(ATTENDANCEYES_DIRTYGROUP, ATTENDANCEYES_DIRTYMASK, aFlag); }


    public void setAttendanceyes(String  p)
    {
       setAttendanceyes(p, DTOCasingStyle.none);
    }
    
    public void setAttendanceyes(String  p, DTOCasingStyle casingStyle)
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
       markAttendanceyesAsDirty(!equalsObject(attendanceyes, p));
       attendanceyes = p;
    }

    // crewregularparam getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    public boolean isCrewregularparamDirty()  { return checkFieldDirtiness(CREWREGULARPARAM_DIRTYGROUP, CREWREGULARPARAM_DIRTYMASK); }

    public java.lang.String   getCrewregularparam()         { return crewregularparam; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    public java.lang.String   getCrewregularparamAsString() { return (crewregularparam == null) ? "" : crewregularparam; }

    // crewregularparam setter methods.
    
    protected void markCrewregularparamAsDirty(boolean aFlag)  { markFieldAsDirty(CREWREGULARPARAM_DIRTYGROUP, CREWREGULARPARAM_DIRTYMASK, aFlag); }


    public void setCrewregularparam(String  p)
    {
       setCrewregularparam(p, DTOCasingStyle.none);
    }
    
    public void setCrewregularparam(String  p, DTOCasingStyle casingStyle)
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
       markCrewregularparamAsDirty(!equalsObject(crewregularparam, p));
       crewregularparam = p;
    }

    // crewregular getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    public boolean isCrewregularDirty()  { return checkFieldDirtiness(CREWREGULAR_DIRTYGROUP, CREWREGULAR_DIRTYMASK); }

    public java.lang.String   getCrewregular()         { return crewregular; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    public java.lang.String   getCrewregularAsString() { return (crewregular == null) ? "" : crewregular; }

    // crewregular setter methods.
    
    protected void markCrewregularAsDirty(boolean aFlag)  { markFieldAsDirty(CREWREGULAR_DIRTYGROUP, CREWREGULAR_DIRTYMASK, aFlag); }


    public void setCrewregular(String  p)
    {
       setCrewregular(p, DTOCasingStyle.none);
    }
    
    public void setCrewregular(String  p, DTOCasingStyle casingStyle)
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
       markCrewregularAsDirty(!equalsObject(crewregular, p));
       crewregular = p;
    }

}
