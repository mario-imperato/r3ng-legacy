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

  boolean gsidebarEnabled = false;

  org.r3.db.cms.pageview.PageViewLUT pageViewLut = (org.r3.db.cms.pageview.PageViewLUT)
  org.r3.db.system.lut.LUTManager.getLUTManager().getLUT(org.r3.db.system.lut.LUTManager.LUTName.cms_page, r3Env.getRequestLanguage());

  org.r3.db.cms.pageview.PageViewLUTDTO sitePages = pageViewLut.getItem(targetSite.getSite(), r3Env.getRequestLanguage()); 
  
  java.util.List<org.r3.db.cms.pageview.PageViewDTO> listOfPages = null;  
  
  if (sitePages != null)
      listOfPages = sitePages.getPages();  
  

  /*
   * userPhotoUrl viene tolto r3ng in quanto se no viene appeso due volte
   */
  String userPhotoUrl = "/org/r3/home/shakeus/icon-squared.png";
  
  String userPhotoIcon = "/org/r3/home/shakeus/icon-squared.png";
  String userPhotoImage = "/org/r3/home/shakeus/icon-squared.png";
  org.r3.db.mongo.usercollection.UserCollectionDTO userCollectionDTO = r3Env.getUserCollectionDTO();
  if (userCollectionDTO != null)
  {
	  userPhotoUrl = "/was/" +  targetSite.getSite() + "/it/userscollection/" +  userCollectionDTO.getUserid() + "/photo;photorole=icon";
	  
	  String s = userCollectionDTO.getPhotoUrl4Icon();
	  if ( s!=null )
		  userPhotoIcon = FileCollectionUrl.getRestUrl(r3Env.getRequestSiteId(), r3Env.getRequestLanguage(), s);
	  
	  s = userCollectionDTO.getPhotoUrl4Image();
	  if ( s!=null )
		  userPhotoImage = FileCollectionUrl.getRestUrl(r3Env.getRequestSiteId(), r3Env.getRequestLanguage(), s);
	  
  }
  
  String sitePhoto = "/was/" + targetSite.getSite() + "/it/sitecollection/" + targetSite.getSite() + "/graphics/sitesquared;imagerole=icon";
%>

   <nav class="navbar navbar-static-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <a href='<r3_lang:pathResolver path="/org/r3/home.do" />' class="navbar-brand"><b><%=targetSite.getSitedescr()%></b></a>
        </div>

	  <!-- Navigazione a sinistra. Su small device tende a sparire. -->
	  <div class="collapse navbar-collapse pull-left" id="navbar-collapse">
	  <ul class="nav navbar-nav">

	  </ul>
	  </div>

      	                  
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu" style='right: 0px'>
      <ul class='nav navbar-nav'>    
                  
          <r3_lang:ifinrole allowRoles="shkadmin,shkowner">           
		  <li>
            <a href='<r3_lang:pathResolver path="/org/r3/shkadmin/home.do" />' ><i class="fa fa-gears"></i></a>
          </li>
          </r3_lang:ifinrole>
                               
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
                
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <!--  In questo caso eseguo l'override in quanto l'immagine dell'utente mi viene messa nel posto sbagliato. -->
                  <a href='<r3_lang:pathResolver path="/org/r3/user/myr3.do" overrideSite='<%=targetSite.getSitedomain()%>' />' class="btn btn-default btn-flat">Profilo</a>
                </div>
                <div class="pull-right">
                  <a href="javascript:void(0)" class="btn btn-default btn-flat" id="pageAction_logOut">Esci</a>
                </div>
              </li>
            </ul>
          </li>
          </r3_lang:ifinclude>

        <!-- BOF LoginForm --> 
        <r3_lang:ifinclude include="<%=r3Env.isGuest()%>"> 
		<li>
                 
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
		</li>
		</r3_lang:ifinclude>
        <!-- EOF LoginForm --> 

          </ul>          
          

    
      </div>
    </nav>
        
             

</r3_lang:environment>
