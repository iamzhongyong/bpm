package test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

public class SimpleActivitiDemo {

	public static void main(String[] args) {
		//创建ProcessEngine，读取classpath中的activiti.cfg.xml
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		//获取仓库服务
		RepositoryService repositoryService = processEngine.getRepositoryService();
		//获取运行时服务
		RuntimeService runtimeService = processEngine.getRuntimeService();
		
		//将一个流程的配置文件添加到仓库中
		repositoryService.createDeployment()
			.addClasspathResource("diagram/simple-activiti.bpmn20.xml")
			.deploy();
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("financialReport");
	}

}
