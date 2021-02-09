package com.example.demo.multidatasource.service;

import com.example.demo.multidatasource.common.config.druid.ContextConst;
import com.example.demo.multidatasource.common.config.druid.DataSource;
import com.example.demo.multidatasource.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestService {
    @Resource
    TestMapper testMapper;

    @DataSource(ContextConst.DataSourceType.PRISM_MS)
    public Object selectPrismMSAllId(){
        return testMapper.selectAllIds();
    }

    @DataSource(ContextConst.DataSourceType.PRISM)
    public Object selectPrismAllId(){
        return testMapper.selectAllIds();
    }

}
