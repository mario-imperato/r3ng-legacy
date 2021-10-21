$.r3Utils.namespace("org.r3.jsportlet.imageupload");

org.r3.jsportlet.imageupload.UserPhotoActionFormView = org.r3.ActionFormView.extend(
{
	init : function(anHtmlActionFormContainerId, anActionFormManager)
	{
		this._super(anHtmlActionFormContainerId, anActionFormManager);
		this.defaultConfigOptions = { 
			 "extraInfo" : [ { "name": "cms_attachtype" , "value" : "userphoto" }], "aspectratio": 1, "maxsize": [300, 300],
			 "templateFile" : "UserPhotoActionFormView.html.jsp"
		};		
		this.configOptions = null;
	},

	close : function()
	{
		this.hide();
	},
	
	open : function(aConfigHash)
	{
		if (aConfigHash)
		     this.configOptions = $.extend({}, this.defaultConfigOptions, aConfigHash);
		else this.configOptions = this.defaultConfigOptions;
		
		org.r3.PageManager.wait("org.r3.message.waiting");
		var networkRequestsQueue = [];
		networkRequestsQueue.push(
		{
			id : "view",
			type : "Get",
			url : org.r3.PageManager.getVersionedUIURL(org.r3.Constants.applicationContext + '/org/r3/jsportlet/imageupload/' + this.configOptions.templateFile),
			dataType : "html"
		});

		// networkRequestsQueue.push(org.r3.PageManager.lutManager.getLUTNetworkRequest(this, 'LUT_SailEvent'));
		
		org.r3.PageManager.multiAjax(networkRequestsQueue,

		$.r3Utils.hitch(this, function(responseData)
		{
			org.r3.PageManager.closeNotifier();			 	
			
			$(this.htmlContainerId).html(tmpl(responseData['view'], {}));												
			
			var userPhotoUrl = org.r3.PageManager.userInfo.getUserPhoto();
			if (userPhotoUrl)
			{
				loadImage(userPhotoUrl, function (img) {
					var userphoto_avatar_image = $('#cmsattachment_userphoto_canvas .loadimage_canvas_img');
					$('#cmsattachment_userphoto_canvas .loadimage_canvas_img')[0].src = img.src;
                });
			}
			
			// $('#startdemo').click($.r3Utils.hitch(this, function(e) {this.demo();}));
			$('#cmsattachment_userphoto_input_file').on('change', $.r3Utils.hitch(this, this.onFileSelected));
			$('#cmsattachment_userphoto_canvas .overlay').hide();
		    $(document)
	        .on('dragover', function (e) {
	            e.preventDefault();
	            e = e.originalEvent;
	            e.dataTransfer.dropEffect = 'copy';
	        })
	        .on('drop', $.r3Utils.hitch(this, this.onFileSelected));
		    
		    $('#cmsattachment_userphoto_canvas .loadimage_canvas_selectiontrigger').unbind().click(function(e) { 
		    	$('#cmsattachment_userphoto_input_file').trigger('click'); 
		    } );
		    
//			$('#imageCanvasCnt').imagecanvas({
//				inputFileWidgetId: '#bkg_img1'
//			});
			
//			$("div#userphoto-dropzone").dropzone({ 
//				url: "/r3ng/was/cvfxxxvchamp/it/cms/cards/00_METEO/files",
//				addRemoveLinks: true,
//				maxFiles: 1,
//				acceptedFiles: "image/*",
//				maxfilesexceeded: function(file)
//				{
//				alert('You have uploaded more than 1 Image. Only the first file will be uploaded!');
//				},
//				createImageThumbnails: false,
//				clickable: '#clickableid',
//				previewContainer: false
//			});
			
//			$('#bkg_img').on("change", function(event)
//			{ 
//				var t = $(event.currentTarget);
//				var file = $(t)[0].files[0];
//				var preview = $('#myImage');
//				
//				console.log("Selected File is", file);	
//				
//				var reader  = new FileReader();
//
//			    reader.onloadend = function () 
//			    {
//			    	// preview[0].src = reader.result;	
//			    	var img = new Image();
//			    	img.onload = function () {
//			    		console.log(this.width + " " + this.height);
//			    		
//			    		$('#myCanvas').css("background", 'url(' + reader.result + ') no-repeat');
//				    	
//				    	$('#myCanvas').backgroundDraggable({
//			    		  done: function() {
//			    		    backgroundPosition = $('#myCanvas').css('background-position');
//			    		    console.log(backgroundPosition);
//			    		    
//			    		    var bkgInfo = backgroundPosition.split(/px\s*/);
//			    		  }
//			    		});
//			        };
//			        
//			        img.src = reader.result;
////			        var _URL = window.URL || window.webkitURL;
////			        img.src = _URL.createObjectURL(file);
//			        
//			    	
//			    	
//			    };
//
//			    if (file) 
//			    {
//			    	reader.readAsDataURL(file);
//			    } 
//			    else 
//			    {
//			    	preview.src = "";
//			    }				  
//			});
			
//			$("#avatar").fileinput({
//				showPreview : true,  // Non ti fa vedere nulla
//				// uploadUrl : "/r3ng/was/cvfxxxvchamp/it/cms/cards/00_METEO/files",
//				uploadUrl : "/r3ng/org/r3/jsportlet/dropzone/upload_mockup.json",
//			    overwriteInitial: true,
//			    resizeImage: true,
//			    resizePreference: 'contain',
//			    maxImageWidth: 200,
//			    maxImageHeight: 200,
//			    showUpload: true,
//			    uploadAsync: true,
//			    maxFileSize: 1000,
//			    showClose: false,
//			    showCaption: false,
//			    browseLabel: '',
//			    removeLabel: '',
//			    browseIcon: '<i class="glyphicon glyphicon-folder-open"></i>',
//			    removeIcon: '<i class="glyphicon glyphicon-remove"></i>',
//			    removeTitle: 'Cancel or reset changes',
//			    elErrorContainer: '#kv-avatar-errors',
//			    msgErrorClass: 'alert alert-block alert-danger',
//			    defaultPreviewContent: '<img src="' + org.r3.Constants.getSiteResourceUrl('default_avatar_male.jpg') + '" alt="Your Avatar" style="width:160px">',
//			    layoutTemplates: {
//			    	 main2: '{preview}',
//			    	 actions: '<div class="file-actions">\n' +
//			         '    <div class="file-footer-buttons">\n' +
//			         '        {upload}' +
//			         '    </div>\n' +
//			         '    <div class="file-upload-indicator" tabindex="-1" title="{indicatorTitle}">{indicator}</div>\n' +
//			         '    <div class="clearfix"></div>\n' +
//			         '</div>'
//			    },
//			    allowedFileExtensions: ["jpg", "png", "gif"]
//			});
//			
//			$('#mytrigger').click($.r3Utils.hitch(this, function() {
//				this.doUploadUserPhoto();
//			}));
//			
//			$('#avatar').on('filecleared', function(event) {
//			    console.log("filecleared");
//			});
//			
//			$('#avatar').on('fileclear', function(event) {
//			    console.log("fileclear");
//			});
//			
//			$('#avatar').on('filepredelete', function(event) {
//			    console.log("filepredelete", arguments);
//			});
//			
//			$('#avatar').on('filereset', function(event) {
//			    console.log("filereset");
//			    
//				$('#avatar-canvas .file-default-preview').click(function() {
//					$("#avatar").trigger('click');
//				});
//			});
//			
//			$('#avatar').on('fileloaded', $.r3Utils.hitch(this, function(event) {
//			    console.log("fileloaded");
//			    // $("#avatar").fileinput('upload');
//			    var img = $('#avatar-canvas img.file-preview-image');
//			    console.log('Img: ', img, img.get(0).naturalWidth, img.get(0).naturalHeight);
//				$('#avatar-canvas .file-preview-image').click(function() {
//					$("#avatar").trigger('click');
//				});
//			}));
//			
//			$('#avatar').on('fileimageloaded', $.r3Utils.hitch(this, function(event) {
//			    console.log("fileimageloaded");
//			    // $("#avatar").fileinput('upload');
//			    var img = $('#avatar-canvas img.file-preview-image');
//			    console.log('Img: ', img, img.get(0).naturalWidth, img.get(0).naturalHeight);
//				$('#avatar-canvas .file-preview-image').click(function() {
//					$("#avatar").trigger('click');
//				});
//			}));
//		
//			
//			$('#avatar').on('fileuploaded', function(event, data, previewId, index) {
//			    console.log("fileuploaded", arguments);
//			 
////			    $('#avatar').fileinput('refresh', {
////			    	
////			    	  defaultPreviewContent: '<img src="' + org.r3.Constants.getSiteResourceUrl('default_avatar_male.jpg') + '" alt="Your Avatar2" style="width:160px">',
////				});
//			    
//				$('#avatar-canvas .file-preview-initial').click(function() {
//					$("#avatar").trigger('click');
//				});
//				
//			});
//			
//			$('#avatar-canvas .file-preview-image').click(function() {
//				$("#avatar").trigger('click');
//			});
//			
//
//			
//			$('#avatar').on('fileerror', function(event, data) {
//				   console.log(data.id);
//				   console.log(data.index);
//				   console.log(data.file);
//				   console.log(data.reader);
//				   console.log(data.files);
//				   
//				   $('#avatar-canvas .file-preview-other').click(function() {
//						$("#avatar").trigger('click');
//				   });
//			});
//			
//			$('#avatar-canvas .file-default-preview').click(function() {
//				$("#avatar").trigger('click');
//			});
			
			this.show();
		}),

		// Error.
		function(d)
		{
			console.error("controller did not load");
		});
		
	},
	
	onFileSelected: function(e)
	{
        e.preventDefault();
        e = e.originalEvent;
        var target = e.dataTransfer || e.target,
            file = target && target.files && target.files[0]
            ;
        
        if (!file) {
            return;
        }
        
        this.processFile(file);        
    },

    processFile: function(aFile)
    {
    	$('#cmsattachment_userphoto_input_file').val("");
    	
    	var _self = this;
    	
//    	var result = $('#result'),
//            exifNode = $('#exif'),
//            thumbNode = $('#thumbnail'),
//            actionsNode = $('#actions');
        
        var options = {
                // maxWidth: result.width(),
                canvas: true
        };
    	
    	$('#photo_dialog').loadImage1({ 
    		file: aFile, 
    		
    		aspectRatio: 1,
    		maxSize: [ 300, 300 ],
    		    		
    		processImage : function(img_or_canvas, exifData) 
    		{ 
    			$('#cmsattachment_userphoto_canvas .loadimage_canvas_img')[0].src = img_or_canvas.toDataURL(aFile.type);
    			img_or_canvas.toBlob(
	            	     function (blob) {
	            	    	 console.log(blob);
	            	    	 
	            	    	 var fd = new FormData();
	            	    	 fd.append('file', blob, aFile.name);
	            	    	 if (exifData)
	            	    	 {
	            	    		 for (var prop in exifData) {
	            	                if (exifData.hasOwnProperty(prop)) {
	            	                	fd.append('exif_' + prop, exifData[prop]);	            	                    
	            	                }
	            	            }		 
	            	    	 }
	            	    	 
	            	    	 if (img_or_canvas.height)	            	    		 
	            	    	     fd.append("height", img_or_canvas.height);
	            	    	 
	            	    	 if (img_or_canvas.width)	            	    		 
	            	    	     fd.append("width", img_or_canvas.width);
	            	    	 
	            	    	 if (_self.configOptions.extraInfo && _self.configOptions.extraInfo.length)
	            	    	 {
	            	    		 for(var k = 0; k <  _self.configOptions.extraInfo.length; k++)
	            	    		      fd.append(_self.configOptions.extraInfo[k].name, _self.configOptions.extraInfo[k].value);
	            	    	 }
	            	    	 
	            	    	 var restUrl = org.r3.PageManager.getRESTUrl('PUT_UserCollection_Photo', [ org.r3.PageManager.userInfo.dataBean.userid ]);
	            	    	 
	            	    	 $('#cmsattachment_userphoto_canvas .overlay').show();
	            	    	 org.r3.AjaxUtils.submitFormData("PUT", restUrl, fd, function(e) {console.log("Success"); $('#cmsattachment_userphoto_canvas .overlay').hide(); }, null, false, true);
	            	     },
	            	     aFile.type
            	 );    			
    		} 
    	});
    	
    },
    
	doUploadUserPhoto: function()
	{
		var _self = this;
		
		if (true /* $('#userphoto_actionform').valid() */)
		{
			org.r3.PageManager.wait("org.r3.message.waiting");

			var method = "post";
			var restUrl = "/r3ng/was/cvfxxxvchamp/it/cms/cards/00_METEO/files";
			$('#userphoto_actionform').ajaxSubmit(
			{
				"type" : method,
				"url" : restUrl,
				"dataType" : "json",
				"success" : function(responseData)
				{
					org.r3.PageManager.closeNotifier();
					console.log(responseData);										
				},
				"error" : function(jqXHR, timeout, message)
				{
					console.log(arguments);
					org.r3.PageManager.closeNotifier();
				}
			});
		}				
	},
	
	demo: function()
	{
		$('#photo_dialog').modal('show');
		
		$(function () {
		    'use strict';

		    var result = $('#result'),
		        exifNode = $('#exif'),
		        thumbNode = $('#thumbnail'),
		        actionsNode = $('#actions'),
		        currentFile,
		        replaceResults = function (img) {
		            var content;
		            if (!(img.src || img instanceof HTMLCanvasElement)) {
		                content = $('<span>Loading image file failed</span>');
		            } else {
		                content = $('<a target="_blank">').append(img)
		                    .attr('download', currentFile.name)
		                    .attr('href', img.src || img.toDataURL());
		            }
		            result.html(img);
		            if (img.getContext) {
		                actionsNode.show();
		            }
		        },
		        displayImage = function (file, options) {
		            currentFile = file;
		            if (!loadImage(
		                    file,
		                    replaceResults,
		                    options
		                )) {
		                result.children().replaceWith(
		                    $('<span>Your browser does not support the URL or FileReader API.</span>')
		                );
		            }
		        },
		        displayExifData = function (exif) {
		            var thumbnail = exif.get('Thumbnail'),
		                tags = exif.getAll(),
		                table = exifNode.find('table').empty(),
		                row = $('<tr></tr>'),
		                cell = $('<td></td>'),
		                prop;
		            if (thumbnail) {
		                thumbNode.empty();
		                loadImage(thumbnail, function (img) {
		                    thumbNode.append(img).show();
		                }, {orientation: exif.get('Orientation')});
		            }
		            for (prop in tags) {
		                if (tags.hasOwnProperty(prop)) {
		                    table.append(
		                        row.clone()
		                            .append(cell.clone().text(prop))
		                            .append(cell.clone().text(tags[prop]))
		                    );
		                }
		            }
		            exifNode.show();
		        },
		        dropChangeHandler = function (e) {
		            e.preventDefault();
		            e = e.originalEvent;
		            var target = e.dataTransfer || e.target,
		                file = target && target.files && target.files[0],
		                options = {
		                    maxWidth: result.width(),
		                    canvas: true
		                };
		            if (!file) {
		                return;
		            }
		            exifNode.hide();
		            thumbNode.hide();
		            loadImage.parseMetaData(file, function (data) {
		                if (data.exif) {
		                    options.orientation = data.exif.get('Orientation');
		                    displayExifData(data.exif);
		                }
		                displayImage(file, options);
		            });
		        },
		        coordinates;
		    // Hide URL/FileReader API requirement message in capable browsers:
		    if (window.createObjectURL || window.URL || window.webkitURL || window.FileReader) {
		        result.children().hide();
		    }
//		    $(document)
//		        .on('dragover', function (e) {
//		            e.preventDefault();
//		            e = e.originalEvent;
//		            e.dataTransfer.dropEffect = 'copy';
//		        })
//		        .on('drop', dropChangeHandler);
		    $('#file-input').on('change', dropChangeHandler);
		    $('#edit').on('click', function (event) {
		        event.preventDefault();
		        var imgNode = result.find('img, canvas'),
		            img = imgNode[0];
		        imgNode.Jcrop({
		        	minSize: [ img.width - 80, img.height - 80],
		        	maxSize: [ img.width - 80, img.height - 80],
		            setSelect: [40, 40, img.width - 40, img.height - 40],
		            onSelect: function (coords) {
		                coordinates = coords;
		            },
		            onRelease: function () {
		                coordinates = null;
		            }
		        }).parent().on('click', function (event) {
		            event.preventDefault();
		        });
		    });
		    $('#crop').on('click', function (event) {
		        event.preventDefault();
		        var img = result.find('img, canvas')[0];
		        if (img && coordinates) {
		            replaceResults(loadImage.scale(img, {
		                left: coordinates.x,
		                top: coordinates.y,
		                sourceWidth: coordinates.w,
		                sourceHeight: coordinates.h,
		                minWidth: result.width()
		            }));
		            coordinates = null;
		        }
		    });

		});
	}
	
		
});
