<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env">

<script id="template-bbsthreadportletviewactionform_cimbarco_contentrenderer" type="text/x-tmpl">
  			    	
<div >

<table class="xbbcode-table">
 <tbody><tr class="xbbcode-tr"><td class="xbbcode-td"><span class="xbbcode-b">Ruolo</span></td><td class="xbbcode-td">{%=o.crewroletext%}</td><td class="xbbcode-td"><span class="xbbcode-b">&nbsp;</span></td><td class="xbbcode-td">&nbsp;</td></tr>
 <tr class="xbbcode-tr"><td class="xbbcode-td"><span class="xbbcode-b">Livello</span></td><td class="xbbcode-td">{%=o.crewleveltext%}</td><td class="xbbcode-td"><span class="xbbcode-b">&nbsp;</span></td><td class="xbbcode-td">&nbsp;</td></tr>
 <tr class="xbbcode-tr"><td class="xbbcode-td"><span class="xbbcode-b">Nominativo</span></td><td class="xbbcode-td">{%=o.crewname%}</td><td class="xbbcode-td"><span class="xbbcode-b">Peso</span></td><td class="xbbcode-td">{%=o.crewweight%}</td></tr>
 <tr class="xbbcode-tr"><td class="xbbcode-td"><span class="xbbcode-b">E-mail</span></td><td class="xbbcode-td">{%=o.crewemail%}</td><td class="xbbcode-td"><span class="xbbcode-b">Altezza</span></td><td class="xbbcode-td">{%=o.crewheight%}</td></tr>
 <tr class="xbbcode-tr"><td class="xbbcode-td"><span class="xbbcode-b">Telefono</span></td><td class="xbbcode-td">{%=o.crewphone%}</td><td class="xbbcode-td"><span class="xbbcode-b">Eta'</span></td><td class="xbbcode-td">{%=o.crewage%}</td></tr>
</tbody></table>

<div style="padding: 10px" >
{%=o.crewinfo%}     			    	
</div>

</div>

</script>

<script id="template-bbsthreadportletviewactionform_oimbarco_contentrenderer" type="text/x-tmpl">
  			    	
<div >

<table class="xbbcode-table">
 <tbody><tr class="xbbcode-tr"><td class="xbbcode-td"><span class="xbbcode-b">Ruolo</span></td><td class="xbbcode-td">{%=o.crewroletext%}</td><td class="xbbcode-td"><span class="xbbcode-b">&nbsp;</span></td><td class="xbbcode-td">&nbsp;</td></tr>
 <tr class="xbbcode-tr"><td class="xbbcode-td"><span class="xbbcode-b">Livello</span></td><td class="xbbcode-td">{%=o.crewleveltext%}</td><td class="xbbcode-td"><span class="xbbcode-b">&nbsp;</span></td><td class="xbbcode-td">&nbsp;</td></tr>
 <tr class="xbbcode-tr"><td class="xbbcode-td"><span class="xbbcode-b">Nominativo</span></td><td class="xbbcode-td">{%=o.ownername%}</td><td class="xbbcode-td"><span class="xbbcode-b">Barca</span></td><td class="xbbcode-td">{%=o.yachtname%}</td></tr>
 <tr class="xbbcode-tr"><td class="xbbcode-td"><span class="xbbcode-b">E-mail</span></td><td class="xbbcode-td">{%=o.owneremail%}</td><td class="xbbcode-td"><span class="xbbcode-b">Modello</span></td><td class="xbbcode-td">{%=o.yachtmodel%}</td></tr>
 <tr class="xbbcode-tr"><td class="xbbcode-td"><span class="xbbcode-b">Telefono</span></td><td class="xbbcode-td">{%=o.ownerphone%}</td><td class="xbbcode-td"><span class="xbbcode-b">&nbsp;</span></td><td class="xbbcode-td">&nbsp;</td></tr>
</tbody></table>

<div style="padding: 10px" >
{%=o.yachtinfo%}     			    	
</div>

</div>

</script>



<script id="template-bbsthreadportletviewactionform_postinforenderer" type="text/x-tmpl">
  			    	
     <span class="title">{%=o.post.dataBean.nodetitle%}</span>
     <span class="annotator">{%=o.post.getUsername()%}</span>
     <span class="date">{%=o.post.getCreationdate()%}</span>

</script>

<script id="template-bbsthreadportletviewactionform" type="text/x-tmpl">

