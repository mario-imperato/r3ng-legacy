//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.queues.queuemessage;

import java.util.ArrayList;
import java.util.List;

public class QueueMessageFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public QueueMessageFilter() 
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

    public QueueMessageCriteria or() 
    {
        QueueMessageCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public QueueMessageCriteria createCriteria() 
    {
        QueueMessageCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected QueueMessageCriteria createCriteriaInternal() 
    {
        QueueMessageCriteria criteria = new QueueMessageCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class QueueMessageCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public QueueMessageCriteria andQueuemessageidIsNull() {
            addCriterion("queuemessageid is null");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueuemessageidIsNotNull() {
            addCriterion("queuemessageid is not null");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueuemessageidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queuemessageid =", value, "queuemessageid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueuemessageidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queuemessageid <>", value, "queuemessageid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueuemessageidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("queuemessageid >", value, "queuemessageid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueuemessageidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queuemessageid >=", value, "queuemessageid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueuemessageidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("queuemessageid <", value, "queuemessageid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueuemessageidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queuemessageid <=", value, "queuemessageid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueuemessageidLike(java.lang.String value) {
            if (value != null)
              addCriterion("queuemessageid like ", value, "queuemessageid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueuemessageidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("queuemessageid not like ", value, "queuemessageid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueuemessageidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("queuemessageid in ", value, "queuemessageid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueuemessageidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("queuemessageid not in ", value, "queuemessageid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueuemessageidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("queuemessageid between ", value1, value2, "queuemessageid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueuemessageidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("queuemessageid not between ", value1, value2, "queuemessageid");
            return (QueueMessageCriteria) this;
        }
        
        public QueueMessageCriteria andQueueidIsNull() {
            addCriterion("queueid is null");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueueidIsNotNull() {
            addCriterion("queueid is not null");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueueidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queueid =", value, "queueid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueueidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queueid <>", value, "queueid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueueidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("queueid >", value, "queueid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueueidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queueid >=", value, "queueid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueueidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("queueid <", value, "queueid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueueidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queueid <=", value, "queueid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueueidLike(java.lang.String value) {
            if (value != null)
              addCriterion("queueid like ", value, "queueid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueueidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("queueid not like ", value, "queueid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueueidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("queueid in ", value, "queueid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueueidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("queueid not in ", value, "queueid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueueidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("queueid between ", value1, value2, "queueid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andQueueidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("queueid not between ", value1, value2, "queueid");
            return (QueueMessageCriteria) this;
        }
        
        public QueueMessageCriteria andCorrelationidIsNull() {
            addCriterion("correlationid is null");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andCorrelationidIsNotNull() {
            addCriterion("correlationid is not null");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andCorrelationidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("correlationid =", value, "correlationid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andCorrelationidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("correlationid <>", value, "correlationid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andCorrelationidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("correlationid >", value, "correlationid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andCorrelationidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("correlationid >=", value, "correlationid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andCorrelationidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("correlationid <", value, "correlationid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andCorrelationidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("correlationid <=", value, "correlationid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andCorrelationidLike(java.lang.String value) {
            if (value != null)
              addCriterion("correlationid like ", value, "correlationid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andCorrelationidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("correlationid not like ", value, "correlationid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andCorrelationidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("correlationid in ", value, "correlationid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andCorrelationidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("correlationid not in ", value, "correlationid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andCorrelationidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("correlationid between ", value1, value2, "correlationid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andCorrelationidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("correlationid not between ", value1, value2, "correlationid");
            return (QueueMessageCriteria) this;
        }
        
        public QueueMessageCriteria andSrcqueuemessageidIsNull() {
            addCriterion("srcqueuemessageid is null");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andSrcqueuemessageidIsNotNull() {
            addCriterion("srcqueuemessageid is not null");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andSrcqueuemessageidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("srcqueuemessageid =", value, "srcqueuemessageid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andSrcqueuemessageidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("srcqueuemessageid <>", value, "srcqueuemessageid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andSrcqueuemessageidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("srcqueuemessageid >", value, "srcqueuemessageid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andSrcqueuemessageidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("srcqueuemessageid >=", value, "srcqueuemessageid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andSrcqueuemessageidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("srcqueuemessageid <", value, "srcqueuemessageid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andSrcqueuemessageidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("srcqueuemessageid <=", value, "srcqueuemessageid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andSrcqueuemessageidLike(java.lang.String value) {
            if (value != null)
              addCriterion("srcqueuemessageid like ", value, "srcqueuemessageid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andSrcqueuemessageidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("srcqueuemessageid not like ", value, "srcqueuemessageid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andSrcqueuemessageidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("srcqueuemessageid in ", value, "srcqueuemessageid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andSrcqueuemessageidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("srcqueuemessageid not in ", value, "srcqueuemessageid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andSrcqueuemessageidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("srcqueuemessageid between ", value1, value2, "srcqueuemessageid");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andSrcqueuemessageidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("srcqueuemessageid not between ", value1, value2, "srcqueuemessageid");
            return (QueueMessageCriteria) this;
        }
        
        public QueueMessageCriteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andPriorityEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("priority =", value, "priority");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andPriorityNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("priority <>", value, "priority");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andPriorityGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("priority >", value, "priority");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andPriorityGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("priority >=", value, "priority");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andPriorityLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("priority <", value, "priority");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andPriorityLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("priority <=", value, "priority");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andPriorityLike(java.lang.String value) {
            if (value != null)
              addCriterion("priority like ", value, "priority");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andPriorityNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("priority not like ", value, "priority");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andPriorityIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("priority in ", value, "priority");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andPriorityNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("priority not in ", value, "priority");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andPriorityBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("priority between ", value1, value2, "priority");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andPriorityNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("priority not between ", value1, value2, "priority");
            return (QueueMessageCriteria) this;
        }
        
        public QueueMessageCriteria andMessagestatusIsNull() {
            addCriterion("messagestatus is null");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagestatusIsNotNull() {
            addCriterion("messagestatus is not null");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagestatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messagestatus =", value, "messagestatus");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagestatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messagestatus <>", value, "messagestatus");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagestatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("messagestatus >", value, "messagestatus");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagestatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messagestatus >=", value, "messagestatus");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagestatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("messagestatus <", value, "messagestatus");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagestatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messagestatus <=", value, "messagestatus");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagestatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("messagestatus like ", value, "messagestatus");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagestatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("messagestatus not like ", value, "messagestatus");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagestatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("messagestatus in ", value, "messagestatus");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagestatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("messagestatus not in ", value, "messagestatus");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagestatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("messagestatus between ", value1, value2, "messagestatus");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagestatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("messagestatus not between ", value1, value2, "messagestatus");
            return (QueueMessageCriteria) this;
        }
        
        public QueueMessageCriteria andMessagetypeIsNull() {
            addCriterion("messagetype is null");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagetypeIsNotNull() {
            addCriterion("messagetype is not null");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagetypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messagetype =", value, "messagetype");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagetypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messagetype <>", value, "messagetype");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagetypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("messagetype >", value, "messagetype");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagetypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messagetype >=", value, "messagetype");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagetypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("messagetype <", value, "messagetype");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagetypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messagetype <=", value, "messagetype");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagetypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("messagetype like ", value, "messagetype");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagetypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("messagetype not like ", value, "messagetype");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagetypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("messagetype in ", value, "messagetype");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagetypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("messagetype not in ", value, "messagetype");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagetypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("messagetype between ", value1, value2, "messagetype");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andMessagetypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("messagetype not between ", value1, value2, "messagetype");
            return (QueueMessageCriteria) this;
        }
        
        public QueueMessageCriteria andPutdateIsNull() {
            addCriterion("putdate is null");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andPutdateIsNotNull() {
            addCriterion("putdate is not null");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andPutdateEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("putdate =", value, "putdate");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andPutdateNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("putdate <>", value, "putdate");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andPutdateGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("putdate >", value, "putdate");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andPutdateGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("putdate >=", value, "putdate");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andPutdateLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("putdate <", value, "putdate");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andPutdateLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("putdate <=", value, "putdate");
            return (QueueMessageCriteria) this;
        }

        
        public QueueMessageCriteria andGetdateIsNull() {
            addCriterion("getdate is null");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andGetdateIsNotNull() {
            addCriterion("getdate is not null");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andGetdateEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("getdate =", value, "getdate");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andGetdateNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("getdate <>", value, "getdate");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andGetdateGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("getdate >", value, "getdate");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andGetdateGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("getdate >=", value, "getdate");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andGetdateLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("getdate <", value, "getdate");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andGetdateLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("getdate <=", value, "getdate");
            return (QueueMessageCriteria) this;
        }

        
        public QueueMessageCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (QueueMessageCriteria) this;
        }
        public QueueMessageCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (QueueMessageCriteria) this;
        }

    }
    
}

