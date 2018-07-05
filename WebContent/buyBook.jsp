<%@page import="homework3.bean.*"%>
<%@page import="homework3.service.ShoppingService"%>
<%@page import="homework3.utils.SpringUtils"%>
<%@page import="java.util.*"%>
<%@page import="org.springframework.beans.factory.BeanFactory"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
	//查询用户请求商品
	String bookId = request.getParameter("bookId");
	if (bookId == null || bookId.equals("")) {
		out.print("error");
		return;
	}
	BeanFactory factory = SpringUtils.getBeanFactory();
	ShoppingService service = factory.getBean(ShoppingService.class);
	BookInfoBean book = service.findBook(bookId);
	//从session取出购物车
	List<OrderTableInfo> shoppings = (List<OrderTableInfo>) session
			.getAttribute(ShoppingService.SESSION_SHOPPINGS);
	if (shoppings == null) {
		shoppings = new ArrayList<OrderTableInfo>();
	}
	//更新购物车
	boolean ifExists = false;
	for (OrderTableInfo order : shoppings) {
		if (book.getBookId() == order.getBookId()) {
			ifExists = true;
			int quantity = order.getBookQuantity() + 1;
			order.setBookQuantity(quantity);
			break;
		}
	}
	if (ifExists == false) {
		OrderTableInfo order = new OrderTableInfo(book.getBookId(), book.getBookName(), book.getBookPrice(), 1);
		shoppings.add(order);
	}
	//写回session对象
	session.setAttribute(ShoppingService.SESSION_SHOPPINGS, shoppings);
%>