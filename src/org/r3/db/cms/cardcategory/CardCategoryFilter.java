//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardcategory;

import java.util.ArrayList;
import java.util.List;

public class CardCategoryFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public CardCategoryFilter() 
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

    public CardCategoryCriteria or() 
    {
        CardCategoryCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public CardCategoryCriteria createCriteria() 
    {
        CardCategoryCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected CardCategoryCriteria createCriteriaInternal() 
    {
        CardCategoryCriteria criteria = new CardCategoryCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class CardCategoryCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public CardCategoryCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (CardCategoryCriteria) this;
        }
        
        public CardCategoryCriteria andCardidIsNull() {
            addCriterion("cardid is null");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCardidIsNotNull() {
            addCriterion("cardid is not null");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCardidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid =", value, "cardid");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCardidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <>", value, "cardid");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCardidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardid >", value, "cardid");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCardidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid >=", value, "cardid");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCardidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <", value, "cardid");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCardidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <=", value, "cardid");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCardidLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardid like ", value, "cardid");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCardidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardid not like ", value, "cardid");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCardidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("cardid in ", value, "cardid");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCardidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("cardid not in ", value, "cardid");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCardidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardid between ", value1, value2, "cardid");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCardidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardid not between ", value1, value2, "cardid");
            return (CardCategoryCriteria) this;
        }
        
        public CardCategoryCriteria andCategoryidIsNull() {
            addCriterion("categoryid is null");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCategoryidIsNotNull() {
            addCriterion("categoryid is not null");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCategoryidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid =", value, "categoryid");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCategoryidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid <>", value, "categoryid");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCategoryidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid >", value, "categoryid");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCategoryidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid >=", value, "categoryid");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCategoryidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid <", value, "categoryid");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCategoryidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid <=", value, "categoryid");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCategoryidLike(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid like ", value, "categoryid");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCategoryidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid not like ", value, "categoryid");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCategoryidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("categoryid in ", value, "categoryid");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCategoryidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("categoryid not in ", value, "categoryid");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCategoryidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("categoryid between ", value1, value2, "categoryid");
            return (CardCategoryCriteria) this;
        }
        public CardCategoryCriteria andCategoryidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("categoryid not between ", value1, value2, "categoryid");
            return (CardCategoryCriteria) this;
        }
    }
    
}

