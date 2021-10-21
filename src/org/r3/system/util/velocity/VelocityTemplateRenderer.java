package org.r3.system.util.velocity;

import java.io.StringWriter;

import org.apache.velocity.VelocityContext;

public class VelocityTemplateRenderer
{
    private VelocityTemplate  template;

    protected VelocityContext velocityContext = null;

    public VelocityTemplateRenderer(VelocityTemplate aTemplate)
    {
        template = aTemplate;
        velocityContext = new VelocityContext();
        add("VTH", new VelocityTemplateHelper());
    }

    public void add(String aName, Object anObject)
    {
        velocityContext.put(aName, anObject);
    }

    public String mergeTemplate() throws Exception
    {
        StringWriter prt = null;

        try
        {
            prt = new StringWriter();
            template.getTemplate().merge(velocityContext, prt);
            
            return prt.toString();
        }
        finally
        {
            if (prt != null)
                prt.close();
        }
        
    }

}
