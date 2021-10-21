//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.teammemberprofile;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TeamMemberProfileMapper{
    
  org.r3.db.project.teammemberprofile.TeamMemberProfileDTO  selectByProfileid(
            @Param("profileid")   java.lang.String profileid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
            
  int deleteByProfileid(
            @Param("profileid")   java.lang.String profileid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);             
  org.r3.db.project.teammemberprofile.TeamMemberProfileDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.project.teammemberprofile.TeamMemberProfileKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.project.teammemberprofile.TeamMemberProfileKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.project.teammemberprofile.TeamMemberProfileDTO> select(
            @Param("filter") org.r3.db.project.teammemberprofile.TeamMemberProfileFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.project.teammemberprofile.TeamMemberProfileFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.project.teammemberprofile.TeamMemberProfileFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.project.teammemberprofile.TeamMemberProfileDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.project.teammemberprofile.TeamMemberProfileDTO aRecord, 
             @Param("filter") org.r3.db.project.teammemberprofile.TeamMemberProfileFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.project.teammemberprofile.TeamMemberProfileDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
