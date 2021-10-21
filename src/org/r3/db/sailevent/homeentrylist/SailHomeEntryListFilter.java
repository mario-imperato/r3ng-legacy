//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.homeentrylist;

import java.util.ArrayList;
import java.util.List;

public class SailHomeEntryListFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public SailHomeEntryListFilter() 
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

    public SailHomeEntryListCriteria or() 
    {
        SailHomeEntryListCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public SailHomeEntryListCriteria createCriteria() 
    {
        SailHomeEntryListCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected SailHomeEntryListCriteria createCriteriaInternal() 
    {
        SailHomeEntryListCriteria criteria = new SailHomeEntryListCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class SailHomeEntryListCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public SailHomeEntryListCriteria andEventidIsNull() {
            addCriterion("eventid is null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andEventidIsNotNull() {
            addCriterion("eventid is not null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andEventidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid =", value, "eventid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andEventidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <>", value, "eventid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andEventidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >", value, "eventid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andEventidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >=", value, "eventid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andEventidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <", value, "eventid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andEventidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <=", value, "eventid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andEventidLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid like ", value, "eventid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andEventidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid not like ", value, "eventid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andEventidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("eventid in ", value, "eventid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andEventidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("eventid not in ", value, "eventid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andEventidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid between ", value1, value2, "eventid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andEventidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid not between ", value1, value2, "eventid");
            return (SailHomeEntryListCriteria) this;
        }
        
        public SailHomeEntryListCriteria andApplicationidIsNull() {
            addCriterion("applicationid is null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andApplicationidIsNotNull() {
            addCriterion("applicationid is not null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andApplicationidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid =", value, "applicationid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andApplicationidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid <>", value, "applicationid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andApplicationidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid >", value, "applicationid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andApplicationidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid >=", value, "applicationid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andApplicationidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid <", value, "applicationid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andApplicationidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid <=", value, "applicationid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andApplicationidLike(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid like ", value, "applicationid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andApplicationidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid not like ", value, "applicationid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andApplicationidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("applicationid in ", value, "applicationid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andApplicationidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("applicationid not in ", value, "applicationid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andApplicationidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("applicationid between ", value1, value2, "applicationid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andApplicationidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("applicationid not between ", value1, value2, "applicationid");
            return (SailHomeEntryListCriteria) this;
        }
        
        public SailHomeEntryListCriteria andUseridIsNull() {
            addCriterion("userid is null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andUseridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid =", value, "userid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andUseridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <>", value, "userid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andUseridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid >", value, "userid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andUseridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid >=", value, "userid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andUseridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid <", value, "userid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andUseridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <=", value, "userid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andUseridLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid like ", value, "userid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andUseridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid not like ", value, "userid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andUseridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("userid in ", value, "userid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andUseridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("userid not in ", value, "userid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andUseridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid between ", value1, value2, "userid");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andUseridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid not between ", value1, value2, "userid");
            return (SailHomeEntryListCriteria) this;
        }
        
        public SailHomeEntryListCriteria andSailnumberIsNull() {
            addCriterion("sailnumber is null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andSailnumberIsNotNull() {
            addCriterion("sailnumber is not null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andSailnumberEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber =", value, "sailnumber");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andSailnumberNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber <>", value, "sailnumber");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andSailnumberGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber >", value, "sailnumber");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andSailnumberGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber >=", value, "sailnumber");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andSailnumberLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber <", value, "sailnumber");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andSailnumberLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber <=", value, "sailnumber");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andSailnumberLike(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber like ", value, "sailnumber");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andSailnumberNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber not like ", value, "sailnumber");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andSailnumberIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("sailnumber in ", value, "sailnumber");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andSailnumberNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("sailnumber not in ", value, "sailnumber");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andSailnumberBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sailnumber between ", value1, value2, "sailnumber");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andSailnumberNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sailnumber not between ", value1, value2, "sailnumber");
            return (SailHomeEntryListCriteria) this;
        }
        
        public SailHomeEntryListCriteria andYachtnameIsNull() {
            addCriterion("yachtname is null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachtnameIsNotNull() {
            addCriterion("yachtname is not null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachtnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname =", value, "yachtname");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachtnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname <>", value, "yachtname");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachtnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname >", value, "yachtname");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachtnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname >=", value, "yachtname");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachtnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname <", value, "yachtname");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachtnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname <=", value, "yachtname");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachtnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname like ", value, "yachtname");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachtnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname not like ", value, "yachtname");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachtnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("yachtname in ", value, "yachtname");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachtnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("yachtname not in ", value, "yachtname");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachtnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("yachtname between ", value1, value2, "yachtname");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachtnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("yachtname not between ", value1, value2, "yachtname");
            return (SailHomeEntryListCriteria) this;
        }
        
        public SailHomeEntryListCriteria andYachttypeIsNull() {
            addCriterion("yachttype is null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachttypeIsNotNull() {
            addCriterion("yachttype is not null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachttypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachttype =", value, "yachttype");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachttypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachttype <>", value, "yachttype");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachttypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("yachttype >", value, "yachttype");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachttypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachttype >=", value, "yachttype");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachttypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("yachttype <", value, "yachttype");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachttypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachttype <=", value, "yachttype");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachttypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("yachttype like ", value, "yachttype");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachttypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("yachttype not like ", value, "yachttype");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachttypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("yachttype in ", value, "yachttype");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachttypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("yachttype not in ", value, "yachttype");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachttypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("yachttype between ", value1, value2, "yachttype");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andYachttypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("yachttype not between ", value1, value2, "yachttype");
            return (SailHomeEntryListCriteria) this;
        }
        
        public SailHomeEntryListCriteria andBoatimageurlIsNull() {
            addCriterion("boatimageurl is null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimageurlIsNotNull() {
            addCriterion("boatimageurl is not null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimageurlEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("boatimageurl =", value, "boatimageurl");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimageurlNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("boatimageurl <>", value, "boatimageurl");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimageurlGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("boatimageurl >", value, "boatimageurl");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimageurlGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("boatimageurl >=", value, "boatimageurl");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimageurlLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("boatimageurl <", value, "boatimageurl");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimageurlLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("boatimageurl <=", value, "boatimageurl");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimageurlLike(java.lang.String value) {
            if (value != null)
              addCriterion("boatimageurl like ", value, "boatimageurl");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimageurlNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("boatimageurl not like ", value, "boatimageurl");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimageurlIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("boatimageurl in ", value, "boatimageurl");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimageurlNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("boatimageurl not in ", value, "boatimageurl");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimageurlBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("boatimageurl between ", value1, value2, "boatimageurl");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimageurlNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("boatimageurl not between ", value1, value2, "boatimageurl");
            return (SailHomeEntryListCriteria) this;
        }
        
        public SailHomeEntryListCriteria andBoatimageheightIsNull() {
            addCriterion("boatimageheight is null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimageheightIsNotNull() {
            addCriterion("boatimageheight is not null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimageheightEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boatimageheight =", value, "boatimageheight");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimageheightNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boatimageheight <>", value, "boatimageheight");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimageheightGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("boatimageheight >", value, "boatimageheight");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimageheightGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boatimageheight >=", value, "boatimageheight");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimageheightLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("boatimageheight <", value, "boatimageheight");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimageheightLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boatimageheight <=", value, "boatimageheight");
            return (SailHomeEntryListCriteria) this;
        }

        
        public SailHomeEntryListCriteria andBoatimagewidthIsNull() {
            addCriterion("boatimagewidth is null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimagewidthIsNotNull() {
            addCriterion("boatimagewidth is not null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimagewidthEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boatimagewidth =", value, "boatimagewidth");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimagewidthNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boatimagewidth <>", value, "boatimagewidth");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimagewidthGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("boatimagewidth >", value, "boatimagewidth");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimagewidthGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boatimagewidth >=", value, "boatimagewidth");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimagewidthLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("boatimagewidth <", value, "boatimagewidth");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoatimagewidthLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boatimagewidth <=", value, "boatimagewidth");
            return (SailHomeEntryListCriteria) this;
        }

        
        public SailHomeEntryListCriteria andBoaticonurlIsNull() {
            addCriterion("boaticonurl is null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonurlIsNotNull() {
            addCriterion("boaticonurl is not null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonurlEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("boaticonurl =", value, "boaticonurl");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonurlNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("boaticonurl <>", value, "boaticonurl");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonurlGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("boaticonurl >", value, "boaticonurl");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonurlGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("boaticonurl >=", value, "boaticonurl");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonurlLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("boaticonurl <", value, "boaticonurl");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonurlLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("boaticonurl <=", value, "boaticonurl");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonurlLike(java.lang.String value) {
            if (value != null)
              addCriterion("boaticonurl like ", value, "boaticonurl");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonurlNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("boaticonurl not like ", value, "boaticonurl");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonurlIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("boaticonurl in ", value, "boaticonurl");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonurlNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("boaticonurl not in ", value, "boaticonurl");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonurlBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("boaticonurl between ", value1, value2, "boaticonurl");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonurlNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("boaticonurl not between ", value1, value2, "boaticonurl");
            return (SailHomeEntryListCriteria) this;
        }
        
        public SailHomeEntryListCriteria andBoaticonwidthIsNull() {
            addCriterion("boaticonwidth is null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonwidthIsNotNull() {
            addCriterion("boaticonwidth is not null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonwidthEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boaticonwidth =", value, "boaticonwidth");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonwidthNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boaticonwidth <>", value, "boaticonwidth");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonwidthGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("boaticonwidth >", value, "boaticonwidth");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonwidthGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boaticonwidth >=", value, "boaticonwidth");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonwidthLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("boaticonwidth <", value, "boaticonwidth");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonwidthLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boaticonwidth <=", value, "boaticonwidth");
            return (SailHomeEntryListCriteria) this;
        }

        
        public SailHomeEntryListCriteria andBoaticonheightIsNull() {
            addCriterion("boaticonheight is null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonheightIsNotNull() {
            addCriterion("boaticonheight is not null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonheightEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boaticonheight =", value, "boaticonheight");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonheightNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boaticonheight <>", value, "boaticonheight");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonheightGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("boaticonheight >", value, "boaticonheight");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonheightGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boaticonheight >=", value, "boaticonheight");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonheightLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("boaticonheight <", value, "boaticonheight");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andBoaticonheightLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("boaticonheight <=", value, "boaticonheight");
            return (SailHomeEntryListCriteria) this;
        }

        
        public SailHomeEntryListCriteria andAddtohomeentrylistIsNull() {
            addCriterion("addtohomeentrylist is null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andAddtohomeentrylistIsNotNull() {
            addCriterion("addtohomeentrylist is not null");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andAddtohomeentrylistEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("addtohomeentrylist =", value, "addtohomeentrylist");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andAddtohomeentrylistNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("addtohomeentrylist <>", value, "addtohomeentrylist");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andAddtohomeentrylistGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("addtohomeentrylist >", value, "addtohomeentrylist");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andAddtohomeentrylistGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("addtohomeentrylist >=", value, "addtohomeentrylist");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andAddtohomeentrylistLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("addtohomeentrylist <", value, "addtohomeentrylist");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andAddtohomeentrylistLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("addtohomeentrylist <=", value, "addtohomeentrylist");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andAddtohomeentrylistLike(java.lang.String value) {
            if (value != null)
              addCriterion("addtohomeentrylist like ", value, "addtohomeentrylist");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andAddtohomeentrylistNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("addtohomeentrylist not like ", value, "addtohomeentrylist");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andAddtohomeentrylistIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("addtohomeentrylist in ", value, "addtohomeentrylist");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andAddtohomeentrylistNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("addtohomeentrylist not in ", value, "addtohomeentrylist");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andAddtohomeentrylistBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("addtohomeentrylist between ", value1, value2, "addtohomeentrylist");
            return (SailHomeEntryListCriteria) this;
        }
        public SailHomeEntryListCriteria andAddtohomeentrylistNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("addtohomeentrylist not between ", value1, value2, "addtohomeentrylist");
            return (SailHomeEntryListCriteria) this;
        }
    }
    
}

