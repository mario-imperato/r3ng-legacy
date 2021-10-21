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

<table class='table table-condensed' >
<thead>
<tr>
<th>{%=o.appDTO.dataBean.applicationid%} - Spazio Riservato alla Segreteria</th>
</tr>
</thead>
<tbody>
<td>
        <div class="columns columns-condensed" >
        
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
</td>
</tbody>
</table>

<table class='table table-condensed'>
<thead>
<tr>
<th colspan="4">{%=o.appDTO.dataBean.applicationid%} - Informazioni Imbarcazione</th>
</tr>
</thead>
<tbody>
<tr>
   <td style='width: 25%'>Nome Imbarcazione</td><td style='width: 35%'><b>{%=o.appDTO.dataBean.yachtname%}</b></td>   
   <td style='width: 15%'>Numero velico</td><td style='width: 25%'><b>{%=o.appDTO.dataBean.sailnumber%}</b></td>
</tr>
<tr>
   <td style='width: 25%'>Cantiere - Modello - Anno</td><td  style='width: 35%'><b>{%=o.appDTO.getPropertyValue('yardship', '')%}  {%=o.appDTO.dataBean.yachttype%} {%=o.appDTO.getPropertyValue('year', '')%}</b></td>
   <td style='width: 15%'>Colore Scafo</td><td  style='width: 25%'><b>{%=o.appDTO.getPropertyValue('hullcolor', '')%}</b></td>
</tr>
<tr>
   <td style='width: 25%'>Circolo Appartenenza</td><td  style='width: 35%'><b>{%=o.appDTO.dataBean.yachtclub%}</b></td>    
   <td style='width: 15%'>Targa</td><td style='width: 25%'><b>{%=o.appDTO.dataBean.plate%}</b></td>      
</tr>
<tr>
   <td style='width: 25%'>Porto di ormeggio </td><td  style='width: 35%'><b>{%= org.r3.PageManager.getLUTItemDescription('GET_classifier_r3ea_mooringloc', o.appDTO.dataBean.mooringloc)%} {%=o.appDTO.getPropertyValue('mooringspec', '')%}</b> </td>   
   <td style='width: 15%'>Lungh. / Largh. </td><td style='width: 25%'><b>{%=o.appDTO.getPropertyValue('loa', '')%} / {%=o.appDTO.getPropertyValue('beam', '')%}</b> </td>
</tr>
</tbody>
</table>

<table class='table table-condensed'>
<thead>
<tr>
<th colspan="4">{%=o.appDTO.dataBean.applicationid%} - Armatore o suo rappresentante</th>
</tr>
</thead>
<tbody>
<tr>   
   <td style='width: 25%'>Nome Cognome </td><td style='width: 35%'><b>{%=o.appDTO.getOwnerfirstname()%} {%=o.appDTO.getOwnerlastname()%} </b></td>
   <td style='width: 15%'>Indirizzo </td><td style='width: 25%'><b>{%=o.appDTO.getOwneraddress()%} </b></td>   
</tr>
<tr>   
   <td style='width: 25%'>E-mail </td><td style='width: 35%'><b>{%=o.appDTO.getOwneremail()%} </b></td>
   <td style='width: 15%'> C.a.p.</td><td style='width: 25%'><b>{%=o.appDTO.getOwnerzipcode()%} </b></td>
</tr>
<tr>   
   <td style='width: 25%'>Telefono </td><td style='width: 35%'><b>{%=o.appDTO.getOwnerphone()%} </b></td>
   <td style='width: 15%'>Citt&agrave; </td><td style='width: 25%'><b>{%=o.appDTO.getOwnertown()%} </b></td>
</tr>
<tr>   
   <td style='width: 25%'>Cellulare </td><td style='width: 35%'><b> {%=o.appDTO.getOwnercellphone()%}</b></td>
</tr> 
</tbody>
</table>

<!-- Timoniere -->
{% if (o.appDTO.getHavehelmsman())  { %}
<table class='table table-condensed'>
<thead>
<tr>
<th colspan="4">{%=o.appDTO.dataBean.applicationid%} - Informazioni Timoniere</th>
</tr>
</thead>
<tbody>
<tr>      
   <td style='width: 25%'>Nome Cognome </td><td style='width: 35%'><b>{%=o.appDTO.getHelmsmanfirstname()%} {%=o.appDTO.getHelmsmanlastname()%}  </b></td>
   <td style='width: 15%'>Indirizzo </td><td style='width: 25%'><b>{%=o.appDTO.getHelmsmanaddress()%}</b></td>
</tr>
<tr>   
   <td style='width: 25%'>E-mail </td><td style='width: 35%'><b>{%=o.appDTO.getHelmsmanemail()%} </b></td>
   <td style='width: 15%'> C.a.p.</td><td style='width: 25%'><b>{%=o.appDTO.getHelmsmanzipcode()%} </b></td>
</tr>
<tr>   
   <td style='width: 25%'>Telefono </td><td style='width: 35%'><b>{%=o.appDTO.getHelmsmanphone()%} </b></td>
   <td style='width: 15%'>Citt&agrave; </td><td style='width: 25%'><b>{%=o.appDTO.getHelmsmantown()%} </b></td>
</tr>
<tr>   
   <td style='width: 25%'>Cellulare </td><td style='width: 35%'><b> {%=o.appDTO.getHelmsmancellphone()%}</b></td>
</tr>
</tbody>
</table>
{% } %}

