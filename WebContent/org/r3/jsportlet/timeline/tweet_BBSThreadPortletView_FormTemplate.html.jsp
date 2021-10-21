<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<div id='tweet_jsportlettimelineform_wrapper' >

<div class='jsportlettimelineform_fieldsetmessage'></div>
 
<div class="row">
<div class="col-sm-10 col-xs-9">
    <form id="tweet_jsportlettimelineform_form" method="POST" >
    <input type='hidden' id="tweet_jsportlettimelineform_nodeparentid" name="nodeparentid" />             
    <input type='hidden' id="tweet_jsportlettimelineform_threadnodeid" name="threadnodeid" />      
    <input type='hidden' id="tweet_jsportlettimelineform_nodetype" name="nodetype" value='tweet' />
    
	<textarea
	        id="tweet_jsportlettimelineform_nodetext"
			class="form-control" name="nodetext" maxlength="1000"
			placeholder="Pubblica"
			style="border-radius: 4px; margin-top: 0px; margin-bottom: 0px; height: 124px;"
			aria-multiline="true" aria-invalid="false"></textarea>
	</form>
	</div>

	<div class="col-sm-2 col-xs-3" style='padding-left: 0'>

		<button type="button" data-action='tweet-cancel' class="btn btn-default  btn-block">
			Annulla
		</button>
		
		<button type="button" data-action='tweet-submit' class="btn btn-primary  btn-block">
			Crea<br />Messaggio
		</button>
		
	</div>
</div>
</div>
