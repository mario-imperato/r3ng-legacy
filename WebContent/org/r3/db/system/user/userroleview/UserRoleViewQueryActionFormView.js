//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.system.user.userroleview");

org.r3.db.system.user.userroleview.UserRoleViewQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.system.user.userroleview.UserRoleViewDTOAdapter(aRowDataBean); });   
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

        defaultColumnDefinitions['site'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "site",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.site || '';
          }       
       };
        defaultColumnDefinitions['userid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "userid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.userid || '';
          }       
       };
        defaultColumnDefinitions['roleid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "roleid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.roleid || '';
          }       
       };
        defaultColumnDefinitions['roledescr'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "roledescr",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.roledescr || '';
          }       
       };
        
       return defaultColumnDefinitions;
   },
   
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.system.user.userroleview.UserRoleViewDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

