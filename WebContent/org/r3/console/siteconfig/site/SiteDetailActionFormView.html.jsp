<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<div id="siteDetailActionFormTabs" >

<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#siteDetailActionForm_tab_generale" role="tab" data-toggle="tab">{%=org.r3.console.siteconfig.site.message.siteDetailActionForm_tab_generale%}</a></li>        
    <li role="presentation" ><a href="#siteDetailActionForm_tab_cardfile" role="tab" data-toggle="tab">{%=org.r3.console.siteconfig.site.message.siteDetailActionForm_tab_cardfile%}</a></li>
{% if (org.r3.SiteConstants.is10Gen()) { %}
    <li role="presentation" ><a href="#siteDetailActionForm_tab_sitegraphics" role="tab" data-toggle="tab">{%=org.r3.console.siteconfig.site.message.siteDetailActionForm_tab_sitegraphics%}</a></li>    
{% } %}
</ul>

<div class="tab-content" >  
  <div id="siteDetailActionForm_tab_generale"  class='tab-pane active tab-pane-framed'></div>    
  <div id="siteDetailActionForm_tab_cardfile"  class='tab-pane tab-pane-framed' ></div>
{% if (org.r3.SiteConstants.is10Gen()) { %}
  <div id="siteDetailActionForm_tab_sitegraphics"  class='tab-pane tab-pane-framed' ></div>  
{% } %}
</div>

</div>
