package com.example.activiti.demo.controller;

import org.activiti.engine.*;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("deployActiviti")
    public Object deployActiviti() {
        DeploymentBuilder builder = repositoryService.createDeployment();
        builder.addClasspathResource("processes/vacationProcess.bpmn");
        Deployment deployment = builder.deploy();
        return deployment;
    }


    /**
     * 根据流程key开启一个流程
     *
     * @return
     */
    @GetMapping("startActiviti")
    public Object startActiviti(Integer days,Integer formId,String userId) {
        //启动流程实例，字符串"vacationProcess"是BPMN模型文件里process元素的id
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("vacationProcess");
        //流程实例启动后，流程会跳转到请假申请节点
        Task vacationApply = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        //设置请假申请任务的执行人
        taskService.setAssignee(vacationApply.getId(), userId);

        //设置流程参数：请假天数和表单ID
        //流程引擎会根据请假天数days>3判断流程走向
        //formId是用来将流程数据和表单数据关联起来
        Map<String, Object> args = new HashMap<>();
        args.put("days", days);
        args.put("formId", formId);

        //完成请假申请任务
        taskService.complete(vacationApply.getId(), args);
        return true;
    }

    /**
     * 查询待办
     *
     * @return
     */
    @GetMapping("/getTaskList")
    public Object getTaskList() {
        //获取待办的一些信息，这里可以传入需要查询的用户，
        //我这里查询的所有待办
        List<Task> tasks = taskService.createTaskQuery().list();
        for (Task t : tasks) {
            System.out.println("id:"+t.getId());
            System.out.println("create_time"+t.getCreateTime());
            System.out.println("name:"+t.getName());
            System.out.println("processInstanceId:"+t.getProcessInstanceId());
            System.out.println("taskDefinitionKey:"+t.getTaskDefinitionKey());
            System.out.println("parent_task_id"+t.getParentTaskId());
            System.out.println("---"+t.toString());
        }
        return true;
    }

    /**
     * 根据任务id提交任务
     *
     * @param taskId
     * @return
     */

    @GetMapping("complete")
    public Object complete(String taskId) {
        taskService.complete(taskId);
        return true;
    }

    /**
     * 根据流程id直接结束流程
     *
     * @param runId
     * @return
     */
    @GetMapping("deleteProcessInstance")
    public Object deleteProcessInstance(String runId) {
        runtimeService.deleteProcessInstance(runId, "结束");
        return true;
    }

    /**
     * 历史流程查询
     * @return
     */
    @GetMapping("historicProcess")
    public Object historicProcess(){
        //获取历史流程
        HistoricProcessInstanceQuery historicProcessInstanceQuery = historyService.createHistoricProcessInstanceQuery();
        //查询已经完成的流程
        HistoricProcessInstance historicProcessInstance = historicProcessInstanceQuery.finished().singleResult();

        System.out.println(historicProcessInstance.toString());
        return historicProcessInstance;
    }


}
