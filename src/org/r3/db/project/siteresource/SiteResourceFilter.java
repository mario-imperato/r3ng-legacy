//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.siteresource;

import java.util.ArrayList;
import java.util.List;

public class SiteResourceFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public SiteResourceFilter() 
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

    public SiteResourceCriteria or() 
    {
        SiteResourceCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public SiteResourceCriteria createCriteria() 
    {
        SiteResourceCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected SiteResourceCriteria createCriteriaInternal() 
    {
        SiteResourceCriteria criteria = new SiteResourceCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class SiteResourceCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public SiteResourceCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (SiteResourceCriteria) this;
        }
        
        public SiteResourceCriteria andResourceidIsNull() {
            addCriterion("resourceid is null");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andResourceidIsNotNull() {
            addCriterion("resourceid is not null");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andResourceidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid =", value, "resourceid");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andResourceidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid <>", value, "resourceid");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andResourceidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid >", value, "resourceid");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andResourceidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid >=", value, "resourceid");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andResourceidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid <", value, "resourceid");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andResourceidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid <=", value, "resourceid");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andResourceidLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid like ", value, "resourceid");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andResourceidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid not like ", value, "resourceid");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andResourceidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("resourceid in ", value, "resourceid");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andResourceidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("resourceid not in ", value, "resourceid");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andResourceidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourceid between ", value1, value2, "resourceid");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andResourceidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourceid not between ", value1, value2, "resourceid");
            return (SiteResourceCriteria) this;
        }
        
        public SiteResourceCriteria andProfileidIsNull() {
            addCriterion("profileid is null");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andProfileidIsNotNull() {
            addCriterion("profileid is not null");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andProfileidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid =", value, "profileid");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andProfileidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid <>", value, "profileid");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andProfileidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("profileid >", value, "profileid");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andProfileidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid >=", value, "profileid");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andProfileidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("profileid <", value, "profileid");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andProfileidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid <=", value, "profileid");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andProfileidLike(java.lang.String value) {
            if (value != null)
              addCriterion("profileid like ", value, "profileid");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andProfileidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("profileid not like ", value, "profileid");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andProfileidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("profileid in ", value, "profileid");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andProfileidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("profileid not in ", value, "profileid");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andProfileidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("profileid between ", value1, value2, "profileid");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andProfileidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("profileid not between ", value1, value2, "profileid");
            return (SiteResourceCriteria) this;
        }
        
        public SiteResourceCriteria andEvalueunitIsNull() {
            addCriterion("evalueunit is null");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andEvalueunitIsNotNull() {
            addCriterion("evalueunit is not null");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andEvalueunitEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit =", value, "evalueunit");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andEvalueunitNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit <>", value, "evalueunit");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andEvalueunitGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit >", value, "evalueunit");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andEvalueunitGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit >=", value, "evalueunit");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andEvalueunitLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit <", value, "evalueunit");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andEvalueunitLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit <=", value, "evalueunit");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andEvalueunitLike(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit like ", value, "evalueunit");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andEvalueunitNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit not like ", value, "evalueunit");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andEvalueunitIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("evalueunit in ", value, "evalueunit");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andEvalueunitNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("evalueunit not in ", value, "evalueunit");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andEvalueunitBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("evalueunit between ", value1, value2, "evalueunit");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andEvalueunitNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("evalueunit not between ", value1, value2, "evalueunit");
            return (SiteResourceCriteria) this;
        }
        
        public SiteResourceCriteria andPriceIsNull() {
            addCriterion("price is null");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andPriceEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("price =", value, "price");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andPriceNotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("price <>", value, "price");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andPriceGreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("price >", value, "price");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andPriceGreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("price >=", value, "price");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andPriceLessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("price <", value, "price");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andPriceLessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("price <=", value, "price");
            return (SiteResourceCriteria) this;
        }

        
        public SiteResourceCriteria andCostIsNull() {
            addCriterion("cost is null");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andCostIsNotNull() {
            addCriterion("cost is not null");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andCostEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("cost =", value, "cost");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andCostNotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("cost <>", value, "cost");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andCostGreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("cost >", value, "cost");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andCostGreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("cost >=", value, "cost");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andCostLessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("cost <", value, "cost");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andCostLessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("cost <=", value, "cost");
            return (SiteResourceCriteria) this;
        }

        
        public SiteResourceCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (SiteResourceCriteria) this;
        }
        
        public SiteResourceCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (SiteResourceCriteria) this;
        }
        public SiteResourceCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (SiteResourceCriteria) this;
        }

    }
    
}

