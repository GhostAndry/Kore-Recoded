package me.ghostdevelopment.kore.commands;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandInfo {
    String name();

    String permission() default "";

    String permission2() default "";

    String permission3() default "";

    boolean tabCompleter() default false;
}
