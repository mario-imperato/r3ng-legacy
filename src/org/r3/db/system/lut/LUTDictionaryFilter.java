//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.lut;

import java.util.ArrayList;
import java.util.List;

public class LUTDictionaryFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public LUTDictionaryFilter() 
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

    public LUTDictionaryCriteria or() 
    {
        LUTDictionaryCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public LUTDictionaryCriteria createCriteria() 
    {
        LUTDictionaryCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected LUTDictionaryCriteria createCriteriaInternal() 
    {
        LUTDictionaryCriteria criteria = new LUTDictionaryCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class LUTDictionaryCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public LUTDictionaryCriteria andLutidIsNull() {
            addCriterion("lutid is null");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andLutidIsNotNull() {
            addCriterion("lutid is not null");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andLutidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lutid =", value, "lutid");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andLutidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lutid <>", value, "lutid");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andLutidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("lutid >", value, "lutid");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andLutidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lutid >=", value, "lutid");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andLutidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("lutid <", value, "lutid");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andLutidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lutid <=", value, "lutid");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andLutidLike(java.lang.String value) {
            if (value != null)
              addCriterion("lutid like ", value, "lutid");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andLutidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("lutid not like ", value, "lutid");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andLutidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("lutid in ", value, "lutid");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andLutidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("lutid not in ", value, "lutid");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andLutidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("lutid between ", value1, value2, "lutid");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andLutidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("lutid not between ", value1, value2, "lutid");
            return (LUTDictionaryCriteria) this;
        }
        
        public LUTDictionaryCriteria andCacheintervalIsNull() {
            addCriterion("cacheinterval is null");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andCacheintervalIsNotNull() {
            addCriterion("cacheinterval is not null");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andCacheintervalEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("cacheinterval =", value, "cacheinterval");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andCacheintervalNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("cacheinterval <>", value, "cacheinterval");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andCacheintervalGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("cacheinterval >", value, "cacheinterval");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andCacheintervalGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("cacheinterval >=", value, "cacheinterval");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andCacheintervalLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("cacheinterval <", value, "cacheinterval");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andCacheintervalLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("cacheinterval <=", value, "cacheinterval");
            return (LUTDictionaryCriteria) this;
        }

        
        public LUTDictionaryCriteria andInvalidcountIsNull() {
            addCriterion("invalidcount is null");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andInvalidcountIsNotNull() {
            addCriterion("invalidcount is not null");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andInvalidcountEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("invalidcount =", value, "invalidcount");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andInvalidcountNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("invalidcount <>", value, "invalidcount");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andInvalidcountGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("invalidcount >", value, "invalidcount");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andInvalidcountGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("invalidcount >=", value, "invalidcount");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andInvalidcountLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("invalidcount <", value, "invalidcount");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andInvalidcountLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("invalidcount <=", value, "invalidcount");
            return (LUTDictionaryCriteria) this;
        }

        
        public LUTDictionaryCriteria andTargetsiteIsNull() {
            addCriterion("targetsite is null");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andTargetsiteIsNotNull() {
            addCriterion("targetsite is not null");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andTargetsiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("targetsite =", value, "targetsite");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andTargetsiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("targetsite <>", value, "targetsite");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andTargetsiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("targetsite >", value, "targetsite");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andTargetsiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("targetsite >=", value, "targetsite");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andTargetsiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("targetsite <", value, "targetsite");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andTargetsiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("targetsite <=", value, "targetsite");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andTargetsiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("targetsite like ", value, "targetsite");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andTargetsiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("targetsite not like ", value, "targetsite");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andTargetsiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("targetsite in ", value, "targetsite");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andTargetsiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("targetsite not in ", value, "targetsite");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andTargetsiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("targetsite between ", value1, value2, "targetsite");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andTargetsiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("targetsite not between ", value1, value2, "targetsite");
            return (LUTDictionaryCriteria) this;
        }
        
        public LUTDictionaryCriteria andEtagIsNull() {
            addCriterion("etag is null");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andEtagIsNotNull() {
            addCriterion("etag is not null");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andEtagEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("etag =", value, "etag");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andEtagNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("etag <>", value, "etag");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andEtagGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("etag >", value, "etag");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andEtagGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("etag >=", value, "etag");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andEtagLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("etag <", value, "etag");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andEtagLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("etag <=", value, "etag");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andEtagLike(java.lang.String value) {
            if (value != null)
              addCriterion("etag like ", value, "etag");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andEtagNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("etag not like ", value, "etag");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andEtagIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("etag in ", value, "etag");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andEtagNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("etag not in ", value, "etag");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andEtagBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("etag between ", value1, value2, "etag");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andEtagNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("etag not between ", value1, value2, "etag");
            return (LUTDictionaryCriteria) this;
        }
        
        public LUTDictionaryCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (LUTDictionaryCriteria) this;
        }
        public LUTDictionaryCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (LUTDictionaryCriteria) this;
        }

    }
    
}

