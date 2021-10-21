package org.r3.ws.system.sitecollection;

import javax.ws.rs.FormParam;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.geo.GeoJson;
import org.mongodb.morphia.geo.Point;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.DTOBase;
import org.r3.db.mongo.MongoGeoCodeLocationName;
import org.r3.db.mongo.sitecollection.SiteCollectionDTO;
import org.r3.db.mongo.usercollection.UserCollectionDTOBase.AddressDTO;
import org.r3.db.mongo.usercollection.UserCollectionDTOBase.AddressGeomDTO;

public class AddressActionForm
{
	@FormParam("street_number")
	private String street_number               ;    

	public String getStreet_number()    { return DTOBase.nullOnEmpty(street_number); }

	@FormParam("locality")
	private String locality                    ;

	public String getLocality()    { return DTOBase.nullOnEmpty(locality); }

	@FormParam("route")
	private String route                       ;

	public String getRoute()    { return DTOBase.nullOnEmpty(route); }

	@FormParam("administrative_area_level_3")
	private String administrative_area_level_3 ;

	public String getAdministrative_area_level_3()    { return DTOBase.nullOnEmpty(administrative_area_level_3); }

	@FormParam("administrative_area_level_3_id")
	private String administrative_area_level_3_id;

	public String getAdministrative_area_level_3_id()    { return DTOBase.nullOnEmpty(administrative_area_level_3_id); }

	public MongoGeoCodeLocationName getAdministrative_area_level_3GeoCodeLocationName()
	{
		MongoGeoCodeLocationName m = null;
		
		String c = getAdministrative_area_level_3();
		if (c != null)
		{
			m = new MongoGeoCodeLocationName();
			m.setName(c);
			m.setLocationid(getAdministrative_area_level_3_id());
		}
		return m;
	}
	
	@FormParam("administrative_area_level_2")
	private String administrative_area_level_2 ;

	public String getAdministrative_area_level_2()    { return DTOBase.nullOnEmpty(administrative_area_level_2); }

	@FormParam("administrative_area_level_2_id")
	private String administrative_area_level_2_id;

	public String getAdministrative_area_level_2_id()    { return DTOBase.nullOnEmpty(administrative_area_level_2_id); }

	public MongoGeoCodeLocationName getAdministrative_area_level_2GeoCodeLocationName()
	{
		MongoGeoCodeLocationName m = null;
		
		String c = getAdministrative_area_level_2();
		if (c != null)
		{
			m = new MongoGeoCodeLocationName();
			m.setName(c);
			m.setLocationid(getAdministrative_area_level_2_id());
		}
		return m;
	}
	
	@FormParam("administrative_area_level_1")
	private String administrative_area_level_1 ;

	public String getAdministrative_area_level_1()    { return DTOBase.nullOnEmpty(administrative_area_level_1); }

	@FormParam("administrative_area_level_1_id")
	private String administrative_area_level_1_id;

	public String getAdministrative_area_level_1_id()    { return DTOBase.nullOnEmpty(administrative_area_level_1_id); }

	public MongoGeoCodeLocationName getAdministrative_area_level_1GeoCodeLocationName()
	{
		MongoGeoCodeLocationName m = null;
		
		String c = getAdministrative_area_level_1();
		if (c != null)
		{
			m = new MongoGeoCodeLocationName();
			m.setName(c);
			m.setLocationid(getAdministrative_area_level_1_id());
		}
		return m;
	}
	
	@FormParam("country")
	private String country                     ;

	public String getCountry()    { return DTOBase.nullOnEmpty(country); }

	public MongoGeoCodeLocationName getCountryGeoCodeLocationName()
	{
		MongoGeoCodeLocationName m = null;
		
		String c = getCountry();
		if (c != null)
		{
			m = new MongoGeoCodeLocationName();
			m.setName(c);			
		}
		return m;
	}
	
	@FormParam("postal_code")
	private String postal_code                 ;

	public String getPostal_code()    { return DTOBase.nullOnEmpty(postal_code); }

	@FormParam("location")
	private String location                    ;

	public String getLocation()    { return DTOBase.nullOnEmpty(location); }

	public Point getLocationAsGeoJsonPoint()
	{
		Point o = null;
		String l = getLocation();
		if (l != null)
		{
			int ndx = l.indexOf('#');
			if (ndx >= 0)
			{
				o = GeoJson.point(Double.parseDouble(l.substring(0, ndx)), Double.parseDouble(l.substring(ndx + 1)));
			}
		}
		
		return o;
	}
	
	@FormParam("northeast")
	private String northeast                   ;

	public String getNortheast()    { return DTOBase.nullOnEmpty(northeast); }

	public Point getNortheastAsGeoJsonPoint()
	{
		Point o = null;
		String l = getNortheast();
		if (l != null)
		{
			int ndx = l.indexOf('#');
			if (ndx >= 0)
			{
				o = GeoJson.point(Double.parseDouble(l.substring(0, ndx)), Double.parseDouble(l.substring(ndx + 1)));
			}
		}
		
		return o;
	}
	
	@FormParam("southwest")
	private String southwest                   ;

	public String getSouthwest()    { return DTOBase.nullOnEmpty(southwest); }

	public Point getSouthwestAsGeoJsonPoint()
	{
		Point o = null;
		String l = getSouthwest();
		if (l != null)
		{
			int ndx = l.indexOf('#');
			if (ndx >= 0)
			{
				o = GeoJson.point(Double.parseDouble(l.substring(0, ndx)), Double.parseDouble(l.substring(ndx + 1)));
			}
		}
		
		return o;
	}
	
	public AddressGeomDTO getGeom()
	{
		AddressGeomDTO g = null;
		
		String l = getLocation();
		if (l != null)
		{
			g = new AddressGeomDTO();
			
			g.setLocation(getLocationAsGeoJsonPoint());
			g.setViewpnortheast(getNortheastAsGeoJsonPoint());
			g.setViewpsouthwest(getSouthwestAsGeoJsonPoint());
		}
		
		return g;
	}
	
	@FormParam("place_id")
	private String place_id                    ;

	public String getPlace_id()    { return DTOBase.nullOnEmpty(place_id); }

	@FormParam("formatted_address")
	private String formatted_address           ;

	public String getFormatted_address()    { return DTOBase.nullOnEmpty(formatted_address); }

	
	
	public UpdateOperations<SiteCollectionDTO> getUpdateOperation(Datastore mongoDatastore)
	{
		UpdateOperations<SiteCollectionDTO> uop = mongoDatastore.createUpdateOperations(SiteCollectionDTO.class);
		
		AddressDTO dto = new AddressDTO();
		
		dto.setCountry(getCountryGeoCodeLocationName());
		dto.setAdminarea_l1(getAdministrative_area_level_1GeoCodeLocationName());
		dto.setAdminarea_l2(getAdministrative_area_level_2GeoCodeLocationName());
		dto.setAdminarea_l3(getAdministrative_area_level_3GeoCodeLocationName());
		dto.setLocality(getLocality());
		dto.setRoute(getRoute());
		dto.setSnumber(getStreet_number());
		dto.setPostcode(getPostal_code());
		
		dto.setFormatted(getFormatted_address());
		dto.setGmapplaceid(getPlace_id());

		dto.setGeom(getGeom());
		
		uop.set(SiteCollectionDTO.ADDRESS, dto);
		uop.set(SiteCollectionDTO.LASTMODIFIED, new java.util.Date());
		uop.add(SiteCollectionDTO.SECTIONS, "address", false);
		return  uop;
	}

	

	
}
