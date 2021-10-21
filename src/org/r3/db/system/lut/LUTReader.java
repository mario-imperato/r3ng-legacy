package org.r3.db.system.lut;

public abstract class LUTReader
{
	  public abstract LUTTable readLUT() throws LUTException;
	
	  protected void postReadLUTProcessing(LUTTable lutTable) throws LUTException
	  {
	  }

	  protected void addToTable(LUTTable table, ILUTItem item)  throws LUTException
	  {
	  	table.setItem(item.getDtokey(), item);
	  }

}
