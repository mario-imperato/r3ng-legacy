package org.r3.ws.system.classifiers;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.system.classifieritem.ClassifierItemDTO;

public class ClassifierItemActionForm
{
	@FormParam("clsitemid")
    private String clsitemid;

    public String getClsitemid()
    {    	
    	return DTOBase.nullOnEmpty(clsitemid);
    }

	@FormParam("clsitembusid")
    private String clsitembusid;

    public String getClsitembusid()
    {    	
    	return DTOBase.nullOnEmpty(clsitembusid);
    }

	@FormParam("classifieritemdescr")
    private String classifieritemdescr;

    public String getClassifieritemdescr()
    {    	
    	return DTOBase.nullOnEmpty(classifieritemdescr);
    }

	@FormParam("classifieritemorder")
    private String classifieritemorder;

    public String getClassifieritemorder()
    {    	
    	return DTOBase.nullOnEmpty(classifieritemorder);
    }

    public int getClassifieritemorderAsInt()
    {    	
    	String s = DTOBase.nullOnEmpty(classifieritemorder);
    	if (s != null)
    		return Integer.parseInt(s);
    	
    	return 99;
    }

    
	@FormParam("classifieritemiattr")
    private String classifieritemiattr;

    public String getClassifieritemiattr()
    {    	
    	return DTOBase.nullOnEmpty(classifieritemiattr);
    }

    public int getClassifieritemiattrAsInt()
    {    	
    	String s = DTOBase.nullOnEmpty(classifieritemiattr);
    	if (s != null)
    		return Integer.parseInt(s);
    	
    	return 0;
    }
    
	@FormParam("classifieritemsattr")
    private String classifieritemsattr;

    public String getClassifieritemsattr()
    {    	
    	return DTOBase.nullOnEmpty(classifieritemsattr);
    }
    
	@FormParam("subgroups")
    private String subgroups;

    public String getSubgroups()
    {    	
    	return DTOBase.nullOnEmpty(subgroups);
    }    
    
    public String[] getSubgroupsAsArray()
    {    	
    	String s = getSubgroups();

    	String[] sarr = null;
        if (s != null)
        {
        	sarr = DTOBase.string2Array(s, ",");
        }
        
        return sarr;
    }   
    
	public ClassifierItemDTO getDTO4Insert(String aSite, String aClsId)
	{
		ClassifierItemDTO dto = new ClassifierItemDTO();
		dto.setClsitemid(getClsitemid());
        dto.setSite(aSite);
        dto.setClsid(aClsId);
        
        dto.setClassifieritemdepth(0);
        dto.setClassifieritemiattr(getClassifieritemiattrAsInt());
        dto.setClassifieritemsattr(getClassifieritemsattr());
        dto.setClassifieritemorder(getClassifieritemorderAsInt());
        dto.setClassifieritemdescr(getClassifieritemdescr());        
        
        String s = getClsitembusid();
        if (s != null)
		   dto.setClsitembusid(s);
        else 
 		   dto.setClsitembusid(getClsitemid());
        
		return  dto;
	}

	public ClassifierItemDTO getDTO4Update(ClassifierItemDTO dto)
	{		        
        dto.setClassifieritemdepth(0);
        dto.setClassifieritemiattr(getClassifieritemiattrAsInt());
        dto.setClassifieritemsattr(getClassifieritemsattr());
        dto.setClassifieritemorder(getClassifieritemorderAsInt());
        dto.setClassifieritemdescr(getClassifieritemdescr()); 
        
        String s = getClsitembusid();
        if (s != null)
		   dto.setClsitembusid(s);
        else 
 		   dto.setClsitembusid(dto.getClsitemid());


       	return  dto;
	}

	public ClassifierItemDTO getDTO4SubgroupInsert(int i, String itemId, String itemDescr, String aSite, String aClsId, String parentClsitemid)
	{
		ClassifierItemDTO dto = new ClassifierItemDTO();
		dto.setClsitemid(itemId);
		dto.setClsitembusid(itemId);

		dto.setSite(aSite);
        dto.setClsid(aClsId);
        dto.setParentitemid(parentClsitemid);        
        dto.setClassifieritemdepth(1);
        dto.setClassifieritemorder(i);
        dto.setClassifieritemdescr(itemDescr);        
                
		return  dto;
	}

}
