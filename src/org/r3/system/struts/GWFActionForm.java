/*
 * Created on 3-gen-2005
 *
 */
package org.r3.system.struts;

import java.io.Serializable;

import org.apache.struts.action.ActionForm;

public class GWFActionForm extends ActionForm implements Serializable 
{
    public String getId() {
        return this.getClass().getName();
    }

}
