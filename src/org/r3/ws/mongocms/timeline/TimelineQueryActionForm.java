package org.r3.ws.mongocms.timeline;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.r3.db.mongo.timelinecollection.TimelineCollectionDTO;
import org.r3.db.utils.DataTableQueryActionForm;


public class TimelineQueryActionForm extends DataTableQueryActionForm
{
    

	public Query<TimelineCollectionDTO>  getSearchCondition(Datastore ds, String targetSite)
	{
		Query<TimelineCollectionDTO> filter = ds.createQuery(TimelineCollectionDTO.class);						
		filter.field(TimelineCollectionDTO.SITE).equal(targetSite);				
		
		if (isDefaultSorting())
		     filter.order(" timelineid ");
		else filter.order(getMongoSortingCondition());
		
		return filter;
	}
}
