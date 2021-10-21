package org.r3.db;

public class CountByDTO extends DTOBase
{
	private String dtokey;
	protected java.lang.Integer  count;
	protected java.lang.String   minvalue;
	protected java.lang.String   maxvalue;
	
	protected java.lang.Integer  minintvalue;
	protected java.lang.Integer  maxintvalue;
	
	public CountByDTO()
	{
	}
	
	@Override
    public String getDtokey()
    {
        return dtokey;	
    }
    
	public void setDtokey(String dtokey)
	{
		this.dtokey = dtokey;
	}

	public java.lang.Integer getCount()
	{
		return count;
	}

	public void setCount(java.lang.Integer count)
	{
		this.count = count;
	}

	public java.lang.String getMinvalue()
	{
		return minvalue;
	}

	public void setMinvalue(java.lang.String minvalue)
	{
		this.minvalue = minvalue;
	}

	public java.lang.String getMaxvalue()
	{
		return maxvalue;
	}

	public void setMaxvalue(java.lang.String maxvalue)
	{
		this.maxvalue = maxvalue;
	}

	public java.lang.Integer getMinintvalue()
	{
		return minintvalue;
	}

	public void setMinintvalue(java.lang.Integer minintvalue)
	{
		this.minintvalue = minintvalue;
	}

	public java.lang.Integer getMaxintvalue()
	{
		return maxintvalue;
	}

	public void setMaxintvalue(java.lang.Integer maxintvalue)
	{
		this.maxintvalue = maxintvalue;
	}

}
