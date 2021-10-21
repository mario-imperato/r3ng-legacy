package org.r3.system.util;


public class FileActionErrorEvent
{
  private int    errCode;
  private String errReason;

  public FileActionErrorEvent(int c, String s)
  {
     errCode   = c;
     errReason = s;
  }

  public int getCode()
  {
     return errCode;
  }

  public String getReason()
  {
     return errReason;
  }

}

