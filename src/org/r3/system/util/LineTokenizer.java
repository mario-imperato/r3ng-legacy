package org.r3.system.util;


import java.util.Vector;

public class LineTokenizer
{
  protected String  line;
  protected char  separator;
  protected char  escape;

  protected int     curChar;
  protected boolean finished;
  protected boolean useEscape;
  private static boolean verbose = false;


  public LineTokenizer(String line)
  {
    this.line = new String(line);
    
    curChar   = 0;
    separator = ';';
    escape    = '\"';
    useEscape = true;    
    finished  = false;
  }

  public boolean getUseEscape()
  {
    return useEscape;
  }

  public void setUseEscape(boolean useEscape)
  {
    this.useEscape = useEscape;
  }
  
  public char getSeparator()
  {
    return separator;
  }

  public void setSeparator(char separator)
  {
    this.separator = separator;
  }

  public void setSeparator(String separator)
  {
    if (separator.length() == 1)
    {
      this.separator = separator.charAt(0);
    }
    else
    {
      System.out.println("the separator has not been set:");	
      System.out.println("it has to be a single character");	
    }
  }
  
  public char getEscape()
  {
    return escape;
  }

  public void setEscape(char escape)
  {
    this.escape = escape;
  }

  public void setEscape(String escape)
  {
    if (escape.length() == 1)
    {
      this.escape = escape.charAt(0);
    }
    else
    {
      System.out.println("the escape has not been set:");	
      System.out.println("it has to be a single character");	
    }
  }
 
  
  public String nthToken(int nth)
  {
    // If the end had already been reached before, return
    // a null value.
    //
    if(finished)
      return null;
    
    int cont = 1;
    if (line.length() > curChar)
    {
      while (cont < nth)
      {
        String res = skipToken();	
        if (res == null)
        {
          return null;	
        }
        cont ++;
      }
    }
    String nt = nextToken();
    reset();
    return nt;
  }

  private String skipToken()
  {
    //System.out.println("*skipToken()* curChar= "+curChar);
    if (curChar < 0)
      return null;
      
    if(finished)
      return null;
    
    int index = 0;
    if (line.length() > curChar)
    {		
      if (line.charAt(curChar) == escape)
      {
        index = curChar + 1;
	while ( (index = line.indexOf(escape,index)) >= 0 )
	{
          if (verbose) System.out.println("index= " + index);         
	  if ( line.length() > index + 1 )
	  {
	    if (line.charAt(index + 1) == escape)
	    {
	      index = index + 2;
            }
            else
            {
	      curChar = line.indexOf(separator, index);
	      if (verbose) System.out.println("curChar= " + curChar);     
	      if (curChar < 0)
	      {
	        return null;
	      }
	      else
	      {
	        curChar ++;
	        return "OK";
	      }
            }	
          }
	}
      }
      else
      {
        curChar = line.indexOf(separator, curChar);
        if (verbose) System.out.println("curChar= "+curChar);
        if (curChar < 0)
        {
	  return null;	 
        }
        else
        {
          curChar ++;
        }
      }
    }
    else
    {
      reset();
      return null;
    }
    return "OK";
  }
  
  public int getTokenNum()
  {
    curChar = 0;
    finished = false;
    int cont = 0;
    
    while (!finished)
    {
      //System.out.println("cont= "+ cont);
      String res = nextToken();
      //System.out.println("res= " + res);	
      if (res == null)
      {
        break;
      }
      cont ++;
    }
    if (curChar < 0)
    {
      cont ++;    
    }
    reset();
    return cont;
  }
  
  
  public String nextToken()
  {
    String ret;
    
    // If the end had already been reached before, return
    // a null value.
    //
    if(finished)
      return null;
	
    // look for " at the beginning of the field
    // different possible situations
    // if the original field is ciao"carlo 
    //       in the csv mode is "ciao""carlo" 
    // if the original field is ciao;carlo
    //       in the csv mode is	"ciao;carlo"
    if (line.length() > curChar)
    {		
      if ( (line.charAt(curChar) == escape) && useEscape )
      {
	 int index = curChar + 1;
         while ( (index = line.indexOf(escape,index)) >= 0 )
	 {
	   if ( line.length() > index + 1 )
	   {
	     if (line.charAt(index + 1) == escape)
	     {
	       index = index + 2;
             }
             else
             {
               ret     = line.substring(curChar + 1, index);
               curChar = line.indexOf(separator, index);   
               if (curChar < 0)
               {
               	 
               }
               else
               {
                 curChar ++;
               }
               ret = cutEscape(ret);
               return ret;
             }
           }
           else
           {
             ret = line.substring(curChar + 1, index);
             finished = true;
             ret = cutEscape(ret);
             return ret;
           }
         }
       }
    }

    // Look for the separator, starting from the current
    // character.
    //
    //System.out.println("curChar=" + curChar);
    int index = line.indexOf(separator, curChar);
    //System.out.println("index=" + index);
    
    if (index < 0 && line.trim().length() == 0)
    {
      finished = true;	
      return "";
    }
    
    if (index < 0 && line.charAt(line.length()-1) == separator) 
    {   
      finished = true;	
      return "";
    }

    // Token not found.
    //
    if(index < 0)
    {
      // Set the finished flag.
      //
      finished = true;
      
      if (curChar == line.length())
      {
        return "";	
      }
      // Get the remainder of the line.
      //
      //ret = line.substring(curChar).trim();
      ret = line.substring(curChar);
      //System.out.println("ret=" + ret);

      // Check if something has been obtained. If the remainder
      // has zero length, return a null value, otherwise return
      // that portion of the line.
      //
      if(ret.length() == 0)
        return null;
      else
      {
        return ret;
      }
    }


    // Token is found. Return the value.
    //
    //ret = line.substring(curChar, index).trim();
    ret = line.substring(curChar, index);
    curChar = index + 1;
    return ret;
  }
  
  // elimina le doppie virgolette in eccesso
  public String cutEscape(String ret)
  {
    int index1 = 0;
    int index2 = 0;
    String retApp = "";
    while ( (index2 = ret.indexOf(escape, index1)) >= 0)
    {
      retApp += ret.substring(index1, index2 + 1);
      index1 = index2 + 2;
    }
    retApp += ret.substring(index1,ret.length());
    ret = retApp;
    return ret;
  }

  public void reset()
  {
    curChar  = 0;
    finished = false;
  }
  
  public static void main( String[] argv )
    throws Exception
    {
      Vector res = new Vector();
      LineTokenizer lt = new LineTokenizer("");
      lt.setSeparator(',');
      lt.setEscape("\"");
      lt.setUseEscape(true);
      String buffer = null;
      while ((buffer = lt.nextToken()) != null)
      {
        res.add(buffer);
      }
      System.out.println("res= " + res);
      //junit.textui.TestRunner.run(LineTokenizerTest.suite());
    }
}
