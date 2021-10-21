package org.r3.system.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.r3.db.PersistenceContext;
import org.r3.db.bbs.bbstopic.BBSTopicDTO;
import org.r3.db.bbs.bbstopic.BBSTopicPersistence;
import org.r3.db.cms.card.CardDTO;
import org.r3.db.cms.card.CardPersistence;
import org.r3.db.cms.pageview.PageViewDTO;
import org.r3.db.cms.pageview.PageViewPersistence;
import org.r3.db.system.site.SiteDTO.SiteProfile;

public class R3Manager extends GWFMappingDispatchAction
{
	/*
	 * Fetch DTOs Section
	 */
	protected String getRequestParameter(HttpServletRequest request,
			String pName)
	{
		String pValue = request.getParameter(pName);
		return pValue;
	}

	protected PageViewDTO retrievePageById(HttpServletRequest request,
			SqlSession aSession, PersistenceContext pcfg, String anEventId, String aLanguage,
			String aPageId)
	{
		PageViewPersistence pagePersistence = PageViewPersistence
				.createPersistenceObject(pcfg, aSession);
		PageViewDTO sailApplicationDTO = pagePersistence.selectBySiteLanguagePageid(
				anEventId, aLanguage, aPageId, pcfg.getPersistenceConfigInfo());

		return sailApplicationDTO;
	}

	protected CardDTO retrieveCardById(HttpServletRequest request,
			SqlSession aSession, PersistenceContext pcfg, String anEventId,
			String aCardId)
	{
		CardPersistence cardPersistence = CardPersistence
				.createPersistenceObject(pcfg, aSession);
		CardDTO sailApplicationDTO = cardPersistence.selectBySiteCardid(
				anEventId, aCardId, pcfg.getPersistenceConfigInfo());

		return sailApplicationDTO;
	}

	protected BBSTopicDTO retrieveTopicById(HttpServletRequest request,
			SqlSession aSession, PersistenceContext pcfg, String aSite,
			String aTopicId)
	{
		BBSTopicPersistence cardPersistence = BBSTopicPersistence.createPersistenceObject(pcfg, aSession);
		BBSTopicDTO topicDTO = cardPersistence.selectBySiteTopicid(aSite, aTopicId, pcfg.getPersistenceConfigInfo());

		return topicDTO;
	}

