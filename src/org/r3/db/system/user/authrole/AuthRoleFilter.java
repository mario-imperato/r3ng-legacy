//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.user.authrole;

import java.util.ArrayList;
import java.util.List;

public class AuthRoleFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public AuthRoleFilter() 
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

    public AuthRoleCriteria or() 
    {
        AuthRoleCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public AuthRoleCriteria createCriteria() 
    {
        AuthRoleCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected AuthRoleCriteria createCriteriaInternal() 
    {
        AuthRoleCriteria criteria = new AuthRoleCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class AuthRoleCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public AuthRoleCriteria andRoleidIsNull() {
            addCriterion("roleid is null");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoleidIsNotNull() {
            addCriterion("roleid is not null");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoleidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("roleid =", value, "roleid");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoleidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("roleid <>", value, "roleid");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoleidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("roleid >", value, "roleid");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoleidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("roleid >=", value, "roleid");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoleidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("roleid <", value, "roleid");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoleidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("roleid <=", value, "roleid");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoleidLike(java.lang.String value) {
            if (value != null)
              addCriterion("roleid like ", value, "roleid");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoleidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("roleid not like ", value, "roleid");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoleidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("roleid in ", value, "roleid");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoleidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("roleid not in ", value, "roleid");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoleidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("roleid between ", value1, value2, "roleid");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoleidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("roleid not between ", value1, value2, "roleid");
            return (AuthRoleCriteria) this;
        }
        
        public AuthRoleCriteria andRoledescrIsNull() {
            addCriterion("roledescr is null");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoledescrIsNotNull() {
            addCriterion("roledescr is not null");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoledescrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("roledescr =", value, "roledescr");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoledescrNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("roledescr <>", value, "roledescr");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoledescrGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("roledescr >", value, "roledescr");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoledescrGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("roledescr >=", value, "roledescr");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoledescrLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("roledescr <", value, "roledescr");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoledescrLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("roledescr <=", value, "roledescr");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoledescrLike(java.lang.String value) {
            if (value != null)
              addCriterion("roledescr like ", value, "roledescr");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoledescrNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("roledescr not like ", value, "roledescr");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoledescrIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("roledescr in ", value, "roledescr");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoledescrNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("roledescr not in ", value, "roledescr");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoledescrBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("roledescr between ", value1, value2, "roledescr");
            return (AuthRoleCriteria) this;
        }
        public AuthRoleCriteria andRoledescrNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("roledescr not between ", value1, value2, "roledescr");
            return (AuthRoleCriteria) this;
        }
    }
    
}

