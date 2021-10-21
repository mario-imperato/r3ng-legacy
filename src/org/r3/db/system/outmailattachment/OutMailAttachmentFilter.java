//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.outmailattachment;

import java.util.ArrayList;
import java.util.List;

public class OutMailAttachmentFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public OutMailAttachmentFilter() 
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

    public OutMailAttachmentCriteria or() 
    {
        OutMailAttachmentCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public OutMailAttachmentCriteria createCriteria() 
    {
        OutMailAttachmentCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected OutMailAttachmentCriteria createCriteriaInternal() 
    {
        OutMailAttachmentCriteria criteria = new OutMailAttachmentCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class OutMailAttachmentCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public OutMailAttachmentCriteria andAttachmentidIsNull() {
            addCriterion("attachmentid is null");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentidIsNotNull() {
            addCriterion("attachmentid is not null");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("attachmentid =", value, "attachmentid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("attachmentid <>", value, "attachmentid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("attachmentid >", value, "attachmentid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("attachmentid >=", value, "attachmentid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("attachmentid <", value, "attachmentid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("attachmentid <=", value, "attachmentid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentidLike(java.lang.String value) {
            if (value != null)
              addCriterion("attachmentid like ", value, "attachmentid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("attachmentid not like ", value, "attachmentid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("attachmentid in ", value, "attachmentid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("attachmentid not in ", value, "attachmentid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("attachmentid between ", value1, value2, "attachmentid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("attachmentid not between ", value1, value2, "attachmentid");
            return (OutMailAttachmentCriteria) this;
        }
        
        public OutMailAttachmentCriteria andAttachmentgroupidIsNull() {
            addCriterion("attachmentgroupid is null");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentgroupidIsNotNull() {
            addCriterion("attachmentgroupid is not null");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentgroupidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("attachmentgroupid =", value, "attachmentgroupid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentgroupidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("attachmentgroupid <>", value, "attachmentgroupid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentgroupidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("attachmentgroupid >", value, "attachmentgroupid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentgroupidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("attachmentgroupid >=", value, "attachmentgroupid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentgroupidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("attachmentgroupid <", value, "attachmentgroupid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentgroupidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("attachmentgroupid <=", value, "attachmentgroupid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentgroupidLike(java.lang.String value) {
            if (value != null)
              addCriterion("attachmentgroupid like ", value, "attachmentgroupid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentgroupidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("attachmentgroupid not like ", value, "attachmentgroupid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentgroupidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("attachmentgroupid in ", value, "attachmentgroupid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentgroupidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("attachmentgroupid not in ", value, "attachmentgroupid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentgroupidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("attachmentgroupid between ", value1, value2, "attachmentgroupid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmentgroupidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("attachmentgroupid not between ", value1, value2, "attachmentgroupid");
            return (OutMailAttachmentCriteria) this;
        }
        
        public OutMailAttachmentCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (OutMailAttachmentCriteria) this;
        }
        
        public OutMailAttachmentCriteria andMessageidIsNull() {
            addCriterion("messageid is null");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andMessageidIsNotNull() {
            addCriterion("messageid is not null");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andMessageidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messageid =", value, "messageid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andMessageidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messageid <>", value, "messageid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andMessageidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("messageid >", value, "messageid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andMessageidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messageid >=", value, "messageid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andMessageidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("messageid <", value, "messageid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andMessageidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messageid <=", value, "messageid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andMessageidLike(java.lang.String value) {
            if (value != null)
              addCriterion("messageid like ", value, "messageid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andMessageidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("messageid not like ", value, "messageid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andMessageidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("messageid in ", value, "messageid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andMessageidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("messageid not in ", value, "messageid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andMessageidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("messageid between ", value1, value2, "messageid");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andMessageidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("messageid not between ", value1, value2, "messageid");
            return (OutMailAttachmentCriteria) this;
        }
        
        public OutMailAttachmentCriteria andAttachmenturlIsNull() {
            addCriterion("attachmenturl is null");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmenturlIsNotNull() {
            addCriterion("attachmenturl is not null");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmenturlEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("attachmenturl =", value, "attachmenturl");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmenturlNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("attachmenturl <>", value, "attachmenturl");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmenturlGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("attachmenturl >", value, "attachmenturl");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmenturlGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("attachmenturl >=", value, "attachmenturl");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmenturlLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("attachmenturl <", value, "attachmenturl");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmenturlLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("attachmenturl <=", value, "attachmenturl");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmenturlLike(java.lang.String value) {
            if (value != null)
              addCriterion("attachmenturl like ", value, "attachmenturl");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmenturlNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("attachmenturl not like ", value, "attachmenturl");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmenturlIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("attachmenturl in ", value, "attachmenturl");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmenturlNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("attachmenturl not in ", value, "attachmenturl");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmenturlBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("attachmenturl between ", value1, value2, "attachmenturl");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andAttachmenturlNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("attachmenturl not between ", value1, value2, "attachmenturl");
            return (OutMailAttachmentCriteria) this;
        }
        
        public OutMailAttachmentCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (OutMailAttachmentCriteria) this;
        }
        
        public OutMailAttachmentCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (OutMailAttachmentCriteria) this;
        }
        public OutMailAttachmentCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (OutMailAttachmentCriteria) this;
        }

    }
    
}

