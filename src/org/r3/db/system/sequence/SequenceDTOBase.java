//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// GPA Web Framework, Copyright 2004, 2005
//
//
// TODO: Readme Section.
//

package org.r3.db.system.sequence;

public class SequenceDTOBase extends org.r3.db.DTOBase 
{
    int[] dirtyFlagsArray;
     
    protected java.lang.String  sequencecode;
    protected java.lang.Integer  sequencevalue;
    protected java.lang.String  sequencedescr;

    public static final java.lang.String SEQUENCECODE_DEFAULT  =  null;
    public static final java.lang.Integer SEQUENCEVALUE_DEFAULT  =  null;
    public static final java.lang.String SEQUENCEDESCR_DEFAULT  =  null;

    public static final int SEQUENCECODE_DIRTYGROUP  =  0;
    public static final int SEQUENCECODE_DIRTYMASK   =  1;    
    public static final int SEQUENCEVALUE_DIRTYGROUP  =  0;
    public static final int SEQUENCEVALUE_DIRTYMASK   =  2;    
    public static final int SEQUENCEDESCR_DIRTYGROUP  =  0;
    public static final int SEQUENCEDESCR_DIRTYMASK   =  4;    


    /**
      * DataBean constructor.
      */
    public SequenceDTOBase() 
    {    
       dirtyFlagsArray = new int[3 / 30 + 1];
       clearDirtyFlags();
              
       sequencecode = SEQUENCECODE_DEFAULT;
       sequencevalue = SEQUENCEVALUE_DEFAULT;
       sequencedescr = SEQUENCEDESCR_DEFAULT;
    }
    
    /**
      * Copy constructor.
      */    
    public SequenceDTOBase(SequenceDTOBase another) 
    {    	

       sequencecode = another.getSequencecode();
       sequencevalue = another.getSequencevalue();
       sequencedescr = another.getSequencedescr();

       dirtyFlagsArray = another.getCopyOfDirtyFlags();
    }
    
    public void clearDirtyFlags()
    {
       for(int i = 0; i < dirtyFlagsArray.length; i++)
            dirtyFlagsArray[i] = 0;
    }
    
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
       return (dirtyFlagsArray[mainIndex] = dirtyFlagsArray[mainIndex] & bitwiseIndex) != 0; 
    }
    
    /**
      * DataBean Getter And Setter Accessor
      */    

    // sequencecode getter methods.
    
    public boolean isSequencecodeDirty()  { return checkFieldDirtiness(SEQUENCECODE_DIRTYGROUP, SEQUENCECODE_DIRTYMASK); }

    public java.lang.String   getSequencecode()         { return sequencecode; }
    public java.lang.String   getSequencecodeAsString() { return (sequencecode == null) ? "" : sequencecode; }
    
    // sequencecode setter methods.
    
    protected void markSequencecodeAsDirty(boolean aFlag)  { markFieldAsDirty(SEQUENCECODE_DIRTYGROUP, SEQUENCECODE_DIRTYMASK, aFlag); }


    public void setSequencecode(String  p)
    {
    	 if (p != null)
    	 {
    	 	if (p.length() == 0)  p = null;
         }
         markSequencecodeAsDirty(!equalsObject(sequencecode, p));
         sequencecode = p;
    }

    // sequencevalue getter methods.
    
    public boolean isSequencevalueDirty()  { return checkFieldDirtiness(SEQUENCEVALUE_DIRTYGROUP, SEQUENCEVALUE_DIRTYMASK); }

    public java.lang.Integer   getSequencevalue() { return sequencevalue; }
    public String getSequencevalueAsString() { return integerAsString(sequencevalue); }
    public int    getSequencevalueAsInt()    { return sequencevalue != null ? sequencevalue.intValue() : 0; }
    
    // sequencevalue setter methods.
    
    protected void markSequencevalueAsDirty(boolean aFlag)  { markFieldAsDirty(SEQUENCEVALUE_DIRTYGROUP, SEQUENCEVALUE_DIRTYMASK, aFlag); }


    public void setSequencevalue(java.lang.Integer  p)
    {
        markSequencevalueAsDirty(!equalsObject(sequencevalue, p));
    	sequencevalue = p;
    }
    public void setSequencevalue(int p)
    {
    	setSequencevalue(new java.lang.Integer(p));
    }
    public void setSequencevalue()
    {
    	setSequencevalue(0);
    }
    public void setSequencevalue(String  p)
    {
    	setSequencevalue(stringAsInteger(p));
    }

    // sequencedescr getter methods.
    
    public boolean isSequencedescrDirty()  { return checkFieldDirtiness(SEQUENCEDESCR_DIRTYGROUP, SEQUENCEDESCR_DIRTYMASK); }

    public java.lang.String   getSequencedescr()         { return sequencedescr; }
    public java.lang.String   getSequencedescrAsString() { return (sequencedescr == null) ? "" : sequencedescr; }
    
    // sequencedescr setter methods.
    
    protected void markSequencedescrAsDirty(boolean aFlag)  { markFieldAsDirty(SEQUENCEDESCR_DIRTYGROUP, SEQUENCEDESCR_DIRTYMASK, aFlag); }


    public void setSequencedescr(String  p)
    {
    	 if (p != null)
    	 {
    	 	if (p.length() == 0)  p = null;
         }
         markSequencedescrAsDirty(!equalsObject(sequencedescr, p));
         sequencedescr = p;
    }

}
