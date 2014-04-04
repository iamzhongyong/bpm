package test.program;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import test.program.domain.OrderDO;
//生成发货单
public class GenConsignOrder implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		OrderDO order = (OrderDO)execution.getVariable("order");
		System.out.println("节点名字：开始生成发货单");
		System.out.println("----------------------------");
		System.out.println("收件人：" + order.getUserName());
		System.out.println("收货地址：" + order.getAddress());
		System.out.println("支付状态：" + order.getPayState());
		System.out.println("----------------------------");
	}

}
