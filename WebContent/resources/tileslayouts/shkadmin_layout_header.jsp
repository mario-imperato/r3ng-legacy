<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00"     prefix="r3_lang" %>

<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<%@ page language="java" session="false"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,    
    java.util.*,
    org.r3.db.system.site.SiteDTO,
    org.r3.db.mongo.filecollection.*
    " %>

<r3_lang:environment id="r3Env">

<tiles:useAttribute id="windowLayout_cssprofile" ignore="true" name="windowLayout_cssprofile" classname="java.lang.String" />

<%
  SiteDTO targetSite = r3Env.getRequestSite();

  boolean gsidebarEnabled = true;

  org.r3.db.cms.pageview.PageViewLUT pageViewLut = (org.r3.db.cms.pageview.PageViewLUT)
  org.r3.db.system.lut.LUTManager.getLUTManager().getLUT(org.r3.db.system.lut.LUTManager.LUTName.cms_page, r3Env.getRequestLanguage());

  org.r3.db.cms.pageview.PageViewLUTDTO sitePages = pageViewLut.getItem(targetSite.getSite(), r3Env.getRequestLanguage()); 
  
  java.util.List<org.r3.db.cms.pageview.PageViewDTO> listOfPages = null;  
  
  if (sitePages != null)
      listOfPages = sitePages.getPages();  
  

  String userPhotoUrl = "/org/r3/home/shakeus/icon-squared.png";
  
  String userPhotoIcon = "/org/r3/home/shakeus/icon-squared.png";
  String userPhotoImage = "/org/r3/home/shakeus/icon-squared.png";
  String sitePhoto = "/org/r3/home/shakeus/icon-squared.png";
  
  if (org.r3.db.PersistenceContext.getPersistenceContext().isMongoDbAvailable())
  {
	  org.r3.db.mongo.usercollection.UserCollectionDTO userCollectionDTO = r3Env.getUserCollectionDTO();
	  if (userCollectionDTO != null)
	  {
		  userPhotoUrl = "/was/" + targetSite.getSite() + "/it/userscollection/" +  userCollectionDTO.getUserid() + "/photo;photorole=icon";
		  
		  String s = userCollectionDTO.getPhotoUrl4Icon();
		  if ( s!=null )
			  userPhotoIcon = FileCollectionUrl.getRestUrl(r3Env.getRequestSiteId(), r3Env.getRequestLanguage(), s);
		  
		  s = userCollectionDTO.getPhotoUrl4Image();
		  if ( s!=null )
			  userPhotoImage = FileCollectionUrl.getRestUrl(r3Env.getRequestSiteId(), r3Env.getRequestLanguage(), s);
		  
	  }
	  sitePhoto = "/was/" + targetSite.getSite() + "/it/sitecollection/" + targetSite.getSite() + "/graphics/sitesquared;imagerole=icon";
  }

%>

  <!-- Logo -->
  <a href='<r3_lang:pathResolver path="/org/r3/home.do" />' class="logo" style="padding-left: 0">
   
    <!-- <span class="logo-mini"><i class="fa fa-home "></i></span> -->
    <span class="logo-mini"
          style="background: url('<r3_lang:pathResolver path="<%=sitePhoto%>" />') no-repeat top left; background-size: 50px 50px; height: 65px; margin-left: 0px;"></span>
          
    <span class="logo-lg" 
          style="background: url('<r3_lang:pathResolver path="<%=sitePhoto%>" />') no-repeat; background-size: auto 50px; padding-left: 60px;">
             <%=targetSite.getSitedescr()%></span>
  </a>
        
    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
      
      <!-- Sidebar toggle button-->
      <r3_lang:ifinclude include='<%=gsidebarEnabled%>'>
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      </r3_lang:ifinclude>
      
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
      <ul class='nav navbar-nav pull-right '>    
                             
          <r3_lang:ifinclude include="<%=!r3Env.isGuest()%>">
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src='<r3_lang:pathResolver path="<%=userPhotoUrl%>" />' class="user-image" alt="User Image">                                      
              <!-- <img src="<%=userPhotoIcon%>" class="user-image" alt="User Image">  -->
              <span class="hidden-xs"><%=r3Env.getUsername()%></span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src='<r3_lang:pathResolver path="<%=userPhotoUrl%>" />' class="img-circle" alt="User Image">

                <p>
                  <%=r3Env.getUsername()%>
                  <!-- <small>Member since Nov. 2012</small>  -->
                </p>
              </li>
              <!-- Menu Body -->
              <!--                 
              <li class="user-body">
				<div class="row">
                  <div class="col-xs-4 text-center">
                    <a href="#">Followers</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Sales</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Friends</a>
                  </div>
                </div>                
              </li>
              -->
                
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href='<r3_lang:pathResolver path="/org/r3/user/myr3.do" overrideSite='<%=targetSite.getAdmrefsite()%>' />' class="btn btn-default btn-flat">Profilo</a>
                </div>
                <div class="pull-right">
                  <a href="javascript:void(0)" class="btn btn-default btn-flat" id="pageAction_logOut">Esci</a>
                </div>
              </li>
            </ul>
          </li>
          </r3_lang:ifinclude>
          </ul>          
          
        <!-- BOF LoginForm --> 
        <r3_lang:ifinclude include="<%=r3Env.isGuest()%>"> 
        <div>                  
		<form id='loginform_form' class="navbar-form navbar-left hidden-xs ">
		<div class='loginform_mainsection'>
		<div class="form-group">
			<div class="input-group">							    
			    <span class="input-group-addon">
			        <i class="fa fa-user"></i>
			    </span>
			    <input type="text" class="form-control" name='nickname' id='loginform_form_nickname'  maxlength='60' />
			</div>
			
		</div>
		<div class="form-group">
			<div class="input-group">							    
			    <span class="input-group-addon">
			        <i class="fa fa-key"></i>
			    </span>
			    <input type="password" class="form-control" name='password' id="loginform_form_password" maxlength='10'/>
			</div>

		</div>			
        </div> 
		</form>
		</div>
		</r3_lang:ifinclude>
        <!-- EOF LoginForm --> 

    
      </div>
    </nav>
        
        <!--    
    <div id="breadcrumb_bar" class="hidden-print clearfix" style="display: none; width: 100%; background-color: #cccccc;">
    <div id="breadcrumbs">
    </div>
     </div>
     -->

</r3_lang:environment>
