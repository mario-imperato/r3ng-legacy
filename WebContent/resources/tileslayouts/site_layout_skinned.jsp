<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00"     prefix="r3_lang" %>

<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<%@ page language="java" session="false"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,    
    java.util.*,
    org.r3.db.system.site.SiteDTO,
    org.r3.db.system.siteproperty.SitePropertyDTO,
    org.r3.db.system.siteproperty.GoogleAnalyticsTracker
    " %>

<r3_lang:environment id="r3Env" namespace='org.r3'>

<%
  SiteDTO targetSite = r3Env.getRequestSite();
  SitePropertyDTO spDto = targetSite.getSiteProperties().getPropertyByPropertykey(SitePropertyDTO.UI_CFG_PKG, SitePropertyDTO.UI_CFG_MENUS);
  SitePropertyDTO spDto_menuitems = targetSite.getSiteProperties().getPropertyByPropertykey(SitePropertyDTO.UI_CFG_PKG, SitePropertyDTO.UI_CFG_MENUSITEMS);
  GoogleAnalyticsTracker googleTracker = targetSite.getGoogleAnalyticsTracker();
  
  org.r3.db.cms.pageview.PageViewLUT pageViewLut = (org.r3.db.cms.pageview.PageViewLUT)
	       org.r3.db.system.lut.LUTManager.getLUTManager().getLUT(org.r3.db.system.lut.LUTManager.LUTName.cms_page, r3Env.getRequestLanguage());
  
  org.r3.db.cms.pageview.PageViewLUTDTO sitePages = pageViewLut.getItem(targetSite.getSite(), r3Env.getRequestLanguage());	 
  
  java.util.List<org.r3.db.cms.pageview.PageViewDTO> listOfPages = null;  
  
  if (sitePages != null)
      listOfPages = sitePages.getPages();   
  
  String siteBanner = targetSite.getCMSPropertyValueAsURL(targetSite.getSite(), "it", "site_banner", null);
  if (siteBanner == null)
	  siteBanner = new StringBuilder().append("/r3ng/resources/sites/").append(targetSite.getSiteresourcepath()).append("/top_banner.png").toString();

  String siteResourcePathStyleSheet = "/resources/sites/" + targetSite.getSiteresourcepath() + "/site_style.css";
%>


<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1">  
  <title><tiles:getAsString name="windowLayout_pageTitle"/></title>
  
  <script type="text/javascript">
  var console_layout = false;
  var r3_IE = false;  
  var facebook_appid = null;
  </script>

<link href='<r3_lang:pathResolver path="/resources/bootstrap/css/style_skinned.css" />' rel="stylesheet" type="text/css"/>  

<r3_lang:ifinclude include="<%=targetSite.isCSSDefined()%>">  
<link href='<r3_lang:pathResolver path="<%=targetSite.getSitecss()%>" />' rel="stylesheet" type="text/css"/>  
</r3_lang:ifinclude>

<link href='<r3_lang:pathResolver path="/resources/adminlte/css/AdminLTE.css" />' rel="stylesheet" type="text/css"/> 
<link href='<r3_lang:pathResolver path="/resources/adminlte/css/skins/adminlte-skins.css" />' rel="stylesheet" type="text/css"/>

<link href='<r3_lang:pathResolver path="<%=siteResourcePathStyleSheet%>" />' rel="stylesheet" type="text/css"/>  

<link href='<r3_lang:pathResolver path="/resources/bootstrap/css/datatables/dataTables.bootstrap.css" />' rel="stylesheet" type="text/css"/>
<link href='<r3_lang:pathResolver path="/resources/bootstrap/css/datatables/dataTables.responsive.css" />' rel="stylesheet" type="text/css"/>

<link href="//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Raleway:400,900,800,600,500,700,300,200,100" rel="stylesheet">

