package org.r3.db.utils.criterionimpl;

import java.util.List;

import org.r3.db.utils.Criterion;



public class ListValueCriterion extends Criterion
{
	public ListValueCriterion(String condition, List<?> value)
	{
		this(condition, value, null);
	}
	
	public ListValueCriterion(String condition, List<?> value, String typeHandler)
	{
		super(condition, value, typeHandler);
	}
	
	@Override
    public boolean isListValue() 
    {
        return true;
    }
}
