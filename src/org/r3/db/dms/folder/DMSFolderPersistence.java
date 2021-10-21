//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.folder;


import java.util.List;

import org.r3.db.PersistenceConfigInfo;
import org.r3.db.dms.folder.DMSFolderDTO.FolderStatus;

public class DMSFolderPersistence extends DMSFolderPersistenceBase
{
  public static DMSFolderPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  DMSFolderPersistence p = new DMSFolderPersistence();
	    p.setMapper(aSession.getMapper(DMSFolderMapper.class));
	    p.setSequencePersistence(pcfg.getSequencePersistence());
	    return p;
  }    

	public int numberOfFoldersBoundToDevice(String deviceid, PersistenceConfigInfo persistenceContext)
	{
      DMSFolderFilter filter = new DMSFolderFilter();
      filter.or().andDeviceidEqualTo(deviceid);
      
      int rc = count(filter, persistenceContext);
		return rc;
	}

	public boolean hasChildren(String upperCase, int i, PersistenceConfigInfo persistenceContext)
	{
		DMSFolderFilter filter = new DMSFolderFilter();
		filter.or().andFolderlogicalpathLike(upperCase + "%").andFolderdepthEqualTo(i);
      
		int rc = count(filter, persistenceContext);
		return rc > 0;
	}

	public void markFolderEnabledByFolderlogicalpath(DMSFolderDTO dmsFolder, String upperCase, PersistenceConfigInfo persistenceContext)
	{
		DMSFolderFilter filter = new DMSFolderFilter();
		filter.or().andFolderlogicalpathLike(upperCase + "%");
		
		update(dmsFolder, filter, persistenceContext);		
	}

	public DMSFolderDTO selectByFolderlogicalpath(String upperCase, PersistenceConfigInfo persistenceContext)
	{
		DMSFolderFilter filter = new DMSFolderFilter();
		filter.or().andFolderlogicalpathLike(upperCase);
		
		List<DMSFolderDTO> l = select(filter, persistenceContext);
		if (l != null && l.size() > 0)
			return l.get(0);
		
		return null;
	}

	public List<DMSFolderDTO> selectHierarchy(String path, boolean parentFirstFlag, PersistenceConfigInfo persistenceContext)
	{
		return selectHierarchy(path, (parentFirstFlag) ? "FOLDERDEPTH ASC" : "FOLDERDEPTH DESC", persistenceContext);
	}

	public List<DMSFolderDTO> selectHierarchy(String aFolderlogicalpath, String childrenOrdering, PersistenceConfigInfo pcfg)
  {
		return selectChildren(aFolderlogicalpath, -1, childrenOrdering, pcfg);
  }
	
  public List<DMSFolderDTO> selectChildren(String aFolderlogicalpath, int childrenDepth, PersistenceConfigInfo pcfg)
  {
      return selectChildren(aFolderlogicalpath, childrenDepth, "FOLDERLOGICALPATH ASC", pcfg);
  }


  /**
   * Il parametro childrenDepth puo' valere un valore positivo e allora vengono considerati solo i figli
   * a quel livello, oppure un valore negativo o nullo, in questo caso vengono ritornati tutti i figli della gerarchia.
   * E' previsto un parametro di ordering.
   * 
   */
  public List<DMSFolderDTO> selectChildren(
          String aFolderlogicalpath, int childrenDepth, String ordering, PersistenceConfigInfo pcfg) 
  {    	
      // In caso di childrenDepth non specificata, la condizione di interrogazione mi acchiappa la
      // gerarchia con l'inclusione del nodo. Questo escamotage dovrebbe eliminare automaticamente il nodo.
      if (!aFolderlogicalpath.endsWith("/"))
      {
          aFolderlogicalpath = aFolderlogicalpath + "/%";     
      }
      else aFolderlogicalpath = aFolderlogicalpath + "%";     
   
  	DMSFolderFilter filter = new DMSFolderFilter();
      DMSFolderCriteria criteria = filter.or();
      
      criteria.andFolderstatusEqualTo(FolderStatus.sys_recact.toString());
      criteria.andFolderlogicalpathLike(aFolderlogicalpath);
             
      if (childrenDepth >= 0)
      	criteria.andFolderdepthEqualTo(childrenDepth);

      if (ordering != null)
          filter.setOrderByClause(ordering);
              
      return select(filter, pcfg);
  }

}
  
