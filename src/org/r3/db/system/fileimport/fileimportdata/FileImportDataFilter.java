//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.fileimport.fileimportdata;

import java.util.ArrayList;
import java.util.List;

public class FileImportDataFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public FileImportDataFilter() 
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

    public FileImportDataCriteria or() 
    {
        FileImportDataCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public FileImportDataCriteria createCriteria() 
    {
        FileImportDataCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected FileImportDataCriteria createCriteriaInternal() 
    {
        FileImportDataCriteria criteria = new FileImportDataCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class FileImportDataCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public FileImportDataCriteria andImportdataidIsNull() {
            addCriterion("importdataid is null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andImportdataidIsNotNull() {
            addCriterion("importdataid is not null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andImportdataidEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("importdataid =", value, "importdataid");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andImportdataidNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("importdataid <>", value, "importdataid");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andImportdataidGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("importdataid >", value, "importdataid");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andImportdataidGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("importdataid >=", value, "importdataid");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andImportdataidLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("importdataid <", value, "importdataid");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andImportdataidLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("importdataid <=", value, "importdataid");
            return (FileImportDataCriteria) this;
        }

        
        public FileImportDataCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (FileImportDataCriteria) this;
        }
        
        public FileImportDataCriteria andImportidIsNull() {
            addCriterion("importid is null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andImportidIsNotNull() {
            addCriterion("importid is not null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andImportidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("importid =", value, "importid");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andImportidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("importid <>", value, "importid");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andImportidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("importid >", value, "importid");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andImportidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("importid >=", value, "importid");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andImportidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("importid <", value, "importid");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andImportidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("importid <=", value, "importid");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andImportidLike(java.lang.String value) {
            if (value != null)
              addCriterion("importid like ", value, "importid");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andImportidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("importid not like ", value, "importid");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andImportidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("importid in ", value, "importid");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andImportidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("importid not in ", value, "importid");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andImportidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("importid between ", value1, value2, "importid");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andImportidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("importid not between ", value1, value2, "importid");
            return (FileImportDataCriteria) this;
        }
        
        public FileImportDataCriteria andRecordtypeIsNull() {
            addCriterion("recordtype is null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecordtypeIsNotNull() {
            addCriterion("recordtype is not null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecordtypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recordtype =", value, "recordtype");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecordtypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recordtype <>", value, "recordtype");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecordtypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recordtype >", value, "recordtype");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecordtypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recordtype >=", value, "recordtype");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecordtypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recordtype <", value, "recordtype");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecordtypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recordtype <=", value, "recordtype");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecordtypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("recordtype like ", value, "recordtype");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecordtypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recordtype not like ", value, "recordtype");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecordtypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recordtype in ", value, "recordtype");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecordtypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recordtype not in ", value, "recordtype");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecordtypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recordtype between ", value1, value2, "recordtype");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecordtypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recordtype not between ", value1, value2, "recordtype");
            return (FileImportDataCriteria) this;
        }
        
        public FileImportDataCriteria andRecordnumberIsNull() {
            addCriterion("recordnumber is null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecordnumberIsNotNull() {
            addCriterion("recordnumber is not null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecordnumberEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("recordnumber =", value, "recordnumber");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecordnumberNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("recordnumber <>", value, "recordnumber");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecordnumberGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("recordnumber >", value, "recordnumber");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecordnumberGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("recordnumber >=", value, "recordnumber");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecordnumberLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("recordnumber <", value, "recordnumber");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecordnumberLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("recordnumber <=", value, "recordnumber");
            return (FileImportDataCriteria) this;
        }

        
        public FileImportDataCriteria andCol1IsNull() {
            addCriterion("col1 is null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol1IsNotNull() {
            addCriterion("col1 is not null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol1EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col1 =", value, "col1");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol1NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col1 <>", value, "col1");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol1GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("col1 >", value, "col1");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol1GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col1 >=", value, "col1");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol1LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("col1 <", value, "col1");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol1LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col1 <=", value, "col1");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol1Like(java.lang.String value) {
            if (value != null)
              addCriterion("col1 like ", value, "col1");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol1NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("col1 not like ", value, "col1");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol1In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("col1 in ", value, "col1");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol1NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("col1 not in ", value, "col1");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol1Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("col1 between ", value1, value2, "col1");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol1NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("col1 not between ", value1, value2, "col1");
            return (FileImportDataCriteria) this;
        }
        
        public FileImportDataCriteria andCol2IsNull() {
            addCriterion("col2 is null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol2IsNotNull() {
            addCriterion("col2 is not null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol2EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col2 =", value, "col2");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol2NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col2 <>", value, "col2");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol2GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("col2 >", value, "col2");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol2GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col2 >=", value, "col2");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol2LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("col2 <", value, "col2");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol2LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col2 <=", value, "col2");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol2Like(java.lang.String value) {
            if (value != null)
              addCriterion("col2 like ", value, "col2");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol2NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("col2 not like ", value, "col2");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol2In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("col2 in ", value, "col2");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol2NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("col2 not in ", value, "col2");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol2Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("col2 between ", value1, value2, "col2");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol2NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("col2 not between ", value1, value2, "col2");
            return (FileImportDataCriteria) this;
        }
        
        public FileImportDataCriteria andCol3IsNull() {
            addCriterion("col3 is null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol3IsNotNull() {
            addCriterion("col3 is not null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol3EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col3 =", value, "col3");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol3NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col3 <>", value, "col3");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol3GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("col3 >", value, "col3");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol3GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col3 >=", value, "col3");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol3LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("col3 <", value, "col3");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol3LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col3 <=", value, "col3");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol3Like(java.lang.String value) {
            if (value != null)
              addCriterion("col3 like ", value, "col3");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol3NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("col3 not like ", value, "col3");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol3In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("col3 in ", value, "col3");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol3NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("col3 not in ", value, "col3");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol3Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("col3 between ", value1, value2, "col3");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol3NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("col3 not between ", value1, value2, "col3");
            return (FileImportDataCriteria) this;
        }
        
        public FileImportDataCriteria andCol4IsNull() {
            addCriterion("col4 is null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol4IsNotNull() {
            addCriterion("col4 is not null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol4EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col4 =", value, "col4");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol4NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col4 <>", value, "col4");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol4GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("col4 >", value, "col4");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol4GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col4 >=", value, "col4");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol4LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("col4 <", value, "col4");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol4LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col4 <=", value, "col4");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol4Like(java.lang.String value) {
            if (value != null)
              addCriterion("col4 like ", value, "col4");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol4NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("col4 not like ", value, "col4");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol4In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("col4 in ", value, "col4");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol4NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("col4 not in ", value, "col4");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol4Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("col4 between ", value1, value2, "col4");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol4NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("col4 not between ", value1, value2, "col4");
            return (FileImportDataCriteria) this;
        }
        
        public FileImportDataCriteria andCol5IsNull() {
            addCriterion("col5 is null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol5IsNotNull() {
            addCriterion("col5 is not null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol5EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col5 =", value, "col5");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol5NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col5 <>", value, "col5");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol5GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("col5 >", value, "col5");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol5GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col5 >=", value, "col5");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol5LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("col5 <", value, "col5");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol5LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col5 <=", value, "col5");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol5Like(java.lang.String value) {
            if (value != null)
              addCriterion("col5 like ", value, "col5");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol5NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("col5 not like ", value, "col5");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol5In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("col5 in ", value, "col5");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol5NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("col5 not in ", value, "col5");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol5Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("col5 between ", value1, value2, "col5");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol5NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("col5 not between ", value1, value2, "col5");
            return (FileImportDataCriteria) this;
        }
        
        public FileImportDataCriteria andCol6IsNull() {
            addCriterion("col6 is null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol6IsNotNull() {
            addCriterion("col6 is not null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol6EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col6 =", value, "col6");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol6NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col6 <>", value, "col6");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol6GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("col6 >", value, "col6");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol6GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col6 >=", value, "col6");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol6LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("col6 <", value, "col6");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol6LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col6 <=", value, "col6");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol6Like(java.lang.String value) {
            if (value != null)
              addCriterion("col6 like ", value, "col6");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol6NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("col6 not like ", value, "col6");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol6In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("col6 in ", value, "col6");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol6NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("col6 not in ", value, "col6");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol6Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("col6 between ", value1, value2, "col6");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol6NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("col6 not between ", value1, value2, "col6");
            return (FileImportDataCriteria) this;
        }
        
        public FileImportDataCriteria andCol7IsNull() {
            addCriterion("col7 is null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol7IsNotNull() {
            addCriterion("col7 is not null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol7EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col7 =", value, "col7");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol7NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col7 <>", value, "col7");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol7GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("col7 >", value, "col7");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol7GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col7 >=", value, "col7");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol7LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("col7 <", value, "col7");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol7LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col7 <=", value, "col7");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol7Like(java.lang.String value) {
            if (value != null)
              addCriterion("col7 like ", value, "col7");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol7NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("col7 not like ", value, "col7");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol7In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("col7 in ", value, "col7");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol7NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("col7 not in ", value, "col7");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol7Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("col7 between ", value1, value2, "col7");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol7NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("col7 not between ", value1, value2, "col7");
            return (FileImportDataCriteria) this;
        }
        
        public FileImportDataCriteria andCol8IsNull() {
            addCriterion("col8 is null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol8IsNotNull() {
            addCriterion("col8 is not null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol8EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col8 =", value, "col8");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol8NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col8 <>", value, "col8");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol8GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("col8 >", value, "col8");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol8GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col8 >=", value, "col8");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol8LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("col8 <", value, "col8");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol8LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col8 <=", value, "col8");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol8Like(java.lang.String value) {
            if (value != null)
              addCriterion("col8 like ", value, "col8");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol8NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("col8 not like ", value, "col8");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol8In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("col8 in ", value, "col8");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol8NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("col8 not in ", value, "col8");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol8Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("col8 between ", value1, value2, "col8");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol8NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("col8 not between ", value1, value2, "col8");
            return (FileImportDataCriteria) this;
        }
        
        public FileImportDataCriteria andCol9IsNull() {
            addCriterion("col9 is null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol9IsNotNull() {
            addCriterion("col9 is not null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol9EqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col9 =", value, "col9");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol9NotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col9 <>", value, "col9");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol9GreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("col9 >", value, "col9");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol9GreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col9 >=", value, "col9");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol9LessThan(java.lang.String value) {
            if (value != null)
              addCriterion("col9 <", value, "col9");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol9LessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("col9 <=", value, "col9");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol9Like(java.lang.String value) {
            if (value != null)
              addCriterion("col9 like ", value, "col9");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol9NotLike(java.lang.String value) {
            if (value != null)
              addCriterion("col9 not like ", value, "col9");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol9In(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("col9 in ", value, "col9");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol9NotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("col9 not in ", value, "col9");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol9Between(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("col9 between ", value1, value2, "col9");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andCol9NotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("col9 not between ", value1, value2, "col9");
            return (FileImportDataCriteria) this;
        }
        
        public FileImportDataCriteria andColaIsNull() {
            addCriterion("cola is null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColaIsNotNull() {
            addCriterion("cola is not null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColaEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cola =", value, "cola");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColaNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cola <>", value, "cola");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColaGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("cola >", value, "cola");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColaGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cola >=", value, "cola");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColaLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("cola <", value, "cola");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColaLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cola <=", value, "cola");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColaLike(java.lang.String value) {
            if (value != null)
              addCriterion("cola like ", value, "cola");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColaNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("cola not like ", value, "cola");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColaIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("cola in ", value, "cola");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColaNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("cola not in ", value, "cola");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColaBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cola between ", value1, value2, "cola");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColaNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cola not between ", value1, value2, "cola");
            return (FileImportDataCriteria) this;
        }
        
        public FileImportDataCriteria andColbIsNull() {
            addCriterion("colb is null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColbIsNotNull() {
            addCriterion("colb is not null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColbEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("colb =", value, "colb");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColbNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("colb <>", value, "colb");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColbGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("colb >", value, "colb");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColbGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("colb >=", value, "colb");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColbLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("colb <", value, "colb");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColbLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("colb <=", value, "colb");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColbLike(java.lang.String value) {
            if (value != null)
              addCriterion("colb like ", value, "colb");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColbNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("colb not like ", value, "colb");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColbIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("colb in ", value, "colb");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColbNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("colb not in ", value, "colb");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColbBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("colb between ", value1, value2, "colb");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColbNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("colb not between ", value1, value2, "colb");
            return (FileImportDataCriteria) this;
        }
        
        public FileImportDataCriteria andColcIsNull() {
            addCriterion("colc is null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColcIsNotNull() {
            addCriterion("colc is not null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColcEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("colc =", value, "colc");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColcNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("colc <>", value, "colc");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColcGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("colc >", value, "colc");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColcGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("colc >=", value, "colc");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColcLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("colc <", value, "colc");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColcLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("colc <=", value, "colc");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColcLike(java.lang.String value) {
            if (value != null)
              addCriterion("colc like ", value, "colc");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColcNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("colc not like ", value, "colc");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColcIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("colc in ", value, "colc");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColcNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("colc not in ", value, "colc");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColcBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("colc between ", value1, value2, "colc");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColcNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("colc not between ", value1, value2, "colc");
            return (FileImportDataCriteria) this;
        }
        
        public FileImportDataCriteria andColdIsNull() {
            addCriterion("cold is null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColdIsNotNull() {
            addCriterion("cold is not null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColdEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cold =", value, "cold");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColdNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cold <>", value, "cold");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColdGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("cold >", value, "cold");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColdGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cold >=", value, "cold");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColdLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("cold <", value, "cold");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColdLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cold <=", value, "cold");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColdLike(java.lang.String value) {
            if (value != null)
              addCriterion("cold like ", value, "cold");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColdNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("cold not like ", value, "cold");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColdIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("cold in ", value, "cold");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColdNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("cold not in ", value, "cold");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColdBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cold between ", value1, value2, "cold");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColdNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cold not between ", value1, value2, "cold");
            return (FileImportDataCriteria) this;
        }
        
        public FileImportDataCriteria andColeIsNull() {
            addCriterion("cole is null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColeIsNotNull() {
            addCriterion("cole is not null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cole =", value, "cole");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cole <>", value, "cole");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("cole >", value, "cole");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cole >=", value, "cole");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("cole <", value, "cole");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("cole <=", value, "cole");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColeLike(java.lang.String value) {
            if (value != null)
              addCriterion("cole like ", value, "cole");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("cole not like ", value, "cole");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("cole in ", value, "cole");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("cole not in ", value, "cole");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cole between ", value1, value2, "cole");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("cole not between ", value1, value2, "cole");
            return (FileImportDataCriteria) this;
        }
        
        public FileImportDataCriteria andColfIsNull() {
            addCriterion("colf is null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColfIsNotNull() {
            addCriterion("colf is not null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColfEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("colf =", value, "colf");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColfNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("colf <>", value, "colf");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColfGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("colf >", value, "colf");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColfGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("colf >=", value, "colf");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColfLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("colf <", value, "colf");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColfLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("colf <=", value, "colf");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColfLike(java.lang.String value) {
            if (value != null)
              addCriterion("colf like ", value, "colf");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColfNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("colf not like ", value, "colf");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColfIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("colf in ", value, "colf");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColfNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("colf not in ", value, "colf");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColfBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("colf between ", value1, value2, "colf");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andColfNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("colf not between ", value1, value2, "colf");
            return (FileImportDataCriteria) this;
        }
        
        public FileImportDataCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (FileImportDataCriteria) this;
        }
        
        public FileImportDataCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (FileImportDataCriteria) this;
        }
        public FileImportDataCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (FileImportDataCriteria) this;
        }

    }
    
}

