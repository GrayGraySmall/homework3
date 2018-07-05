<%@page import="homework3.service.ShoppingService"%>
<%@page import="homework3.bean.OrderTableInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
	//获取想要删除的订单的书籍id
	String bookId = request.getParameter("bookId");
	if (bookId == null || bookId.equals("")) {
		out.print("error");
		return;
	}
	int id = Integer.parseInt(bookId);
	//获取session的值
	List<OrderTableInfo> shoppings = (List<OrderTableInfo>) session
			.getAttribute(ShoppingService.SESSION_SHOPPINGS);
	int index = 0;
	for (OrderTableInfo order : shoppings) {
		//out.println(order.getBookId());
		if (id == order.getBookId()) {
			shoppings.remove(index);
			break;
		}
		index++;
	}
	//写回session对象
	session.setAttribute(ShoppingService.SESSION_SHOPPINGS, shoppings);
%>