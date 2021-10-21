package org.r3.system.rest;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.system.util.CryptoUtils;

public class SecurityTokenActionForm
{

	public SecurityTokenActionForm()
	{
	}

	@FormParam("securetoken")
	private String securetoken;

	public String getSecuretoken()
	{
		return DTOBase.nullOnEmpty(securetoken);
	}

	@FormParam("securecode")
	private String securecode;

	public String getSecurecode()
	{
		return DTOBase.nullOnEmpty(securecode);
	}

	private String getSecuretokenDecoded() throws GeneralSecurityException,
			IOException
	{
		String s = getSecuretoken();
		if (s != null)
		{
			return CryptoUtils.decrypt(s);
		}

		return null;
	}

	public boolean isSecuritycodeValid()
	{
		try
		{
			String token = getSecuretokenDecoded();
			String scode = getSecurecode();

			if (token != null && scode != null && token.equalsIgnoreCase(scode))
				return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return false;
	}

}
