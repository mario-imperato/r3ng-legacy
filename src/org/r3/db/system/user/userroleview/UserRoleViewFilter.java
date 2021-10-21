//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.user.userroleview;

import java.util.ArrayList;
import java.util.List;

public class UserRoleViewFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public UserRoleViewFilter() 
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

    public UserRoleViewCriteria or() 
    {
        UserRoleViewCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public UserRoleViewCriteria createCriteria() 
    {
        UserRoleViewCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected UserRoleViewCriteria createCriteriaInternal() 
    {
        UserRoleViewCriteria criteria = new UserRoleViewCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class UserRoleViewCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public UserRoleViewCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (UserRoleViewCriteria) this;
        }
        
        public UserRoleViewCriteria andUseridIsNull() {
            addCriterion("userid is null");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andUseridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid =", value, "userid");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andUseridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <>", value, "userid");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andUseridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid >", value, "userid");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andUseridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid >=", value, "userid");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andUseridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid <", value, "userid");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andUseridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <=", value, "userid");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andUseridLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid like ", value, "userid");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andUseridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid not like ", value, "userid");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andUseridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("userid in ", value, "userid");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andUseridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("userid not in ", value, "userid");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andUseridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid between ", value1, value2, "userid");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andUseridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid not between ", value1, value2, "userid");
            return (UserRoleViewCriteria) this;
        }
        
        public UserRoleViewCriteria andRoleidIsNull() {
            addCriterion("roleid is null");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoleidIsNotNull() {
            addCriterion("roleid is not null");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoleidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("roleid =", value, "roleid");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoleidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("roleid <>", value, "roleid");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoleidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("roleid >", value, "roleid");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoleidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("roleid >=", value, "roleid");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoleidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("roleid <", value, "roleid");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoleidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("roleid <=", value, "roleid");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoleidLike(java.lang.String value) {
            if (value != null)
              addCriterion("roleid like ", value, "roleid");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoleidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("roleid not like ", value, "roleid");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoleidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("roleid in ", value, "roleid");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoleidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("roleid not in ", value, "roleid");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoleidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("roleid between ", value1, value2, "roleid");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoleidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("roleid not between ", value1, value2, "roleid");
            return (UserRoleViewCriteria) this;
        }
        
        public UserRoleViewCriteria andRoledescrIsNull() {
            addCriterion("roledescr is null");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoledescrIsNotNull() {
            addCriterion("roledescr is not null");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoledescrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("roledescr =", value, "roledescr");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoledescrNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("roledescr <>", value, "roledescr");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoledescrGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("roledescr >", value, "roledescr");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoledescrGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("roledescr >=", value, "roledescr");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoledescrLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("roledescr <", value, "roledescr");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoledescrLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("roledescr <=", value, "roledescr");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoledescrLike(java.lang.String value) {
            if (value != null)
              addCriterion("roledescr like ", value, "roledescr");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoledescrNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("roledescr not like ", value, "roledescr");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoledescrIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("roledescr in ", value, "roledescr");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoledescrNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("roledescr not in ", value, "roledescr");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoledescrBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("roledescr between ", value1, value2, "roledescr");
            return (UserRoleViewCriteria) this;
        }
        public UserRoleViewCriteria andRoledescrNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("roledescr not between ", value1, value2, "roledescr");
            return (UserRoleViewCriteria) this;
        }
    }
    
}

