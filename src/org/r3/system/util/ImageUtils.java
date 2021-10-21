/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.r3.system.util;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JComponent;

import org.apache.struts.upload.FormFile;

/**
 * 
 * @author lutrib
 */
public class ImageUtils
{
    public static final int VERTICAL      = 0;

    public static final int HORIZONTAL    = 1;

    public int              width         = 0;

    public int              height        = 0;

    private FormFile       imageFileName = null;

    public OutputStream     os;

    private Dimension imageSize = null;
    
    public ImageUtils(FormFile binaryfile)
    {
        this.imageFileName = binaryfile;
        // getFormatName();
        // getImageSize();
    }

    public String getFormatName()
    {
        InputStream is = null;
        String formatName = null;
        try
        {            
            is = imageFileName.getInputStream();
            formatName = getFormatName(is);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            SystemUtils.close(is);
        }
        
        return formatName;
    }

    /**
     * Calculate image size width and height
     */
    public Dimension getImageSize()
    {
        if (imageSize != null)
            return imageSize;
                
        InputStream is = null;
        try
        {
            is = imageFileName.getInputStream();
            BufferedImage bi = ImageIO.read(is);
            //System.out.println("width - height" + bi.getWidth() + bi.getHeight());
            imageSize = new Dimension(bi.getWidth(), bi.getHeight());
            // Image img = new ImageIcon(imageFileName).getImage();
            // SystemUtils.sleep(2000);
            
            // imageSize = new Dimension(img.getWidth(null), img.getHeight(null));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            SystemUtils.close(is);
        }
        
        return imageSize;
    }

    /**
     *Taglia le dimensioni dell immagine
     * 
     * @param fileoutput
     * @param x
     * @param y
     * @param w
     * @param h
     */
//    public void cropImage(String fileoutput, int x, int y, int w, int h)
//    {
//        String formatName = null;
//        
//        try
//        {
//            CropImage cim = new CropImage();
//            cim.cropImage(imageFileName, os, formatName, x, y, w, h);
//        }
//        catch (Exception ex)
//        {
//            ex.printStackTrace();
//        }
//    }

    /**
     * Crea il Thumbnail dell'immagine
     * 
     * @param fileoutput
     * @param direzione
     *            della misura dell'immagine che si vuole ottenere
     * @param dimensione
     *            del lato
     */
//    public void thumbnailImage(String fileoutput, int direction, int size)
//    {
//        try
//        {
//            CreateThumbnail ct = new CreateThumbnail(imageFileName);
//            ct.getThumbnail(size, direction);
//            ct.saveThumbnail(new File(fileoutput), CreateThumbnail.IMAGE_JPEG);
//        }
//        catch (Exception ex)
//        {
//            ex.printStackTrace();
//        }
//    }

    private static String getFormatName(Object o)
    {
        try
        {
            // Create an image input stream on the image
            ImageInputStream iis = ImageIO.createImageInputStream(o);

            // Find all image readers that recognize the image format
            Iterator iter = ImageIO.getImageReaders(iis);
            if (!iter.hasNext())
            {
                // No readers found
                return null;
            }

            // Use the first reader
            ImageReader reader = (ImageReader) iter.next();

            // Close stream
            iis.close();

            // Return the format name
            return reader.getFormatName();
        }
        catch (IOException e)
        {}
        // The image could not be read
        return null;
    }
    
    public static Image waitForLoading(Image image, JComponent comp)
    {
        MediaTracker tracker = new MediaTracker(comp);
        tracker.addImage(image, 0);
        try
        {
            tracker.waitForID(0);
        }
        catch (InterruptedException i)
        {}
        catch (Exception e)
        {
            //System.out.println("[ImageWait.waitForLoading], exception " + e.getMessage());
            e.printStackTrace();
        }
        return image;
    }
    
}
