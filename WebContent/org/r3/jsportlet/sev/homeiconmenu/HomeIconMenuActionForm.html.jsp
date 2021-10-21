<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*,
    org.r3.db.system.site.SiteDTO,
    org.r3.db.system.siteproperty.SitePropertyDTO
    " %>

<r3_lang:environment id="r3Env">

<%
  SiteDTO targetSite = r3Env.getRequestSite();
  SitePropertyDTO spDto = targetSite.getSiteProperties().getPropertyByPropertykey(SitePropertyDTO.UI_CFG_PKG, SitePropertyDTO.UI_CFG_MENUS);
  SitePropertyDTO spDto_menuitems = targetSite.getSiteProperties().getPropertyByPropertykey(SitePropertyDTO.UI_CFG_PKG, SitePropertyDTO.UI_CFG_MENUSITEMS);
  
  org.r3.db.cms.pageview.PageViewLUT pageViewLut = (org.r3.db.cms.pageview.PageViewLUT)
       org.r3.db.system.lut.LUTManager.getLUTManager().getLUT(org.r3.db.system.lut.LUTManager.LUTName.cms_page, r3Env.getRequestLanguage());
  
  org.r3.db.cms.pageview.PageViewLUTDTO sitePages = pageViewLut.getItem(targetSite.getSite(), r3Env.getRequestLanguage());
  
  java.util.List<org.r3.db.cms.pageview.PageViewDTO> listOfPages = sitePages.getPages();
%>

  <r3_lang:ifinclude include='<%=spDto.valueContains("iconmenu", null, null)%>'>
  <div class="iconic_menu_carousel">
     <div id="iconic_menu_carousel_canvas" style="width: 800px; height: 210px" >

<%
  for( org.r3.db.cms.pageview.PageViewDTO pageDTO : listOfPages)
  {
	  System.out.println("Reading Page: " + pageDTO.getDtokey());
	  if (pageDTO.isVisibleIn(org.r3.db.cms.page.PageDTO.PageVisibility.cmspg_iconmenu, r3Env.isGuest())  && r3Env.checkFunction(pageDTO.getPermissions()))
	  {
%>
        <div class="iconic_menu_carousel_item <%=pageDTO.getPagestyle()%>" >
          <a href='<%=pageDTO.getPagelink("/org/r3")%>' ><img src='<%=targetSite.getResourceAbslutePath(org.r3.db.system.site.SiteDTO.SiteResourceType.iconicmenu, pageDTO.getPageicon1())%>' alt="<%=pageDTO.getPagetitle()%>"  /></a>
          <div >
            <a href='<%=pageDTO.getPagelink("/org/r3")%>' style='padding: 0; margin: 0'><p><%=pageDTO.getPagetitle()%></p></a>
          </div>          
        </div>
<%
	  }
  }
%>
      </div>
     
      <div class="clearfix"></div>     
      <div class="iconic_menu_carousel_pagination" id="iconic_menu_carousel_pagination"></div>
      
  </div>
  </r3_lang:ifinclude>
  <!-- Fine Menu Iconico di Pagina -->

</r3_lang:environment>
  