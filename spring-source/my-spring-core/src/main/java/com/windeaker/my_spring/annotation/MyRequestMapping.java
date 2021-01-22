package com.windeaker.my_spring.annotation;

import java.lang.annotation.*;

/**
 * @author xiong qiang
 * @Description TODO
 * @Date 2021/1/22
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRequestMapping {
    String value() default "";
}
