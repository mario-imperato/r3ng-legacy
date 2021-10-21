package org.r3.ws.system.classifiers;

import javax.ws.rs.QueryParam;

import org.r3.db.DTOBase;
import org.r3.db.system.classifieritem.ClassifierItemCriteria;
import org.r3.db.system.classifieritem.ClassifierItemFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class ClassifierItemQueryActionForm extends DataTableQueryActionForm
{
	@QueryParam("classifieritemdepth")
    private String classifieritemdepth;

    public String getClassifieritemdepth()
    {    	
    	return DTOBase.nullOnEmpty(classifieritemdepth);
    }
    
    public int getClassifieritemdepthAsInt()
    {    	
    	String d = getClassifieritemdepth();
    	if (d != null)
    		return Integer.parseInt(d);
    	    	
    	return 0;
    }
    
    
	public ClassifierItemFilter getSearchCondition(String aSite, String aClsId)
	{
		ClassifierItemFilter filter = new ClassifierItemFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" classifieritemorder asc ");
		else filter.setOrderByClause(getSortingCondition());
				
		ClassifierItemCriteria c = filter.or()
		   .andSiteEqualTo(aSite)
		   .andClsidEqualTo(aClsId)
		   ;
		
		c.andClassifieritemdepthEqualTo(getClassifieritemdepthAsInt());
		return filter;
	}
}
