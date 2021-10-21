//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.project.siteresourceview");

org.r3.db.project.siteresourceview.SiteResourceViewQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.project.siteresourceview.SiteResourceViewDTOAdapter(aRowDataBean); });   
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
          "fnRender": function ( oObj, sVal ) 
          {
          	    var item = oObj.aData; 
                return item.indexOfItem;
          }
       };

        defaultColumnDefinitions['resourceid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.siteresourceview.message.resourceid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.resourceid || '';
          }       
       };
        defaultColumnDefinitions['resourcetype'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.siteresourceview.message.resourcetype,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.resourcetype || '';
          }       
       };
        defaultColumnDefinitions['resourcedescr'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.siteresourceview.message.resourcedescr,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.resourcedescr || '';
          }       
       };
        defaultColumnDefinitions['sitedomain'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.siteresourceview.message.sitedomain,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.sitedomain || '';
          }       
       };
        defaultColumnDefinitions['userid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.siteresourceview.message.userid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.userid || '';
          }       
       };
        defaultColumnDefinitions['firstname'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.siteresourceview.message.firstname,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.firstname || '';
          }       
       };
        defaultColumnDefinitions['lastname'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.siteresourceview.message.lastname,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.lastname || '';
          }       
       };
        defaultColumnDefinitions['phone'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.siteresourceview.message.phone,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.phone || '';
          }       
       };
        defaultColumnDefinitions['cellphone'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.siteresourceview.message.cellphone,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.cellphone || '';
          }       
       };
        defaultColumnDefinitions['email'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.siteresourceview.message.email,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.email || '';
          }       
       };
        defaultColumnDefinitions['address'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.siteresourceview.message.address,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.address || '';
          }       
       };
        defaultColumnDefinitions['town'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.siteresourceview.message.town,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.town || '';
          }       
       };
        defaultColumnDefinitions['zipcode'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.siteresourceview.message.zipcode,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.zipcode || '';
          }       
       };
        defaultColumnDefinitions['resourcecardid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.siteresourceview.message.resourcecardid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.resourcecardid || '';
          }       
       };
        defaultColumnDefinitions['recstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.siteresourceview.message.recstatus,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.recstatus || '';
          }       
       };
        defaultColumnDefinitions['rectimestamp'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.siteresourceview.message.rectimestamp,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.rectimestamp || '';
          }       
       };
        defaultColumnDefinitions['site'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.siteresourceview.message.site,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.site || '';
          }       
       };
        defaultColumnDefinitions['profileid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.siteresourceview.message.profileid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.profileid || '';
          }       
       };
        defaultColumnDefinitions['evalueunit'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.siteresourceview.message.evalueunit,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.evalueunit || '';
          }       
       };
        defaultColumnDefinitions['price'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.siteresourceview.message.price,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.price || '';
          }       
       };
        defaultColumnDefinitions['cost'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.siteresourceview.message.cost,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.cost || '';
          }       
       };
        defaultColumnDefinitions['siterecstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.siteresourceview.message.siterecstatus,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.siterecstatus || '';
          }       
       };
        
       return defaultColumnDefinitions;
   },
   
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.project.siteresourceview.SiteResourceViewDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

