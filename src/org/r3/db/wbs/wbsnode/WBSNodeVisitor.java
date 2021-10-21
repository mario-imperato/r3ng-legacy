package org.r3.db.wbs.wbsnode;

public interface WBSNodeVisitor
{
	public enum VisitType { anticipata, posticipata };
	
    boolean visit(WBSNodeDTO aParentNode, WBSNodeDTO aNode, int childPosition);
}
