//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.cms.page");

org.r3.db.cms.page.PageQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.cms.page.PageDTOAdapter(aRowDataBean); });   
      return adapter;
   },
   
   _setupDefaultColumnDefinitions: function()
   { 
   	   var defaultColumnDefinitions = {};
   	      
   	   defaultColumnDefinitions['indexofitem'] = 
       {  
       	  "aTargets": [ -1 ], 
       	  "sClass": "center", 
       	  "sTitle": "",
          "render": function ( data, type, row, meta ) 
          {
          	    var item = data; 
                return item.indexOfItem;
          }
       };

        defaultColumnDefinitions['site'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.page.message.site,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.site || '';
          }       
       };
        defaultColumnDefinitions['pageid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.page.message.pageid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.pageid || '';
          }       
       };
        defaultColumnDefinitions['pagetype'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.page.message.pagetype,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.pagetype || '';
          }       
       };
        defaultColumnDefinitions['pagetitle'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.page.message.pagetitle,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.pagetitle || '';
          }       
       };
        defaultColumnDefinitions['pageicon1'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.page.message.pageicon1,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.pageicon1 || '';
          }       
       };
        defaultColumnDefinitions['pageicon2'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.page.message.pageicon2,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.pageicon2 || '';
          }       
       };
        defaultColumnDefinitions['pagelink'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.page.message.pagelink,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.pagelink || '';
          }       
       };
        defaultColumnDefinitions['pageorder'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.page.message.pageorder,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.pageorder || '';
          }       
       };
        defaultColumnDefinitions['visibility'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.page.message.visibility,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.visibility || '';
          }       
       };
        defaultColumnDefinitions['pagestyle'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.page.message.pagestyle,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.pagestyle || '';
          }       
       };
        defaultColumnDefinitions['forwardview'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.page.message.forwardview,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.forwardview || '';
          }       
       };
        defaultColumnDefinitions['onuserstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.page.message.onuserstatus,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.onuserstatus || '';
          }       
       };
        defaultColumnDefinitions['permissions'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.page.message.permissions,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.permissions || '';
          }       
       };
        defaultColumnDefinitions['viewoptions'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.cms.page.message.viewoptions,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.viewoptions || '';
          }       
       };
        
       return defaultColumnDefinitions;
   },
   
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.cms.page.PageDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

