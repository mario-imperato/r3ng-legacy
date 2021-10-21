//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.system.classifieritem");

org.r3.db.system.classifieritem.ClassifierItemQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.system.classifieritem.ClassifierItemDTOAdapter(aRowDataBean); });   
      return adapter;
   },
   
   _setupDefaultColumnDefinitions: function()
   { 
   	   var defaultColumnDefinitions = {};
   	      
   	   defaultColumnDefinitions['indexofitem'] = 
       {  
       	  "aTargets": [ -1 ], 
       	  "sClass": "center", "sTitle": "",
          "render": function ( data, type, row, meta ) 
          {
          	    var item = data; 
                return item.indexOfItem;
          }
       };

        defaultColumnDefinitions['clsitemid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Id.",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.clsitemid || '';
          }       
       };
        defaultColumnDefinitions['site'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "site",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.site || '';
          }       
       };
        defaultColumnDefinitions['clsid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "clsid",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.clsid || '';
          }       
       };
        defaultColumnDefinitions['clsitembusid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "clsitembusid",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.clsitembusid || '';
          }       
       };
        defaultColumnDefinitions['parentitemid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "parentitemid",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.parentitemid || '';
          }       
       };
        defaultColumnDefinitions['classifieritemdescr'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Etichetta",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.classifieritemdescr || '';
          }       
       };
        defaultColumnDefinitions['classifieritempath'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "classifieritempath",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.classifieritempath || '';
          }       
       };
        defaultColumnDefinitions['classifieritemdepth'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "classifieritemdepth",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.classifieritemdepth || '';
          }       
       };
        defaultColumnDefinitions['classifieritemorder'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Ordine",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.classifieritemorder || '0';
          }       
       };
        defaultColumnDefinitions['classifieritemiattr'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "classifieritemiattr",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.classifieritemiattr || '';
          }       
       };
        defaultColumnDefinitions['classifieritemsattr'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "classifieritemsattr",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.classifieritemsattr || '';
          }       
       };
        
        defaultColumnDefinitions['numberofchildren'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "#",
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.dataBean.numberofchildren || '0';
           }       
        };
        
       return defaultColumnDefinitions;
   },
   
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.system.classifieritem.ClassifierItemDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

