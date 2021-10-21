//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.user.userprofileview;

import java.util.ArrayList;
import java.util.List;

public class UserProfileViewFilter{
    protected String orderByClause;
    protected String  groupByClause;
    protected boolean distinct;
    protected int     limitFetch;
    
    protected List<org.r3.db.utils.Criteria> oredCriteria;

    public UserProfileViewFilter() 
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

    public UserProfileViewCriteria or() 
    {
        UserProfileViewCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public UserProfileViewCriteria createCriteria() 
    {
        UserProfileViewCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected UserProfileViewCriteria createCriteriaInternal() 
    {
        UserProfileViewCriteria criteria = new UserProfileViewCriteria();
        return criteria;
    }

    public void clear() 
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static abstract class UserProfileViewCriteriaBase extends org.r3.db.utils.Criteria
    {
        
        public UserProfileViewCriteria andUseridIsNull() {
            addCriterion("userid is null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUseridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid =", value, "userid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUseridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <>", value, "userid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUseridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid >", value, "userid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUseridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid >=", value, "userid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUseridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("userid <", value, "userid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUseridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userid <=", value, "userid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUseridLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid like ", value, "userid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUseridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("userid not like ", value, "userid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUseridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("userid in ", value, "userid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUseridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("userid not in ", value, "userid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUseridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid between ", value1, value2, "userid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUseridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userid not between ", value1, value2, "userid");
            return (UserProfileViewCriteria) this;
        }
        
        public UserProfileViewCriteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andNicknameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nickname =", value, "nickname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andNicknameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nickname <>", value, "nickname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andNicknameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("nickname >", value, "nickname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andNicknameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nickname >=", value, "nickname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andNicknameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("nickname <", value, "nickname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andNicknameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("nickname <=", value, "nickname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andNicknameLike(java.lang.String value) {
            if (value != null)
              addCriterion("nickname like ", value, "nickname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andNicknameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("nickname not like ", value, "nickname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andNicknameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("nickname in ", value, "nickname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andNicknameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("nickname not in ", value, "nickname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andNicknameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nickname between ", value1, value2, "nickname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andNicknameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("nickname not between ", value1, value2, "nickname");
            return (UserProfileViewCriteria) this;
        }
        
        public UserProfileViewCriteria andPasswordIsNull() {
            addCriterion("password is null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andPasswordEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("password =", value, "password");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andPasswordNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("password <>", value, "password");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andPasswordGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("password >", value, "password");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andPasswordGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("password >=", value, "password");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andPasswordLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("password <", value, "password");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andPasswordLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("password <=", value, "password");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andPasswordLike(java.lang.String value) {
            if (value != null)
              addCriterion("password like ", value, "password");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andPasswordNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("password not like ", value, "password");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andPasswordIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("password in ", value, "password");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andPasswordNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("password not in ", value, "password");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andPasswordBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("password between ", value1, value2, "password");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andPasswordNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("password not between ", value1, value2, "password");
            return (UserProfileViewCriteria) this;
        }
        
        public UserProfileViewCriteria andFirstnameIsNull() {
            addCriterion("firstname is null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFirstnameIsNotNull() {
            addCriterion("firstname is not null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFirstnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("firstname =", value, "firstname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFirstnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("firstname <>", value, "firstname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFirstnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("firstname >", value, "firstname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFirstnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("firstname >=", value, "firstname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFirstnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("firstname <", value, "firstname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFirstnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("firstname <=", value, "firstname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFirstnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("firstname like ", value, "firstname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFirstnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("firstname not like ", value, "firstname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFirstnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("firstname in ", value, "firstname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFirstnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("firstname not in ", value, "firstname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFirstnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("firstname between ", value1, value2, "firstname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFirstnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("firstname not between ", value1, value2, "firstname");
            return (UserProfileViewCriteria) this;
        }
        
        public UserProfileViewCriteria andLastnameIsNull() {
            addCriterion("lastname is null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andLastnameIsNotNull() {
            addCriterion("lastname is not null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andLastnameEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lastname =", value, "lastname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andLastnameNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lastname <>", value, "lastname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andLastnameGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("lastname >", value, "lastname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andLastnameGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lastname >=", value, "lastname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andLastnameLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("lastname <", value, "lastname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andLastnameLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("lastname <=", value, "lastname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andLastnameLike(java.lang.String value) {
            if (value != null)
              addCriterion("lastname like ", value, "lastname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andLastnameNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("lastname not like ", value, "lastname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andLastnameIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("lastname in ", value, "lastname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andLastnameNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("lastname not in ", value, "lastname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andLastnameBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("lastname between ", value1, value2, "lastname");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andLastnameNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("lastname not between ", value1, value2, "lastname");
            return (UserProfileViewCriteria) this;
        }
        
        public UserProfileViewCriteria andCompanyidIsNull() {
            addCriterion("companyid is null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andCompanyidIsNotNull() {
            addCriterion("companyid is not null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andCompanyidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("companyid =", value, "companyid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andCompanyidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("companyid <>", value, "companyid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andCompanyidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("companyid >", value, "companyid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andCompanyidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("companyid >=", value, "companyid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andCompanyidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("companyid <", value, "companyid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andCompanyidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("companyid <=", value, "companyid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andCompanyidLike(java.lang.String value) {
            if (value != null)
              addCriterion("companyid like ", value, "companyid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andCompanyidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("companyid not like ", value, "companyid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andCompanyidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("companyid in ", value, "companyid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andCompanyidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("companyid not in ", value, "companyid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andCompanyidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("companyid between ", value1, value2, "companyid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andCompanyidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("companyid not between ", value1, value2, "companyid");
            return (UserProfileViewCriteria) this;
        }
        
        public UserProfileViewCriteria andUsertypeIsNull() {
            addCriterion("usertype is null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUsertypeIsNotNull() {
            addCriterion("usertype is not null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUsertypeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("usertype =", value, "usertype");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUsertypeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("usertype <>", value, "usertype");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUsertypeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("usertype >", value, "usertype");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUsertypeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("usertype >=", value, "usertype");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUsertypeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("usertype <", value, "usertype");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUsertypeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("usertype <=", value, "usertype");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUsertypeLike(java.lang.String value) {
            if (value != null)
              addCriterion("usertype like ", value, "usertype");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUsertypeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("usertype not like ", value, "usertype");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUsertypeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("usertype in ", value, "usertype");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUsertypeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("usertype not in ", value, "usertype");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUsertypeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("usertype between ", value1, value2, "usertype");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUsertypeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("usertype not between ", value1, value2, "usertype");
            return (UserProfileViewCriteria) this;
        }
        
        public UserProfileViewCriteria andAvatarroleIsNull() {
            addCriterion("avatarrole is null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andAvatarroleIsNotNull() {
            addCriterion("avatarrole is not null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andAvatarroleEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("avatarrole =", value, "avatarrole");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andAvatarroleNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("avatarrole <>", value, "avatarrole");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andAvatarroleGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("avatarrole >", value, "avatarrole");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andAvatarroleGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("avatarrole >=", value, "avatarrole");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andAvatarroleLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("avatarrole <", value, "avatarrole");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andAvatarroleLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("avatarrole <=", value, "avatarrole");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andAvatarroleLike(java.lang.String value) {
            if (value != null)
              addCriterion("avatarrole like ", value, "avatarrole");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andAvatarroleNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("avatarrole not like ", value, "avatarrole");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andAvatarroleIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("avatarrole in ", value, "avatarrole");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andAvatarroleNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("avatarrole not in ", value, "avatarrole");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andAvatarroleBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("avatarrole between ", value1, value2, "avatarrole");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andAvatarroleNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("avatarrole not between ", value1, value2, "avatarrole");
            return (UserProfileViewCriteria) this;
        }
        
        public UserProfileViewCriteria andParentuseridIsNull() {
            addCriterion("parentuserid is null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andParentuseridIsNotNull() {
            addCriterion("parentuserid is not null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andParentuseridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("parentuserid =", value, "parentuserid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andParentuseridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("parentuserid <>", value, "parentuserid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andParentuseridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("parentuserid >", value, "parentuserid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andParentuseridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("parentuserid >=", value, "parentuserid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andParentuseridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("parentuserid <", value, "parentuserid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andParentuseridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("parentuserid <=", value, "parentuserid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andParentuseridLike(java.lang.String value) {
            if (value != null)
              addCriterion("parentuserid like ", value, "parentuserid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andParentuseridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("parentuserid not like ", value, "parentuserid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andParentuseridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("parentuserid in ", value, "parentuserid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andParentuseridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("parentuserid not in ", value, "parentuserid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andParentuseridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("parentuserid between ", value1, value2, "parentuserid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andParentuseridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("parentuserid not between ", value1, value2, "parentuserid");
            return (UserProfileViewCriteria) this;
        }
        
        public UserProfileViewCriteria andUserphotoIsNull() {
            addCriterion("userphoto is null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserphotoIsNotNull() {
            addCriterion("userphoto is not null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserphotoEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userphoto =", value, "userphoto");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserphotoNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userphoto <>", value, "userphoto");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserphotoGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("userphoto >", value, "userphoto");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserphotoGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userphoto >=", value, "userphoto");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserphotoLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("userphoto <", value, "userphoto");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserphotoLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userphoto <=", value, "userphoto");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserphotoLike(java.lang.String value) {
            if (value != null)
              addCriterion("userphoto like ", value, "userphoto");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserphotoNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("userphoto not like ", value, "userphoto");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserphotoIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("userphoto in ", value, "userphoto");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserphotoNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("userphoto not in ", value, "userphoto");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserphotoBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userphoto between ", value1, value2, "userphoto");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserphotoNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userphoto not between ", value1, value2, "userphoto");
            return (UserProfileViewCriteria) this;
        }
        
        public UserProfileViewCriteria andLastloginIsNull() {
            addCriterion("lastlogin is null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andLastloginIsNotNull() {
            addCriterion("lastlogin is not null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andLastloginEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("lastlogin =", value, "lastlogin");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andLastloginNotEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("lastlogin <>", value, "lastlogin");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andLastloginGreaterThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("lastlogin >", value, "lastlogin");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andLastloginGreaterThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("lastlogin >=", value, "lastlogin");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andLastloginLessThan(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("lastlogin <", value, "lastlogin");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andLastloginLessThanOrEqualTo(java.sql.Timestamp value) {
            if (value != null)
              addCriterion("lastlogin <=", value, "lastlogin");
            return (UserProfileViewCriteria) this;
        }

        
        public UserProfileViewCriteria andNumberofloginsIsNull() {
            addCriterion("numberoflogins is null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andNumberofloginsIsNotNull() {
            addCriterion("numberoflogins is not null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andNumberofloginsEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberoflogins =", value, "numberoflogins");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andNumberofloginsNotEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberoflogins <>", value, "numberoflogins");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andNumberofloginsGreaterThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberoflogins >", value, "numberoflogins");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andNumberofloginsGreaterThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberoflogins >=", value, "numberoflogins");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andNumberofloginsLessThan(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberoflogins <", value, "numberoflogins");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andNumberofloginsLessThanOrEqualTo(java.lang.Integer value) {
            if (value != null)
              addCriterion("numberoflogins <=", value, "numberoflogins");
            return (UserProfileViewCriteria) this;
        }

        
        public UserProfileViewCriteria andUserconsentIsNull() {
            addCriterion("userconsent is null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserconsentIsNotNull() {
            addCriterion("userconsent is not null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserconsentEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userconsent =", value, "userconsent");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserconsentNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userconsent <>", value, "userconsent");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserconsentGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("userconsent >", value, "userconsent");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserconsentGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userconsent >=", value, "userconsent");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserconsentLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("userconsent <", value, "userconsent");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserconsentLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("userconsent <=", value, "userconsent");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserconsentLike(java.lang.String value) {
            if (value != null)
              addCriterion("userconsent like ", value, "userconsent");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserconsentNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("userconsent not like ", value, "userconsent");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserconsentIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("userconsent in ", value, "userconsent");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserconsentNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("userconsent not in ", value, "userconsent");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserconsentBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userconsent between ", value1, value2, "userconsent");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andUserconsentNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("userconsent not between ", value1, value2, "userconsent");
            return (UserProfileViewCriteria) this;
        }
        
        public UserProfileViewCriteria andFbuseridIsNull() {
            addCriterion("fbuserid is null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFbuseridIsNotNull() {
            addCriterion("fbuserid is not null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFbuseridEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fbuserid =", value, "fbuserid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFbuseridNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fbuserid <>", value, "fbuserid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFbuseridGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("fbuserid >", value, "fbuserid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFbuseridGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fbuserid >=", value, "fbuserid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFbuseridLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("fbuserid <", value, "fbuserid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFbuseridLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("fbuserid <=", value, "fbuserid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFbuseridLike(java.lang.String value) {
            if (value != null)
              addCriterion("fbuserid like ", value, "fbuserid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFbuseridNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("fbuserid not like ", value, "fbuserid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFbuseridIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("fbuserid in ", value, "fbuserid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFbuseridNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("fbuserid not in ", value, "fbuserid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFbuseridBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("fbuserid between ", value1, value2, "fbuserid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFbuseridNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("fbuserid not between ", value1, value2, "fbuserid");
            return (UserProfileViewCriteria) this;
        }
        
        public UserProfileViewCriteria andRecstatusIsNull() {
            addCriterion("recstatus is null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRecstatusIsNotNull() {
            addCriterion("recstatus is not null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRecstatusEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus =", value, "recstatus");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRecstatusNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <>", value, "recstatus");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRecstatusGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >", value, "recstatus");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRecstatusGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus >=", value, "recstatus");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRecstatusLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <", value, "recstatus");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRecstatusLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus <=", value, "recstatus");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRecstatusLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus like ", value, "recstatus");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRecstatusNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("recstatus not like ", value, "recstatus");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRecstatusIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("recstatus in ", value, "recstatus");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRecstatusNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("recstatus not in ", value, "recstatus");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRecstatusBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus between ", value1, value2, "recstatus");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRecstatusNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("recstatus not between ", value1, value2, "recstatus");
            return (UserProfileViewCriteria) this;
        }
        
        public UserProfileViewCriteria andSiteIsNull() {
            addCriterion("site is null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andSiteEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site =", value, "site");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andSiteNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <>", value, "site");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andSiteGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("site >", value, "site");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andSiteGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site >=", value, "site");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andSiteLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("site <", value, "site");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andSiteLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("site <=", value, "site");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andSiteLike(java.lang.String value) {
            if (value != null)
              addCriterion("site like ", value, "site");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andSiteNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("site not like ", value, "site");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andSiteIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("site in ", value, "site");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andSiteNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("site not in ", value, "site");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andSiteBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site between ", value1, value2, "site");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andSiteNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("site not between ", value1, value2, "site");
            return (UserProfileViewCriteria) this;
        }
        
        public UserProfileViewCriteria andRoleidIsNull() {
            addCriterion("roleid is null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRoleidIsNotNull() {
            addCriterion("roleid is not null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRoleidEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("roleid =", value, "roleid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRoleidNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("roleid <>", value, "roleid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRoleidGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("roleid >", value, "roleid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRoleidGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("roleid >=", value, "roleid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRoleidLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("roleid <", value, "roleid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRoleidLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("roleid <=", value, "roleid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRoleidLike(java.lang.String value) {
            if (value != null)
              addCriterion("roleid like ", value, "roleid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRoleidNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("roleid not like ", value, "roleid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRoleidIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("roleid in ", value, "roleid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRoleidNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("roleid not in ", value, "roleid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRoleidBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("roleid between ", value1, value2, "roleid");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andRoleidNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("roleid not between ", value1, value2, "roleid");
            return (UserProfileViewCriteria) this;
        }
        
        public UserProfileViewCriteria andFunctioncodeIsNull() {
            addCriterion("functioncode is null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFunctioncodeIsNotNull() {
            addCriterion("functioncode is not null");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFunctioncodeEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("functioncode =", value, "functioncode");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFunctioncodeNotEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("functioncode <>", value, "functioncode");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFunctioncodeGreaterThan(java.lang.String value) {
            if (value != null)
              addCriterion("functioncode >", value, "functioncode");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFunctioncodeGreaterThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("functioncode >=", value, "functioncode");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFunctioncodeLessThan(java.lang.String value) {
            if (value != null)
              addCriterion("functioncode <", value, "functioncode");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFunctioncodeLessThanOrEqualTo(java.lang.String value) {
            if (value != null)
              addCriterion("functioncode <=", value, "functioncode");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFunctioncodeLike(java.lang.String value) {
            if (value != null)
              addCriterion("functioncode like ", value, "functioncode");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFunctioncodeNotLike(java.lang.String value) {
            if (value != null)
              addCriterion("functioncode not like ", value, "functioncode");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFunctioncodeIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
              addCriterion("functioncode in ", value, "functioncode");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFunctioncodeNotIn(java.util.List<java.lang.String> value) {
            if (value != null && value.size() > 0)
               addCriterion("functioncode not in ", value, "functioncode");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFunctioncodeBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("functioncode between ", value1, value2, "functioncode");
            return (UserProfileViewCriteria) this;
        }
        public UserProfileViewCriteria andFunctioncodeNotBetween(java.lang.String value1, java.lang.String value2) {
            if (value1 != null && value2 != null)
              addCriterion("functioncode not between ", value1, value2, "functioncode");
            return (UserProfileViewCriteria) this;
        }
    }
    
}

