<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00"     prefix="r3_lang" %>

<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<%@ page language="java" session="false"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,    
    java.util.*,
    org.r3.db.system.site.SiteDTO,
    org.r3.db.system.siteproperty.SitePropertyDTO,
    org.r3.db.mongo.filecollection.*
    " %>

<r3_lang:environment id="r3Env">

<tiles:useAttribute id="windowLayout_cssprofile" ignore="true" name="windowLayout_cssprofile" classname="java.lang.String" />

<%
  SiteDTO targetSite = r3Env.getRequestSite();
  SitePropertyDTO spDto = targetSite.getSiteProperties().getPropertyByPropertykey(SitePropertyDTO.UI_CFG_PKG, SitePropertyDTO.UI_CFG_MENUS);
  SitePropertyDTO spDto_menuitems = targetSite.getSiteProperties().getPropertyByPropertykey(SitePropertyDTO.UI_CFG_PKG, SitePropertyDTO.UI_CFG_MENUSITEMS);

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

  String siteBanner = targetSite.getCMSPropertyValueAsURL(targetSite.getSite(), "it", "site_banner", null);
  if (siteBanner == null)
 	  siteBanner = new StringBuilder().append("/r3ng/resources/sites/").append(targetSite.getSiteresourcepath()).append("/top_banner.png").toString();

  String siteResourcePathStyleSheet = "/resources/sites/" + targetSite.getSiteresourcepath() + "/site_style.css";

%>

   <nav class="navbar navbar-static-top">
      <div class="container-fluid">
        <div class="navbar-header">
       <!-- 
            padding-left: 60px;
    background: url(/r3ng/was/shakeus/it/userscollection/root/photo;photorole=icon) top left no-repeat;
    background-size: 50px 50px;
    -->
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
       
<%
  int numberOfAreasEnabled = 0;
  if (listOfPages != null)
  {
  for( org.r3.db.cms.pageview.PageViewDTO pageDTO : listOfPages)
  {
	
    if (pageDTO.isVisibleIn(org.r3.db.cms.page.PageDTO.PageVisibility.cmspg_txtmenu, r3Env.isGuest())  && r3Env.checkFunction(pageDTO.getPermissions()))
    {
    	numberOfAreasEnabled++;
    	if (numberOfAreasEnabled == 1)
    	{
%>  
<li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"">
              <i class="fa fa-bars"></i>
              
            </a>
            <ul class="dropdown-menu">
            

<%    		
    	}
%>
        <li><a href='<r3_lang:pathResolver path="<%=pageDTO.getPagelink()%>" />'><%=pageDTO.getPagetitle()%></a></li>
<%
    }
  }
  }
  
  if (numberOfAreasEnabled > 0)
	{
%>  </ul></li> <%    		
	}
	
%>          
       
          <r3_lang:ifinrole allowRoles="shkadmin,shkowner" allowFunctions="console">           
		  <li>
            <a href='<r3_lang:pathResolver path="/org/r3/console/home.do" />' ><i class="fa fa-gears"></i></a>
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
                  <!-- L'override sul dominio mi crea problemi in quanto mi cambia stile overrideSite='<%=targetSite.getSitedomain()%>' -->
                  <a href='<r3_lang:pathResolver path="/org/r3/user/myr3.do" />' class="btn btn-default btn-flat">Profilo</a>
                </div>
                <div class="pull-right">
                  <a href="javascript:void(0)" class="btn btn-default btn-flat" id="pageAction_logOut">Esci</a>
                </div>
              </li>
            </ul>
          </li>
          </r3_lang:ifinclude>                

      </ul>          
        
      </div>
    </nav>
        
             

</r3_lang:environment>
