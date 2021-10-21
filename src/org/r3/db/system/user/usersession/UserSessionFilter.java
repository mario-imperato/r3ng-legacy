//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.user.usersession;

import java.util.ArrayList;
import java.util.List;

public class UserSessionFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public UserSessionFilter() 
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

    public UserSessionCriteria or() 
    {
        UserSessionCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public UserSessionCriteria createCriteria() 
    {
        UserSessionCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected UserSessionCriteria createCriteriaInternal() 
    {
        UserSessionCriteria criteria = new UserSessionCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class UserSessionCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public UserSessionCriteria andSessionidIsNull() {
            addCriterion("sessionid is null");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andSessionidIsNotNull() {
            addCriterion("sessionid is not null");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andSessionidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sessionid =", value, "sessionid");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andSessionidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sessionid <>", value, "sessionid");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andSessionidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("sessionid >", value, "sessionid");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andSessionidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sessionid >=", value, "sessionid");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andSessionidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("sessionid <", value, "sessionid");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andSessionidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sessionid <=", value, "sessionid");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andSessionidLike(java.lang.String value) {
            if (value != null)
              addCriterion("sessionid like ", value, "sessionid");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andSessionidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("sessionid not like ", value, "sessionid");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andSessionidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("sessionid in ", value, "sessionid");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andSessionidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("sessionid not in ", value, "sessionid");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andSessionidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sessionid between ", value1, value2, "sessionid");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andSessionidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sessionid not between ", value1, value2, "sessionid");
            return (UserSessionCriteria) this;
        }
        
        public UserSessionCriteria andUseridIsNull() {
            addCriterion("userid is null");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andUseridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid =", value, "userid");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andUseridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <>", value, "userid");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andUseridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid >", value, "userid");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andUseridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid >=", value, "userid");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andUseridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid <", value, "userid");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andUseridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <=", value, "userid");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andUseridLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid like ", value, "userid");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andUseridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid not like ", value, "userid");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andUseridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("userid in ", value, "userid");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andUseridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("userid not in ", value, "userid");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andUseridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid between ", value1, value2, "userid");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andUseridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid not between ", value1, value2, "userid");
            return (UserSessionCriteria) this;
        }
        
        public UserSessionCriteria andIpaddressIsNull() {
            addCriterion("ipaddress is null");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andIpaddressIsNotNull() {
            addCriterion("ipaddress is not null");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andIpaddressEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ipaddress =", value, "ipaddress");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andIpaddressNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ipaddress <>", value, "ipaddress");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andIpaddressGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("ipaddress >", value, "ipaddress");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andIpaddressGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ipaddress >=", value, "ipaddress");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andIpaddressLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("ipaddress <", value, "ipaddress");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andIpaddressLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ipaddress <=", value, "ipaddress");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andIpaddressLike(java.lang.String value) {
            if (value != null)
              addCriterion("ipaddress like ", value, "ipaddress");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andIpaddressNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("ipaddress not like ", value, "ipaddress");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andIpaddressIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("ipaddress in ", value, "ipaddress");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andIpaddressNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("ipaddress not in ", value, "ipaddress");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andIpaddressBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ipaddress between ", value1, value2, "ipaddress");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andIpaddressNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ipaddress not between ", value1, value2, "ipaddress");
            return (UserSessionCriteria) this;
        }
        
        public UserSessionCriteria andConsentmodeIsNull() {
            addCriterion("consentmode is null");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andConsentmodeIsNotNull() {
            addCriterion("consentmode is not null");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andConsentmodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("consentmode =", value, "consentmode");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andConsentmodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("consentmode <>", value, "consentmode");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andConsentmodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("consentmode >", value, "consentmode");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andConsentmodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("consentmode >=", value, "consentmode");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andConsentmodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("consentmode <", value, "consentmode");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andConsentmodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("consentmode <=", value, "consentmode");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andConsentmodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("consentmode like ", value, "consentmode");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andConsentmodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("consentmode not like ", value, "consentmode");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andConsentmodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("consentmode in ", value, "consentmode");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andConsentmodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("consentmode not in ", value, "consentmode");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andConsentmodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("consentmode between ", value1, value2, "consentmode");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andConsentmodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("consentmode not between ", value1, value2, "consentmode");
            return (UserSessionCriteria) this;
        }
        
        public UserSessionCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (UserSessionCriteria) this;
        }
        public UserSessionCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (UserSessionCriteria) this;
        }

    }
    
}

