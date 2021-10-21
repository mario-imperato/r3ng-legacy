<%@ taglib uri="http://www.r3.org/taglibs/r3/lang-1.00" prefix="r3_lang" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,
    java.util.*
    " %>



<input id="mongotimeline_input_file" name="files[]" type="file" style="opacity: 0; position: absolute;">
<div class="modal fade" id='mongotimeline_photo_dialog' tabindex="-1" role="dialog" aria-labelledby="photo_dialog">
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

<div class="mongotimeline_edit_content" style='display: none'></div>

<div class="mongotimeline_newpost_canvas" ></div> 
<div class="mongotimeline_childpost_canvas" style='display: none'></div> 
 
<div class='mongotimeline_posts_cnt' ></div>
<div class='mongotimeline_loadmorecontentprogress' class='text-center' style='display: none'><i class="fa fa-spinner fa-spin fa-3x"></i></div>
 

