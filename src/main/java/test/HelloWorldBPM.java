package test;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

/**
 * 最简单的HelloWorld，流程的节点是一个脚本任务
 * @author bixiao.zy
 *
 */
public class HelloWorldBPM {

	public static void main(String[] args) {
		//创建ProcessEngine，读取classpath中的activiti.cfg.xml
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		//获取仓库服务
		RepositoryService repositoryService = processEngine.getRepositoryService();
		//获取运行时服务
		RuntimeService runtimeService = processEngine.getRuntimeService();
		
		//将一个流程的配置文件添加到仓库中
		repositoryService.createDeployment()
			.addClasspathResource("diagram/HelloWorld.bpmn20.xml")
			.deploy();
		
		//数一下仓库中的流程数量
		System.out.println("目前仓库中的任务数："+repositoryService.createProcessDefinitionQuery().count());
		
		runtimeService.startProcessInstanceByKey("HelloWorld");
		
		TaskService taskService = processEngine.getTaskService();
		List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("management").list();
		
		
		 for (Task task : tasks) {
	       // 用户kermit认领任务
	       taskService.claim(task.getId(), "kermit");
	       // 执行任务
	       taskService.complete(task.getId());
	       System.out.println("用户kermit有任务 " + task.getName() + "，认领并执行！");
		 }
		 processEngine.close();
	}
}
