//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.applicationview;

import java.util.ArrayList;
import java.util.List;

public class SailApplicationViewFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public SailApplicationViewFilter() 
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

    public SailApplicationViewCriteria or() 
    {
        SailApplicationViewCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public SailApplicationViewCriteria createCriteria() 
    {
        SailApplicationViewCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected SailApplicationViewCriteria createCriteriaInternal() 
    {
        SailApplicationViewCriteria criteria = new SailApplicationViewCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class SailApplicationViewCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public SailApplicationViewCriteria andEventidIsNull() {
            addCriterion("eventid is null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andEventidIsNotNull() {
            addCriterion("eventid is not null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andEventidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid =", value, "eventid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andEventidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <>", value, "eventid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andEventidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >", value, "eventid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andEventidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >=", value, "eventid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andEventidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <", value, "eventid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andEventidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <=", value, "eventid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andEventidLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid like ", value, "eventid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andEventidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid not like ", value, "eventid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andEventidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("eventid in ", value, "eventid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andEventidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("eventid not in ", value, "eventid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andEventidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid between ", value1, value2, "eventid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andEventidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid not between ", value1, value2, "eventid");
            return (SailApplicationViewCriteria) this;
        }
        
        public SailApplicationViewCriteria andApplicationidIsNull() {
            addCriterion("applicationid is null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApplicationidIsNotNull() {
            addCriterion("applicationid is not null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApplicationidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid =", value, "applicationid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApplicationidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid <>", value, "applicationid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApplicationidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid >", value, "applicationid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApplicationidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid >=", value, "applicationid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApplicationidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid <", value, "applicationid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApplicationidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid <=", value, "applicationid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApplicationidLike(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid like ", value, "applicationid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApplicationidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid not like ", value, "applicationid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApplicationidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("applicationid in ", value, "applicationid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApplicationidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("applicationid not in ", value, "applicationid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApplicationidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("applicationid between ", value1, value2, "applicationid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApplicationidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("applicationid not between ", value1, value2, "applicationid");
            return (SailApplicationViewCriteria) this;
        }
        
        public SailApplicationViewCriteria andUseridIsNull() {
            addCriterion("userid is null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andUseridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid =", value, "userid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andUseridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <>", value, "userid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andUseridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid >", value, "userid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andUseridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid >=", value, "userid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andUseridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid <", value, "userid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andUseridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <=", value, "userid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andUseridLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid like ", value, "userid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andUseridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid not like ", value, "userid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andUseridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("userid in ", value, "userid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andUseridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("userid not in ", value, "userid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andUseridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid between ", value1, value2, "userid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andUseridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid not between ", value1, value2, "userid");
            return (SailApplicationViewCriteria) this;
        }
        
        public SailApplicationViewCriteria andCompletionstatusIsNull() {
            addCriterion("completionstatus is null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andCompletionstatusIsNotNull() {
            addCriterion("completionstatus is not null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andCompletionstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("completionstatus =", value, "completionstatus");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andCompletionstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("completionstatus <>", value, "completionstatus");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andCompletionstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("completionstatus >", value, "completionstatus");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andCompletionstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("completionstatus >=", value, "completionstatus");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andCompletionstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("completionstatus <", value, "completionstatus");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andCompletionstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("completionstatus <=", value, "completionstatus");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andCompletionstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("completionstatus like ", value, "completionstatus");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andCompletionstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("completionstatus not like ", value, "completionstatus");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andCompletionstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("completionstatus in ", value, "completionstatus");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andCompletionstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("completionstatus not in ", value, "completionstatus");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andCompletionstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("completionstatus between ", value1, value2, "completionstatus");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andCompletionstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("completionstatus not between ", value1, value2, "completionstatus");
            return (SailApplicationViewCriteria) this;
        }
        
        public SailApplicationViewCriteria andVerificationstatusIsNull() {
            addCriterion("verificationstatus is null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andVerificationstatusIsNotNull() {
            addCriterion("verificationstatus is not null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andVerificationstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("verificationstatus =", value, "verificationstatus");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andVerificationstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("verificationstatus <>", value, "verificationstatus");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andVerificationstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("verificationstatus >", value, "verificationstatus");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andVerificationstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("verificationstatus >=", value, "verificationstatus");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andVerificationstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("verificationstatus <", value, "verificationstatus");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andVerificationstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("verificationstatus <=", value, "verificationstatus");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andVerificationstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("verificationstatus like ", value, "verificationstatus");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andVerificationstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("verificationstatus not like ", value, "verificationstatus");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andVerificationstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("verificationstatus in ", value, "verificationstatus");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andVerificationstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("verificationstatus not in ", value, "verificationstatus");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andVerificationstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("verificationstatus between ", value1, value2, "verificationstatus");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andVerificationstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("verificationstatus not between ", value1, value2, "verificationstatus");
            return (SailApplicationViewCriteria) this;
        }
        
        public SailApplicationViewCriteria andAdminchecksIsNull() {
            addCriterion("adminchecks is null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andAdminchecksIsNotNull() {
            addCriterion("adminchecks is not null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andAdminchecksEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("adminchecks =", value, "adminchecks");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andAdminchecksNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("adminchecks <>", value, "adminchecks");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andAdminchecksGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("adminchecks >", value, "adminchecks");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andAdminchecksGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("adminchecks >=", value, "adminchecks");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andAdminchecksLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("adminchecks <", value, "adminchecks");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andAdminchecksLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("adminchecks <=", value, "adminchecks");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andAdminchecksLike(java.lang.String value) {
            if (value != null)
              addCriterion("adminchecks like ", value, "adminchecks");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andAdminchecksNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("adminchecks not like ", value, "adminchecks");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andAdminchecksIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("adminchecks in ", value, "adminchecks");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andAdminchecksNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("adminchecks not in ", value, "adminchecks");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andAdminchecksBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("adminchecks between ", value1, value2, "adminchecks");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andAdminchecksNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("adminchecks not between ", value1, value2, "adminchecks");
            return (SailApplicationViewCriteria) this;
        }
        
        public SailApplicationViewCriteria andPlateIsNull() {
            addCriterion("plate is null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andPlateIsNotNull() {
            addCriterion("plate is not null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andPlateEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("plate =", value, "plate");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andPlateNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("plate <>", value, "plate");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andPlateGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("plate >", value, "plate");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andPlateGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("plate >=", value, "plate");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andPlateLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("plate <", value, "plate");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andPlateLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("plate <=", value, "plate");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andPlateLike(java.lang.String value) {
            if (value != null)
              addCriterion("plate like ", value, "plate");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andPlateNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("plate not like ", value, "plate");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andPlateIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("plate in ", value, "plate");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andPlateNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("plate not in ", value, "plate");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andPlateBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("plate between ", value1, value2, "plate");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andPlateNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("plate not between ", value1, value2, "plate");
            return (SailApplicationViewCriteria) this;
        }
        
        public SailApplicationViewCriteria andSailnumberIsNull() {
            addCriterion("sailnumber is null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andSailnumberIsNotNull() {
            addCriterion("sailnumber is not null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andSailnumberEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber =", value, "sailnumber");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andSailnumberNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber <>", value, "sailnumber");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andSailnumberGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber >", value, "sailnumber");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andSailnumberGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber >=", value, "sailnumber");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andSailnumberLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber <", value, "sailnumber");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andSailnumberLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber <=", value, "sailnumber");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andSailnumberLike(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber like ", value, "sailnumber");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andSailnumberNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber not like ", value, "sailnumber");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andSailnumberIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("sailnumber in ", value, "sailnumber");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andSailnumberNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("sailnumber not in ", value, "sailnumber");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andSailnumberBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sailnumber between ", value1, value2, "sailnumber");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andSailnumberNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sailnumber not between ", value1, value2, "sailnumber");
            return (SailApplicationViewCriteria) this;
        }
        
        public SailApplicationViewCriteria andYachtnameIsNull() {
            addCriterion("yachtname is null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtnameIsNotNull() {
            addCriterion("yachtname is not null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname =", value, "yachtname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname <>", value, "yachtname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname >", value, "yachtname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname >=", value, "yachtname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname <", value, "yachtname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname <=", value, "yachtname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname like ", value, "yachtname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname not like ", value, "yachtname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("yachtname in ", value, "yachtname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("yachtname not in ", value, "yachtname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("yachtname between ", value1, value2, "yachtname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("yachtname not between ", value1, value2, "yachtname");
            return (SailApplicationViewCriteria) this;
        }
        
        public SailApplicationViewCriteria andYachtclubIsNull() {
            addCriterion("yachtclub is null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtclubIsNotNull() {
            addCriterion("yachtclub is not null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtclubEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtclub =", value, "yachtclub");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtclubNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtclub <>", value, "yachtclub");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtclubGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("yachtclub >", value, "yachtclub");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtclubGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtclub >=", value, "yachtclub");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtclubLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("yachtclub <", value, "yachtclub");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtclubLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtclub <=", value, "yachtclub");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtclubLike(java.lang.String value) {
            if (value != null)
              addCriterion("yachtclub like ", value, "yachtclub");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtclubNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("yachtclub not like ", value, "yachtclub");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtclubIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("yachtclub in ", value, "yachtclub");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtclubNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("yachtclub not in ", value, "yachtclub");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtclubBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("yachtclub between ", value1, value2, "yachtclub");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtclubNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("yachtclub not between ", value1, value2, "yachtclub");
            return (SailApplicationViewCriteria) this;
        }
        
        public SailApplicationViewCriteria andYachttypeIsNull() {
            addCriterion("yachttype is null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachttypeIsNotNull() {
            addCriterion("yachttype is not null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachttypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachttype =", value, "yachttype");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachttypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachttype <>", value, "yachttype");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachttypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("yachttype >", value, "yachttype");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachttypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachttype >=", value, "yachttype");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachttypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("yachttype <", value, "yachttype");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachttypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachttype <=", value, "yachttype");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachttypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("yachttype like ", value, "yachttype");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachttypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("yachttype not like ", value, "yachttype");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachttypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("yachttype in ", value, "yachttype");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachttypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("yachttype not in ", value, "yachttype");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachttypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("yachttype between ", value1, value2, "yachttype");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachttypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("yachttype not between ", value1, value2, "yachttype");
            return (SailApplicationViewCriteria) this;
        }
        
        public SailApplicationViewCriteria andMooringlocIsNull() {
            addCriterion("mooringloc is null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andMooringlocIsNotNull() {
            addCriterion("mooringloc is not null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andMooringlocEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("mooringloc =", value, "mooringloc");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andMooringlocNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("mooringloc <>", value, "mooringloc");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andMooringlocGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("mooringloc >", value, "mooringloc");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andMooringlocGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("mooringloc >=", value, "mooringloc");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andMooringlocLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("mooringloc <", value, "mooringloc");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andMooringlocLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("mooringloc <=", value, "mooringloc");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andMooringlocLike(java.lang.String value) {
            if (value != null)
              addCriterion("mooringloc like ", value, "mooringloc");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andMooringlocNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("mooringloc not like ", value, "mooringloc");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andMooringlocIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("mooringloc in ", value, "mooringloc");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andMooringlocNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("mooringloc not in ", value, "mooringloc");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andMooringlocBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("mooringloc between ", value1, value2, "mooringloc");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andMooringlocNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("mooringloc not between ", value1, value2, "mooringloc");
            return (SailApplicationViewCriteria) this;
        }
        
        public SailApplicationViewCriteria andYachtbsfIsNull() {
            addCriterion("yachtbsf is null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtbsfIsNotNull() {
            addCriterion("yachtbsf is not null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtbsfEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtbsf =", value, "yachtbsf");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtbsfNotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtbsf <>", value, "yachtbsf");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtbsfGreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtbsf >", value, "yachtbsf");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtbsfGreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtbsf >=", value, "yachtbsf");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtbsfLessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtbsf <", value, "yachtbsf");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtbsfLessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtbsf <=", value, "yachtbsf");
            return (SailApplicationViewCriteria) this;
        }

        
        public SailApplicationViewCriteria andYachtgphIsNull() {
            addCriterion("yachtgph is null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtgphIsNotNull() {
            addCriterion("yachtgph is not null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtgphEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtgph =", value, "yachtgph");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtgphNotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtgph <>", value, "yachtgph");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtgphGreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtgph >", value, "yachtgph");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtgphGreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtgph >=", value, "yachtgph");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtgphLessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtgph <", value, "yachtgph");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andYachtgphLessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtgph <=", value, "yachtgph");
            return (SailApplicationViewCriteria) this;
        }

        
        public SailApplicationViewCriteria andRacegroupIsNull() {
            addCriterion("racegroup is null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRacegroupIsNotNull() {
            addCriterion("racegroup is not null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRacegroupEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup =", value, "racegroup");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRacegroupNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup <>", value, "racegroup");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRacegroupGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup >", value, "racegroup");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRacegroupGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup >=", value, "racegroup");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRacegroupLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup <", value, "racegroup");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRacegroupLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup <=", value, "racegroup");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRacegroupLike(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup like ", value, "racegroup");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRacegroupNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup not like ", value, "racegroup");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRacegroupIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("racegroup in ", value, "racegroup");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRacegroupNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("racegroup not in ", value, "racegroup");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRacegroupBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racegroup between ", value1, value2, "racegroup");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRacegroupNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racegroup not between ", value1, value2, "racegroup");
            return (SailApplicationViewCriteria) this;
        }
        
        public SailApplicationViewCriteria andRaceclassIsNull() {
            addCriterion("raceclass is null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRaceclassIsNotNull() {
            addCriterion("raceclass is not null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRaceclassEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass =", value, "raceclass");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRaceclassNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass <>", value, "raceclass");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRaceclassGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass >", value, "raceclass");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRaceclassGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass >=", value, "raceclass");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRaceclassLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass <", value, "raceclass");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRaceclassLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass <=", value, "raceclass");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRaceclassLike(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass like ", value, "raceclass");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRaceclassNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass not like ", value, "raceclass");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRaceclassIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("raceclass in ", value, "raceclass");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRaceclassNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("raceclass not in ", value, "raceclass");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRaceclassBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("raceclass between ", value1, value2, "raceclass");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRaceclassNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("raceclass not between ", value1, value2, "raceclass");
            return (SailApplicationViewCriteria) this;
        }
        
        public SailApplicationViewCriteria andApptypeIsNull() {
            addCriterion("apptype is null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApptypeIsNotNull() {
            addCriterion("apptype is not null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApptypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("apptype =", value, "apptype");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApptypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("apptype <>", value, "apptype");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApptypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("apptype >", value, "apptype");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApptypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("apptype >=", value, "apptype");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApptypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("apptype <", value, "apptype");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApptypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("apptype <=", value, "apptype");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApptypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("apptype like ", value, "apptype");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApptypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("apptype not like ", value, "apptype");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApptypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("apptype in ", value, "apptype");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApptypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("apptype not in ", value, "apptype");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApptypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("apptype between ", value1, value2, "apptype");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andApptypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("apptype not between ", value1, value2, "apptype");
            return (SailApplicationViewCriteria) this;
        }
        
        public SailApplicationViewCriteria andOwneridIsNull() {
            addCriterion("ownerid is null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneridIsNotNull() {
            addCriterion("ownerid is not null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownerid =", value, "ownerid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownerid <>", value, "ownerid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("ownerid >", value, "ownerid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownerid >=", value, "ownerid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("ownerid <", value, "ownerid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownerid <=", value, "ownerid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneridLike(java.lang.String value) {
            if (value != null)
              addCriterion("ownerid like ", value, "ownerid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("ownerid not like ", value, "ownerid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("ownerid in ", value, "ownerid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("ownerid not in ", value, "ownerid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ownerid between ", value1, value2, "ownerid");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ownerid not between ", value1, value2, "ownerid");
            return (SailApplicationViewCriteria) this;
        }
        
        public SailApplicationViewCriteria andOwnerfirstnameIsNull() {
            addCriterion("ownerfirstname is null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerfirstnameIsNotNull() {
            addCriterion("ownerfirstname is not null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerfirstnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownerfirstname =", value, "ownerfirstname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerfirstnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownerfirstname <>", value, "ownerfirstname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerfirstnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("ownerfirstname >", value, "ownerfirstname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerfirstnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownerfirstname >=", value, "ownerfirstname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerfirstnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("ownerfirstname <", value, "ownerfirstname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerfirstnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownerfirstname <=", value, "ownerfirstname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerfirstnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("ownerfirstname like ", value, "ownerfirstname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerfirstnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("ownerfirstname not like ", value, "ownerfirstname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerfirstnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("ownerfirstname in ", value, "ownerfirstname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerfirstnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("ownerfirstname not in ", value, "ownerfirstname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerfirstnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ownerfirstname between ", value1, value2, "ownerfirstname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerfirstnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ownerfirstname not between ", value1, value2, "ownerfirstname");
            return (SailApplicationViewCriteria) this;
        }
        
        public SailApplicationViewCriteria andOwnerlastnameIsNull() {
            addCriterion("ownerlastname is null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerlastnameIsNotNull() {
            addCriterion("ownerlastname is not null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerlastnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownerlastname =", value, "ownerlastname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerlastnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownerlastname <>", value, "ownerlastname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerlastnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("ownerlastname >", value, "ownerlastname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerlastnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownerlastname >=", value, "ownerlastname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerlastnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("ownerlastname <", value, "ownerlastname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerlastnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownerlastname <=", value, "ownerlastname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerlastnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("ownerlastname like ", value, "ownerlastname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerlastnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("ownerlastname not like ", value, "ownerlastname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerlastnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("ownerlastname in ", value, "ownerlastname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerlastnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("ownerlastname not in ", value, "ownerlastname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerlastnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ownerlastname between ", value1, value2, "ownerlastname");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnerlastnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ownerlastname not between ", value1, value2, "ownerlastname");
            return (SailApplicationViewCriteria) this;
        }
        
        public SailApplicationViewCriteria andOwneremailIsNull() {
            addCriterion("owneremail is null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneremailIsNotNull() {
            addCriterion("owneremail is not null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneremailEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("owneremail =", value, "owneremail");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneremailNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("owneremail <>", value, "owneremail");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneremailGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("owneremail >", value, "owneremail");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneremailGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("owneremail >=", value, "owneremail");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneremailLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("owneremail <", value, "owneremail");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneremailLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("owneremail <=", value, "owneremail");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneremailLike(java.lang.String value) {
            if (value != null)
              addCriterion("owneremail like ", value, "owneremail");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneremailNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("owneremail not like ", value, "owneremail");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneremailIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("owneremail in ", value, "owneremail");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneremailNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("owneremail not in ", value, "owneremail");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneremailBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("owneremail between ", value1, value2, "owneremail");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwneremailNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("owneremail not between ", value1, value2, "owneremail");
            return (SailApplicationViewCriteria) this;
        }
        
        public SailApplicationViewCriteria andOwnercellphoneIsNull() {
            addCriterion("ownercellphone is null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnercellphoneIsNotNull() {
            addCriterion("ownercellphone is not null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnercellphoneEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownercellphone =", value, "ownercellphone");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnercellphoneNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownercellphone <>", value, "ownercellphone");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnercellphoneGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("ownercellphone >", value, "ownercellphone");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnercellphoneGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownercellphone >=", value, "ownercellphone");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnercellphoneLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("ownercellphone <", value, "ownercellphone");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnercellphoneLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownercellphone <=", value, "ownercellphone");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnercellphoneLike(java.lang.String value) {
            if (value != null)
              addCriterion("ownercellphone like ", value, "ownercellphone");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnercellphoneNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("ownercellphone not like ", value, "ownercellphone");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnercellphoneIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("ownercellphone in ", value, "ownercellphone");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnercellphoneNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("ownercellphone not in ", value, "ownercellphone");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnercellphoneBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ownercellphone between ", value1, value2, "ownercellphone");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andOwnercellphoneNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ownercellphone not between ", value1, value2, "ownercellphone");
            return (SailApplicationViewCriteria) this;
        }
        
        public SailApplicationViewCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (SailApplicationViewCriteria) this;
        }
        public SailApplicationViewCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (SailApplicationViewCriteria) this;
        }

    }
    
}

