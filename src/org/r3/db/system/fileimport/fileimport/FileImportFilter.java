//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.fileimport.fileimport;

import java.util.ArrayList;
import java.util.List;

public class FileImportFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public FileImportFilter() 
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

    public FileImportCriteria or() 
    {
        FileImportCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public FileImportCriteria createCriteria() 
    {
        FileImportCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected FileImportCriteria createCriteriaInternal() 
    {
        FileImportCriteria criteria = new FileImportCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class FileImportCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public FileImportCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (FileImportCriteria) this;
        }
        
        public FileImportCriteria andImportidIsNull() {
            addCriterion("importid is null");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportidIsNotNull() {
            addCriterion("importid is not null");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("importid =", value, "importid");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("importid <>", value, "importid");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("importid >", value, "importid");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("importid >=", value, "importid");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("importid <", value, "importid");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("importid <=", value, "importid");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportidLike(java.lang.String value) {
            if (value != null)
              addCriterion("importid like ", value, "importid");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("importid not like ", value, "importid");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("importid in ", value, "importid");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("importid not in ", value, "importid");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("importid between ", value1, value2, "importid");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("importid not between ", value1, value2, "importid");
            return (FileImportCriteria) this;
        }
        
        public FileImportCriteria andImportnameIsNull() {
            addCriterion("importname is null");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportnameIsNotNull() {
            addCriterion("importname is not null");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("importname =", value, "importname");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("importname <>", value, "importname");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("importname >", value, "importname");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("importname >=", value, "importname");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("importname <", value, "importname");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("importname <=", value, "importname");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("importname like ", value, "importname");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("importname not like ", value, "importname");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("importname in ", value, "importname");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("importname not in ", value, "importname");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("importname between ", value1, value2, "importname");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("importname not between ", value1, value2, "importname");
            return (FileImportCriteria) this;
        }
        
        public FileImportCriteria andImportcontextIsNull() {
            addCriterion("importcontext is null");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportcontextIsNotNull() {
            addCriterion("importcontext is not null");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportcontextEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("importcontext =", value, "importcontext");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportcontextNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("importcontext <>", value, "importcontext");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportcontextGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("importcontext >", value, "importcontext");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportcontextGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("importcontext >=", value, "importcontext");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportcontextLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("importcontext <", value, "importcontext");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportcontextLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("importcontext <=", value, "importcontext");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportcontextLike(java.lang.String value) {
            if (value != null)
              addCriterion("importcontext like ", value, "importcontext");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportcontextNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("importcontext not like ", value, "importcontext");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportcontextIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("importcontext in ", value, "importcontext");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportcontextNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("importcontext not in ", value, "importcontext");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportcontextBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("importcontext between ", value1, value2, "importcontext");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andImportcontextNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("importcontext not between ", value1, value2, "importcontext");
            return (FileImportCriteria) this;
        }
        
        public FileImportCriteria andMajortypeIsNull() {
            addCriterion("majortype is null");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMajortypeIsNotNull() {
            addCriterion("majortype is not null");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMajortypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("majortype =", value, "majortype");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMajortypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("majortype <>", value, "majortype");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMajortypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("majortype >", value, "majortype");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMajortypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("majortype >=", value, "majortype");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMajortypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("majortype <", value, "majortype");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMajortypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("majortype <=", value, "majortype");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMajortypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("majortype like ", value, "majortype");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMajortypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("majortype not like ", value, "majortype");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMajortypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("majortype in ", value, "majortype");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMajortypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("majortype not in ", value, "majortype");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMajortypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("majortype between ", value1, value2, "majortype");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMajortypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("majortype not between ", value1, value2, "majortype");
            return (FileImportCriteria) this;
        }
        
        public FileImportCriteria andMinortypeIsNull() {
            addCriterion("minortype is null");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMinortypeIsNotNull() {
            addCriterion("minortype is not null");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMinortypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("minortype =", value, "minortype");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMinortypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("minortype <>", value, "minortype");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMinortypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("minortype >", value, "minortype");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMinortypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("minortype >=", value, "minortype");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMinortypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("minortype <", value, "minortype");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMinortypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("minortype <=", value, "minortype");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMinortypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("minortype like ", value, "minortype");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMinortypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("minortype not like ", value, "minortype");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMinortypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("minortype in ", value, "minortype");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMinortypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("minortype not in ", value, "minortype");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMinortypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("minortype between ", value1, value2, "minortype");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andMinortypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("minortype not between ", value1, value2, "minortype");
            return (FileImportCriteria) this;
        }
        
        public FileImportCriteria andWithheaderIsNull() {
            addCriterion("withheader is null");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andWithheaderIsNotNull() {
            addCriterion("withheader is not null");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andWithheaderEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("withheader =", value, "withheader");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andWithheaderNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("withheader <>", value, "withheader");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andWithheaderGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("withheader >", value, "withheader");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andWithheaderGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("withheader >=", value, "withheader");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andWithheaderLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("withheader <", value, "withheader");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andWithheaderLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("withheader <=", value, "withheader");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andWithheaderLike(java.lang.String value) {
            if (value != null)
              addCriterion("withheader like ", value, "withheader");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andWithheaderNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("withheader not like ", value, "withheader");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andWithheaderIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("withheader in ", value, "withheader");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andWithheaderNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("withheader not in ", value, "withheader");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andWithheaderBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("withheader between ", value1, value2, "withheader");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andWithheaderNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("withheader not between ", value1, value2, "withheader");
            return (FileImportCriteria) this;
        }
        
        public FileImportCriteria andNumberofcolumnsIsNull() {
            addCriterion("numberofcolumns is null");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andNumberofcolumnsIsNotNull() {
            addCriterion("numberofcolumns is not null");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andNumberofcolumnsEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofcolumns =", value, "numberofcolumns");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andNumberofcolumnsNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofcolumns <>", value, "numberofcolumns");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andNumberofcolumnsGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofcolumns >", value, "numberofcolumns");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andNumberofcolumnsGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofcolumns >=", value, "numberofcolumns");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andNumberofcolumnsLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofcolumns <", value, "numberofcolumns");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andNumberofcolumnsLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofcolumns <=", value, "numberofcolumns");
            return (FileImportCriteria) this;
        }

        
        public FileImportCriteria andNumberofrecordsIsNull() {
            addCriterion("numberofrecords is null");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andNumberofrecordsIsNotNull() {
            addCriterion("numberofrecords is not null");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andNumberofrecordsEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofrecords =", value, "numberofrecords");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andNumberofrecordsNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofrecords <>", value, "numberofrecords");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andNumberofrecordsGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofrecords >", value, "numberofrecords");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andNumberofrecordsGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofrecords >=", value, "numberofrecords");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andNumberofrecordsLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofrecords <", value, "numberofrecords");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andNumberofrecordsLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofrecords <=", value, "numberofrecords");
            return (FileImportCriteria) this;
        }

        
        public FileImportCriteria andUploaddateIsNull() {
            addCriterion("uploaddate is null");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andUploaddateIsNotNull() {
            addCriterion("uploaddate is not null");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andUploaddateEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("uploaddate =", value, "uploaddate");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andUploaddateNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("uploaddate <>", value, "uploaddate");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andUploaddateGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("uploaddate >", value, "uploaddate");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andUploaddateGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("uploaddate >=", value, "uploaddate");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andUploaddateLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("uploaddate <", value, "uploaddate");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andUploaddateLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("uploaddate <=", value, "uploaddate");
            return (FileImportCriteria) this;
        }

        
        public FileImportCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (FileImportCriteria) this;
        }
        
        public FileImportCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (FileImportCriteria) this;
        }
        public FileImportCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (FileImportCriteria) this;
        }

    }
    
}

