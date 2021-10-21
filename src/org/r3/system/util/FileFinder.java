package org.r3.system.util;

import java.io.File;
import java.util.Vector;

// Referenced classes of package com.ibm.filemanagement:
//            FunctionBean

public class FileFinder
{
    private Vector searchResult;
    private boolean returnResultVector = true;

    private Vector operations;
    private Vector strings;
    private String arbString;
    private String arbChar;
            String emptyString;
    private Vector fileFoundEventListeners;
            String fieldIllegalSimbols;
            String fieldMultipleCharacterPattern;
            String fieldSingleCharacterPattern;
            boolean fieldRecurse;
            String fieldResultLastFoundFilename;
            String fieldInputPath;
            String fieldInputPattern;
            String fieldResultListOfFilenames[];
            boolean patExtEmpty;
            boolean tagExtEmpty;
            int fieldResultCountOfFoundFiles;

    public FileFinder()
    {
        searchResult                  = new Vector();
        operations                    = new Vector();
        strings                       = new Vector();
        arbString                     = "*";
        arbChar                       = "?";
        emptyString                   = "";
        fieldIllegalSimbols           = "<>|";
        fieldMultipleCharacterPattern = "*";
        fieldSingleCharacterPattern   = "?";
        fieldRecurse                  = false;
        fieldResultLastFoundFilename  = "";
        fieldInputPath                = "";
        fieldInputPattern             = "";
        fieldResultListOfFilenames    = new String[0];
        patExtEmpty                   = false;
        tagExtEmpty                   = false;
        fieldResultCountOfFoundFiles  = 0;
        returnResultVector = true;
    }

    public void addFileFoundListener(FileFoundListener l)
    {
        if (fileFoundEventListeners == null) fileFoundEventListeners = new Vector();
        fileFoundEventListeners.addElement(l);
    }

    protected void fireFileFoundEvent(String resPath)
    {
        if (fileFoundEventListeners == null) return;
        if(fileFoundEventListeners.isEmpty())
            return;
        FileFoundEvent ev = new FileFoundEvent(this, resPath);
        for(int i = 0; i < fileFoundEventListeners.size(); i++)
            ((FileFoundListener)fileFoundEventListeners.elementAt(i)).fileFound(ev);

    }

    public void removeFileFoundListener(FileFoundListener l)
    {
        if (fileFoundEventListeners == null) return;
        if(fileFoundEventListeners.isEmpty())
        {
            return;
        } else
        {
            fileFoundEventListeners.removeElement(l);
            return;
        }
    }

    public void setReturnResultVector(boolean b)
    {
      returnResultVector = b;
    }

    public String getInputPath()
    {
        return fieldInputPath;
    }

    public String getInputPattern()
    {
        return fieldInputPattern;
    }

    public String getMultipleCharacterPattern()
    {
        return fieldMultipleCharacterPattern;
    }

    public boolean getRecurse()
    {
        return fieldRecurse;
    }

    public int getResultCountOfFoundFiles()
    {
        // fieldResultCountOfFoundFiles = searchResult.size();
        return fieldResultCountOfFoundFiles;
    }

    public String getResultLastFoundFilename()
    {
        return fieldResultLastFoundFilename;
    }

    public String[] getResultListOfFilenames()
    {
        return fieldResultListOfFilenames;
    }

    public String getSingleCharacterPattern()
    {
        return fieldSingleCharacterPattern;
    }

    private boolean match(String aTarget, String aPattern)
    {
    	boolean b = aTarget.matches(aPattern);
    	
		 
    	return b; 
    	
//        String target  = aTarget;
//        String pattern = aPattern;
//        if(aTarget == null)
//            throw new IllegalArgumentException("aTarget is null");
//        if(aPattern == null)
//            throw new IllegalArgumentException("aPattern is null");
//        if(pattern.equals("*.*"))
//            pattern = "*";
//        if(pattern.equals(arbString))
//            return true;
//        if(target.equals(pattern))
//            return true;
//        if(patExtEmpty && target.length() == 1 && tagExtEmpty && pattern.equals("."))
//        {
//            patExtEmpty = false;
//            tagExtEmpty = false;
//            return true;
//        }
//        if(target.equals(emptyString))
//            return false;
//        if(pattern.equals(emptyString))
//            return false;
//        if(pattern.substring(0, 1).equals(arbString) && pattern.substring(1, 2).equals(arbString))
//            pattern = pattern.substring(1);
//        else
//        if(pattern.substring(0, 1).equals(arbString) && pattern.substring(1, 2).equals(arbChar))
//        {
//            pattern = arbChar + arbString + pattern.substring(2);
//        } else
//        {
//            if(pattern.substring(0, 1).equals(arbChar))
//                return match(target.substring(1), pattern.substring(1));
//            if(pattern.substring(0, 1).equals(arbString))
//            {
//                for(int i = 0; i < target.length(); i++)
//                    if(match(target.substring(i), pattern.substring(1)))
//                        return true;
//
//                return false;
//            }
//            if(pattern.substring(0, 1).equals(target.substring(0, 1)))
//                return match(target.substring(1), pattern.substring(1));
//            else
//                return false;
//        }
//        return match(target, pattern);
    }


