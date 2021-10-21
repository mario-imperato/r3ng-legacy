//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.classifier;

import java.util.ArrayList;
import java.util.List;

public class ClassifierFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public ClassifierFilter() 
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

    public ClassifierCriteria or() 
    {
        ClassifierCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public ClassifierCriteria createCriteria() 
    {
        ClassifierCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected ClassifierCriteria createCriteriaInternal() 
    {
        ClassifierCriteria criteria = new ClassifierCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class ClassifierCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public ClassifierCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (ClassifierCriteria) this;
        }
        
        public ClassifierCriteria andClsidIsNull() {
            addCriterion("clsid is null");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsidIsNotNull() {
            addCriterion("clsid is not null");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clsid =", value, "clsid");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clsid <>", value, "clsid");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("clsid >", value, "clsid");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clsid >=", value, "clsid");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("clsid <", value, "clsid");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clsid <=", value, "clsid");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsidLike(java.lang.String value) {
            if (value != null)
              addCriterion("clsid like ", value, "clsid");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("clsid not like ", value, "clsid");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("clsid in ", value, "clsid");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("clsid not in ", value, "clsid");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("clsid between ", value1, value2, "clsid");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("clsid not between ", value1, value2, "clsid");
            return (ClassifierCriteria) this;
        }
        
        public ClassifierCriteria andClsdescrIsNull() {
            addCriterion("clsdescr is null");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsdescrIsNotNull() {
            addCriterion("clsdescr is not null");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsdescrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clsdescr =", value, "clsdescr");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsdescrNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clsdescr <>", value, "clsdescr");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsdescrGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("clsdescr >", value, "clsdescr");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsdescrGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clsdescr >=", value, "clsdescr");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsdescrLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("clsdescr <", value, "clsdescr");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsdescrLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clsdescr <=", value, "clsdescr");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsdescrLike(java.lang.String value) {
            if (value != null)
              addCriterion("clsdescr like ", value, "clsdescr");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsdescrNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("clsdescr not like ", value, "clsdescr");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsdescrIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("clsdescr in ", value, "clsdescr");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsdescrNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("clsdescr not in ", value, "clsdescr");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsdescrBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("clsdescr between ", value1, value2, "clsdescr");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsdescrNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("clsdescr not between ", value1, value2, "clsdescr");
            return (ClassifierCriteria) this;
        }
        
        public ClassifierCriteria andClstypecodeIsNull() {
            addCriterion("clstypecode is null");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClstypecodeIsNotNull() {
            addCriterion("clstypecode is not null");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClstypecodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clstypecode =", value, "clstypecode");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClstypecodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clstypecode <>", value, "clstypecode");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClstypecodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("clstypecode >", value, "clstypecode");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClstypecodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clstypecode >=", value, "clstypecode");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClstypecodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("clstypecode <", value, "clstypecode");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClstypecodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clstypecode <=", value, "clstypecode");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClstypecodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("clstypecode like ", value, "clstypecode");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClstypecodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("clstypecode not like ", value, "clstypecode");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClstypecodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("clstypecode in ", value, "clstypecode");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClstypecodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("clstypecode not in ", value, "clstypecode");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClstypecodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("clstypecode between ", value1, value2, "clstypecode");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClstypecodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("clstypecode not between ", value1, value2, "clstypecode");
            return (ClassifierCriteria) this;
        }
        
        public ClassifierCriteria andClsambitcodeIsNull() {
            addCriterion("clsambitcode is null");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsambitcodeIsNotNull() {
            addCriterion("clsambitcode is not null");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsambitcodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clsambitcode =", value, "clsambitcode");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsambitcodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clsambitcode <>", value, "clsambitcode");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsambitcodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("clsambitcode >", value, "clsambitcode");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsambitcodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clsambitcode >=", value, "clsambitcode");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsambitcodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("clsambitcode <", value, "clsambitcode");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsambitcodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clsambitcode <=", value, "clsambitcode");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsambitcodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("clsambitcode like ", value, "clsambitcode");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsambitcodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("clsambitcode not like ", value, "clsambitcode");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsambitcodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("clsambitcode in ", value, "clsambitcode");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsambitcodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("clsambitcode not in ", value, "clsambitcode");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsambitcodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("clsambitcode between ", value1, value2, "clsambitcode");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andClsambitcodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("clsambitcode not between ", value1, value2, "clsambitcode");
            return (ClassifierCriteria) this;
        }
        
        public ClassifierCriteria andCacheintervalIsNull() {
            addCriterion("cacheinterval is null");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andCacheintervalIsNotNull() {
            addCriterion("cacheinterval is not null");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andCacheintervalEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("cacheinterval =", value, "cacheinterval");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andCacheintervalNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("cacheinterval <>", value, "cacheinterval");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andCacheintervalGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("cacheinterval >", value, "cacheinterval");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andCacheintervalGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("cacheinterval >=", value, "cacheinterval");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andCacheintervalLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("cacheinterval <", value, "cacheinterval");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andCacheintervalLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("cacheinterval <=", value, "cacheinterval");
            return (ClassifierCriteria) this;
        }

        
        public ClassifierCriteria andEtagIsNull() {
            addCriterion("etag is null");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andEtagIsNotNull() {
            addCriterion("etag is not null");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andEtagEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("etag =", value, "etag");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andEtagNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("etag <>", value, "etag");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andEtagGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("etag >", value, "etag");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andEtagGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("etag >=", value, "etag");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andEtagLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("etag <", value, "etag");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andEtagLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("etag <=", value, "etag");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andEtagLike(java.lang.String value) {
            if (value != null)
              addCriterion("etag like ", value, "etag");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andEtagNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("etag not like ", value, "etag");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andEtagIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("etag in ", value, "etag");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andEtagNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("etag not in ", value, "etag");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andEtagBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("etag between ", value1, value2, "etag");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andEtagNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("etag not between ", value1, value2, "etag");
            return (ClassifierCriteria) this;
        }
        
        public ClassifierCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (ClassifierCriteria) this;
        }
        public ClassifierCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (ClassifierCriteria) this;
        }

    }
    
}

