//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.outmailspooler;

import java.util.ArrayList;
import java.util.List;

public class OutMailSpoolerFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public OutMailSpoolerFilter() 
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

    public OutMailSpoolerCriteria or() 
    {
        OutMailSpoolerCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public OutMailSpoolerCriteria createCriteria() 
    {
        OutMailSpoolerCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected OutMailSpoolerCriteria createCriteriaInternal() 
    {
        OutMailSpoolerCriteria criteria = new OutMailSpoolerCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class OutMailSpoolerCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public OutMailSpoolerCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (OutMailSpoolerCriteria) this;
        }
        
        public OutMailSpoolerCriteria andMessageidIsNull() {
            addCriterion("messageid is null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMessageidIsNotNull() {
            addCriterion("messageid is not null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMessageidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messageid =", value, "messageid");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMessageidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messageid <>", value, "messageid");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMessageidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("messageid >", value, "messageid");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMessageidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messageid >=", value, "messageid");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMessageidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("messageid <", value, "messageid");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMessageidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("messageid <=", value, "messageid");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMessageidLike(java.lang.String value) {
            if (value != null)
              addCriterion("messageid like ", value, "messageid");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMessageidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("messageid not like ", value, "messageid");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMessageidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("messageid in ", value, "messageid");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMessageidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("messageid not in ", value, "messageid");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMessageidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("messageid between ", value1, value2, "messageid");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMessageidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("messageid not between ", value1, value2, "messageid");
            return (OutMailSpoolerCriteria) this;
        }
        
        public OutMailSpoolerCriteria andMsgtitleIsNull() {
            addCriterion("msgtitle is null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtitleIsNotNull() {
            addCriterion("msgtitle is not null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtitleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgtitle =", value, "msgtitle");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtitleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgtitle <>", value, "msgtitle");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtitleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("msgtitle >", value, "msgtitle");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtitleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgtitle >=", value, "msgtitle");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtitleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("msgtitle <", value, "msgtitle");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtitleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgtitle <=", value, "msgtitle");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtitleLike(java.lang.String value) {
            if (value != null)
              addCriterion("msgtitle like ", value, "msgtitle");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtitleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("msgtitle not like ", value, "msgtitle");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtitleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("msgtitle in ", value, "msgtitle");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtitleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("msgtitle not in ", value, "msgtitle");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtitleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("msgtitle between ", value1, value2, "msgtitle");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtitleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("msgtitle not between ", value1, value2, "msgtitle");
            return (OutMailSpoolerCriteria) this;
        }
        
        public OutMailSpoolerCriteria andMsgtextIsNull() {
            addCriterion("msgtext is null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtextIsNotNull() {
            addCriterion("msgtext is not null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtextEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgtext =", value, "msgtext");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtextNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgtext <>", value, "msgtext");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtextGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("msgtext >", value, "msgtext");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtextGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgtext >=", value, "msgtext");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtextLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("msgtext <", value, "msgtext");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtextLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgtext <=", value, "msgtext");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtextLike(java.lang.String value) {
            if (value != null)
              addCriterion("msgtext like ", value, "msgtext");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtextNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("msgtext not like ", value, "msgtext");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtextIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("msgtext in ", value, "msgtext");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtextNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("msgtext not in ", value, "msgtext");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtextBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("msgtext between ", value1, value2, "msgtext");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgtextNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("msgtext not between ", value1, value2, "msgtext");
            return (OutMailSpoolerCriteria) this;
        }
        
        public OutMailSpoolerCriteria andMsgfromIsNull() {
            addCriterion("msgfrom is null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgfromIsNotNull() {
            addCriterion("msgfrom is not null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgfromEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgfrom =", value, "msgfrom");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgfromNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgfrom <>", value, "msgfrom");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgfromGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("msgfrom >", value, "msgfrom");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgfromGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgfrom >=", value, "msgfrom");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgfromLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("msgfrom <", value, "msgfrom");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgfromLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgfrom <=", value, "msgfrom");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgfromLike(java.lang.String value) {
            if (value != null)
              addCriterion("msgfrom like ", value, "msgfrom");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgfromNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("msgfrom not like ", value, "msgfrom");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgfromIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("msgfrom in ", value, "msgfrom");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgfromNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("msgfrom not in ", value, "msgfrom");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgfromBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("msgfrom between ", value1, value2, "msgfrom");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgfromNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("msgfrom not between ", value1, value2, "msgfrom");
            return (OutMailSpoolerCriteria) this;
        }
        
        public OutMailSpoolerCriteria andMsgccIsNull() {
            addCriterion("msgcc is null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgccIsNotNull() {
            addCriterion("msgcc is not null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgccEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgcc =", value, "msgcc");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgccNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgcc <>", value, "msgcc");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgccGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("msgcc >", value, "msgcc");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgccGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgcc >=", value, "msgcc");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgccLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("msgcc <", value, "msgcc");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgccLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgcc <=", value, "msgcc");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgccLike(java.lang.String value) {
            if (value != null)
              addCriterion("msgcc like ", value, "msgcc");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgccNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("msgcc not like ", value, "msgcc");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgccIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("msgcc in ", value, "msgcc");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgccNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("msgcc not in ", value, "msgcc");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgccBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("msgcc between ", value1, value2, "msgcc");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgccNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("msgcc not between ", value1, value2, "msgcc");
            return (OutMailSpoolerCriteria) this;
        }
        
        public OutMailSpoolerCriteria andMsgbccIsNull() {
            addCriterion("msgbcc is null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgbccIsNotNull() {
            addCriterion("msgbcc is not null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgbccEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgbcc =", value, "msgbcc");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgbccNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgbcc <>", value, "msgbcc");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgbccGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("msgbcc >", value, "msgbcc");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgbccGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgbcc >=", value, "msgbcc");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgbccLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("msgbcc <", value, "msgbcc");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgbccLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgbcc <=", value, "msgbcc");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgbccLike(java.lang.String value) {
            if (value != null)
              addCriterion("msgbcc like ", value, "msgbcc");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgbccNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("msgbcc not like ", value, "msgbcc");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgbccIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("msgbcc in ", value, "msgbcc");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgbccNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("msgbcc not in ", value, "msgbcc");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgbccBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("msgbcc between ", value1, value2, "msgbcc");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgbccNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("msgbcc not between ", value1, value2, "msgbcc");
            return (OutMailSpoolerCriteria) this;
        }
        
        public OutMailSpoolerCriteria andMsgmodeIsNull() {
            addCriterion("msgmode is null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgmodeIsNotNull() {
            addCriterion("msgmode is not null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgmodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgmode =", value, "msgmode");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgmodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgmode <>", value, "msgmode");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgmodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("msgmode >", value, "msgmode");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgmodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgmode >=", value, "msgmode");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgmodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("msgmode <", value, "msgmode");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgmodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("msgmode <=", value, "msgmode");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgmodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("msgmode like ", value, "msgmode");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgmodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("msgmode not like ", value, "msgmode");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgmodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("msgmode in ", value, "msgmode");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgmodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("msgmode not in ", value, "msgmode");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgmodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("msgmode between ", value1, value2, "msgmode");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgmodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("msgmode not between ", value1, value2, "msgmode");
            return (OutMailSpoolerCriteria) this;
        }
        
        public OutMailSpoolerCriteria andMsgsendatIsNull() {
            addCriterion("msgsendat is null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgsendatIsNotNull() {
            addCriterion("msgsendat is not null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgsendatEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("msgsendat =", value, "msgsendat");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgsendatNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("msgsendat <>", value, "msgsendat");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgsendatGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("msgsendat >", value, "msgsendat");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgsendatGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("msgsendat >=", value, "msgsendat");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgsendatLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("msgsendat <", value, "msgsendat");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andMsgsendatLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("msgsendat <=", value, "msgsendat");
            return (OutMailSpoolerCriteria) this;
        }

        
        public OutMailSpoolerCriteria andNumberofattachmentsIsNull() {
            addCriterion("numberofattachments is null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andNumberofattachmentsIsNotNull() {
            addCriterion("numberofattachments is not null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andNumberofattachmentsEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofattachments =", value, "numberofattachments");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andNumberofattachmentsNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofattachments <>", value, "numberofattachments");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andNumberofattachmentsGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofattachments >", value, "numberofattachments");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andNumberofattachmentsGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofattachments >=", value, "numberofattachments");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andNumberofattachmentsLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofattachments <", value, "numberofattachments");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andNumberofattachmentsLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofattachments <=", value, "numberofattachments");
            return (OutMailSpoolerCriteria) this;
        }

        
        public OutMailSpoolerCriteria andNumberoftargetsIsNull() {
            addCriterion("numberoftargets is null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andNumberoftargetsIsNotNull() {
            addCriterion("numberoftargets is not null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andNumberoftargetsEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberoftargets =", value, "numberoftargets");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andNumberoftargetsNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberoftargets <>", value, "numberoftargets");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andNumberoftargetsGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberoftargets >", value, "numberoftargets");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andNumberoftargetsGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberoftargets >=", value, "numberoftargets");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andNumberoftargetsLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberoftargets <", value, "numberoftargets");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andNumberoftargetsLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberoftargets <=", value, "numberoftargets");
            return (OutMailSpoolerCriteria) this;
        }

        
        public OutMailSpoolerCriteria andNumberofsentitemsIsNull() {
            addCriterion("numberofsentitems is null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andNumberofsentitemsIsNotNull() {
            addCriterion("numberofsentitems is not null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andNumberofsentitemsEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofsentitems =", value, "numberofsentitems");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andNumberofsentitemsNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofsentitems <>", value, "numberofsentitems");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andNumberofsentitemsGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofsentitems >", value, "numberofsentitems");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andNumberofsentitemsGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofsentitems >=", value, "numberofsentitems");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andNumberofsentitemsLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofsentitems <", value, "numberofsentitems");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andNumberofsentitemsLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofsentitems <=", value, "numberofsentitems");
            return (OutMailSpoolerCriteria) this;
        }

        
        public OutMailSpoolerCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (OutMailSpoolerCriteria) this;
        }
        
        public OutMailSpoolerCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (OutMailSpoolerCriteria) this;
        }
        public OutMailSpoolerCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (OutMailSpoolerCriteria) this;
        }

    }
    
}

