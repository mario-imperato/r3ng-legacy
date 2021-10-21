package org.r3.ws.cms.channel;

import javax.ws.rs.QueryParam;

import org.r3.db.DTOBase;
import org.r3.db.cms.cardchannelview.CardChannelViewCriteria;
import org.r3.db.cms.cardchannelview.CardChannelViewFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class CardChannelQueryActionForm extends DataTableQueryActionForm
{
	@QueryParam("channelid")
    private String channelid;

    public String getChannelid()
    {    	
    	String s = getsSearch();
    	if (s == null)
    	   return DTOBase.nullOnEmpty(channelid);
    
    	return s;
    }
	
	@QueryParam("categoryid")
    private String categoryid;

    public String getCategoryid()
    {    	
    	String s = getsSearch();
    	if (s == null)
    	    return DTOBase.nullOnEmpty(categoryid);
    	
    	return s;
    }

	public CardChannelViewFilter getSearchCondition(String targetDomain, String targetSite, String aLanguageCode)
	{
		CardChannelViewFilter filter = new CardChannelViewFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" cardid asc ");
		else filter.setOrderByClause(getSortingCondition());
		
		CardChannelViewCriteria criteria = filter.or().andChannelidEqualTo(getChannelid());
		
		if (targetDomain.equalsIgnoreCase(targetSite))
			 criteria.andSiteEqualToOrSiteInDomain(targetDomain, targetSite);
		else criteria.andSiteEqualTo(targetSite);
		
		criteria.andLanguagecodeEqualTo(aLanguageCode);

		return filter;
	}
}
