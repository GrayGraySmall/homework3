package homework3.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * 订单信息
 * 
 * @author zephyr
 *
 */
@Component("orderInfoBean")
public class OrderInfoBean {
	private int orderId; // 订单编号
	private Date orderTime; // 订单时间
	private Double orderDiscount; // 订单折扣（保留两位小数）

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

	/*
	 * 重载比较方法
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object order) {
		if (!(order instanceof OrderInfoBean)) {
			return false;
		}
		return ((OrderInfoBean) order).getOrderId() == this.orderId;
	}
}
