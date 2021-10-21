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

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.ServletContext;



/**
 * A <code>ClassLoadHelper</code> uses all of the <code>ClassLoadHelper</code>
 * types that are found in this package in its attempts to load a class, when
 * one scheme is found to work, it is promoted to the scheme that will be used
 * first the next time a class is loaded (in order to improve performance).
 * 
 * <p>
 * This approach is used because of the wide variance in class loader behavior
 * between the various environments in which Quartz runs (e.g. disparate 
 * application servers, stand-alone, mobile devices, etc.).  Because of this
 * disparity, Quartz ran into difficulty with a one class-load style fits-all 
 * design.  Thus, this class loader finds the approach that works, then 
 * 'remembers' it.  
 * </p>
 * 
 * @see org.quartz.spi.ClassLoadHelper
 * @see org.quartz.simpl.LoadingLoaderClassLoadHelper
 * @see org.quartz.simpl.SimpleClassLoadHelper
 * @see org.quartz.simpl.ThreadContextClassLoadHelper
 * @see org.quartz.simpl.InitThreadContextClassLoadHelper
 * 
 * @author jhouse
 * @author pl47ypus
 */
public class CascadingClassLoadHelper extends ResourceLoadHelper {

    private static ResourceLoadHelper classLoadHelper;
    static
    {
        classLoadHelper = new CascadingClassLoadHelper();
        classLoadHelper.initialize();
    }
    
    public static ResourceLoadHelper getInstance()
    {
        return classLoadHelper;    
    }
    
    public CascadingClassLoadHelper()
    {
        this(null);
    }
    
    public CascadingClassLoadHelper(ServletContext aServletContext)
    {
        servletContext = aServletContext;    
    }
    
    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * 
     * Data members.
     * 
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    private LinkedList<ResourceLoadHelper> loadHelpers;
    private ServletContext                 servletContext;
    
    private ResourceLoadHelper bestCandidate;

    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * 
     * Interface.
     * 
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    /**
     * Called to give the ClassLoadHelper a chance to initialize itself,
     * including the opportunity to "steal" the class loader off of the calling
     * thread, which is the thread that is initializing Quartz.
     */
    public void initialize() {
        loadHelpers = new LinkedList<ResourceLoadHelper>();

        loadHelpers.add(new LoadingLoaderClassLoadHelper());
        loadHelpers.add(new SimpleClassLoadHelper());
        loadHelpers.add(new ThreadContextClassLoadHelper());
        loadHelpers.add(new InitThreadContextClassLoadHelper());
        
        Iterator<ResourceLoadHelper> iter = loadHelpers.iterator();
        while (iter.hasNext()) {
            ResourceLoadHelper loadHelper = iter.next();
            loadHelper.initialize();
        }
    }

    /**
     * Return the class with the given name.
     */
    public Class loadClass(String name) throws ClassNotFoundException {

        if (bestCandidate != null) {
            try {
                return bestCandidate.loadClass(name);
            } catch (Exception e) {
                bestCandidate = null;
            }
        }

        ClassNotFoundException cnfe = null;
        Class clazz = null;
        ResourceLoadHelper loadHelper = null;

        Iterator<ResourceLoadHelper> iter = loadHelpers.iterator();
        while (iter.hasNext()) {
            loadHelper = iter.next();

            try {
                clazz = loadHelper.loadClass(name);
                break;
            } catch (ClassNotFoundException e) {
                cnfe = e;
            }
        }

        if (clazz == null) {
            throw cnfe;
        }

        bestCandidate = loadHelper;

        return clazz;
    }

    /**
     * Finds a resource with a given name. This method returns null if no
     * resource with this name is found.
     * @param name name of the desired resource
     * @return a java.net.URL object
     */
    public URL getResource(String name) {

        URL result = null;
        
        if (bestCandidate != null) {
            try {
                result = bestCandidate.getResource(name);
                if (result == null && servletContext != null)
                {
                    try
                    {
                        result = servletContext.getResource(name);
                    }
                    catch (MalformedURLException e)
                    {
                        e.printStackTrace();
                    }
                }
                return result;
            } catch (Exception e) {
                bestCandidate = null;
            }
        }

        ResourceLoadHelper loadHelper = null;

        Iterator<ResourceLoadHelper> iter = loadHelpers.iterator();
        while (iter.hasNext()) {
            loadHelper = iter.next();

            result = loadHelper.getResource(name);
            if (result != null) {
                break;
            }
        }

        bestCandidate = loadHelper;        
        if (result == null && servletContext != null)
        {
            try
            {
                result = servletContext.getResource(name);
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
        }
        
        return result;

    }

    /**
     * Finds a resource with a given name. This method returns null if no
     * resource with this name is found.
     * @param name name of the desired resource
     * @return a java.io.InputStream object
     */
    public InputStream getResourceAsStream(String name) {

        InputStream result = null;
        if (bestCandidate != null) {
            try {
                result = bestCandidate.getResourceAsStream(name);
                if (result == null && servletContext != null)
                {
                   result = servletContext.getResourceAsStream(name);
                }                    
                return result;
            } catch (Exception e) {
                bestCandidate = null;
            }
        }

        
        ResourceLoadHelper loadHelper = null;

        Iterator<ResourceLoadHelper> iter = loadHelpers.iterator();
        while (iter.hasNext()) {
            loadHelper = (ResourceLoadHelper) iter.next();

            result = loadHelper.getResourceAsStream(name);
            if (result != null) {
                break;
            }
        }

        bestCandidate = loadHelper;
        if (result == null && servletContext != null)
        {
           result = servletContext.getResourceAsStream(name);
        }                    

        return result;

    }

    /**
     * Enable sharing of the class-loader with 3rd party (e.g. digester).
     *
     * @return the class-loader user be the helper.
     */
    public ClassLoader getClassLoader() {
        return (this.bestCandidate == null) ?
                Thread.currentThread().getContextClassLoader() :
                this.bestCandidate.getClassLoader();
    }

}
