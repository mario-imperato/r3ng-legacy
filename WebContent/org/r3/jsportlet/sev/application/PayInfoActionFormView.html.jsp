<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

  
<form id="payinfoform_form" method="POST">
<ul class="list-group">
  <li class="list-group-item">
  <h4 style='margin-bottom: 15px'><span id="payinfoform_applicationid">&nbsp;</span> - Modalit&agrave; di pagamento</h4>
  
  <div id="payinfoform_fieldset_message" ></div>    
  <div id="payinfoform_card"></div>
  
  </li>
</ul>

 <div class="form-action-bar">
        
         <button type="button" id="payinfoform_action_prev" class="btn btn-default">
          <span>Precedente</span>
        </button>

        <button type="button" id="payinfoform_action_next" class="btn btn-default">
          <span>Successivo</span>
        </button>
        
   </div>     
</form>

  