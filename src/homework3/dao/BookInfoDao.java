package homework3.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import homework3.bean.BookInfoBean;

/**
 * 书籍信息操作
 * 
 * @author zephyr
 *
 */
@Repository
public class BookInfoDao {
	private JdbcTemplate jdbcTemplate = null;

	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(BookInfoBean book) {
		String sql = "insert into BookInfo(bookName, bookPrice, publishDate) values( ? ,? ,? )";
		int ret = this.jdbcTemplate.update(sql, book.getBookName(), book.getBookPrice(), book.getPublishDate());
		return ret;
	}

	/**
	 * 查找所有图书信息
	 * 
	 * @return 图书
	 */
	public BookInfoBean[] findAllBookInfos() {
		List<BookInfoBean> objs = jdbcTemplate.query("select * from BookInfo",
				BeanPropertyRowMapper.newInstance(BookInfoBean.class));
		return objs.toArray(new BookInfoBean[0]);
	}

	/**
	 * 返回第index页的数据
	 * 
	 * @param index
	 *            页号
	 * @return 图书数组
	 */
	public BookInfoBean[] findByIndex(int index, String bookName) {
		System.out.println(index);
		String sql = "select top " + 5 + " * from BookInfo where ";
		if (bookName == null || bookName.equals("") == true)
			sql = sql + " bookId not in ";
		else
			sql = sql + " bookName like '%" + bookName + "%' and bookId not in ";
		String subSql = " (select top " + index * 5 + " bookId from BookInfo ";
		if (bookName == null || bookName.equals("") == true)
			subSql = subSql + " order by bookId) ";
		else
			subSql = subSql + " where bookName like '%" + bookName + "%' order by bookId) ";
		sql = sql + subSql + " order by bookId ";
		List<BookInfoBean> objs = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(BookInfoBean.class));
		return objs.toArray(new BookInfoBean[0]);
	}

	/**
	 * 计算一共有多少行数据
	 * 
	 * @return
	 */
	public int countRow(String bookName) {
		String sql = "select count(*) as countRows from BookInfo ";
		if (!(bookName == null || bookName.equals("") == true))
			sql = sql + " where bookName like '%" + bookName + "%'";
		Integer x = jdbcTemplate.queryForObject(sql, Integer.class);
		return x;
	}

	/**
	 * 按照书籍编号查找书籍
	 * 
	 * @param bookId
	 * @return
	 */
	public BookInfoBean findBookById(String bookId) {
		String sql = "select * from BookInfo where bookId = ?";
		List<BookInfoBean> objs = jdbcTemplate.query(sql, new Object[] { bookId },
				BeanPropertyRowMapper.newInstance(BookInfoBean.class));
		if (objs.size() >= 1)
			return objs.get(0);
		else
			return null;
	}
}
