package homework3.bean;

import java.util.ArrayList;
import java.util.Date;

public class HistoryInfoBean {
	private int orderId; // 订单编号
	private Date orderTime; // 订单时间
	private Double orderDiscount; // 订单折扣（保留两位小数）
	OrderTableInfo[] orderTableInfos;//订单详情

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Double getOrderDiscount() {
		return orderDiscount;
	}

	public void setOrderDiscount(Double orderDiscount) {
		this.orderDiscount = orderDiscount;
	}

	public OrderTableInfo[] getOrderTableInfos() {
		return orderTableInfos;
	}

	public void setOrderTableInfos(OrderTableInfo[] orderTableInfos) {
		this.orderTableInfos = orderTableInfos;
	}

	public HistoryInfoBean() {

	}

	public HistoryInfoBean(int orderId, Date orderTime, Double orderDiscount, OrderTableInfo[] orderTableInfos) {
		super();
		this.orderId = orderId;
		this.orderTime = orderTime;
		this.orderDiscount = orderDiscount;
		this.orderTableInfos = orderTableInfos;
	}

}
