//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.devicealias;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface DMSDeviceAliasMapper{
    
  org.r3.db.dms.devicealias.DMSDeviceAliasDTO  selectByDeviceidClientid(
             @Param("deviceid") java.lang.String deviceid, @Param("clientid") java.lang.String clientid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int deleteByDeviceidClientid(
             @Param("deviceid") java.lang.String deviceid, @Param("clientid") java.lang.String clientid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);            
  org.r3.db.dms.devicealias.DMSDeviceAliasDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.dms.devicealias.DMSDeviceAliasKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.dms.devicealias.DMSDeviceAliasKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.dms.devicealias.DMSDeviceAliasDTO> select(
            @Param("filter") org.r3.db.dms.devicealias.DMSDeviceAliasFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.dms.devicealias.DMSDeviceAliasFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.dms.devicealias.DMSDeviceAliasFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.dms.devicealias.DMSDeviceAliasDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.dms.devicealias.DMSDeviceAliasDTO aRecord, 
             @Param("filter") org.r3.db.dms.devicealias.DMSDeviceAliasFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.dms.devicealias.DMSDeviceAliasDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
