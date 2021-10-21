<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>


<!-- Rispetto alla versione completa il template non contiene il pannello modale e il file input field che debbono essere forniti
     dall'ambiente circostante. Serve nei casi in cui la funzione puo' essere invocata in piu' punti nella stessa pagina e il pannello modale viene 
     fattrizzato in un unica locazione.
 -->
    <div id="loadimage_canvas" class="r3_loadimage_canvas {%=o.viewConfigOptions.cssClassName%}" style='display: inline-block'>
    <div class="overlay" >
    <i class="fa fa-refresh fa-spin fa-3x"></i>
    </div>
    <div class="loadimage_canvas_image_canvas" style='max-width: 400px'>
        <img class="loadimage_canvas_img"  src="/r3ng/resources/sites/default/default_avatar_male.jpg" alt="Avatar Photo" >
        <div class="loadimage_canvas_selectiontrigger" ><i class="fa fa-camera fa-2x"></i></div>
    </div>
    </div>
    
