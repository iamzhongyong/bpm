package test.program;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import test.program.domain.OrderDO;

//֪ͨ������˾����
public class NotifyLogisticsCompany implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("�ڵ����ƣ�֪ͨ������˾����....");
		System.out.println("========================");
		System.out.println("�ջ���ַ��" + ((OrderDO)execution.getVariable("order")).getAddress());
		System.out.println("========================");
	}

}
