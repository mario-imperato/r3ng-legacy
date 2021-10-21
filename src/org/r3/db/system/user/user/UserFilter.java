//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.user.user;

import java.util.ArrayList;
import java.util.List;

public class UserFilter{
    protected String orderByClause;
    protected String  groupByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public UserFilter() 
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

    public UserCriteria or() 
    {
        UserCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public UserCriteria createCriteria() 
    {
        UserCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected UserCriteria createCriteriaInternal() 
    {
        UserCriteria criteria = new UserCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class UserCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public UserCriteria andUseridIsNull() {
            addCriterion("userid is null");
            return (UserCriteria) this;
        }
        public UserCriteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (UserCriteria) this;
        }
        public UserCriteria andUseridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid =", value, "userid");
            return (UserCriteria) this;
        }
        public UserCriteria andUseridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <>", value, "userid");
            return (UserCriteria) this;
        }
        public UserCriteria andUseridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid >", value, "userid");
            return (UserCriteria) this;
        }
        public UserCriteria andUseridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid >=", value, "userid");
            return (UserCriteria) this;
        }
        public UserCriteria andUseridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid <", value, "userid");
            return (UserCriteria) this;
        }
        public UserCriteria andUseridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <=", value, "userid");
            return (UserCriteria) this;
        }
        public UserCriteria andUseridLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid like ", value, "userid");
            return (UserCriteria) this;
        }
        public UserCriteria andUseridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid not like ", value, "userid");
            return (UserCriteria) this;
        }
        public UserCriteria andUseridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("userid in ", value, "userid");
            return (UserCriteria) this;
        }
        public UserCriteria andUseridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("userid not in ", value, "userid");
            return (UserCriteria) this;
        }
        public UserCriteria andUseridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid between ", value1, value2, "userid");
            return (UserCriteria) this;
        }
        public UserCriteria andUseridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid not between ", value1, value2, "userid");
            return (UserCriteria) this;
        }
        
        public UserCriteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (UserCriteria) this;
        }
        public UserCriteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (UserCriteria) this;
        }
        public UserCriteria andNicknameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nickname =", value, "nickname");
            return (UserCriteria) this;
        }
        public UserCriteria andNicknameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nickname <>", value, "nickname");
            return (UserCriteria) this;
        }
        public UserCriteria andNicknameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("nickname >", value, "nickname");
            return (UserCriteria) this;
        }
        public UserCriteria andNicknameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nickname >=", value, "nickname");
            return (UserCriteria) this;
        }
        public UserCriteria andNicknameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("nickname <", value, "nickname");
            return (UserCriteria) this;
        }
        public UserCriteria andNicknameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nickname <=", value, "nickname");
            return (UserCriteria) this;
        }
        public UserCriteria andNicknameLike(java.lang.String value) {
            if (value != null)
              addCriterion("nickname like ", value, "nickname");
            return (UserCriteria) this;
        }
        public UserCriteria andNicknameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("nickname not like ", value, "nickname");
            return (UserCriteria) this;
        }
        public UserCriteria andNicknameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("nickname in ", value, "nickname");
            return (UserCriteria) this;
        }
        public UserCriteria andNicknameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("nickname not in ", value, "nickname");
            return (UserCriteria) this;
        }
        public UserCriteria andNicknameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nickname between ", value1, value2, "nickname");
            return (UserCriteria) this;
        }
        public UserCriteria andNicknameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nickname not between ", value1, value2, "nickname");
            return (UserCriteria) this;
        }
        
        public UserCriteria andPasswordIsNull() {
            addCriterion("password is null");
            return (UserCriteria) this;
        }
        public UserCriteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (UserCriteria) this;
        }
        public UserCriteria andPasswordEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("password =", value, "password");
            return (UserCriteria) this;
        }
        public UserCriteria andPasswordNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("password <>", value, "password");
            return (UserCriteria) this;
        }
        public UserCriteria andPasswordGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("password >", value, "password");
            return (UserCriteria) this;
        }
        public UserCriteria andPasswordGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("password >=", value, "password");
            return (UserCriteria) this;
        }
        public UserCriteria andPasswordLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("password <", value, "password");
            return (UserCriteria) this;
        }
        public UserCriteria andPasswordLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("password <=", value, "password");
            return (UserCriteria) this;
        }
        public UserCriteria andPasswordLike(java.lang.String value) {
            if (value != null)
              addCriterion("password like ", value, "password");
            return (UserCriteria) this;
        }
        public UserCriteria andPasswordNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("password not like ", value, "password");
            return (UserCriteria) this;
        }
        public UserCriteria andPasswordIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("password in ", value, "password");
            return (UserCriteria) this;
        }
        public UserCriteria andPasswordNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("password not in ", value, "password");
            return (UserCriteria) this;
        }
        public UserCriteria andPasswordBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("password between ", value1, value2, "password");
            return (UserCriteria) this;
        }
        public UserCriteria andPasswordNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("password not between ", value1, value2, "password");
            return (UserCriteria) this;
        }
        
        public UserCriteria andFirstnameIsNull() {
            addCriterion("firstname is null");
            return (UserCriteria) this;
        }
        public UserCriteria andFirstnameIsNotNull() {
            addCriterion("firstname is not null");
            return (UserCriteria) this;
        }
        public UserCriteria andFirstnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("firstname =", value, "firstname");
            return (UserCriteria) this;
        }
        public UserCriteria andFirstnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("firstname <>", value, "firstname");
            return (UserCriteria) this;
        }
        public UserCriteria andFirstnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("firstname >", value, "firstname");
            return (UserCriteria) this;
        }
        public UserCriteria andFirstnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("firstname >=", value, "firstname");
            return (UserCriteria) this;
        }
        public UserCriteria andFirstnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("firstname <", value, "firstname");
            return (UserCriteria) this;
        }
        public UserCriteria andFirstnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("firstname <=", value, "firstname");
            return (UserCriteria) this;
        }
        public UserCriteria andFirstnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("firstname like ", value, "firstname");
            return (UserCriteria) this;
        }
        public UserCriteria andFirstnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("firstname not like ", value, "firstname");
            return (UserCriteria) this;
        }
        public UserCriteria andFirstnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("firstname in ", value, "firstname");
            return (UserCriteria) this;
        }
        public UserCriteria andFirstnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("firstname not in ", value, "firstname");
            return (UserCriteria) this;
        }
        public UserCriteria andFirstnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("firstname between ", value1, value2, "firstname");
            return (UserCriteria) this;
        }
        public UserCriteria andFirstnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("firstname not between ", value1, value2, "firstname");
            return (UserCriteria) this;
        }
        
        public UserCriteria andLastnameIsNull() {
            addCriterion("lastname is null");
            return (UserCriteria) this;
        }
        public UserCriteria andLastnameIsNotNull() {
            addCriterion("lastname is not null");
            return (UserCriteria) this;
        }
        public UserCriteria andLastnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lastname =", value, "lastname");
            return (UserCriteria) this;
        }
        public UserCriteria andLastnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lastname <>", value, "lastname");
            return (UserCriteria) this;
        }
        public UserCriteria andLastnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("lastname >", value, "lastname");
            return (UserCriteria) this;
        }
        public UserCriteria andLastnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lastname >=", value, "lastname");
            return (UserCriteria) this;
        }
        public UserCriteria andLastnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("lastname <", value, "lastname");
            return (UserCriteria) this;
        }
        public UserCriteria andLastnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lastname <=", value, "lastname");
            return (UserCriteria) this;
        }
        public UserCriteria andLastnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("lastname like ", value, "lastname");
            return (UserCriteria) this;
        }
        public UserCriteria andLastnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("lastname not like ", value, "lastname");
            return (UserCriteria) this;
        }
        public UserCriteria andLastnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("lastname in ", value, "lastname");
            return (UserCriteria) this;
        }
        public UserCriteria andLastnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("lastname not in ", value, "lastname");
            return (UserCriteria) this;
        }
        public UserCriteria andLastnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("lastname between ", value1, value2, "lastname");
            return (UserCriteria) this;
        }
        public UserCriteria andLastnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("lastname not between ", value1, value2, "lastname");
            return (UserCriteria) this;
        }
        
        public UserCriteria andCompanyidIsNull() {
            addCriterion("companyid is null");
            return (UserCriteria) this;
        }
        public UserCriteria andCompanyidIsNotNull() {
            addCriterion("companyid is not null");
            return (UserCriteria) this;
        }
        public UserCriteria andCompanyidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("companyid =", value, "companyid");
            return (UserCriteria) this;
        }
        public UserCriteria andCompanyidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("companyid <>", value, "companyid");
            return (UserCriteria) this;
        }
        public UserCriteria andCompanyidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("companyid >", value, "companyid");
            return (UserCriteria) this;
        }
        public UserCriteria andCompanyidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("companyid >=", value, "companyid");
            return (UserCriteria) this;
        }
        public UserCriteria andCompanyidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("companyid <", value, "companyid");
            return (UserCriteria) this;
        }
        public UserCriteria andCompanyidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("companyid <=", value, "companyid");
            return (UserCriteria) this;
        }
        public UserCriteria andCompanyidLike(java.lang.String value) {
            if (value != null)
              addCriterion("companyid like ", value, "companyid");
            return (UserCriteria) this;
        }
        public UserCriteria andCompanyidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("companyid not like ", value, "companyid");
            return (UserCriteria) this;
        }
        public UserCriteria andCompanyidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("companyid in ", value, "companyid");
            return (UserCriteria) this;
        }
        public UserCriteria andCompanyidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("companyid not in ", value, "companyid");
            return (UserCriteria) this;
        }
        public UserCriteria andCompanyidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("companyid between ", value1, value2, "companyid");
            return (UserCriteria) this;
        }
        public UserCriteria andCompanyidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("companyid not between ", value1, value2, "companyid");
            return (UserCriteria) this;
        }
        
        public UserCriteria andEmailIsNull() {
            addCriterion("email is null");
            return (UserCriteria) this;
        }
        public UserCriteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (UserCriteria) this;
        }
        public UserCriteria andEmailEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("email =", value, "email");
            return (UserCriteria) this;
        }
        public UserCriteria andEmailNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("email <>", value, "email");
            return (UserCriteria) this;
        }
        public UserCriteria andEmailGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("email >", value, "email");
            return (UserCriteria) this;
        }
        public UserCriteria andEmailGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("email >=", value, "email");
            return (UserCriteria) this;
        }
        public UserCriteria andEmailLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("email <", value, "email");
            return (UserCriteria) this;
        }
        public UserCriteria andEmailLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("email <=", value, "email");
            return (UserCriteria) this;
        }
        public UserCriteria andEmailLike(java.lang.String value) {
            if (value != null)
              addCriterion("email like ", value, "email");
            return (UserCriteria) this;
        }
        public UserCriteria andEmailNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("email not like ", value, "email");
            return (UserCriteria) this;
        }
        public UserCriteria andEmailIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("email in ", value, "email");
            return (UserCriteria) this;
        }
        public UserCriteria andEmailNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("email not in ", value, "email");
            return (UserCriteria) this;
        }
        public UserCriteria andEmailBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("email between ", value1, value2, "email");
            return (UserCriteria) this;
        }
        public UserCriteria andEmailNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("email not between ", value1, value2, "email");
            return (UserCriteria) this;
        }
        
        public UserCriteria andUsertypeIsNull() {
            addCriterion("usertype is null");
            return (UserCriteria) this;
        }
        public UserCriteria andUsertypeIsNotNull() {
            addCriterion("usertype is not null");
            return (UserCriteria) this;
        }
        public UserCriteria andUsertypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("usertype =", value, "usertype");
            return (UserCriteria) this;
        }
        public UserCriteria andUsertypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("usertype <>", value, "usertype");
            return (UserCriteria) this;
        }
        public UserCriteria andUsertypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("usertype >", value, "usertype");
            return (UserCriteria) this;
        }
        public UserCriteria andUsertypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("usertype >=", value, "usertype");
            return (UserCriteria) this;
        }
        public UserCriteria andUsertypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("usertype <", value, "usertype");
            return (UserCriteria) this;
        }
        public UserCriteria andUsertypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("usertype <=", value, "usertype");
            return (UserCriteria) this;
        }
        public UserCriteria andUsertypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("usertype like ", value, "usertype");
            return (UserCriteria) this;
        }
        public UserCriteria andUsertypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("usertype not like ", value, "usertype");
            return (UserCriteria) this;
        }
        public UserCriteria andUsertypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("usertype in ", value, "usertype");
            return (UserCriteria) this;
        }
        public UserCriteria andUsertypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("usertype not in ", value, "usertype");
            return (UserCriteria) this;
        }
        public UserCriteria andUsertypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("usertype between ", value1, value2, "usertype");
            return (UserCriteria) this;
        }
        public UserCriteria andUsertypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("usertype not between ", value1, value2, "usertype");
            return (UserCriteria) this;
        }
        
        public UserCriteria andAvatarroleIsNull() {
            addCriterion("avatarrole is null");
            return (UserCriteria) this;
        }
        public UserCriteria andAvatarroleIsNotNull() {
            addCriterion("avatarrole is not null");
            return (UserCriteria) this;
        }
        public UserCriteria andAvatarroleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("avatarrole =", value, "avatarrole");
            return (UserCriteria) this;
        }
        public UserCriteria andAvatarroleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("avatarrole <>", value, "avatarrole");
            return (UserCriteria) this;
        }
        public UserCriteria andAvatarroleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("avatarrole >", value, "avatarrole");
            return (UserCriteria) this;
        }
        public UserCriteria andAvatarroleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("avatarrole >=", value, "avatarrole");
            return (UserCriteria) this;
        }
        public UserCriteria andAvatarroleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("avatarrole <", value, "avatarrole");
            return (UserCriteria) this;
        }
        public UserCriteria andAvatarroleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("avatarrole <=", value, "avatarrole");
            return (UserCriteria) this;
        }
        public UserCriteria andAvatarroleLike(java.lang.String value) {
            if (value != null)
              addCriterion("avatarrole like ", value, "avatarrole");
            return (UserCriteria) this;
        }
        public UserCriteria andAvatarroleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("avatarrole not like ", value, "avatarrole");
            return (UserCriteria) this;
        }
        public UserCriteria andAvatarroleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("avatarrole in ", value, "avatarrole");
            return (UserCriteria) this;
        }
        public UserCriteria andAvatarroleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("avatarrole not in ", value, "avatarrole");
            return (UserCriteria) this;
        }
        public UserCriteria andAvatarroleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("avatarrole between ", value1, value2, "avatarrole");
            return (UserCriteria) this;
        }
        public UserCriteria andAvatarroleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("avatarrole not between ", value1, value2, "avatarrole");
            return (UserCriteria) this;
        }
        
        public UserCriteria andParentuseridIsNull() {
            addCriterion("parentuserid is null");
            return (UserCriteria) this;
        }
        public UserCriteria andParentuseridIsNotNull() {
            addCriterion("parentuserid is not null");
            return (UserCriteria) this;
        }
        public UserCriteria andParentuseridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("parentuserid =", value, "parentuserid");
            return (UserCriteria) this;
        }
        public UserCriteria andParentuseridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("parentuserid <>", value, "parentuserid");
            return (UserCriteria) this;
        }
        public UserCriteria andParentuseridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("parentuserid >", value, "parentuserid");
            return (UserCriteria) this;
        }
        public UserCriteria andParentuseridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("parentuserid >=", value, "parentuserid");
            return (UserCriteria) this;
        }
        public UserCriteria andParentuseridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("parentuserid <", value, "parentuserid");
            return (UserCriteria) this;
        }
        public UserCriteria andParentuseridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("parentuserid <=", value, "parentuserid");
            return (UserCriteria) this;
        }
        public UserCriteria andParentuseridLike(java.lang.String value) {
            if (value != null)
              addCriterion("parentuserid like ", value, "parentuserid");
            return (UserCriteria) this;
        }
        public UserCriteria andParentuseridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("parentuserid not like ", value, "parentuserid");
            return (UserCriteria) this;
        }
        public UserCriteria andParentuseridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("parentuserid in ", value, "parentuserid");
            return (UserCriteria) this;
        }
        public UserCriteria andParentuseridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("parentuserid not in ", value, "parentuserid");
            return (UserCriteria) this;
        }
        public UserCriteria andParentuseridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("parentuserid between ", value1, value2, "parentuserid");
            return (UserCriteria) this;
        }
        public UserCriteria andParentuseridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("parentuserid not between ", value1, value2, "parentuserid");
            return (UserCriteria) this;
        }
        
        public UserCriteria andUserphotoIsNull() {
            addCriterion("userphoto is null");
            return (UserCriteria) this;
        }
        public UserCriteria andUserphotoIsNotNull() {
            addCriterion("userphoto is not null");
            return (UserCriteria) this;
        }
        public UserCriteria andUserphotoEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userphoto =", value, "userphoto");
            return (UserCriteria) this;
        }
        public UserCriteria andUserphotoNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userphoto <>", value, "userphoto");
            return (UserCriteria) this;
        }
        public UserCriteria andUserphotoGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("userphoto >", value, "userphoto");
            return (UserCriteria) this;
        }
        public UserCriteria andUserphotoGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userphoto >=", value, "userphoto");
            return (UserCriteria) this;
        }
        public UserCriteria andUserphotoLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("userphoto <", value, "userphoto");
            return (UserCriteria) this;
        }
        public UserCriteria andUserphotoLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userphoto <=", value, "userphoto");
            return (UserCriteria) this;
        }
        public UserCriteria andUserphotoLike(java.lang.String value) {
            if (value != null)
              addCriterion("userphoto like ", value, "userphoto");
            return (UserCriteria) this;
        }
        public UserCriteria andUserphotoNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("userphoto not like ", value, "userphoto");
            return (UserCriteria) this;
        }
        public UserCriteria andUserphotoIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("userphoto in ", value, "userphoto");
            return (UserCriteria) this;
        }
        public UserCriteria andUserphotoNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("userphoto not in ", value, "userphoto");
            return (UserCriteria) this;
        }
        public UserCriteria andUserphotoBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userphoto between ", value1, value2, "userphoto");
            return (UserCriteria) this;
        }
        public UserCriteria andUserphotoNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userphoto not between ", value1, value2, "userphoto");
            return (UserCriteria) this;
        }
        
        public UserCriteria andLastloginIsNull() {
            addCriterion("lastlogin is null");
            return (UserCriteria) this;
        }
        public UserCriteria andLastloginIsNotNull() {
            addCriterion("lastlogin is not null");
            return (UserCriteria) this;
        }
        public UserCriteria andLastloginEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("lastlogin =", value, "lastlogin");
            return (UserCriteria) this;
        }
        public UserCriteria andLastloginNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("lastlogin <>", value, "lastlogin");
            return (UserCriteria) this;
        }
        public UserCriteria andLastloginGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("lastlogin >", value, "lastlogin");
            return (UserCriteria) this;
        }
        public UserCriteria andLastloginGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("lastlogin >=", value, "lastlogin");
            return (UserCriteria) this;
        }
        public UserCriteria andLastloginLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("lastlogin <", value, "lastlogin");
            return (UserCriteria) this;
        }
        public UserCriteria andLastloginLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("lastlogin <=", value, "lastlogin");
            return (UserCriteria) this;
        }

        
        public UserCriteria andNumberofloginsIsNull() {
            addCriterion("numberoflogins is null");
            return (UserCriteria) this;
        }
        public UserCriteria andNumberofloginsIsNotNull() {
            addCriterion("numberoflogins is not null");
            return (UserCriteria) this;
        }
        public UserCriteria andNumberofloginsEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberoflogins =", value, "numberoflogins");
            return (UserCriteria) this;
        }
        public UserCriteria andNumberofloginsNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberoflogins <>", value, "numberoflogins");
            return (UserCriteria) this;
        }
        public UserCriteria andNumberofloginsGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberoflogins >", value, "numberoflogins");
            return (UserCriteria) this;
        }
        public UserCriteria andNumberofloginsGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberoflogins >=", value, "numberoflogins");
            return (UserCriteria) this;
        }
        public UserCriteria andNumberofloginsLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberoflogins <", value, "numberoflogins");
            return (UserCriteria) this;
        }
        public UserCriteria andNumberofloginsLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberoflogins <=", value, "numberoflogins");
            return (UserCriteria) this;
        }

        
        public UserCriteria andUserconsentIsNull() {
            addCriterion("userconsent is null");
            return (UserCriteria) this;
        }
        public UserCriteria andUserconsentIsNotNull() {
            addCriterion("userconsent is not null");
            return (UserCriteria) this;
        }
        public UserCriteria andUserconsentEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userconsent =", value, "userconsent");
            return (UserCriteria) this;
        }
        public UserCriteria andUserconsentNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userconsent <>", value, "userconsent");
            return (UserCriteria) this;
        }
        public UserCriteria andUserconsentGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("userconsent >", value, "userconsent");
            return (UserCriteria) this;
        }
        public UserCriteria andUserconsentGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userconsent >=", value, "userconsent");
            return (UserCriteria) this;
        }
        public UserCriteria andUserconsentLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("userconsent <", value, "userconsent");
            return (UserCriteria) this;
        }
        public UserCriteria andUserconsentLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userconsent <=", value, "userconsent");
            return (UserCriteria) this;
        }
        public UserCriteria andUserconsentLike(java.lang.String value) {
            if (value != null)
              addCriterion("userconsent like ", value, "userconsent");
            return (UserCriteria) this;
        }
        public UserCriteria andUserconsentNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("userconsent not like ", value, "userconsent");
            return (UserCriteria) this;
        }
        public UserCriteria andUserconsentIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("userconsent in ", value, "userconsent");
            return (UserCriteria) this;
        }
        public UserCriteria andUserconsentNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("userconsent not in ", value, "userconsent");
            return (UserCriteria) this;
        }
        public UserCriteria andUserconsentBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userconsent between ", value1, value2, "userconsent");
            return (UserCriteria) this;
        }
        public UserCriteria andUserconsentNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userconsent not between ", value1, value2, "userconsent");
            return (UserCriteria) this;
        }
        
        public UserCriteria andFbuseridIsNull() {
            addCriterion("fbuserid is null");
            return (UserCriteria) this;
        }
        public UserCriteria andFbuseridIsNotNull() {
            addCriterion("fbuserid is not null");
            return (UserCriteria) this;
        }
        public UserCriteria andFbuseridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fbuserid =", value, "fbuserid");
            return (UserCriteria) this;
        }
        public UserCriteria andFbuseridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fbuserid <>", value, "fbuserid");
            return (UserCriteria) this;
        }
        public UserCriteria andFbuseridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("fbuserid >", value, "fbuserid");
            return (UserCriteria) this;
        }
        public UserCriteria andFbuseridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fbuserid >=", value, "fbuserid");
            return (UserCriteria) this;
        }
        public UserCriteria andFbuseridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("fbuserid <", value, "fbuserid");
            return (UserCriteria) this;
        }
        public UserCriteria andFbuseridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fbuserid <=", value, "fbuserid");
            return (UserCriteria) this;
        }
        public UserCriteria andFbuseridLike(java.lang.String value) {
            if (value != null)
              addCriterion("fbuserid like ", value, "fbuserid");
            return (UserCriteria) this;
        }
        public UserCriteria andFbuseridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("fbuserid not like ", value, "fbuserid");
            return (UserCriteria) this;
        }
        public UserCriteria andFbuseridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("fbuserid in ", value, "fbuserid");
            return (UserCriteria) this;
        }
        public UserCriteria andFbuseridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("fbuserid not in ", value, "fbuserid");
            return (UserCriteria) this;
        }
        public UserCriteria andFbuseridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("fbuserid between ", value1, value2, "fbuserid");
            return (UserCriteria) this;
        }
        public UserCriteria andFbuseridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("fbuserid not between ", value1, value2, "fbuserid");
            return (UserCriteria) this;
        }
        
        public UserCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (UserCriteria) this;
        }
        public UserCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (UserCriteria) this;
        }
        public UserCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (UserCriteria) this;
        }
        public UserCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (UserCriteria) this;
        }
        public UserCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (UserCriteria) this;
        }
        public UserCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (UserCriteria) this;
        }
        public UserCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (UserCriteria) this;
        }
        public UserCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (UserCriteria) this;
        }
        public UserCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (UserCriteria) this;
        }
        public UserCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (UserCriteria) this;
        }
        public UserCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (UserCriteria) this;
        }
        public UserCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (UserCriteria) this;
        }
        public UserCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (UserCriteria) this;
        }
        public UserCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (UserCriteria) this;
        }
        
        public UserCriteria andRectimestampIsNull() {
            addCriterion("rectimestamp is null");
            return (UserCriteria) this;
        }
        public UserCriteria andRectimestampIsNotNull() {
            addCriterion("rectimestamp is not null");
            return (UserCriteria) this;
        }
        public UserCriteria andRectimestampEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp =", value, "rectimestamp");
            return (UserCriteria) this;
        }
        public UserCriteria andRectimestampNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <>", value, "rectimestamp");
            return (UserCriteria) this;
        }
        public UserCriteria andRectimestampGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >", value, "rectimestamp");
            return (UserCriteria) this;
        }
        public UserCriteria andRectimestampGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp >=", value, "rectimestamp");
            return (UserCriteria) this;
        }
        public UserCriteria andRectimestampLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <", value, "rectimestamp");
            return (UserCriteria) this;
        }
        public UserCriteria andRectimestampLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("rectimestamp <=", value, "rectimestamp");
            return (UserCriteria) this;
        }

    }
    
}

