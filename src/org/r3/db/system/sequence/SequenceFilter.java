//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// GPA Web Framework, Copyright 2004, 2005
//
//
// TODO: Readme Section.
//

package org.r3.db.system.sequence;
import java.util.ArrayList;
import java.util.List;

import org.r3.db.utils.Criteria;

public class SequenceFilter{
    protected String orderByClause;
    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SequenceFilter() 
    {
        oredCriteria = new ArrayList<Criteria>();
    }
    
    public void setOrderByClause(String orderByClause) 
    {
        this.orderByClause = orderByClause;
    }
    
    public String getOrderByClause() 
    {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) 
    {
        this.distinct = distinct;
    }

    public boolean isDistinct() 
    {
        return distinct;
    }

    public List<Criteria> getOredCriteria() 
    {
        return oredCriteria;
    }

    public void or(Criteria criteria) 
    {
        oredCriteria.add(criteria);
    }

    public SequenceCriteria or() 
    {
        SequenceCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public SequenceCriteria createCriteria() 
    {
        SequenceCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected SequenceCriteria createCriteriaInternal() 
    {
        SequenceCriteria criteria = new SequenceCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class SequenceCriteriaBase extends Criteria
    {
        
        public SequenceCriteria andSequencecodeIsNull() {
            addCriterion("sequencecode is null");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencecodeIsNotNull() {
            addCriterion("sequencecode is not null");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencecodeEqualTo(java.lang.String value) {
            addCriterion("sequencecode =", value, "sequencecode");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencecodeNotEqualTo(java.lang.String value) {
            addCriterion("sequencecode <>", value, "sequencecode");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencecodeGreaterThan(java.lang.String value) {
            addCriterion("sequencecode >", value, "sequencecode");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencecodeGreaterThanOrEqualTo(java.lang.String value) {
            addCriterion("sequencecode >=", value, "sequencecode");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencecodeLessThan(java.lang.String value) {
            addCriterion("sequencecode <", value, "sequencecode");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencecodeLessThanOrEqualTo(java.lang.String value) {
            addCriterion("sequencecode <=", value, "sequencecode");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencecodeLike(java.lang.String value) {
            addCriterion("sequencecode like ", value, "sequencecode");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencecodeNotLike(java.lang.String value) {
            addCriterion("sequencecode not like ", value, "sequencecode");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencecodeIn(java.util.List<java.lang.String> value) {
            addCriterion("sequencecode in ", value, "sequencecode");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencecodeNotIn(java.util.List<java.lang.String> value) {
            addCriterion("sequencecode not in ", value, "sequencecode");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencecodeBetween(java.lang.String value1, java.lang.String value2) {
            addCriterion("sequencecode between ", value1, value2, "sequencecode");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencecodeNotBetween(java.lang.String value1, java.lang.String value2) {
            addCriterion("sequencecode not between ", value1, value2, "sequencecode");
            return (SequenceCriteria) this;
        }
        

        
        public SequenceCriteria andSequencedescrIsNull() {
            addCriterion("sequencedescr is null");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencedescrIsNotNull() {
            addCriterion("sequencedescr is not null");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencedescrEqualTo(java.lang.String value) {
            addCriterion("sequencedescr =", value, "sequencedescr");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencedescrNotEqualTo(java.lang.String value) {
            addCriterion("sequencedescr <>", value, "sequencedescr");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencedescrGreaterThan(java.lang.String value) {
            addCriterion("sequencedescr >", value, "sequencedescr");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencedescrGreaterThanOrEqualTo(java.lang.String value) {
            addCriterion("sequencedescr >=", value, "sequencedescr");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencedescrLessThan(java.lang.String value) {
            addCriterion("sequencedescr <", value, "sequencedescr");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencedescrLessThanOrEqualTo(java.lang.String value) {
            addCriterion("sequencedescr <=", value, "sequencedescr");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencedescrLike(java.lang.String value) {
            addCriterion("sequencedescr like ", value, "sequencedescr");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencedescrNotLike(java.lang.String value) {
            addCriterion("sequencedescr not like ", value, "sequencedescr");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencedescrIn(java.util.List<java.lang.String> value) {
            addCriterion("sequencedescr in ", value, "sequencedescr");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencedescrNotIn(java.util.List<java.lang.String> value) {
            addCriterion("sequencedescr not in ", value, "sequencedescr");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencedescrBetween(java.lang.String value1, java.lang.String value2) {
            addCriterion("sequencedescr between ", value1, value2, "sequencedescr");
            return (SequenceCriteria) this;
        }
        public SequenceCriteria andSequencedescrNotBetween(java.lang.String value1, java.lang.String value2) {
            addCriterion("sequencedescr not between ", value1, value2, "sequencedescr");
            return (SequenceCriteria) this;
        }
    }
    
}

