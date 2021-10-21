package org.r3.system.util.nls_dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.r3.system.util.FileActionErrorEvent;
import org.r3.system.util.FileFinder;
import org.r3.system.util.FileFoundEvent;
import org.r3.system.util.FileFoundListener;
import org.r3.system.util.SystemUtils;
import org.r3.system.util.classLoadHelper.CascadingClassLoadHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NLSDictionary
{
    private static final String DefaultFilePattern = "dictionary_(\\w{2,3}).xml";
    
	static Logger logger = LoggerFactory.getLogger(NLSDictionary.class);

	public static String getNLSDictionaryClassId = NLSDictionary.class.getName();
	
    private Map<String, NamespaceBundle> mapOfBundles;
    private String fileMatchingPattern = DefaultFilePattern;
    
	public NLSDictionary()
	{
		mapOfBundles = new HashMap<String, NamespaceBundle>();
	}

	public void addBundle(NamespaceBundle aBundle)
	{
		mapOfBundles.put(aBundle.getKey(), aBundle);
	}
	
	protected NamespaceBundle getBundle(String aNamespace, String aLanguage)
	{
		String bundleKey = NamespaceBundle.getKey(aNamespace, aLanguage);
		NamespaceBundle theBundle = mapOfBundles.get(bundleKey);
		
		return theBundle;
	}
	
	public String getStringFor(String aNamespace, String aLanguage, String aStringId)
	{
		NamespaceBundle b = getBundle(aNamespace, aLanguage);
		if (b != null)
			return b.get(aStringId);
		
		return null;
	}
	
	public void readDirectory(String rootPath, CascadingClassLoadHelper c) throws IOException
	{								
		List<String> foundFiles = scanDirectories(rootPath, fileMatchingPattern);
		read(foundFiles, c);
	}
	
	public void readCatalog(String rootPath, CascadingClassLoadHelper c) throws IOException
	{								
		List<String> foundFiles = scanCatalog(rootPath, fileMatchingPattern, c);
		read(foundFiles, c);
	}
	
	private void read(List<String> foundFiles, CascadingClassLoadHelper c) throws IOException
	{								
		if (foundFiles != null)
		{			
			for(String aFileName : foundFiles)
			{
				File f = new File(aFileName);
				String l = extractLanguageFromFileName(f, fileMatchingPattern);
				if ( l != null)
				{
			    	NamespaceBundleReader r = new NamespaceBundleReader(c);			    	
					NamespaceBundle nsb = r.read(f.getAbsolutePath(), l);
					addBundle(nsb);
					logger.info(String.format("### GWF - Found %d entries for namespace %s and language %s in file %s", nsb.size(), nsb.getNamespace(), nsb.getLanguage(), f.getAbsolutePath()));
				}
			}
		}
	}
	
	private String extractLanguageFromFileName(File f, String fileMatchingPattern)
	{
    	Pattern MY_PATTERN = Pattern.compile(fileMatchingPattern);
		 Matcher m = MY_PATTERN.matcher(f.getName());
		 
		 m.find();		 
		 if (m.groupCount() <= 0)
			 return null;
		 
		 return m.group(1);	
	}
	
	private List<String> scanCatalog(String dictionaryCatalog, String filenamePattern, CascadingClassLoadHelper resourceLoadHelper) throws FileNotFoundException
	{
		File dirPath = new File(dictionaryCatalog);		
		if (!(dirPath.exists() && dirPath.isFile() && dirPath.canRead()))
		{
			if (logger.isErrorEnabled())
				logger.error("### GWF - The file " + dictionaryCatalog + " cannot be accessed... it won't be searched for string tables!");
			
			throw new FileNotFoundException("The file " + dictionaryCatalog + " cannot be accessed... it won't be searched for string tables!");
		}
		
		final List<String> dictFiles = new ArrayList<String>();
		
		Reader rd = null;
		try
		{
			rd = resourceLoadHelper
					.getFileOrResourceAsReader(dictionaryCatalog);
			if (rd != null)
			{
				BufferedReader brd = new BufferedReader(rd);
				String line = brd.readLine();
				while (line != null)
				{
					line = line.trim();
					if (line.length() > 0 && !line.startsWith("#"))
						dictFiles.add(line);

					line = brd.readLine();
				}
			}
			
			return dictFiles;
		}
		catch (IOException e)
		{
			SystemUtils.close(rd);
		}
		
		return null;
	}
	
	private List<String> scanDirectories(String rootPath, String filenamePattern) throws FileNotFoundException
	{
		File dirPath = new File(rootPath);		
		if (!(dirPath.exists() && dirPath.isDirectory() && dirPath.canRead()))
		{
			if (logger.isErrorEnabled())
				logger.error("### GWF - The directory " + rootPath + " cannot be accessed... it won't be searched for string tables!");
			
			throw new FileNotFoundException("The directory " + rootPath + " cannot be accessed... it won't be searched for string tables!");
		}
		
		final List<String> dictFiles = new ArrayList<String>();
		
		FileFinder finder = new FileFinder();

		if (logger.isInfoEnabled())
		{
			logger.info("### GWF - Searching Directory : " + rootPath);
			logger.info("### GWF - Searching for files : " + filenamePattern);
		}

		finder.setInputPattern(filenamePattern);
		finder.setInputPath(rootPath
				+ System.getProperty("file.separator"));
		finder.setRecurse(true);
		// finder.addFileFoundListener(this.new FileFoundHandler(parser));
		FileFoundListener fileFoundListener = new FileFoundListener()
		{
			public void fileFound(FileFoundEvent filefoundevent)
			{				
				dictFiles.add(filefoundevent.getPathName());
			}
		};
		finder.addFileFoundListener(fileFoundListener);
		FileActionErrorEvent act = finder.process();
		if (act != null)
		{
			logger.error("### GWF -  Result: " + act.getCode() + ", " + act.getReason());
			return null;
		}
			logger.info("### GWF - Found " + finder.getResultCountOfFoundFiles() + " files");

			return dictFiles;
	}

	public static void main(String args[]) throws IOException
	{
		CascadingClassLoadHelper c = new CascadingClassLoadHelper();
		NLSDictionary d = new NLSDictionary();
		d.readDirectory(".", c);
		
		String k = "login_form.title";
		System.out.printf("The Translation for %s and language %s is %s\n", k, "it", d.getStringFor("org.r3", "it", k));
		System.out.printf("The Translation for %s and language %s is %s\n", k, "en", d.getStringFor("org.r3", "en", k));
	}
}
