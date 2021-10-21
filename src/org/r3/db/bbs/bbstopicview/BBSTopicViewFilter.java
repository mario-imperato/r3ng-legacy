//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.bbs.bbstopicview;

import java.util.ArrayList;
import java.util.List;

public class BBSTopicViewFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public BBSTopicViewFilter() 
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

    public BBSTopicViewCriteria or() 
    {
        BBSTopicViewCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public BBSTopicViewCriteria createCriteria() 
    {
        BBSTopicViewCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected BBSTopicViewCriteria createCriteriaInternal() 
    {
        BBSTopicViewCriteria criteria = new BBSTopicViewCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class BBSTopicViewCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public BBSTopicViewCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (BBSTopicViewCriteria) this;
        }
        
        public BBSTopicViewCriteria andTopicidIsNull() {
            addCriterion("topicid is null");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopicidIsNotNull() {
            addCriterion("topicid is not null");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopicidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("topicid =", value, "topicid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopicidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("topicid <>", value, "topicid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopicidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("topicid >", value, "topicid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopicidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("topicid >=", value, "topicid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopicidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("topicid <", value, "topicid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopicidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("topicid <=", value, "topicid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopicidLike(java.lang.String value) {
            if (value != null)
              addCriterion("topicid like ", value, "topicid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopicidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("topicid not like ", value, "topicid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopicidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("topicid in ", value, "topicid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopicidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("topicid not in ", value, "topicid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopicidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("topicid between ", value1, value2, "topicid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopicidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("topicid not between ", value1, value2, "topicid");
            return (BBSTopicViewCriteria) this;
        }
        
        public BBSTopicViewCriteria andTopictitleIsNull() {
            addCriterion("topictitle is null");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopictitleIsNotNull() {
            addCriterion("topictitle is not null");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopictitleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("topictitle =", value, "topictitle");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopictitleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("topictitle <>", value, "topictitle");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopictitleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("topictitle >", value, "topictitle");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopictitleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("topictitle >=", value, "topictitle");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopictitleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("topictitle <", value, "topictitle");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopictitleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("topictitle <=", value, "topictitle");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopictitleLike(java.lang.String value) {
            if (value != null)
              addCriterion("topictitle like ", value, "topictitle");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopictitleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("topictitle not like ", value, "topictitle");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopictitleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("topictitle in ", value, "topictitle");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopictitleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("topictitle not in ", value, "topictitle");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopictitleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("topictitle between ", value1, value2, "topictitle");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andTopictitleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("topictitle not between ", value1, value2, "topictitle");
            return (BBSTopicViewCriteria) this;
        }
        
        public BBSTopicViewCriteria andCardidIsNull() {
            addCriterion("cardid is null");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andCardidIsNotNull() {
            addCriterion("cardid is not null");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andCardidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid =", value, "cardid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andCardidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <>", value, "cardid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andCardidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardid >", value, "cardid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andCardidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid >=", value, "cardid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andCardidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <", value, "cardid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andCardidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cardid <=", value, "cardid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andCardidLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardid like ", value, "cardid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andCardidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("cardid not like ", value, "cardid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andCardidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("cardid in ", value, "cardid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andCardidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("cardid not in ", value, "cardid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andCardidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardid between ", value1, value2, "cardid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andCardidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cardid not between ", value1, value2, "cardid");
            return (BBSTopicViewCriteria) this;
        }
        
        public BBSTopicViewCriteria andModeratoridIsNull() {
            addCriterion("moderatorid is null");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratoridIsNotNull() {
            addCriterion("moderatorid is not null");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratoridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("moderatorid =", value, "moderatorid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratoridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("moderatorid <>", value, "moderatorid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratoridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("moderatorid >", value, "moderatorid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratoridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("moderatorid >=", value, "moderatorid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratoridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("moderatorid <", value, "moderatorid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratoridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("moderatorid <=", value, "moderatorid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratoridLike(java.lang.String value) {
            if (value != null)
              addCriterion("moderatorid like ", value, "moderatorid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratoridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("moderatorid not like ", value, "moderatorid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratoridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("moderatorid in ", value, "moderatorid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratoridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("moderatorid not in ", value, "moderatorid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratoridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("moderatorid between ", value1, value2, "moderatorid");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratoridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("moderatorid not between ", value1, value2, "moderatorid");
            return (BBSTopicViewCriteria) this;
        }
        
        public BBSTopicViewCriteria andModeratormodeIsNull() {
            addCriterion("moderatormode is null");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratormodeIsNotNull() {
            addCriterion("moderatormode is not null");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratormodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("moderatormode =", value, "moderatormode");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratormodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("moderatormode <>", value, "moderatormode");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratormodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("moderatormode >", value, "moderatormode");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratormodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("moderatormode >=", value, "moderatormode");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratormodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("moderatormode <", value, "moderatormode");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratormodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("moderatormode <=", value, "moderatormode");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratormodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("moderatormode like ", value, "moderatormode");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratormodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("moderatormode not like ", value, "moderatormode");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratormodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("moderatormode in ", value, "moderatormode");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratormodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("moderatormode not in ", value, "moderatormode");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratormodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("moderatormode between ", value1, value2, "moderatormode");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andModeratormodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("moderatormode not between ", value1, value2, "moderatormode");
            return (BBSTopicViewCriteria) this;
        }
        
        public BBSTopicViewCriteria andOptionsIsNull() {
            addCriterion("options is null");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andOptionsIsNotNull() {
            addCriterion("options is not null");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andOptionsEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options =", value, "options");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andOptionsNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options <>", value, "options");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andOptionsGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("options >", value, "options");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andOptionsGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options >=", value, "options");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andOptionsLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("options <", value, "options");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andOptionsLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("options <=", value, "options");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andOptionsLike(java.lang.String value) {
            if (value != null)
              addCriterion("options like ", value, "options");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andOptionsNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("options not like ", value, "options");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andOptionsIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("options in ", value, "options");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andOptionsNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("options not in ", value, "options");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andOptionsBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("options between ", value1, value2, "options");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andOptionsNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("options not between ", value1, value2, "options");
            return (BBSTopicViewCriteria) this;
        }
        
        public BBSTopicViewCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (BBSTopicViewCriteria) this;
        }
        
        public BBSTopicViewCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (BBSTopicViewCriteria) this;
        }

        
        public BBSTopicViewCriteria andNumthreadsIsNull() {
            addCriterion("numthreads is null");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andNumthreadsIsNotNull() {
            addCriterion("numthreads is not null");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andNumthreadsEqualTo(java.lang.Long value) {
            if (value != null)
              addCriterion("numthreads =", value, "numthreads");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andNumthreadsNotEqualTo(java.lang.Long value) {
            if (value != null)
              addCriterion("numthreads <>", value, "numthreads");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andNumthreadsGreaterThan(java.lang.Long value) {
            if (value != null)
              addCriterion("numthreads >", value, "numthreads");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andNumthreadsGreaterThanOrEqualTo(java.lang.Long value) {
            if (value != null)
              addCriterion("numthreads >=", value, "numthreads");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andNumthreadsLessThan(java.lang.Long value) {
            if (value != null)
              addCriterion("numthreads <", value, "numthreads");
            return (BBSTopicViewCriteria) this;
        }
        public BBSTopicViewCriteria andNumthreadsLessThanOrEqualTo(java.lang.Long value) {
            if (value != null)
              addCriterion("numthreads <=", value, "numthreads");
            return (BBSTopicViewCriteria) this;
        }

        

    }
    
}

