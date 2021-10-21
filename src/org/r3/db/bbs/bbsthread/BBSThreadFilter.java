//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.bbs.bbsthread;

import java.util.ArrayList;
import java.util.List;

public class BBSThreadFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public BBSThreadFilter() 
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

    public BBSThreadCriteria or() 
    {
        BBSThreadCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public BBSThreadCriteria createCriteria() 
    {
        BBSThreadCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected BBSThreadCriteria createCriteriaInternal() 
    {
        BBSThreadCriteria criteria = new BBSThreadCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class BBSThreadCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public BBSThreadCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (BBSThreadCriteria) this;
        }
        
        public BBSThreadCriteria andThreadidIsNull() {
            addCriterion("threadid is null");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadidIsNotNull() {
            addCriterion("threadid is not null");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadid =", value, "threadid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadid <>", value, "threadid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("threadid >", value, "threadid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadid >=", value, "threadid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("threadid <", value, "threadid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadid <=", value, "threadid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadidLike(java.lang.String value) {
            if (value != null)
              addCriterion("threadid like ", value, "threadid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("threadid not like ", value, "threadid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("threadid in ", value, "threadid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("threadid not in ", value, "threadid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("threadid between ", value1, value2, "threadid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("threadid not between ", value1, value2, "threadid");
            return (BBSThreadCriteria) this;
        }
        
        public BBSThreadCriteria andTopicidIsNull() {
            addCriterion("topicid is null");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andTopicidIsNotNull() {
            addCriterion("topicid is not null");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andTopicidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("topicid =", value, "topicid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andTopicidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("topicid <>", value, "topicid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andTopicidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("topicid >", value, "topicid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andTopicidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("topicid >=", value, "topicid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andTopicidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("topicid <", value, "topicid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andTopicidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("topicid <=", value, "topicid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andTopicidLike(java.lang.String value) {
            if (value != null)
              addCriterion("topicid like ", value, "topicid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andTopicidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("topicid not like ", value, "topicid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andTopicidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("topicid in ", value, "topicid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andTopicidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("topicid not in ", value, "topicid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andTopicidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("topicid between ", value1, value2, "topicid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andTopicidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("topicid not between ", value1, value2, "topicid");
            return (BBSThreadCriteria) this;
        }
        
        public BBSThreadCriteria andThreadtitleIsNull() {
            addCriterion("threadtitle is null");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadtitleIsNotNull() {
            addCriterion("threadtitle is not null");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadtitleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadtitle =", value, "threadtitle");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadtitleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadtitle <>", value, "threadtitle");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadtitleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("threadtitle >", value, "threadtitle");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadtitleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadtitle >=", value, "threadtitle");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadtitleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("threadtitle <", value, "threadtitle");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadtitleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadtitle <=", value, "threadtitle");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadtitleLike(java.lang.String value) {
            if (value != null)
              addCriterion("threadtitle like ", value, "threadtitle");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadtitleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("threadtitle not like ", value, "threadtitle");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadtitleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("threadtitle in ", value, "threadtitle");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadtitleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("threadtitle not in ", value, "threadtitle");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadtitleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("threadtitle between ", value1, value2, "threadtitle");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadtitleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("threadtitle not between ", value1, value2, "threadtitle");
            return (BBSThreadCriteria) this;
        }
        
        public BBSThreadCriteria andThreadprofileIsNull() {
            addCriterion("threadprofile is null");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadprofileIsNotNull() {
            addCriterion("threadprofile is not null");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadprofileEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadprofile =", value, "threadprofile");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadprofileNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadprofile <>", value, "threadprofile");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadprofileGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("threadprofile >", value, "threadprofile");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadprofileGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadprofile >=", value, "threadprofile");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadprofileLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("threadprofile <", value, "threadprofile");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadprofileLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadprofile <=", value, "threadprofile");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadprofileLike(java.lang.String value) {
            if (value != null)
              addCriterion("threadprofile like ", value, "threadprofile");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadprofileNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("threadprofile not like ", value, "threadprofile");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadprofileIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("threadprofile in ", value, "threadprofile");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadprofileNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("threadprofile not in ", value, "threadprofile");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadprofileBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("threadprofile between ", value1, value2, "threadprofile");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andThreadprofileNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("threadprofile not between ", value1, value2, "threadprofile");
            return (BBSThreadCriteria) this;
        }
        
        public BBSThreadCriteria andUseridIsNull() {
            addCriterion("userid is null");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andUseridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid =", value, "userid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andUseridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <>", value, "userid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andUseridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid >", value, "userid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andUseridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid >=", value, "userid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andUseridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid <", value, "userid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andUseridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <=", value, "userid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andUseridLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid like ", value, "userid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andUseridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid not like ", value, "userid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andUseridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("userid in ", value, "userid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andUseridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("userid not in ", value, "userid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andUseridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid between ", value1, value2, "userid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andUseridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid not between ", value1, value2, "userid");
            return (BBSThreadCriteria) this;
        }
        
        public BBSThreadCriteria andCreationdateIsNull() {
            addCriterion("creationdate is null");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andCreationdateIsNotNull() {
            addCriterion("creationdate is not null");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andCreationdateEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("creationdate =", value, "creationdate");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andCreationdateNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("creationdate <>", value, "creationdate");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andCreationdateGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("creationdate >", value, "creationdate");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andCreationdateGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("creationdate >=", value, "creationdate");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andCreationdateLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("creationdate <", value, "creationdate");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andCreationdateLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("creationdate <=", value, "creationdate");
            return (BBSThreadCriteria) this;
        }

        
        public BBSThreadCriteria andNumpostsIsNull() {
            addCriterion("numposts is null");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andNumpostsIsNotNull() {
            addCriterion("numposts is not null");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andNumpostsEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numposts =", value, "numposts");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andNumpostsNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numposts <>", value, "numposts");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andNumpostsGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numposts >", value, "numposts");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andNumpostsGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numposts >=", value, "numposts");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andNumpostsLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numposts <", value, "numposts");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andNumpostsLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numposts <=", value, "numposts");
            return (BBSThreadCriteria) this;
        }

        
        public BBSThreadCriteria andLastthreadnodeidIsNull() {
            addCriterion("lastthreadnodeid is null");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andLastthreadnodeidIsNotNull() {
            addCriterion("lastthreadnodeid is not null");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andLastthreadnodeidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lastthreadnodeid =", value, "lastthreadnodeid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andLastthreadnodeidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lastthreadnodeid <>", value, "lastthreadnodeid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andLastthreadnodeidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("lastthreadnodeid >", value, "lastthreadnodeid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andLastthreadnodeidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lastthreadnodeid >=", value, "lastthreadnodeid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andLastthreadnodeidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("lastthreadnodeid <", value, "lastthreadnodeid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andLastthreadnodeidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lastthreadnodeid <=", value, "lastthreadnodeid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andLastthreadnodeidLike(java.lang.String value) {
            if (value != null)
              addCriterion("lastthreadnodeid like ", value, "lastthreadnodeid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andLastthreadnodeidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("lastthreadnodeid not like ", value, "lastthreadnodeid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andLastthreadnodeidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("lastthreadnodeid in ", value, "lastthreadnodeid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andLastthreadnodeidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("lastthreadnodeid not in ", value, "lastthreadnodeid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andLastthreadnodeidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("lastthreadnodeid between ", value1, value2, "lastthreadnodeid");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andLastthreadnodeidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("lastthreadnodeid not between ", value1, value2, "lastthreadnodeid");
            return (BBSThreadCriteria) this;
        }
        
        public BBSThreadCriteria andLastposttimestampIsNull() {
            addCriterion("lastposttimestamp is null");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andLastposttimestampIsNotNull() {
            addCriterion("lastposttimestamp is not null");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andLastposttimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("lastposttimestamp =", value, "lastposttimestamp");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andLastposttimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("lastposttimestamp <>", value, "lastposttimestamp");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andLastposttimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("lastposttimestamp >", value, "lastposttimestamp");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andLastposttimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("lastposttimestamp >=", value, "lastposttimestamp");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andLastposttimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("lastposttimestamp <", value, "lastposttimestamp");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andLastposttimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("lastposttimestamp <=", value, "lastposttimestamp");
            return (BBSThreadCriteria) this;
        }

        
        public BBSThreadCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (BBSThreadCriteria) this;
        }
        
        public BBSThreadCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (BBSThreadCriteria) this;
        }
        public BBSThreadCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (BBSThreadCriteria) this;
        }

    }
    
}

