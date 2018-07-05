package homework3.bean;

public class OrderTableInfo {
	int bookId; //书籍编号
	String bookName;//书籍姓名
	double bookPrice;//书籍价格
	int bookQuantity;//书籍数量

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

	public int getBookQuantity() {
		return bookQuantity;
	}

	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}

	public OrderTableInfo(int bookId, String bookName, double bookPrice, int bookQuantity) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookQuantity = bookQuantity;
	}

}
