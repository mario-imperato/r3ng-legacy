//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.pagedescr;

import java.util.ArrayList;
import java.util.List;

public class PageDescrFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public PageDescrFilter() 
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

    public PageDescrCriteria or() 
    {
        PageDescrCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public PageDescrCriteria createCriteria() 
    {
        PageDescrCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected PageDescrCriteria createCriteriaInternal() 
    {
        PageDescrCriteria criteria = new PageDescrCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class PageDescrCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public PageDescrCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (PageDescrCriteria) this;
        }
        
        public PageDescrCriteria andPageidIsNull() {
            addCriterion("pageid is null");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPageidIsNotNull() {
            addCriterion("pageid is not null");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPageidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid =", value, "pageid");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPageidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid <>", value, "pageid");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPageidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pageid >", value, "pageid");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPageidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid >=", value, "pageid");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPageidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pageid <", value, "pageid");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPageidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid <=", value, "pageid");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPageidLike(java.lang.String value) {
            if (value != null)
              addCriterion("pageid like ", value, "pageid");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPageidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pageid not like ", value, "pageid");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPageidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pageid in ", value, "pageid");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPageidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pageid not in ", value, "pageid");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPageidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pageid between ", value1, value2, "pageid");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPageidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pageid not between ", value1, value2, "pageid");
            return (PageDescrCriteria) this;
        }
        
        public PageDescrCriteria andLanguagecodeIsNull() {
            addCriterion("languagecode is null");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andLanguagecodeIsNotNull() {
            addCriterion("languagecode is not null");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andLanguagecodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode =", value, "languagecode");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andLanguagecodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode <>", value, "languagecode");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andLanguagecodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode >", value, "languagecode");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andLanguagecodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode >=", value, "languagecode");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andLanguagecodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode <", value, "languagecode");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andLanguagecodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode <=", value, "languagecode");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andLanguagecodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode like ", value, "languagecode");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andLanguagecodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode not like ", value, "languagecode");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andLanguagecodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("languagecode in ", value, "languagecode");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andLanguagecodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("languagecode not in ", value, "languagecode");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andLanguagecodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("languagecode between ", value1, value2, "languagecode");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andLanguagecodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("languagecode not between ", value1, value2, "languagecode");
            return (PageDescrCriteria) this;
        }
        
        public PageDescrCriteria andPagetitleIsNull() {
            addCriterion("pagetitle is null");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPagetitleIsNotNull() {
            addCriterion("pagetitle is not null");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPagetitleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagetitle =", value, "pagetitle");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPagetitleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagetitle <>", value, "pagetitle");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPagetitleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagetitle >", value, "pagetitle");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPagetitleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagetitle >=", value, "pagetitle");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPagetitleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagetitle <", value, "pagetitle");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPagetitleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagetitle <=", value, "pagetitle");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPagetitleLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagetitle like ", value, "pagetitle");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPagetitleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagetitle not like ", value, "pagetitle");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPagetitleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pagetitle in ", value, "pagetitle");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPagetitleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pagetitle not in ", value, "pagetitle");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPagetitleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagetitle between ", value1, value2, "pagetitle");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andPagetitleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagetitle not between ", value1, value2, "pagetitle");
            return (PageDescrCriteria) this;
        }
        
        public PageDescrCriteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSummaryEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("summary =", value, "summary");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSummaryNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("summary <>", value, "summary");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSummaryGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("summary >", value, "summary");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSummaryGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("summary >=", value, "summary");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSummaryLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("summary <", value, "summary");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSummaryLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("summary <=", value, "summary");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSummaryLike(java.lang.String value) {
            if (value != null)
              addCriterion("summary like ", value, "summary");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSummaryNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("summary not like ", value, "summary");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSummaryIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("summary in ", value, "summary");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSummaryNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("summary not in ", value, "summary");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSummaryBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("summary between ", value1, value2, "summary");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andSummaryNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("summary not between ", value1, value2, "summary");
            return (PageDescrCriteria) this;
        }
        
        public PageDescrCriteria andTextbodyIsNull() {
            addCriterion("textbody is null");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andTextbodyIsNotNull() {
            addCriterion("textbody is not null");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andTextbodyEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("textbody =", value, "textbody");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andTextbodyNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("textbody <>", value, "textbody");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andTextbodyGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("textbody >", value, "textbody");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andTextbodyGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("textbody >=", value, "textbody");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andTextbodyLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("textbody <", value, "textbody");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andTextbodyLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("textbody <=", value, "textbody");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andTextbodyLike(java.lang.String value) {
            if (value != null)
              addCriterion("textbody like ", value, "textbody");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andTextbodyNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("textbody not like ", value, "textbody");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andTextbodyIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("textbody in ", value, "textbody");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andTextbodyNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("textbody not in ", value, "textbody");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andTextbodyBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("textbody between ", value1, value2, "textbody");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andTextbodyNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("textbody not between ", value1, value2, "textbody");
            return (PageDescrCriteria) this;
        }
        
        public PageDescrCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (PageDescrCriteria) this;
        }
        
        public PageDescrCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (PageDescrCriteria) this;
        }
        public PageDescrCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (PageDescrCriteria) this;
        }

    }
    
}

