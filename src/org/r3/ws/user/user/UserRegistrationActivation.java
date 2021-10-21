package org.r3.ws.user.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.PersistenceContext;
import org.r3.db.system.otp.OTPDTO;
import org.r3.db.system.otp.OTPPersistence;
import org.r3.db.system.user.user.UserDTO;
import org.r3.db.system.user.user.UserPersistence;
import org.r3.system.struts.GWFActionMapping;
import org.r3.system.struts.GWFConstants;
import org.r3.system.struts.GWFMappingDispatchAction;

public class UserRegistrationActivation extends GWFMappingDispatchAction
{

	public ActionForward activate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
					throws Exception
	{

		GWFActionMapping gwfMapping = processCastActionMapping(mapping);
		System.err.println("### GWF - Invoked the success method");

		PersistenceContext pcfg = PersistenceContext.getPersistenceContext();
		SqlSession session = pcfg.openSession();
		try
		{
			String digest = request.getParameter(GWFConstants.RequestOneTimePasswordParam);
			if (digest == null || digest.length() != 40)
				return gwfMapping.findForward(request, GWFConstants.Failure);

			boolean successFlag = false;

			OTPPersistence otpPersistence = OTPPersistence.createPersistenceObject(pcfg, session);
			OTPDTO otpDTO = otpPersistence.selectByDigest(digest, pcfg.getPersistenceConfigInfo());
			if (otpDTO != null)
			{
				UserPersistence userPersistence = UserPersistence.createPersistenceObject(pcfg, session);
				UserDTO userDTO = userPersistence.selectByUserid(otpDTO.getUserid(), pcfg.getPersistenceConfigInfo());
				if (userDTO != null)
				{
					if (userDTO.isBlocked())
					{
						userDTO.setRecstatus(RecordStatus.sys_recact.toString());
						userPersistence.updateByPrimaryKey(userDTO, pcfg.getPersistenceConfigInfo());
						
						successFlag = true;
					}
				}

				otpPersistence.deleteByDigest(digest, pcfg.getPersistenceConfigInfo());
			}

			session.commit();

			if (successFlag)
				return gwfMapping.findForward(request, GWFConstants.Success);

			return gwfMapping.findForward(request, GWFConstants.Failure);

		}
		finally
		{
			session.close();
		}

	}

}
