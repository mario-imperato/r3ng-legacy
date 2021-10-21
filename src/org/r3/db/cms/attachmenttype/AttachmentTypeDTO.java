//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.attachmenttype;

import org.r3.system.util.StringUtils;

public class AttachmentTypeDTO extends AttachmentTypeDTOBase
{
	public enum AttachScope { card_scope, site_scope, system_scope;
	
	public static AttachScope getValue4(String s, AttachScope defaultValue)
	{
		if (s != null)
		{
			return AttachScope.site_scope;
		}
		
		return defaultValue;
	}
	
	};
    public AttachmentTypeDTO()
    {
        super();
    }

    public AttachmentTypeDTO(AttachmentTypeDTO another)
    {
        super(another);
    }

    @Override
    public String getDtokey()
    {
        StringBuilder stb = new StringBuilder();
        stb.append(site);
        stb.append("_");
        stb.append(attachtypeid);
        return stb.toString();
    }
    
    public String getDtokey(boolean excludeSite)
    {
    	String dtok = getDtokey();
    	
    	if (excludeSite)
    	{
    		dtok = StringUtils.sliceTokens(dtok, '_', 1);        	
    	}
    		
    	return dtok;
    }

	public boolean isSiteAttachment()
	{
		return attachscope != null && (attachscope.equalsIgnoreCase("site") || attachscope.equalsIgnoreCase("site_scope"));
	}
	
	public String getBusinesskey()
	{
		return getAttachtypeid();
	}
	
}
