package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Assert;

public class ActivitiDemoTest {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//创建ProcessEngine，读取classpath中的activiti.cfg.xml
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		//获取仓库服务
		RepositoryService repositoryService = processEngine.getRepositoryService();
		//获取运行时服务
		RuntimeService runtimeService = processEngine.getRuntimeService();
		
		//将一个流程的配置文件添加到仓库中
		repositoryService.createDeployment()
			.addClasspathResource("diagram/demo.bpmn20.xml")
			.deploy();
		
		//数一下仓库中的流程数量
		Assert.assertEquals(1, repositoryService.createProcessDefinitionQuery().count());
		
		//创建变量
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("employeeName", "Kermit");
		variables.put("numberOfDays", new Integer(4));
		variables.put("vacationMotivation", "I'm really tired!");
		     
		//通过runtimeService来启动一个流程，启动的流程返回一个流程实例，所有的流程实例，共享一个流程定义
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("vacationRequest", variables);
		//清点一下目前的流程实例数
		Assert.assertEquals(1,runtimeService.createProcessInstanceQuery().count());
		
		//获取所有的任务
		TaskService taskService = processEngine.getTaskService();
		List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("management").list();
		for (Task task : tasks) {
			System.out.println(task.getName());
		} 
		
		//获取任务，然后执行
		Task task = tasks.get(0);	
		Map<String, Object> taskVariables = new HashMap<String, Object>();
		taskVariables.put("vacationApproved", "false");
		taskVariables.put("managerMotivation", "We have a tight deadline!");
		taskService.complete(task.getId(), taskVariables);
		for (Task task1 : taskService.createTaskQuery().taskCandidateGroup("management").list()) {
			System.out.println(task1.getName());
		} 
	}
}
