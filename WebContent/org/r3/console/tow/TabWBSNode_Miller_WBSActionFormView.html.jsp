<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.io.*,
    java.util.*
    "%>

<div class="panel tabbed-panel">
  <div class="panel-heading" >  
    <h3 class="panel-title" >{%=org.r3.jsportlet.wbs.message.wbsnodemanager_legend_title%}</h3>
  </div>
  
  <div class="panel-body">
  <div id="wbsnodeform_fieldset_message"></div>
  <div id='wbs_miller' class='row' ></div>
  </div>
</div>



