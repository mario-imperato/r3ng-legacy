package org.r3.system.captcha;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.util.CryptoUtils;

import nl.captcha.text.producer.DefaultTextProducer;
import nl.captcha.text.producer.TextProducer;

public class GETCaptchaToken extends ServicePattern
{
	 private static final int DEFAULT_LENGTH = 8;
	 private static final char[] DEFAULT_CHARS = new char[] { 'a', 'b', 'c', 'd',
	            'e', 'f', 'g', 'h', 'k', 'm', 'n', 'p', 'r', 'w', 'x', 'y',
	            '2', '3', '4', '5', '6', '7', '8', };
	    
	public GETCaptchaToken(ServletContext ctx,  ServiceEnvironment serviceEnvironment)
	{
		super(ctx, serviceEnvironment);
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		RestServiceDTO restServiceDTO = new RestServiceDTO(Status.ok, "CAPTCHA_OK", "Captcha Token Succesfully Created");
		
		TextProducer txtProducer = new DefaultTextProducer(DEFAULT_LENGTH, DEFAULT_CHARS);
		String text = txtProducer.getText();
		
		String token;
		try
		{
			token = CryptoUtils.encrypt(text);
			restServiceDTO.setCorrelationid(token);
			return restServiceDTO;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return RestServiceDTO.FailDTO;
	}

}
