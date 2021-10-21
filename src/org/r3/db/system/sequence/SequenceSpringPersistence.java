package org.r3.db.system.sequence;


public class SequenceSpringPersistence extends SequencePersistence
{
	private SequenceMapper mapper;
	
	public SequenceMapper getMapper()
	{
		return mapper;
	}

	public void setMapper(SequenceMapper mapper)
	{
		this.mapper = mapper;
	}

	@Override
    public String getSequence(String aSequencePrefix)
    {
	    System.out.println("001 - Before Selecting Sequence Value");
   		SequenceDTO s = mapper.selectbySequencecode(aSequencePrefix);
   		System.out.println("002 - After Selecting Sequence Value: " + s.getSequencevalue());    	    	
   		
   		int sValue = s.getSequencevalue();
   		s.setSequencevalue(sValue + 1);
   		mapper.updateByPrimaryKey(s);
   		System.out.println("003 - After Updating Sequence Value to: " + (sValue + 1));    	    	
   		
   		return String.valueOf(sValue); 
    }
}
