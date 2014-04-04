package test.program;

import java.util.Date;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import test.program.domain.OrderDO;
//拍下订单
public class TakeOrders implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		OrderDO order = new OrderDO();
		order.setUserName("iamzhongyong");
		order.setTakeOrderTime(new Date());
		order.setAddress("浙江省杭州市西湖区");
		order.setOrderMoney(1023L);
		order.setPayState("未支付");
		System.out.println("节点名字：用户拍下订单");
		System.out.println("订单完成写入数据库。。。");
		execution.setVariable("order", order);
		Thread.sleep(200);
	}

}
