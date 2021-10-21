package org.r3.db.utils.criterionimpl;

import org.r3.db.utils.Criterion;



public class SingleValueCriterion extends Criterion
{
	public SingleValueCriterion(String condition, Object value)
	{
		this(condition, value, null);
	}
	
	public SingleValueCriterion(String condition, Object value, String typeHandler)
	{
		super(condition, value, typeHandler);
	}
	
	@Override
    public boolean isSingleValue() 
    {
        return true;
    }

}
