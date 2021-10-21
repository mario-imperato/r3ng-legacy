<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>


<div id='shcoffer_edit_wrapper' >

<div class='content_fieldsetmessage'></div>
   
   <form id="shcoffer_form" method="POST" >
   <input type='hidden' id="shcoffer_geolat" name="geolat" /> 
   <input type='hidden' id="shcoffer_geolong" name="geolong" />
   <input type='hidden' id="shcoffer_geoacc" name="geoacc" />
   <input type='hidden' id="shcoffer_timeline" name="timeline" />   
   <input type='hidden' id="shcoffer_parentpostid" name="parentpostid" />
   <input type='hidden' id="shcoffer_postid"       name="postid" />
   <input type='hidden' id="shcoffer_contentcategory" name="contentcategory" value='shkmerchant' />    
   <input type='hidden' id="shcoffer_contentclass" name="contentclass" value='shcoffer' />    
   <input type="hidden" id="shcoffer_title"        name="title" />
   <input type="hidden" id="shcoffer_content"      name="content" />
    <input type="hidden" id="shcoffer_photo"       name="photo"  />
	<input type="hidden" name="author" id="shcoffer_author"   />
	<input type="hidden" name="authorname" id="shcoffer_authorname"   />
	<input type="hidden" name="authortype" id="shcoffer_authortype"   />
		        
<div class='row'>

   <div class="col-md-12"   style='margin-bottom: 10px;'>
     <div id='shcoffer_postimage'></div>     
   </div>
     
   <div class='col-md-12'>
                 
 <div class="form-group">
    <input type="text" name="what" class="form-control" id="shcoffer_what" placeholder='Oggetto' maxlength="60"  />        
 </div>
                     
 <div class="form-group">
	<textarea name="description" class="form-control" id="shcoffer_description"  placeholder='Descrizione' rows='5'></textarea>        
 </div>
 
 <div class="form-group">
	<input type="text" name="unitprice" class="form-control" id="shcoffer_unitprice" placeholder='Prezzo Unitario' maxlength="15"  />        
 </div>

  <div class="form-group">
	<input type="text" name="availability" class="form-control" id="shcoffer_availability" placeholder='Disponibilità' maxlength="30"  />        
 </div>
 
</div>
</div>

<div class='row'>
<div class='col-md-12'>

 
    <div class="form-action-bar">
        <button type="button" data-action='image-selection:shcoffer' class="btn btn-default  btn-sm" >
          <i class='fa fa-camera'></i>
        </button>
        
        <button type="button" data-action='primarypost-submit:shcoffer' class="btn btn-default  btn-sm formaction" >
          <span>{%#org.r3.message.action_save%}</span>
        </button>        
    </div> 
    
</div>
</div>
    
    </form>
    </div>
               