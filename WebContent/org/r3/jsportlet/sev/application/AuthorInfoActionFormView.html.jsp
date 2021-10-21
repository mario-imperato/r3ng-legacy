<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>


<div id="authorinfoform_fieldset_message" ></div>
<form id="authorinfoform_form" method="POST" class="form-horizontal">
  
  <ul class="list-group">
  <li class="list-group-item">
  <h4 style='margin-bottom: 15px'><span id="authorinfoform_applicationid">&nbsp;</span> - Liberatorie</h4>
  
{% 
   for(var i = 0; i < o.widgets.length; i++)
   {
      var wInfo = o.widgets[i]; 
%}
  <div class="form-group">
    <label class="col-sm-4 control-label">{%=wInfo.label%}: <a id="authorinfoform_{%=wInfo.cardid%}" class="authorinfoform_authcard_link" href="#authorinfoform_authcard_anchor">Leggi il testo</a></label>
    <div class='col-sm-8 columns' id="authorinfoform_{%=wInfo.id%}_cnt">
    <label class='radio-inline'>
             <input  type="radio" value="btrue" name="prop_{%=wInfo.id%}" {%=wInfo.btrue%}>Do il consenso</label>
             
    <label class='radio-inline'>
             <input  type="radio" value="bfalse" name="prop_{%=wInfo.id%}" {%=wInfo.bfalse%}>Nego il consenso</label>
    </div>
  </div>
{% } %}

  </li>
  
  <li class="list-group-item">
    <a name='#authorinfoform_authcard_anchor' />
    <div id="authorinfoform_authcard"></div>
  </li>
  </ul>
  
  <div class="form-action-bar">
        
         <button type="button" id="authorinfoform_action_prev" class="btn btn-default">
          <span>Precedente</span>
        </button>

        <button type="button" id="authorinfoform_action_next" class="btn btn-default">
          <span>Successivo</span>
        </button>
        
   </div>     
   
</form>



   