<div class="comment-wrapper" id="thn_{%=o.post.dataBean.threadnodeid%}">
  <div class="comment">
  <div class="info" data-action='open-close'>     
     <span class="title">{%=o.post.dataBean.nodetitle%}</span>
     <span class="annotator">{%=o.post.getUsername()%}</span>
     <span class="date">{%=o.post.getCreationdate()%}</span>
  </div>

  <div class="content">
    {%#o.nodetextashtml%}            
  </div>

  {% 
      var pactions = o.threadProfile.getPostActions();
      if (pactions && pactions.length > 0) { %}
  <ul class="control-list">
  {%         
       for (var i = 0; i < pactions.length; i++) { 
       var v = pactions[i].visibility == 'always' || 
              (pactions[i].visibility == 'onUserLogged' && !org.r3.PageManager.userInfo.isGuest()) ||
              (pactions[i].visibility == 'onUserNotLogged' && org.r3.PageManager.userInfo.isGuest()) || 
              (pactions[i].visibility == 'onUserIsOwner' && org.r3.PageManager.userInfo.dataBean.userid == o.post.dataBean.userid);
       if (v) 
       {
  %}
    <li class="open" ><span class='action' data-action='{%=pactions[i].id%}'>{%=pactions[i].text%}</span></li>
  {%   }
     } %}
  </ul>
  {% } %}

  </div> 
</div>

</script>

<script  type="text/x-tmpl" id="tpl_wbsoutline">
{%    
   var theWbs = o.wbs; 
   var theWbsNodes = theWbs.getListOfWbsNodes();
%}

<h1 id='{%=theWbs.dataBean.wbsid%}'>{%=theWbs.dataBean.wbstitle%}</h1>
{%#theWbs.dataBean.wbstext%}

<div class="wbs_content">
{% if (theWbsNodes) 
   { 
      for(var j = 0; j < theWbsNodes.length; j++) 
      {
         var theWbsNodeOutlineClass = (theWbsNodes[j].dataBean.nodesectdirtiness) ? 'invalid' : '';

         %} <h{%=(theWbsNodes[j].getNodeHSection())%} class='{%=theWbsNodeOutlineClass%}'>{%=theWbsNodes[j].getNodeLabel(true)%}</h2> <p>{%=theWbsNodes[j].dataBean.nodesummary%}</p> {%      
      }
   }
%}
</div>        
</script> 
              

<script id="template-timelineportletviewactionform_postinforenderer" type="text/x-tmpl">

</script>

<script id="template-timelineportletviewactionform" type="text/x-tmpl">

<div class="panel panel-grade1 timelinepost" id="thn_{%=o.post.dataBean.threadnodeid%}">
  <div class="panel-heading" style='background-color: #fcfcfc'>

  <figure><img src="/r3ng/resources/sites/cvfxxxvchamp/icon-squared.png"></figure>
  <span class="date">{%#o.post.getCreationDateAsBadge()%}</span>

{% 
var dropDownPresent = false;
var pactions = o.threadProfile.getPostActions();
if (pactions && pactions.length > 0) 
{ 
   for (var i = 0; i < pactions.length; i++) 
   { 
       var v = pactions[i].visibility == 'always' || 
         (pactions[i].visibility == 'onUserLogged' && !org.r3.PageManager.userInfo.isGuest()) ||
         (pactions[i].visibility == 'onUserNotLogged' && org.r3.PageManager.userInfo.isGuest()) || 
         (pactions[i].visibility == 'onUserIsOwner' && org.r3.PageManager.userInfo.dataBean.userid == o.post.dataBean.userid);
 
     if (v && !dropDownPresent)
     {
       dropDownPresent = true;
%}     <div class="dropdown" style='display: inline-block; float: right'>
		 <button style='height: 43px; margin: 6px' class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
		    Azioni <span class="caret"></span>
		 </button>
		 <ul  class="dropdown-menu" aria-labelledby="dropdownMenu1"> 
{%
     }

     if (v) 
     {
%}
         <li><a data-action='{%=pactions[i].id%}'>{%=pactions[i].text%}</a></li>
{%   }
   } 

   if (v && dropDownPresent)
   {
%}      </ul></div> {%
   }
}
%}

	<h4 class="title">{%=o.post.getUsername()%}</h4>
	<span class="moment">{%=o.post.getCreationdateAsElapsed()%}</span>

  </div>

  <div class="panel-body">
		
    <div class="timelinepost_content" id="thn_{%=o.post.dataBean.threadnodeid%}_postcontent">
       {%#o.nodetextashtml%}        
    </div>
    <div id="thn_{%=o.post.dataBean.threadnodeid%}_editcanvas"></div>

    <hr />

    <ul class='list-unstyled' id="thn_{%=o.post.dataBean.threadnodeid%}_childlist" style='padding-left: 20px'>
    </ul>

{% if (!org.r3.PageManager.userInfo.isGuest() && o.post.allowsTweets()) { %}
        <div class='text-right'>
		<button  data-action='new-child' class="btn btn-default" type="button" >
		    Commenta
	    </button>
        </div>

        <div id="thn_{%=o.post.dataBean.threadnodeid%}_newchildcanvas"></div>
{% } %}

  </div>
</div>

</script>

</r3_lang:environment>
