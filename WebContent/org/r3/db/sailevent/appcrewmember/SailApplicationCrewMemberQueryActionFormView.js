//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.appcrewmember");

org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTOAdapter(aRowDataBean); });   
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

        defaultColumnDefinitions['crewmemberid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "crewmemberid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.crewmemberid || '';
          }       
       };
        defaultColumnDefinitions['eventid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "eventid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.eventid || '';
          }       
       };
        defaultColumnDefinitions['applicationid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "applicationid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.applicationid || '';
          }       
       };
        defaultColumnDefinitions['cardnumber'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "No. Tessera",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.cardnumber || '';
          }       
       };
        defaultColumnDefinitions['crewmembername'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Nominativo",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.crewmembername || '';
          }       
       };
        defaultColumnDefinitions['weight'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Peso",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.weight || '';
          }       
       };
        defaultColumnDefinitions['crewmemberrolecode'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Ruolo",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.getCrewmemberrolecode() || '';
          }       
       };
        defaultColumnDefinitions['memberstatuscode'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "memberstatuscode",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.memberstatuscode || '';
          }       
       };
        defaultColumnDefinitions['createtimestamp'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "createtimestamp",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.createtimestamp || '';
          }       
       };
        defaultColumnDefinitions['deletetimestamp'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "deletetimestamp",
           "fnRender": function ( oObj, sVal )
           {
              var item = oObj.aData; 
              return item.dataBean.deletetimestamp || '';
           }       
        };        
        defaultColumnDefinitions['checkcardnumber'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "checkcardnumber",
           "fnRender": function ( oObj, sVal )
           {
              var item = oObj.aData; 
              return item.dataBean.checkcardnumber || '';
           }       
        };
        defaultColumnDefinitions['checkcardnumber_ts'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "checkcardnumber_ts",
           "fnRender": function ( oObj, sVal )
           {
              var item = oObj.aData; 
              return item.dataBean.checkcardnumber_ts || '';
           }       
        };        
        defaultColumnDefinitions['recstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "recstatus",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.recstatus || '';
          }       
       };
        defaultColumnDefinitions['rectimestamp'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "rectimestamp",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.rectimestamp || '';
          }       
       };
        
       return defaultColumnDefinitions;
   },
   
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

