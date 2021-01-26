package com.example.activiti.demo.controller;

import org.activiti.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiong qiang
 * @Description TODO
 * @Date 2021/1/26
 */
@RestController
public class ActivitiHandleController {


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


}
