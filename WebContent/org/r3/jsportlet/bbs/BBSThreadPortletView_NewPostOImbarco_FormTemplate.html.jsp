<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>


<input type="hidden" name="nodetitle" id="bbsthreadportletviewactionform_nodetitle" maxlength="80"  />
<input type="hidden" name="nodetext" id="bbsthreadportletviewactionform_nodetext" maxlength="80"  />
        
<div class="form-group">
     <label class="col-md-2 control-label "  >Ruolo</label>
     <div class="col-md-10 columns" >
		<label class='checkbox-inline'>
                <input id="bbsthreadportletviewactionform_crewrole_role_multiple" type="checkbox" value="role_multiple" name="crewrole" >Più Ruoli</label>
            <label class='checkbox-inline'>
                <input id="bbsthreadportletviewactionform_crewrole_role_prodiere" type="checkbox" value="role_prodiere" name="crewrole" >Prodiere</label>
            <label class='checkbox-inline'>
                <input id="bbsthreadportletviewactionform_crewrole_role_albero" type="checkbox" value="role_albero" name="crewrole" >Albero</label>
            <label class='checkbox-inline'>
                <input id="bbsthreadportletviewactionform_crewrole_role_drizze" type="checkbox" value="role_drizze" name="crewrole" >Drizze</label>
            <label class='checkbox-inline'>
                <input id="bbsthreadportletviewactionform_crewrole_role_tailer" type="checkbox" value="role_tailer" name="crewrole" >Tailer</label>
            <label class='checkbox-inline'>
                <input id="bbsthreadportletviewactionform_crewrole_role_randa" type="checkbox" value="role_randa" name="crewrole" >Randa</label>
            <label class='checkbox-inline'>
                <input id="bbsthreadportletviewactionform_crewrole_role_timone" type="checkbox" value="role_timone" name="crewrole" >Timone</label>
            <label class='checkbox-inline'>
                <input id="bbsthreadportletviewactionform_crewrole_role_tattico" type="checkbox" value="role_tattico" name="crewrole" >Tattico</label>
            <label class='checkbox-inline'>
                <input id="bbsthreadportletviewactionform_crewrole_role_navigatore" type="checkbox" value="role_navigatore" name="crewrole" >Navigatore</label>                  
     </div>
</div>

 <div class="form-group">
     <label class="col-md-2 control-label "  >Livello</label>
     <div class="col-md-10" >
          <select name="crewlevel" class="form-control" id="bbsthreadportletviewactionform_crewlevel" >
              <option ></option>
              <option value="level_patent" >Patente</option>
              <option value="level_rookie" >Junior</option>
              <option value="level_expert" >Esperto</option>
              <option value="level_pro" >Professionale</option>                   
          </select>        
     </div>
 </div>
        
 <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >Nominativo</label>
     <div class="col-md-10" >
        <input type="text" name="ownername" class="form-control" id="bbsthreadportletviewactionform_ownername" maxlength="60"  />        
     </div>
 </div>
                     
 <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >E-mail</label>
     <div class="col-md-10" >
         <input type="text" name="owneremail" class="form-control" id="bbsthreadportletviewactionform_owneremail" maxlength="60"  />        
     </div>
 </div>
 
 <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >Tel.</label>
     <div class="col-md-10" >
		<input type="text" name="ownerphone" class="form-control" id="bbsthreadportletviewactionform_ownerphone" maxlength="15"  />        
     </div>
 </div>

  <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >Barca</label>
     <div class="col-md-10" >
		<input type="text" name="yachtname" class="form-control" id="bbsthreadportletviewactionform_yachtname" maxlength="30"  />        
     </div>
 </div>
 
  <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >Modello</label>
     <div class="col-md-10" >
		<input type="text" name="yachtmodel" class="form-control" id="bbsthreadportletviewactionform_yachtmodel" maxlength="30"  />        
     </div>
 </div>

  <div class="form-group">
     <label class="col-md-2 control-label "  >Informazioni Addizionali</label>
     <div class="col-md-10" >
		<textarea name="yachtinfo" class="form-control" id="bbsthreadportletviewactionform_yachtinfo"  rows='5'></textarea>        
     </div>
 </div>
 
           