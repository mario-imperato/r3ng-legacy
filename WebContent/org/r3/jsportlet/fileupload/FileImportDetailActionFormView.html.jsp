<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    

<div class="panel panel-default">
  <div class="panel-heading" style='background: white'>  
    <h3 class="panel-title" >{%=org.r3.jsportlet.fileupload.message.jsportletfileimportform_legend%}</h3>
  </div>
  
  <div class="panel-body">
  <div id="jsportletfileimportform_fieldset_message" ></div>
  <div class="formmessageCanvas info" style='margin-bottom: 10px'>{%=org.r3.jsportlet.fileupload.message.jsportletfileimportform_panelinfo%}</div>

  <form id="jsportletfileimportform_form" method="POST" class="form-horizontal">

    <div id='jsportletfileimportform_extension_fields'></div>
    
    
    
{%
var numCols = o.fileImportDTOAdapter.dataBean.numberofcolumns;
for(var i = 1; i <= numCols; i++)
{
%}
    <div class="form-group">
    <label class="col-md-2  control-label fieldRequired">Col {%=i%}</label>
    <div class='col-md-4 '>    
    <select name="col{%=i%}samples" id="jsportletfileimportform_col{%=i%}samples" class="form-control">
                 
{%
     var importData = o.fileImportData;     
     if (importData && importData.iTotalRecords > 0)
     {
         for(var j = 0; j < importData.aaData.length; j++)
         {
            var cval = eval('importData.aaData[j].col' + i);
            if (cval)
            {
               %}<option value='{%=j%}'>{%=cval%}</option>{%
            }
         }
     }
%}                     
          </select>
      </div>  
    
    <label class="col-md-2  control-label fieldRequired">{%=org.r3.jsportlet.fileupload.message.jsportletfileimportform_columnmatch%}</label>
    <div class='col-md-4 '>    
    <select name="columnmatch" id="jsportletfileimportform_fileimport_match4col{%=i%}" class="form-control">
    </select>
    </div>                          
    </div>
{%
}
%}    
        
  </form>
  
   <div class="form-action-bar">
        <button type="button" id="jsportletfileimportform_action_saveitem" class="btn btn-default" >
          <span>{%=org.r3.message.action_save%}</span>
        </button>

        <button type="button" id="jsportletfileimportform_action_cancel" class="btn btn-default" >
          <span>{%=org.r3.message.action_cancel%}</span>
        </button>

      <button type="button" id="jsportletfileimportform_action_delete" class="btn btn-danger" >
        <span>{%=org.r3.message.action_delete%}</span>
      </button>
                  
   </div>   
  </div>
</div>


    
    
   
