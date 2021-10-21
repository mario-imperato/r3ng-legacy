<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*,
    org.r3.db.system.site.SiteDTO
    " %>

<r3_lang:environment id="r3Env">

<%
  SiteDTO targetSite = r3Env.getRequestSite();

  org.r3.db.cms.pageview.PageViewLUT pageViewLut = (org.r3.db.cms.pageview.PageViewLUT)
  org.r3.db.system.lut.LUTManager.getLUTManager().getLUT(org.r3.db.system.lut.LUTManager.LUTName.cms_page, r3Env.getRequestLanguage());

  org.r3.db.cms.pageview.PageViewLUTDTO sitePages = pageViewLut.getItem(targetSite.getSite(), r3Env.getRequestLanguage());

 java.util.List<org.r3.db.cms.pageview.PageViewDTO> listOfPages = sitePages.getPages();

%>

  <!-- Fixed navbar -->
  <nav class="navbar navbar-inverse navbar-fixed-top" >
      <div class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            
            <!-- Tende a sfondare.. 
            <a class="navbar-brand" href="#"><%=targetSite.getSitedescr()%></a>
             -->
             
          </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class='nav navbar-nav'>  
<%
  for( org.r3.db.cms.pageview.PageViewDTO pageDTO : listOfPages)
  {
    if (pageDTO.isVisibleIn(org.r3.db.cms.page.PageDTO.PageVisibility.cmspg_txtmenu, r3Env.isGuest())  && r3Env.checkFunction(pageDTO.getPermissions()))
    {
%>
        <li><a href='<r3_lang:pathResolver path="<%=pageDTO.getPagelink()%>" />'><%=pageDTO.getPagetitle()%></a></li>  
<%
    }
  }
%>    
          </ul>
  
        </div><!--/.nav-collapse -->
      </div>
  </nav>

<div id="site_header" >
  
  <div class="container">
  <div class="iconic_menu_carousel hidden-xs hidden-sm" >
     <div id="iconic_menu_carousel_canvas" style="width: 800px; height: 210px" >
  
  <%
  for( org.r3.db.cms.pageview.PageViewDTO pageDTO : listOfPages)
  {
	  System.out.println("Reading Page: " + pageDTO.getDtokey());
	  if (pageDTO.isVisibleIn(org.r3.db.cms.page.PageDTO.PageVisibility.cmspg_iconmenu, r3Env.isGuest()) && r3Env.checkFunction(pageDTO.getPermissions()))
	  {
%>
        <div class="iconic_menu_carousel_item <%=pageDTO.getPagestyle()%>" >
          <a href='<r3_lang:pathResolver path="<%=pageDTO.getPagelink()%>" />' ><img src='<%=targetSite.getResourceAbslutePath(org.r3.db.system.site.SiteDTO.SiteResourceType.iconicmenu, pageDTO.getPageicon1())%>' alt="<%=pageDTO.getPagetitle()%>"  /></a>
          <div >
            <a href='<r3_lang:pathResolver path="<%=pageDTO.getPagelink()%>" />' style='padding: 0; margin: 0'><p><%=pageDTO.getPagetitle()%></p></a>
          </div>          
        </div>
<%
	  }
  }
%>
                 
      </div>
     
      <!-- <div class="clearfix"></div>-->   
      <div class="iconic_menu_carousel_pagination" id="iconic_menu_carousel_pagination"></div>
      
  </div>        

  </div>    
    
  <div style='border-top: 2px solid #7A94AB;' >
  <div id="breadcrumb_bar" class="container" style="display: none"><div id="breadcrumbs"></div></div>   
  </div>

  <div id='social_bar' >
    <div class='container' >
    <div >
    <a href='https://www.facebook.com/pages/Circolo-Velico-Fiumicino/714928588568140' class='facebook'>Seguici su FaceBook</a>
    <a href='https://twitter.com/cvfiumicino' class='twitter'>Seguici su Twitter</a>
    <!-- 
    <a href='http://youtube.com' class='youtube'>Seguici su YouTube</a>
     -->    
    </div>
    </div>
  </div>
           
</div>
              
</r3_lang:environment>