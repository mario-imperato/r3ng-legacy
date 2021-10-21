<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>


<div class="panel panel-light">
  <div class="panel-heading" >  
    <h3 class="panel-title" ><label class="fieldReadOnly" id="threadnodedetailactionform_threadnodeid_label"></label> {%=org.r3.db.bbs.bbsthreadnode.message.detailactionformview_legend%}</h3>
  </div>
  
  <div class="panel-body">
  <div id="threadnodedetailactionform_fieldset_message" ></div>  
  <form id="threadnodedetailactionform_form" method="POST" class='form-horizontal'>
  
 <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >{%=org.r3.db.bbs.bbsthreadnode.message.nodetitle%}</label>
     <div class="col-md-10" >
        <input type="text" class='form-control' name="nodetitle" id="threadnodedetailactionform_nodetitle" maxlength="80"  />        
     </div>
 </div>
 
 <textarea class="ckeditor"  id="threadnodedetailactionform_nodetext" name="nodetext" style="width: 90%" rows="5"></textarea>
 
  </form>

    <div class="form-action-bar">
        <button type="button" id="threadnodedetailactionform_action_saveitem" class="btn btn-default" >
          <span>{%=org.r3.message.action_save%}</span>
        </button>  
        
        <button type="button" id="threadnodedetailactionform_action_delete" class="btn btn-danger" >
           <span>{%=org.r3.message.action_delete%}</span>
        </button>                        
    </div>
      
  </div>
</div>


     

