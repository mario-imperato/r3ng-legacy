<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<input type="hidden" name="nodetitle" id="bbsthreadportletviewactionform_nodetitle"   />
<input type="hidden" name="nodetext" id="bbsthreadportletviewactionform_nodetext"   />
        
 <div class="form-group">
   <label class="col-md-2 control-label "  >Ruolo</label>
   <div class="col-md-10" >
       <select name="crewrole" class="form-control" id="bbsthreadportletviewactionform_crewrole" >
           <option ></option>
           <option value="role_multiple" >Più Ruoli</option>
           <option value="role_prodiere" >Prodiere</option>
           <option value="role_albero"   >Albero</option>
           <option value="role_drizze"   >Drizze</option>
           <option value="role_tailer"   >Tailer</option>   
           <option value="role_randa"   >Randa</option>
           <option value="role_timone"   >Timone</option> 
           <option value="role_tattico"   >Tattico</option>   
           <option value="role_navigatore"   >Navigatore</option>
       </select>        
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
        <input type="text" name="crewname" class="form-control" id="bbsthreadportletviewactionform_crewname" maxlength="60"  />
     </div>
 </div>

 <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >E-mail</label>
     <div class="col-md-10" >
        <input type="text" name="crewemail" class="form-control" id="bbsthreadportletviewactionform_crewemail" maxlength="60"  />        
     </div>
 </div>

  <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >Tel.</label>
     <div class="col-md-10" >
        <input type="text" name="crewphone" class="form-control" id="bbsthreadportletviewactionform_crewphone" maxlength="15"  />        
     </div>
 </div>
        
 <div class="form-group">
     <label class="col-md-2 control-label "  >Peso (kg)</label>
     <div class="col-md-10" >
        <input type="text" name="crewweight" class="form-control" id="bbsthreadportletviewactionform_crewweight" maxlength="10"  />        
     </div>
 </div>
        
 <div class="form-group">
     <label class="col-md-2 control-label "  >Altezza (cm)</label>
     <div class="col-md-10" >
        <input type="text" name="crewheight" class="form-control" id="bbsthreadportletviewactionform_crewheight" maxlength="10"  />        
     </div>
 </div>

 <div class="form-group">
     <label class="col-md-2 control-label "  >Eta'</label>
     <div class="col-md-10" >
         <input type="text" name="crewage" class="form-control" id="bbsthreadportletviewactionform_crewage" maxlength="10"  />        
     </div>
 </div>

 <div class="form-group">
     <label class="col-md-2 control-label "  >Informazioni Addizionali</label>
     <div class="col-md-10" >
          <textarea name="crewinfo" class="form-control" id="bbsthreadportletviewactionform_crewinfo"  rows='5'></textarea>        
     </div>
 </div>
        

