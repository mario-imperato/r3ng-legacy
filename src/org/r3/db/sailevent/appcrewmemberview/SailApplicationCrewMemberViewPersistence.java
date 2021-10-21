//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.sailevent.appcrewmemberview;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.PersistenceConfigInfo;

public class SailApplicationCrewMemberViewPersistence extends
		SailApplicationCrewMemberViewPersistenceBase
{
	public static SailApplicationCrewMemberViewPersistence createPersistenceObject(
			org.r3.db.PersistenceContext pcfg,
			org.apache.ibatis.session.SqlSession aSession)
	{
		SailApplicationCrewMemberViewPersistence p = new SailApplicationCrewMemberViewPersistence();
		p.setMapper(aSession
				.getMapper(SailApplicationCrewMemberViewMapper.class));
		return p;
	}

	public List<SailApplicationCrewMemberViewDTO> selectByEventidApplicationid(String eventId, String applicationId, PersistenceConfigInfo persistenceConfigInfo)
	{
		SailApplicationCrewMemberViewFilter filter = new SailApplicationCrewMemberViewFilter();
		filter.or().andApplicationidEqualTo(applicationId).andEventidEqualTo(eventId);
		return select(filter, persistenceConfigInfo);
	}
	
	public org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewSummaryDataTableAdapter selectCrewReport(
			String anEventId, org.r3.db.PersistenceConfigInfo pcfg)
	{
		org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewFilter filterCondition = new SailApplicationCrewMemberViewFilter();
		filterCondition.or().andEventidEqualTo(anEventId);
		filterCondition.setOrderByClause("yachtname asc, applicationid");
		List<org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewSummaryDTO> listOfDTOs = this.mapper
				.selectCrewReport(filterCondition, pcfg);
		org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewSummaryDataTableAdapter dt = new org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewSummaryDataTableAdapter(
				listOfDTOs, "1");

		return dt;
	}

	public org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewDataTableAdapter selectAthletesReport(
			String anEventId, org.r3.db.PersistenceConfigInfo pcfg)
	{
		org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewFilter filterCondition = new SailApplicationCrewMemberViewFilter();
		filterCondition.or()
			.andEventidEqualTo(anEventId)
			.andRecstatusEqualTo(RecordStatus.sys_recact.toString())
			.andCardnumberstatuscodeNotEqualTo("fiv_cn_notexist")
			.andCardnumberstatuscodeNotEqualTo("fiv_cn_unknown")
		;
		
		filterCondition.setOrderByClause(" applicationid ");
		List<org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewDTO> listOfDTOs = this.mapper
				.select(filterCondition, pcfg, new RowBounds());
		org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewDataTableAdapter dt = new org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewDataTableAdapter(
				listOfDTOs, "1");

		return dt;
	}

}
