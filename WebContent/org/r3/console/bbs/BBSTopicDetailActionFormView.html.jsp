<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
<div class="panel panel-light">
  <div class="panel-heading" >  
    <h3 class="panel-title" ><label class="fieldReadOnly" id="topicdetailactionform_topicid_label"></label> {%=org.r3.db.bbs.bbstopic.message.detailactionformview_legend%}</h3>
  </div>
  
  <div class="panel-body">
  <div id="topicdetailactionform_fieldset_message" ></div>  
  <form id="topicdetailactionform_form" method="POST" class='form-horizontal'>
  
 <div class="form-group">
     <label class="col-md-2 control-label "  >{%=org.r3.db.bbs.bbstopic.message.topicid%}</label>
     <div class="col-md-10" >
          <input name="topicid" class='form-control' id="topicdetailactionform_topicid" type="text"  maxlength="15" />        
     </div>
 </div>
 
 <div class="form-group">
     <label class="col-md-2 control-label "  >{%=org.r3.db.bbs.bbstopic.message.moderatormode%}</label>
     <div class="col-md-10 columns" >
        <label class='radio-inline'>
            <input id="topicdetailactionform_moderatormode_moderated" type="radio" value="moderated" name="moderatormode" checked>
              {%=org.r3.db.bbs.bbstopic.message.moderatormode_moderated%}
        </label>

        <label class='radio-inline'>
            <input id="topicdetailactionform_moderatormode_regulated" type="radio" value="regulated" name="moderatormode" >
              {%=org.r3.db.bbs.bbstopic.message.moderatormode_regulated%}
        </label>     
     </div>
</div>
   
   
  <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >{%=org.r3.db.bbs.bbstopic.message.topictitle%}</label>
     <div class="col-md-10" >
         <input type="text" class='form-control' name="topictitle" id="topicdetailactionform_topictitle" maxlength="80"  />        
     </div>
 </div>

  <div class="form-group">
     <label class="col-md-2 control-label "  >{%=org.r3.db.bbs.bbstopic.message.cardid%}</label>
     <div class="col-md-10" >
         <label class="form-control"  id="topicdetailactionform_cardid" disabled>&nbsp;</label>        
     </div>
 </div>
   
  </form>

 <div class="form-action-bar">
        <button type="button" id="topicdetailactionform_action_saveitem" class="btn btn-default" >
          <span>{%=org.r3.message.action_save%}</span>
        </button>  
        
        <button type="button" id="topicdetailactionform_action_delete" class="btn btn-danger" >
           <span>{%=org.r3.message.action_delete%}</span>
        </button>                        
  </div>
      
  </div>
</div>


     
