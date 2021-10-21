//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.fileproperty;

import java.util.ArrayList;
import java.util.List;

public class DMSFilePropertyFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public DMSFilePropertyFilter() 
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

    public DMSFilePropertyCriteria or() 
    {
        DMSFilePropertyCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public DMSFilePropertyCriteria createCriteria() 
    {
        DMSFilePropertyCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected DMSFilePropertyCriteria createCriteriaInternal() 
    {
        DMSFilePropertyCriteria criteria = new DMSFilePropertyCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class DMSFilePropertyCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public DMSFilePropertyCriteria andFileidIsNull() {
            addCriterion("fileid is null");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andFileidIsNotNull() {
            addCriterion("fileid is not null");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andFileidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fileid =", value, "fileid");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andFileidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fileid <>", value, "fileid");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andFileidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("fileid >", value, "fileid");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andFileidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fileid >=", value, "fileid");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andFileidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("fileid <", value, "fileid");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andFileidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fileid <=", value, "fileid");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andFileidLike(java.lang.String value) {
            if (value != null)
              addCriterion("fileid like ", value, "fileid");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andFileidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("fileid not like ", value, "fileid");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andFileidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("fileid in ", value, "fileid");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andFileidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("fileid not in ", value, "fileid");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andFileidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("fileid between ", value1, value2, "fileid");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andFileidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("fileid not between ", value1, value2, "fileid");
            return (DMSFilePropertyCriteria) this;
        }
        
        public DMSFilePropertyCriteria andPropertynameIsNull() {
            addCriterion("propertyname is null");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertynameIsNotNull() {
            addCriterion("propertyname is not null");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertynameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname =", value, "propertyname");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertynameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname <>", value, "propertyname");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertynameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname >", value, "propertyname");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertynameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname >=", value, "propertyname");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertynameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname <", value, "propertyname");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertynameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname <=", value, "propertyname");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertynameLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname like ", value, "propertyname");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertynameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyname not like ", value, "propertyname");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertynameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("propertyname in ", value, "propertyname");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertynameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("propertyname not in ", value, "propertyname");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertynameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyname between ", value1, value2, "propertyname");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertynameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyname not between ", value1, value2, "propertyname");
            return (DMSFilePropertyCriteria) this;
        }
        
        public DMSFilePropertyCriteria andPropertyvalueIsNull() {
            addCriterion("propertyvalue is null");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertyvalueIsNotNull() {
            addCriterion("propertyvalue is not null");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertyvalueEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue =", value, "propertyvalue");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertyvalueNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue <>", value, "propertyvalue");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertyvalueGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue >", value, "propertyvalue");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertyvalueGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue >=", value, "propertyvalue");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertyvalueLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue <", value, "propertyvalue");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertyvalueLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue <=", value, "propertyvalue");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertyvalueLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue like ", value, "propertyvalue");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertyvalueNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyvalue not like ", value, "propertyvalue");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertyvalueIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("propertyvalue in ", value, "propertyvalue");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertyvalueNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("propertyvalue not in ", value, "propertyvalue");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertyvalueBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyvalue between ", value1, value2, "propertyvalue");
            return (DMSFilePropertyCriteria) this;
        }
        public DMSFilePropertyCriteria andPropertyvalueNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyvalue not between ", value1, value2, "propertyvalue");
            return (DMSFilePropertyCriteria) this;
        }
    }
    
}

