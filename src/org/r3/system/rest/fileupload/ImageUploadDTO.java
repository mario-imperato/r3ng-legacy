package org.r3.system.rest.fileupload;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.r3.system.rest.fileupload.FileUploadProcessingConfig.ConfigParamClass;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.tasks.io.InputStreamImageSource;

public class ImageUploadDTO extends FileUploadDTO
{
//	public static class ImageOptions implements FileUploadOptions
//	{
//		 private String optionsName; 
//	     private int maxWidth;
//	     private int maxHeight;
//	     
//	     public ImageOptions(String aName, String csvOptions)
//	     {
//	    	 optionsName = aName;
//	    	 
//	    	 if (csvOptions == null || csvOptions.trim().length() == 0)
//	    		 setDefaults();
//	    	 else
//	    	 {
//	    		 String[] optsArray = csvOptions.split(",");
//	    		 if (optsArray.length != 2)
//	    			 setDefaults();
//	    		 else
//	    		 {
//	    			 try
//	    			 {
//	    			     maxWidth = Integer.parseInt(optsArray[0]);
//	    			     maxHeight = Integer.parseInt(optsArray[1]);
//	    			 }
//	    			 catch(Exception e)
//	    			 {
//	    				 e.printStackTrace();
//	    				 setDefaults();
//	    			 }
//	    		 }	    		 
//	    	 }	    	 
//	     }
//	     
//	     private void setDefaults()
//	     {
//		     maxWidth = -1;
//		     maxHeight = -1;	    	 
//	     }
//	     
//	     public boolean isResizeRequired(int currentWidth, int currentHeight)
//	     {
//	    	 return maxWidth > 0 && maxHeight > 0 && (currentWidth > maxWidth || currentHeight > maxHeight);
//	     }
//
//		public int getMaxWidth()
//		{
//			return maxWidth;
//		}
//
//		public int getMaxHeight()
//		{
//			return maxHeight;
//		}	     	     
//	}

	private String imageurl;
	private int imageWidth;
	private int imageHeight;

	private String iconurl;

	private InputStream iconInputStream;
	private int iconWidth;
	private int iconHeight;

	public ImageUploadDTO()
	{

	}

	@Override
	public void setFileInputStream(InputStream fileInputStream) throws IOException
	{
		super.setFileInputStream(fileInputStream);
		computeImageSize(fileInputStream);
	}

	private FileUploadProcessingImageConfig getImageOption()
	{
		FileUploadProcessingConfig opt = getFileUploadProcessingConfig(ConfigParamClass.image);
		if (opt != null)
			return (FileUploadProcessingImageConfig)opt;
		
		return null;
	}

	private FileUploadProcessingImageConfig getIconOption()
	{
		FileUploadProcessingConfig opt = getFileUploadProcessingConfig(ConfigParamClass.icon);
		if (opt != null)
			return (FileUploadProcessingImageConfig)opt;
		
		return null;
	}

	@Override
	public void applyUploadOptions() throws IOException
	{
		InputStream uploadInputStream = getFileInputStream();

		int uploadWidth = imageWidth;
		int uploadHeight = imageHeight;
        
		FileUploadProcessingImageConfig imageOptions = getImageOption();
		FileUploadProcessingImageConfig iconOptions = getIconOption();
		
		if (imageOptions != null && imageOptions.isResizeRequired(uploadWidth, uploadHeight))
		{
			float scale = getScalingRatio(uploadWidth, imageOptions.getMaxWidth(), uploadHeight, imageOptions.getMaxHeight());
			
			uploadInputStream.reset();

			ByteArrayOutputStream os = new ByteArrayOutputStream();
			Thumbnails.of(uploadInputStream).size(imageOptions.getMaxWidth(), imageOptions.getMaxHeight()).toOutputStream(os);

			ByteArrayInputStream bis = new ByteArrayInputStream(os.toByteArray());
			super.setFileInputStream(bis);
			imageWidth = Math.round(uploadWidth * scale);
			imageHeight = Math.round(uploadHeight * scale);
		}

		if (iconOptions != null && iconOptions.isResizeRequired(uploadWidth, uploadHeight))
		{
			float scale = getScalingRatio(uploadWidth, iconOptions.getMaxWidth(), uploadHeight, iconOptions.getMaxHeight());
			
			uploadInputStream.reset();

			ByteArrayOutputStream os = new ByteArrayOutputStream();
			Thumbnails.of(uploadInputStream).size(iconOptions.getMaxWidth(), iconOptions.getMaxHeight()).toOutputStream(os);

			ByteArrayInputStream bis = new ByteArrayInputStream(os.toByteArray());
			iconInputStream = bis;
			iconWidth = Math.round(uploadWidth * scale);
			iconHeight = Math.round(uploadHeight * scale);
		}

	}

	private float getScalingRatio(int currentWidth, int maxWidth, int currentHeight, int maxHeight)
	{
		float wr = (float)maxWidth / currentWidth;
		float hr = (float)maxHeight / currentHeight;
		
		return Math.min(wr,  hr);
	}
	
	// public void setImageInfo(String aUrl, int aWidth, int anHeight)
	// {
	// imageurl = aUrl;
	// imageWidth = aWidth;
	// imageHeight = anHeight;
	// }
	//
	// public void setImageIconInfo(String aUrl, int aWidth, int anHeight)
	// {
	// imageIconurl = aUrl;
	// iconWidth = aWidth;
	// iconHeight = anHeight;
	// }


	@Override
	public String getImageurl()
	{
		return imageurl;
	}

	public void setImageurl(String imageurl)
	{
		this.imageurl = imageurl;
	}

	@Override
	public String getIconurl()
	{
		return iconurl;
	}

	public void setIconurl(String iconurl)
	{
		this.iconurl = iconurl;
	}

	@Override
	public int getImageWidth()
	{
		return imageWidth;
	}

	@Override
	public int getImageHeight()
	{
		return imageHeight;
	}

	// public String getImageIconurl()
	// {
	// return imageIconurl;
	// }

	@Override
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient
	public InputStream getIconInputStream()
	{
		return iconInputStream;
	}
	
	@Override
	public int getIconWidth()
	{
		return iconWidth;
	}

	@Override
	public int getIconHeight()
	{
		return iconHeight;
	}

	private void computeImageSize(InputStream is) throws IOException
	{
		InputStreamImageSource imageSource = new InputStreamImageSource(is);

		BufferedImage bf = imageSource.read();
		imageWidth = bf.getWidth();
		imageHeight = bf.getHeight();		
	}

}
