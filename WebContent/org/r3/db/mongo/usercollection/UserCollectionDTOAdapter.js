//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.mongo.usercollection");

org.r3.db.mongo.usercollection.UserCollectionDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	init : function(aDataBean)
	{
		this._super(new org.r3.db.mongo.usercollection.UserCollectionDTO(aDataBean));
		this.completionPercs = [ 0, 25, 50, 100 ];
		
		this.merchantRoles = [];
		this.userNeighborhoodOwnerFlag = false;
		this.userFollowerFlag = false;
		this.userMemberFlag = false;		
	},
	
	isCurrentUser: function()
	{
		return this.dataBean.userid == org.r3.PageManager.userCollectionProfileInfo.dataBean.userid;
	},
	
	getUsername: function()
	{
		if (this.dataBean.firstname)
			return this.dataBean.firstname + ' ' + this.dataBean.lastname;
		
		return this.dataBean.userid;
	},
	
	getEmail: function()
	{
		return this.dataBean.email || 'n.d.';
	},

	getCellphone: function()
	{
		return "+39";
	},

	setUserAnalyticsLastpostauthor: function(anAuthorId, anAuthorType)
	{
		if (!this.dataBean.userana)
			this.dataBean.userana = {};
		
		this.dataBean.userana.lastpostauthorid = anAuthorId;
		this.dataBean.userana.lastpostauthortype = anAuthorType;
	},

	getUserAnalyticsLastpostauthor: function()
	{
		return this.dataBean.userana && this.dataBean.userana.lastpostauthorid;
	},

	isSiteInFavoriteList: function()
	{
		if (this.dataBean.favsites && this.dataBean.favsites.length)
		{
			for(var i = 0; i < this.dataBean.favsites.length; i++)
			{
				if (this.dataBean.favsites[i] == org.r3.Constants.site)
					return true;
			}
		}
		
		return false;
	},
	
	isUserFollower: function()
	{
		return this.userFollowerFlag ;
	},
	
	isUserMember: function()
	{
		return this.userMemberFlag ;
	},
	
	isUserMerchant: function()
	{
		// Merchant Roles contiene per ogni negozio gli id degli stessi.
		// La verifica secca cosi' non basta. Deve avere i ruoli shkadmin oppure shkowner.
		// 03/10/2016 12:04:40. Modifica: il vettore contiene solo i roles se si tratta di un amministratore.
		return this.merchantRoles && this.merchantRoles.length > 0;
	},
	
	isUserNeighborhoodOwner: function(aUserDTOAdapter)
	{				
		return this.userNeighborhoodOwnerFlag ;
	},
	
	setupEnabledRoles4Site : function(aUserDTOAdapter, aSiteCollectionDTOAdapter)
	{
		if (aUserDTOAdapter)
		{
			if (aSiteCollectionDTOAdapter && aSiteCollectionDTOAdapter.dataBean.friends && aSiteCollectionDTOAdapter.dataBean.friends.length)
			{				
			for(var i = 0; i < aSiteCollectionDTOAdapter.dataBean.friends.length; i++)
			{
				var item = aSiteCollectionDTOAdapter.dataBean.friends[i];
				var rs = aUserDTOAdapter.getRoles4Site(item.site);
				if (rs && rs.length)
				{
					switch(item.sitetype)
					{
					case 'shkshop':
					   // 03/10/2016 12:04:40 Metto come merchant solo se è un amministratore oppure owner.
					   if (aUserDTOAdapter.hasRole4Site(item.site, org.r3.db.system.user.user.role_shkadmin) || 
						   aUserDTOAdapter.hasRole4Site(item.site, org.r3.db.system.user.user.role_shkowner))
					   {
						   this.merchantRoles.push({ site: item, roles : rs });						   
					   }						
					   break;
					}
				}
			}
			}
			
			// Anche in questo caso debbo verificare che abbia un ruolo preciso mentre in questo momento mi basta avere un ruolo qualsiasi. 
			// 03/10/2016 12:04:40 Tolgo la verifica del tipo di sito in quanto faccio una verifica sul ruolo. Il flag userNeighborhoodOwnerFlag
			// viene usato se si tratta di un amministratore del contesto corrente... indipendentemente dal fatto che sia un vicinato.
			// this.userNeighborhoodOwnerFlag = false;
			// if (org.r3.SiteConstants.targetSiteType == 'shkneighb')
			// {
			//	var rs = aUserDTOAdapter.getRoles4Site(org.r3.Constants.site);
			//	if (rs && rs.length)
			//	{
			//		this.userNeighborhoodOwnerFlag = true;
			//	}	
			// }
			this.userNeighborhoodOwnerFlag = 
					aUserDTOAdapter.hasRole4Site(org.r3.Constants.site, org.r3.db.system.user.user.role_shkadmin) || 
					aUserDTOAdapter.hasRole4Site(org.r3.Constants.site, org.r3.db.system.user.user.role_shkowner);
			
			if (this.userNeighborhoodOwnerFlag && org.r3.SiteConstants.targetSiteType == 'shkshop')
			{
				this.merchantRoles.push({ site: { site : org.r3.Constants.site, sitetype : 'shkshop', sitedescription : org.r3.SiteConstants.targetSiteName }, roles : aUserDTOAdapter.getRoles4Site(org.r3.Constants.site) });
			}
		
			this.userFollowerFlag = aUserDTOAdapter.hasRole4Site(org.r3.Constants.site, org.r3.db.system.user.user.role_shkfollower);
			this.userMemberFlag = aUserDTOAdapter.hasRole4Site(org.r3.Constants.site, org.r3.db.system.user.user.role_shkmember);
		}
	},
	
	isProfileOK: function()
	{
		if (this.dataBean.sections && this.dataBean.sections.length)
			return this.completionPercs[this.dataBean.sections.length] == 100;
		
		return false;
	},
	
	getCompletionPercentage: function()
	{
		if (this.dataBean.sections && this.dataBean.sections.length)
			return this.completionPercs[this.dataBean.sections.length];
		
		return this.completionPercs[0];
	},
	
	getPhotoIconUrl: function()
	{
		var p = this.getPhotoByRole('icon');
		if (p)
		  return p.url;
		
		// Torno un Default Sperando sia configurato.
		var defUrl = org.r3.SiteConstants.getSiteResourceUrl('img', 'userPhotoIcon.png');
		return defUrl;
	},
	
	getPhotoUrl: function()
	{
		var p = this.getPhotoByRole('image');
		if (p)
		  return p.url;
		
		return null;
	},
	
	getPhotoByRole: function(aRole)
	{
		if (!this.dataBean.photo)
			return null;
		
		for(var i = 0; i < this.dataBean.photo.length; i++)
		{
			if (this.dataBean.photo[i].role == aRole)
				return this.dataBean.photo[i];
		}
		
		return null;
	},
	
	getAddressDTOAdapter: function()
	{
		if (!this.dataBean.address)
			return null;
		
		return new org.r3.db.mongo.usercollection.AddressDTOAdapter(this.dataBean.address);
	},
	
	getMerchantRoleById: function(aMerchantId)
	{
		var m = null;
		
		var merchantRoles = org.r3.PageManager.userCollectionProfileInfo.merchantRoles;
		if (merchantRoles && merchantRoles.length)
		{
			for(var i = 0; i < merchantRoles.length; i++)
			{
				if (aMerchantId ==  merchantRoles[i].site.site)
					return merchantRoles[i];
			}
		}
		 
		return m;
		 
	}
	

});

org.r3.db.mongo.usercollection.AddressDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	init : function(aDataBean)
	{
		this._super(new org.r3.db.mongo.usercollection.AddressDTO(aDataBean));
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