package ru.lebedev.se.HomeWork7.CheckDZ.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Java 3, JavaLevel3.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 22.02.2019
 * @link https://github.com/Centnerman
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

public @interface BeforeSuite {
    int priority() default 1;
}