<link href='<r3_lang:pathResolver path="/resources/bootstrap/css/jquery-fileupload/jquery.fileupload.css" />' rel="stylesheet" type="text/css"/>
<link href='<r3_lang:pathResolver path="/resources/bootstrap/css/jquery-fileupload/jquery.fileupload-ui.css" />' rel="stylesheet" type="text/css"/>
<link href='<r3_lang:pathResolver path="/resources/bootstrap/css/jquery-fn-gantt/jquery.fn.gantt.css" />' rel="stylesheet" type="text/css"/>
<link href='<r3_lang:pathResolver path="/resources/bootstrap/css/bootstrap-datepicker.css" />' rel="stylesheet" type="text/css"/>
<link href='<r3_lang:pathResolver path="/resources/bootstrap/css/bootstrap-fileinput/fileinput.css" />' rel="stylesheet" type="text/css"/>
<link href='<r3_lang:pathResolver path="/resources/bootstrap/css/calendar/fullcalendar.css" />' rel="stylesheet" type="text/css"/>
<link href='<r3_lang:pathResolver path="/resources/bootstrap/css/font-awesome-4.7.0/css/font-awesome.min.css" />' rel="stylesheet" type="text/css"/>
<link href='<r3_lang:pathResolver path="/resources/bootstrap/css/leaflet/leaflet.css" />'  rel="stylesheet" type="text/css"/>
<!-- Genera una sovrapposizione con AdminLTE. -->
<r3_lang:comment>
<link href='<r3_lang:pathResolver path="/resources/bootstrap/css/leaflet/leaflet-sidebar.css" />'  rel="stylesheet" type="text/css"/>
</r3_lang:comment>
<link href='<r3_lang:pathResolver path="/resources/bootstrap/css/leaflet/leaflet.awesome-markers.css" />'  rel="stylesheet" type="text/css"/>

<link href='<r3_lang:pathResolver path="/resources/bootstrap/css/bootstrap-image-gallery/bootstrap-image-gallery.min.css" />'  rel="stylesheet" type="text/css"/>
<link href='<r3_lang:pathResolver path="/resources/bootstrap/css/bootstrap-image-gallery/blueimp-gallery.min.css" />'  rel="stylesheet" type="text/css"/>

<link href='<r3_lang:pathResolver path="/resources/bootstrap/css/slimbox/slimbox2.css" />' rel="stylesheet" type="text/css"/>  
<link href='<r3_lang:pathResolver path="/resources/bootstrap/css/flowplayer/flowplayer.css" />'  rel="stylesheet" type="text/css"/>

<style type="text/css" title="currentStyle">
  
#cookieLawConsent  {    }
#cookieLawConsent .userConsent {text-align:center;min-height:100px;background-color:#058B7B;overflow:auto;}
#cookieLawConsent .userConsent p,
#cookieLawConsent .userConsent a {padding: 5px;font:normal 11px arial;line-height:15px;color: #FFFFFF;text-transform: uppercase}
#cookieLawConsent .userConsent a{text-decoration:underline;}
#cookieLawConsent .userConsent a.closeBtn {padding:2px 4px;margin-left:10px;text-decoration: none;color:#058B7B;background-color: #FFFFFF;border:1px solid #000000;}
    
</style>

<!--[if gt IE 9]>
  <script src="http://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="http://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

<tiles:useAttribute id="windowLayout_pagestyle" ignore="true" name="windowLayout_pagestyle" classname="java.lang.String" />
<r3_lang:ifinclude include="<%=windowLayout_pagestyle!=null%>">
     <%=windowLayout_pagestyle%>
</r3_lang:ifinclude>

<r3_lang:ifinclude include="<%=googleTracker != null%>">
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', '<%=googleTracker.getTrackerId()%>', '<%=googleTracker.getTrackerDomain()%>');
  // ga('send', 'pageview');

</script>
</r3_lang:ifinclude>


<!-- 
  <r3_lang:comment>
  User Session Id is: <%=r3Env.getAuthInfo().getUserSessionId()%>
  </r3_lang:comment>
 -->
  
</head>

<%
   java.util.Random r = new java.util.Random(new java.util.Date().getTime()); 
   String skinNumber = "skinnumber_" + (r.nextInt(13) + 6);
   %>
