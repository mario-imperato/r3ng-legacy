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
%>

<div class='cf' style='width: 960px; margin: 0 auto; margin-top: 20px; '>

<div style='float:left; min-height: 100px; width: 670px; margin-right: 10px; padding: 0px; '>
    
  <div style='margin-bottom: 15px;'>

  <div id='home_splash'></div>
  			
  <h3 class='actionable grade6' style='margin-top: 0px'><a href='cms/cmspage.do?pageid=articles'><i class="fa fa-file-o"></i> Articoli</a></h3>  
  <div id='homearticles'></div>  
  </div>

</div>
 
<div style='float:left; width: 268px; margin-left: 10px;'>  

<div id="site_header" >

  <div class="iconic_menu_carousel" style='padding: 0; padding-left: 15px; background-color: #ffffff'>
     <div id="iconic_menu_carousel_canvas"  >
  
        <div class="iconic_menu_carousel_item grade6" style='margin: 5px'>
          <a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=veleria" />' ><img src="/r3ng/resources/sites/<%=targetSite.getSiteresourcepath()%>/menu/veleria.jpg" alt="La Veleria"  /></a>
          <div >            
            <a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=veleria" />' style='padding: 0; margin: 0'><p>La Veleria</p></a>
          </div>          
        </div>
        
        <div class="iconic_menu_carousel_item grade6" style='margin: 5px'>
          <a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=genoa" />' ><img src="/r3ng/resources/sites/<%=targetSite.getSiteresourcepath()%>/menu/genoa.jpg" alt="Genoa"  /></a>
          <div >            
            <a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=genoa" />' style='padding: 0; margin: 0'><p>Genoa</p></a>
          </div>          
        </div>
        
        <div class="iconic_menu_carousel_item grade6" style='margin: 5px'>
          <a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=mainsail" />' ><img src="/r3ng/resources/sites/<%=targetSite.getSiteresourcepath()%>/menu/rande.jpg" alt="Rande"  /></a>
          <div >            
            <a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=mainsail" />' style='padding: 0; margin: 0'><p>Rande</p></a>
          </div>          
        </div>

        <div class="iconic_menu_carousel_item grade6" style='margin: 5px'>
          <a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=spi" />' ><img src="/r3ng/resources/sites/<%=targetSite.getSiteresourcepath()%>/menu/spi.jpg" alt="Vele Portanti"  /></a>
          <div >            
            <a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=spi" />' style='padding: 0; margin: 0'><p>Vele Portanti</p></a>
          </div>          
        </div>

        <div class="iconic_menu_carousel_item grade6" style='margin: 5px'>
          <a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=derive" />' ><img src="/r3ng/resources/sites/<%=targetSite.getSiteresourcepath()%>/menu/derive.jpg" alt="Derive e Monotipi"  /></a>
          <div >            
            <a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=derive" />' style='padding: 0; margin: 0'><p>Derive e Monotipi</p></a>
          </div>          
        </div>

        <div class="iconic_menu_carousel_item grade6" style='margin: 5px'>
          <a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=accessories" />' ><img src="/r3ng/resources/sites/<%=targetSite.getSiteresourcepath()%>/menu/accessori.jpg" alt="Accessori"  /></a>
          <div >            
            <a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=accessories" />' style='padding: 0; margin: 0'><p>Accessori</p></a>
          </div>          
        </div>
                 
      </div>
     
      <div class="clearfix"></div>     
      <div class="pagination" id="iconic_menu_carousel_pagination"></div>
      
  </div>  
             
</div>

<div id='JSPortlet_HomeChannelsActionForm' style='margin-bottom: 10px; background-color: #eeeeff; border: 1px solid #dddddd; display: none'></div>

</div>

</div>
            
</r3_lang:environment>