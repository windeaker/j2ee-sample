package com.example.demo.multidatasource.common.config.druid;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class MultiDataSourceConfig {

    @Bean(name = "dataSourcePrism")
    @ConfigurationProperties(prefix = "spring.datasource.prism")
    public DataSource prismDataSource(){
        return new DruidDataSource();
    }

    @Bean(name = "dataSourcePrismMS")
    @ConfigurationProperties(prefix = "spring.datasource.prism-ms")
    public DataSource prismMSDataSource(){
        return new DruidDataSource();
    }

    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //配置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(prismDataSource());

        //配置多数据源
        HashMap<Object, Object> dataSourceMap = new HashMap();
        dataSourceMap.put(ContextConst.DataSourceType.PRISM.name(),prismDataSource());
        dataSourceMap.put(ContextConst.DataSourceType.PRISM_MS.name(),prismMSDataSource());
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        return dynamicDataSource;
    }

    /**
     * 配置@Transactional注解事务
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
