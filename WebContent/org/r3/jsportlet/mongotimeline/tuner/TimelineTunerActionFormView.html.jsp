<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	import="java.io.*,
    java.util.*
    "%>


{% if (o.timelines && o.timelines.aaData.length)  { %}
<div class="box box-widget">
<div class="box-body">

 <div class='row'>
 <div class='col-md-12'>
 <div class="form-group">
   <select name="timelineid" class="form-control" id="timelinetuner_timelineid" >
{%
    for(var i = 0; i < o.timelines.aaData.length; i++) {
%}       
     <option value="{%=o.timelines.aaData[i].timelineid%}" >{%=o.timelines.aaData[i].title%}</option>
{%
    }
%}       
   </select>           
 </div>
 <p style="padding-left: 5px; padding-right: 5px;" id="timelinetuner_timelinedescription"></p>
 </div>
 
 <div class='col-md-12'>
 <ul class="nav nav-pills red  pull-right" role="tablist"> 
 <li role="presentation" class="active"><a href="#" id="timelinetuner_refreshtimeline_action" data-action='refresh:timeline'><span><i class="fa fa-refresh" ></i></span></a></li> 

 <li role="presentation" class="dropdown" id="timelinetuner_newprimarypost_action"> 
    <a href="#" class="dropdown-toggle" id="drop4" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Nuovo Messaggio <span class="caret"></span></a> 

    <ul class="dropdown-menu" id="menu1" aria-labelledby="drop4"> 
    
    </ul> 
  </li> 
</ul>

    <!--

 <div class="action-bar" id='timelinetuner_timeline_actionbar'>
    <button type="button" id="timelinetuner_refreshtimeline_action" data-action='refresh:timeline' class="btn btn-default" style="margin-top: 5px">
      <span><i class="fa fa-refresh" ></i></span>
    </button>   
   
    <button type="button" id="timelinetuner_newprimarypost_action" data-action='newprimary:timeline' class="btn btn-default" style="margin-top: 5px">
      <span>Nuovo Messaggio</span>
    </button> 
                                                           
 </div>
 </div>
    -->     
 
<!-- <div style='border-top: 1px solid #f0f0f0; padding: 0px 10px 10px 10px'></div>  -->

</div> 

</div>
</div>
{% } %}




