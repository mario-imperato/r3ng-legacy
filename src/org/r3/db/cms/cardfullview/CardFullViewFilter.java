//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardfullview;

import java.util.ArrayList;
import java.util.List;

public class CardFullViewFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public CardFullViewFilter() 
    {
        oredCriteria = new ArrayList<org.r3.db.utils.Criteria>();
        limitFetch = 0;
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

    public CardFullViewCriteria or() 
    {
        CardFullViewCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public CardFullViewCriteria createCriteria() 
    {
        CardFullViewCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected CardFullViewCriteria createCriteriaInternal() 
    {
        CardFullViewCriteria criteria = new CardFullViewCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class CardFullViewCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public CardFullViewCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (CardFullViewCriteria) this;
        }
        
        public CardFullViewCriteria andCardidIsNull() {
            addCriterion("cardid is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCardidIsNotNull() {
            addCriterion("cardid is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCardidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid =", value, "cardid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCardidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <>", value, "cardid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCardidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardid >", value, "cardid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCardidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid >=", value, "cardid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCardidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <", value, "cardid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCardidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <=", value, "cardid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCardidLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardid like ", value, "cardid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCardidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardid not like ", value, "cardid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCardidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("cardid in ", value, "cardid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCardidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("cardid not in ", value, "cardid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCardidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardid between ", value1, value2, "cardid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCardidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardid not between ", value1, value2, "cardid");
            return (CardFullViewCriteria) this;
        }
        
        public CardFullViewCriteria andLanguagecodeIsNull() {
            addCriterion("languagecode is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andLanguagecodeIsNotNull() {
            addCriterion("languagecode is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andLanguagecodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode =", value, "languagecode");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andLanguagecodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode <>", value, "languagecode");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andLanguagecodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode >", value, "languagecode");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andLanguagecodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode >=", value, "languagecode");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andLanguagecodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode <", value, "languagecode");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andLanguagecodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode <=", value, "languagecode");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andLanguagecodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode like ", value, "languagecode");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andLanguagecodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode not like ", value, "languagecode");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andLanguagecodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("languagecode in ", value, "languagecode");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andLanguagecodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("languagecode not in ", value, "languagecode");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andLanguagecodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("languagecode between ", value1, value2, "languagecode");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andLanguagecodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("languagecode not between ", value1, value2, "languagecode");
            return (CardFullViewCriteria) this;
        }
        
        public CardFullViewCriteria andCategoryidIsNull() {
            addCriterion("categoryid is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCategoryidIsNotNull() {
            addCriterion("categoryid is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCategoryidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid =", value, "categoryid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCategoryidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid <>", value, "categoryid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCategoryidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid >", value, "categoryid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCategoryidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid >=", value, "categoryid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCategoryidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid <", value, "categoryid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCategoryidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid <=", value, "categoryid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCategoryidLike(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid like ", value, "categoryid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCategoryidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid not like ", value, "categoryid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCategoryidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("categoryid in ", value, "categoryid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCategoryidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("categoryid not in ", value, "categoryid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCategoryidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("categoryid between ", value1, value2, "categoryid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andCategoryidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("categoryid not between ", value1, value2, "categoryid");
            return (CardFullViewCriteria) this;
        }
        
        public CardFullViewCriteria andPagelinktypeIsNull() {
            addCriterion("pagelinktype is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinktypeIsNotNull() {
            addCriterion("pagelinktype is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinktypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype =", value, "pagelinktype");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinktypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype <>", value, "pagelinktype");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinktypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype >", value, "pagelinktype");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinktypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype >=", value, "pagelinktype");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinktypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype <", value, "pagelinktype");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinktypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype <=", value, "pagelinktype");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinktypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype like ", value, "pagelinktype");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinktypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype not like ", value, "pagelinktype");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinktypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pagelinktype in ", value, "pagelinktype");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinktypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pagelinktype not in ", value, "pagelinktype");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinktypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagelinktype between ", value1, value2, "pagelinktype");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinktypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagelinktype not between ", value1, value2, "pagelinktype");
            return (CardFullViewCriteria) this;
        }
        
        public CardFullViewCriteria andPagelinkIsNull() {
            addCriterion("pagelink is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinkIsNotNull() {
            addCriterion("pagelink is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinkEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink =", value, "pagelink");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinkNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink <>", value, "pagelink");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinkGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink >", value, "pagelink");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinkGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink >=", value, "pagelink");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinkLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink <", value, "pagelink");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinkLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink <=", value, "pagelink");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinkLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink like ", value, "pagelink");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinkNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink not like ", value, "pagelink");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinkIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pagelink in ", value, "pagelink");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinkNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pagelink not in ", value, "pagelink");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinkBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagelink between ", value1, value2, "pagelink");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPagelinkNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagelink not between ", value1, value2, "pagelink");
            return (CardFullViewCriteria) this;
        }
        
        public CardFullViewCriteria andPageidIsNull() {
            addCriterion("pageid is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPageidIsNotNull() {
            addCriterion("pageid is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPageidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid =", value, "pageid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPageidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid <>", value, "pageid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPageidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pageid >", value, "pageid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPageidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid >=", value, "pageid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPageidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pageid <", value, "pageid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPageidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid <=", value, "pageid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPageidLike(java.lang.String value) {
            if (value != null)
              addCriterion("pageid like ", value, "pageid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPageidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pageid not like ", value, "pageid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPageidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pageid in ", value, "pageid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPageidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pageid not in ", value, "pageid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPageidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pageid between ", value1, value2, "pageid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPageidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pageid not between ", value1, value2, "pageid");
            return (CardFullViewCriteria) this;
        }
        
        public CardFullViewCriteria andRefdateIsNull() {
            addCriterion("refdate is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRefdateIsNotNull() {
            addCriterion("refdate is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRefdateEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate =", value, "refdate");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRefdateNotEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate <>", value, "refdate");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRefdateGreaterThan(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate >", value, "refdate");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRefdateGreaterThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate >=", value, "refdate");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRefdateLessThan(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate <", value, "refdate");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRefdateLessThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate <=", value, "refdate");
            return (CardFullViewCriteria) this;
        }

        
        public CardFullViewCriteria andOptionsIsNull() {
            addCriterion("options is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andOptionsIsNotNull() {
            addCriterion("options is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andOptionsEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options =", value, "options");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andOptionsNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options <>", value, "options");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andOptionsGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("options >", value, "options");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andOptionsGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options >=", value, "options");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andOptionsLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("options <", value, "options");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andOptionsLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options <=", value, "options");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andOptionsLike(java.lang.String value) {
            if (value != null)
              addCriterion("options like ", value, "options");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andOptionsNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("options not like ", value, "options");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andOptionsIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("options in ", value, "options");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andOptionsNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("options not in ", value, "options");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andOptionsBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("options between ", value1, value2, "options");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andOptionsNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("options not between ", value1, value2, "options");
            return (CardFullViewCriteria) this;
        }
        
        public CardFullViewCriteria andTitleIsNull() {
            addCriterion("title is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTitleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("title =", value, "title");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTitleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("title <>", value, "title");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTitleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("title >", value, "title");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTitleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("title >=", value, "title");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTitleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("title <", value, "title");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTitleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("title <=", value, "title");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTitleLike(java.lang.String value) {
            if (value != null)
              addCriterion("title like ", value, "title");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTitleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("title not like ", value, "title");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTitleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("title in ", value, "title");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTitleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("title not in ", value, "title");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTitleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("title between ", value1, value2, "title");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTitleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("title not between ", value1, value2, "title");
            return (CardFullViewCriteria) this;
        }
        
        public CardFullViewCriteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSummaryEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("summary =", value, "summary");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSummaryNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("summary <>", value, "summary");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSummaryGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("summary >", value, "summary");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSummaryGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("summary >=", value, "summary");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSummaryLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("summary <", value, "summary");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSummaryLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("summary <=", value, "summary");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSummaryLike(java.lang.String value) {
            if (value != null)
              addCriterion("summary like ", value, "summary");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSummaryNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("summary not like ", value, "summary");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSummaryIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("summary in ", value, "summary");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSummaryNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("summary not in ", value, "summary");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSummaryBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("summary between ", value1, value2, "summary");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andSummaryNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("summary not between ", value1, value2, "summary");
            return (CardFullViewCriteria) this;
        }
        
        public CardFullViewCriteria andTextbodyIsNull() {
            addCriterion("textbody is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTextbodyIsNotNull() {
            addCriterion("textbody is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTextbodyEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("textbody =", value, "textbody");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTextbodyNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("textbody <>", value, "textbody");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTextbodyGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("textbody >", value, "textbody");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTextbodyGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("textbody >=", value, "textbody");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTextbodyLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("textbody <", value, "textbody");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTextbodyLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("textbody <=", value, "textbody");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTextbodyLike(java.lang.String value) {
            if (value != null)
              addCriterion("textbody like ", value, "textbody");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTextbodyNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("textbody not like ", value, "textbody");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTextbodyIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("textbody in ", value, "textbody");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTextbodyNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("textbody not in ", value, "textbody");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTextbodyBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("textbody between ", value1, value2, "textbody");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andTextbodyNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("textbody not between ", value1, value2, "textbody");
            return (CardFullViewCriteria) this;
        }
        
        public CardFullViewCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (CardFullViewCriteria) this;
        }

        
        public CardFullViewCriteria andPropertyidIsNull() {
            addCriterion("propertyid is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyidIsNotNull() {
            addCriterion("propertyid is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyid =", value, "propertyid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyid <>", value, "propertyid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyid >", value, "propertyid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyid >=", value, "propertyid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyid <", value, "propertyid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyid <=", value, "propertyid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyidLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyid like ", value, "propertyid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyid not like ", value, "propertyid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("propertyid in ", value, "propertyid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("propertyid not in ", value, "propertyid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyid between ", value1, value2, "propertyid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyid not between ", value1, value2, "propertyid");
            return (CardFullViewCriteria) this;
        }
        
        public CardFullViewCriteria andPropertyroleIsNull() {
            addCriterion("propertyrole is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyroleIsNotNull() {
            addCriterion("propertyrole is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyroleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole =", value, "propertyrole");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyroleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole <>", value, "propertyrole");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyroleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole >", value, "propertyrole");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyroleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole >=", value, "propertyrole");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyroleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole <", value, "propertyrole");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyroleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole <=", value, "propertyrole");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyroleLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole like ", value, "propertyrole");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyroleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole not like ", value, "propertyrole");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyroleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("propertyrole in ", value, "propertyrole");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyroleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("propertyrole not in ", value, "propertyrole");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyroleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyrole between ", value1, value2, "propertyrole");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyroleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyrole not between ", value1, value2, "propertyrole");
            return (CardFullViewCriteria) this;
        }
        
        public CardFullViewCriteria andPropertytypecodeIsNull() {
            addCriterion("propertytypecode is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertytypecodeIsNotNull() {
            addCriterion("propertytypecode is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertytypecodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertytypecode =", value, "propertytypecode");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertytypecodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertytypecode <>", value, "propertytypecode");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertytypecodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertytypecode >", value, "propertytypecode");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertytypecodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertytypecode >=", value, "propertytypecode");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertytypecodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertytypecode <", value, "propertytypecode");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertytypecodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertytypecode <=", value, "propertytypecode");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertytypecodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertytypecode like ", value, "propertytypecode");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertytypecodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertytypecode not like ", value, "propertytypecode");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertytypecodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("propertytypecode in ", value, "propertytypecode");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertytypecodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("propertytypecode not in ", value, "propertytypecode");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertytypecodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertytypecode between ", value1, value2, "propertytypecode");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertytypecodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertytypecode not between ", value1, value2, "propertytypecode");
            return (CardFullViewCriteria) this;
        }
        
        public CardFullViewCriteria andPropertynameIsNull() {
            addCriterion("propertyname is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertynameIsNotNull() {
            addCriterion("propertyname is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertynameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname =", value, "propertyname");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertynameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname <>", value, "propertyname");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertynameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname >", value, "propertyname");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertynameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname >=", value, "propertyname");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertynameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname <", value, "propertyname");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertynameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname <=", value, "propertyname");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertynameLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname like ", value, "propertyname");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertynameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname not like ", value, "propertyname");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertynameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("propertyname in ", value, "propertyname");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertynameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("propertyname not in ", value, "propertyname");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertynameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyname between ", value1, value2, "propertyname");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertynameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyname not between ", value1, value2, "propertyname");
            return (CardFullViewCriteria) this;
        }
        
        public CardFullViewCriteria andPropertyvalueIsNull() {
            addCriterion("propertyvalue is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyvalueIsNotNull() {
            addCriterion("propertyvalue is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyvalueEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue =", value, "propertyvalue");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyvalueNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue <>", value, "propertyvalue");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyvalueGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue >", value, "propertyvalue");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyvalueGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue >=", value, "propertyvalue");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyvalueLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue <", value, "propertyvalue");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyvalueLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue <=", value, "propertyvalue");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyvalueLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue like ", value, "propertyvalue");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyvalueNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue not like ", value, "propertyvalue");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyvalueIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("propertyvalue in ", value, "propertyvalue");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyvalueNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("propertyvalue not in ", value, "propertyvalue");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyvalueBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyvalue between ", value1, value2, "propertyvalue");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertyvalueNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyvalue not between ", value1, value2, "propertyvalue");
            return (CardFullViewCriteria) this;
        }
        
        public CardFullViewCriteria andPropertysizeIsNull() {
            addCriterion("propertysize is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertysizeIsNotNull() {
            addCriterion("propertysize is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertysizeEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("propertysize =", value, "propertysize");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertysizeNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("propertysize <>", value, "propertysize");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertysizeGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("propertysize >", value, "propertysize");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertysizeGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("propertysize >=", value, "propertysize");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertysizeLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("propertysize <", value, "propertysize");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andPropertysizeLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("propertysize <=", value, "propertysize");
            return (CardFullViewCriteria) this;
        }

        
        public CardFullViewCriteria andRefpropertyidIsNull() {
            addCriterion("refpropertyid is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRefpropertyidIsNotNull() {
            addCriterion("refpropertyid is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRefpropertyidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("refpropertyid =", value, "refpropertyid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRefpropertyidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("refpropertyid <>", value, "refpropertyid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRefpropertyidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("refpropertyid >", value, "refpropertyid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRefpropertyidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("refpropertyid >=", value, "refpropertyid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRefpropertyidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("refpropertyid <", value, "refpropertyid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRefpropertyidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("refpropertyid <=", value, "refpropertyid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRefpropertyidLike(java.lang.String value) {
            if (value != null)
              addCriterion("refpropertyid like ", value, "refpropertyid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRefpropertyidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("refpropertyid not like ", value, "refpropertyid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRefpropertyidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("refpropertyid in ", value, "refpropertyid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRefpropertyidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("refpropertyid not in ", value, "refpropertyid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRefpropertyidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("refpropertyid between ", value1, value2, "refpropertyid");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andRefpropertyidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("refpropertyid not between ", value1, value2, "refpropertyid");
            return (CardFullViewCriteria) this;
        }
        
        public CardFullViewCriteria andContenttypeIsNull() {
            addCriterion("contenttype is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andContenttypeIsNotNull() {
            addCriterion("contenttype is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andContenttypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype =", value, "contenttype");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andContenttypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype <>", value, "contenttype");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andContenttypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype >", value, "contenttype");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andContenttypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype >=", value, "contenttype");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andContenttypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype <", value, "contenttype");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andContenttypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype <=", value, "contenttype");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andContenttypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype like ", value, "contenttype");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andContenttypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype not like ", value, "contenttype");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andContenttypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("contenttype in ", value, "contenttype");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andContenttypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("contenttype not in ", value, "contenttype");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andContenttypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("contenttype between ", value1, value2, "contenttype");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andContenttypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("contenttype not between ", value1, value2, "contenttype");
            return (CardFullViewCriteria) this;
        }
        
        public CardFullViewCriteria andImageurlIsNull() {
            addCriterion("imageurl is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImageurlIsNotNull() {
            addCriterion("imageurl is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImageurlEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("imageurl =", value, "imageurl");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImageurlNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("imageurl <>", value, "imageurl");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImageurlGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("imageurl >", value, "imageurl");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImageurlGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("imageurl >=", value, "imageurl");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImageurlLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("imageurl <", value, "imageurl");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImageurlLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("imageurl <=", value, "imageurl");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImageurlLike(java.lang.String value) {
            if (value != null)
              addCriterion("imageurl like ", value, "imageurl");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImageurlNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("imageurl not like ", value, "imageurl");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImageurlIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("imageurl in ", value, "imageurl");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImageurlNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("imageurl not in ", value, "imageurl");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImageurlBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("imageurl between ", value1, value2, "imageurl");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImageurlNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("imageurl not between ", value1, value2, "imageurl");
            return (CardFullViewCriteria) this;
        }
        
        public CardFullViewCriteria andImageheightIsNull() {
            addCriterion("imageheight is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImageheightIsNotNull() {
            addCriterion("imageheight is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImageheightEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("imageheight =", value, "imageheight");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImageheightNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("imageheight <>", value, "imageheight");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImageheightGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("imageheight >", value, "imageheight");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImageheightGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("imageheight >=", value, "imageheight");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImageheightLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("imageheight <", value, "imageheight");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImageheightLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("imageheight <=", value, "imageheight");
            return (CardFullViewCriteria) this;
        }

        
        public CardFullViewCriteria andImagewidthIsNull() {
            addCriterion("imagewidth is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImagewidthIsNotNull() {
            addCriterion("imagewidth is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImagewidthEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("imagewidth =", value, "imagewidth");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImagewidthNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("imagewidth <>", value, "imagewidth");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImagewidthGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("imagewidth >", value, "imagewidth");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImagewidthGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("imagewidth >=", value, "imagewidth");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImagewidthLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("imagewidth <", value, "imagewidth");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andImagewidthLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("imagewidth <=", value, "imagewidth");
            return (CardFullViewCriteria) this;
        }

        
        public CardFullViewCriteria andIconurlIsNull() {
            addCriterion("iconurl is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconurlIsNotNull() {
            addCriterion("iconurl is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconurlEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("iconurl =", value, "iconurl");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconurlNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("iconurl <>", value, "iconurl");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconurlGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("iconurl >", value, "iconurl");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconurlGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("iconurl >=", value, "iconurl");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconurlLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("iconurl <", value, "iconurl");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconurlLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("iconurl <=", value, "iconurl");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconurlLike(java.lang.String value) {
            if (value != null)
              addCriterion("iconurl like ", value, "iconurl");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconurlNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("iconurl not like ", value, "iconurl");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconurlIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("iconurl in ", value, "iconurl");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconurlNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("iconurl not in ", value, "iconurl");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconurlBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("iconurl between ", value1, value2, "iconurl");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconurlNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("iconurl not between ", value1, value2, "iconurl");
            return (CardFullViewCriteria) this;
        }
        
        public CardFullViewCriteria andIconheightIsNull() {
            addCriterion("iconheight is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconheightIsNotNull() {
            addCriterion("iconheight is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconheightEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconheight =", value, "iconheight");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconheightNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconheight <>", value, "iconheight");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconheightGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconheight >", value, "iconheight");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconheightGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconheight >=", value, "iconheight");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconheightLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconheight <", value, "iconheight");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconheightLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconheight <=", value, "iconheight");
            return (CardFullViewCriteria) this;
        }

        
        public CardFullViewCriteria andIconwidthIsNull() {
            addCriterion("iconwidth is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconwidthIsNotNull() {
            addCriterion("iconwidth is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconwidthEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconwidth =", value, "iconwidth");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconwidthNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconwidth <>", value, "iconwidth");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconwidthGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconwidth >", value, "iconwidth");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconwidthGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconwidth >=", value, "iconwidth");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconwidthLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconwidth <", value, "iconwidth");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andIconwidthLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("iconwidth <=", value, "iconwidth");
            return (CardFullViewCriteria) this;
        }

        
        public CardFullViewCriteria andProprectimestampIsNull() {
            addCriterion("proprectimestamp is null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andProprectimestampIsNotNull() {
            addCriterion("proprectimestamp is not null");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andProprectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("proprectimestamp =", value, "proprectimestamp");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andProprectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("proprectimestamp <>", value, "proprectimestamp");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andProprectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("proprectimestamp >", value, "proprectimestamp");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andProprectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("proprectimestamp >=", value, "proprectimestamp");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andProprectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("proprectimestamp <", value, "proprectimestamp");
            return (CardFullViewCriteria) this;
        }
        public CardFullViewCriteria andProprectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("proprectimestamp <=", value, "proprectimestamp");
            return (CardFullViewCriteria) this;
        }

    }
    
}

