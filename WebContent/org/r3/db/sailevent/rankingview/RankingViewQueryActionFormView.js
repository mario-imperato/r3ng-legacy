//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.rankingview");

org.r3.db.sailevent.rankingview.RankingViewQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.sailevent.rankingview.RankingViewDTOAdapter(aRowDataBean); });   
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
        defaultColumnDefinitions['rankinggroup'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "rankinggroup",
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.dataBean.rankinggroup || '';
           }       
        };        
        defaultColumnDefinitions['ranktitle'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "ranktitle",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.ranktitle || '';
          }       
       };
        defaultColumnDefinitions['racegroup'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "racegroup",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.racegroup || '';
          }       
       };
        defaultColumnDefinitions['raceclass'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "raceclass",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.raceclass || '';
          }       
       };
        defaultColumnDefinitions['rankordering'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "rankordering",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.rankordering || '';
          }       
       };
        defaultColumnDefinitions['instanceid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "instanceid",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.instanceid || '';
          }       
       };
        defaultColumnDefinitions['racenumber'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "racenumber",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.racenumber || '';
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
        defaultColumnDefinitions['racedate'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "racedate",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.racedate || '';
          }       
       };
        
       return defaultColumnDefinitions;
   },
   
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.sailevent.rankingview.RankingViewDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

