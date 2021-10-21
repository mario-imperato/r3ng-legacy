//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.rankinginstanceview;

import java.util.ArrayList;
import java.util.List;

public class RankingInstanceViewFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public RankingInstanceViewFilter() 
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

    public RankingInstanceViewCriteria or() 
    {
        RankingInstanceViewCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public RankingInstanceViewCriteria createCriteria() 
    {
        RankingInstanceViewCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected RankingInstanceViewCriteria createCriteriaInternal() 
    {
        RankingInstanceViewCriteria criteria = new RankingInstanceViewCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class RankingInstanceViewCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public RankingInstanceViewCriteria andEventidIsNull() {
            addCriterion("eventid is null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andEventidIsNotNull() {
            addCriterion("eventid is not null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andEventidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid =", value, "eventid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andEventidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <>", value, "eventid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andEventidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >", value, "eventid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andEventidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >=", value, "eventid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andEventidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <", value, "eventid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andEventidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <=", value, "eventid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andEventidLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid like ", value, "eventid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andEventidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid not like ", value, "eventid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andEventidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("eventid in ", value, "eventid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andEventidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("eventid not in ", value, "eventid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andEventidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid between ", value1, value2, "eventid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andEventidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid not between ", value1, value2, "eventid");
            return (RankingInstanceViewCriteria) this;
        }
        
        public RankingInstanceViewCriteria andRankidIsNull() {
            addCriterion("rankid is null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankidIsNotNull() {
            addCriterion("rankid is not null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankid =", value, "rankid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankid <>", value, "rankid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("rankid >", value, "rankid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankid >=", value, "rankid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("rankid <", value, "rankid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankid <=", value, "rankid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankidLike(java.lang.String value) {
            if (value != null)
              addCriterion("rankid like ", value, "rankid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("rankid not like ", value, "rankid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("rankid in ", value, "rankid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("rankid not in ", value, "rankid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("rankid between ", value1, value2, "rankid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("rankid not between ", value1, value2, "rankid");
            return (RankingInstanceViewCriteria) this;
        }
        
        public RankingInstanceViewCriteria andRanktypeIsNull() {
            addCriterion("ranktype is null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktypeIsNotNull() {
            addCriterion("ranktype is not null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ranktype =", value, "ranktype");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ranktype <>", value, "ranktype");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("ranktype >", value, "ranktype");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ranktype >=", value, "ranktype");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("ranktype <", value, "ranktype");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ranktype <=", value, "ranktype");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("ranktype like ", value, "ranktype");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("ranktype not like ", value, "ranktype");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("ranktype in ", value, "ranktype");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("ranktype not in ", value, "ranktype");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ranktype between ", value1, value2, "ranktype");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ranktype not between ", value1, value2, "ranktype");
            return (RankingInstanceViewCriteria) this;
        }
        
        public RankingInstanceViewCriteria andRanktitleIsNull() {
            addCriterion("ranktitle is null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktitleIsNotNull() {
            addCriterion("ranktitle is not null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktitleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ranktitle =", value, "ranktitle");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktitleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ranktitle <>", value, "ranktitle");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktitleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("ranktitle >", value, "ranktitle");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktitleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ranktitle >=", value, "ranktitle");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktitleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("ranktitle <", value, "ranktitle");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktitleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ranktitle <=", value, "ranktitle");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktitleLike(java.lang.String value) {
            if (value != null)
              addCriterion("ranktitle like ", value, "ranktitle");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktitleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("ranktitle not like ", value, "ranktitle");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktitleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("ranktitle in ", value, "ranktitle");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktitleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("ranktitle not in ", value, "ranktitle");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktitleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ranktitle between ", value1, value2, "ranktitle");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRanktitleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ranktitle not between ", value1, value2, "ranktitle");
            return (RankingInstanceViewCriteria) this;
        }
        
        public RankingInstanceViewCriteria andRacegroupIsNull() {
            addCriterion("racegroup is null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacegroupIsNotNull() {
            addCriterion("racegroup is not null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacegroupEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup =", value, "racegroup");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacegroupNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup <>", value, "racegroup");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacegroupGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup >", value, "racegroup");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacegroupGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup >=", value, "racegroup");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacegroupLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup <", value, "racegroup");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacegroupLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup <=", value, "racegroup");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacegroupLike(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup like ", value, "racegroup");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacegroupNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup not like ", value, "racegroup");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacegroupIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("racegroup in ", value, "racegroup");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacegroupNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("racegroup not in ", value, "racegroup");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacegroupBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racegroup between ", value1, value2, "racegroup");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacegroupNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racegroup not between ", value1, value2, "racegroup");
            return (RankingInstanceViewCriteria) this;
        }
        
        public RankingInstanceViewCriteria andRaceclassIsNull() {
            addCriterion("raceclass is null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceclassIsNotNull() {
            addCriterion("raceclass is not null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceclassEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass =", value, "raceclass");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceclassNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass <>", value, "raceclass");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceclassGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass >", value, "raceclass");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceclassGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass >=", value, "raceclass");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceclassLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass <", value, "raceclass");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceclassLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass <=", value, "raceclass");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceclassLike(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass like ", value, "raceclass");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceclassNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass not like ", value, "raceclass");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceclassIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("raceclass in ", value, "raceclass");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceclassNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("raceclass not in ", value, "raceclass");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceclassBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("raceclass between ", value1, value2, "raceclass");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceclassNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("raceclass not between ", value1, value2, "raceclass");
            return (RankingInstanceViewCriteria) this;
        }
        
        public RankingInstanceViewCriteria andRankrateorgIsNull() {
            addCriterion("rankrateorg is null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankrateorgIsNotNull() {
            addCriterion("rankrateorg is not null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankrateorgEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankrateorg =", value, "rankrateorg");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankrateorgNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankrateorg <>", value, "rankrateorg");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankrateorgGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("rankrateorg >", value, "rankrateorg");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankrateorgGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankrateorg >=", value, "rankrateorg");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankrateorgLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("rankrateorg <", value, "rankrateorg");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankrateorgLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankrateorg <=", value, "rankrateorg");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankrateorgLike(java.lang.String value) {
            if (value != null)
              addCriterion("rankrateorg like ", value, "rankrateorg");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankrateorgNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("rankrateorg not like ", value, "rankrateorg");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankrateorgIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("rankrateorg in ", value, "rankrateorg");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankrateorgNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("rankrateorg not in ", value, "rankrateorg");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankrateorgBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("rankrateorg between ", value1, value2, "rankrateorg");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRankrateorgNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("rankrateorg not between ", value1, value2, "rankrateorg");
            return (RankingInstanceViewCriteria) this;
        }
        
        public RankingInstanceViewCriteria andInstanceidIsNull() {
            addCriterion("instanceid is null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstanceidIsNotNull() {
            addCriterion("instanceid is not null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstanceidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid =", value, "instanceid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstanceidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid <>", value, "instanceid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstanceidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid >", value, "instanceid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstanceidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid >=", value, "instanceid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstanceidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid <", value, "instanceid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstanceidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid <=", value, "instanceid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstanceidLike(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid like ", value, "instanceid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstanceidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid not like ", value, "instanceid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstanceidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("instanceid in ", value, "instanceid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstanceidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("instanceid not in ", value, "instanceid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstanceidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("instanceid between ", value1, value2, "instanceid");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstanceidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("instanceid not between ", value1, value2, "instanceid");
            return (RankingInstanceViewCriteria) this;
        }
        
        public RankingInstanceViewCriteria andInstancetypeIsNull() {
            addCriterion("instancetype is null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstancetypeIsNotNull() {
            addCriterion("instancetype is not null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstancetypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instancetype =", value, "instancetype");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstancetypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instancetype <>", value, "instancetype");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstancetypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("instancetype >", value, "instancetype");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstancetypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instancetype >=", value, "instancetype");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstancetypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("instancetype <", value, "instancetype");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstancetypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instancetype <=", value, "instancetype");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstancetypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("instancetype like ", value, "instancetype");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstancetypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("instancetype not like ", value, "instancetype");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstancetypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("instancetype in ", value, "instancetype");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstancetypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("instancetype not in ", value, "instancetype");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstancetypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("instancetype between ", value1, value2, "instancetype");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andInstancetypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("instancetype not between ", value1, value2, "instancetype");
            return (RankingInstanceViewCriteria) this;
        }
        
        public RankingInstanceViewCriteria andRacenumberIsNull() {
            addCriterion("racenumber is null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacenumberIsNotNull() {
            addCriterion("racenumber is not null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacenumberEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("racenumber =", value, "racenumber");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacenumberNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("racenumber <>", value, "racenumber");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacenumberGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("racenumber >", value, "racenumber");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacenumberGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("racenumber >=", value, "racenumber");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacenumberLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("racenumber <", value, "racenumber");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacenumberLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("racenumber <=", value, "racenumber");
            return (RankingInstanceViewCriteria) this;
        }

        
        public RankingInstanceViewCriteria andRacedateIsNull() {
            addCriterion("racedate is null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacedateIsNotNull() {
            addCriterion("racedate is not null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacedateEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("racedate =", value, "racedate");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacedateNotEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("racedate <>", value, "racedate");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacedateGreaterThan(java.sql.Date value) {
            if (value != null)
              addCriterion("racedate >", value, "racedate");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacedateGreaterThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("racedate >=", value, "racedate");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacedateLessThan(java.sql.Date value) {
            if (value != null)
              addCriterion("racedate <", value, "racedate");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacedateLessThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("racedate <=", value, "racedate");
            return (RankingInstanceViewCriteria) this;
        }

        
        public RankingInstanceViewCriteria andRacetimeIsNull() {
            addCriterion("racetime is null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacetimeIsNotNull() {
            addCriterion("racetime is not null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacetimeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racetime =", value, "racetime");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacetimeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racetime <>", value, "racetime");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacetimeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("racetime >", value, "racetime");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacetimeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racetime >=", value, "racetime");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacetimeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("racetime <", value, "racetime");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacetimeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racetime <=", value, "racetime");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacetimeLike(java.lang.String value) {
            if (value != null)
              addCriterion("racetime like ", value, "racetime");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacetimeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("racetime not like ", value, "racetime");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacetimeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("racetime in ", value, "racetime");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacetimeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("racetime not in ", value, "racetime");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacetimeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racetime between ", value1, value2, "racetime");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacetimeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racetime not between ", value1, value2, "racetime");
            return (RankingInstanceViewCriteria) this;
        }
        

        
        public RankingInstanceViewCriteria andRaceratingIsNull() {
            addCriterion("racerating is null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceratingIsNotNull() {
            addCriterion("racerating is not null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceratingEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racerating =", value, "racerating");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceratingNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racerating <>", value, "racerating");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceratingGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("racerating >", value, "racerating");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceratingGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racerating >=", value, "racerating");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceratingLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("racerating <", value, "racerating");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceratingLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racerating <=", value, "racerating");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceratingLike(java.lang.String value) {
            if (value != null)
              addCriterion("racerating like ", value, "racerating");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceratingNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("racerating not like ", value, "racerating");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceratingIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("racerating in ", value, "racerating");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceratingNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("racerating not in ", value, "racerating");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceratingBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racerating between ", value1, value2, "racerating");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRaceratingNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racerating not between ", value1, value2, "racerating");
            return (RankingInstanceViewCriteria) this;
        }
        
        public RankingInstanceViewCriteria andRacefiledmsurlIsNull() {
            addCriterion("racefiledmsurl is null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacefiledmsurlIsNotNull() {
            addCriterion("racefiledmsurl is not null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacefiledmsurlEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racefiledmsurl =", value, "racefiledmsurl");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacefiledmsurlNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racefiledmsurl <>", value, "racefiledmsurl");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacefiledmsurlGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("racefiledmsurl >", value, "racefiledmsurl");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacefiledmsurlGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racefiledmsurl >=", value, "racefiledmsurl");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacefiledmsurlLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("racefiledmsurl <", value, "racefiledmsurl");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacefiledmsurlLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racefiledmsurl <=", value, "racefiledmsurl");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacefiledmsurlLike(java.lang.String value) {
            if (value != null)
              addCriterion("racefiledmsurl like ", value, "racefiledmsurl");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacefiledmsurlNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("racefiledmsurl not like ", value, "racefiledmsurl");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacefiledmsurlIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("racefiledmsurl in ", value, "racefiledmsurl");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacefiledmsurlNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("racefiledmsurl not in ", value, "racefiledmsurl");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacefiledmsurlBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racefiledmsurl between ", value1, value2, "racefiledmsurl");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRacefiledmsurlNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racefiledmsurl not between ", value1, value2, "racefiledmsurl");
            return (RankingInstanceViewCriteria) this;
        }
        
        public RankingInstanceViewCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (RankingInstanceViewCriteria) this;
        }
        public RankingInstanceViewCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (RankingInstanceViewCriteria) this;
        }

    }
    
}

