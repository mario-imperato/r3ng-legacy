//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.agenda.agenda;

import java.util.ArrayList;
import java.util.List;

public class AgendaFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public AgendaFilter() 
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

    public AgendaCriteria or() 
    {
        AgendaCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public AgendaCriteria createCriteria() 
    {
        AgendaCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected AgendaCriteria createCriteriaInternal() 
    {
        AgendaCriteria criteria = new AgendaCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class AgendaCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public AgendaCriteria andAgendaidIsNull() {
            addCriterion("agendaid is null");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andAgendaidIsNotNull() {
            addCriterion("agendaid is not null");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andAgendaidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("agendaid =", value, "agendaid");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andAgendaidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("agendaid <>", value, "agendaid");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andAgendaidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("agendaid >", value, "agendaid");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andAgendaidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("agendaid >=", value, "agendaid");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andAgendaidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("agendaid <", value, "agendaid");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andAgendaidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("agendaid <=", value, "agendaid");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andAgendaidLike(java.lang.String value) {
            if (value != null)
              addCriterion("agendaid like ", value, "agendaid");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andAgendaidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("agendaid not like ", value, "agendaid");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andAgendaidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("agendaid in ", value, "agendaid");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andAgendaidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("agendaid not in ", value, "agendaid");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andAgendaidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("agendaid between ", value1, value2, "agendaid");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andAgendaidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("agendaid not between ", value1, value2, "agendaid");
            return (AgendaCriteria) this;
        }
        
        public AgendaCriteria andActoridIsNull() {
            addCriterion("actorid is null");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andActoridIsNotNull() {
            addCriterion("actorid is not null");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andActoridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("actorid =", value, "actorid");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andActoridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("actorid <>", value, "actorid");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andActoridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("actorid >", value, "actorid");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andActoridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("actorid >=", value, "actorid");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andActoridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("actorid <", value, "actorid");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andActoridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("actorid <=", value, "actorid");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andActoridLike(java.lang.String value) {
            if (value != null)
              addCriterion("actorid like ", value, "actorid");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andActoridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("actorid not like ", value, "actorid");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andActoridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("actorid in ", value, "actorid");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andActoridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("actorid not in ", value, "actorid");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andActoridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("actorid between ", value1, value2, "actorid");
            return (AgendaCriteria) this;
        }
        public AgendaCriteria andActoridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("actorid not between ", value1, value2, "actorid");
            return (AgendaCriteria) this;
        }
    }
    
}

