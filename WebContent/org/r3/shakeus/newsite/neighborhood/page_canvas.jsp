<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.io.*,
    java.util.*
    "%>

<r3_lang:environment id="r3Env" namespace='org.r3.shakeus.newsite.neighborhood'>

<div style='min-height: 500px; padding: 10px;' >

<div class='row'>
<div class='col-md-3 hidden-sm hidden-xs'>

<figure class="bw" style='margin-bottom: 5px'>
<img src="/r3ng/org/r3/shakeus/newsite/neighborhood/new-profile-asd.png" style="width: 100%" />
</figure>

<div  id="JSPortlet_RandomPhotoSideBar"></div>

</div>

<div id='newsite_maincanvas' class='col-md-9 col-sm-12'> 

<div id='newsite_termsandconditions_actionform'></div>
<div id='newsite_siteinfo_actionform'></div>
<div id='newsite_siterequestaccepted_actionform'></div>

</div>
</div>

</div>

</r3_lang:environment>