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

<div class="title"><span ><%=targetSite.getSitedescr()%></span><br /><span style="font-size: 0.8em">Rapporto Flotta</span></div>
</div>

<div id='#crewreportviewer_summary'>
<h3 class='section'>Rapporto Sintesi Flotta</h3>

   <table class="table table-bordered" >
   <thead>
   <tr>
      <th  style="vertical-align: middle; text-align: center; width: 5%">
      
      </th>            
      <th  style="vertical-align: middle; text-align: left; width: 10%">
      Stato
      </th>      
      <th  style="vertical-align: middle; text-align: left;  width: 15%">
      Iscrizione
      </th>
      <th  style="vertical-align: middle; text-align: left;  width: 15%">
      No. Velico
      </th>
      <th  style="vertical-align: middle; text-align: left;  width: 25%">
      Imbarcazione
      </th>
      <th  style="vertical-align: middle; text-align: center; width: 5%">
      A bordo
      </th>
      <th  style="vertical-align: middle; text-align: center; width: 5%">
      Riserve
      </th>      
      <th  style="vertical-align: middle; text-align: center; width: 5%">
      Validi
      </th>
      <th  style="vertical-align: middle; text-align: center; width: 5%">
      Scaduti
      </th>
      <th  style="vertical-align: middle; text-align: center; width: 5%">
      Errati
      </th>
      <th  style="vertical-align: middle; text-align: center; width: 5%">
      Non verificati
      </th>
      <th  style="vertical-align: middle; text-align: center; width: 5%">
      Cancellati
      </th>
   </tr>
   </thead>
   <tbody>
   
{% for (var i = 0; i < o.crewReport.getNumberOfItems(); i++)
   {
      var theItem = o.crewReport.getItem(i); %}

   <tr class='{%=theItem.getCrewStatusAsTableContextualClass()%}'>

      <td  style="vertical-align: middle; text-align: center; width: 5%">
      {%#theItem.getCrewStatusAsSemaphore()%}
      </td>            
      <td  style="vertical-align: middle; text-align: left; width: 10%">
      {%#theItem.getCrewStatus()%}      
      </td>      
      <td  style="vertical-align: middle; text-align: left; width: 15%">
       {%=theItem.dataBean.applicationid%}
      </td>
      <td  style="vertical-align: middle; text-align: left; width: 15%">
       {%=theItem.dataBean.sailnumber%}
      </td>
      <td  style="vertical-align: middle; text-align: left; width: 25%">
       {%=theItem.dataBean.yachtname%}
      </td>
      <td  style="vertical-align: middle; text-align: center; width: 5%">
      {%=theItem.getCrewSize()%}
      </td>
      <td  style="vertical-align: middle; text-align: center; width: 5%">
      {%=theItem.getReserveCrewSize()%}
      </td>      
      <td  style="vertical-align: middle; text-align: center; width: 5%">
      {%=theItem.getCrewValid()%}
      </td>
      <td  style="vertical-align: middle; text-align: center; width: 5%">
      {%=theItem.getCrewExpired()%}
      </td>
      <td  style="vertical-align: middle; text-align: center; width: 5%">
       {%=theItem.getCrewError()%}
      </td>
      <td  style="vertical-align: middle; text-align: center; width: 5%">
       {%=theItem.getCrewUnknown()%}
      </td>
      <td  style="vertical-align: middle; text-align: center; width: 5%">
       {%=theItem.getCrewDeleted()%}
      </td>

   </tr>
            
{% } %}
   
   </tbody>
   </table>
</div>

<div id='#crewreportviewer_detail'>
      
{% for (var i = 0; i < o.crewReport.getNumberOfItems(); i++) 
   {             
     var theItem = o.crewReport.getItem(i); 
     var listOfCrewMembers = theItem.dataBean.listOfCrewMembers;
     %}
    
   <div class="page-break-before crewreportviewer_boatdetail crewreportviewer_boatdetail_{%=theItem._getCrewStatus()%}">
   <h3 class='text-{%=theItem.getCrewStatusAsTableContextualClass()%}'>Codice Iscrizione: {%=theItem.dataBean.applicationid%} - {%=theItem.dataBean.sailnumber%} - {%=theItem.dataBean.yachtname%}</h3>
   
   {% if (listOfCrewMembers && theItem.getCrewSize() > 0) { %}
   <table class="table table-bordered" >
   <thead>
   <tr>
      
      <th  style="vertical-align: middle; width: 5%">
      &nbsp;
      </th>
      <th  style="vertical-align: middle; width: 5%">
      Stato
      </th>
      <th  style="vertical-align: middle; width: 10%">
      No. Tessera FIV
      </th>
      <th  style="vertical-align: middle; width: 15%">
      Nominativo
      </th>
      <th  style="vertical-align: middle; width: 15%">
      Circolo di appartenenza
      </th>
      <th  style="vertical-align: middle; width: 10%">
      Data rinnovo
      </th>
      <th  style="vertical-align: middle; width: 10%">
      Scad. Cert. Med.
      </th>
      <th style="vertical-align: middle; width: 10%">
      Ruolo                      
      </th>
      <th style="vertical-align: middle; width: 5%">
      Peso                      
      </th>
      <th style="vertical-align: middle; width: 5%">
      Tit/Ris                      
      </th>      
      <th style="vertical-align: middle; width: 10%">
      Data Verifica                      
      </th>

   </tr>
   </thead>
   <tbody>

   {% 
   for (var j = 0; j < listOfCrewMembers.getNumberOfItems(); j++) 
   {             
     var theMemberItem = listOfCrewMembers.getItem(j); 
     if (theMemberItem.isActive()) {     
     %}
   <tr>
      
      <td  style="vertical-align: middle; text-align: center; width: 5%">
      {%#theMemberItem.getCardnumberstatuscodeAsSemaphore()%}      
      </td>
      <td  style="vertical-align: middle; width: 5%">
       {%#theMemberItem.getCardnumberstatuscode()%}     
      </td>
      <td  style="vertical-align: middle; width: 10%">
      {%=theMemberItem.dataBean.cardnumber%}
      </td>
      <td  style="vertical-align: middle; width: 15%">
      {%#theMemberItem.getMemberInfo()%}
      </td>
      <td  style="vertical-align: middle; width: 20%">
      {%=theMemberItem.dataBean.yachtclub%}      
      </td>
      <td  style="vertical-align: middle; width: 10%">
      {%=theMemberItem.getRenewaldate()%}
      </td>
      <td  style="vertical-align: middle; width: 10%">
      {%=theMemberItem.getMedexamexpirationdate()%}      
      </td>
      <td style="vertical-align: middle; width: 10%">
      {%=theMemberItem.getCrewmemberrolecode()%}                                
      </td>
      <td style="vertical-align: middle; width: 5%">
      {%=theMemberItem.dataBean.weight%}                      
      </td>
      <td style="vertical-align: middle; width: 5%">
      {%=theMemberItem.getMemberstatuscode()%}                      
      </td>      
      <td style="vertical-align: middle; width: 10%">
      {%=theMemberItem.getCheckcardnumber_ts()%}                                
      </td>

   </tr>
   {% }
   } %}  
      
   </tbody>
   </table>
   {% } %}     
     
   </div>
{% } %}     

</div>
</div>

</r3_lang:environment>
     