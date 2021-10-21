//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.actor.group;

import java.util.ArrayList;
import java.util.List;

public class ActorGroupFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public ActorGroupFilter() 
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

    public ActorGroupCriteria or() 
    {
        ActorGroupCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public ActorGroupCriteria createCriteria() 
    {
        ActorGroupCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected ActorGroupCriteria createCriteriaInternal() 
    {
        ActorGroupCriteria criteria = new ActorGroupCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class ActorGroupCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public ActorGroupCriteria andEventidIsNull() {
            addCriterion("eventid is null");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andEventidIsNotNull() {
            addCriterion("eventid is not null");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andEventidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid =", value, "eventid");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andEventidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <>", value, "eventid");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andEventidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >", value, "eventid");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andEventidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >=", value, "eventid");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andEventidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <", value, "eventid");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andEventidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <=", value, "eventid");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andEventidLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid like ", value, "eventid");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andEventidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid not like ", value, "eventid");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andEventidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("eventid in ", value, "eventid");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andEventidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("eventid not in ", value, "eventid");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andEventidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid between ", value1, value2, "eventid");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andEventidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid not between ", value1, value2, "eventid");
            return (ActorGroupCriteria) this;
        }
        
        public ActorGroupCriteria andGroupidIsNull() {
            addCriterion("groupid is null");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupidIsNotNull() {
            addCriterion("groupid is not null");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupid =", value, "groupid");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupid <>", value, "groupid");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("groupid >", value, "groupid");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupid >=", value, "groupid");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("groupid <", value, "groupid");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupid <=", value, "groupid");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupidLike(java.lang.String value) {
            if (value != null)
              addCriterion("groupid like ", value, "groupid");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("groupid not like ", value, "groupid");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("groupid in ", value, "groupid");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("groupid not in ", value, "groupid");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("groupid between ", value1, value2, "groupid");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("groupid not between ", value1, value2, "groupid");
            return (ActorGroupCriteria) this;
        }
        
        public ActorGroupCriteria andGrouptitleIsNull() {
            addCriterion("grouptitle is null");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptitleIsNotNull() {
            addCriterion("grouptitle is not null");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptitleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("grouptitle =", value, "grouptitle");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptitleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("grouptitle <>", value, "grouptitle");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptitleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("grouptitle >", value, "grouptitle");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptitleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("grouptitle >=", value, "grouptitle");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptitleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("grouptitle <", value, "grouptitle");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptitleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("grouptitle <=", value, "grouptitle");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptitleLike(java.lang.String value) {
            if (value != null)
              addCriterion("grouptitle like ", value, "grouptitle");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptitleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("grouptitle not like ", value, "grouptitle");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptitleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("grouptitle in ", value, "grouptitle");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptitleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("grouptitle not in ", value, "grouptitle");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptitleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("grouptitle between ", value1, value2, "grouptitle");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptitleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("grouptitle not between ", value1, value2, "grouptitle");
            return (ActorGroupCriteria) this;
        }
        
        public ActorGroupCriteria andGroupnatureIsNull() {
            addCriterion("groupnature is null");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupnatureIsNotNull() {
            addCriterion("groupnature is not null");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupnatureEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupnature =", value, "groupnature");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupnatureNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupnature <>", value, "groupnature");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupnatureGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("groupnature >", value, "groupnature");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupnatureGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupnature >=", value, "groupnature");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupnatureLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("groupnature <", value, "groupnature");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupnatureLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupnature <=", value, "groupnature");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupnatureLike(java.lang.String value) {
            if (value != null)
              addCriterion("groupnature like ", value, "groupnature");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupnatureNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("groupnature not like ", value, "groupnature");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupnatureIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("groupnature in ", value, "groupnature");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupnatureNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("groupnature not in ", value, "groupnature");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupnatureBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("groupnature between ", value1, value2, "groupnature");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupnatureNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("groupnature not between ", value1, value2, "groupnature");
            return (ActorGroupCriteria) this;
        }
        
        public ActorGroupCriteria andGrouptypeIsNull() {
            addCriterion("grouptype is null");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptypeIsNotNull() {
            addCriterion("grouptype is not null");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("grouptype =", value, "grouptype");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("grouptype <>", value, "grouptype");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("grouptype >", value, "grouptype");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("grouptype >=", value, "grouptype");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("grouptype <", value, "grouptype");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("grouptype <=", value, "grouptype");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("grouptype like ", value, "grouptype");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("grouptype not like ", value, "grouptype");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("grouptype in ", value, "grouptype");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("grouptype not in ", value, "grouptype");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("grouptype between ", value1, value2, "grouptype");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouptypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("grouptype not between ", value1, value2, "grouptype");
            return (ActorGroupCriteria) this;
        }
        
        public ActorGroupCriteria andGroupprofileIsNull() {
            addCriterion("groupprofile is null");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupprofileIsNotNull() {
            addCriterion("groupprofile is not null");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupprofileEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupprofile =", value, "groupprofile");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupprofileNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupprofile <>", value, "groupprofile");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupprofileGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("groupprofile >", value, "groupprofile");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupprofileGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupprofile >=", value, "groupprofile");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupprofileLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("groupprofile <", value, "groupprofile");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupprofileLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupprofile <=", value, "groupprofile");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupprofileLike(java.lang.String value) {
            if (value != null)
              addCriterion("groupprofile like ", value, "groupprofile");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupprofileNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("groupprofile not like ", value, "groupprofile");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupprofileIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("groupprofile in ", value, "groupprofile");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupprofileNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("groupprofile not in ", value, "groupprofile");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupprofileBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("groupprofile between ", value1, value2, "groupprofile");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGroupprofileNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("groupprofile not between ", value1, value2, "groupprofile");
            return (ActorGroupCriteria) this;
        }
        
        public ActorGroupCriteria andBusinesskeyIsNull() {
            addCriterion("businesskey is null");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andBusinesskeyIsNotNull() {
            addCriterion("businesskey is not null");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andBusinesskeyEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("businesskey =", value, "businesskey");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andBusinesskeyNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("businesskey <>", value, "businesskey");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andBusinesskeyGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("businesskey >", value, "businesskey");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andBusinesskeyGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("businesskey >=", value, "businesskey");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andBusinesskeyLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("businesskey <", value, "businesskey");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andBusinesskeyLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("businesskey <=", value, "businesskey");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andBusinesskeyLike(java.lang.String value) {
            if (value != null)
              addCriterion("businesskey like ", value, "businesskey");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andBusinesskeyNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("businesskey not like ", value, "businesskey");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andBusinesskeyIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("businesskey in ", value, "businesskey");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andBusinesskeyNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("businesskey not in ", value, "businesskey");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andBusinesskeyBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("businesskey between ", value1, value2, "businesskey");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andBusinesskeyNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("businesskey not between ", value1, value2, "businesskey");
            return (ActorGroupCriteria) this;
        }
        
        public ActorGroupCriteria andGrouporderIsNull() {
            addCriterion("grouporder is null");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouporderIsNotNull() {
            addCriterion("grouporder is not null");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouporderEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("grouporder =", value, "grouporder");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouporderNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("grouporder <>", value, "grouporder");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouporderGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("grouporder >", value, "grouporder");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouporderGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("grouporder >=", value, "grouporder");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouporderLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("grouporder <", value, "grouporder");
            return (ActorGroupCriteria) this;
        }
        public ActorGroupCriteria andGrouporderLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("grouporder <=", value, "grouporder");
            return (ActorGroupCriteria) this;
        }

    }
    
}

