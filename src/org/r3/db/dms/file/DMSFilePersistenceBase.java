//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//



package org.r3.db.dms.file;


import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class DMSFilePersistenceBase
{
  protected DMSFileMapper mapper;
  
  public void setMapper(DMSFileMapper aMapper)
  {
     this.mapper = aMapper;
  }


  protected org.r3.db.system.sequence.SequencePersistence  sequencePersistence;    
  
  public void setSequencePersistence(org.r3.db.system.sequence.SequencePersistence aSequencePersistence)
  {
      this.sequencePersistence = aSequencePersistence;
  }
   
  public String getFileid_sequence(org.r3.db.PersistenceConfigInfo pcfg)
  {
     String seqId = null;
     seqId = sequencePersistence.getSequence("DFL", pcfg.getSequenceSubPrefix());
     return seqId;
  }
  
  
  public DMSFilePersistenceBase ()
  {
  
  }
      
  public org.r3.db.dms.file.DMSFileDTO  selectByFileid(
         java.lang.String fileid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.dms.file.DMSFileDTO dto = this.mapper.selectByFileid(fileid, pcfg);
      return dto;
  }

  public int deleteByFileid(java.lang.String fileid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteByFileid(fileid, pcfg);
      return numberOfRowsAffected;
  }  
  public org.r3.db.dms.file.DMSFileDTO  selectByPrimaryKey(org.r3.db.dms.file.DMSFileKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      org.r3.db.dms.file.DMSFileDTO dto = this.mapper.selectByPrimaryKey(pk, pcfg);
      return dto;
  }
  
  public int  deleteByPrimaryKey(org.r3.db.dms.file.DMSFileKey pk, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.deleteByPrimaryKey(pk, pcfg);
      return numberOfRowsAffected;  
  }  

  public org.r3.db.dms.file.DMSFileDTO selectFirst(org.r3.db.dms.file.DMSFileFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {   
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.dms.file.DMSFileFilter();
      }
      filterCondition.setLimitFetch(1);

      List<org.r3.db.dms.file.DMSFileDTO> l = select(filterCondition, pcfg, new RowBounds(0, 1));
      if (l != null && l.size() > 0)
     			return l.get(0);
     			
      return null;
  }

  public List<org.r3.db.dms.file.DMSFileDTO> select(org.r3.db.dms.file.DMSFileFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {      
      return select(filterCondition, pcfg, null);
  }

  public List<org.r3.db.dms.file.DMSFileDTO> select(org.r3.db.dms.file.DMSFileFilter filterCondition, org.r3.db.PersistenceConfigInfo pcfg, RowBounds aRowBounds)
  {      
      if (filterCondition == null)
      {
         filterCondition = new org.r3.db.dms.file.DMSFileFilter();
      }
            
      if (aRowBounds == null)
         aRowBounds = new RowBounds();
      else
      {      
    	   if (aRowBounds.getLimit() < RowBounds.NO_ROW_LIMIT)
              filterCondition.setLimitFetch(aRowBounds.getOffset() + aRowBounds.getLimit());
      }
                        
      List<org.r3.db.dms.file.DMSFileDTO> listOfDTOs = this.mapper.select(filterCondition, pcfg, aRowBounds);
      return listOfDTOs;
  }
  
  public int count(org.r3.db.dms.file.DMSFileFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.count(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public org.r3.db.dms.file.DMSFileDataTableAdapter query(
      org.r3.db.dms.file.DMSFileFilter aFilterCondition, 
      org.r3.db.PersistenceConfigInfo pcfg, 
      String sEcho, 
      int iDisplayStart, 
      int iDisplayLength,
      boolean countElements)
  {  
    	int numberOfItems = (countElements) ? count(aFilterCondition, pcfg) : -1;    	
    	List<org.r3.db.dms.file.DMSFileDTO> l = null;
    	if (numberOfItems != 0)
    	{
    	RowBounds rb = new RowBounds(
    					(iDisplayStart >= 0)  ? iDisplayStart : RowBounds.NO_ROW_OFFSET, 
    			    (iDisplayLength > 0) ? iDisplayLength : RowBounds.NO_ROW_LIMIT);
    	
		  l = select(aFilterCondition, pcfg, rb);
      }

		  org.r3.db.dms.file.DMSFileDataTableAdapter dt = new org.r3.db.dms.file.DMSFileDataTableAdapter();
		  dt.setsEcho(sEcho);
		  dt.setiTotalRecords(numberOfItems);
		  dt.setiTotalDisplayRecords(numberOfItems);
		  dt.setAaData(l);
		
		  return dt;
  }  
  
  public int delete(org.r3.db.dms.file.DMSFileFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.delete(aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }

  public int insert(org.r3.db.dms.file.DMSFileDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      String seqId = null;
      if (aRecord.getFileid() == null)
      {     
        seqId = getFileid_sequence(pcfg);
        aRecord.setFileid(seqId);
      }      

      int numberOfRowsAffected = this.mapper.insert(aRecord, pcfg);
      return numberOfRowsAffected;  
  }

  public int update(org.r3.db.dms.file.DMSFileDTO aRecord, org.r3.db.dms.file.DMSFileFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.update(aRecord, aFilterCondition, pcfg);
      return numberOfRowsAffected;  
  }
  
  public int updateByPrimaryKey(org.r3.db.dms.file.DMSFileDTO aRecord, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfRowsAffected = this.mapper.updateByPrimaryKey(aRecord, pcfg);
      return numberOfRowsAffected;  
  }

  public byte[] selectFilebodyByPrimaryKey(org.r3.db.dms.file.DMSFileKey aPk, org.r3.db.PersistenceConfigInfo pcfg)
  {
	 byte[] aBlob = this.mapper.selectFilebodyByPrimaryKey(aPk, pcfg);
     return aBlob;
  }
  
  public byte[] selectFilebodyByFileid( java.lang.String fileid, org.r3.db.PersistenceConfigInfo pcfg)
  {
	 byte[] aBlob = this.mapper.selectFilebodyByFileid( fileid, pcfg);
     return aBlob;
  }
  
  public int storeFilebodyByFileid(byte[] filebody, java.lang.String fileid, org.r3.db.PersistenceConfigInfo pcfg)
  {
      int numberOfByteStored = this.mapper.storeFilebodyByFileid(filebody, fileid, pcfg);
      return numberOfByteStored;  
  }

}
  
