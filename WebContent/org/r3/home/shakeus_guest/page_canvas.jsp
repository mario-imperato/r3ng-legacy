<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env" namespace='org.r3.home.shakeus_guest'>

<div >
	<div class="shakehome-header">
		<div class='container-fluid'>
			<div class='row'>
				<div class='col-md-4  col-sm-3'><div class='shakehome-logo'></div></div>
				<div class='col-md-8 col-sm-9'>
				<div id='JSPortlet_LoginActionForm'></div>
				</div>
			</div>
		</div>
	</div>

	<div class='container shakehome-canvas ' >
	<div class='row hidden-xs'>
	<div class='col-md-6 col-sm-6' style='margin-top: 10px; margin-bottom: 10px; '>	
    <div id='ShakeUSSplash' class='shakehome-splash' >
    <!-- Creare una card generica con id SHKSPLASH con il contenuto HTMl Seguente -->
    <h1 style='margin-top: 0px;'>Lo sport in connessione</h1>
       <h4>ShakeUs
       <span class="uppercase">Lo sport local network che ci serve!</span></h4>
       <div style='position: absolute; bottom: 0px; right: 30px;'>
         <iframe  src="https://www.youtube.com/embed/P-nBgLZH8XM?rel=0" frameborder="0" allowfullscreen=""></iframe>
       </div>
    </div>
    </div>
	<div class='col-md-6 col-sm-6' style='margin-top: 10px; margin-bottom: 10px; '>
	
	<div class="callout callout-danger">
	<div id='ShakeUSSplash2'></div>
	<div style='text-align: right'>                                                                                     
		<a class="btn  btn-primary" href="home.do?shkaction=map" role="button">Esplora</a>
		<button class="btn btn-social-icon btn-facebook" id="FBLoginAction"><i class="fa fa-facebook"></i></button>                      
	</div>
	</div> 
    
    <div id='JSPortlet_RegistrationActionForm'></div>
	
    </div>	
	</div>
	<div id='ShakeUSSplash3' class='hidden-lg hidden-md hidden-sm'></div>
	</div>

    <div class="shakehome-footer" ></div>
</div>
            
</r3_lang:environment>