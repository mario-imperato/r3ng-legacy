//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.folder;

import java.util.ArrayList;
import java.util.List;

public class DMSFolderFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public DMSFolderFilter() 
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

    public DMSFolderCriteria or() 
    {
        DMSFolderCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public DMSFolderCriteria createCriteria() 
    {
        DMSFolderCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected DMSFolderCriteria createCriteriaInternal() 
    {
        DMSFolderCriteria criteria = new DMSFolderCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class DMSFolderCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public DMSFolderCriteria andFolderidIsNull() {
            addCriterion("folderid is null");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderidIsNotNull() {
            addCriterion("folderid is not null");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("folderid =", value, "folderid");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("folderid <>", value, "folderid");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("folderid >", value, "folderid");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("folderid >=", value, "folderid");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("folderid <", value, "folderid");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("folderid <=", value, "folderid");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderidLike(java.lang.String value) {
            if (value != null)
              addCriterion("folderid like ", value, "folderid");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("folderid not like ", value, "folderid");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("folderid in ", value, "folderid");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("folderid not in ", value, "folderid");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("folderid between ", value1, value2, "folderid");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("folderid not between ", value1, value2, "folderid");
            return (DMSFolderCriteria) this;
        }
        
        public DMSFolderCriteria andDeviceidIsNull() {
            addCriterion("deviceid is null");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andDeviceidIsNotNull() {
            addCriterion("deviceid is not null");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andDeviceidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("deviceid =", value, "deviceid");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andDeviceidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("deviceid <>", value, "deviceid");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andDeviceidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("deviceid >", value, "deviceid");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andDeviceidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("deviceid >=", value, "deviceid");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andDeviceidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("deviceid <", value, "deviceid");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andDeviceidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("deviceid <=", value, "deviceid");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andDeviceidLike(java.lang.String value) {
            if (value != null)
              addCriterion("deviceid like ", value, "deviceid");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andDeviceidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("deviceid not like ", value, "deviceid");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andDeviceidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("deviceid in ", value, "deviceid");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andDeviceidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("deviceid not in ", value, "deviceid");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andDeviceidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("deviceid between ", value1, value2, "deviceid");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andDeviceidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("deviceid not between ", value1, value2, "deviceid");
            return (DMSFolderCriteria) this;
        }
        
        public DMSFolderCriteria andFolderlogicalpathIsNull() {
            addCriterion("folderlogicalpath is null");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderlogicalpathIsNotNull() {
            addCriterion("folderlogicalpath is not null");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderlogicalpathEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("folderlogicalpath =", value, "folderlogicalpath");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderlogicalpathNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("folderlogicalpath <>", value, "folderlogicalpath");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderlogicalpathGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("folderlogicalpath >", value, "folderlogicalpath");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderlogicalpathGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("folderlogicalpath >=", value, "folderlogicalpath");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderlogicalpathLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("folderlogicalpath <", value, "folderlogicalpath");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderlogicalpathLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("folderlogicalpath <=", value, "folderlogicalpath");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderlogicalpathLike(java.lang.String value) {
            if (value != null)
              addCriterion("folderlogicalpath like ", value, "folderlogicalpath");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderlogicalpathNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("folderlogicalpath not like ", value, "folderlogicalpath");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderlogicalpathIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("folderlogicalpath in ", value, "folderlogicalpath");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderlogicalpathNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("folderlogicalpath not in ", value, "folderlogicalpath");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderlogicalpathBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("folderlogicalpath between ", value1, value2, "folderlogicalpath");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderlogicalpathNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("folderlogicalpath not between ", value1, value2, "folderlogicalpath");
            return (DMSFolderCriteria) this;
        }
        
        public DMSFolderCriteria andFolderphysicalpathIsNull() {
            addCriterion("folderphysicalpath is null");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderphysicalpathIsNotNull() {
            addCriterion("folderphysicalpath is not null");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderphysicalpathEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("folderphysicalpath =", value, "folderphysicalpath");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderphysicalpathNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("folderphysicalpath <>", value, "folderphysicalpath");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderphysicalpathGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("folderphysicalpath >", value, "folderphysicalpath");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderphysicalpathGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("folderphysicalpath >=", value, "folderphysicalpath");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderphysicalpathLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("folderphysicalpath <", value, "folderphysicalpath");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderphysicalpathLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("folderphysicalpath <=", value, "folderphysicalpath");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderphysicalpathLike(java.lang.String value) {
            if (value != null)
              addCriterion("folderphysicalpath like ", value, "folderphysicalpath");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderphysicalpathNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("folderphysicalpath not like ", value, "folderphysicalpath");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderphysicalpathIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("folderphysicalpath in ", value, "folderphysicalpath");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderphysicalpathNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("folderphysicalpath not in ", value, "folderphysicalpath");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderphysicalpathBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("folderphysicalpath between ", value1, value2, "folderphysicalpath");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderphysicalpathNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("folderphysicalpath not between ", value1, value2, "folderphysicalpath");
            return (DMSFolderCriteria) this;
        }
        
        public DMSFolderCriteria andFolderstatusIsNull() {
            addCriterion("folderstatus is null");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderstatusIsNotNull() {
            addCriterion("folderstatus is not null");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("folderstatus =", value, "folderstatus");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("folderstatus <>", value, "folderstatus");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("folderstatus >", value, "folderstatus");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("folderstatus >=", value, "folderstatus");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("folderstatus <", value, "folderstatus");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("folderstatus <=", value, "folderstatus");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("folderstatus like ", value, "folderstatus");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("folderstatus not like ", value, "folderstatus");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("folderstatus in ", value, "folderstatus");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("folderstatus not in ", value, "folderstatus");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("folderstatus between ", value1, value2, "folderstatus");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("folderstatus not between ", value1, value2, "folderstatus");
            return (DMSFolderCriteria) this;
        }
        
        public DMSFolderCriteria andFolderdepthIsNull() {
            addCriterion("folderdepth is null");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderdepthIsNotNull() {
            addCriterion("folderdepth is not null");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderdepthEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("folderdepth =", value, "folderdepth");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderdepthNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("folderdepth <>", value, "folderdepth");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderdepthGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("folderdepth >", value, "folderdepth");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderdepthGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("folderdepth >=", value, "folderdepth");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderdepthLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("folderdepth <", value, "folderdepth");
            return (DMSFolderCriteria) this;
        }
        public DMSFolderCriteria andFolderdepthLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("folderdepth <=", value, "folderdepth");
            return (DMSFolderCriteria) this;
        }

    }
    
}

