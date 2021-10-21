//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.system.user.user");

org.r3.db.system.user.user.UserDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	init : function(aDataBean)
	{
		this._super(new org.r3.db.system.user.user.UserDTO(aDataBean));
	},

	isInRole : function(site, targetFunctionCode)
	{
		if (!this.dataBean.sitepermissions)
			return false;

		for ( var i = 0; i < this.dataBean.sitepermissions.length; i++)
		{
			var sitePerm = this.dataBean.sitepermissions[i];
			if (sitePerm.site == site)
			{
				if (sitePerm.roles)
				{
					for ( var k = 0; k < sitePerm.roles.length; k++)
					{
						var enabledFuncs = sitePerm.roles[k].functions;
						if (enabledFuncs && enabledFuncs.length)
						{
							if (targetFunctionCode == '__any__')
								return true;
							
							for ( var j = 0; j < enabledFuncs.length; j++)
							{
								if (enabledFuncs[j].functioncode == targetFunctionCode)
									return true;
							}
						}
					}
				}
			}
		}

		return false;
	},

	getUsername : function()
	{
		return this.dataBean.nickname;
	},

	getUserFullname : function()
	{
		var s = this.dataBean.lastname;
		if (s)
		{
		   if (this.dataBean.firstname)	
			   s = this.dataBean.firstname + ' ' + s;
		}
		else s = this.dataBean.nickname;
		
		return s;
	},
	
	isGuest : function()
	{
		return this.isUsertype('guest');
	},

	isUser : function()
	{
		return this.isUsertype('user');
	},
	
	isAvatar : function()
	{
		return this.isUsertype('avatar');
	},
	
	isUsertype : function(aUsertype)
	{
		return this.dataBean.usertype && this.dataBean.usertype == aUsertype;
	},
	
	setRoles : function(/* aDTOTableAdapterOfUserRoleViewDTOAdapter */ aListOfRoles)
	{
		if (!aListOfRoles || aListOfRoles.getNumberOfItems() == 0)
			this.dataBean.sitepermissions = null;
		
		this.dataBean.sitepermissions = [];
		for ( var i = 0; i < aListOfRoles.getNumberOfItems(); i++)
		{
			var theUserRoleViewDTOAdapter = aListOfRoles.getItem(i); 
			var theSite = theUserRoleViewDTOAdapter.dataBean.site;
			var siteRoles = this.getRoles4Site(theSite);
			if (siteRoles && siteRoles.length > 0)
			{
			   siteRoles.push({ "roleid": theUserRoleViewDTOAdapter.dataBean.roleid });	
			}
			else
			{
				var rolesArray = [];
				rolesArray.push({ "roleid": theUserRoleViewDTOAdapter.dataBean.roleid });
				this.dataBean.sitepermissions.push({ "site": theSite, "roles": rolesArray });	
			}
		}
	},

	setRoles4Site : function(aSite, anArrayOfRoleid)
	{		
		var rolesArray = null;
		if (anArrayOfRoleid && anArrayOfRoleid.length > 0)
		{
			rolesArray = [];
			for(var i = 0; i < anArrayOfRoleid.length; i++)
			{
				rolesArray.push({ "roleid": anArrayOfRoleid[i] });
			}
		}
		
		for ( var i = 0; i < this.dataBean.sitepermissions.length; i++)
		{
			var sitePerm = this.dataBean.sitepermissions[i];
			if (sitePerm.site == aSite)
			{
				if (rolesArray)
				   sitePerm.roles = rolesArray;
				else 
					this.dataBean.sitepermissions.splice(i, 1);
				return ;
			}
		}
		
		if (rolesArray)
		{
			this.dataBean.sitepermissions.push({ "site": aSite, "roles": rolesArray });	
		}
	},

	getRoles4Site : function(site)
	{
		if (this.dataBean.sitepermissions)
        {
		for ( var i = 0; i < this.dataBean.sitepermissions.length; i++)
		{
			var sitePerm = this.dataBean.sitepermissions[i];
			if (sitePerm.site == site)
			{
				return sitePerm.roles;
			}						
		}
        }
		
		return [];
	},
	
	getRoles4SiteAsArrayOfRoleId : function(site)
	{
		if (this.dataBean.sitepermissions)
        {
		for ( var i = 0; i < this.dataBean.sitepermissions.length; i++)
		{
			var sitePerm = this.dataBean.sitepermissions[i];
			if (sitePerm.site == site)
			{
				var arrayOfRoleId = []; 
				for(var j = 0; j < sitePerm.roles.length; j++)
					arrayOfRoleId.push(sitePerm.roles[j].roleid);
				
				return arrayOfRoleId;
			}						
		}
        }
		
		return null;
	},
	
	hasRole4Site: function(site, roleId)
	{
		if (!site)
			site = org.r3.Constants.site;
		
	    var roles = this.getRoles4Site(site);
	    if (!roles || roles.length == 0)
	    	return false;
	    
	    for(var i = 0; i < roles.length; i++)
	    {
	        if (roles[i].roleid == roleId)
	        	return true;
	    }
	    
	    return false;
	},
	
	getSerializedSitePermissions: function()
	{
	    var serializedPermissions = "";

		if (this.dataBean.sitepermissions)
        {
		for ( var i = 0; i < this.dataBean.sitepermissions.length; i++)
		{
			var sitePerm = this.dataBean.sitepermissions[i];
			serializedPermissions = serializedPermissions + sitePerm.site + "=";
			for(var j = 0; j < sitePerm.roles.length; j++)
			{
				if (j > 0)
					serializedPermissions = serializedPermissions + ",";
				
				serializedPermissions = serializedPermissions + sitePerm.roles[j].roleid;	
			}
			
			serializedPermissions = serializedPermissions + ";";	
		}
        }
		
		return serializedPermissions;
	},
	
	getCSVPermissions4Site: function(aSite)
	{
	    var serializedPermissions = "";

	    var roles4Site = this.getRoles4Site(aSite);
	    if (roles4Site)
        {
			for(var j = 0; j < roles4Site.length; j++)
			{
				if (j > 0)
					serializedPermissions = serializedPermissions + ",";
				
				serializedPermissions = serializedPermissions + roles4Site[j].roleid;	
			}
        }
		
		return serializedPermissions;
	},
	
	isUserConsentRequired: function()
	{
		return this.dataBean.userconsent && (this.dataBean.userconsent == 'nonblocking' || this.dataBean.userconsent == 'required');
	},
	
	getUserPhoto: function()
    {
        if (this.dataBean.userphoto)
        {
        	return $.r3Utils.formatDMSUrl4ClientAccess(this.dataBean.userphoto);
        }
        
        return null;
    },
    
	getUserPhotoIconUrl: function()
	{
		// Mongo Functionality..
		 if (this.dataBean.userid)
		 {
			 return org.r3.PageManager.getRESTUrl("GET_UserCollection_Photo", [ this.dataBean.userid, 'icon' ]);
		 }
		 
		 return null;
	}
	

});

org.r3.db.system.user.user.role_shkadmin = 'shkadmin';
org.r3.db.system.user.user.role_shkowner = 'shkowner';
org.r3.db.system.user.user.role_shkfollower = 'shkfollower';
org.r3.db.system.user.user.role_shkmember = 'shkmember';

