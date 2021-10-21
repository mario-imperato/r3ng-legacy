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
         <label class="col-sm-2 control-label fieldRequired">{%=org.r3.console.contacts.message.jsportletfileuploadform_fileimport_minortype%}</label>
         <div class='col-sm-10'>
            <select name="fileimport_minortype" id="jsportletfileuploadform_fileimport_minortype" class="form-control" >
             <option value='comma'>{%=org.r3.console.contacts.message.jsportletfileuploadform_fileimport_minortype_comma%}</option>
             <option value='semicolon'>{%=org.r3.console.contacts.message.jsportletfileuploadform_fileimport_minortype_semicolon%}</option>
             <option value='tab'>{%=org.r3.console.contacts.message.jsportletfileuploadform_fileimport_minortype_tab%}</option>                  
            </select>
         </div>
      </div>   

