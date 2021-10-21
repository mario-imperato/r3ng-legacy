//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.bbs.bbsthreadnode;

import java.util.ArrayList;
import java.util.List;

public class BBSThreadNodeFilter{
    protected String orderByClause;
    protected String  groupByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public BBSThreadNodeFilter() 
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

    public BBSThreadNodeCriteria or() 
    {
        BBSThreadNodeCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public BBSThreadNodeCriteria createCriteria() 
    {
        BBSThreadNodeCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected BBSThreadNodeCriteria createCriteriaInternal() 
    {
        BBSThreadNodeCriteria criteria = new BBSThreadNodeCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class BBSThreadNodeCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public BBSThreadNodeCriteria andThreadnodeidIsNull() {
            addCriterion("threadnodeid is null");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadnodeidIsNotNull() {
            addCriterion("threadnodeid is not null");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadnodeidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadnodeid =", value, "threadnodeid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadnodeidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadnodeid <>", value, "threadnodeid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadnodeidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("threadnodeid >", value, "threadnodeid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadnodeidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadnodeid >=", value, "threadnodeid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadnodeidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("threadnodeid <", value, "threadnodeid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadnodeidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadnodeid <=", value, "threadnodeid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadnodeidLike(java.lang.String value) {
            if (value != null)
              addCriterion("threadnodeid like ", value, "threadnodeid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadnodeidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("threadnodeid not like ", value, "threadnodeid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadnodeidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("threadnodeid in ", value, "threadnodeid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadnodeidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("threadnodeid not in ", value, "threadnodeid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadnodeidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("threadnodeid between ", value1, value2, "threadnodeid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadnodeidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("threadnodeid not between ", value1, value2, "threadnodeid");
            return (BBSThreadNodeCriteria) this;
        }
        
        public BBSThreadNodeCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (BBSThreadNodeCriteria) this;
        }
        
        public BBSThreadNodeCriteria andThreadidIsNull() {
            addCriterion("threadid is null");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadidIsNotNull() {
            addCriterion("threadid is not null");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadid =", value, "threadid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadid <>", value, "threadid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("threadid >", value, "threadid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadid >=", value, "threadid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("threadid <", value, "threadid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("threadid <=", value, "threadid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadidLike(java.lang.String value) {
            if (value != null)
              addCriterion("threadid like ", value, "threadid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("threadid not like ", value, "threadid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("threadid in ", value, "threadid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("threadid not in ", value, "threadid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("threadid between ", value1, value2, "threadid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andThreadidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("threadid not between ", value1, value2, "threadid");
            return (BBSThreadNodeCriteria) this;
        }
        
        public BBSThreadNodeCriteria andNodetypeIsNull() {
            addCriterion("nodetype is null");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetypeIsNotNull() {
            addCriterion("nodetype is not null");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype =", value, "nodetype");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype <>", value, "nodetype");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype >", value, "nodetype");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype >=", value, "nodetype");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype <", value, "nodetype");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype <=", value, "nodetype");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype like ", value, "nodetype");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype not like ", value, "nodetype");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("nodetype in ", value, "nodetype");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("nodetype not in ", value, "nodetype");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodetype between ", value1, value2, "nodetype");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodetype not between ", value1, value2, "nodetype");
            return (BBSThreadNodeCriteria) this;
        }
        
        public BBSThreadNodeCriteria andNodetitleIsNull() {
            addCriterion("nodetitle is null");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetitleIsNotNull() {
            addCriterion("nodetitle is not null");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetitleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetitle =", value, "nodetitle");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetitleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetitle <>", value, "nodetitle");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetitleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodetitle >", value, "nodetitle");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetitleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetitle >=", value, "nodetitle");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetitleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodetitle <", value, "nodetitle");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetitleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetitle <=", value, "nodetitle");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetitleLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodetitle like ", value, "nodetitle");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetitleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodetitle not like ", value, "nodetitle");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetitleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("nodetitle in ", value, "nodetitle");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetitleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("nodetitle not in ", value, "nodetitle");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetitleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodetitle between ", value1, value2, "nodetitle");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetitleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodetitle not between ", value1, value2, "nodetitle");
            return (BBSThreadNodeCriteria) this;
        }
        
        public BBSThreadNodeCriteria andNodetextIsNull() {
            addCriterion("nodetext is null");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetextIsNotNull() {
            addCriterion("nodetext is not null");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetextEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetext =", value, "nodetext");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetextNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetext <>", value, "nodetext");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetextGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodetext >", value, "nodetext");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetextGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetext >=", value, "nodetext");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetextLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodetext <", value, "nodetext");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetextLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetext <=", value, "nodetext");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetextLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodetext like ", value, "nodetext");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetextNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodetext not like ", value, "nodetext");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetextIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("nodetext in ", value, "nodetext");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetextNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("nodetext not in ", value, "nodetext");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetextBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodetext between ", value1, value2, "nodetext");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodetextNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodetext not between ", value1, value2, "nodetext");
            return (BBSThreadNodeCriteria) this;
        }
        
        public BBSThreadNodeCriteria andNodeparentidIsNull() {
            addCriterion("nodeparentid is null");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodeparentidIsNotNull() {
            addCriterion("nodeparentid is not null");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodeparentidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodeparentid =", value, "nodeparentid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodeparentidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodeparentid <>", value, "nodeparentid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodeparentidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodeparentid >", value, "nodeparentid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodeparentidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodeparentid >=", value, "nodeparentid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodeparentidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodeparentid <", value, "nodeparentid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodeparentidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodeparentid <=", value, "nodeparentid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodeparentidLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodeparentid like ", value, "nodeparentid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodeparentidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodeparentid not like ", value, "nodeparentid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodeparentidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("nodeparentid in ", value, "nodeparentid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodeparentidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("nodeparentid not in ", value, "nodeparentid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodeparentidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodeparentid between ", value1, value2, "nodeparentid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodeparentidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodeparentid not between ", value1, value2, "nodeparentid");
            return (BBSThreadNodeCriteria) this;
        }
        
        public BBSThreadNodeCriteria andNodepathIsNull() {
            addCriterion("nodepath is null");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodepathIsNotNull() {
            addCriterion("nodepath is not null");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodepathEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodepath =", value, "nodepath");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodepathNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodepath <>", value, "nodepath");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodepathGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodepath >", value, "nodepath");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodepathGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodepath >=", value, "nodepath");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodepathLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodepath <", value, "nodepath");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodepathLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodepath <=", value, "nodepath");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodepathLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodepath like ", value, "nodepath");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodepathNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodepath not like ", value, "nodepath");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodepathIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("nodepath in ", value, "nodepath");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodepathNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("nodepath not in ", value, "nodepath");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodepathBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodepath between ", value1, value2, "nodepath");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andNodepathNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodepath not between ", value1, value2, "nodepath");
            return (BBSThreadNodeCriteria) this;
        }
        
