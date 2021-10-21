//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.racegroupview;

import java.util.ArrayList;
import java.util.List;

public class SailRaceGroupViewFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public SailRaceGroupViewFilter() 
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

    public SailRaceGroupViewCriteria or() 
    {
        SailRaceGroupViewCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public SailRaceGroupViewCriteria createCriteria() 
    {
        SailRaceGroupViewCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected SailRaceGroupViewCriteria createCriteriaInternal() 
    {
        SailRaceGroupViewCriteria criteria = new SailRaceGroupViewCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class SailRaceGroupViewCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public SailRaceGroupViewCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (SailRaceGroupViewCriteria) this;
        }
        
        public SailRaceGroupViewCriteria andParentitemidIsNull() {
            addCriterion("parentitemid is null");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemidIsNotNull() {
            addCriterion("parentitemid is not null");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("parentitemid =", value, "parentitemid");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("parentitemid <>", value, "parentitemid");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("parentitemid >", value, "parentitemid");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("parentitemid >=", value, "parentitemid");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("parentitemid <", value, "parentitemid");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("parentitemid <=", value, "parentitemid");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemidLike(java.lang.String value) {
            if (value != null)
              addCriterion("parentitemid like ", value, "parentitemid");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("parentitemid not like ", value, "parentitemid");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("parentitemid in ", value, "parentitemid");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("parentitemid not in ", value, "parentitemid");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("parentitemid between ", value1, value2, "parentitemid");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("parentitemid not between ", value1, value2, "parentitemid");
            return (SailRaceGroupViewCriteria) this;
        }
        
        public SailRaceGroupViewCriteria andParentitemdescrIsNull() {
            addCriterion("parentitemdescr is null");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemdescrIsNotNull() {
            addCriterion("parentitemdescr is not null");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemdescrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("parentitemdescr =", value, "parentitemdescr");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemdescrNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("parentitemdescr <>", value, "parentitemdescr");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemdescrGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("parentitemdescr >", value, "parentitemdescr");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemdescrGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("parentitemdescr >=", value, "parentitemdescr");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemdescrLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("parentitemdescr <", value, "parentitemdescr");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemdescrLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("parentitemdescr <=", value, "parentitemdescr");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemdescrLike(java.lang.String value) {
            if (value != null)
              addCriterion("parentitemdescr like ", value, "parentitemdescr");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemdescrNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("parentitemdescr not like ", value, "parentitemdescr");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemdescrIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("parentitemdescr in ", value, "parentitemdescr");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemdescrNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("parentitemdescr not in ", value, "parentitemdescr");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemdescrBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("parentitemdescr between ", value1, value2, "parentitemdescr");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemdescrNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("parentitemdescr not between ", value1, value2, "parentitemdescr");
            return (SailRaceGroupViewCriteria) this;
        }
        
        public SailRaceGroupViewCriteria andParentitemorderIsNull() {
            addCriterion("parentitemorder is null");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemorderIsNotNull() {
            addCriterion("parentitemorder is not null");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemorderEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("parentitemorder =", value, "parentitemorder");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemorderNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("parentitemorder <>", value, "parentitemorder");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemorderGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("parentitemorder >", value, "parentitemorder");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemorderGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("parentitemorder >=", value, "parentitemorder");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemorderLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("parentitemorder <", value, "parentitemorder");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andParentitemorderLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("parentitemorder <=", value, "parentitemorder");
            return (SailRaceGroupViewCriteria) this;
        }

        
        public SailRaceGroupViewCriteria andChilditemidIsNull() {
            addCriterion("childitemid is null");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemidIsNotNull() {
            addCriterion("childitemid is not null");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("childitemid =", value, "childitemid");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("childitemid <>", value, "childitemid");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("childitemid >", value, "childitemid");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("childitemid >=", value, "childitemid");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("childitemid <", value, "childitemid");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("childitemid <=", value, "childitemid");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemidLike(java.lang.String value) {
            if (value != null)
              addCriterion("childitemid like ", value, "childitemid");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("childitemid not like ", value, "childitemid");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("childitemid in ", value, "childitemid");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("childitemid not in ", value, "childitemid");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("childitemid between ", value1, value2, "childitemid");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("childitemid not between ", value1, value2, "childitemid");
            return (SailRaceGroupViewCriteria) this;
        }
        
        public SailRaceGroupViewCriteria andChilditemdescrIsNull() {
            addCriterion("childitemdescr is null");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemdescrIsNotNull() {
            addCriterion("childitemdescr is not null");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemdescrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("childitemdescr =", value, "childitemdescr");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemdescrNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("childitemdescr <>", value, "childitemdescr");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemdescrGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("childitemdescr >", value, "childitemdescr");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemdescrGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("childitemdescr >=", value, "childitemdescr");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemdescrLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("childitemdescr <", value, "childitemdescr");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemdescrLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("childitemdescr <=", value, "childitemdescr");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemdescrLike(java.lang.String value) {
            if (value != null)
              addCriterion("childitemdescr like ", value, "childitemdescr");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemdescrNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("childitemdescr not like ", value, "childitemdescr");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemdescrIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("childitemdescr in ", value, "childitemdescr");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemdescrNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("childitemdescr not in ", value, "childitemdescr");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemdescrBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("childitemdescr between ", value1, value2, "childitemdescr");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemdescrNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("childitemdescr not between ", value1, value2, "childitemdescr");
            return (SailRaceGroupViewCriteria) this;
        }
        
        public SailRaceGroupViewCriteria andChilditemorderIsNull() {
            addCriterion("childitemorder is null");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemorderIsNotNull() {
            addCriterion("childitemorder is not null");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemorderEqualTo(java.lang.Long value) {
            if (value != null)
              addCriterion("childitemorder =", value, "childitemorder");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemorderNotEqualTo(java.lang.Long value) {
            if (value != null)
              addCriterion("childitemorder <>", value, "childitemorder");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemorderGreaterThan(java.lang.Long value) {
            if (value != null)
              addCriterion("childitemorder >", value, "childitemorder");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemorderGreaterThanOrEqualTo(java.lang.Long value) {
            if (value != null)
              addCriterion("childitemorder >=", value, "childitemorder");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemorderLessThan(java.lang.Long value) {
            if (value != null)
              addCriterion("childitemorder <", value, "childitemorder");
            return (SailRaceGroupViewCriteria) this;
        }
        public SailRaceGroupViewCriteria andChilditemorderLessThanOrEqualTo(java.lang.Long value) {
            if (value != null)
              addCriterion("childitemorder <=", value, "childitemorder");
            return (SailRaceGroupViewCriteria) this;
        }

    }
    
}

