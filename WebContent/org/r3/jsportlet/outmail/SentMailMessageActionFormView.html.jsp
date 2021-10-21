<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
<div class="panel panel-default">
  <div class="panel-heading" style='background: white'>  
    <h3 class="panel-title">{%=org.r3.db.system.outmailspooler.message.detailactionformview_legend%}</h3>
  </div>
  
  <div class="panel-body">
  <div id="sentmailmessageactionform_fieldset_message" ></div>
      
  <form id="sentmailmessageactionform_form" method="POST" class='form-horizontal'>
  <input type='hidden' id='sentmailmessageactionform_attachmentgroupid' name='attachmentgroupid' />
  
  <div class="form-group">
    <label class="col-md-2  control-label fieldRequired">{%=org.r3.db.system.outmailspooler.message.msgfrom%}</label>    
    <div class='col-md-10 '>
    <label class="form-control-static" id="sentmailmessageactionform_msgfrom" >&nbsp;</label>
    </div>
  </div> 
  
  <div class="form-group" id="sentmailmessageactionform_formgroup_msgcc">
    <label class="col-md-2  control-label">{%=org.r3.db.system.outmailspooler.message.msgcc%}</label>
    <div class='col-md-10 '>
    <label class="form-control-static"  id="sentmailmessageactionform_msgcc" >&nbsp;</label>
    </div>
  </div> 

  <div class="form-group" id="sentmailmessageactionform_formgroup_msgbcc">
    <label class="col-md-2  control-label">{%=org.r3.db.system.outmailspooler.message.msgbcc%}</label>
    <div class='col-md-10 '>
    <label class="form-control-static"   id="sentmailmessageactionform_msgbcc" >&nbsp;</label>
    </div>
  </div> 
  
  <div class="form-group">
    <label class="col-md-2  control-label fieldRequired">{%=org.r3.db.system.outmailspooler.message.msgtitle%}</label>
    <div class='col-md-10 '>
    <label class="form-control-static" id="sentmailmessageactionform_msgtitle" >&nbsp;</label>
    </div>
  </div> 

  </form>  
  
  <div class="box collapsed-box">
  <div class="box-header with-border">
    <h3 class="box-title">Destinatari ({%=o.message.getMsgmode()%})</h3>
    <div class="box-tools pull-right">      
      <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
    </div><!-- /.box-tools -->
  </div><!-- /.box-header -->
  <div class="box-body">
    <div id="sentmailmessageactionform_msgrecipients" class='row'>
{% if (o.recipientList && o.recipientList.getNumberOfItems()) { 
      for(var i = 0; i < o.recipientList.getNumberOfItems(); i++) {
         var item = o.recipientList.getItem(i);
%}    
    <div class="col-md-4 col-sm-6" style='overflow: hidden'>{%#item.getRecordStatusAsSemaphore()%}{%=item.dataBean.msgto%}</div>
{%    } 
   } 
   else
   { %}
    <div class="col-md-12 text-warning"><i class="fa fa-warning"></i> {%=org.r3.jsportlet.outmail.message.norecipients%}</div>
{% }
%}
    </div>
  </div>  
  </div>
  
  <div class="box">
  <div class="box-header with-border">
    <h3 class="box-title">Oggetto</h3>
    <div class="box-tools pull-right">      
      <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
    </div><!-- /.box-tools -->
  </div><!-- /.box-header -->
  <div class="box-body">
    <div id="sentmailmessageactionform_msgtext" ></div>
  </div>  
  </div>
  
  </div>
</div>
   
  