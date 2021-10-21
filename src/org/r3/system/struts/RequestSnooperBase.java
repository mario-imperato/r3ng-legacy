package org.r3.system.struts;

import java.io.BufferedReader;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;

public abstract class RequestSnooperBase extends RequestSnooper
{
    private static String newLine = System.getProperty("line.separator");
    
    private StringBuilder println(StringBuilder stb, String aLabel)
    {
        stb.append(aLabel).append(newLine);       
        return stb;
    }
    
    private StringBuilder println(StringBuilder stb, String aLabel, String aValue)
    {
        stb.append(aLabel).append(aValue).append(newLine);       
        return stb;
    }

    private StringBuilder println(StringBuilder stb, String aLabel, int aValue)
    {
        stb.append(aLabel).append(aValue).append(newLine);       
        return stb;
    }

    private StringBuilder printServletConfig(StringBuilder stb, ServletConfig servletCfg)
    {
        println(stb, "Init Parameters");
        
        Enumeration<String> en = servletCfg.getInitParameterNames();
        if (en != null)
        {
            
            while (en.hasMoreElements())
            {
                String param = (String) en.nextElement();
                println(stb, param, servletCfg.getInitParameter(param));
            }
        }

        return stb;
    }

    private StringBuilder printRequestInfo(StringBuilder stb, HttpServletRequest req)
    {
        println(stb, "Request information:");

        println(stb, "Request method: ", req.getMethod());
        println(stb, "Request URI: ", req.getRequestURI());
        println(stb, "Request protocol: ", req.getProtocol());
        println(stb, "Servlet path: ", req.getServletPath());
        println(stb, "Path info: ", req.getPathInfo());
        println(stb, "Path translated: ", req.getPathTranslated());
        println(stb, "Query string: ", req.getQueryString());
        println(stb, "Content length: ", req.getContentLength());
        println(stb, "Content type: ", req.getContentType());
        // println(stb, "Server name: ", req.getServerName());
        // println(stb, "Server port: ", req.getServerPort());
        println(stb, "Remote user: ", req.getRemoteUser());
        // println(stb, "Remote address: ", req.getRemoteAddr());
        // println(stb, "Remote host: ", req.getRemoteHost());
        println(stb, "Authorization scheme: ", req.getAuthType());

        return stb;
    }

    private StringBuilder printRequestAddressInfo(StringBuilder stb, HttpServletRequest req)
    { 
        println(stb, 
         String.format("Snoop Req. Address: Server name: %s, Server port: %d, Remote address: %s, Remote host: %s", req.getServerName(), req.getServerPort(), req.getRemoteAddr(), req.getRemoteHost()));

        return stb;
    }
    
    private StringBuilder printHeaderInfo(StringBuilder stb, HttpServletRequest req)
    {
        println(stb, "Header information:");

        Enumeration<String> e = req.getHeaderNames();
        if (e != null)
        {
            while (e.hasMoreElements())
            {
                String name = (String) e.nextElement();
                println(stb, " Header[" + name + "]: ", req.getHeader(name));
            }
        }

        return stb;
    }

    private StringBuilder printParameters(StringBuilder stb, HttpServletRequest request)
    {
        println(stb, "Servlet parameters (Multiple Value style):");        
        Enumeration<String> e = request.getParameterNames();
        if (e != null)
        {
            while (e.hasMoreElements())
            {
                String name = (String) e.nextElement();
                String vals[] = (String[]) request.getParameterValues(name);

                String paramValue = " SNOOP NOVALUE ";
                if (vals != null && vals.length > 0)
                {
                    if (vals.length == 1)
                    {
                        if (vals[0].length() > 0)
                            paramValue = vals[0];
                    }
                    else
                    {
                        StringBuilder stbLocal = new StringBuilder();
                        for (int i = 0; i < vals.length; i++)
                        {

                            if (i > 0)
                                stbLocal.append(", ");
                            stbLocal.append(vals[i]);
                        }

                        paramValue = stbLocal.toString();
                    }
                }

                println(stb, " " + name + " = ", paramValue);
            }
        }

        return stb;
    }

    private StringBuilder printCertificateChain(StringBuilder stb, HttpServletRequest req)
    {
        println(stb, "HTTPS Information:");

        String cipherSuite = (String) req.getAttribute("javax.net.ssl.cipher_suite");

        if (cipherSuite != null)
        {
            X509Certificate certChain[] = (X509Certificate[]) req.getAttribute("javax.net.ssl.peer_certificates");
            println(stb, "Cipher Suite:  ", cipherSuite);

            if (certChain != null)
            {
                for (int i = 0; i < certChain.length; i++)
                {
                    println(stb, "client cert chain [" + i + "] = ", certChain[i].toString());
                }
            }

        }
        return stb;
    }
    
    private StringBuilder printJDKInfo(StringBuilder stb)
    {
        println(stb, "Java Information:");

        println(stb, "Java version:  " , System.getProperty("java.version"));
        println(stb, "Java home:  " , System.getProperty("java.home"));
        println(stb, "Java vendor:  " , System.getProperty("java.vendor"));
        println(stb, "Java class version:  " , System.getProperty("java.class.version"));
        
        String cp = System.getProperty("java.class.path");
        println(stb, "Java class path:", cp);

        return stb;
    }
    
    private StringBuilder printBody(StringBuilder stb, HttpServletRequest req)
    {
        String line = null;
        BufferedReader r = null;
        try
        {
            r = req.getReader();
            stb.append(newLine);

            line = r.readLine();
            while (line != null)
            {
                println(stb, line);
                line = r.readLine();
            };
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (r != null)
                try { r.close(); }  catch (IOException e)  { e.printStackTrace(); }
        }

        return stb;
    }

    public StringBuilder prepareSnoopBuffer(ServletConfig servletCfg, HttpServletRequest req, RequestSnooperInfo snoopType)
    {    
        StringBuilder stb = new StringBuilder();

        if (snoopType == RequestSnooperInfo.address)
        {
        	printRequestAddressInfo(stb, req);
        }
        else
        {
        printJDKInfo(stb);
        if (req.getRequestURL() != null)
           println(stb, "Requested URL: ", req.getRequestURL().toString());
     
        printServletConfig(stb, servletCfg);
        printRequestAddressInfo(stb, req);
        printRequestInfo(stb, req);
        printHeaderInfo(stb, req);
        printParameters(stb, req);
        printCertificateChain(stb, req);
        
        printBody(stb, req);
        }
        
        return stb;
    }        
}