    public ActionForward failure(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {
         
            GWFActionMapping gwfMapping = processCastActionMapping(mapping);

            System.err.println("### GWF - Invoked the failure method");   
            return gwfMapping.findForward(request, GWFConstants.Failure);
    }
    
	public ActionForward success(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{

		GWFActionMapping gwfMapping = processCastActionMapping(mapping);
		ActionForward af = gwfMapping.findForward(request, GWFConstants.Success);
		return af;
	}

	public ActionForward successAndSuccessGuest(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{

		GWFActionMapping gwfMapping = processCastActionMapping(mapping);
		RequestEnvironment reqEnv = RequestEnvironment.getInstance(request);
		
		ActionForward af = gwfMapping.findForward(request, GWFConstants.Success);
		if (reqEnv.isGuest())
    	{
			af = gwfMapping.findForward(request, GWFConstants.SuccessGuest);
    	}
		
		return af;
	}
	
	/*
	 * SuccessProfile1. Require Site enabled and MongoDb Present.
	 */
	public ActionForward successProfiled(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		GWFActionMapping gwfMapping = processCastActionMapping(mapping);
		RequestEnvironment reqEnv = RequestEnvironment.getInstance(request);
		
		ActionForward af = null;
		
		String forward = GWFConstants.Success;
		SiteProfile siteProfile =  reqEnv.getSiteProfile();
		switch(siteProfile)
		{
		case profile1:
	        if (PersistenceContext.getPersistenceContext().isMongoDbAvailable() && siteProfile == SiteProfile.profile1)
	        {
	        	System.out.println("Mongo Configured. Routing to SuccessMongo");
	        	forward = GWFConstants.SuccessProfile1;        	
	        }
			break;
			
		default:
		}
		        
        af = gwfMapping.findForward(request, forward);        
		return af;
	}

    public ActionForward home(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        GWFActionMapping gwfMapping = processCastActionMapping(mapping);
        RequestEnvironment reqEnv = RequestEnvironment.getInstance(request);

        String welcomeForward = GWFConstants.YachtClubSiteHome;
        if (reqEnv.isDefaultSite())
        	welcomeForward = GWFConstants.DefaultSiteHome;
        else if (reqEnv.isRegattaSite())
        	welcomeForward = GWFConstants.RegattaSiteHome;
        else if (reqEnv.isSiteOfType("speedsails"))
        	welcomeForward = GWFConstants.SpeedSailsHome;
        else if (reqEnv.isSiteOfType("workshop"))
        	welcomeForward = GWFConstants.WorkshopHome;
        else if (reqEnv.isSiteOfType("mastersite"))
        	welcomeForward = GWFConstants.MasterSiteHome;
        else if (reqEnv.isSiteOfType("cptes"))
        	welcomeForward = GWFConstants.ITILServiceSiteHome;
        else if (reqEnv.isSiteOfType("shakeus"))
        {
        	welcomeForward = GWFConstants.ShakeusHome;
        	if (reqEnv.isGuest())
        	{
        		String shkAction = request.getParameter("shkaction");
        		if (shkAction == null || !shkAction.equalsIgnoreCase("map"))
        			welcomeForward = GWFConstants.ShakeusHomeGuest; 
        	}   	       		
        }
        else if (reqEnv.isSiteOfType("shkneighb"))
        {
        	welcomeForward = GWFConstants.ShakeusNeighbHome;
//        	if (reqEnv.isGuest())
//        	{
//        		String shkAction = request.getParameter("shkaction");
//        		if (shkAction == null || !shkAction.equalsIgnoreCase("map"))
//        			welcomeForward = GWFConstants.ShakeusHomeGuest; 
//        	}       		
        }
        else if (reqEnv.isSiteOfType("shkshop"))
        {
        	welcomeForward = GWFConstants.ShakeusShopHome;        	      	
        }
        
        return gwfMapping.findForward(request, welcomeForward);
    }
    
	public ActionForward viewRouter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{

		GWFActionMapping gwfMapping = processCastActionMapping(mapping);

		String forwardview = request.getParameter("fviewid");
		if (forwardview == null)
			forwardview = GWFConstants.Success;

		ActionForward af = gwfMapping.findForward(request, forwardview);
		return af;
	}
        
	public ActionForward page(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		GWFActionMapping gwfMapping = processCastActionMapping(mapping);
		RequestEnvironment reqEnv = RequestEnvironment.getInstance(request);

		PageViewDTO pageDTO = null;
		CardDTO cardDTO = null;
		BBSTopicDTO topicDTO = null;
		
		String pageId = this.getRequestParameter(request, "pageid");
		String cardId = this.getRequestParameter(request, "cardid");
		String topicId = this.getRequestParameter(request, "topicid");
		if (pageId != null || cardId != null || topicId != null)
		{
			PersistenceContext pcfg = PersistenceContext
					.getPersistenceContext();

			SqlSession session = pcfg.openSession();
			try
			{
				if (pageId != null)
					pageDTO = this.retrievePageById(request, session, pcfg,
							reqEnv.getRequestSiteId(), reqEnv.getRequestLanguage(), pageId);

				if (cardId != null)
				{
					cardDTO = this.retrieveCardById(request, session, pcfg,
							reqEnv.getRequestSiteId(), cardId);
					if (cardDTO == null)
					{
						cardDTO = new CardDTO();
						cardDTO.setCardid(cardId);
						cardDTO.setSystemtitle(cardId);
					}
				}
				
				if (topicId != null)
					topicDTO = this.retrieveTopicById(request, session, pcfg,
							reqEnv.getRequestSiteId(), topicId);
				
				session.commit();
			}
			finally
			{
				session.close();
			}
		}

		String actionForward = GWFConstants.Success;
		if (pageDTO != null)
		{
			actionForward = pageDTO.getForwardview();
			saveFormBean(request, "request", pageDTO.getClass().getName(),
					pageDTO);
		}

		if (cardDTO != null)
		{
			saveFormBean(request, "request", cardDTO.getClass().getName(),
					cardDTO);
		}

		if (topicDTO != null)
		{
			saveFormBean(request, "request", topicDTO.getClass().getName(),
					topicDTO);
		}
		
		return gwfMapping.findForward(request, actionForward);
	}

}
