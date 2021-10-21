//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.system.queues.queuework;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface QueueWorkMapper
{

	org.r3.db.system.queues.queuework.QueueWorkDTO selectByQueueworkid(@Param("queueworkid") java.lang.String queueworkid,
					@Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);

	int deleteByQueueworkid(@Param("queueworkid") java.lang.String queueworkid, @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);

	org.r3.db.system.queues.queuework.QueueWorkDTO selectByPrimaryKey(@Param("pk") org.r3.db.system.queues.queuework.QueueWorkKey pk,
					@Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);

	int deleteByPrimaryKey(@Param("pk") org.r3.db.system.queues.queuework.QueueWorkKey pk,
					@Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);

	List<org.r3.db.system.queues.queuework.QueueWorkDTO> select(
					@Param("filter") org.r3.db.system.queues.queuework.QueueWorkFilter filterCondition,
					@Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg, RowBounds aRowBounds);

	int count(@Param("filter") org.r3.db.system.queues.queuework.QueueWorkFilter aFilterCondition,
					@Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);

	int delete(@Param("filter") org.r3.db.system.queues.queuework.QueueWorkFilter aFilterCondition,
					@Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);

	int insert(@Param("record") org.r3.db.system.queues.queuework.QueueWorkDTO aRecord, @Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);

	int update(@Param("record") org.r3.db.system.queues.queuework.QueueWorkDTO aRecord,
					@Param("filter") org.r3.db.system.queues.queuework.QueueWorkFilter aFilterCondition,
					@Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);

	int updateByPrimaryKey(@Param("record") org.r3.db.system.queues.queuework.QueueWorkDTO aRecord,
					@Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);

	List<org.r3.db.CountByDTO> countByRefEntityId(@Param("filter") QueueWorkFilter aFilterCondition,
					@Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);

	List<org.r3.db.CountByDTO> countByRefAmbitId(@Param("filter") QueueWorkFilter aFilterCondition,
					@Param("pcfg") org.r3.db.PersistenceConfigInfo pcfg);

}
