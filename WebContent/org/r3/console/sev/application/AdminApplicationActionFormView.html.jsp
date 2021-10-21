<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.io.*,
    java.util.*
    "%>

<div id="infoLine_page"></div>

<div id="adminApplicationActionFormTabs" >

 <ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#adminApplicationActionForm_tab_admininfo" role="tab" data-toggle="tab">Verifiche Amministrative</a></li>   
    <li role="presentation"><a href="#adminApplicationActionForm_tab_techinfo" role="tab" data-toggle="tab">Informazioni Tecniche</a></li>
    <li role="presentation"><a href="#adminApplicationActionForm_tab_crewinfo" role="tab" data-toggle="tab">Verifiche Equipaggio</a></li>
   
  </ul>

  <div class="tab-content" >
  <div id="adminApplicationActionForm_tab_admininfo"     class='tab-pane active tab-pane-framed' ></div>
  <div id="adminApplicationActionForm_tab_techinfo" class='tab-pane tab-pane-framed' ></div>
  <div id="adminApplicationActionForm_tab_crewinfo" class='tab-pane tab-pane-framed' >
  <div id="sailApplicationCrewMemberViewQueryActionFormView" ></div>    
  </div>
  </div>
</div>
  
 