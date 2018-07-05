<%@page import="homework3.utils.JsonUtils"%>
<%@page import="homework3.bean.*"%>
<%@page import="homework3.service.ShoppingService"%>
<%@page import="homework3.utils.SpringUtils"%>
<%@page import="java.util.*"%>
<%@page import="org.springframework.beans.factory.BeanFactory"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
	//1-从session取出购物车
	List<OrderTableInfo> shoppings = (List<OrderTableInfo>) session
			.getAttribute(ShoppingService.SESSION_SHOPPINGS);
	//2-java对象(数组) 转换 json字符串
	if (shoppings != null) {
		String jsonStr = JsonUtils.objectToJson(shoppings);
		//3-通过reponse对象返回
		out.write(jsonStr);
	}
%>