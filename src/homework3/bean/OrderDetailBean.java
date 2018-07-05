package homework3.bean;

import org.springframework.stereotype.Component;

/**
 * 订单详情
 * 
 * @author zephyr
 *
 */
@Component("orderDetailBean")
public class OrderDetailBean {
	private int detailId; // 详细编号
	private int orderId; // 订单编号
	private int bookId; // 书本编号
	private int orderQuantity; // 订单数量

	public OrderDetailBean() {
	}

	public OrderDetailBean(int detailId, int orderId, int bookId, int orderQuantity) {
		this.detailId = detailId;
		this.orderId = orderId;
		this.bookId = bookId;
		this.orderQuantity = orderQuantity;
	}

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
}
