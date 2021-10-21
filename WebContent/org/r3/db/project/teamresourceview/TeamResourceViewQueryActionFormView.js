//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.project.teamresourceview");

org.r3.db.project.teamresourceview.TeamResourceViewQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.project.teamresourceview.TeamResourceViewDTOAdapter(aRowDataBean); });   
      return adapter;
   },
   
   _setupDefaultColumnDefinitions: function()
   { 
   	   var defaultColumnDefinitions = {};
   	         	  
   	   var attributekey = '<attributeid>';    
       var global_multiselector = this.dataTableId + "_all_" + attributekey;
   	   var selectorPrefix = this.dataTableId;

   	   defaultColumnDefinitions['singleselector'] = 
       {  
       	  "aTargets": [ -1 ], 
       	  "sClass": "text-center", 
       	  "sTitle": "",
          "render": function ( data, type, row, meta ) 
          {
          	    var item = data; 
          	    var k = item.dataBean.dtokey;
          	    var d = item.dataBean.dtodescr;
          	    
          	    var itemChecked = "";
//          	    if ($('#' + global_multiselector).prop('checked'))
//          	    {
//          	    	itemChecked = ' checked ';
//          	    }
          	    var s = "<input type='radio' name='" + attributekey + "' id='" + selectorPrefix + '_' + item.dataBean.dtokey + "' value='" + k + "' title='" + d + "' " + itemChecked + " />"; 
                return s;
          }
       };   	      	         	      
       
   	   defaultColumnDefinitions['multiselector'] = 
       {  
       	  "aTargets": [ -1 ], 
       	  "sClass": "text-center", 
       	  "sTitle": "<input type='checkbox' id='" + global_multiselector + "' name='all_" + attributekey + "' value='btrue' />",
       
          "render": function ( data, type, row, meta ) 
          {
          	    var item = data; 
          	    var k = item.dataBean.dtokey;
          	    var d = item.dataBean.dtodescr;
          	    
          	    var itemChecked = "";
//          	    if ($('#' + global_multiselector).prop('checked'))
//          	    {
//          	    	itemChecked = ' checked ';
//          	    }
          	    var s = "<input type='checkbox' name='" + attributekey + "' value='" + k + "' " + itemChecked + " />"; 
                return s;
          }
       };  
              
   	   defaultColumnDefinitions['indexofitem'] = 
       {  
       	  "aTargets": [ -1 ], 
       	  "sClass": "text-center", 
       	  "sTitle": "",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.indexOfItem;
          }       
       };

	    defaultColumnDefinitions['queryformview-tools'] = 
       {  
       	  "aTargets": [ -1 ], 
       	  "sClass": "text-center",
       	  "sWidth": "35px",
       	  "sTitle": "",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             var s = '<div class="queryformview-tools">';
             s += '<i class="fa fa-file-o tools-icon toolid-detail" style="margin: 2px"></i>';
             if (item.dataBean.teamstatus == 'team_building')
                 s += '<i class="fa fa-trash-o tools-icon toolid-delete" style="margin: 2px"></i>';
            	  
             s += '</div>';

             return s;
          }       
       };  
       
        defaultColumnDefinitions['site'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.teamresourceview.message.site,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.site || '';
          }       
       };
        defaultColumnDefinitions['teamid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.teamresourceview.message.teamid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.teamid || '';
          }       
       };
        defaultColumnDefinitions['teamdescr'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.teamresourceview.message.teamdescr,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getTeamstatusAsSemaphore() + ' ' + item.dataBean.teamdescr || '';
          }       
       };
        defaultColumnDefinitions['periodindex'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.teamresourceview.message.periodindex,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.periodindex || '';
          }       
       };
        defaultColumnDefinitions['periodtype'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.teamresourceview.message.periodtype,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.periodtype || '';
          }       
       };
        defaultColumnDefinitions['teamstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.teamresourceview.message.teamstatus,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getTeamstatusAsSemaphore() + ' ' + item.dataBean.teamstatus;
          }       
       };
        defaultColumnDefinitions['resourceid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.teamresourceview.message.resourceid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.resourceid || '';
          }       
       };
        defaultColumnDefinitions['resourcedescr'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.teamresourceview.message.resourcedescr,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getResourcedefstatusAsSemaphore() + ' ' + item.dataBean.resourcedescr || '';
          }       
       };
        defaultColumnDefinitions['profileid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.teamresourceview.message.profileid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getProfileDescr();
          }       
       };
        defaultColumnDefinitions['evalueunit'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.teamresourceview.message.evalueunit,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.evalueunit || '';
          }       
       };
        defaultColumnDefinitions['price'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.teamresourceview.message.price,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.price || '';
          }       
       };
        defaultColumnDefinitions['cost'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.teamresourceview.message.cost,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.cost || '';
          }       
       };
        defaultColumnDefinitions['resourcedefstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.teamresourceview.message.resourcedefstatus,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getResourcedefstatusAsSemaphore();
          }       
       };
        defaultColumnDefinitions['recstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.teamresourceview.message.recstatus,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.recstatus || '';
          }       
       };
        
       return defaultColumnDefinitions;
   },
   
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.project.teamresourceview.TeamResourceViewDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

