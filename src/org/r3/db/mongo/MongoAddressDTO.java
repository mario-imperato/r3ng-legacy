package org.r3.db.mongo;

import org.mongodb.morphia.annotations.Embedded;

/*
      "type" : "object",
      "properties" : {
        "formatted" : {
          "type" : "string"
        },
        "snumber" : {
          "type" : "string"
        },
        "route" : {
          "type" : "string"
        },
        "locality" : {
          "type" : "string"
        },
        "adminarea_l3" : {
          "type" : "classref",
          "classname" : "org.r3.db.mongo.MongoGeoCodeLocationName"
        },
        "adminarea_l2" : {
          "type" : "classref",
          "classname" : "org.r3.db.mongo.MongoGeoCodeLocationName"
        },
        "adminarea_l1" : {
          "type" : "classref",
          "classname" : "org.r3.db.mongo.MongoGeoCodeLocationName"
        },
        "country" : {
          "type" : "classref",
          "classname" : "org.r3.db.mongo.MongoGeoCodeLocationName"
        },
        "postcode" : {
          "type" : "string"
        },
        "geom" : {
          "type" : "object",
          "properties" : {
            "location" : {
              "type" : "geoloc"
            },
            "viewpnortheast" : {
              "type" : "geoloc"
            },
            "viewpsouthwest" : {
              "type" : "geoloc"
            }
          }
        },
        "gmapplaceid" : {
          "type" : "string"
        }
      }
 */
public class MongoAddressDTO
{
	public static final String ADMINAREA_L1 = "adminarea_l1";
	public static final String ADMINAREA_L1_LOCATIONID = ADMINAREA_L1 + "." + MongoGeoCodeLocationName.LOCATIONID;
	
	public MongoAddressDTO()
	{
	}

  	private String  addressid;
    
  	public String   getAddressid()         
  	{ 
  		return addressid; 
  	}

  	public void setAddressid(org.bson.types.ObjectId  p)         
  	{ 
  		addressid = p.toHexString(); 
  	}

  	public void setAddressid(java.lang.String  p)         
  	{ 
  		addressid = p; 
  	}
  	
	//
	private java.lang.String formatted;

	public java.lang.String getFormatted()
	{
		return formatted;
	}

	public void setFormatted(java.lang.String p)
	{
		formatted = p;
	}

	//
	private java.lang.String snumber;

	public java.lang.String getSnumber()
	{
		return snumber;
	}

	public void setSnumber(java.lang.String p)
	{
		snumber = p;
	}

	//
	private java.lang.String route;

	public java.lang.String getRoute()
	{
		return route;
	}

	public void setRoute(java.lang.String p)
	{
		route = p;
	}

	//
	private java.lang.String locality;

	public java.lang.String getLocality()
	{
		return locality;
	}

	public void setLocality(java.lang.String p)
	{
		locality = p;
	}

	@Embedded
	private org.r3.db.mongo.MongoGeoCodeLocationName adminarea_l3;

	public org.r3.db.mongo.MongoGeoCodeLocationName getAdminarea_l3()
	{
		return adminarea_l3;
	}

	public void setAdminarea_l3(org.r3.db.mongo.MongoGeoCodeLocationName p)
	{
		adminarea_l3 = p;
	}

	@Embedded
	private org.r3.db.mongo.MongoGeoCodeLocationName adminarea_l2;

	public org.r3.db.mongo.MongoGeoCodeLocationName getAdminarea_l2()
	{
		return adminarea_l2;
	}

	public void setAdminarea_l2(org.r3.db.mongo.MongoGeoCodeLocationName p)
	{
		adminarea_l2 = p;
	}

	@Embedded
	private org.r3.db.mongo.MongoGeoCodeLocationName adminarea_l1;

	public org.r3.db.mongo.MongoGeoCodeLocationName getAdminarea_l1()
	{
		return adminarea_l1;
	}

	public void setAdminarea_l1(org.r3.db.mongo.MongoGeoCodeLocationName p)
	{
		adminarea_l1 = p;
	}

	@Embedded
	private org.r3.db.mongo.MongoGeoCodeLocationName country;

	public org.r3.db.mongo.MongoGeoCodeLocationName getCountry()
	{
		return country;
	}

	public void setCountry(org.r3.db.mongo.MongoGeoCodeLocationName p)
	{
		country = p;
	}

	//
	private java.lang.String postcode;

	public java.lang.String getPostcode()
	{
		return postcode;
	}

	public void setPostcode(java.lang.String p)
	{
		postcode = p;
	}

	@Embedded
	private AddressGeomDTO geom;

	public AddressGeomDTO getGeom()
	{
		return geom;
	}

	public void setGeom(AddressGeomDTO p)
	{
		geom = p;
	}

	//
	private java.lang.String gmapplaceid;

	public java.lang.String getGmapplaceid()
	{
		return gmapplaceid;
	}

	public void setGmapplaceid(java.lang.String p)
	{
		gmapplaceid = p;
	}

	public static class AddressGeomDTO
	{
		//
		private org.mongodb.morphia.geo.Point location;

		public org.mongodb.morphia.geo.Point getLocation()
		{
			return location;
		}

		public void setLocation(org.mongodb.morphia.geo.Point p)
		{
			location = p;
		}

		//
		private org.mongodb.morphia.geo.Point viewpnortheast;

		public org.mongodb.morphia.geo.Point getViewpnortheast()
		{
			return viewpnortheast;
		}

		public void setViewpnortheast(org.mongodb.morphia.geo.Point p)
		{
			viewpnortheast = p;
		}

		//
		private org.mongodb.morphia.geo.Point viewpsouthwest;

		public org.mongodb.morphia.geo.Point getViewpsouthwest()
		{
			return viewpsouthwest;
		}

		public void setViewpsouthwest(org.mongodb.morphia.geo.Point p)
		{
			viewpsouthwest = p;
		}

	}
}