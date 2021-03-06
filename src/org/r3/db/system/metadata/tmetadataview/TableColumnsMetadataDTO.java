//
// generated by jGAMe Software - GPA Gruppo Progetti Avanzati s.r.l. 2016-2017
//
//
// README Section
//


package org.r3.db.system.metadata.tmetadataview;

public class TableColumnsMetadataDTO extends TableColumnsMetadataDTOBase
{
    public TableColumnsMetadataDTO()
    {
        super();
    }

    public TableColumnsMetadataDTO(TableColumnsMetadataDTO another)
    {
        super(another);
    }

    public static String getDtokey(String aSchema, String aTableName, String aColumnName)
	{
		StringBuilder stb = new StringBuilder();
		
		if (aSchema != null)
		{
			stb.append(aSchema.toUpperCase());
			stb.append(".");
		}
		
		stb.append(aTableName != null ? aTableName.toUpperCase() : aTableName);
		stb.append(".");
		stb.append(aColumnName != null ? aColumnName.toUpperCase() : aColumnName);
		return stb.toString();
	}
	
	public String getDtokey()
	{
		return getDtokey(true);
	}

	public String getDtokey(boolean suppressSchema)
	{
		if (suppressSchema)
		  return getDtokey(null, getTable_name(), getColumn_name());
		
		return getDtokey(getTable_schema(), getTable_name(), getColumn_name());
	}

}
