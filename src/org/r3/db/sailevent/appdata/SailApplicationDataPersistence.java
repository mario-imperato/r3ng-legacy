//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.sailevent.appdata;

import org.r3.db.PersistenceConfigInfo;
import org.r3.db.utils.DataTableQueryActionForm;
import org.r3.db.utils.SQLStringUtils;
import org.r3.db.utils.SQLStringUtils.LikeMode;

public class SailApplicationDataPersistence extends SailApplicationDataPersistenceBase {
	public static SailApplicationDataPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg,
			org.apache.ibatis.session.SqlSession aSession) {
		SailApplicationDataPersistence p = new SailApplicationDataPersistence();
		p.setMapper(aSession.getMapper(SailApplicationDataMapper.class));
		return p;
	}

	public int deleteByEventidApplicationidSectionid(String requestSiteId, String applicationId, String aSectionId,
			PersistenceConfigInfo persistenceConfigInfo) {
		SailApplicationDataFilter filter = new SailApplicationDataFilter();
		filter.or().andEventidEqualTo(requestSiteId).andApplicationidEqualTo(applicationId)
				.andSectionidEqualTo(aSectionId);

		return this.delete(filter, persistenceConfigInfo);
	}

	public int deleteByEventidApplicationidSectionidParamNamePrefix(String requestSiteId, String applicationId,
			String aSectionId, String paramNamePrefix, PersistenceConfigInfo persistenceConfigInfo) {
		SailApplicationDataFilter filter = new SailApplicationDataFilter();
		filter.or().andEventidEqualTo(requestSiteId).andApplicationidEqualTo(applicationId)
				.andSectionidEqualTo(aSectionId)
				.andParamnameLike(SQLStringUtils.getStringForLikeMode(paramNamePrefix, LikeMode.LeftLike));

		return this.delete(filter, persistenceConfigInfo);
	}

	public SailApplicationDataDataTableAdapter queryByEventidApplicationid(String requestSiteId, String applicationId,
			PersistenceConfigInfo persistenceConfigInfo) {
		SailApplicationDataFilter filter = new SailApplicationDataFilter();
		filter.or().andEventidEqualTo(requestSiteId).andApplicationidEqualTo(applicationId);

		DataTableQueryActionForm queryForm = new DataTableQueryActionForm();
		queryForm.setExecuteCount(false);

		return this.query(filter, persistenceConfigInfo, queryForm.getsEcho(), queryForm.getiDisplayStart(),
				queryForm.getiDisplayLength(), queryForm.isExecuteCount());

	}

}
