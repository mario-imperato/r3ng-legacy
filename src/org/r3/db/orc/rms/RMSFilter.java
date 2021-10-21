//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.orc.rms;

import java.util.ArrayList;
import java.util.List;

public class RMSFilter{
    protected String orderByClause;
    protected String  groupByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public RMSFilter() 
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

    public RMSCriteria or() 
    {
        RMSCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public RMSCriteria createCriteria() 
    {
        RMSCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected RMSCriteria createCriteriaInternal() 
    {
        RMSCriteria criteria = new RMSCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class RMSCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public RMSCriteria andRmsidIsNull() {
            addCriterion("rmsid is null");
            return (RMSCriteria) this;
        }
        public RMSCriteria andRmsidIsNotNull() {
            addCriterion("rmsid is not null");
            return (RMSCriteria) this;
        }
        public RMSCriteria andRmsidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rmsid =", value, "rmsid");
            return (RMSCriteria) this;
        }
        public RMSCriteria andRmsidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rmsid <>", value, "rmsid");
            return (RMSCriteria) this;
        }
        public RMSCriteria andRmsidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("rmsid >", value, "rmsid");
            return (RMSCriteria) this;
        }
        public RMSCriteria andRmsidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rmsid >=", value, "rmsid");
            return (RMSCriteria) this;
        }
        public RMSCriteria andRmsidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("rmsid <", value, "rmsid");
            return (RMSCriteria) this;
        }
        public RMSCriteria andRmsidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("rmsid <=", value, "rmsid");
            return (RMSCriteria) this;
        }
        public RMSCriteria andRmsidLike(java.lang.String value) {
            if (value != null)
              addCriterion("rmsid like ", value, "rmsid");
            return (RMSCriteria) this;
        }
        public RMSCriteria andRmsidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("rmsid not like ", value, "rmsid");
            return (RMSCriteria) this;
        }
        public RMSCriteria andRmsidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("rmsid in ", value, "rmsid");
            return (RMSCriteria) this;
        }
        public RMSCriteria andRmsidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("rmsid not in ", value, "rmsid");
            return (RMSCriteria) this;
        }
        public RMSCriteria andRmsidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("rmsid between ", value1, value2, "rmsid");
            return (RMSCriteria) this;
        }
        public RMSCriteria andRmsidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("rmsid not between ", value1, value2, "rmsid");
            return (RMSCriteria) this;
        }
        
        public RMSCriteria andFilenameIsNull() {
            addCriterion("filename is null");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFilenameIsNotNull() {
            addCriterion("filename is not null");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFilenameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("filename =", value, "filename");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFilenameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("filename <>", value, "filename");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFilenameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("filename >", value, "filename");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFilenameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("filename >=", value, "filename");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFilenameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("filename <", value, "filename");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFilenameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("filename <=", value, "filename");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFilenameLike(java.lang.String value) {
            if (value != null)
              addCriterion("filename like ", value, "filename");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFilenameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("filename not like ", value, "filename");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFilenameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("filename in ", value, "filename");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFilenameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("filename not in ", value, "filename");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFilenameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("filename between ", value1, value2, "filename");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFilenameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("filename not between ", value1, value2, "filename");
            return (RMSCriteria) this;
        }
        
        public RMSCriteria andFileurlIsNull() {
            addCriterion("fileurl is null");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFileurlIsNotNull() {
            addCriterion("fileurl is not null");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFileurlEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fileurl =", value, "fileurl");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFileurlNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fileurl <>", value, "fileurl");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFileurlGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("fileurl >", value, "fileurl");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFileurlGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fileurl >=", value, "fileurl");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFileurlLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("fileurl <", value, "fileurl");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFileurlLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fileurl <=", value, "fileurl");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFileurlLike(java.lang.String value) {
            if (value != null)
              addCriterion("fileurl like ", value, "fileurl");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFileurlNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("fileurl not like ", value, "fileurl");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFileurlIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("fileurl in ", value, "fileurl");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFileurlNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("fileurl not in ", value, "fileurl");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFileurlBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("fileurl between ", value1, value2, "fileurl");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFileurlNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("fileurl not between ", value1, value2, "fileurl");
            return (RMSCriteria) this;
        }
        
        public RMSCriteria andFilesizeIsNull() {
            addCriterion("filesize is null");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFilesizeIsNotNull() {
            addCriterion("filesize is not null");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFilesizeEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("filesize =", value, "filesize");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFilesizeNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("filesize <>", value, "filesize");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFilesizeGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("filesize >", value, "filesize");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFilesizeGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("filesize >=", value, "filesize");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFilesizeLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("filesize <", value, "filesize");
            return (RMSCriteria) this;
        }
        public RMSCriteria andFilesizeLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("filesize <=", value, "filesize");
            return (RMSCriteria) this;
        }

        
        public RMSCriteria andNumberofcertsIsNull() {
            addCriterion("numberofcerts is null");
            return (RMSCriteria) this;
        }
        public RMSCriteria andNumberofcertsIsNotNull() {
            addCriterion("numberofcerts is not null");
            return (RMSCriteria) this;
        }
        public RMSCriteria andNumberofcertsEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofcerts =", value, "numberofcerts");
            return (RMSCriteria) this;
        }
        public RMSCriteria andNumberofcertsNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofcerts <>", value, "numberofcerts");
            return (RMSCriteria) this;
        }
        public RMSCriteria andNumberofcertsGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofcerts >", value, "numberofcerts");
            return (RMSCriteria) this;
        }
        public RMSCriteria andNumberofcertsGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofcerts >=", value, "numberofcerts");
            return (RMSCriteria) this;
        }
        public RMSCriteria andNumberofcertsLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofcerts <", value, "numberofcerts");
            return (RMSCriteria) this;
        }
        public RMSCriteria andNumberofcertsLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofcerts <=", value, "numberofcerts");
            return (RMSCriteria) this;
        }

        
        public RMSCriteria andNumberofdupcertsIsNull() {
            addCriterion("numberofdupcerts is null");
            return (RMSCriteria) this;
        }
        public RMSCriteria andNumberofdupcertsIsNotNull() {
            addCriterion("numberofdupcerts is not null");
            return (RMSCriteria) this;
        }
        public RMSCriteria andNumberofdupcertsEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofdupcerts =", value, "numberofdupcerts");
            return (RMSCriteria) this;
        }
        public RMSCriteria andNumberofdupcertsNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofdupcerts <>", value, "numberofdupcerts");
            return (RMSCriteria) this;
        }
        public RMSCriteria andNumberofdupcertsGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofdupcerts >", value, "numberofdupcerts");
            return (RMSCriteria) this;
        }
        public RMSCriteria andNumberofdupcertsGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofdupcerts >=", value, "numberofdupcerts");
            return (RMSCriteria) this;
        }
        public RMSCriteria andNumberofdupcertsLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofdupcerts <", value, "numberofdupcerts");
            return (RMSCriteria) this;
        }
        public RMSCriteria andNumberofdupcertsLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberofdupcerts <=", value, "numberofdupcerts");
            return (RMSCriteria) this;
        }

        
        public RMSCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (RMSCriteria) this;
        }
        public RMSCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (RMSCriteria) this;
        }
        public RMSCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (RMSCriteria) this;
        }
        public RMSCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (RMSCriteria) this;
        }
        public RMSCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (RMSCriteria) this;
        }
        public RMSCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (RMSCriteria) this;
        }
        public RMSCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (RMSCriteria) this;
        }
        public RMSCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (RMSCriteria) this;
        }

    }
    
}

