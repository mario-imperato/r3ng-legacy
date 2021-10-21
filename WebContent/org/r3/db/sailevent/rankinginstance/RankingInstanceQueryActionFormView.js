//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.rankinginstance");

org.r3.db.sailevent.rankinginstance.RankingInstanceQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.sailevent.rankinginstance.RankingInstanceDTOAdapter(aRowDataBean); });   
      return adapter;
   },
   
   _setupDefaultColumnDefinitions: function()
   { 
   	   var defaultColumnDefinitions = {};

   	   var global_multiselector = this.dataTableId + "_all_instanceid";
   	   
   	   defaultColumnDefinitions['multiselector'] = 
       {  
       	  "aTargets": [ -1 ], 
       	  "sClass": "center", 
       	  "sTitle": "<input type='checkbox' id='" + global_multiselector + "' name='all_instanceid' value='btrue' />",
          "render": function ( data, type, row, meta ) 
          {
          	    var item = data; 
          	    
          	    var itemChecked = "";
//          	    if ($('#' + global_multiselector).prop('checked'))
//          	    {
//          	    	itemChecked = ' checked ';
//          	    }
          	    var s = "<input type='checkbox' name='instanceid' value='" + item.dataBean.instanceid + "' " + itemChecked + " />"; 
                return s;
          }
       };

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

        defaultColumnDefinitions['eventid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "eventid",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.eventid || '';
          }       
       };
        defaultColumnDefinitions['instanceid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Id.",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.instanceid || '';
          }       
       };
        defaultColumnDefinitions['instancetype'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "instancetype",
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.dataBean.instancetype || '';
           }       
        };        
        defaultColumnDefinitions['rankid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "rankid",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.rankid || '';
          }       
       };
        defaultColumnDefinitions['racenumber'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "N.Prova",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.racenumber || '';
          }       
       };
        defaultColumnDefinitions['racedate'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Data",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getRacedate() || '';
          }       
       };
        defaultColumnDefinitions['racefiledmsurl'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "racefiledmsurl",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.racefiledmsurl || '';
          }       
       };
        defaultColumnDefinitions['racetime'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "racetime",
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.dataBean.racetime || '';
           }       
        };
         defaultColumnDefinitions['racedistance'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "racedistance",
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.dataBean.racedistance || '';
           }       
        };
         defaultColumnDefinitions['racecoefficient'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "racecoefficient",
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.dataBean.racecoefficient || '';
           }       
        };
         defaultColumnDefinitions['racerating'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "racerating",
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.dataBean.racerating || '';
           }       
        };
         defaultColumnDefinitions['softwareversion'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "softwareversion",
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.dataBean.softwareversion || '';
           }       
        };
         defaultColumnDefinitions['softwarecode'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "softwarecode",
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.dataBean.softwarecode || '';
           }       
        };
        
        defaultColumnDefinitions['rectimestamp'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Ultima Mod.",
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
   	  var adaptedItem = new org.r3.db.sailevent.rankinginstance.RankingInstanceDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