        public BBSThreadNodeCriteria andUseridIsNull() {
            addCriterion("userid is null");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andUseridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid =", value, "userid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andUseridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <>", value, "userid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andUseridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid >", value, "userid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andUseridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid >=", value, "userid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andUseridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid <", value, "userid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andUseridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <=", value, "userid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andUseridLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid like ", value, "userid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andUseridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid not like ", value, "userid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andUseridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("userid in ", value, "userid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andUseridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("userid not in ", value, "userid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andUseridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid between ", value1, value2, "userid");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andUseridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid not between ", value1, value2, "userid");
            return (BBSThreadNodeCriteria) this;
        }
        
        public BBSThreadNodeCriteria andCreationdateIsNull() {
            addCriterion("creationdate is null");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andCreationdateIsNotNull() {
            addCriterion("creationdate is not null");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andCreationdateEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("creationdate =", value, "creationdate");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andCreationdateNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("creationdate <>", value, "creationdate");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andCreationdateGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("creationdate >", value, "creationdate");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andCreationdateGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("creationdate >=", value, "creationdate");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andCreationdateLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("creationdate <", value, "creationdate");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andCreationdateLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("creationdate <=", value, "creationdate");
            return (BBSThreadNodeCriteria) this;
        }

        
        public BBSThreadNodeCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (BBSThreadNodeCriteria) this;
        }
        
        public BBSThreadNodeCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (BBSThreadNodeCriteria) this;
        }
        public BBSThreadNodeCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (BBSThreadNodeCriteria) this;
        }

    }
    
}

