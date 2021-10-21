//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.resource;

import java.util.ArrayList;
import java.util.List;

public class ResourceFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public ResourceFilter() 
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

    public ResourceCriteria or() 
    {
        ResourceCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public ResourceCriteria createCriteria() 
    {
        ResourceCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected ResourceCriteria createCriteriaInternal() 
    {
        ResourceCriteria criteria = new ResourceCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class ResourceCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public ResourceCriteria andResourceidIsNull() {
            addCriterion("resourceid is null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourceidIsNotNull() {
            addCriterion("resourceid is not null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourceidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid =", value, "resourceid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourceidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid <>", value, "resourceid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourceidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid >", value, "resourceid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourceidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid >=", value, "resourceid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourceidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid <", value, "resourceid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourceidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid <=", value, "resourceid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourceidLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid like ", value, "resourceid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourceidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid not like ", value, "resourceid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourceidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("resourceid in ", value, "resourceid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourceidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("resourceid not in ", value, "resourceid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourceidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourceid between ", value1, value2, "resourceid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourceidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourceid not between ", value1, value2, "resourceid");
            return (ResourceCriteria) this;
        }
        
        public ResourceCriteria andResourcetypeIsNull() {
            addCriterion("resourcetype is null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcetypeIsNotNull() {
            addCriterion("resourcetype is not null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcetypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcetype =", value, "resourcetype");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcetypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcetype <>", value, "resourcetype");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcetypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourcetype >", value, "resourcetype");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcetypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcetype >=", value, "resourcetype");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcetypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourcetype <", value, "resourcetype");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcetypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcetype <=", value, "resourcetype");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcetypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourcetype like ", value, "resourcetype");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcetypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourcetype not like ", value, "resourcetype");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcetypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("resourcetype in ", value, "resourcetype");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcetypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("resourcetype not in ", value, "resourcetype");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcetypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourcetype between ", value1, value2, "resourcetype");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcetypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourcetype not between ", value1, value2, "resourcetype");
            return (ResourceCriteria) this;
        }
        
        public ResourceCriteria andResourcedescrIsNull() {
            addCriterion("resourcedescr is null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcedescrIsNotNull() {
            addCriterion("resourcedescr is not null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcedescrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedescr =", value, "resourcedescr");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcedescrNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedescr <>", value, "resourcedescr");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcedescrGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedescr >", value, "resourcedescr");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcedescrGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedescr >=", value, "resourcedescr");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcedescrLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedescr <", value, "resourcedescr");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcedescrLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedescr <=", value, "resourcedescr");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcedescrLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedescr like ", value, "resourcedescr");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcedescrNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedescr not like ", value, "resourcedescr");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcedescrIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("resourcedescr in ", value, "resourcedescr");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcedescrNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("resourcedescr not in ", value, "resourcedescr");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcedescrBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourcedescr between ", value1, value2, "resourcedescr");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcedescrNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourcedescr not between ", value1, value2, "resourcedescr");
            return (ResourceCriteria) this;
        }
        
        public ResourceCriteria andSitedomainIsNull() {
            addCriterion("sitedomain is null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSitedomainIsNotNull() {
            addCriterion("sitedomain is not null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSitedomainEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sitedomain =", value, "sitedomain");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSitedomainNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sitedomain <>", value, "sitedomain");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSitedomainGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("sitedomain >", value, "sitedomain");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSitedomainGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sitedomain >=", value, "sitedomain");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSitedomainLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("sitedomain <", value, "sitedomain");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSitedomainLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sitedomain <=", value, "sitedomain");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSitedomainLike(java.lang.String value) {
            if (value != null)
              addCriterion("sitedomain like ", value, "sitedomain");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSitedomainNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("sitedomain not like ", value, "sitedomain");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSitedomainIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("sitedomain in ", value, "sitedomain");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSitedomainNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("sitedomain not in ", value, "sitedomain");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSitedomainBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sitedomain between ", value1, value2, "sitedomain");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSitedomainNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sitedomain not between ", value1, value2, "sitedomain");
            return (ResourceCriteria) this;
        }
        
        public ResourceCriteria andUseridIsNull() {
            addCriterion("userid is null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andUseridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid =", value, "userid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andUseridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <>", value, "userid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andUseridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid >", value, "userid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andUseridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid >=", value, "userid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andUseridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid <", value, "userid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andUseridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <=", value, "userid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andUseridLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid like ", value, "userid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andUseridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid not like ", value, "userid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andUseridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("userid in ", value, "userid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andUseridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("userid not in ", value, "userid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andUseridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid between ", value1, value2, "userid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andUseridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid not between ", value1, value2, "userid");
            return (ResourceCriteria) this;
        }
        
        public ResourceCriteria andFirstnameIsNull() {
            addCriterion("firstname is null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andFirstnameIsNotNull() {
            addCriterion("firstname is not null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andFirstnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("firstname =", value, "firstname");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andFirstnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("firstname <>", value, "firstname");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andFirstnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("firstname >", value, "firstname");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andFirstnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("firstname >=", value, "firstname");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andFirstnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("firstname <", value, "firstname");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andFirstnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("firstname <=", value, "firstname");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andFirstnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("firstname like ", value, "firstname");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andFirstnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("firstname not like ", value, "firstname");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andFirstnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("firstname in ", value, "firstname");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andFirstnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("firstname not in ", value, "firstname");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andFirstnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("firstname between ", value1, value2, "firstname");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andFirstnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("firstname not between ", value1, value2, "firstname");
            return (ResourceCriteria) this;
        }
        
        public ResourceCriteria andLastnameIsNull() {
            addCriterion("lastname is null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andLastnameIsNotNull() {
            addCriterion("lastname is not null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andLastnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lastname =", value, "lastname");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andLastnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lastname <>", value, "lastname");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andLastnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("lastname >", value, "lastname");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andLastnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lastname >=", value, "lastname");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andLastnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("lastname <", value, "lastname");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andLastnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lastname <=", value, "lastname");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andLastnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("lastname like ", value, "lastname");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andLastnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("lastname not like ", value, "lastname");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andLastnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("lastname in ", value, "lastname");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andLastnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("lastname not in ", value, "lastname");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andLastnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("lastname between ", value1, value2, "lastname");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andLastnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("lastname not between ", value1, value2, "lastname");
            return (ResourceCriteria) this;
        }
        
        public ResourceCriteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andPhoneEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phone =", value, "phone");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andPhoneNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phone <>", value, "phone");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andPhoneGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("phone >", value, "phone");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andPhoneGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phone >=", value, "phone");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andPhoneLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("phone <", value, "phone");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andPhoneLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("phone <=", value, "phone");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andPhoneLike(java.lang.String value) {
            if (value != null)
              addCriterion("phone like ", value, "phone");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andPhoneNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("phone not like ", value, "phone");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andPhoneIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("phone in ", value, "phone");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andPhoneNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("phone not in ", value, "phone");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andPhoneBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("phone between ", value1, value2, "phone");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andPhoneNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("phone not between ", value1, value2, "phone");
            return (ResourceCriteria) this;
        }
        
        public ResourceCriteria andCellphoneIsNull() {
            addCriterion("cellphone is null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andCellphoneIsNotNull() {
            addCriterion("cellphone is not null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andCellphoneEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cellphone =", value, "cellphone");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andCellphoneNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cellphone <>", value, "cellphone");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andCellphoneGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("cellphone >", value, "cellphone");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andCellphoneGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cellphone >=", value, "cellphone");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andCellphoneLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("cellphone <", value, "cellphone");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andCellphoneLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cellphone <=", value, "cellphone");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andCellphoneLike(java.lang.String value) {
            if (value != null)
              addCriterion("cellphone like ", value, "cellphone");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andCellphoneNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("cellphone not like ", value, "cellphone");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andCellphoneIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("cellphone in ", value, "cellphone");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andCellphoneNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("cellphone not in ", value, "cellphone");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andCellphoneBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cellphone between ", value1, value2, "cellphone");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andCellphoneNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cellphone not between ", value1, value2, "cellphone");
            return (ResourceCriteria) this;
        }
        
        public ResourceCriteria andEmailIsNull() {
            addCriterion("email is null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andEmailEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("email =", value, "email");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andEmailNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("email <>", value, "email");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andEmailGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("email >", value, "email");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andEmailGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("email >=", value, "email");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andEmailLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("email <", value, "email");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andEmailLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("email <=", value, "email");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andEmailLike(java.lang.String value) {
            if (value != null)
              addCriterion("email like ", value, "email");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andEmailNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("email not like ", value, "email");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andEmailIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("email in ", value, "email");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andEmailNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("email not in ", value, "email");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andEmailBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("email between ", value1, value2, "email");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andEmailNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("email not between ", value1, value2, "email");
            return (ResourceCriteria) this;
        }
        
        public ResourceCriteria andAddressIsNull() {
            addCriterion("address is null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andAddressEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("address =", value, "address");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andAddressNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("address <>", value, "address");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andAddressGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("address >", value, "address");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andAddressGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("address >=", value, "address");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andAddressLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("address <", value, "address");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andAddressLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("address <=", value, "address");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andAddressLike(java.lang.String value) {
            if (value != null)
              addCriterion("address like ", value, "address");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andAddressNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("address not like ", value, "address");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andAddressIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("address in ", value, "address");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andAddressNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("address not in ", value, "address");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andAddressBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("address between ", value1, value2, "address");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andAddressNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("address not between ", value1, value2, "address");
            return (ResourceCriteria) this;
        }
        
        public ResourceCriteria andTownIsNull() {
            addCriterion("town is null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andTownIsNotNull() {
            addCriterion("town is not null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andTownEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("town =", value, "town");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andTownNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("town <>", value, "town");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andTownGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("town >", value, "town");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andTownGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("town >=", value, "town");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andTownLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("town <", value, "town");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andTownLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("town <=", value, "town");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andTownLike(java.lang.String value) {
            if (value != null)
              addCriterion("town like ", value, "town");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andTownNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("town not like ", value, "town");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andTownIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("town in ", value, "town");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andTownNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("town not in ", value, "town");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andTownBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("town between ", value1, value2, "town");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andTownNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("town not between ", value1, value2, "town");
            return (ResourceCriteria) this;
        }
        
        public ResourceCriteria andZipcodeIsNull() {
            addCriterion("zipcode is null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andZipcodeIsNotNull() {
            addCriterion("zipcode is not null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andZipcodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode =", value, "zipcode");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andZipcodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode <>", value, "zipcode");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andZipcodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode >", value, "zipcode");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andZipcodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode >=", value, "zipcode");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andZipcodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode <", value, "zipcode");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andZipcodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode <=", value, "zipcode");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andZipcodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode like ", value, "zipcode");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andZipcodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("zipcode not like ", value, "zipcode");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andZipcodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("zipcode in ", value, "zipcode");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andZipcodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("zipcode not in ", value, "zipcode");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andZipcodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("zipcode between ", value1, value2, "zipcode");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andZipcodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("zipcode not between ", value1, value2, "zipcode");
            return (ResourceCriteria) this;
        }
        
        public ResourceCriteria andSsnIsNull() {
            addCriterion("ssn is null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSsnIsNotNull() {
            addCriterion("ssn is not null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSsnEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ssn =", value, "ssn");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSsnNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ssn <>", value, "ssn");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSsnGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("ssn >", value, "ssn");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSsnGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ssn >=", value, "ssn");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSsnLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("ssn <", value, "ssn");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSsnLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ssn <=", value, "ssn");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSsnLike(java.lang.String value) {
            if (value != null)
              addCriterion("ssn like ", value, "ssn");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSsnNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("ssn not like ", value, "ssn");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSsnIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("ssn in ", value, "ssn");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSsnNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("ssn not in ", value, "ssn");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSsnBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ssn between ", value1, value2, "ssn");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSsnNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ssn not between ", value1, value2, "ssn");
            return (ResourceCriteria) this;
        }
        
        public ResourceCriteria andSexIsNull() {
            addCriterion("sex is null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSexEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sex =", value, "sex");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSexNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sex <>", value, "sex");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSexGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("sex >", value, "sex");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSexGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sex >=", value, "sex");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSexLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("sex <", value, "sex");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSexLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sex <=", value, "sex");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSexLike(java.lang.String value) {
            if (value != null)
              addCriterion("sex like ", value, "sex");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSexNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("sex not like ", value, "sex");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSexIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("sex in ", value, "sex");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSexNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("sex not in ", value, "sex");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSexBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sex between ", value1, value2, "sex");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andSexNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sex not between ", value1, value2, "sex");
            return (ResourceCriteria) this;
        }
        
        public ResourceCriteria andBirthdateIsNull() {
            addCriterion("birthdate is null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthdateIsNotNull() {
            addCriterion("birthdate is not null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthdateEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("birthdate =", value, "birthdate");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthdateNotEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("birthdate <>", value, "birthdate");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthdateGreaterThan(java.sql.Date value) {
            if (value != null)
              addCriterion("birthdate >", value, "birthdate");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthdateGreaterThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("birthdate >=", value, "birthdate");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthdateLessThan(java.sql.Date value) {
            if (value != null)
              addCriterion("birthdate <", value, "birthdate");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthdateLessThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("birthdate <=", value, "birthdate");
            return (ResourceCriteria) this;
        }

        
        public ResourceCriteria andBirthtownIsNull() {
            addCriterion("birthtown is null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthtownIsNotNull() {
            addCriterion("birthtown is not null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthtownEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("birthtown =", value, "birthtown");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthtownNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("birthtown <>", value, "birthtown");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthtownGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("birthtown >", value, "birthtown");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthtownGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("birthtown >=", value, "birthtown");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthtownLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("birthtown <", value, "birthtown");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthtownLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("birthtown <=", value, "birthtown");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthtownLike(java.lang.String value) {
            if (value != null)
              addCriterion("birthtown like ", value, "birthtown");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthtownNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("birthtown not like ", value, "birthtown");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthtownIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("birthtown in ", value, "birthtown");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthtownNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("birthtown not in ", value, "birthtown");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthtownBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("birthtown between ", value1, value2, "birthtown");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthtownNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("birthtown not between ", value1, value2, "birthtown");
            return (ResourceCriteria) this;
        }
        
        public ResourceCriteria andBirthdistrictIsNull() {
            addCriterion("birthdistrict is null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthdistrictIsNotNull() {
            addCriterion("birthdistrict is not null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthdistrictEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("birthdistrict =", value, "birthdistrict");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthdistrictNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("birthdistrict <>", value, "birthdistrict");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthdistrictGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("birthdistrict >", value, "birthdistrict");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthdistrictGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("birthdistrict >=", value, "birthdistrict");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthdistrictLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("birthdistrict <", value, "birthdistrict");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthdistrictLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("birthdistrict <=", value, "birthdistrict");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthdistrictLike(java.lang.String value) {
            if (value != null)
              addCriterion("birthdistrict like ", value, "birthdistrict");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthdistrictNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("birthdistrict not like ", value, "birthdistrict");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthdistrictIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("birthdistrict in ", value, "birthdistrict");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthdistrictNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("birthdistrict not in ", value, "birthdistrict");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthdistrictBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("birthdistrict between ", value1, value2, "birthdistrict");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andBirthdistrictNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("birthdistrict not between ", value1, value2, "birthdistrict");
            return (ResourceCriteria) this;
        }
        
        public ResourceCriteria andResourcecardidIsNull() {
            addCriterion("resourcecardid is null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcecardidIsNotNull() {
            addCriterion("resourcecardid is not null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcecardidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcecardid =", value, "resourcecardid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcecardidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcecardid <>", value, "resourcecardid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcecardidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourcecardid >", value, "resourcecardid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcecardidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcecardid >=", value, "resourcecardid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcecardidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourcecardid <", value, "resourcecardid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcecardidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcecardid <=", value, "resourcecardid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcecardidLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourcecardid like ", value, "resourcecardid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcecardidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourcecardid not like ", value, "resourcecardid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcecardidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("resourcecardid in ", value, "resourcecardid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcecardidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("resourcecardid not in ", value, "resourcecardid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcecardidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourcecardid between ", value1, value2, "resourcecardid");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andResourcecardidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourcecardid not between ", value1, value2, "resourcecardid");
            return (ResourceCriteria) this;
        }
        
        public ResourceCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (ResourceCriteria) this;
        }
        
        public ResourceCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (ResourceCriteria) this;
        }
        public ResourceCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (ResourceCriteria) this;
        }

    }
    
}

