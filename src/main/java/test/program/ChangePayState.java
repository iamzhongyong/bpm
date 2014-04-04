package test.program;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import test.program.domain.OrderDO;
//修改订单的支付状态
public class ChangePayState implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		OrderDO order = (OrderDO)execution.getVariable("order");
		order.setPayState("支付成功");
		
		System.out.println("----------------------------");
		System.out.println("收件人：" + order.getUserName());
		System.out.println("收货地址：" + order.getAddress());
		System.out.println("支付状态：" + order.getPayState());
		System.out.println("支付方式：" + order.getPayWay());
		System.out.println("----------------------------");
	}

}
