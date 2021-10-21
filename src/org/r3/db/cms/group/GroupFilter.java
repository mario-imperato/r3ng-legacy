//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.group;

import java.util.ArrayList;
import java.util.List;

public class GroupFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public GroupFilter() 
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

    public GroupCriteria or() 
    {
        GroupCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public GroupCriteria createCriteria() 
    {
        GroupCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected GroupCriteria createCriteriaInternal() 
    {
        GroupCriteria criteria = new GroupCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class GroupCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public GroupCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (GroupCriteria) this;
        }
        public GroupCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (GroupCriteria) this;
        }
        public GroupCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (GroupCriteria) this;
        }
        public GroupCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (GroupCriteria) this;
        }
        public GroupCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (GroupCriteria) this;
        }
        public GroupCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (GroupCriteria) this;
        }
        public GroupCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (GroupCriteria) this;
        }
        public GroupCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (GroupCriteria) this;
        }
        public GroupCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (GroupCriteria) this;
        }
        public GroupCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (GroupCriteria) this;
        }
        public GroupCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (GroupCriteria) this;
        }
        public GroupCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (GroupCriteria) this;
        }
        public GroupCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (GroupCriteria) this;
        }
        public GroupCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (GroupCriteria) this;
        }
        
        public GroupCriteria andGroupidIsNull() {
            addCriterion("groupid is null");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupidIsNotNull() {
            addCriterion("groupid is not null");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupid =", value, "groupid");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupid <>", value, "groupid");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("groupid >", value, "groupid");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupid >=", value, "groupid");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("groupid <", value, "groupid");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupid <=", value, "groupid");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupidLike(java.lang.String value) {
            if (value != null)
              addCriterion("groupid like ", value, "groupid");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("groupid not like ", value, "groupid");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("groupid in ", value, "groupid");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("groupid not in ", value, "groupid");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("groupid between ", value1, value2, "groupid");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("groupid not between ", value1, value2, "groupid");
            return (GroupCriteria) this;
        }
        
        public GroupCriteria andGroupnameIsNull() {
            addCriterion("groupname is null");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupnameIsNotNull() {
            addCriterion("groupname is not null");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupname =", value, "groupname");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupname <>", value, "groupname");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("groupname >", value, "groupname");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupname >=", value, "groupname");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("groupname <", value, "groupname");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupname <=", value, "groupname");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("groupname like ", value, "groupname");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("groupname not like ", value, "groupname");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("groupname in ", value, "groupname");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("groupname not in ", value, "groupname");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("groupname between ", value1, value2, "groupname");
            return (GroupCriteria) this;
        }
        public GroupCriteria andGroupnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("groupname not between ", value1, value2, "groupname");
            return (GroupCriteria) this;
        }
        
        public GroupCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (GroupCriteria) this;
        }
        public GroupCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (GroupCriteria) this;
        }
        public GroupCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (GroupCriteria) this;
        }
        public GroupCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (GroupCriteria) this;
        }
        public GroupCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (GroupCriteria) this;
        }
        public GroupCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (GroupCriteria) this;
        }
        public GroupCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (GroupCriteria) this;
        }
        public GroupCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (GroupCriteria) this;
        }
        public GroupCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (GroupCriteria) this;
        }
        public GroupCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (GroupCriteria) this;
        }
        public GroupCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (GroupCriteria) this;
        }
        public GroupCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (GroupCriteria) this;
        }
        public GroupCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (GroupCriteria) this;
        }
        public GroupCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (GroupCriteria) this;
        }
        
        public GroupCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (GroupCriteria) this;
        }
        public GroupCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (GroupCriteria) this;
        }
        public GroupCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (GroupCriteria) this;
        }
        public GroupCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (GroupCriteria) this;
        }
        public GroupCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (GroupCriteria) this;
        }
        public GroupCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (GroupCriteria) this;
        }
        public GroupCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (GroupCriteria) this;
        }
        public GroupCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (GroupCriteria) this;
        }

    }
    
}