<table class='table table-condensed'>
<thead>
<tr>
<th colspan="2">{%=o.appDTO.dataBean.applicationid%} - Iscrizione</th>
</tr>
</thead>
<tbody>
<tr>
<td style='width: 25%'>Raggruppamento</td>
<td>
        <div class="columns columns-condensed" >
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
</td> 
</tr>
<tr>
<td style='width: 25%'>Classifiche</td>
<td>
        <div class="columns columns-condensed" >
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
        <div id="appviewer_classinfoform_racegroupdecl_checkboxgroup">
        <div class="columns columns-condensed" >
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
</td>
</tr>
<tr id="appviewer_classinfoform_apptype_framedpanel">
<td style='width: 25%'>Desidero iscrivermi</td></td>
<td>
        <div class="columns columns-condensed" >
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
</td>
</tr>
</tbody>
</table>

<table class='table table-condensed' id='appviewer_classinfoform_grancrocieraorc_framedpanel'>
<thead>
<tr>
<th colspan="2">{%=o.appDTO.dataBean.applicationid%} - Dichiarazione Appartenenza alla categoria Gran Crociera</th>
</tr>
</thead>
<tbody>
<tr>
<td colspan='2'>
Sulla barca devono essere presenti quattro dei parametri sottoelencati, se si utilizzano vele a bassa tecnologia, altrimenti almeno cinque.
Con la presente dichiaro che l'imbarcazione presenta i parametri marcati e mantiene gli arredi la configuarazione originale di barca da 
diporto e non utilizza carbonio per scafo, appendici, antenne (albero e boma) e per le vele.            
</td>
</tr>
<tr>
<td style='width: 25%'>Parametri</td>
<td>
        <div class="columns columns-condensed" >
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
</td>
</tr>
</tbody>
</table>

<table class='table table-condensed'>
<thead>
<tr>
<th colspan="2">{%=o.appDTO.dataBean.applicationid%} - Esposizione pubblicit&agrave;</th>
</tr>
</thead>
<tbody>
<tr>
<td style='width: 25%'>Esposizione pubblicit&agrave;</td>
<td>
        <div class="columns columns-condensed" >
        
         {%
         var haveAdvertisingValue = o.appDTO.getPropertyValueAsBoolean('haveadvertising');
         var checked = (haveAdvertisingValue) ? 'checked' : '';
         var checkBoxIcon = (haveAdvertisingValue) ? 'checkbox_on.png' : 'checkbox_off.png';
          %}
         <label class='checkbox-inline' style='width: 100%'>
               <input name="advertising" id=" has_advertising" type="checkbox" value="id_has_advertising" {%=checked%}>La mia imbarcazione espone della pubblicità (quindi allego una copia della licenza FIV per l'anno in corso)</label>    
                         
          </div>
</td>
</tr>
</tbody>
</table>

<table class='table table-condensed' id='appviewer_boatinfoform_otherinfo_framedpanel'>
<thead>
<tr>
<th colspan="2">{%=o.appDTO.dataBean.applicationid%} - Altre Caratteristiche</th>
</tr>
</thead>
<tbody>
         {%
         var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_boatelse');    
         var theLUT = org.r3.PageManager.lutManager.getLUT(resolvedUrl);
         if (theLUT.aaData && theLUT.iTotalRecords)
         {     
             $.each(theLUT.aaData, function(index, item)
             {
          %}
            <tr>
            <td style='width: 25%'> {%=item.dtodescr%}</td><td><b>{%=o.appDTO.getPropertyValue(item.dtokey.toLowerCase(), '')%}</b></td>
            </tr>
          {% });
         } %}   

<tr>
<td style='width: 25%'>Materiale di costruzione delle vele</td>
<td>
     <div class="columns columns-condensed" >

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
     
</td>
</tr> 
  
<tr>
<td style='width: 25%'>Dettaglio Materiale</td>
<td><b>{%=o.appDTO.getPropertyValue('sailmaterialelse', '')%}</b></td>
</tr>
      
</tbody>
</table>

<table class='table table-condensed' >
<thead>
<tr>
<th colspan="2">{%=o.appDTO.dataBean.applicationid%} - Prospetto Riassuntivo delle Autorizzazioni</th>
</tr>
</thead>
<tbody>

      {%
       var resolvedUrl = org.r3.PageManager.getRESTUrl('GET_classifier_r3ea_authoriz');    
       var theLUT = org.r3.PageManager.lutManager.getLUT(resolvedUrl);
       if (theLUT.aaData && theLUT.iTotalRecords)
       {
             $.each(theLUT.aaData, function(index, item)
             {
      %} 

      <tr>
        <td style='width: 25%'>{%=item.dtodescr%}</td>
        <td>
        <div class="columns columns-condensed" >
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
          </td>
       </tr>
          {%     
              
             });
       } %}

</tbody>
</table>
       
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