<body class="r3 skinned <%=skinNumber%>" leftMargin="0" topMargin="50" marginWidth="0" marginHeight="0">

  <!-- Div Section for FaceBook -->
  <div id="fb-root"></div>
      
  <div id="wmg_application_notifier" style="display: block">
    <div class="wmg_notifiche clearfix">
        
      <div class="wmg_notifiche_in">
        <p style="float: left"><r3_lang:string resourceId="wait_please"></r3_lang:string></p>
        <div class="wmg_notifiche_actions">
          <button type="button" id="notifierButtonOK" class="btn btn-primary start">
            <span>OK</span>
          </button>
        </div>
      </div>

    </div>
  </div>

 
 <div id="cookieLawConsent"></div>
 
  <div id="mainTop">  
  </div>
  
  <div id='layout_root_container' class='container' >
  <div id="header" >
  <div 
    style="background: url('<%=siteBanner%>') no-repeat scroll left bottom #142A38; background-size: 100% 100%; width: 100%; position: relative; padding-bottom: 10%;">
  
      <%
         String topBannerLinks = "/resources/sites/" + targetSite.getSiteresourcepath() + "/top_banner_links.html";
      %>

      <jsp:include page="<%=topBannerLinks%>" flush="true" />      
            
  </div>

  <!-- Fixed navbar -->
  <r3_lang:ifinclude include='<%=spDto.valueContains("txtmenu", null, null)%>'>
  <nav class="navbar navbar-inverse " style ='margin-bottom: 0'>
      <div class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            
            
            <r3_lang:ifinclude include="<%=!r3Env.isGuest()%>">
            <a class="navbar-brand" >
            <%=r3Env.getUsername()%></a></r3_lang:ifinclude>
            
          </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class='nav navbar-nav pull-right '>  
<%
  if (listOfPages != null)
  {
  for( org.r3.db.cms.pageview.PageViewDTO pageDTO : listOfPages)
  {
    if (pageDTO.isVisibleIn(org.r3.db.cms.page.PageDTO.PageVisibility.cmspg_txtmenu, r3Env.isGuest())  && r3Env.checkFunction(pageDTO.getPermissions()))
    {
%>
        <li><a href='<r3_lang:pathResolver path="<%=pageDTO.getPagelink()%>" />'><%=pageDTO.getPagetitle()%></a></li>  
<%
    }
  }
  }
%>    

          <r3_lang:ifinrole allowFunctions="console">
          <li><a href='<r3_lang:pathResolver path="/org/r3/console/home.do" />'>Area Amministrativa</a></li>
          </r3_lang:ifinrole>
                      
          <r3_lang:ifinclude include="<%=!r3Env.isGuest()%>">
          <li><a href='<r3_lang:pathResolver path="/org/r3/user/myr3.do" />'>My R3</a></li>
          <li><a href="javascript:void(0)" id="pageAction_logOut" >Log-out</a></li>          
          <!-- <li><a class="disabled" ><%=r3Env.getUsername()%></a></li>  -->
          </r3_lang:ifinclude>
          
          </ul>
  
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    </r3_lang:ifinclude>
            
    <r3_lang:ifinclude include='<%=(spDto.valueContains("socialmenu", null, null) || spDto.valueContains("flagsmenu", null, null))%>'>
    <div id='iconiclinks_bar' >
    <ul class='list-inline'>
    <r3_lang:ifinclude include='<%=(spDto.valueContains("socialmenu", null, null))%>'>
    <li><a href='https://www.facebook.com/pages/Circolo-Velico-Fiumicino/714928588568140' class='social_selector  facebook'>&nbsp;</a></li>
    <li><a href='https://twitter.com/cvfiumicino' class='social_selector  twitter'>&nbsp;</a></li>
    </r3_lang:ifinclude>
    <!-- 
    <a href='http://youtube.com' class='youtube'>Seguici su YouTube</a>
     -->
    <r3_lang:ifinclude include='<%=(spDto.valueContains("flagsmenu", null, null))%>'>
    <li><a class='language_selector italy'  data-language='it' href='javascript:void(0)'>&nbsp;</a></li>
    <li><a class='language_selector brasil' data-language='pt' href='javascript:void(0)'>&nbsp;</a></li>
    </r3_lang:ifinclude>
    </ul>
        
    </div>
    </r3_lang:ifinclude>
           
    <div id="breadcrumb_bar" class="clearfix hidden-print" style="display: none; width: 100%; background-color: #cccccc;">
    <div id="breadcrumbs">
    </div>
     </div>
    
  </div>
    
  <div id="mainCanvas" class='clearfix' >
    <div id="canvas_content" class='clearfix' >

