//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.card;

import org.r3.db.cms.channel.ChannelDataTableAdapter;
import org.r3.db.cms.group.GroupDataTableAdapter;

public class CardDTO extends CardDTOBase
{
	public enum ValidityRule { always, never, date };
	public enum PageLinkType { none, page, custom };
	
	public static final String CARDID_DOMAIN_SEQUENCE_CODE = "CRDD";
		
    public CardDTO()
    {
        super();
    }

    public CardDTO(CardDTO another)
    {
        super(another);
    }

    public static ValidityRule getValidityruleAsEnum(String v, ValidityRule defaultValue)
    {
    	if (v != null)
    	{
    		try
    		{
        		return ValidityRule.valueOf(v);    			
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    	}
    	
    	return defaultValue;
    }

    public static PageLinkType getPagelinktypeAsEnum(String v, PageLinkType defaultValue)
    {
    	if (v != null)
    	{
    		try
    		{
        		return PageLinkType.valueOf(v);    			
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    	}
    	
    	return defaultValue;
    }

    public ValidityRule getValidityruleAsEnum()
    {
    	return getValidityruleAsEnum(getValidityrule(), ValidityRule.never);
    }
    
    public PageLinkType getPagelinktypeAsEnum()
    {
    	return getPagelinktypeAsEnum(getPagelinktype(), PageLinkType.none);
    }
    
    private GroupDataTableAdapter groups;

	public GroupDataTableAdapter getGroups()
	{
		return groups;
	}

	public void setGroups(GroupDataTableAdapter groups)
	{
		this.groups = groups;
	}
    
    private ChannelDataTableAdapter channels;

	public ChannelDataTableAdapter getChannels()
	{
		return channels;
	}

	public void setChannels(ChannelDataTableAdapter channels)
	{
		this.channels = channels;
	}
	
	public static boolean isDomainScope(String aCardId)
	{
		if (aCardId != null && aCardId.startsWith(CARDID_DOMAIN_SEQUENCE_CODE))
			return true;
		
		return false;
	}
	
	public boolean isDomainScope()
	{	
		return isDomainScope(getCardid());
	}
}
