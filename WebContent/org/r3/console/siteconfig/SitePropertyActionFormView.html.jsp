<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<div id="sitePropertiesActionFormTabs" >

<!-- Nav tabs -->
 <ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#sitePropertiesActionForm_tab_pkg_google" role="tab" data-toggle="tab">{%=org.r3.console.siteconfig.message.sitePropertiesActionForm_tab_pkg_google%}</a></li>
   
    <li role="presentation"><a href="#sitePropertiesActionForm_tab_pkg_sms" role="tab" data-toggle="tab">{%=org.r3.console.siteconfig.message.sitePropertiesActionForm_tab_pkg_sms%}</a></li>
    <li role="presentation"><a href="#sitePropertiesActionForm_tab_pkg_mail" role="tab" data-toggle="tab">{%=org.r3.console.siteconfig.message.sitePropertiesActionForm_tab_pkg_mail%}</a></li>
   
  </ul>

  <div class="tab-content" >
  <div id="sitePropertiesActionForm_tab_pkg_google"     class='tab-pane active tab-pane-framed' ></div>
  <div id="sitePropertiesActionForm_tab_pkg_sms" class='tab-pane tab-pane-framed' ></div>
  <div id="sitePropertiesActionForm_tab_pkg_mail" class='tab-pane tab-pane-framed' ></div>

  </div>
  
</div>
