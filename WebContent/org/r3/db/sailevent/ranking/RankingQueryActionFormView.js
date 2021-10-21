//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.ranking");

org.r3.db.sailevent.ranking.RankingQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.sailevent.ranking.RankingDTOAdapter(aRowDataBean); });   
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
          "sTitle": "Id.",
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
           "sTitle": "Raggrupp.",
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.getRankinggroup() || '';
           }       
        };        
        defaultColumnDefinitions['ranktitle'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Nome classifica",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.ranktitle || '';
          }       
       };
        defaultColumnDefinitions['ranktype'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "ranktype",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.ranktype || '';
          }       
       };
        defaultColumnDefinitions['championship'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "championship",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.championship || '';
          }       
       };
        defaultColumnDefinitions['racegroup'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Raggrupp.",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getRacegroup() || '';
          }       
       };
        defaultColumnDefinitions['raceclass'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Classe",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getRaceclass() || '';
          }       
       };
        defaultColumnDefinitions['rating'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "IRC/ORC",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getRating() || '';
          }       
       };
        defaultColumnDefinitions['racefilepattern'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Nome file prova",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.racefilepattern || '';
          }       
       };
        defaultColumnDefinitions['overallfilepattern'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Nome file generale",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.overallfilepattern || '';
          }       
       };

        defaultColumnDefinitions['rankordering'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "&nbsp;",
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.dataBean.rankordering || '';
           }       
        };
        
        defaultColumnDefinitions['rectimestamp'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "rectimestamp",
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
   	  var adaptedItem = new org.r3.db.sailevent.ranking.RankingDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

