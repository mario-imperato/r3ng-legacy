package org.r3.system.struts;

import javax.servlet.ServletContext;

public class ActionEnvironment
{
  private int    alertPollingInterval = 10 * 60 * 1000;
  private String systemAlerts         = null;
  private long   alertTimestamp       = -1;

  private String busySiteWarning        = null;
  private long   busySiteWarningTimeout = -1;
  private int    numberOfUsers          = 0;

  private int    busySiteLowerBound =  40;
  private int    busySiteUpperBound = 150;

  public ActionEnvironment()
  {
    systemAlerts           = null;
    alertTimestamp         = -1;
    busySiteWarning        = null;
    busySiteWarningTimeout = -1;
    numberOfUsers          = 0;
  }

  private static final String environmentAttrName = "GWF__RESERVED_CTRL_ENVIRONMENT_";

  public static ActionEnvironment getInstance(ServletContext sc)
  {
    ActionEnvironment env = (ActionEnvironment)sc.getAttribute(environmentAttrName);
    if (env == null)
    {
       env = new ActionEnvironment();
       sc.setAttribute(environmentAttrName, env);
    }
    return env;
  }

  public String getSystemAlerts()
  {
    return systemAlerts;
  }

  public void setSystemAlerts(String a)
  {
    systemAlerts = a;
  }

  public void setSystemAlertsTimestamp(long a)
  {
    alertTimestamp = a;
  }

  public long getSystemAlertsTimestamp()
  {
    return alertTimestamp;
  }

  public long getAlertPollingInterval()
  {
    return alertPollingInterval;
  }

  // Return true if the current number of users exceeds the limits.
  public boolean addUser()
  {
     numberOfUsers ++;
     if (numberOfUsers > busySiteUpperBound) return true;

     return false;
  }

  public int getNumberOfUsers()
  {
     return numberOfUsers;
  }

  public boolean removeUser()
  {
     numberOfUsers --;
     if (numberOfUsers < 0) numberOfUsers = 0;
     if (numberOfUsers < busySiteLowerBound)  return false;

     return true;
  }

  public String getBusySiteWarning()
  {
    if (busySiteWarning != null)
    {
         if (busySiteWarningTimeout > 0)
         {
            long  currTime = System.currentTimeMillis();
            if (currTime > busySiteWarningTimeout)
            {
               busySiteWarning        = null;
               busySiteWarningTimeout = -1;
            }
         }
    }

    return busySiteWarning;
  }

  public void setBusySiteWarning(String a, long timeoutDuration)
  {
    busySiteWarning = a;
    busySiteWarningTimeout = timeoutDuration;
  }

  public void clearBusySiteWarning()
  {
    busySiteWarning        = null;
    busySiteWarningTimeout = -1;
  }

  public void setBusySiteBounds(int low, int high)
  {
    busySiteLowerBound = low;
    busySiteUpperBound = high;
  }

  public int getBusySiteLowerBound()
  {
     return busySiteLowerBound;
  }

  public int getBusySiteUpperBound()
  {
     return busySiteUpperBound;
  }

}

