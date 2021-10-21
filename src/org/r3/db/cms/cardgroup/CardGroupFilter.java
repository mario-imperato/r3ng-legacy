//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardgroup;

import java.util.ArrayList;
import java.util.List;

public class CardGroupFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public CardGroupFilter() 
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

    public CardGroupCriteria or() 
    {
        CardGroupCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public CardGroupCriteria createCriteria() 
    {
        CardGroupCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected CardGroupCriteria createCriteriaInternal() 
    {
        CardGroupCriteria criteria = new CardGroupCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class CardGroupCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public CardGroupCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (CardGroupCriteria) this;
        }
        
        public CardGroupCriteria andCardidIsNull() {
            addCriterion("cardid is null");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andCardidIsNotNull() {
            addCriterion("cardid is not null");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andCardidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid =", value, "cardid");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andCardidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <>", value, "cardid");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andCardidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardid >", value, "cardid");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andCardidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid >=", value, "cardid");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andCardidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <", value, "cardid");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andCardidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <=", value, "cardid");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andCardidLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardid like ", value, "cardid");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andCardidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardid not like ", value, "cardid");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andCardidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("cardid in ", value, "cardid");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andCardidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("cardid not in ", value, "cardid");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andCardidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardid between ", value1, value2, "cardid");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andCardidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardid not between ", value1, value2, "cardid");
            return (CardGroupCriteria) this;
        }
        
        public CardGroupCriteria andGroupidIsNull() {
            addCriterion("groupid is null");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andGroupidIsNotNull() {
            addCriterion("groupid is not null");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andGroupidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupid =", value, "groupid");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andGroupidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupid <>", value, "groupid");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andGroupidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("groupid >", value, "groupid");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andGroupidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupid >=", value, "groupid");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andGroupidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("groupid <", value, "groupid");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andGroupidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("groupid <=", value, "groupid");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andGroupidLike(java.lang.String value) {
            if (value != null)
              addCriterion("groupid like ", value, "groupid");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andGroupidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("groupid not like ", value, "groupid");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andGroupidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("groupid in ", value, "groupid");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andGroupidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("groupid not in ", value, "groupid");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andGroupidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("groupid between ", value1, value2, "groupid");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andGroupidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("groupid not between ", value1, value2, "groupid");
            return (CardGroupCriteria) this;
        }
        
        public CardGroupCriteria andValidtoIsNull() {
            addCriterion("validto is null");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andValidtoIsNotNull() {
            addCriterion("validto is not null");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andValidtoEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("validto =", value, "validto");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andValidtoNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("validto <>", value, "validto");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andValidtoGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("validto >", value, "validto");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andValidtoGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("validto >=", value, "validto");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andValidtoLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("validto <", value, "validto");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andValidtoLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("validto <=", value, "validto");
            return (CardGroupCriteria) this;
        }

        
        public CardGroupCriteria andValidfromIsNull() {
            addCriterion("validfrom is null");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andValidfromIsNotNull() {
            addCriterion("validfrom is not null");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andValidfromEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("validfrom =", value, "validfrom");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andValidfromNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("validfrom <>", value, "validfrom");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andValidfromGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("validfrom >", value, "validfrom");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andValidfromGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("validfrom >=", value, "validfrom");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andValidfromLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("validfrom <", value, "validfrom");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andValidfromLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("validfrom <=", value, "validfrom");
            return (CardGroupCriteria) this;
        }

        
        public CardGroupCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (CardGroupCriteria) this;
        }
        
        public CardGroupCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (CardGroupCriteria) this;
        }
        public CardGroupCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (CardGroupCriteria) this;
        }

    }
    
}

