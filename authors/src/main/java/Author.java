package main.java;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(Authors.class)
public @interface Author {
    String value () default "Unknown";
}

