//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardview;

import java.util.ArrayList;
import java.util.List;

public class CardViewFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public CardViewFilter() 
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

    public CardViewCriteria or() 
    {
        CardViewCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public CardViewCriteria createCriteria() 
    {
        CardViewCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected CardViewCriteria createCriteriaInternal() 
    {
        CardViewCriteria criteria = new CardViewCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class CardViewCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public CardViewCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (CardViewCriteria) this;
        }
        
        public CardViewCriteria andCardidIsNull() {
            addCriterion("cardid is null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCardidIsNotNull() {
            addCriterion("cardid is not null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCardidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid =", value, "cardid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCardidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <>", value, "cardid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCardidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardid >", value, "cardid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCardidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid >=", value, "cardid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCardidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <", value, "cardid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCardidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <=", value, "cardid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCardidLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardid like ", value, "cardid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCardidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardid not like ", value, "cardid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCardidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("cardid in ", value, "cardid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCardidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("cardid not in ", value, "cardid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCardidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardid between ", value1, value2, "cardid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCardidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardid not between ", value1, value2, "cardid");
            return (CardViewCriteria) this;
        }
        
        public CardViewCriteria andLanguagecodeIsNull() {
            addCriterion("languagecode is null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andLanguagecodeIsNotNull() {
            addCriterion("languagecode is not null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andLanguagecodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode =", value, "languagecode");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andLanguagecodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode <>", value, "languagecode");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andLanguagecodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode >", value, "languagecode");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andLanguagecodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode >=", value, "languagecode");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andLanguagecodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode <", value, "languagecode");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andLanguagecodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode <=", value, "languagecode");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andLanguagecodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode like ", value, "languagecode");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andLanguagecodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode not like ", value, "languagecode");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andLanguagecodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("languagecode in ", value, "languagecode");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andLanguagecodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("languagecode not in ", value, "languagecode");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andLanguagecodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("languagecode between ", value1, value2, "languagecode");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andLanguagecodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("languagecode not between ", value1, value2, "languagecode");
            return (CardViewCriteria) this;
        }
        
        public CardViewCriteria andCategoryidIsNull() {
            addCriterion("categoryid is null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCategoryidIsNotNull() {
            addCriterion("categoryid is not null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCategoryidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid =", value, "categoryid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCategoryidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid <>", value, "categoryid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCategoryidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid >", value, "categoryid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCategoryidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid >=", value, "categoryid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCategoryidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid <", value, "categoryid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCategoryidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid <=", value, "categoryid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCategoryidLike(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid like ", value, "categoryid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCategoryidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid not like ", value, "categoryid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCategoryidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("categoryid in ", value, "categoryid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCategoryidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("categoryid not in ", value, "categoryid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCategoryidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("categoryid between ", value1, value2, "categoryid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andCategoryidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("categoryid not between ", value1, value2, "categoryid");
            return (CardViewCriteria) this;
        }
        
        public CardViewCriteria andPagelinktypeIsNull() {
            addCriterion("pagelinktype is null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinktypeIsNotNull() {
            addCriterion("pagelinktype is not null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinktypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype =", value, "pagelinktype");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinktypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype <>", value, "pagelinktype");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinktypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype >", value, "pagelinktype");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinktypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype >=", value, "pagelinktype");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinktypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype <", value, "pagelinktype");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinktypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype <=", value, "pagelinktype");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinktypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype like ", value, "pagelinktype");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinktypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype not like ", value, "pagelinktype");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinktypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pagelinktype in ", value, "pagelinktype");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinktypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pagelinktype not in ", value, "pagelinktype");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinktypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagelinktype between ", value1, value2, "pagelinktype");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinktypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagelinktype not between ", value1, value2, "pagelinktype");
            return (CardViewCriteria) this;
        }
        
        public CardViewCriteria andPagelinkIsNull() {
            addCriterion("pagelink is null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinkIsNotNull() {
            addCriterion("pagelink is not null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinkEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink =", value, "pagelink");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinkNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink <>", value, "pagelink");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinkGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink >", value, "pagelink");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinkGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink >=", value, "pagelink");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinkLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink <", value, "pagelink");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinkLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink <=", value, "pagelink");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinkLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink like ", value, "pagelink");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinkNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink not like ", value, "pagelink");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinkIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pagelink in ", value, "pagelink");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinkNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pagelink not in ", value, "pagelink");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinkBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagelink between ", value1, value2, "pagelink");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPagelinkNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagelink not between ", value1, value2, "pagelink");
            return (CardViewCriteria) this;
        }
        
        public CardViewCriteria andPageidIsNull() {
            addCriterion("pageid is null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPageidIsNotNull() {
            addCriterion("pageid is not null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPageidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid =", value, "pageid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPageidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid <>", value, "pageid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPageidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pageid >", value, "pageid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPageidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid >=", value, "pageid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPageidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pageid <", value, "pageid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPageidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid <=", value, "pageid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPageidLike(java.lang.String value) {
            if (value != null)
              addCriterion("pageid like ", value, "pageid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPageidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pageid not like ", value, "pageid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPageidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pageid in ", value, "pageid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPageidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pageid not in ", value, "pageid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPageidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pageid between ", value1, value2, "pageid");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andPageidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pageid not between ", value1, value2, "pageid");
            return (CardViewCriteria) this;
        }
        
        public CardViewCriteria andRefdateIsNull() {
            addCriterion("refdate is null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andRefdateIsNotNull() {
            addCriterion("refdate is not null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andRefdateEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate =", value, "refdate");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andRefdateNotEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate <>", value, "refdate");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andRefdateGreaterThan(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate >", value, "refdate");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andRefdateGreaterThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate >=", value, "refdate");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andRefdateLessThan(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate <", value, "refdate");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andRefdateLessThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate <=", value, "refdate");
            return (CardViewCriteria) this;
        }

        
        public CardViewCriteria andOptionsIsNull() {
            addCriterion("options is null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andOptionsIsNotNull() {
            addCriterion("options is not null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andOptionsEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options =", value, "options");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andOptionsNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options <>", value, "options");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andOptionsGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("options >", value, "options");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andOptionsGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options >=", value, "options");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andOptionsLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("options <", value, "options");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andOptionsLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options <=", value, "options");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andOptionsLike(java.lang.String value) {
            if (value != null)
              addCriterion("options like ", value, "options");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andOptionsNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("options not like ", value, "options");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andOptionsIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("options in ", value, "options");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andOptionsNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("options not in ", value, "options");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andOptionsBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("options between ", value1, value2, "options");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andOptionsNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("options not between ", value1, value2, "options");
            return (CardViewCriteria) this;
        }
        
        public CardViewCriteria andTitleIsNull() {
            addCriterion("title is null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTitleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("title =", value, "title");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTitleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("title <>", value, "title");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTitleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("title >", value, "title");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTitleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("title >=", value, "title");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTitleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("title <", value, "title");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTitleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("title <=", value, "title");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTitleLike(java.lang.String value) {
            if (value != null)
              addCriterion("title like ", value, "title");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTitleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("title not like ", value, "title");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTitleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("title in ", value, "title");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTitleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("title not in ", value, "title");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTitleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("title between ", value1, value2, "title");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTitleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("title not between ", value1, value2, "title");
            return (CardViewCriteria) this;
        }
        
        public CardViewCriteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSummaryEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("summary =", value, "summary");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSummaryNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("summary <>", value, "summary");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSummaryGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("summary >", value, "summary");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSummaryGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("summary >=", value, "summary");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSummaryLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("summary <", value, "summary");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSummaryLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("summary <=", value, "summary");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSummaryLike(java.lang.String value) {
            if (value != null)
              addCriterion("summary like ", value, "summary");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSummaryNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("summary not like ", value, "summary");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSummaryIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("summary in ", value, "summary");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSummaryNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("summary not in ", value, "summary");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSummaryBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("summary between ", value1, value2, "summary");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andSummaryNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("summary not between ", value1, value2, "summary");
            return (CardViewCriteria) this;
        }
        
        public CardViewCriteria andTextbodyIsNull() {
            addCriterion("textbody is null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTextbodyIsNotNull() {
            addCriterion("textbody is not null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTextbodyEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("textbody =", value, "textbody");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTextbodyNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("textbody <>", value, "textbody");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTextbodyGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("textbody >", value, "textbody");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTextbodyGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("textbody >=", value, "textbody");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTextbodyLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("textbody <", value, "textbody");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTextbodyLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("textbody <=", value, "textbody");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTextbodyLike(java.lang.String value) {
            if (value != null)
              addCriterion("textbody like ", value, "textbody");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTextbodyNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("textbody not like ", value, "textbody");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTextbodyIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("textbody in ", value, "textbody");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTextbodyNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("textbody not in ", value, "textbody");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTextbodyBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("textbody between ", value1, value2, "textbody");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andTextbodyNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("textbody not between ", value1, value2, "textbody");
            return (CardViewCriteria) this;
        }
        
        public CardViewCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (CardViewCriteria) this;
        }
        public CardViewCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (CardViewCriteria) this;
        }

    }
    
}

