package org.r3.ws.user.user;

import javax.ws.rs.QueryParam;

import org.r3.db.DTOBase;
import org.r3.db.system.user.user.UserCriteria;
import org.r3.db.system.user.user.UserDTO.UserType;
import org.r3.db.system.user.user.UserFilter;
import org.r3.db.utils.DataTableQueryActionForm;
import org.r3.db.utils.SQLStringUtils;
import org.r3.db.utils.SQLStringUtils.LikeMode;


public class UserQueryActionForm extends DataTableQueryActionForm
{
	@QueryParam("userid")
    private String userid;

    public String getUserid()
    {    	
    	return DTOBase.nullOnEmpty(userid);
    }

	@QueryParam("nickname")
    private String nickname;

    public String getNickname()
    {
    	String s = getsSearch();
    	if (s == null)
    		return DTOBase.nullOnEmpty(nickname);

    	return s;
    }

	@QueryParam("firstname")
    private String firstname;

    public String getFirstname()
    {    	
    	return DTOBase.nullOnEmpty(firstname);
    }

	@QueryParam("lastname")
    private String lastname;

    public String getLastname()
    {    	
    	return DTOBase.nullOnEmpty(lastname);
    }

	@QueryParam("email")
    private String email;

    public String getEmail()
    {    	
    	return DTOBase.nullOnEmpty(email);
    }

    @QueryParam("logincontact")
    private String logincontact;

    public String getLogincontact()
    {    	
    	return DTOBase.nullOnEmpty(logincontact);
    }    
    
    @QueryParam("hasrole")
    private String hasrole;

    public String getHasrole()
    {    	
    	return DTOBase.nullOnEmpty(hasrole);
    }    
    
	public String getUsertype()
	{
		return UserType.user.toString();
	}

	public UserFilter getSearchCondition(String targetSite)
	{
		UserFilter filter = new UserFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" nickname asc ");
		else filter.setOrderByClause(getSortingCondition());
		
		UserCriteria criteria = filter.or();
		if (getNickname() != null)
		{
			criteria.andNicknameLike(SQLStringUtils.getStringForLikeMode(getNickname(), LikeMode.FullLike));
		}

		if (getUserid() != null)
		{
			criteria.andUseridLike(SQLStringUtils.getStringForLikeMode(getUserid(), LikeMode.FullLike));
		}

		if (getFirstname() != null)
		{
			criteria.andFirstnameLike(SQLStringUtils.getStringForLikeMode(getFirstname(), LikeMode.FullLike));
		}

		if (getLastname() != null)
		{
			criteria.andLastnameLike(SQLStringUtils.getStringForLikeMode(getLastname(), LikeMode.FullLike));
		}

		if (getEmail() != null)
		{
			criteria.andEmailLike(SQLStringUtils.getStringForLikeMode(getEmail(), LikeMode.FullLike));
		}
		
        if (logincontact != null)
        {
        	 if (logincontact.equalsIgnoreCase("missing"))
        	 {
        		criteria.andHasNotLogincontact(targetSite); 
        	 }
        	 
        	 if (logincontact.equalsIgnoreCase("present"))
        	 {
        		criteria.andHasLogincontact(targetSite); 
        	 }
        }
			
        if (hasrole != null)
        {
        	criteria.andUserHasRole(targetSite, hasrole);
        }
        
		criteria.andUsertypeEqualTo(getUsertype());
		return filter;
	}
}
