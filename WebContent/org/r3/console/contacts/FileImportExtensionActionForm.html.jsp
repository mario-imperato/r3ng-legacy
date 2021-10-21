<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
    
<input type='hidden' name='fileimport_importcontext' value='actor' />
<input type='hidden' name='fileimport_majortype' value='csv' />
<input type='hidden' name='fileimport_importoptions' value='withheader' />

 <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >{%=org.r3.console.contacts.message.jsportletfileimportform_processingopts%}</label>
     <div class="col-md-10 columns" id="jsportletfileimportform_processingopts_cnt">
        <label class="checkbox-inline" style="width: 220px; ">
           <input type='checkbox' id="jsportletfileimportform_processingopts_mail_required" value="mail_required" name="processingopts" checked />{%=org.r3.console.contacts.message.jsportletfileimportform_processingopts_mail_required%}</label>

        <label class="checkbox-inline" style="width: 220px; ">
           <input id="jsportletfileimportform_processingopts_checkduplicates" type="checkbox" value="checkduplicates" name="processingopts" checked />{%=org.r3.console.contacts.message.jsportletfileimportform_processingopts_checkduplicates%}</label>               
     </div>
 </div>

 <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >{%=org.r3.console.contacts.message.jsportletfileimportform_actorgroup%}</label>
     <div class="col-md-10" >
        <select name="actorgroup" class='form-control' id="jsportletfileimportform_actorgroup" >    
        </select>
     </div>
 </div>

