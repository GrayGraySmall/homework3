package homework3.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import homework3.bean.OrderInfoBean;

@Repository
public class OrderInfoDao {
	JdbcTemplate jdbcTemplate = null;

	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 增加订单
	 * 
	 * @param order
	 * @return
	 */
	public int addOrderInfo(OrderInfoBean order) {
		String sql = "insert into dbo.OrderInfo(orderTime, orderDisCount) values (?, ?)";
		int ret = this.jdbcTemplate.update(sql, order.getOrderTime(), order.getOrderDiscount());
		return ret;
	}

	/**
	 * 获取最大自增主键
	 */
	public int maxPri() {
		String sql = "select max(orderId) from OrderInfo";
		Integer x = jdbcTemplate.queryForObject(sql, Integer.class);
		return x;
	}

	/**
	 * 获取所有订单信息
	 * @return 返回所有订单信息的集合
	 */
	public OrderInfoBean[] findAllOrderInfo() {
		String sql = "select * from OrderInfo";
		List<OrderInfoBean> orderInfo = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(OrderInfoBean.class));
		return orderInfo.toArray(new OrderInfoBean[0]);
	}
}
