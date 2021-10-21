<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*,
    org.r3.db.system.site.SiteDTO
    " %>

<r3_lang:environment id="r3Env">

<%
  SiteDTO targetSite = r3Env.getRequestSite();
 %>
 

<div class="event-report">

<div class="header clearfix">
<div class="logo">
   <img src='/r3ng/resources/sites/<%=targetSite.getSiteresourcepath()%>/regattaeventLogo.png' border='0' />
</div>

<div class="title"><span ><%=targetSite.getSitedescr()%></span><br /><span style="font-size: 0.8em">Modulo di iscrizione</span></div>

<div class="report-status" >         
{% if (o.appDTO.isAccepted()) 
   {
          %}<img src='/r3ng/resources/img/sailevent/stamp_approved.jpg' /><br />
          {%=o.appDTO.getCommittimestamp()%}<br />
          Stato: {%           
   }
   else
   {
      if (o.appDTO.isCommit())
      {
          %}<img src='/r3ng/resources/img/sailevent/stamp_final.png' /><br />
           {%=o.appDTO.getCommittimestamp()%} 
          {%
      }
      else
      {
          %}<img src='/r3ng/resources/img/sailevent/stamp_draft.png' /><br />
           {%=o.appDTO.getCreatetimestamp()%} 
          {%
      }
   }    
%}   
</div>
</div>

<div class="panel panel-light">
  <div class="panel-heading" >  
    <h3 class="panel-title" >{%=o.appDTO.dataBean.applicationid%} - Informazioni Imbarcazione</h3>
  </div>
  
  <div class="panel-body">
       
   <div class="modulo_cvf">       
   <div style="width: 60%;" >
   <small>Nome Imbarcazione</small><p >{%=o.appDTO.dataBean.yachtname%}</p>
   </div>

   <div style="width: 39%;" >
   <small>Numero velico</small><p>{%=o.appDTO.dataBean.sailnumber%}</p>
   </div>
   </div>
       
   <div class="modulo_cvf">       
   <div style="width: 15%;" >
   <small>Colore Scafo</small><p >{%=o.appDTO.getPropertyValue('hullcolor', '')%}</p>
   </div>

   <div style="width: 15%;" >
   <small>Targa</small><p>{%=o.appDTO.dataBean.plate%}</p>
   </div>

   <div style="width: 35%;" >
   <small>Circolo Appartenenza</small><p >{%=o.appDTO.dataBean.yachtclub%}</p>
   </div>

   <div style="width: 35%;" >
   <small>Cantiere e Modello</small><p>{%=o.appDTO.getPropertyValue('yardship', '')%}  {%=o.appDTO.dataBean.yachttype%}</p>
   </div>
   </div>
   
   <div class="modulo_cvf">       
   <div style="width: 25%;" >
   <small>Lungh. </small><p >{%=o.appDTO.getPropertyValue('loa', '')%} </p>
   </div>

   <div style="width: 25%;" >
   <small> Largh.</small><p>{%=o.appDTO.getPropertyValue('beam', '')%} </p>
   </div>

   <div style="width: 10%;" >
   <small>Anno </small><p>{%=o.appDTO.getPropertyValue('year', '')%} </p>
   </div>

   <div style="width: 40%;" >
   <small>Porto di ormeggio </small><p>{%= org.r3.PageManager.getLUTItemDescription('GET_classifier_r3ea_mooringloc', o.appDTO.dataBean.mooringloc)%} {%=o.appDTO.getPropertyValue('mooringspec', '')%} </p>
   </div>
   </div>
       
    </div>
        
  </div>

