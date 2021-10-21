<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<div id='shkmessage_edit_wrapper' >

<div class='content_fieldsetmessage'></div>
  
<form id="shkmessage_form" method="POST" class="form-horizontal">
<input type='hidden' id="shkmessage_geolat" name="geolat" /> 
<input type='hidden' id="shkmessage_geolong" name="geolong" />
<input type='hidden' id="shkmessage_geoacc" name="geoacc" />
<input type='hidden' id="shkmessage_timeline" name="timeline" /> 
<input type='hidden' id="shkmessage_parentpostid" name="parentpostid" />
<input type='hidden' id="shkmessage_postid" name="postid" />
<input type='hidden' id="shkmessage_contentcategory" name="contentcategory" value='shkgeneral' />	
<input type='hidden' id="shkmessage_contentclass" name="contentclass" value='shkmessage' />    
<input type="hidden" name="title" id="shkmessage_title"   />
<input type="hidden" name="content" id="shkmessage_content"   />
<input type="hidden" name="photo" id="shkmessage_photo"   />
<input type="hidden" name="author" id="shkmessage_author"   />
<input type="hidden" name="authorname" id="shkmessage_authorname"   />
<input type="hidden" name="authortype" id="shkmessage_authortype"   />
	
<div id='shkmessage_postcontent'>
        
 <div class="form-group">
     <!-- <label class="col-md-2 control-label "  >Informazioni Addizionali</label>  -->
     
     <div class="col-md-12" >
     <div id='shkmessage_postimage'>
        
     </div>     
     </div>
     
     <div class="col-md-12" >
          <textarea name="message" class="form-control" id="shkmessage_message"  rows='5'></textarea>        
     </div>
 </div>
        

    <div class="form-action-bar">
        <button type="button" data-action='image-selection:shkmessage' class="btn btn-default  btn-sm" >
          <i class='fa fa-camera'></i>
        </button>
        
        <button type="button" data-action='primarypost-submit:shkmessage' class="btn btn-default  btn-sm" >
          <span>{%#org.r3.message.action_save%}</span>
        </button>        
    </div> 
</div>    
</form>
</div>
    