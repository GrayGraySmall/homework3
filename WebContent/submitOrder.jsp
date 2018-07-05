<%@page import="java.util.Date"%>
<%@page import="homework3.bean.OrderInfoBean"%>
<%@page import="homework3.utils.SpringUtils"%>
<%@page import="org.springframework.beans.factory.BeanFactory"%>
<%@page import="homework3.service.ShoppingService"%>
<%@page import="homework3.bean.OrderTableInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String c = request.getParameter("count");
	double count = Double.parseDouble(c);

	//从session取出购物车
	List<OrderTableInfo> shoppings = (List<OrderTableInfo>) session
			.getAttribute(ShoppingService.SESSION_SHOPPINGS);

	BeanFactory factory = SpringUtils.getBeanFactory();
	ShoppingService service = factory.getBean(ShoppingService.class);
	OrderInfoBean order = factory.getBean(OrderInfoBean.class);
	order.setOrderDiscount(count);
	order.setOrderTime(new Date());
	
	service.addOrder(order, shoppings);
	session.removeAttribute(ShoppingService.SESSION_SHOPPINGS);
%>