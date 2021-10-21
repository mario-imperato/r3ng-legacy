//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.agenda.agendaentry;

import java.util.ArrayList;
import java.util.List;

public class AgendaEntryFilter{
    protected String orderByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public AgendaEntryFilter() 
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

    public AgendaEntryCriteria or() 
    {
        AgendaEntryCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public AgendaEntryCriteria createCriteria() 
    {
        AgendaEntryCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected AgendaEntryCriteria createCriteriaInternal() 
    {
        AgendaEntryCriteria criteria = new AgendaEntryCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class AgendaEntryCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public AgendaEntryCriteria andAgendaentryidIsNull() {
            addCriterion("agendaentryid is null");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaentryidIsNotNull() {
            addCriterion("agendaentryid is not null");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaentryidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("agendaentryid =", value, "agendaentryid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaentryidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("agendaentryid <>", value, "agendaentryid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaentryidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("agendaentryid >", value, "agendaentryid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaentryidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("agendaentryid >=", value, "agendaentryid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaentryidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("agendaentryid <", value, "agendaentryid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaentryidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("agendaentryid <=", value, "agendaentryid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaentryidLike(java.lang.String value) {
            if (value != null)
              addCriterion("agendaentryid like ", value, "agendaentryid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaentryidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("agendaentryid not like ", value, "agendaentryid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaentryidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("agendaentryid in ", value, "agendaentryid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaentryidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("agendaentryid not in ", value, "agendaentryid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaentryidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("agendaentryid between ", value1, value2, "agendaentryid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaentryidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("agendaentryid not between ", value1, value2, "agendaentryid");
            return (AgendaEntryCriteria) this;
        }
        
        public AgendaEntryCriteria andAgendaidIsNull() {
            addCriterion("agendaid is null");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaidIsNotNull() {
            addCriterion("agendaid is not null");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("agendaid =", value, "agendaid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("agendaid <>", value, "agendaid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("agendaid >", value, "agendaid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("agendaid >=", value, "agendaid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("agendaid <", value, "agendaid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("agendaid <=", value, "agendaid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaidLike(java.lang.String value) {
            if (value != null)
              addCriterion("agendaid like ", value, "agendaid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("agendaid not like ", value, "agendaid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("agendaid in ", value, "agendaid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("agendaid not in ", value, "agendaid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("agendaid between ", value1, value2, "agendaid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAgendaidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("agendaid not between ", value1, value2, "agendaid");
            return (AgendaEntryCriteria) this;
        }
        
        public AgendaEntryCriteria andEntrydescrIsNull() {
            addCriterion("entrydescr is null");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrydescrIsNotNull() {
            addCriterion("entrydescr is not null");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrydescrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("entrydescr =", value, "entrydescr");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrydescrNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("entrydescr <>", value, "entrydescr");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrydescrGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("entrydescr >", value, "entrydescr");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrydescrGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("entrydescr >=", value, "entrydescr");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrydescrLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("entrydescr <", value, "entrydescr");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrydescrLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("entrydescr <=", value, "entrydescr");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrydescrLike(java.lang.String value) {
            if (value != null)
              addCriterion("entrydescr like ", value, "entrydescr");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrydescrNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("entrydescr not like ", value, "entrydescr");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrydescrIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("entrydescr in ", value, "entrydescr");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrydescrNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("entrydescr not in ", value, "entrydescr");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrydescrBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("entrydescr between ", value1, value2, "entrydescr");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrydescrNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("entrydescr not between ", value1, value2, "entrydescr");
            return (AgendaEntryCriteria) this;
        }
        
        public AgendaEntryCriteria andEntrytypeIsNull() {
            addCriterion("entrytype is null");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytypeIsNotNull() {
            addCriterion("entrytype is not null");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("entrytype =", value, "entrytype");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("entrytype <>", value, "entrytype");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("entrytype >", value, "entrytype");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("entrytype >=", value, "entrytype");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("entrytype <", value, "entrytype");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("entrytype <=", value, "entrytype");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("entrytype like ", value, "entrytype");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("entrytype not like ", value, "entrytype");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("entrytype in ", value, "entrytype");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("entrytype not in ", value, "entrytype");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("entrytype between ", value1, value2, "entrytype");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("entrytype not between ", value1, value2, "entrytype");
            return (AgendaEntryCriteria) this;
        }
        
        public AgendaEntryCriteria andEntrytyperefidIsNull() {
            addCriterion("entrytyperefid is null");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytyperefidIsNotNull() {
            addCriterion("entrytyperefid is not null");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytyperefidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("entrytyperefid =", value, "entrytyperefid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytyperefidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("entrytyperefid <>", value, "entrytyperefid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytyperefidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("entrytyperefid >", value, "entrytyperefid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytyperefidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("entrytyperefid >=", value, "entrytyperefid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytyperefidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("entrytyperefid <", value, "entrytyperefid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytyperefidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("entrytyperefid <=", value, "entrytyperefid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytyperefidLike(java.lang.String value) {
            if (value != null)
              addCriterion("entrytyperefid like ", value, "entrytyperefid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytyperefidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("entrytyperefid not like ", value, "entrytyperefid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytyperefidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("entrytyperefid in ", value, "entrytyperefid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytyperefidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("entrytyperefid not in ", value, "entrytyperefid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytyperefidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("entrytyperefid between ", value1, value2, "entrytyperefid");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEntrytyperefidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("entrytyperefid not between ", value1, value2, "entrytyperefid");
            return (AgendaEntryCriteria) this;
        }
        
        public AgendaEntryCriteria andAlldayflagIsNull() {
            addCriterion("alldayflag is null");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAlldayflagIsNotNull() {
            addCriterion("alldayflag is not null");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAlldayflagEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("alldayflag =", value, "alldayflag");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAlldayflagNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("alldayflag <>", value, "alldayflag");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAlldayflagGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("alldayflag >", value, "alldayflag");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAlldayflagGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("alldayflag >=", value, "alldayflag");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAlldayflagLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("alldayflag <", value, "alldayflag");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAlldayflagLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("alldayflag <=", value, "alldayflag");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAlldayflagLike(java.lang.String value) {
            if (value != null)
              addCriterion("alldayflag like ", value, "alldayflag");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAlldayflagNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("alldayflag not like ", value, "alldayflag");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAlldayflagIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("alldayflag in ", value, "alldayflag");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAlldayflagNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("alldayflag not in ", value, "alldayflag");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAlldayflagBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("alldayflag between ", value1, value2, "alldayflag");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andAlldayflagNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("alldayflag not between ", value1, value2, "alldayflag");
            return (AgendaEntryCriteria) this;
        }
        
        public AgendaEntryCriteria andStartdateIsNull() {
            addCriterion("startdate is null");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andStartdateIsNotNull() {
            addCriterion("startdate is not null");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andStartdateEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("startdate =", value, "startdate");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andStartdateNotEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("startdate <>", value, "startdate");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andStartdateGreaterThan(java.sql.Date value) {
            if (value != null)
              addCriterion("startdate >", value, "startdate");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andStartdateGreaterThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("startdate >=", value, "startdate");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andStartdateLessThan(java.sql.Date value) {
            if (value != null)
              addCriterion("startdate <", value, "startdate");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andStartdateLessThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("startdate <=", value, "startdate");
            return (AgendaEntryCriteria) this;
        }

        
        public AgendaEntryCriteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andStarttimeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("starttime =", value, "starttime");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andStarttimeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("starttime <>", value, "starttime");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andStarttimeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("starttime >", value, "starttime");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andStarttimeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("starttime >=", value, "starttime");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andStarttimeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("starttime <", value, "starttime");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andStarttimeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("starttime <=", value, "starttime");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andStarttimeLike(java.lang.String value) {
            if (value != null)
              addCriterion("starttime like ", value, "starttime");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andStarttimeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("starttime not like ", value, "starttime");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andStarttimeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("starttime in ", value, "starttime");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andStarttimeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("starttime not in ", value, "starttime");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andStarttimeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("starttime between ", value1, value2, "starttime");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andStarttimeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("starttime not between ", value1, value2, "starttime");
            return (AgendaEntryCriteria) this;
        }
        
        public AgendaEntryCriteria andEnddateIsNull() {
            addCriterion("enddate is null");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEnddateIsNotNull() {
            addCriterion("enddate is not null");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEnddateEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("enddate =", value, "enddate");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEnddateNotEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("enddate <>", value, "enddate");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEnddateGreaterThan(java.sql.Date value) {
            if (value != null)
              addCriterion("enddate >", value, "enddate");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEnddateGreaterThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("enddate >=", value, "enddate");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEnddateLessThan(java.sql.Date value) {
            if (value != null)
              addCriterion("enddate <", value, "enddate");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEnddateLessThanOrEqualTo(java.sql.Date value) {
            if (value != null)
              addCriterion("enddate <=", value, "enddate");
            return (AgendaEntryCriteria) this;
        }

        
        public AgendaEntryCriteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEndtimeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("endtime =", value, "endtime");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEndtimeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("endtime <>", value, "endtime");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEndtimeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("endtime >", value, "endtime");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEndtimeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("endtime >=", value, "endtime");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEndtimeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("endtime <", value, "endtime");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEndtimeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("endtime <=", value, "endtime");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEndtimeLike(java.lang.String value) {
            if (value != null)
              addCriterion("endtime like ", value, "endtime");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEndtimeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("endtime not like ", value, "endtime");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEndtimeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("endtime in ", value, "endtime");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEndtimeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("endtime not in ", value, "endtime");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEndtimeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("endtime between ", value1, value2, "endtime");
            return (AgendaEntryCriteria) this;
        }
        public AgendaEntryCriteria andEndtimeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("endtime not between ", value1, value2, "endtime");
            return (AgendaEntryCriteria) this;
        }
    }
    
}

