//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardproperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardPropertyDTO extends CardPropertyDTOBase
{
//	public enum CardPropertyRole
//	{
//		cms_cardimage, cms_boatimage, cms_galleryimage, cms_homebannerimage, regattalogoimage 
//	};
	
	public enum CardPropertyType { 
		image, document, file, link, htmlfragment
	};
		
	public enum CardPropertyRole { 
		cms_card_icon, mail_sysattach
	};
	
    public static List<String> listOfPropertyType_attachment;
    public static List<String> listOfPropertyType_link;
    public static List<String> listOfPropertyType_image;
    
	private static Map<String, CardPropertyType> contentTypeMapping;
    static
    {
    	contentTypeMapping = new HashMap<String, CardPropertyType>();
    	contentTypeMapping.put("image/jpeg", CardPropertyType.image);
    	contentTypeMapping.put("image/gif", CardPropertyType.image);
    	contentTypeMapping.put("image/png", CardPropertyType.image);
    	contentTypeMapping.put("application/pdf", CardPropertyType.document);
    	contentTypeMapping.put("text/html", CardPropertyType.htmlfragment);
			contentTypeMapping.put("application/msword", CardPropertyType.document);
    	contentTypeMapping.put("application/vnd.openxmlformats-officedocument.wordprocessingml.document", CardPropertyType.document);
    	contentTypeMapping.put("application/vnd.ms-excel", CardPropertyType.document);
    	contentTypeMapping.put("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", CardPropertyType.document);
    	contentTypeMapping.put("application/vnd.ms-powerpoint", CardPropertyType.document);
    	contentTypeMapping.put("application/vnd.openxmlformats-officedocument.presentationml.presentation", CardPropertyType.document);    	
    	contentTypeMapping.put("binary/octet-stream", CardPropertyType.file);
    	
    	listOfPropertyType_attachment = new ArrayList<String>();
    	listOfPropertyType_attachment.add(CardPropertyType.image.toString());
    	listOfPropertyType_attachment.add(CardPropertyType.document.toString());
    	listOfPropertyType_attachment.add(CardPropertyType.file.toString());
    	listOfPropertyType_attachment.add(CardPropertyType.htmlfragment.toString());
    	
    	listOfPropertyType_link = new ArrayList<String>();
    	listOfPropertyType_link.add(CardPropertyType.link.toString());
    	
    	listOfPropertyType_image = new ArrayList<String>();
    	listOfPropertyType_image.add(CardPropertyType.image.toString());    	
    }
    
	public static CardPropertyType getCardPropertyTypeByContentType(String aContentType, CardPropertyType defaultValue)
	{
		CardPropertyType p = null;
		if (aContentType != null)
			p = contentTypeMapping.get(aContentType);

		if (p == null)
			p = defaultValue;
		
		return p;
	}
    
	public static CardPropertyType getPropertytypecodeAsEnum(String aPropertytypecode)
	{
		if (aPropertytypecode != null)
			return CardPropertyType.valueOf(aPropertytypecode);
		
		return null;
	}
	
    public CardPropertyDTO()
    {
        super();
    }

    public CardPropertyDTO(CardPropertyDTO another)
    {
        super(another);
    }

    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient
    public CardPropertyType getPropertytypecodeAsEnum()
	{
		return getPropertytypecodeAsEnum(propertytypecode);		
	}
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient
    public boolean isImage()
    {
    	CardPropertyType p = getPropertytypecodeAsEnum();
    	return p != null && p == CardPropertyType.image;
    }

	public void addRole(String aRole)
	{
		if (aRole == null)
			return ;
		
		String r = getPropertyrole();
		if (r == null)
			r = aRole.toString();
		else 
		{
			if (r.indexOf(aRole.toString()) < 0)
			{
				StringBuilder stb = new StringBuilder();
				stb.append(r).append(",").append(aRole);
				r = stb.toString();
			}
		}
		
		setPropertyrole(r);
	}

    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient
	public boolean hasRoles()
	{
		String r = getPropertyrole();
		if (r != null && r.length() > 0)
			return true;
		
		return false;
	}
	
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient
	public String[] getRoles()
	{
		String r = getPropertyrole();
		if (r != null && r.length() > 0)
		{
			String[] roles = r.split(",");
			if (roles != null && roles.length > 0)
				return roles;
		}
		
		return null;
	}

    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient    
	public boolean isDMSProperty()
	{
		if (propertyvalue != null && propertyvalue.startsWith("DMS_FILE:"))
			return true;
		
		return false;
	}
}
