//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardchannelview;

import java.util.ArrayList;
import java.util.List;

public class CardChannelViewFilter{
    protected String orderByClause;
    protected String  groupByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public CardChannelViewFilter() 
    {
        oredCriteria = new ArrayList<org.r3.db.utils.Criteria>();
        limitFetch = 0;
        groupByClause = null;
    }
    
    public String getGroupByClause()
	  {
	  	return groupByClause;
	  }
    
	  public void setGroupByClause(String groupByClause)
	  {
	  	this.groupByClause = groupByClause;
	  }
	
	  public boolean isGroupBy(String aColumnName)
	  {
	  	return groupByClause != null && groupByClause.indexOf(aColumnName) >= 0;
	  }
	
    public void setOrderByClause(String orderByClause) 
    {
        this.orderByClause = orderByClause;
    }
    
    public String getOrderByClause() 
    {
        return orderByClause;
    }

    public int getLimitFetch()
  	{
		   return limitFetch;
	  }

	  public void setLimitFetch(int limitFetch)
	  {
		  this.limitFetch = limitFetch;
	  }

    public void setDistinct(boolean distinct) 
    {
        this.distinct = distinct;
    }

    public boolean isDistinct() 
    {
        return distinct;
    }

    public List<org.r3.db.utils.Criteria> getOredCriteria() 
    {
        return oredCriteria;
    }

    public void or(org.r3.db.utils.Criteria criteria) 
    {
        oredCriteria.add(criteria);
    }

