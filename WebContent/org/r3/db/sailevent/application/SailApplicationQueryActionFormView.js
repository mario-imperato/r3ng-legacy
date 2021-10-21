//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.application");

org.r3.db.sailevent.application.SailApplicationQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.sailevent.application.SailApplicationDTOAdapter(aRowDataBean); });   
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
        defaultColumnDefinitions['dmsfolderurl'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "dmsfolderurl",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.dmsfolderurl || '';
          }       
       };
        defaultColumnDefinitions['annotation'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "annotation",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.annotation || '';
          }       
       };
        defaultColumnDefinitions['completionstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "completionstatus",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.completionstatus || '';
          }       
       };
        defaultColumnDefinitions['verificationstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "verificationstatus",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.verificationstatus || '';
          }       
       };
        defaultColumnDefinitions['adminchecks'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "adminchecks",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.adminchecks || '';
          }       
       };
        defaultColumnDefinitions['adminracegroup'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "adminracegroup",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.adminracegroup || '';
          }       
       };
        defaultColumnDefinitions['adminraceclass'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "adminraceclass",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.adminraceclass || '';
          }       
       };
        defaultColumnDefinitions['plate'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "plate",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.plate || '';
          }       
       };
        defaultColumnDefinitions['yachtname'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "yachtname",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.yachtname || '';
          }       
       };
        defaultColumnDefinitions['yachtclub'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "yachtclub",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.yachtclub || '';
          }       
       };
        defaultColumnDefinitions['yachttype'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "yachttype",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.yachttype || '';
          }       
       };
        defaultColumnDefinitions['mooringloc'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "mooringloc",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.mooringloc || '';
          }       
       };
        defaultColumnDefinitions['yachtbsf'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "yachtbsf",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.yachtbsf || '';
          }       
       };
        defaultColumnDefinitions['yachtgph'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "yachtgph",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.yachtgph || '';
          }       
       };
        defaultColumnDefinitions['sailnumber'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "sailnumber",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.sailnumber || '';
          }       
       };
        defaultColumnDefinitions['racegroup'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "racegroup",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.racegroup || '';
          }       
       };
        defaultColumnDefinitions['raceclass'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "raceclass",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.raceclass || '';
          }       
       };
        defaultColumnDefinitions['apptype'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "apptype",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.apptype || '';
          }       
       };
        defaultColumnDefinitions['ownerid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "ownerid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.ownerid || '';
          }       
       };
        defaultColumnDefinitions['helmsmanid'] = 
        {
        	  "aTargets": [ -1 ],
           "sClass": "left",
           "sTitle": "helmsmanid",
           "fnRender": function ( oObj, sVal )
           {
              var item = oObj.aData; 
              return item.dataBean.helmsmanid || '';
           }       
        };        
        defaultColumnDefinitions['boatimageid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "boatimageid",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.boatimageid || '';
          }       
       };
        defaultColumnDefinitions['boatimageurl'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "boatimageurl",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.boatimageurl || '';
          }       
       };
        defaultColumnDefinitions['boatimageheight'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "boatimageheight",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.boatimageheight || '';
          }       
       };
        defaultColumnDefinitions['boatimagewidth'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "boatimagewidth",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.boatimagewidth || '';
          }       
       };
        defaultColumnDefinitions['boaticonurl'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "boaticonurl",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.boaticonurl || '';
          }       
       };
        defaultColumnDefinitions['boaticonwidth'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "boaticonwidth",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.boaticonwidth || '';
          }       
       };
        defaultColumnDefinitions['boaticonheight'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "boaticonheight",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.boaticonheight || '';
          }       
       };
        defaultColumnDefinitions['addtohomeentrylist'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "addtohomeentrylist",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.addtohomeentrylist || '';
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
        defaultColumnDefinitions['committimestamp'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "left",
          "sTitle": "committimestamp",
          "fnRender": function ( oObj, sVal )
          {
             var item = oObj.aData; 
             return item.dataBean.committimestamp || '';
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
   	  var adaptedItem = new org.r3.db.sailevent.application.SailApplicationDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

