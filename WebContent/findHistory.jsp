<%@page import="homework3.utils.JsonUtils"%>
<%@page import="homework3.bean.HistoryInfoBean"%>
<%@page import="homework3.utils.SpringUtils"%>
<%@page import="org.springframework.beans.factory.BeanFactory"%>
<%@page import="homework3.service.ShoppingService"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
	BeanFactory factory = SpringUtils.getBeanFactory();
	ShoppingService service = factory.getBean(ShoppingService.class);

	HistoryInfoBean[] history = service.findHistory();
	String jsonStr = JsonUtils.objectToJson(history);
	//3-通过reponse对象返回
	out.write(jsonStr);
%>