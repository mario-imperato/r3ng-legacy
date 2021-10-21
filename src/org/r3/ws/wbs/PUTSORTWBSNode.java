package org.r3.ws.wbs;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.wbs.wbsnode.WBSNodeDTO;
import org.r3.db.wbs.wbsnode.WBSNodePersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTSORTWBSNode extends ServicePattern
{
    private String wbsId;
    private String nodeId;
    private String parentNodeId;
    private int    newPosition;
    private String prevSiblingId;
    
	public PUTSORTWBSNode(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aWbsId, String aParentNodeId, String aNodeId, int newNodePosition, String aPrevSiblingId)
	{
		super(ctx, serviceEnvironment);

		wbsId = aWbsId;
		nodeId = aNodeId;
		parentNodeId = aParentNodeId;
		newPosition = newNodePosition;
		prevSiblingId = aPrevSiblingId;
	}

	private static final int NODEORDER_SHIFT_AMOUNT = 5;
	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		WBSNodePersistence p = WBSNodePersistence.createPersistenceObject(pcfg, aSession);
		WBSNodeDTO nodeDto = p.selectByWbsnodeid(nodeId, pcfg.getPersistenceConfigInfo());
		if (nodeDto == null)
			return RestServiceDTO.FailDTO;
	
		String currentParentId = nodeDto.getNodeparentid();
		if (!currentParentId.equalsIgnoreCase(parentNodeId))
		{
			// Sto spostando e non solo muovendo.
			WBSNodeDTO parentNodeDto = p.selectByWbsnodeid(parentNodeId, pcfg.getPersistenceConfigInfo());
			if (parentNodeDto == null)
				return RestServiceDTO.FailDTO;
			
			p.changeNodeParent(nodeDto, parentNodeDto, pcfg.getPersistenceConfigInfo());
		}
		
		int newNodeOrder = NODEORDER_SHIFT_AMOUNT / 2;
		int shiftWhenNodeOrderGraterThan = 0;
		if (newPosition > 0 && prevSiblingId != null)
		{
			nodeDto = p.selectByWbsnodeid(prevSiblingId, pcfg.getPersistenceConfigInfo());
			if (nodeDto != null)
			{
				newNodeOrder = nodeDto.getNodeorder() + (NODEORDER_SHIFT_AMOUNT / 2);
				shiftWhenNodeOrderGraterThan = nodeDto.getNodeorder();
			}
		}

	    p.shiftChildrenNodes(parentNodeId, shiftWhenNodeOrderGraterThan, NODEORDER_SHIFT_AMOUNT, pcfg.getPersistenceConfigInfo());

		nodeDto = new WBSNodeDTO();
		nodeDto.setWbsnodeid(nodeId);
		nodeDto.setNodeorder(newNodeOrder);		
		p.updateByPrimaryKey(nodeDto, pcfg.getPersistenceConfigInfo());
		
		return nodeDto;
	}

}
