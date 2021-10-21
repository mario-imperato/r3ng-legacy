//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.file;

import java.util.ArrayList;
import java.util.List;

public class DMSFileFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public DMSFileFilter() 
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

    public DMSFileCriteria or() 
    {
        DMSFileCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public DMSFileCriteria createCriteria() 
    {
        DMSFileCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected DMSFileCriteria createCriteriaInternal() 
    {
        DMSFileCriteria criteria = new DMSFileCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class DMSFileCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public DMSFileCriteria andFileidIsNull() {
            addCriterion("fileid is null");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFileidIsNotNull() {
            addCriterion("fileid is not null");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFileidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fileid =", value, "fileid");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFileidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fileid <>", value, "fileid");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFileidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("fileid >", value, "fileid");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFileidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fileid >=", value, "fileid");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFileidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("fileid <", value, "fileid");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFileidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fileid <=", value, "fileid");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFileidLike(java.lang.String value) {
            if (value != null)
              addCriterion("fileid like ", value, "fileid");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFileidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("fileid not like ", value, "fileid");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFileidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("fileid in ", value, "fileid");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFileidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("fileid not in ", value, "fileid");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFileidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("fileid between ", value1, value2, "fileid");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFileidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("fileid not between ", value1, value2, "fileid");
            return (DMSFileCriteria) this;
        }
        
        public DMSFileCriteria andFilenameIsNull() {
            addCriterion("filename is null");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilenameIsNotNull() {
            addCriterion("filename is not null");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilenameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("filename =", value, "filename");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilenameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("filename <>", value, "filename");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilenameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("filename >", value, "filename");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilenameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("filename >=", value, "filename");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilenameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("filename <", value, "filename");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilenameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("filename <=", value, "filename");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilenameLike(java.lang.String value) {
            if (value != null)
              addCriterion("filename like ", value, "filename");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilenameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("filename not like ", value, "filename");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilenameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("filename in ", value, "filename");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilenameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("filename not in ", value, "filename");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilenameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("filename between ", value1, value2, "filename");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilenameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("filename not between ", value1, value2, "filename");
            return (DMSFileCriteria) this;
        }
        
        public DMSFileCriteria andMimetypeIsNull() {
            addCriterion("mimetype is null");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andMimetypeIsNotNull() {
            addCriterion("mimetype is not null");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andMimetypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("mimetype =", value, "mimetype");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andMimetypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("mimetype <>", value, "mimetype");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andMimetypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("mimetype >", value, "mimetype");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andMimetypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("mimetype >=", value, "mimetype");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andMimetypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("mimetype <", value, "mimetype");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andMimetypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("mimetype <=", value, "mimetype");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andMimetypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("mimetype like ", value, "mimetype");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andMimetypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("mimetype not like ", value, "mimetype");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andMimetypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("mimetype in ", value, "mimetype");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andMimetypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("mimetype not in ", value, "mimetype");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andMimetypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("mimetype between ", value1, value2, "mimetype");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andMimetypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("mimetype not between ", value1, value2, "mimetype");
            return (DMSFileCriteria) this;
        }
        
        public DMSFileCriteria andFilelengthIsNull() {
            addCriterion("filelength is null");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilelengthIsNotNull() {
            addCriterion("filelength is not null");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilelengthEqualTo(java.lang.Long value) {
            if (value != null)
              addCriterion("filelength =", value, "filelength");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilelengthNotEqualTo(java.lang.Long value) {
            if (value != null)
              addCriterion("filelength <>", value, "filelength");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilelengthGreaterThan(java.lang.Long value) {
            if (value != null)
              addCriterion("filelength >", value, "filelength");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilelengthGreaterThanOrEqualTo(java.lang.Long value) {
            if (value != null)
              addCriterion("filelength >=", value, "filelength");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilelengthLessThan(java.lang.Long value) {
            if (value != null)
              addCriterion("filelength <", value, "filelength");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilelengthLessThanOrEqualTo(java.lang.Long value) {
            if (value != null)
              addCriterion("filelength <=", value, "filelength");
            return (DMSFileCriteria) this;
        }

        
        public DMSFileCriteria andFilephysicalpathIsNull() {
            addCriterion("filephysicalpath is null");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilephysicalpathIsNotNull() {
            addCriterion("filephysicalpath is not null");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilephysicalpathEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("filephysicalpath =", value, "filephysicalpath");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilephysicalpathNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("filephysicalpath <>", value, "filephysicalpath");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilephysicalpathGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("filephysicalpath >", value, "filephysicalpath");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilephysicalpathGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("filephysicalpath >=", value, "filephysicalpath");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilephysicalpathLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("filephysicalpath <", value, "filephysicalpath");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilephysicalpathLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("filephysicalpath <=", value, "filephysicalpath");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilephysicalpathLike(java.lang.String value) {
            if (value != null)
              addCriterion("filephysicalpath like ", value, "filephysicalpath");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilephysicalpathNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("filephysicalpath not like ", value, "filephysicalpath");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilephysicalpathIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("filephysicalpath in ", value, "filephysicalpath");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilephysicalpathNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("filephysicalpath not in ", value, "filephysicalpath");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilephysicalpathBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("filephysicalpath between ", value1, value2, "filephysicalpath");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFilephysicalpathNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("filephysicalpath not between ", value1, value2, "filephysicalpath");
            return (DMSFileCriteria) this;
        }
        
        public DMSFileCriteria andFolderidIsNull() {
            addCriterion("folderid is null");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFolderidIsNotNull() {
            addCriterion("folderid is not null");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFolderidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("folderid =", value, "folderid");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFolderidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("folderid <>", value, "folderid");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFolderidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("folderid >", value, "folderid");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFolderidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("folderid >=", value, "folderid");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFolderidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("folderid <", value, "folderid");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFolderidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("folderid <=", value, "folderid");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFolderidLike(java.lang.String value) {
            if (value != null)
              addCriterion("folderid like ", value, "folderid");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFolderidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("folderid not like ", value, "folderid");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFolderidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("folderid in ", value, "folderid");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFolderidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("folderid not in ", value, "folderid");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFolderidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("folderid between ", value1, value2, "folderid");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andFolderidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("folderid not between ", value1, value2, "folderid");
            return (DMSFileCriteria) this;
        }
        
        public DMSFileCriteria andCreationdateIsNull() {
            addCriterion("creationdate is null");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andCreationdateIsNotNull() {
            addCriterion("creationdate is not null");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andCreationdateEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("creationdate =", value, "creationdate");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andCreationdateNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("creationdate <>", value, "creationdate");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andCreationdateGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("creationdate >", value, "creationdate");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andCreationdateGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("creationdate >=", value, "creationdate");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andCreationdateLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("creationdate <", value, "creationdate");
            return (DMSFileCriteria) this;
        }
        public DMSFileCriteria andCreationdateLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("creationdate <=", value, "creationdate");
            return (DMSFileCriteria) this;
        }

    }
    
}

