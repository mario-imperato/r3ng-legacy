//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.sailevent.application;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.r3.db.PersistenceConfigInfo;

public class SailApplicationPersistence extends SailApplicationPersistenceBase
{
	public static SailApplicationPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg,
					org.apache.ibatis.session.SqlSession aSession)
	{
		SailApplicationPersistence p = new SailApplicationPersistence();
		p.setMapper(aSession.getMapper(SailApplicationMapper.class));
		p.setSequencePersistence(pcfg.getSequencePersistence());
		return p;
	}

	public void clearReference2Document(String site, String applicationId, String documentId, PersistenceConfigInfo persistenceConfigInfo)
	{
	       SailApplicationFilter filter = new SailApplicationFilter();       
	       filter.or().andEventidEqualTo(site).andApplicationidEqualTo(applicationId).andBoatimageidEqualTo(documentId);

	       SailApplicationDTO applicationDTO = new SailApplicationDTO();
	       applicationDTO.clearBoatimagefields();
	       
	       this.update(applicationDTO, filter, persistenceConfigInfo);		
	}

	public Map<String, SailApplicationDTO> selectDTOsAsMapOfSailNumber(String eventId, PersistenceConfigInfo pcfg)
	{
		SailApplicationFilter filter = new SailApplicationFilter();
		filter.or().andEventidEqualTo(eventId);
		filter.setOrderByClause(" sailnumber ");
		List<SailApplicationDTO> listOfDTOs = select(filter, pcfg);
		
		HashMap<String, SailApplicationDTO> mapOfAppIds = null;
		if (listOfDTOs != null)
		{
			mapOfAppIds = new HashMap<String, SailApplicationDTO>();
			
			for(SailApplicationDTO dto : listOfDTOs)
			{
				mapOfAppIds.put(dto.getSailnumber(), dto);
			}
		}
		
		return mapOfAppIds;
	}
		
}
