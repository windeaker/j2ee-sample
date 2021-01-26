package com.example.activiti.demo;

import org.activiti.engine.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ActivitiDemoApplicationTests {

    /**
     * 流程引擎
     * 核心API
     * 调用ProcessEngines的getDefaultProceeEngine方法时会自动加载classpath下名为activiti.cfg.xml文件
     *
     */
    @Resource
    private ProcessEngine processEngine;

    /**
     * 执行管理，包括启动、推进、删除流程实例等操作
     */
    @Resource
    private RuntimeService runtimeService;

    /**
     * 任务管理
     */
    @Resource
    private TaskService taskService;

    /**
     * 组织机构管理
     */
    @Resource
    private IdentityService identityService;

    /**
     * 流程定义管理
     */
    @Resource
    private RepositoryService repositoryService;

    /**
     * 历史数据管理，执行完的数据管理
     */
    @Resource
    private HistoryService historyService;

    @Test
    void contextLoads() {
    }

    @Test
    void createNewActivity() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("vacation");
    }

}