    public CardChannelViewCriteria or() 
    {
        CardChannelViewCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public CardChannelViewCriteria createCriteria() 
    {
        CardChannelViewCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected CardChannelViewCriteria createCriteriaInternal() 
    {
        CardChannelViewCriteria criteria = new CardChannelViewCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class CardChannelViewCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public CardChannelViewCriteria andChannelidIsNull() {
            addCriterion("channelid is null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andChannelidIsNotNull() {
            addCriterion("channelid is not null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andChannelidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("channelid =", value, "channelid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andChannelidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("channelid <>", value, "channelid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andChannelidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("channelid >", value, "channelid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andChannelidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("channelid >=", value, "channelid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andChannelidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("channelid <", value, "channelid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andChannelidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("channelid <=", value, "channelid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andChannelidLike(java.lang.String value) {
            if (value != null)
              addCriterion("channelid like ", value, "channelid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andChannelidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("channelid not like ", value, "channelid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andChannelidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("channelid in ", value, "channelid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andChannelidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("channelid not in ", value, "channelid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andChannelidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("channelid between ", value1, value2, "channelid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andChannelidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("channelid not between ", value1, value2, "channelid");
            return (CardChannelViewCriteria) this;
        }
        
        public CardChannelViewCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (CardChannelViewCriteria) this;
        }
        
        public CardChannelViewCriteria andCardidIsNull() {
            addCriterion("cardid is null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCardidIsNotNull() {
            addCriterion("cardid is not null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCardidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid =", value, "cardid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCardidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <>", value, "cardid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCardidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardid >", value, "cardid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCardidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid >=", value, "cardid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCardidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <", value, "cardid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCardidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <=", value, "cardid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCardidLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardid like ", value, "cardid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCardidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardid not like ", value, "cardid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCardidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("cardid in ", value, "cardid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCardidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("cardid not in ", value, "cardid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCardidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardid between ", value1, value2, "cardid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCardidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardid not between ", value1, value2, "cardid");
            return (CardChannelViewCriteria) this;
        }
        
        public CardChannelViewCriteria andLanguagecodeIsNull() {
            addCriterion("languagecode is null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andLanguagecodeIsNotNull() {
            addCriterion("languagecode is not null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andLanguagecodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode =", value, "languagecode");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andLanguagecodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode <>", value, "languagecode");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andLanguagecodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode >", value, "languagecode");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andLanguagecodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode >=", value, "languagecode");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andLanguagecodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode <", value, "languagecode");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andLanguagecodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode <=", value, "languagecode");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andLanguagecodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode like ", value, "languagecode");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andLanguagecodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode not like ", value, "languagecode");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andLanguagecodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("languagecode in ", value, "languagecode");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andLanguagecodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("languagecode not in ", value, "languagecode");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andLanguagecodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("languagecode between ", value1, value2, "languagecode");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andLanguagecodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("languagecode not between ", value1, value2, "languagecode");
            return (CardChannelViewCriteria) this;
        }
        
        public CardChannelViewCriteria andCategoryidIsNull() {
            addCriterion("categoryid is null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCategoryidIsNotNull() {
            addCriterion("categoryid is not null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCategoryidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid =", value, "categoryid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCategoryidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid <>", value, "categoryid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCategoryidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid >", value, "categoryid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCategoryidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid >=", value, "categoryid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCategoryidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid <", value, "categoryid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCategoryidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid <=", value, "categoryid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCategoryidLike(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid like ", value, "categoryid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCategoryidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid not like ", value, "categoryid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCategoryidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("categoryid in ", value, "categoryid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCategoryidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("categoryid not in ", value, "categoryid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCategoryidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("categoryid between ", value1, value2, "categoryid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andCategoryidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("categoryid not between ", value1, value2, "categoryid");
            return (CardChannelViewCriteria) this;
        }
        
        public CardChannelViewCriteria andPagelinktypeIsNull() {
            addCriterion("pagelinktype is null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinktypeIsNotNull() {
            addCriterion("pagelinktype is not null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinktypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype =", value, "pagelinktype");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinktypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype <>", value, "pagelinktype");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinktypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype >", value, "pagelinktype");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinktypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype >=", value, "pagelinktype");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinktypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype <", value, "pagelinktype");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinktypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype <=", value, "pagelinktype");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinktypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype like ", value, "pagelinktype");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinktypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype not like ", value, "pagelinktype");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinktypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pagelinktype in ", value, "pagelinktype");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinktypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pagelinktype not in ", value, "pagelinktype");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinktypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagelinktype between ", value1, value2, "pagelinktype");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinktypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagelinktype not between ", value1, value2, "pagelinktype");
            return (CardChannelViewCriteria) this;
        }
        
        public CardChannelViewCriteria andPagelinkIsNull() {
            addCriterion("pagelink is null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinkIsNotNull() {
            addCriterion("pagelink is not null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinkEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink =", value, "pagelink");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinkNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink <>", value, "pagelink");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinkGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink >", value, "pagelink");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinkGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink >=", value, "pagelink");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinkLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink <", value, "pagelink");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinkLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink <=", value, "pagelink");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinkLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink like ", value, "pagelink");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinkNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink not like ", value, "pagelink");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinkIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pagelink in ", value, "pagelink");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinkNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pagelink not in ", value, "pagelink");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinkBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagelink between ", value1, value2, "pagelink");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPagelinkNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagelink not between ", value1, value2, "pagelink");
            return (CardChannelViewCriteria) this;
        }
        
        public CardChannelViewCriteria andPageidIsNull() {
            addCriterion("pageid is null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPageidIsNotNull() {
            addCriterion("pageid is not null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPageidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid =", value, "pageid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPageidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid <>", value, "pageid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPageidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pageid >", value, "pageid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPageidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid >=", value, "pageid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPageidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pageid <", value, "pageid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPageidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid <=", value, "pageid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPageidLike(java.lang.String value) {
            if (value != null)
              addCriterion("pageid like ", value, "pageid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPageidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pageid not like ", value, "pageid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPageidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pageid in ", value, "pageid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPageidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pageid not in ", value, "pageid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPageidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pageid between ", value1, value2, "pageid");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andPageidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pageid not between ", value1, value2, "pageid");
            return (CardChannelViewCriteria) this;
        }
        
        public CardChannelViewCriteria andRefdateIsNull() {
            addCriterion("refdate is null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andRefdateIsNotNull() {
            addCriterion("refdate is not null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andRefdateEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate =", value, "refdate");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andRefdateNotEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate <>", value, "refdate");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andRefdateGreaterThan(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate >", value, "refdate");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andRefdateGreaterThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate >=", value, "refdate");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andRefdateLessThan(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate <", value, "refdate");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andRefdateLessThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate <=", value, "refdate");
            return (CardChannelViewCriteria) this;
        }

        
        public CardChannelViewCriteria andOptionsIsNull() {
            addCriterion("options is null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andOptionsIsNotNull() {
            addCriterion("options is not null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andOptionsEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options =", value, "options");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andOptionsNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options <>", value, "options");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andOptionsGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("options >", value, "options");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andOptionsGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options >=", value, "options");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andOptionsLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("options <", value, "options");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andOptionsLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options <=", value, "options");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andOptionsLike(java.lang.String value) {
            if (value != null)
              addCriterion("options like ", value, "options");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andOptionsNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("options not like ", value, "options");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andOptionsIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("options in ", value, "options");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andOptionsNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("options not in ", value, "options");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andOptionsBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("options between ", value1, value2, "options");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andOptionsNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("options not between ", value1, value2, "options");
            return (CardChannelViewCriteria) this;
        }
        
        public CardChannelViewCriteria andTitleIsNull() {
            addCriterion("title is null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTitleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("title =", value, "title");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTitleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("title <>", value, "title");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTitleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("title >", value, "title");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTitleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("title >=", value, "title");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTitleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("title <", value, "title");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTitleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("title <=", value, "title");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTitleLike(java.lang.String value) {
            if (value != null)
              addCriterion("title like ", value, "title");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTitleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("title not like ", value, "title");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTitleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("title in ", value, "title");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTitleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("title not in ", value, "title");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTitleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("title between ", value1, value2, "title");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTitleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("title not between ", value1, value2, "title");
            return (CardChannelViewCriteria) this;
        }
        
        public CardChannelViewCriteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSummaryEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("summary =", value, "summary");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSummaryNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("summary <>", value, "summary");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSummaryGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("summary >", value, "summary");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSummaryGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("summary >=", value, "summary");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSummaryLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("summary <", value, "summary");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSummaryLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("summary <=", value, "summary");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSummaryLike(java.lang.String value) {
            if (value != null)
              addCriterion("summary like ", value, "summary");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSummaryNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("summary not like ", value, "summary");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSummaryIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("summary in ", value, "summary");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSummaryNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("summary not in ", value, "summary");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSummaryBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("summary between ", value1, value2, "summary");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andSummaryNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("summary not between ", value1, value2, "summary");
            return (CardChannelViewCriteria) this;
        }
        
        public CardChannelViewCriteria andTextbodyIsNull() {
            addCriterion("textbody is null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTextbodyIsNotNull() {
            addCriterion("textbody is not null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTextbodyEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("textbody =", value, "textbody");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTextbodyNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("textbody <>", value, "textbody");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTextbodyGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("textbody >", value, "textbody");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTextbodyGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("textbody >=", value, "textbody");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTextbodyLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("textbody <", value, "textbody");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTextbodyLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("textbody <=", value, "textbody");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTextbodyLike(java.lang.String value) {
            if (value != null)
              addCriterion("textbody like ", value, "textbody");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTextbodyNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("textbody not like ", value, "textbody");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTextbodyIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("textbody in ", value, "textbody");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTextbodyNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("textbody not in ", value, "textbody");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTextbodyBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("textbody between ", value1, value2, "textbody");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andTextbodyNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("textbody not between ", value1, value2, "textbody");
            return (CardChannelViewCriteria) this;
        }
        
        public CardChannelViewCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (CardChannelViewCriteria) this;
        }
        public CardChannelViewCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (CardChannelViewCriteria) this;
        }

    }
    
}

