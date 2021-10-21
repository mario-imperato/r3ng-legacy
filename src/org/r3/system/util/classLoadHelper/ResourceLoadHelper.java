/* 
 * Copyright 2001-2009 James House 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not 
 * use this file except in compliance with the License. You may obtain a copy 
 * of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
 * License for the specific language governing permissions and limitations 
 * under the License.
 * 
 */

/*
 * Previously Copyright (c) 2001-2004 James House
 */
package org.r3.system.util.classLoadHelper;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

import org.r3.system.util.SystemUtils;

/**
 * An interface for classes wishing to provide the service of loading classes
 * and resources within the scheduler...
 * 
 * @author jhouse
 * @author pl47ypus
 */
public abstract class ResourceLoadHelper
{

    /**
     * Called to give the ClassLoadHelper a chance to initialize itself,
     * including the opportunity to "steal" the class loader off of the calling
     * thread, which is the thread that is initializing Quartz.
     */
    public abstract void initialize();

    /**
     * Return the class with the given name.
     * 
     * @param name
     *            the fqcn of the class to load.
     * @return the requested class.
     * @throws ClassNotFoundException
     *             if the class can be found in the classpath.
     */
    public abstract Class loadClass(String name) throws ClassNotFoundException;

    /**
     * Finds a resource with a given name. This method returns null if no
     * resource with this name is found.
     * 
     * @param name
     *            name of the desired resource
     * @return a java.net.URL object
     */
    public abstract URL getResource(String name);

    /**
     * Finds a resource with a given name. This method returns null if no
     * resource with this name is found.
     * 
     * @param name
     *            name of the desired resource
     * @return a java.io.InputStream object
     */
    public abstract InputStream getResourceAsStream(String name);

    /**
     * Enable sharing of the class-loader with 3rd party (e.g. digester).
     * 
     * @return the class-loader user be the helper.
     */
    public abstract ClassLoader getClassLoader();

    public Reader getFileOrResourceAsReader(String resourceName)
    {
        Reader rd = null;
        InputStream is = null;

        try
        {
            File f = new File(resourceName);
            if (f.exists())
            {
                rd = new FileReader(f);
            }
            
            if (rd == null)
            {
                is = getResourceAsStream(resourceName);
                if (is != null)
                   rd = new InputStreamReader(is);
            }

        }
        catch (IOException e)
        {
            SystemUtils.close(is);
        }

        return rd;
    }

    public InputStream getFileOrResourceAsInputStream(String resourceName)
    {
        InputStream is = null;

        try
        {
            File f = new File(resourceName);
            if (f.exists())
            {
                is = new FileInputStream(f);
            }

            if (is == null)
                is = getResourceAsStream(resourceName);
        }
        catch (IOException e)
        {
            SystemUtils.close(is);
            is = null;
        }

        return is;
    }

    // public URL getFileOrResourceURL(String resourceName) throws
    // MalformedURLException
    // {
    // URL uri = null;
    //        
    // File dictionaryFile = new File(resourceName);
    // if (dictionaryFile.exists())
    // {
    // uri = new URL("file:" + dictionaryFile);
    // return uri;
    // }
    //        
    // uri = getResource(resourceName);
    // if (uri != null)
    // return uri;
    //                
    // return uri;
    // }

    public URL getFileOrResourceURL(String resourceName)
    {
        URL uri = null;

        File dictionaryFile = new File(resourceName);
        if (dictionaryFile.exists())
        {
            try
            {
                uri = new URL("file:" + dictionaryFile);
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
            return uri;
        }

        uri = getResource(resourceName);
        if (uri != null)
            return uri;

        return uri;
    }

    public boolean resourceExists(String resourceName)
    {
        return getFileOrResourceURL(resourceName) != null;
    }

    public boolean resourceIsFile(String resourceName)
    {
        File dictionaryFile = new File(resourceName);
        return dictionaryFile.exists();
    }
}
