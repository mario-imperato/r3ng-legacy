package org.r3.db.system.lut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class LUTTable
{
  private ArrayList    orderedItems;
  private HashMap      items;

  // private   boolean        _isTimed = false;
  private   String         language = null;


  public int    getSize()
  {
     return orderedItems.size();
  }

  public LUTTable()
  {
    orderedItems = new ArrayList();
    items        = new HashMap();
    // _isTimed     = false;         // By default this LUT never expires.
    language = null;
  }

  public String getLanguage()
  {
    return language;
  }

  public void setLanguage(String  l)
  {
    language = l;
  }

//  public boolean isTimed()
//  {
//    return _isTimed;
//  }
//
//  public void setIsTimed(boolean b)
//  {
//    _isTimed = b;
//  }

  public boolean itemPresent(String key)
  {
    return items.get(key.trim().toLowerCase()) != null;
  }

  public boolean itemPresent(int key)
  {
    return items.get(Integer.toString(key)) != null;
  }

  public ILUTItem getItem(String key)
    throws LUTException
  {
    if(key == null)
    {
      LUTException exc = new LUTException("String key argument cannot be null.");
      exc.printStackTrace();
      throw exc;
    }
    
    ILUTItem item = (ILUTItem)items.get(key.trim().toLowerCase());
    return item;
  }

  public ILUTItem getItem4Site(String aSite, String attachmentTypeId) throws LUTException
  {
		String dtokey = new StringBuilder().append(aSite).append('_').append(attachmentTypeId).toString();
	    return getItem(dtokey);
  }
  
  public ILUTItem getItem(int key)
    throws LUTException
  {
    ILUTItem item = (ILUTItem)items.get(Integer.toString(key));
    return item;
  }

  // These two functions are a variations in that they try to retrieve the key resulting
  // from prefixing the passed key. If it fails they attempt to find the original one.
  // If the prefix is null it just reverts to the usual case.
  public ILUTItem getItem(String prefix, String key)
    throws LUTException
  {
    if(key == null)
    {
        LUTException exc = new LUTException("String key and prefix arguments cannot be null.");
        exc.printStackTrace();
        throw exc;
    }

    if (prefix == null) return getItem(key);

    key = key.trim().toLowerCase();
    prefix = prefix.trim().toLowerCase();

    String searchFor = prefix + key;
    ILUTItem item = (ILUTItem)items.get(searchFor);
    if (item == null)
        item = (ILUTItem)items.get(key);

    return item;
  }

  public ILUTItem getItem(String prefix, int key)
    throws LUTException
  {
      return getItem(prefix, Integer.toString(key));
  }

  // In the unfortunate case of duplicates keys only the first one gets stored.
  public void setItem(String key, ILUTItem item)
    throws LUTException
  {
    if(key == null)
    {
        LUTException exc = new LUTException("String key argument cannot be null.");
        exc.printStackTrace();
        throw exc;
    }
    
    if(item == null)
    {
        LUTException exc = new LUTException("LookupTableItem item argument cannot be null.");
        exc.printStackTrace();
        throw exc;
    }

    String locBuf = key.trim().toLowerCase();
    if (items.get(locBuf) == null) 
    {
        items.put(locBuf, item);
        orderedItems.add(item);
    }

  }

  public void setItem(int key, ILUTItem item)
    throws LUTException
  {
      setItem(Integer.toString(key), item);
  }

  public String getDescription(String key)
    throws LUTException
  {
    if(key == null)
    {
        LUTException exc = new LUTException("String key argument cannot be null.");
        exc.printStackTrace();
        throw exc;
    }

    ILUTItem item = getItem(key);
    if(item == null)
    {
        LUTException exc = new LUTException("Key not found.");
        exc.printStackTrace();
        throw exc;
    }

    return(item.getDtodescr());
  }

  public String getDescription(int key)
    throws LUTException
  {
    ILUTItem item = getItem(key);
    if(item == null)
    {
        LUTException exc = new LUTException("Key not found.");
        exc.printStackTrace();
        throw exc;
    }

    return(item.getDtodescr());
  }

  public Iterator keys()
  {
    return items.keySet().iterator();
  }

  public Iterator elements()
  {
    return elements(null);
  }

  public Iterator elements(ILUTVisitor aVisitor)
  {
     return new LUTIterator(orderedItems.listIterator(), aVisitor);
  }
  
}
