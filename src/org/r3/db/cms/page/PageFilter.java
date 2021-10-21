//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.page;

import java.util.ArrayList;
import java.util.List;

public class PageFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public PageFilter() 
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

    public PageCriteria or() 
    {
        PageCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public PageCriteria createCriteria() 
    {
        PageCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected PageCriteria createCriteriaInternal() 
    {
        PageCriteria criteria = new PageCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class PageCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public PageCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (PageCriteria) this;
        }
        public PageCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (PageCriteria) this;
        }
        public PageCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (PageCriteria) this;
        }
        public PageCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (PageCriteria) this;
        }
        public PageCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (PageCriteria) this;
        }
        public PageCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (PageCriteria) this;
        }
        public PageCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (PageCriteria) this;
        }
        public PageCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (PageCriteria) this;
        }
        public PageCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (PageCriteria) this;
        }
        public PageCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (PageCriteria) this;
        }
        public PageCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (PageCriteria) this;
        }
        public PageCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (PageCriteria) this;
        }
        public PageCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (PageCriteria) this;
        }
        public PageCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (PageCriteria) this;
        }
        
        public PageCriteria andPageidIsNull() {
            addCriterion("pageid is null");
            return (PageCriteria) this;
        }
        public PageCriteria andPageidIsNotNull() {
            addCriterion("pageid is not null");
            return (PageCriteria) this;
        }
        public PageCriteria andPageidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid =", value, "pageid");
            return (PageCriteria) this;
        }
        public PageCriteria andPageidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid <>", value, "pageid");
            return (PageCriteria) this;
        }
        public PageCriteria andPageidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pageid >", value, "pageid");
            return (PageCriteria) this;
        }
        public PageCriteria andPageidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid >=", value, "pageid");
            return (PageCriteria) this;
        }
        public PageCriteria andPageidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pageid <", value, "pageid");
            return (PageCriteria) this;
        }
        public PageCriteria andPageidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid <=", value, "pageid");
            return (PageCriteria) this;
        }
        public PageCriteria andPageidLike(java.lang.String value) {
            if (value != null)
              addCriterion("pageid like ", value, "pageid");
            return (PageCriteria) this;
        }
        public PageCriteria andPageidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pageid not like ", value, "pageid");
            return (PageCriteria) this;
        }
        public PageCriteria andPageidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pageid in ", value, "pageid");
            return (PageCriteria) this;
        }
        public PageCriteria andPageidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pageid not in ", value, "pageid");
            return (PageCriteria) this;
        }
        public PageCriteria andPageidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pageid between ", value1, value2, "pageid");
            return (PageCriteria) this;
        }
        public PageCriteria andPageidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pageid not between ", value1, value2, "pageid");
            return (PageCriteria) this;
        }
        
        public PageCriteria andPagetypeIsNull() {
            addCriterion("pagetype is null");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetypeIsNotNull() {
            addCriterion("pagetype is not null");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagetype =", value, "pagetype");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagetype <>", value, "pagetype");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagetype >", value, "pagetype");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagetype >=", value, "pagetype");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagetype <", value, "pagetype");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagetype <=", value, "pagetype");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagetype like ", value, "pagetype");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagetype not like ", value, "pagetype");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pagetype in ", value, "pagetype");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pagetype not in ", value, "pagetype");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagetype between ", value1, value2, "pagetype");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagetype not between ", value1, value2, "pagetype");
            return (PageCriteria) this;
        }
        
        public PageCriteria andPagetitleIsNull() {
            addCriterion("pagetitle is null");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetitleIsNotNull() {
            addCriterion("pagetitle is not null");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetitleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagetitle =", value, "pagetitle");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetitleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagetitle <>", value, "pagetitle");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetitleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagetitle >", value, "pagetitle");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetitleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagetitle >=", value, "pagetitle");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetitleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagetitle <", value, "pagetitle");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetitleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagetitle <=", value, "pagetitle");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetitleLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagetitle like ", value, "pagetitle");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetitleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagetitle not like ", value, "pagetitle");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetitleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pagetitle in ", value, "pagetitle");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetitleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pagetitle not in ", value, "pagetitle");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetitleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagetitle between ", value1, value2, "pagetitle");
            return (PageCriteria) this;
        }
        public PageCriteria andPagetitleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagetitle not between ", value1, value2, "pagetitle");
            return (PageCriteria) this;
        }
        
        public PageCriteria andPageicon1IsNull() {
            addCriterion("pageicon1 is null");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon1IsNotNull() {
            addCriterion("pageicon1 is not null");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon1EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon1 =", value, "pageicon1");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon1NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon1 <>", value, "pageicon1");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon1GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon1 >", value, "pageicon1");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon1GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon1 >=", value, "pageicon1");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon1LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon1 <", value, "pageicon1");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon1LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon1 <=", value, "pageicon1");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon1Like(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon1 like ", value, "pageicon1");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon1NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon1 not like ", value, "pageicon1");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon1In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pageicon1 in ", value, "pageicon1");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon1NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pageicon1 not in ", value, "pageicon1");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon1Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pageicon1 between ", value1, value2, "pageicon1");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon1NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pageicon1 not between ", value1, value2, "pageicon1");
            return (PageCriteria) this;
        }
        
        public PageCriteria andPageicon2IsNull() {
            addCriterion("pageicon2 is null");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon2IsNotNull() {
            addCriterion("pageicon2 is not null");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon2EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon2 =", value, "pageicon2");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon2NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon2 <>", value, "pageicon2");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon2GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon2 >", value, "pageicon2");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon2GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon2 >=", value, "pageicon2");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon2LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon2 <", value, "pageicon2");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon2LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon2 <=", value, "pageicon2");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon2Like(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon2 like ", value, "pageicon2");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon2NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pageicon2 not like ", value, "pageicon2");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon2In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pageicon2 in ", value, "pageicon2");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon2NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pageicon2 not in ", value, "pageicon2");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon2Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pageicon2 between ", value1, value2, "pageicon2");
            return (PageCriteria) this;
        }
        public PageCriteria andPageicon2NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pageicon2 not between ", value1, value2, "pageicon2");
            return (PageCriteria) this;
        }
        
        public PageCriteria andPagelinkIsNull() {
            addCriterion("pagelink is null");
            return (PageCriteria) this;
        }
        public PageCriteria andPagelinkIsNotNull() {
            addCriterion("pagelink is not null");
            return (PageCriteria) this;
        }
        public PageCriteria andPagelinkEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink =", value, "pagelink");
            return (PageCriteria) this;
        }
        public PageCriteria andPagelinkNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink <>", value, "pagelink");
            return (PageCriteria) this;
        }
        public PageCriteria andPagelinkGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink >", value, "pagelink");
            return (PageCriteria) this;
        }
        public PageCriteria andPagelinkGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink >=", value, "pagelink");
            return (PageCriteria) this;
        }
        public PageCriteria andPagelinkLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink <", value, "pagelink");
            return (PageCriteria) this;
        }
        public PageCriteria andPagelinkLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink <=", value, "pagelink");
            return (PageCriteria) this;
        }
        public PageCriteria andPagelinkLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink like ", value, "pagelink");
            return (PageCriteria) this;
        }
        public PageCriteria andPagelinkNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagelink not like ", value, "pagelink");
            return (PageCriteria) this;
        }
        public PageCriteria andPagelinkIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pagelink in ", value, "pagelink");
            return (PageCriteria) this;
        }
        public PageCriteria andPagelinkNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pagelink not in ", value, "pagelink");
            return (PageCriteria) this;
        }
        public PageCriteria andPagelinkBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagelink between ", value1, value2, "pagelink");
            return (PageCriteria) this;
        }
        public PageCriteria andPagelinkNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagelink not between ", value1, value2, "pagelink");
            return (PageCriteria) this;
        }
        
        public PageCriteria andPageorderIsNull() {
            addCriterion("pageorder is null");
            return (PageCriteria) this;
        }
        public PageCriteria andPageorderIsNotNull() {
            addCriterion("pageorder is not null");
            return (PageCriteria) this;
        }
        public PageCriteria andPageorderEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("pageorder =", value, "pageorder");
            return (PageCriteria) this;
        }
        public PageCriteria andPageorderNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("pageorder <>", value, "pageorder");
            return (PageCriteria) this;
        }
        public PageCriteria andPageorderGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("pageorder >", value, "pageorder");
            return (PageCriteria) this;
        }
        public PageCriteria andPageorderGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("pageorder >=", value, "pageorder");
            return (PageCriteria) this;
        }
        public PageCriteria andPageorderLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("pageorder <", value, "pageorder");
            return (PageCriteria) this;
        }
        public PageCriteria andPageorderLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("pageorder <=", value, "pageorder");
            return (PageCriteria) this;
        }

        
        public PageCriteria andVisibilityIsNull() {
            addCriterion("visibility is null");
            return (PageCriteria) this;
        }
        public PageCriteria andVisibilityIsNotNull() {
            addCriterion("visibility is not null");
            return (PageCriteria) this;
        }
        public PageCriteria andVisibilityEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("visibility =", value, "visibility");
            return (PageCriteria) this;
        }
        public PageCriteria andVisibilityNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("visibility <>", value, "visibility");
            return (PageCriteria) this;
        }
        public PageCriteria andVisibilityGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("visibility >", value, "visibility");
            return (PageCriteria) this;
        }
        public PageCriteria andVisibilityGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("visibility >=", value, "visibility");
            return (PageCriteria) this;
        }
        public PageCriteria andVisibilityLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("visibility <", value, "visibility");
            return (PageCriteria) this;
        }
        public PageCriteria andVisibilityLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("visibility <=", value, "visibility");
            return (PageCriteria) this;
        }
        public PageCriteria andVisibilityLike(java.lang.String value) {
            if (value != null)
              addCriterion("visibility like ", value, "visibility");
            return (PageCriteria) this;
        }
        public PageCriteria andVisibilityNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("visibility not like ", value, "visibility");
            return (PageCriteria) this;
        }
        public PageCriteria andVisibilityIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("visibility in ", value, "visibility");
            return (PageCriteria) this;
        }
        public PageCriteria andVisibilityNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("visibility not in ", value, "visibility");
            return (PageCriteria) this;
        }
        public PageCriteria andVisibilityBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("visibility between ", value1, value2, "visibility");
            return (PageCriteria) this;
        }
        public PageCriteria andVisibilityNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("visibility not between ", value1, value2, "visibility");
            return (PageCriteria) this;
        }
        
        public PageCriteria andPagestyleIsNull() {
            addCriterion("pagestyle is null");
            return (PageCriteria) this;
        }
        public PageCriteria andPagestyleIsNotNull() {
            addCriterion("pagestyle is not null");
            return (PageCriteria) this;
        }
        public PageCriteria andPagestyleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagestyle =", value, "pagestyle");
            return (PageCriteria) this;
        }
        public PageCriteria andPagestyleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagestyle <>", value, "pagestyle");
            return (PageCriteria) this;
        }
        public PageCriteria andPagestyleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagestyle >", value, "pagestyle");
            return (PageCriteria) this;
        }
        public PageCriteria andPagestyleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagestyle >=", value, "pagestyle");
            return (PageCriteria) this;
        }
        public PageCriteria andPagestyleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pagestyle <", value, "pagestyle");
            return (PageCriteria) this;
        }
        public PageCriteria andPagestyleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pagestyle <=", value, "pagestyle");
            return (PageCriteria) this;
        }
        public PageCriteria andPagestyleLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagestyle like ", value, "pagestyle");
            return (PageCriteria) this;
        }
        public PageCriteria andPagestyleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pagestyle not like ", value, "pagestyle");
            return (PageCriteria) this;
        }
        public PageCriteria andPagestyleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pagestyle in ", value, "pagestyle");
            return (PageCriteria) this;
        }
        public PageCriteria andPagestyleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pagestyle not in ", value, "pagestyle");
            return (PageCriteria) this;
        }
        public PageCriteria andPagestyleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagestyle between ", value1, value2, "pagestyle");
            return (PageCriteria) this;
        }
        public PageCriteria andPagestyleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pagestyle not between ", value1, value2, "pagestyle");
            return (PageCriteria) this;
        }
        
        public PageCriteria andForwardviewIsNull() {
            addCriterion("forwardview is null");
            return (PageCriteria) this;
        }
        public PageCriteria andForwardviewIsNotNull() {
            addCriterion("forwardview is not null");
            return (PageCriteria) this;
        }
        public PageCriteria andForwardviewEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("forwardview =", value, "forwardview");
            return (PageCriteria) this;
        }
        public PageCriteria andForwardviewNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("forwardview <>", value, "forwardview");
            return (PageCriteria) this;
        }
        public PageCriteria andForwardviewGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("forwardview >", value, "forwardview");
            return (PageCriteria) this;
        }
        public PageCriteria andForwardviewGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("forwardview >=", value, "forwardview");
            return (PageCriteria) this;
        }
        public PageCriteria andForwardviewLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("forwardview <", value, "forwardview");
            return (PageCriteria) this;
        }
        public PageCriteria andForwardviewLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("forwardview <=", value, "forwardview");
            return (PageCriteria) this;
        }
        public PageCriteria andForwardviewLike(java.lang.String value) {
            if (value != null)
              addCriterion("forwardview like ", value, "forwardview");
            return (PageCriteria) this;
        }
        public PageCriteria andForwardviewNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("forwardview not like ", value, "forwardview");
            return (PageCriteria) this;
        }
        public PageCriteria andForwardviewIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("forwardview in ", value, "forwardview");
            return (PageCriteria) this;
        }
        public PageCriteria andForwardviewNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("forwardview not in ", value, "forwardview");
            return (PageCriteria) this;
        }
        public PageCriteria andForwardviewBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("forwardview between ", value1, value2, "forwardview");
            return (PageCriteria) this;
        }
        public PageCriteria andForwardviewNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("forwardview not between ", value1, value2, "forwardview");
            return (PageCriteria) this;
        }
        
        public PageCriteria andOnuserstatusIsNull() {
            addCriterion("onuserstatus is null");
            return (PageCriteria) this;
        }
        public PageCriteria andOnuserstatusIsNotNull() {
            addCriterion("onuserstatus is not null");
            return (PageCriteria) this;
        }
        public PageCriteria andOnuserstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("onuserstatus =", value, "onuserstatus");
            return (PageCriteria) this;
        }
        public PageCriteria andOnuserstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("onuserstatus <>", value, "onuserstatus");
            return (PageCriteria) this;
        }
        public PageCriteria andOnuserstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("onuserstatus >", value, "onuserstatus");
            return (PageCriteria) this;
        }
        public PageCriteria andOnuserstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("onuserstatus >=", value, "onuserstatus");
            return (PageCriteria) this;
        }
        public PageCriteria andOnuserstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("onuserstatus <", value, "onuserstatus");
            return (PageCriteria) this;
        }
        public PageCriteria andOnuserstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("onuserstatus <=", value, "onuserstatus");
            return (PageCriteria) this;
        }
        public PageCriteria andOnuserstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("onuserstatus like ", value, "onuserstatus");
            return (PageCriteria) this;
        }
        public PageCriteria andOnuserstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("onuserstatus not like ", value, "onuserstatus");
            return (PageCriteria) this;
        }
        public PageCriteria andOnuserstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("onuserstatus in ", value, "onuserstatus");
            return (PageCriteria) this;
        }
        public PageCriteria andOnuserstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("onuserstatus not in ", value, "onuserstatus");
            return (PageCriteria) this;
        }
        public PageCriteria andOnuserstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("onuserstatus between ", value1, value2, "onuserstatus");
            return (PageCriteria) this;
        }
        public PageCriteria andOnuserstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("onuserstatus not between ", value1, value2, "onuserstatus");
            return (PageCriteria) this;
        }
        
        public PageCriteria andPermissionsIsNull() {
            addCriterion("permissions is null");
            return (PageCriteria) this;
        }
        public PageCriteria andPermissionsIsNotNull() {
            addCriterion("permissions is not null");
            return (PageCriteria) this;
        }
        public PageCriteria andPermissionsEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("permissions =", value, "permissions");
            return (PageCriteria) this;
        }
        public PageCriteria andPermissionsNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("permissions <>", value, "permissions");
            return (PageCriteria) this;
        }
        public PageCriteria andPermissionsGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("permissions >", value, "permissions");
            return (PageCriteria) this;
        }
        public PageCriteria andPermissionsGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("permissions >=", value, "permissions");
            return (PageCriteria) this;
        }
        public PageCriteria andPermissionsLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("permissions <", value, "permissions");
            return (PageCriteria) this;
        }
        public PageCriteria andPermissionsLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("permissions <=", value, "permissions");
            return (PageCriteria) this;
        }
        public PageCriteria andPermissionsLike(java.lang.String value) {
            if (value != null)
              addCriterion("permissions like ", value, "permissions");
            return (PageCriteria) this;
        }
        public PageCriteria andPermissionsNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("permissions not like ", value, "permissions");
            return (PageCriteria) this;
        }
        public PageCriteria andPermissionsIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("permissions in ", value, "permissions");
            return (PageCriteria) this;
        }
        public PageCriteria andPermissionsNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("permissions not in ", value, "permissions");
            return (PageCriteria) this;
        }
        public PageCriteria andPermissionsBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("permissions between ", value1, value2, "permissions");
            return (PageCriteria) this;
        }
        public PageCriteria andPermissionsNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("permissions not between ", value1, value2, "permissions");
            return (PageCriteria) this;
        }
        
        public PageCriteria andViewoptionsIsNull() {
            addCriterion("viewoptions is null");
            return (PageCriteria) this;
        }
        public PageCriteria andViewoptionsIsNotNull() {
            addCriterion("viewoptions is not null");
            return (PageCriteria) this;
        }
        public PageCriteria andViewoptionsEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("viewoptions =", value, "viewoptions");
            return (PageCriteria) this;
        }
        public PageCriteria andViewoptionsNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("viewoptions <>", value, "viewoptions");
            return (PageCriteria) this;
        }
        public PageCriteria andViewoptionsGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("viewoptions >", value, "viewoptions");
            return (PageCriteria) this;
        }
        public PageCriteria andViewoptionsGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("viewoptions >=", value, "viewoptions");
            return (PageCriteria) this;
        }
        public PageCriteria andViewoptionsLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("viewoptions <", value, "viewoptions");
            return (PageCriteria) this;
        }
        public PageCriteria andViewoptionsLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("viewoptions <=", value, "viewoptions");
            return (PageCriteria) this;
        }
        public PageCriteria andViewoptionsLike(java.lang.String value) {
            if (value != null)
              addCriterion("viewoptions like ", value, "viewoptions");
            return (PageCriteria) this;
        }
        public PageCriteria andViewoptionsNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("viewoptions not like ", value, "viewoptions");
            return (PageCriteria) this;
        }
        public PageCriteria andViewoptionsIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("viewoptions in ", value, "viewoptions");
            return (PageCriteria) this;
        }
        public PageCriteria andViewoptionsNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("viewoptions not in ", value, "viewoptions");
            return (PageCriteria) this;
        }
        public PageCriteria andViewoptionsBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("viewoptions between ", value1, value2, "viewoptions");
            return (PageCriteria) this;
        }
        public PageCriteria andViewoptionsNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("viewoptions not between ", value1, value2, "viewoptions");
            return (PageCriteria) this;
        }
    }
    
}

