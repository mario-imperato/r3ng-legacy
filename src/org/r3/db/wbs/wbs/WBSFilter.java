//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.wbs.wbs;

import java.util.ArrayList;
import java.util.List;

public class WBSFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public WBSFilter() 
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

    public WBSCriteria or() 
    {
        WBSCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public WBSCriteria createCriteria() 
    {
        WBSCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected WBSCriteria createCriteriaInternal() 
    {
        WBSCriteria criteria = new WBSCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class WBSCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public WBSCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (WBSCriteria) this;
        }
        public WBSCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (WBSCriteria) this;
        }
        public WBSCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (WBSCriteria) this;
        }
        public WBSCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (WBSCriteria) this;
        }
        public WBSCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (WBSCriteria) this;
        }
        public WBSCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (WBSCriteria) this;
        }
        public WBSCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (WBSCriteria) this;
        }
        public WBSCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (WBSCriteria) this;
        }
        public WBSCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (WBSCriteria) this;
        }
        public WBSCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (WBSCriteria) this;
        }
        public WBSCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (WBSCriteria) this;
        }
        public WBSCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (WBSCriteria) this;
        }
        public WBSCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (WBSCriteria) this;
        }
        public WBSCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (WBSCriteria) this;
        }
        
        public WBSCriteria andWbsidIsNull() {
            addCriterion("wbsid is null");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbsidIsNotNull() {
            addCriterion("wbsid is not null");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbsidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid =", value, "wbsid");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbsidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid <>", value, "wbsid");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbsidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid >", value, "wbsid");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbsidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid >=", value, "wbsid");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbsidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid <", value, "wbsid");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbsidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid <=", value, "wbsid");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbsidLike(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid like ", value, "wbsid");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbsidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid not like ", value, "wbsid");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbsidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("wbsid in ", value, "wbsid");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbsidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("wbsid not in ", value, "wbsid");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbsidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("wbsid between ", value1, value2, "wbsid");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbsidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("wbsid not between ", value1, value2, "wbsid");
            return (WBSCriteria) this;
        }
        
        public WBSCriteria andWbstitleIsNull() {
            addCriterion("wbstitle is null");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstitleIsNotNull() {
            addCriterion("wbstitle is not null");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstitleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbstitle =", value, "wbstitle");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstitleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbstitle <>", value, "wbstitle");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstitleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("wbstitle >", value, "wbstitle");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstitleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbstitle >=", value, "wbstitle");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstitleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("wbstitle <", value, "wbstitle");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstitleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbstitle <=", value, "wbstitle");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstitleLike(java.lang.String value) {
            if (value != null)
              addCriterion("wbstitle like ", value, "wbstitle");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstitleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("wbstitle not like ", value, "wbstitle");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstitleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("wbstitle in ", value, "wbstitle");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstitleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("wbstitle not in ", value, "wbstitle");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstitleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("wbstitle between ", value1, value2, "wbstitle");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstitleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("wbstitle not between ", value1, value2, "wbstitle");
            return (WBSCriteria) this;
        }
        
        public WBSCriteria andWbstextIsNull() {
            addCriterion("wbstext is null");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstextIsNotNull() {
            addCriterion("wbstext is not null");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstextEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbstext =", value, "wbstext");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstextNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbstext <>", value, "wbstext");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstextGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("wbstext >", value, "wbstext");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstextGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbstext >=", value, "wbstext");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstextLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("wbstext <", value, "wbstext");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstextLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbstext <=", value, "wbstext");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstextLike(java.lang.String value) {
            if (value != null)
              addCriterion("wbstext like ", value, "wbstext");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstextNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("wbstext not like ", value, "wbstext");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstextIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("wbstext in ", value, "wbstext");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstextNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("wbstext not in ", value, "wbstext");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstextBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("wbstext between ", value1, value2, "wbstext");
            return (WBSCriteria) this;
        }
        public WBSCriteria andWbstextNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("wbstext not between ", value1, value2, "wbstext");
            return (WBSCriteria) this;
        }
        
        public WBSCriteria andBbstopicidIsNull() {
            addCriterion("bbstopicid is null");
            return (WBSCriteria) this;
        }
        public WBSCriteria andBbstopicidIsNotNull() {
            addCriterion("bbstopicid is not null");
            return (WBSCriteria) this;
        }
        public WBSCriteria andBbstopicidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("bbstopicid =", value, "bbstopicid");
            return (WBSCriteria) this;
        }
        public WBSCriteria andBbstopicidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("bbstopicid <>", value, "bbstopicid");
            return (WBSCriteria) this;
        }
        public WBSCriteria andBbstopicidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("bbstopicid >", value, "bbstopicid");
            return (WBSCriteria) this;
        }
        public WBSCriteria andBbstopicidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("bbstopicid >=", value, "bbstopicid");
            return (WBSCriteria) this;
        }
        public WBSCriteria andBbstopicidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("bbstopicid <", value, "bbstopicid");
            return (WBSCriteria) this;
        }
        public WBSCriteria andBbstopicidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("bbstopicid <=", value, "bbstopicid");
            return (WBSCriteria) this;
        }
        public WBSCriteria andBbstopicidLike(java.lang.String value) {
            if (value != null)
              addCriterion("bbstopicid like ", value, "bbstopicid");
            return (WBSCriteria) this;
        }
        public WBSCriteria andBbstopicidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("bbstopicid not like ", value, "bbstopicid");
            return (WBSCriteria) this;
        }
        public WBSCriteria andBbstopicidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("bbstopicid in ", value, "bbstopicid");
            return (WBSCriteria) this;
        }
        public WBSCriteria andBbstopicidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("bbstopicid not in ", value, "bbstopicid");
            return (WBSCriteria) this;
        }
        public WBSCriteria andBbstopicidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("bbstopicid between ", value1, value2, "bbstopicid");
            return (WBSCriteria) this;
        }
        public WBSCriteria andBbstopicidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("bbstopicid not between ", value1, value2, "bbstopicid");
            return (WBSCriteria) this;
        }
        
        public WBSCriteria andOptionsIsNull() {
            addCriterion("options is null");
            return (WBSCriteria) this;
        }
        public WBSCriteria andOptionsIsNotNull() {
            addCriterion("options is not null");
            return (WBSCriteria) this;
        }
        public WBSCriteria andOptionsEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options =", value, "options");
            return (WBSCriteria) this;
        }
        public WBSCriteria andOptionsNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options <>", value, "options");
            return (WBSCriteria) this;
        }
        public WBSCriteria andOptionsGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("options >", value, "options");
            return (WBSCriteria) this;
        }
        public WBSCriteria andOptionsGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options >=", value, "options");
            return (WBSCriteria) this;
        }
        public WBSCriteria andOptionsLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("options <", value, "options");
            return (WBSCriteria) this;
        }
        public WBSCriteria andOptionsLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options <=", value, "options");
            return (WBSCriteria) this;
        }
        public WBSCriteria andOptionsLike(java.lang.String value) {
            if (value != null)
              addCriterion("options like ", value, "options");
            return (WBSCriteria) this;
        }
        public WBSCriteria andOptionsNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("options not like ", value, "options");
            return (WBSCriteria) this;
        }
        public WBSCriteria andOptionsIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("options in ", value, "options");
            return (WBSCriteria) this;
        }
        public WBSCriteria andOptionsNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("options not in ", value, "options");
            return (WBSCriteria) this;
        }
        public WBSCriteria andOptionsBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("options between ", value1, value2, "options");
            return (WBSCriteria) this;
        }
        public WBSCriteria andOptionsNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("options not between ", value1, value2, "options");
            return (WBSCriteria) this;
        }
        
        public WBSCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (WBSCriteria) this;
        }
        public WBSCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (WBSCriteria) this;
        }
        public WBSCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (WBSCriteria) this;
        }
        public WBSCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (WBSCriteria) this;
        }
        public WBSCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (WBSCriteria) this;
        }
        public WBSCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (WBSCriteria) this;
        }
        public WBSCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (WBSCriteria) this;
        }
        public WBSCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (WBSCriteria) this;
        }
        public WBSCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (WBSCriteria) this;
        }
        public WBSCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (WBSCriteria) this;
        }
        public WBSCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (WBSCriteria) this;
        }
        public WBSCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (WBSCriteria) this;
        }
        public WBSCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (WBSCriteria) this;
        }
        public WBSCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (WBSCriteria) this;
        }
        
        public WBSCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (WBSCriteria) this;
        }
        public WBSCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (WBSCriteria) this;
        }
        public WBSCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (WBSCriteria) this;
        }
        public WBSCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (WBSCriteria) this;
        }
        public WBSCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (WBSCriteria) this;
        }
        public WBSCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (WBSCriteria) this;
        }
        public WBSCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (WBSCriteria) this;
        }
        public WBSCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (WBSCriteria) this;
        }

    }
    
}