<div class="panel panel-light">
  <div class="panel-heading" >  
    <h3 class="panel-title" >{%=o.appDTO.dataBean.applicationid%} - Armatore o suo rappresentante</h3>
  </div>
  
  <div class="panel-body">
  
   <div class="modulo_cvf">       
   <div style="width: 80%;" >
   <small>Nome Cognome </small><p >{%=o.appDTO.getOwnerfirstname()%} {%=o.appDTO.getOwnerlastname()%} </p>
   </div>

   <div style="width: 20%;" >
   <small>Telefono </small><p>{%=o.appDTO.getOwnerphone()%} </p>
   </div>
   </div>
   
   <div class="modulo_cvf">       
   <div style="width: 70%;" >
   <small>Indirizzo </small><p >{%=o.appDTO.getOwneraddress()%} </p>
   </div>

   <div style="width: 10%;" >
   <small> C.a.p.</small><p>{%=o.appDTO.getOwnerzipcode()%} </p>
   </div>
   
   <div style="width: 20%;" >
   <small>Citt&agrave; </small><p>{%=o.appDTO.getOwnertown()%} </p>
   </div>   
   </div>
   
   <div class="modulo_cvf">       
   <div style="width: 20%;" >
   <small>Cellulare </small><p > {%=o.appDTO.getOwnercellphone()%}</p>
   </div>

   <div style="width: 80%;" >
   <small>E-mail </small><p>{%=o.appDTO.getOwneremail()%} </p>
   </div>
   </div>
 
   <!-- Timoniere -->
   {% if (o.appDTO.getHavehelmsman())  { %}
   <div style="margin-left: 50px">
   <!-- 
   <div style="margin-left: 20px; margin-top: 10px;">
   <label style="display: block; width: 220px;"><img src="/r3ng/resources/img/icons/checkbox_on.png"  border="0" /> Informazioni Timoniere</label>
   </div>
   -->
      
   <div class="modulo_cvf">       
   <div style="width: 80%;" >
   <small>Nome Cognome </small><p >{%=o.appDTO.getHelmsmanfirstname()%} {%=o.appDTO.getHelmsmanlastname()%}  </p>
   </div>

   <div style="width: 20%;" >
   <small>Telefono </small><p>{%=o.appDTO.getHelmsmanphone()%} </p>
   </div>
   </div>
   
   <div class="modulo_cvf">       
   <div style="width: 70%;" >
   <small>Indirizzo </small><p >{%=o.appDTO.getHelmsmanaddress()%}</p>
   </div>

   <div style="width: 10%;" >
   <small> C.a.p.</small><p>{%=o.appDTO.getHelmsmanzipcode()%} </p>
   </div>
   
   <div style="width: 20%;" >
   <small>Citt&agrave; </small><p>{%=o.appDTO.getHelmsmantown()%} </p>
   </div>   
   </div>
   
   <div class="modulo_cvf">       
   <div style="width: 20%;" >
   <small>Cellulare </small><p > {%=o.appDTO.getHelmsmancellphone()%}</p>
   </div>

   <div style="width: 80%;" >
   <small>E-mail </small><p>{%=o.appDTO.getHelmsmanemail()%} </p>
   </div>

   </div>   
   {% } %}
   
    </div>
    
   </div>