    private void searchFolder(String path)
    {
        //System.out.println("Searching folder: " + path);
        File f = new File(path);
        String list[] = f.list();
        if(list == null)
            return;
        for(int i = 0; i < list.length; i++)
        {
            File file = new File(path + list[i]);
            if(file.isFile())
            {
                if(list[i].indexOf(".") == -1)
                    tagExtEmpty = true;
                else
                    tagExtEmpty = false;
                if(fieldInputPattern.charAt(fieldInputPattern.length() - 1) == '.')
                    patExtEmpty = true;
                if(match(list[i].toLowerCase(), fieldInputPattern.toLowerCase()))
                {
                    String resultPath = file.getPath();
                    // If this flag is true I populate the vector of the results.
                    if (returnResultVector)
                           searchResult.addElement(resultPath);
                    fireFileFoundEvent(resultPath);
                    fieldResultLastFoundFilename = resultPath;
                    fieldResultCountOfFoundFiles += 1;
                }
            } else
            if(fieldRecurse)
            {
                searchFolder(path + list[i] + System.getProperty("file.separator"));
            }
        }

    }

    public void setIllegalSymbols(String illegalSymbols)
    {
        fieldIllegalSimbols = illegalSymbols;
    }

    public void setInputPath(String inputPath)
    {
        if(inputPath == null)
            throw new IllegalArgumentException("Can not set inputPath to null!");
        fieldInputPath = inputPath;
    }

    public void setInputPattern(String inputPattern)
    {
        if(inputPattern == null || inputPattern.length() == 0)
            return;
        if(inputPattern == ".")
            return;
        fieldInputPattern = inputPattern;
    }

    public void setMultipleCharacterPattern(String multipleCharacterPattern)
    {
        fieldMultipleCharacterPattern = multipleCharacterPattern;
        if(multipleCharacterPattern == null || multipleCharacterPattern.length() == 0)
            throw new IllegalArgumentException("Can not set multipleCharacterPattern to null!");
        fieldMultipleCharacterPattern = multipleCharacterPattern;
        if(multipleCharacterPattern.length() == 1)
        {
            arbString = multipleCharacterPattern;
        } else
        {
            arbString = multipleCharacterPattern.substring(0, 1);
            fieldMultipleCharacterPattern = arbString;
        }
    }

    public void setRecurse(boolean recurse)
    {
        fieldRecurse = recurse;
    }

    public void setSingleCharacterPattern(String singleCharacterPattern)
    {
        if(singleCharacterPattern == null || singleCharacterPattern.length() == 0)
            throw new IllegalArgumentException("Can not set singleCharacterPattern to null!");
        if(singleCharacterPattern.length() == 1)
            fieldSingleCharacterPattern = singleCharacterPattern;
        else
            fieldSingleCharacterPattern = singleCharacterPattern.substring(0, 1);
        arbChar = fieldSingleCharacterPattern;
    }

    public FileActionErrorEvent process()
    {
        searchResult.removeAllElements();
        FileActionErrorEvent ret = null;
        if(fieldInputPath.equals(""))
        {
            return new FileActionErrorEvent(-1, "InputPath not specified");
        }
        if(fieldInputPattern.equals(""))
        {
            return new FileActionErrorEvent(-2, "InputPattern not specified");
        }
        if(fieldMultipleCharacterPattern.equals(""))
        {
            return new FileActionErrorEvent(-3, "FileFinder environment not properly set");
        }
        if(fieldSingleCharacterPattern.equals(""))
        {
            return new FileActionErrorEvent(-3, "FileFinder environment not properly set");
        }
        for(int i = 0; i < fieldIllegalSimbols.length(); i++)
            if(fieldInputPath.indexOf(fieldIllegalSimbols.charAt(i)) != -1)
            {
                return new FileActionErrorEvent(-4, "InputPath contains invalid symbols");
            }

        File path = new File(fieldInputPath);
        if(!path.exists() || !path.isDirectory())
        {
            return new FileActionErrorEvent(-5, "InputPath not valid");
        }
        searchFolder(fieldInputPath);
        if(!searchResult.isEmpty())
        {
            String arr[] = new String[searchResult.size()];
            searchResult.copyInto(arr);
            fieldResultListOfFilenames = new String[arr.length];
            System.arraycopy(arr, 0, fieldResultListOfFilenames, 0, arr.length);
            fieldResultCountOfFoundFiles = searchResult.size();
        }
        return ret;
    }

    public static void main(String[] argv)
    {

      FileFinder finder = new FileFinder();
      finder.setInputPattern("FIL*");
      finder.setInputPath("/opt/httpd/jakarta-tomcat/webapps/electio/data/");
      finder.setRecurse(true);
      FileActionErrorEvent act = finder.process();
      if (act == null)
        {
          int ct = 0;
          //System.out.println("CountOfFields: " + (ct = finder.getResultCountOfFoundFiles()));
          if (ct>0)
          {
            String[] res = finder.getResultListOfFilenames();
            //for(int i=0; i<ct; i++ )  System.out.println("File: " + res[i]);
          }
        }
      else
        {
          //System.out.println("Error: " + act.getReason());
        }
    }

}

