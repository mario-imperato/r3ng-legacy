//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.bbs.bbstopic;

import java.util.ArrayList;
import java.util.List;

public class BBSTopicFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public BBSTopicFilter() 
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

    public BBSTopicCriteria or() 
    {
        BBSTopicCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public BBSTopicCriteria createCriteria() 
    {
        BBSTopicCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected BBSTopicCriteria createCriteriaInternal() 
    {
        BBSTopicCriteria criteria = new BBSTopicCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class BBSTopicCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public BBSTopicCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (BBSTopicCriteria) this;
        }
        
        public BBSTopicCriteria andTopicidIsNull() {
            addCriterion("topicid is null");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopicidIsNotNull() {
            addCriterion("topicid is not null");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopicidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("topicid =", value, "topicid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopicidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("topicid <>", value, "topicid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopicidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("topicid >", value, "topicid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopicidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("topicid >=", value, "topicid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopicidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("topicid <", value, "topicid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopicidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("topicid <=", value, "topicid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopicidLike(java.lang.String value) {
            if (value != null)
              addCriterion("topicid like ", value, "topicid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopicidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("topicid not like ", value, "topicid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopicidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("topicid in ", value, "topicid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopicidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("topicid not in ", value, "topicid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopicidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("topicid between ", value1, value2, "topicid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopicidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("topicid not between ", value1, value2, "topicid");
            return (BBSTopicCriteria) this;
        }
        
        public BBSTopicCriteria andTopictitleIsNull() {
            addCriterion("topictitle is null");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopictitleIsNotNull() {
            addCriterion("topictitle is not null");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopictitleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("topictitle =", value, "topictitle");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopictitleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("topictitle <>", value, "topictitle");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopictitleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("topictitle >", value, "topictitle");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopictitleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("topictitle >=", value, "topictitle");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopictitleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("topictitle <", value, "topictitle");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopictitleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("topictitle <=", value, "topictitle");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopictitleLike(java.lang.String value) {
            if (value != null)
              addCriterion("topictitle like ", value, "topictitle");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopictitleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("topictitle not like ", value, "topictitle");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopictitleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("topictitle in ", value, "topictitle");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopictitleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("topictitle not in ", value, "topictitle");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopictitleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("topictitle between ", value1, value2, "topictitle");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andTopictitleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("topictitle not between ", value1, value2, "topictitle");
            return (BBSTopicCriteria) this;
        }
        
        public BBSTopicCriteria andCardidIsNull() {
            addCriterion("cardid is null");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andCardidIsNotNull() {
            addCriterion("cardid is not null");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andCardidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid =", value, "cardid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andCardidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <>", value, "cardid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andCardidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardid >", value, "cardid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andCardidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid >=", value, "cardid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andCardidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <", value, "cardid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andCardidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <=", value, "cardid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andCardidLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardid like ", value, "cardid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andCardidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardid not like ", value, "cardid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andCardidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("cardid in ", value, "cardid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andCardidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("cardid not in ", value, "cardid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andCardidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardid between ", value1, value2, "cardid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andCardidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardid not between ", value1, value2, "cardid");
            return (BBSTopicCriteria) this;
        }
        
        public BBSTopicCriteria andModeratoridIsNull() {
            addCriterion("moderatorid is null");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratoridIsNotNull() {
            addCriterion("moderatorid is not null");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratoridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("moderatorid =", value, "moderatorid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratoridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("moderatorid <>", value, "moderatorid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratoridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("moderatorid >", value, "moderatorid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratoridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("moderatorid >=", value, "moderatorid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratoridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("moderatorid <", value, "moderatorid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratoridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("moderatorid <=", value, "moderatorid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratoridLike(java.lang.String value) {
            if (value != null)
              addCriterion("moderatorid like ", value, "moderatorid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratoridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("moderatorid not like ", value, "moderatorid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratoridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("moderatorid in ", value, "moderatorid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratoridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("moderatorid not in ", value, "moderatorid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratoridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("moderatorid between ", value1, value2, "moderatorid");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratoridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("moderatorid not between ", value1, value2, "moderatorid");
            return (BBSTopicCriteria) this;
        }
        
        public BBSTopicCriteria andModeratormodeIsNull() {
            addCriterion("moderatormode is null");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratormodeIsNotNull() {
            addCriterion("moderatormode is not null");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratormodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("moderatormode =", value, "moderatormode");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratormodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("moderatormode <>", value, "moderatormode");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratormodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("moderatormode >", value, "moderatormode");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratormodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("moderatormode >=", value, "moderatormode");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratormodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("moderatormode <", value, "moderatormode");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratormodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("moderatormode <=", value, "moderatormode");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratormodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("moderatormode like ", value, "moderatormode");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratormodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("moderatormode not like ", value, "moderatormode");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratormodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("moderatormode in ", value, "moderatormode");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratormodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("moderatormode not in ", value, "moderatormode");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratormodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("moderatormode between ", value1, value2, "moderatormode");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andModeratormodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("moderatormode not between ", value1, value2, "moderatormode");
            return (BBSTopicCriteria) this;
        }
        
        public BBSTopicCriteria andOptionsIsNull() {
            addCriterion("options is null");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andOptionsIsNotNull() {
            addCriterion("options is not null");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andOptionsEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options =", value, "options");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andOptionsNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options <>", value, "options");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andOptionsGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("options >", value, "options");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andOptionsGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options >=", value, "options");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andOptionsLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("options <", value, "options");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andOptionsLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options <=", value, "options");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andOptionsLike(java.lang.String value) {
            if (value != null)
              addCriterion("options like ", value, "options");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andOptionsNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("options not like ", value, "options");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andOptionsIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("options in ", value, "options");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andOptionsNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("options not in ", value, "options");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andOptionsBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("options between ", value1, value2, "options");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andOptionsNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("options not between ", value1, value2, "options");
            return (BBSTopicCriteria) this;
        }
        
        public BBSTopicCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (BBSTopicCriteria) this;
        }
        
        public BBSTopicCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (BBSTopicCriteria) this;
        }
        public BBSTopicCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (BBSTopicCriteria) this;
        }

    }
    
}

