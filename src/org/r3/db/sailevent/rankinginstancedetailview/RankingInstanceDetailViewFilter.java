//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.rankinginstancedetailview;

import java.util.ArrayList;
import java.util.List;

public class RankingInstanceDetailViewFilter{
    protected String orderByClause;
    protected String  groupByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public RankingInstanceDetailViewFilter() 
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

    public RankingInstanceDetailViewCriteria or() 
    {
        RankingInstanceDetailViewCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public RankingInstanceDetailViewCriteria createCriteria() 
    {
        RankingInstanceDetailViewCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected RankingInstanceDetailViewCriteria createCriteriaInternal() 
    {
        RankingInstanceDetailViewCriteria criteria = new RankingInstanceDetailViewCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class RankingInstanceDetailViewCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public RankingInstanceDetailViewCriteria andRankentryidIsNull() {
            addCriterion("rankentryid is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRankentryidIsNotNull() {
            addCriterion("rankentryid is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRankentryidEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("rankentryid =", value, "rankentryid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRankentryidNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("rankentryid <>", value, "rankentryid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRankentryidGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("rankentryid >", value, "rankentryid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRankentryidGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("rankentryid >=", value, "rankentryid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRankentryidLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("rankentryid <", value, "rankentryid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRankentryidLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("rankentryid <=", value, "rankentryid");
            return (RankingInstanceDetailViewCriteria) this;
        }

        
        public RankingInstanceDetailViewCriteria andEventidIsNull() {
            addCriterion("eventid is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andEventidIsNotNull() {
            addCriterion("eventid is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andEventidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid =", value, "eventid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andEventidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <>", value, "eventid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andEventidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >", value, "eventid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andEventidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >=", value, "eventid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andEventidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <", value, "eventid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andEventidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <=", value, "eventid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andEventidLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid like ", value, "eventid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andEventidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid not like ", value, "eventid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andEventidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("eventid in ", value, "eventid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andEventidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("eventid not in ", value, "eventid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andEventidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid between ", value1, value2, "eventid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andEventidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid not between ", value1, value2, "eventid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andInstanceidIsNull() {
            addCriterion("instanceid is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andInstanceidIsNotNull() {
            addCriterion("instanceid is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andInstanceidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid =", value, "instanceid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andInstanceidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid <>", value, "instanceid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andInstanceidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid >", value, "instanceid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andInstanceidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid >=", value, "instanceid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andInstanceidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid <", value, "instanceid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andInstanceidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid <=", value, "instanceid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andInstanceidLike(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid like ", value, "instanceid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andInstanceidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid not like ", value, "instanceid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andInstanceidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("instanceid in ", value, "instanceid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andInstanceidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("instanceid not in ", value, "instanceid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andInstanceidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("instanceid between ", value1, value2, "instanceid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andInstanceidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("instanceid not between ", value1, value2, "instanceid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andApplicationidIsNull() {
            addCriterion("applicationid is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andApplicationidIsNotNull() {
            addCriterion("applicationid is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andApplicationidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid =", value, "applicationid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andApplicationidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid <>", value, "applicationid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andApplicationidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid >", value, "applicationid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andApplicationidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid >=", value, "applicationid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andApplicationidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid <", value, "applicationid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andApplicationidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid <=", value, "applicationid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andApplicationidLike(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid like ", value, "applicationid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andApplicationidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("applicationid not like ", value, "applicationid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andApplicationidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("applicationid in ", value, "applicationid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andApplicationidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("applicationid not in ", value, "applicationid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andApplicationidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("applicationid between ", value1, value2, "applicationid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andApplicationidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("applicationid not between ", value1, value2, "applicationid");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andPosIsNull() {
            addCriterion("pos is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andPosIsNotNull() {
            addCriterion("pos is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andPosEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("pos =", value, "pos");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andPosNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("pos <>", value, "pos");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andPosGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("pos >", value, "pos");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andPosGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("pos >=", value, "pos");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andPosLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("pos <", value, "pos");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andPosLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("pos <=", value, "pos");
            return (RankingInstanceDetailViewCriteria) this;
        }

        
        public RankingInstanceDetailViewCriteria andSailnumberIsNull() {
            addCriterion("sailnumber is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andSailnumberIsNotNull() {
            addCriterion("sailnumber is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andSailnumberEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber =", value, "sailnumber");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andSailnumberNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber <>", value, "sailnumber");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andSailnumberGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber >", value, "sailnumber");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andSailnumberGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber >=", value, "sailnumber");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andSailnumberLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber <", value, "sailnumber");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andSailnumberLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber <=", value, "sailnumber");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andSailnumberLike(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber like ", value, "sailnumber");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andSailnumberNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("sailnumber not like ", value, "sailnumber");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andSailnumberIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("sailnumber in ", value, "sailnumber");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andSailnumberNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("sailnumber not in ", value, "sailnumber");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andSailnumberBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sailnumber between ", value1, value2, "sailnumber");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andSailnumberNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("sailnumber not between ", value1, value2, "sailnumber");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andYachtnameIsNull() {
            addCriterion("yachtname is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtnameIsNotNull() {
            addCriterion("yachtname is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname =", value, "yachtname");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname <>", value, "yachtname");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname >", value, "yachtname");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname >=", value, "yachtname");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname <", value, "yachtname");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname <=", value, "yachtname");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname like ", value, "yachtname");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("yachtname not like ", value, "yachtname");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("yachtname in ", value, "yachtname");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("yachtname not in ", value, "yachtname");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("yachtname between ", value1, value2, "yachtname");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("yachtname not between ", value1, value2, "yachtname");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andOwnerIsNull() {
            addCriterion("owner is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andOwnerIsNotNull() {
            addCriterion("owner is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andOwnerEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("owner =", value, "owner");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andOwnerNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("owner <>", value, "owner");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andOwnerGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("owner >", value, "owner");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andOwnerGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("owner >=", value, "owner");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andOwnerLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("owner <", value, "owner");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andOwnerLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("owner <=", value, "owner");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andOwnerLike(java.lang.String value) {
            if (value != null)
              addCriterion("owner like ", value, "owner");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andOwnerNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("owner not like ", value, "owner");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andOwnerIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("owner in ", value, "owner");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andOwnerNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("owner not in ", value, "owner");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andOwnerBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("owner between ", value1, value2, "owner");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andOwnerNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("owner not between ", value1, value2, "owner");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andClubIsNull() {
            addCriterion("club is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andClubIsNotNull() {
            addCriterion("club is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andClubEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("club =", value, "club");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andClubNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("club <>", value, "club");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andClubGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("club >", value, "club");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andClubGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("club >=", value, "club");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andClubLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("club <", value, "club");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andClubLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("club <=", value, "club");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andClubLike(java.lang.String value) {
            if (value != null)
              addCriterion("club like ", value, "club");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andClubNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("club not like ", value, "club");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andClubIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("club in ", value, "club");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andClubNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("club not in ", value, "club");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andClubBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("club between ", value1, value2, "club");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andClubNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("club not between ", value1, value2, "club");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andModelIsNull() {
            addCriterion("model is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andModelEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("model =", value, "model");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andModelNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("model <>", value, "model");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andModelGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("model >", value, "model");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andModelGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("model >=", value, "model");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andModelLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("model <", value, "model");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andModelLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("model <=", value, "model");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andModelLike(java.lang.String value) {
            if (value != null)
              addCriterion("model like ", value, "model");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andModelNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("model not like ", value, "model");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andModelIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("model in ", value, "model");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andModelNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("model not in ", value, "model");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andModelBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("model between ", value1, value2, "model");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andModelNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("model not between ", value1, value2, "model");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andRacegroupIsNull() {
            addCriterion("racegroup is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRacegroupIsNotNull() {
            addCriterion("racegroup is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRacegroupEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup =", value, "racegroup");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRacegroupNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup <>", value, "racegroup");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRacegroupGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup >", value, "racegroup");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRacegroupGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup >=", value, "racegroup");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRacegroupLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup <", value, "racegroup");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRacegroupLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup <=", value, "racegroup");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRacegroupLike(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup like ", value, "racegroup");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRacegroupNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup not like ", value, "racegroup");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRacegroupIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("racegroup in ", value, "racegroup");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRacegroupNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("racegroup not in ", value, "racegroup");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRacegroupBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racegroup between ", value1, value2, "racegroup");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRacegroupNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racegroup not between ", value1, value2, "racegroup");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andDivisionIsNull() {
            addCriterion("division is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andDivisionIsNotNull() {
            addCriterion("division is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andDivisionEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("division =", value, "division");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andDivisionNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("division <>", value, "division");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andDivisionGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("division >", value, "division");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andDivisionGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("division >=", value, "division");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andDivisionLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("division <", value, "division");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andDivisionLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("division <=", value, "division");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andDivisionLike(java.lang.String value) {
            if (value != null)
              addCriterion("division like ", value, "division");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andDivisionNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("division not like ", value, "division");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andDivisionIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("division in ", value, "division");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andDivisionNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("division not in ", value, "division");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andDivisionBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("division between ", value1, value2, "division");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andDivisionNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("division not between ", value1, value2, "division");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andTimoniereIsNull() {
            addCriterion("timoniere is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andTimoniereIsNotNull() {
            addCriterion("timoniere is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andTimoniereEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("timoniere =", value, "timoniere");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andTimoniereNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("timoniere <>", value, "timoniere");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andTimoniereGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("timoniere >", value, "timoniere");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andTimoniereGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("timoniere >=", value, "timoniere");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andTimoniereLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("timoniere <", value, "timoniere");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andTimoniereLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("timoniere <=", value, "timoniere");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andTimoniereLike(java.lang.String value) {
            if (value != null)
              addCriterion("timoniere like ", value, "timoniere");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andTimoniereNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("timoniere not like ", value, "timoniere");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andTimoniereIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("timoniere in ", value, "timoniere");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andTimoniereNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("timoniere not in ", value, "timoniere");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andTimoniereBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("timoniere between ", value1, value2, "timoniere");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andTimoniereNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("timoniere not between ", value1, value2, "timoniere");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andArrivaldateIsNull() {
            addCriterion("arrivaldate is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andArrivaldateIsNotNull() {
            addCriterion("arrivaldate is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andArrivaldateEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("arrivaldate =", value, "arrivaldate");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andArrivaldateNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("arrivaldate <>", value, "arrivaldate");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andArrivaldateGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("arrivaldate >", value, "arrivaldate");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andArrivaldateGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("arrivaldate >=", value, "arrivaldate");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andArrivaldateLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("arrivaldate <", value, "arrivaldate");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andArrivaldateLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("arrivaldate <=", value, "arrivaldate");
            return (RankingInstanceDetailViewCriteria) this;
        }

        
        public RankingInstanceDetailViewCriteria andRealtimeIsNull() {
            addCriterion("realtime is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRealtimeIsNotNull() {
            addCriterion("realtime is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRealtimeEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("realtime =", value, "realtime");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRealtimeNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("realtime <>", value, "realtime");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRealtimeGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("realtime >", value, "realtime");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRealtimeGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("realtime >=", value, "realtime");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRealtimeLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("realtime <", value, "realtime");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRealtimeLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("realtime <=", value, "realtime");
            return (RankingInstanceDetailViewCriteria) this;
        }

        
        public RankingInstanceDetailViewCriteria andDrealtimeIsNull() {
            addCriterion("drealtime is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andDrealtimeIsNotNull() {
            addCriterion("drealtime is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andDrealtimeEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("drealtime =", value, "drealtime");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andDrealtimeNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("drealtime <>", value, "drealtime");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andDrealtimeGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("drealtime >", value, "drealtime");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andDrealtimeGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("drealtime >=", value, "drealtime");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andDrealtimeLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("drealtime <", value, "drealtime");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andDrealtimeLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("drealtime <=", value, "drealtime");
            return (RankingInstanceDetailViewCriteria) this;
        }

        
        public RankingInstanceDetailViewCriteria andCorrectedtimeIsNull() {
            addCriterion("correctedtime is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andCorrectedtimeIsNotNull() {
            addCriterion("correctedtime is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andCorrectedtimeEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("correctedtime =", value, "correctedtime");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andCorrectedtimeNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("correctedtime <>", value, "correctedtime");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andCorrectedtimeGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("correctedtime >", value, "correctedtime");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andCorrectedtimeGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("correctedtime >=", value, "correctedtime");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andCorrectedtimeLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("correctedtime <", value, "correctedtime");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andCorrectedtimeLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("correctedtime <=", value, "correctedtime");
            return (RankingInstanceDetailViewCriteria) this;
        }

        
        public RankingInstanceDetailViewCriteria andAnnotationIsNull() {
            addCriterion("annotation is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andAnnotationIsNotNull() {
            addCriterion("annotation is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andAnnotationEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("annotation =", value, "annotation");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andAnnotationNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("annotation <>", value, "annotation");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andAnnotationGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("annotation >", value, "annotation");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andAnnotationGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("annotation >=", value, "annotation");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andAnnotationLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("annotation <", value, "annotation");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andAnnotationLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("annotation <=", value, "annotation");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andAnnotationLike(java.lang.String value) {
            if (value != null)
              addCriterion("annotation like ", value, "annotation");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andAnnotationNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("annotation not like ", value, "annotation");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andAnnotationIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("annotation in ", value, "annotation");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andAnnotationNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("annotation not in ", value, "annotation");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andAnnotationBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("annotation between ", value1, value2, "annotation");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andAnnotationNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("annotation not between ", value1, value2, "annotation");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andPerctempenIsNull() {
            addCriterion("perctempen is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andPerctempenIsNotNull() {
            addCriterion("perctempen is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andPerctempenEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("perctempen =", value, "perctempen");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andPerctempenNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("perctempen <>", value, "perctempen");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andPerctempenGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("perctempen >", value, "perctempen");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andPerctempenGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("perctempen >=", value, "perctempen");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andPerctempenLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("perctempen <", value, "perctempen");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andPerctempenLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("perctempen <=", value, "perctempen");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andPerctempenLike(java.lang.String value) {
            if (value != null)
              addCriterion("perctempen like ", value, "perctempen");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andPerctempenNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("perctempen not like ", value, "perctempen");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andPerctempenIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("perctempen in ", value, "perctempen");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andPerctempenNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("perctempen not in ", value, "perctempen");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andPerctempenBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("perctempen between ", value1, value2, "perctempen");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andPerctempenNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("perctempen not between ", value1, value2, "perctempen");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andScoreIsNull() {
            addCriterion("score is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScoreEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("score =", value, "score");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScoreNotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("score <>", value, "score");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScoreGreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("score >", value, "score");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScoreGreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("score >=", value, "score");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScoreLessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("score <", value, "score");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScoreLessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("score <=", value, "score");
            return (RankingInstanceDetailViewCriteria) this;
        }

        
        public RankingInstanceDetailViewCriteria andMaxracesIsNull() {
            addCriterion("maxraces is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andMaxracesIsNotNull() {
            addCriterion("maxraces is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andMaxracesEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("maxraces =", value, "maxraces");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andMaxracesNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("maxraces <>", value, "maxraces");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andMaxracesGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("maxraces >", value, "maxraces");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andMaxracesGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("maxraces >=", value, "maxraces");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andMaxracesLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("maxraces <", value, "maxraces");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andMaxracesLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("maxraces <=", value, "maxraces");
            return (RankingInstanceDetailViewCriteria) this;
        }

        
        public RankingInstanceDetailViewCriteria andScorer01IsNull() {
            addCriterion("scorer01 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer01IsNotNull() {
            addCriterion("scorer01 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer01EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer01 =", value, "scorer01");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer01NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer01 <>", value, "scorer01");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer01GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer01 >", value, "scorer01");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer01GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer01 >=", value, "scorer01");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer01LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer01 <", value, "scorer01");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer01LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer01 <=", value, "scorer01");
            return (RankingInstanceDetailViewCriteria) this;
        }

        
        public RankingInstanceDetailViewCriteria andScorer02IsNull() {
            addCriterion("scorer02 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer02IsNotNull() {
            addCriterion("scorer02 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer02EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer02 =", value, "scorer02");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer02NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer02 <>", value, "scorer02");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer02GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer02 >", value, "scorer02");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer02GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer02 >=", value, "scorer02");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer02LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer02 <", value, "scorer02");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer02LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer02 <=", value, "scorer02");
            return (RankingInstanceDetailViewCriteria) this;
        }

        
        public RankingInstanceDetailViewCriteria andScorer03IsNull() {
            addCriterion("scorer03 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer03IsNotNull() {
            addCriterion("scorer03 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer03EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer03 =", value, "scorer03");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer03NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer03 <>", value, "scorer03");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer03GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer03 >", value, "scorer03");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer03GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer03 >=", value, "scorer03");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer03LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer03 <", value, "scorer03");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer03LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer03 <=", value, "scorer03");
            return (RankingInstanceDetailViewCriteria) this;
        }

        
        public RankingInstanceDetailViewCriteria andScorer04IsNull() {
            addCriterion("scorer04 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer04IsNotNull() {
            addCriterion("scorer04 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer04EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer04 =", value, "scorer04");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer04NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer04 <>", value, "scorer04");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer04GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer04 >", value, "scorer04");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer04GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer04 >=", value, "scorer04");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer04LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer04 <", value, "scorer04");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer04LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer04 <=", value, "scorer04");
            return (RankingInstanceDetailViewCriteria) this;
        }

        
        public RankingInstanceDetailViewCriteria andScorer05IsNull() {
            addCriterion("scorer05 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer05IsNotNull() {
            addCriterion("scorer05 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer05EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer05 =", value, "scorer05");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer05NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer05 <>", value, "scorer05");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer05GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer05 >", value, "scorer05");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer05GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer05 >=", value, "scorer05");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer05LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer05 <", value, "scorer05");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer05LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer05 <=", value, "scorer05");
            return (RankingInstanceDetailViewCriteria) this;
        }

        
        public RankingInstanceDetailViewCriteria andScorer06IsNull() {
            addCriterion("scorer06 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer06IsNotNull() {
            addCriterion("scorer06 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer06EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer06 =", value, "scorer06");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer06NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer06 <>", value, "scorer06");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer06GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer06 >", value, "scorer06");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer06GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer06 >=", value, "scorer06");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer06LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer06 <", value, "scorer06");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer06LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer06 <=", value, "scorer06");
            return (RankingInstanceDetailViewCriteria) this;
        }

        
        public RankingInstanceDetailViewCriteria andScorer07IsNull() {
            addCriterion("scorer07 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer07IsNotNull() {
            addCriterion("scorer07 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer07EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer07 =", value, "scorer07");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer07NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer07 <>", value, "scorer07");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer07GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer07 >", value, "scorer07");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer07GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer07 >=", value, "scorer07");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer07LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer07 <", value, "scorer07");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer07LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer07 <=", value, "scorer07");
            return (RankingInstanceDetailViewCriteria) this;
        }

        
        public RankingInstanceDetailViewCriteria andScorer08IsNull() {
            addCriterion("scorer08 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer08IsNotNull() {
            addCriterion("scorer08 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer08EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer08 =", value, "scorer08");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer08NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer08 <>", value, "scorer08");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer08GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer08 >", value, "scorer08");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer08GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer08 >=", value, "scorer08");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer08LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer08 <", value, "scorer08");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer08LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer08 <=", value, "scorer08");
            return (RankingInstanceDetailViewCriteria) this;
        }

        
        public RankingInstanceDetailViewCriteria andScorer09IsNull() {
            addCriterion("scorer09 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer09IsNotNull() {
            addCriterion("scorer09 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer09EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer09 =", value, "scorer09");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer09NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer09 <>", value, "scorer09");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer09GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer09 >", value, "scorer09");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer09GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer09 >=", value, "scorer09");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer09LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer09 <", value, "scorer09");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer09LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer09 <=", value, "scorer09");
            return (RankingInstanceDetailViewCriteria) this;
        }

        
        public RankingInstanceDetailViewCriteria andScorer10IsNull() {
            addCriterion("scorer10 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer10IsNotNull() {
            addCriterion("scorer10 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer10EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer10 =", value, "scorer10");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer10NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer10 <>", value, "scorer10");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer10GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer10 >", value, "scorer10");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer10GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer10 >=", value, "scorer10");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer10LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer10 <", value, "scorer10");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer10LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer10 <=", value, "scorer10");
            return (RankingInstanceDetailViewCriteria) this;
        }

        
        public RankingInstanceDetailViewCriteria andScorer11IsNull() {
            addCriterion("scorer11 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer11IsNotNull() {
            addCriterion("scorer11 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer11EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer11 =", value, "scorer11");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer11NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer11 <>", value, "scorer11");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer11GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer11 >", value, "scorer11");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer11GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer11 >=", value, "scorer11");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer11LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer11 <", value, "scorer11");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer11LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer11 <=", value, "scorer11");
            return (RankingInstanceDetailViewCriteria) this;
        }

        
        public RankingInstanceDetailViewCriteria andScorer12IsNull() {
            addCriterion("scorer12 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer12IsNotNull() {
            addCriterion("scorer12 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer12EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer12 =", value, "scorer12");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer12NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer12 <>", value, "scorer12");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer12GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer12 >", value, "scorer12");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer12GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer12 >=", value, "scorer12");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer12LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer12 <", value, "scorer12");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer12LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer12 <=", value, "scorer12");
            return (RankingInstanceDetailViewCriteria) this;
        }

        
        public RankingInstanceDetailViewCriteria andScorer13IsNull() {
            addCriterion("scorer13 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer13IsNotNull() {
            addCriterion("scorer13 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer13EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer13 =", value, "scorer13");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer13NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer13 <>", value, "scorer13");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer13GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer13 >", value, "scorer13");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer13GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer13 >=", value, "scorer13");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer13LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer13 <", value, "scorer13");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer13LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer13 <=", value, "scorer13");
            return (RankingInstanceDetailViewCriteria) this;
        }

        
        public RankingInstanceDetailViewCriteria andScorer14IsNull() {
            addCriterion("scorer14 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer14IsNotNull() {
            addCriterion("scorer14 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer14EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer14 =", value, "scorer14");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer14NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer14 <>", value, "scorer14");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer14GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer14 >", value, "scorer14");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer14GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer14 >=", value, "scorer14");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer14LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer14 <", value, "scorer14");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer14LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer14 <=", value, "scorer14");
            return (RankingInstanceDetailViewCriteria) this;
        }

        
        public RankingInstanceDetailViewCriteria andScorer15IsNull() {
            addCriterion("scorer15 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer15IsNotNull() {
            addCriterion("scorer15 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer15EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer15 =", value, "scorer15");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer15NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer15 <>", value, "scorer15");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer15GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer15 >", value, "scorer15");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer15GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer15 >=", value, "scorer15");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer15LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer15 <", value, "scorer15");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorer15LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("scorer15 <=", value, "scorer15");
            return (RankingInstanceDetailViewCriteria) this;
        }

        
        public RankingInstanceDetailViewCriteria andScorern01IsNull() {
            addCriterion("scorern01 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern01IsNotNull() {
            addCriterion("scorern01 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern01EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern01 =", value, "scorern01");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern01NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern01 <>", value, "scorern01");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern01GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern01 >", value, "scorern01");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern01GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern01 >=", value, "scorern01");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern01LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern01 <", value, "scorern01");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern01LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern01 <=", value, "scorern01");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern01Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern01 like ", value, "scorern01");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern01NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern01 not like ", value, "scorern01");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern01In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern01 in ", value, "scorern01");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern01NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern01 not in ", value, "scorern01");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern01Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern01 between ", value1, value2, "scorern01");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern01NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern01 not between ", value1, value2, "scorern01");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andScorern02IsNull() {
            addCriterion("scorern02 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern02IsNotNull() {
            addCriterion("scorern02 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern02EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern02 =", value, "scorern02");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern02NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern02 <>", value, "scorern02");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern02GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern02 >", value, "scorern02");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern02GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern02 >=", value, "scorern02");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern02LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern02 <", value, "scorern02");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern02LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern02 <=", value, "scorern02");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern02Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern02 like ", value, "scorern02");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern02NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern02 not like ", value, "scorern02");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern02In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern02 in ", value, "scorern02");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern02NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern02 not in ", value, "scorern02");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern02Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern02 between ", value1, value2, "scorern02");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern02NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern02 not between ", value1, value2, "scorern02");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andScorern03IsNull() {
            addCriterion("scorern03 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern03IsNotNull() {
            addCriterion("scorern03 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern03EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern03 =", value, "scorern03");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern03NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern03 <>", value, "scorern03");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern03GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern03 >", value, "scorern03");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern03GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern03 >=", value, "scorern03");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern03LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern03 <", value, "scorern03");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern03LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern03 <=", value, "scorern03");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern03Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern03 like ", value, "scorern03");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern03NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern03 not like ", value, "scorern03");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern03In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern03 in ", value, "scorern03");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern03NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern03 not in ", value, "scorern03");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern03Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern03 between ", value1, value2, "scorern03");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern03NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern03 not between ", value1, value2, "scorern03");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andScorern04IsNull() {
            addCriterion("scorern04 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern04IsNotNull() {
            addCriterion("scorern04 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern04EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern04 =", value, "scorern04");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern04NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern04 <>", value, "scorern04");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern04GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern04 >", value, "scorern04");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern04GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern04 >=", value, "scorern04");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern04LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern04 <", value, "scorern04");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern04LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern04 <=", value, "scorern04");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern04Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern04 like ", value, "scorern04");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern04NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern04 not like ", value, "scorern04");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern04In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern04 in ", value, "scorern04");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern04NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern04 not in ", value, "scorern04");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern04Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern04 between ", value1, value2, "scorern04");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern04NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern04 not between ", value1, value2, "scorern04");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andScorern05IsNull() {
            addCriterion("scorern05 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern05IsNotNull() {
            addCriterion("scorern05 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern05EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern05 =", value, "scorern05");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern05NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern05 <>", value, "scorern05");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern05GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern05 >", value, "scorern05");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern05GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern05 >=", value, "scorern05");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern05LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern05 <", value, "scorern05");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern05LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern05 <=", value, "scorern05");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern05Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern05 like ", value, "scorern05");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern05NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern05 not like ", value, "scorern05");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern05In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern05 in ", value, "scorern05");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern05NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern05 not in ", value, "scorern05");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern05Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern05 between ", value1, value2, "scorern05");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern05NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern05 not between ", value1, value2, "scorern05");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andScorern06IsNull() {
            addCriterion("scorern06 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern06IsNotNull() {
            addCriterion("scorern06 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern06EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern06 =", value, "scorern06");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern06NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern06 <>", value, "scorern06");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern06GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern06 >", value, "scorern06");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern06GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern06 >=", value, "scorern06");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern06LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern06 <", value, "scorern06");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern06LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern06 <=", value, "scorern06");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern06Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern06 like ", value, "scorern06");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern06NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern06 not like ", value, "scorern06");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern06In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern06 in ", value, "scorern06");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern06NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern06 not in ", value, "scorern06");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern06Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern06 between ", value1, value2, "scorern06");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern06NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern06 not between ", value1, value2, "scorern06");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andScorern07IsNull() {
            addCriterion("scorern07 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern07IsNotNull() {
            addCriterion("scorern07 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern07EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern07 =", value, "scorern07");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern07NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern07 <>", value, "scorern07");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern07GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern07 >", value, "scorern07");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern07GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern07 >=", value, "scorern07");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern07LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern07 <", value, "scorern07");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern07LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern07 <=", value, "scorern07");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern07Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern07 like ", value, "scorern07");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern07NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern07 not like ", value, "scorern07");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern07In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern07 in ", value, "scorern07");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern07NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern07 not in ", value, "scorern07");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern07Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern07 between ", value1, value2, "scorern07");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern07NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern07 not between ", value1, value2, "scorern07");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andScorern08IsNull() {
            addCriterion("scorern08 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern08IsNotNull() {
            addCriterion("scorern08 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern08EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern08 =", value, "scorern08");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern08NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern08 <>", value, "scorern08");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern08GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern08 >", value, "scorern08");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern08GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern08 >=", value, "scorern08");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern08LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern08 <", value, "scorern08");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern08LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern08 <=", value, "scorern08");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern08Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern08 like ", value, "scorern08");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern08NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern08 not like ", value, "scorern08");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern08In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern08 in ", value, "scorern08");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern08NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern08 not in ", value, "scorern08");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern08Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern08 between ", value1, value2, "scorern08");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern08NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern08 not between ", value1, value2, "scorern08");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andScorern09IsNull() {
            addCriterion("scorern09 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern09IsNotNull() {
            addCriterion("scorern09 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern09EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern09 =", value, "scorern09");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern09NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern09 <>", value, "scorern09");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern09GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern09 >", value, "scorern09");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern09GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern09 >=", value, "scorern09");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern09LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern09 <", value, "scorern09");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern09LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern09 <=", value, "scorern09");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern09Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern09 like ", value, "scorern09");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern09NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern09 not like ", value, "scorern09");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern09In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern09 in ", value, "scorern09");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern09NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern09 not in ", value, "scorern09");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern09Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern09 between ", value1, value2, "scorern09");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern09NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern09 not between ", value1, value2, "scorern09");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andScorern10IsNull() {
            addCriterion("scorern10 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern10IsNotNull() {
            addCriterion("scorern10 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern10EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern10 =", value, "scorern10");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern10NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern10 <>", value, "scorern10");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern10GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern10 >", value, "scorern10");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern10GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern10 >=", value, "scorern10");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern10LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern10 <", value, "scorern10");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern10LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern10 <=", value, "scorern10");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern10Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern10 like ", value, "scorern10");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern10NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern10 not like ", value, "scorern10");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern10In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern10 in ", value, "scorern10");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern10NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern10 not in ", value, "scorern10");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern10Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern10 between ", value1, value2, "scorern10");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern10NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern10 not between ", value1, value2, "scorern10");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andScorern11IsNull() {
            addCriterion("scorern11 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern11IsNotNull() {
            addCriterion("scorern11 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern11EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern11 =", value, "scorern11");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern11NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern11 <>", value, "scorern11");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern11GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern11 >", value, "scorern11");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern11GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern11 >=", value, "scorern11");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern11LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern11 <", value, "scorern11");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern11LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern11 <=", value, "scorern11");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern11Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern11 like ", value, "scorern11");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern11NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern11 not like ", value, "scorern11");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern11In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern11 in ", value, "scorern11");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern11NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern11 not in ", value, "scorern11");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern11Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern11 between ", value1, value2, "scorern11");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern11NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern11 not between ", value1, value2, "scorern11");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andScorern12IsNull() {
            addCriterion("scorern12 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern12IsNotNull() {
            addCriterion("scorern12 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern12EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern12 =", value, "scorern12");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern12NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern12 <>", value, "scorern12");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern12GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern12 >", value, "scorern12");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern12GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern12 >=", value, "scorern12");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern12LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern12 <", value, "scorern12");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern12LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern12 <=", value, "scorern12");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern12Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern12 like ", value, "scorern12");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern12NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern12 not like ", value, "scorern12");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern12In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern12 in ", value, "scorern12");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern12NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern12 not in ", value, "scorern12");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern12Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern12 between ", value1, value2, "scorern12");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern12NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern12 not between ", value1, value2, "scorern12");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andScorern13IsNull() {
            addCriterion("scorern13 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern13IsNotNull() {
            addCriterion("scorern13 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern13EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern13 =", value, "scorern13");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern13NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern13 <>", value, "scorern13");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern13GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern13 >", value, "scorern13");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern13GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern13 >=", value, "scorern13");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern13LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern13 <", value, "scorern13");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern13LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern13 <=", value, "scorern13");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern13Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern13 like ", value, "scorern13");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern13NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern13 not like ", value, "scorern13");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern13In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern13 in ", value, "scorern13");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern13NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern13 not in ", value, "scorern13");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern13Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern13 between ", value1, value2, "scorern13");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern13NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern13 not between ", value1, value2, "scorern13");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andScorern14IsNull() {
            addCriterion("scorern14 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern14IsNotNull() {
            addCriterion("scorern14 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern14EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern14 =", value, "scorern14");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern14NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern14 <>", value, "scorern14");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern14GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern14 >", value, "scorern14");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern14GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern14 >=", value, "scorern14");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern14LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern14 <", value, "scorern14");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern14LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern14 <=", value, "scorern14");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern14Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern14 like ", value, "scorern14");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern14NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern14 not like ", value, "scorern14");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern14In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern14 in ", value, "scorern14");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern14NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern14 not in ", value, "scorern14");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern14Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern14 between ", value1, value2, "scorern14");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern14NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern14 not between ", value1, value2, "scorern14");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andScorern15IsNull() {
            addCriterion("scorern15 is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern15IsNotNull() {
            addCriterion("scorern15 is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern15EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern15 =", value, "scorern15");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern15NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern15 <>", value, "scorern15");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern15GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern15 >", value, "scorern15");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern15GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern15 >=", value, "scorern15");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern15LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("scorern15 <", value, "scorern15");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern15LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("scorern15 <=", value, "scorern15");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern15Like(java.lang.String value) {
            if (value != null)
              addCriterion("scorern15 like ", value, "scorern15");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern15NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("scorern15 not like ", value, "scorern15");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern15In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("scorern15 in ", value, "scorern15");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern15NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("scorern15 not in ", value, "scorern15");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern15Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern15 between ", value1, value2, "scorern15");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andScorern15NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("scorern15 not between ", value1, value2, "scorern15");
            return (RankingInstanceDetailViewCriteria) this;
        }
        
        public RankingInstanceDetailViewCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (RankingInstanceDetailViewCriteria) this;
        }

        
        public RankingInstanceDetailViewCriteria andYachtbsfIsNull() {
            addCriterion("yachtbsf is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtbsfIsNotNull() {
            addCriterion("yachtbsf is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtbsfEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtbsf =", value, "yachtbsf");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtbsfNotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtbsf <>", value, "yachtbsf");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtbsfGreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtbsf >", value, "yachtbsf");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtbsfGreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtbsf >=", value, "yachtbsf");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtbsfLessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtbsf <", value, "yachtbsf");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtbsfLessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtbsf <=", value, "yachtbsf");
            return (RankingInstanceDetailViewCriteria) this;
        }

        
        public RankingInstanceDetailViewCriteria andYachtgphIsNull() {
            addCriterion("yachtgph is null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtgphIsNotNull() {
            addCriterion("yachtgph is not null");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtgphEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtgph =", value, "yachtgph");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtgphNotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtgph <>", value, "yachtgph");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtgphGreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtgph >", value, "yachtgph");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtgphGreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtgph >=", value, "yachtgph");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtgphLessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtgph <", value, "yachtgph");
            return (RankingInstanceDetailViewCriteria) this;
        }
        public RankingInstanceDetailViewCriteria andYachtgphLessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("yachtgph <=", value, "yachtgph");
            return (RankingInstanceDetailViewCriteria) this;
        }

    }
    
}

