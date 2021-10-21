<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>


<div class="modal fade" id='photo_dialog' tabindex="-1" role="dialog" aria-labelledby="photo_dialog">
	<div class="modal-dialog r3_img_cropcanvas" style='width: 530px'>
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Modal title</h4>
			</div>
			<div class="modal-body ">
				<div id="result" class="result" style='width: 500px; max-height: 500px; line-height: 0'></div>
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary"
					id='r3_img_cropcanvas_commit'>Save changes</button>
			</div>
		</div>
	</div>
</div>

<div class="panel tabbed-panel">
  <div class="panel-heading" >  
    <h3 class="panel-title">Foto Utente</h3>
  </div>
  <div class="panel-body">
  
    <div class='row'>
    
    <div class='col-md-6'>

    <div id="cmsattachment_userphoto_canvas" class="r3_loadimage_canvas" >
    <div class="overlay" >
    <i class="fa fa-refresh fa-spin fa-3x"></i>
    </div>
    <div class="loadimage_canvas_image_canvas">
        <img class="loadimage_canvas_img"  src="/r3ng/resources/sites/default/default_avatar_male.jpg" alt="Avatar Photo" >
        <div class="loadimage_canvas_selectiontrigger" ><i class="fa fa-camera fa-2x"></i></div>
    </div>
    </div>
    
    <input id="cmsattachment_userphoto_input_file" name="files[]" type="file" class="photofileinput" style="opacity: 0">
    
    </div>
    
    <div class='col-md-6'>
    <p>Funzionalità in fase di sperimentazione</p>
    </div>
    
  </div>
  
  </div>
</div>
