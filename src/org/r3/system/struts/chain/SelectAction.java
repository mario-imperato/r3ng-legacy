package org.r3.system.struts.chain;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.chain.Constants;
import org.apache.struts.chain.commands.AbstractSelectAction;
import org.apache.struts.chain.contexts.ActionContext;
import org.apache.struts.chain.contexts.ServletActionContext;
import org.apache.struts.config.ModuleConfig;

public class SelectAction extends AbstractSelectAction
{

    @Override
    protected String getPath(ActionContext context)
    {
        ServletActionContext saContext = (ServletActionContext) context;
        HttpServletRequest request = saContext.getRequest();
        String path = null;
        boolean extension = false;
 
        // For prefix matching, match on the path info
        path = (String) request.getAttribute(Constants.INCLUDE_PATH_INFO);

        if ((path == null) || (path.length() == 0)) {
            path = request.getPathInfo();
        }

        // For extension matching, match on the servlet path
        if ((path == null) || (path.length() == 0)) {
            path = (String) request.getAttribute(Constants.INCLUDE_SERVLET_PATH);

            if ((path == null) || (path.length() == 0)) {
                path = request.getServletPath();
            }

            if ((path == null) || (path.length() == 0)) {
                throw new IllegalArgumentException(
                    "No path information in request");
            }

            extension = true;
        }

        if (!extension)
        {
            // Strip the module prefix and extension (if any)
            path = processModuleConfig(saContext, path);
            return path;
        }
        
        // Provo a tirare via il sito e il linguaggio prima del prefisso del Modulo...
        // Poi si vede....
        path = stripExtension(path);
        
            String[] pathTokens = processStandardPath(path);
            path = pathTokens[2];
            path = processModuleConfig(saContext, path);        

        return (path);
    }

//    private String joinPathTokens(String[] pathTokens, int startIndex, int endIndex)
//    {
//        StringBuilder stb = new StringBuilder();
//        for(int i = startIndex ; i < endIndex; i++)
//        {
//            stb.append("/").append(pathTokens[i]);
//        }
//        
//        return stb.toString();
//    }

    private String stripExtension(String path)
    {
        int slash = path.lastIndexOf("/");
        int period = path.lastIndexOf(".");

        if ((period >= 0) && (period > slash)) {
            path = path.substring(0, period);
        }
        return path;
    }

    private String processModuleConfig(ServletActionContext saContext, String path)
    {
        ModuleConfig moduleConfig = saContext.getModuleConfig();
        String prefix = moduleConfig.getPrefix();

        if (!path.startsWith(prefix)) {
            throw new IllegalArgumentException("Path does not start with '"
                + prefix + "'");
        }

        path = path.substring(prefix.length());
        return path;
    }

    private String[] processStandardPath(String path)
    {
        String[] returnArray = new String[3];
        
        StringTokenizer strTok = new StringTokenizer(path, "/");
        if (strTok.countTokens() <= 2)
            throw new IllegalArgumentException(
                    "GWF --- Could not process path: " + path);
        
        StringBuilder stb = new StringBuilder();        
        int    tokenNumber = 0;
        while (strTok.hasMoreTokens())
        {
            String token = strTok.nextToken();
            if (tokenNumber < 2)
               returnArray[tokenNumber] = token;            
            
            if (tokenNumber >= 2)
                stb.append('/').append(token);
            
            tokenNumber++;
        }
        
        returnArray[2] = stb.toString(); 
        return returnArray;
    }

    private String[] processPortalPath(String path)
    {
        StringTokenizer strTok = new StringTokenizer(path, "/");
        
        String[] splittedPath = new String[strTok.countTokens()];
        for(int i = 0; strTok.hasMoreTokens(); i++)
        {
            String t = strTok.nextToken();
            int ndx = t.indexOf('+');
            if (ndx >= 0)
                 splittedPath[i] = t.substring(0, ndx);
            else splittedPath[i] = t;
        }
        
        return splittedPath;
    }

}
