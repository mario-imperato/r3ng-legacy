//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.queues.queue;

import java.util.ArrayList;
import java.util.List;

public class QueueFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public QueueFilter() 
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

    public QueueCriteria or() 
    {
        QueueCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public QueueCriteria createCriteria() 
    {
        QueueCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected QueueCriteria createCriteriaInternal() 
    {
        QueueCriteria criteria = new QueueCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class QueueCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public QueueCriteria andQueueidIsNull() {
            addCriterion("queueid is null");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueueidIsNotNull() {
            addCriterion("queueid is not null");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueueidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queueid =", value, "queueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueueidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queueid <>", value, "queueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueueidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("queueid >", value, "queueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueueidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queueid >=", value, "queueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueueidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("queueid <", value, "queueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueueidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queueid <=", value, "queueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueueidLike(java.lang.String value) {
            if (value != null)
              addCriterion("queueid like ", value, "queueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueueidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("queueid not like ", value, "queueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueueidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("queueid in ", value, "queueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueueidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("queueid not in ", value, "queueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueueidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("queueid between ", value1, value2, "queueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueueidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("queueid not between ", value1, value2, "queueid");
            return (QueueCriteria) this;
        }
        
        public QueueCriteria andQueuenameIsNull() {
            addCriterion("queuename is null");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuenameIsNotNull() {
            addCriterion("queuename is not null");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuenameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queuename =", value, "queuename");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuenameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queuename <>", value, "queuename");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuenameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("queuename >", value, "queuename");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuenameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queuename >=", value, "queuename");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuenameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("queuename <", value, "queuename");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuenameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queuename <=", value, "queuename");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuenameLike(java.lang.String value) {
            if (value != null)
              addCriterion("queuename like ", value, "queuename");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuenameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("queuename not like ", value, "queuename");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuenameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("queuename in ", value, "queuename");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuenameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("queuename not in ", value, "queuename");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuenameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("queuename between ", value1, value2, "queuename");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuenameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("queuename not between ", value1, value2, "queuename");
            return (QueueCriteria) this;
        }
        
        public QueueCriteria andQueuephysicalnameIsNull() {
            addCriterion("queuephysicalname is null");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuephysicalnameIsNotNull() {
            addCriterion("queuephysicalname is not null");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuephysicalnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queuephysicalname =", value, "queuephysicalname");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuephysicalnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queuephysicalname <>", value, "queuephysicalname");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuephysicalnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("queuephysicalname >", value, "queuephysicalname");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuephysicalnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queuephysicalname >=", value, "queuephysicalname");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuephysicalnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("queuephysicalname <", value, "queuephysicalname");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuephysicalnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queuephysicalname <=", value, "queuephysicalname");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuephysicalnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("queuephysicalname like ", value, "queuephysicalname");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuephysicalnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("queuephysicalname not like ", value, "queuephysicalname");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuephysicalnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("queuephysicalname in ", value, "queuephysicalname");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuephysicalnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("queuephysicalname not in ", value, "queuephysicalname");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuephysicalnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("queuephysicalname between ", value1, value2, "queuephysicalname");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuephysicalnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("queuephysicalname not between ", value1, value2, "queuephysicalname");
            return (QueueCriteria) this;
        }
        
        public QueueCriteria andQueuetypeIsNull() {
            addCriterion("queuetype is null");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuetypeIsNotNull() {
            addCriterion("queuetype is not null");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuetypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queuetype =", value, "queuetype");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuetypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queuetype <>", value, "queuetype");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuetypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("queuetype >", value, "queuetype");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuetypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queuetype >=", value, "queuetype");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuetypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("queuetype <", value, "queuetype");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuetypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("queuetype <=", value, "queuetype");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuetypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("queuetype like ", value, "queuetype");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuetypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("queuetype not like ", value, "queuetype");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuetypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("queuetype in ", value, "queuetype");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuetypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("queuetype not in ", value, "queuetype");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuetypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("queuetype between ", value1, value2, "queuetype");
            return (QueueCriteria) this;
        }
        public QueueCriteria andQueuetypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("queuetype not between ", value1, value2, "queuetype");
            return (QueueCriteria) this;
        }
        
        public QueueCriteria andDeadqueueidIsNull() {
            addCriterion("deadqueueid is null");
            return (QueueCriteria) this;
        }
        public QueueCriteria andDeadqueueidIsNotNull() {
            addCriterion("deadqueueid is not null");
            return (QueueCriteria) this;
        }
        public QueueCriteria andDeadqueueidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("deadqueueid =", value, "deadqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andDeadqueueidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("deadqueueid <>", value, "deadqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andDeadqueueidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("deadqueueid >", value, "deadqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andDeadqueueidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("deadqueueid >=", value, "deadqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andDeadqueueidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("deadqueueid <", value, "deadqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andDeadqueueidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("deadqueueid <=", value, "deadqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andDeadqueueidLike(java.lang.String value) {
            if (value != null)
              addCriterion("deadqueueid like ", value, "deadqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andDeadqueueidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("deadqueueid not like ", value, "deadqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andDeadqueueidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("deadqueueid in ", value, "deadqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andDeadqueueidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("deadqueueid not in ", value, "deadqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andDeadqueueidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("deadqueueid between ", value1, value2, "deadqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andDeadqueueidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("deadqueueid not between ", value1, value2, "deadqueueid");
            return (QueueCriteria) this;
        }
        
        public QueueCriteria andRetryqueueidIsNull() {
            addCriterion("retryqueueid is null");
            return (QueueCriteria) this;
        }
        public QueueCriteria andRetryqueueidIsNotNull() {
            addCriterion("retryqueueid is not null");
            return (QueueCriteria) this;
        }
        public QueueCriteria andRetryqueueidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("retryqueueid =", value, "retryqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andRetryqueueidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("retryqueueid <>", value, "retryqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andRetryqueueidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("retryqueueid >", value, "retryqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andRetryqueueidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("retryqueueid >=", value, "retryqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andRetryqueueidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("retryqueueid <", value, "retryqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andRetryqueueidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("retryqueueid <=", value, "retryqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andRetryqueueidLike(java.lang.String value) {
            if (value != null)
              addCriterion("retryqueueid like ", value, "retryqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andRetryqueueidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("retryqueueid not like ", value, "retryqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andRetryqueueidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("retryqueueid in ", value, "retryqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andRetryqueueidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("retryqueueid not in ", value, "retryqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andRetryqueueidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("retryqueueid between ", value1, value2, "retryqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andRetryqueueidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("retryqueueid not between ", value1, value2, "retryqueueid");
            return (QueueCriteria) this;
        }
        
        public QueueCriteria andNotifyqueueidIsNull() {
            addCriterion("notifyqueueid is null");
            return (QueueCriteria) this;
        }
        public QueueCriteria andNotifyqueueidIsNotNull() {
            addCriterion("notifyqueueid is not null");
            return (QueueCriteria) this;
        }
        public QueueCriteria andNotifyqueueidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("notifyqueueid =", value, "notifyqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andNotifyqueueidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("notifyqueueid <>", value, "notifyqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andNotifyqueueidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("notifyqueueid >", value, "notifyqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andNotifyqueueidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("notifyqueueid >=", value, "notifyqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andNotifyqueueidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("notifyqueueid <", value, "notifyqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andNotifyqueueidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("notifyqueueid <=", value, "notifyqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andNotifyqueueidLike(java.lang.String value) {
            if (value != null)
              addCriterion("notifyqueueid like ", value, "notifyqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andNotifyqueueidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("notifyqueueid not like ", value, "notifyqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andNotifyqueueidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("notifyqueueid in ", value, "notifyqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andNotifyqueueidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("notifyqueueid not in ", value, "notifyqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andNotifyqueueidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("notifyqueueid between ", value1, value2, "notifyqueueid");
            return (QueueCriteria) this;
        }
        public QueueCriteria andNotifyqueueidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("notifyqueueid not between ", value1, value2, "notifyqueueid");
            return (QueueCriteria) this;
        }
        
        public QueueCriteria andMaxnumberofretriesIsNull() {
            addCriterion("maxnumberofretries is null");
            return (QueueCriteria) this;
        }
        public QueueCriteria andMaxnumberofretriesIsNotNull() {
            addCriterion("maxnumberofretries is not null");
            return (QueueCriteria) this;
        }
        public QueueCriteria andMaxnumberofretriesEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("maxnumberofretries =", value, "maxnumberofretries");
            return (QueueCriteria) this;
        }
        public QueueCriteria andMaxnumberofretriesNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("maxnumberofretries <>", value, "maxnumberofretries");
            return (QueueCriteria) this;
        }
        public QueueCriteria andMaxnumberofretriesGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("maxnumberofretries >", value, "maxnumberofretries");
            return (QueueCriteria) this;
        }
        public QueueCriteria andMaxnumberofretriesGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("maxnumberofretries >=", value, "maxnumberofretries");
            return (QueueCriteria) this;
        }
        public QueueCriteria andMaxnumberofretriesLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("maxnumberofretries <", value, "maxnumberofretries");
            return (QueueCriteria) this;
        }
        public QueueCriteria andMaxnumberofretriesLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("maxnumberofretries <=", value, "maxnumberofretries");
            return (QueueCriteria) this;
        }

    }
    
}

