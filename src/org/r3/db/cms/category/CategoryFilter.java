//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.category;

import java.util.ArrayList;
import java.util.List;

public class CategoryFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public CategoryFilter() 
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

    public CategoryCriteria or() 
    {
        CategoryCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public CategoryCriteria createCriteria() 
    {
        CategoryCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected CategoryCriteria createCriteriaInternal() 
    {
        CategoryCriteria criteria = new CategoryCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class CategoryCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public CategoryCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (CategoryCriteria) this;
        }
        
        public CategoryCriteria andCategoryidIsNull() {
            addCriterion("categoryid is null");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategoryidIsNotNull() {
            addCriterion("categoryid is not null");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategoryidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid =", value, "categoryid");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategoryidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid <>", value, "categoryid");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategoryidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid >", value, "categoryid");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategoryidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid >=", value, "categoryid");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategoryidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid <", value, "categoryid");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategoryidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid <=", value, "categoryid");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategoryidLike(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid like ", value, "categoryid");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategoryidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid not like ", value, "categoryid");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategoryidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("categoryid in ", value, "categoryid");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategoryidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("categoryid not in ", value, "categoryid");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategoryidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("categoryid between ", value1, value2, "categoryid");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategoryidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("categoryid not between ", value1, value2, "categoryid");
            return (CategoryCriteria) this;
        }
        
        public CategoryCriteria andCategorymodeIsNull() {
            addCriterion("categorymode is null");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorymodeIsNotNull() {
            addCriterion("categorymode is not null");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorymodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categorymode =", value, "categorymode");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorymodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categorymode <>", value, "categorymode");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorymodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("categorymode >", value, "categorymode");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorymodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categorymode >=", value, "categorymode");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorymodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("categorymode <", value, "categorymode");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorymodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categorymode <=", value, "categorymode");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorymodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("categorymode like ", value, "categorymode");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorymodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("categorymode not like ", value, "categorymode");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorymodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("categorymode in ", value, "categorymode");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorymodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("categorymode not in ", value, "categorymode");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorymodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("categorymode between ", value1, value2, "categorymode");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorymodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("categorymode not between ", value1, value2, "categorymode");
            return (CategoryCriteria) this;
        }
        
        public CategoryCriteria andCategorydescrIsNull() {
            addCriterion("categorydescr is null");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorydescrIsNotNull() {
            addCriterion("categorydescr is not null");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorydescrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categorydescr =", value, "categorydescr");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorydescrNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categorydescr <>", value, "categorydescr");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorydescrGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("categorydescr >", value, "categorydescr");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorydescrGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categorydescr >=", value, "categorydescr");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorydescrLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("categorydescr <", value, "categorydescr");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorydescrLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categorydescr <=", value, "categorydescr");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorydescrLike(java.lang.String value) {
            if (value != null)
              addCriterion("categorydescr like ", value, "categorydescr");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorydescrNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("categorydescr not like ", value, "categorydescr");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorydescrIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("categorydescr in ", value, "categorydescr");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorydescrNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("categorydescr not in ", value, "categorydescr");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorydescrBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("categorydescr between ", value1, value2, "categorydescr");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andCategorydescrNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("categorydescr not between ", value1, value2, "categorydescr");
            return (CategoryCriteria) this;
        }
        
        public CategoryCriteria andPreviewtmplIsNull() {
            addCriterion("previewtmpl is null");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andPreviewtmplIsNotNull() {
            addCriterion("previewtmpl is not null");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andPreviewtmplEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("previewtmpl =", value, "previewtmpl");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andPreviewtmplNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("previewtmpl <>", value, "previewtmpl");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andPreviewtmplGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("previewtmpl >", value, "previewtmpl");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andPreviewtmplGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("previewtmpl >=", value, "previewtmpl");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andPreviewtmplLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("previewtmpl <", value, "previewtmpl");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andPreviewtmplLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("previewtmpl <=", value, "previewtmpl");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andPreviewtmplLike(java.lang.String value) {
            if (value != null)
              addCriterion("previewtmpl like ", value, "previewtmpl");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andPreviewtmplNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("previewtmpl not like ", value, "previewtmpl");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andPreviewtmplIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("previewtmpl in ", value, "previewtmpl");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andPreviewtmplNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("previewtmpl not in ", value, "previewtmpl");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andPreviewtmplBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("previewtmpl between ", value1, value2, "previewtmpl");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andPreviewtmplNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("previewtmpl not between ", value1, value2, "previewtmpl");
            return (CategoryCriteria) this;
        }
        
        public CategoryCriteria andFulltmplIsNull() {
            addCriterion("fulltmpl is null");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andFulltmplIsNotNull() {
            addCriterion("fulltmpl is not null");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andFulltmplEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fulltmpl =", value, "fulltmpl");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andFulltmplNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fulltmpl <>", value, "fulltmpl");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andFulltmplGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("fulltmpl >", value, "fulltmpl");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andFulltmplGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fulltmpl >=", value, "fulltmpl");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andFulltmplLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("fulltmpl <", value, "fulltmpl");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andFulltmplLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fulltmpl <=", value, "fulltmpl");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andFulltmplLike(java.lang.String value) {
            if (value != null)
              addCriterion("fulltmpl like ", value, "fulltmpl");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andFulltmplNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("fulltmpl not like ", value, "fulltmpl");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andFulltmplIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("fulltmpl in ", value, "fulltmpl");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andFulltmplNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("fulltmpl not in ", value, "fulltmpl");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andFulltmplBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("fulltmpl between ", value1, value2, "fulltmpl");
            return (CategoryCriteria) this;
        }
        public CategoryCriteria andFulltmplNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("fulltmpl not between ", value1, value2, "fulltmpl");
            return (CategoryCriteria) this;
        }
    }
    
}

