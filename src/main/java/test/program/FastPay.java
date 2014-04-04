package test.program;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import test.program.domain.OrderDO;
//快捷支付
public class FastPay implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		OrderDO order = (OrderDO)execution.getVariable("order");
		order.setPayWay("快捷支付");
		System.out.println("节点名字：用户进行快捷支付");

	}

}
