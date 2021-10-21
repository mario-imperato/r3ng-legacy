//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.carddescr;

import java.util.ArrayList;
import java.util.List;

public class CardDescrFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public CardDescrFilter() 
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

    public CardDescrCriteria or() 
    {
        CardDescrCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public CardDescrCriteria createCriteria() 
    {
        CardDescrCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected CardDescrCriteria createCriteriaInternal() 
    {
        CardDescrCriteria criteria = new CardDescrCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class CardDescrCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public CardDescrCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (CardDescrCriteria) this;
        }
        
        public CardDescrCriteria andCardidIsNull() {
            addCriterion("cardid is null");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andCardidIsNotNull() {
            addCriterion("cardid is not null");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andCardidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid =", value, "cardid");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andCardidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <>", value, "cardid");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andCardidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardid >", value, "cardid");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andCardidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid >=", value, "cardid");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andCardidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <", value, "cardid");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andCardidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <=", value, "cardid");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andCardidLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardid like ", value, "cardid");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andCardidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardid not like ", value, "cardid");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andCardidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("cardid in ", value, "cardid");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andCardidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("cardid not in ", value, "cardid");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andCardidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardid between ", value1, value2, "cardid");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andCardidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardid not between ", value1, value2, "cardid");
            return (CardDescrCriteria) this;
        }
        
        public CardDescrCriteria andLanguagecodeIsNull() {
            addCriterion("languagecode is null");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andLanguagecodeIsNotNull() {
            addCriterion("languagecode is not null");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andLanguagecodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode =", value, "languagecode");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andLanguagecodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode <>", value, "languagecode");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andLanguagecodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode >", value, "languagecode");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andLanguagecodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode >=", value, "languagecode");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andLanguagecodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode <", value, "languagecode");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andLanguagecodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode <=", value, "languagecode");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andLanguagecodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode like ", value, "languagecode");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andLanguagecodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode not like ", value, "languagecode");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andLanguagecodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("languagecode in ", value, "languagecode");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andLanguagecodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("languagecode not in ", value, "languagecode");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andLanguagecodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("languagecode between ", value1, value2, "languagecode");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andLanguagecodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("languagecode not between ", value1, value2, "languagecode");
            return (CardDescrCriteria) this;
        }
        
        public CardDescrCriteria andTitleIsNull() {
            addCriterion("title is null");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTitleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("title =", value, "title");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTitleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("title <>", value, "title");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTitleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("title >", value, "title");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTitleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("title >=", value, "title");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTitleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("title <", value, "title");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTitleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("title <=", value, "title");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTitleLike(java.lang.String value) {
            if (value != null)
              addCriterion("title like ", value, "title");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTitleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("title not like ", value, "title");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTitleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("title in ", value, "title");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTitleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("title not in ", value, "title");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTitleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("title between ", value1, value2, "title");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTitleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("title not between ", value1, value2, "title");
            return (CardDescrCriteria) this;
        }
        
        public CardDescrCriteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSummaryEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("summary =", value, "summary");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSummaryNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("summary <>", value, "summary");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSummaryGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("summary >", value, "summary");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSummaryGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("summary >=", value, "summary");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSummaryLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("summary <", value, "summary");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSummaryLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("summary <=", value, "summary");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSummaryLike(java.lang.String value) {
            if (value != null)
              addCriterion("summary like ", value, "summary");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSummaryNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("summary not like ", value, "summary");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSummaryIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("summary in ", value, "summary");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSummaryNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("summary not in ", value, "summary");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSummaryBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("summary between ", value1, value2, "summary");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andSummaryNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("summary not between ", value1, value2, "summary");
            return (CardDescrCriteria) this;
        }
        
        public CardDescrCriteria andTextbodyIsNull() {
            addCriterion("textbody is null");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTextbodyIsNotNull() {
            addCriterion("textbody is not null");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTextbodyEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("textbody =", value, "textbody");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTextbodyNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("textbody <>", value, "textbody");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTextbodyGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("textbody >", value, "textbody");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTextbodyGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("textbody >=", value, "textbody");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTextbodyLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("textbody <", value, "textbody");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTextbodyLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("textbody <=", value, "textbody");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTextbodyLike(java.lang.String value) {
            if (value != null)
              addCriterion("textbody like ", value, "textbody");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTextbodyNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("textbody not like ", value, "textbody");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTextbodyIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("textbody in ", value, "textbody");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTextbodyNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("textbody not in ", value, "textbody");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTextbodyBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("textbody between ", value1, value2, "textbody");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andTextbodyNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("textbody not between ", value1, value2, "textbody");
            return (CardDescrCriteria) this;
        }
        
        public CardDescrCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (CardDescrCriteria) this;
        }
        
        public CardDescrCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (CardDescrCriteria) this;
        }
        public CardDescrCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (CardDescrCriteria) this;
        }

    }
    
}

