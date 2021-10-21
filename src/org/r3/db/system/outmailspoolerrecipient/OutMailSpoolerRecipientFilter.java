//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.outmailspoolerrecipient;

import java.util.ArrayList;
import java.util.List;

public class OutMailSpoolerRecipientFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public OutMailSpoolerRecipientFilter() 
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

    public OutMailSpoolerRecipientCriteria or() 
    {
        OutMailSpoolerRecipientCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public OutMailSpoolerRecipientCriteria createCriteria() 
    {
        OutMailSpoolerRecipientCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected OutMailSpoolerRecipientCriteria createCriteriaInternal() 
    {
        OutMailSpoolerRecipientCriteria criteria = new OutMailSpoolerRecipientCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class OutMailSpoolerRecipientCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public OutMailSpoolerRecipientCriteria andRecipientidIsNull() {
            addCriterion("recipientid is null");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRecipientidIsNotNull() {
            addCriterion("recipientid is not null");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRecipientidEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("recipientid =", value, "recipientid");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRecipientidNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("recipientid <>", value, "recipientid");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRecipientidGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("recipientid >", value, "recipientid");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRecipientidGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("recipientid >=", value, "recipientid");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRecipientidLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("recipientid <", value, "recipientid");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRecipientidLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("recipientid <=", value, "recipientid");
            return (OutMailSpoolerRecipientCriteria) this;
        }

        
        public OutMailSpoolerRecipientCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        
        public OutMailSpoolerRecipientCriteria andMessageidIsNull() {
            addCriterion("messageid is null");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMessageidIsNotNull() {
            addCriterion("messageid is not null");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMessageidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messageid =", value, "messageid");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMessageidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messageid <>", value, "messageid");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMessageidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("messageid >", value, "messageid");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMessageidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messageid >=", value, "messageid");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMessageidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("messageid <", value, "messageid");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMessageidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messageid <=", value, "messageid");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMessageidLike(java.lang.String value) {
            if (value != null)
              addCriterion("messageid like ", value, "messageid");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMessageidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("messageid not like ", value, "messageid");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMessageidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("messageid in ", value, "messageid");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMessageidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("messageid not in ", value, "messageid");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMessageidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("messageid between ", value1, value2, "messageid");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMessageidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("messageid not between ", value1, value2, "messageid");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        
        public OutMailSpoolerRecipientCriteria andMsgtoIsNull() {
            addCriterion("msgto is null");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMsgtoIsNotNull() {
            addCriterion("msgto is not null");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMsgtoEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgto =", value, "msgto");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMsgtoNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgto <>", value, "msgto");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMsgtoGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("msgto >", value, "msgto");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMsgtoGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgto >=", value, "msgto");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMsgtoLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("msgto <", value, "msgto");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMsgtoLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgto <=", value, "msgto");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMsgtoLike(java.lang.String value) {
            if (value != null)
              addCriterion("msgto like ", value, "msgto");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMsgtoNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("msgto not like ", value, "msgto");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMsgtoIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("msgto in ", value, "msgto");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMsgtoNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("msgto not in ", value, "msgto");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMsgtoBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("msgto between ", value1, value2, "msgto");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andMsgtoNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("msgto not between ", value1, value2, "msgto");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        
        public OutMailSpoolerRecipientCriteria andBusinesskeyIsNull() {
            addCriterion("businesskey is null");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andBusinesskeyIsNotNull() {
            addCriterion("businesskey is not null");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andBusinesskeyEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("businesskey =", value, "businesskey");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andBusinesskeyNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("businesskey <>", value, "businesskey");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andBusinesskeyGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("businesskey >", value, "businesskey");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andBusinesskeyGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("businesskey >=", value, "businesskey");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andBusinesskeyLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("businesskey <", value, "businesskey");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andBusinesskeyLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("businesskey <=", value, "businesskey");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andBusinesskeyLike(java.lang.String value) {
            if (value != null)
              addCriterion("businesskey like ", value, "businesskey");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andBusinesskeyNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("businesskey not like ", value, "businesskey");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andBusinesskeyIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("businesskey in ", value, "businesskey");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andBusinesskeyNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("businesskey not in ", value, "businesskey");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andBusinesskeyBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("businesskey between ", value1, value2, "businesskey");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andBusinesskeyNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("businesskey not between ", value1, value2, "businesskey");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        
        public OutMailSpoolerRecipientCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        
        public OutMailSpoolerRecipientCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (OutMailSpoolerRecipientCriteria) this;
        }
        public OutMailSpoolerRecipientCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (OutMailSpoolerRecipientCriteria) this;
        }

    }
    
}

