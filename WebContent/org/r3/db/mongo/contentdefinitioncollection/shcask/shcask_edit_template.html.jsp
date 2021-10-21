<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<div id='shcask_edit_wrapper' >

<div class='content_fieldsetmessage'></div>
  
<form id="shcask_form" method="POST" >
<input type='hidden' id="shcask_geolat" name="geolat" /> 
<input type='hidden' id="shcask_geolong" name="geolong" />
<input type='hidden' id="shcask_geoacc" name="geoacc" />
<input type='hidden' id="shcask_timeline" name="timeline" />
<input type='hidden' id="shcask_parentpostid" name="parentpostid" />
<input type='hidden' id="shcask_postid" name="postid" />
<input type='hidden' id="shcask_contentcategory" name="contentcategory" value='shkmerchant' /> 
<input type='hidden' id="shcask_contentclass" name="contentclass" value='shcask' />    
<input type="hidden" name="title" id="shcask_title"   />
<input type="hidden" name="content" id="shcask_content"   />
<input type="hidden" name="photo" id="shcask_photo"   />
<input type="hidden" name="author" id="shcask_author"   />
<input type="hidden" name="authorname" id="shcask_authorname"   />
<input type="hidden" name="authortype" id="shcask_authortype"   />
   
<div class='row'>

   <div class="col-md-12"   style='margin-bottom: 10px;'>
     <div id='shcask_image'></div>     
   </div>
     
   <div class='col-md-12'>
                 
 <div class="form-group">
    <input type="text" name="what" class="form-control" id="shcask_what" placeholder='Oggetto' maxlength="60"  />        
 </div>
                     
 <div class="form-group">
	<textarea name="description" class="form-control" id="shcask_description"  placeholder='Descrizione' rows='5'></textarea>        
 </div>
 
 <div class="form-group">
	<input type="text" name="unitprice" class="form-control" id="shcask_unitprice" placeholder='Prezzo Unitario' maxlength="15"  />        
 </div>
 
</div>
</div>


<div class='row'>
<div class='col-md-12'>
    <div class="form-action-bar">
        <button type="button" data-action='image-selection:shcask' class="btn btn-default  btn-sm" >
          <i class='fa fa-camera'></i>
        </button>
        
        <button type="button" data-action='primarypost-submit:shcask' class="btn btn-default btn-sm" >
          <span>{%#org.r3.message.action_save%}</span>
        </button>
        
    </div> 
</div>
</div>
</form>
</div>
    