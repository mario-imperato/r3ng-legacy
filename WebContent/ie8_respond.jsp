<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00"     prefix="r3_lang" %>

<%@ page language="java" session="false"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,    
    java.util.*,
    org.r3.db.system.site.SiteDTO      
    " %>

<r3_lang:environment id="r3Env" namespace='org.r3'>
<%
  
%>

<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
  <meta http-equiv=”X-UA-Compatible” content=”IE=edge”>
  <meta name=”viewport” content=”width=device-width, initial-scale=1″>
 
  <link href='resources/bootstrap/css/bootstrap.css' rel="stylesheet" type="text/css"/>


<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- 
  <script type='text/javascript' src='resources/js/modernizr.min.js'></script>
  <script type='text/javascript' src='resources/js/css3-mediaqueries.js'></script>
  -->
<!-- 
  <script type='text/javascript' src='resources/js/html5shiv.min.js'></script>
  <script type='text/javascript' src='resources/js/respond.min.js'></script>
 -->
<!--[if lt IE 9]>
  <script src="http://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="http://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

</head>

<body class="r3" leftMargin="0" topMargin="0" marginWidth="0" marginHeight="0" >

  <div class='container'>
  <div class='row'>
  <div class='col-md-5' style='border: 1px solid #cccccc'>Rosso</div>
  <div class='col-md-7'>Giallo</div>
  
  </div>
  </div>
  
  <r3_lang:script path2resolve="/resources/js/jquery-1.10.1.min.js"           scriptEnv="any" />  
  <r3_lang:script path2resolve="/resources/js/jquery-ui-1.10.3.custom.min.js" scriptEnv="any" />  
  <r3_lang:script path2resolve="/resources/bootstrap/js/bootstrap.min.js"     scriptEnv="any" />
    
</body>

</r3_lang:environment>
