package homework3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.BeanFactory;
import homework3.bean.BookInfoBean;
import homework3.dao.BookInfoDao;
import homework3.utils.JsonUtils;
import homework3.utils.SpringUtils;

/**
 * Servlet implementation class BookListPagedServlet
 */
@WebServlet("/BookListPagedServlet")
public class BookListPagedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookListPagedServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1-接受用户请求(图书名称+Page Index)
		request.setCharacterEncoding("utf-8");
		int pageIndex = 0;
		String bookName = "";
		try {
			pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
			bookName = request.getParameter("bookName");
			System.out.println(bookName);
		} catch (Exception e) {
		}
		BeanFactory factory = SpringUtils.getBeanFactory();
		BookInfoDao dao = factory.getBean("bookInfoDao", BookInfoDao.class);
		BookInfoBean[] books = dao.findByIndex(pageIndex-1, bookName);
		//返回数据
		response.setCharacterEncoding("utf-8");
		String strJson= JsonUtils.objectToJson(books);
		System.out.println(strJson);
		response.getWriter().write( strJson );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
