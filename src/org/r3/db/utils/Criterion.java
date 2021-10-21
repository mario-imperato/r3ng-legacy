package org.r3.db.utils;


public abstract class Criterion 
{
	public boolean isSubSelectCriterion()
	{
		return false;
	}

    public boolean isNoValue() 
    {
        return false;
    }

    public boolean isSingleValue() 
    {
        return false;
    }

    public boolean isBetweenValue() 
    {
        return false;
    }

    public boolean isListValue() 
    {
        return false;
    }

    private String conditionLeftPart;
    
    private String conditionRightPart;        
    
    public String getPrefixCondition()
	{
		return conditionLeftPart;
	}

	public String getSuffixCondition()
	{
		return conditionRightPart;
	}

	private String condition;

    private Object value;

    private Object secondValue;
    
    private String typeHandler;

    public String getCondition() {
        return condition;
    }

    public Object getValue() {
        return value;
    }

    public Object getSecondValue() {
        return secondValue;
    }

    public String getTypeHandler() {
        return typeHandler;
    }

    protected Criterion(String condition) {
        super();
        this.condition = condition;
        this.typeHandler = null;
    }

    protected Criterion(String condition, Object value, String typeHandler) {
        super();
        this.condition = condition;
        this.value = value;
        this.typeHandler = typeHandler;
    }
    
    protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
        super();
        this.condition = condition;
        this.value = value;
        this.secondValue = secondValue;
        this.typeHandler = typeHandler;
    }
    
    protected Criterion(String leftCondition, Object value, String rightCondition, String typeHandler) {
        super();
        this.conditionLeftPart = leftCondition;
        this.conditionRightPart = rightCondition;
        this.value = value;
        this.typeHandler = typeHandler;
    }

}
