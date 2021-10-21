//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.queues.queuework;

import java.util.ArrayList;
import java.util.List;

public class QueueWorkFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public QueueWorkFilter() 
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

    public QueueWorkCriteria or() 
    {
        QueueWorkCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public QueueWorkCriteria createCriteria() 
    {
        QueueWorkCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected QueueWorkCriteria createCriteriaInternal() 
    {
        QueueWorkCriteria criteria = new QueueWorkCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class QueueWorkCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public QueueWorkCriteria andQueueworkidIsNull() {
            addCriterion("queueworkid is null");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueworkidIsNotNull() {
            addCriterion("queueworkid is not null");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueworkidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queueworkid =", value, "queueworkid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueworkidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queueworkid <>", value, "queueworkid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueworkidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("queueworkid >", value, "queueworkid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueworkidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queueworkid >=", value, "queueworkid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueworkidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("queueworkid <", value, "queueworkid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueworkidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queueworkid <=", value, "queueworkid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueworkidLike(java.lang.String value) {
            if (value != null)
              addCriterion("queueworkid like ", value, "queueworkid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueworkidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("queueworkid not like ", value, "queueworkid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueworkidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("queueworkid in ", value, "queueworkid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueworkidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("queueworkid not in ", value, "queueworkid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueworkidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("queueworkid between ", value1, value2, "queueworkid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueworkidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("queueworkid not between ", value1, value2, "queueworkid");
            return (QueueWorkCriteria) this;
        }
        
        public QueueWorkCriteria andQueueidIsNull() {
            addCriterion("queueid is null");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueidIsNotNull() {
            addCriterion("queueid is not null");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queueid =", value, "queueid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queueid <>", value, "queueid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("queueid >", value, "queueid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queueid >=", value, "queueid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("queueid <", value, "queueid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queueid <=", value, "queueid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueidLike(java.lang.String value) {
            if (value != null)
              addCriterion("queueid like ", value, "queueid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("queueid not like ", value, "queueid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("queueid in ", value, "queueid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("queueid not in ", value, "queueid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("queueid between ", value1, value2, "queueid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andQueueidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("queueid not between ", value1, value2, "queueid");
            return (QueueWorkCriteria) this;
        }
        
        public QueueWorkCriteria andRefambitidIsNull() {
            addCriterion("refambitid is null");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefambitidIsNotNull() {
            addCriterion("refambitid is not null");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefambitidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("refambitid =", value, "refambitid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefambitidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("refambitid <>", value, "refambitid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefambitidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("refambitid >", value, "refambitid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefambitidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("refambitid >=", value, "refambitid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefambitidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("refambitid <", value, "refambitid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefambitidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("refambitid <=", value, "refambitid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefambitidLike(java.lang.String value) {
            if (value != null)
              addCriterion("refambitid like ", value, "refambitid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefambitidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("refambitid not like ", value, "refambitid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefambitidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("refambitid in ", value, "refambitid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefambitidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("refambitid not in ", value, "refambitid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefambitidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("refambitid between ", value1, value2, "refambitid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefambitidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("refambitid not between ", value1, value2, "refambitid");
            return (QueueWorkCriteria) this;
        }
        
        public QueueWorkCriteria andRefentityidIsNull() {
            addCriterion("refentityid is null");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefentityidIsNotNull() {
            addCriterion("refentityid is not null");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefentityidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("refentityid =", value, "refentityid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefentityidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("refentityid <>", value, "refentityid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefentityidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("refentityid >", value, "refentityid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefentityidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("refentityid >=", value, "refentityid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefentityidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("refentityid <", value, "refentityid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefentityidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("refentityid <=", value, "refentityid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefentityidLike(java.lang.String value) {
            if (value != null)
              addCriterion("refentityid like ", value, "refentityid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefentityidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("refentityid not like ", value, "refentityid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefentityidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("refentityid in ", value, "refentityid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefentityidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("refentityid not in ", value, "refentityid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefentityidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("refentityid between ", value1, value2, "refentityid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefentityidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("refentityid not between ", value1, value2, "refentityid");
            return (QueueWorkCriteria) this;
        }
        
        public QueueWorkCriteria andRefdateIsNull() {
            addCriterion("refdate is null");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefdateIsNotNull() {
            addCriterion("refdate is not null");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefdateEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate =", value, "refdate");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefdateNotEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate <>", value, "refdate");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefdateGreaterThan(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate >", value, "refdate");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefdateGreaterThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate >=", value, "refdate");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefdateLessThan(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate <", value, "refdate");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRefdateLessThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("refdate <=", value, "refdate");
            return (QueueWorkCriteria) this;
        }

        
        public QueueWorkCriteria andTriggerdatetimeIsNull() {
            addCriterion("triggerdatetime is null");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andTriggerdatetimeIsNotNull() {
            addCriterion("triggerdatetime is not null");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andTriggerdatetimeEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("triggerdatetime =", value, "triggerdatetime");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andTriggerdatetimeNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("triggerdatetime <>", value, "triggerdatetime");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andTriggerdatetimeGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("triggerdatetime >", value, "triggerdatetime");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andTriggerdatetimeGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("triggerdatetime >=", value, "triggerdatetime");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andTriggerdatetimeLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("triggerdatetime <", value, "triggerdatetime");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andTriggerdatetimeLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("triggerdatetime <=", value, "triggerdatetime");
            return (QueueWorkCriteria) this;
        }

        
        public QueueWorkCriteria andCorrelationidIsNull() {
            addCriterion("correlationid is null");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andCorrelationidIsNotNull() {
            addCriterion("correlationid is not null");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andCorrelationidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("correlationid =", value, "correlationid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andCorrelationidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("correlationid <>", value, "correlationid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andCorrelationidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("correlationid >", value, "correlationid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andCorrelationidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("correlationid >=", value, "correlationid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andCorrelationidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("correlationid <", value, "correlationid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andCorrelationidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("correlationid <=", value, "correlationid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andCorrelationidLike(java.lang.String value) {
            if (value != null)
              addCriterion("correlationid like ", value, "correlationid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andCorrelationidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("correlationid not like ", value, "correlationid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andCorrelationidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("correlationid in ", value, "correlationid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andCorrelationidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("correlationid not in ", value, "correlationid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andCorrelationidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("correlationid between ", value1, value2, "correlationid");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andCorrelationidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("correlationid not between ", value1, value2, "correlationid");
            return (QueueWorkCriteria) this;
        }
        
        public QueueWorkCriteria andMessagestatusIsNull() {
            addCriterion("messagestatus is null");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagestatusIsNotNull() {
            addCriterion("messagestatus is not null");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagestatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messagestatus =", value, "messagestatus");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagestatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messagestatus <>", value, "messagestatus");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagestatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("messagestatus >", value, "messagestatus");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagestatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messagestatus >=", value, "messagestatus");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagestatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("messagestatus <", value, "messagestatus");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagestatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messagestatus <=", value, "messagestatus");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagestatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("messagestatus like ", value, "messagestatus");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagestatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("messagestatus not like ", value, "messagestatus");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagestatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("messagestatus in ", value, "messagestatus");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagestatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("messagestatus not in ", value, "messagestatus");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagestatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("messagestatus between ", value1, value2, "messagestatus");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagestatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("messagestatus not between ", value1, value2, "messagestatus");
            return (QueueWorkCriteria) this;
        }
        
        public QueueWorkCriteria andMessagetypeIsNull() {
            addCriterion("messagetype is null");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagetypeIsNotNull() {
            addCriterion("messagetype is not null");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagetypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messagetype =", value, "messagetype");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagetypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messagetype <>", value, "messagetype");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagetypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("messagetype >", value, "messagetype");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagetypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messagetype >=", value, "messagetype");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagetypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("messagetype <", value, "messagetype");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagetypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messagetype <=", value, "messagetype");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagetypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("messagetype like ", value, "messagetype");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagetypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("messagetype not like ", value, "messagetype");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagetypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("messagetype in ", value, "messagetype");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagetypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("messagetype not in ", value, "messagetype");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagetypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("messagetype between ", value1, value2, "messagetype");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andMessagetypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("messagetype not between ", value1, value2, "messagetype");
            return (QueueWorkCriteria) this;
        }
        
        public QueueWorkCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (QueueWorkCriteria) this;
        }
        public QueueWorkCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (QueueWorkCriteria) this;
        }

    }
    
}

