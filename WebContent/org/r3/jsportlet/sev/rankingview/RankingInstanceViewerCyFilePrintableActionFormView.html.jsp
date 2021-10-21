<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.io.*,
    java.util.*,
    org.r3.db.system.site.SiteDTO
    " %>

<r3_lang:environment id="r3Env">

<%
  SiteDTO targetSite = r3Env.getRequestSite();
 %>

<!-- 
<div class="action_bar cf unprintable" style="border-top: 0px; margin-bottom: 20px;">
    <button type="button" id="appviewer_action_print" class="btn" style="margin-top: 5px">
      <span>Stampa</span>
    </button>

    <button type="button" id="appviewer_action_back" class="btn" style="margin-top: 5px">
      <span>Indietro</span>
    </button>        
</div>
-->

<div class="appviewer">

<div class="appviewer_header cf">
<div class="eventLogo">
   <img src='/r3ng/resources/sites/<%=targetSite.getSiteresourcepath()%>/regattaeventLogo.png' border='0' />
</div>

{% 
   var rankTitle = 'Classifica';
   if (o.aRankInstanceDTOAdapter.isOverallInstance()) {
       rankTitle = 'Classifica Generale';
   }
   
   rankTitle += ': ' + o.aRankInstanceDTOAdapter.dataBean.ranktitle;
   
   if (o.aRankInstanceDTOAdapter.getRaceclass())
      rankTitle += ' - ' + o.aRankInstanceDTOAdapter.getRaceclass();
%}   

<div class="eventTitle">
 <span ><%=targetSite.getSitedescr()%></span><br />
 <span style="font-size: 0.8em">{%=rankTitle%}</span></div>
</div>

{%  if (!o.aRankInstanceDTOAdapter.isOverallInstance()) { %}

<div class="framed_panel" >    

    <div class="panel_legend">
       <div class="legend_title"><label class="fieldReadOnly" >{%=o.aRankInstanceDTOAdapter.dataBean.instanceid%}</label> - Informazioni Regata</div>
    </div>  
    
    <div class="panel_content cf">       
     <table class="framed-table">
     <tr>
        <td style="width: 20%" class="framed-cell">
        <div class="framed-cell-label">N.Prova</div>
        <div class="framed-cell-value">{%=o.aRankInstanceDTOAdapter.dataBean.racenumber%}</div>
        </td>
        <td  style="width: 20%" class="framed-cell">
        <div class="framed-cell-label">Data</div>
        <div class="framed-cell-value">{%=o.aRankInstanceDTOAdapter.getRacedate()%}</div>      
        </td>
        <td  style="width: 20%" class="framed-cell">
        <div class="framed-cell-label">Ora</div>
        <div class="framed-cell-value">{%=o.aRankInstanceDTOAdapter.getRacetime()%}</div>      
        </td>
        <td  style="width: 20%" class="framed-cell">
        <div class="framed-cell-label">Distanza</div>
        <div class="framed-cell-value">{%=o.aRankInstanceDTOAdapter.dataBean.racedistance%}</div>      
        </td>
        <td  style="width: 20%" class="framed-cell">
        <div class="framed-cell-label">&nbsp;</div>
        <div class="framed-cell-value">{%=o.aRankInstanceDTOAdapter.dataBean.racerating%}</div>      
        </td>
     </tr>   
     </table>       
   </div>    
       
</div>
  
{%  } %}

<div id="rankinginstancevieweractionform_htmlcanvas" style="color: #000000; margin-top: 20px; margin-bottom: 20px"></div>

</div>
</r3_lang:environment>
