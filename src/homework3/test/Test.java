package homework3.test;

import org.springframework.beans.factory.BeanFactory;
import homework3.bean.BookInfoBean;
import homework3.dao.BookInfoDao;
import homework3.utils.SpringUtils;

public class Test {
	public static void main(String[] args) {
		BeanFactory factory = SpringUtils.getBeanFactory();
		BookInfoDao dao = factory.getBean("bookInfoDao", BookInfoDao.class);
		
		System.out.println(dao.findBookById("1").getBookName());
		
		BookInfoBean[] books = dao.findByIndex(2, "康粤婷");
		for(BookInfoBean book:books){
			System.out.println(book.getBookName() + book.getBookPrice() + book.getPublishDate());
		}
	}
}
