package homework3.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * 书籍
 * 
 * @author zephyr 书籍类
 */
@Component("bookInfoBean")
public class BookInfoBean {
	private int bookId; // 书籍编号
	private String bookName; // 书籍名字
	private double bookPrice; // 书籍价格
	private Date publishDate; // 书籍出版日期
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Date getPublishDate() {
		return publishDate;
	}
	
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	/* 空构造函数 */
	public BookInfoBean() {

	}

	public BookInfoBean(int bookId, String bookName, double bookPrice, Date publishDate) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.publishDate = publishDate;
	}

	/*
	 * 重写equals方法用于方法之间的比较(non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object bookInfo) {
		if (!(bookInfo instanceof BookInfoBean)) {
			return false;
		} else {
			return this.bookId == ((BookInfoBean) bookInfo).getBookId();
		}
	}
}
