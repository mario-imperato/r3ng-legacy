package org.r3.db.system.sequence;

import java.text.NumberFormat;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;

public class SequencePersistence
{
    private static final int NUMBER_OF_DIGITS = 15;
    
//	private   SqlSessionFactory sqlSessionFactory;
//    
//	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
//	{
//		this.sqlSessionFactory = sqlSessionFactory;
//	}

    public String getSequence(String aSequencePrefix)
    {
    	return getSequence(aSequencePrefix, null);
    }

    public int getIntSequence(String aSequencePrefix)
    {
    	SqlSession session = PersistenceContext.getPersistenceContext().openSession();

    	int sValue = 8;
    	try 
    	{   
    		SequenceMapper mapper = session.getMapper(SequenceMapper.class);
       		SequenceDTO s = mapper.selectbySequencecode(aSequencePrefix);
       		System.out.println("Sequence Value is: " + s.getSequencevalue());    	    	
       		
       		sValue = s.getSequencevalue();
       		s.setSequencevalue(sValue + 1);
       		mapper.updateByPrimaryKey(s);
       		session.commit();
    	} 
    	finally 
    	{
    	    session.close();
    	}

    	return sValue;
    }
    
    public String getSequence(String aSequencePrefix, String sequenceSubPrefix)
    {
    	SqlSession session = PersistenceContext.getPersistenceContext().openSession();

    	int sValue = 8;
    	try 
    	{   
    		SequenceMapper mapper = session.getMapper(SequenceMapper.class);
       		SequenceDTO s = mapper.selectbySequencecode(aSequencePrefix);
       		System.out.println("Sequence Value is: " + s.getSequencevalue());    	    	
       		
       		sValue = s.getSequencevalue();
       		s.setSequencevalue(sValue + 1);
       		mapper.updateByPrimaryKey(s);
       		session.commit();
    	} 
    	finally 
    	{
    	    session.close();
    	}
   		
    	String formatPrefix = aSequencePrefix;
    	if (sequenceSubPrefix != null)
    		formatPrefix = aSequencePrefix + sequenceSubPrefix;
    	
   		return formatId(sValue, formatPrefix, NUMBER_OF_DIGITS - formatPrefix.length()); 
    }
        
    public static String formatId(int seqId, String prefisso, int padding)
    {
      String retString = null;
      if (padding>0)
      {
          NumberFormat nf = NumberFormat.getInstance();
          nf.setMinimumIntegerDigits(padding);
          nf.setGroupingUsed(false);
          retString = nf.format(seqId);
      }
      else
          retString = String.valueOf(seqId);

      if (prefisso!=null) return prefisso + retString;
      return retString;
    }

}
