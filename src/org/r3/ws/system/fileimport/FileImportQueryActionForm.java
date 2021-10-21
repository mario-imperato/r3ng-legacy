package org.r3.ws.system.fileimport;

import org.r3.db.system.fileimport.fileimport.FileImportCriteria;
import org.r3.db.system.fileimport.fileimport.FileImportFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class FileImportQueryActionForm extends DataTableQueryActionForm
{    
		
	public FileImportFilter getSearchCondition(String aSite)
	{
		FileImportFilter filter = new FileImportFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" importid asc ");
		else filter.setOrderByClause(getSortingCondition());
				
		FileImportCriteria criteria = filter.or().andSiteEqualTo(aSite);
		
		return filter;
	}
}
