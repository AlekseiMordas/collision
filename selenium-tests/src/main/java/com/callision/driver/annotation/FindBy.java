package com.callision.driver.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface FindBy {

	String locator() default "";

	int id() default -1;

}