<tiles:useAttribute id="windowLayout_canvasList" name="windowLayout_canvasList" classname="java.util.List" ignore="true" />
<%
   if (windowLayout_canvasList != null)
   {
     Iterator<String> iter = (Iterator<String>) windowLayout_canvasList.listIterator();
     for( ; iter.hasNext(); )
     {
        String tilesItem = (String)iter.next();
  %>
  
  <tiles:insert name="<%=tilesItem%>" flush="true" />
  <%
     }
   }
   else 
   {
       %><div style="height: 400px"></div><%
   }
   %>
      </div>

  <!-- 
    </div>
  </div>
  -->
  
  <div id="canvas_report" >
    
    <div class="panel panel-default">
    <div class="panel-heading clearfix unprintable">
      <h4 class="panel-title pull-left" style="padding-top: 7.5px;" id="canvas_report_title">&nbsp;</h4>
      <div class="btn-group pull-right">
      
        <a href="#" id="canvas_report_printAction" class="btn btn-default btn-sm">Stampa</a>
        <a href="#" id="canvas_report_closeAction" class="btn btn-default btn-sm">Chiudi</a>
      </div>
    </div>
    <div class="panel-body" id="canvas_report_content">    
    </div>
    
    </div>
    
  </div>
    
  <div id="layout-footer" >
    <div class="separator"></div>
  </div>
  </div>
  </div>

  <%
  	org.r3.system.social.facebook.AppInfo facebookAppInfo =
  		org.r3.system.social.facebook.AppInfo.retrieveAppInfo(r3Env.getServerName());
  
    if (facebookAppInfo != null)
    {
    	   %> 
    	   <script type='text/javascript'>
    	     	facebook_appid = "<%=facebookAppInfo.getAppId()%>"; 
    	   </script>
    	   <%
    }
  %>
  <r3_lang:script path2resolve="/resources/js/social_scripts.js"              scriptEnv="any" />  
  <r3_lang:script path2resolve="/resources/js/jquery-1.10.1.min.js"           scriptEnv="any" />  
  <r3_lang:script path2resolve="/resources/js/jquery-ui-1.10.3.custom.min.js" scriptEnv="any" />
  <r3_lang:script path2resolve="/resources/bootstrap/js/bootstrap.min.js"     scriptEnv="any" />
  

  <r3_lang:script path2resolve="/resources/js/jquery_r3ng_js.js"     scriptEnv="runtime" />
  <r3_lang:script path2resolve="/resources/jsr3/jquery_r3ng_jsr3.js" scriptEnv="runtime" />


  <r3_lang:script path2resolve="/resources/js/Class.js"                               scriptEnv="dev"/>
  <r3_lang:script path2resolve="/resources/js/date.js"                                scriptEnv="dev"/>
  <r3_lang:comment>
  <r3_lang:script path2resolve="/resources/js/html5shiv.js"                           scriptEnv="dev"/>
  </r3_lang:comment>
  
  <r3_lang:script path2resolve="/resources/js/I18NMessage.js"                         scriptEnv="dev"/>
  <r3_lang:script path2resolve="/resources/js/i18next-1.7.7.min.js"                     scriptEnv="dev"/>
  <r3_lang:script path2resolve="/resources/js/jquery-tmpl.min.js"                     scriptEnv="dev"/>

  <r3_lang:script path2resolve="/resources/js/datatables/jquery.dataTables.min.js"               scriptEnv="dev"/>
  <r3_lang:script path2resolve="/resources/js/datatables/dataTables.bootstrap.js"                scriptEnv="dev"/>
  <r3_lang:script path2resolve="/resources/js/datatables/dataTables.responsive.min.js"                scriptEnv="dev"/>
  
  <r3_lang:script path2resolve="/resources/js/bootstrap-slider.js"                    scriptEnv="dev"/>
  <r3_lang:script path2resolve="/resources/js/bootstrap-multiselect.js"                    scriptEnv="dev"/>
  <r3_lang:script path2resolve="/resources/js/bootstrap-datepicker.min.js"                    scriptEnv="dev"/>
  <r3_lang:script path2resolve="/resources/js/bootstrap-timepicker.js"                  scriptEnv="dev"/>  
  <r3_lang:script path2resolve="/resources/js/bootstrap3-typeahead.min.js"                  scriptEnv="dev"/>  
    
  <r3_lang:script path2resolve="/resources/js/jquery.form.js"                         scriptEnv="dev"/>
  <r3_lang:script path2resolve="/resources/js/jquery.metadata.js"                     scriptEnv="dev"/>
  <r3_lang:script path2resolve="/resources/js/jquery.validate.js"                 scriptEnv="dev"/> 
  


  <r3_lang:script path2resolve="/resources/js/jquery.flot.min.js"                    scriptEnv="dev"/>
  <r3_lang:script path2resolve="/resources/js/jquery.flot.pie.min.js"                scriptEnv="dev"/>

  <r3_lang:script path2resolve="/resources/js/moment-with-langs.min.js"               scriptEnv="dev"/>
  <r3_lang:script path2resolve="/resources/js/fullcalendar/fullcalendar.min.js"       scriptEnv="dev"/>
  <r3_lang:script path2resolve="/resources/js/fullcalendar/lang/pt-br.js"              ifLanguage='pt' scriptEnv="any"/>
  <r3_lang:script path2resolve="/resources/js/fullcalendar/lang/it.js"                 ifLanguage='it' scriptEnv="any"/>

  <r3_lang:script path2resolve="/resources/js/lang-all.js"                            scriptEnv="dev"/>
  
  <r3_lang:script path2resolve="/resources/js/underscore.js"                 scriptEnv="dev"/>
  <r3_lang:script path2resolve="/resources/js/ui-totop/jquery.ui.totop.js" scriptEnv="dev" />
  <r3_lang:script path2resolve="/resources/js/ui-totop/easing.js" scriptEnv="dev" />
  <r3_lang:script path2resolve="/resources/js/leaflet/leaflet.js" scriptEnv="dev" />
  <r3_lang:script path2resolve="/resources/js/leaflet/jquery-sidebar.js" scriptEnv="dev" />
  <r3_lang:script path2resolve="/resources/js/leaflet/leaflet-sidebar.js" scriptEnv="dev" />
  <r3_lang:script path2resolve="/resources/js/leaflet/leaflet.awesome-markers.js" scriptEnv="dev" />
    
  <r3_lang:script path2resolve="/resources/js/jquery-img/canvas-to-blob.min.js" scriptEnv="dev" /> 
  <r3_lang:script path2resolve="/resources/js/jquery-img/draggable_background.js" scriptEnv="dev" />
  <r3_lang:script path2resolve="/resources/js/jquery-img/jquery.color.js" scriptEnv="dev" />
  <r3_lang:script path2resolve="/resources/js/jquery-img/jquery.Jcrop.min.js" scriptEnv="dev" />
  <r3_lang:script path2resolve="/resources/js/jquery-img/load-image.all.min.js" scriptEnv="dev" />
  
  <!-- Inserito un hack in app.js per gestire la situazione nella quale applicava slimscroll in maniera incondizionata alle sidebar
       e andava a centrare anche la sidebar leaflet.
   -->  
  <r3_lang:script path2resolve="/resources/js/jquery.slimscroll.js" scriptEnv="dev" />
      
  <r3_lang:script path2resolve="/resources/js/bootstrap-fileinput/fileinput.js" scriptEnv="dev" />
  <r3_lang:script path2resolve="/resources/js/bootstrap-fileinput/fileinput_locale_it.js" scriptEnv="dev" />
  
  <r3_lang:script path2resolve="/resources/js/jquery.iframe-transport.js"    scriptEnv="dev"/>
  <r3_lang:script path2resolve="/resources/js/jquery.fileupload.js"          scriptEnv="dev"/>
  <r3_lang:script path2resolve="/resources/js/jquery.fileupload-process.js"  scriptEnv="dev"/>
  <r3_lang:script path2resolve="/resources/js/jquery.fileupload-image.js"    scriptEnv="dev"/>
  <r3_lang:script path2resolve="/resources/js/jquery.fileupload-validate.js" scriptEnv="dev"/>    
  <r3_lang:script path2resolve="/resources/js/jquery.fileupload-ui.js"       scriptEnv="dev"/>

  <r3_lang:script path2resolve="/resources/js/jquery.fileupload-locale.js" 	  scriptEnv="dev"/>
  
  <r3_lang:script path2resolve="/resources/js/jquery.jstree.js" scriptEnv="dev" />
  
  <!-- Da verificare in relazione all'uso di light box... -->  
  <r3_lang:script path2resolve="/resources/js/img-gallery/blueimp-gallery.min.js"      scriptEnv="dev"/>
  <r3_lang:script path2resolve="/resources/js/img-gallery/bootstrap-image-gallery.min.js"      scriptEnv="dev"/>
  
  <r3_lang:script path2resolve="/resources/js/slimbox2.js"      scriptEnv="dev"/>
  <r3_lang:script path2resolve="/resources/js/jquery.carouFredSel-6.2.1-packed.js" scriptEnv="dev" />
  <r3_lang:script path2resolve="/resources/js/modernizr.custom-2.7.1.js" scriptEnv="dev" />
  <r3_lang:script path2resolve="/resources/js/xbbcode.js" scriptEnv="dev" /> 
  <r3_lang:script path2resolve="/resources/js/jquery.fn.gantt.js" scriptEnv="dev" /> 
  <r3_lang:script path2resolve="/resources/js/jquery.knob.js" scriptEnv="dev" />
  <r3_lang:script path2resolve="/resources/js/flowplayer/flowplayer.js" scriptEnv="any" />

  <!-- R3 Plugins Javascript -->  
  <r3_lang:script path2resolve="/resources/jsr3/r3_cascade.js" />
  <r3_lang:comment>
  <r3_lang:script path2resolve="/resources/jsr3/r3_datepicker_checker.js" />
  </r3_lang:comment>
  <r3_lang:script path2resolve="/resources/jsr3/r3_formmessage.js" />
  <r3_lang:script path2resolve="/resources/jsr3/r3_infoline.js" />
  <r3_lang:script path2resolve="/resources/jsr3/r3_notifier.js" />
  <r3_lang:script path2resolve="/resources/jsr3/r3_wizardnavigator.js" />
  <r3_lang:script path2resolve="/resources/jsr3/r3_cmscard.js" />
  <r3_lang:script path2resolve="/resources/jsr3/r3_gmenubar.js" />
  <r3_lang:script path2resolve="/resources/jsr3/r3_gsidebar.js" />
  <r3_lang:script path2resolve="/resources/jsr3/r3_gmultiselect.js" />
  <r3_lang:script path2resolve="/resources/jsr3/r3_gdatetime.js" />
  <r3_lang:script path2resolve="/resources/jsr3/r3_picker.js" />
  <r3_lang:script path2resolve="/resources/jsr3/r3_loadimage.js" />

  <r3_lang:script path2resolve="/resources/jsr3/r3_utils.js" />
  <r3_lang:script path2resolve="/resources/jsr3/r3_gmiller.js" /> 
  
  <r3_lang:script path2resolve="/org/r3/siteconstants.do"   scriptEnv="any" />
  <r3_lang:script path2resolve="/org/r3/constants.do"       scriptEnv="any" />

  <r3_lang:script path2resolve="/org/r3/jquery_r3ng_jsappmsg.js"     scriptEnv="runtime" />  
  <r3_lang:script path2resolve="/org/r3/jquery_r3ng_jsappmsg_pt.js"  ifLanguage='pt'  scriptEnv="runtime" />  
  <r3_lang:script path2resolve="/org/r3/jquery_r3ng_jsapp.js"        scriptEnv="runtime" />

  <r3_lang:script path2resolve="/org/r3/Messages.js" />
  <r3_lang:script path2resolve="/org/r3/Messages_pt.json" ifLanguage='pt' />

  <r3_lang:script path2resolve="/org/r3/Validation.js" />
  <r3_lang:script path2resolve="/org/r3/RESTConfigManager.js" />
  <r3_lang:script path2resolve="/org/r3/RestDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/LUTManager.js" />

  <r3_lang:script path2resolve="/org/r3/PageManager.js" />
  <r3_lang:script path2resolve="/org/r3/AjaxUtils.js" />
  <r3_lang:script path2resolve="/org/r3/GoogleMapsUtils.js" />

  <r3_lang:script path2resolve="/org/r3/ActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/ActionFormManager.js" />
  <r3_lang:script path2resolve="/org/r3/BreadCrumbManager.js" />

  <r3_lang:script path2resolve="/org/r3/db/DataTableEntityActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/DTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/DTOTableAdapter.js" />

  <r3_lang:script path2resolve="/org/r3/db/system/user/user/UserQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/user/user/UserDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/user/user/UserDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/user/user/UserDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/system/user/user/UserDictionary_pt.json" ifLanguage='pt' />
  
  <r3_lang:script path2resolve="/org/r3/db/mongo/usercollection/UserCollectionDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/usercollection/UserCollectionDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/usercollection/UserCollectionDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/usercollection/UserCollectionQueryActionFormView.js" /> 

  <r3_lang:script path2resolve="/org/r3/db/mongo/sitecollection/SiteCollectionDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/sitecollection/SiteCollectionDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/sitecollection/SiteCollectionDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/AddressDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/mongo/MongoImageDTOAdapter.js" />  
  <r3_lang:script path2resolve="/org/r3/db/mongo/MongoImageIconDTOAdapter.js" />  
  <r3_lang:script path2resolve="/org/r3/db/mongo/MongoFileAttachmentDTOAdapter.js" />      
  <r3_lang:script path2resolve="/org/r3/db/mongo/MongoLinkDTOAdapter.js" />      
    
  <r3_lang:script path2resolve="/org/r3/jsportlet/cms/CMSPage_PaginationHelper.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cms/CMSPage_GalleryView.js" />

  <r3_lang:script path2resolve="/org/r3/db/cms/cardview/CardViewQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/cardview/CardViewDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/cardview/CardViewDTO.js" />

  <r3_lang:script path2resolve="/org/r3/db/cms/page/PageQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/page/PageDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/page/PageDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/page/PageDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/page/PageDictionary_pt.json" ifLanguage='pt' />
  
  <r3_lang:script path2resolve="/org/r3/db/cms/cardproperty/CardPropertyQueryActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/cardproperty/CardPropertyDTOAdapter.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/cardproperty/CardPropertyDTO.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/cardproperty/CardPropertyDictionary.js" />
  <r3_lang:script path2resolve="/org/r3/db/cms/cardproperty/CardPropertyDictionary_pt.json" ifLanguage='pt' />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/cookielaw/CookieLawActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/cookielaw/CookieLawActionFormView.js" />
  
  <r3_lang:script path2resolve="/org/r3/jsportlet/login/LoginActionForm.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/login/LoginActionFormView.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/login/LoginActionForm_validation.js" />
  <r3_lang:script path2resolve="/org/r3/jsportlet/login/messages.js" />

  <tiles:insert attribute='layout_templates_001'  />
  <tiles:insert attribute='layout_templates_002'  />
  <tiles:insert attribute='layout_templates_003'  />


<tiles:useAttribute id="windowLayout_scriptList" name="windowLayout_scriptList" classname="java.util.List" ignore="true" />
<%
   if (windowLayout_scriptList != null)
   {
     Iterator<String> iter = (Iterator<String>) windowLayout_scriptList.listIterator();
     for( ; iter.hasNext(); )
     {
        String tilesItem = (String)iter.next();
  %>
  
  <tiles:insert name="<%=tilesItem%>" flush="true" />
  <%
     }
   }
   %>

<form id="r3_js_appversionform_form"><input type='hidden' name='jsappversion' value='1.0' /></form>
</body>

</r3_lang:environment>
