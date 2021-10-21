//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.actor.group");

org.r3.db.actor.group.ActorGroupQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.actor.group.ActorGroupDTOAdapter(aRowDataBean); });   
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

        defaultColumnDefinitions['eventid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.actor.group.message.eventid,
          "render": function ( data, type, row, meta )
          {
              var item = data; 
             return item.dataBean.eventid || '';
          }       
       };
        defaultColumnDefinitions['groupid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.actor.group.message.groupid,
          "render": function ( data, type, row, meta )
          {
              var item = data; 
             return item.dataBean.groupid || '';
          }       
       };
        defaultColumnDefinitions['grouptitle'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.actor.group.message.grouptitle,
          "render": function ( data, type, row, meta )
          {
              var item = data; 
             return item.dataBean.grouptitle || '';
          }       
       };
        defaultColumnDefinitions['groupnature'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.actor.group.message.groupnature,
          "render": function ( data, type, row, meta )
          {
              var item = data; 
             return item.dataBean.groupnature || '';
          }       
       };
        defaultColumnDefinitions['grouptype'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.actor.group.message.grouptype,
          "render": function ( data, type, row, meta )
          {
              var item = data; 
             return item.dataBean.grouptype || '';
          }       
       };
        defaultColumnDefinitions['groupprofile'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.actor.group.message.groupprofile,
          "render": function ( data, type, row, meta )
          {
              var item = data; 
             return item.dataBean.groupprofile || '';
          }       
       };
        defaultColumnDefinitions['businesskey'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.actor.group.message.businesskey,
          "render": function ( data, type, row, meta )
          {
              var item = data; 
             return item.dataBean.businesskey || '';
          }       
       };
        defaultColumnDefinitions['grouporder'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.actor.group.message.grouporder,
          "render": function ( data, type, row, meta )
          {
              var item = data; 
             return item.dataBean.grouporder || '';
          }       
       };
        
       return defaultColumnDefinitions;
   },
   
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.actor.group.ActorGroupDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

