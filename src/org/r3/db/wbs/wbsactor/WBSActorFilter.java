//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.wbs.wbsactor;

import java.util.ArrayList;
import java.util.List;

public class WBSActorFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public WBSActorFilter() 
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

    public WBSActorCriteria or() 
    {
        WBSActorCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public WBSActorCriteria createCriteria() 
    {
        WBSActorCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected WBSActorCriteria createCriteriaInternal() 
    {
        WBSActorCriteria criteria = new WBSActorCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class WBSActorCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public WBSActorCriteria andWbsactoridIsNull() {
            addCriterion("wbsactorid is null");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsactoridIsNotNull() {
            addCriterion("wbsactorid is not null");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsactoridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsactorid =", value, "wbsactorid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsactoridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsactorid <>", value, "wbsactorid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsactoridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("wbsactorid >", value, "wbsactorid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsactoridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsactorid >=", value, "wbsactorid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsactoridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("wbsactorid <", value, "wbsactorid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsactoridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsactorid <=", value, "wbsactorid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsactoridLike(java.lang.String value) {
            if (value != null)
              addCriterion("wbsactorid like ", value, "wbsactorid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsactoridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("wbsactorid not like ", value, "wbsactorid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsactoridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("wbsactorid in ", value, "wbsactorid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsactoridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("wbsactorid not in ", value, "wbsactorid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsactoridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("wbsactorid between ", value1, value2, "wbsactorid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsactoridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("wbsactorid not between ", value1, value2, "wbsactorid");
            return (WBSActorCriteria) this;
        }
        
        public WBSActorCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (WBSActorCriteria) this;
        }
        
        public WBSActorCriteria andActoridIsNull() {
            addCriterion("actorid is null");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActoridIsNotNull() {
            addCriterion("actorid is not null");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActoridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("actorid =", value, "actorid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActoridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("actorid <>", value, "actorid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActoridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("actorid >", value, "actorid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActoridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("actorid >=", value, "actorid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActoridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("actorid <", value, "actorid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActoridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("actorid <=", value, "actorid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActoridLike(java.lang.String value) {
            if (value != null)
              addCriterion("actorid like ", value, "actorid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActoridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("actorid not like ", value, "actorid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActoridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("actorid in ", value, "actorid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActoridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("actorid not in ", value, "actorid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActoridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("actorid between ", value1, value2, "actorid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActoridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("actorid not between ", value1, value2, "actorid");
            return (WBSActorCriteria) this;
        }
        
        public WBSActorCriteria andActorroleIsNull() {
            addCriterion("actorrole is null");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActorroleIsNotNull() {
            addCriterion("actorrole is not null");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActorroleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("actorrole =", value, "actorrole");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActorroleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("actorrole <>", value, "actorrole");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActorroleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("actorrole >", value, "actorrole");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActorroleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("actorrole >=", value, "actorrole");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActorroleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("actorrole <", value, "actorrole");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActorroleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("actorrole <=", value, "actorrole");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActorroleLike(java.lang.String value) {
            if (value != null)
              addCriterion("actorrole like ", value, "actorrole");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActorroleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("actorrole not like ", value, "actorrole");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActorroleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("actorrole in ", value, "actorrole");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActorroleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("actorrole not in ", value, "actorrole");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActorroleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("actorrole between ", value1, value2, "actorrole");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andActorroleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("actorrole not between ", value1, value2, "actorrole");
            return (WBSActorCriteria) this;
        }
        
        public WBSActorCriteria andWbsidIsNull() {
            addCriterion("wbsid is null");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsidIsNotNull() {
            addCriterion("wbsid is not null");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid =", value, "wbsid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid <>", value, "wbsid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid >", value, "wbsid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid >=", value, "wbsid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid <", value, "wbsid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid <=", value, "wbsid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsidLike(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid like ", value, "wbsid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid not like ", value, "wbsid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("wbsid in ", value, "wbsid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("wbsid not in ", value, "wbsid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("wbsid between ", value1, value2, "wbsid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("wbsid not between ", value1, value2, "wbsid");
            return (WBSActorCriteria) this;
        }
        
        public WBSActorCriteria andWbsnodeidIsNull() {
            addCriterion("wbsnodeid is null");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsnodeidIsNotNull() {
            addCriterion("wbsnodeid is not null");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsnodeidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid =", value, "wbsnodeid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsnodeidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid <>", value, "wbsnodeid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsnodeidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid >", value, "wbsnodeid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsnodeidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid >=", value, "wbsnodeid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsnodeidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid <", value, "wbsnodeid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsnodeidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid <=", value, "wbsnodeid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsnodeidLike(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid like ", value, "wbsnodeid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsnodeidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid not like ", value, "wbsnodeid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsnodeidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("wbsnodeid in ", value, "wbsnodeid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsnodeidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("wbsnodeid not in ", value, "wbsnodeid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsnodeidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("wbsnodeid between ", value1, value2, "wbsnodeid");
            return (WBSActorCriteria) this;
        }
        public WBSActorCriteria andWbsnodeidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("wbsnodeid not between ", value1, value2, "wbsnodeid");
            return (WBSActorCriteria) this;
        }
    }
    
}

