<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.io.*,
    java.util.*
    "%>

<div>

<!-- <ul class="list-group">  -->
  

{%    if (o.rankData && o.rankData.length) 
      {
%}

{%    for(var i = 0; i < o.rankData.length; i++) 
      {
          var theItem = o.rankData[i];
          %} <div class="panel panel-light">
  <div class="panel-heading">
    <h3 class="panel-title">{%=$.r3Utils.formatLUTDataBeanField('GET_classifier_r3ea_sinott', theItem.title)%}</h3>
  </div>
  <div class="panel-body">
                        
           {%
%}

{%    if (theItem.items && theItem.items.length) 
      {
%}
      
      <table class="table table-striped table-bordered table-hover grade_level5 dataTable no-footer" style='width: 100%'
         id="RankingQueryActionFormView_{%=theItem.title%}" aria-describedby="RankingQueryActionFormView_info">

      <thead>
        <tr role="row">
          <th class="sorting_disabled text-left" tabindex="0" rowspan="1" colspan="1" style="" aria-label="Id.">Classi</th>
{%      for (var j = 1; j <= (o.numOfRaces); j++)
        {
           %}<th class="sorting_disabled text-center" tabindex="0" rowspan="1" colspan="1" style="" aria-label="Id.">Prova {%=j%}</th>{%
        }    
%}  
          <th class="sorting_disabled text-center" tabindex="0" rowspan="1" colspan="1" style="" aria-label="Id.">Generale</th>
        </tr>
      </thead>
      <tbody role="alert" aria-live="polite" aria-relevant="all">
        
{%      
        var altRowClass = "even";
        for(var j0 = 0; j0 < theItem.items.length; j0++)
        {
           var rowData = theItem.items[j0]; 
           
           if (altRowClass == 'even')
                altRowClass = "odd";
           else altRowClass = "even";
%}           
        <tr class="grade_ranking {%=altRowClass%}">
        <td class="text-left">{%=rowData.ranktitle%}</td>    
{%            
        for (var j = 0; j < (rowData.instances.length); j++)
        {
           %}<td style='' class="text-center">{%
           if (rowData.instances[j].instanceid == 'empty')
           { %}
              &nbsp;
{%         }
           else
           {  
              if (rowData.instances[j].overall)
              {
                 %}<a href="javascript:void(0)" id="{%=rowData.instances[j].instanceid%}" class="synoptic_link"><img border='0' src='{%=rowData.instances[j].linkIcon%}' /></a>{%
              }
              else
              {
                 %}<a href="javascript:void(0)" id="{%=rowData.instances[j].instanceid%}" class="synoptic_link">{%=rowData.instances[j].racedate%}</a>{%
              }
              %}                        
{%         }  %}
           </td>
{%           
        }        
%}  
        </tr>       
{%
        }        
%}  

        
     </tbody>
     </table>
     
     
{%   }  %}

    </div></div>
{%   }  %}

{%   }  %}

<!-- </ul> -->
  </div>
  

 



