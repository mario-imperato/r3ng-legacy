package org.r3.system.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.r3.db.DTOBase;

public class StringUtils
{
    public static String replace(String str, String oldSubStr, int newSubStrAsInt)
    {
        return replace(str, oldSubStr, String.valueOf(newSubStrAsInt));
    }

    public static String replace(String str, String oldSubStr, String newSubStr)
    {
        if (str == null)
            return null;

        StringBuilder ret = new StringBuilder();

        String lookFor = oldSubStr;
        int curChar = 0;
        int index;
        int lookForLen = lookFor.length();

        while ((index = str.indexOf(lookFor, curChar)) >= 0)
        {
            ret.append(str.substring(curChar, index));

            ret.append(newSubStr);
            curChar = index + lookForLen;
        }

        ret.append(str.substring(curChar, str.length()));
        return ret.toString();
    }

    public static String firstLetterToUpperCase(String s)
    {
        if (s != null)
        {
            s = Character.toUpperCase(s.charAt(0)) + s.substring(1);
        }

        return s;
    }

    public static String formatCamelCase(String aFirstString, String aSecondString)
    {
        StringBuilder stb = new StringBuilder();
        stb.append(aFirstString.toLowerCase());
        stb.append(StringUtils.firstLetterToUpperCase(aSecondString));
        return stb.toString();
    }

