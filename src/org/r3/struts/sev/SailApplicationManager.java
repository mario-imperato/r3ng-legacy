package org.r3.struts.sev;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.application.SailApplicationDTO;
import org.r3.system.struts.GWFActionMapping;
import org.r3.system.struts.GWFConstants;
import org.r3.system.struts.RequestEnvironment;

public class SailApplicationManager extends SailEventManager
{

	public ActionForward editMyApplication(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
					throws Exception
	{
		GWFActionMapping gwfMapping = processCastActionMapping(mapping);
		RequestEnvironment reqEnv = RequestEnvironment.getInstance(request);

		SailApplicationDTO sailApplicationDTO = null;

		String applicationId = this.getRequestParameter(request, "objid");
		if (applicationId != null)
		{
			PersistenceContext pcfg = PersistenceContext.getPersistenceContext();

			SqlSession session = pcfg.openSession();
			try
			{
				sailApplicationDTO = this.retrieveApplicationById(request, session, pcfg, reqEnv.getRequestSiteId(), applicationId);
				session.commit();
			}
			finally
			{
				session.close();
			}
		}

		String actionForward = "SessionRequiredFailure"; // GWFConstants.Failure;
		if (sailApplicationDTO != null && sailApplicationDTO.getUserid().equalsIgnoreCase(reqEnv.getUserProfile().getUserid()))
		{
			saveFormBean(request, "request", sailApplicationDTO.getClass().getName(), sailApplicationDTO);
			actionForward = GWFConstants.Success;
		}

		return gwfMapping.findForward(request, actionForward);
	}

	public ActionForward adminApplication(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
					throws Exception
	{
		GWFActionMapping gwfMapping = processCastActionMapping(mapping);
		RequestEnvironment reqEnv = RequestEnvironment.getInstance(request);

		SailApplicationDTO sailApplicationDTO = null;

		String applicationId = this.getRequestParameter(request, "objid");
		if (applicationId != null)
		{
			PersistenceContext pcfg = PersistenceContext.getPersistenceContext();

			SqlSession session = pcfg.openSession();
			try
			{
				sailApplicationDTO = this.retrieveApplicationById(request, session, pcfg, reqEnv.getRequestSiteId(), applicationId);
				session.commit();
			}
			finally
			{
				session.close();
			}
		}

		String actionForward = GWFConstants.Failure;
		if (sailApplicationDTO != null)
		{
			saveFormBean(request, "request", sailApplicationDTO.getClass().getName(), sailApplicationDTO);
			actionForward = GWFConstants.Success;
		}

		return gwfMapping.findForward(request, actionForward);
	}

}
