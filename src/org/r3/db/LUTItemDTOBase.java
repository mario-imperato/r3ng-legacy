package org.r3.db;

public class LUTItemDTOBase extends DTOBase
{
    private String dtokey;
    private String dtodescr;
    
	public LUTItemDTOBase()
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

	@Override
    public String getDtodescr()
    {
        return dtodescr;    	
    }
    
	public void setDtodescr(String dtodescr)
	{
		this.dtodescr = dtodescr;
	}
    
}
