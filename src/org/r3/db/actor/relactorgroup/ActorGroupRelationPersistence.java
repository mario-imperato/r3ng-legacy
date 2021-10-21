//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.actor.relactorgroup;

import java.util.List;

import org.r3.db.PersistenceConfigInfo;
import org.r3.db.actor.group.ActorGroupDTO.GroupNature;

public class ActorGroupRelationPersistence extends ActorGroupRelationPersistenceBase
{
	public static ActorGroupRelationPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg,
					org.apache.ibatis.session.SqlSession aSession)
	{
		ActorGroupRelationPersistence p = new ActorGroupRelationPersistence();
		p.setMapper(aSession.getMapper(ActorGroupRelationMapper.class));
		return p;
	}

	public ActorGroupRelationDataTableAdapter queryByEventidActorid(String requestSiteId, String actorId, PersistenceConfigInfo persistenceConfigInfo)
	{
		ActorGroupRelationFilter filter = new ActorGroupRelationFilter();
		filter.or().andEventidEqualTo(requestSiteId).andActoridEqualTo(actorId);
		
		ActorGroupRelationDataTableAdapter dt = this.query(filter, persistenceConfigInfo, "1", -1, -1, false);
		return dt;		
	}

	public String selectByEventidActoridAsCSV(String requestSiteId,
			String actorId, PersistenceConfigInfo persistenceConfigInfo)
	{
		String s = null;

		ActorGroupRelationFilter filter = new ActorGroupRelationFilter();
		filter.or()
		    .andEventidEqualTo(requestSiteId)
			.andActoridEqualTo(actorId);

		List<ActorGroupRelationDTO> l = this.select(filter, persistenceConfigInfo);
		if (l != null && l.size() > 0)
		{
			int numberOfItems = 0;
			
		    StringBuilder stb = new StringBuilder();	
		    for(ActorGroupRelationDTO agdto : l)
		    {		    		        	
	        	if (numberOfItems > 0)
	        		stb.append(',');
	        	
	        	numberOfItems++;
	        	stb.append(agdto.getGroupid());		    	
		    }
		    
		    s = stb.toString();
		}
			
		return s;
	}
	
	public int insertActorIntoGroup(String siteId, String groupId, String actorId, PersistenceConfigInfo persistenceConfigInfo)
	{
		ActorGroupRelationDTO dto = new ActorGroupRelationDTO();
		dto.setActorid(actorId);
		dto.setEventid(siteId);
		dto.setGroupid(groupId);
		
		return insert(dto, persistenceConfigInfo);
	}

	public int removeActorFromGroup(String siteId, String groupId, String actorId, PersistenceConfigInfo persistenceConfigInfo)
	{
		ActorGroupRelationFilter filter = new ActorGroupRelationFilter();
	    filter.or().andActoridEqualTo(actorId).andEventidEqualTo(siteId).andGroupidEqualTo(groupId);
		return delete(filter, persistenceConfigInfo);
	}

	public int removeActorFromGroupsOfNature(String siteId, String actorId, GroupNature aGroupNature, PersistenceConfigInfo persistenceConfigInfo)
	{
		ActorGroupRelationFilter filter = new ActorGroupRelationFilter();
	    filter.or().andActoridEqualTo(actorId).andEventidEqualTo(siteId).andGroupnatureEqualTo(aGroupNature);
		return delete(filter, persistenceConfigInfo);
	}

	public int removeActorFromGroupsOfType(String siteId, String actorId, String aGroupType, PersistenceConfigInfo persistenceConfigInfo)
	{
		ActorGroupRelationFilter filter = new ActorGroupRelationFilter();
	    filter.or().andActoridEqualTo(actorId).andEventidEqualTo(siteId).andGrouptypeEqualTo(aGroupType);
		return delete(filter, persistenceConfigInfo);
	}

	public int insertAllActorsIntoGroup(String requestSiteId, String groupid, PersistenceConfigInfo persistenceConfigInfo)
	{
		return this.mapper.insertAllActorsIntoGroup(requestSiteId, groupid, persistenceConfigInfo);
	}

	public int insertActorsIntoGroupFromGroup(String requestSiteId, String groupid, String createfromgroup,
					PersistenceConfigInfo persistenceConfigInfo)
	{
		return this.mapper.insertActorsIntoGroupFromGroup(requestSiteId, groupid, createfromgroup, persistenceConfigInfo);
	}

	public int deleteByEventidGroupid(String siteId, String groupId, PersistenceConfigInfo persistenceConfigInfo)
	{
		ActorGroupRelationFilter filter = new ActorGroupRelationFilter();
	    filter.or().andGroupidEqualTo(groupId).andEventidEqualTo(siteId);
		return delete(filter, persistenceConfigInfo);       		
	}

	public int deleteByEventidActorid(String siteId, String helmsmanid, PersistenceConfigInfo persistenceConfigInfo)
	{
		ActorGroupRelationFilter filter = new ActorGroupRelationFilter();
	    filter.or().andActoridEqualTo(helmsmanid).andEventidEqualTo(siteId);
		return delete(filter, persistenceConfigInfo);       				
	}

}
