<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

 <form id="businesscardinfoactionform_form" method="POST" >
 <div class="form-group">
    <label >Personal Statement</label>
    <textarea  class="form-control" name="personalstatement" id="businesscardinfoactionform_personalstatement" placeholder="Personal Statement" ></textarea>
 </div>
  
 <div class="form-group">
    <label >Email</label>
    <input type="email" class="form-control" name="email" id="businesscardinfoactionform_email" placeholder="Email" maxlength='50' >
 </div>

 <div class="form-group">
    <label >Cellulare</label>
    <input class="form-control" type="text" name="cellphone" id="businesscardinfoactionform_cellphone" maxlength="15" placeholder="Cellulare" />
 </div>
 </form>
 
 <div class="form-action-bar">
     <button type="button" id="businesscardinfoactionform_action_saveitem" class="btn btn-default" >
       <span>{%=org.r3.message.action_save%}</span>
     </button>                                        
 </div>
 