<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>


<div id='crewoffer_edit_wrapper' >

<div class='content_fieldsetmessage'></div>
   
   <form id="crewoffer_form" method="POST" >
   <input type='hidden' id="crewoffer_geolat" name="geolat" /> 
   <input type='hidden' id="crewoffer_geolong" name="geolong" />
   <input type='hidden' id="crewoffer_geoacc" name="geoacc" />
   <input type='hidden' id="crewoffer_timeline" name="timeline" />   
   <input type='hidden' id="crewoffer_parentpostid" name="parentpostid" />
   <input type='hidden' id="crewoffer_postid"       name="postid" />
   <input type='hidden' id="crewoffer_contentcategory" name="contentcategory" value='shksailing' />    
   <input type='hidden' id="crewoffer_contentclass" name="contentclass" value='crewoffer' />    
   <input type="hidden" id="crewoffer_title"        name="title" />
   <input type="hidden" id="crewoffer_content"      name="content" />
   <input type="hidden" id="crewoffer_photo"       name="photo"  />
   <input type="hidden" name="author" id="crewoffer_author"   />
   <input type="hidden" name="authorname" id="crewoffer_authorname"   />
   <input type="hidden" name="authortype" id="crewoffer_authortype"   />
        
<div class='row'>
  <div class='col-md-4'>
  <img class="img-thumbnail" id='crewoffer_image' src="/r3ng/resources/sites/default/default_avatar_male.jpg" style='width: 100%' />
  
  </div>
 <div class='col-md-8'>
         
<div class="form-group">
     
     <div class="columns" >
		<label class='checkbox-inline'>
                <input id="crewoffer_crewrole_role_multiple" type="checkbox" value="role_multiple" name="crewrole" >Più Ruoli</label>
            <label class='checkbox-inline'>
                <input id="crewoffer_crewrole_role_prodiere" type="checkbox" value="role_prodiere" name="crewrole" >Prodiere</label>
            <label class='checkbox-inline'>
                <input id="crewoffer_crewrole_role_albero" type="checkbox" value="role_albero" name="crewrole" >Albero</label>
            <label class='checkbox-inline'>
                <input id="crewoffer_crewrole_role_drizze" type="checkbox" value="role_drizze" name="crewrole" >Drizze</label>
            <label class='checkbox-inline'>
                <input id="crewoffer_crewrole_role_tailer" type="checkbox" value="role_tailer" name="crewrole" >Tailer</label>
            <label class='checkbox-inline'>
                <input id="crewoffer_crewrole_role_randa" type="checkbox" value="role_randa" name="crewrole" >Randa</label>
            <label class='checkbox-inline'>
                <input id="crewoffer_crewrole_role_timone" type="checkbox" value="role_timone" name="crewrole" >Timone</label>
            <label class='checkbox-inline'>
                <input id="crewoffer_crewrole_role_tattico" type="checkbox" value="role_tattico" name="crewrole" >Tattico</label>
            <label class='checkbox-inline'>
                <input id="crewoffer_crewrole_role_navigatore" type="checkbox" value="role_navigatore" name="crewrole" >Navigatore</label>                  
     </div>
</div>

 <div class="form-group">
          <select name="crewlevel" class="form-control" id="crewoffer_crewlevel" >
              <option >-- Livello --</option>
              <option value="level_patent" >Patente</option>
              <option value="level_rookie" >Junior</option>
              <option value="level_expert" >Esperto</option>
              <option value="level_pro" >Professionale</option>                   
          </select>        
 </div>
        
 <div class="form-group">
        <input type="text" name="ownername" class="form-control" id="crewoffer_ownername" placeholder='Nominativo' maxlength="60"  />        
 </div>
                     
 <div class="form-group">
         <input type="text" name="owneremail" class="form-control" id="crewoffer_owneremail" placeholder='EMail' maxlength="60"  />        
 </div>
 
 <div class="form-group">
		<input type="text" name="ownerphone" class="form-control" id="crewoffer_ownerphone" placeholder='Telefono' maxlength="15"  />        
 </div>

  <div class="form-group">
		<input type="text" name="yachtname" class="form-control" id="crewoffer_yachtname" placeholder='Nome Barca' maxlength="30"  />        
 </div>
 
  <div class="form-group">
		<input type="text" name="yachtmodel" class="form-control" id="crewoffer_yachtmodel" placeholder='Modello' maxlength="30"  />        
 </div>
</div>
</div>

<div class='row'>
<div class='col-md-12'>
  <div class="form-group">
		<textarea name="yachtinfo" class="form-control" id="crewoffer_yachtinfo"  placeholder='Informazioni Addizionali' rows='5'></textarea>        
 </div>
 
    <div class="form-action-bar">
        <button type="button" data-action='image-selection:crewoffer' class="btn btn-default  btn-sm" >
          <i class='fa fa-camera'></i>
        </button>
        
        <button type="button" data-action='primarypost-submit:crewoffer' class="btn btn-default  btn-sm formaction" >
          <span>{%#org.r3.message.action_save%}</span>
        </button>        
    </div> 
    
</div>
</div>
    
    </form>
    </div>
               