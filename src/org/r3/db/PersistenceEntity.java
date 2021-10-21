package org.r3.db;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PersistenceEntity 
{	
	String schema() default "";
	String name();
}