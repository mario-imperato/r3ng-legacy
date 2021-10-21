package org.r3.db;

public class PersistenceConfigInfo implements Cloneable
{
	private String dbToken;
    private String sequenceSubPrefix;
    private String targetTable;
    private boolean cloned;
    
	public PersistenceConfigInfo()
	{
		setDbToken("unepdbtoken");
	}

	public boolean isClonedFlag()
	{
		return cloned;
	}

	protected void setClonedFlag(boolean cloned)
	{
		this.cloned = cloned;
	}

	public String getTargetTable()
	{
		return targetTable;
	}

	public void setTargetTable(String targetTable)
	{
		this.targetTable = targetTable;
	}

	public String getDbToken()
	{
		return dbToken;
	}

	private void setDbToken(String dbToken)
	{
		this.dbToken = dbToken;
	}
	
	public Object clone() throws CloneNotSupportedException
	{		
		return super.clone();		
	}

	public String getSequenceSubPrefix()
	{
		return sequenceSubPrefix;
	}

	public void setSequenceSubPrefix(String sequenceSubPrefix)
	{
		this.sequenceSubPrefix = sequenceSubPrefix;
	}
	
}
