package org.r3.system.util;

import java.util.ArrayList;
import java.util.List;

public class Property
{
    private String paramName;
    private String paramValue;
    
    public Property(String aName, String aValue)
    {
        paramName = aName;
        paramValue = aValue;
    }
        
    public String getName()    
    {
        return paramName;
    }
    
    public String getValue()
    {
        return paramValue;
    }

    public static List<Property> parseUrlEncodedParameters(String configuration)
    {
        List<Property> listOfParameters = null;
        if (configuration != null)
           {
               String[] parameters = configuration.split("&|=");
               if (parameters != null && parameters.length > 0)
               {
                   if (listOfParameters == null)
                       listOfParameters = new ArrayList<Property>();
                   
                   for(int i = 0; (i + 1) < parameters.length ; i +=2 )
                   {
                       listOfParameters.add(new Property(parameters[i], parameters[i+1]));
                   }
               }
           }
        return listOfParameters;
    }

}
