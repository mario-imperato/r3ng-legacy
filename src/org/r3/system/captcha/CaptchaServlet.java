package org.r3.system.captcha;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.r3.system.util.CryptoUtils;

import nl.captcha.Captcha;
import nl.captcha.servlet.CaptchaServletUtil;
import nl.captcha.text.producer.TextProducer;

public class CaptchaServlet extends HttpServlet {

	public static class EchoTextProducer implements TextProducer
	{
        private String echo;
        
        public EchoTextProducer(String s)
        {
        	echo = s;
        }
        
		public String getText()
		{
			return echo;
		}
	    	
	}
	
    private static final long serialVersionUID = 1L;

    private static int _width = 200;
    private static int _height = 50;
    
    private static final List<Color> COLORS = new ArrayList<Color>(2);
    private static final List<Font> FONTS = new ArrayList<Font>(3);
    
    static {
        COLORS.add(Color.BLACK);
        COLORS.add(Color.BLUE);

        FONTS.add(new Font("Geneva", Font.ITALIC, 48));
        FONTS.add(new Font("Courier", Font.BOLD, 48));
        FONTS.add(new Font("Arial", Font.BOLD, 48));
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    	if (getInitParameter("captcha-height") != null) {
    		_height = Integer.valueOf(getInitParameter("captcha-height"));
    	}
    	
    	if (getInitParameter("captcha-width") != null) {
    		_width = Integer.valueOf(getInitParameter("captcha-width"));
    	}
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	
    	String token = req.getParameter("token");
    	if (token != null)
    	{
    		try
			{
				token = CryptoUtils.decrypt(token);
			}
			catch (GeneralSecurityException e)
			{
				e.printStackTrace();
				token = "tok_err";
			}
    	}
    	else token = "tok_no";    	
    	    	
        Captcha captcha = new Captcha.Builder(_width, _height)
                .addText(new EchoTextProducer(token))     
                .gimp()
                .addBorder()
                .addNoise()                
                .build();

        CaptchaServletUtil.writeImage(resp, captcha.getImage());
        // req.getSession().setAttribute(NAME, captcha);
    }
}
