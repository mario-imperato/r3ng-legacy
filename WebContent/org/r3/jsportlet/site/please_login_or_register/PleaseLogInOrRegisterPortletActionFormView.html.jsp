<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.io.*,
    java.util.*
    "%>

<%
	String mode = request.getParameter("mode");
	boolean isDetail = mode.equalsIgnoreCase("detail");
	boolean isCreate = !isDetail;
%>


<!-- 
<div class="alert alert-danger alert-dismissible">
	<button type="button" class="close" data-dismiss="alert"
		aria-hidden="true">×</button>
	<p>
		<a
			href="{%=org.r3.Constants.getStrutsActionContext()%}/org/r3/user/myr3.do"
			" style='text-decoration: none;'><i class="icon fa fa-edit"></i>
			Registrarsi è semplice e non costa nulla!</a>
	</p>
</div>
-->

<div class="callout callout-danger">
<p>
Per utilizzare ShakeUs è necessario registrarsi: è semplice e non costa nulla!                                                             
</p>             
<div style='text-align: right'>                                                                                     
<button class="btn btn-primary" id='please_action_register'>Registrati</button> 
<button class="btn btn-social-icon btn-facebook" id='please_action_fblogin'><i class="fa fa-facebook"></i></button>                     
</div>

</div>   
		
<div id='JSPortlet_PleaseLogInOrRegister_LoginForm'></div>


