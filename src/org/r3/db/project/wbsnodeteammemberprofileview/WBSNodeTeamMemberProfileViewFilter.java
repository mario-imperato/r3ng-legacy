//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.wbsnodeteammemberprofileview;

import java.util.ArrayList;
import java.util.List;

public class WBSNodeTeamMemberProfileViewFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public WBSNodeTeamMemberProfileViewFilter() 
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

    public WBSNodeTeamMemberProfileViewCriteria or() 
    {
        WBSNodeTeamMemberProfileViewCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public WBSNodeTeamMemberProfileViewCriteria createCriteria() 
    {
        WBSNodeTeamMemberProfileViewCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected WBSNodeTeamMemberProfileViewCriteria createCriteriaInternal() 
    {
        WBSNodeTeamMemberProfileViewCriteria criteria = new WBSNodeTeamMemberProfileViewCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class WBSNodeTeamMemberProfileViewCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public WBSNodeTeamMemberProfileViewCriteria andProfileidIsNull() {
            addCriterion("profileid is null");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andProfileidIsNotNull() {
            addCriterion("profileid is not null");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andProfileidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid =", value, "profileid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andProfileidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid <>", value, "profileid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andProfileidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("profileid >", value, "profileid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andProfileidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid >=", value, "profileid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andProfileidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("profileid <", value, "profileid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andProfileidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid <=", value, "profileid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andProfileidLike(java.lang.String value) {
            if (value != null)
              addCriterion("profileid like ", value, "profileid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andProfileidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("profileid not like ", value, "profileid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andProfileidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("profileid in ", value, "profileid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andProfileidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("profileid not in ", value, "profileid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andProfileidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("profileid between ", value1, value2, "profileid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andProfileidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("profileid not between ", value1, value2, "profileid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        
        public WBSNodeTeamMemberProfileViewCriteria andWbsnodeidIsNull() {
            addCriterion("wbsnodeid is null");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsnodeidIsNotNull() {
            addCriterion("wbsnodeid is not null");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsnodeidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid =", value, "wbsnodeid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsnodeidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid <>", value, "wbsnodeid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsnodeidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid >", value, "wbsnodeid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsnodeidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid >=", value, "wbsnodeid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsnodeidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid <", value, "wbsnodeid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsnodeidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid <=", value, "wbsnodeid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsnodeidLike(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid like ", value, "wbsnodeid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsnodeidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid not like ", value, "wbsnodeid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsnodeidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("wbsnodeid in ", value, "wbsnodeid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsnodeidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("wbsnodeid not in ", value, "wbsnodeid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsnodeidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("wbsnodeid between ", value1, value2, "wbsnodeid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsnodeidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("wbsnodeid not between ", value1, value2, "wbsnodeid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        
        public WBSNodeTeamMemberProfileViewCriteria andEffortIsNull() {
            addCriterion("effort is null");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andEffortIsNotNull() {
            addCriterion("effort is not null");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andEffortEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("effort =", value, "effort");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andEffortNotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("effort <>", value, "effort");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andEffortGreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("effort >", value, "effort");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andEffortGreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("effort >=", value, "effort");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andEffortLessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("effort <", value, "effort");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andEffortLessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("effort <=", value, "effort");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }

        
        public WBSNodeTeamMemberProfileViewCriteria andUniteffortIsNull() {
            addCriterion("uniteffort is null");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andUniteffortIsNotNull() {
            addCriterion("uniteffort is not null");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andUniteffortEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort =", value, "uniteffort");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andUniteffortNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort <>", value, "uniteffort");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andUniteffortGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort >", value, "uniteffort");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andUniteffortGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort >=", value, "uniteffort");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andUniteffortLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort <", value, "uniteffort");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andUniteffortLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort <=", value, "uniteffort");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andUniteffortLike(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort like ", value, "uniteffort");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andUniteffortNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort not like ", value, "uniteffort");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andUniteffortIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("uniteffort in ", value, "uniteffort");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andUniteffortNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("uniteffort not in ", value, "uniteffort");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andUniteffortBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("uniteffort between ", value1, value2, "uniteffort");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andUniteffortNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("uniteffort not between ", value1, value2, "uniteffort");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        
        public WBSNodeTeamMemberProfileViewCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        
        public WBSNodeTeamMemberProfileViewCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        
        public WBSNodeTeamMemberProfileViewCriteria andWbsidIsNull() {
            addCriterion("wbsid is null");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsidIsNotNull() {
            addCriterion("wbsid is not null");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid =", value, "wbsid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid <>", value, "wbsid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid >", value, "wbsid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid >=", value, "wbsid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid <", value, "wbsid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid <=", value, "wbsid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsidLike(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid like ", value, "wbsid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid not like ", value, "wbsid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("wbsid in ", value, "wbsid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("wbsid not in ", value, "wbsid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("wbsid between ", value1, value2, "wbsid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andWbsidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("wbsid not between ", value1, value2, "wbsid");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        
        public WBSNodeTeamMemberProfileViewCriteria andNodetypeIsNull() {
            addCriterion("nodetype is null");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodetypeIsNotNull() {
            addCriterion("nodetype is not null");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodetypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype =", value, "nodetype");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodetypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype <>", value, "nodetype");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodetypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype >", value, "nodetype");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodetypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype >=", value, "nodetype");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodetypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype <", value, "nodetype");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodetypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype <=", value, "nodetype");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodetypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype like ", value, "nodetype");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodetypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype not like ", value, "nodetype");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodetypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("nodetype in ", value, "nodetype");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodetypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("nodetype not in ", value, "nodetype");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodetypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodetype between ", value1, value2, "nodetype");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodetypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodetype not between ", value1, value2, "nodetype");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        
        public WBSNodeTeamMemberProfileViewCriteria andNodeorderIsNull() {
            addCriterion("nodeorder is null");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodeorderIsNotNull() {
            addCriterion("nodeorder is not null");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodeorderEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("nodeorder =", value, "nodeorder");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodeorderNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("nodeorder <>", value, "nodeorder");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodeorderGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("nodeorder >", value, "nodeorder");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodeorderGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("nodeorder >=", value, "nodeorder");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodeorderLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("nodeorder <", value, "nodeorder");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodeorderLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("nodeorder <=", value, "nodeorder");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }

        
        public WBSNodeTeamMemberProfileViewCriteria andNodesectIsNull() {
            addCriterion("nodesect is null");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodesectIsNotNull() {
            addCriterion("nodesect is not null");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodesectEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodesect =", value, "nodesect");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodesectNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodesect <>", value, "nodesect");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodesectGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodesect >", value, "nodesect");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodesectGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodesect >=", value, "nodesect");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodesectLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodesect <", value, "nodesect");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodesectLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodesect <=", value, "nodesect");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodesectLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodesect like ", value, "nodesect");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodesectNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodesect not like ", value, "nodesect");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodesectIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("nodesect in ", value, "nodesect");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodesectNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("nodesect not in ", value, "nodesect");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodesectBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodesect between ", value1, value2, "nodesect");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodesectNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodesect not between ", value1, value2, "nodesect");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        
        public WBSNodeTeamMemberProfileViewCriteria andNodenameIsNull() {
            addCriterion("nodename is null");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodenameIsNotNull() {
            addCriterion("nodename is not null");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodenameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodename =", value, "nodename");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodenameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodename <>", value, "nodename");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodenameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodename >", value, "nodename");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodenameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodename >=", value, "nodename");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodenameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodename <", value, "nodename");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodenameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodename <=", value, "nodename");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodenameLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodename like ", value, "nodename");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodenameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodename not like ", value, "nodename");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodenameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("nodename in ", value, "nodename");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodenameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("nodename not in ", value, "nodename");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodenameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodename between ", value1, value2, "nodename");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodenameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodename not between ", value1, value2, "nodename");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        
        public WBSNodeTeamMemberProfileViewCriteria andNodestatusIsNull() {
            addCriterion("nodestatus is null");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodestatusIsNotNull() {
            addCriterion("nodestatus is not null");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodestatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodestatus =", value, "nodestatus");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodestatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodestatus <>", value, "nodestatus");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodestatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodestatus >", value, "nodestatus");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodestatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodestatus >=", value, "nodestatus");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodestatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodestatus <", value, "nodestatus");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodestatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodestatus <=", value, "nodestatus");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodestatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodestatus like ", value, "nodestatus");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodestatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodestatus not like ", value, "nodestatus");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodestatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("nodestatus in ", value, "nodestatus");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodestatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("nodestatus not in ", value, "nodestatus");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodestatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodestatus between ", value1, value2, "nodestatus");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
        public WBSNodeTeamMemberProfileViewCriteria andNodestatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodestatus not between ", value1, value2, "nodestatus");
            return (WBSNodeTeamMemberProfileViewCriteria) this;
        }
    }
    
}

