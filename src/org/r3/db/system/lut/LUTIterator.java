/*
 * Created on 19-ago-2005
 *
 */
package org.r3.db.system.lut;

import java.util.Iterator;

/**
 * @author Administrator
 *
 */
public class LUTIterator implements Iterator
{
    Iterator   iterator   = null;
    ILUTVisitor lutVisitor = null;

    // In case a visitor has been set I need to keep a currentItem
    // in order to determine an hasNext() condition in synch with
    // the next function.
    ILUTItem    currentItem = null;
    
    /**
     * 
     */
    public LUTIterator(Iterator anIterator, ILUTVisitor aVisitor)
    {
        super();
        iterator = anIterator;
        lutVisitor = aVisitor;
    }
    
    /* (non-Javadoc)
     * @see java.util.Iterator#remove()
     */
    public void remove()
    {
        if (iterator != null)  iterator.remove();
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#hasNext()
     */
    public boolean hasNext()
    {
        if (iterator == null)                 return false;        
        if (lutVisitor == null)               return iterator.hasNext();        
        if (findNextItem(lutVisitor) != null) return true;
                     
        return false;
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#next()
     */
    public Object next()
    {
        if (iterator == null)    return null;
        if (lutVisitor == null)  return iterator.next();

        return nextItem(lutVisitor);
    }

    protected Object nextItem(ILUTVisitor aVisitor)
    {
        Object theItem = findNextItem(aVisitor);
        currentItem = null;
        return theItem;
    }

    protected Object findNextItem(ILUTVisitor aVisitor)
    {
        while(currentItem == null && iterator.hasNext())
        {
           currentItem = (ILUTItem)iterator.next();
           if (!aVisitor.accept(currentItem))  currentItem = null;
        }
        
        return currentItem;
    }
}
