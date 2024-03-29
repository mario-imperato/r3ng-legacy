//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.wbs.wbs;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.r3.db.wbs.wbsactor.WBSActorDTO;
import org.r3.db.wbs.wbsnode.WBSNodeDTO;

public class WBSDTO extends WBSDTOBase
{
	public enum WBSOptions {
	       wbs_none, wbs_notify;
	       
	       public static WBSOptions getValue(String s, WBSOptions defaultResult)
			{
	    	   WBSOptions pv = defaultResult;
				if (s != null && s.length() > 0)
					pv = WBSOptions.valueOf(s);
				
				return pv;
			}
	}
	
	private WBSNodeDTO rootNode;
	
    public WBSDTO()
    {
        super();
    }

    public WBSDTO(WBSDTO another)
    {
        super(another);
    }

    @Override
    public String getDtokey()
    {
        StringBuilder stb = new StringBuilder(); 
        stb.append(site).append('_');
        stb.append(wbsid);
        return stb.toString();
    }
    
    public WBSNodeDTO buildTree(List<WBSNodeDTO> aListOfNodes)
    {
    	if (aListOfNodes == null || aListOfNodes.size() == 0)
    		return null;

    	ListIterator<WBSNodeDTO> iter = aListOfNodes.listIterator();

    	WBSNodeDTO rootNode = iter.next();
    	if (!rootNode.isRoot())
    	{   		
    		return null;
    	}    	    	
    	
    	Map<String, WBSNodeDTO> mapOfNodes = new HashMap<String, WBSNodeDTO>();
    	mapOfNodes.put(rootNode.getWbsnodeid(), rootNode);
    	
    	for( ; iter.hasNext(); )
    	{
    		WBSNodeDTO dto = iter.next();
    		
    		// Azzero i flag di modifica sui singoli campi. In questo modo sono in grado di identificare cambiamenti intervenuti sul nodo
    		// In questo caso i cambiamenti sono legati al metodo addChild che forza il nodesect al valore della label.
    		dto.clearDirtyFlags();
    		
    		// Il parentId deve essere valorizzato in quanto ho gi� eliminato la root.
    		String parentId = dto.getNodeparentid();
    		
    		// Il nodo parent deve essere gi� nella mappa in quanto per ordinamento lo vedo prima dei figli.
    		mapOfNodes.get(parentId).addChild(dto);
    		
    		// Inserisco il nodo nella mappa in meniare da trovarlo quando viene richiesto.
    		mapOfNodes.put(dto.getWbsnodeid(), dto);
    	}
    	
    	return rootNode;    	
    }
    

//    Il metodo ' commentato in quanto presupppone un ordinamento che al momento non penso si possa fare.     
//    public WBSNodeDTO visitNodes(WBSNodeDTO aNode, ListIterator<WBSNodeDTO> aListOfNodes)
//    {
//    	int currentNodeDepth = aNode.getNodeDepth();
//    	
//    	for( ; aListOfNodes.hasNext(); )
//    	{
//    		WBSNodeDTO dto = aListOfNodes.next();
//    		
//    		int d = dto.getNodeDepth();
//    		while(d == (currentNodeDepth + 1))
//    		{
//    			aNode.addChild(dto);
//    			dto = visitNodes(dto, aListOfNodes);
//    			if (dto != null)
//    				  d = dto.getNodeDepth();
//    			else  d = -1;
//    		}
//    		
//    		return dto;
//    	}
//    	
//    	return null;
//    }

	public void setRootnode(WBSNodeDTO aRootNode)
	{
		rootNode = aRootNode;		
	}

	public WBSNodeDTO getRootnode()
	{
		return rootNode;
	}
	
	public String getBusinesskey()
	{
		return wbsid;
	}
	
	private List<WBSActorDTO> actors;

	public List<WBSActorDTO> getActors()
	{
		return actors;
	}

	public void setActors(List<WBSActorDTO> properties)
	{
		this.actors = properties;
	}
    
}
