package test.program;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;


/**
 * 程序流程
 * 1、仅仅需要启动流程即可；
 * 2、然后关注每个流程节点的意义；
 * 3、不需要关注流程之间的关联逻辑；
 * @author bixiao.zy
 *
 */
public class ProgramBPM {

	public static void main(String[] args) {
		//创建ProcessEngine，读取classpath中的activiti.cfg.xml
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		//获取仓库服务
		RepositoryService repositoryService = processEngine.getRepositoryService();
		//获取运行时服务
		RuntimeService runtimeService = processEngine.getRuntimeService();
		
		//将一个流程的配置文件添加到仓库中
		repositoryService.createDeployment()
			.addClasspathResource("diagram/Program.bpmn20.xml")
			.deploy();
		
		//数一下仓库中的流程数量
		System.out.println("目前仓库中的任务数："+repositoryService.createProcessDefinitionQuery().count());
		
		runtimeService.startProcessInstanceByKey("Program");
		
		
		 processEngine.close();
	}
}
