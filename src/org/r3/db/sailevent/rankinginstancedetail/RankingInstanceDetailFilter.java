//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.rankinginstancedetail;

import java.util.ArrayList;
import java.util.List;

public class RankingInstanceDetailFilter{
    protected String orderByClause;
    protected String  groupByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public RankingInstanceDetailFilter() 
    {
        oredCriteria = new ArrayList<org.r3.db.utils.Criteria>();
        limitFetch = 0;
        groupByClause = null;
    }
    
    public String getGroupByClause()
	  {
	  	return groupByClause;
	  }
    
	  public void setGroupByClause(String groupByClause)
	  {
	  	this.groupByClause = groupByClause;
	  }
	
	  public boolean isGroupBy(String aColumnName)
	  {
	  	return groupByClause != null && groupByClause.indexOf(aColumnName) >= 0;
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

    public RankingInstanceDetailCriteria or() 
    {
        RankingInstanceDetailCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public RankingInstanceDetailCriteria createCriteria() 
    {
        RankingInstanceDetailCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected RankingInstanceDetailCriteria createCriteriaInternal() 
    {
        RankingInstanceDetailCriteria criteria = new RankingInstanceDetailCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class RankingInstanceDetailCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public RankingInstanceDetailCriteria andRankentryidIsNull() {
            addCriterion("rankentryid is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRankentryidIsNotNull() {
            addCriterion("rankentryid is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRankentryidEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("rankentryid =", value, "rankentryid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRankentryidNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("rankentryid <>", value, "rankentryid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRankentryidGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("rankentryid >", value, "rankentryid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRankentryidGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("rankentryid >=", value, "rankentryid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRankentryidLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("rankentryid <", value, "rankentryid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRankentryidLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("rankentryid <=", value, "rankentryid");
            return (RankingInstanceDetailCriteria) this;
        }

        
        public RankingInstanceDetailCriteria andEventidIsNull() {
            addCriterion("eventid is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andEventidIsNotNull() {
            addCriterion("eventid is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andEventidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid =", value, "eventid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andEventidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <>", value, "eventid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andEventidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >", value, "eventid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andEventidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >=", value, "eventid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andEventidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <", value, "eventid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andEventidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <=", value, "eventid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andEventidLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid like ", value, "eventid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andEventidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid not like ", value, "eventid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andEventidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("eventid in ", value, "eventid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andEventidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("eventid not in ", value, "eventid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andEventidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid between ", value1, value2, "eventid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andEventidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid not between ", value1, value2, "eventid");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andInstanceidIsNull() {
            addCriterion("instanceid is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andInstanceidIsNotNull() {
            addCriterion("instanceid is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andInstanceidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid =", value, "instanceid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andInstanceidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid <>", value, "instanceid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andInstanceidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid >", value, "instanceid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andInstanceidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid >=", value, "instanceid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andInstanceidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid <", value, "instanceid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andInstanceidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid <=", value, "instanceid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andInstanceidLike(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid like ", value, "instanceid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andInstanceidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid not like ", value, "instanceid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andInstanceidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("instanceid in ", value, "instanceid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andInstanceidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("instanceid not in ", value, "instanceid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andInstanceidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("instanceid between ", value1, value2, "instanceid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andInstanceidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("instanceid not between ", value1, value2, "instanceid");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andApplicationidIsNull() {
            addCriterion("applicationid is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andApplicationidIsNotNull() {
            addCriterion("applicationid is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andApplicationidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid =", value, "applicationid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andApplicationidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid <>", value, "applicationid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andApplicationidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid >", value, "applicationid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andApplicationidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid >=", value, "applicationid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andApplicationidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid <", value, "applicationid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andApplicationidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid <=", value, "applicationid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andApplicationidLike(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid like ", value, "applicationid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andApplicationidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid not like ", value, "applicationid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andApplicationidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("applicationid in ", value, "applicationid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andApplicationidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("applicationid not in ", value, "applicationid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andApplicationidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("applicationid between ", value1, value2, "applicationid");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andApplicationidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("applicationid not between ", value1, value2, "applicationid");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andPosIsNull() {
            addCriterion("pos is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andPosIsNotNull() {
            addCriterion("pos is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andPosEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("pos =", value, "pos");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andPosNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("pos <>", value, "pos");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andPosGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("pos >", value, "pos");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andPosGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("pos >=", value, "pos");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andPosLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("pos <", value, "pos");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andPosLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("pos <=", value, "pos");
            return (RankingInstanceDetailCriteria) this;
        }

        
        public RankingInstanceDetailCriteria andSailnumberIsNull() {
            addCriterion("sailnumber is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andSailnumberIsNotNull() {
            addCriterion("sailnumber is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andSailnumberEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber =", value, "sailnumber");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andSailnumberNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber <>", value, "sailnumber");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andSailnumberGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber >", value, "sailnumber");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andSailnumberGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber >=", value, "sailnumber");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andSailnumberLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber <", value, "sailnumber");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andSailnumberLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber <=", value, "sailnumber");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andSailnumberLike(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber like ", value, "sailnumber");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andSailnumberNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber not like ", value, "sailnumber");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andSailnumberIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("sailnumber in ", value, "sailnumber");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andSailnumberNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("sailnumber not in ", value, "sailnumber");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andSailnumberBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sailnumber between ", value1, value2, "sailnumber");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andSailnumberNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sailnumber not between ", value1, value2, "sailnumber");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andYachtnameIsNull() {
            addCriterion("yachtname is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andYachtnameIsNotNull() {
            addCriterion("yachtname is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andYachtnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname =", value, "yachtname");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andYachtnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname <>", value, "yachtname");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andYachtnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname >", value, "yachtname");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andYachtnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname >=", value, "yachtname");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andYachtnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname <", value, "yachtname");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andYachtnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname <=", value, "yachtname");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andYachtnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname like ", value, "yachtname");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andYachtnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname not like ", value, "yachtname");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andYachtnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("yachtname in ", value, "yachtname");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andYachtnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("yachtname not in ", value, "yachtname");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andYachtnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("yachtname between ", value1, value2, "yachtname");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andYachtnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("yachtname not between ", value1, value2, "yachtname");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andOwnerIsNull() {
            addCriterion("owner is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andOwnerIsNotNull() {
            addCriterion("owner is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andOwnerEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("owner =", value, "owner");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andOwnerNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("owner <>", value, "owner");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andOwnerGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("owner >", value, "owner");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andOwnerGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("owner >=", value, "owner");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andOwnerLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("owner <", value, "owner");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andOwnerLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("owner <=", value, "owner");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andOwnerLike(java.lang.String value) {
            if (value != null)
              addCriterion("owner like ", value, "owner");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andOwnerNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("owner not like ", value, "owner");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andOwnerIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("owner in ", value, "owner");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andOwnerNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("owner not in ", value, "owner");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andOwnerBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("owner between ", value1, value2, "owner");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andOwnerNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("owner not between ", value1, value2, "owner");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andClubIsNull() {
            addCriterion("club is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andClubIsNotNull() {
            addCriterion("club is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andClubEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("club =", value, "club");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andClubNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("club <>", value, "club");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andClubGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("club >", value, "club");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andClubGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("club >=", value, "club");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andClubLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("club <", value, "club");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andClubLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("club <=", value, "club");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andClubLike(java.lang.String value) {
            if (value != null)
              addCriterion("club like ", value, "club");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andClubNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("club not like ", value, "club");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andClubIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("club in ", value, "club");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andClubNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("club not in ", value, "club");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andClubBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("club between ", value1, value2, "club");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andClubNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("club not between ", value1, value2, "club");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andModelIsNull() {
            addCriterion("model is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andModelEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("model =", value, "model");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andModelNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("model <>", value, "model");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andModelGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("model >", value, "model");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andModelGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("model >=", value, "model");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andModelLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("model <", value, "model");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andModelLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("model <=", value, "model");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andModelLike(java.lang.String value) {
            if (value != null)
              addCriterion("model like ", value, "model");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andModelNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("model not like ", value, "model");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andModelIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("model in ", value, "model");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andModelNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("model not in ", value, "model");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andModelBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("model between ", value1, value2, "model");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andModelNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("model not between ", value1, value2, "model");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andRacegroupIsNull() {
            addCriterion("racegroup is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRacegroupIsNotNull() {
            addCriterion("racegroup is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRacegroupEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup =", value, "racegroup");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRacegroupNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup <>", value, "racegroup");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRacegroupGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup >", value, "racegroup");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRacegroupGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup >=", value, "racegroup");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRacegroupLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup <", value, "racegroup");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRacegroupLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup <=", value, "racegroup");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRacegroupLike(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup like ", value, "racegroup");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRacegroupNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup not like ", value, "racegroup");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRacegroupIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("racegroup in ", value, "racegroup");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRacegroupNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("racegroup not in ", value, "racegroup");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRacegroupBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racegroup between ", value1, value2, "racegroup");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRacegroupNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racegroup not between ", value1, value2, "racegroup");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andDivisionIsNull() {
            addCriterion("division is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andDivisionIsNotNull() {
            addCriterion("division is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andDivisionEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("division =", value, "division");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andDivisionNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("division <>", value, "division");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andDivisionGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("division >", value, "division");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andDivisionGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("division >=", value, "division");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andDivisionLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("division <", value, "division");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andDivisionLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("division <=", value, "division");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andDivisionLike(java.lang.String value) {
            if (value != null)
              addCriterion("division like ", value, "division");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andDivisionNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("division not like ", value, "division");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andDivisionIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("division in ", value, "division");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andDivisionNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("division not in ", value, "division");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andDivisionBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("division between ", value1, value2, "division");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andDivisionNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("division not between ", value1, value2, "division");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andTimoniereIsNull() {
            addCriterion("timoniere is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andTimoniereIsNotNull() {
            addCriterion("timoniere is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andTimoniereEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("timoniere =", value, "timoniere");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andTimoniereNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("timoniere <>", value, "timoniere");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andTimoniereGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("timoniere >", value, "timoniere");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andTimoniereGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("timoniere >=", value, "timoniere");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andTimoniereLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("timoniere <", value, "timoniere");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andTimoniereLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("timoniere <=", value, "timoniere");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andTimoniereLike(java.lang.String value) {
            if (value != null)
              addCriterion("timoniere like ", value, "timoniere");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andTimoniereNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("timoniere not like ", value, "timoniere");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andTimoniereIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("timoniere in ", value, "timoniere");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andTimoniereNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("timoniere not in ", value, "timoniere");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andTimoniereBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("timoniere between ", value1, value2, "timoniere");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andTimoniereNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("timoniere not between ", value1, value2, "timoniere");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andArrivaldateIsNull() {
            addCriterion("arrivaldate is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andArrivaldateIsNotNull() {
            addCriterion("arrivaldate is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andArrivaldateEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("arrivaldate =", value, "arrivaldate");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andArrivaldateNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("arrivaldate <>", value, "arrivaldate");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andArrivaldateGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("arrivaldate >", value, "arrivaldate");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andArrivaldateGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("arrivaldate >=", value, "arrivaldate");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andArrivaldateLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("arrivaldate <", value, "arrivaldate");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andArrivaldateLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("arrivaldate <=", value, "arrivaldate");
            return (RankingInstanceDetailCriteria) this;
        }

        
        public RankingInstanceDetailCriteria andRealtimeIsNull() {
            addCriterion("realtime is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRealtimeIsNotNull() {
            addCriterion("realtime is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRealtimeEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("realtime =", value, "realtime");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRealtimeNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("realtime <>", value, "realtime");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRealtimeGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("realtime >", value, "realtime");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRealtimeGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("realtime >=", value, "realtime");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRealtimeLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("realtime <", value, "realtime");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRealtimeLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("realtime <=", value, "realtime");
            return (RankingInstanceDetailCriteria) this;
        }

        
        public RankingInstanceDetailCriteria andDrealtimeIsNull() {
            addCriterion("drealtime is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andDrealtimeIsNotNull() {
            addCriterion("drealtime is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andDrealtimeEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("drealtime =", value, "drealtime");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andDrealtimeNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("drealtime <>", value, "drealtime");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andDrealtimeGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("drealtime >", value, "drealtime");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andDrealtimeGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("drealtime >=", value, "drealtime");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andDrealtimeLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("drealtime <", value, "drealtime");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andDrealtimeLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("drealtime <=", value, "drealtime");
            return (RankingInstanceDetailCriteria) this;
        }

        
        public RankingInstanceDetailCriteria andCorrectedtimeIsNull() {
            addCriterion("correctedtime is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andCorrectedtimeIsNotNull() {
            addCriterion("correctedtime is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andCorrectedtimeEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("correctedtime =", value, "correctedtime");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andCorrectedtimeNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("correctedtime <>", value, "correctedtime");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andCorrectedtimeGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("correctedtime >", value, "correctedtime");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andCorrectedtimeGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("correctedtime >=", value, "correctedtime");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andCorrectedtimeLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("correctedtime <", value, "correctedtime");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andCorrectedtimeLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("correctedtime <=", value, "correctedtime");
            return (RankingInstanceDetailCriteria) this;
        }

        
        public RankingInstanceDetailCriteria andAnnotationIsNull() {
            addCriterion("annotation is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andAnnotationIsNotNull() {
            addCriterion("annotation is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andAnnotationEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("annotation =", value, "annotation");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andAnnotationNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("annotation <>", value, "annotation");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andAnnotationGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("annotation >", value, "annotation");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andAnnotationGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("annotation >=", value, "annotation");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andAnnotationLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("annotation <", value, "annotation");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andAnnotationLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("annotation <=", value, "annotation");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andAnnotationLike(java.lang.String value) {
            if (value != null)
              addCriterion("annotation like ", value, "annotation");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andAnnotationNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("annotation not like ", value, "annotation");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andAnnotationIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("annotation in ", value, "annotation");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andAnnotationNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("annotation not in ", value, "annotation");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andAnnotationBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("annotation between ", value1, value2, "annotation");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andAnnotationNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("annotation not between ", value1, value2, "annotation");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andPerctempenIsNull() {
            addCriterion("perctempen is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andPerctempenIsNotNull() {
            addCriterion("perctempen is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andPerctempenEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("perctempen =", value, "perctempen");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andPerctempenNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("perctempen <>", value, "perctempen");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andPerctempenGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("perctempen >", value, "perctempen");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andPerctempenGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("perctempen >=", value, "perctempen");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andPerctempenLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("perctempen <", value, "perctempen");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andPerctempenLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("perctempen <=", value, "perctempen");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andPerctempenLike(java.lang.String value) {
            if (value != null)
              addCriterion("perctempen like ", value, "perctempen");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andPerctempenNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("perctempen not like ", value, "perctempen");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andPerctempenIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("perctempen in ", value, "perctempen");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andPerctempenNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("perctempen not in ", value, "perctempen");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andPerctempenBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("perctempen between ", value1, value2, "perctempen");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andPerctempenNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("perctempen not between ", value1, value2, "perctempen");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andScoreIsNull() {
            addCriterion("score is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScoreEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("score =", value, "score");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScoreNotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("score <>", value, "score");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScoreGreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("score >", value, "score");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScoreGreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("score >=", value, "score");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScoreLessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("score <", value, "score");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScoreLessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("score <=", value, "score");
            return (RankingInstanceDetailCriteria) this;
        }

        
        public RankingInstanceDetailCriteria andMaxracesIsNull() {
            addCriterion("maxraces is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andMaxracesIsNotNull() {
            addCriterion("maxraces is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andMaxracesEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("maxraces =", value, "maxraces");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andMaxracesNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("maxraces <>", value, "maxraces");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andMaxracesGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("maxraces >", value, "maxraces");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andMaxracesGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("maxraces >=", value, "maxraces");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andMaxracesLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("maxraces <", value, "maxraces");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andMaxracesLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("maxraces <=", value, "maxraces");
            return (RankingInstanceDetailCriteria) this;
        }

        
        public RankingInstanceDetailCriteria andScorer01IsNull() {
            addCriterion("scorer01 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer01IsNotNull() {
            addCriterion("scorer01 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer01EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer01 =", value, "scorer01");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer01NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer01 <>", value, "scorer01");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer01GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer01 >", value, "scorer01");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer01GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer01 >=", value, "scorer01");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer01LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer01 <", value, "scorer01");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer01LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer01 <=", value, "scorer01");
            return (RankingInstanceDetailCriteria) this;
        }

        
        public RankingInstanceDetailCriteria andScorer02IsNull() {
            addCriterion("scorer02 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer02IsNotNull() {
            addCriterion("scorer02 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer02EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer02 =", value, "scorer02");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer02NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer02 <>", value, "scorer02");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer02GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer02 >", value, "scorer02");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer02GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer02 >=", value, "scorer02");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer02LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer02 <", value, "scorer02");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer02LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer02 <=", value, "scorer02");
            return (RankingInstanceDetailCriteria) this;
        }

        
        public RankingInstanceDetailCriteria andScorer03IsNull() {
            addCriterion("scorer03 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer03IsNotNull() {
            addCriterion("scorer03 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer03EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer03 =", value, "scorer03");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer03NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer03 <>", value, "scorer03");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer03GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer03 >", value, "scorer03");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer03GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer03 >=", value, "scorer03");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer03LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer03 <", value, "scorer03");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer03LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer03 <=", value, "scorer03");
            return (RankingInstanceDetailCriteria) this;
        }

        
        public RankingInstanceDetailCriteria andScorer04IsNull() {
            addCriterion("scorer04 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer04IsNotNull() {
            addCriterion("scorer04 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer04EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer04 =", value, "scorer04");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer04NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer04 <>", value, "scorer04");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer04GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer04 >", value, "scorer04");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer04GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer04 >=", value, "scorer04");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer04LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer04 <", value, "scorer04");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer04LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer04 <=", value, "scorer04");
            return (RankingInstanceDetailCriteria) this;
        }

        
        public RankingInstanceDetailCriteria andScorer05IsNull() {
            addCriterion("scorer05 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer05IsNotNull() {
            addCriterion("scorer05 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer05EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer05 =", value, "scorer05");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer05NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer05 <>", value, "scorer05");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer05GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer05 >", value, "scorer05");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer05GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer05 >=", value, "scorer05");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer05LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer05 <", value, "scorer05");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer05LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer05 <=", value, "scorer05");
            return (RankingInstanceDetailCriteria) this;
        }

        
        public RankingInstanceDetailCriteria andScorer06IsNull() {
            addCriterion("scorer06 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer06IsNotNull() {
            addCriterion("scorer06 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer06EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer06 =", value, "scorer06");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer06NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer06 <>", value, "scorer06");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer06GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer06 >", value, "scorer06");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer06GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer06 >=", value, "scorer06");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer06LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer06 <", value, "scorer06");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer06LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer06 <=", value, "scorer06");
            return (RankingInstanceDetailCriteria) this;
        }

        
        public RankingInstanceDetailCriteria andScorer07IsNull() {
            addCriterion("scorer07 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer07IsNotNull() {
            addCriterion("scorer07 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer07EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer07 =", value, "scorer07");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer07NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer07 <>", value, "scorer07");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer07GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer07 >", value, "scorer07");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer07GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer07 >=", value, "scorer07");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer07LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer07 <", value, "scorer07");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer07LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer07 <=", value, "scorer07");
            return (RankingInstanceDetailCriteria) this;
        }

        
        public RankingInstanceDetailCriteria andScorer08IsNull() {
            addCriterion("scorer08 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer08IsNotNull() {
            addCriterion("scorer08 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer08EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer08 =", value, "scorer08");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer08NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer08 <>", value, "scorer08");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer08GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer08 >", value, "scorer08");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer08GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer08 >=", value, "scorer08");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer08LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer08 <", value, "scorer08");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer08LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer08 <=", value, "scorer08");
            return (RankingInstanceDetailCriteria) this;
        }

        
        public RankingInstanceDetailCriteria andScorer09IsNull() {
            addCriterion("scorer09 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer09IsNotNull() {
            addCriterion("scorer09 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer09EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer09 =", value, "scorer09");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer09NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer09 <>", value, "scorer09");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer09GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer09 >", value, "scorer09");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer09GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer09 >=", value, "scorer09");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer09LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer09 <", value, "scorer09");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer09LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer09 <=", value, "scorer09");
            return (RankingInstanceDetailCriteria) this;
        }

        
        public RankingInstanceDetailCriteria andScorer10IsNull() {
            addCriterion("scorer10 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer10IsNotNull() {
            addCriterion("scorer10 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer10EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer10 =", value, "scorer10");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer10NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer10 <>", value, "scorer10");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer10GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer10 >", value, "scorer10");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer10GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer10 >=", value, "scorer10");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer10LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer10 <", value, "scorer10");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer10LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer10 <=", value, "scorer10");
            return (RankingInstanceDetailCriteria) this;
        }

        
        public RankingInstanceDetailCriteria andScorer11IsNull() {
            addCriterion("scorer11 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer11IsNotNull() {
            addCriterion("scorer11 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer11EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer11 =", value, "scorer11");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer11NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer11 <>", value, "scorer11");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer11GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer11 >", value, "scorer11");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer11GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer11 >=", value, "scorer11");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer11LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer11 <", value, "scorer11");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer11LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer11 <=", value, "scorer11");
            return (RankingInstanceDetailCriteria) this;
        }

        
        public RankingInstanceDetailCriteria andScorer12IsNull() {
            addCriterion("scorer12 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer12IsNotNull() {
            addCriterion("scorer12 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer12EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer12 =", value, "scorer12");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer12NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer12 <>", value, "scorer12");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer12GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer12 >", value, "scorer12");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer12GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer12 >=", value, "scorer12");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer12LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer12 <", value, "scorer12");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer12LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer12 <=", value, "scorer12");
            return (RankingInstanceDetailCriteria) this;
        }

        
        public RankingInstanceDetailCriteria andScorer13IsNull() {
            addCriterion("scorer13 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer13IsNotNull() {
            addCriterion("scorer13 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer13EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer13 =", value, "scorer13");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer13NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer13 <>", value, "scorer13");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer13GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer13 >", value, "scorer13");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer13GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer13 >=", value, "scorer13");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer13LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer13 <", value, "scorer13");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer13LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer13 <=", value, "scorer13");
            return (RankingInstanceDetailCriteria) this;
        }

        
        public RankingInstanceDetailCriteria andScorer14IsNull() {
            addCriterion("scorer14 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer14IsNotNull() {
            addCriterion("scorer14 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer14EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer14 =", value, "scorer14");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer14NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer14 <>", value, "scorer14");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer14GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer14 >", value, "scorer14");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer14GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer14 >=", value, "scorer14");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer14LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer14 <", value, "scorer14");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer14LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer14 <=", value, "scorer14");
            return (RankingInstanceDetailCriteria) this;
        }

        
        public RankingInstanceDetailCriteria andScorer15IsNull() {
            addCriterion("scorer15 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer15IsNotNull() {
            addCriterion("scorer15 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer15EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer15 =", value, "scorer15");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer15NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer15 <>", value, "scorer15");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer15GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer15 >", value, "scorer15");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer15GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer15 >=", value, "scorer15");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer15LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer15 <", value, "scorer15");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorer15LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer15 <=", value, "scorer15");
            return (RankingInstanceDetailCriteria) this;
        }

        
        public RankingInstanceDetailCriteria andScorern01IsNull() {
            addCriterion("scorern01 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern01IsNotNull() {
            addCriterion("scorern01 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern01EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern01 =", value, "scorern01");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern01NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern01 <>", value, "scorern01");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern01GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern01 >", value, "scorern01");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern01GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern01 >=", value, "scorern01");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern01LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern01 <", value, "scorern01");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern01LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern01 <=", value, "scorern01");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern01Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern01 like ", value, "scorern01");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern01NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern01 not like ", value, "scorern01");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern01In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern01 in ", value, "scorern01");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern01NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern01 not in ", value, "scorern01");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern01Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern01 between ", value1, value2, "scorern01");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern01NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern01 not between ", value1, value2, "scorern01");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andScorern02IsNull() {
            addCriterion("scorern02 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern02IsNotNull() {
            addCriterion("scorern02 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern02EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern02 =", value, "scorern02");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern02NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern02 <>", value, "scorern02");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern02GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern02 >", value, "scorern02");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern02GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern02 >=", value, "scorern02");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern02LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern02 <", value, "scorern02");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern02LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern02 <=", value, "scorern02");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern02Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern02 like ", value, "scorern02");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern02NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern02 not like ", value, "scorern02");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern02In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern02 in ", value, "scorern02");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern02NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern02 not in ", value, "scorern02");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern02Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern02 between ", value1, value2, "scorern02");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern02NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern02 not between ", value1, value2, "scorern02");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andScorern03IsNull() {
            addCriterion("scorern03 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern03IsNotNull() {
            addCriterion("scorern03 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern03EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern03 =", value, "scorern03");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern03NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern03 <>", value, "scorern03");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern03GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern03 >", value, "scorern03");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern03GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern03 >=", value, "scorern03");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern03LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern03 <", value, "scorern03");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern03LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern03 <=", value, "scorern03");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern03Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern03 like ", value, "scorern03");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern03NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern03 not like ", value, "scorern03");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern03In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern03 in ", value, "scorern03");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern03NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern03 not in ", value, "scorern03");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern03Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern03 between ", value1, value2, "scorern03");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern03NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern03 not between ", value1, value2, "scorern03");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andScorern04IsNull() {
            addCriterion("scorern04 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern04IsNotNull() {
            addCriterion("scorern04 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern04EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern04 =", value, "scorern04");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern04NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern04 <>", value, "scorern04");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern04GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern04 >", value, "scorern04");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern04GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern04 >=", value, "scorern04");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern04LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern04 <", value, "scorern04");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern04LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern04 <=", value, "scorern04");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern04Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern04 like ", value, "scorern04");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern04NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern04 not like ", value, "scorern04");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern04In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern04 in ", value, "scorern04");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern04NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern04 not in ", value, "scorern04");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern04Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern04 between ", value1, value2, "scorern04");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern04NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern04 not between ", value1, value2, "scorern04");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andScorern05IsNull() {
            addCriterion("scorern05 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern05IsNotNull() {
            addCriterion("scorern05 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern05EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern05 =", value, "scorern05");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern05NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern05 <>", value, "scorern05");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern05GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern05 >", value, "scorern05");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern05GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern05 >=", value, "scorern05");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern05LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern05 <", value, "scorern05");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern05LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern05 <=", value, "scorern05");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern05Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern05 like ", value, "scorern05");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern05NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern05 not like ", value, "scorern05");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern05In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern05 in ", value, "scorern05");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern05NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern05 not in ", value, "scorern05");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern05Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern05 between ", value1, value2, "scorern05");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern05NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern05 not between ", value1, value2, "scorern05");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andScorern06IsNull() {
            addCriterion("scorern06 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern06IsNotNull() {
            addCriterion("scorern06 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern06EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern06 =", value, "scorern06");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern06NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern06 <>", value, "scorern06");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern06GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern06 >", value, "scorern06");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern06GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern06 >=", value, "scorern06");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern06LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern06 <", value, "scorern06");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern06LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern06 <=", value, "scorern06");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern06Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern06 like ", value, "scorern06");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern06NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern06 not like ", value, "scorern06");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern06In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern06 in ", value, "scorern06");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern06NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern06 not in ", value, "scorern06");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern06Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern06 between ", value1, value2, "scorern06");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern06NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern06 not between ", value1, value2, "scorern06");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andScorern07IsNull() {
            addCriterion("scorern07 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern07IsNotNull() {
            addCriterion("scorern07 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern07EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern07 =", value, "scorern07");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern07NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern07 <>", value, "scorern07");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern07GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern07 >", value, "scorern07");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern07GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern07 >=", value, "scorern07");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern07LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern07 <", value, "scorern07");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern07LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern07 <=", value, "scorern07");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern07Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern07 like ", value, "scorern07");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern07NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern07 not like ", value, "scorern07");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern07In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern07 in ", value, "scorern07");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern07NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern07 not in ", value, "scorern07");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern07Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern07 between ", value1, value2, "scorern07");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern07NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern07 not between ", value1, value2, "scorern07");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andScorern08IsNull() {
            addCriterion("scorern08 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern08IsNotNull() {
            addCriterion("scorern08 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern08EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern08 =", value, "scorern08");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern08NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern08 <>", value, "scorern08");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern08GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern08 >", value, "scorern08");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern08GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern08 >=", value, "scorern08");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern08LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern08 <", value, "scorern08");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern08LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern08 <=", value, "scorern08");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern08Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern08 like ", value, "scorern08");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern08NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern08 not like ", value, "scorern08");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern08In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern08 in ", value, "scorern08");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern08NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern08 not in ", value, "scorern08");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern08Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern08 between ", value1, value2, "scorern08");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern08NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern08 not between ", value1, value2, "scorern08");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andScorern09IsNull() {
            addCriterion("scorern09 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern09IsNotNull() {
            addCriterion("scorern09 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern09EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern09 =", value, "scorern09");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern09NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern09 <>", value, "scorern09");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern09GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern09 >", value, "scorern09");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern09GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern09 >=", value, "scorern09");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern09LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern09 <", value, "scorern09");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern09LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern09 <=", value, "scorern09");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern09Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern09 like ", value, "scorern09");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern09NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern09 not like ", value, "scorern09");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern09In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern09 in ", value, "scorern09");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern09NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern09 not in ", value, "scorern09");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern09Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern09 between ", value1, value2, "scorern09");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern09NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern09 not between ", value1, value2, "scorern09");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andScorern10IsNull() {
            addCriterion("scorern10 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern10IsNotNull() {
            addCriterion("scorern10 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern10EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern10 =", value, "scorern10");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern10NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern10 <>", value, "scorern10");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern10GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern10 >", value, "scorern10");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern10GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern10 >=", value, "scorern10");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern10LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern10 <", value, "scorern10");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern10LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern10 <=", value, "scorern10");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern10Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern10 like ", value, "scorern10");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern10NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern10 not like ", value, "scorern10");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern10In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern10 in ", value, "scorern10");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern10NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern10 not in ", value, "scorern10");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern10Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern10 between ", value1, value2, "scorern10");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern10NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern10 not between ", value1, value2, "scorern10");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andScorern11IsNull() {
            addCriterion("scorern11 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern11IsNotNull() {
            addCriterion("scorern11 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern11EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern11 =", value, "scorern11");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern11NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern11 <>", value, "scorern11");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern11GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern11 >", value, "scorern11");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern11GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern11 >=", value, "scorern11");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern11LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern11 <", value, "scorern11");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern11LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern11 <=", value, "scorern11");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern11Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern11 like ", value, "scorern11");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern11NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern11 not like ", value, "scorern11");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern11In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern11 in ", value, "scorern11");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern11NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern11 not in ", value, "scorern11");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern11Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern11 between ", value1, value2, "scorern11");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern11NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern11 not between ", value1, value2, "scorern11");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andScorern12IsNull() {
            addCriterion("scorern12 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern12IsNotNull() {
            addCriterion("scorern12 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern12EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern12 =", value, "scorern12");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern12NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern12 <>", value, "scorern12");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern12GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern12 >", value, "scorern12");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern12GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern12 >=", value, "scorern12");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern12LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern12 <", value, "scorern12");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern12LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern12 <=", value, "scorern12");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern12Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern12 like ", value, "scorern12");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern12NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern12 not like ", value, "scorern12");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern12In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern12 in ", value, "scorern12");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern12NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern12 not in ", value, "scorern12");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern12Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern12 between ", value1, value2, "scorern12");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern12NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern12 not between ", value1, value2, "scorern12");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andScorern13IsNull() {
            addCriterion("scorern13 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern13IsNotNull() {
            addCriterion("scorern13 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern13EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern13 =", value, "scorern13");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern13NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern13 <>", value, "scorern13");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern13GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern13 >", value, "scorern13");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern13GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern13 >=", value, "scorern13");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern13LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern13 <", value, "scorern13");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern13LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern13 <=", value, "scorern13");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern13Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern13 like ", value, "scorern13");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern13NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern13 not like ", value, "scorern13");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern13In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern13 in ", value, "scorern13");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern13NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern13 not in ", value, "scorern13");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern13Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern13 between ", value1, value2, "scorern13");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern13NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern13 not between ", value1, value2, "scorern13");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andScorern14IsNull() {
            addCriterion("scorern14 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern14IsNotNull() {
            addCriterion("scorern14 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern14EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern14 =", value, "scorern14");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern14NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern14 <>", value, "scorern14");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern14GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern14 >", value, "scorern14");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern14GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern14 >=", value, "scorern14");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern14LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern14 <", value, "scorern14");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern14LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern14 <=", value, "scorern14");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern14Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern14 like ", value, "scorern14");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern14NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern14 not like ", value, "scorern14");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern14In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern14 in ", value, "scorern14");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern14NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern14 not in ", value, "scorern14");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern14Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern14 between ", value1, value2, "scorern14");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern14NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern14 not between ", value1, value2, "scorern14");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andScorern15IsNull() {
            addCriterion("scorern15 is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern15IsNotNull() {
            addCriterion("scorern15 is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern15EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern15 =", value, "scorern15");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern15NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern15 <>", value, "scorern15");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern15GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern15 >", value, "scorern15");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern15GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern15 >=", value, "scorern15");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern15LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern15 <", value, "scorern15");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern15LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern15 <=", value, "scorern15");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern15Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern15 like ", value, "scorern15");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern15NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern15 not like ", value, "scorern15");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern15In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern15 in ", value, "scorern15");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern15NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern15 not in ", value, "scorern15");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern15Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern15 between ", value1, value2, "scorern15");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andScorern15NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern15 not between ", value1, value2, "scorern15");
            return (RankingInstanceDetailCriteria) this;
        }
        
        public RankingInstanceDetailCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (RankingInstanceDetailCriteria) this;
        }
        public RankingInstanceDetailCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (RankingInstanceDetailCriteria) this;
        }

    }
    
}

