package com.example.demo.multidatasource.common.config.druid;

import lombok.extern.log4j.Log4j;

@Log4j
public class DataSourceContextHolder {
    private static final String DEFAULT_DATASOURCE = "PRIMARY_DATASOURCE";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setDataSource(String dbType){
        System.out.println("切换到["+dbType+"]数据源");
        contextHolder.set(dbType);
    }

    public static String getDataSource(){
        return contextHolder.get();
    }

    public static void clearDataSource(){
        contextHolder.remove();
    }
}
