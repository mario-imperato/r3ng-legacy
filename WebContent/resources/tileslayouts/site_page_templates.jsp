<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env">


<script type="text/x-tmpl" id="cms_tpl_simple">
  <div class="cmsCard">
  {%#o.object.dataBean.textbody%}
  </div>
</script>
  
<script type="text/x-tmpl" id="cms_tpl_notfound">
  <div class="cmsCard">
  <h3>Card: {%=o.object.cardid%}</h3>
  <p>Not found</p>
  </div>
</script>

<script type="text/x-tmpl" id="cms_tpl_listofcards">
{% 
if (o.object.getNumberOfItems() > 0) 
{  
   for(var i = 0; i < o.object.getNumberOfItems(); i++)
   {
        var item = o.object.getItem(i); 
%} 
   <p style='margin-top: 0px'>
       <b>{%=item.getRefdate()%} - {%#item.getHtmlLinkFragmentTitle2Detail(o.options.pageid)%}</b> - {%=item.dataBean.summary%}
   </p> 
{% 
   }
} 
%}
</script>

<script type="text/x-tmpl" id="cms_tpl_homecarouselview">
  {% 
  console.log('cms_tpl_homecarouselview');  
  if (o.object.getNumberOfItems() > 0) {  %}
  <div class="html_carousel"><div id="homecarouselview_canvas">
  {%    for(var i = 0; i < o.object.getNumberOfItems(); i++)
        {
           var item = o.object.getItem(i);
           var listOfCarouselImages = item.getListOfPropertiesByPropertyrole('cms_carousel_lg');
           if (listOfCarouselImages && listOfCarouselImages.length)
           {
               for(var j = 0; j <  listOfCarouselImages.length; j++) {

          %} <div class="slide">
              <img src="{%=listOfCarouselImages[j].getImageurl()%}" alt="carousel 1" width="1690" height="524" />
              <div>                 
                 <div class='slide-caption' >
                  <h4>{%=item.dataBean.title%}</h4>
                  <p>{%=item.dataBean.summary%}</p>
                 </div>
              </div>
          </div> {%
               }
           }           
        } 
     %} </div><div class="clearfix"></div></div> {%
     }  %}   
</script>          

<script  type="text/x-tmpl" id="cms_tpl_homenewsletter">
<img src='/r3ng/resources/sites/cvfonline/pages/articles_headline.png' style="width: 266px; display: block" />
<div class='cmsCard' style='padding: 5px;'>
<p>Test</p>

</div>
</script>
       
<script  type="text/x-tmpl" id="cms_tpl_channelportlet">
{% 
console.log('cms_tpl_channelportlet');  
if (o.object.getNumberOfItems() > 0) {  %}
<div class='cmsCard' style='margin-bottom: 10px; padding: 5px;'>
<h3 style=' margin-top: 0px; text-align:left; padding-bottom: 3px; border-bottom: 1px solid #cccccc'>Canale VHF09</h3> 

 {%  for(var i = 0; i < o.object.getNumberOfItems(); i++)
     {
        var item = o.object.getItem(i);
        var titleLink = item.getPagelink();
  
     %} <p style='margin-top: 0px'> 
        <!-- <span style='color: #ff0000'> --> {%
 
        if (titleLink) {
           %}<b>{%=item.getRefdate()%}<br /><a href='{%=titleLink%}' onClick="{%=item.getOnClickGoogleTracking()%}">{%=item.dataBean.title%}</a></b>{%
        }
        else
        {
           %}<b>{%=item.getRefdate()%}<br />{%=item.dataBean.title%}</b>{%
        } %}
        
        {%=item.dataBean.summary%}
        
        <!-- </span> -->
        </p>

 {%  } %}

<!--
<p style='margin-top: 0px'>
<b>Ven, 22/03/2013<br /><a href='whatever'>CVF Informa</a></b>
Qui potrete scaricare il nuovo numero di CVF informa la newsletter del Circolo.
</p>
-->

</div>
{% }  %}
</script>  

<script  type="text/x-tmpl" id="cms_tpl_homearticles">
{% 
console.log('cms_tpl_homearticles');
if (o.object.getNumberOfItems() > 0) { 
     for(var i = 0; i < o.object.getNumberOfItems(); i++)
     {
        var item = o.object.getItem(i); 
        var titleLink = item.getPagelink();
%}<div class='cmsCard cardlayout_icontext' style='background-image: url("{%=item.getCardIconUrl()%}")'>{%

        if (titleLink) {
           %}<h3 style='margin-bottom: 0px'><a href='{%=titleLink%}' onClick="{%=item.getOnClickGoogleTracking()%}">{%=item.dataBean.title%}</a></h3>{%
        }
        else
        {
           %}<h3 style='margin-bottom: 0px'>{%=item.dataBean.title%}</h3>{%
        } %}

<p style='margin-top: 0px'> 
{%=item.dataBean.summary%}
</p>
<p><b>{%=item.getRefdate()%}</b></p>
</div>
 {%  } 
  }  %}
</script>            

<script  type="text/x-tmpl" id="cms_tpl_homesailevent">
{% 
console.log('cms_tpl_homesailevent');
if (o.object.getNumberOfItems() > 0) { 
     for(var i = 0; i < o.object.getNumberOfItems(); i++)
     {
        var item = o.object.getItem(i); 
        var titleLink = item.getPagelink();
%}<div class='cmsCard cardlayout_icontext' style='background-image: url("{%=item.getCardIconUrl()%}")'>{%

        if (titleLink) {
           %}<h3 style='margin-bottom: 0px'><a href='{%=titleLink%}' onClick="{%=item.getOnClickGoogleTracking()%}">{%=item.dataBean.title%}</a></h3>{%
        }
        else
        {
           %}<h3 style='margin-bottom: 0px'>{%=item.dataBean.title%}</h3>{%
        } %}

<p style='margin-top: 0px'> 
{%=item.dataBean.summary%}
</p>

</div>
 {%  } 
  }  %}
</script>            

<script  type="text/x-tmpl" id="cms_tpl_sponsorsview">
  {% 
  console.log('cms_tpl_sponsorsview');
  if (o.object.getNumberOfItems() > 0) {  %}
  <div class="horizimagelinks_carouselview">   
   <div class="horizimagelinks_canvas" id="sponsorcarouselview_canvas" >
  {%    for(var i = 0; i < o.object.getNumberOfItems(); i++)
        {                      
           var item = o.object.getItem(i);
           var listOfLinks = item.dataBean.listof_link;

           if (listOfLinks && listOfLinks.length)
           {               
               for(var j = 0; j <  listOfLinks.length; j++) {
                  var styleStr = '';
          %}<div style='width: 140px; height: 80px; background-color: #ffffff'>
            <a href='{%=listOfLinks[j].dataBean.propertyvalue%}' onClick="{%=listOfLinks[j].getOnClickGoogleTracking()%}" target='_blank'>
                <img src="{%=listOfLinks[j].getImageurl()%}" alt="{%=listOfLinks[j].dataBean.propertyname%}" style='{%=styleStr%}' />
            </a>
          </div> {%
                
               }
           }           
        } 
     %} </div><div class="clearfix"></div></div> {%
  }  %}   
</script>            

<script  type="text/x-tmpl" id="cms_tpl_friendsview">
  {% 
  console.log('cms_tpl_friendsview'); 
  if (o.object.getNumberOfItems() > 0) {  %}
  <div class="horizimagelinks_carouselview">   
   <div class="horizimagelinks_canvas"  >
  {%    for(var i = 0; i < o.object.getNumberOfItems(); i++)
        {                      
           var item = o.object.getItem(i);
           var listOfLinks = item.dataBean.listof_link;

           if (listOfLinks && listOfLinks.length)
           {               
               for(var j = 0; j <  listOfLinks.length; j++) {
                  var styleStr = '';
          %}<div style='width: 150px; height: 90px'>
            <a href='{%=listOfLinks[j].dataBean.propertyvalue%}' onClick="{%=listOfLinks[j].getOnClickGoogleTracking()%}" target='_blank'>
                <img src="{%=listOfLinks[j].getImageurl()%}" alt="{%=listOfLinks[j].dataBean.propertyname%}" style='{%=styleStr%}' />
            </a>
          </div> {%
                
               }
           }           
        } 
     %} </div><div class="clearfix"></div></div> {%
  }  %}   
</script>            
     
<script  type="text/x-tmpl" id="cms_tpl_cardgroup_index">
{% 
  console.log('cms_tpl_cardgroup_index'); 
  if (o.object.getNumberOfItems() > 0) {  
    %} <h2 class='title'>Indice</h2><div class='listOfDocuments'><ul class="list-unstyled"> {%
        for(var i = 0; i < o.object.getNumberOfItems(); i++)
        {
           var item = o.object.getItem(i);
           %}<!-- <li class='icon_file cmsCard_link2carddetail' data-cardid='{%=item.dataBean.cardid%}'><a href='javascript:void(0)' >{%=item.dataBean.title%}</a></li> -->{%
           %}<li class='icon_file'>{%#item.getHtmlLinkFragmentTitle2Detail(o.options.pageid)%}</li>{%
        }
    %} </ul></div> {%  
  }
  %}
</script>            

<script  type="text/x-tmpl" id="cms_tpl_cardgroup_iconicindex">
{%
  console.log('cms_tpl_cardgroup_iconicindex');
  if (o.object.getNumberOfItems() > 0) {  
  %} <div class='cf'> {% 

   for(var i = 0; i < o.object.getNumberOfItems(); i++)
   {
        var item = o.object.getItem(i); 
%}<div class='cmsCard' style='padding-left: 200px; min-height: 100px; background: url("{%=item.getCardIconUrl()%}") no-repeat left center'>{%
        
        %}<h3 style='margin-bottom: 0px'>{%#item.getHtmlLinkFragmentTitle2Detail(o.options.pageid)%}</h3>{%

        var titleLink = item.getPagelink();
        if (titleLink) {
           %}<!-- <h3 style='margin-bottom: 0px'><a href='{%=titleLink%}'>{%=item.dataBean.title%}</a></h3> -->{%
        }
        else
        {
           %}<!-- <h3 style='margin-bottom: 0px'>{%=item.dataBean.title%}</h3> -->{%
        }

%} <p style='margin-top: 0px'> 
{%=item.dataBean.summary%}
</p>
<p><b>{%=item.getRefdate()%}</b></p>
</div> {%  
   }
 
  %} </div> {%
   }  %}
</script>  

<script  type="text/x-tmpl" id="cms_tpl_cardview_type1">
<!-- BOF Left Bar: Card Icon, Documents, Links -->
<div class='r3_container' style='min-height: 300px;'>

<div class='row'>
   <div class="col-md-3 cmsCard" style='text-align: center; padding-top: 20px;'>
     <img class="icons_180" src="{%=o.object.getCardIconUrl()%}" >

{%
  var listOfDocuments = o.object.dataBean.listof_document;
  if (listOfDocuments && listOfDocuments.length)
  {               
      %} <div class='title'>Documenti</div><div class='listOfDocuments'><ul class="list-unstyled"> {%

      for(var j = 0; j <  listOfDocuments.length; j++) 
      {
      var styleStr = '';
         %}<li class='{%=listOfDocuments[j].getDocumentIconClass_16x16()%}'><a href='{%=listOfDocuments[j].getDocumenturl()%}' target='_blank' onClick="{%=listOfDocuments[j].getOnClickGoogleTracking()%}">{%=listOfDocuments[j].dataBean.propertyname%}</a></li> {%
      } 

      %} </ul></div> {%          
  } %}           

  {%
  var listOfLinks = o.object.dataBean.listof_textlink;
  if (listOfLinks && listOfLinks.length)
  {               
      %} <div class='title'>Vedi anche</div><div class='listOfDocuments'><ul class="list-unstyled"> {%

      for(var j = 0; j <  listOfLinks.length; j++) 
      {
      var styleStr = '';
         %}<li class='icon_file'><a href='{%=listOfLinks[j].dataBean.propertyvalue%}' target='_blank' onClick="{%=listOfLinks[j].getOnClickGoogleTracking()%}">{%=listOfLinks[j].dataBean.propertyname%}</a></li> {%
      } 

      %} </ul></div> {%          
  } 
  %}           

  {%
  var listOfLinks = o.object.dataBean.listof_iconlink;
  if (listOfLinks && listOfLinks.length)
  {               
      %} <div class='listOfIconLinks'><ul class="list-unstyled"> {%

      for(var j = 0; j <  listOfLinks.length; j++) 
      {
      var styleStr = '';
         %}<li style='margin-top: 0px; padding-bottom: 0px; padding-left: 0px'><a href='{%=listOfLinks[j].dataBean.propertyvalue%}' onClick="{%=listOfLinks[j].getOnClickGoogleTracking()%}" target='_blank'><img src='{%=listOfLinks[j].getIconurl()%}' /></a></li> {%
      } 

      %} </ul></div> {%          
  } 

  
  %}    
   </div>

   <div class="col-md-9 cmsCard">
   <h2 class="title" style="margin-top: 0px">
     {%#o.object.dataBean.title%}
     <br><small>{%=o.object.getRefdate()%}</small>
    </h2>

<p><i>{%#o.object.dataBean.summary%}</i></p>

{%#o.object.dataBean.textbody%}

  {% 
  if (o.object.hasExecutableHtmlFragments())
  {
      var listOfExecutableHtmlFragments = o.object.dataBean.listof_executablehtmlfragments;
      for(var h = 0; h < listOfExecutableHtmlFragments.length; h++)
      { 
         %} {%#listOfExecutableHtmlFragments[h].dataBean.propertyvalue%} {%
      }
  }   
  %}

  {% 
  var listOfGalleryImages = o.object.getListOfPropertiesByPropertyrole('cms_img_gallery');
  if (listOfGalleryImages && listOfGalleryImages.length)
  {
      %} 
      <div id="{%=o.object.dataBean.cardid%}_cms_gallery_canvas" class='cms_gallery_canvas' style='display: none'>
      <div class='title'>Immagini</div>

<div class="cms_pagination_container clearfix" style="padding: 5px; border-bottom: 1px solid #cccccc">
<nav>
  <ul class="pager">
    <li class="previous"><a href="#" id='cms_pagination_action_prev'><span aria-hidden="true">&larr;</span> Pag. Precedente</a></li>
    <li class="next"><a href="#" id='cms_pagination_action_next'>Pag. Successiva <span aria-hidden="true">&rarr;</span></a></li>
  </ul>
</nav>

<div class="cms_pagination_info">Record visualizzati da 1 a 14 di 14</div>
</div>

      <div style="width: 100%" class="cms_gallery clearfix">
      </div> 
      </div>
      {%
  }           
  %}

   </div>
</div>


</script>            

<script  type="text/x-tmpl" id="cms_tpl_cardview_type2">

<div class='cmsCard cms_tpl_cardview_type2'>

<img src='{%=o.object.getCardIconUrl()%}' style='display: block' />

<div class='title' style="margin-top: 0px">
{%#o.object.dataBean.title%}
<div>{%=o.object.getRefdate()%}</div>
</div>

<p><i>{%#o.object.dataBean.summary%}</i></p>

  {%
  var listOfDocuments = o.object.dataBean.listof_document;
  if (listOfDocuments && listOfDocuments.length)
  {               
      %} <div class='listOfDocuments'><ul class="list-unstyled"> {%

      for(var j = 0; j <  listOfDocuments.length; j++) 
      {
      var styleStr = '';
         %}<li class='{%=listOfDocuments[j].getDocumentIconClass_16x16()%}'><a href='{%=listOfDocuments[j].getDocumenturl()%}' target='_blank' onClick="{%=listOfDocuments[j].getOnClickGoogleTracking()%}" >{%=listOfDocuments[j].dataBean.propertyname%}</a></li> {%
      } 

      %} </ul></div> {%          
  } 
  %}           

{%#o.object.dataBean.textbody%}

</div>

<div class='cmsCard'>

  {%
  var listOfLinks = o.object.dataBean.listof_textlink;
  if (listOfLinks && listOfLinks.length)
  {               
      %} <div class='title'>Vedi anche</div><div class='listOfDocuments'><ul class="list-unstyled"> {%

      for(var j = 0; j <  listOfLinks.length; j++) 
      {
      var styleStr = '';
         %}<li class='icon_file'><a href='{%=listOfLinks[j].dataBean.propertyvalue%}' target='_blank' onClick="{%=listOfLinks[j].getOnClickGoogleTracking()%}">{%=listOfLinks[j].dataBean.propertyname%}</a></li> {%
      } 

      %} </ul></div> {%          
  } 
  %}           

  {%
  var listOfLinks = o.object.dataBean.listof_iconlink;
  if (listOfLinks && listOfLinks.length)
  {               
      %} <div class='listOfIconLinks'><ul> {%

      for(var j = 0; j <  listOfLinks.length; j++) 
      {
      var styleStr = '';
         %}<li style='padding-left: 0px'><a href='{%=listOfLinks[j].dataBean.propertyvalue%}' target='_blank' onClick="{%=listOfLinks[j].getOnClickGoogleTracking()%}"><img src='{%=listOfLinks[j].getIconurl()%}' /></a></li> {%
      } 

      %} </ul></div> {%          
  } 
  %}           

  {% 
  var listOfGalleryImages = o.object.getListOfPropertiesByPropertyrole('cms_img_gallery');
  if (listOfGalleryImages && listOfGalleryImages.length)
  {
      %} 
      <div id="{%=o.object.dataBean.cardid%}_cms_gallery_canvas" class='cms_gallery_canvas' style='display: none'>
      <div class='title'>Immagini</div>
      
<div class="cms_pagination_container clearfix" style="padding: 5px; border-bottom: 1px solid #cccccc">
<nav>
  <ul class="pager">
    <li class="previous"><a href="#" id='cms_pagination_action_prev'><span aria-hidden="true">&larr;</span> Pag. Precedente</a></li>
    <li class="next"><a href="#" id='cms_pagination_action_next'>Pag. Successiva <span aria-hidden="true">&rarr;</span></a></li>
  </ul>
</nav>

<div class="cms_pagination_info">Record visualizzati da 1 a 14 di 14</div>
</div>

      <div style="width: 100%" class="cms_gallery clearfix">
      </div> 
      </div>
      {%
  }           
  %}

  {%
   if (o.object.getCardImageUrl()) {
       %} <img src="{%=o.object.getCardImageUrl()%}" style='width: 100%' /> {%
   }
   %}
       
</script>     

<script  type="text/x-tmpl" id="cms_tpl_cardview_type3">

<div class='cmsCard cms_tpl_cardview_type3'>

<h2 class='title' style="margin-top: 0px">
{%#o.object.dataBean.title%}
<br /><small>{%=o.object.getRefdate()%}</small>
</h2>

<p><i>{%#o.object.dataBean.summary%}</i></p>

  {%
  var listOfDocuments = o.object.dataBean.listof_document;
  if (listOfDocuments && listOfDocuments.length)
  {               
      %} <div class='listOfDocuments'><ul class="list-unstyled"> {%

      for(var j = 0; j <  listOfDocuments.length; j++) 
      {
      var styleStr = '';
         %}<li class='{%=listOfDocuments[j].getDocumentIconClass_16x16()%}'><a href='{%=listOfDocuments[j].getDocumenturl()%}' target='_blank' onClick="{%=listOfDocuments[j].getOnClickGoogleTracking()%}">{%=listOfDocuments[j].dataBean.propertyname%}</a></li> {%
      } 

      %} </ul></div> {%          
  } 
  %}           

{%#o.object.dataBean.textbody%}

</div>

<div class='cmsCard'>

  {%
  var listOfLinks = o.object.dataBean.listof_textlink;
  if (listOfLinks && listOfLinks.length)
  {               
      %} <div class='title'>Vedi anche</div><div class='listOfDocuments'><ul class="list-unstyled"> {%

      for(var j = 0; j <  listOfLinks.length; j++) 
      {
      var styleStr = '';
         %}<li class='icon_file'><a href='{%=listOfLinks[j].dataBean.propertyvalue%}' target='_blank' onClick="{%=listOfLinks[j].getOnClickGoogleTracking()%}">{%=listOfLinks[j].dataBean.propertyname%}</a></li> {%
      } 

      %} </ul></div> {%          
  } 
  %}           

  {%
  var listOfLinks = o.object.dataBean.listof_iconlink;
  if (listOfLinks && listOfLinks.length)
  {               
      %} <div class='listOfIconLinks'><ul> {%

      for(var j = 0; j <  listOfLinks.length; j++) 
      {
      var styleStr = '';
         %}<li style='padding-left: 0px'><a href='{%=listOfLinks[j].dataBean.propertyvalue%}' target='_blank' onClick="{%=listOfLinks[j].getOnClickGoogleTracking()%}"><img src='{%=listOfLinks[j].getIconurl()%}' /></a></li> {%
      } 

      %} </ul></div> {%          
  } 
  %}           

  {% 
  if (o.object.hasExecutableHtmlFragments())
  {
      var listOfExecutableHtmlFragments = o.object.dataBean.listof_executablehtmlfragments;
      for(var h = 0; h < listOfExecutableHtmlFragments.length; h++)
      { 
         %} {%#listOfExecutableHtmlFragments[h].dataBean.propertyvalue%} {%
      }
  }   
  %}

  {% 
  var listOfGalleryImages = o.object.getListOfPropertiesByPropertyrole('cms_img_gallery');
  if (listOfGalleryImages && listOfGalleryImages.length)
  {
      %} 
      <div id="{%=o.object.dataBean.cardid%}_cms_gallery_canvas" class='cms_gallery_canvas' style='display: none'>
      <div class='title'>Immagini</div>
      
<div class="cms_pagination_container clearfix" style="padding: 5px; border-bottom: 1px solid #cccccc">
<nav>
  <ul class="pager">
    <li class="previous"><a href="#" id='cms_pagination_action_prev'><span aria-hidden="true">&larr;</span> Pag. Precedente</a></li>
    <li class="next"><a href="#" id='cms_pagination_action_next'>Pag. Successiva <span aria-hidden="true">&rarr;</span></a></li>
  </ul>
</nav>

<div class="cms_pagination_info">Record visualizzati da 1 a 14 di 14</div>
</div>

      <div style="width: 100%" class="cms_gallery clearfix freewall-gallery">
      </div> 
      </div>
      {%
  }           
  %}

  {%
   if (o.object.getCardImageUrl()) {
       %} <img src="{%=o.object.getCardImageUrl()%}" style='width: 100%' /> {%
   }
   %}
       
</script>     
              
<script type="text/x-tmpl" id="cms_tpl_regatta_channelshomeportlet">
{% 
console.log('cms_tpl_regatta_channelshomeportlet'); 
if (o.object.getNumberOfItems() > 0) {  
%}

<div class="box box-solid box-primary">
  <div class="box-header with-border">
    <h3 class="box-title">Canale VHF09</h3>
  </div>
  <div class="box-body">

{% 
   for(var i = 0; i < o.object.getNumberOfItems(); i++)
   {
        var item = o.object.getItem(i); %} 
   <p style='margin-top: 0px'>
   <b>{%=item.getRefdate()%} - {%#item.getHtmlLinkFragmentTitle2Detail(o.options.pageid)%}</b> - {%=item.dataBean.summary%}
   </p> 
{% } %}

  </div>
</div>

{% } %}
</script>

<script type="text/x-tmpl" id="cms_tpl_cardview_gallery_old_20170911">

{%  
  var listOfGalleryImages = o.listOfGalleryImages;
  var iDisplayStart = o.iDisplayStart;
  var iDisplayLength = o.iDisplayLength;
  
  for(var j = iDisplayStart; j <  (iDisplayStart + iDisplayLength); j++) {
      
      %} <div class="cms_gallery_icon"> 
            <span class="image_valign_helper"></span>             
            <a title="{%=listOfGalleryImages[j].dataBean.propertyname%}" rel="lightbox-{%=o.cardid%}" href="{%=listOfGalleryImages[j].getImageurl()%}">
            <img border="0" src="{%=listOfGalleryImages[j].getIconurl()%}"></a>  </div>  {% 
  }
%}

</script>
  
<script type="text/x-tmpl" id="cms_tpl_cardview_gallery">

{%  
  var listOfGalleryImages = o.listOfGalleryImages;
  var iDisplayStart = o.iDisplayStart;
  var iDisplayLength = o.iDisplayLength;
  
  for(var j = iDisplayStart; j <  (iDisplayStart + iDisplayLength); j++) {
      
%} 
		<div class="brick size11">
		    <a href='{%=listOfGalleryImages[j].getImageurl()%}' rel="lightbox-{%=o.cardid%}"  title='{%=listOfGalleryImages[j].dataBean.propertyname%}' >
			<i style='background : url("{%=listOfGalleryImages[j].getIconurl()%}") no-repeat center; background-size: cover; width: 100%; height: 100%; display: block;'>
			</i>	
					</a>		
		</div>  
{% 
  }
%}

</script>
  
<script  type="text/x-tmpl" id="cms_tpl_cardsetlistofdocuments">
{% 
console.log('cms_tpl_cardsetlistofdocuments'); 
if (o.object.getNumberOfItems() > 0) {  %}
<div class='cmsCard'>

 {%  for(var i = 0; i < o.object.getNumberOfItems(); i++)
     {
        var item = o.object.getItem(i);
        var listOfDocuments = item.dataBean.listof_document;
        if (listOfDocuments && listOfDocuments.length)
        {
        %}<div class='listOfDocuments'><ul  class="list-unstyled">{%
        for(var j = 0; j <  listOfDocuments.length; j++) 
        {
          %}<li class='{%=listOfDocuments[j].getDocumentIconClass_16x16()%}'><a href='{%=listOfDocuments[j].getDocumenturl()%}' onClick="{%=listOfDocuments[j].getOnClickGoogleTracking()%}" target='_blank'>{%=listOfDocuments[j].dataBean.propertyname%}</a></li> {% 
        }
        %}</ul></div>{%
        }

      } %}

</div>
{% }  %}
</script>  

<script  type="text/x-tmpl" id="cms_tpl_sev_welcome">
<div class="box box-solid box-default">
  <div class="box-header with-border">
    <h3 class="box-title">{%#o.object.dataBean.title%}</h3>    
  </div>
  <div class="box-body">
{%#o.object.dataBean.textbody%}
  </div>
</div> 
</script>  
           
<script  type="text/x-tmpl" id="cms_tpl_embeddedfragments">
{% 
  if (o.object.hasExecutableHtmlFragments())
  {
      var listOfExecutableHtmlFragments = o.object.dataBean.listof_executablehtmlfragments;
      for(var h = 0; h < listOfExecutableHtmlFragments.length; h++)
      { 
         %} {%#listOfExecutableHtmlFragments[h].dataBean.propertyvalue%} {%
      }
  }   
%}
</script>

<script  type="text/x-tmpl" id="cms_tpl_page_index">
{% 
  if (o.aaData && o.aaData.length > 0) {  
    %} <div class='title'>Indice</div><div class='listOfDocuments'><ul class="list-unstyled"> {%
        for(var i = 0; i < o.aaData.length; i++)
        {
           var item = o.aaData[i];           
           %}<li class='icon_file'><a href='cmspage.do?pageid={%=item.pageid%}'>{%#item.pagetitle%}</a></li>{%
        }
    %} </ul></div> {%  
  }
  %}
</script> 

<script  type="text/x-tmpl" id="cms_tpl_wall_link">
  <div class="walloflinks_view">   
  <div class="walloflinks_canvas clearfix"  >
{% 
    var item = o.object;
    var listOfLinks = item.dataBean.listof_link;

    if (listOfLinks && listOfLinks.length)
    {               
         for(var j = 0; j <  listOfLinks.length; j++) {
                  var styleStr = '';
          %}<div style='background-color: #ffffff'>
            <a href='{%=listOfLinks[j].dataBean.propertyvalue%}' onClick="{%=listOfLinks[j].getOnClickGoogleTracking()%}" target='_blank'>
                <img src="{%=listOfLinks[j].getImageurl()%}" alt="{%=listOfLinks[j].dataBean.propertyname%}" style='{%=styleStr%}' />
            </a>
          </div> {%                
         }
    }           
 %}
  
   </div>
   <div class="clear_float"></div>
   </div>
</script> 

 <!-- The template to display files available for upload -->
<script id="template-upload" type="text/x-tmpl">
{% for (var i=0, file; file=o.files[i]; i++) { %}
    <tr class="template-upload fade">
        <td>
            <span class="preview"></span>
        </td>
        <td>
            <p class="name">{%=file.name%}</p>
            <strong class="error text-danger"></strong>
        </td>
        <td>
            <p class="size">Processing...</p>
            <div class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0"><div class="progress-bar progress-bar-success" style="width:0%;"></div></div>
        </td>
        <td>
            {% if (!i && !o.options.autoUpload) { %}
                <button class="btn btn-primary start" disabled>
                    <i class="glyphicon glyphicon-upload"></i>
                    <span>Start</span>
                </button>
            {% } %}
            {% if (!i) { %}
                <button class="btn btn-warning cancel">
                    <i class="glyphicon glyphicon-ban-circle"></i>
                    <span>Cancel</span>
                </button>
            {% } %}
        </td>
    </tr>
{% } %}
</script>

<script id="template-download" type="text/x-tmpl">
{% for (var i=0, file; file=o.files[i]; i++) { %}
    <tr class="template-download fade">
        <td>
            <span class="preview">
                {% if (file.thumbnailUrl) { %}
                    <a href="{%=file.url%}" title="{%=file.name%}" download="{%=file.name%}" data-gallery><img src="{%=file.thumbnailUrl%}"></a>
                {% } %}
            </span>
        </td>
        <td>
            <p class="name">
                {% if (file.url) { %}
                    <a href="{%=file.url%}" title="{%=file.name%}" download="{%=file.name%}" {%=file.thumbnailUrl?'data-gallery':''%}>{%=file.name%}</a>
                {% } else { %}
                    <span>{%=file.name%}</span>
                {% } %}
            </p>
            {% if (file.error) { %}
                <div><span class="label label-danger">Error</span> {%=file.error%}</div>
            {% } %}
        </td>
        <td>
            <span class="size">{%=o.formatFileSize(file.size)%}</span>
        </td>
        <td>
            {% if (file.deleteUrl) { %}
                <button class="btn btn-danger delete" data-type="{%=file.deleteType%}" data-url="{%=file.deleteUrl%}"{% if (file.deleteWithCredentials) { %} data-xhr-fields='{"withCredentials":true}'{% } %}>
                    <i class="glyphicon glyphicon-trash"></i>
                    <span>Delete</span>
                </button>
                <input type="checkbox" name="delete" value="1" class="toggle">
            {% } else { %}
                <button class="btn btn-warning cancel">
                    <i class="glyphicon glyphicon-ban-circle"></i>
                    <span>Cancel</span>
                </button>
            {% } %}
        </td>
    </tr>
{% } %}
</script>
              
              
</r3_lang:environment>
