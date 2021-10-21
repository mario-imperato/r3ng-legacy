package org.r3.db.utils.criterionimpl;

import org.r3.db.utils.Criterion;



public class BetweenValueCriterion extends Criterion
{
    public BetweenValueCriterion(String condition, Object value, Object secondValue, String typeHandler)
    {
    	super(condition, value, secondValue, typeHandler);
    }

    @Override
    public boolean isBetweenValue() 
    {
        return true;
    }

}
