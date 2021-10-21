//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.appcrewmember;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SailApplicationCrewMemberMapper{
    
  org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTO  selectByCrewmemberid(
            @Param("crewmemberid")   java.lang.String crewmemberid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
            
  int deleteByCrewmemberid(
            @Param("crewmemberid")   java.lang.String crewmemberid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
  org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTO> select(
            @Param("filter") org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTO aRecord, 
             @Param("filter") org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