</div>
<div class="panel panel-light">
  <div class="panel-heading" >  
    <h3 class="panel-title" >{%=o.appDTO.dataBean.applicationid%} - Iscrizione</h3>
  </div>
  
  <div class="panel-body">
      
      <form class="form-horizontal">
      <div class="form-group">
        <label class="col-md-2 col-xs-2 control-label "  >Raggruppamento</label>
        <div class="col-md-10 col-xs-10 columns" >
 		{%
         var raceGroupValue = o.appDTO.dataBean.racegroup;
         var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_boatgroup');    
         var theLUT = org.r3.PageManager.lutManager.getLUT(resolvedUrl);
         if (theLUT.aaData && theLUT.iTotalRecords)
         {     
             $.each(theLUT.aaData, function(index, item)
             {
                var checkBoxIcon = (raceGroupValue && raceGroupValue.indexOf(item.dtokey) >= 0) ? 'checkbox_on.png' : 'checkbox_off.png';
                 var checked = (raceGroupValue && raceGroupValue.indexOf(item.dtokey) >= 0) ? 'checked' : '';
          %}
          
            <label class='checkbox-inline' style='width: 45%'>
               <input name="racegroup" id="{%=item.dtokey%}" type="checkbox" value="{%=item.dtokey%}" {%=checked%}>{%=item.dtodescr%}</label>
            
          {% });
         } %}             
        </div>
      </div>
      </form>
      
      <form class="form-horizontal">
      <div class="form-group">
        <label class="col-md-2 col-xs-2 control-label "  >Classifiche</label>
        <div class="col-md-10 col-xs-10 columns" >
         {%
         var rankTypeValue = o.appDTO.getPropertyValue('ranktype', null);
         var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_ranktype');    
         var theLUT = org.r3.PageManager.lutManager.getLUT(resolvedUrl);
         if (theLUT.aaData && theLUT.iTotalRecords)
         {     
             $.each(theLUT.aaData, function(index, item)
             {
                var checkBoxIcon = (rankTypeValue && rankTypeValue.indexOf(item.dtokey) >= 0) ? 'checkbox_on.png' : 'checkbox_off.png';
                var checked = (rankTypeValue && rankTypeValue.indexOf(item.dtokey) >= 0) ? 'checked' : '';
          %}
           <label class='checkbox-inline' style='width: 45%'>
               <input name="ranktype" id=" {%=item.dtokey%}" type="checkbox" value="{%=item.dtokey%}" {%=checked%}>{%=item.dtodescr%}</label>
          {% });
         } %}          
        </div>
      </div>
      </form>
      
      <form class="form-horizontal " id="appviewer_classinfoform_racegroupdecl_checkboxgroup">
      <div class="form-group">
        <label class="col-md-2 col-xs-2 control-label "  >&nbsp;</label>
        <div class="col-md-10 col-xs-10 columns" >
         {%
         var racegroupdeclValue = o.appDTO.getPropertyValue('racegroupdecl', null);
         var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_boatgroup2');    
         var theLUT = org.r3.PageManager.lutManager.getLUT(resolvedUrl);
         if (theLUT.aaData && theLUT.iTotalRecords)
         {     
             $.each(theLUT.aaData, function(index, item)
             {
                var checked = (racegroupdeclValue && racegroupdeclValue.indexOf(item.dtokey) >= 0) ? 'checked' : '';
                var checkBoxIcon = (racegroupdeclValue && racegroupdeclValue.indexOf(item.dtokey) >= 0) ? 'checkbox_on.png' : 'checkbox_off.png';
          %}
          <label class='checkbox-inline' style='width: 45%'>
               <input name="racegroupdecl" id=" {%=item.dtokey%}" type="checkbox" value="{%=item.dtokey%}" {%=checked%}>{%=item.dtodescr%}</label>
                         
          {% });
         } %}          
        </div>
      </div>
      </form>

      <form class="form-horizontal" id="appviewer_classinfoform_apptype_framedpanel">
      <div class="form-group">
        <label class="col-md-2 col-xs-2 control-label "  >Desidero iscrivermi</label>
        <div class="col-md-10 col-xs-10 columns" >
         {%
         var appTypeValue = o.appDTO.dataBean.apptype;
         var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_apptype');    
         var theLUT = org.r3.PageManager.lutManager.getLUT(resolvedUrl);
         if (theLUT.aaData && theLUT.iTotalRecords)
         {     
             $.each(theLUT.aaData, function(index, item)
             {
                var checked = (appTypeValue && appTypeValue.indexOf(item.dtokey) >= 0) ? 'checked' : '';
                var checkBoxIcon = (appTypeValue && appTypeValue.indexOf(item.dtokey) >= 0) ? 'checkbox_on.png' : 'checkbox_off.png';
          %}
             <label class='checkbox-inline' style='width: 45%'>
               <input name="apptype" id=" {%=item.dtokey%}" type="checkbox" value="{%=item.dtokey%}" {%=checked%}>{%=item.dtodescr%}</label>
          {% });
         } %}          
        </div>
      </div>
      </form>
      
    </div>
  </div>

