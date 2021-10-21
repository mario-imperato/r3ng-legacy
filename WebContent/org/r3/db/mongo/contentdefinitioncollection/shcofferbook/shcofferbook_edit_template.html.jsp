<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<div id='shcofferbook_edit_wrapper' >

<div class='content_fieldsetmessage'></div>
 
    <form id="shcofferbook_form" method="POST" >
        <input type='hidden' id="shcofferbook_geolat" name="geolat" /> 
        <input type='hidden' id="shcofferbook_geolong" name="geolong" />
        <input type='hidden' id="shcofferbook_geoacc" name="geoacc" />    
        <input type='hidden' id="shcofferbook_timeline" name="timeline" /> 
		<input type='hidden' id="shcofferbook_parentpostid" name="parentpostid" />
		<input type='hidden' id="shcofferbook_postid" name="postid" />
        <input type='hidden' id="shcofferbook_contentcategory" name="contentcategory" value='shkmerchant' />		
		<input type='hidden' id="shcofferbook_contentclass" name="contentclass" value='shcofferbook' />    
		<input type="hidden" name="title" id="shcofferbook_title"   />
		<input type="hidden" name="content" id="shcofferbook_content"   />
		<input type="hidden" name="shakeit" id="shcofferbook_shakeit" value="true"  />
		<input type="hidden" name="author" id="shcofferbook_author"   />
		<input type="hidden" name="authorname" id="shcofferbook_authorname"   />
		<input type="hidden" name="authortype" id="shcofferbook_authortype"   />
		
    <div class="form-group">
	<textarea
	        id="shcofferbook_message"
			class="form-control input-sm" name="message" maxlength="1000"
			placeholder="Pubblica"
			aria-multiline="true" aria-invalid="false"></textarea>
	</div>
    </form>
    
    <div class='pull-right' style='margin-top: 5px'>
    <button type="button" data-action='childpost-submit:shcofferbook' class="btn btn-danger  btn-sm">
			Pubblica
	</button>
	</div>
	

</div>
