//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.siteportletcfg;

import java.util.ArrayList;
import java.util.List;

public class SitePortletConfigFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public SitePortletConfigFilter() 
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

    public SitePortletConfigCriteria or() 
    {
        SitePortletConfigCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public SitePortletConfigCriteria createCriteria() 
    {
        SitePortletConfigCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected SitePortletConfigCriteria createCriteriaInternal() 
    {
        SitePortletConfigCriteria criteria = new SitePortletConfigCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class SitePortletConfigCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public SitePortletConfigCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (SitePortletConfigCriteria) this;
        }
        
        public SitePortletConfigCriteria andPageidIsNull() {
            addCriterion("pageid is null");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPageidIsNotNull() {
            addCriterion("pageid is not null");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPageidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid =", value, "pageid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPageidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid <>", value, "pageid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPageidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("pageid >", value, "pageid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPageidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid >=", value, "pageid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPageidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("pageid <", value, "pageid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPageidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("pageid <=", value, "pageid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPageidLike(java.lang.String value) {
            if (value != null)
              addCriterion("pageid like ", value, "pageid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPageidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("pageid not like ", value, "pageid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPageidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("pageid in ", value, "pageid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPageidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("pageid not in ", value, "pageid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPageidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pageid between ", value1, value2, "pageid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPageidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("pageid not between ", value1, value2, "pageid");
            return (SitePortletConfigCriteria) this;
        }
        
        public SitePortletConfigCriteria andPositionidIsNull() {
            addCriterion("positionid is null");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPositionidIsNotNull() {
            addCriterion("positionid is not null");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPositionidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("positionid =", value, "positionid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPositionidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("positionid <>", value, "positionid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPositionidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("positionid >", value, "positionid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPositionidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("positionid >=", value, "positionid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPositionidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("positionid <", value, "positionid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPositionidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("positionid <=", value, "positionid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPositionidLike(java.lang.String value) {
            if (value != null)
              addCriterion("positionid like ", value, "positionid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPositionidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("positionid not like ", value, "positionid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPositionidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("positionid in ", value, "positionid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPositionidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("positionid not in ", value, "positionid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPositionidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("positionid between ", value1, value2, "positionid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andPositionidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("positionid not between ", value1, value2, "positionid");
            return (SitePortletConfigCriteria) this;
        }
        
        public SitePortletConfigCriteria andJsclassnameIsNull() {
            addCriterion("jsclassname is null");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andJsclassnameIsNotNull() {
            addCriterion("jsclassname is not null");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andJsclassnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("jsclassname =", value, "jsclassname");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andJsclassnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("jsclassname <>", value, "jsclassname");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andJsclassnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("jsclassname >", value, "jsclassname");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andJsclassnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("jsclassname >=", value, "jsclassname");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andJsclassnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("jsclassname <", value, "jsclassname");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andJsclassnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("jsclassname <=", value, "jsclassname");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andJsclassnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("jsclassname like ", value, "jsclassname");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andJsclassnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("jsclassname not like ", value, "jsclassname");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andJsclassnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("jsclassname in ", value, "jsclassname");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andJsclassnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("jsclassname not in ", value, "jsclassname");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andJsclassnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("jsclassname between ", value1, value2, "jsclassname");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andJsclassnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("jsclassname not between ", value1, value2, "jsclassname");
            return (SitePortletConfigCriteria) this;
        }
        
        public SitePortletConfigCriteria andCssclassnameIsNull() {
            addCriterion("cssclassname is null");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andCssclassnameIsNotNull() {
            addCriterion("cssclassname is not null");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andCssclassnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cssclassname =", value, "cssclassname");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andCssclassnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cssclassname <>", value, "cssclassname");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andCssclassnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("cssclassname >", value, "cssclassname");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andCssclassnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cssclassname >=", value, "cssclassname");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andCssclassnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("cssclassname <", value, "cssclassname");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andCssclassnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cssclassname <=", value, "cssclassname");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andCssclassnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("cssclassname like ", value, "cssclassname");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andCssclassnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("cssclassname not like ", value, "cssclassname");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andCssclassnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("cssclassname in ", value, "cssclassname");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andCssclassnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("cssclassname not in ", value, "cssclassname");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andCssclassnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cssclassname between ", value1, value2, "cssclassname");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andCssclassnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cssclassname not between ", value1, value2, "cssclassname");
            return (SitePortletConfigCriteria) this;
        }
        
        public SitePortletConfigCriteria andDatacardidIsNull() {
            addCriterion("datacardid is null");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDatacardidIsNotNull() {
            addCriterion("datacardid is not null");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDatacardidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("datacardid =", value, "datacardid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDatacardidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("datacardid <>", value, "datacardid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDatacardidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("datacardid >", value, "datacardid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDatacardidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("datacardid >=", value, "datacardid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDatacardidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("datacardid <", value, "datacardid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDatacardidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("datacardid <=", value, "datacardid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDatacardidLike(java.lang.String value) {
            if (value != null)
              addCriterion("datacardid like ", value, "datacardid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDatacardidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("datacardid not like ", value, "datacardid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDatacardidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("datacardid in ", value, "datacardid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDatacardidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("datacardid not in ", value, "datacardid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDatacardidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("datacardid between ", value1, value2, "datacardid");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDatacardidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("datacardid not between ", value1, value2, "datacardid");
            return (SitePortletConfigCriteria) this;
        }
        
        public SitePortletConfigCriteria andDataoptionsIsNull() {
            addCriterion("dataoptions is null");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataoptionsIsNotNull() {
            addCriterion("dataoptions is not null");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataoptionsEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("dataoptions =", value, "dataoptions");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataoptionsNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("dataoptions <>", value, "dataoptions");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataoptionsGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("dataoptions >", value, "dataoptions");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataoptionsGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("dataoptions >=", value, "dataoptions");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataoptionsLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("dataoptions <", value, "dataoptions");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataoptionsLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("dataoptions <=", value, "dataoptions");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataoptionsLike(java.lang.String value) {
            if (value != null)
              addCriterion("dataoptions like ", value, "dataoptions");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataoptionsNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("dataoptions not like ", value, "dataoptions");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataoptionsIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("dataoptions in ", value, "dataoptions");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataoptionsNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("dataoptions not in ", value, "dataoptions");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataoptionsBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("dataoptions between ", value1, value2, "dataoptions");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataoptionsNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("dataoptions not between ", value1, value2, "dataoptions");
            return (SitePortletConfigCriteria) this;
        }
        
        public SitePortletConfigCriteria andDataonuserstatusIsNull() {
            addCriterion("dataonuserstatus is null");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataonuserstatusIsNotNull() {
            addCriterion("dataonuserstatus is not null");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataonuserstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("dataonuserstatus =", value, "dataonuserstatus");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataonuserstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("dataonuserstatus <>", value, "dataonuserstatus");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataonuserstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("dataonuserstatus >", value, "dataonuserstatus");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataonuserstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("dataonuserstatus >=", value, "dataonuserstatus");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataonuserstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("dataonuserstatus <", value, "dataonuserstatus");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataonuserstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("dataonuserstatus <=", value, "dataonuserstatus");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataonuserstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("dataonuserstatus like ", value, "dataonuserstatus");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataonuserstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("dataonuserstatus not like ", value, "dataonuserstatus");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataonuserstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("dataonuserstatus in ", value, "dataonuserstatus");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataonuserstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("dataonuserstatus not in ", value, "dataonuserstatus");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataonuserstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("dataonuserstatus between ", value1, value2, "dataonuserstatus");
            return (SitePortletConfigCriteria) this;
        }
        public SitePortletConfigCriteria andDataonuserstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("dataonuserstatus not between ", value1, value2, "dataonuserstatus");
            return (SitePortletConfigCriteria) this;
        }
    }
    
}

