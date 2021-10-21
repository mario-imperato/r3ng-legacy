<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
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

<div id="site_header" >

  <div class="iconic_menu_carousel" >
     <div id="iconic_menu_carousel_canvas" style="width: 800px; height: 210px" >

<%
  for( org.r3.db.cms.pageview.PageViewDTO pageDTO : listOfPages)
  {
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
     
      <div class="clearfix"></div>     
      <div class="pagination" id="iconic_menu_carousel_pagination"></div>
      
  </div>  
  
  <div style='border-top: 2px solid #7A94AB;' >
  <div id="breadcrumb_bar" class="cf layout1_centered_container" style="display: none"><div id="breadcrumbs"></div></div>   
  </div>

  <r3_lang:comment>
  <div id='social_bar' class='cf'>
    <div class='layout1_centered_container' >
    <div >
    <a href='https://www.facebook.com/pages/Circolo-Velico-Fiumicino/714928588568140' class='facebook'>Seguici su FaceBook</a>
    <a href='https://twitter.com/cvfiumicino' class='twitter'>Seguici su Twitter</a>    
    </div>
    </div>
  </div>
  </r3_lang:comment>
           
</div>
              
</r3_lang:environment>