package org.r3.ws.system.classifiers;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.system.classifier.ClassifierDTO;

public class ClassifierActionForm
{
	@FormParam("clsdescr")
    private String clsdescr;

    public String getClsdescr()
    {    	
    	return DTOBase.nullOnEmpty(clsdescr);
    }

	public ClassifierDTO getDTO4Update(ClassifierDTO dto)
	{		                
        dto.setClsdescr(getClsdescr());                
       	return  dto;
	}

}
