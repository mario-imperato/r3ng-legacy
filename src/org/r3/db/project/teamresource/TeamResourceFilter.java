//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.teamresource;

import java.util.ArrayList;
import java.util.List;

public class TeamResourceFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public TeamResourceFilter() 
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

    public TeamResourceCriteria or() 
    {
        TeamResourceCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public TeamResourceCriteria createCriteria() 
    {
        TeamResourceCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected TeamResourceCriteria createCriteriaInternal() 
    {
        TeamResourceCriteria criteria = new TeamResourceCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class TeamResourceCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public TeamResourceCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (TeamResourceCriteria) this;
        }
        
        public TeamResourceCriteria andTeamidIsNull() {
            addCriterion("teamid is null");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andTeamidIsNotNull() {
            addCriterion("teamid is not null");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andTeamidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamid =", value, "teamid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andTeamidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamid <>", value, "teamid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andTeamidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("teamid >", value, "teamid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andTeamidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamid >=", value, "teamid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andTeamidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("teamid <", value, "teamid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andTeamidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("teamid <=", value, "teamid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andTeamidLike(java.lang.String value) {
            if (value != null)
              addCriterion("teamid like ", value, "teamid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andTeamidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("teamid not like ", value, "teamid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andTeamidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("teamid in ", value, "teamid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andTeamidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("teamid not in ", value, "teamid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andTeamidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("teamid between ", value1, value2, "teamid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andTeamidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("teamid not between ", value1, value2, "teamid");
            return (TeamResourceCriteria) this;
        }
        
        public TeamResourceCriteria andResourceidIsNull() {
            addCriterion("resourceid is null");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourceidIsNotNull() {
            addCriterion("resourceid is not null");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourceidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid =", value, "resourceid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourceidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid <>", value, "resourceid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourceidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid >", value, "resourceid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourceidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid >=", value, "resourceid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourceidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid <", value, "resourceid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourceidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid <=", value, "resourceid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourceidLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid like ", value, "resourceid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourceidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourceid not like ", value, "resourceid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourceidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("resourceid in ", value, "resourceid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourceidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("resourceid not in ", value, "resourceid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourceidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourceid between ", value1, value2, "resourceid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourceidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourceid not between ", value1, value2, "resourceid");
            return (TeamResourceCriteria) this;
        }
        
        public TeamResourceCriteria andProfileidIsNull() {
            addCriterion("profileid is null");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andProfileidIsNotNull() {
            addCriterion("profileid is not null");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andProfileidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid =", value, "profileid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andProfileidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid <>", value, "profileid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andProfileidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("profileid >", value, "profileid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andProfileidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid >=", value, "profileid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andProfileidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("profileid <", value, "profileid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andProfileidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid <=", value, "profileid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andProfileidLike(java.lang.String value) {
            if (value != null)
              addCriterion("profileid like ", value, "profileid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andProfileidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("profileid not like ", value, "profileid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andProfileidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("profileid in ", value, "profileid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andProfileidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("profileid not in ", value, "profileid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andProfileidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("profileid between ", value1, value2, "profileid");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andProfileidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("profileid not between ", value1, value2, "profileid");
            return (TeamResourceCriteria) this;
        }
        
        public TeamResourceCriteria andEvalueunitIsNull() {
            addCriterion("evalueunit is null");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andEvalueunitIsNotNull() {
            addCriterion("evalueunit is not null");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andEvalueunitEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit =", value, "evalueunit");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andEvalueunitNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit <>", value, "evalueunit");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andEvalueunitGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit >", value, "evalueunit");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andEvalueunitGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit >=", value, "evalueunit");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andEvalueunitLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit <", value, "evalueunit");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andEvalueunitLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit <=", value, "evalueunit");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andEvalueunitLike(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit like ", value, "evalueunit");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andEvalueunitNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("evalueunit not like ", value, "evalueunit");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andEvalueunitIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("evalueunit in ", value, "evalueunit");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andEvalueunitNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("evalueunit not in ", value, "evalueunit");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andEvalueunitBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("evalueunit between ", value1, value2, "evalueunit");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andEvalueunitNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("evalueunit not between ", value1, value2, "evalueunit");
            return (TeamResourceCriteria) this;
        }
        
        public TeamResourceCriteria andPriceIsNull() {
            addCriterion("price is null");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andPriceEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("price =", value, "price");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andPriceNotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("price <>", value, "price");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andPriceGreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("price >", value, "price");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andPriceGreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("price >=", value, "price");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andPriceLessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("price <", value, "price");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andPriceLessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("price <=", value, "price");
            return (TeamResourceCriteria) this;
        }

        
        public TeamResourceCriteria andCostIsNull() {
            addCriterion("cost is null");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andCostIsNotNull() {
            addCriterion("cost is not null");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andCostEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("cost =", value, "cost");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andCostNotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("cost <>", value, "cost");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andCostGreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("cost >", value, "cost");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andCostGreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("cost >=", value, "cost");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andCostLessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("cost <", value, "cost");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andCostLessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("cost <=", value, "cost");
            return (TeamResourceCriteria) this;
        }

        
        public TeamResourceCriteria andResourcedefstatusIsNull() {
            addCriterion("resourcedefstatus is null");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourcedefstatusIsNotNull() {
            addCriterion("resourcedefstatus is not null");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourcedefstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedefstatus =", value, "resourcedefstatus");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourcedefstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedefstatus <>", value, "resourcedefstatus");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourcedefstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedefstatus >", value, "resourcedefstatus");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourcedefstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedefstatus >=", value, "resourcedefstatus");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourcedefstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedefstatus <", value, "resourcedefstatus");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourcedefstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedefstatus <=", value, "resourcedefstatus");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourcedefstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedefstatus like ", value, "resourcedefstatus");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourcedefstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("resourcedefstatus not like ", value, "resourcedefstatus");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourcedefstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("resourcedefstatus in ", value, "resourcedefstatus");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourcedefstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("resourcedefstatus not in ", value, "resourcedefstatus");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourcedefstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourcedefstatus between ", value1, value2, "resourcedefstatus");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andResourcedefstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("resourcedefstatus not between ", value1, value2, "resourcedefstatus");
            return (TeamResourceCriteria) this;
        }
        
        public TeamResourceCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (TeamResourceCriteria) this;
        }
        
        public TeamResourceCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (TeamResourceCriteria) this;
        }
        public TeamResourceCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (TeamResourceCriteria) this;
        }

    }
    
}

