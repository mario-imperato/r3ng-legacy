package org.r3.system.util.velocity;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.RuleSetBase;
import org.r3.system.util.SystemUtils;
import org.r3.system.util.classLoadHelper.CascadingClassLoadHelper;
import org.r3.system.util.classLoadHelper.ResourceLoadHelper;

public class VelocityTemplateModel
{
     private HashMap<String, VelocityTemplateGroup> listOfTemplates;
     
     private HashMap<String, VelocityTemplateGroup> getListOfTemplates()
     {
         if (listOfTemplates == null)
             listOfTemplates = new HashMap<String, VelocityTemplateGroup>();
         
         return listOfTemplates;
     }
     
     private VelocityTemplateGroup getTemplateGroupFor(String aTemplateName)
     {
    	 return getListOfTemplates().get(aTemplateName);
     }
     
     public void addTemplate(VelocityTemplate aTemplate)
     {
    	 VelocityTemplateGroup vg = getTemplateGroupFor(aTemplate.getName());
    	 if (vg == null)
    	 {
    	      vg = new VelocityTemplateGroup();
    	      getListOfTemplates().put(aTemplate.getName(), vg);
    	 }
    	 
    	 vg.addTemplate(aTemplate);  
     }

     public VelocityTemplate getTemplate(String aTemplateId)
     {
    	 return getTemplate(aTemplateId, VelocityTemplateGroup.TemplateDefaultDomainParameter, null);
     }
     
     public VelocityTemplate getTemplate( String aTemplateId, String domain)
     {
    	 return getTemplate(aTemplateId, domain,  null);
     }

     public VelocityTemplate getTemplate(String aTemplateId, String domain, String aLocale)
     {
    	 VelocityTemplate v = null;
    	 VelocityTemplateGroup vg = getTemplateGroupFor(aTemplateId);
    	 if (vg != null)
    	 {
    		 v = vg.getTemplate(domain, aLocale);
    	 }
    	 
         return v;
     }
     
     public VelocityTemplateRenderer newRendererInstance(String aTemplateId, String aDomain)
     {
         return newRendererInstance(aTemplateId, aDomain, null); 
     }

     public VelocityTemplateRenderer newRendererInstance(String aTemplateId, String aDomain, String aLocale)
     {
         VelocityTemplate t = getTemplate(aTemplateId, aDomain,  aLocale);
         return new VelocityTemplateRenderer(t); 
     }

     public void setInContext(ServletContext ctx)
     {
         ctx.setAttribute("_UNEP_VELOCITY_", this);
     }

     // Convenience method to access a LUTSet in the servlet context.
     public static VelocityTemplateModel getVelocityPlugInModel(ServletContext ctx)
     {
         Object o = ctx.getAttribute("_UNEP_VELOCITY_");
         if (o == null)
         {
             System.err.println("Could not find velocityPlugInModel Object");
         }
         else
         {
             if (o instanceof VelocityTemplateModel)
                 return (VelocityTemplateModel) o;
             else
             {
            	 System.err.println("Object is not an instance of VelocityPlugInModel");
             }
         }

         return null;
     }

     public void loadTemplates(List<String> listOfTemplatesDictionaries) throws Exception
     {
         Digester d = null;
                  
         InputStream dictionaryInputStream = null;
         try
         {
            ResourceLoadHelper resourceLoadHelper = CascadingClassLoadHelper.getInstance();
            for(String t : listOfTemplatesDictionaries)
            {
            	d = new Digester();
                d.setNamespaceAware(true);

                d.push(this);
                d.addRuleSet(new GWFVelocityPlugInRuleSet("templates/"));
                
                System.out.println(String.format("### %s - INITCONTEXT LISTENER: Load Template %s", "---", t));
            	dictionaryInputStream = resourceLoadHelper.getFileOrResourceAsInputStream(t);
            	d.parse(dictionaryInputStream);
            }
            
         }
         finally
         {
            SystemUtils.close(dictionaryInputStream);
         }
     }

     public static class GWFVelocityPlugInRuleSet extends RuleSetBase
     {
         protected String prefix = null;

         public GWFVelocityPlugInRuleSet()
         {
             this("");
         }

         public GWFVelocityPlugInRuleSet(String prefix)
         {
             super();
             this.prefix = prefix;
             // this.namespaceURI = GWFDescriptor.xmlnsUrl;
         }

         public void addRuleInstances(Digester d)
         {
             d.addObjectCreate(prefix + "template", VelocityTemplate.class.getName());

             // Gli attributi sono: name
             d.addSetProperties(prefix + "template");

             d.addCallMethod(prefix + "template/title",      "setTitle", 0);
             d.addCallMethod(prefix + "template/domain",     "setDomain", 0);
             d.addCallMethod(prefix + "template/filename",   "setFilename", 0);
             d.addCallMethod(prefix + "template/locale",     "setLocale", 0);

             d.addSetNext(prefix + "template", "addTemplate", VelocityTemplate.class.getName());
         }


     }

}
