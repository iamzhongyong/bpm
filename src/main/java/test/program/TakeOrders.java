package test.program;

import java.util.Date;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import test.program.domain.OrderDO;
//���¶���
public class TakeOrders implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		OrderDO order = new OrderDO();
		order.setUserName("iamzhongyong");
		order.setTakeOrderTime(new Date());
		order.setAddress("�㽭ʡ������������");
		order.setOrderMoney(1023L);
		order.setPayState("δ֧��");
		System.out.println("�ڵ����֣��û����¶���");
		System.out.println("�������д�����ݿ⡣����");
		execution.setVariable("order", order);
		Thread.sleep(200);
	}

}
