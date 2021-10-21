<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env">

<script type="text/x-tmpl" id="cms_tpl_shakeusmapexplorer">
<img src="/r3ng/was/{%=o.siteCollectionDTOAdapter.dataBean.site%}/it/sitecollection/{%=o.siteCollectionDTOAdapter.dataBean.site%}/graphics/shksitephoto;imagerole=image" style='width: 100%' />
   
<button type='button' id="shakeus_mapexplorer_enter" class='btn btn-danger btn-block' style='margin-bottom: 20px'>Entra</button>
<p>{%#o.siteCollectionDTOAdapter.dataBean.summary%}</p>
</script>

<script type="text/x-tmpl" id="cms_tpl_shakeusmapexplorer_news">
{% 
if (o.object.getNumberOfItems() > 0) 
{  
   for(var i = 0; i < o.object.getNumberOfItems(); i++)
   {
        var item = o.object.getItem(i); 
%} 
   <h3 class='text-red'><a href='{%=item.getTitleLink()%}'>{%=item.getTitle()%}</a></h3>
<p>{%=item.getSummary()%}</p>
{% 
   }
} 
%}
</script>

<script type="text/x-tmpl" id="cms_tpl_shakeusmapexplorer_OLD">
{%
   if (o.object.getCardImageUrl()) {
       %} <img src="{%=o.object.getCardImageUrl()%}" style='width: 100%' /> {%
   }
%}

<button type='button' id="shakeus_mapexplorer_enter" class='btn btn-danger btn-block' style='margin-bottom: 20px'>Entra</button>
{%#o.object.dataBean.textbody%}
</script>

<script type="text/x-tmpl" id="cms_tpl_shakeussitememberbcard">

{%
    var businessCard = o.member && o.member.dataBean.businesscard;
    var userName =  o.member && o.member.getUsername();
%}
<div class="box box-widget" >
	<div class="box-header with-border">
		<h3 class='box-title'>{%=userName%}</h3>
		<!-- /.user-block -->
		<div class="box-tools">
			<button type="button" class="btn btn-box-tool" data-widget="remove">
				<i class="fa fa-times"></i>
			</button>
		</div>
		<!-- /.box-tools -->
	</div>
	<div class="box-body">

<div class='row'>
<div class='col-md-4 col-sm-6 col-xs-6'><img src='{%=o.memberPhoto%}' class='img-thumbnail sitemember-photo' style='width: 100%'></div>
<div class='col-md-8 col-sm-6 col-xs-6'>   
{% if (businessCard) { %}        
<p>{%=businessCard.personalstatement%}</p>
{% } else { %}
<p>Ooops. {%=userName%} non ha inserito neanche una breve descrizione..</p>
{% if (o.member.isCurrentUser()) { %}
<p><a href='user/myr3.do'>Voglio modificare i miei dati di profilo</a></p>
{% } %}        
{% } %}        
</div>      
</div>

<div class='row' style='margin-top: 20px'>
<div class='col-md-12' class='contact-info'>
<div style='margin-left: 10px'>
{% if (businessCard && businessCard.email) { %}
 <p><i class='fa fa-envelope'></i> <span class='sitemember-email'>{%=businessCard.email%}</span></p>
{% } %} 
{% if (businessCard && businessCard.cellphone) { %}
 <p><i class='fa fa-phone'></i> <span class='sitemember-cell'>{%=businessCard.cellphone%}</span></p>
{% } %} 
</div>
</div>
</div>

	</div>
</div>

</script>

<script type="text/x-tmpl" id="cms_tpl_shakeussitememberbcard_modal">
<div class="modal-header">
  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  <h4 class="modal-title sitemember-name" id="gridSystemModalLabel">{%=o.member.getUsername()%}</h4>
</div>
<div class="modal-body">
<div class="container-fluid">
 <div id="sitemember_fieldset_message" ></div>
 
<div class='row'>
<div class='col-md-4'><img src='{%=o.memberPhoto%}' class='img-thumbnail sitemember-photo' style='width: 100%'></div>
<div class='col-md-8'>           
<p>Lorem Ipsum</p>
</div>      
</div>
<div class='row' style='margin-top: 20px'>
<div class='col-md-12' class='contact-info'>
 <i class='fa fa-edit'></i> <span class='sitemember-email'>{%=o.member.getEmail()%}</span><br />
 <i class='fa fa-edit'></i> <span class='sitemember-cell'>{%=o.member.getCellphone()%}</span>
</div>
</div>
</div>
</div>

<div class="modal-footer">
  <button type="button" class="btn btn-default" data-dismiss="modal">Chiudi</button>       
</div>
</script>
              
</r3_lang:environment>