    /**
     * Verifica se nella String s, contiene solo caratteri presenti nella String
     * bag.Serve per controllare se una String contiene caratteri non permessi.
     * 
     * @param s
     *            la String in input
     * @param bag
     *            la String contenente i caratteri da verificare
     * 
     * @return true se nella la String s esiste almeno un caratere presente
     *         nella String bag
     * 
     */
    public static boolean existsOnlyInBag(String s, String bag)
    {
        if ((s == null) || (s.length() == 0))
            return true;
        //
        // se la bag contiene un set di caratteri vuoto, torna false
        //
        if ((bag == null) || (bag.length() == 0))
            return false;
        //
        // loop cerca un carattere per volta, esci al primo false
        //
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (bag.indexOf(c) == -1) { return false; }
        }
        return true;
    }

	public static boolean isNumeric(String s)
	{
		if (s != null)
		   return existsOnlyInBag(s.trim(), "0123456789");
		
		return false;
	}

    /**
     * Sostituisce nella String s, tutte le occorrenze della String olds con la
     * String news
     * 
     * @param s
     *            la String in input
     * @param olds
     *            la String contenente la substringa da sostituire
     * @param news
     *            la String contenente la substringa nuova
     * 
     * @return la String s, con tutte le occorrenze della String old sosttuite
     *         con la String new, return null se la String s � null, return ""
     *         se la String s � vuota
     * 
     */
    public static String replaceAll(String s, String olds, String news)
    {
        if (s == null)
            return null;
        if (s.length() == 0)
            return s;
        //
        // la news pu� essere una stringa vuota !!!
        // (serve per eliminare una substringa, vedi funzione
        // successiva)
        //
        if (olds == null || news == null || olds.length() == 0) { return s; }
        //
        // alloca uno StringBuilder con size doppia rispetto alla
        // String onde evitare che lo faccia lo StringBuilder da solo
        //
        StringBuilder buf = new StringBuilder(s.length() * 2);
        int pos = 0;
        int idx = s.indexOf(olds);
        int oldLgt = olds.length();
        //
        // vai in loop a cercare nella String s le String olds
        // quando ne trovi una inserisci in StringBuilder, la
        // String s fino alla olds esclusa,poi inserisci in
        // StringBuilder la news, e poi cntinui in loop a cercare
        // la String olds nella rimanente String s.
        // Usa pos come puntatore nella String s, ed idx come
        // indice di ricerca della olds in s
        //
        while (idx >= 0)
        {
            //
            // inserisci in StringBuilder la parte di s dalla
            // precedente ricerca di olds fino a questa
            //
            buf.append(s.substring(pos, idx));
            //
            // appendi la news
            //
            buf.append(news);
            //
            // sposta indice di ricerca della lunghezza della olds
            // e cerca nuovamente
            //
            pos = idx + oldLgt;
            idx = s.indexOf(olds, pos);
        }
        //
        // ora appendi quanto resta in String s
        //
        buf.append(s.substring(pos));
        return buf.toString();
    }

    /**
     * Riceve una String che � una delimited list e la converte in uno String[];
     * in pratica esegue lo split, ma a differenza di altre fnzioni di questa
     * stessa classe il delimitatore pu� essere composto da pi� caratteri. (non
     * usa infatti la StringTokenizer)..
     * 
     * Nota : usa la StringTokenizer, che � di fatto una classe depercata, se
     * possibile usare le funzioni della 1.4 Sring[] =
     * String.split("regular_expression") o Sring[] =
     * String.split("regular_expression",int numeroitems)
     * 
     * 
     * @param s
     *            la String in input
     * @param delim
     *            la String contenente il delimitatore che pu� avere anche pi�
     *            di un carattere, in questo caso tutta la String � usata come
     *            delimitatore.
     * 
     * @return uno String[], se la String in input � null torna un String[]
     *         vuoto, se la String in input � vuota torna uno String[] con un
     *         elemento vuoto; non torna mai null
     * 
     * @see #split
     */
    public static String[] delimitedListToArray(String s, String delim)
    {
        if (s == null)
            return new String[0];
        if (delim == null || delim.length() == 0 || s.length() == 0) { return new String[] { s }; }

        StringTokenizer strTok = new StringTokenizer(s, "/");
        String[] resArray = new String[strTok.countTokens()];
        for (int i = 0; strTok.hasMoreTokens(); i++)
        {
            resArray[i] = strTok.nextToken();
        }

        return resArray;

        // List result = new ArrayList();
        // int pos = 0;
        // int delPos = 0;
        // //
        // // loop nella String, ricerca delimitatore
        // // a partire dalla posizione pos
        // //
        // while ((delPos = s.indexOf(delim, pos)) != -1)
        // {
        // result.add(s.substring(pos, delPos));
        // //
        // // prosima ricerca parti da fine delimitatore
        // //
        // pos = delPos + delim.length();
        // }
        // //
        // // inserici quello che rimane della String, se non vuoto
        // //
        // if (pos <= s.length())
        // {
        // result.add(s.substring(pos));
        // }
        // return (String[]) result.toArray(new String[result.size()]);

    }

    /**
     * Converte una Collection in una delimied String, in pratica f� la join
     * 
     * @param coll
     *            la Collection da accorpare
     * @param delim
     *            il delimitatore da usare per la join
     * @param startWithDelim
     *            indica l'inserimento di un delimitatore all'inizio della sequenza
     * @param endWithDelim
     *            la sequenza deve essere terminata con un delimitatore
     * 
     * @return una String unica
     */
    public static String joinCollection(Collection coll, String delim, boolean startWithDelim, boolean endWithDelim)
    {
        StringBuilder buf = new StringBuilder();
        if (startWithDelim)
            buf.append(delim);

        if (coll == null || coll.size() == 0) { return buf.toString(); }

        Iterator iter = coll.iterator();
        int i = 0;
        //
        // loop sulla collection
        //
        while (iter.hasNext())
        {
            if (i > 0)
            {
                buf.append(delim);
            }
            buf.append(iter.next());
            i++;
        }

        if (i > 0 && endWithDelim)
            buf.append(delim);
        return buf.toString();
    }

	public static String joinStrings(String... args) 
	{
	    return joinStrings(" ", false, false, args);	
	}
	
	public static String joinStrings(String delim, boolean startWithDelim, boolean endWithDelim, String... args) 
	{
		StringBuilder buf = new StringBuilder();
		if (delim == null)
		{
			delim = "";
			startWithDelim = false;
			endWithDelim = false;
		}
		
		if (startWithDelim)
			buf.append(delim);

		int i = 0;
		for (String s : args) {
			if (s != null) {
				if (i > 0) {
					buf.append(delim);
				}
				buf.append(s);
				i++;
			}
		}

		if (i > 0 && endWithDelim)
			buf.append(delim);
		return buf.toString();
	}
    
    public static int numberOfOccurrences(String targetString, String findString)
    {
        int retCount  = 0;
        int fromIndex = 0;
        int ndx = targetString.indexOf(findString, fromIndex);
        while(ndx >= 0)
        {
            retCount++;
            
            fromIndex = ndx + 1;
            if (fromIndex >= targetString.length()) 
                 ndx = -1;
            else ndx = targetString.indexOf(findString, fromIndex);
        }
        
        return retCount;        
    }
    
    public static String xmlString(String s)
    {
        if (s == null)
            return "";
        
        StringBuilder stb = new StringBuilder();

        int len = (s != null) ? s.length() : 0;
        for (int i = 0; i < len; i++)
        {
            char c = s.charAt(i);

            switch (c)
            {
                case '<':
                {
                    stb.append("&lt;");
                    break;
                }
                case '>':
                {
                    stb.append("&gt;");
                    break;
                }
                case '&':
                {
                    stb.append("&amp;");
                    break;
                }
                case '"':
                {
                    stb.append("&quot;");
                    break;
                }
                case '\r':
                case '\n':
                    break;

                default:
                {
                    stb.append(c);
                }
            }

        }
        return stb.toString();
    }

    private static final String randomAlphabet = "abcdefghijklmnopqrstuvxywz1234567890";
    
	public static String generateRandomAlphaString(int length, String alphabet)
	{
		if (alphabet == null)
		    alphabet = randomAlphabet;
		
	    StringBuilder stb = new StringBuilder();
	    
	    Random rnd = new Random(new java.util.Date().getTime());
	    for(int i = 0; i < length; i++)
	    {
	    	int rndVal = rnd.nextInt(alphabet.length());
	    	stb.append(alphabet.charAt(rndVal));
	    }
	    
        return stb.toString();	    	    
	}
	
	public static String generateRandomPassword()
	{
		return StringUtils.generateRandomAlphaString(8, null);
	}

     public static String convert2JSONString(java.lang.String aString)
     {
	   if (aString == null)
	           return null;
	        
	    aString = escapeSingleQuotes(aString);
        return new StringBuilder().append("'").append(aString).append("'").toString();
     }

	 public static List<Integer> findNumbers(String targetString)
	 {
		 if (targetString == null)
			 return null;
		 
		 Pattern MY_PATTERN = Pattern.compile("\\d+");
		 Matcher m = MY_PATTERN.matcher(targetString);
		 
		 List<Integer> listOfResults = null;
		 while (m.find()) 
		 {     
			 System.out.println("---" + m.groupCount());
			 String s = m.group();
			 if (listOfResults == null)
				 listOfResults = new ArrayList<Integer>();
			 
			 listOfResults.add(new Integer(s));
		 }
		 
		 return listOfResults;
	 }
	 
	 public static String getNestestFolder(String path)
	 {		 
		 return getNestestFolder(path, '/');
	 }
	 
	 public static String getNestestFolder(String path, char folderSeparator)
	 {
		 int index = path.lastIndexOf(folderSeparator);
		 if (index == -1)
			 return path;
	     return path.substring(index+1);
	 }
	 
	 public static void main(String[] args)
	 {
		 List<Integer> l = findNumbers("DOKS0000000023");
		 System.out.printf("Is Numeric: %b\n", StringUtils.isNumeric("01a23"));
	 }

	 public static String escapeDoubleQuotes(String targetString)
     {
         if (targetString == null || targetString.length() == 0 || targetString.indexOf('"') < 0)
             return targetString;

         return replace(targetString, "\"", "\\\"");
     }

	 public static String escapeSingleQuotes(String targetString)
     {
         if (targetString == null || targetString.length() == 0 || targetString.indexOf('\'') < 0)
             return targetString;

         return replace(targetString, "'", "\\'");
     }

	public static StringBuilder escapeString(StringBuilder stb, String s, String alphabet)
	{
		if (s == null)
			return stb;

		
		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if (alphabet.indexOf(c) < 0)
			{
				stb.append(c);
			}
			else
			{
				switch (c)
				{
				case '\r':
				case '\n':
					break;
				case '"':
					stb.append("\\\"");
					break;
					
				case '\'':
					stb.append("\\'");
					break;
				default:
				
					stb.append(c);
				
				}
			}

		}
		return stb;
	}

    public static String getString(String aSringValue, String ifIsNullValue)
    {
    	if (aSringValue == null)
    		return ifIsNullValue;

    	return aSringValue;
    }

    public static String testString(String aSringValue, String matchedValue, String ifEqualsValue, String ifDoesntEqualsValue)
    {
    	if (aSringValue == null || matchedValue == null)
    		return ifDoesntEqualsValue;

	    if (aSringValue.equalsIgnoreCase(matchedValue))
	    	return  ifEqualsValue;
	       	
    	return ifDoesntEqualsValue;
    }

	public static boolean findStringInArray(String[] items, String s)
	{
		boolean contains = false;
		
		if (items != null)
		{
		for (String item : items) {
		    if (s.equalsIgnoreCase(item)) {
		        contains = true;
		        break; // No need to look further.
		    } 
		}
		}

		return contains;
	}

	public static String getStringFromInputStream(InputStream is) {
		 
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
 
		String resultString = null;
		
		String line;
		try {
 
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			resultString = DTOBase.nullOnEmpty(sb.toString());
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
 
		return resultString;
 
	}

	public static String sliceTokens(String s, char delimiter, int indexOfFirstToken)
	{		
		String res = s;
        if (indexOfFirstToken > 0 && s != null)
        {
        	int ndx = -1;
        	int startndx = 0;
        	while(indexOfFirstToken > 0)
        	{
        		ndx = res.indexOf(delimiter, startndx);
        		if (ndx < 0)
        			return (startndx == 0) ? res : res.substring(startndx);
        		
        		indexOfFirstToken--;
        		startndx = ndx + 1;
        	}
        	
        	return res.substring(startndx);
        }
		return null;
	}

//	public static String getToken(String s, String delimiters, int indexOfToken)
//	{		
//		StringTokenizer strTok = new StringTokenizer(s, delimiters);
//		indexOfToken--;	
//		while(strTok.hasMoreTokens())
//		{
//			String t = strTok.nextToken();
//			if (indexOfToken <= 0)
//				return t;
//			
//			indexOfToken--;			
//		}
//		
//		return null;
//	}
}