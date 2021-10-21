package org.r3.system.taglibs.r3_lang;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

import org.r3.system.struts.RequestEnvironment;

public class JSScriptTag extends GWFTagSupport
{
	public enum JSScriptTagEnvirnoment {
		dev, runtime, any, none;

		public static JSScriptTagEnvirnoment getValue(String s)
		{
			JSScriptTagEnvirnoment v = JSScriptTagEnvirnoment.dev;
			if (s != null && s.length() > 0)
			{
				try
				{
					v = JSScriptTagEnvirnoment.valueOf(s.toLowerCase());
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}

			return v;
		}

	};

	// <script type="text/javascript" src='<r3_lang:pathResolver
	// path="/resources/js/jquery.iframe-transport.js" />'></script>

	private String src = null;
	private String ifLanguage;
	private String path = null;
	private JSScriptTagEnvirnoment scriptEnv = null;

	public JSScriptTag()
	{
		clearTagState();
	}

	public void clearTagState()
	{
		super.clearTagState();
		path = null;
		ifLanguage = null;
		scriptEnv = JSScriptTagEnvirnoment.dev;
		src = null;
	}

	public int doStartTag() throws JspException
	{
		JspWriter out = pageContext.getOut();

		JSScriptTagEnvirnoment deployEnv = JSScriptTagEnvirnoment.dev;
		String deployEnvStr = pageContext.getServletContext().getInitParameter("deploy.environment");
		if (deployEnvStr != null)
		{
			deployEnv = JSScriptTagEnvirnoment.getValue(deployEnvStr);
		}
		
		;
		
		String htmlOut = null;
		try
		{
			if (path != null)
				src = getAbsoluteUrl(pageContext, path, null, null);
		
			if ((getIfLanguage() != null && languageRequiredMatches(getIfLanguage())) || 
				(getIfLanguage() == null && scriptEnv != JSScriptTagEnvirnoment.none && (deployEnv == scriptEnv || scriptEnv == JSScriptTagEnvirnoment.any)))
			{
				htmlOut = formatOutput(src);
			}
			else
			{
				// Non sparo fuori il commentato degli script per evitare che qualcuno li tiri giù a mazzetta.
				if (deployEnv == JSScriptTagEnvirnoment.dev)
				       htmlOut = String.format("<!-- Unmatched Environment for: %s / %s -->", src, getIfLanguage());
				else   htmlOut = String.format("<!-- Unmatched Environment for: NONE -->");
			}
			
			out.println(htmlOut);
		}
		catch (Exception ex)
		{
			throw new JspTagException(ex.getMessage());
		}
		finally
		{
			clearTagState();
		}

		return SKIP_BODY;
	}

	private boolean languageRequiredMatches(String aLang)
	{
		if (aLang == null)
			return true;
		
		String reqLang = null;
		EnvironmentTag etag = getParentEnvironmentTag();
		if (etag != null)
		{
			RequestEnvironment renv = etag.getEnvironment();
			if (renv != null)
			{
				reqLang = renv.getRequestLanguage();
			}
		}
		
		if (reqLang != null && reqLang.equalsIgnoreCase(aLang))
			return true;
		
		return false;
	}

	private String formatOutput(String aSourceRef)
	{
		return String.format("<script type='text/javascript' src='%s' ></script>", aSourceRef);
	}

	public int doEndTag() throws JspException
	{
		JspWriter out = pageContext.getOut();

		try
		{

		}
		catch (Exception ex)
		{
			throw new JspTagException(ex.getMessage());
		}
		finally
		{
			clearTagState();
		}

		return EVAL_PAGE;
	}

	public void setSrc(String aSrc)
	{
		src = aSrc;
	}

	public String getSrc()
	{
		return src;
	}

	public void setPath2resolve(String s)
	{
		path = s;
	}

	public String getPath2resolve()
	{
		return path;
	}

	public void setScriptEnv(String s)
	{
		scriptEnv = JSScriptTagEnvirnoment.getValue(s);
	}

	public String getScriptEnv()
	{
		return scriptEnv.toString();
	}

	public String getIfLanguage()
	{
		return ifLanguage;
	}

	public void setIfLanguage(String ifLanguage)
	{
		this.ifLanguage = ifLanguage;
	}

}
