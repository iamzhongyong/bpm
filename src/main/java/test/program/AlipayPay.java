package test.program;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import test.program.domain.OrderDO;
//֧�������֧��
public class AlipayPay implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		OrderDO order = (OrderDO)execution.getVariable("order");
		order.setPayWay("֧�������֧��");
		System.out.println("�ڵ����֣��û�����֧�������֧��");

	}

}
