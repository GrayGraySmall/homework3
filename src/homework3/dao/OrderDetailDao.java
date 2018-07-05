package homework3.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import homework3.bean.BookInfoBean;
import homework3.bean.OrderDetailBean;
import homework3.bean.OrderInfoBean;
import homework3.bean.OrderTableInfo;

@Repository
public class OrderDetailDao {
	JdbcTemplate templates = null;

	@Resource
	public void setTemplates(JdbcTemplate templates) {
		this.templates = templates;
	}

	/**
	 * 插入订单
	 * @param id 书籍订单
	 * @param orders 
	 */
	public void addOrderDetail(int id, List<OrderTableInfo> orders) {
		for (OrderTableInfo order : orders) {
			String sql = "insert into dbo.OrderDetail(orderId, bookId, orderQuantity) values (?,?,?)";
			templates.update(sql, id, order.getBookId(), order.getBookQuantity());
		}
	}
	/**
	 * 根据订单编号查询订单详细信息
	 * @param orderId
	 * @return
	 */
	public OrderDetailBean[] findByOrderId(int orderId) {
		String sql = "select * from OrderDetail where orderId = ?";
		List<OrderDetailBean> orders =  templates.query(sql, new Object[] { orderId },
				BeanPropertyRowMapper.newInstance(OrderDetailBean.class));
		return orders.toArray(new OrderDetailBean[0]);
	}
}
