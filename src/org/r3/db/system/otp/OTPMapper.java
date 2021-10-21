//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.otp;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface OTPMapper{
    
  org.r3.db.system.otp.OTPDTO  selectByDigest(
            @Param("digest")   java.lang.String digest,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
            
  int deleteByDigest(
            @Param("digest")   java.lang.String digest,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
  org.r3.db.system.otp.OTPDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.system.otp.OTPKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.system.otp.OTPKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.system.otp.OTPDTO> select(
            @Param("filter") org.r3.db.system.otp.OTPFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.system.otp.OTPFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.system.otp.OTPFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.system.otp.OTPDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.system.otp.OTPDTO aRecord, 
             @Param("filter") org.r3.db.system.otp.OTPFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.system.otp.OTPDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
