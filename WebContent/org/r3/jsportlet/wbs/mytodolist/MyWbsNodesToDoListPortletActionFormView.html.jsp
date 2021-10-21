<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<div class="home_portlet">
<div class='title grade6'><i class="fa fa-user"></i> {%#o.dictionary.my_todo_list_title%}</div>

{%  
if (o.wbses && o.wbses.getNumberOfItems() > 0) { 
   for (var i = 0; i < o.wbses.getNumberOfItems(); i++) 
   {             
        var theWbsNode = o.wbses.getItem(i);         
%} 
<div class="wbsnode" id='{%=theWbsNode.dataBean.wbsnodeid%}' data-wbsid='{%=theWbsNode.dataBean.wbsid%}'>
<h3><a href='{%=org.r3.Constants.getStrutsActionContext()%}/org/r3/wbs/wbsfillout.do?pageid=wbses&wbsnodeid={%=theWbsNode.dataBean.wbsnodeid%}&wbsid={%=theWbsNode.dataBean.wbsid%}'>{%=theWbsNode.getNodeLabel(true)%}</a></h3>
<div class='row'>
<div class="col-md-8">	
<div class="wbsnode_info">
  {%#org.r3.db.wbs.wbsnode.message.startdate%}: {%=theWbsNode.getStartdate()%},
  {%#org.r3.db.wbs.wbsnode.message.enddate%}: {%=theWbsNode.getEnddate()%},
  {%#org.r3.db.wbs.wbsnode.message.duration%}: {%=theWbsNode.getDuration(true)%}
</div>   
<div class="wbsnode_info">
  {%#org.r3.db.wbs.wbsnode.message.completiondescr%}: {%=theWbsNode.getCompletionDescr()%},
  {%#org.r3.db.wbs.wbsnode.message.completiondate%}: {%=theWbsNode.getCompletionDate()%}
</div>   
<div class="wbsnode_info">
  {%#org.r3.db.wbs.wbsnode.message.economicvalue%}: {%=theWbsNode.getEconomicvalue()%},
  {%#org.r3.db.wbs.wbsnode.message.completioneffort%}: {%=theWbsNode.getCompletioneffort()%},
  {%#org.r3.db.wbs.wbsnode.message.completioneffortevalue%}: {%=theWbsNode.getCompletioneffortEValue()%},
  {%#org.r3.db.wbs.wbsnode.message.economicvalue2%}: {%=theWbsNode.getEconomicvalue2()%}
</div>   
</div>

<div class="col-md-4">
<div style='text-align: right;' class="{%=theWbsNode.getTemperatureClassForNode()%}">{%=theWbsNode.getCompletionAsPercentage()%}
   <div class="completion-bar-cnt " style='width: 100%'>
      <div class="completion-bar " style='width: {%=theWbsNode.getCompletionAsPercentage()%};'></div>
   </div> 
</div>	
</div>
</div>

<div class="wbsnode_summary">{%=theWbsNode.dataBean.nodesummary%}</div>
       
</div>

{%  } %}
{%  } %}


</div>

