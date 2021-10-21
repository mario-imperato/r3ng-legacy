<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env">

  <div id="homecarouselview"></div>
  <div id="sponsorcarouselview" style='background-color: #dddddd'></div>

  <!-- background-color: #1B4E88; color: #F5EC37; border-top: 5px solid #7A94AB;  #373737 -->
  <div style="border-bottom: 5px solid #7A94AB;  background-color: #425AA2; box-shadow: 0 -1px 0 #555555;">
  <div class='cf list-inline' style='width: 960px; margin: 0 auto; height: 40px'>
  <ul class='home_header_menu'>
  <li><a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=veleria" />'>La Veleria</a></li>
  <li><a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=genoa" />'>Genoa</a></li>
  <li><a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=mainsail" />'>Rande</a></li>
  <li><a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=spi" />'>Vele Portanti</a></li>
  <li><a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=derive" />'>Derive e monotipi</a></li>
  <li><a href='<r3_lang:pathResolver path="/org/r3/cms/cmspage.do?pageid=accessories" />'>Accessori</a></li>
  </ul>
  </div>
  </div>
  
  <!--     
  <div class="html_carousel">
      <div id="foo2">
           
          <div class="slide">
              <img src="/r3ng/org/r3/home/yachtclubsite/banner_002_bw.jpg" alt="carousel 1" width="1690" height="524" />
              <div>
                 <div class='slide-caption' >
                  <h4>Circolo Velico Fiumicino</h4>
                  <p>Il Circolo Velico Fiumicino e' un'associazione sportiva senza fini di lucro basata su principi di solidarieta' ed aggregazione nello sviluppo delle attivita' veliche e degli sport nautici.</p>
                 </div>
              </div>
          </div>

          <div class="slide">
              <img src="/r3ng/org/r3/home/yachtclubsite/banner_001.jpg" alt="carousel 1" width="1690" height="524" />
              <div>
                 <div class='slide-caption'>
                  <h4>Circolo Velico Fiumicino</h4>
                  <p>Il Circolo Velico Fiumicino e' un'associazione sportiva senza fini di lucro basata su principi di solidarieta' ed aggregazione nello sviluppo delle attivita' veliche e degli sport nautici.</p>
                 </div>
              </div>
          </div>
      </div>
      <div class="clearfix"></div>
  </div>

   -->    
          
              
</r3_lang:environment>