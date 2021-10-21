//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.channel;

import java.util.ArrayList;
import java.util.List;

public class ChannelFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public ChannelFilter() 
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

    public ChannelCriteria or() 
    {
        ChannelCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public ChannelCriteria createCriteria() 
    {
        ChannelCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected ChannelCriteria createCriteriaInternal() 
    {
        ChannelCriteria criteria = new ChannelCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class ChannelCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public ChannelCriteria andChannelidIsNull() {
            addCriterion("channelid is null");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelidIsNotNull() {
            addCriterion("channelid is not null");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("channelid =", value, "channelid");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("channelid <>", value, "channelid");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("channelid >", value, "channelid");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("channelid >=", value, "channelid");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("channelid <", value, "channelid");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("channelid <=", value, "channelid");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelidLike(java.lang.String value) {
            if (value != null)
              addCriterion("channelid like ", value, "channelid");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("channelid not like ", value, "channelid");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("channelid in ", value, "channelid");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("channelid not in ", value, "channelid");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("channelid between ", value1, value2, "channelid");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("channelid not between ", value1, value2, "channelid");
            return (ChannelCriteria) this;
        }
        
        public ChannelCriteria andChannelnameIsNull() {
            addCriterion("channelname is null");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelnameIsNotNull() {
            addCriterion("channelname is not null");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("channelname =", value, "channelname");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("channelname <>", value, "channelname");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("channelname >", value, "channelname");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("channelname >=", value, "channelname");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("channelname <", value, "channelname");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("channelname <=", value, "channelname");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("channelname like ", value, "channelname");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("channelname not like ", value, "channelname");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("channelname in ", value, "channelname");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("channelname not in ", value, "channelname");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("channelname between ", value1, value2, "channelname");
            return (ChannelCriteria) this;
        }
        public ChannelCriteria andChannelnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("channelname not between ", value1, value2, "channelname");
            return (ChannelCriteria) this;
        }
    }
    
}

