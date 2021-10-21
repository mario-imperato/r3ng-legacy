<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.io.*,
    java.util.*,
    org.r3.db.system.site.SiteDTO,
    org.r3.db.system.siteproperty.SitePropertyDTO,
    org.r3.db.system.siteportletcfg.SitePortletConfigDTOCollection      
    "%>

<r3_lang:environment id="r3Env" namespace='org.r3.home.site'>

<%
  SiteDTO targetSite = r3Env.getRequestSite();  
  SitePortletConfigDTOCollection listOfPositions = targetSite.getPortletConfigCollection("home");
  // if (listOfPositions != null)
  //   System.out.println("HTML is " + listOfPositions.getPortletConfigByPositionId("22").getHTML4Position("22"));
%>

<!-- 
<div style="background-color: #DDDDDD; padding-left: 190px; min-height: 80px; padding-right: 10px; margin-bottom: 10px; background: url('/r3ng/sites/cvfxxxiiichamp/bandiera_cvf.png') no-repeat left center #DDDDDD">
<h1 style="color: #B41617; font-size: 1.6em; padding-top: 10px; margin-top: 0px"><a href='sev/ranking.do'>Sono Disponibili le Classifiche provvisorie</a></h1>
<p class="description">
  Sono state pubblicate le classifiche <b>provvisorie</b> delle prove effettuate. Possono essere consultate al link: 
  <a href='javascript:void(0)' onclick="window.open('sev/ranking.do')">Visualizza Classifiche</a>
</p>
</div>
 -->

<%
	boolean hasMenuCarousel = true;
%>

<r3_lang:ifinclude include="<%=hasMenuCarousel%>">
	<div id='JSPortlet_HomeIconMenuActionForm' class='page-heading' ></div>
</r3_lang:ifinclude>

 <div class='row'>
    <div class="col-md-12">
	<!-- [30] -->
	<div id="JSPPortlet_30" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("30").getHTML4Position("30", !r3Env.isGuest())%> ></div>
	</div>
</div>

<div class="row">
	<div class="col-md-6">						
		
		<!-- [00] Was. JSPortlet_HomeWelcomeActionForm -->
	    <div id="JSPPortlet_00" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("00").getHTML4Position("00", !r3Env.isGuest())%> ></div>
	    
	    <!-- [01] Was. JSPortlet_HomeComunicatiActionForm -->
		<div id="JSPPortlet_01" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("01").getHTML4Position("01", !r3Env.isGuest())%> ></div>

    	<!-- [02] Was. JSPortlet_HomeLoginActionForm -->
		<div id="JSPPortlet_02" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("02").getHTML4Position("02", !r3Env.isGuest())%> ></div>

        <!-- [03] Was. JSPortlet_HomeCalendarActionForm -->
		<div id="JSPPortlet_03" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("03").getHTML4Position("03", !r3Env.isGuest())%> ></div>
		
		<!-- [04] Was. JSPortlet_HomeNORActionForm -->
		<div id="JSPPortlet_04" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("04").getHTML4Position("04", !r3Env.isGuest())%> ></div>

        <!-- [05] -->
        <div id="JSPPortlet_05" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("05").getHTML4Position("05", !r3Env.isGuest())%> ></div>
        
        <!-- [06] -->
        <div id="JSPPortlet_06" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("06").getHTML4Position("06", !r3Env.isGuest())%> ></div>
        
        <!-- [07] -->
        <div id="JSPPortlet_07" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("07").getHTML4Position("07", !r3Env.isGuest())%> ></div>
        
        <!-- [08] -->
        <div id="JSPPortlet_08" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("08").getHTML4Position("08", !r3Env.isGuest())%> ></div>
        
        <!-- [09] -->
        <div id="JSPPortlet_09" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("09").getHTML4Position("09", !r3Env.isGuest())%> ></div>
        
	</div>

	<div
		class="col-md-6">
        
        <!-- [10] Was. JSPortlet_HomeChannelsActionForm -->
		<div id="JSPPortlet_10" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("10").getHTML4Position("10", !r3Env.isGuest())%> ></div>

        <!-- [11] Was. JSPortlet_HomeTrackerActionForm -->
		<div id="JSPPortlet_11" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("11").getHTML4Position("11", !r3Env.isGuest())%> ></div>	
		
		<!-- [12] Was. JSPortlet_HomeRankingActionForm -->		
		<div id="JSPPortlet_12" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("12").getHTML4Position("12", !r3Env.isGuest())%> ></div>

		<!-- [13] Was. JSPortlet_MyAppActionForm -->		
		<div id="JSPPortlet_13" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("13").getHTML4Position("13", !r3Env.isGuest())%> ></div>		
		
		<!-- [14] Was. JSPortlet_HomeEntryListActionForm -->				
		<div id="JSPPortlet_14" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("14").getHTML4Position("14", !r3Env.isGuest())%> ></div>

        <!-- [15] -->
		<div id="JSPPortlet_15" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("15").getHTML4Position("15", !r3Env.isGuest())%> ></div>
		
		<!-- [16] -->
		<div id="JSPPortlet_16" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("16").getHTML4Position("16", !r3Env.isGuest())%> ></div>
		
		<!-- [17] -->
		<div id="JSPPortlet_17" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("17").getHTML4Position("17", !r3Env.isGuest())%> ></div>
		
		<!-- [18] -->
		<div id="JSPPortlet_18" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("18").getHTML4Position("18", !r3Env.isGuest())%> ></div>
		
		<!-- [19] -->
		<div id="JSPPortlet_19" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("19").getHTML4Position("19", !r3Env.isGuest())%> ></div>
		
	</div>

</div>

<div class='row'>
<div class="col-md-12">
    <!-- [20] Was. JSPortlet_HomeYachtClubActionForm -->	
	<div id="JSPPortlet_20" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("20").getHTML4Position("20", !r3Env.isGuest())%> ></div>
	
	<!-- [21] -->
	<div id="JSPPortlet_21" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("21").getHTML4Position("21", !r3Env.isGuest())%> ></div>
	
	<!-- [22] -->
	<div id="JSPPortlet_22" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("22").getHTML4Position("22", !r3Env.isGuest())%> ></div>
	
    </div>
 </div>
 
 <div class='row'>
    <div class="col-md-12">
	<!-- [23] -->
	<div id="JSPPortlet_23" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("23").getHTML4Position("23", !r3Env.isGuest())%> ></div>
	
	<!-- [24] -->
	<div id="JSPPortlet_24" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("24").getHTML4Position("24", !r3Env.isGuest())%> ></div>
	
	<!-- [25] -->
	<div id="JSPPortlet_25" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("25").getHTML4Position("25", !r3Env.isGuest())%> ></div>
	
    </div>
 </div>
 
 <div class='row'>
    <div class="col-md-12">
	<!-- [26] -->
	<div id="JSPPortlet_26" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("26").getHTML4Position("26", !r3Env.isGuest())%> ></div>
	
	<!-- [27] -->
	<div id="JSPPortlet_27" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("27").getHTML4Position("27", !r3Env.isGuest())%> ></div>
	
	<!-- [28] -->
	<div id="JSPPortlet_28" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("28").getHTML4Position("28", !r3Env.isGuest())%> ></div>
	
	<!-- [29] -->
	<div id="JSPPortlet_29" style='margin: 10px' <%=listOfPositions.getPortletConfigByPositionId("29").getHTML4Position("29", !r3Env.isGuest())%> ></div>
</div>
</div>
</r3_lang:environment>