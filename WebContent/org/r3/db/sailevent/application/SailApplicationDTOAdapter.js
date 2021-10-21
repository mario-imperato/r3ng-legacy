//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.application");

org.r3.db.sailevent.application.SailApplicationDTOAdapter = org.r3.db.DTOAdapter.extend(
{
	 init: function(aDataBean)
	 {  
	 	   this._super(new org.r3.db.sailevent.application.SailApplicationDTO(aDataBean));
	 },
	 
	 getCompletionstatusText: function()
	 {
		 return $.r3Utils.formatLUTDataBeanField('GET_classifier_r3ea_completion', this.dataBean.completionstatus);
	 },
	 
	 isDraft: function()
	 {
		 return this.dataBean.completionstatus == 'r3ea_draft';
	 },
	 
	 isEmpty: function()
	 {
		 return this.dataBean.completionstatus == 'r3ea_empty';
	 },
	 
	 isCommit: function()
	 {
		 return this.dataBean.completionstatus == 'r3ea_commit';
	 },
	 
	 isAccepted: function()
	 {
		 return this.dataBean.verificationstatus == 'r3ea_accepted';
	 },
	 
	 getPropertyValue: function(propName, defaultValue)
	 {
		 if (this.dataBean.properties && this.dataBean.properties.getNumberOfItems() > 0)
		 {
			  var foundProperty = null;
		      var visitor = {
		    		  
		    		  processItem: function(theItem)
		    		  {
		    			  if (theItem.dataBean.paramname == propName)
		    			  {
		    				  foundProperty = theItem;
		    				  return false;
		    			  }
		    			  
		    			  return true;
		    		  }
		      
		      }
		      
		      this.dataBean.properties.visit(visitor);
		      if (foundProperty)
		    	  return foundProperty.dataBean.paramvalue;
		 }
		 
		 return defaultValue;
	 },
	 
	 getPropertyValueAsBoolean: function(propName)
	 {
		 var t = this.getPropertyValue(propName, 'bfalse');
		 return t  && t == 'btrue';
	 },
	 
	 getOwnerfirstname: function()
	 {
		 return this.dataBean.owner && this.dataBean.owner.dataBean.firstname;
	 },

	 getOwnerlastname: function()
	 {
		 return this.dataBean.owner && this.dataBean.owner.dataBean.lastname;
	 },

	 getOwnerphone: function()
	 {
		 return this.dataBean.owner && this.dataBean.owner.dataBean.phone;
	 },

	 getOwnercellphone: function()
	 {
		 return this.dataBean.owner && this.dataBean.owner.dataBean.cellphone;
	 },

	 getOwneremail: function()
	 {
		 return this.dataBean.owner && this.dataBean.owner.dataBean.email;
	 },

	 getOwneraddress: function()
	 {
		 return this.dataBean.owner && this.dataBean.owner.dataBean.address;
	 },

	 getOwnertown: function()
	 {
		 return this.dataBean.owner && this.dataBean.owner.dataBean.town;
	 },

	 getOwnerzipcode: function()
	 {
		 return this.dataBean.owner && this.dataBean.owner.dataBean.zipcode;
	 },
	 
	 getHavehelmsman: function()
	 {
		 return this.getPropertyValueAsBoolean('havehelmsman');
	 },

	 getHelmsmanfirstname: function()
	 {
		 return this.dataBean.helmsman && this.dataBean.helmsman.dataBean.firstname;
	 },

	 getHelmsmanlastname: function()
	 {
		 return this.dataBean.helmsman && this.dataBean.helmsman.dataBean.lastname;
	 },

	 getHelmsmanphone: function()
	 {
		 return this.dataBean.helmsman && this.dataBean.helmsman.dataBean.phone;
	 },

	 getHelmsmancellphone: function()
	 {
		 return this.dataBean.helmsman && this.dataBean.helmsman.dataBean.cellphone;
	 },

	 getHelmsmanemail: function()
	 {
		 return this.dataBean.helmsman && this.dataBean.helmsman.dataBean.email;
	 },

	 getHelmsmanaddress: function()
	 {
		 return this.dataBean.helmsman && this.dataBean.helmsman.dataBean.address;
	 },

	 getHelmsmantown: function()
	 {
		 return this.dataBean.helmsman && this.dataBean.helmsman.dataBean.town;
	 },

	 getHelmsmanzipcode: function()
	 {
		 return this.dataBean.helmsman && this.dataBean.helmsman.dataBean.zipcode;
	 },

	 getCommittimestamp: function()
	 {
		 return $.r3Utils.formatTimestampDataBeanField(this.dataBean.committimestamp);
	 },
	 
	 getCreatetimestamp: function()
	 {
		 return $.r3Utils.formatTimestampDataBeanField(this.dataBean.createtimestamp);
	 },
	 
	 getBoatIconUrl: function()
	 {
		 if (this.hasBoatImage())
			 return $.r3Utils.formatDMSUrl4ClientAccess(this.dataBean.boaticonurl);
		
		 return org.r3.Constants.getDefaultBoatIcon();
	 },
	 
	 hasBoatImage: function()
	 {
		 return this.dataBean.boaticonurl;
	 },
	 
	 getBoatIconMarginTop: function()
	 {
		 if (this.hasBoatImage())
		 {
			 return Math.floor((org.r3.Constants.boatIconMaxHeight - this.dataBean.boaticonheight) / 2)  || '0';			 
		 }
		 else  return Math.floor((org.r3.Constants.boatIconMaxHeight - org.r3.Constants.defaultBoatIconHeight) / 2)  || '0';
	 },

	 getBoatIconLayoutType: function()
	 {
		 if (this.hasBoatImage())
		 {
			 return (this.dataBean.boaticonwidth - this.dataBean.boaticonheight) > 0 ? 'landscape' : 'portrait';			 
		 }
		 
		 null;
	 },

	 getEscapedYachtTitle: function()
	 {
		 var t = this.dataBean.sailnumber + ' - ' + $.r3Utils.format4HtmlConsumption(this.dataBean.yachtname);
		 return t;
	 }

});

