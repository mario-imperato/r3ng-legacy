//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.rankinginstance;

import java.util.ArrayList;
import java.util.List;

public class RankingInstanceFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public RankingInstanceFilter() 
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

    public RankingInstanceCriteria or() 
    {
        RankingInstanceCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public RankingInstanceCriteria createCriteria() 
    {
        RankingInstanceCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected RankingInstanceCriteria createCriteriaInternal() 
    {
        RankingInstanceCriteria criteria = new RankingInstanceCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class RankingInstanceCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public RankingInstanceCriteria andEventidIsNull() {
            addCriterion("eventid is null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andEventidIsNotNull() {
            addCriterion("eventid is not null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andEventidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid =", value, "eventid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andEventidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <>", value, "eventid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andEventidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >", value, "eventid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andEventidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >=", value, "eventid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andEventidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <", value, "eventid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andEventidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <=", value, "eventid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andEventidLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid like ", value, "eventid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andEventidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid not like ", value, "eventid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andEventidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("eventid in ", value, "eventid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andEventidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("eventid not in ", value, "eventid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andEventidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid between ", value1, value2, "eventid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andEventidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid not between ", value1, value2, "eventid");
            return (RankingInstanceCriteria) this;
        }
        
        public RankingInstanceCriteria andInstanceidIsNull() {
            addCriterion("instanceid is null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstanceidIsNotNull() {
            addCriterion("instanceid is not null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstanceidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid =", value, "instanceid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstanceidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid <>", value, "instanceid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstanceidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid >", value, "instanceid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstanceidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid >=", value, "instanceid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstanceidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid <", value, "instanceid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstanceidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid <=", value, "instanceid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstanceidLike(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid like ", value, "instanceid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstanceidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("instanceid not like ", value, "instanceid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstanceidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("instanceid in ", value, "instanceid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstanceidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("instanceid not in ", value, "instanceid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstanceidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("instanceid between ", value1, value2, "instanceid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstanceidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("instanceid not between ", value1, value2, "instanceid");
            return (RankingInstanceCriteria) this;
        }
        
        public RankingInstanceCriteria andRankidIsNull() {
            addCriterion("rankid is null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRankidIsNotNull() {
            addCriterion("rankid is not null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRankidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankid =", value, "rankid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRankidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankid <>", value, "rankid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRankidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("rankid >", value, "rankid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRankidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankid >=", value, "rankid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRankidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("rankid <", value, "rankid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRankidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rankid <=", value, "rankid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRankidLike(java.lang.String value) {
            if (value != null)
              addCriterion("rankid like ", value, "rankid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRankidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("rankid not like ", value, "rankid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRankidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("rankid in ", value, "rankid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRankidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("rankid not in ", value, "rankid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRankidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("rankid between ", value1, value2, "rankid");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRankidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("rankid not between ", value1, value2, "rankid");
            return (RankingInstanceCriteria) this;
        }
        
        public RankingInstanceCriteria andInstancetypeIsNull() {
            addCriterion("instancetype is null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstancetypeIsNotNull() {
            addCriterion("instancetype is not null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstancetypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instancetype =", value, "instancetype");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstancetypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instancetype <>", value, "instancetype");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstancetypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("instancetype >", value, "instancetype");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstancetypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instancetype >=", value, "instancetype");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstancetypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("instancetype <", value, "instancetype");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstancetypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("instancetype <=", value, "instancetype");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstancetypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("instancetype like ", value, "instancetype");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstancetypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("instancetype not like ", value, "instancetype");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstancetypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("instancetype in ", value, "instancetype");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstancetypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("instancetype not in ", value, "instancetype");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstancetypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("instancetype between ", value1, value2, "instancetype");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andInstancetypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("instancetype not between ", value1, value2, "instancetype");
            return (RankingInstanceCriteria) this;
        }
        
        public RankingInstanceCriteria andRacenumberIsNull() {
            addCriterion("racenumber is null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacenumberIsNotNull() {
            addCriterion("racenumber is not null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacenumberEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("racenumber =", value, "racenumber");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacenumberNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("racenumber <>", value, "racenumber");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacenumberGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("racenumber >", value, "racenumber");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacenumberGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("racenumber >=", value, "racenumber");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacenumberLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("racenumber <", value, "racenumber");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacenumberLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("racenumber <=", value, "racenumber");
            return (RankingInstanceCriteria) this;
        }

        
        public RankingInstanceCriteria andRacedateIsNull() {
            addCriterion("racedate is null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacedateIsNotNull() {
            addCriterion("racedate is not null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacedateEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("racedate =", value, "racedate");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacedateNotEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("racedate <>", value, "racedate");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacedateGreaterThan(java.sql.Date value) {
            if (value != null)
              addCriterion("racedate >", value, "racedate");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacedateGreaterThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("racedate >=", value, "racedate");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacedateLessThan(java.sql.Date value) {
            if (value != null)
              addCriterion("racedate <", value, "racedate");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacedateLessThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("racedate <=", value, "racedate");
            return (RankingInstanceCriteria) this;
        }

        
        public RankingInstanceCriteria andRacetimeIsNull() {
            addCriterion("racetime is null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacetimeIsNotNull() {
            addCriterion("racetime is not null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacetimeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racetime =", value, "racetime");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacetimeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racetime <>", value, "racetime");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacetimeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("racetime >", value, "racetime");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacetimeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racetime >=", value, "racetime");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacetimeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("racetime <", value, "racetime");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacetimeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racetime <=", value, "racetime");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacetimeLike(java.lang.String value) {
            if (value != null)
              addCriterion("racetime like ", value, "racetime");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacetimeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("racetime not like ", value, "racetime");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacetimeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("racetime in ", value, "racetime");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacetimeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("racetime not in ", value, "racetime");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacetimeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racetime between ", value1, value2, "racetime");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacetimeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racetime not between ", value1, value2, "racetime");
            return (RankingInstanceCriteria) this;
        }
        

        
        public RankingInstanceCriteria andRacecoefficientIsNull() {
            addCriterion("racecoefficient is null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacecoefficientIsNotNull() {
            addCriterion("racecoefficient is not null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacecoefficientEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racecoefficient =", value, "racecoefficient");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacecoefficientNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racecoefficient <>", value, "racecoefficient");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacecoefficientGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("racecoefficient >", value, "racecoefficient");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacecoefficientGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racecoefficient >=", value, "racecoefficient");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacecoefficientLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("racecoefficient <", value, "racecoefficient");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacecoefficientLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racecoefficient <=", value, "racecoefficient");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacecoefficientLike(java.lang.String value) {
            if (value != null)
              addCriterion("racecoefficient like ", value, "racecoefficient");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacecoefficientNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("racecoefficient not like ", value, "racecoefficient");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacecoefficientIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("racecoefficient in ", value, "racecoefficient");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacecoefficientNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("racecoefficient not in ", value, "racecoefficient");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacecoefficientBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racecoefficient between ", value1, value2, "racecoefficient");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacecoefficientNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racecoefficient not between ", value1, value2, "racecoefficient");
            return (RankingInstanceCriteria) this;
        }
        
        public RankingInstanceCriteria andRaceratingIsNull() {
            addCriterion("racerating is null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRaceratingIsNotNull() {
            addCriterion("racerating is not null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRaceratingEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racerating =", value, "racerating");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRaceratingNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racerating <>", value, "racerating");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRaceratingGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("racerating >", value, "racerating");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRaceratingGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racerating >=", value, "racerating");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRaceratingLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("racerating <", value, "racerating");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRaceratingLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racerating <=", value, "racerating");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRaceratingLike(java.lang.String value) {
            if (value != null)
              addCriterion("racerating like ", value, "racerating");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRaceratingNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("racerating not like ", value, "racerating");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRaceratingIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("racerating in ", value, "racerating");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRaceratingNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("racerating not in ", value, "racerating");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRaceratingBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racerating between ", value1, value2, "racerating");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRaceratingNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racerating not between ", value1, value2, "racerating");
            return (RankingInstanceCriteria) this;
        }
        
        public RankingInstanceCriteria andMinrealtimeIsNull() {
            addCriterion("minrealtime is null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andMinrealtimeIsNotNull() {
            addCriterion("minrealtime is not null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andMinrealtimeEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("minrealtime =", value, "minrealtime");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andMinrealtimeNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("minrealtime <>", value, "minrealtime");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andMinrealtimeGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("minrealtime >", value, "minrealtime");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andMinrealtimeGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("minrealtime >=", value, "minrealtime");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andMinrealtimeLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("minrealtime <", value, "minrealtime");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andMinrealtimeLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("minrealtime <=", value, "minrealtime");
            return (RankingInstanceCriteria) this;
        }

        
        public RankingInstanceCriteria andSoftwareversionIsNull() {
            addCriterion("softwareversion is null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwareversionIsNotNull() {
            addCriterion("softwareversion is not null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwareversionEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("softwareversion =", value, "softwareversion");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwareversionNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("softwareversion <>", value, "softwareversion");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwareversionGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("softwareversion >", value, "softwareversion");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwareversionGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("softwareversion >=", value, "softwareversion");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwareversionLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("softwareversion <", value, "softwareversion");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwareversionLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("softwareversion <=", value, "softwareversion");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwareversionLike(java.lang.String value) {
            if (value != null)
              addCriterion("softwareversion like ", value, "softwareversion");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwareversionNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("softwareversion not like ", value, "softwareversion");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwareversionIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("softwareversion in ", value, "softwareversion");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwareversionNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("softwareversion not in ", value, "softwareversion");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwareversionBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("softwareversion between ", value1, value2, "softwareversion");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwareversionNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("softwareversion not between ", value1, value2, "softwareversion");
            return (RankingInstanceCriteria) this;
        }
        
        public RankingInstanceCriteria andSoftwarecodeIsNull() {
            addCriterion("softwarecode is null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwarecodeIsNotNull() {
            addCriterion("softwarecode is not null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwarecodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("softwarecode =", value, "softwarecode");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwarecodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("softwarecode <>", value, "softwarecode");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwarecodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("softwarecode >", value, "softwarecode");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwarecodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("softwarecode >=", value, "softwarecode");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwarecodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("softwarecode <", value, "softwarecode");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwarecodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("softwarecode <=", value, "softwarecode");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwarecodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("softwarecode like ", value, "softwarecode");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwarecodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("softwarecode not like ", value, "softwarecode");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwarecodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("softwarecode in ", value, "softwarecode");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwarecodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("softwarecode not in ", value, "softwarecode");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwarecodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("softwarecode between ", value1, value2, "softwarecode");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andSoftwarecodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("softwarecode not between ", value1, value2, "softwarecode");
            return (RankingInstanceCriteria) this;
        }
        
        public RankingInstanceCriteria andRacefiledmsurlIsNull() {
            addCriterion("racefiledmsurl is null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacefiledmsurlIsNotNull() {
            addCriterion("racefiledmsurl is not null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacefiledmsurlEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racefiledmsurl =", value, "racefiledmsurl");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacefiledmsurlNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racefiledmsurl <>", value, "racefiledmsurl");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacefiledmsurlGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("racefiledmsurl >", value, "racefiledmsurl");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacefiledmsurlGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racefiledmsurl >=", value, "racefiledmsurl");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacefiledmsurlLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("racefiledmsurl <", value, "racefiledmsurl");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacefiledmsurlLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("racefiledmsurl <=", value, "racefiledmsurl");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacefiledmsurlLike(java.lang.String value) {
            if (value != null)
              addCriterion("racefiledmsurl like ", value, "racefiledmsurl");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacefiledmsurlNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("racefiledmsurl not like ", value, "racefiledmsurl");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacefiledmsurlIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("racefiledmsurl in ", value, "racefiledmsurl");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacefiledmsurlNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("racefiledmsurl not in ", value, "racefiledmsurl");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacefiledmsurlBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racefiledmsurl between ", value1, value2, "racefiledmsurl");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRacefiledmsurlNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("racefiledmsurl not between ", value1, value2, "racefiledmsurl");
            return (RankingInstanceCriteria) this;
        }
        
        public RankingInstanceCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (RankingInstanceCriteria) this;
        }
        public RankingInstanceCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (RankingInstanceCriteria) this;
        }

    }
    
}

