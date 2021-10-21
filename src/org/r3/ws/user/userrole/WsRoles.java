package org.r3.ws.user.userrole;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.Form;
import org.r3.system.rest.AccessLogInfo;
import org.r3.system.rest.RestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("{site}/{language}/roles")
public class WsRoles extends RestService
{
	private static Logger logger = LoggerFactory.getLogger(WsRoles.class);


	@PUT
	@Path("{roleid}/users")
	@Produces({ "application/xml", "application/json" })
	@Consumes("application/x-www-form-urlencoded")
	public Response deleteRole(
		     @Context javax.servlet.ServletContext ctx, @Context javax.servlet.http.HttpServletRequest servletRequest,
		     @Context Request request, 
		     @Context HttpHeaders headers,
		     @PathParam("site") String aSite,
		     @PathParam("language") String aLanguage,
		     @PathParam("roleid") String aRoleId,
		     @Form UserRolesActionForm anActionForm
		     )
	{
		AccessLogInfo a = null;
		if (logger.isInfoEnabled())
		{
			a = this.accessLogInfo();	
		}		

		if (logger.isDebugEnabled())
		{

		}		

		DELETEUserRole bl = new DELETEUserRole(ctx, getServiceEnvironment(ctx, servletRequest, headers, aSite, aLanguage), aRoleId, anActionForm);
		Response response = bl.process(request);
	    if (a != null)
	    {
	       logger.info(a.close());	 
	    }
		return response;
	}
	

}
