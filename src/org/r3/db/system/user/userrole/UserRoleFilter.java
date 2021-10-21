//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.user.userrole;

import java.util.ArrayList;
import java.util.List;

public class UserRoleFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public UserRoleFilter() 
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

    public UserRoleCriteria or() 
    {
        UserRoleCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public UserRoleCriteria createCriteria() 
    {
        UserRoleCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected UserRoleCriteria createCriteriaInternal() 
    {
        UserRoleCriteria criteria = new UserRoleCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class UserRoleCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public UserRoleCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (UserRoleCriteria) this;
        }
        
        public UserRoleCriteria andUseridIsNull() {
            addCriterion("userid is null");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andUseridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid =", value, "userid");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andUseridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <>", value, "userid");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andUseridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid >", value, "userid");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andUseridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid >=", value, "userid");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andUseridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid <", value, "userid");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andUseridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <=", value, "userid");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andUseridLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid like ", value, "userid");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andUseridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid not like ", value, "userid");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andUseridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("userid in ", value, "userid");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andUseridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("userid not in ", value, "userid");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andUseridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid between ", value1, value2, "userid");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andUseridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid not between ", value1, value2, "userid");
            return (UserRoleCriteria) this;
        }
        
        public UserRoleCriteria andRoleidIsNull() {
            addCriterion("roleid is null");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andRoleidIsNotNull() {
            addCriterion("roleid is not null");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andRoleidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("roleid =", value, "roleid");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andRoleidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("roleid <>", value, "roleid");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andRoleidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("roleid >", value, "roleid");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andRoleidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("roleid >=", value, "roleid");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andRoleidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("roleid <", value, "roleid");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andRoleidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("roleid <=", value, "roleid");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andRoleidLike(java.lang.String value) {
            if (value != null)
              addCriterion("roleid like ", value, "roleid");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andRoleidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("roleid not like ", value, "roleid");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andRoleidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("roleid in ", value, "roleid");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andRoleidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("roleid not in ", value, "roleid");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andRoleidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("roleid between ", value1, value2, "roleid");
            return (UserRoleCriteria) this;
        }
        public UserRoleCriteria andRoleidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("roleid not between ", value1, value2, "roleid");
            return (UserRoleCriteria) this;
        }
    }
    
}

