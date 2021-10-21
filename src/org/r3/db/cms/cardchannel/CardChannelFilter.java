//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardchannel;

import java.util.ArrayList;
import java.util.List;

public class CardChannelFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public CardChannelFilter() 
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

    public CardChannelCriteria or() 
    {
        CardChannelCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public CardChannelCriteria createCriteria() 
    {
        CardChannelCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected CardChannelCriteria createCriteriaInternal() 
    {
        CardChannelCriteria criteria = new CardChannelCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class CardChannelCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public CardChannelCriteria andChannelidIsNull() {
            addCriterion("channelid is null");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andChannelidIsNotNull() {
            addCriterion("channelid is not null");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andChannelidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("channelid =", value, "channelid");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andChannelidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("channelid <>", value, "channelid");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andChannelidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("channelid >", value, "channelid");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andChannelidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("channelid >=", value, "channelid");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andChannelidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("channelid <", value, "channelid");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andChannelidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("channelid <=", value, "channelid");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andChannelidLike(java.lang.String value) {
            if (value != null)
              addCriterion("channelid like ", value, "channelid");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andChannelidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("channelid not like ", value, "channelid");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andChannelidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("channelid in ", value, "channelid");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andChannelidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("channelid not in ", value, "channelid");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andChannelidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("channelid between ", value1, value2, "channelid");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andChannelidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("channelid not between ", value1, value2, "channelid");
            return (CardChannelCriteria) this;
        }
        
        public CardChannelCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (CardChannelCriteria) this;
        }
        
        public CardChannelCriteria andCardidIsNull() {
            addCriterion("cardid is null");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andCardidIsNotNull() {
            addCriterion("cardid is not null");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andCardidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid =", value, "cardid");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andCardidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <>", value, "cardid");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andCardidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardid >", value, "cardid");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andCardidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid >=", value, "cardid");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andCardidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <", value, "cardid");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andCardidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <=", value, "cardid");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andCardidLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardid like ", value, "cardid");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andCardidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardid not like ", value, "cardid");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andCardidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("cardid in ", value, "cardid");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andCardidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("cardid not in ", value, "cardid");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andCardidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardid between ", value1, value2, "cardid");
            return (CardChannelCriteria) this;
        }
        public CardChannelCriteria andCardidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardid not between ", value1, value2, "cardid");
            return (CardChannelCriteria) this;
        }
    }
    
}

