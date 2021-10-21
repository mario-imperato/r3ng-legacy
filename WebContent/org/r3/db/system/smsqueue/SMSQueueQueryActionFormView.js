//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.system.smsqueue");

org.r3.db.system.smsqueue.SMSQueueQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.system.smsqueue.SMSQueueDTOAdapter(aRowDataBean); });   
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
          "sTitle": org.r3.db.system.smsqueue.message.site,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.site || '';
          }       
       };
        defaultColumnDefinitions['smsid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.system.smsqueue.message.smsid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getGtwayresponsecodeAsSemaphore() + item.dataBean.smsid || '';
          }       
       };
        defaultColumnDefinitions['smsinfo'] = 
        {
           "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": org.r3.db.system.smsqueue.message.smsinfo,
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.getSmsinfo() || '';
           }       
        };
        
        defaultColumnDefinitions['smstext'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.system.smsqueue.message.smstext,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.smstext || '';
          }       
       };
        defaultColumnDefinitions['smssender'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.system.smsqueue.message.smssender,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.smssender || '';
          }       
       };
        defaultColumnDefinitions['smsopts'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.system.smsqueue.message.smsopts,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.smsopts || '';
          }       
       };
        defaultColumnDefinitions['smssendat'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.system.smsqueue.message.smssendat,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.smssendat || '';
          }       
       };
        defaultColumnDefinitions['numberofretries'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "center",
          "sTitle": org.r3.db.system.smsqueue.message.numberofretries,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.numberofretries || '0';
          }       
       };
        defaultColumnDefinitions['numberoftargets'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "center",
          "sTitle": org.r3.db.system.smsqueue.message.numberoftargets,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.numberoftargets || '0';
          }       
       };
        defaultColumnDefinitions['numberofsentitems'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "center",
          "sTitle": org.r3.db.system.smsqueue.message.numberofsentitems,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.numberofsentitems || '0';
          }       
       };
        defaultColumnDefinitions['gtwayresponsecode'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.system.smsqueue.message.gtwayresponsecode,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getGtwayresponsecodeAsSemaphore() || '';
          }       
       };
        defaultColumnDefinitions['gtwayresponsereason'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.system.smsqueue.message.gtwayresponsereason,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.gtwayresponsereason || '';
          }       
       };
        defaultColumnDefinitions['recstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.system.smsqueue.message.recstatus,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getRecstatus() || '';
          }       
       };
        defaultColumnDefinitions['rectimestamp'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.system.smsqueue.message.rectimestamp,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getRectimestamp() || '';
          }       
       };
        
       return defaultColumnDefinitions;
   },
   
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.system.smsqueue.SMSQueueDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

