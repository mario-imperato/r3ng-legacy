package org.r3.ws.cms.cardproperty;

import java.util.List;

import org.r3.db.cms.cardproperty.CardPropertyCriteria;
import org.r3.db.cms.cardproperty.CardPropertyFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class CardPropertyQueryActionForm extends DataTableQueryActionForm
{
//	@QueryParam("cardid")
//    private String cardid;
//
//    public String getCardid()
//    {    	
//    	return DTOBase.nullOnEmpty(cardid);
//    }

    private List<String> listOfPropertytypecode;
    
	public List<String> getListOfPropertytypecode()
	{
		return listOfPropertytypecode;
	}

	public void setListOfPropertytypecode(List<String> listOfPropertytypecode)
	{
		this.listOfPropertytypecode = listOfPropertytypecode;
	}

	public CardPropertyFilter getSearchCondition(String aSite, String aCardId)
	{
		CardPropertyFilter filter = new CardPropertyFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" propertyid asc ");
		else filter.setOrderByClause(getSortingCondition());
		
		CardPropertyCriteria criteria = filter.or();
		criteria.andSiteEqualTo(aSite).andCardidEqualTo(aCardId);
		
		if (listOfPropertytypecode != null && listOfPropertytypecode.size() > 0)
		       criteria.andPropertytypecodeIn(listOfPropertytypecode);

		return filter;
	}
}
