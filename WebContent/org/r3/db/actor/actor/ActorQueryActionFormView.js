//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.actor.actor");

org.r3.db.actor.actor.ActorQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.actor.actor.ActorDTOAdapter(aRowDataBean); });   
      return adapter;
   },
   
   _setupDefaultColumnDefinitions: function()
   { 
   	   var defaultColumnDefinitions = {};
   	         	   
   	   var global_multiselector = this.dataTableId + "_all_actorid";
   	   
   	   defaultColumnDefinitions['multiselector'] = 
       {  
       	  "aTargets": [ -1 ], 
       	  "sClass": "center", 
       	  "sTitle": "<input type='checkbox' id='" + global_multiselector + "' name='all_actorid' value='btrue' />",
          "render": function ( data, type, row, meta ) 
          {
          	    var item = data; 
          	    
          	    var itemChecked = "";
//          	    if ($('#' + global_multiselector).prop('checked'))
//          	    {
//          	    	itemChecked = ' checked ';
//          	    }
          	    var s = "<input type='checkbox' name='actorid' value='" + item.dataBean.actorid + "' " + itemChecked + " />"; 
                return s;
          }
       };

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
          "sTitle": org.r3.db.actor.actor.message.eventid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.eventid || '';
          }       
       };
        defaultColumnDefinitions['actorid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle":  org.r3.db.actor.actor.message.actorid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.actorid || '';
          }       
       };
        defaultColumnDefinitions['firstname'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.actor.actor.message.firstname,
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
          "sTitle": org.r3.db.actor.actor.message.lastname,
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
          "sTitle": org.r3.db.actor.actor.message.phone,
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
          "sTitle": org.r3.db.actor.actor.message.cellphone,
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
          "sTitle": org.r3.db.actor.actor.message.email,
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
          "sTitle": org.r3.db.actor.actor.message.address,
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
          "sTitle": org.r3.db.actor.actor.message.town,
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
          "sTitle": org.r3.db.actor.actor.message.zipcode,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.zipcode || '';
          }       
       };
        defaultColumnDefinitions['contactgroup'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": org.r3.db.actor.actor.message.contactgroup,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.contactgroup || '';
          }       
       };

        defaultColumnDefinitions['recstatus'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "&nbsp;",
           "render": function ( data, type, row, meta )
           {
              var item = data;
              
              var s = '';
              if (item.dataBean.recstatus && item.dataBean.recstatus == 'sys_recblock')
                 s = "<label class='contact-icon contact-locked'></label>";
              else s = "<label class='contact-icon contact-unlocked'></label>";

              return s; // item.dataBean.recstatus || '';
           }       
        };
        
         defaultColumnDefinitions['rectimestamp'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": org.r3.db.actor.actor.message.rectimestamp,
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.dataBean.rectimestamp || '';
           }       
        };
         
       return defaultColumnDefinitions;
   },
   
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.actor.actor.ActorDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

