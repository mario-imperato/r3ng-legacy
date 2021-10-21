package org.r3.system.util;

import java.util.HashMap;
import java.util.Iterator;

public class String2IntMap
{
    private HashMap  commands = null;

    public String2IntMap()
    {
        super();
        commands = new HashMap();
    }
    
    public void put(String aStringKey, int anIntegerValue)
    {
        commands.put(aStringKey.toUpperCase(), new Integer(anIntegerValue));
    }

    public int get(String t)
    {
        return get(t, false);
    }
    
    public int get(String t, boolean likeMatch)
    {
        if (likeMatch)
        {
            // Viene richiesto un match parziale.... debbo iterare sulle chiavi per trovare la stringa completa e tirar fuori
            // il valore numerico.
            Iterator iter = commands.keySet().iterator();
            for( ; iter.hasNext(); )
            {
                String  k    = (String)iter.next();
                if (t.indexOf(k) >= 0)
                {
                   Integer iObj = (Integer)commands.get(k);
                   return iObj.intValue();
                }
            }
            
            return -1;
        }
        else
        {
          // Viene richiesto un match esatto, non debbo iterare, utilizzo la funzione base della mappa.
          Integer tok = (Integer)commands.get(t.toUpperCase());
          if (tok == null)
          {
               return -1;
          }
          return tok.intValue();          
        }
    }
    
    public String get(int iVal)
    {
        Iterator iter = commands.keySet().iterator();
        for( ; iter.hasNext(); )
        {
            String  k    = (String)iter.next();
            Integer iObj = (Integer)commands.get(k);
            if (iObj.intValue() == iVal)
                return k;
        }
        
        return null;
    }

}
