//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.wbs.wbsnode;

import java.util.ArrayList;
import java.util.List;

public class WBSNodeFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public WBSNodeFilter() 
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

    public WBSNodeCriteria or() 
    {
        WBSNodeCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public WBSNodeCriteria createCriteria() 
    {
        WBSNodeCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected WBSNodeCriteria createCriteriaInternal() 
    {
        WBSNodeCriteria criteria = new WBSNodeCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class WBSNodeCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public WBSNodeCriteria andWbsnodeidIsNull() {
            addCriterion("wbsnodeid is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsnodeidIsNotNull() {
            addCriterion("wbsnodeid is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsnodeidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid =", value, "wbsnodeid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsnodeidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid <>", value, "wbsnodeid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsnodeidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid >", value, "wbsnodeid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsnodeidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid >=", value, "wbsnodeid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsnodeidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid <", value, "wbsnodeid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsnodeidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid <=", value, "wbsnodeid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsnodeidLike(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid like ", value, "wbsnodeid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsnodeidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("wbsnodeid not like ", value, "wbsnodeid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsnodeidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("wbsnodeid in ", value, "wbsnodeid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsnodeidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("wbsnodeid not in ", value, "wbsnodeid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsnodeidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("wbsnodeid between ", value1, value2, "wbsnodeid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsnodeidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("wbsnodeid not between ", value1, value2, "wbsnodeid");
            return (WBSNodeCriteria) this;
        }
        
        public WBSNodeCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (WBSNodeCriteria) this;
        }
        
        public WBSNodeCriteria andWbsidIsNull() {
            addCriterion("wbsid is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsidIsNotNull() {
            addCriterion("wbsid is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid =", value, "wbsid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid <>", value, "wbsid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid >", value, "wbsid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid >=", value, "wbsid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid <", value, "wbsid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid <=", value, "wbsid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsidLike(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid like ", value, "wbsid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("wbsid not like ", value, "wbsid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("wbsid in ", value, "wbsid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("wbsid not in ", value, "wbsid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("wbsid between ", value1, value2, "wbsid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andWbsidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("wbsid not between ", value1, value2, "wbsid");
            return (WBSNodeCriteria) this;
        }
        
        public WBSNodeCriteria andNodetypeIsNull() {
            addCriterion("nodetype is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetypeIsNotNull() {
            addCriterion("nodetype is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype =", value, "nodetype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype <>", value, "nodetype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype >", value, "nodetype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype >=", value, "nodetype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype <", value, "nodetype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype <=", value, "nodetype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype like ", value, "nodetype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodetype not like ", value, "nodetype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("nodetype in ", value, "nodetype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("nodetype not in ", value, "nodetype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodetype between ", value1, value2, "nodetype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodetype not between ", value1, value2, "nodetype");
            return (WBSNodeCriteria) this;
        }
        
        public WBSNodeCriteria andNodeorderIsNull() {
            addCriterion("nodeorder is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodeorderIsNotNull() {
            addCriterion("nodeorder is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodeorderEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("nodeorder =", value, "nodeorder");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodeorderNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("nodeorder <>", value, "nodeorder");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodeorderGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("nodeorder >", value, "nodeorder");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodeorderGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("nodeorder >=", value, "nodeorder");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodeorderLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("nodeorder <", value, "nodeorder");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodeorderLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("nodeorder <=", value, "nodeorder");
            return (WBSNodeCriteria) this;
        }

        
        public WBSNodeCriteria andNodesectIsNull() {
            addCriterion("nodesect is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesectIsNotNull() {
            addCriterion("nodesect is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesectEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodesect =", value, "nodesect");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesectNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodesect <>", value, "nodesect");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesectGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodesect >", value, "nodesect");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesectGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodesect >=", value, "nodesect");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesectLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodesect <", value, "nodesect");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesectLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodesect <=", value, "nodesect");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesectLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodesect like ", value, "nodesect");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesectNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodesect not like ", value, "nodesect");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesectIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("nodesect in ", value, "nodesect");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesectNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("nodesect not in ", value, "nodesect");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesectBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodesect between ", value1, value2, "nodesect");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesectNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodesect not between ", value1, value2, "nodesect");
            return (WBSNodeCriteria) this;
        }
        
        public WBSNodeCriteria andNodenameIsNull() {
            addCriterion("nodename is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodenameIsNotNull() {
            addCriterion("nodename is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodenameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodename =", value, "nodename");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodenameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodename <>", value, "nodename");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodenameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodename >", value, "nodename");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodenameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodename >=", value, "nodename");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodenameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodename <", value, "nodename");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodenameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodename <=", value, "nodename");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodenameLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodename like ", value, "nodename");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodenameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodename not like ", value, "nodename");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodenameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("nodename in ", value, "nodename");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodenameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("nodename not in ", value, "nodename");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodenameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodename between ", value1, value2, "nodename");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodenameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodename not between ", value1, value2, "nodename");
            return (WBSNodeCriteria) this;
        }
        
        public WBSNodeCriteria andNodesummaryIsNull() {
            addCriterion("nodesummary is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesummaryIsNotNull() {
            addCriterion("nodesummary is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesummaryEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodesummary =", value, "nodesummary");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesummaryNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodesummary <>", value, "nodesummary");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesummaryGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodesummary >", value, "nodesummary");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesummaryGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodesummary >=", value, "nodesummary");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesummaryLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodesummary <", value, "nodesummary");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesummaryLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodesummary <=", value, "nodesummary");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesummaryLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodesummary like ", value, "nodesummary");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesummaryNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodesummary not like ", value, "nodesummary");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesummaryIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("nodesummary in ", value, "nodesummary");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesummaryNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("nodesummary not in ", value, "nodesummary");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesummaryBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodesummary between ", value1, value2, "nodesummary");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodesummaryNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodesummary not between ", value1, value2, "nodesummary");
            return (WBSNodeCriteria) this;
        }
        
        public WBSNodeCriteria andNodetextIsNull() {
            addCriterion("nodetext is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetextIsNotNull() {
            addCriterion("nodetext is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetextEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetext =", value, "nodetext");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetextNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetext <>", value, "nodetext");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetextGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodetext >", value, "nodetext");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetextGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetext >=", value, "nodetext");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetextLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodetext <", value, "nodetext");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetextLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodetext <=", value, "nodetext");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetextLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodetext like ", value, "nodetext");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetextNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodetext not like ", value, "nodetext");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetextIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("nodetext in ", value, "nodetext");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetextNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("nodetext not in ", value, "nodetext");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetextBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodetext between ", value1, value2, "nodetext");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodetextNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodetext not between ", value1, value2, "nodetext");
            return (WBSNodeCriteria) this;
        }
        
        public WBSNodeCriteria andNodeparentidIsNull() {
            addCriterion("nodeparentid is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodeparentidIsNotNull() {
            addCriterion("nodeparentid is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodeparentidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodeparentid =", value, "nodeparentid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodeparentidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodeparentid <>", value, "nodeparentid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodeparentidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodeparentid >", value, "nodeparentid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodeparentidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodeparentid >=", value, "nodeparentid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodeparentidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodeparentid <", value, "nodeparentid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodeparentidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodeparentid <=", value, "nodeparentid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodeparentidLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodeparentid like ", value, "nodeparentid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodeparentidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodeparentid not like ", value, "nodeparentid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodeparentidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("nodeparentid in ", value, "nodeparentid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodeparentidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("nodeparentid not in ", value, "nodeparentid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodeparentidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodeparentid between ", value1, value2, "nodeparentid");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodeparentidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodeparentid not between ", value1, value2, "nodeparentid");
            return (WBSNodeCriteria) this;
        }
        
        public WBSNodeCriteria andNodepathIsNull() {
            addCriterion("nodepath is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodepathIsNotNull() {
            addCriterion("nodepath is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodepathEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodepath =", value, "nodepath");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodepathNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodepath <>", value, "nodepath");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodepathGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodepath >", value, "nodepath");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodepathGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodepath >=", value, "nodepath");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodepathLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("nodepath <", value, "nodepath");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodepathLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nodepath <=", value, "nodepath");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodepathLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodepath like ", value, "nodepath");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodepathNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("nodepath not like ", value, "nodepath");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodepathIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("nodepath in ", value, "nodepath");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodepathNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("nodepath not in ", value, "nodepath");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodepathBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodepath between ", value1, value2, "nodepath");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andNodepathNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nodepath not between ", value1, value2, "nodepath");
            return (WBSNodeCriteria) this;
        }
        
        public WBSNodeCriteria andAssignedtoIsNull() {
            addCriterion("assignedto is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andAssignedtoIsNotNull() {
            addCriterion("assignedto is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andAssignedtoEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("assignedto =", value, "assignedto");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andAssignedtoNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("assignedto <>", value, "assignedto");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andAssignedtoGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("assignedto >", value, "assignedto");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andAssignedtoGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("assignedto >=", value, "assignedto");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andAssignedtoLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("assignedto <", value, "assignedto");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andAssignedtoLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("assignedto <=", value, "assignedto");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andAssignedtoLike(java.lang.String value) {
            if (value != null)
              addCriterion("assignedto like ", value, "assignedto");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andAssignedtoNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("assignedto not like ", value, "assignedto");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andAssignedtoIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("assignedto in ", value, "assignedto");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andAssignedtoNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("assignedto not in ", value, "assignedto");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andAssignedtoBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("assignedto between ", value1, value2, "assignedto");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andAssignedtoNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("assignedto not between ", value1, value2, "assignedto");
            return (WBSNodeCriteria) this;
        }
        
        public WBSNodeCriteria andDurationIsNull() {
            addCriterion("duration is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andDurationEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("duration =", value, "duration");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andDurationNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("duration <>", value, "duration");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andDurationGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("duration >", value, "duration");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andDurationGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("duration >=", value, "duration");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andDurationLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("duration <", value, "duration");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andDurationLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("duration <=", value, "duration");
            return (WBSNodeCriteria) this;
        }

        
        public WBSNodeCriteria andStartdateIsNull() {
            addCriterion("startdate is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andStartdateIsNotNull() {
            addCriterion("startdate is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andStartdateEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("startdate =", value, "startdate");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andStartdateNotEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("startdate <>", value, "startdate");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andStartdateGreaterThan(java.sql.Date value) {
            if (value != null)
              addCriterion("startdate >", value, "startdate");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andStartdateGreaterThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("startdate >=", value, "startdate");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andStartdateLessThan(java.sql.Date value) {
            if (value != null)
              addCriterion("startdate <", value, "startdate");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andStartdateLessThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("startdate <=", value, "startdate");
            return (WBSNodeCriteria) this;
        }

        
        public WBSNodeCriteria andEnddateIsNull() {
            addCriterion("enddate is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEnddateIsNotNull() {
            addCriterion("enddate is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEnddateEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("enddate =", value, "enddate");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEnddateNotEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("enddate <>", value, "enddate");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEnddateGreaterThan(java.sql.Date value) {
            if (value != null)
              addCriterion("enddate >", value, "enddate");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEnddateGreaterThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("enddate >=", value, "enddate");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEnddateLessThan(java.sql.Date value) {
            if (value != null)
              addCriterion("enddate <", value, "enddate");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEnddateLessThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("enddate <=", value, "enddate");
            return (WBSNodeCriteria) this;
        }

        
        public WBSNodeCriteria andCompletiontypeIsNull() {
            addCriterion("completiontype is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiontypeIsNotNull() {
            addCriterion("completiontype is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiontypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("completiontype =", value, "completiontype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiontypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("completiontype <>", value, "completiontype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiontypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("completiontype >", value, "completiontype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiontypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("completiontype >=", value, "completiontype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiontypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("completiontype <", value, "completiontype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiontypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("completiontype <=", value, "completiontype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiontypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("completiontype like ", value, "completiontype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiontypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("completiontype not like ", value, "completiontype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiontypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("completiontype in ", value, "completiontype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiontypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("completiontype not in ", value, "completiontype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiontypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("completiontype between ", value1, value2, "completiontype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiontypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("completiontype not between ", value1, value2, "completiontype");
            return (WBSNodeCriteria) this;
        }
        
        public WBSNodeCriteria andCompletionstatusIsNull() {
            addCriterion("completionstatus is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionstatusIsNotNull() {
            addCriterion("completionstatus is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("completionstatus =", value, "completionstatus");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("completionstatus <>", value, "completionstatus");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("completionstatus >", value, "completionstatus");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("completionstatus >=", value, "completionstatus");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("completionstatus <", value, "completionstatus");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("completionstatus <=", value, "completionstatus");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("completionstatus like ", value, "completionstatus");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("completionstatus not like ", value, "completionstatus");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("completionstatus in ", value, "completionstatus");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("completionstatus not in ", value, "completionstatus");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("completionstatus between ", value1, value2, "completionstatus");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("completionstatus not between ", value1, value2, "completionstatus");
            return (WBSNodeCriteria) this;
        }
        
        public WBSNodeCriteria andCompletiondescrIsNull() {
            addCriterion("completiondescr is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiondescrIsNotNull() {
            addCriterion("completiondescr is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiondescrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("completiondescr =", value, "completiondescr");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiondescrNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("completiondescr <>", value, "completiondescr");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiondescrGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("completiondescr >", value, "completiondescr");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiondescrGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("completiondescr >=", value, "completiondescr");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiondescrLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("completiondescr <", value, "completiondescr");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiondescrLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("completiondescr <=", value, "completiondescr");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiondescrLike(java.lang.String value) {
            if (value != null)
              addCriterion("completiondescr like ", value, "completiondescr");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiondescrNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("completiondescr not like ", value, "completiondescr");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiondescrIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("completiondescr in ", value, "completiondescr");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiondescrNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("completiondescr not in ", value, "completiondescr");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiondescrBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("completiondescr between ", value1, value2, "completiondescr");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiondescrNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("completiondescr not between ", value1, value2, "completiondescr");
            return (WBSNodeCriteria) this;
        }
        
        public WBSNodeCriteria andCompletionIsNull() {
            addCriterion("completion is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionIsNotNull() {
            addCriterion("completion is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("completion =", value, "completion");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionNotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("completion <>", value, "completion");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionGreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("completion >", value, "completion");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionGreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("completion >=", value, "completion");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionLessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("completion <", value, "completion");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionLessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("completion <=", value, "completion");
            return (WBSNodeCriteria) this;
        }

        
        public WBSNodeCriteria andCompletionfromIsNull() {
            addCriterion("completionfrom is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionfromIsNotNull() {
            addCriterion("completionfrom is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionfromEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("completionfrom =", value, "completionfrom");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionfromNotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("completionfrom <>", value, "completionfrom");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionfromGreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("completionfrom >", value, "completionfrom");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionfromGreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("completionfrom >=", value, "completionfrom");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionfromLessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("completionfrom <", value, "completionfrom");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletionfromLessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("completionfrom <=", value, "completionfrom");
            return (WBSNodeCriteria) this;
        }

        
        public WBSNodeCriteria andCompletiontoIsNull() {
            addCriterion("completionto is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiontoIsNotNull() {
            addCriterion("completionto is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiontoEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("completionto =", value, "completionto");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiontoNotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("completionto <>", value, "completionto");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiontoGreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("completionto >", value, "completionto");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiontoGreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("completionto >=", value, "completionto");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiontoLessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("completionto <", value, "completionto");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiontoLessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("completionto <=", value, "completionto");
            return (WBSNodeCriteria) this;
        }

        
        public WBSNodeCriteria andCompletiondateIsNull() {
            addCriterion("completiondate is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiondateIsNotNull() {
            addCriterion("completiondate is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiondateEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("completiondate =", value, "completiondate");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiondateNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("completiondate <>", value, "completiondate");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiondateGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("completiondate >", value, "completiondate");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiondateGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("completiondate >=", value, "completiondate");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiondateLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("completiondate <", value, "completiondate");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletiondateLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("completiondate <=", value, "completiondate");
            return (WBSNodeCriteria) this;
        }

        
        public WBSNodeCriteria andCompletioneffortIsNull() {
            addCriterion("completioneffort is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletioneffortIsNotNull() {
            addCriterion("completioneffort is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletioneffortEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("completioneffort =", value, "completioneffort");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletioneffortNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("completioneffort <>", value, "completioneffort");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletioneffortGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("completioneffort >", value, "completioneffort");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletioneffortGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("completioneffort >=", value, "completioneffort");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletioneffortLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("completioneffort <", value, "completioneffort");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletioneffortLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("completioneffort <=", value, "completioneffort");
            return (WBSNodeCriteria) this;
        }

        
        public WBSNodeCriteria andCompletioneffunitIsNull() {
            addCriterion("completioneffunit is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletioneffunitIsNotNull() {
            addCriterion("completioneffunit is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletioneffunitEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("completioneffunit =", value, "completioneffunit");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletioneffunitNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("completioneffunit <>", value, "completioneffunit");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletioneffunitGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("completioneffunit >", value, "completioneffunit");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletioneffunitGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("completioneffunit >=", value, "completioneffunit");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletioneffunitLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("completioneffunit <", value, "completioneffunit");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletioneffunitLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("completioneffunit <=", value, "completioneffunit");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletioneffunitLike(java.lang.String value) {
            if (value != null)
              addCriterion("completioneffunit like ", value, "completioneffunit");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletioneffunitNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("completioneffunit not like ", value, "completioneffunit");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletioneffunitIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("completioneffunit in ", value, "completioneffunit");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletioneffunitNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("completioneffunit not in ", value, "completioneffunit");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletioneffunitBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("completioneffunit between ", value1, value2, "completioneffunit");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andCompletioneffunitNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("completioneffunit not between ", value1, value2, "completioneffunit");
            return (WBSNodeCriteria) this;
        }
        
        public WBSNodeCriteria andEconomicvalueIsNull() {
            addCriterion("economicvalue is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEconomicvalueIsNotNull() {
            addCriterion("economicvalue is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEconomicvalueEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("economicvalue =", value, "economicvalue");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEconomicvalueNotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("economicvalue <>", value, "economicvalue");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEconomicvalueGreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("economicvalue >", value, "economicvalue");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEconomicvalueGreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("economicvalue >=", value, "economicvalue");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEconomicvalueLessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("economicvalue <", value, "economicvalue");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEconomicvalueLessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("economicvalue <=", value, "economicvalue");
            return (WBSNodeCriteria) this;
        }

        
        public WBSNodeCriteria andEconomicvalue2IsNull() {
            addCriterion("economicvalue2 is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEconomicvalue2IsNotNull() {
            addCriterion("economicvalue2 is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEconomicvalue2EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("economicvalue2 =", value, "economicvalue2");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEconomicvalue2NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("economicvalue2 <>", value, "economicvalue2");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEconomicvalue2GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("economicvalue2 >", value, "economicvalue2");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEconomicvalue2GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("economicvalue2 >=", value, "economicvalue2");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEconomicvalue2LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("economicvalue2 <", value, "economicvalue2");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEconomicvalue2LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("economicvalue2 <=", value, "economicvalue2");
            return (WBSNodeCriteria) this;
        }

        
        public WBSNodeCriteria andEconomicvalue3IsNull() {
            addCriterion("economicvalue3 is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEconomicvalue3IsNotNull() {
            addCriterion("economicvalue3 is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEconomicvalue3EqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("economicvalue3 =", value, "economicvalue3");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEconomicvalue3NotEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("economicvalue3 <>", value, "economicvalue3");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEconomicvalue3GreaterThan(java.lang.Float value) {
            if (value != null)
              addCriterion("economicvalue3 >", value, "economicvalue3");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEconomicvalue3GreaterThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("economicvalue3 >=", value, "economicvalue3");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEconomicvalue3LessThan(java.lang.Float value) {
            if (value != null)
              addCriterion("economicvalue3 <", value, "economicvalue3");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andEconomicvalue3LessThanOrEqualTo(java.lang.Float value) {
            if (value != null)
              addCriterion("economicvalue3 <=", value, "economicvalue3");
            return (WBSNodeCriteria) this;
        }

        
        public WBSNodeCriteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRemarksEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("remarks =", value, "remarks");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRemarksNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("remarks <>", value, "remarks");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRemarksGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("remarks >", value, "remarks");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRemarksGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("remarks >=", value, "remarks");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRemarksLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("remarks <", value, "remarks");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRemarksLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("remarks <=", value, "remarks");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRemarksLike(java.lang.String value) {
            if (value != null)
              addCriterion("remarks like ", value, "remarks");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRemarksNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("remarks not like ", value, "remarks");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRemarksIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("remarks in ", value, "remarks");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRemarksNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("remarks not in ", value, "remarks");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRemarksBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("remarks between ", value1, value2, "remarks");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRemarksNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("remarks not between ", value1, value2, "remarks");
            return (WBSNodeCriteria) this;
        }
        
        public WBSNodeCriteria andStereotypeIsNull() {
            addCriterion("stereotype is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andStereotypeIsNotNull() {
            addCriterion("stereotype is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andStereotypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("stereotype =", value, "stereotype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andStereotypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("stereotype <>", value, "stereotype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andStereotypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("stereotype >", value, "stereotype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andStereotypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("stereotype >=", value, "stereotype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andStereotypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("stereotype <", value, "stereotype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andStereotypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("stereotype <=", value, "stereotype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andStereotypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("stereotype like ", value, "stereotype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andStereotypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("stereotype not like ", value, "stereotype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andStereotypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("stereotype in ", value, "stereotype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andStereotypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("stereotype not in ", value, "stereotype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andStereotypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("stereotype between ", value1, value2, "stereotype");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andStereotypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("stereotype not between ", value1, value2, "stereotype");
            return (WBSNodeCriteria) this;
        }
        
        public WBSNodeCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (WBSNodeCriteria) this;
        }
        
        public WBSNodeCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (WBSNodeCriteria) this;
        }
        public WBSNodeCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (WBSNodeCriteria) this;
        }

    }
    
}

