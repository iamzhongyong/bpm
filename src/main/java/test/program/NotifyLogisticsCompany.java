package test.program;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import test.program.domain.OrderDO;

//通知物流公司发货
public class NotifyLogisticsCompany implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("节点名称：通知物流公司发货....");
		System.out.println("========================");
		System.out.println("收货地址：" + ((OrderDO)execution.getVariable("order")).getAddress());
		System.out.println("========================");
	}

}
