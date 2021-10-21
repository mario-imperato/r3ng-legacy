<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<div class='wbs cmsCard'>
{%  
   var theWbs = o.wbs; 
   var theWbsNodes = theWbs.getListOfWbsNodes();  
   var wbsStatInfo = theWbs.collectWbsStatInfo();      
%} 

<h4 class='title' style='background-color: #cccccc; padding: 5px; color: #1b88bb;'>
{%=theWbs.dataBean.wbstitle%} 
<!--<div>Testo piccolino</div>-->
</h4>   

{%#theWbs.dataBean.wbstext%}

<div id='wbs_teamprofile'></div>

<div class="wbsnode">
{% if (theWbsNodes) { 
      for(var j = 0; j < theWbsNodes.length; j++) 
      {
         var wbsNode = theWbsNodes[j];
         
         %} 
         <h{%=(theWbsNodes[j].getNodeHSection())%}>{%=theWbsNodes[j].getNodeLabel(true)%}</h{%=(theWbsNodes[j].getNodeHSection())%}>
         
{%       if (wbsNode.isAction()) { %} 
         
         {% if (theWbs.isExecutiveOrCoach())  { %}
              <!-- <p style='color: #ff0000'>Current User Is Executive Or Coach</p> -->
         {% } %} 
                  
         {% if (theWbsNodes[j].isAssignee())  { %}
               <!-- <p style='color: #ff0000'>Current User Is Assignee</p> -->
         {% } %} 
         
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
{% 		 }   %}         
         
         <p>{%=theWbsNodes[j].dataBean.nodesummary%}</p>
         
         {% if (theWbsNodes[j].dataBean.nodetext) {    %}
         <p>{%#theWbsNodes[j].dataBean.nodetext%}</p>
{% 		 }   %}
                  
         {%      
      }
   }
%}

</div>

</div>


