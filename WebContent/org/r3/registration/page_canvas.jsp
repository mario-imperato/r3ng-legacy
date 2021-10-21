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
 
<div style='min-height: 500px; padding: 10px;' >

<div class="row">
<div class="col-md-3 cmsCard">
 <div id="HLP_REGISTRATION" class="actionForm hidden-xs" style="display: none; margin-bottom: 30px" card_tmpl="cms_tpl_simple"></div> 
</div>

<div class="col-md-9 ">
   <div id="JSPortlet_RegistrationActionForm" class='actionForm'></div>
</div>
</div>
</div>
