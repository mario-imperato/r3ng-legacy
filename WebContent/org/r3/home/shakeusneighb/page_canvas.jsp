<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.io.*,
    java.util.*
    "%>

<r3_lang:environment id="r3Env" namespace='org.r3.home.shakeusneighb'>

<%
 org.r3.db.system.site.SiteDTO targetSite = r3Env.getRequestSite();
 String sitePhoto = "/was/" + targetSite.getSite() + "/it/sitecollection/" + targetSite.getSite() + "/graphics/shksitephoto;imagerole=image";
 
%>

<div class='row'>
			<div class='col-md-9 col-sm-9'>
 
                <div id='JSPortlet_PleaseLogInOrRegister' class='site-members-portlet'></div>
                
                <div style='margin-bottom: 20px'>
				<img src='<r3_lang:pathResolver path="<%=sitePhoto%>" />' style='width: 100%;' />
			    <div class="btn-group btn-group-justified" role="group" >
			      <!-- 
			      <a href="#" class="btn btn-default" role="button">Timeline</a>
			      <a href="#" class="btn btn-default" role="button">Strutture Vicinato</a>
			       -->
	 	         <a class="btn btn-social-icon btn-google" title='Esplora' href="/r3ng/shakeus/it/org/r3/home.do?shkaction=map">
    				<span class="fa fa-map-marker"></span>
  				 </a>
  
  	 	          <a href="javascript:void(0)" class="btn btn-social-icon btn-facebook timeline-action" data-timelineid='tuner' title='Timelines' >
    				<span class="fa fa-users"></span>
  				  </a>
  				 	
	 	          <a href="javascript:void(0)" class="btn btn-social-icon btn-twitter timeline-action" data-timelineid='news' title='Notizie' >
    				<span class="fa fa-newspaper-o"></span>
  				  </a>
  				 			      	 	          				    				 			     
                 			      		      
			    </div>
				</div>
				
                <div class='row'>
                <div class='col-md-3 hidden-sm hidden-xs' id="JSPortlet_RandomPhotoSideBar">
                
                </div>
                <!-- 
                <div class='col-md-3 col-sm-3'>
                <h4>Area Privata</h4>
                <ul class='list-unstyled'>
                <li>
                <i  style='display: inline-block; vertical-align: middle; width: 16px; height: 16px; background: url("/r3ng/resources/bootstrap/css/img/fb_icons.png") no-repeat 0 -692px'></i>                
                <div style='display: inline-block; vertical-align: middle; margin-left: 5px; cursor: pointer;'>
                Modifica profilo
                </div>                
                </li>                
                </ul>
                
                <h4>Vicinati Gemellati</h4>
                <h4>Attività commerciali</h4>
                
                </div> -->
                <div class='col-md-9 col-sm-12'>                
                <div id='jsportlet_startof_centerband' style="display: none"></div>                                
                <div id='jsportlet_mongo_timelinetuner'></div>
                <div id='jsportlet_mongo_timeline'></div>
                
                <div id='jsportlet_shk_timelinetuner'></div>
                <div id='jsportlet_shk_timeline'></div>
                <div id='jsportlet_endof_centerband' style="display: none"></div>
                </div>
                </div>
				
			</div>
			<div class='col-md-3 col-sm-3'>

				<div id="jsportlet_startof_rightband" ></div>				                
                <div id="JSPortlet_SiteMembers" class='site-members-portlet'></div>
				<div id="jsportlet_endof_rightband" ></div>

			</div>

		</div>

</r3_lang:environment>