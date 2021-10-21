//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.application;

import java.util.ArrayList;
import java.util.List;

public class SailApplicationFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public SailApplicationFilter() 
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

    public SailApplicationCriteria or() 
    {
        SailApplicationCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public SailApplicationCriteria createCriteria() 
    {
        SailApplicationCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected SailApplicationCriteria createCriteriaInternal() 
    {
        SailApplicationCriteria criteria = new SailApplicationCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class SailApplicationCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public SailApplicationCriteria andEventidIsNull() {
            addCriterion("eventid is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andEventidIsNotNull() {
            addCriterion("eventid is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andEventidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid =", value, "eventid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andEventidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <>", value, "eventid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andEventidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >", value, "eventid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andEventidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >=", value, "eventid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andEventidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <", value, "eventid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andEventidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <=", value, "eventid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andEventidLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid like ", value, "eventid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andEventidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid not like ", value, "eventid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andEventidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("eventid in ", value, "eventid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andEventidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("eventid not in ", value, "eventid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andEventidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid between ", value1, value2, "eventid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andEventidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid not between ", value1, value2, "eventid");
            return (SailApplicationCriteria) this;
        }
        
        public SailApplicationCriteria andApplicationidIsNull() {
            addCriterion("applicationid is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApplicationidIsNotNull() {
            addCriterion("applicationid is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApplicationidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid =", value, "applicationid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApplicationidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid <>", value, "applicationid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApplicationidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid >", value, "applicationid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApplicationidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid >=", value, "applicationid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApplicationidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid <", value, "applicationid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApplicationidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid <=", value, "applicationid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApplicationidLike(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid like ", value, "applicationid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApplicationidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid not like ", value, "applicationid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApplicationidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("applicationid in ", value, "applicationid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApplicationidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("applicationid not in ", value, "applicationid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApplicationidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("applicationid between ", value1, value2, "applicationid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApplicationidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("applicationid not between ", value1, value2, "applicationid");
            return (SailApplicationCriteria) this;
        }
        
        public SailApplicationCriteria andUseridIsNull() {
            addCriterion("userid is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andUseridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid =", value, "userid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andUseridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <>", value, "userid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andUseridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid >", value, "userid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andUseridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid >=", value, "userid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andUseridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid <", value, "userid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andUseridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <=", value, "userid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andUseridLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid like ", value, "userid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andUseridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid not like ", value, "userid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andUseridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("userid in ", value, "userid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andUseridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("userid not in ", value, "userid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andUseridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid between ", value1, value2, "userid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andUseridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid not between ", value1, value2, "userid");
            return (SailApplicationCriteria) this;
        }
        
        public SailApplicationCriteria andDmsfolderurlIsNull() {
            addCriterion("dmsfolderurl is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andDmsfolderurlIsNotNull() {
            addCriterion("dmsfolderurl is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andDmsfolderurlEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("dmsfolderurl =", value, "dmsfolderurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andDmsfolderurlNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("dmsfolderurl <>", value, "dmsfolderurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andDmsfolderurlGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("dmsfolderurl >", value, "dmsfolderurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andDmsfolderurlGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("dmsfolderurl >=", value, "dmsfolderurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andDmsfolderurlLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("dmsfolderurl <", value, "dmsfolderurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andDmsfolderurlLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("dmsfolderurl <=", value, "dmsfolderurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andDmsfolderurlLike(java.lang.String value) {
            if (value != null)
              addCriterion("dmsfolderurl like ", value, "dmsfolderurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andDmsfolderurlNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("dmsfolderurl not like ", value, "dmsfolderurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andDmsfolderurlIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("dmsfolderurl in ", value, "dmsfolderurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andDmsfolderurlNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("dmsfolderurl not in ", value, "dmsfolderurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andDmsfolderurlBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("dmsfolderurl between ", value1, value2, "dmsfolderurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andDmsfolderurlNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("dmsfolderurl not between ", value1, value2, "dmsfolderurl");
            return (SailApplicationCriteria) this;
        }
        
        public SailApplicationCriteria andAnnotationIsNull() {
            addCriterion("annotation is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAnnotationIsNotNull() {
            addCriterion("annotation is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAnnotationEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("annotation =", value, "annotation");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAnnotationNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("annotation <>", value, "annotation");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAnnotationGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("annotation >", value, "annotation");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAnnotationGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("annotation >=", value, "annotation");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAnnotationLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("annotation <", value, "annotation");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAnnotationLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("annotation <=", value, "annotation");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAnnotationLike(java.lang.String value) {
            if (value != null)
              addCriterion("annotation like ", value, "annotation");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAnnotationNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("annotation not like ", value, "annotation");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAnnotationIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("annotation in ", value, "annotation");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAnnotationNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("annotation not in ", value, "annotation");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAnnotationBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("annotation between ", value1, value2, "annotation");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAnnotationNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("annotation not between ", value1, value2, "annotation");
            return (SailApplicationCriteria) this;
        }
        
        public SailApplicationCriteria andCompletionstatusIsNull() {
            addCriterion("completionstatus is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCompletionstatusIsNotNull() {
            addCriterion("completionstatus is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCompletionstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("completionstatus =", value, "completionstatus");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCompletionstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("completionstatus <>", value, "completionstatus");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCompletionstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("completionstatus >", value, "completionstatus");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCompletionstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("completionstatus >=", value, "completionstatus");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCompletionstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("completionstatus <", value, "completionstatus");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCompletionstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("completionstatus <=", value, "completionstatus");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCompletionstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("completionstatus like ", value, "completionstatus");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCompletionstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("completionstatus not like ", value, "completionstatus");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCompletionstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("completionstatus in ", value, "completionstatus");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCompletionstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("completionstatus not in ", value, "completionstatus");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCompletionstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("completionstatus between ", value1, value2, "completionstatus");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCompletionstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("completionstatus not between ", value1, value2, "completionstatus");
            return (SailApplicationCriteria) this;
        }
        
        public SailApplicationCriteria andVerificationstatusIsNull() {
            addCriterion("verificationstatus is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andVerificationstatusIsNotNull() {
            addCriterion("verificationstatus is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andVerificationstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("verificationstatus =", value, "verificationstatus");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andVerificationstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("verificationstatus <>", value, "verificationstatus");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andVerificationstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("verificationstatus >", value, "verificationstatus");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andVerificationstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("verificationstatus >=", value, "verificationstatus");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andVerificationstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("verificationstatus <", value, "verificationstatus");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andVerificationstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("verificationstatus <=", value, "verificationstatus");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andVerificationstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("verificationstatus like ", value, "verificationstatus");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andVerificationstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("verificationstatus not like ", value, "verificationstatus");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andVerificationstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("verificationstatus in ", value, "verificationstatus");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andVerificationstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("verificationstatus not in ", value, "verificationstatus");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andVerificationstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("verificationstatus between ", value1, value2, "verificationstatus");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andVerificationstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("verificationstatus not between ", value1, value2, "verificationstatus");
            return (SailApplicationCriteria) this;
        }
        
        public SailApplicationCriteria andAdminchecksIsNull() {
            addCriterion("adminchecks is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminchecksIsNotNull() {
            addCriterion("adminchecks is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminchecksEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("adminchecks =", value, "adminchecks");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminchecksNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("adminchecks <>", value, "adminchecks");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminchecksGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("adminchecks >", value, "adminchecks");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminchecksGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("adminchecks >=", value, "adminchecks");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminchecksLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("adminchecks <", value, "adminchecks");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminchecksLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("adminchecks <=", value, "adminchecks");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminchecksLike(java.lang.String value) {
            if (value != null)
              addCriterion("adminchecks like ", value, "adminchecks");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminchecksNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("adminchecks not like ", value, "adminchecks");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminchecksIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("adminchecks in ", value, "adminchecks");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminchecksNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("adminchecks not in ", value, "adminchecks");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminchecksBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("adminchecks between ", value1, value2, "adminchecks");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminchecksNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("adminchecks not between ", value1, value2, "adminchecks");
            return (SailApplicationCriteria) this;
        }
        
        public SailApplicationCriteria andAdminracegroupIsNull() {
            addCriterion("adminracegroup is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminracegroupIsNotNull() {
            addCriterion("adminracegroup is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminracegroupEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("adminracegroup =", value, "adminracegroup");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminracegroupNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("adminracegroup <>", value, "adminracegroup");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminracegroupGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("adminracegroup >", value, "adminracegroup");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminracegroupGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("adminracegroup >=", value, "adminracegroup");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminracegroupLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("adminracegroup <", value, "adminracegroup");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminracegroupLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("adminracegroup <=", value, "adminracegroup");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminracegroupLike(java.lang.String value) {
            if (value != null)
              addCriterion("adminracegroup like ", value, "adminracegroup");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminracegroupNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("adminracegroup not like ", value, "adminracegroup");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminracegroupIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("adminracegroup in ", value, "adminracegroup");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminracegroupNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("adminracegroup not in ", value, "adminracegroup");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminracegroupBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("adminracegroup between ", value1, value2, "adminracegroup");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminracegroupNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("adminracegroup not between ", value1, value2, "adminracegroup");
            return (SailApplicationCriteria) this;
        }
        
        public SailApplicationCriteria andAdminraceclassIsNull() {
            addCriterion("adminraceclass is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminraceclassIsNotNull() {
            addCriterion("adminraceclass is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminraceclassEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("adminraceclass =", value, "adminraceclass");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminraceclassNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("adminraceclass <>", value, "adminraceclass");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminraceclassGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("adminraceclass >", value, "adminraceclass");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminraceclassGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("adminraceclass >=", value, "adminraceclass");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminraceclassLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("adminraceclass <", value, "adminraceclass");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminraceclassLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("adminraceclass <=", value, "adminraceclass");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminraceclassLike(java.lang.String value) {
            if (value != null)
              addCriterion("adminraceclass like ", value, "adminraceclass");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminraceclassNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("adminraceclass not like ", value, "adminraceclass");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminraceclassIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("adminraceclass in ", value, "adminraceclass");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminraceclassNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("adminraceclass not in ", value, "adminraceclass");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminraceclassBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("adminraceclass between ", value1, value2, "adminraceclass");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAdminraceclassNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("adminraceclass not between ", value1, value2, "adminraceclass");
            return (SailApplicationCriteria) this;
        }
        
        public SailApplicationCriteria andPlateIsNull() {
            addCriterion("plate is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andPlateIsNotNull() {
            addCriterion("plate is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andPlateEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("plate =", value, "plate");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andPlateNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("plate <>", value, "plate");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andPlateGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("plate >", value, "plate");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andPlateGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("plate >=", value, "plate");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andPlateLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("plate <", value, "plate");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andPlateLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("plate <=", value, "plate");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andPlateLike(java.lang.String value) {
            if (value != null)
              addCriterion("plate like ", value, "plate");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andPlateNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("plate not like ", value, "plate");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andPlateIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("plate in ", value, "plate");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andPlateNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("plate not in ", value, "plate");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andPlateBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("plate between ", value1, value2, "plate");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andPlateNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("plate not between ", value1, value2, "plate");
            return (SailApplicationCriteria) this;
        }
        
        public SailApplicationCriteria andYachtnameIsNull() {
            addCriterion("yachtname is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtnameIsNotNull() {
            addCriterion("yachtname is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname =", value, "yachtname");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname <>", value, "yachtname");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname >", value, "yachtname");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname >=", value, "yachtname");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname <", value, "yachtname");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname <=", value, "yachtname");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname like ", value, "yachtname");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname not like ", value, "yachtname");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("yachtname in ", value, "yachtname");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("yachtname not in ", value, "yachtname");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("yachtname between ", value1, value2, "yachtname");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("yachtname not between ", value1, value2, "yachtname");
            return (SailApplicationCriteria) this;
        }
        
        public SailApplicationCriteria andYachtclubIsNull() {
            addCriterion("yachtclub is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtclubIsNotNull() {
            addCriterion("yachtclub is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtclubEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtclub =", value, "yachtclub");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtclubNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtclub <>", value, "yachtclub");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtclubGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("yachtclub >", value, "yachtclub");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtclubGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtclub >=", value, "yachtclub");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtclubLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("yachtclub <", value, "yachtclub");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtclubLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtclub <=", value, "yachtclub");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtclubLike(java.lang.String value) {
            if (value != null)
              addCriterion("yachtclub like ", value, "yachtclub");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtclubNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("yachtclub not like ", value, "yachtclub");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtclubIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("yachtclub in ", value, "yachtclub");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtclubNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("yachtclub not in ", value, "yachtclub");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtclubBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("yachtclub between ", value1, value2, "yachtclub");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtclubNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("yachtclub not between ", value1, value2, "yachtclub");
            return (SailApplicationCriteria) this;
        }
        
        public SailApplicationCriteria andYachttypeIsNull() {
            addCriterion("yachttype is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachttypeIsNotNull() {
            addCriterion("yachttype is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachttypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachttype =", value, "yachttype");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachttypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachttype <>", value, "yachttype");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachttypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("yachttype >", value, "yachttype");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachttypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachttype >=", value, "yachttype");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachttypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("yachttype <", value, "yachttype");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachttypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachttype <=", value, "yachttype");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachttypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("yachttype like ", value, "yachttype");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachttypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("yachttype not like ", value, "yachttype");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachttypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("yachttype in ", value, "yachttype");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachttypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("yachttype not in ", value, "yachttype");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachttypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("yachttype between ", value1, value2, "yachttype");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachttypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("yachttype not between ", value1, value2, "yachttype");
            return (SailApplicationCriteria) this;
        }
        
        public SailApplicationCriteria andMooringlocIsNull() {
            addCriterion("mooringloc is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andMooringlocIsNotNull() {
            addCriterion("mooringloc is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andMooringlocEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("mooringloc =", value, "mooringloc");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andMooringlocNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("mooringloc <>", value, "mooringloc");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andMooringlocGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("mooringloc >", value, "mooringloc");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andMooringlocGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("mooringloc >=", value, "mooringloc");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andMooringlocLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("mooringloc <", value, "mooringloc");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andMooringlocLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("mooringloc <=", value, "mooringloc");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andMooringlocLike(java.lang.String value) {
            if (value != null)
              addCriterion("mooringloc like ", value, "mooringloc");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andMooringlocNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("mooringloc not like ", value, "mooringloc");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andMooringlocIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("mooringloc in ", value, "mooringloc");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andMooringlocNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("mooringloc not in ", value, "mooringloc");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andMooringlocBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("mooringloc between ", value1, value2, "mooringloc");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andMooringlocNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("mooringloc not between ", value1, value2, "mooringloc");
            return (SailApplicationCriteria) this;
        }
        
        public SailApplicationCriteria andYachtbsfIsNull() {
            addCriterion("yachtbsf is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtbsfIsNotNull() {
            addCriterion("yachtbsf is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtbsfEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtbsf =", value, "yachtbsf");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtbsfNotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtbsf <>", value, "yachtbsf");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtbsfGreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtbsf >", value, "yachtbsf");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtbsfGreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtbsf >=", value, "yachtbsf");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtbsfLessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtbsf <", value, "yachtbsf");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtbsfLessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtbsf <=", value, "yachtbsf");
            return (SailApplicationCriteria) this;
        }

        
        public SailApplicationCriteria andYachtgphIsNull() {
            addCriterion("yachtgph is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtgphIsNotNull() {
            addCriterion("yachtgph is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtgphEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtgph =", value, "yachtgph");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtgphNotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtgph <>", value, "yachtgph");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtgphGreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtgph >", value, "yachtgph");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtgphGreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtgph >=", value, "yachtgph");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtgphLessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtgph <", value, "yachtgph");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andYachtgphLessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtgph <=", value, "yachtgph");
            return (SailApplicationCriteria) this;
        }

        
        public SailApplicationCriteria andSailnumberIsNull() {
            addCriterion("sailnumber is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andSailnumberIsNotNull() {
            addCriterion("sailnumber is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andSailnumberEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber =", value, "sailnumber");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andSailnumberNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber <>", value, "sailnumber");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andSailnumberGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber >", value, "sailnumber");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andSailnumberGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber >=", value, "sailnumber");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andSailnumberLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber <", value, "sailnumber");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andSailnumberLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber <=", value, "sailnumber");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andSailnumberLike(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber like ", value, "sailnumber");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andSailnumberNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber not like ", value, "sailnumber");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andSailnumberIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("sailnumber in ", value, "sailnumber");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andSailnumberNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("sailnumber not in ", value, "sailnumber");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andSailnumberBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sailnumber between ", value1, value2, "sailnumber");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andSailnumberNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sailnumber not between ", value1, value2, "sailnumber");
            return (SailApplicationCriteria) this;
        }
        
        public SailApplicationCriteria andRacegroupIsNull() {
            addCriterion("racegroup is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRacegroupIsNotNull() {
            addCriterion("racegroup is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRacegroupEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup =", value, "racegroup");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRacegroupNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup <>", value, "racegroup");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRacegroupGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup >", value, "racegroup");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRacegroupGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup >=", value, "racegroup");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRacegroupLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup <", value, "racegroup");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRacegroupLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup <=", value, "racegroup");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRacegroupLike(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup like ", value, "racegroup");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRacegroupNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup not like ", value, "racegroup");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRacegroupIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("racegroup in ", value, "racegroup");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRacegroupNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("racegroup not in ", value, "racegroup");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRacegroupBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racegroup between ", value1, value2, "racegroup");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRacegroupNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racegroup not between ", value1, value2, "racegroup");
            return (SailApplicationCriteria) this;
        }
        
        public SailApplicationCriteria andRaceclassIsNull() {
            addCriterion("raceclass is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRaceclassIsNotNull() {
            addCriterion("raceclass is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRaceclassEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass =", value, "raceclass");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRaceclassNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass <>", value, "raceclass");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRaceclassGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass >", value, "raceclass");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRaceclassGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass >=", value, "raceclass");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRaceclassLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass <", value, "raceclass");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRaceclassLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass <=", value, "raceclass");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRaceclassLike(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass like ", value, "raceclass");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRaceclassNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass not like ", value, "raceclass");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRaceclassIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("raceclass in ", value, "raceclass");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRaceclassNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("raceclass not in ", value, "raceclass");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRaceclassBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("raceclass between ", value1, value2, "raceclass");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRaceclassNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("raceclass not between ", value1, value2, "raceclass");
            return (SailApplicationCriteria) this;
        }
        
        public SailApplicationCriteria andApptypeIsNull() {
            addCriterion("apptype is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApptypeIsNotNull() {
            addCriterion("apptype is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApptypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("apptype =", value, "apptype");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApptypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("apptype <>", value, "apptype");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApptypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("apptype >", value, "apptype");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApptypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("apptype >=", value, "apptype");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApptypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("apptype <", value, "apptype");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApptypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("apptype <=", value, "apptype");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApptypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("apptype like ", value, "apptype");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApptypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("apptype not like ", value, "apptype");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApptypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("apptype in ", value, "apptype");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApptypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("apptype not in ", value, "apptype");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApptypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("apptype between ", value1, value2, "apptype");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andApptypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("apptype not between ", value1, value2, "apptype");
            return (SailApplicationCriteria) this;
        }
        
        public SailApplicationCriteria andOwneridIsNull() {
            addCriterion("ownerid is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andOwneridIsNotNull() {
            addCriterion("ownerid is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andOwneridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownerid =", value, "ownerid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andOwneridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownerid <>", value, "ownerid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andOwneridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("ownerid >", value, "ownerid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andOwneridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownerid >=", value, "ownerid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andOwneridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("ownerid <", value, "ownerid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andOwneridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownerid <=", value, "ownerid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andOwneridLike(java.lang.String value) {
            if (value != null)
              addCriterion("ownerid like ", value, "ownerid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andOwneridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("ownerid not like ", value, "ownerid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andOwneridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("ownerid in ", value, "ownerid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andOwneridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("ownerid not in ", value, "ownerid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andOwneridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ownerid between ", value1, value2, "ownerid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andOwneridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ownerid not between ", value1, value2, "ownerid");
            return (SailApplicationCriteria) this;
        }
        
        public SailApplicationCriteria andHelmsmanidIsNull() {
            addCriterion("helmsmanid is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andHelmsmanidIsNotNull() {
            addCriterion("helmsmanid is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andHelmsmanidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("helmsmanid =", value, "helmsmanid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andHelmsmanidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("helmsmanid <>", value, "helmsmanid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andHelmsmanidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("helmsmanid >", value, "helmsmanid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andHelmsmanidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("helmsmanid >=", value, "helmsmanid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andHelmsmanidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("helmsmanid <", value, "helmsmanid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andHelmsmanidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("helmsmanid <=", value, "helmsmanid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andHelmsmanidLike(java.lang.String value) {
            if (value != null)
              addCriterion("helmsmanid like ", value, "helmsmanid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andHelmsmanidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("helmsmanid not like ", value, "helmsmanid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andHelmsmanidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("helmsmanid in ", value, "helmsmanid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andHelmsmanidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("helmsmanid not in ", value, "helmsmanid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andHelmsmanidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("helmsmanid between ", value1, value2, "helmsmanid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andHelmsmanidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("helmsmanid not between ", value1, value2, "helmsmanid");
            return (SailApplicationCriteria) this;
        }
        
        public SailApplicationCriteria andBoatimageidIsNull() {
            addCriterion("boatimageid is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageidIsNotNull() {
            addCriterion("boatimageid is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("boatimageid =", value, "boatimageid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("boatimageid <>", value, "boatimageid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("boatimageid >", value, "boatimageid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("boatimageid >=", value, "boatimageid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("boatimageid <", value, "boatimageid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("boatimageid <=", value, "boatimageid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageidLike(java.lang.String value) {
            if (value != null)
              addCriterion("boatimageid like ", value, "boatimageid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("boatimageid not like ", value, "boatimageid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("boatimageid in ", value, "boatimageid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("boatimageid not in ", value, "boatimageid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("boatimageid between ", value1, value2, "boatimageid");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("boatimageid not between ", value1, value2, "boatimageid");
            return (SailApplicationCriteria) this;
        }
        
        public SailApplicationCriteria andBoatimageurlIsNull() {
            addCriterion("boatimageurl is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageurlIsNotNull() {
            addCriterion("boatimageurl is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageurlEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("boatimageurl =", value, "boatimageurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageurlNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("boatimageurl <>", value, "boatimageurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageurlGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("boatimageurl >", value, "boatimageurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageurlGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("boatimageurl >=", value, "boatimageurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageurlLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("boatimageurl <", value, "boatimageurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageurlLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("boatimageurl <=", value, "boatimageurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageurlLike(java.lang.String value) {
            if (value != null)
              addCriterion("boatimageurl like ", value, "boatimageurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageurlNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("boatimageurl not like ", value, "boatimageurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageurlIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("boatimageurl in ", value, "boatimageurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageurlNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("boatimageurl not in ", value, "boatimageurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageurlBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("boatimageurl between ", value1, value2, "boatimageurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageurlNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("boatimageurl not between ", value1, value2, "boatimageurl");
            return (SailApplicationCriteria) this;
        }
        
        public SailApplicationCriteria andBoatimageheightIsNull() {
            addCriterion("boatimageheight is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageheightIsNotNull() {
            addCriterion("boatimageheight is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageheightEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boatimageheight =", value, "boatimageheight");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageheightNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boatimageheight <>", value, "boatimageheight");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageheightGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("boatimageheight >", value, "boatimageheight");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageheightGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boatimageheight >=", value, "boatimageheight");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageheightLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("boatimageheight <", value, "boatimageheight");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimageheightLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boatimageheight <=", value, "boatimageheight");
            return (SailApplicationCriteria) this;
        }

        
        public SailApplicationCriteria andBoatimagewidthIsNull() {
            addCriterion("boatimagewidth is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimagewidthIsNotNull() {
            addCriterion("boatimagewidth is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimagewidthEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boatimagewidth =", value, "boatimagewidth");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimagewidthNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boatimagewidth <>", value, "boatimagewidth");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimagewidthGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("boatimagewidth >", value, "boatimagewidth");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimagewidthGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boatimagewidth >=", value, "boatimagewidth");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimagewidthLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("boatimagewidth <", value, "boatimagewidth");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoatimagewidthLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boatimagewidth <=", value, "boatimagewidth");
            return (SailApplicationCriteria) this;
        }

        
        public SailApplicationCriteria andBoaticonurlIsNull() {
            addCriterion("boaticonurl is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonurlIsNotNull() {
            addCriterion("boaticonurl is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonurlEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("boaticonurl =", value, "boaticonurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonurlNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("boaticonurl <>", value, "boaticonurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonurlGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("boaticonurl >", value, "boaticonurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonurlGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("boaticonurl >=", value, "boaticonurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonurlLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("boaticonurl <", value, "boaticonurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonurlLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("boaticonurl <=", value, "boaticonurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonurlLike(java.lang.String value) {
            if (value != null)
              addCriterion("boaticonurl like ", value, "boaticonurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonurlNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("boaticonurl not like ", value, "boaticonurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonurlIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("boaticonurl in ", value, "boaticonurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonurlNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("boaticonurl not in ", value, "boaticonurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonurlBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("boaticonurl between ", value1, value2, "boaticonurl");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonurlNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("boaticonurl not between ", value1, value2, "boaticonurl");
            return (SailApplicationCriteria) this;
        }
        
        public SailApplicationCriteria andBoaticonwidthIsNull() {
            addCriterion("boaticonwidth is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonwidthIsNotNull() {
            addCriterion("boaticonwidth is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonwidthEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boaticonwidth =", value, "boaticonwidth");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonwidthNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boaticonwidth <>", value, "boaticonwidth");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonwidthGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("boaticonwidth >", value, "boaticonwidth");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonwidthGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boaticonwidth >=", value, "boaticonwidth");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonwidthLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("boaticonwidth <", value, "boaticonwidth");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonwidthLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boaticonwidth <=", value, "boaticonwidth");
            return (SailApplicationCriteria) this;
        }

        
        public SailApplicationCriteria andBoaticonheightIsNull() {
            addCriterion("boaticonheight is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonheightIsNotNull() {
            addCriterion("boaticonheight is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonheightEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boaticonheight =", value, "boaticonheight");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonheightNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boaticonheight <>", value, "boaticonheight");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonheightGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("boaticonheight >", value, "boaticonheight");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonheightGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boaticonheight >=", value, "boaticonheight");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonheightLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("boaticonheight <", value, "boaticonheight");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andBoaticonheightLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boaticonheight <=", value, "boaticonheight");
            return (SailApplicationCriteria) this;
        }

        
        public SailApplicationCriteria andAddtohomeentrylistIsNull() {
            addCriterion("addtohomeentrylist is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAddtohomeentrylistIsNotNull() {
            addCriterion("addtohomeentrylist is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAddtohomeentrylistEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("addtohomeentrylist =", value, "addtohomeentrylist");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAddtohomeentrylistNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("addtohomeentrylist <>", value, "addtohomeentrylist");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAddtohomeentrylistGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("addtohomeentrylist >", value, "addtohomeentrylist");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAddtohomeentrylistGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("addtohomeentrylist >=", value, "addtohomeentrylist");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAddtohomeentrylistLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("addtohomeentrylist <", value, "addtohomeentrylist");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAddtohomeentrylistLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("addtohomeentrylist <=", value, "addtohomeentrylist");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAddtohomeentrylistLike(java.lang.String value) {
            if (value != null)
              addCriterion("addtohomeentrylist like ", value, "addtohomeentrylist");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAddtohomeentrylistNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("addtohomeentrylist not like ", value, "addtohomeentrylist");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAddtohomeentrylistIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("addtohomeentrylist in ", value, "addtohomeentrylist");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAddtohomeentrylistNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("addtohomeentrylist not in ", value, "addtohomeentrylist");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAddtohomeentrylistBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("addtohomeentrylist between ", value1, value2, "addtohomeentrylist");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andAddtohomeentrylistNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("addtohomeentrylist not between ", value1, value2, "addtohomeentrylist");
            return (SailApplicationCriteria) this;
        }
        
        public SailApplicationCriteria andCreatetimestampIsNull() {
            addCriterion("createtimestamp is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCreatetimestampIsNotNull() {
            addCriterion("createtimestamp is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCreatetimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("createtimestamp =", value, "createtimestamp");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCreatetimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("createtimestamp <>", value, "createtimestamp");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCreatetimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("createtimestamp >", value, "createtimestamp");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCreatetimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("createtimestamp >=", value, "createtimestamp");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCreatetimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("createtimestamp <", value, "createtimestamp");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCreatetimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("createtimestamp <=", value, "createtimestamp");
            return (SailApplicationCriteria) this;
        }

        
        public SailApplicationCriteria andCommittimestampIsNull() {
            addCriterion("committimestamp is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCommittimestampIsNotNull() {
            addCriterion("committimestamp is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCommittimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("committimestamp =", value, "committimestamp");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCommittimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("committimestamp <>", value, "committimestamp");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCommittimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("committimestamp >", value, "committimestamp");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCommittimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("committimestamp >=", value, "committimestamp");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCommittimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("committimestamp <", value, "committimestamp");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andCommittimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("committimestamp <=", value, "committimestamp");
            return (SailApplicationCriteria) this;
        }

        
        public SailApplicationCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (SailApplicationCriteria) this;
        }
        public SailApplicationCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (SailApplicationCriteria) this;
        }

    }
    
}

