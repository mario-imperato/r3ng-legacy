package org.r3.ws.system.country;


import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.country.CountryFilter;
import org.r3.db.system.country.CountryPersistence;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.system.rest.LUTConditionalGetPattern;
import org.r3.system.rest.ServiceEnvironment;

public class GETCountryLUTItems extends LUTConditionalGetPattern
{

	public GETCountryLUTItems(ServletContext ctx,  ServiceEnvironment serviceEnvironment)
	{
		super(ctx, serviceEnvironment,LUTName.country.toString());
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		CountryPersistence p = CountryPersistence.createPersistenceObject(pcfg, aSession);

		CountryFilter filter = new CountryFilter();
		filter.setOrderByClause(" countryname ");
				
		return p.query(filter, pcfg.getPersistenceConfigInfo(), "1", 0, -1, false);
	}

}
