package homework3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import homework3.bean.BookInfoBean;
import homework3.bean.HistoryInfoBean;
import homework3.bean.OrderDetailBean;
import homework3.bean.OrderInfoBean;
import homework3.bean.OrderTableInfo;
import homework3.dao.BookInfoDao;
import homework3.dao.OrderDetailDao;
import homework3.dao.OrderInfoDao;
import homework3.utils.JsonUtils;

@Service
public class ShoppingService {
	public final static String SESSION_SHOPPINGS = "shoppings";
	@Autowired
	private BookInfoDao bookInfoDao = null;
	@Autowired
	private OrderInfoDao orderInfoDao = null;
	@Autowired
	private OrderDetailDao orderDetailDao = null;

	/**
	 * 按照书籍编号查找书籍
	 * 
	 * @param bookId
	 * @return
	 */
	public BookInfoBean findBook(String bookId) {
		return bookInfoDao.findBookById(bookId);
	}

	/**
	 * 添加订单
	 * 
	 * @param order
	 * @return
	 */
	public void addOrder(OrderInfoBean order, List<OrderTableInfo> orders) {
		orderInfoDao.addOrderInfo(order);
		int id = orderInfoDao.maxPri();// 获取最大的值
		orderDetailDao.addOrderDetail(id, orders);
	}

	/**
	 * 查看所有历史订单
	 * 
	 * @return
	 */
	public HistoryInfoBean[] findHistory() {
		ArrayList<HistoryInfoBean> historys = new ArrayList<HistoryInfoBean>();
		OrderInfoBean order[] = orderInfoDao.findAllOrderInfo();
		for (int i = 0; i < order.length; i++) {
			OrderDetailBean[] orderdetail = orderDetailDao.findByOrderId(order[i].getOrderId());
			ArrayList<OrderTableInfo> orderTable = new ArrayList<>();
			for (int j = 0; j < orderdetail.length; j++) {
				BookInfoBean book = bookInfoDao.findBookById(orderdetail[j].getBookId() + "");
				OrderTableInfo orderinfo = new OrderTableInfo(book.getBookId(), book.getBookName(), book.getBookPrice(),
						orderdetail[j].getOrderQuantity());
				orderTable.add(orderinfo);
			}

			HistoryInfoBean history = new HistoryInfoBean(order[i].getOrderId(), order[i].getOrderTime(),
					order[i].getOrderDiscount(), orderTable.toArray(new OrderTableInfo[0]));
			historys.add(history);
		}
		String jsonStr = JsonUtils.objectToJson(historys);
		// 3-通过reponse对象返回
		return historys.toArray(new HistoryInfoBean[0]);
	}
}
