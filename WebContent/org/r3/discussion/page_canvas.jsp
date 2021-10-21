<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env" namespace='org.r3.discussion'>

<div class='r3_container' style='min-height: 500px; padding: 10px;' >
<div class="row">

<div class="col-md-3 cmsCard hidden-sm hidden-xs">
 <div >
   <div id='page_image' style='display: block; text-align: center; margin-bottom: 20px;'></div>
   <div id='gmenubar' ></div>
 </div>   
</div>

<div class="col-md-9 ">
  <div id="topicCmsPageActionForm" class='actionForm'></div>    
  <div id='threadActionForm' class='actionForm'></div>
</div>
</div>
</div>
            
</r3_lang:environment>