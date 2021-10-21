package org.r3.system.util.nls_dictionary;

import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.r3.system.util.classLoadHelper.CascadingClassLoadHelper;
import org.r3.system.util.classLoadHelper.ResourceLoadHelper;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class NamespaceBundleReader
{			
	public static boolean xmlParsingVerbose = false;
	private ResourceLoadHelper resourceLoadHelper;
	
	public NamespaceBundleReader(CascadingClassLoadHelper classLoadHelper)
	{
		resourceLoadHelper = classLoadHelper;
	}

	public NamespaceBundle read(String dictionaryResource, String forLanguage)
	{		
		try
		{
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader parser = sp.getXMLReader();

			XMLStringHandler hd = new XMLStringHandler(forLanguage);
			parser.setContentHandler(hd);
			parser.setErrorHandler(hd);

			URL dictionaryFileURL = resourceLoadHelper.getFileOrResourceURL(dictionaryResource);
			parser.parse(dictionaryFileURL.toString());
			
			return hd.getParsedBundle();
		}
		catch (Exception e)
		{
			e.printStackTrace(System.err);			
		}

		return null;
	}

	private static class XMLStringHandler extends DefaultHandler
	{
		enum XMLToken 
		{ 			
			unknown, dictionary, string;
		
			public static XMLToken getValue(String s)
			{
				if (s == null)
					return XMLToken.unknown;
				
				try
				{
					XMLToken t = XMLToken.valueOf(s);
					return t;
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				return XMLToken.unknown;
			}		
		};
		
		public enum ReaderStatus 
		{
			s_zero, s_error, s_dictionary, s_string, s_end, s_token
		};

		private boolean elementOpen = false;
		private ReaderStatus readerStatus = ReaderStatus.s_zero;
		
		private String  bundleLanguage;
		
		// Holds the current Id of the string
		private String stringId = null;
		private StringBuffer stringValue = null;

		private NamespaceBundle parsedBundle;

		public NamespaceBundle getParsedBundle()
		{
			return parsedBundle;
		}
		
		public XMLStringHandler(String targetLanguage)
		{
			bundleLanguage = targetLanguage;	
		}
		
		/** Processing instruction. */
		@Override
		public void processingInstruction(String target, String data)
		{

		}

		/** Start document. */
		@Override
		public void startDocument()
		{

		}

		/** Start element. */
		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attrs) throws SAXException
		{
//			if (NLSDictionary.logger.isDebugEnabled())
//				NLSDictionary.logger.debug("### GWF - startElement " + qName);

			XMLToken xmlToken = XMLToken.getValue(qName);
			switch (xmlToken)
			{

			case unknown:
				if (readerStatus != ReaderStatus.s_string)
				{
					throw new SAXException(
							"XMLStringHandler::startElement: invalid position of element - "
									+ qName);
				}
				if (elementOpen)
				{
					addToValue(">");
				}
				addToValue("<" + qName);
				elementOpen = true;
				break;

			case string:
				if (readerStatus != ReaderStatus.s_dictionary)
				{
					String excMessage = "XMLStringHandler::startElement: String element not allowed in that scope";
					NLSDictionary.logger.error("### GWF - startElement " + excMessage);
					throw new SAXException(excMessage);
				}

				stringId = attrs.getValue("id");
				if (stringId == null)
				{
					throw new SAXException(
							"XMLStringHandler::startElement: attribute id not found");
				}
				
				readerStatus = ReaderStatus.s_string;
				break;
			case dictionary:
				if (readerStatus != ReaderStatus.s_zero)
					throw new SAXException(
							"XMLStringHandler::startElement: Dictionary element not allowed in that scope");
				readerStatus = ReaderStatus.s_dictionary;

				String ns = attrs.getValue("namespace");
				if (ns == null)
				{
					throw new SAXException(
							"XMLStringHandler::startElement: attribute ns not found in dictionary element");
				}
				
				parsedBundle = new NamespaceBundle(ns, bundleLanguage);
				
				// Reset the elements to the default values.
				// This because I use the same parser twice.
				stringId = null;
				stringValue = null;
				elementOpen = false;
				break;
			}

			return;

		}

		public void addToValue(String s)
		{
			if (stringValue == null)
				stringValue = new StringBuffer();
			s = s.replace('\n', ' ');
			stringValue.append(s.replace('\r', ' '));
		}

		/** Characters. */
		@Override
		public void characters(char ch[], int start, int length)
		{

//			if (NLSDictionary.logger.isDebugEnabled())
//				NLSDictionary.logger.debug("### GWF - characters ");

			if (readerStatus == ReaderStatus.s_string)
			{
				if (elementOpen)
				{
					addToValue(" />");
					elementOpen = false;
				}
				addToValue(new String(ch, start, length));
			}

		}

		/** End element. */
		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException
		{
//			if (NLSDictionary.logger.isDebugEnabled())
//				NLSDictionary.logger.debug("### GWF - endElement " + qName);

			XMLToken xmlToken = XMLToken.getValue(qName);
			switch (xmlToken)
			{

			case unknown:
				if (readerStatus != ReaderStatus.s_string)
				{
					throw new SAXException(
							"XMLStringHandler::endElement: invalid position of element - "
									+ qName);
				}
				if (elementOpen)
					addToValue(" />");
				else
					addToValue("</" + qName + ">");

				elementOpen = false;
				break;

			case string:
				if (readerStatus != ReaderStatus.s_string)
					throw new SAXException(
							"XMLStringHandler::endElement: String element not allowed in that scope");

				if (stringValue != null)
				{
					try
					{
						parsedBundle.put(stringId, stringValue.toString().trim());
						stringValue = null;
					}
					catch (Exception e)
					{
						e.printStackTrace(System.err);
						throw new SAXException(
								"XMLStringHandler::endElement: LUT Exception "
										+ e.getMessage());
					}
				}

				readerStatus = ReaderStatus.s_dictionary;
				break;

			case dictionary:
				if (readerStatus != ReaderStatus.s_dictionary)
					throw new SAXException(
							"XMLStringHandler::startElement: Dictionary element not allowed in that scope");
				readerStatus = ReaderStatus.s_end;
				break;

			}

			return;
		}

		//
		// ErrorHandler methods
		//

		/** Warning. */
		@Override
		public void warning(SAXParseException ex)
		{
			if (NLSDictionary.logger.isWarnEnabled())
				NLSDictionary.logger.warn("### GWF - warning " + getLocationString(ex) + ": "
						+ ex.getMessage());
		}

		/** Error. */
		@Override
		public void error(SAXParseException ex)
		{
			if (NLSDictionary.logger.isErrorEnabled())
				NLSDictionary.logger.error("### GWF - error " + getLocationString(ex) + ": "
						+ ex.getMessage());
		}

		/** Fatal error. */
		@Override
		public void fatalError(SAXParseException ex) throws SAXException
		{
			if (NLSDictionary.logger.isErrorEnabled())
				NLSDictionary.logger.error("### GWF - fatalError " + getLocationString(ex)
						+ ": " + ex.getMessage());
			throw ex;
		}

		/** Returns a string of the location. */
		private String getLocationString(SAXParseException ex)
		{
			StringBuffer str = new StringBuffer();

			String systemId = ex.getSystemId();
			if (systemId != null)
			{
				int index = systemId.lastIndexOf('/');
				if (index != -1)
					systemId = systemId.substring(index + 1);
				str.append(systemId);
			}
			str.append(':');
			str.append(ex.getLineNumber());
			str.append(':');
			str.append(ex.getColumnNumber());

			return str.toString();

		} // getLocationString(SAXParseException):String

/** Normalizes the given string. 
	        protected String normalize(String s)
	        {
	            StringBuffer str = new StringBuffer();

	            int len = (s != null) ? s.length() : 0;
	            for (int i = 0; i < len; i++)
	            {
	                char ch = s.charAt(i);
	                switch (ch)
	                {
	                    case '<':
	                    {
	                        str.append("&lt;");
	                        break;
	                    }
	                    case '>':
	                    {
	                        str.append("&gt;");
	                        break;
	                    }
	                    case '&':
	                    {
	                        str.append("&amp;");
	                        break;
	                    }
	                    case '"':
	                    {
	                        str.append("&quot;");
	                        break;
	                    }
	                    case '\r':
	                    case '\n':
	                    {
	                        // else, default append char
	                    }
	                    default:
	                    {
	                        str.append(ch);
	                    }
	                }
	            }

	            return str.toString();

	        }
	        */
	}

    public static void main(String[] args)
    {
    	CascadingClassLoadHelper c = new CascadingClassLoadHelper();
    	NamespaceBundleReader r = new NamespaceBundleReader(c);
    	
    	NamespaceBundle nsb = r.read(args[0], "en");
    	
    	String k = "login_form.title";
    	System.out.printf("The Translation for %s is %s\n", k, nsb.get(k));
    }
}
