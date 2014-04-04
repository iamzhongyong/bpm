package test.program;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import test.program.domain.OrderDO;
//���ɷ�����
public class GenConsignOrder implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		OrderDO order = (OrderDO)execution.getVariable("order");
		System.out.println("�ڵ����֣���ʼ���ɷ�����");
		System.out.println("----------------------------");
		System.out.println("�ռ��ˣ�" + order.getUserName());
		System.out.println("�ջ���ַ��" + order.getAddress());
		System.out.println("֧��״̬��" + order.getPayState());
		System.out.println("----------------------------");
	}

}
