package org.r3.db.system.metadata.tmetadataview;

import org.r3.db.PersistenceDTOValidator;

public class TableColumnsMetadataDTOValidator implements PersistenceDTOValidator
{
	private TableColumnsMetadataLUT aLut;

	public TableColumnsMetadataDTOValidator(TableColumnsMetadataLUT aLutOfValues)
	{
		aLut = aLutOfValues;
	}

	@Override
	public String validate(String aTableName, String aColumnName, String aValue) throws IllegalArgumentException
	{
		return validate(aTableName, aColumnName, aValue, false);
	}
	
	@Override
	public String validate(String aTableName, String aColumnName, String aValue, boolean allowTrim) throws IllegalArgumentException
	{
		String dtoKey = TableColumnsMetadataDTO.getDtokey(null, aTableName, aColumnName);

		try
		{
			/*
			Iterator i = aLut.getInstance().elements();
			while (i.hasNext())
			{
				TableMetadataViewDTO item = (TableMetadataViewDTO) i.next();
				System.out.printf("DTO Validation - Converting %s\n", item.getDtokey());
			}
			 */
			
			TableColumnsMetadataDTO lutItem = aLut.getItem(dtoKey);
			if (lutItem == null)
				throw new IllegalArgumentException("Metdata Dictionary - Cannot Find DTO 4: " + dtoKey);
			
			if (aValue != null && aValue.length() > lutItem.getData_length())
			{
				aValue = trim(aValue, (int)lutItem.getData_lengthAsLong());
			}
			
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
		
		return aValue;
	}

    private String trim(String s, int maxLength)
    {
    	if (s == null || s.length() == 0)
            return null;
    	
    	if (s.length() > maxLength)
    	{
    		int trimToLength = maxLength;
    		if (maxLength > 50)
    		{
    			trimToLength = maxLength - 3;
        		StringBuilder stb = new StringBuilder();
        		stb.append(s.substring(0, trimToLength)).append("...");
        		s = stb.toString();
    		}
    		else 
    			s = s.substring(0, trimToLength);    		    		
    	}
    	
    	return s;
    }
    
}
