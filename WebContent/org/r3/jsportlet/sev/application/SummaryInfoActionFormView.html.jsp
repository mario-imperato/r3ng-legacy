<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<form id="summaryinfoform_form" method="POST">
<ul class="list-group">
  <li class="list-group-item">
  <h4 style='margin-bottom: 15px'><span id="summaryinfoform_applicationid">&nbsp;</span> - Conferma della domanda</h4>
  
    <div id="summaryinfoform_fieldset_message" ></div>
    <div id="summaryinfoform_card"></div>
  
  </li>
</ul>

 <div class="form-action-bar">
        
         <button type="button" id="summaryinfoform_action_prev" class="btn btn-default">
          <span>Precedente</span>
        </button>

        <button type="button" id="summaryinfoform_action_commit" class="btn btn-default">
          <span>Conferma</span>
        </button>
 
        <button type="button" id="summaryinfoform_action_view" class="btn btn-default">
          <span>Visualizza</span>
        </button>
 
        <button type="button" id="summaryinfoform_action_end" class="btn btn-default">
          <span>Termina</span>
        </button>
        
   </div>     
</form>

   