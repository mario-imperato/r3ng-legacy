//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.racegroupview");

org.r3.db.sailevent.racegroupview.SailRaceGroupViewQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.sailevent.racegroupview.SailRaceGroupViewDTOAdapter(aRowDataBean); });   
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
        defaultColumnDefinitions['parentitemid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "parentitemid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.parentitemid || '';
          }       
       };
        defaultColumnDefinitions['parentitemdescr'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "parentitemdescr",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.parentitemdescr || '';
          }       
       };
        defaultColumnDefinitions['parentitemorder'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "parentitemorder",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.parentitemorder || '';
          }       
       };
        defaultColumnDefinitions['childitemid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "childitemid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.childitemid || '';
          }       
       };
        defaultColumnDefinitions['childitemdescr'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "childitemdescr",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.childitemdescr || '';
          }       
       };
        defaultColumnDefinitions['childitemorder'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "childitemorder",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.childitemorder || '';
          }       
       };
        
       return defaultColumnDefinitions;
   },
   
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.sailevent.racegroupview.SailRaceGroupViewDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

