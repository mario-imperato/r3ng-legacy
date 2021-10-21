<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*,
    net.tanesha.recaptcha.ReCaptcha,
    net.tanesha.recaptcha.ReCaptchaFactory    
    " %>

<script type="text/javascript">
 var RecaptchaOptions = {
    theme : 'clean'
 };
</script>

<div id='userprofileactionform' class="actionForm" style="padding: 20px;">


<div class="row">
<div class="col-md-3 col-sm-3 cmsCard">

 <div id="JSPortlet_TaskCompletionSideBar" class="actionForm" style="display: none; "></div>  
 <div id="JSPortlet_RandomPhotoSideBar" class="hidden-xs actionForm" style="display: none; "></div>
 
</div>

<div class="col-md-9 col-sm-9">

<div id="profileActionFormTabs" >

<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#businessCardActionForm" role="tab" data-toggle="tab">Biglietto da Visita</a></li>
    <li role="presentation" ><a href="#addressActionForm" role="tab" data-toggle="tab">Indirizzo</a></li>
    <li role="presentation" ><a href="#changeUserPasswordActionForm" role="tab" data-toggle="tab">Modifica Parola Chiave</a></li>
</ul>

<div class="tab-content" >  
   <div id="businessCardActionForm" class='tab-pane active tab-pane-framed'>

	<div class="panel tabbed-panel">
  		<div class="panel-heading" >  
    		<h3 class="panel-title">Upload Immagini</h3>
  		</div>
  
  		<div class="panel-body">
  		
   <div class='row'>    
    <div class='col-md-5 col-lg-4' id='userPhotoActionForm' style='text-align: center'>
    </div>
    <div class='col-md-7 col-lg-8' id='businesscardinfoActionForm'>
    </div>
   </div>
   </div>
   </div>
   </div>   
   <div id="addressActionForm" class='tab-pane tab-pane-framed'>            
   </div>
   <div id="changeUserPasswordActionForm" class='tab-pane tab-pane-framed'></div>   
</div>
  

  
</div>

</div>
</div>
</div>

