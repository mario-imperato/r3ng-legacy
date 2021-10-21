//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.card;

import java.util.ArrayList;
import java.util.List;

public class CardFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public CardFilter() 
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

    public CardCriteria or() 
    {
        CardCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public CardCriteria createCriteria() 
    {
        CardCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected CardCriteria createCriteriaInternal() 
    {
        CardCriteria criteria = new CardCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class CardCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public CardCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (CardCriteria) this;
        }
        public CardCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (CardCriteria) this;
        }
        public CardCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (CardCriteria) this;
        }
        public CardCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (CardCriteria) this;
        }
        public CardCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (CardCriteria) this;
        }
        public CardCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (CardCriteria) this;
        }
        public CardCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (CardCriteria) this;
        }
        public CardCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (CardCriteria) this;
        }
        public CardCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (CardCriteria) this;
        }
        public CardCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (CardCriteria) this;
        }
        public CardCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (CardCriteria) this;
        }
        public CardCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (CardCriteria) this;
        }
        public CardCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (CardCriteria) this;
        }
        public CardCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (CardCriteria) this;
        }
        
        public CardCriteria andCardidIsNull() {
            addCriterion("cardid is null");
            return (CardCriteria) this;
        }
        public CardCriteria andCardidIsNotNull() {
            addCriterion("cardid is not null");
            return (CardCriteria) this;
        }
        public CardCriteria andCardidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid =", value, "cardid");
            return (CardCriteria) this;
        }
        public CardCriteria andCardidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <>", value, "cardid");
            return (CardCriteria) this;
        }
        public CardCriteria andCardidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardid >", value, "cardid");
            return (CardCriteria) this;
        }
        public CardCriteria andCardidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid >=", value, "cardid");
            return (CardCriteria) this;
        }
        public CardCriteria andCardidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <", value, "cardid");
            return (CardCriteria) this;
        }
        public CardCriteria andCardidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <=", value, "cardid");
            return (CardCriteria) this;
        }
        public CardCriteria andCardidLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardid like ", value, "cardid");
            return (CardCriteria) this;
        }
        public CardCriteria andCardidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardid not like ", value, "cardid");
            return (CardCriteria) this;
        }
        public CardCriteria andCardidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("cardid in ", value, "cardid");
            return (CardCriteria) this;
        }
        public CardCriteria andCardidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("cardid not in ", value, "cardid");
            return (CardCriteria) this;
        }
        public CardCriteria andCardidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardid between ", value1, value2, "cardid");
            return (CardCriteria) this;
        }
        public CardCriteria andCardidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardid not between ", value1, value2, "cardid");
            return (CardCriteria) this;
        }
        
        public CardCriteria andSystemtitleIsNull() {
            addCriterion("systemtitle is null");
            return (CardCriteria) this;
        }
        public CardCriteria andSystemtitleIsNotNull() {
            addCriterion("systemtitle is not null");
            return (CardCriteria) this;
        }
        public CardCriteria andSystemtitleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("systemtitle =", value, "systemtitle");
            return (CardCriteria) this;
        }
        public CardCriteria andSystemtitleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("systemtitle <>", value, "systemtitle");
            return (CardCriteria) this;
        }
        public CardCriteria andSystemtitleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("systemtitle >", value, "systemtitle");
            return (CardCriteria) this;
        }
        public CardCriteria andSystemtitleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("systemtitle >=", value, "systemtitle");
            return (CardCriteria) this;
        }
        public CardCriteria andSystemtitleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("systemtitle <", value, "systemtitle");
            return (CardCriteria) this;
        }
        public CardCriteria andSystemtitleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("systemtitle <=", value, "systemtitle");
            return (CardCriteria) this;
        }
        public CardCriteria andSystemtitleLike(java.lang.String value) {
            if (value != null)
              addCriterion("systemtitle like ", value, "systemtitle");
            return (CardCriteria) this;
        }
        public CardCriteria andSystemtitleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("systemtitle not like ", value, "systemtitle");
            return (CardCriteria) this;
        }
        public CardCriteria andSystemtitleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("systemtitle in ", value, "systemtitle");
            return (CardCriteria) this;
        }
        public CardCriteria andSystemtitleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("systemtitle not in ", value, "systemtitle");
            return (CardCriteria) this;
        }
        public CardCriteria andSystemtitleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("systemtitle between ", value1, value2, "systemtitle");
            return (CardCriteria) this;
        }
        public CardCriteria andSystemtitleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("systemtitle not between ", value1, value2, "systemtitle");
            return (CardCriteria) this;
        }
        
        public CardCriteria andPagelinktypeIsNull() {
            addCriterion("pagelinktype is null");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinktypeIsNotNull() {
            addCriterion("pagelinktype is not null");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinktypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype =", value, "pagelinktype");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinktypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype <>", value, "pagelinktype");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinktypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype >", value, "pagelinktype");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinktypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype >=", value, "pagelinktype");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinktypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype <", value, "pagelinktype");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinktypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype <=", value, "pagelinktype");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinktypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype like ", value, "pagelinktype");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinktypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagelinktype not like ", value, "pagelinktype");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinktypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pagelinktype in ", value, "pagelinktype");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinktypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pagelinktype not in ", value, "pagelinktype");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinktypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagelinktype between ", value1, value2, "pagelinktype");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinktypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagelinktype not between ", value1, value2, "pagelinktype");
            return (CardCriteria) this;
        }
        
        public CardCriteria andPagelinkIsNull() {
            addCriterion("pagelink is null");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinkIsNotNull() {
            addCriterion("pagelink is not null");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinkEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink =", value, "pagelink");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinkNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink <>", value, "pagelink");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinkGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink >", value, "pagelink");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinkGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink >=", value, "pagelink");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinkLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink <", value, "pagelink");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinkLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink <=", value, "pagelink");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinkLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink like ", value, "pagelink");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinkNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink not like ", value, "pagelink");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinkIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pagelink in ", value, "pagelink");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinkNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pagelink not in ", value, "pagelink");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinkBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagelink between ", value1, value2, "pagelink");
            return (CardCriteria) this;
        }
        public CardCriteria andPagelinkNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagelink not between ", value1, value2, "pagelink");
            return (CardCriteria) this;
        }
        
        public CardCriteria andPageidIsNull() {
            addCriterion("pageid is null");
            return (CardCriteria) this;
        }
        public CardCriteria andPageidIsNotNull() {
            addCriterion("pageid is not null");
            return (CardCriteria) this;
        }
        public CardCriteria andPageidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid =", value, "pageid");
            return (CardCriteria) this;
        }
        public CardCriteria andPageidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid <>", value, "pageid");
            return (CardCriteria) this;
        }
        public CardCriteria andPageidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pageid >", value, "pageid");
            return (CardCriteria) this;
        }
        public CardCriteria andPageidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid >=", value, "pageid");
            return (CardCriteria) this;
        }
        public CardCriteria andPageidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pageid <", value, "pageid");
            return (CardCriteria) this;
        }
        public CardCriteria andPageidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid <=", value, "pageid");
            return (CardCriteria) this;
        }
        public CardCriteria andPageidLike(java.lang.String value) {
            if (value != null)
              addCriterion("pageid like ", value, "pageid");
            return (CardCriteria) this;
        }
        public CardCriteria andPageidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pageid not like ", value, "pageid");
            return (CardCriteria) this;
        }
        public CardCriteria andPageidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pageid in ", value, "pageid");
            return (CardCriteria) this;
        }
        public CardCriteria andPageidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pageid not in ", value, "pageid");
            return (CardCriteria) this;
        }
        public CardCriteria andPageidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pageid between ", value1, value2, "pageid");
            return (CardCriteria) this;
        }
        public CardCriteria andPageidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pageid not between ", value1, value2, "pageid");
            return (CardCriteria) this;
        }
        
        public CardCriteria andRefdateIsNull() {
            addCriterion("refdate is null");
            return (CardCriteria) this;
        }
        public CardCriteria andRefdateIsNotNull() {
            addCriterion("refdate is not null");
            return (CardCriteria) this;
        }
        public CardCriteria andRefdateEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate =", value, "refdate");
            return (CardCriteria) this;
        }
        public CardCriteria andRefdateNotEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate <>", value, "refdate");
            return (CardCriteria) this;
        }
        public CardCriteria andRefdateGreaterThan(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate >", value, "refdate");
            return (CardCriteria) this;
        }
        public CardCriteria andRefdateGreaterThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate >=", value, "refdate");
            return (CardCriteria) this;
        }
        public CardCriteria andRefdateLessThan(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate <", value, "refdate");
            return (CardCriteria) this;
        }
        public CardCriteria andRefdateLessThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate <=", value, "refdate");
            return (CardCriteria) this;
        }

        
        public CardCriteria andOptionsIsNull() {
            addCriterion("options is null");
            return (CardCriteria) this;
        }
        public CardCriteria andOptionsIsNotNull() {
            addCriterion("options is not null");
            return (CardCriteria) this;
        }
        public CardCriteria andOptionsEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options =", value, "options");
            return (CardCriteria) this;
        }
        public CardCriteria andOptionsNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options <>", value, "options");
            return (CardCriteria) this;
        }
        public CardCriteria andOptionsGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("options >", value, "options");
            return (CardCriteria) this;
        }
        public CardCriteria andOptionsGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options >=", value, "options");
            return (CardCriteria) this;
        }
        public CardCriteria andOptionsLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("options <", value, "options");
            return (CardCriteria) this;
        }
        public CardCriteria andOptionsLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options <=", value, "options");
            return (CardCriteria) this;
        }
        public CardCriteria andOptionsLike(java.lang.String value) {
            if (value != null)
              addCriterion("options like ", value, "options");
            return (CardCriteria) this;
        }
        public CardCriteria andOptionsNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("options not like ", value, "options");
            return (CardCriteria) this;
        }
        public CardCriteria andOptionsIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("options in ", value, "options");
            return (CardCriteria) this;
        }
        public CardCriteria andOptionsNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("options not in ", value, "options");
            return (CardCriteria) this;
        }
        public CardCriteria andOptionsBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("options between ", value1, value2, "options");
            return (CardCriteria) this;
        }
        public CardCriteria andOptionsNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("options not between ", value1, value2, "options");
            return (CardCriteria) this;
        }
        
        public CardCriteria andValidityruleIsNull() {
            addCriterion("validityrule is null");
            return (CardCriteria) this;
        }
        public CardCriteria andValidityruleIsNotNull() {
            addCriterion("validityrule is not null");
            return (CardCriteria) this;
        }
        public CardCriteria andValidityruleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("validityrule =", value, "validityrule");
            return (CardCriteria) this;
        }
        public CardCriteria andValidityruleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("validityrule <>", value, "validityrule");
            return (CardCriteria) this;
        }
        public CardCriteria andValidityruleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("validityrule >", value, "validityrule");
            return (CardCriteria) this;
        }
        public CardCriteria andValidityruleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("validityrule >=", value, "validityrule");
            return (CardCriteria) this;
        }
        public CardCriteria andValidityruleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("validityrule <", value, "validityrule");
            return (CardCriteria) this;
        }
        public CardCriteria andValidityruleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("validityrule <=", value, "validityrule");
            return (CardCriteria) this;
        }
        public CardCriteria andValidityruleLike(java.lang.String value) {
            if (value != null)
              addCriterion("validityrule like ", value, "validityrule");
            return (CardCriteria) this;
        }
        public CardCriteria andValidityruleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("validityrule not like ", value, "validityrule");
            return (CardCriteria) this;
        }
        public CardCriteria andValidityruleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("validityrule in ", value, "validityrule");
            return (CardCriteria) this;
        }
        public CardCriteria andValidityruleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("validityrule not in ", value, "validityrule");
            return (CardCriteria) this;
        }
        public CardCriteria andValidityruleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("validityrule between ", value1, value2, "validityrule");
            return (CardCriteria) this;
        }
        public CardCriteria andValidityruleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("validityrule not between ", value1, value2, "validityrule");
            return (CardCriteria) this;
        }
        
        public CardCriteria andValidfromIsNull() {
            addCriterion("validfrom is null");
            return (CardCriteria) this;
        }
        public CardCriteria andValidfromIsNotNull() {
            addCriterion("validfrom is not null");
            return (CardCriteria) this;
        }
        public CardCriteria andValidfromEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("validfrom =", value, "validfrom");
            return (CardCriteria) this;
        }
        public CardCriteria andValidfromNotEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("validfrom <>", value, "validfrom");
            return (CardCriteria) this;
        }
        public CardCriteria andValidfromGreaterThan(java.sql.Date value) {
            if (value != null)
              addCriterion("validfrom >", value, "validfrom");
            return (CardCriteria) this;
        }
        public CardCriteria andValidfromGreaterThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("validfrom >=", value, "validfrom");
            return (CardCriteria) this;
        }
        public CardCriteria andValidfromLessThan(java.sql.Date value) {
            if (value != null)
              addCriterion("validfrom <", value, "validfrom");
            return (CardCriteria) this;
        }
        public CardCriteria andValidfromLessThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("validfrom <=", value, "validfrom");
            return (CardCriteria) this;
        }

        
        public CardCriteria andValidtoIsNull() {
            addCriterion("validto is null");
            return (CardCriteria) this;
        }
        public CardCriteria andValidtoIsNotNull() {
            addCriterion("validto is not null");
            return (CardCriteria) this;
        }
        public CardCriteria andValidtoEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("validto =", value, "validto");
            return (CardCriteria) this;
        }
        public CardCriteria andValidtoNotEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("validto <>", value, "validto");
            return (CardCriteria) this;
        }
        public CardCriteria andValidtoGreaterThan(java.sql.Date value) {
            if (value != null)
              addCriterion("validto >", value, "validto");
            return (CardCriteria) this;
        }
        public CardCriteria andValidtoGreaterThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("validto >=", value, "validto");
            return (CardCriteria) this;
        }
        public CardCriteria andValidtoLessThan(java.sql.Date value) {
            if (value != null)
              addCriterion("validto <", value, "validto");
            return (CardCriteria) this;
        }
        public CardCriteria andValidtoLessThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("validto <=", value, "validto");
            return (CardCriteria) this;
        }

        
        public CardCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (CardCriteria) this;
        }
        public CardCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (CardCriteria) this;
        }
        public CardCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (CardCriteria) this;
        }
        public CardCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (CardCriteria) this;
        }
        public CardCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (CardCriteria) this;
        }
        public CardCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (CardCriteria) this;
        }
        public CardCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (CardCriteria) this;
        }
        public CardCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (CardCriteria) this;
        }
        public CardCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (CardCriteria) this;
        }
        public CardCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (CardCriteria) this;
        }
        public CardCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (CardCriteria) this;
        }
        public CardCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (CardCriteria) this;
        }
        public CardCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (CardCriteria) this;
        }
        public CardCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (CardCriteria) this;
        }
        
        public CardCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (CardCriteria) this;
        }
        public CardCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (CardCriteria) this;
        }
        public CardCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (CardCriteria) this;
        }
        public CardCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (CardCriteria) this;
        }
        public CardCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (CardCriteria) this;
        }
        public CardCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (CardCriteria) this;
        }
        public CardCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (CardCriteria) this;
        }
        public CardCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (CardCriteria) this;
        }

        
        public CardCriteria andCategoryidIsNull() {
            addCriterion("categoryid is null");
            return (CardCriteria) this;
        }
        public CardCriteria andCategoryidIsNotNull() {
            addCriterion("categoryid is not null");
            return (CardCriteria) this;
        }
        public CardCriteria andCategoryidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid =", value, "categoryid");
            return (CardCriteria) this;
        }
        public CardCriteria andCategoryidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid <>", value, "categoryid");
            return (CardCriteria) this;
        }
        public CardCriteria andCategoryidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid >", value, "categoryid");
            return (CardCriteria) this;
        }
        public CardCriteria andCategoryidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid >=", value, "categoryid");
            return (CardCriteria) this;
        }
        public CardCriteria andCategoryidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid <", value, "categoryid");
            return (CardCriteria) this;
        }
        public CardCriteria andCategoryidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid <=", value, "categoryid");
            return (CardCriteria) this;
        }
        public CardCriteria andCategoryidLike(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid like ", value, "categoryid");
            return (CardCriteria) this;
        }
        public CardCriteria andCategoryidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid not like ", value, "categoryid");
            return (CardCriteria) this;
        }
        public CardCriteria andCategoryidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("categoryid in ", value, "categoryid");
            return (CardCriteria) this;
        }
        public CardCriteria andCategoryidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("categoryid not in ", value, "categoryid");
            return (CardCriteria) this;
        }
        public CardCriteria andCategoryidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("categoryid between ", value1, value2, "categoryid");
            return (CardCriteria) this;
        }
        public CardCriteria andCategoryidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("categoryid not between ", value1, value2, "categoryid");
            return (CardCriteria) this;
        }
    }
    
}

