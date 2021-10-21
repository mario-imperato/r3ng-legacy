//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.appeventlogview;

import java.util.ArrayList;
import java.util.List;

public class SailApplicationEventLogViewFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public SailApplicationEventLogViewFilter() 
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

    public SailApplicationEventLogViewCriteria or() 
    {
        SailApplicationEventLogViewCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public SailApplicationEventLogViewCriteria createCriteria() 
    {
        SailApplicationEventLogViewCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected SailApplicationEventLogViewCriteria createCriteriaInternal() 
    {
        SailApplicationEventLogViewCriteria criteria = new SailApplicationEventLogViewCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class SailApplicationEventLogViewCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public SailApplicationEventLogViewCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (SailApplicationEventLogViewCriteria) this;
        }
        
        public SailApplicationEventLogViewCriteria andUsecaseambitIsNull() {
            addCriterion("usecaseambit is null");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUsecaseambitIsNotNull() {
            addCriterion("usecaseambit is not null");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUsecaseambitEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("usecaseambit =", value, "usecaseambit");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUsecaseambitNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("usecaseambit <>", value, "usecaseambit");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUsecaseambitGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("usecaseambit >", value, "usecaseambit");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUsecaseambitGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("usecaseambit >=", value, "usecaseambit");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUsecaseambitLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("usecaseambit <", value, "usecaseambit");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUsecaseambitLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("usecaseambit <=", value, "usecaseambit");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUsecaseambitLike(java.lang.String value) {
            if (value != null)
              addCriterion("usecaseambit like ", value, "usecaseambit");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUsecaseambitNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("usecaseambit not like ", value, "usecaseambit");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUsecaseambitIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("usecaseambit in ", value, "usecaseambit");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUsecaseambitNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("usecaseambit not in ", value, "usecaseambit");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUsecaseambitBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("usecaseambit between ", value1, value2, "usecaseambit");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUsecaseambitNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("usecaseambit not between ", value1, value2, "usecaseambit");
            return (SailApplicationEventLogViewCriteria) this;
        }
        
        public SailApplicationEventLogViewCriteria andApplicationidIsNull() {
            addCriterion("applicationid is null");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andApplicationidIsNotNull() {
            addCriterion("applicationid is not null");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andApplicationidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid =", value, "applicationid");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andApplicationidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid <>", value, "applicationid");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andApplicationidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid >", value, "applicationid");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andApplicationidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid >=", value, "applicationid");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andApplicationidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid <", value, "applicationid");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andApplicationidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid <=", value, "applicationid");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andApplicationidLike(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid like ", value, "applicationid");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andApplicationidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid not like ", value, "applicationid");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andApplicationidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("applicationid in ", value, "applicationid");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andApplicationidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("applicationid not in ", value, "applicationid");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andApplicationidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("applicationid between ", value1, value2, "applicationid");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andApplicationidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("applicationid not between ", value1, value2, "applicationid");
            return (SailApplicationEventLogViewCriteria) this;
        }
        
        public SailApplicationEventLogViewCriteria andUseridIsNull() {
            addCriterion("userid is null");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUseridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid =", value, "userid");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUseridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <>", value, "userid");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUseridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid >", value, "userid");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUseridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid >=", value, "userid");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUseridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid <", value, "userid");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUseridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <=", value, "userid");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUseridLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid like ", value, "userid");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUseridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid not like ", value, "userid");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUseridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("userid in ", value, "userid");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUseridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("userid not in ", value, "userid");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUseridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid between ", value1, value2, "userid");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andUseridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid not between ", value1, value2, "userid");
            return (SailApplicationEventLogViewCriteria) this;
        }
        
        public SailApplicationEventLogViewCriteria andSailnumberIsNull() {
            addCriterion("sailnumber is null");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSailnumberIsNotNull() {
            addCriterion("sailnumber is not null");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSailnumberEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber =", value, "sailnumber");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSailnumberNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber <>", value, "sailnumber");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSailnumberGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber >", value, "sailnumber");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSailnumberGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber >=", value, "sailnumber");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSailnumberLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber <", value, "sailnumber");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSailnumberLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber <=", value, "sailnumber");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSailnumberLike(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber like ", value, "sailnumber");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSailnumberNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber not like ", value, "sailnumber");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSailnumberIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("sailnumber in ", value, "sailnumber");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSailnumberNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("sailnumber not in ", value, "sailnumber");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSailnumberBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sailnumber between ", value1, value2, "sailnumber");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andSailnumberNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sailnumber not between ", value1, value2, "sailnumber");
            return (SailApplicationEventLogViewCriteria) this;
        }
        
        public SailApplicationEventLogViewCriteria andYachtnameIsNull() {
            addCriterion("yachtname is null");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andYachtnameIsNotNull() {
            addCriterion("yachtname is not null");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andYachtnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname =", value, "yachtname");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andYachtnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname <>", value, "yachtname");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andYachtnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname >", value, "yachtname");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andYachtnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname >=", value, "yachtname");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andYachtnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname <", value, "yachtname");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andYachtnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname <=", value, "yachtname");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andYachtnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname like ", value, "yachtname");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andYachtnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname not like ", value, "yachtname");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andYachtnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("yachtname in ", value, "yachtname");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andYachtnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("yachtname not in ", value, "yachtname");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andYachtnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("yachtname between ", value1, value2, "yachtname");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andYachtnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("yachtname not between ", value1, value2, "yachtname");
            return (SailApplicationEventLogViewCriteria) this;
        }
        
        public SailApplicationEventLogViewCriteria andOwnernameIsNull() {
            addCriterion("ownername is null");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andOwnernameIsNotNull() {
            addCriterion("ownername is not null");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andOwnernameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownername =", value, "ownername");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andOwnernameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownername <>", value, "ownername");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andOwnernameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("ownername >", value, "ownername");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andOwnernameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownername >=", value, "ownername");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andOwnernameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("ownername <", value, "ownername");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andOwnernameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ownername <=", value, "ownername");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andOwnernameLike(java.lang.String value) {
            if (value != null)
              addCriterion("ownername like ", value, "ownername");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andOwnernameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("ownername not like ", value, "ownername");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andOwnernameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("ownername in ", value, "ownername");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andOwnernameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("ownername not in ", value, "ownername");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andOwnernameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ownername between ", value1, value2, "ownername");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andOwnernameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ownername not between ", value1, value2, "ownername");
            return (SailApplicationEventLogViewCriteria) this;
        }
        
        public SailApplicationEventLogViewCriteria andLatest_tsIsNull() {
            addCriterion("latest_ts is null");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andLatest_tsIsNotNull() {
            addCriterion("latest_ts is not null");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andLatest_tsEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("latest_ts =", value, "latest_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andLatest_tsNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("latest_ts <>", value, "latest_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andLatest_tsGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("latest_ts >", value, "latest_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andLatest_tsGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("latest_ts >=", value, "latest_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andLatest_tsLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("latest_ts <", value, "latest_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andLatest_tsLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("latest_ts <=", value, "latest_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }

        

        
        public SailApplicationEventLogViewCriteria andEv_general_tsIsNull() {
            addCriterion("ev_general_ts is null");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_general_tsIsNotNull() {
            addCriterion("ev_general_ts is not null");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_general_tsEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("ev_general_ts =", value, "ev_general_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_general_tsNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("ev_general_ts <>", value, "ev_general_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_general_tsGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("ev_general_ts >", value, "ev_general_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_general_tsGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("ev_general_ts >=", value, "ev_general_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_general_tsLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("ev_general_ts <", value, "ev_general_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_general_tsLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("ev_general_ts <=", value, "ev_general_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }

        

        
        public SailApplicationEventLogViewCriteria andEv_doc_tsIsNull() {
            addCriterion("ev_doc_ts is null");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_doc_tsIsNotNull() {
            addCriterion("ev_doc_ts is not null");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_doc_tsEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("ev_doc_ts =", value, "ev_doc_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_doc_tsNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("ev_doc_ts <>", value, "ev_doc_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_doc_tsGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("ev_doc_ts >", value, "ev_doc_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_doc_tsGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("ev_doc_ts >=", value, "ev_doc_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_doc_tsLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("ev_doc_ts <", value, "ev_doc_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_doc_tsLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("ev_doc_ts <=", value, "ev_doc_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }

        

        
        public SailApplicationEventLogViewCriteria andEv_crew_tsIsNull() {
            addCriterion("ev_crew_ts is null");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_crew_tsIsNotNull() {
            addCriterion("ev_crew_ts is not null");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_crew_tsEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("ev_crew_ts =", value, "ev_crew_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_crew_tsNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("ev_crew_ts <>", value, "ev_crew_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_crew_tsGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("ev_crew_ts >", value, "ev_crew_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_crew_tsGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("ev_crew_ts >=", value, "ev_crew_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_crew_tsLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("ev_crew_ts <", value, "ev_crew_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_crew_tsLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("ev_crew_ts <=", value, "ev_crew_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }

        

        
        public SailApplicationEventLogViewCriteria andEv_commit_tsIsNull() {
            addCriterion("ev_commit_ts is null");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_commit_tsIsNotNull() {
            addCriterion("ev_commit_ts is not null");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_commit_tsEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("ev_commit_ts =", value, "ev_commit_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_commit_tsNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("ev_commit_ts <>", value, "ev_commit_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_commit_tsGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("ev_commit_ts >", value, "ev_commit_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_commit_tsGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("ev_commit_ts >=", value, "ev_commit_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_commit_tsLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("ev_commit_ts <", value, "ev_commit_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }
        public SailApplicationEventLogViewCriteria andEv_commit_tsLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("ev_commit_ts <=", value, "ev_commit_ts");
            return (SailApplicationEventLogViewCriteria) this;
        }

    }
    
}