<div class="panel panel-light" id='appviewer_classinfoform_grancrocieraorc_framedpanel' >
  <div class="panel-heading" >  
    <h3 class="panel-title" >{%=o.appDTO.dataBean.applicationid%} - Dichiarazione Appartenenza alla categoria Gran Crociera</h3>
  </div>
  
  <div class="panel-body">

      <p>
      Sulla barca devono essere presenti quattro dei parametri sottoelencati, se si utilizzano vele a bassa tecnologia, altrimenti almeno cinque.
      Con la presente dichiaro che l'imbarcazione presenta i parametri marcati e mantiene gli arredi la configuarazione originale di barca da 
      diporto e non utilizza carbonio per scafo, appendici, antenne (albero e boma) e per le vele.      
      </p>
            
      <form class="form-horizontal">
      <div class="form-group">
        <label class="col-md-2 col-xs-2 control-label "  >Parametri</label>
        <div class="col-md-10 col-xs-10 columns" >
         {%
         var grancrocieraValue = o.appDTO.getPropertyValue('grancrocieraorc', null);
         var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_orcgranc');    
         var theLUT = org.r3.PageManager.lutManager.getLUT(resolvedUrl);
         if (theLUT.aaData && theLUT.iTotalRecords)
         {     
             $.each(theLUT.aaData, function(index, item)
             {
                var checked = (grancrocieraValue && grancrocieraValue.indexOf(item.dtokey) >= 0) ? 'checked' : '';
                var checkBoxIcon = (appTypeValue && appTypeValue.indexOf(item.dtokey) >= 0) ? 'checkbox_on.png' : 'checkbox_off.png';
          %}
          <label class='checkbox-inline' >
               <input name="grancrociera" id=" {%=item.dtokey%}" type="checkbox" value="{%=item.dtokey%}" {%=checked%}>{%=item.dtodescr%}</label>                                    
          {% });
         } %}              
          </div>
      </div>
      </form>
     </div>
   </div>

