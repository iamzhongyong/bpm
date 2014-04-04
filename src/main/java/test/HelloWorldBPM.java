package test;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

/**
 * ��򵥵�HelloWorld�����̵Ľڵ���һ���ű�����
 * @author bixiao.zy
 *
 */
public class HelloWorldBPM {

	public static void main(String[] args) {
		//����ProcessEngine����ȡclasspath�е�activiti.cfg.xml
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		//��ȡ�ֿ����
		RepositoryService repositoryService = processEngine.getRepositoryService();
		//��ȡ����ʱ����
		RuntimeService runtimeService = processEngine.getRuntimeService();
		
		//��һ�����̵������ļ���ӵ��ֿ���
		repositoryService.createDeployment()
			.addClasspathResource("diagram/HelloWorld.bpmn20.xml")
			.deploy();
		
		//��һ�²ֿ��е���������
		System.out.println("Ŀǰ�ֿ��е���������"+repositoryService.createProcessDefinitionQuery().count());
		
		runtimeService.startProcessInstanceByKey("HelloWorld");
		
		TaskService taskService = processEngine.getTaskService();
		List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("management").list();
		
		
		 for (Task task : tasks) {
	       // �û�kermit��������
	       taskService.claim(task.getId(), "kermit");
	       // ִ������
	       taskService.complete(task.getId());
	       System.out.println("�û�kermit������ " + task.getName() + "�����첢ִ�У�");
		 }
		 processEngine.close();
	}
}
