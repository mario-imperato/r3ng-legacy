//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.wbsnodeteammemberprofile;

import java.util.ArrayList;
import java.util.List;

public class WBSNodeTeamMemberProfileFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public WBSNodeTeamMemberProfileFilter() 
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

    public WBSNodeTeamMemberProfileCriteria or() 
    {
        WBSNodeTeamMemberProfileCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public WBSNodeTeamMemberProfileCriteria createCriteria() 
    {
        WBSNodeTeamMemberProfileCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected WBSNodeTeamMemberProfileCriteria createCriteriaInternal() 
    {
        WBSNodeTeamMemberProfileCriteria criteria = new WBSNodeTeamMemberProfileCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class WBSNodeTeamMemberProfileCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public WBSNodeTeamMemberProfileCriteria andProfileidIsNull() {
            addCriterion("profileid is null");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andProfileidIsNotNull() {
            addCriterion("profileid is not null");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andProfileidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid =", value, "profileid");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andProfileidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid <>", value, "profileid");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andProfileidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("profileid >", value, "profileid");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andProfileidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid >=", value, "profileid");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andProfileidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("profileid <", value, "profileid");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andProfileidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("profileid <=", value, "profileid");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andProfileidLike(java.lang.String value) {
            if (value != null)
              addCriterion("profileid like ", value, "profileid");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andProfileidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("profileid not like ", value, "profileid");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andProfileidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("profileid in ", value, "profileid");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andProfileidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("profileid not in ", value, "profileid");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andProfileidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("profileid between ", value1, value2, "profileid");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andProfileidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("profileid not between ", value1, value2, "profileid");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        
        public WBSNodeTeamMemberProfileCriteria andWbsnodeidIsNull() {
            addCriterion("wbsnodeid is null");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andWbsnodeidIsNotNull() {
            addCriterion("wbsnodeid is not null");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andWbsnodeidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid =", value, "wbsnodeid");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andWbsnodeidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid <>", value, "wbsnodeid");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andWbsnodeidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid >", value, "wbsnodeid");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andWbsnodeidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid >=", value, "wbsnodeid");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andWbsnodeidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid <", value, "wbsnodeid");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andWbsnodeidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid <=", value, "wbsnodeid");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andWbsnodeidLike(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid like ", value, "wbsnodeid");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andWbsnodeidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid not like ", value, "wbsnodeid");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andWbsnodeidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("wbsnodeid in ", value, "wbsnodeid");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andWbsnodeidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("wbsnodeid not in ", value, "wbsnodeid");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andWbsnodeidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("wbsnodeid between ", value1, value2, "wbsnodeid");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andWbsnodeidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("wbsnodeid not between ", value1, value2, "wbsnodeid");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        
        public WBSNodeTeamMemberProfileCriteria andEffortIsNull() {
            addCriterion("effort is null");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andEffortIsNotNull() {
            addCriterion("effort is not null");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andEffortEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("effort =", value, "effort");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andEffortNotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("effort <>", value, "effort");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andEffortGreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("effort >", value, "effort");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andEffortGreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("effort >=", value, "effort");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andEffortLessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("effort <", value, "effort");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andEffortLessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("effort <=", value, "effort");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }

        
        public WBSNodeTeamMemberProfileCriteria andUniteffortIsNull() {
            addCriterion("uniteffort is null");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andUniteffortIsNotNull() {
            addCriterion("uniteffort is not null");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andUniteffortEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort =", value, "uniteffort");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andUniteffortNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort <>", value, "uniteffort");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andUniteffortGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort >", value, "uniteffort");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andUniteffortGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort >=", value, "uniteffort");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andUniteffortLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort <", value, "uniteffort");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andUniteffortLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort <=", value, "uniteffort");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andUniteffortLike(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort like ", value, "uniteffort");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andUniteffortNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("uniteffort not like ", value, "uniteffort");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andUniteffortIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("uniteffort in ", value, "uniteffort");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andUniteffortNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("uniteffort not in ", value, "uniteffort");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andUniteffortBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("uniteffort between ", value1, value2, "uniteffort");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andUniteffortNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("uniteffort not between ", value1, value2, "uniteffort");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        
        public WBSNodeTeamMemberProfileCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        
        public WBSNodeTeamMemberProfileCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }
        public WBSNodeTeamMemberProfileCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (WBSNodeTeamMemberProfileCriteria) this;
        }

    }
    
}

