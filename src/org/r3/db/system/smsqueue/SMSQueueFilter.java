//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.smsqueue;

import java.util.ArrayList;
import java.util.List;

public class SMSQueueFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public SMSQueueFilter() 
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

    public SMSQueueCriteria or() 
    {
        SMSQueueCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public SMSQueueCriteria createCriteria() 
    {
        SMSQueueCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected SMSQueueCriteria createCriteriaInternal() 
    {
        SMSQueueCriteria criteria = new SMSQueueCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class SMSQueueCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public SMSQueueCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (SMSQueueCriteria) this;
        }
        
        public SMSQueueCriteria andSmsidIsNull() {
            addCriterion("smsid is null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsidIsNotNull() {
            addCriterion("smsid is not null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("smsid =", value, "smsid");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("smsid <>", value, "smsid");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("smsid >", value, "smsid");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("smsid >=", value, "smsid");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("smsid <", value, "smsid");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("smsid <=", value, "smsid");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsidLike(java.lang.String value) {
            if (value != null)
              addCriterion("smsid like ", value, "smsid");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("smsid not like ", value, "smsid");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("smsid in ", value, "smsid");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("smsid not in ", value, "smsid");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("smsid between ", value1, value2, "smsid");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("smsid not between ", value1, value2, "smsid");
            return (SMSQueueCriteria) this;
        }
        
        public SMSQueueCriteria andSmstextIsNull() {
            addCriterion("smstext is null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmstextIsNotNull() {
            addCriterion("smstext is not null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmstextEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("smstext =", value, "smstext");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmstextNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("smstext <>", value, "smstext");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmstextGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("smstext >", value, "smstext");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmstextGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("smstext >=", value, "smstext");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmstextLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("smstext <", value, "smstext");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmstextLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("smstext <=", value, "smstext");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmstextLike(java.lang.String value) {
            if (value != null)
              addCriterion("smstext like ", value, "smstext");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmstextNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("smstext not like ", value, "smstext");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmstextIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("smstext in ", value, "smstext");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmstextNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("smstext not in ", value, "smstext");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmstextBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("smstext between ", value1, value2, "smstext");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmstextNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("smstext not between ", value1, value2, "smstext");
            return (SMSQueueCriteria) this;
        }
        
        public SMSQueueCriteria andSmssenderIsNull() {
            addCriterion("smssender is null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmssenderIsNotNull() {
            addCriterion("smssender is not null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmssenderEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("smssender =", value, "smssender");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmssenderNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("smssender <>", value, "smssender");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmssenderGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("smssender >", value, "smssender");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmssenderGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("smssender >=", value, "smssender");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmssenderLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("smssender <", value, "smssender");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmssenderLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("smssender <=", value, "smssender");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmssenderLike(java.lang.String value) {
            if (value != null)
              addCriterion("smssender like ", value, "smssender");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmssenderNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("smssender not like ", value, "smssender");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmssenderIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("smssender in ", value, "smssender");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmssenderNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("smssender not in ", value, "smssender");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmssenderBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("smssender between ", value1, value2, "smssender");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmssenderNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("smssender not between ", value1, value2, "smssender");
            return (SMSQueueCriteria) this;
        }
        
        public SMSQueueCriteria andSmsoptsIsNull() {
            addCriterion("smsopts is null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsoptsIsNotNull() {
            addCriterion("smsopts is not null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsoptsEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("smsopts =", value, "smsopts");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsoptsNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("smsopts <>", value, "smsopts");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsoptsGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("smsopts >", value, "smsopts");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsoptsGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("smsopts >=", value, "smsopts");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsoptsLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("smsopts <", value, "smsopts");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsoptsLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("smsopts <=", value, "smsopts");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsoptsLike(java.lang.String value) {
            if (value != null)
              addCriterion("smsopts like ", value, "smsopts");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsoptsNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("smsopts not like ", value, "smsopts");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsoptsIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("smsopts in ", value, "smsopts");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsoptsNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("smsopts not in ", value, "smsopts");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsoptsBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("smsopts between ", value1, value2, "smsopts");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmsoptsNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("smsopts not between ", value1, value2, "smsopts");
            return (SMSQueueCriteria) this;
        }
        
        public SMSQueueCriteria andSmssendatIsNull() {
            addCriterion("smssendat is null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmssendatIsNotNull() {
            addCriterion("smssendat is not null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmssendatEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("smssendat =", value, "smssendat");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmssendatNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("smssendat <>", value, "smssendat");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmssendatGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("smssendat >", value, "smssendat");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmssendatGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("smssendat >=", value, "smssendat");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmssendatLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("smssendat <", value, "smssendat");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andSmssendatLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("smssendat <=", value, "smssendat");
            return (SMSQueueCriteria) this;
        }

        
        public SMSQueueCriteria andNumberofretriesIsNull() {
            addCriterion("numberofretries is null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andNumberofretriesIsNotNull() {
            addCriterion("numberofretries is not null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andNumberofretriesEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofretries =", value, "numberofretries");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andNumberofretriesNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofretries <>", value, "numberofretries");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andNumberofretriesGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofretries >", value, "numberofretries");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andNumberofretriesGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofretries >=", value, "numberofretries");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andNumberofretriesLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofretries <", value, "numberofretries");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andNumberofretriesLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofretries <=", value, "numberofretries");
            return (SMSQueueCriteria) this;
        }

        
        public SMSQueueCriteria andNumberoftargetsIsNull() {
            addCriterion("numberoftargets is null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andNumberoftargetsIsNotNull() {
            addCriterion("numberoftargets is not null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andNumberoftargetsEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberoftargets =", value, "numberoftargets");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andNumberoftargetsNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberoftargets <>", value, "numberoftargets");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andNumberoftargetsGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberoftargets >", value, "numberoftargets");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andNumberoftargetsGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberoftargets >=", value, "numberoftargets");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andNumberoftargetsLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberoftargets <", value, "numberoftargets");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andNumberoftargetsLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberoftargets <=", value, "numberoftargets");
            return (SMSQueueCriteria) this;
        }

        
        public SMSQueueCriteria andNumberofsentitemsIsNull() {
            addCriterion("numberofsentitems is null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andNumberofsentitemsIsNotNull() {
            addCriterion("numberofsentitems is not null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andNumberofsentitemsEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofsentitems =", value, "numberofsentitems");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andNumberofsentitemsNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofsentitems <>", value, "numberofsentitems");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andNumberofsentitemsGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofsentitems >", value, "numberofsentitems");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andNumberofsentitemsGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofsentitems >=", value, "numberofsentitems");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andNumberofsentitemsLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofsentitems <", value, "numberofsentitems");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andNumberofsentitemsLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofsentitems <=", value, "numberofsentitems");
            return (SMSQueueCriteria) this;
        }

        
        public SMSQueueCriteria andGtwayresponsecodeIsNull() {
            addCriterion("gtwayresponsecode is null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsecodeIsNotNull() {
            addCriterion("gtwayresponsecode is not null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsecodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("gtwayresponsecode =", value, "gtwayresponsecode");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsecodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("gtwayresponsecode <>", value, "gtwayresponsecode");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsecodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("gtwayresponsecode >", value, "gtwayresponsecode");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsecodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("gtwayresponsecode >=", value, "gtwayresponsecode");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsecodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("gtwayresponsecode <", value, "gtwayresponsecode");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsecodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("gtwayresponsecode <=", value, "gtwayresponsecode");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsecodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("gtwayresponsecode like ", value, "gtwayresponsecode");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsecodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("gtwayresponsecode not like ", value, "gtwayresponsecode");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsecodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("gtwayresponsecode in ", value, "gtwayresponsecode");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsecodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("gtwayresponsecode not in ", value, "gtwayresponsecode");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsecodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("gtwayresponsecode between ", value1, value2, "gtwayresponsecode");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsecodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("gtwayresponsecode not between ", value1, value2, "gtwayresponsecode");
            return (SMSQueueCriteria) this;
        }
        
        public SMSQueueCriteria andGtwayresponsereasonIsNull() {
            addCriterion("gtwayresponsereason is null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsereasonIsNotNull() {
            addCriterion("gtwayresponsereason is not null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsereasonEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("gtwayresponsereason =", value, "gtwayresponsereason");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsereasonNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("gtwayresponsereason <>", value, "gtwayresponsereason");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsereasonGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("gtwayresponsereason >", value, "gtwayresponsereason");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsereasonGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("gtwayresponsereason >=", value, "gtwayresponsereason");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsereasonLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("gtwayresponsereason <", value, "gtwayresponsereason");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsereasonLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("gtwayresponsereason <=", value, "gtwayresponsereason");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsereasonLike(java.lang.String value) {
            if (value != null)
              addCriterion("gtwayresponsereason like ", value, "gtwayresponsereason");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsereasonNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("gtwayresponsereason not like ", value, "gtwayresponsereason");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsereasonIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("gtwayresponsereason in ", value, "gtwayresponsereason");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsereasonNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("gtwayresponsereason not in ", value, "gtwayresponsereason");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsereasonBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("gtwayresponsereason between ", value1, value2, "gtwayresponsereason");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andGtwayresponsereasonNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("gtwayresponsereason not between ", value1, value2, "gtwayresponsereason");
            return (SMSQueueCriteria) this;
        }
        
        public SMSQueueCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (SMSQueueCriteria) this;
        }
        
        public SMSQueueCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (SMSQueueCriteria) this;
        }
        public SMSQueueCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (SMSQueueCriteria) this;
        }

    }
    
}

