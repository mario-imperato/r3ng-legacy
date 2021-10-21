//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.mongo");

org.r3.db.mongo.AddressDTO = Class.extend(
 {
     init: function(aDataBean)
	 {
        this.formatted = aDataBean.formatted || null;
        this.snumber = aDataBean.snumber || null;
        this.route = aDataBean.route || null;
        this.locality = aDataBean.locality || null;
        this.adminarea_l3 = aDataBean.adminarea_l3 || null;
        this.adminarea_l2 = aDataBean.adminarea_l2 || null;
        this.adminarea_l1 = aDataBean.adminarea_l1 || null;
        this.country = aDataBean.country || null;
        this.postcode = aDataBean.postcode || null;
        this.geom = aDataBean.geom || null;
        this.gmapplaceid = aDataBean.gmapplaceid || null;
	 }	   
 });  

org.r3.db.mongo.AddressDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	init : function(aDataBean)
	{
		this._super(new org.r3.db.mongo.AddressDTO(aDataBean));
	},
	
	getRouteStreetNumber: function()
	{
		var a = this.dataBean && this.dataBean.route;
		if (a && this.dataBean.snumber)
			a = a + ', ' + this.dataBean.snumber;
		
		return a;
	},
	
	getAdministrative_area_level_1_id: function()
	{
		if (this.dataBean && this.dataBean.adminarea_l1 && this.dataBean.adminarea_l1.locationid)
			return this.dataBean.adminarea_l1.locationid;
		
		return null;
	},

	getSerializedAdminarea_l1: function()
	{
		if (this.dataBean && this.dataBean.adminarea_l1)
		{
			return this.getSerializedNameAndSName(this.dataBean.adminarea_l1);		
		}
		
		return null;
	},
	
	getAdministrative_area_level_2_id: function()
	{
		if (this.dataBean && this.dataBean.adminarea_l2 && this.dataBean.adminarea_l2.locationid)
			return this.dataBean.adminarea_l2.locationid;
		
		return null;
	},

	getSerializedAdminarea_l2: function()
	{
		if (this.dataBean && this.dataBean.adminarea_l2)
		{
			return this.getSerializedNameAndSName(this.dataBean.adminarea_l2);		
		}
		
		return null;
	},
	
	getAdministrative_area_level_3_id: function()
	{
		if (this.dataBean && this.dataBean.adminarea_l3 && this.dataBean.adminarea_l3.locationid)
			return this.dataBean.adminarea_l3.locationid;
		
		return null;
	},
	
	getSerializedAdminarea_l3: function()
	{
		if (this.dataBean && this.dataBean.adminarea_l3)
		{
			return this.getSerializedNameAndSName(this.dataBean.adminarea_l3);		
		}
		
		return null;
	},
	
	getSerializedCountry: function()
	{
		if (this.dataBean && this.dataBean.country)
		{
			return this.getSerializedNameAndSName(this.dataBean.country);		
		}
		
		return null;
	},
	
	getSerializedNameAndSName: function(anItem)
	{
		if (!anItem)
			return null;
		
		if (anItem.sname && anItem.name)
		{
			return anItem.sname + '#' + anItem.name;
		}
			
	    return anItem.name;
	},
	
	getSerializedLocation: function()
	{
		if (this.dataBean && this.dataBean.geom && this.dataBean.geom.location)
		{
			return this.getSerializedLatLng(this.dataBean.geom.location);		
		}
		
		return null;
	},
	
	getLocationAsCoordsArray: function()
	{
		if (this.dataBean && this.dataBean.geom && this.dataBean.geom.location)
		{
			var item = this.dataBean.geom.location;
			return [ item.coordinates[1], item.coordinates[0] ];		
		}
		
		return null;
	},
	
	getSerializedNortheast: function()
	{
		if (this.dataBean && this.dataBean.geom && this.dataBean.geom.viewpnortheast)
		{
			return this.getSerializedLatLng(this.dataBean.geom.viewpnortheast);		
		}
		
		return null;
	},
	
	getSerializedSouthwest: function()
	{
		if (this.dataBean && this.dataBean.geom && this.dataBean.geom.viewpsouthwest)
		{
			return this.getSerializedLatLng(this.dataBean.geom.viewpsouthwest);		
		}
		
		return null;
	},
	
	getSerializedLatLng: function(anItem)
	{
		if (!anItem)
			return null;
		
		return anItem.coordinates[1] + '#' + anItem.coordinates[0];
	}
});