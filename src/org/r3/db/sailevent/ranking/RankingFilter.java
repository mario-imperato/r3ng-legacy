//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.ranking;

import java.util.ArrayList;
import java.util.List;

public class RankingFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public RankingFilter() 
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

    public RankingCriteria or() 
    {
        RankingCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public RankingCriteria createCriteria() 
    {
        RankingCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected RankingCriteria createCriteriaInternal() 
    {
        RankingCriteria criteria = new RankingCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class RankingCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public RankingCriteria andEventidIsNull() {
            addCriterion("eventid is null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andEventidIsNotNull() {
            addCriterion("eventid is not null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andEventidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid =", value, "eventid");
            return (RankingCriteria) this;
        }
        public RankingCriteria andEventidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <>", value, "eventid");
            return (RankingCriteria) this;
        }
        public RankingCriteria andEventidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >", value, "eventid");
            return (RankingCriteria) this;
        }
        public RankingCriteria andEventidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >=", value, "eventid");
            return (RankingCriteria) this;
        }
        public RankingCriteria andEventidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <", value, "eventid");
            return (RankingCriteria) this;
        }
        public RankingCriteria andEventidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <=", value, "eventid");
            return (RankingCriteria) this;
        }
        public RankingCriteria andEventidLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid like ", value, "eventid");
            return (RankingCriteria) this;
        }
        public RankingCriteria andEventidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid not like ", value, "eventid");
            return (RankingCriteria) this;
        }
        public RankingCriteria andEventidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("eventid in ", value, "eventid");
            return (RankingCriteria) this;
        }
        public RankingCriteria andEventidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("eventid not in ", value, "eventid");
            return (RankingCriteria) this;
        }
        public RankingCriteria andEventidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid between ", value1, value2, "eventid");
            return (RankingCriteria) this;
        }
        public RankingCriteria andEventidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid not between ", value1, value2, "eventid");
            return (RankingCriteria) this;
        }
        
        public RankingCriteria andRankidIsNull() {
            addCriterion("rankid is null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankidIsNotNull() {
            addCriterion("rankid is not null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankid =", value, "rankid");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankid <>", value, "rankid");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("rankid >", value, "rankid");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankid >=", value, "rankid");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("rankid <", value, "rankid");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankid <=", value, "rankid");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankidLike(java.lang.String value) {
            if (value != null)
              addCriterion("rankid like ", value, "rankid");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("rankid not like ", value, "rankid");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("rankid in ", value, "rankid");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("rankid not in ", value, "rankid");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("rankid between ", value1, value2, "rankid");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("rankid not between ", value1, value2, "rankid");
            return (RankingCriteria) this;
        }
        
        public RankingCriteria andRankinggroupIsNull() {
            addCriterion("rankinggroup is null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankinggroupIsNotNull() {
            addCriterion("rankinggroup is not null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankinggroupEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankinggroup =", value, "rankinggroup");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankinggroupNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankinggroup <>", value, "rankinggroup");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankinggroupGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("rankinggroup >", value, "rankinggroup");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankinggroupGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankinggroup >=", value, "rankinggroup");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankinggroupLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("rankinggroup <", value, "rankinggroup");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankinggroupLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankinggroup <=", value, "rankinggroup");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankinggroupLike(java.lang.String value) {
            if (value != null)
              addCriterion("rankinggroup like ", value, "rankinggroup");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankinggroupNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("rankinggroup not like ", value, "rankinggroup");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankinggroupIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("rankinggroup in ", value, "rankinggroup");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankinggroupNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("rankinggroup not in ", value, "rankinggroup");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankinggroupBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("rankinggroup between ", value1, value2, "rankinggroup");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankinggroupNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("rankinggroup not between ", value1, value2, "rankinggroup");
            return (RankingCriteria) this;
        }
        
        public RankingCriteria andRanktitleIsNull() {
            addCriterion("ranktitle is null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktitleIsNotNull() {
            addCriterion("ranktitle is not null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktitleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ranktitle =", value, "ranktitle");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktitleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ranktitle <>", value, "ranktitle");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktitleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("ranktitle >", value, "ranktitle");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktitleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ranktitle >=", value, "ranktitle");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktitleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("ranktitle <", value, "ranktitle");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktitleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ranktitle <=", value, "ranktitle");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktitleLike(java.lang.String value) {
            if (value != null)
              addCriterion("ranktitle like ", value, "ranktitle");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktitleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("ranktitle not like ", value, "ranktitle");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktitleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("ranktitle in ", value, "ranktitle");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktitleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("ranktitle not in ", value, "ranktitle");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktitleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ranktitle between ", value1, value2, "ranktitle");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktitleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ranktitle not between ", value1, value2, "ranktitle");
            return (RankingCriteria) this;
        }
        
        public RankingCriteria andRanktypeIsNull() {
            addCriterion("ranktype is null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktypeIsNotNull() {
            addCriterion("ranktype is not null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ranktype =", value, "ranktype");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ranktype <>", value, "ranktype");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("ranktype >", value, "ranktype");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ranktype >=", value, "ranktype");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("ranktype <", value, "ranktype");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("ranktype <=", value, "ranktype");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("ranktype like ", value, "ranktype");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("ranktype not like ", value, "ranktype");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("ranktype in ", value, "ranktype");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("ranktype not in ", value, "ranktype");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ranktype between ", value1, value2, "ranktype");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRanktypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("ranktype not between ", value1, value2, "ranktype");
            return (RankingCriteria) this;
        }
        
        public RankingCriteria andChampionshipIsNull() {
            addCriterion("championship is null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andChampionshipIsNotNull() {
            addCriterion("championship is not null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andChampionshipEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("championship =", value, "championship");
            return (RankingCriteria) this;
        }
        public RankingCriteria andChampionshipNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("championship <>", value, "championship");
            return (RankingCriteria) this;
        }
        public RankingCriteria andChampionshipGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("championship >", value, "championship");
            return (RankingCriteria) this;
        }
        public RankingCriteria andChampionshipGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("championship >=", value, "championship");
            return (RankingCriteria) this;
        }
        public RankingCriteria andChampionshipLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("championship <", value, "championship");
            return (RankingCriteria) this;
        }
        public RankingCriteria andChampionshipLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("championship <=", value, "championship");
            return (RankingCriteria) this;
        }
        public RankingCriteria andChampionshipLike(java.lang.String value) {
            if (value != null)
              addCriterion("championship like ", value, "championship");
            return (RankingCriteria) this;
        }
        public RankingCriteria andChampionshipNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("championship not like ", value, "championship");
            return (RankingCriteria) this;
        }
        public RankingCriteria andChampionshipIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("championship in ", value, "championship");
            return (RankingCriteria) this;
        }
        public RankingCriteria andChampionshipNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("championship not in ", value, "championship");
            return (RankingCriteria) this;
        }
        public RankingCriteria andChampionshipBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("championship between ", value1, value2, "championship");
            return (RankingCriteria) this;
        }
        public RankingCriteria andChampionshipNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("championship not between ", value1, value2, "championship");
            return (RankingCriteria) this;
        }
        
        public RankingCriteria andRacegroupIsNull() {
            addCriterion("racegroup is null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacegroupIsNotNull() {
            addCriterion("racegroup is not null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacegroupEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup =", value, "racegroup");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacegroupNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup <>", value, "racegroup");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacegroupGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup >", value, "racegroup");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacegroupGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup >=", value, "racegroup");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacegroupLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup <", value, "racegroup");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacegroupLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup <=", value, "racegroup");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacegroupLike(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup like ", value, "racegroup");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacegroupNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("racegroup not like ", value, "racegroup");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacegroupIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("racegroup in ", value, "racegroup");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacegroupNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("racegroup not in ", value, "racegroup");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacegroupBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racegroup between ", value1, value2, "racegroup");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacegroupNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racegroup not between ", value1, value2, "racegroup");
            return (RankingCriteria) this;
        }
        
        public RankingCriteria andRaceclassIsNull() {
            addCriterion("raceclass is null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRaceclassIsNotNull() {
            addCriterion("raceclass is not null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRaceclassEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass =", value, "raceclass");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRaceclassNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass <>", value, "raceclass");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRaceclassGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass >", value, "raceclass");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRaceclassGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass >=", value, "raceclass");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRaceclassLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass <", value, "raceclass");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRaceclassLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass <=", value, "raceclass");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRaceclassLike(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass like ", value, "raceclass");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRaceclassNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("raceclass not like ", value, "raceclass");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRaceclassIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("raceclass in ", value, "raceclass");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRaceclassNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("raceclass not in ", value, "raceclass");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRaceclassBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("raceclass between ", value1, value2, "raceclass");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRaceclassNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("raceclass not between ", value1, value2, "raceclass");
            return (RankingCriteria) this;
        }
        
        public RankingCriteria andRatingIsNull() {
            addCriterion("rating is null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRatingIsNotNull() {
            addCriterion("rating is not null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRatingEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rating =", value, "rating");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRatingNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rating <>", value, "rating");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRatingGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("rating >", value, "rating");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRatingGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rating >=", value, "rating");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRatingLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("rating <", value, "rating");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRatingLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rating <=", value, "rating");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRatingLike(java.lang.String value) {
            if (value != null)
              addCriterion("rating like ", value, "rating");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRatingNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("rating not like ", value, "rating");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRatingIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("rating in ", value, "rating");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRatingNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("rating not in ", value, "rating");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRatingBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("rating between ", value1, value2, "rating");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRatingNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("rating not between ", value1, value2, "rating");
            return (RankingCriteria) this;
        }
        
        public RankingCriteria andRacefilepatternIsNull() {
            addCriterion("racefilepattern is null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacefilepatternIsNotNull() {
            addCriterion("racefilepattern is not null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacefilepatternEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racefilepattern =", value, "racefilepattern");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacefilepatternNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racefilepattern <>", value, "racefilepattern");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacefilepatternGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("racefilepattern >", value, "racefilepattern");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacefilepatternGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racefilepattern >=", value, "racefilepattern");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacefilepatternLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("racefilepattern <", value, "racefilepattern");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacefilepatternLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racefilepattern <=", value, "racefilepattern");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacefilepatternLike(java.lang.String value) {
            if (value != null)
              addCriterion("racefilepattern like ", value, "racefilepattern");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacefilepatternNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("racefilepattern not like ", value, "racefilepattern");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacefilepatternIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("racefilepattern in ", value, "racefilepattern");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacefilepatternNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("racefilepattern not in ", value, "racefilepattern");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacefilepatternBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racefilepattern between ", value1, value2, "racefilepattern");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRacefilepatternNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racefilepattern not between ", value1, value2, "racefilepattern");
            return (RankingCriteria) this;
        }
        
        public RankingCriteria andOverallfilepatternIsNull() {
            addCriterion("overallfilepattern is null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andOverallfilepatternIsNotNull() {
            addCriterion("overallfilepattern is not null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andOverallfilepatternEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("overallfilepattern =", value, "overallfilepattern");
            return (RankingCriteria) this;
        }
        public RankingCriteria andOverallfilepatternNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("overallfilepattern <>", value, "overallfilepattern");
            return (RankingCriteria) this;
        }
        public RankingCriteria andOverallfilepatternGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("overallfilepattern >", value, "overallfilepattern");
            return (RankingCriteria) this;
        }
        public RankingCriteria andOverallfilepatternGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("overallfilepattern >=", value, "overallfilepattern");
            return (RankingCriteria) this;
        }
        public RankingCriteria andOverallfilepatternLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("overallfilepattern <", value, "overallfilepattern");
            return (RankingCriteria) this;
        }
        public RankingCriteria andOverallfilepatternLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("overallfilepattern <=", value, "overallfilepattern");
            return (RankingCriteria) this;
        }
        public RankingCriteria andOverallfilepatternLike(java.lang.String value) {
            if (value != null)
              addCriterion("overallfilepattern like ", value, "overallfilepattern");
            return (RankingCriteria) this;
        }
        public RankingCriteria andOverallfilepatternNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("overallfilepattern not like ", value, "overallfilepattern");
            return (RankingCriteria) this;
        }
        public RankingCriteria andOverallfilepatternIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("overallfilepattern in ", value, "overallfilepattern");
            return (RankingCriteria) this;
        }
        public RankingCriteria andOverallfilepatternNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("overallfilepattern not in ", value, "overallfilepattern");
            return (RankingCriteria) this;
        }
        public RankingCriteria andOverallfilepatternBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("overallfilepattern between ", value1, value2, "overallfilepattern");
            return (RankingCriteria) this;
        }
        public RankingCriteria andOverallfilepatternNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("overallfilepattern not between ", value1, value2, "overallfilepattern");
            return (RankingCriteria) this;
        }
        
        public RankingCriteria andRankorderingIsNull() {
            addCriterion("rankordering is null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankorderingIsNotNull() {
            addCriterion("rankordering is not null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankorderingEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("rankordering =", value, "rankordering");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankorderingNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("rankordering <>", value, "rankordering");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankorderingGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("rankordering >", value, "rankordering");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankorderingGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("rankordering >=", value, "rankordering");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankorderingLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("rankordering <", value, "rankordering");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRankorderingLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("rankordering <=", value, "rankordering");
            return (RankingCriteria) this;
        }

        
        public RankingCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (RankingCriteria) this;
        }
        public RankingCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (RankingCriteria) this;
        }

    }
    
}

