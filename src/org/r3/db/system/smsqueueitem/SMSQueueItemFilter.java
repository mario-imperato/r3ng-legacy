//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.smsqueueitem;

import java.util.ArrayList;
import java.util.List;

public class SMSQueueItemFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public SMSQueueItemFilter() 
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

    public SMSQueueItemCriteria or() 
    {
        SMSQueueItemCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public SMSQueueItemCriteria createCriteria() 
    {
        SMSQueueItemCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected SMSQueueItemCriteria createCriteriaInternal() 
    {
        SMSQueueItemCriteria criteria = new SMSQueueItemCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class SMSQueueItemCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public SMSQueueItemCriteria andSmsitemidIsNull() {
            addCriterion("smsitemid is null");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSmsitemidIsNotNull() {
            addCriterion("smsitemid is not null");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSmsitemidEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("smsitemid =", value, "smsitemid");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSmsitemidNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("smsitemid <>", value, "smsitemid");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSmsitemidGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("smsitemid >", value, "smsitemid");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSmsitemidGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("smsitemid >=", value, "smsitemid");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSmsitemidLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("smsitemid <", value, "smsitemid");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSmsitemidLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("smsitemid <=", value, "smsitemid");
            return (SMSQueueItemCriteria) this;
        }

        
        public SMSQueueItemCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (SMSQueueItemCriteria) this;
        }
        
        public SMSQueueItemCriteria andSmsidIsNull() {
            addCriterion("smsid is null");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSmsidIsNotNull() {
            addCriterion("smsid is not null");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSmsidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("smsid =", value, "smsid");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSmsidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("smsid <>", value, "smsid");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSmsidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("smsid >", value, "smsid");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSmsidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("smsid >=", value, "smsid");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSmsidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("smsid <", value, "smsid");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSmsidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("smsid <=", value, "smsid");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSmsidLike(java.lang.String value) {
            if (value != null)
              addCriterion("smsid like ", value, "smsid");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSmsidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("smsid not like ", value, "smsid");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSmsidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("smsid in ", value, "smsid");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSmsidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("smsid not in ", value, "smsid");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSmsidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("smsid between ", value1, value2, "smsid");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andSmsidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("smsid not between ", value1, value2, "smsid");
            return (SMSQueueItemCriteria) this;
        }
        
        public SMSQueueItemCriteria andPhonenumberIsNull() {
            addCriterion("phonenumber is null");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andPhonenumberIsNotNull() {
            addCriterion("phonenumber is not null");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andPhonenumberEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phonenumber =", value, "phonenumber");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andPhonenumberNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phonenumber <>", value, "phonenumber");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andPhonenumberGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("phonenumber >", value, "phonenumber");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andPhonenumberGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phonenumber >=", value, "phonenumber");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andPhonenumberLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("phonenumber <", value, "phonenumber");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andPhonenumberLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phonenumber <=", value, "phonenumber");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andPhonenumberLike(java.lang.String value) {
            if (value != null)
              addCriterion("phonenumber like ", value, "phonenumber");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andPhonenumberNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("phonenumber not like ", value, "phonenumber");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andPhonenumberIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("phonenumber in ", value, "phonenumber");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andPhonenumberNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("phonenumber not in ", value, "phonenumber");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andPhonenumberBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("phonenumber between ", value1, value2, "phonenumber");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andPhonenumberNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("phonenumber not between ", value1, value2, "phonenumber");
            return (SMSQueueItemCriteria) this;
        }
        
        public SMSQueueItemCriteria andBusinesskeyIsNull() {
            addCriterion("businesskey is null");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andBusinesskeyIsNotNull() {
            addCriterion("businesskey is not null");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andBusinesskeyEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("businesskey =", value, "businesskey");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andBusinesskeyNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("businesskey <>", value, "businesskey");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andBusinesskeyGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("businesskey >", value, "businesskey");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andBusinesskeyGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("businesskey >=", value, "businesskey");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andBusinesskeyLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("businesskey <", value, "businesskey");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andBusinesskeyLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("businesskey <=", value, "businesskey");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andBusinesskeyLike(java.lang.String value) {
            if (value != null)
              addCriterion("businesskey like ", value, "businesskey");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andBusinesskeyNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("businesskey not like ", value, "businesskey");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andBusinesskeyIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("businesskey in ", value, "businesskey");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andBusinesskeyNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("businesskey not in ", value, "businesskey");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andBusinesskeyBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("businesskey between ", value1, value2, "businesskey");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andBusinesskeyNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("businesskey not between ", value1, value2, "businesskey");
            return (SMSQueueItemCriteria) this;
        }
        
        public SMSQueueItemCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (SMSQueueItemCriteria) this;
        }
        
        public SMSQueueItemCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (SMSQueueItemCriteria) this;
        }
        public SMSQueueItemCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (SMSQueueItemCriteria) this;
        }

    }
    
}

