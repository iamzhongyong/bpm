package test.program;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import test.program.domain.OrderDO;
//支付宝余额支付
public class AlipayPay implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		OrderDO order = (OrderDO)execution.getVariable("order");
		order.setPayWay("支付宝余额支付");
		System.out.println("节点名字：用户进行支付宝余额支付");

	}

}
