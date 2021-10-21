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

<div style='min-height: 500px; padding: 20px;' >

<div class="row">
<div class="col-md-3 hidden-sm hidden-xs cmsCard">
 <div id="JSPortlet_SideBar" class="actionForm" style="display: none; "></div>
</div>

<div class="col-md-9 col-sm-12 col-xs-12">

<div id="profileActionFormTabs" >

<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#userPhotoActionForm" role="tab" data-toggle="tab">Fotografia Profilo</a></li>
    <li role="presentation" ><a href="#changeUserPasswordActionForm" role="tab" data-toggle="tab">Modifica Parola Chiave</a></li>
</ul>

<div class="tab-content" >  
   <div id="userPhotoActionForm" class='tab-pane active tab-pane-framed'></div>
   <div id="changeUserPasswordActionForm" class='tab-pane tab-pane-framed'></div>
</div>
  
</div>

</div>
</div>
</div>

