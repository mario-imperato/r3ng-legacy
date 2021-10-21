//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.appcrewmember;

import java.util.ArrayList;
import java.util.List;

public class SailApplicationCrewMemberFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public SailApplicationCrewMemberFilter() 
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

    public SailApplicationCrewMemberCriteria or() 
    {
        SailApplicationCrewMemberCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public SailApplicationCrewMemberCriteria createCriteria() 
    {
        SailApplicationCrewMemberCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected SailApplicationCrewMemberCriteria createCriteriaInternal() 
    {
        SailApplicationCrewMemberCriteria criteria = new SailApplicationCrewMemberCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class SailApplicationCrewMemberCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public SailApplicationCrewMemberCriteria andCrewmemberidIsNull() {
            addCriterion("crewmemberid is null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberidIsNotNull() {
            addCriterion("crewmemberid is not null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("crewmemberid =", value, "crewmemberid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("crewmemberid <>", value, "crewmemberid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("crewmemberid >", value, "crewmemberid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("crewmemberid >=", value, "crewmemberid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("crewmemberid <", value, "crewmemberid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("crewmemberid <=", value, "crewmemberid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberidLike(java.lang.String value) {
            if (value != null)
              addCriterion("crewmemberid like ", value, "crewmemberid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("crewmemberid not like ", value, "crewmemberid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("crewmemberid in ", value, "crewmemberid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("crewmemberid not in ", value, "crewmemberid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("crewmemberid between ", value1, value2, "crewmemberid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("crewmemberid not between ", value1, value2, "crewmemberid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        
        public SailApplicationCrewMemberCriteria andEventidIsNull() {
            addCriterion("eventid is null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andEventidIsNotNull() {
            addCriterion("eventid is not null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andEventidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid =", value, "eventid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andEventidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <>", value, "eventid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andEventidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >", value, "eventid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andEventidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >=", value, "eventid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andEventidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <", value, "eventid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andEventidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <=", value, "eventid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andEventidLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid like ", value, "eventid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andEventidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid not like ", value, "eventid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andEventidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("eventid in ", value, "eventid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andEventidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("eventid not in ", value, "eventid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andEventidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid between ", value1, value2, "eventid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andEventidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid not between ", value1, value2, "eventid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        
        public SailApplicationCrewMemberCriteria andApplicationidIsNull() {
            addCriterion("applicationid is null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andApplicationidIsNotNull() {
            addCriterion("applicationid is not null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andApplicationidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid =", value, "applicationid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andApplicationidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid <>", value, "applicationid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andApplicationidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid >", value, "applicationid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andApplicationidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid >=", value, "applicationid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andApplicationidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid <", value, "applicationid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andApplicationidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid <=", value, "applicationid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andApplicationidLike(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid like ", value, "applicationid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andApplicationidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid not like ", value, "applicationid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andApplicationidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("applicationid in ", value, "applicationid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andApplicationidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("applicationid not in ", value, "applicationid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andApplicationidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("applicationid between ", value1, value2, "applicationid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andApplicationidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("applicationid not between ", value1, value2, "applicationid");
            return (SailApplicationCrewMemberCriteria) this;
        }
        
        public SailApplicationCrewMemberCriteria andCardnumberIsNull() {
            addCriterion("cardnumber is null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCardnumberIsNotNull() {
            addCriterion("cardnumber is not null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCardnumberEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardnumber =", value, "cardnumber");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCardnumberNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardnumber <>", value, "cardnumber");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCardnumberGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardnumber >", value, "cardnumber");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCardnumberGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardnumber >=", value, "cardnumber");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCardnumberLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardnumber <", value, "cardnumber");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCardnumberLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardnumber <=", value, "cardnumber");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCardnumberLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardnumber like ", value, "cardnumber");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCardnumberNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardnumber not like ", value, "cardnumber");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCardnumberIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("cardnumber in ", value, "cardnumber");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCardnumberNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("cardnumber not in ", value, "cardnumber");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCardnumberBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardnumber between ", value1, value2, "cardnumber");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCardnumberNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardnumber not between ", value1, value2, "cardnumber");
            return (SailApplicationCrewMemberCriteria) this;
        }
        
        public SailApplicationCrewMemberCriteria andCrewmembernameIsNull() {
            addCriterion("crewmembername is null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmembernameIsNotNull() {
            addCriterion("crewmembername is not null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmembernameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("crewmembername =", value, "crewmembername");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmembernameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("crewmembername <>", value, "crewmembername");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmembernameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("crewmembername >", value, "crewmembername");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmembernameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("crewmembername >=", value, "crewmembername");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmembernameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("crewmembername <", value, "crewmembername");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmembernameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("crewmembername <=", value, "crewmembername");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmembernameLike(java.lang.String value) {
            if (value != null)
              addCriterion("crewmembername like ", value, "crewmembername");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmembernameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("crewmembername not like ", value, "crewmembername");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmembernameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("crewmembername in ", value, "crewmembername");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmembernameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("crewmembername not in ", value, "crewmembername");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmembernameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("crewmembername between ", value1, value2, "crewmembername");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmembernameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("crewmembername not between ", value1, value2, "crewmembername");
            return (SailApplicationCrewMemberCriteria) this;
        }
        
        public SailApplicationCrewMemberCriteria andWeightIsNull() {
            addCriterion("weight is null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andWeightEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("weight =", value, "weight");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andWeightNotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("weight <>", value, "weight");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andWeightGreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("weight >", value, "weight");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andWeightGreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("weight >=", value, "weight");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andWeightLessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("weight <", value, "weight");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andWeightLessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("weight <=", value, "weight");
            return (SailApplicationCrewMemberCriteria) this;
        }

        
        public SailApplicationCrewMemberCriteria andCrewmemberrolecodeIsNull() {
            addCriterion("crewmemberrolecode is null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberrolecodeIsNotNull() {
            addCriterion("crewmemberrolecode is not null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberrolecodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("crewmemberrolecode =", value, "crewmemberrolecode");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberrolecodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("crewmemberrolecode <>", value, "crewmemberrolecode");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberrolecodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("crewmemberrolecode >", value, "crewmemberrolecode");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberrolecodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("crewmemberrolecode >=", value, "crewmemberrolecode");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberrolecodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("crewmemberrolecode <", value, "crewmemberrolecode");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberrolecodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("crewmemberrolecode <=", value, "crewmemberrolecode");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberrolecodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("crewmemberrolecode like ", value, "crewmemberrolecode");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberrolecodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("crewmemberrolecode not like ", value, "crewmemberrolecode");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberrolecodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("crewmemberrolecode in ", value, "crewmemberrolecode");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberrolecodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("crewmemberrolecode not in ", value, "crewmemberrolecode");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberrolecodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("crewmemberrolecode between ", value1, value2, "crewmemberrolecode");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCrewmemberrolecodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("crewmemberrolecode not between ", value1, value2, "crewmemberrolecode");
            return (SailApplicationCrewMemberCriteria) this;
        }
        
        public SailApplicationCrewMemberCriteria andMemberstatuscodeIsNull() {
            addCriterion("memberstatuscode is null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andMemberstatuscodeIsNotNull() {
            addCriterion("memberstatuscode is not null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andMemberstatuscodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("memberstatuscode =", value, "memberstatuscode");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andMemberstatuscodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("memberstatuscode <>", value, "memberstatuscode");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andMemberstatuscodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("memberstatuscode >", value, "memberstatuscode");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andMemberstatuscodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("memberstatuscode >=", value, "memberstatuscode");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andMemberstatuscodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("memberstatuscode <", value, "memberstatuscode");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andMemberstatuscodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("memberstatuscode <=", value, "memberstatuscode");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andMemberstatuscodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("memberstatuscode like ", value, "memberstatuscode");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andMemberstatuscodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("memberstatuscode not like ", value, "memberstatuscode");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andMemberstatuscodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("memberstatuscode in ", value, "memberstatuscode");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andMemberstatuscodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("memberstatuscode not in ", value, "memberstatuscode");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andMemberstatuscodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("memberstatuscode between ", value1, value2, "memberstatuscode");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andMemberstatuscodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("memberstatuscode not between ", value1, value2, "memberstatuscode");
            return (SailApplicationCrewMemberCriteria) this;
        }
        
        public SailApplicationCrewMemberCriteria andCreatetimestampIsNull() {
            addCriterion("createtimestamp is null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCreatetimestampIsNotNull() {
            addCriterion("createtimestamp is not null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCreatetimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("createtimestamp =", value, "createtimestamp");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCreatetimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("createtimestamp <>", value, "createtimestamp");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCreatetimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("createtimestamp >", value, "createtimestamp");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCreatetimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("createtimestamp >=", value, "createtimestamp");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCreatetimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("createtimestamp <", value, "createtimestamp");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCreatetimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("createtimestamp <=", value, "createtimestamp");
            return (SailApplicationCrewMemberCriteria) this;
        }

        
        public SailApplicationCrewMemberCriteria andDeletetimestampIsNull() {
            addCriterion("deletetimestamp is null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andDeletetimestampIsNotNull() {
            addCriterion("deletetimestamp is not null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andDeletetimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("deletetimestamp =", value, "deletetimestamp");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andDeletetimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("deletetimestamp <>", value, "deletetimestamp");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andDeletetimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("deletetimestamp >", value, "deletetimestamp");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andDeletetimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("deletetimestamp >=", value, "deletetimestamp");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andDeletetimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("deletetimestamp <", value, "deletetimestamp");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andDeletetimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("deletetimestamp <=", value, "deletetimestamp");
            return (SailApplicationCrewMemberCriteria) this;
        }

        
        public SailApplicationCrewMemberCriteria andCheckcardnumberIsNull() {
            addCriterion("checkcardnumber is null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCheckcardnumberIsNotNull() {
            addCriterion("checkcardnumber is not null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCheckcardnumberEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("checkcardnumber =", value, "checkcardnumber");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCheckcardnumberNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("checkcardnumber <>", value, "checkcardnumber");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCheckcardnumberGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("checkcardnumber >", value, "checkcardnumber");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCheckcardnumberGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("checkcardnumber >=", value, "checkcardnumber");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCheckcardnumberLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("checkcardnumber <", value, "checkcardnumber");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCheckcardnumberLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("checkcardnumber <=", value, "checkcardnumber");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCheckcardnumberLike(java.lang.String value) {
            if (value != null)
              addCriterion("checkcardnumber like ", value, "checkcardnumber");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCheckcardnumberNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("checkcardnumber not like ", value, "checkcardnumber");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCheckcardnumberIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("checkcardnumber in ", value, "checkcardnumber");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCheckcardnumberNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("checkcardnumber not in ", value, "checkcardnumber");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCheckcardnumberBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("checkcardnumber between ", value1, value2, "checkcardnumber");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCheckcardnumberNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("checkcardnumber not between ", value1, value2, "checkcardnumber");
            return (SailApplicationCrewMemberCriteria) this;
        }
        
        public SailApplicationCrewMemberCriteria andCheckcardnumber_tsIsNull() {
            addCriterion("checkcardnumber_ts is null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCheckcardnumber_tsIsNotNull() {
            addCriterion("checkcardnumber_ts is not null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCheckcardnumber_tsEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("checkcardnumber_ts =", value, "checkcardnumber_ts");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCheckcardnumber_tsNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("checkcardnumber_ts <>", value, "checkcardnumber_ts");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCheckcardnumber_tsGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("checkcardnumber_ts >", value, "checkcardnumber_ts");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCheckcardnumber_tsGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("checkcardnumber_ts >=", value, "checkcardnumber_ts");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCheckcardnumber_tsLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("checkcardnumber_ts <", value, "checkcardnumber_ts");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andCheckcardnumber_tsLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("checkcardnumber_ts <=", value, "checkcardnumber_ts");
            return (SailApplicationCrewMemberCriteria) this;
        }

        
        public SailApplicationCrewMemberCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (SailApplicationCrewMemberCriteria) this;
        }
        
        public SailApplicationCrewMemberCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (SailApplicationCrewMemberCriteria) this;
        }
        public SailApplicationCrewMemberCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (SailApplicationCrewMemberCriteria) this;
        }

    }
    
}

