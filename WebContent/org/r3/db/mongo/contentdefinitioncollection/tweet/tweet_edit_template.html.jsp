<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<div id='tweet_edit_wrapper' >

<div class='content_fieldsetmessage'></div>
 
    <form id="tweet_form" method="POST" >
    	<input type='hidden' id="tweet_geolat" name="geolat" /> 
		<input type='hidden' id="tweet_geolong" name="geolong" />
		<input type='hidden' id="tweet_geoacc" name="geoacc" />
        <input type='hidden' id="tweet_timeline" name="timeline" /> 
		<input type='hidden' id="tweet_parentpostid" name="parentpostid" />
		<input type='hidden' id="tweet_postid" name="postid" />
		<input type='hidden' id="tweet_contentcategory" name="contentcategory" value='shkgeneral' />			
		<input type='hidden' id="tweet_contentclass" name="contentclass" value='tweet' />    
		<input type="hidden" name="title" id="tweet_title"   />
		<input type="hidden" name="content" id="tweet_content"   />
		<input type="hidden" name="author" id="tweet_author"   />
		<input type="hidden" name="authorname" id="tweet_authorname"   />
		<input type="hidden" name="authortype" id="tweet_authortype"   />
		
    <div class="form-group">
	<textarea
	        id="tweet_tweet"
			class="form-control input-sm" name="tweet" maxlength="1000"
			placeholder="Pubblica"
			aria-multiline="true" aria-invalid="false"></textarea>
	</div>
    </form>
    
    <div class='pull-right' style='margin-top: 5px'>
    <button type="button" data-action='childpost-submit:tweet' class="btn btn-danger  btn-sm">
			Pubblica
	</button>
	</div>
	

</div>
