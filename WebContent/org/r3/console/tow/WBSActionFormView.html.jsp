<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<%
   String mode = request.getParameter("mode");
   boolean isDetail = mode.equalsIgnoreCase("detail");
   boolean isCreate = !isDetail;
%>

<div id="wbsActionFormTabs" >

<!-- Nav tabs -->
 <ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#wbsActionForm_tab_generale" role="tab" data-toggle="tab">{%=org.r3.jsportlet.wbs.message.wbsActionForm_tab_generale%}</a></li>
    
    <r3_lang:ifinclude include="<%=isDetail%>" >
    <li role="presentation"><a href="#wbsActionForm_tab_nodes" role="tab" data-toggle="tab">{%=org.r3.jsportlet.wbs.message.wbsActionForm_tab_nodes%}</a></li>
    </r3_lang:ifinclude>
  </ul>

<div class="tab-content" >
  <div id="wbsActionForm_tab_generale" class='tab-pane active tab-pane-framed'></div>
  <r3_lang:ifinclude include="<%=isDetail%>" >
  <div id="wbsActionForm_tab_nodes" class='tab-pane tab-pane-framed'>
     <div id="wbsActionForm_tab_nodes_miller"></div>
     <div id="wbsActionForm_tab_nodes_detail" style='display: none'></div>  
     
     <a id='wbs_outline_anchor' />
	 <div class='wbs wbs_collapsed'>
	 <div id='wbs_outline_panel' class="panel" style='margin-top: 20px;'>    
	    
	    <div class="panel-heading" >  
        <h3 class="panel-title" >{%=org.r3.jsportlet.wbs.message.wbs_outline_panel_caption%}</h3>
        </div>	  
	 	    
	    <div class="panel-body" > 
	    
	    <div class="action-bar position-top" id="wbsoutline_actonbar">
         <button type="button" class="btn btn-primary start" id="action_updatewbsnumbering"  disabled  >         
         <span>Aggiorna Numerazione</span>
         </button>
        </div>
            
	    <div class='wbs_outline'     style="padding: 5px 5px 10px 10px"></div>
	    <div id='wbs_teamprofile' style="padding: 5px 5px 10px 10px"></div>
	    		    
	    </div>
	 </div>    
	 </div>
     
  </div>
  </r3_lang:ifinclude>
</div>
</div>

 
