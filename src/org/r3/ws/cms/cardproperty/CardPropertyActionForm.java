package org.r3.ws.cms.cardproperty;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.cms.cardproperty.CardPropertyDTO;

public abstract class CardPropertyActionForm
{
	
	@FormParam("propertyname")
    private String propertyname;

    public String getPropertyname()
    {    	
    	String s = DTOBase.nullOnEmpty(propertyname);    	
    	return s;
    }

	@FormParam("propertyvalue")
    private String propertyvalue;

    public String getPropertyvalue()
    {    	
    	String s = DTOBase.nullOnEmpty(propertyvalue);    	
    	return s;
    }
    
	@FormParam("refpropertyid")
    private String refpropertyid;

    public String getRefpropertyid()
    {    	
    	String s = DTOBase.nullOnEmpty(refpropertyid);    	
    	return s;
    }
    
    public abstract CardPropertyDTO getDTO4Update(String aSite, String aCardId, String aPropertyId);
    public abstract CardPropertyDTO getDTO4Insert(String aSite, String aCardId);
    

}