<div class="panel panel-light"  >
  <div class="panel-heading" >  
    <h3 class="panel-title" >{%=o.appDTO.dataBean.applicationid%} - Esposizione pubblicit&agrave;</h3>
  </div>
  
  <div class="panel-body">

      <form class="form-horizontal">
      <div class="form-group">
        <div class="col-md-12 col-xs-12 columns" >
        
         {%
         var haveAdvertisingValue = o.appDTO.getPropertyValueAsBoolean('haveadvertising');
         var checked = (haveAdvertisingValue) ? 'checked' : '';
         var checkBoxIcon = (haveAdvertisingValue) ? 'checkbox_on.png' : 'checkbox_off.png';
          %}
         <label class='checkbox-inline' style='width: 100%'>
               <input name="advertising" id=" has_advertising" type="checkbox" value="id_has_advertising" {%=checked%}>La mia imbarcazione espone della pubblicità (quindi allego una copia della licenza FIV per l'anno in corso)</label>    
                         
          </div>
      </div>
      </form>
      
     </div>
   </div>

<div class="panel panel-light" id='appviewer_boatinfoform_otherinfo_framedpanel' >
  <div class="panel-heading" >  
    <h3 class="panel-title" >{%=o.appDTO.dataBean.applicationid%} - Altre Caratteristiche</h3>
  </div>
  
  <div class="panel-body">
    
         {%
         var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_boatelse');    
         var theLUT = org.r3.PageManager.lutManager.getLUT(resolvedUrl);
         if (theLUT.aaData && theLUT.iTotalRecords)
         {     
             $.each(theLUT.aaData, function(index, item)
             {
          %}
            <div class="cmsCard"><p> {%=item.dtodescr%}: <b>{%=o.appDTO.getPropertyValue(item.dtokey.toLowerCase(), '')%}</b></p></div>
          {% });
         } %}   
             
    </div>
  </div>

<div class="panel panel-light"  >
  <div class="panel-heading" >  
    <h3 class="panel-title" >{%=o.appDTO.dataBean.applicationid%} - Materiale di costruzione delle vele</h3>
  </div>
  
  <div class="panel-body">

     <form class="form-horizontal">
      
     <div class="form-group">
     <label class="col-md-2 col-xs-2 control-label"  >Materiale</label>
     <div class="col-md-10 col-xs-10 columns" >

{%       var sailMaterialValue = o.appDTO.getPropertyValue('sailmaterial', null);
         var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_sailmat');    
         var theLUT = org.r3.PageManager.lutManager.getLUT(resolvedUrl);
         if (theLUT.aaData && theLUT.iTotalRecords)
         {     
             $.each(theLUT.aaData, function(index, item)
             {
                var checked = (sailMaterialValue && sailMaterialValue.indexOf(item.dtokey) >= 0) ? 'checked' : '';
          %}
          
     <label class="checkbox-inline" >     
         <input name="sailmaterial" id="{%=item.dtokey%}" type="checkbox" value="{%=item.dtokey%}" {%=checked%}>{%=item.dtodescr%}</label>
     
       {% });
         } %}          
        
     </div>
     </div>

     </form>

    </div>
  </div>

 <div class="panel panel-light" >
  <div class="panel-heading" >  
    <h3 class="panel-title" >{%=o.appDTO.dataBean.applicationid%}</label> - Spazio Riservato alla Segreteria</h3>
  </div>

  <div class="panel-body">     

      <form class="form-horizontal">
      <div class="form-group">
        <label class="col-md-2 col-xs-2 control-label "  >Elementi verificati</label>
        <div class="col-md-10 col-xs-10 columns" >
        
         {%
         var adminChecksGroupValue = o.appDTO.dataBean.adminchecks;
         var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_admincks');    
         var theLUT = org.r3.PageManager.lutManager.getLUT(resolvedUrl);
         if (theLUT.aaData && theLUT.iTotalRecords)
         {     
             $.each(theLUT.aaData, function(index, item)
             {
                var checked = (adminChecksGroupValue && adminChecksGroupValue.indexOf(item.dtokey) >= 0) ? 'checked' : '';
                var checkBoxIcon = (adminChecksGroupValue && adminChecksGroupValue.indexOf(item.dtokey) >= 0) ? 'checkbox_on.png' : 'checkbox_off.png';
          %}
          <label class='checkbox-inline' >
               <input name="adminchecks" id=" {%=item.dtokey%}" type="checkbox" value="{%=item.dtokey%}" {%=checked%}>{%=item.dtodescr%}</label>              
                          
          {% });
         } %}          
          </div>
      </div>
     </form>
  
  </div>
        
  </div>

    
  <div class="panel panel-light" >
  <div class="panel-heading" >  
    <h3 class="panel-title" >{%=o.appDTO.dataBean.applicationid%} - Prospetto Riassuntivo delle Autorizzazioni</h3>
  </div>
  
  <div class="panel-body">     

      {%
       var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_authoriz');    
       var theLUT = org.r3.PageManager.lutManager.getLUT(resolvedUrl);
       if (theLUT.aaData && theLUT.iTotalRecords)
       {
             $.each(theLUT.aaData, function(index, item)
             {
      %} 

      <form class="form-horizontal">
      <div class="form-group">
        <label class="col-md-4 col-xs-5 control-label "  >{%=item.dtodescr%}</label>
        <div class="col-md-8 col-xs-7 columns" >
          {%
     
                 var authValue = o.appDTO.getPropertyValue(item.dtokey, null);
                 var checked_true = (authValue && authValue.indexOf('btrue') >= 0) ? 'checked' : '';
                 var checked_false =  (authValue && authValue.indexOf('bfalse') >= 0) ? 'checked' : '';
                    
                 var checkBoxIcon_true  =  (authValue && authValue.indexOf('btrue') >= 0) ? 'checkbox_on.png' : 'checkbox_off.png';
                 var checkBoxIcon_false =  (authValue && authValue.indexOf('bfalse') >= 0) ? 'checkbox_on.png' : 'checkbox_off.png';
                 %} 
          <label class='checkbox-inline' style='width: 40%'>
               <input name="authorizations" id="{%=item.dtokey%}_btrue" type="checkbox" value="btrue" {%=checked_true%}>Do il consenso</label>              

          <label class='checkbox-inline' style='width: 40%' >
               <input name="authorizations" id="{%=item.dtokey%}_btrue" type="checkbox" value="btrue" {%=checked_false%}>Nego il consenso</label>              

          </div>
       </div>
       </form>          
          {%     
              
             });
       } %}

      </div>
    </div>
       
    <table class="table hidden-print" >
    <thead>
      <tr>
      <th  colspan="2">
      <label class="fieldReadOnly" >{%=o.appDTO.dataBean.applicationid%}</label> - Documenti allegati
      </th>
      </tr>              
    </thead>
    <tbody>

      {% 
      var numberOfItems = (o.docsDTO && o.docsDTO.getNumberOfItems()) || 0;
      console.info("Number is: ", numberOfItems, o.docsDTO);
      if (numberOfItems > 0) 
      {
         for( var i = 0; i < numberOfItems; i++)
         {
              var theItem =  o.docsDTO.getItem(i);
      %}            
      <tr>
      <td  style="width: 20%; height: 30px">
      <a href="javascript:void(0)" onclick="org.r3.PageManager.viewDocument('{%=theItem.dataBean.documenturl%}');"><i class="fa fa-file-pdf-o">&nbsp;</i>{%=theItem.getDocumenttypecode()%}</a>
      </td>
      <td  style="width: 80%; height: 30px">
      <a href="javascript:void(0)" onclick="org.r3.PageManager.viewDocument('{%=theItem.dataBean.documenturl%}');">{%=theItem.dataBean.documentname%}</a>            
      </td>
      </tr>
      {%
         }
      }
      else 
      {
      %}
      <tr>
      <td  style="width: 20%">
      &nbsp;
      </td>
      <td  style="width: 80%">
      Alla domanda non sono stati allegati documenti
      </td>      
      </tr> 
      {%
      } %}   
    </tbody>
    </table>      
    
    <table class="table" >
    <thead>
      <tr>
      <th  colspan="4">
      <label class="fieldReadOnly" >{%=o.appDTO.dataBean.applicationid%}</label> - Dati di dettaglio dell'equipaggio
      </th>
      </tr>
      <tr>
      <th  style="width: 10%; vertical-align: middle">
      No. Tessera FIV
      </th>
      <th  style="width: 50%; vertical-align: middle">
      Nominativo
      </th>
      <th style="width: 20%; vertical-align: middle">
      Ruolo                      
      </th>
      <th style="width: 10%; vertical-align: middle; text-align: center">
      Peso Kg.<br />(Solo ORC)                      
      </th>
      <th style="width: 10%; vertical-align: middle; text-align: center">
      Tit/Ris.                      
      </th>      
      </tr>                    
    </thead>
    <tbody>

      {% 
      var numberOfItems = (o.crewDTO && o.crewDTO.getNumberOfItems()) || 0;
      console.info("Number is: ", numberOfItems, o.crewDTO);
      if (numberOfItems > 0) 
      {
         for( var i = 0; i < numberOfItems; i++)
         {
              var theItem =  o.crewDTO.getItem(i);
      %}            
      <tr>
      <td  style="width: 10%;">
      {%=theItem.dataBean.cardnumber%}            
      </td>
      <td  style="width: 50%;">
      {%=theItem.dataBean.crewmembername%}            
      </td>
      <td  style="width: 20%;">
      {%= org.r3.PageManager.getLUTItemDescription('GET_classifier_r3ea_crewrole', theItem.dataBean.crewmemberrolecode)%}            
      </td>
      <td  style="width: 10%;text-align: center">
      {%=theItem.dataBean.weight%}            
      </td>
      <td  style="width: 10%;text-align: center">
      {%=theItem.getMemberstatuscode()%}            
      </td>       
      </tr>
      {%
         }
      } %}

      {% for(var emptyLine = 0; emptyLine < (10 - numberOfItems); emptyLine++)
      { %}         
      <tr>
      <td  style="width: 10%;">
      &nbsp;   
      </td>
      <td  style="width: 50%;">
      &nbsp;            
      </td>
      <td  style="width: 20%;">
      &nbsp;            
      </td>
      <td  style="width: 10%;">
      &nbsp;            
      </td>
      <td  style="width: 10%;">
      &nbsp;            
      </td>      
      </tr>
      {% } %}   
    </tbody>
    </table>      
  
    {%
       var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_authoriz');    
       var theLUT = org.r3.PageManager.lutManager.getLUT(resolvedUrl);
       if (theLUT.aaData && theLUT.iTotalRecords)
       {
             $.each(theLUT.aaData, function(index, item)
             {
                 %} <div id="appviewer_{%=item.classifieritemsattr%}"></div> {%
             });
       }
     %}
  
</div>

</r3_lang:environment>