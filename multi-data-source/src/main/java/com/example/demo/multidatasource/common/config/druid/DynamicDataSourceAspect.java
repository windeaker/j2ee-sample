package com.example.demo.multidatasource.common.config.druid;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class DynamicDataSourceAspect {

    @Before("execution(* com.example.demo.multidatasource.service..*.*(..))")
    public void before(JoinPoint point){
        try {
            DataSource annotationOfClass = point.getTarget().getClass().getAnnotation(DataSource.class);
            String methodName = point.getSignature().getName();
            Class[] parameterTypes = ((MethodSignature) point.getSignature()).getParameterTypes();
            Method method = point.getTarget().getClass().getMethod(methodName, parameterTypes);
            DataSource methodAnnotation = method.getAnnotation(DataSource.class);
            methodAnnotation = methodAnnotation == null ? annotationOfClass:methodAnnotation;
            ContextConst.DataSourceType dataSourceType = methodAnnotation != null && methodAnnotation.value() !=null ? methodAnnotation.value() :ContextConst.DataSourceType.PRISM ;
            DataSourceContextHolder.setDataSource(dataSourceType.name());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @After("execution(* com.example.demo.multidatasource.service..*.*(..))")
    public void after(JoinPoint point){
        DataSourceContextHolder.clearDataSource();
    }
}
