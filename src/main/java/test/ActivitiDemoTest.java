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
		//����ProcessEngine����ȡclasspath�е�activiti.cfg.xml
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		//��ȡ�ֿ����
		RepositoryService repositoryService = processEngine.getRepositoryService();
		//��ȡ����ʱ����
		RuntimeService runtimeService = processEngine.getRuntimeService();
		
		//��һ�����̵������ļ���ӵ��ֿ���
		repositoryService.createDeployment()
			.addClasspathResource("diagram/demo.bpmn20.xml")
			.deploy();
		
		//��һ�²ֿ��е���������
		Assert.assertEquals(1, repositoryService.createProcessDefinitionQuery().count());
		
		//��������
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("employeeName", "Kermit");
		variables.put("numberOfDays", new Integer(4));
		variables.put("vacationMotivation", "I'm really tired!");
		     
		//ͨ��runtimeService������һ�����̣����������̷���һ������ʵ�������е�����ʵ��������һ�����̶���
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("vacationRequest", variables);
		//���һ��Ŀǰ������ʵ����
		Assert.assertEquals(1,runtimeService.createProcessInstanceQuery().count());
		
		//��ȡ���е�����
		TaskService taskService = processEngine.getTaskService();
		List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("management").list();
		for (Task task : tasks) {
			System.out.println(task.getName());
		} 
		
		//��ȡ����Ȼ��ִ��
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
