//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.appcrewmemberview");

org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewDTOAdapter(aRowDataBean); });   
      return adapter;
   },
   
   _setupDefaultColumnDefinitions: function()
   { 
   	   var defaultColumnDefinitions = {};
   	      
   	
	   defaultColumnDefinitions['memberinfo'] = 
       {  
       	  "aTargets": [ -1 ], 
       	  "sClass": "center", 
       	  "sTitle": "Nominativo / Circolo",
          "render": function ( data, type, row, meta ) 
          {
          	    var item = data; 
                return item.getMemberInfo() || '';
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

        defaultColumnDefinitions['crewmemberid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "crewmemberid",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.crewmemberid || '';
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
        defaultColumnDefinitions['applicationid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "applicationid",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.applicationid || '';
          }       
       };
        defaultColumnDefinitions['cardnumber'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Numero",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.cardnumber || '';
          }       
       };
        defaultColumnDefinitions['crewmembername'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Nominativo",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.crewmembername || '';
          }       
       };
        defaultColumnDefinitions['weight'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "weight",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.weight || '';
          }       
       };
        defaultColumnDefinitions['crewmemberrolecode'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Ruolo",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getCrewmemberrolecode() || '';
          }       
       };
        defaultColumnDefinitions['memberstatuscode'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Tit/Ris.",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getMemberstatuscode() || '';
          }       
       };
        defaultColumnDefinitions['createtimestamp'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "createtimestamp",
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.dataBean.createtimestamp || '';
           }       
        };
         defaultColumnDefinitions['deletetimestamp'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "deletetimestamp",
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.dataBean.deletetimestamp || '';
           }       
        };
         defaultColumnDefinitions['checkcardnumber'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "&nbsp;",
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.getCheckcardnumberAsSemaphore() || '';
           }       
        };
         defaultColumnDefinitions['checkcardnumber_ts'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "Data Verif.",
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.getCheckcardnumber_ts() || '';
           }       
        };        
        defaultColumnDefinitions['recstatus'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "recstatus",
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.dataBean.recstatus || '';
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
        defaultColumnDefinitions['cardnumberstatuscode'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "&nbsp;",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getCardnumberstatuscodeAsSemaphore() || '';
          }       
       };
        defaultColumnDefinitions['yachtclub'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "yachtclub",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.yachtclub || '';
          }       
       };
        defaultColumnDefinitions['cardholdername'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "cardholdername",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.cardholdername || '';
          }       
       };
        defaultColumnDefinitions['cardholderlastname'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "cardholderlastname",
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.dataBean.cardholderlastname || '';
           }       
        };        
        defaultColumnDefinitions['medexamexpirationdate'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Vis. Med.",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getMedexamexpirationdate() || '';
          }       
       };
        defaultColumnDefinitions['cardexpirationdate'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "cardexpirationdate",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.cardexpirationdate || '';
          }       
       };
        defaultColumnDefinitions['renewaldate'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Rinnovo",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getRenewaldate() || '';
          }       
       };
        defaultColumnDefinitions['generalcardexpirationdate'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "generalcardexpirationdate",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.generalcardexpirationdate || '';
          }       
       };
        defaultColumnDefinitions['systemcheckdate'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "Data Verif. FIV",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getSystemcheckdate() || '';
          }       
       };
        defaultColumnDefinitions['sailnumber'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "sailnumber",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.sailnumber || '';
          }       
       };
        defaultColumnDefinitions['yachtname'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "yachtname",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.yachtname || '';
          }       
       };
        defaultColumnDefinitions['completionstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "completionstatus",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.completionstatus || '';
          }       
       };
        defaultColumnDefinitions['verificationstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "verificationstatus",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.verificationstatus || '';
          }       
       };
       defaultColumnDefinitions['numcoviddocs'] = 
       {
           "aTargets": [ -1 ],
           "sClass": "text-center",
           "sTitle": "Certif. Covid",
           "render": function ( data, type, row, meta )
           {
              var item = data; 
              return item.getNumcoviddocsAsSemaphore() || '';
           }       
        };
        
       return defaultColumnDefinitions;
   },
   
   addRawItem: function(anItem)
   {
   	  var adaptedItem = new org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

