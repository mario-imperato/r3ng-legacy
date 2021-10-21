package org.r3.db.utils;



import javax.ws.rs.QueryParam;

import org.r3.db.DTOBase;

public class DataTableQueryActionForm
{
	private boolean executeCount;
	public enum SortingDirection { asc, desc };
	
	public DataTableQueryActionForm()
	{
	    sEcho = "1";
	    iDisplayStart = 0;
	    iDisplayLength = -1;
        executeCount = true;
	}
	
	@QueryParam("sEcho")
    private String sEcho;

	public String getsEcho()
	{
		return sEcho;
	}

	@QueryParam("sSearch")
    private String sSearch;

	public String getsSearch()
	{
		return DTOBase.nullOnEmpty(sSearch);
	}
	
//	public void setsEcho(String sEcho)
//	{
//		this.sEcho = sEcho;
//	}

	@QueryParam("iDisplayLength")
	private int iDisplayLength;

	public int getiDisplayLength()
	{
		return iDisplayLength;
	}

//	public void setiDisplayLength(int iDisplayLength)
//	{
//		this.iDisplayLength = iDisplayLength;
//	}

	@QueryParam("iDisplayStart")
	private int iDisplayStart;

	public int getiDisplayStart()
	{
		return iDisplayStart;
	}

	public boolean queryIsRowBounded()
	{
		return iDisplayStart >= 0 && iDisplayLength > 0;
	}
	
	public boolean isExecuteCount()
	{
		return executeCount;
	}

	public void setExecuteCount(boolean executeCount)
	{
		this.executeCount = executeCount;
	}

//	public void setiDisplayStart(int iDisplayStart)
//	{
//		this.iDisplayStart = iDisplayStart;
//	}
	
	@QueryParam("sColumns")
	private String sColumns;

	public String getsColumns()
	{
		return sColumns;
	}

	public String getsColumns(int indexOfColumn)
	{
		if (sColumns == null)
			return null;
		
		String[] sColumnsArray = sColumns.split(",");
		if (sColumnsArray == null || sColumnsArray.length <= indexOfColumn)
			return null;
		
		return sColumnsArray[indexOfColumn];
	}

	@QueryParam("sSortDir_0")
	private String sSortDir_0;

	public String getsSortDir_0()
	{
		return sSortDir_0;
	}

	public SortingDirection getsSortDir_0_AsEnum()
	{
	    if (sSortDir_0 != null)
	    	return SortingDirection.valueOf(sSortDir_0);
	    
	    return SortingDirection.asc;
	}
	
	@QueryParam("iSortingCols")
	private int iSortingCols;

	public int getiSortingCols()
	{
		return iSortingCols;
	}

	@QueryParam("iSortCol_0")
	private int iSortCol_0;

	public int getiSortCol_0()
	{
		return iSortCol_0;
	}

    public boolean isDefaultSorting()
    {
        if (iSortingCols == 0)
        	return true;
        
        return false;
    }
    
    public String getSortingCondition()
    {
        if (isDefaultSorting())
        	return null;
        
        String colName = getsColumns(getiSortCol_0());
        if (colName == null)
        	return null;
        
        if (getsSortDir_0() == null)
        	return null;
        
        return String.format("%s %s", colName, getsSortDir_0());        
    }

    public String getMongoSortingCondition()
    {
        if (isDefaultSorting())
        	return null;
        
        String colName = getsColumns(getiSortCol_0());
        if (colName == null)
        	return null;
        
        if (getsSortDir_0() == null)
        	return null;
        
        String sortExpression = "";
        if (getsSortDir_0().equalsIgnoreCase("ASC"))
        {
        	sortExpression = String.format("%s", colName);
        }
        else 
        {
        	sortExpression = String.format("-%s", colName);
        }
        	
        return sortExpression;        
    }

}
