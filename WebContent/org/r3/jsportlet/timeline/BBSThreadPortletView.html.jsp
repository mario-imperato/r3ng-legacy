<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>


<a id="jsportlettimelineform_newprimarypost_anchor" ></a>

<h4 id='bbsthreadportletviewactionform_threadtitle'>{%#org.r3.jsportlet.timeline.message.thread_name%}</h4>

<div id='jsportlettimelineform_newprimarypost_actionbar'>    
    <div class="action-bar">
        <button type="button" id="jsportlettimelineform_newprimarypost_action" class="btn btn-default" style="margin-top: 5px">
          <span>{%=o.threadProfile.getLabels().newPost%}</span>
        </button>                                                             
    </div>
</div>

<div id="jsportlettimelineform_newprimarypost_canvas" style='display: none'>
<div class="panel panel-grade1 timelinepost">
	<div class="panel-heading" style='background-color: #fcfcfc'>

		<figure>
			<img src="/r3ng/resources/sites/cvfxxxvchamp/icon-squared.png">
		</figure>

		<span class="date">{%#$.r3Utils.formatDateAsBadge()%}</span>

		<h4 class="title">{%=org.r3.PageManager.userInfo.getUserFullname()%}</h4>
		<span class="moment">{%=org.r3.message.no_second_ago%}</span>

	</div>

	<div class="panel-body">	
	<div id="jsportlettimelineform_primarypost_formtemplate" ></div>  		  
    </div>
</div>
</div>    


 
<!-- <div id='bbsthreadportletviewactionform_threadposts_summary' style="color: #ff0000"></div>  -->
<div id='bbsthreadportletviewactionform_threadposts_cnt' ></div>
<div id='loadMoreContentProgress' class='text-center' style='display: none'><i class="fa fa-spinner fa-spin fa-3x"></i></div>
 
<div id="jsportlettimelineform_childpost_formtemplate" style='display: none'></div> 
