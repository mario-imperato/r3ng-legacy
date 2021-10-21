//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.wbs.wbsnode;

import java.util.ArrayList;
import java.util.List;

import org.r3.db.wbs.wbsnode.WBSNodeVisitor.VisitType;

public class WBSNodeDTO extends WBSNodeDTOBase
{
	public enum NodeType
	{

		root, node, action, towgroup, tow;

		public static NodeType getValue4(String s, NodeType defaultNodeType)
		{
			if (s != null && s.length() > 0)
			{
				return NodeType.valueOf(s);
			}

			return defaultNodeType;
		}
	};

	public enum ActionCompletionType
	{

		percentage, int_pos_range;

		public static ActionCompletionType getValue4(String s, ActionCompletionType completionType)
		{
			if (s != null && s.length() > 0)
			{
				return ActionCompletionType.valueOf(s);
			}

			return completionType;
		}
	};

	public enum CompletionStatus
	{

		empty, partial, completed;

		public static CompletionStatus getValue4(String s, CompletionStatus completionStatus)
		{
			if (s != null && s.length() > 0)
			{
				return CompletionStatus.valueOf(s);
			}

			return completionStatus;
		}
	};

	public WBSNodeDTO()
	{
		super();
	}

	public WBSNodeDTO(WBSNodeDTO another)
	{
		super(another);
	}

	private List<WBSNodeDTO> children;

	public void addChild(WBSNodeDTO aChildNode)
	{
		if (children == null)
			children = new ArrayList<WBSNodeDTO>();

		StringBuilder sectNumber = new StringBuilder();
		if (getNodesect() != null)
			sectNumber.append(getNodesect());

		sectNumber.append(String.format("%02d", children.size() + 1)).append('.');
		aChildNode.setNodesect(sectNumber.toString());

		children.add(aChildNode);
	}

	public List<WBSNodeDTO> getChildren()
	{
		return children;
	}

	public boolean visit(WBSNodeVisitor aVisitor, VisitType aVisitType)
	{
		return visit(aVisitor, aVisitType, null, 0);
	}

	public boolean visit(WBSNodeVisitor aVisitor, VisitType aVisitType, WBSNodeDTO aParentNode, int indexOfChild)
	{
		boolean keepVisiting = true;

		if (keepVisiting && aVisitType == VisitType.anticipata)
		{
			keepVisiting = aVisitor.visit(aParentNode, this, indexOfChild);
		}

		if (keepVisiting && children != null && children.size() > 0)
		{
			for (int i = 0; i < children.size(); i++)
			{
				keepVisiting = aVisitor.visit(this, children.get(i), i);
				if (!keepVisiting)
					break;
			}
		}

		if (keepVisiting && aVisitType == VisitType.posticipata)
		{
			keepVisiting = aVisitor.visit(aParentNode, this, indexOfChild);
		}

		return keepVisiting;
	}

	@com.fasterxml.jackson.annotation.JsonIgnore
	@javax.xml.bind.annotation.XmlTransient
	public int getNodeDepth()
	{
		if (nodepath == null)
			return -1;

		// Tolgo il punto iniziale e considero l'id da 15 e il punto finale.
		return (nodepath.length() - 1) / 16;
	}

	@com.fasterxml.jackson.annotation.JsonIgnore
	@javax.xml.bind.annotation.XmlTransient
	public boolean isRoot()
	{
		return NodeType.getValue4(getNodetype(), NodeType.node) == NodeType.root;
	}

	@com.fasterxml.jackson.annotation.JsonIgnore
	@javax.xml.bind.annotation.XmlTransient
	public boolean isAction()
	{
		return NodeType.getValue4(nodetype, null) == NodeType.action;
	}

	@com.fasterxml.jackson.annotation.JsonIgnore
	@javax.xml.bind.annotation.XmlTransient
	public boolean isTowgroup()
	{
		return NodeType.getValue4(nodetype, null) == NodeType.towgroup;
	}

	@com.fasterxml.jackson.annotation.JsonIgnore
	@javax.xml.bind.annotation.XmlTransient
	public boolean isTow()
	{
		return NodeType.getValue4(nodetype, null) == NodeType.tow;
	}

	@com.fasterxml.jackson.annotation.JsonIgnore
	@javax.xml.bind.annotation.XmlTransient
	public int getCompletiontoAsInt()
	{
		Float f = getCompletionto();
		if (f != null)
		{
			return f.intValue();
		}

		return 0;
	}
	
	// Questo metodo ha lo scopo di propagare la dirtiness del campo in un caso specifico: quando ho ricostruito l'albero
	// serverside: GET_WBSTree. In questo caso infatti i flags di dirtiness sono azzerati e viene aggiornato il nodesect.
	public boolean getNodesectdirtiness()
	{
		return isNodesectDirty();
	}
}
