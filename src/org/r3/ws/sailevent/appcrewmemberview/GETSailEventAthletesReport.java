package org.r3.ws.sailevent.appcrewmemberview;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewDataTableAdapter;
import org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewPersistence;
import org.r3.system.rest.RestService.OutputFormat;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.util.velocity.VelocityTemplateModel;
import org.r3.ws.system.velocity.VelocityStreamingOutput;

public class GETSailEventAthletesReport extends ServicePattern
{
	private VelocityTemplateModel velocityEngine;
	
	public GETSailEventAthletesReport(ServletContext ctx,  ServiceEnvironment serviceEnvironment, OutputFormat aFormat)
	{
		super(ctx, serviceEnvironment);
		velocityEngine = VelocityTemplateModel.getVelocityPlugInModel(ctx);	
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		SailApplicationCrewMemberViewPersistence p = SailApplicationCrewMemberViewPersistence.createPersistenceObject(pcfg, aSession);			
		SailApplicationCrewMemberViewDataTableAdapter dt = p.selectAthletesReport(senv.getRequestSiteId(), pcfg.getPersistenceConfigInfo());
		
		VelocityStreamingOutput sout = new VelocityStreamingOutput(velocityEngine, "SylkAthletesReport");
		sout.addParameter("listOfDTOs", dt);
		return sout;		
	}
	

}
