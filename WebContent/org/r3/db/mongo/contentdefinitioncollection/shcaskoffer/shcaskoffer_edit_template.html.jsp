<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<div id='shcaskoffer_edit_wrapper' >

<div class='content_fieldsetmessage'></div>
 
    <form id="shcaskoffer_form" method="POST" >
        <input type='hidden' id="shcaskoffer_geolat" name="geolat" /> 
        <input type='hidden' id="shcaskoffer_geolong" name="geolong" />
        <input type='hidden' id="shcaskoffer_geoacc" name="geoacc" />
        <input type='hidden' id="shcaskoffer_timeline" name="timeline" /> 
		<input type='hidden' id="shcaskoffer_parentpostid" name="parentpostid" />
		<input type='hidden' id="shcaskoffer_postid" name="postid" />
		<input type='hidden' id="shcaskoffer_contentcategory" name="contentcategory" value='shkmerchant' /> 
		<input type='hidden' id="shcaskoffer_contentclass" name="contentclass" value='shcaskoffer' />    
		<input type="hidden" name="title" id="shcaskoffer_title"   />
		<input type="hidden" name="content" id="shcaskoffer_content"   />
		<input type="hidden" name="author" id="shcaskoffer_author"   />
		<input type="hidden" name="authorname" id="shcaskoffer_authorname"   />
		<input type="hidden" name="authortype" id="shcaskoffer_authortype"   />
		
    <div class="form-group">
	<textarea
	        id="shcaskoffer_shcaskoffer"
			class="form-control input-sm" name="shcaskoffer" maxlength="1000"
			placeholder="Pubblica"
			aria-multiline="true" aria-invalid="false"></textarea>
	</div>
    </form>
    
    <div class='pull-right' style='margin-top: 5px'>
    <button type="button" data-action='childpost-submit:shcaskoffer' class="btn btn-danger  btn-sm">
			Pubblica
	</button>
	</div>
	

</div>
