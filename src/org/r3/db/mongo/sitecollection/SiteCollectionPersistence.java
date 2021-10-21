//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//

package org.r3.db.mongo.sitecollection;

import java.util.List;

import org.mongodb.morphia.query.Query;

public class SiteCollectionPersistence extends SiteCollectionPersistenceBase
{
	public static SiteCollectionPersistence createPersistenceObject(org.r3.db.MongoPersistenceContext pcfg)
	{
		SiteCollectionPersistence p = new SiteCollectionPersistence();
		return p;
	}

	public int count(Query<SiteCollectionDTO> query)
	{
		return (int)query.countAll();
	}

	public SiteCollectionDataTableAdapter query(Query<SiteCollectionDTO> query, String sEcho, int iDisplayStart, int iDisplayLength, boolean countElements)
	{
		int numberOfItems = (countElements) ? count(query) : -1;    	
		List<SiteCollectionDTO> l = null;
    	if (numberOfItems != 0)
    	{
    		if (iDisplayStart > 0)
    			query.offset(iDisplayStart);
    		
    		if (iDisplayLength > 0)
    			query.limit(iDisplayLength);
    	
		    l = query.asList();
        }

		SiteCollectionDataTableAdapter dt = new SiteCollectionDataTableAdapter();
		dt.setsEcho(sEcho);
		  
		if (numberOfItems >= 0)
		{
		     dt.setiTotalRecords(numberOfItems);
		     dt.setiTotalDisplayRecords(numberOfItems);
		}
		else
		{
		     if (l != null)
		     {
		     dt.setiTotalRecords(l.size());
		     dt.setiTotalDisplayRecords(l.size());
		     }
		     else
		     {
		     dt.setiTotalRecords(0);
		     dt.setiTotalDisplayRecords(0);
		     }
		}
		     
		dt.setAaData(l);		
		return dt;		  
	}
}
