package org.r3.db.utils;

import java.util.ArrayList;
import java.util.List;

import org.r3.db.utils.criterionimpl.BetweenValueCriterion;
import org.r3.db.utils.criterionimpl.ListValueCriterion;
import org.r3.db.utils.criterionimpl.NoValueCriterion;
import org.r3.db.utils.criterionimpl.SingleValueCriterion;
import org.r3.db.utils.criterionimpl.SubSelectCriterion;

public class Criteria
{
	protected List<Criterion> criteria;

	public Criteria()
	{
		super();
		criteria = new ArrayList<Criterion>();
	}

	public boolean isValid()
	{
		return criteria.size() > 0;
	}

	public List<Criterion> getAllCriteria()
	{
		return criteria;
	}

	public List<Criterion> getCriteria()
	{
		return criteria;
	}

	protected void addCriterion(String condition)
	{
		if (condition == null)
		{
			throw new RuntimeException("Value for condition cannot be null");
		}
		criteria.add(new NoValueCriterion(condition));
	}

	protected void addCriterion(String condition, Object value, String property)
	{
		if (value == null)
		{
			throw new RuntimeException("Value for " + property + " cannot be null");
		}
		
		if (value instanceof List<?>)
			 criteria.add(new ListValueCriterion(condition, (List<?>)value));
		else criteria.add(new SingleValueCriterion(condition, value));
	}

	protected void addCriterion(String condition, Object value1, Object value2, String property)
	{
		if (value1 == null || value2 == null)
		{
			throw new RuntimeException("Between values for " + property + " cannot be null");
		}
		criteria.add(new BetweenValueCriterion(condition, value1, value2, null));
	}

	protected void addSubSelectCriterion(String conditionLeftPart, Object value, String conditionRightPart, String property)
	{
		if (value == null)
		{
			throw new RuntimeException("SubSelectCriterion values for " + property + " cannot be null");
		}
		criteria.add(new SubSelectCriterion(conditionLeftPart, value, conditionRightPart, null));
	}

}
