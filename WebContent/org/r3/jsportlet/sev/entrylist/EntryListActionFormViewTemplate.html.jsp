<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<!-- 
<h2 style='border-bottom: 1px solid #ccc; margin-top: 0px; padding: 5px;'>{%=o.legend%}
<span style='font-size: 0.6em'>(<input type='checkbox' name='showboaticons' id='entrylist_action_showboaticons' value='btrue' /> Mostra Icone)</span>
</h2>
-->
   
<div class="panel panel-light">
  <div class="panel-heading">
    <h3 class="panel-title">{%=o.legend%} (<input type='checkbox' name='showboaticons' id='entrylist_action_showboaticons' value='btrue' /> Mostra Icone)</h3>
  </div> 
  <div class="panel-body">

      {% if (o.isLayoutFullWidth() && o.isActionBarEnabled() && o.isActionBarOnTop()) { %} 
            
      <div class="panel_action_bar position_top">
      {% 
         for(var i = 0; i < o.buttons.length; i++)
         {      
      %}      
         <button type="button" class="btn btn-primary start" id="{%=o.buttons[i].id%}"  {% if (o.buttons[i].disabled) { %} disabled {% } %} >         
         <span>{%=o.buttons[i].label%}</span>
         </button>
      {% 
         }      
      %}      
      </div>            
                  
      {% } %}
    
      <div class="dataTables_wrapper">      
      {% if (o.isSearchEnabled()) { %}      
      <div id="{%=o.dataTableId%}_filter" class="dataTables_filter">
      
      <a class="{%=o.dataTableId%}_filter_search" href="javascript:void(0)" >{%=o.getSearchLabel()%}</a>
      {% if (o.isAdvancedSearchEnabled()) { 
            for(var i = 0; i < o.getNumberOfAdvancedSearchOptions(); i++)
            {
      %}
      &nbsp;|&nbsp;<a href="javascript:void(0)" id="{%=o.dataTableId%}_filter_advsearch_{%=i+''%}" class="{%=o.dataTableId%}_filter_advsearch">{%=o.getAdvancedSearchLabel(i)%}</a>      
      {% }} %}
      <span class="search_icon {%=o.dataTableId%}_filter_search" ></span>
      <form id="{%=o.dataTableId%}_filter_searchform">
      {% if (o.isSearchWidgetSelect()) { %}

          <select name="filter_item" class='form-control' style='display: inline-block; width: 50%' id="{%=o.dataTableId%}_filter_searchitem" >
          </select>
                   
      {% } 
         else { %}
          <input type="text" name="filter_item" id="{%=o.dataTableId%}_filter_searchitem" >
      {% } %}
      </form>
      
      </div>
      {% } %}	
                        
      <table id="{%=o.dataTableId%}" class="table table-striped table-bordered table-hover {%=o.gradeLevel%}" >
        <tbody>
        </tbody>
      </table>
                        
      </div>
      
  </div>
</div>
    
