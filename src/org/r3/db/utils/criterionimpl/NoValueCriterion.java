package org.r3.db.utils.criterionimpl;

import org.r3.db.utils.Criterion;



public class NoValueCriterion extends Criterion
{
	public NoValueCriterion(String condition)
	{
		super(condition);
	}

	@Override
	public boolean isNoValue()
	{
		return true;
	}

}
