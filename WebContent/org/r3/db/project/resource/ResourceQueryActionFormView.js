//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

jQuery.r3Utils.namespace("org.r3.db.project.resource");

org.r3.db.project.resource.ResourceQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.project.resource.ResourceDTOAdapter(aRowDataBean); });   
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
       	  "sTitle": "",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             var s = '<div class="tools"><i class="fa fa-file-o tools-icon toolid-file" style="margin: 2px"></i></div>';
                return s;
          }       
       };  
       
        defaultColumnDefinitions['resourceid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resource.message.resourceid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.resourceid || '';
          }       
       };
        defaultColumnDefinitions['resourcetype'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resource.message.resourcetype,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.resourcetype || '';
          }       
       };
        defaultColumnDefinitions['resourcedescr'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resource.message.resourcedescr,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.resourcedescr || '';
          }       
       };
        defaultColumnDefinitions['sitedomain'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resource.message.sitedomain,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.sitedomain || '';
          }       
       };
        defaultColumnDefinitions['userid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resource.message.userid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.userid || '';
          }       
       };
        defaultColumnDefinitions['firstname'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resource.message.firstname,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.firstname || '';
          }       
       };
        defaultColumnDefinitions['lastname'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resource.message.lastname,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.lastname || '';
          }       
       };
        defaultColumnDefinitions['phone'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resource.message.phone,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.phone || '';
          }       
       };
        defaultColumnDefinitions['cellphone'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resource.message.cellphone,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.cellphone || '';
          }       
       };
        defaultColumnDefinitions['email'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resource.message.email,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.email || '';
          }       
       };
        defaultColumnDefinitions['address'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resource.message.address,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.address || '';
          }       
       };
        defaultColumnDefinitions['town'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resource.message.town,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.town || '';
          }       
       };
        defaultColumnDefinitions['zipcode'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resource.message.zipcode,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.zipcode || '';
          }       
       };
        defaultColumnDefinitions['ssn'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "text-left",
           "sTitle": org.r3.db.project.resource.message.ssn,
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.dataBean.ssn || '';
           }       
        };
         defaultColumnDefinitions['sex'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "text-left",
           "sTitle": org.r3.db.project.resource.message.sex,
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.dataBean.sex || '';
           }       
        };
         defaultColumnDefinitions['birthdate'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "text-left",
           "sTitle": org.r3.db.project.resource.message.birthdate,
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.dataBean.birthdate || '';
           }       
        };
         defaultColumnDefinitions['birthtown'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "text-left",
           "sTitle": org.r3.db.project.resource.message.birthtown,
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.dataBean.birthtown || '';
           }       
        };
         defaultColumnDefinitions['birthdistrict'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "text-left",
           "sTitle": org.r3.db.project.resource.message.birthdistrict,
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.dataBean.birthdistrict || '';
           }       
        };        
        defaultColumnDefinitions['resourcecardid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resource.message.resourcecardid,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.resourcecardid || '';
          }       
       };
        defaultColumnDefinitions['recstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resource.message.recstatus,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.recstatus || '';
          }       
       };
        defaultColumnDefinitions['rectimestamp'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": org.r3.db.project.resource.message.rectimestamp,
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
   	  var adaptedItem = new org.r3.db.project.resource.ResourceDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

