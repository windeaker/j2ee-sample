package com.example.demo.multidatasource.common.config.druid;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    ContextConst.DataSourceType value() default ContextConst.DataSourceType.PRISM;
}
