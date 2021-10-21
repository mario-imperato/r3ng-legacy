<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env">

  
  <div id="uploadFileActionForm" class="actionForm"></div>
  <div id="rankingQueryActionForm"           class="actionForm"></div>
  
  <div id="ranking-detail-canvas" style='display: none'>
  <ul class="list-group">
  <li class="list-group-item">
  <div id="rankingDetailActionForm"          class="actionForm"></div>
  </li>
  <li class="list-group-item">
  <div id="rankingInstancesQueryActionForm"  class="actionForm"></div>
  </li>
  </ul>
  </div>
  
  <div id="rankingInstanceDetailActionForm"  class="actionForm"></div>
  <div id="rankingSynopticActionForm"  class="actionForm"></div>
  <div id='rankingInstanceViewerActionForm'  class="actionForm" style='display: none'></div>  
  <div id='rankingInstanceViewerActionForm_Entries'  class="actionForm" style='display: none'></div>
  
  <div id="classifierActionForm" ></div>
  
 <div id="classifierItemActionForm"  style='display: none'>
  <ul class="list-group">
    <li class="list-group-item">
  		<div id="classifierItemDetailActionForm"  ></div>
    </li>
    <li class="list-group-item">
  		<div id="classifierItemListActionForm"    ></div>
    </li>
  </ul>
  </div>


</r3_lang:environment>        