package i.vk52.beans;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookDaoImpl implements IBookDao {
	private JdbcTemplate jdbcTemplate;
	private BookRowMapper bookRowMapper;

	// Constructor
	public BookDaoImpl(JdbcTemplate jdbcTemplate, BookRowMapper bookRowMapper) {
		this.jdbcTemplate = jdbcTemplate;
		this.bookRowMapper = bookRowMapper;
	}

	@Override
	public void saveBookDetails(int bid, String bname, int bprice) {
		String query = "INSERT INTO BOOKSTORE (bid, bname, bprice) VALUES (?, ?, ?)";
		jdbcTemplate.update(query, bid, bname, bprice);
	}

	@Override
	public List<Book> getDataFromDB() {
		String sql = "SELECT * FROM BOOKSTORE";
		List<Book> books = jdbcTemplate.query(sql, bookRowMapper);
		return books;
	}
	
}
