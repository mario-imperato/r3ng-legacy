//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.attachmenttype;

import java.util.ArrayList;
import java.util.List;

public class AttachmentTypeFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public AttachmentTypeFilter() 
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

    public AttachmentTypeCriteria or() 
    {
        AttachmentTypeCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public AttachmentTypeCriteria createCriteria() 
    {
        AttachmentTypeCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected AttachmentTypeCriteria createCriteriaInternal() 
    {
        AttachmentTypeCriteria criteria = new AttachmentTypeCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class AttachmentTypeCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public AttachmentTypeCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (AttachmentTypeCriteria) this;
        }
        
        public AttachmentTypeCriteria andAttachtypeidIsNull() {
            addCriterion("attachtypeid is null");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypeidIsNotNull() {
            addCriterion("attachtypeid is not null");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypeidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("attachtypeid =", value, "attachtypeid");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypeidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("attachtypeid <>", value, "attachtypeid");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypeidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("attachtypeid >", value, "attachtypeid");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypeidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("attachtypeid >=", value, "attachtypeid");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypeidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("attachtypeid <", value, "attachtypeid");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypeidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("attachtypeid <=", value, "attachtypeid");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypeidLike(java.lang.String value) {
            if (value != null)
              addCriterion("attachtypeid like ", value, "attachtypeid");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypeidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("attachtypeid not like ", value, "attachtypeid");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypeidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("attachtypeid in ", value, "attachtypeid");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypeidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("attachtypeid not in ", value, "attachtypeid");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypeidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("attachtypeid between ", value1, value2, "attachtypeid");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypeidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("attachtypeid not between ", value1, value2, "attachtypeid");
            return (AttachmentTypeCriteria) this;
        }
        
        public AttachmentTypeCriteria andAttachtypedescrIsNull() {
            addCriterion("attachtypedescr is null");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypedescrIsNotNull() {
            addCriterion("attachtypedescr is not null");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypedescrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("attachtypedescr =", value, "attachtypedescr");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypedescrNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("attachtypedescr <>", value, "attachtypedescr");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypedescrGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("attachtypedescr >", value, "attachtypedescr");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypedescrGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("attachtypedescr >=", value, "attachtypedescr");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypedescrLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("attachtypedescr <", value, "attachtypedescr");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypedescrLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("attachtypedescr <=", value, "attachtypedescr");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypedescrLike(java.lang.String value) {
            if (value != null)
              addCriterion("attachtypedescr like ", value, "attachtypedescr");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypedescrNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("attachtypedescr not like ", value, "attachtypedescr");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypedescrIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("attachtypedescr in ", value, "attachtypedescr");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypedescrNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("attachtypedescr not in ", value, "attachtypedescr");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypedescrBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("attachtypedescr between ", value1, value2, "attachtypedescr");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachtypedescrNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("attachtypedescr not between ", value1, value2, "attachtypedescr");
            return (AttachmentTypeCriteria) this;
        }
        
        public AttachmentTypeCriteria andContenttypeIsNull() {
            addCriterion("contenttype is null");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andContenttypeIsNotNull() {
            addCriterion("contenttype is not null");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andContenttypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype =", value, "contenttype");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andContenttypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype <>", value, "contenttype");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andContenttypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype >", value, "contenttype");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andContenttypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype >=", value, "contenttype");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andContenttypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype <", value, "contenttype");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andContenttypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype <=", value, "contenttype");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andContenttypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype like ", value, "contenttype");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andContenttypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("contenttype not like ", value, "contenttype");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andContenttypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("contenttype in ", value, "contenttype");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andContenttypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("contenttype not in ", value, "contenttype");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andContenttypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("contenttype between ", value1, value2, "contenttype");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andContenttypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("contenttype not between ", value1, value2, "contenttype");
            return (AttachmentTypeCriteria) this;
        }
        
        public AttachmentTypeCriteria andImagescalingIsNull() {
            addCriterion("imagescaling is null");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andImagescalingIsNotNull() {
            addCriterion("imagescaling is not null");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andImagescalingEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("imagescaling =", value, "imagescaling");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andImagescalingNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("imagescaling <>", value, "imagescaling");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andImagescalingGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("imagescaling >", value, "imagescaling");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andImagescalingGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("imagescaling >=", value, "imagescaling");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andImagescalingLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("imagescaling <", value, "imagescaling");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andImagescalingLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("imagescaling <=", value, "imagescaling");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andImagescalingLike(java.lang.String value) {
            if (value != null)
              addCriterion("imagescaling like ", value, "imagescaling");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andImagescalingNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("imagescaling not like ", value, "imagescaling");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andImagescalingIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("imagescaling in ", value, "imagescaling");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andImagescalingNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("imagescaling not in ", value, "imagescaling");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andImagescalingBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("imagescaling between ", value1, value2, "imagescaling");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andImagescalingNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("imagescaling not between ", value1, value2, "imagescaling");
            return (AttachmentTypeCriteria) this;
        }
        
        public AttachmentTypeCriteria andIconscalingIsNull() {
            addCriterion("iconscaling is null");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andIconscalingIsNotNull() {
            addCriterion("iconscaling is not null");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andIconscalingEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("iconscaling =", value, "iconscaling");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andIconscalingNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("iconscaling <>", value, "iconscaling");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andIconscalingGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("iconscaling >", value, "iconscaling");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andIconscalingGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("iconscaling >=", value, "iconscaling");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andIconscalingLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("iconscaling <", value, "iconscaling");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andIconscalingLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("iconscaling <=", value, "iconscaling");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andIconscalingLike(java.lang.String value) {
            if (value != null)
              addCriterion("iconscaling like ", value, "iconscaling");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andIconscalingNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("iconscaling not like ", value, "iconscaling");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andIconscalingIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("iconscaling in ", value, "iconscaling");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andIconscalingNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("iconscaling not in ", value, "iconscaling");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andIconscalingBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("iconscaling between ", value1, value2, "iconscaling");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andIconscalingNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("iconscaling not between ", value1, value2, "iconscaling");
            return (AttachmentTypeCriteria) this;
        }
        
        public AttachmentTypeCriteria andPropertyroleIsNull() {
            addCriterion("propertyrole is null");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andPropertyroleIsNotNull() {
            addCriterion("propertyrole is not null");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andPropertyroleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole =", value, "propertyrole");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andPropertyroleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole <>", value, "propertyrole");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andPropertyroleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole >", value, "propertyrole");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andPropertyroleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole >=", value, "propertyrole");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andPropertyroleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole <", value, "propertyrole");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andPropertyroleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole <=", value, "propertyrole");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andPropertyroleLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole like ", value, "propertyrole");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andPropertyroleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("propertyrole not like ", value, "propertyrole");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andPropertyroleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("propertyrole in ", value, "propertyrole");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andPropertyroleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("propertyrole not in ", value, "propertyrole");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andPropertyroleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyrole between ", value1, value2, "propertyrole");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andPropertyroleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("propertyrole not between ", value1, value2, "propertyrole");
            return (AttachmentTypeCriteria) this;
        }
        
        public AttachmentTypeCriteria andAttachscopeIsNull() {
            addCriterion("attachscope is null");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachscopeIsNotNull() {
            addCriterion("attachscope is not null");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachscopeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("attachscope =", value, "attachscope");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachscopeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("attachscope <>", value, "attachscope");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachscopeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("attachscope >", value, "attachscope");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachscopeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("attachscope >=", value, "attachscope");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachscopeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("attachscope <", value, "attachscope");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachscopeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("attachscope <=", value, "attachscope");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachscopeLike(java.lang.String value) {
            if (value != null)
              addCriterion("attachscope like ", value, "attachscope");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachscopeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("attachscope not like ", value, "attachscope");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachscopeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("attachscope in ", value, "attachscope");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachscopeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("attachscope not in ", value, "attachscope");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachscopeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("attachscope between ", value1, value2, "attachscope");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andAttachscopeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("attachscope not between ", value1, value2, "attachscope");
            return (AttachmentTypeCriteria) this;
        }
        
        public AttachmentTypeCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (AttachmentTypeCriteria) this;
        }
        public AttachmentTypeCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (AttachmentTypeCriteria) this;
        }

    }
    
}

