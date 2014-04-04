package test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

public class SimpleActivitiDemo {

	public static void main(String[] args) {
		//����ProcessEngine����ȡclasspath�е�activiti.cfg.xml
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		//��ȡ�ֿ����
		RepositoryService repositoryService = processEngine.getRepositoryService();
		//��ȡ����ʱ����
		RuntimeService runtimeService = processEngine.getRuntimeService();
		
		//��һ�����̵������ļ���ӵ��ֿ���
		repositoryService.createDeployment()
			.addClasspathResource("diagram/simple-activiti.bpmn20.xml")
			.deploy();
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("financialReport");
	}

}
