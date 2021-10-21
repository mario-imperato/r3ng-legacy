<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env" namespace='org.r3.home.defaultsite'>

<div id="canvas_body">

  <div id="left_canvas">
     <div id="left_innercanvas" >
 
        <h1 id="r3_welcome_canvas" >
        <r3_lang:string resourceId="welcome_s100" />.
        </h1>
         
        <div id="homePageActionForm" ></div>         
     </div>
  </div>

  <div id="right_canvas">

     <div id="right_top_canvas" style="height: 30px; margin-top: 80px">
        
     </div>
    
     <div>
        <img src='<r3_lang:pathResolver path="/resources/sites/default/boat-background.jpg" />' style="display: block" />
     </div>          
      
  </div>
  
  <div style="clear: both" ></div>
</div>


</r3_lang:environment>
