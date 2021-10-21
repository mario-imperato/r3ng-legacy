<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
<div class="panel panel-default">
  <div class="panel-heading" style='background: white'>  
    <h3 class="panel-title">{%=org.r3.jsportlet.outmail.message.outmailuploadfileactionform_form_legend%}</h3>
  </div>
  
  <div class="panel-body">
  <div id="cardfileuploadactionform_fieldset_message" >
    <div class="formmessageCanvas info" style="">{%=org.r3.jsportlet.outmail.message.outmailuploadfileactionform_form_formmessage%}</div>
  </div>
    
  <form id="uploadfileactionform_form" action="server.jsp" method="POST" enctype="multipart/form-data" accept-charset="UTF-8" class="form-horizontal">
  
  <div id='formfragment_fields'></div>
  
           <div class="row fileupload-buttonbar">
            <div class="col-lg-9">
                <!-- The fileinput-button span is used to style the file input field as button -->
                <span class="btn btn-success fileinput-button">
                    <i class="glyphicon glyphicon-plus"></i>
                    <span>{%=org.r3.jsportlet.outmail.message.outmailuploadfileactionform_addfile%}</span>
                    <input type="file" name="files[]" multiple>
                </span>
                <button type="submit" class="btn btn-primary start">
                    <i class="glyphicon glyphicon-upload"></i>
                    <span>{%=org.r3.jsportlet.outmail.message.outmailuploadfileactionform_start%}</span>
                </button>
                <button type="reset" class="btn btn-warning cancel">
                    <i class="glyphicon glyphicon-ban-circle"></i>
                    <span>{%=org.r3.jsportlet.outmail.message.outmailuploadfileactionform_cancel%}</span>
                </button>
                                
                <!-- 
                <button type="button" class="btn btn-danger delete">
                    <i class="glyphicon glyphicon-trash"></i>
                    <span>Delete</span>
                </button>
                <input type="checkbox" class="toggle">
                 -->
                 
                <!-- The global file processing state -->
                <span class="fileupload-process"></span>
            </div>
            <!-- The global progress state -->
            <div class="col-lg-3 fileupload-progress fade">
                <!-- The global progress bar -->
                <div class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100">
                    <div class="progress-bar progress-bar-success" style="width:0%;"></div>
                </div>
                <!-- The extended global progress state -->
                <div class="progress-extended">&nbsp;</div>
            </div>
        </div>
        <!-- The table listing the files available for upload/download -->
        
        <table role="presentation" class="table table-striped"><tbody class="files"></tbody></table>
        
  </form>
  </div>
</div>

