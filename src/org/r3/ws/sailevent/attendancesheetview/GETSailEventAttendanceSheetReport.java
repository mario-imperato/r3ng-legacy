package org.r3.ws.sailevent.attendancesheetview;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewDataTableAdapter;
import org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewPersistence;
import org.r3.db.sailevent.attendancesheetview.SailAttendanceSheetViewDataTableAdapter;
import org.r3.db.sailevent.attendancesheetview.SailAttendanceSheetViewPersistence;
import org.r3.system.rest.RestService.OutputFormat;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.util.velocity.VelocityTemplateModel;
import org.r3.ws.system.velocity.VelocityStreamingOutput;

public class GETSailEventAttendanceSheetReport extends ServicePattern {
	private VelocityTemplateModel velocityEngine;

	public GETSailEventAttendanceSheetReport(ServletContext ctx, ServiceEnvironment serviceEnvironment,
			OutputFormat aFormat) {
		super(ctx, serviceEnvironment);
		velocityEngine = VelocityTemplateModel.getVelocityPlugInModel(ctx);
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) {
		SailAttendanceSheetViewPersistence p = SailAttendanceSheetViewPersistence.createPersistenceObject(pcfg,
				aSession);
		SailAttendanceSheetViewDataTableAdapter dt = p.selectAttendanceSheetReport(senv.getRequestSiteId(),
				"ats000000000005", pcfg.getPersistenceConfigInfo());

		VelocityStreamingOutput sout = new VelocityStreamingOutput(velocityEngine, "SylkAttendanceSheetReport");
		sout.addParameter("listOfDTOs", dt);
		return sout;
	}

}
