<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<!-- 
<div class="wbs_dashboard ">
   <div class='qplot_cnt cf' >
      <div style='float: left; width: 50%'>
      <div class='qplot_wbspie1' style='width: 180px;  height: 180px; '></div>
      </div>
      <div style='float: left; width: 50%'>      
      <div class='qplot_wbspie2' style='width: 180px; height: 180px; '></div>
      </div>
      
   </div>   
   <div class='gantt'></div>
</div>
-->

<div class="wbs_dashboard ">
   <div class='cf' style='display: table; width: 100%'>
   <div class='qplot_cnt' style='display: table-cell; padding-right: 10px; width: 75%'>
      <div class='cf' style='margin-top: 20px'>
      <div class='qplot_wbspie1' style='float: left; width: 250px; height: 200px; '></div>
      <div class='qplot_wbspie1_legend' style='padding-left: 250px; height: 200px; '></div>
      </div>
      
      <div class='cf' style='margin-top: 20px'>      
      <div class='qplot_wbspie2' style='float: left; width: 250px; height: 200px; '></div>
      <div class='qplot_wbspie2_legend' style='padding-left: 250px; height: 200px; '></div>
      </div>      
   </div>
   <div style='display: table-cell; width: 25%; border-left: 1px solid #cccccc; padding: 10px; vertical-align: top;'>
      <div class='wbsroi_canvas' style='font-size: 2em; text-align: center'></div>
   </div>   
   </div>
   <div class='gantt'></div>
</div>

