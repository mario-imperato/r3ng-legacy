<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<div id='crewask_edit_wrapper' >
  
<form id="crewask_form" method="POST" >
<input type='hidden' id="crewask_geolat" name="geolat" /> 
<input type='hidden' id="crewask_geolong" name="geolong" />
<input type='hidden' id="crewask_geoacc" name="geoacc" />
<input type='hidden' id="crewask_timeline" name="timeline" />
<input type='hidden' id="crewask_parentpostid" name="parentpostid" />
<input type='hidden' id="crewask_postid" name="postid" />
<input type='hidden' id="crewask_contentclass" name="contentclass" value='crewask' />    
<input type='hidden' id="crewask_contentcategory" name="contentcategory" value='shksailing' />    
<input type="hidden" name="title" id="crewask_title"   />
<input type="hidden" name="content" id="crewask_content"   />
<input type="hidden" name="photo" id="crewask_photo"   />
<input type="hidden" name="author" id="crewask_author"   />
<input type="hidden" name="authorname" id="crewask_authorname"   />
<input type="hidden" name="authortype" id="crewask_authortype"   />

 <!-- <div id='crewask_jsportlettimelineform_postcontent'>  -->
 <div class='row'>
  <div class='col-md-4 col-sm-4'>
  <img class="img-thumbnail" id='crewask_image' src="/r3ng/resources/sites/default/default_avatar_male.jpg" style='width: 100%' />
  
  </div>
 <div class='col-md-8 col-sm-8'>
 <div class='content_fieldsetmessage'></div>
 <div class="form-group">
       <select name="crewrole" class="form-control" id="crewask_crewrole" >
           <option >-- Ruolo --</option>
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

<div class="form-group">
         <select name="crewlevel" class="form-control" id="crewask_crewlevel" >
             <option >-- Livello --</option>
             <option value="level_patent" >Patente</option>
             <option value="level_rookie" >Junior</option>
             <option value="level_expert" >Esperto</option>
             <option value="level_pro" >Professionale</option>                   
         </select>
 </div>

 <div class="form-group">
        <input type="text" name="crewname" class="form-control" id="crewask_crewname" placeholder='Nominativo' maxlength="60"  />
 </div>

 <div class="form-group">
        <input type="text" name="crewemail" class="form-control" id="crewask_crewemail" placeholder='EMail' maxlength="60"  />        
 </div>

  <div class="form-group">
        <input type="text" name="crewphone" class="form-control" id="crewask_crewphone" placeholder='Telefono' maxlength="15"  />        
 </div>
        
 <div class="form-group">
   <input type="text" name="crewweight" class="form-control" id="crewask_crewweight" placeholder='Peso (Kg)' maxlength="10"  />   
 </div>
        
 <div class="form-group">
    <input type="text" name="crewheight" class="form-control" id="crewask_crewheight" placeholder='Altezza (cm)' maxlength="10"  />        
 </div>

 <div class="form-group">
         <input type="text" name="crewage" class="form-control" id="crewask_crewage" placeholder="Eta'" maxlength="10"  />        
 </div>
 </div>       
</div>
 <div class="form-group">
          <textarea name="crewinfo" class="form-control" id="crewask_crewinfo"  placeholder='Informazioni Addizionali' rows='5'></textarea>        
 </div>


<div class='row'>
<div class='col-md-12'>
    <div class="form-action-bar">
        <button type="button" data-action='image-selection:crewask' class="btn btn-default  btn-sm" >
          <i class='fa fa-camera'></i>
        </button>
        
        <button type="button" data-action='primarypost-submit:crewask' class="btn btn-default btn-sm" >
          <span>{%#org.r3.message.action_save%}</span>
        </button>
        
    </div> 
</div>
</div>
</form>
</div>
    