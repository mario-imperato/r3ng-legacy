//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.project.wbsnodeteammemberprofileview");

org.r3.db.project.wbsnodeteammemberprofileview.WBSNodeTeamMemberProfileViewQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.project.wbsnodeteammemberprofileview.WBSNodeTeamMemberProfileViewDTOAdapter(aRowDataBean); });   
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

        defaultColumnDefinitions['profileid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.wbsnodeteammemberprofileview.message.profileid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.profileid || '';
          }       
       };
        defaultColumnDefinitions['wbsnodeid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.wbsnodeteammemberprofileview.message.wbsnodeid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.wbsnodeid || '';
          }       
       };
        defaultColumnDefinitions['effort'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.wbsnodeteammemberprofileview.message.effort,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.effort || '';
          }       
       };
        defaultColumnDefinitions['uniteffort'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.wbsnodeteammemberprofileview.message.uniteffort,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.uniteffort || '';
          }       
       };
        defaultColumnDefinitions['recstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.wbsnodeteammemberprofileview.message.recstatus,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.recstatus || '';
          }       
       };
        defaultColumnDefinitions['site'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.wbsnodeteammemberprofileview.message.site,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.site || '';
          }       
       };
        defaultColumnDefinitions['wbsid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.wbsnodeteammemberprofileview.message.wbsid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.wbsid || '';
          }       
       };
        defaultColumnDefinitions['nodetype'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.wbsnodeteammemberprofileview.message.nodetype,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.nodetype || '';
          }       
       };
        defaultColumnDefinitions['nodeorder'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.wbsnodeteammemberprofileview.message.nodeorder,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.nodeorder || '';
          }       
       };
        defaultColumnDefinitions['nodesect'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.wbsnodeteammemberprofileview.message.nodesect,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.nodesect || '';
          }       
       };
        defaultColumnDefinitions['nodename'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.wbsnodeteammemberprofileview.message.nodename,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.nodename || '';
          }       
       };
        defaultColumnDefinitions['nodestatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.project.wbsnodeteammemberprofileview.message.nodestatus,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.nodestatus || '';
          }       
       };
        
       return defaultColumnDefinitions;
   },
   
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.project.wbsnodeteammemberprofileview.WBSNodeTeamMemberProfileViewDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

