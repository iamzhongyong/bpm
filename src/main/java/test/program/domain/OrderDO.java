package test.program.domain;

import java.util.Date;

/**
 * ∂©µ•√Ë ˆ–≈œ¢
 * @author bixiao.zy
 *
 */
public class OrderDO implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7995919040309087196L;

	private String userName;
	
	private Date takeOrderTime;
	
	private long orderMoney;
	
	private String address;
	
	private String payState;
	
	private String payWay;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getTakeOrderTime() {
		return takeOrderTime;
	}

	public void setTakeOrderTime(Date takeOrderTime) {
		this.takeOrderTime = takeOrderTime;
	}

	public long getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(long orderMoney) {
		this.orderMoney = orderMoney;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPayState() {
		return payState;
	}

	public void setPayState(String payState) {
		this.payState = payState;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}
	
	
	
	
}
