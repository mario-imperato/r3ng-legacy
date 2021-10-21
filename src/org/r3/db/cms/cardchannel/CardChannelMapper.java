//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardchannel;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CardChannelMapper{
    
  org.r3.db.cms.cardchannel.CardChannelDTO  selectByChannelidSiteCardid(
             @Param("channelid") java.lang.String channelid, @Param("site") java.lang.String site, @Param("cardid") java.lang.String cardid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int deleteByChannelidSiteCardid(
             @Param("channelid") java.lang.String channelid, @Param("site") java.lang.String site, @Param("cardid") java.lang.String cardid,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);            
  org.r3.db.cms.cardchannel.CardChannelDTO  selectByPrimaryKey(
            @Param("pk") org.r3.db.cms.cardchannel.CardChannelKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int  deleteByPrimaryKey(
            @Param("pk") org.r3.db.cms.cardchannel.CardChannelKey pk,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);

  List<org.r3.db.cms.cardchannel.CardChannelDTO> select(
            @Param("filter") org.r3.db.cms.cardchannel.CardChannelFilter filterCondition, 
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg,
            RowBounds aRowBounds);
            
  int count(@Param("filter") org.r3.db.cms.cardchannel.CardChannelFilter aFilterCondition,
            @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
            
  int delete(@Param("filter") org.r3.db.cms.cardchannel.CardChannelFilter aFilterCondition,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
             
  int insert(@Param("record") org.r3.db.cms.cardchannel.CardChannelDTO aRecord,
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);
               
  int update(@Param("record") org.r3.db.cms.cardchannel.CardChannelDTO aRecord, 
             @Param("filter") org.r3.db.cms.cardchannel.CardChannelFilter aFilterCondition,
             @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);
             
  int updateByPrimaryKey(
             @Param("record") org.r3.db.cms.cardchannel.CardChannelDTO aRecord, 
             @Param("pcfg")   org.r3.db.PersistenceConfigInfo pcfg);    


}
  
