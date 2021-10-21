//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


jQuery.r3Utils.namespace("org.r3.db.sailevent.applicationview");

org.r3.db.sailevent.applicationview.SailApplicationViewQueryActionFormView = org.r3.db.DataTableEntityActionFormView.extend(
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
      var adapter = new org.r3.db.DTOTableAdapter(serverResponseData, function(aRowDataBean) { return new org.r3.db.sailevent.applicationview.SailApplicationViewDTOAdapter(aRowDataBean); });   
      return adapter;
   },
   
   // Estensione!
   getColumnDefinitions_sTitle_4adminchecks: function()
   {
	   var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_admincks');    
       var theLUT = org.r3.PageManager.lutManager.getLUT(resolvedUrl);
       
       var result = '';
       if (theLUT.aaData && theLUT.iTotalRecords)
       {           	       	 
           $.each(theLUT.aaData, function(index, item)
           {
              result = result + item.classifieritemsattr + ' ';
           });
           
       }
       
	   return result;
   },
   
   _setupDefaultColumnDefinitions: function()
   { 
   	   var defaultColumnDefinitions = {};
   	      
   	   defaultColumnDefinitions['indexofitem'] = 
       {  
       	  "aTargets": [ -1 ], 
       	  "sClass": "text-center", "sTitle": "",
          "render": function ( data, type, row, meta ) 
          {
          	    var item = data; 
                return item.indexOfItem;
          }
       };

       defaultColumnDefinitions['ownername'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": "Armatore",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.ownerlastname || '';
          }       
       };

       defaultColumnDefinitions['racegroup_raceclass'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": "Raggrup.",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             var s = item.getRacegroup();
             var s1 = item.getRaceclass();
             if (s) 
             {
                 if (s1)
                	 s = s + ' ' + s1;
                 
                 return s;	 
             }
             
             return '';             
          }       
       };

        defaultColumnDefinitions['eventid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
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
          "sClass": "text-left",
          "sTitle": "Id.",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.applicationid || '';
          }       
       };
        defaultColumnDefinitions['userid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": "Id. utente",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.userid || '';
          }       
       };
        defaultColumnDefinitions['completionstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-center",
          "sTitle": "&nbsp;",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getCompletionstatusAsSemaphore() || '';
          }       
       };
        defaultColumnDefinitions['verificationstatus'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": "verificationstatus",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getVerificationstatusAsSemaphore() || '';
          }       
       };
        defaultColumnDefinitions['adminchecks'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-center",
          "sTitle": this.getColumnDefinitions_sTitle_4adminchecks,
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.getAdminchecks() || '';
          }       
       };
       defaultColumnDefinitions['accepted'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-center sevapp-accepted-label",
          "sTitle": '&nbsp;',
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             if (item.isAccepted()) {
                return  "<div style='background-color: #12633e; color: white; padding: 2px'>COMPLETATA</div>";
             } else {
				return "<div style='background-color: #bb0606; color: white; padding: 2px'>DA&nbsp;COMPLETARE</div>";
             }             
          }       
       };
        defaultColumnDefinitions['plate'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": "Targa",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.plate || '';
          }       
       };
        defaultColumnDefinitions['sailnumber'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": "No. velico",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.sailnumber || '';
          }       
       };
        defaultColumnDefinitions['yachtname'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": "Nome imbarcazione",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.yachtname || '';
          }       
       };
        defaultColumnDefinitions['yachtclub'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": "Yacht Club",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.yachtclub || '';
          }       
       };
        defaultColumnDefinitions['yachttype'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": "Tipo modello",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.yachttype || '';
          }       
       };
        defaultColumnDefinitions['mooringloc'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": "Ormeggio",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.mooringloc || '';
          }       
       };
        defaultColumnDefinitions['yachtbsf'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": "BSF",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.yachtbsf || '';
          }       
       };
        defaultColumnDefinitions['yachtgph'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": "GPH",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.yachtgph || '';
          }       
       };
        defaultColumnDefinitions['racegroup'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
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
          "sClass": "text-left",
          "sTitle": "raceclass",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.raceclass || '';
          }       
       };
        defaultColumnDefinitions['apptype'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": "Tipo Iscriz.",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.apptype || '';
          }       
       };
        defaultColumnDefinitions['ownerid'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": "Id. Armatore",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.ownerid || '';
          }       
       };
        defaultColumnDefinitions['ownerfirstname'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": "ownerfirstname",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.ownerfirstname || '';
          }       
       };
        defaultColumnDefinitions['ownerlastname'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": "ownerlastname",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.ownerlastname || '';
          }       
       };
        defaultColumnDefinitions['owneremail'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": "e-mail",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.owneremail || '';
          }       
       };
        defaultColumnDefinitions['ownercellphone'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": "Cellulare",
          "render": function ( data, type, row, meta )
          {
             var item = data; 
             return item.dataBean.ownercellphone || '';
          }       
       };
        defaultColumnDefinitions['rectimestamp'] = 
       {
       	  "aTargets": [ -1 ],
          "sClass": "text-left",
          "sTitle": "Modifica",
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
   	  var adaptedItem = new org.r3.db.sailevent.applicationview.SailApplicationViewDTOAdapter(anItem);   
   	  this.addItem(adaptedItem);
   },
   
   addAdaptedItem: function(anAdaptedItem)
   {
   	  this.addItem(anAdaptedItem);
   }
 
});

