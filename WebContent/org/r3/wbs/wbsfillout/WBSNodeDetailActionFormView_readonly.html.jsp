<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
  
<div id='wbsnode_infoLine_page' style='margin-top: 10px'></div>

<div class="panel panel-default">
  <div class="panel-heading" style='background: white'>  
    <h3 class="panel-title" id="wbsnodeactionform_nodename">{%#org.r3.wbs.wbsfillout.message.wbsnodeactionform_nodename%}</h3>
  </div>
  <div class="panel-body">
  
    <div id="wbsnodeactionform_fieldset_message" ></div>
  
    <label class="fieldReadOnly" style='color: #777777' id="wbsnodeactionform_nodesummary"></label>
    <label id="wbsnodeactionform_nodetext"></label>
      
  </div>
</div>

