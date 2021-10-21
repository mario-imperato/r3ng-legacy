//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.fileimport.fileimportdata;

public class FileImportDataDTO extends FileImportDataDTOBase
{
	public enum FileImportRecordType 
	{
		header, datarecord;
		
		public static FileImportRecordType getValueFor(String s, FileImportRecordType defaultOptions)
		{
			if (s != null && s.length() > 0)
				return valueOf(s);
			
			return defaultOptions;
		}
	}
	
    public FileImportDataDTO()
    {
        super();
    }

    public FileImportDataDTO(FileImportDataDTO another)
    {
        super(another);
    }

	public boolean setColumn(int index, String aValue)
	{
		boolean rc = true;
		
        switch(index)
        {
        case 1:
        	setCol1(aValue);
        	break;
        case 2:
        	setCol2(aValue);
        	break;
        case 3:
        	setCol3(aValue);
        	break;
        case 4:
        	setCol4(aValue);
        	break;
        case 5:
        	setCol5(aValue);
        	break;
        case 6:
        	setCol6(aValue);
        	break;
        case 7:
        	setCol7(aValue);
        	break;
        case 8:
        	setCol8(aValue);
        	break;
        case 9:
        	setCol9(aValue);
        	break;
        case 10:
        	setCola(aValue);
        	break;
        case 11:
        	setColb(aValue);
        	break;
        case 12:
        	setColc(aValue);
        	break;
        case 13:
        	setCold(aValue);
        	break;
        case 14:
        	setCole(aValue);
        	break;
        case 15:
        	setColf(aValue);
        	break;
        default:
        	rc = false;
        }
		
        return rc;
	}

	public void clearColumns()
	{
		col1 = null;
		col2 = null;
		col3 = null;
		col4 = null;
		col5 = null;
		col6 = null;
		col7 = null;
		col8 = null;
		col9 = null;
		cola = null;
		colb = null;
		colc = null;
		cold = null;
		cole = null;
		colf = null;
	}

	public String getColumnValue(int i, int maxLength) throws Exception
	{
		String value = null;
		
        switch(i)
        {
        case 1:
        	value = getCol1();
        	break;
        case 2:
        	value = getCol2();
        	break;
        case 3:
        	value = getCol3();
        	break;
        case 4:
        	value = getCol4();
        	break;
        case 5:
        	value = getCol5();
        	break;
        case 6:
        	value = getCol6();
        	break;
        case 7:
        	value = getCol7();
        	break;
        case 8:
        	value = getCol8();
        	break;
        case 9:
        	value = getCol9();
        	break;
        case 10:
        	value = getCola();
        	break;
        case 11:
        	value = getColb();
        	break;
        case 12:
        	value = getColc();
        	break;
        case 13:
        	value = getCold();
        	break;
        case 14:
        	value = getCole();
        	break;
        case 15:
        	value = getColf();
        	break;
        default:
        	Exception e = new IndexOutOfBoundsException("FileImportDataDTO::getColumnValue - Index Out Of Range " + i);
        	throw e;
        }
		        
        if (value != null)
        { 
        	value = value.trim();
        	if (value.length() > maxLength)
        	{
        		value = value.substring(0, maxLength);
        	}
        }
        
		return value;
	}
	
	public String[] getColumnValueSplitted(int i, int maxLength, String aDelim) throws Exception
	{
		String v = getColumnValue(i, Integer.MAX_VALUE);
		if (v != null)
		{
			String[] arr = v.split(aDelim);
			if (arr != null && arr.length > 0)
			{
				for(int j = 0; j < arr.length; j++)
				{
					if (arr[j].length() > maxLength)
					{
						arr[j] = arr[j].substring(0, maxLength);
					}
				}
			}
			return arr;
		}
		
		return null;
	}
	
	public FileImportRecordType getRecordTypeAsEnum()
	{
		return FileImportRecordType.getValueFor(getRecordtype(), FileImportRecordType.datarecord);
	}
}
