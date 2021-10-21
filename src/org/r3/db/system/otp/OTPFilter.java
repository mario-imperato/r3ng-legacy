//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.otp;

import java.util.ArrayList;
import java.util.List;

public class OTPFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public OTPFilter() 
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

    public OTPCriteria or() 
    {
        OTPCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public OTPCriteria createCriteria() 
    {
        OTPCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected OTPCriteria createCriteriaInternal() 
    {
        OTPCriteria criteria = new OTPCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class OTPCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public OTPCriteria andDigestIsNull() {
            addCriterion("digest is null");
            return (OTPCriteria) this;
        }
        public OTPCriteria andDigestIsNotNull() {
            addCriterion("digest is not null");
            return (OTPCriteria) this;
        }
        public OTPCriteria andDigestEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("digest =", value, "digest");
            return (OTPCriteria) this;
        }
        public OTPCriteria andDigestNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("digest <>", value, "digest");
            return (OTPCriteria) this;
        }
        public OTPCriteria andDigestGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("digest >", value, "digest");
            return (OTPCriteria) this;
        }
        public OTPCriteria andDigestGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("digest >=", value, "digest");
            return (OTPCriteria) this;
        }
        public OTPCriteria andDigestLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("digest <", value, "digest");
            return (OTPCriteria) this;
        }
        public OTPCriteria andDigestLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("digest <=", value, "digest");
            return (OTPCriteria) this;
        }
        public OTPCriteria andDigestLike(java.lang.String value) {
            if (value != null)
              addCriterion("digest like ", value, "digest");
            return (OTPCriteria) this;
        }
        public OTPCriteria andDigestNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("digest not like ", value, "digest");
            return (OTPCriteria) this;
        }
        public OTPCriteria andDigestIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("digest in ", value, "digest");
            return (OTPCriteria) this;
        }
        public OTPCriteria andDigestNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("digest not in ", value, "digest");
            return (OTPCriteria) this;
        }
        public OTPCriteria andDigestBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("digest between ", value1, value2, "digest");
            return (OTPCriteria) this;
        }
        public OTPCriteria andDigestNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("digest not between ", value1, value2, "digest");
            return (OTPCriteria) this;
        }
        
        public OTPCriteria andExpirytimeIsNull() {
            addCriterion("expirytime is null");
            return (OTPCriteria) this;
        }
        public OTPCriteria andExpirytimeIsNotNull() {
            addCriterion("expirytime is not null");
            return (OTPCriteria) this;
        }
        public OTPCriteria andExpirytimeEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("expirytime =", value, "expirytime");
            return (OTPCriteria) this;
        }
        public OTPCriteria andExpirytimeNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("expirytime <>", value, "expirytime");
            return (OTPCriteria) this;
        }
        public OTPCriteria andExpirytimeGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("expirytime >", value, "expirytime");
            return (OTPCriteria) this;
        }
        public OTPCriteria andExpirytimeGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("expirytime >=", value, "expirytime");
            return (OTPCriteria) this;
        }
        public OTPCriteria andExpirytimeLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("expirytime <", value, "expirytime");
            return (OTPCriteria) this;
        }
        public OTPCriteria andExpirytimeLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("expirytime <=", value, "expirytime");
            return (OTPCriteria) this;
        }

        
        public OTPCriteria andUseridIsNull() {
            addCriterion("userid is null");
            return (OTPCriteria) this;
        }
        public OTPCriteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (OTPCriteria) this;
        }
        public OTPCriteria andUseridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid =", value, "userid");
            return (OTPCriteria) this;
        }
        public OTPCriteria andUseridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <>", value, "userid");
            return (OTPCriteria) this;
        }
        public OTPCriteria andUseridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid >", value, "userid");
            return (OTPCriteria) this;
        }
        public OTPCriteria andUseridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid >=", value, "userid");
            return (OTPCriteria) this;
        }
        public OTPCriteria andUseridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid <", value, "userid");
            return (OTPCriteria) this;
        }
        public OTPCriteria andUseridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <=", value, "userid");
            return (OTPCriteria) this;
        }
        public OTPCriteria andUseridLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid like ", value, "userid");
            return (OTPCriteria) this;
        }
        public OTPCriteria andUseridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid not like ", value, "userid");
            return (OTPCriteria) this;
        }
        public OTPCriteria andUseridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("userid in ", value, "userid");
            return (OTPCriteria) this;
        }
        public OTPCriteria andUseridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("userid not in ", value, "userid");
            return (OTPCriteria) this;
        }
        public OTPCriteria andUseridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid between ", value1, value2, "userid");
            return (OTPCriteria) this;
        }
        public OTPCriteria andUseridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid not between ", value1, value2, "userid");
            return (OTPCriteria) this;
        }
    }
    
}

