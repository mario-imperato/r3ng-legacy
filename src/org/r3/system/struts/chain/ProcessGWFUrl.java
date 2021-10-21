package org.r3.system.struts.chain;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.chain.commands.ActionCommandBase;
import org.apache.struts.chain.commands.InvalidPathException;
import org.apache.struts.chain.contexts.ActionContext;
import org.apache.struts.chain.contexts.ServletActionContext;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.site.SiteDTO;
import org.r3.db.system.site.SiteLUT;
import org.r3.system.struts.GWFActionMapping;
import org.r3.system.struts.GWFHttpUtils;

public class ProcessGWFUrl extends ActionCommandBase
{

    @Override
    public boolean execute(ActionContext actionContext) throws Exception
    {
        ServletActionContext saContext = (ServletActionContext) actionContext;
        HttpServletRequest request = saContext.getRequest();

        processSiteAndLanguage(actionContext, request);        
        return false;
    }
    
    private void processSiteAndLanguage(ActionContext actionContext, HttpServletRequest request)
            throws InvalidPathException
    {
        String requestSite = GWFHttpUtils.getRequestSite(request);
        String requestLanguage = GWFHttpUtils.getRequestLanguage(request);
        
        if (requestSite == null || requestLanguage == null)
            throw new InvalidPathException("No action config found for the specified 'url': ", GWFHttpUtils.getRequestUri(request));
        
        	SiteLUT siteLUT = (SiteLUT)LUTManager.getLUTManager().getLUT(LUTName.site, requestLanguage);
        	SiteDTO siteDTO = siteLUT.getItem(requestSite);
        	
            if (siteDTO == null)
            	throw new InvalidPathException("No site for: ", requestSite);

            if (!siteDTO.supports(requestLanguage))
                throw new InvalidPathException("Site doesn't support language: ", requestLanguage);

        /*
        if (!requestSite.equalsIgnoreCase("default"))
            throw new InvalidPathException("No site supported beyond 'default': ", requestSite);

        if (!requestLanguage.equalsIgnoreCase("it"))
            throw new InvalidPathException("No language supported beyond 'it': ", requestLanguage);
        */
        
        // ActionMapping cannot be null.....
        // In this section I should check that the site is good for the action requested.
        GWFActionMapping actionMapping = (GWFActionMapping)actionContext.getActionConfig();
        String allowedSites = actionMapping.getAllowedSites();
        if (allowedSites != null)
            if (allowedSites.indexOf(requestSite) < 0)
                throw new InvalidPathException("Action not supported for site: ", requestSite);
    }

}
