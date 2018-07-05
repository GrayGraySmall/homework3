package homework3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;

import homework3.dao.BookInfoDao;
import homework3.utils.JsonUtils;
import homework3.utils.SpringUtils;

/**
 * 计算表中一共有多少条数据
 */
@WebServlet("/CalculatePageServlet")
public class CalculatePageServlet extends HttpServlet {

    public CalculatePageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String bookName = request.getParameter("bookName");
		//获取总行数
		BeanFactory factory = SpringUtils.getBeanFactory();
		BookInfoDao dao = factory.getBean("bookInfoDao", BookInfoDao.class);
		int x = dao.countRow(bookName);
		//返回总行数
		response.setCharacterEncoding("utf-8");
		String strJson= JsonUtils.objectToJson(x);
		System.out.println(strJson);
		response.getWriter().write( strJson );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
