package org.r3.ws.actors.actorgroup;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.QueryParam;

import org.r3.db.DTOBase;
import org.r3.db.actor.group.ActorGroupCriteria;
import org.r3.db.actor.group.ActorGroupFilter;
import org.r3.db.system.user.user.UserFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class ActorGroupQueryActionForm extends DataTableQueryActionForm
{
	@QueryParam("groupnature")
    private String groupnature;

    public String getGroupnature()
    {    	
    	return DTOBase.nullOnEmpty(groupnature);
    }

    public boolean isGroupnatureMultiple()
    {
    	String s = getGroupnature();
        return 	s != null && s.indexOf(',') >= 0;
    }
    
    public List<String> getGroupNatureAsList()
    {
    	List<String> res = null;
    	
    	String s = getGroupnature();
    	if (s != null && s.indexOf(',') >= 0)
    	{
    		String[] sarr = s.split(",");
    		res = new ArrayList<String>();
    		for(String s1: sarr)
    		{
    			res.add(s1);
    		}
    	}
    	
    	return res;
    }
    
	public ActorGroupFilter getSearchCondition(String aRequestSite)
	{
		ActorGroupFilter filter = new ActorGroupFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" grouporder, grouptitle asc ");
		else filter.setOrderByClause(getSortingCondition());
		
		ActorGroupCriteria criteria = filter.or().andEventidEqualTo(aRequestSite);	
		
		String gn = getGroupnature();
		if (gn != null)
		{
			if (isGroupnatureMultiple())
			{
				criteria.andGroupnatureIn(getGroupNatureAsList());
			}
			else criteria.andGroupnatureEqualTo(getGroupnature());
		}
		
		return filter;
	}

	public UserFilter getSearchCondition4UsersInGroup(String aSite,
			String aGroupid)
	{
		UserFilter f = new UserFilter();
		f.or().andUserInActorGroup(aSite, aGroupid);
		return f;
	}
}
