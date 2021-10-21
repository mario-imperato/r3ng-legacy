//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.actor.actor;

import java.util.ArrayList;
import java.util.List;

public class ActorFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public ActorFilter() 
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

    public ActorCriteria or() 
    {
        ActorCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public ActorCriteria createCriteria() 
    {
        ActorCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected ActorCriteria createCriteriaInternal() 
    {
        ActorCriteria criteria = new ActorCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class ActorCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public ActorCriteria andEventidIsNull() {
            addCriterion("eventid is null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEventidIsNotNull() {
            addCriterion("eventid is not null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEventidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid =", value, "eventid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEventidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <>", value, "eventid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEventidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >", value, "eventid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEventidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >=", value, "eventid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEventidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <", value, "eventid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEventidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <=", value, "eventid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEventidLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid like ", value, "eventid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEventidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid not like ", value, "eventid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEventidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("eventid in ", value, "eventid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEventidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("eventid not in ", value, "eventid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEventidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid between ", value1, value2, "eventid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEventidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid not between ", value1, value2, "eventid");
            return (ActorCriteria) this;
        }
        
        public ActorCriteria andActoridIsNull() {
            addCriterion("actorid is null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andActoridIsNotNull() {
            addCriterion("actorid is not null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andActoridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("actorid =", value, "actorid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andActoridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("actorid <>", value, "actorid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andActoridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("actorid >", value, "actorid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andActoridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("actorid >=", value, "actorid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andActoridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("actorid <", value, "actorid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andActoridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("actorid <=", value, "actorid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andActoridLike(java.lang.String value) {
            if (value != null)
              addCriterion("actorid like ", value, "actorid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andActoridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("actorid not like ", value, "actorid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andActoridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("actorid in ", value, "actorid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andActoridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("actorid not in ", value, "actorid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andActoridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("actorid between ", value1, value2, "actorid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andActoridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("actorid not between ", value1, value2, "actorid");
            return (ActorCriteria) this;
        }
        
        public ActorCriteria andUseridIsNull() {
            addCriterion("userid is null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andUseridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid =", value, "userid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andUseridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <>", value, "userid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andUseridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid >", value, "userid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andUseridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid >=", value, "userid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andUseridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid <", value, "userid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andUseridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <=", value, "userid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andUseridLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid like ", value, "userid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andUseridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid not like ", value, "userid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andUseridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("userid in ", value, "userid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andUseridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("userid not in ", value, "userid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andUseridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid between ", value1, value2, "userid");
            return (ActorCriteria) this;
        }
        public ActorCriteria andUseridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid not between ", value1, value2, "userid");
            return (ActorCriteria) this;
        }
        
        public ActorCriteria andFirstnameIsNull() {
            addCriterion("firstname is null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andFirstnameIsNotNull() {
            addCriterion("firstname is not null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andFirstnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("firstname =", value, "firstname");
            return (ActorCriteria) this;
        }
        public ActorCriteria andFirstnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("firstname <>", value, "firstname");
            return (ActorCriteria) this;
        }
        public ActorCriteria andFirstnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("firstname >", value, "firstname");
            return (ActorCriteria) this;
        }
        public ActorCriteria andFirstnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("firstname >=", value, "firstname");
            return (ActorCriteria) this;
        }
        public ActorCriteria andFirstnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("firstname <", value, "firstname");
            return (ActorCriteria) this;
        }
        public ActorCriteria andFirstnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("firstname <=", value, "firstname");
            return (ActorCriteria) this;
        }
        public ActorCriteria andFirstnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("firstname like ", value, "firstname");
            return (ActorCriteria) this;
        }
        public ActorCriteria andFirstnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("firstname not like ", value, "firstname");
            return (ActorCriteria) this;
        }
        public ActorCriteria andFirstnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("firstname in ", value, "firstname");
            return (ActorCriteria) this;
        }
        public ActorCriteria andFirstnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("firstname not in ", value, "firstname");
            return (ActorCriteria) this;
        }
        public ActorCriteria andFirstnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("firstname between ", value1, value2, "firstname");
            return (ActorCriteria) this;
        }
        public ActorCriteria andFirstnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("firstname not between ", value1, value2, "firstname");
            return (ActorCriteria) this;
        }
        
        public ActorCriteria andLastnameIsNull() {
            addCriterion("lastname is null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andLastnameIsNotNull() {
            addCriterion("lastname is not null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andLastnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lastname =", value, "lastname");
            return (ActorCriteria) this;
        }
        public ActorCriteria andLastnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lastname <>", value, "lastname");
            return (ActorCriteria) this;
        }
        public ActorCriteria andLastnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("lastname >", value, "lastname");
            return (ActorCriteria) this;
        }
        public ActorCriteria andLastnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lastname >=", value, "lastname");
            return (ActorCriteria) this;
        }
        public ActorCriteria andLastnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("lastname <", value, "lastname");
            return (ActorCriteria) this;
        }
        public ActorCriteria andLastnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lastname <=", value, "lastname");
            return (ActorCriteria) this;
        }
        public ActorCriteria andLastnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("lastname like ", value, "lastname");
            return (ActorCriteria) this;
        }
        public ActorCriteria andLastnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("lastname not like ", value, "lastname");
            return (ActorCriteria) this;
        }
        public ActorCriteria andLastnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("lastname in ", value, "lastname");
            return (ActorCriteria) this;
        }
        public ActorCriteria andLastnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("lastname not in ", value, "lastname");
            return (ActorCriteria) this;
        }
        public ActorCriteria andLastnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("lastname between ", value1, value2, "lastname");
            return (ActorCriteria) this;
        }
        public ActorCriteria andLastnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("lastname not between ", value1, value2, "lastname");
            return (ActorCriteria) this;
        }
        
        public ActorCriteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andPhoneEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phone =", value, "phone");
            return (ActorCriteria) this;
        }
        public ActorCriteria andPhoneNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phone <>", value, "phone");
            return (ActorCriteria) this;
        }
        public ActorCriteria andPhoneGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("phone >", value, "phone");
            return (ActorCriteria) this;
        }
        public ActorCriteria andPhoneGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phone >=", value, "phone");
            return (ActorCriteria) this;
        }
        public ActorCriteria andPhoneLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("phone <", value, "phone");
            return (ActorCriteria) this;
        }
        public ActorCriteria andPhoneLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phone <=", value, "phone");
            return (ActorCriteria) this;
        }
        public ActorCriteria andPhoneLike(java.lang.String value) {
            if (value != null)
              addCriterion("phone like ", value, "phone");
            return (ActorCriteria) this;
        }
        public ActorCriteria andPhoneNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("phone not like ", value, "phone");
            return (ActorCriteria) this;
        }
        public ActorCriteria andPhoneIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("phone in ", value, "phone");
            return (ActorCriteria) this;
        }
        public ActorCriteria andPhoneNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("phone not in ", value, "phone");
            return (ActorCriteria) this;
        }
        public ActorCriteria andPhoneBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("phone between ", value1, value2, "phone");
            return (ActorCriteria) this;
        }
        public ActorCriteria andPhoneNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("phone not between ", value1, value2, "phone");
            return (ActorCriteria) this;
        }
        
        public ActorCriteria andCellphoneIsNull() {
            addCriterion("cellphone is null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andCellphoneIsNotNull() {
            addCriterion("cellphone is not null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andCellphoneEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cellphone =", value, "cellphone");
            return (ActorCriteria) this;
        }
        public ActorCriteria andCellphoneNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cellphone <>", value, "cellphone");
            return (ActorCriteria) this;
        }
        public ActorCriteria andCellphoneGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("cellphone >", value, "cellphone");
            return (ActorCriteria) this;
        }
        public ActorCriteria andCellphoneGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cellphone >=", value, "cellphone");
            return (ActorCriteria) this;
        }
        public ActorCriteria andCellphoneLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("cellphone <", value, "cellphone");
            return (ActorCriteria) this;
        }
        public ActorCriteria andCellphoneLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cellphone <=", value, "cellphone");
            return (ActorCriteria) this;
        }
        public ActorCriteria andCellphoneLike(java.lang.String value) {
            if (value != null)
              addCriterion("cellphone like ", value, "cellphone");
            return (ActorCriteria) this;
        }
        public ActorCriteria andCellphoneNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("cellphone not like ", value, "cellphone");
            return (ActorCriteria) this;
        }
        public ActorCriteria andCellphoneIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("cellphone in ", value, "cellphone");
            return (ActorCriteria) this;
        }
        public ActorCriteria andCellphoneNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("cellphone not in ", value, "cellphone");
            return (ActorCriteria) this;
        }
        public ActorCriteria andCellphoneBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cellphone between ", value1, value2, "cellphone");
            return (ActorCriteria) this;
        }
        public ActorCriteria andCellphoneNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cellphone not between ", value1, value2, "cellphone");
            return (ActorCriteria) this;
        }
        
        public ActorCriteria andEmailIsNull() {
            addCriterion("email is null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEmailEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("email =", value, "email");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEmailNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("email <>", value, "email");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEmailGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("email >", value, "email");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEmailGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("email >=", value, "email");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEmailLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("email <", value, "email");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEmailLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("email <=", value, "email");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEmailLike(java.lang.String value) {
            if (value != null)
              addCriterion("email like ", value, "email");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEmailNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("email not like ", value, "email");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEmailIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("email in ", value, "email");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEmailNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("email not in ", value, "email");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEmailBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("email between ", value1, value2, "email");
            return (ActorCriteria) this;
        }
        public ActorCriteria andEmailNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("email not between ", value1, value2, "email");
            return (ActorCriteria) this;
        }
        
        public ActorCriteria andAddressIsNull() {
            addCriterion("address is null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andAddressEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("address =", value, "address");
            return (ActorCriteria) this;
        }
        public ActorCriteria andAddressNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("address <>", value, "address");
            return (ActorCriteria) this;
        }
        public ActorCriteria andAddressGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("address >", value, "address");
            return (ActorCriteria) this;
        }
        public ActorCriteria andAddressGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("address >=", value, "address");
            return (ActorCriteria) this;
        }
        public ActorCriteria andAddressLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("address <", value, "address");
            return (ActorCriteria) this;
        }
        public ActorCriteria andAddressLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("address <=", value, "address");
            return (ActorCriteria) this;
        }
        public ActorCriteria andAddressLike(java.lang.String value) {
            if (value != null)
              addCriterion("address like ", value, "address");
            return (ActorCriteria) this;
        }
        public ActorCriteria andAddressNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("address not like ", value, "address");
            return (ActorCriteria) this;
        }
        public ActorCriteria andAddressIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("address in ", value, "address");
            return (ActorCriteria) this;
        }
        public ActorCriteria andAddressNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("address not in ", value, "address");
            return (ActorCriteria) this;
        }
        public ActorCriteria andAddressBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("address between ", value1, value2, "address");
            return (ActorCriteria) this;
        }
        public ActorCriteria andAddressNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("address not between ", value1, value2, "address");
            return (ActorCriteria) this;
        }
        
        public ActorCriteria andTownIsNull() {
            addCriterion("town is null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andTownIsNotNull() {
            addCriterion("town is not null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andTownEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("town =", value, "town");
            return (ActorCriteria) this;
        }
        public ActorCriteria andTownNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("town <>", value, "town");
            return (ActorCriteria) this;
        }
        public ActorCriteria andTownGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("town >", value, "town");
            return (ActorCriteria) this;
        }
        public ActorCriteria andTownGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("town >=", value, "town");
            return (ActorCriteria) this;
        }
        public ActorCriteria andTownLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("town <", value, "town");
            return (ActorCriteria) this;
        }
        public ActorCriteria andTownLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("town <=", value, "town");
            return (ActorCriteria) this;
        }
        public ActorCriteria andTownLike(java.lang.String value) {
            if (value != null)
              addCriterion("town like ", value, "town");
            return (ActorCriteria) this;
        }
        public ActorCriteria andTownNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("town not like ", value, "town");
            return (ActorCriteria) this;
        }
        public ActorCriteria andTownIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("town in ", value, "town");
            return (ActorCriteria) this;
        }
        public ActorCriteria andTownNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("town not in ", value, "town");
            return (ActorCriteria) this;
        }
        public ActorCriteria andTownBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("town between ", value1, value2, "town");
            return (ActorCriteria) this;
        }
        public ActorCriteria andTownNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("town not between ", value1, value2, "town");
            return (ActorCriteria) this;
        }
        
        public ActorCriteria andZipcodeIsNull() {
            addCriterion("zipcode is null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andZipcodeIsNotNull() {
            addCriterion("zipcode is not null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andZipcodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode =", value, "zipcode");
            return (ActorCriteria) this;
        }
        public ActorCriteria andZipcodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode <>", value, "zipcode");
            return (ActorCriteria) this;
        }
        public ActorCriteria andZipcodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode >", value, "zipcode");
            return (ActorCriteria) this;
        }
        public ActorCriteria andZipcodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode >=", value, "zipcode");
            return (ActorCriteria) this;
        }
        public ActorCriteria andZipcodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode <", value, "zipcode");
            return (ActorCriteria) this;
        }
        public ActorCriteria andZipcodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode <=", value, "zipcode");
            return (ActorCriteria) this;
        }
        public ActorCriteria andZipcodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode like ", value, "zipcode");
            return (ActorCriteria) this;
        }
        public ActorCriteria andZipcodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode not like ", value, "zipcode");
            return (ActorCriteria) this;
        }
        public ActorCriteria andZipcodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("zipcode in ", value, "zipcode");
            return (ActorCriteria) this;
        }
        public ActorCriteria andZipcodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("zipcode not in ", value, "zipcode");
            return (ActorCriteria) this;
        }
        public ActorCriteria andZipcodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("zipcode between ", value1, value2, "zipcode");
            return (ActorCriteria) this;
        }
        public ActorCriteria andZipcodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("zipcode not between ", value1, value2, "zipcode");
            return (ActorCriteria) this;
        }
        
        public ActorCriteria andContactgroupIsNull() {
            addCriterion("contactgroup is null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andContactgroupIsNotNull() {
            addCriterion("contactgroup is not null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andContactgroupEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("contactgroup =", value, "contactgroup");
            return (ActorCriteria) this;
        }
        public ActorCriteria andContactgroupNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("contactgroup <>", value, "contactgroup");
            return (ActorCriteria) this;
        }
        public ActorCriteria andContactgroupGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("contactgroup >", value, "contactgroup");
            return (ActorCriteria) this;
        }
        public ActorCriteria andContactgroupGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("contactgroup >=", value, "contactgroup");
            return (ActorCriteria) this;
        }
        public ActorCriteria andContactgroupLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("contactgroup <", value, "contactgroup");
            return (ActorCriteria) this;
        }
        public ActorCriteria andContactgroupLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("contactgroup <=", value, "contactgroup");
            return (ActorCriteria) this;
        }
        public ActorCriteria andContactgroupLike(java.lang.String value) {
            if (value != null)
              addCriterion("contactgroup like ", value, "contactgroup");
            return (ActorCriteria) this;
        }
        public ActorCriteria andContactgroupNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("contactgroup not like ", value, "contactgroup");
            return (ActorCriteria) this;
        }
        public ActorCriteria andContactgroupIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("contactgroup in ", value, "contactgroup");
            return (ActorCriteria) this;
        }
        public ActorCriteria andContactgroupNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("contactgroup not in ", value, "contactgroup");
            return (ActorCriteria) this;
        }
        public ActorCriteria andContactgroupBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("contactgroup between ", value1, value2, "contactgroup");
            return (ActorCriteria) this;
        }
        public ActorCriteria andContactgroupNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("contactgroup not between ", value1, value2, "contactgroup");
            return (ActorCriteria) this;
        }
        
        public ActorCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (ActorCriteria) this;
        }
        public ActorCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (ActorCriteria) this;
        }
        public ActorCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (ActorCriteria) this;
        }
        public ActorCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (ActorCriteria) this;
        }
        public ActorCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (ActorCriteria) this;
        }
        public ActorCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (ActorCriteria) this;
        }
        public ActorCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (ActorCriteria) this;
        }
        public ActorCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (ActorCriteria) this;
        }
        public ActorCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (ActorCriteria) this;
        }
        public ActorCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (ActorCriteria) this;
        }
        public ActorCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (ActorCriteria) this;
        }
        public ActorCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (ActorCriteria) this;
        }
        
        public ActorCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (ActorCriteria) this;
        }
        public ActorCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (ActorCriteria) this;
        }
        public ActorCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (ActorCriteria) this;
        }
        public ActorCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (ActorCriteria) this;
        }
        public ActorCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (ActorCriteria) this;
        }
        public ActorCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (ActorCriteria) this;
        }
        public ActorCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (ActorCriteria) this;
        }

    }
    
}

