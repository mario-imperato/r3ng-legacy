//
// generated by jGAMe Software - GPA Gruppo Progetti Avanzati s.r.l. 2016-2017
//
//
// README Section
//

package org.r3.db.sailevent.attendancesheetview;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewFilter;

public class SailAttendanceSheetViewPersistence extends SailAttendanceSheetViewPersistenceBase {
	public static SailAttendanceSheetViewPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg,
			org.apache.ibatis.session.SqlSession aSession) {
		SailAttendanceSheetViewPersistence p = new SailAttendanceSheetViewPersistence();
		p.setMapper(aSession.getMapper(SailAttendanceSheetViewMapper.class));
		return p;
	}

	public SailAttendanceSheetViewDataTableAdapter selectAttendanceSheetReport(String anEventId, String sheetId,
			org.r3.db.PersistenceConfigInfo pcfg) {
		SailAttendanceSheetViewFilter filterCondition = new SailAttendanceSheetViewFilter();
		filterCondition.or().andEventidEqualTo(anEventId).andSheetidEqualTo(sheetId);

		filterCondition.setOrderByClause(" yachtname ");
		List<SailAttendanceSheetViewDTO> listOfDTOs = this.mapper.select(filterCondition, pcfg, new RowBounds());
		SailAttendanceSheetViewDataTableAdapter dt = new SailAttendanceSheetViewDataTableAdapter(listOfDTOs, "1");

		return dt;
	}
}
