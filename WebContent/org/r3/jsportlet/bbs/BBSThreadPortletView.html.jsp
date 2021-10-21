<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>




<div id='bbsthreadportletviewactionform_thread_cnt' class='r3_bulletin'>
  <div class="panel" >    
    <div class="panel-body">
    
<h4 id='bbsthreadportletviewactionform_threadtitle'>{%#org.r3.jsportlet.bbs.message.thread_name%}</h4>
 
 <div id='bbsthreadportletviewactionform_threadposts_summary' style="color: #ff0000">
 
 </div>

 <div id='bbsthreadportletviewactionform_threadposts_cnt' class='r3_bulletin_posts' >
 </div>
 

<a id="bbsthreadportletviewactionform_anchor" ></a>

<!-- La canvas del nuovo commento viene visualizzata in alternativa a quella della form con i campi -->

<div class="panel" id='bbsthreadportletviewactionform_action_startnew_actionbar'>    
    <div class="action-bar">
        <button type="button" id="bbsthreadportletviewactionform_action_startnew" class="btn btn-default" style="margin-top: 5px">
          <span>{%=o.threadProfile.getLabels().newPost%}</span>
        </button>                                                             
    </div>
</div>

<div id="bbsthreadportletviewactionform_form_canvas" style='display: none'>
<div class="panel panel-light" >  
     <div class="panel-heading" >  
        <h3 class="panel-title" >{%=o.threadProfile.getLabels().newPostPanelHeading%}</h3>
     </div>
    
    <div class="panel-body">

    <div id="bbsthreadportletviewactionform_fieldset_message"></div>
    
    <form id="bbsthreadportletviewactionform_form" method="POST" class="form-horizontal">
    <input type='hidden' id="bbsthreadportletviewactionform_nodeparentid" name="nodeparentid" />
    <input type='hidden' id="bbsthreadportletviewactionform_threadnodeid" name="threadnodeid" />
    <input type='hidden' id="bbsthreadportletviewactionform_nodetype" name="nodetype" value='xcode' />
    
    <div id="bbsthreadportletviewactionform_form_template"></div>    
  
    <div class="form-action-bar">
        <button type="button" id="bbsthreadportletviewactionform_action_saveitem" class="btn btn-default" >
          <span>{%#org.r3.message.action_save%}</span>
        </button>
        
        <button type="button" id="bbsthreadportletviewactionform_action_clearform" class="btn btn-default" >
          <span>{%#org.r3.jsportlet.bbs.message.action_clearform%}</span>
        </button>
    </div> 
    </form>
    
    </div>
</div>
</div>    

  </div>
 </div>
 </div>
 