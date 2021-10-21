//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.system.address");

org.r3.db.system.address.AddressQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
{
   //
   // optionsHash: dataTableId, dataTableSource, dataTableColumns, searchEnabled, advancedSearchActionFormView, htmlTemplateUrl
   //
   init: function(anHtmlActionFormContainerId, anActionFormManager, optionsHash)
   {
      this._super(anHtmlActionFormContainerId, anActionFormManager, optionsHash);
   },

   getAdapterFromServerData: function(serverResponseData)
   {
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.system.address.AddressDTOAdapter(aRowDataBean); });   
      return adapter;
   },
   
   _setupDefaultColumnDefinitions: function()
   { 
   	   var defaultColumnDefinitions = {};
   	      
   	   defaultColumnDefinitions['indexofitem'] = 
       {  
       	  "aTargets": [ -1 ], 
       	  "sClass": "center", "sTitle": "",
          "fnRender": function ( oObj, sVal ) 
          {
          	    var item = oObj.aData; 
                return item.indexOfItem;
          }
       };

        defaultColumnDefinitions['addressid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "addressid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.addressid || '';
          }       
       };
        defaultColumnDefinitions['entityid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "entityid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.entityid || '';
          }       
       };
        defaultColumnDefinitions['countryid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "countryid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.countryid || '';
          }       
       };
        defaultColumnDefinitions['ownerid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "ownerid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.ownerid || '';
          }       
       };
        defaultColumnDefinitions['addresstypeid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "addresstypeid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.addresstypeid || '';
          }       
       };
        defaultColumnDefinitions['state'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "state",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.state || '';
          }       
       };
        defaultColumnDefinitions['city'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "city",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.city || '';
          }       
       };
        defaultColumnDefinitions['zipcode'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "zipcode",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.zipcode || '';
          }       
       };
        defaultColumnDefinitions['address'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "address",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.address || '';
          }       
       };
        defaultColumnDefinitions['phonecode1'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "phonecode1",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.phonecode1 || '';
          }       
       };
        defaultColumnDefinitions['phonecode2'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "phonecode2",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.phonecode2 || '';
          }       
       };
        defaultColumnDefinitions['phone1'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "phone1",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.phone1 || '';
          }       
       };
        defaultColumnDefinitions['phone2'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "phone2",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.phone2 || '';
          }       
       };
        defaultColumnDefinitions['website'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "website",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.website || '';
          }       
       };
        
       return defaultColumnDefinitions;
   },
   
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.system.address.AddressDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

