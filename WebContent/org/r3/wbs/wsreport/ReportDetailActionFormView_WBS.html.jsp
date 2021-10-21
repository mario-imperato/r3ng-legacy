<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

{%  
   var isPrinted = o.isPrinted; 
 %}

{%  if (!isPrinted)  {  %}        

<div class="action-bar cf unprintable" style="border-top: 0px; margin-bottom: 0px; margin-top: 0px">
    <button type="button" id="reportdetailactionform_action_printable" class="btn btn-primary" style="margin-top: 5px">
          <span>{%#org.r3.message.action_printable_version%}</span>
    </button>        
</div>

{%  } %}                

<div class='wbs cmsCard'>
{%  
   var theWbs = o.wbs; 
   var theWbsNodes = theWbs.getListOfWbsNodes();
   
    if (theWbs.isExecutiveOrCoach())   {  %}
         <!-- <p style='color: #ff0000'>Current User Is Executive Or Coach</p> -->
{%  } %} 

 <h4 class='title' style='background-color: #cccccc; padding: 5px; color: #1b88bb;'>
{%=theWbs.dataBean.wbstitle%}
  </h4>

{%#theWbs.dataBean.wbstext%}


{% if (o.isPrinted) { %}
<div id='wbs_{%=theWbs.dataBean.wbsid%}_dashboard_printed' ></div>
{% } else { %}
<div id='wbs_{%=theWbs.dataBean.wbsid%}_dashboard' ></div>
{% } %}


<div class="wbsnode">
{% if (theWbsNodes) { 
      for(var j = 0; j < theWbsNodes.length; j++) {
         var wbsNode = theWbsNodes[j];                 
         
         if (wbsNode.isAssignee())  { %}
         <!-- <p style='color: #ff0000'>Current User Is Assignee</p> -->
{% 		 } 
         
         if (wbsNode.isAction()) { %} 
                  
         <h{%=(wbsNode.getNodeHSection())%}>{%=wbsNode.getNodeLabel(true)%}</h{%=(wbsNode.getNodeHSection())%}>
         
         <div class='row'>
           <div class="col-md-9">

         <div class="wbsnode_info">
            {%#org.r3.db.wbs.wbsnode.message.startdate%}: {%=wbsNode.getStartdate()%},
            {%#org.r3.db.wbs.wbsnode.message.enddate%}: {%=wbsNode.getEnddate()%},
            {%#org.r3.db.wbs.wbsnode.message.duration%}: {%=wbsNode.getDuration(true)%}
         </div>   

{% if (wbsNode.isAssignee() || theWbs.isExecutiveOrCoach())  { %}

         <div class="wbsnode_info">
            {%#org.r3.db.wbs.wbsnode.message.completiondescr%}: {%=wbsNode.getCompletionDescr()%},
            {%#org.r3.db.wbs.wbsnode.message.completiondate%}: {%=wbsNode.getCompletionDate()%}
         </div>   

         <div class="wbsnode_info">
 			{%#org.r3.db.wbs.wbsnode.message.economicvalue%}: {%=wbsNode.getEconomicvalue()%},
  			{%#org.r3.db.wbs.wbsnode.message.completioneffort%}: {%=wbsNode.getCompletioneffort()%}
  			{%#org.r3.db.wbs.wbsnode.message.completioneffortevalue%}: {%=wbsNode.getCompletioneffortEValue()%},
  			{%#org.r3.db.wbs.wbsnode.message.economicvalue2%}: {%=wbsNode.getEconomicvalue2()%}
         </div>

{% 		 }   %}
           
           </div>
           <div class="col-md-3">
 {% if (wbsNode.isAssignee() || theWbs.isExecutiveOrCoach())  { %}         
         
         <div class="{%=wbsNode.getTemperatureClassForNode()%}" style='font-size: 1.2em'>{%=wbsNode.getCompletionAsPercentage()%}
          <div class="completion-bar-cnt " style='width: 100%'>
             <div class="completion-bar " style='width: {%=wbsNode.getCompletionAsPercentage()%};'></div>
          </div>           
         </div>
         {% if (wbsNode.getROI()) { %}
         <div style='color: #777777; font-size: 1.2em; padding: 5px'>ROI: {%=wbsNode.getROI()%}</div>
         {% } %}

{%    }  %}
           </div>
         </div>         
                                     
{%    }
      else
      {  %}  
         <h{%=(wbsNode.getNodeHSection())%}>{%=wbsNode.getNodeLabel(true)%}</h{%=(wbsNode.getNodeHSection())%}>      
{%    }  %}
 
      <div class="wbsnode_summary">{%=wbsNode.dataBean.nodesummary%}</div>
      {% if (wbsNode.dataBean.nodetext) { %}
          <div class="wbsnode_summary">{%#wbsNode.dataBean.nodetext%}</div>
      {% }      
      
      }
   }
%}

</div>

</div>


