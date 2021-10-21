//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.categoryview;

import java.util.ArrayList;
import java.util.List;

public class CategoryViewFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public CategoryViewFilter() 
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

    public CategoryViewCriteria or() 
    {
        CategoryViewCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public CategoryViewCriteria createCriteria() 
    {
        CategoryViewCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected CategoryViewCriteria createCriteriaInternal() 
    {
        CategoryViewCriteria criteria = new CategoryViewCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class CategoryViewCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public CategoryViewCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (CategoryViewCriteria) this;
        }
        
        public CategoryViewCriteria andCategoryidIsNull() {
            addCriterion("categoryid is null");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategoryidIsNotNull() {
            addCriterion("categoryid is not null");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategoryidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid =", value, "categoryid");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategoryidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid <>", value, "categoryid");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategoryidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid >", value, "categoryid");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategoryidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid >=", value, "categoryid");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategoryidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid <", value, "categoryid");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategoryidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid <=", value, "categoryid");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategoryidLike(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid like ", value, "categoryid");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategoryidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("categoryid not like ", value, "categoryid");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategoryidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("categoryid in ", value, "categoryid");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategoryidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("categoryid not in ", value, "categoryid");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategoryidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("categoryid between ", value1, value2, "categoryid");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategoryidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("categoryid not between ", value1, value2, "categoryid");
            return (CategoryViewCriteria) this;
        }
        
        public CategoryViewCriteria andCategorymodeIsNull() {
            addCriterion("categorymode is null");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorymodeIsNotNull() {
            addCriterion("categorymode is not null");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorymodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categorymode =", value, "categorymode");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorymodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categorymode <>", value, "categorymode");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorymodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("categorymode >", value, "categorymode");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorymodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categorymode >=", value, "categorymode");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorymodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("categorymode <", value, "categorymode");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorymodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categorymode <=", value, "categorymode");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorymodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("categorymode like ", value, "categorymode");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorymodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("categorymode not like ", value, "categorymode");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorymodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("categorymode in ", value, "categorymode");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorymodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("categorymode not in ", value, "categorymode");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorymodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("categorymode between ", value1, value2, "categorymode");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorymodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("categorymode not between ", value1, value2, "categorymode");
            return (CategoryViewCriteria) this;
        }
        
        public CategoryViewCriteria andLanguagecodeIsNull() {
            addCriterion("languagecode is null");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andLanguagecodeIsNotNull() {
            addCriterion("languagecode is not null");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andLanguagecodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode =", value, "languagecode");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andLanguagecodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode <>", value, "languagecode");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andLanguagecodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode >", value, "languagecode");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andLanguagecodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode >=", value, "languagecode");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andLanguagecodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode <", value, "languagecode");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andLanguagecodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode <=", value, "languagecode");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andLanguagecodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode like ", value, "languagecode");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andLanguagecodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("languagecode not like ", value, "languagecode");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andLanguagecodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("languagecode in ", value, "languagecode");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andLanguagecodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("languagecode not in ", value, "languagecode");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andLanguagecodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("languagecode between ", value1, value2, "languagecode");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andLanguagecodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("languagecode not between ", value1, value2, "languagecode");
            return (CategoryViewCriteria) this;
        }
        
        public CategoryViewCriteria andCategorydescrIsNull() {
            addCriterion("categorydescr is null");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorydescrIsNotNull() {
            addCriterion("categorydescr is not null");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorydescrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categorydescr =", value, "categorydescr");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorydescrNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categorydescr <>", value, "categorydescr");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorydescrGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("categorydescr >", value, "categorydescr");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorydescrGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categorydescr >=", value, "categorydescr");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorydescrLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("categorydescr <", value, "categorydescr");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorydescrLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("categorydescr <=", value, "categorydescr");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorydescrLike(java.lang.String value) {
            if (value != null)
              addCriterion("categorydescr like ", value, "categorydescr");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorydescrNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("categorydescr not like ", value, "categorydescr");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorydescrIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("categorydescr in ", value, "categorydescr");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorydescrNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("categorydescr not in ", value, "categorydescr");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorydescrBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("categorydescr between ", value1, value2, "categorydescr");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andCategorydescrNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("categorydescr not between ", value1, value2, "categorydescr");
            return (CategoryViewCriteria) this;
        }
        
        public CategoryViewCriteria andPreviewtmplIsNull() {
            addCriterion("previewtmpl is null");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andPreviewtmplIsNotNull() {
            addCriterion("previewtmpl is not null");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andPreviewtmplEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("previewtmpl =", value, "previewtmpl");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andPreviewtmplNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("previewtmpl <>", value, "previewtmpl");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andPreviewtmplGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("previewtmpl >", value, "previewtmpl");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andPreviewtmplGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("previewtmpl >=", value, "previewtmpl");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andPreviewtmplLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("previewtmpl <", value, "previewtmpl");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andPreviewtmplLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("previewtmpl <=", value, "previewtmpl");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andPreviewtmplLike(java.lang.String value) {
            if (value != null)
              addCriterion("previewtmpl like ", value, "previewtmpl");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andPreviewtmplNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("previewtmpl not like ", value, "previewtmpl");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andPreviewtmplIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("previewtmpl in ", value, "previewtmpl");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andPreviewtmplNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("previewtmpl not in ", value, "previewtmpl");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andPreviewtmplBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("previewtmpl between ", value1, value2, "previewtmpl");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andPreviewtmplNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("previewtmpl not between ", value1, value2, "previewtmpl");
            return (CategoryViewCriteria) this;
        }
        
        public CategoryViewCriteria andFulltmplIsNull() {
            addCriterion("fulltmpl is null");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andFulltmplIsNotNull() {
            addCriterion("fulltmpl is not null");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andFulltmplEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fulltmpl =", value, "fulltmpl");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andFulltmplNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fulltmpl <>", value, "fulltmpl");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andFulltmplGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("fulltmpl >", value, "fulltmpl");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andFulltmplGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fulltmpl >=", value, "fulltmpl");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andFulltmplLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("fulltmpl <", value, "fulltmpl");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andFulltmplLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fulltmpl <=", value, "fulltmpl");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andFulltmplLike(java.lang.String value) {
            if (value != null)
              addCriterion("fulltmpl like ", value, "fulltmpl");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andFulltmplNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("fulltmpl not like ", value, "fulltmpl");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andFulltmplIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("fulltmpl in ", value, "fulltmpl");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andFulltmplNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("fulltmpl not in ", value, "fulltmpl");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andFulltmplBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("fulltmpl between ", value1, value2, "fulltmpl");
            return (CategoryViewCriteria) this;
        }
        public CategoryViewCriteria andFulltmplNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("fulltmpl not between ", value1, value2, "fulltmpl");
            return (CategoryViewCriteria) this;
        }
    }
    
}

