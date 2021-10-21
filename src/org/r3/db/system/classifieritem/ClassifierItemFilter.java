//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.classifieritem;

import java.util.ArrayList;
import java.util.List;

public class ClassifierItemFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public ClassifierItemFilter() 
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

    public ClassifierItemCriteria or() 
    {
        ClassifierItemCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public ClassifierItemCriteria createCriteria() 
    {
        ClassifierItemCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected ClassifierItemCriteria createCriteriaInternal() 
    {
        ClassifierItemCriteria criteria = new ClassifierItemCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class ClassifierItemCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public ClassifierItemCriteria andClsitemidIsNull() {
            addCriterion("clsitemid is null");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitemidIsNotNull() {
            addCriterion("clsitemid is not null");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitemidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clsitemid =", value, "clsitemid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitemidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clsitemid <>", value, "clsitemid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitemidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("clsitemid >", value, "clsitemid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitemidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clsitemid >=", value, "clsitemid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitemidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("clsitemid <", value, "clsitemid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitemidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clsitemid <=", value, "clsitemid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitemidLike(java.lang.String value) {
            if (value != null)
              addCriterion("clsitemid like ", value, "clsitemid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitemidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("clsitemid not like ", value, "clsitemid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitemidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("clsitemid in ", value, "clsitemid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitemidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("clsitemid not in ", value, "clsitemid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitemidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("clsitemid between ", value1, value2, "clsitemid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitemidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("clsitemid not between ", value1, value2, "clsitemid");
            return (ClassifierItemCriteria) this;
        }
        
        public ClassifierItemCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (ClassifierItemCriteria) this;
        }
        
        public ClassifierItemCriteria andClsidIsNull() {
            addCriterion("clsid is null");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsidIsNotNull() {
            addCriterion("clsid is not null");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clsid =", value, "clsid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clsid <>", value, "clsid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("clsid >", value, "clsid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clsid >=", value, "clsid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("clsid <", value, "clsid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clsid <=", value, "clsid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsidLike(java.lang.String value) {
            if (value != null)
              addCriterion("clsid like ", value, "clsid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("clsid not like ", value, "clsid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("clsid in ", value, "clsid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("clsid not in ", value, "clsid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("clsid between ", value1, value2, "clsid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("clsid not between ", value1, value2, "clsid");
            return (ClassifierItemCriteria) this;
        }
        
        public ClassifierItemCriteria andClsitembusidIsNull() {
            addCriterion("clsitembusid is null");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitembusidIsNotNull() {
            addCriterion("clsitembusid is not null");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitembusidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clsitembusid =", value, "clsitembusid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitembusidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clsitembusid <>", value, "clsitembusid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitembusidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("clsitembusid >", value, "clsitembusid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitembusidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clsitembusid >=", value, "clsitembusid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitembusidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("clsitembusid <", value, "clsitembusid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitembusidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("clsitembusid <=", value, "clsitembusid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitembusidLike(java.lang.String value) {
            if (value != null)
              addCriterion("clsitembusid like ", value, "clsitembusid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitembusidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("clsitembusid not like ", value, "clsitembusid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitembusidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("clsitembusid in ", value, "clsitembusid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitembusidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("clsitembusid not in ", value, "clsitembusid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitembusidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("clsitembusid between ", value1, value2, "clsitembusid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClsitembusidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("clsitembusid not between ", value1, value2, "clsitembusid");
            return (ClassifierItemCriteria) this;
        }
        
        public ClassifierItemCriteria andParentitemidIsNull() {
            addCriterion("parentitemid is null");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andParentitemidIsNotNull() {
            addCriterion("parentitemid is not null");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andParentitemidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("parentitemid =", value, "parentitemid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andParentitemidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("parentitemid <>", value, "parentitemid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andParentitemidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("parentitemid >", value, "parentitemid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andParentitemidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("parentitemid >=", value, "parentitemid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andParentitemidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("parentitemid <", value, "parentitemid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andParentitemidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("parentitemid <=", value, "parentitemid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andParentitemidLike(java.lang.String value) {
            if (value != null)
              addCriterion("parentitemid like ", value, "parentitemid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andParentitemidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("parentitemid not like ", value, "parentitemid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andParentitemidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("parentitemid in ", value, "parentitemid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andParentitemidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("parentitemid not in ", value, "parentitemid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andParentitemidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("parentitemid between ", value1, value2, "parentitemid");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andParentitemidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("parentitemid not between ", value1, value2, "parentitemid");
            return (ClassifierItemCriteria) this;
        }
        
        public ClassifierItemCriteria andClassifieritemdescrIsNull() {
            addCriterion("classifieritemdescr is null");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemdescrIsNotNull() {
            addCriterion("classifieritemdescr is not null");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemdescrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("classifieritemdescr =", value, "classifieritemdescr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemdescrNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("classifieritemdescr <>", value, "classifieritemdescr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemdescrGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("classifieritemdescr >", value, "classifieritemdescr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemdescrGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("classifieritemdescr >=", value, "classifieritemdescr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemdescrLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("classifieritemdescr <", value, "classifieritemdescr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemdescrLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("classifieritemdescr <=", value, "classifieritemdescr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemdescrLike(java.lang.String value) {
            if (value != null)
              addCriterion("classifieritemdescr like ", value, "classifieritemdescr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemdescrNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("classifieritemdescr not like ", value, "classifieritemdescr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemdescrIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("classifieritemdescr in ", value, "classifieritemdescr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemdescrNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("classifieritemdescr not in ", value, "classifieritemdescr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemdescrBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("classifieritemdescr between ", value1, value2, "classifieritemdescr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemdescrNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("classifieritemdescr not between ", value1, value2, "classifieritemdescr");
            return (ClassifierItemCriteria) this;
        }
        
        public ClassifierItemCriteria andClassifieritempathIsNull() {
            addCriterion("classifieritempath is null");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritempathIsNotNull() {
            addCriterion("classifieritempath is not null");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritempathEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("classifieritempath =", value, "classifieritempath");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritempathNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("classifieritempath <>", value, "classifieritempath");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritempathGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("classifieritempath >", value, "classifieritempath");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritempathGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("classifieritempath >=", value, "classifieritempath");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritempathLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("classifieritempath <", value, "classifieritempath");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritempathLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("classifieritempath <=", value, "classifieritempath");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritempathLike(java.lang.String value) {
            if (value != null)
              addCriterion("classifieritempath like ", value, "classifieritempath");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritempathNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("classifieritempath not like ", value, "classifieritempath");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritempathIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("classifieritempath in ", value, "classifieritempath");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritempathNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("classifieritempath not in ", value, "classifieritempath");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritempathBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("classifieritempath between ", value1, value2, "classifieritempath");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritempathNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("classifieritempath not between ", value1, value2, "classifieritempath");
            return (ClassifierItemCriteria) this;
        }
        
        public ClassifierItemCriteria andClassifieritemdepthIsNull() {
            addCriterion("classifieritemdepth is null");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemdepthIsNotNull() {
            addCriterion("classifieritemdepth is not null");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemdepthEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("classifieritemdepth =", value, "classifieritemdepth");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemdepthNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("classifieritemdepth <>", value, "classifieritemdepth");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemdepthGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("classifieritemdepth >", value, "classifieritemdepth");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemdepthGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("classifieritemdepth >=", value, "classifieritemdepth");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemdepthLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("classifieritemdepth <", value, "classifieritemdepth");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemdepthLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("classifieritemdepth <=", value, "classifieritemdepth");
            return (ClassifierItemCriteria) this;
        }

        
        public ClassifierItemCriteria andClassifieritemorderIsNull() {
            addCriterion("classifieritemorder is null");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemorderIsNotNull() {
            addCriterion("classifieritemorder is not null");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemorderEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("classifieritemorder =", value, "classifieritemorder");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemorderNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("classifieritemorder <>", value, "classifieritemorder");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemorderGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("classifieritemorder >", value, "classifieritemorder");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemorderGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("classifieritemorder >=", value, "classifieritemorder");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemorderLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("classifieritemorder <", value, "classifieritemorder");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemorderLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("classifieritemorder <=", value, "classifieritemorder");
            return (ClassifierItemCriteria) this;
        }

        
        public ClassifierItemCriteria andClassifieritemiattrIsNull() {
            addCriterion("classifieritemiattr is null");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemiattrIsNotNull() {
            addCriterion("classifieritemiattr is not null");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemiattrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("classifieritemiattr =", value, "classifieritemiattr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemiattrNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("classifieritemiattr <>", value, "classifieritemiattr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemiattrGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("classifieritemiattr >", value, "classifieritemiattr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemiattrGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("classifieritemiattr >=", value, "classifieritemiattr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemiattrLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("classifieritemiattr <", value, "classifieritemiattr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemiattrLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("classifieritemiattr <=", value, "classifieritemiattr");
            return (ClassifierItemCriteria) this;
        }

        
        public ClassifierItemCriteria andClassifieritemsattrIsNull() {
            addCriterion("classifieritemsattr is null");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemsattrIsNotNull() {
            addCriterion("classifieritemsattr is not null");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemsattrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("classifieritemsattr =", value, "classifieritemsattr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemsattrNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("classifieritemsattr <>", value, "classifieritemsattr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemsattrGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("classifieritemsattr >", value, "classifieritemsattr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemsattrGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("classifieritemsattr >=", value, "classifieritemsattr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemsattrLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("classifieritemsattr <", value, "classifieritemsattr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemsattrLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("classifieritemsattr <=", value, "classifieritemsattr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemsattrLike(java.lang.String value) {
            if (value != null)
              addCriterion("classifieritemsattr like ", value, "classifieritemsattr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemsattrNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("classifieritemsattr not like ", value, "classifieritemsattr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemsattrIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("classifieritemsattr in ", value, "classifieritemsattr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemsattrNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("classifieritemsattr not in ", value, "classifieritemsattr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemsattrBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("classifieritemsattr between ", value1, value2, "classifieritemsattr");
            return (ClassifierItemCriteria) this;
        }
        public ClassifierItemCriteria andClassifieritemsattrNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("classifieritemsattr not between ", value1, value2, "classifieritemsattr");
            return (ClassifierItemCriteria) this;
        }
    }
    
}

