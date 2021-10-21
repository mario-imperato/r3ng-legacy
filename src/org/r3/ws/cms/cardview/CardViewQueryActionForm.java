package org.r3.ws.cms.cardview;

import javax.ws.rs.QueryParam;

import org.r3.db.DTOBase;
import org.r3.db.cms.cardfullview.CardFullViewCriteria;
import org.r3.db.cms.cardfullview.CardFullViewFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class CardViewQueryActionForm extends DataTableQueryActionForm
{
	@QueryParam("orderby")
    private String orderby;

    public String getOrderby()
    {    	
    	return DTOBase.nullOnEmpty(orderby);
    }

	@QueryParam("limit")
    private String limit;

    public String getLimit()
    {    	
    	return DTOBase.nullOnEmpty(limit);
    }

    public int getLimitAsInt()
    {    	
    	String s = DTOBase.nullOnEmpty(limit); 
    	if (s != null)
    		return Integer.parseInt(s);
    	
    	return 0;
    }
    
	@QueryParam("cardid")
    private String cardid;

    public String getCardid()
    {    	
    	return DTOBase.nullOnEmpty(cardid);
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

	@QueryParam("groupid")
    private String groupid;

    public String getGroupid()
    {    	
    	String s = getsSearch();
    	if (s == null)
    	    return DTOBase.nullOnEmpty(groupid);
    	
    	return s;
    }

	@QueryParam("pageid")
    private String pageid;

    public String getPageid()
    {    	
    	String s = getsSearch();
    	if (s == null)
    	    return DTOBase.nullOnEmpty(pageid);
    	
    	return s;
    }
    
	@QueryParam("channelid")
    private String channelid;

    public String getChannelid()
    {    	
    	return DTOBase.nullOnEmpty(channelid);
    }

	public boolean isChannelMode() {		
		return getChannelid() != null;
	}

	@QueryParam("channelfilter")
    private String channelfilter;

    public String getChannelfilter()
    {    	
    	return DTOBase.nullOnEmpty(channelfilter);
    }

	public boolean isRestricted2CurrentSite()
	{
	    if (isChannelMode())
	    {
	    	String chf =  getChannelfilter();
	    	if (chf != null && chf.equalsIgnoreCase("none"))
	    		return false;
	    }
	    
	    return true;
	}
	
//	public CardViewFilter getCardViewSearchCondition(String aSite, String aLanguageCode)
//	{
//		CardViewFilter filter = new CardViewFilter();
//		
//		String s = getOrderby();
//		if (s != null)
//			filter.setOrderByClause(s);
//		else
//		   filter.setOrderByClause(" cardid asc, propertyid asc ");
//		
//		int searchLimit = getLimitAsInt();
//		if (searchLimit > 0)
//            filter.setLimitFetch(searchLimit);
//		
//		CardViewCriteria criteria = filter.or();
//		if (getCardid() != null)
//		{
//			criteria.andCardidEqualTo(getCardid());
//		}
//
//		criteria.andCategoryidEqualTo(getCategoryid());
//		criteria.andGroupidEqualTo(aSite, getGroupid());
//		criteria.andSiteEqualTo(aSite).andLanguagecodeEqualTo(aLanguageCode);
//		
//		return filter;
//	}

	public CardFullViewFilter getCardFullViewSearchCondition(String aSite, String aLanguageCode, boolean fullMode)
	{
		CardFullViewFilter filter = new CardFullViewFilter();
		CardFullViewCriteria criteria = filter.or();
		
		String s = getOrderby();
		if (s != null)
			filter.setOrderByClause(s);
		else
		{
			if (isChannelMode())
			     filter.setOrderByClause(" refdate desc, cardid asc ");
		    else filter.setOrderByClause(" refdate desc, cardid desc, propertyid asc ");			
		}

		
		// La condizione di searchLimit non viene applicata alla vista full in quanto effettivamente poco utilizzabile. In quanto si applicherebbe alle righe della
		// vista e dipendente dal numero di properties delle schede. 
//		int searchLimit = getLimitAsInt();
//		if (searchLimit > 0 && !fullMode)
//            filter.setLimitFetch(searchLimit);
		
		if (getCardid() != null)
		{
			criteria.andCardidEqualTo(getCardid());
		}

		criteria.andCategoryidEqualTo(getCategoryid());
		criteria.andGroupidEqualTo(aSite, getGroupid());
		criteria.andChannelidEqualTo(getChannelid());
		criteria.andPageidEqualTo(getPageid());
		
		if (isRestricted2CurrentSite())
		    criteria.andSiteEqualTo(aSite);
		    
		criteria.andLanguagecodeEqualTo(aLanguageCode);
		return filter;
	}

	public boolean isFullMode(boolean fullModeHint) {		
		return !queryIsRowBounded() && fullModeHint;
	}
		
}
