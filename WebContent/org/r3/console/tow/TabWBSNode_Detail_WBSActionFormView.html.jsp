<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.io.*,
    java.util.*
    "%>



<div class="panel ">
  <div class="panel-heading" >  
    <h3 class="panel-title" >{%=org.r3.jsportlet.wbs.message.wbsnodeactionform_form_legend_title%}</h3>
  </div>
  
  <div class="panel-body">
  <div id="wbsnodeactionform_fieldset_message" ></div>
  <form id="wbsnodeactionform_form" method="POST" class=''>
  <input type='hidden' name="stereotype" value='stynone' />
          
  <div class='form-horizontal row'>
  
  <div class='col-md-6'>
 <div class="form-group">
     <label class="col-md-4 control-label fieldRequired"  >{%#org.r3.db.wbs.wbsnode.message.nodetype%}</label>
     <div class="col-md-8" >
          <select name="nodetype" class='form-control' id="wbsnodeactionform_nodetype" >
          <option value="towgroup">TOW Group</option>
          <option value="tow">TOW</option>
          </select>                  
     </div>
 </div>  
 
  <div class="form-group">
     <label class="col-md-4 control-label fieldRequired"  >{%#org.r3.db.wbs.wbsnode.message.nodename%}</label>
     <div class="col-md-8" >
          <input type="text" class='form-control' name="nodename" id="wbsnodeactionform_nodename" maxlength="40"  />        
     </div>
 </div>
  
  </div>
  
  <div class='col-md-6'>
  
 <div class="form-group">
     <label class="col-md-4 control-label fieldRequired"  >{%#org.r3.db.wbs.wbsnode.message.startdate%}</label>
     <div class="col-md-8" >
          <input name="startdate" class='form-control r3_datepicker' id="wbsnodeactionform_form_startdate" type="text" />        
     </div>
 </div>
 
 <div class="form-group">
     <label class="col-md-4 control-label fieldRequired"  >{%#org.r3.db.wbs.wbsnode.message.enddate%}</label>
     <div class="col-md-8" >
          <input name="enddate" class='form-control r3_datepicker' id="wbsnodeactionform_form_enddate" type="text" />        
     </div>
 </div>
  
  </div>
  
  </div>

  <hr />
  <div class='form-horizontal'>
  <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >{%#org.r3.db.wbs.wbsnode.message.nodesummary%}</label>
     <div class="col-md-10" >
		<textarea  name="nodesummary" class='form-control' id="wbsnodeactionform_nodesummary" rows="5" ></textarea>        
     </div>
 </div>
 </div>
 
           
  {% if (o.teamprofile.getNumberOfItems() > 0) { %}
 <div id="tow_teameffort" class="form-horizontal"> 
 <hr />
 <h3 >Impegno Previsto Risorse</h3>

     <div class="form-group">
     <label class="col-md-2 control-label"  >Unità di misura</label>
     <div class="col-md-4" >
		<select  name="teameffortunit" class='form-control' id="wbsnodeactionform_teameffortunit" >
		<option value="day">Giornaliero</option>
		</select>		        
     </div>
     </div>

     <div class="row"><div class="col-md-12"> 
     {% for(var c = 0; c < o.teamprofile.getNumberOfItems(); c++)
       {
           var item = o.teamprofile.getItem(c);
           %}
     
     <div class="form-group">
     <label class="col-md-2 control-label"  >{%=item.getProfiledescr()%}</label>
     <div class="col-md-4" >
        <input  type='hidden' name="profileid"  value="{%=item.dataBean.profileid%}"   />
		<input  type='text'   name="teameffort" class='form-control teameffort' id="wbsnodeactionform_teameffort_{%=item.dataBean.profileid%}" maxlength="5" />        
     </div>
     </div>
     
       {% } %}
       
       </div></div> 
  </div>
  {% } %}
  
  </form>

    <div class="form-action-bar">
        <button type="button" id="wbsnodeactionform_action_saveitem" class="btn btn-default" >
          <span>{%=org.r3.message.action_save%}</span>
        </button>                       
    </div>

  </div>
</div>


       
           

      
           