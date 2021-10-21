package org.r3.system.rest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.r3.system.AuthFunction;

@Retention(RetentionPolicy.RUNTIME)
public @interface RestServiceMeta 
{	
	String function() default AuthFunction.FunctionPub;  
	boolean identified() default false;
}

