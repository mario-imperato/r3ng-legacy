//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.appeventlogview");

org.r3.db.sailevent.appeventlogview.SailApplicationEventLogViewQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.sailevent.appeventlogview.SailApplicationEventLogViewDTOAdapter(aRowDataBean); });   
      return adapter;
   },
   
   _setupDefaultColumnDefinitions: function()
   { 
   	   var defaultColumnDefinitions = {};
   	      
   	   defaultColumnDefinitions['indexofitem'] = 
       {  
       	  "aTargets": [ -1 ], 
       	  "sClass": "center", "sTitle": "",
          "fnRender": function ( oObj, sVal ) 
          {
          	    var item = oObj.aData; 
                return item.indexOfItem;
          }
       };

        defaultColumnDefinitions['site'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "site",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.site || '';
          }       
       };
        defaultColumnDefinitions['usecaseambit'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "usecaseambit",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.usecaseambit || '';
          }       
       };
        defaultColumnDefinitions['applicationid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Id.",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.applicationid || '';
          }       
       };
        defaultColumnDefinitions['applicationinfo'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "Info",
           "fnRender": function ( oObj, sVal )
           {
              var item = oObj.aData; 
              return item.getApplicationinfo() || '';
           }       
        };        
        defaultColumnDefinitions['userid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "userid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.userid || '';
          }       
       };
        defaultColumnDefinitions['sailnumber'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "No. Vel.",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.sailnumber || '';
          }       
       };
        defaultColumnDefinitions['yachtname'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Imbarcazione",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.yachtname || '';
          }       
       };
        defaultColumnDefinitions['ownername'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Armatore",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.ownername || '';
          }       
       };
        defaultColumnDefinitions['latest_ts'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.getLatest_ts()  || '';
          }       
       };
        defaultColumnDefinitions['ev_info'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "center",
           "sTitle": "GEN DOC EQ CONF",
           "fnRender": function ( oObj, sVal )
 		  {
 				var item = oObj.aData; 				
 				return item.getEv_info();
 		  }
        };

        defaultColumnDefinitions['ev_general'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "center",
          "sTitle": "Gen.",
          "fnRender": function ( oObj, sVal )
		  {
				var item = oObj.aData; 				
				return item.getEv_generalAsSemaphore();
		  }
       };
        defaultColumnDefinitions['ev_general_ts'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "ev_general_ts",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.ev_general_ts || '';
          }       
       };
        defaultColumnDefinitions['ev_document'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "center",
          "sTitle": "Doc.",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.getEv_documentAsSemaphore() || '';
          }       
       };
        defaultColumnDefinitions['ev_doc_ts'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "ev_doc_ts",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.ev_doc_ts || '';
          }       
       };
        defaultColumnDefinitions['ev_crew'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "center",
          "sTitle": "Equip.",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.getEv_crewAsSemaphore() || '';
          }       
       };
        defaultColumnDefinitions['ev_crew_ts'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "ev_crew_ts",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.ev_crew_ts || '';
          }       
       };
        defaultColumnDefinitions['ev_commit'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "center",
          "sTitle": "Conf.",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.getEv_commitAsSemaphore() || '';
          }       
       };
        defaultColumnDefinitions['ev_commit_ts'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "ev_commit_ts",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.ev_commit_ts || '';
          }       
       };
        
       return defaultColumnDefinitions;
   },
   
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.sailevent.appeventlogview.SailApplicationEventLogViewDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

