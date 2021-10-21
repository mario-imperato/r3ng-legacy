package org.r3.db;

public interface PersistenceDTOValidator
{
	String validate(String aTableName, String aColumnName, String aValue)
	   throws IllegalArgumentException;

	String validate(String aTableName, String aColumnName, String aValue, boolean allowTrim)
			   throws IllegalArgumentException;
}
