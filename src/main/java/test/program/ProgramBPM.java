package test.program;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;


/**
 * ��������
 * 1��������Ҫ�������̼��ɣ�
 * 2��Ȼ���עÿ�����̽ڵ�����壻
 * 3������Ҫ��ע����֮��Ĺ����߼���
 * @author bixiao.zy
 *
 */
public class ProgramBPM {

	public static void main(String[] args) {
		//����ProcessEngine����ȡclasspath�е�activiti.cfg.xml
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		//��ȡ�ֿ����
		RepositoryService repositoryService = processEngine.getRepositoryService();
		//��ȡ����ʱ����
		RuntimeService runtimeService = processEngine.getRuntimeService();
		
		//��һ�����̵������ļ���ӵ��ֿ���
		repositoryService.createDeployment()
			.addClasspathResource("diagram/Program.bpmn20.xml")
			.deploy();
		
		//��һ�²ֿ��е���������
		System.out.println("Ŀǰ�ֿ��е���������"+repositoryService.createProcessDefinitionQuery().count());
		
		runtimeService.startProcessInstanceByKey("Program");
		
		
		 processEngine.close();
	}
}
