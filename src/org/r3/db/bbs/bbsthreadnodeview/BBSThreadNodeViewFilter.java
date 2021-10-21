//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.bbs.bbsthreadnodeview;

import java.util.ArrayList;
import java.util.List;

public class BBSThreadNodeViewFilter{
    protected String orderByClause;
    protected String  groupByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public BBSThreadNodeViewFilter() 
    {
        oredCriteria = new ArrayList<org.r3.db.utils.Criteria>();
        limitFetch = 0;
        groupByClause = null;
    }
    
    public String getGroupByClause()
	  {
	  	return groupByClause;
	  }
    
	  public void setGroupByClause(String groupByClause)
	  {
	  	this.groupByClause = groupByClause;
	  }
	
	  public boolean isGroupBy(String aColumnName)
	  {
	  	return groupByClause != null && groupByClause.indexOf(aColumnName) >= 0;
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

    public BBSThreadNodeViewCriteria or() 
    {
        BBSThreadNodeViewCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public BBSThreadNodeViewCriteria createCriteria() 
    {
        BBSThreadNodeViewCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected BBSThreadNodeViewCriteria createCriteriaInternal() 
    {
        BBSThreadNodeViewCriteria criteria = new BBSThreadNodeViewCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class BBSThreadNodeViewCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public BBSThreadNodeViewCriteria andThreadnodeidIsNull() {
            addCriterion("threadnodeid is null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadnodeidIsNotNull() {
            addCriterion("threadnodeid is not null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadnodeidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadnodeid =", value, "threadnodeid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadnodeidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadnodeid <>", value, "threadnodeid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadnodeidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("threadnodeid >", value, "threadnodeid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadnodeidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadnodeid >=", value, "threadnodeid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadnodeidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("threadnodeid <", value, "threadnodeid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadnodeidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadnodeid <=", value, "threadnodeid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadnodeidLike(java.lang.String value) {
            if (value != null)
              addCriterion("threadnodeid like ", value, "threadnodeid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadnodeidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("threadnodeid not like ", value, "threadnodeid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadnodeidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("threadnodeid in ", value, "threadnodeid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadnodeidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("threadnodeid not in ", value, "threadnodeid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadnodeidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("threadnodeid between ", value1, value2, "threadnodeid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadnodeidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("threadnodeid not between ", value1, value2, "threadnodeid");
            return (BBSThreadNodeViewCriteria) this;
        }
        
        public BBSThreadNodeViewCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (BBSThreadNodeViewCriteria) this;
        }
        
        public BBSThreadNodeViewCriteria andThreadidIsNull() {
            addCriterion("threadid is null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadidIsNotNull() {
            addCriterion("threadid is not null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadid =", value, "threadid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadid <>", value, "threadid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("threadid >", value, "threadid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadid >=", value, "threadid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("threadid <", value, "threadid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadid <=", value, "threadid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadidLike(java.lang.String value) {
            if (value != null)
              addCriterion("threadid like ", value, "threadid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("threadid not like ", value, "threadid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("threadid in ", value, "threadid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("threadid not in ", value, "threadid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("threadid between ", value1, value2, "threadid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andThreadidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("threadid not between ", value1, value2, "threadid");
            return (BBSThreadNodeViewCriteria) this;
        }
        
        public BBSThreadNodeViewCriteria andNodetypeIsNull() {
            addCriterion("nodetype is null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetypeIsNotNull() {
            addCriterion("nodetype is not null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype =", value, "nodetype");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype <>", value, "nodetype");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype >", value, "nodetype");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype >=", value, "nodetype");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype <", value, "nodetype");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype <=", value, "nodetype");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype like ", value, "nodetype");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype not like ", value, "nodetype");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("nodetype in ", value, "nodetype");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("nodetype not in ", value, "nodetype");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodetype between ", value1, value2, "nodetype");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodetype not between ", value1, value2, "nodetype");
            return (BBSThreadNodeViewCriteria) this;
        }
        
        public BBSThreadNodeViewCriteria andNodetitleIsNull() {
            addCriterion("nodetitle is null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetitleIsNotNull() {
            addCriterion("nodetitle is not null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetitleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetitle =", value, "nodetitle");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetitleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetitle <>", value, "nodetitle");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetitleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodetitle >", value, "nodetitle");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetitleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetitle >=", value, "nodetitle");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetitleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodetitle <", value, "nodetitle");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetitleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetitle <=", value, "nodetitle");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetitleLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodetitle like ", value, "nodetitle");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetitleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodetitle not like ", value, "nodetitle");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetitleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("nodetitle in ", value, "nodetitle");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetitleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("nodetitle not in ", value, "nodetitle");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetitleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodetitle between ", value1, value2, "nodetitle");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetitleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodetitle not between ", value1, value2, "nodetitle");
            return (BBSThreadNodeViewCriteria) this;
        }
        
        public BBSThreadNodeViewCriteria andNodetextIsNull() {
            addCriterion("nodetext is null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetextIsNotNull() {
            addCriterion("nodetext is not null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetextEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetext =", value, "nodetext");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetextNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetext <>", value, "nodetext");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetextGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodetext >", value, "nodetext");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetextGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetext >=", value, "nodetext");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetextLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodetext <", value, "nodetext");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetextLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetext <=", value, "nodetext");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetextLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodetext like ", value, "nodetext");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetextNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodetext not like ", value, "nodetext");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetextIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("nodetext in ", value, "nodetext");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetextNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("nodetext not in ", value, "nodetext");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetextBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodetext between ", value1, value2, "nodetext");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodetextNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodetext not between ", value1, value2, "nodetext");
            return (BBSThreadNodeViewCriteria) this;
        }
        
        public BBSThreadNodeViewCriteria andNodeparentidIsNull() {
            addCriterion("nodeparentid is null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodeparentidIsNotNull() {
            addCriterion("nodeparentid is not null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodeparentidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodeparentid =", value, "nodeparentid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodeparentidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodeparentid <>", value, "nodeparentid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodeparentidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodeparentid >", value, "nodeparentid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodeparentidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodeparentid >=", value, "nodeparentid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodeparentidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodeparentid <", value, "nodeparentid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodeparentidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodeparentid <=", value, "nodeparentid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodeparentidLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodeparentid like ", value, "nodeparentid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodeparentidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodeparentid not like ", value, "nodeparentid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodeparentidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("nodeparentid in ", value, "nodeparentid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodeparentidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("nodeparentid not in ", value, "nodeparentid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodeparentidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodeparentid between ", value1, value2, "nodeparentid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodeparentidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodeparentid not between ", value1, value2, "nodeparentid");
            return (BBSThreadNodeViewCriteria) this;
        }
        
        public BBSThreadNodeViewCriteria andNodepathIsNull() {
            addCriterion("nodepath is null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodepathIsNotNull() {
            addCriterion("nodepath is not null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodepathEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodepath =", value, "nodepath");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodepathNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodepath <>", value, "nodepath");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodepathGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodepath >", value, "nodepath");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodepathGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodepath >=", value, "nodepath");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodepathLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodepath <", value, "nodepath");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodepathLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodepath <=", value, "nodepath");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodepathLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodepath like ", value, "nodepath");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodepathNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodepath not like ", value, "nodepath");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodepathIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("nodepath in ", value, "nodepath");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodepathNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("nodepath not in ", value, "nodepath");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodepathBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodepath between ", value1, value2, "nodepath");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNodepathNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodepath not between ", value1, value2, "nodepath");
            return (BBSThreadNodeViewCriteria) this;
        }
        
        public BBSThreadNodeViewCriteria andUseridIsNull() {
            addCriterion("userid is null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andUseridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid =", value, "userid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andUseridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <>", value, "userid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andUseridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid >", value, "userid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andUseridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid >=", value, "userid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andUseridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid <", value, "userid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andUseridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <=", value, "userid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andUseridLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid like ", value, "userid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andUseridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid not like ", value, "userid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andUseridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("userid in ", value, "userid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andUseridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("userid not in ", value, "userid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andUseridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid between ", value1, value2, "userid");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andUseridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid not between ", value1, value2, "userid");
            return (BBSThreadNodeViewCriteria) this;
        }
        
        public BBSThreadNodeViewCriteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNicknameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nickname =", value, "nickname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNicknameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nickname <>", value, "nickname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNicknameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("nickname >", value, "nickname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNicknameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nickname >=", value, "nickname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNicknameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("nickname <", value, "nickname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNicknameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nickname <=", value, "nickname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNicknameLike(java.lang.String value) {
            if (value != null)
              addCriterion("nickname like ", value, "nickname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNicknameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("nickname not like ", value, "nickname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNicknameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("nickname in ", value, "nickname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNicknameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("nickname not in ", value, "nickname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNicknameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nickname between ", value1, value2, "nickname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andNicknameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nickname not between ", value1, value2, "nickname");
            return (BBSThreadNodeViewCriteria) this;
        }
        
        public BBSThreadNodeViewCriteria andFirstnameIsNull() {
            addCriterion("firstname is null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andFirstnameIsNotNull() {
            addCriterion("firstname is not null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andFirstnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("firstname =", value, "firstname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andFirstnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("firstname <>", value, "firstname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andFirstnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("firstname >", value, "firstname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andFirstnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("firstname >=", value, "firstname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andFirstnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("firstname <", value, "firstname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andFirstnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("firstname <=", value, "firstname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andFirstnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("firstname like ", value, "firstname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andFirstnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("firstname not like ", value, "firstname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andFirstnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("firstname in ", value, "firstname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andFirstnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("firstname not in ", value, "firstname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andFirstnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("firstname between ", value1, value2, "firstname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andFirstnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("firstname not between ", value1, value2, "firstname");
            return (BBSThreadNodeViewCriteria) this;
        }
        
        public BBSThreadNodeViewCriteria andLastnameIsNull() {
            addCriterion("lastname is null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andLastnameIsNotNull() {
            addCriterion("lastname is not null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andLastnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lastname =", value, "lastname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andLastnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lastname <>", value, "lastname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andLastnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("lastname >", value, "lastname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andLastnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lastname >=", value, "lastname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andLastnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("lastname <", value, "lastname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andLastnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lastname <=", value, "lastname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andLastnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("lastname like ", value, "lastname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andLastnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("lastname not like ", value, "lastname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andLastnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("lastname in ", value, "lastname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andLastnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("lastname not in ", value, "lastname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andLastnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("lastname between ", value1, value2, "lastname");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andLastnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("lastname not between ", value1, value2, "lastname");
            return (BBSThreadNodeViewCriteria) this;
        }
        
        public BBSThreadNodeViewCriteria andCreationdateIsNull() {
            addCriterion("creationdate is null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andCreationdateIsNotNull() {
            addCriterion("creationdate is not null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andCreationdateEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("creationdate =", value, "creationdate");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andCreationdateNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("creationdate <>", value, "creationdate");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andCreationdateGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("creationdate >", value, "creationdate");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andCreationdateGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("creationdate >=", value, "creationdate");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andCreationdateLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("creationdate <", value, "creationdate");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andCreationdateLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("creationdate <=", value, "creationdate");
            return (BBSThreadNodeViewCriteria) this;
        }

        
        public BBSThreadNodeViewCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (BBSThreadNodeViewCriteria) this;
        }
        
        public BBSThreadNodeViewCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (BBSThreadNodeViewCriteria) this;
        }
        public BBSThreadNodeViewCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (BBSThreadNodeViewCriteria) this;
        }

    }
    
}

