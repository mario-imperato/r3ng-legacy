<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env" namespace='org.r3.home.mastersite'>

<div id="row" style='height: 100%'>

  <div class='col-md-4 col-md-offset-2 col-sm-6' id="left_canvas">

        <h1 class="main-heading" > 
        <r3_lang:string resourceId="welcome_s100" /> | <a href="/r3ng/<%=r3Env.getRequestSiteId()%>/<%=r3Env.getRequestLanguage()%>/org/r3/console/home.do"><r3_lang:string resourceId="admin_s100" /></a>.
        </h1>
         
        <div id="homePageActionForm" ></div>         

  </div>
  
  <div class='col-md-4 col-sm-6 hidden-xs' id="right_canvas">
  
     <div class='row'>
     <div id="right_top_canvas" class='col-md-12' >
        
     </div>
     </div>

     <div class='row'>
     <div class='col-md-12 splash_logo'  >
                      
     </div>
     </div>
     
  </div>
  
    
  </div>


</r3_lang:environment>
