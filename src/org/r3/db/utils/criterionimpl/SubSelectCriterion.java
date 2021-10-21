package org.r3.db.utils.criterionimpl;

import org.r3.db.utils.Criterion;



public class SubSelectCriterion extends Criterion
{
    public SubSelectCriterion(String leftCondition, Object value, String rightCondition, String typeHandler) 
    {
    	super(leftCondition, value, rightCondition, typeHandler);
    }
    
    @Override
    public boolean isSubSelectCriterion()
    {
    	return true;
    }
}
