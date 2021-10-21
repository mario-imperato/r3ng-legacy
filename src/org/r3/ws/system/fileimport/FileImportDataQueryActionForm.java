package org.r3.ws.system.fileimport;

import org.r3.db.system.fileimport.fileimportdata.FileImportDataFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class FileImportDataQueryActionForm extends DataTableQueryActionForm
{		

	public FileImportDataFilter getSearchCondition(String aSite, String anImportId, int limitFetch)
	{
		FileImportDataFilter filter = new FileImportDataFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" importdataid asc ");
		else filter.setOrderByClause(getSortingCondition());
				
		filter.or().andSiteEqualTo(aSite).andImportidEqualTo(anImportId);
		filter.setLimitFetch((limitFetch > 0) ? limitFetch : 10);
		
		return filter;
	}

}
