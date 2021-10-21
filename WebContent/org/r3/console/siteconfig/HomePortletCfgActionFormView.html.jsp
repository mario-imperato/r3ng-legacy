<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>
    
     
  <div class="panel panel-default">
  <div class="panel-heading" style='background: white'>  
    <h3 class="panel-title">{%=org.r3.console.siteconfig.message.homeportletcfgactionform_form_legend%}</h3>
  </div>
  
  <div class="panel-body" style='padding-top: 0px; padding-bottom: 0px'>
  <div id="homeportletcfgactionform_fieldset_message" ></div>
  
  <div class='row'>
  <div class='col-sm-4 hidden-xs homeportletslot-canvas'>
  
  <div class='row'>
  <div class='col-sm-12 homeportletslot-column'>
    <div class="homeportletslot " id='layout1-homeportlet-30' ></div>
  </div>
  </div>
  
  <div class='row'>
  <div class='col-sm-6 homeportletslot-column'>
  
     <div class="homeportletslot " id='layout1-homeportlet-00' ></div>
     <div class="homeportletslot " id='layout1-homeportlet-01'></div>
     <div class="homeportletslot " id='layout1-homeportlet-02'></div>
     <div class="homeportletslot " id='layout1-homeportlet-03'></div>
     <div class="homeportletslot " id='layout1-homeportlet-04'></div>
     <div class="homeportletslot  " id='layout1-homeportlet-05'></div>
     <div class="homeportletslot  " id='layout1-homeportlet-06'></div>
     <div class="homeportletslot  " id='layout1-homeportlet-07'></div>
     <div class="homeportletslot  " id='layout1-homeportlet-08'></div>
     <div class="homeportletslot  " id='layout1-homeportlet-09'></div>

  </div>
  
  <div class='col-sm-6 homeportletslot-column'>
  
     <div class="homeportletslot " id='layout1-homeportlet-10'></div>
     <div class="homeportletslot " id='layout1-homeportlet-11'></div>
     <div class="homeportletslot " id='layout1-homeportlet-12'></div>
     <div class="homeportletslot " id='layout1-homeportlet-13'></div>
     <div class="homeportletslot " id='layout1-homeportlet-14'></div>
     <div class="homeportletslot " id='layout1-homeportlet-15'></div>
     <div class="homeportletslot " id='layout1-homeportlet-16'></div>
     <div class="homeportletslot " id='layout1-homeportlet-17'></div>
     <div class="homeportletslot " id='layout1-homeportlet-18'></div>
     <div class="homeportletslot " id='layout1-homeportlet-19'></div>
  
  </div>
  
  </div>
  
  <div class='row'>
  <div class='col-sm-4 homeportletslot-column'>
     <div class="homeportletslot " id='layout1-homeportlet-20' ></div>           
     <div class="homeportletslot " id='layout1-homeportlet-21' ></div>           
     <div class="homeportletslot " id='layout1-homeportlet-22' ></div>
  </div>
  
  <div class='col-sm-4 homeportletslot-column'>               
     <div class="homeportletslot " id='layout1-homeportlet-23' ></div>           
     <div class="homeportletslot " id='layout1-homeportlet-24' ></div>           
     <div class="homeportletslot " id='layout1-homeportlet-25' ></div>             
  </div>

  <div class='col-sm-4 homeportletslot-column'>               
     <div class="homeportletslot " id='layout1-homeportlet-26' ></div>           
     <div class="homeportletslot " id='layout1-homeportlet-27' ></div>           
     <div class="homeportletslot " id='layout1-homeportlet-28' ></div>             
  </div>
  </div>
  
  
  </div>
  
  <div class='col-sm-8' style='padding-top: 15px; padding-bottom: 15px'>
  
  <form id="homeportletcfgactionform_form" method="POST" class='form-horizontal form-small'>
    <input type='hidden' name='positionid' id='homeportletcfgactionform_positionid' />
    
  
 <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >{%=org.r3.console.siteconfig.message.homeportletcfgactionform_jsclassname%}</label>
     <div class="col-md-10" >
        <select name="jsclassname" id="homeportletcfgactionform_jsclassname" class='form-control' ></select>        
     </div>
 </div>

  
 <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >{%=org.r3.console.siteconfig.message.homeportletcfgactionform_cssclassname%}</label>
     <div class="col-md-10" >
          <input type="text" name="cssclassname" id="homeportletcfgactionform_cssclassname" maxlength="40" class='form-control' />        
     </div>
 </div>

  
 <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >{%=org.r3.console.siteconfig.message.homeportletcfgactionform_datacardid%}</label>
     <div class='col-md-10 single_picker' id='homeportletcfgactionform_pickerdatacardid_cnt'></div>
     <!-- 
     <div class="col-md-10" >
          <input type="text" name="datacardid" id="homeportletcfgactionform_datacardid" maxlength="15" class='form-control' />                      
     </div>
      -->
 </div>

  
 <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >{%=org.r3.console.siteconfig.message.homeportletcfgactionform_dataoptions%}</label>
     <div class="col-md-10" >
          <input type="text" name="dataoptions" id="homeportletcfgactionform_dataoptions" maxlength="40" class='form-control' />        
     </div>
 </div>
 
 <div class="form-group">
     <label class="col-md-2 control-label fieldRequired"  >{%=org.r3.console.siteconfig.message.homeportletcfgactionform_dataonuserstatus%}</label>
     <div class="col-md-10 columns" >
          <label class='radio-inline'> <input name="dataonuserstatus" id="homeportletcfgactionform_dataonuserstatus_always"        value="always" type="radio" checked />Sempre</label> 
          <label class='radio-inline'> <input name="dataonuserstatus" id="homeportletcfgactionform_dataonuserstatus_userlogged"    value="userlogged" type="radio" />Identificato</label> 
          <label class='radio-inline'> <input name="dataonuserstatus" id="homeportletcfgactionform_dataonuserstatus_usernotlogged" value="usernotlogged" type="radio" />Non Identificato</label>      
     </div>
</div>
   
  </form>
  
      <div class="form-action-bar">
        <button type="button" id="homeportletcfgactionform_action_saveitem" class="btn" >
          <span>Salva</span>
        </button>
            
    </div>
    
  </div>  
  </div>
  
  </div>
  </div>
  



