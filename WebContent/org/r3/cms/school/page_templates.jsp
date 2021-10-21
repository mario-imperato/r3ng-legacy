<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="java.io.*,
    java.util.*
    " %>

<r3_lang:environment id="r3Env">

<script type="text/x-tmpl" id="cms_tpl_simple">
  <div class="cmsCard">
  {%#o.dataBean.textbody%}
  </div>
</script>
  
<script type="text/x-tmpl" id="cms_tpl_notfound">
  <div class="cmsCard">
  <h3>Card: {%=o.cardid%}</h3>
  <p>Not found</p>
  </div>
</script>

<script  type="text/x-tmpl" id="cms_tpl_sponsorsview">
  {% if (o.getNumberOfItems() > 0) {  %}
  <div class="horizimagelinks_carouselview">   
   <div class="horizimagelinks_canvas" id="sponsorcarouselview_canvas" >
  {%    for(var i = 0; i < o.getNumberOfItems(); i++)
        {           
           stream(log);

           var item = o.getItem(i);
           var listOfLinks = item.dataBean.listof_link;

           if (listOfLinks && listOfLinks.length)
           {               
               for(var j = 0; j <  listOfLinks.length; j++) {
                  var styleStr = '';
          %}<div style='width: 140px; height: 80px'>
            <a href='{%=listOfLinks[j].dataBean.propertyvalue%}' target='_blank'>
                <img src="{%=listOfLinks[j].getImageurl()%}" alt="{%=listOfLinks[j].dataBean.propertyname%}" style='{%=styleStr%}' />
            </a>
          </div> {%
                stream(log);
               }
           }           
        } 
     %} </div><div class="clearfix"></div></div> {%
  }  %}   
</script>            
     
<script  type="text/x-tmpl" id="cms_tpl_cardgroup_index">
{% 
  if (o.getNumberOfItems() > 0) {  
    %} <div class='title'>Corsi/Dettagli</div><div class='listOfDocuments'><ul> {%
        for(var i = 0; i < o.getNumberOfItems(); i++)
        {
           var item = o.getItem(i);
           %}<li class='icon_file cmsCard_link2carddetail' data-cardid='{%=item.dataBean.cardid%}'><a href='javascript:void(0)' >{%=item.dataBean.title%}</a></li>{%
        }
    %} </ul></div> {%  
  }
  %}
</script>            
     
<script  type="text/x-tmpl" id="cms_tpl_cardview_type1">
<!-- BOF Left Bar: Card Icon, Documents, Links -->
<div style='float:left; min-height: 300px; width: 200px; margin-right: 10px; padding: 0px; '>

<div class='cmsCard' style='min-height: 300px; border-right: 1px solid #aaaaaa'>
<div class="borderless d20170212-sidebar">
<img class="icons_180" src="{%=o.getCardIconUrl()%}" >

{%
  var listOfDocuments = o.dataBean.listof_document;
  if (listOfDocuments && listOfDocuments.length)
  {               
      %} <div class='title'>Documenti</div><div class='listOfDocuments'><ul> {%

      for(var j = 0; j <  listOfDocuments.length; j++) 
      {
      var styleStr = '';
         %}<li class='{%=listOfDocuments[j].getDocumentIconClass_16x16()%}'><a href='{%=listOfDocuments[j].getDocumenturl()%}' target='_blank'>{%=listOfDocuments[j].dataBean.propertyname%}</a></li> {%
      } 

      %} </ul></div> {%          
  } %}           

  {%
  var listOfLinks = o.dataBean.listof_textlink;
  if (listOfLinks && listOfLinks.length)
  {               
      %} <div class='title'>Vedi anche</div><div class='listOfDocuments'><ul> {%

      for(var j = 0; j <  listOfLinks.length; j++) 
      {
      var styleStr = '';
         %}<li class='icon_file'><a href='{%=listOfLinks[j].dataBean.propertyvalue%}' target='_blank'>{%=listOfLinks[j].dataBean.propertyname%}</a></li> {%
      } 

      %} </ul></div> {%          
  } 
  %}           

  {%
  var listOfLinks = o.dataBean.listof_iconlink;
  if (listOfLinks && listOfLinks.length)
  {               
      %} <div class='listOfDocuments'><ul> {%

      for(var j = 0; j <  listOfLinks.length; j++) 
      {
      var styleStr = '';
         %}<li style='padding-left: 0px'><a href='{%=listOfLinks[j].dataBean.propertyvalue%}' target='_blank'><img src='{%=listOfLinks[j].getIconurl()%}' /></a></li> {%
      } 

      %} </ul></div> {%          
  } 
  %}           

</div>
</div>
 
</div>
<!-- EOF Left Bar: Card Icon, Documents, Links -->

<!-- BOF Center Canvas -->
<div style='float:left; min-height: 100px; width: 740px; margin-right: 10px; padding: 0px;'>

<div class='cmsCard'>

<div class='title'>
{%#o.dataBean.title%}
<div>{%=o.getRefdate()%}</div>
</div>

<p><i>{%#o.dataBean.summary%}</i></p>

{%#o.dataBean.textbody%}

<!--
<div class='listOfDocuments'>
<ul>
<li class='icon_application_pdf'><a href='pippo'>Open a Document</a></li>
</ul>
</div>
-->

  {% 
  var listOfGalleryImages = o.getListOfPropertiesByPropertyrole('cms_img_gallery');
  if (listOfGalleryImages && listOfGalleryImages.length)
  {
      %} <div class='title'>Immagini</div><div style="width: 100%" class="gallery cf"> {%          

      for(var j = 0; j <  listOfGalleryImages.length; j++) {

      %} <div class="img_icon"><a title="{%=listOfGalleryImages[j].dataBean.propertyname%}" rel="lightbox-{%=o.dataBean.cardid%}" href="{%=listOfGalleryImages[j].getImageurl()%}">
            <img border="0" style="margin-top: {%=listOfGalleryImages[j].getIconMarginTop()%}px;" src="{%=listOfGalleryImages[j].getIconurl()%}"></a></div> {% 

      }

      %} </div></div>  {%
  }           
  %}
       
</div>
<!-- EOF Center Canvas -->

</script>            

<script  type="text/x-tmpl" id="cms_tpl_cardview_type2">

{%
 if (o.getCardIconUrl()) 
 {
%} <div class='cmsCard' style='padding-left: 200px; min-height: 135px; background: url("{%=o.getCardIconUrl()%}") no-repeat left center'> {%
 }
 else
 {
%} <div class='cmsCard' > {%
 }
 %}

<div class='title'>
{%#o.dataBean.title%}
<div>{%=o.getRefdate()%}</div>
</div>

<p><i>{%#o.dataBean.summary%}</i></p>

{%#o.dataBean.textbody%}

</div>

<div class='cmsCard'>

  {%
  var listOfDocuments = o.dataBean.listof_document;
  if (listOfDocuments && listOfDocuments.length)
  {               
      %} <div class='title'>Documenti</div><div class='listOfDocuments'><ul> {%

      for(var j = 0; j <  listOfDocuments.length; j++) 
      {
      var styleStr = '';
         %}<li class='{%=listOfDocuments[j].getDocumentIconClass_16x16()%}'><a href='{%=listOfDocuments[j].getDocumenturl()%}' target='_blank'>{%=listOfDocuments[j].dataBean.propertyname%}</a></li> {%
      } 

      %} </ul></div> {%          
  } 
  %}           

  {%
  var listOfLinks = o.dataBean.listof_textlink;
  if (listOfLinks && listOfLinks.length)
  {               
      %} <div class='title'>Vedi anche</div><div class='listOfDocuments'><ul> {%

      for(var j = 0; j <  listOfLinks.length; j++) 
      {
      var styleStr = '';
         %}<li class='icon_file'><a href='{%=listOfLinks[j].dataBean.propertyvalue%}' target='_blank'>{%=listOfLinks[j].dataBean.propertyname%}</a></li> {%
      } 

      %} </ul></div> {%          
  } 
  %}           

  {%
  var listOfLinks = o.dataBean.listof_iconlink;
  if (listOfLinks && listOfLinks.length)
  {               
      %} <div class='listOfDocuments'><ul> {%

      for(var j = 0; j <  listOfLinks.length; j++) 
      {
      var styleStr = '';
         %}<li style='padding-left: 0px'><a href='{%=listOfLinks[j].dataBean.propertyvalue%}' target='_blank'><img src='{%=listOfLinks[j].getIconurl()%}' /></a></li> {%
      } 

      %} </ul></div> {%          
  } 
  %}           

  {% 
  var listOfGalleryImages = o.getListOfPropertiesByPropertyrole('cms_img_gallery');
  if (listOfGalleryImages && listOfGalleryImages.length)
  {
      %} <div class='title'>Immagini</div><div style="width: 100%" class="gallery cf"> {%          

      for(var j = 0; j <  listOfGalleryImages.length; j++) {

      %} <div class="img_icon"><a title="{%=listOfGalleryImages[j].dataBean.propertyname%}" rel="lightbox-{%=o.dataBean.cardid%}" href="{%=listOfGalleryImages[j].getImageurl()%}">
            <img border="0" style="margin-top: {%=listOfGalleryImages[j].getIconMarginTop()%}px;" src="{%=listOfGalleryImages[j].getIconurl()%}"></a></div> {% 

      }

      %} </div></div>  {%
  }           
  %}
       
</script>     

<script  type="text/x-tmpl" id="cms_tpl_cardview_type3">

<div class='cmsCard'>

<div class='title'>
{%#o.dataBean.title%}
<div>{%=o.getRefdate()%}</div>
</div>

<p><i>{%#o.dataBean.summary%}</i></p>

  {%
  var listOfDocuments = o.dataBean.listof_document;
  if (listOfDocuments && listOfDocuments.length)
  {               
      %} <div class='listOfDocuments'><ul> {%

      for(var j = 0; j <  listOfDocuments.length; j++) 
      {
      var styleStr = '';
         %}<li class='{%=listOfDocuments[j].getDocumentIconClass_16x16()%}'><a href='{%=listOfDocuments[j].getDocumenturl()%}' target='_blank'>{%=listOfDocuments[j].dataBean.propertyname%}</a></li> {%
      } 

      %} </ul></div> {%          
  } 
  %}           

{%#o.dataBean.textbody%}

</div>

<div class='cmsCard'>

  {%
  var listOfLinks = o.dataBean.listof_textlink;
  if (listOfLinks && listOfLinks.length)
  {               
      %} <div class='title'>Vedi anche</div><div class='listOfDocuments'><ul> {%

      for(var j = 0; j <  listOfLinks.length; j++) 
      {
      var styleStr = '';
         %}<li class='icon_file'><a href='{%=listOfLinks[j].dataBean.propertyvalue%}' target='_blank'>{%=listOfLinks[j].dataBean.propertyname%}</a></li> {%
      } 

      %} </ul></div> {%          
  } 
  %}           

  {%
  var listOfLinks = o.dataBean.listof_iconlink;
  if (listOfLinks && listOfLinks.length)
  {               
      %} <div class='listOfDocuments'><ul> {%

      for(var j = 0; j <  listOfLinks.length; j++) 
      {
      var styleStr = '';
         %}<li style='padding-left: 0px'><a href='{%=listOfLinks[j].dataBean.propertyvalue%}' target='_blank'><img src='{%=listOfLinks[j].getIconurl()%}' /></a></li> {%
      } 

      %} </ul></div> {%          
  } 
  %}           

  {% 
  var listOfGalleryImages = o.getListOfPropertiesByPropertyrole('cms_img_gallery');
  if (listOfGalleryImages && listOfGalleryImages.length)
  {
      %} <div class='title'>Immagini</div><div style="width: 100%" class="gallery cf"> {%          

      for(var j = 0; j <  listOfGalleryImages.length; j++) {

      %} <div class="img_icon"><a title="{%=listOfGalleryImages[j].dataBean.propertyname%}" rel="lightbox-{%=o.dataBean.cardid%}" href="{%=listOfGalleryImages[j].getImageurl()%}">
            <img border="0" style="margin-top: {%=listOfGalleryImages[j].getIconMarginTop()%}px;" src="{%=listOfGalleryImages[j].getIconurl()%}"></a></div> {% 

      }

      %} </div></div>  {%
  }           
  %}
       
  {%
   if (o.getCardImageUrl()) {
       %} <img src="{%=o.getCardImageUrl()%}" style='width: 100%' /> {%
   }
   %}
  
</script>     
              
</r3_lang:environment>