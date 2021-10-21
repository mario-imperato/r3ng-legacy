//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.event;

import java.util.ArrayList;
import java.util.List;

public class SailEventFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public SailEventFilter() 
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

    public SailEventCriteria or() 
    {
        SailEventCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public SailEventCriteria createCriteria() 
    {
        SailEventCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected SailEventCriteria createCriteriaInternal() 
    {
        SailEventCriteria criteria = new SailEventCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class SailEventCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public SailEventCriteria andEventidIsNull() {
            addCriterion("eventid is null");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventidIsNotNull() {
            addCriterion("eventid is not null");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid =", value, "eventid");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <>", value, "eventid");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >", value, "eventid");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid >=", value, "eventid");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <", value, "eventid");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventid <=", value, "eventid");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventidLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid like ", value, "eventid");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventid not like ", value, "eventid");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("eventid in ", value, "eventid");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("eventid not in ", value, "eventid");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid between ", value1, value2, "eventid");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventid not between ", value1, value2, "eventid");
            return (SailEventCriteria) this;
        }
        
        public SailEventCriteria andEventtitleIsNull() {
            addCriterion("eventtitle is null");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventtitleIsNotNull() {
            addCriterion("eventtitle is not null");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventtitleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventtitle =", value, "eventtitle");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventtitleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventtitle <>", value, "eventtitle");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventtitleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventtitle >", value, "eventtitle");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventtitleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventtitle >=", value, "eventtitle");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventtitleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventtitle <", value, "eventtitle");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventtitleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventtitle <=", value, "eventtitle");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventtitleLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventtitle like ", value, "eventtitle");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventtitleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventtitle not like ", value, "eventtitle");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventtitleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("eventtitle in ", value, "eventtitle");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventtitleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("eventtitle not in ", value, "eventtitle");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventtitleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventtitle between ", value1, value2, "eventtitle");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventtitleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventtitle not between ", value1, value2, "eventtitle");
            return (SailEventCriteria) this;
        }
        
        public SailEventCriteria andEventdescrIsNull() {
            addCriterion("eventdescr is null");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventdescrIsNotNull() {
            addCriterion("eventdescr is not null");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventdescrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventdescr =", value, "eventdescr");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventdescrNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventdescr <>", value, "eventdescr");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventdescrGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventdescr >", value, "eventdescr");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventdescrGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventdescr >=", value, "eventdescr");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventdescrLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventdescr <", value, "eventdescr");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventdescrLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventdescr <=", value, "eventdescr");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventdescrLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventdescr like ", value, "eventdescr");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventdescrNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventdescr not like ", value, "eventdescr");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventdescrIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("eventdescr in ", value, "eventdescr");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventdescrNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("eventdescr not in ", value, "eventdescr");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventdescrBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventdescr between ", value1, value2, "eventdescr");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventdescrNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventdescr not between ", value1, value2, "eventdescr");
            return (SailEventCriteria) this;
        }
        
        public SailEventCriteria andEventgroupIsNull() {
            addCriterion("eventgroup is null");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventgroupIsNotNull() {
            addCriterion("eventgroup is not null");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventgroupEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventgroup =", value, "eventgroup");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventgroupNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventgroup <>", value, "eventgroup");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventgroupGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventgroup >", value, "eventgroup");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventgroupGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventgroup >=", value, "eventgroup");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventgroupLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventgroup <", value, "eventgroup");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventgroupLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventgroup <=", value, "eventgroup");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventgroupLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventgroup like ", value, "eventgroup");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventgroupNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventgroup not like ", value, "eventgroup");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventgroupIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("eventgroup in ", value, "eventgroup");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventgroupNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("eventgroup not in ", value, "eventgroup");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventgroupBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventgroup between ", value1, value2, "eventgroup");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventgroupNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventgroup not between ", value1, value2, "eventgroup");
            return (SailEventCriteria) this;
        }
        
        public SailEventCriteria andEventstatusIsNull() {
            addCriterion("eventstatus is null");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventstatusIsNotNull() {
            addCriterion("eventstatus is not null");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventstatus =", value, "eventstatus");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventstatus <>", value, "eventstatus");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventstatus >", value, "eventstatus");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventstatus >=", value, "eventstatus");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("eventstatus <", value, "eventstatus");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("eventstatus <=", value, "eventstatus");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventstatus like ", value, "eventstatus");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("eventstatus not like ", value, "eventstatus");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("eventstatus in ", value, "eventstatus");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("eventstatus not in ", value, "eventstatus");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventstatus between ", value1, value2, "eventstatus");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andEventstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("eventstatus not between ", value1, value2, "eventstatus");
            return (SailEventCriteria) this;
        }
        
        public SailEventCriteria andApplicationstatusIsNull() {
            addCriterion("applicationstatus is null");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andApplicationstatusIsNotNull() {
            addCriterion("applicationstatus is not null");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andApplicationstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationstatus =", value, "applicationstatus");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andApplicationstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationstatus <>", value, "applicationstatus");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andApplicationstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("applicationstatus >", value, "applicationstatus");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andApplicationstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationstatus >=", value, "applicationstatus");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andApplicationstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("applicationstatus <", value, "applicationstatus");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andApplicationstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("applicationstatus <=", value, "applicationstatus");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andApplicationstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("applicationstatus like ", value, "applicationstatus");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andApplicationstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("applicationstatus not like ", value, "applicationstatus");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andApplicationstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("applicationstatus in ", value, "applicationstatus");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andApplicationstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("applicationstatus not in ", value, "applicationstatus");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andApplicationstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("applicationstatus between ", value1, value2, "applicationstatus");
            return (SailEventCriteria) this;
        }
        public SailEventCriteria andApplicationstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("applicationstatus not between ", value1, value2, "applicationstatus");
            return (SailEventCriteria) this;
        }
    }
    
}

