//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.rankingview;

import java.util.ArrayList;
import java.util.List;

public class RankingViewFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public RankingViewFilter() 
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

    public RankingViewCriteria or() 
    {
        RankingViewCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public RankingViewCriteria createCriteria() 
    {
        RankingViewCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected RankingViewCriteria createCriteriaInternal() 
    {
        RankingViewCriteria criteria = new RankingViewCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class RankingViewCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public RankingViewCriteria andEventidIsNull() {
            addCriterion("eventid is null");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andEventidIsNotNull() {
            addCriterion("eventid is not null");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andEventidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid =", value, "eventid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andEventidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <>", value, "eventid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andEventidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >", value, "eventid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andEventidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >=", value, "eventid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andEventidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <", value, "eventid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andEventidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <=", value, "eventid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andEventidLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid like ", value, "eventid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andEventidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid not like ", value, "eventid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andEventidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("eventid in ", value, "eventid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andEventidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("eventid not in ", value, "eventid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andEventidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid between ", value1, value2, "eventid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andEventidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid not between ", value1, value2, "eventid");
            return (RankingViewCriteria) this;
        }
        
        public RankingViewCriteria andRankidIsNull() {
            addCriterion("rankid is null");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankidIsNotNull() {
            addCriterion("rankid is not null");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankid =", value, "rankid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankid <>", value, "rankid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("rankid >", value, "rankid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankid >=", value, "rankid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("rankid <", value, "rankid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankid <=", value, "rankid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankidLike(java.lang.String value) {
            if (value != null)
              addCriterion("rankid like ", value, "rankid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("rankid not like ", value, "rankid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("rankid in ", value, "rankid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("rankid not in ", value, "rankid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("rankid between ", value1, value2, "rankid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("rankid not between ", value1, value2, "rankid");
            return (RankingViewCriteria) this;
        }
        
        public RankingViewCriteria andRankinggroupIsNull() {
            addCriterion("rankinggroup is null");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankinggroupIsNotNull() {
            addCriterion("rankinggroup is not null");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankinggroupEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankinggroup =", value, "rankinggroup");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankinggroupNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankinggroup <>", value, "rankinggroup");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankinggroupGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("rankinggroup >", value, "rankinggroup");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankinggroupGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankinggroup >=", value, "rankinggroup");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankinggroupLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("rankinggroup <", value, "rankinggroup");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankinggroupLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankinggroup <=", value, "rankinggroup");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankinggroupLike(java.lang.String value) {
            if (value != null)
              addCriterion("rankinggroup like ", value, "rankinggroup");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankinggroupNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("rankinggroup not like ", value, "rankinggroup");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankinggroupIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("rankinggroup in ", value, "rankinggroup");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankinggroupNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("rankinggroup not in ", value, "rankinggroup");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankinggroupBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("rankinggroup between ", value1, value2, "rankinggroup");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankinggroupNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("rankinggroup not between ", value1, value2, "rankinggroup");
            return (RankingViewCriteria) this;
        }
        
        public RankingViewCriteria andRanktitleIsNull() {
            addCriterion("ranktitle is null");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRanktitleIsNotNull() {
            addCriterion("ranktitle is not null");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRanktitleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ranktitle =", value, "ranktitle");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRanktitleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ranktitle <>", value, "ranktitle");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRanktitleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("ranktitle >", value, "ranktitle");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRanktitleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ranktitle >=", value, "ranktitle");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRanktitleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("ranktitle <", value, "ranktitle");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRanktitleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ranktitle <=", value, "ranktitle");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRanktitleLike(java.lang.String value) {
            if (value != null)
              addCriterion("ranktitle like ", value, "ranktitle");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRanktitleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("ranktitle not like ", value, "ranktitle");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRanktitleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("ranktitle in ", value, "ranktitle");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRanktitleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("ranktitle not in ", value, "ranktitle");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRanktitleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ranktitle between ", value1, value2, "ranktitle");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRanktitleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ranktitle not between ", value1, value2, "ranktitle");
            return (RankingViewCriteria) this;
        }
        
        public RankingViewCriteria andRacegroupIsNull() {
            addCriterion("racegroup is null");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacegroupIsNotNull() {
            addCriterion("racegroup is not null");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacegroupEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup =", value, "racegroup");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacegroupNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup <>", value, "racegroup");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacegroupGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup >", value, "racegroup");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacegroupGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup >=", value, "racegroup");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacegroupLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup <", value, "racegroup");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacegroupLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup <=", value, "racegroup");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacegroupLike(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup like ", value, "racegroup");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacegroupNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup not like ", value, "racegroup");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacegroupIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("racegroup in ", value, "racegroup");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacegroupNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("racegroup not in ", value, "racegroup");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacegroupBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racegroup between ", value1, value2, "racegroup");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacegroupNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racegroup not between ", value1, value2, "racegroup");
            return (RankingViewCriteria) this;
        }
        
        public RankingViewCriteria andRaceclassIsNull() {
            addCriterion("raceclass is null");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRaceclassIsNotNull() {
            addCriterion("raceclass is not null");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRaceclassEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass =", value, "raceclass");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRaceclassNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass <>", value, "raceclass");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRaceclassGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass >", value, "raceclass");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRaceclassGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass >=", value, "raceclass");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRaceclassLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass <", value, "raceclass");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRaceclassLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass <=", value, "raceclass");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRaceclassLike(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass like ", value, "raceclass");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRaceclassNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass not like ", value, "raceclass");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRaceclassIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("raceclass in ", value, "raceclass");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRaceclassNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("raceclass not in ", value, "raceclass");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRaceclassBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("raceclass between ", value1, value2, "raceclass");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRaceclassNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("raceclass not between ", value1, value2, "raceclass");
            return (RankingViewCriteria) this;
        }
        
        public RankingViewCriteria andRankorderingIsNull() {
            addCriterion("rankordering is null");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankorderingIsNotNull() {
            addCriterion("rankordering is not null");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankorderingEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("rankordering =", value, "rankordering");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankorderingNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("rankordering <>", value, "rankordering");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankorderingGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("rankordering >", value, "rankordering");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankorderingGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("rankordering >=", value, "rankordering");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankorderingLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("rankordering <", value, "rankordering");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRankorderingLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("rankordering <=", value, "rankordering");
            return (RankingViewCriteria) this;
        }

        
        public RankingViewCriteria andInstanceidIsNull() {
            addCriterion("instanceid is null");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstanceidIsNotNull() {
            addCriterion("instanceid is not null");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstanceidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid =", value, "instanceid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstanceidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid <>", value, "instanceid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstanceidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid >", value, "instanceid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstanceidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid >=", value, "instanceid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstanceidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid <", value, "instanceid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstanceidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid <=", value, "instanceid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstanceidLike(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid like ", value, "instanceid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstanceidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid not like ", value, "instanceid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstanceidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("instanceid in ", value, "instanceid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstanceidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("instanceid not in ", value, "instanceid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstanceidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("instanceid between ", value1, value2, "instanceid");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstanceidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("instanceid not between ", value1, value2, "instanceid");
            return (RankingViewCriteria) this;
        }
        
        public RankingViewCriteria andInstancetypeIsNull() {
            addCriterion("instancetype is null");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstancetypeIsNotNull() {
            addCriterion("instancetype is not null");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstancetypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instancetype =", value, "instancetype");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstancetypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instancetype <>", value, "instancetype");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstancetypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("instancetype >", value, "instancetype");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstancetypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instancetype >=", value, "instancetype");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstancetypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("instancetype <", value, "instancetype");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstancetypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instancetype <=", value, "instancetype");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstancetypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("instancetype like ", value, "instancetype");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstancetypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("instancetype not like ", value, "instancetype");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstancetypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("instancetype in ", value, "instancetype");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstancetypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("instancetype not in ", value, "instancetype");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstancetypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("instancetype between ", value1, value2, "instancetype");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andInstancetypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("instancetype not between ", value1, value2, "instancetype");
            return (RankingViewCriteria) this;
        }
        
        public RankingViewCriteria andRacenumberIsNull() {
            addCriterion("racenumber is null");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacenumberIsNotNull() {
            addCriterion("racenumber is not null");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacenumberEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("racenumber =", value, "racenumber");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacenumberNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("racenumber <>", value, "racenumber");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacenumberGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("racenumber >", value, "racenumber");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacenumberGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("racenumber >=", value, "racenumber");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacenumberLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("racenumber <", value, "racenumber");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacenumberLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("racenumber <=", value, "racenumber");
            return (RankingViewCriteria) this;
        }

        
        public RankingViewCriteria andRacefiledmsurlIsNull() {
            addCriterion("racefiledmsurl is null");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacefiledmsurlIsNotNull() {
            addCriterion("racefiledmsurl is not null");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacefiledmsurlEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racefiledmsurl =", value, "racefiledmsurl");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacefiledmsurlNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racefiledmsurl <>", value, "racefiledmsurl");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacefiledmsurlGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("racefiledmsurl >", value, "racefiledmsurl");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacefiledmsurlGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racefiledmsurl >=", value, "racefiledmsurl");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacefiledmsurlLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("racefiledmsurl <", value, "racefiledmsurl");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacefiledmsurlLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racefiledmsurl <=", value, "racefiledmsurl");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacefiledmsurlLike(java.lang.String value) {
            if (value != null)
              addCriterion("racefiledmsurl like ", value, "racefiledmsurl");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacefiledmsurlNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("racefiledmsurl not like ", value, "racefiledmsurl");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacefiledmsurlIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("racefiledmsurl in ", value, "racefiledmsurl");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacefiledmsurlNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("racefiledmsurl not in ", value, "racefiledmsurl");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacefiledmsurlBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racefiledmsurl between ", value1, value2, "racefiledmsurl");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacefiledmsurlNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racefiledmsurl not between ", value1, value2, "racefiledmsurl");
            return (RankingViewCriteria) this;
        }
        
        public RankingViewCriteria andRacedateIsNull() {
            addCriterion("racedate is null");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacedateIsNotNull() {
            addCriterion("racedate is not null");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacedateEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("racedate =", value, "racedate");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacedateNotEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("racedate <>", value, "racedate");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacedateGreaterThan(java.sql.Date value) {
            if (value != null)
              addCriterion("racedate >", value, "racedate");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacedateGreaterThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("racedate >=", value, "racedate");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacedateLessThan(java.sql.Date value) {
            if (value != null)
              addCriterion("racedate <", value, "racedate");
            return (RankingViewCriteria) this;
        }
        public RankingViewCriteria andRacedateLessThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("racedate <=", value, "racedate");
            return (RankingViewCriteria) this;
        }

    }
    
}

