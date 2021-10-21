//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.fivmember;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FIVMemberMapper{
    
  org.r3.db.sailevent.fivmember.FIVMemberDTO  selectByCardnumber(
            @Param("cardnumber")   java.lang.String cardnumber,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
            
  int deleteByCardnumber(
            @Param("cardnumber")   java.lang.String cardnumber,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
  org.r3.db.sailevent.fivmember.FIVMemberDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.sailevent.fivmember.FIVMemberKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.sailevent.fivmember.FIVMemberKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.sailevent.fivmember.FIVMemberDTO> select(
            @Param("filter") org.r3.db.sailevent.fivmember.FIVMemberFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.sailevent.fivmember.FIVMemberFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.sailevent.fivmember.FIVMemberFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.sailevent.fivmember.FIVMemberDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.sailevent.fivmember.FIVMemberDTO aRecord, 
             @Param("filter") org.r3.db.sailevent.fivmember.FIVMemberFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.sailevent.fivmember.FIVMemberDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
