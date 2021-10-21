//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.pageview;

import java.util.ArrayList;
import java.util.List;

public class PageViewFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public PageViewFilter() 
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

    public PageViewCriteria or() 
    {
        PageViewCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public PageViewCriteria createCriteria() 
    {
        PageViewCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected PageViewCriteria createCriteriaInternal() 
    {
        PageViewCriteria criteria = new PageViewCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class PageViewCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public PageViewCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (PageViewCriteria) this;
        }
        
        public PageViewCriteria andPageidIsNull() {
            addCriterion("pageid is null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageidIsNotNull() {
            addCriterion("pageid is not null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid =", value, "pageid");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid <>", value, "pageid");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pageid >", value, "pageid");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid >=", value, "pageid");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pageid <", value, "pageid");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid <=", value, "pageid");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageidLike(java.lang.String value) {
            if (value != null)
              addCriterion("pageid like ", value, "pageid");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pageid not like ", value, "pageid");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pageid in ", value, "pageid");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pageid not in ", value, "pageid");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pageid between ", value1, value2, "pageid");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pageid not between ", value1, value2, "pageid");
            return (PageViewCriteria) this;
        }
        
        public PageViewCriteria andLanguagecodeIsNull() {
            addCriterion("languagecode is null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andLanguagecodeIsNotNull() {
            addCriterion("languagecode is not null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andLanguagecodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode =", value, "languagecode");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andLanguagecodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode <>", value, "languagecode");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andLanguagecodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode >", value, "languagecode");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andLanguagecodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode >=", value, "languagecode");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andLanguagecodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode <", value, "languagecode");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andLanguagecodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode <=", value, "languagecode");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andLanguagecodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode like ", value, "languagecode");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andLanguagecodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode not like ", value, "languagecode");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andLanguagecodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("languagecode in ", value, "languagecode");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andLanguagecodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("languagecode not in ", value, "languagecode");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andLanguagecodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("languagecode between ", value1, value2, "languagecode");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andLanguagecodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("languagecode not between ", value1, value2, "languagecode");
            return (PageViewCriteria) this;
        }
        
        public PageViewCriteria andPagetypeIsNull() {
            addCriterion("pagetype is null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetypeIsNotNull() {
            addCriterion("pagetype is not null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagetype =", value, "pagetype");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagetype <>", value, "pagetype");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagetype >", value, "pagetype");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagetype >=", value, "pagetype");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagetype <", value, "pagetype");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagetype <=", value, "pagetype");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagetype like ", value, "pagetype");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagetype not like ", value, "pagetype");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pagetype in ", value, "pagetype");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pagetype not in ", value, "pagetype");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagetype between ", value1, value2, "pagetype");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagetype not between ", value1, value2, "pagetype");
            return (PageViewCriteria) this;
        }
        
        public PageViewCriteria andPagetitleIsNull() {
            addCriterion("pagetitle is null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetitleIsNotNull() {
            addCriterion("pagetitle is not null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetitleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagetitle =", value, "pagetitle");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetitleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagetitle <>", value, "pagetitle");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetitleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagetitle >", value, "pagetitle");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetitleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagetitle >=", value, "pagetitle");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetitleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagetitle <", value, "pagetitle");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetitleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagetitle <=", value, "pagetitle");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetitleLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagetitle like ", value, "pagetitle");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetitleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagetitle not like ", value, "pagetitle");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetitleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pagetitle in ", value, "pagetitle");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetitleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pagetitle not in ", value, "pagetitle");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetitleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagetitle between ", value1, value2, "pagetitle");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagetitleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagetitle not between ", value1, value2, "pagetitle");
            return (PageViewCriteria) this;
        }
        
        public PageViewCriteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSummaryEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("summary =", value, "summary");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSummaryNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("summary <>", value, "summary");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSummaryGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("summary >", value, "summary");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSummaryGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("summary >=", value, "summary");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSummaryLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("summary <", value, "summary");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSummaryLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("summary <=", value, "summary");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSummaryLike(java.lang.String value) {
            if (value != null)
              addCriterion("summary like ", value, "summary");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSummaryNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("summary not like ", value, "summary");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSummaryIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("summary in ", value, "summary");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSummaryNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("summary not in ", value, "summary");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSummaryBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("summary between ", value1, value2, "summary");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andSummaryNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("summary not between ", value1, value2, "summary");
            return (PageViewCriteria) this;
        }
        
        public PageViewCriteria andPageicon1IsNull() {
            addCriterion("pageicon1 is null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon1IsNotNull() {
            addCriterion("pageicon1 is not null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon1EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon1 =", value, "pageicon1");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon1NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon1 <>", value, "pageicon1");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon1GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon1 >", value, "pageicon1");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon1GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon1 >=", value, "pageicon1");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon1LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon1 <", value, "pageicon1");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon1LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon1 <=", value, "pageicon1");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon1Like(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon1 like ", value, "pageicon1");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon1NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon1 not like ", value, "pageicon1");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon1In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pageicon1 in ", value, "pageicon1");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon1NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pageicon1 not in ", value, "pageicon1");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon1Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pageicon1 between ", value1, value2, "pageicon1");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon1NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pageicon1 not between ", value1, value2, "pageicon1");
            return (PageViewCriteria) this;
        }
        
        public PageViewCriteria andPageicon2IsNull() {
            addCriterion("pageicon2 is null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon2IsNotNull() {
            addCriterion("pageicon2 is not null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon2EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon2 =", value, "pageicon2");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon2NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon2 <>", value, "pageicon2");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon2GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon2 >", value, "pageicon2");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon2GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon2 >=", value, "pageicon2");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon2LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon2 <", value, "pageicon2");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon2LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon2 <=", value, "pageicon2");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon2Like(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon2 like ", value, "pageicon2");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon2NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon2 not like ", value, "pageicon2");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon2In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pageicon2 in ", value, "pageicon2");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon2NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pageicon2 not in ", value, "pageicon2");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon2Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pageicon2 between ", value1, value2, "pageicon2");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageicon2NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pageicon2 not between ", value1, value2, "pageicon2");
            return (PageViewCriteria) this;
        }
        
        public PageViewCriteria andPagelinkIsNull() {
            addCriterion("pagelink is null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagelinkIsNotNull() {
            addCriterion("pagelink is not null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagelinkEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink =", value, "pagelink");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagelinkNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink <>", value, "pagelink");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagelinkGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink >", value, "pagelink");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagelinkGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink >=", value, "pagelink");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagelinkLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink <", value, "pagelink");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagelinkLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink <=", value, "pagelink");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagelinkLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink like ", value, "pagelink");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagelinkNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink not like ", value, "pagelink");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagelinkIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pagelink in ", value, "pagelink");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagelinkNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pagelink not in ", value, "pagelink");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagelinkBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagelink between ", value1, value2, "pagelink");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagelinkNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagelink not between ", value1, value2, "pagelink");
            return (PageViewCriteria) this;
        }
        
        public PageViewCriteria andPageorderIsNull() {
            addCriterion("pageorder is null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageorderIsNotNull() {
            addCriterion("pageorder is not null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageorderEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("pageorder =", value, "pageorder");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageorderNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("pageorder <>", value, "pageorder");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageorderGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("pageorder >", value, "pageorder");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageorderGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("pageorder >=", value, "pageorder");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageorderLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("pageorder <", value, "pageorder");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPageorderLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("pageorder <=", value, "pageorder");
            return (PageViewCriteria) this;
        }

        
        public PageViewCriteria andVisibilityIsNull() {
            addCriterion("visibility is null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andVisibilityIsNotNull() {
            addCriterion("visibility is not null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andVisibilityEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("visibility =", value, "visibility");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andVisibilityNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("visibility <>", value, "visibility");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andVisibilityGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("visibility >", value, "visibility");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andVisibilityGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("visibility >=", value, "visibility");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andVisibilityLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("visibility <", value, "visibility");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andVisibilityLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("visibility <=", value, "visibility");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andVisibilityLike(java.lang.String value) {
            if (value != null)
              addCriterion("visibility like ", value, "visibility");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andVisibilityNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("visibility not like ", value, "visibility");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andVisibilityIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("visibility in ", value, "visibility");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andVisibilityNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("visibility not in ", value, "visibility");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andVisibilityBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("visibility between ", value1, value2, "visibility");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andVisibilityNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("visibility not between ", value1, value2, "visibility");
            return (PageViewCriteria) this;
        }
        
        public PageViewCriteria andPagestyleIsNull() {
            addCriterion("pagestyle is null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagestyleIsNotNull() {
            addCriterion("pagestyle is not null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagestyleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagestyle =", value, "pagestyle");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagestyleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagestyle <>", value, "pagestyle");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagestyleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagestyle >", value, "pagestyle");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagestyleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagestyle >=", value, "pagestyle");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagestyleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagestyle <", value, "pagestyle");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagestyleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagestyle <=", value, "pagestyle");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagestyleLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagestyle like ", value, "pagestyle");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagestyleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagestyle not like ", value, "pagestyle");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagestyleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pagestyle in ", value, "pagestyle");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagestyleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pagestyle not in ", value, "pagestyle");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagestyleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagestyle between ", value1, value2, "pagestyle");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPagestyleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagestyle not between ", value1, value2, "pagestyle");
            return (PageViewCriteria) this;
        }
        
        public PageViewCriteria andForwardviewIsNull() {
            addCriterion("forwardview is null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andForwardviewIsNotNull() {
            addCriterion("forwardview is not null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andForwardviewEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("forwardview =", value, "forwardview");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andForwardviewNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("forwardview <>", value, "forwardview");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andForwardviewGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("forwardview >", value, "forwardview");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andForwardviewGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("forwardview >=", value, "forwardview");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andForwardviewLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("forwardview <", value, "forwardview");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andForwardviewLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("forwardview <=", value, "forwardview");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andForwardviewLike(java.lang.String value) {
            if (value != null)
              addCriterion("forwardview like ", value, "forwardview");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andForwardviewNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("forwardview not like ", value, "forwardview");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andForwardviewIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("forwardview in ", value, "forwardview");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andForwardviewNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("forwardview not in ", value, "forwardview");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andForwardviewBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("forwardview between ", value1, value2, "forwardview");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andForwardviewNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("forwardview not between ", value1, value2, "forwardview");
            return (PageViewCriteria) this;
        }
        
        public PageViewCriteria andOnuserstatusIsNull() {
            addCriterion("onuserstatus is null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andOnuserstatusIsNotNull() {
            addCriterion("onuserstatus is not null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andOnuserstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("onuserstatus =", value, "onuserstatus");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andOnuserstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("onuserstatus <>", value, "onuserstatus");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andOnuserstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("onuserstatus >", value, "onuserstatus");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andOnuserstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("onuserstatus >=", value, "onuserstatus");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andOnuserstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("onuserstatus <", value, "onuserstatus");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andOnuserstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("onuserstatus <=", value, "onuserstatus");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andOnuserstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("onuserstatus like ", value, "onuserstatus");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andOnuserstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("onuserstatus not like ", value, "onuserstatus");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andOnuserstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("onuserstatus in ", value, "onuserstatus");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andOnuserstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("onuserstatus not in ", value, "onuserstatus");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andOnuserstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("onuserstatus between ", value1, value2, "onuserstatus");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andOnuserstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("onuserstatus not between ", value1, value2, "onuserstatus");
            return (PageViewCriteria) this;
        }
        
        public PageViewCriteria andPermissionsIsNull() {
            addCriterion("permissions is null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPermissionsIsNotNull() {
            addCriterion("permissions is not null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPermissionsEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("permissions =", value, "permissions");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPermissionsNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("permissions <>", value, "permissions");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPermissionsGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("permissions >", value, "permissions");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPermissionsGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("permissions >=", value, "permissions");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPermissionsLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("permissions <", value, "permissions");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPermissionsLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("permissions <=", value, "permissions");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPermissionsLike(java.lang.String value) {
            if (value != null)
              addCriterion("permissions like ", value, "permissions");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPermissionsNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("permissions not like ", value, "permissions");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPermissionsIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("permissions in ", value, "permissions");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPermissionsNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("permissions not in ", value, "permissions");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPermissionsBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("permissions between ", value1, value2, "permissions");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andPermissionsNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("permissions not between ", value1, value2, "permissions");
            return (PageViewCriteria) this;
        }
        
        public PageViewCriteria andViewoptionsIsNull() {
            addCriterion("viewoptions is null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andViewoptionsIsNotNull() {
            addCriterion("viewoptions is not null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andViewoptionsEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("viewoptions =", value, "viewoptions");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andViewoptionsNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("viewoptions <>", value, "viewoptions");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andViewoptionsGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("viewoptions >", value, "viewoptions");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andViewoptionsGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("viewoptions >=", value, "viewoptions");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andViewoptionsLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("viewoptions <", value, "viewoptions");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andViewoptionsLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("viewoptions <=", value, "viewoptions");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andViewoptionsLike(java.lang.String value) {
            if (value != null)
              addCriterion("viewoptions like ", value, "viewoptions");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andViewoptionsNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("viewoptions not like ", value, "viewoptions");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andViewoptionsIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("viewoptions in ", value, "viewoptions");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andViewoptionsNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("viewoptions not in ", value, "viewoptions");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andViewoptionsBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("viewoptions between ", value1, value2, "viewoptions");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andViewoptionsNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("viewoptions not between ", value1, value2, "viewoptions");
            return (PageViewCriteria) this;
        }
        
        public PageViewCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (PageViewCriteria) this;
        }
        
        public PageViewCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (PageViewCriteria) this;
        }
        public PageViewCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (PageViewCriteria) this;
        }

    }
    
}

