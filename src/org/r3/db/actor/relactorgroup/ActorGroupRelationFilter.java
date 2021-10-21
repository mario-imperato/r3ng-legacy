//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.actor.relactorgroup;

import java.util.ArrayList;
import java.util.List;

public class ActorGroupRelationFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public ActorGroupRelationFilter() 
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

    public ActorGroupRelationCriteria or() 
    {
        ActorGroupRelationCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public ActorGroupRelationCriteria createCriteria() 
    {
        ActorGroupRelationCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected ActorGroupRelationCriteria createCriteriaInternal() 
    {
        ActorGroupRelationCriteria criteria = new ActorGroupRelationCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class ActorGroupRelationCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public ActorGroupRelationCriteria andEventidIsNull() {
            addCriterion("eventid is null");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andEventidIsNotNull() {
            addCriterion("eventid is not null");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andEventidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid =", value, "eventid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andEventidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <>", value, "eventid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andEventidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >", value, "eventid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andEventidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >=", value, "eventid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andEventidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <", value, "eventid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andEventidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <=", value, "eventid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andEventidLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid like ", value, "eventid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andEventidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid not like ", value, "eventid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andEventidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("eventid in ", value, "eventid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andEventidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("eventid not in ", value, "eventid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andEventidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid between ", value1, value2, "eventid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andEventidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid not between ", value1, value2, "eventid");
            return (ActorGroupRelationCriteria) this;
        }
        
        public ActorGroupRelationCriteria andGroupidIsNull() {
            addCriterion("groupid is null");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andGroupidIsNotNull() {
            addCriterion("groupid is not null");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andGroupidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupid =", value, "groupid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andGroupidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupid <>", value, "groupid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andGroupidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("groupid >", value, "groupid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andGroupidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupid >=", value, "groupid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andGroupidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("groupid <", value, "groupid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andGroupidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupid <=", value, "groupid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andGroupidLike(java.lang.String value) {
            if (value != null)
              addCriterion("groupid like ", value, "groupid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andGroupidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("groupid not like ", value, "groupid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andGroupidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("groupid in ", value, "groupid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andGroupidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("groupid not in ", value, "groupid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andGroupidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("groupid between ", value1, value2, "groupid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andGroupidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("groupid not between ", value1, value2, "groupid");
            return (ActorGroupRelationCriteria) this;
        }
        
        public ActorGroupRelationCriteria andActoridIsNull() {
            addCriterion("actorid is null");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andActoridIsNotNull() {
            addCriterion("actorid is not null");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andActoridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("actorid =", value, "actorid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andActoridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("actorid <>", value, "actorid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andActoridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("actorid >", value, "actorid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andActoridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("actorid >=", value, "actorid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andActoridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("actorid <", value, "actorid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andActoridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("actorid <=", value, "actorid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andActoridLike(java.lang.String value) {
            if (value != null)
              addCriterion("actorid like ", value, "actorid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andActoridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("actorid not like ", value, "actorid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andActoridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("actorid in ", value, "actorid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andActoridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("actorid not in ", value, "actorid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andActoridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("actorid between ", value1, value2, "actorid");
            return (ActorGroupRelationCriteria) this;
        }
        public ActorGroupRelationCriteria andActoridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("actorid not between ", value1, value2, "actorid");
            return (ActorGroupRelationCriteria) this;
        }
    }
    
}

