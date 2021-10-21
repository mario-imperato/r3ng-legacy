<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<div id='shknews_edit_wrapper' >

<div class='content_fieldsetmessage'></div>
  
<form id="shknews_form" method="POST" class="form-horizontal">
<input type='hidden' id="shknews_geolat" name="geolat" /> 
<input type='hidden' id="shknews_geolong" name="geolong" />
<input type='hidden' id="shknews_geoacc" name="geoacc" />
<input type='hidden' id="shknews_timeline" name="timeline" /> 
<input type='hidden' id="shknews_parentpostid" name="parentpostid" />
<input type='hidden' id="shknews_postid" name="postid" />
<input type='hidden' id="shknews_contentcategory" name="contentcategory" value='shkgeneral' />	
<input type='hidden' id="shknews_contentclass" name="contentclass" value='shknews' />    
<input type="hidden" name="title" id="shknews_title"   />
<input type="hidden" name="content" id="shknews_content"   />
<input type="hidden" name="photo" id="shknews_photo"   />
<input type="hidden" name="author" id="shknews_author"   />
<input type="hidden" name="authorname" id="shknews_authorname"   />
<input type="hidden" name="authortype" id="shknews_authortype"   />
	
<div id='shknews_postcontent'>
        
 <div class="form-group">
     <!-- <label class="col-md-2 control-label "  >Informazioni Addizionali</label>  -->
     
     <div class="col-md-12" >
     <div id='shknews_postimage'>
        
     </div>     
     </div>
     
     <div class="col-md-12" >
          <textarea name="message" class="form-control" id="shknews_message"  rows='5'></textarea>        
     </div>
 </div>
        

    <div class="form-action-bar">
        <button type="button" data-action='image-selection:shknews' class="btn btn-default  btn-sm" >
          <i class='fa fa-camera'></i>
        </button>
        
        <button type="button" data-action='primarypost-submit:shknews' class="btn btn-default  btn-sm" >
          <span>{%#org.r3.message.action_save%}</span>
        </button>        
    </div> 
</div>    
</form>
</div>
    