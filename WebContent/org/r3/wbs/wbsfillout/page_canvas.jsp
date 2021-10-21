<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env" namespace='org.r3.wbs.wbsfillout'>


<div style='min-height: 500px; padding: 20px;' >

<div class="row">

<div class="col-md-3">
 <div class="row">
 
 <div class="col-md-12" style='margin-bottom: 20px'>
 <div id='page_image' style='display: block; text-align: center'></div>
 </div>
 
 <div class="col-md-12" style='margin-bottom: 20px'>
 <div style='text-align: right'>
   <a class="CardQueryActionFormView_filter_search" href="javascript:void(0)"><r3_lang:string resourceId="select_wbs_dropdown_caption" /></a>
   <span class="filter_search_icon"></span>
   <select id="wbsselection_filter" name="wbsid" class='form-control' style='display: inline-block;'></select>
 </div> 
 </div>
 
 <div class="col-md-12" style='margin-bottom: 20px'> 
 <div id='gmenubar' ></div>
 </div>
 </div>
 
</div>

<div class="col-md-9 ">
  <div id='wbsDetailActionForm'         class='actionForm'></div>
  <div id='wbsNodeDetailActionForm'     class='actionForm'></div>
  <div id='wbsNodeDiscussionActionForm' class='actionForm'></div>
</div>
</div>

</div>
            
</r3_lang:environment>