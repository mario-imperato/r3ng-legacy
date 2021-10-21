package org.r3.system.util;

public class CSVStringBuilder
{
	private String leftSeparator;
	private String rightSeparator;
    private boolean isFirstItem;
    private boolean includeEmptyStrings;
	private StringBuilder stb;

    public CSVStringBuilder()
	{
		this(",", null, false);
	}

    public CSVStringBuilder(boolean includeEmptyStrings)
	{
		this(",", null, includeEmptyStrings);
	}

	public CSVStringBuilder(String aLeftSeparator, String aRightSeparator, boolean includeEmptyStringsParam)
	{
		if (aLeftSeparator == null)
			leftSeparator = ",";
		else
		{
			leftSeparator = aLeftSeparator;

			// Il destro lo considero solo se c'e' il sinistro.
			rightSeparator = aRightSeparator;
		}
		
		stb = null;
		isFirstItem = true;
		includeEmptyStrings = includeEmptyStringsParam;
	}

	public CSVStringBuilder append(Object o)
	{
		String aString = (o != null) ? o.toString() : null;
        return append(aString);		
	}

	public CSVStringBuilder append(String aString)
	{
		if (aString != null && (includeEmptyStrings || aString.trim().length() > 0))
		{
		if (stb == null)
			stb = new StringBuilder();
				
		// Inserisco il left solo se non e' il primo oppure se il right e' assegnato
		if (!isFirstItem || rightSeparator != null)
			stb.append(leftSeparator);
		
		stb.append(aString);
		
		if (rightSeparator != null)
			stb.append(rightSeparator);
				
		isFirstItem = false;
		}
		
		return this;
	}
	
	public String toString()
	{
		if (stb != null)
			return stb.toString();
		
		return null;
	}
}
