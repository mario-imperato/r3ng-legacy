package org.r3.db.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CSVAnnotation
{
	String   attribute()      default "__No_Attrid__";
	String   header()         default "__No_Header__";
	int      streamPosition() default 1;
}
  