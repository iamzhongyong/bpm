package test.program;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import test.program.domain.OrderDO;
//�޸Ķ�����֧��״̬
public class ChangePayState implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		OrderDO order = (OrderDO)execution.getVariable("order");
		order.setPayState("֧���ɹ�");
		
		System.out.println("----------------------------");
		System.out.println("�ռ��ˣ�" + order.getUserName());
		System.out.println("�ջ���ַ��" + order.getAddress());
		System.out.println("֧��״̬��" + order.getPayState());
		System.out.println("֧����ʽ��" + order.getPayWay());
		System.out.println("----------------------------");
	}

}
