//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.wbs.wbsnode;

import java.util.List;

import org.r3.db.CountByDTO;
import org.r3.db.PersistenceConfigInfo;
import org.r3.db.utils.SQLStringUtils;
import org.r3.db.utils.SQLStringUtils.LikeMode;

public class WBSNodePersistence extends WBSNodePersistenceBase
{
	public static WBSNodePersistence createPersistenceObject(
			org.r3.db.PersistenceContext pcfg,
			org.apache.ibatis.session.SqlSession aSession)
	{
		WBSNodePersistence p = new WBSNodePersistence();
		p.setMapper(aSession.getMapper(WBSNodeMapper.class));
		p.setSequencePersistence(pcfg.getSequencePersistence());
		return p;
	}

	public CountByDTO countChildren(String aNodeId, PersistenceConfigInfo pcfg)
	{
		WBSNodeFilter filter = new WBSNodeFilter();
		filter.or().andNodeparentidEqualTo(aNodeId);

		CountByDTO c = this.mapper.countChildren(filter, pcfg);
		return c;
	}

	@Override
	public int deleteByWbsnodeid(java.lang.String wbsnodeid, org.r3.db.PersistenceConfigInfo pcfg)
	{		
		int numberOfRowsAffected = deleteByPath(wbsnodeid, pcfg);
		numberOfRowsAffected += super.deleteByWbsnodeid(wbsnodeid, pcfg);
		return numberOfRowsAffected;
	}
	
	public int deleteByPath(java.lang.String wbsnodeid, org.r3.db.PersistenceConfigInfo pcfg)
	{		
		WBSNodeFilter filter = new WBSNodeFilter();
		filter.or().andNodepathLike(SQLStringUtils.getStringForLikeMode(wbsnodeid, LikeMode.FullLike));

		int numberOfRowsAffected = super.delete(filter, pcfg);
		return numberOfRowsAffected;
	}
	
	public int shiftChildrenNodes(String aParentNodeId, int whereNodeOrderGreaterThan, int shiftAmount, org.r3.db.PersistenceConfigInfo pcfg)
	{
		WBSNodeFilter filter = new WBSNodeFilter();
		filter.or().andNodeparentidEqualTo(aParentNodeId).andNodeorderGreaterThan(whereNodeOrderGreaterThan);

		int numberOfRowsAffected = this.mapper.shiftChildrenNodes(filter, shiftAmount, pcfg);
		return numberOfRowsAffected;		
	}

	public void changeNodeParent(WBSNodeDTO nodeDto, WBSNodeDTO newParentNodeDto, PersistenceConfigInfo persistenceConfigInfo)
	{
		StringBuilder stb = new StringBuilder();
		stb.append(nodeDto.getNodepath()).append(nodeDto.getWbsnodeid()).append('.');		
		String childrenPathPrefix = stb.toString();

		stb = new StringBuilder();
		stb.append(newParentNodeDto.getNodepath()).append(newParentNodeDto.getWbsnodeid()).append('.');		
		String nodeNewPath = stb.toString();
		
		stb = new StringBuilder();
		stb.append(nodeNewPath).append(nodeDto.getWbsnodeid()).append('.');		
		String newChildrenPathPrefix = stb.toString();
				
		WBSNodeFilter filter = new WBSNodeFilter();
		filter.or().andNodepathLike(SQLStringUtils.getStringForLikeMode(childrenPathPrefix, LikeMode.RightLike));
		this.mapper.updateChildrenPath(filter, childrenPathPrefix, childrenPathPrefix.length(), newChildrenPathPrefix, newChildrenPathPrefix.length(), persistenceConfigInfo);
		
		filter = new WBSNodeFilter();
		filter.or().andWbsnodeidEqualTo(nodeDto.getWbsnodeid());
		nodeDto.setNodeparentid(newParentNodeDto.getWbsnodeid());		
		nodeDto.setNodepath(nodeNewPath);		
		updateByPrimaryKey(nodeDto, persistenceConfigInfo);
	}
	
	public List<WBSNodeDTO> selectBySiteWbsid(String aSite, String aWbsId, PersistenceConfigInfo persistenceConfigInfo)
	{
		WBSNodeFilter f = new WBSNodeFilter();
		f.or().andSiteEqualTo(aSite).andWbsidEqualTo(aWbsId);
		f.setOrderByClause(" nodepath, nodeorder " );
		
		List<WBSNodeDTO> l = select(f, persistenceConfigInfo);
		return l;
	}
}
