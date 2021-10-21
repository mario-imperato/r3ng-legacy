package org.r3.ws.cms.card;

import javax.ws.rs.QueryParam;

import org.r3.db.DTOBase;
import org.r3.db.cms.card.CardCriteria;
import org.r3.db.cms.card.CardFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class CardQueryActionForm extends DataTableQueryActionForm
{
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

	public CardFilter getSearchCondition(String targetSite)
	{
		CardFilter filter = new CardFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" cardid asc ");
		else filter.setOrderByClause(getSortingCondition());
		
		CardCriteria criteria = filter.or();
		if (getCardid() != null)
		{
			criteria.andCardidEqualTo(getCardid());
		}

		criteria.andCategoryidEqualTo(getCategoryid());
		
		criteria.andSiteEqualTo(targetSite);
		return filter;
	}
}
