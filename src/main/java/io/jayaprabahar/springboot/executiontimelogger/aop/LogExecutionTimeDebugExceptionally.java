package io.jayaprabahar.springboot.executiontimelogger.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p> Project : execution-time-logger </p>
 * <p> Title : LogExecutionTimeDebugExceptionally.java </p>
 * <p> Description: AOP Advice to log the time taken per method call </p>
 * <p> Created: Jan 8, 2022</p>
 *
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 * @version 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogExecutionTimeDebugExceptionally {
}
