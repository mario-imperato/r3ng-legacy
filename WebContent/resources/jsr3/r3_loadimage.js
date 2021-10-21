(function($)
{
	$.fn.loadImage1 = function(/* Hash */anOptionHash)
	{
		if (this.length == 0)
			return this;
		
		var _self = this;
		
		var defaults =
		{
			canvas: true
		};
		
		var r3LoadImageOptions = $.extend({}, defaults, anOptionHash);
		
		var result = this.find('#result'),		    
		    actionsNode = this.find('#actions'),
		    coordinates = null,
		    exifInfo = null;
		        
	    $('#r3_img_cropcanvas_commit').on('click', function (event) {
	        event.preventDefault();
	        var img = result.find('img, canvas')[0];
	        if (img && coordinates) {
//	            replaceResults(loadImage.scale(img, {
//	                left: coordinates.x,
//	                top: coordinates.y,
//	                sourceWidth: coordinates.w,
//	                sourceHeight: coordinates.h,
//	                minWidth: result.width(),
//	                maxHeight: 500
//	            }));
	        	
	        	var img_or_canvas = loadImage.scale(img, {
	                left: coordinates.x,
	                top: coordinates.y,
	                sourceWidth: coordinates.w,
	                sourceHeight: coordinates.h,
	                maxWidth: r3LoadImageOptions.maxSize[0],
	                maxHeight: r3LoadImageOptions.maxSize[1]
	            });
	        		
	            coordinates = null;
	            _self.modal('hide');
	            
	            if (r3LoadImageOptions.processImage)
	            {
	            	r3LoadImageOptions.processImage(img_or_canvas, exifInfo && exifInfo.getAll());	            		            		                 	
	            }
	        }
	    });
	    
	    var startEditing = function()
	    {
	    	var imgNode = result.find('img, canvas'),
            img = imgNode[0];
	    	
	    	var imgAspectRatio = img.width / img.height;
	    	
		    var percentage = 0.85;
		    
	    	var startSelection, x = 0, y = 0;
	    	if (r3LoadImageOptions.aspectRatio)
	    	{
	    		if (imgAspectRatio >= r3LoadImageOptions.aspectRatio)
	    		{
	    			y = img.height;
	    		    x = img.height * r3LoadImageOptions.aspectRatio;
	    		    
	    		    x = Math.floor(x * percentage); y = Math.floor(y * percentage);
	    		}
	    		else
	    		{
	    		    x = img.width;
	    		    y = img.width / r3LoadImageOptions.aspectRatio;
	    		    
	    		    x = Math.floor(x * percentage); y = Math.floor(y * percentage);	    		    
	    		}	    		
	    		
	    		var sx = Math.floor((img.width - x) / 2);
	    		var sy = Math.floor((img.height - y) / 2);
	    		
	    		startSelection = [sx, sy, sx + x, sy + y];
	    	}
	    	else
	    	{
	    		startSelection = [40, 40, img.width - 40, img.height - 40];
	    	}
	    
	    	imgNode.Jcrop({
	    	aspectRatio : r3LoadImageOptions.aspectRatio,	    	
	    	boxWidth: result.width(),
	    	boxHeight : result.width(),
            setSelect: startSelection,
            onSelect: function (coords) {
                coordinates = coords;
            },
            onRelease: function () {
                coordinates = null;
            }
            });	    	
	    };
	    
		var replaceResults = function (img) 
		{
            if (!(img.src || img instanceof HTMLCanvasElement)) {
                content = $('<span>Loading image file failed</span>');
            } else {
                content = $('<a  target="_blank">').append(img)
                    .attr('download', currentFile.name)
                    .attr('href', img.src || img.toDataURL());
            }
            result.html(img);
            if (img.getContext) {
                actionsNode.show();
            }
            
            setTimeout(startEditing, 500);
            
//            var imgNode = result.find('img, canvas');
//            var img1 = imgNode[0];
//            
//            imgNode.Jcrop({
//        	minSize: [ img1.width - 80, img1.height - 80],
//        	maxSize: [ img1.width - 80, img1.height - 80],
//            setSelect: [40, 40, img1.width - 40, img1.height - 40],
//            onSelect: function (coords) {
//                coordinates = coords;
//            },
//            onRelease: function () {
//                coordinates = null;
//            }
//        	});
        
        };
        
		var  displayImage = function (file, options1) {
            currentFile = file;
            if (!loadImage(
                    file,
                    replaceResults,
                    options1
                )) {
                // result.children().replaceWith(
                //     $('<span>Your browser does not support the URL or FileReader API.</span>') );
            }
        };
        
//        var displayExifData = function (exif) {
//            var thumbnail = exif.get('Thumbnail'),
//                tags = exif.getAll(),
//                table = exifNode.find('table').empty(),
//                row = $('<tr></tr>'),
//                cell = $('<td></td>'),
//                prop;
//            if (thumbnail) {
//                thumbNode.empty();
//                loadImage(thumbnail, function (img) {
//                    thumbNode.append(img).show();
//                }, {orientation: exif.get('Orientation')});
//            }
//            for (prop in tags) {
//                if (tags.hasOwnProperty(prop)) {
//                    table.append(
//                        row.clone()
//                            .append(cell.clone().text(prop))
//                            .append(cell.clone().text(tags[prop]))
//                    );
//                }
//            }
//            exifNode.show();
//        };
        			
		this.modal('show'); 
		
        loadImage.parseMetaData(r3LoadImageOptions.file, function (data) {
        	
        	var anOptionHash = { canvas: true };
            if (data.exif) {
            	anOptionHash.orientation = data.exif.get('Orientation');
                exifInfo = data.exif; // displayExifData(data.exif);
            }
            // T20160406
            // anOptionHash.maxWidth = result.width();    
            // anOptionHash.maxHeight = result.width();
            
            displayImage(r3LoadImageOptions.file, anOptionHash );
        });
        
		return this;
	};

})(jQuery);
