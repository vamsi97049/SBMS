package i.vk52.beans;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {
	
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
    	Book book = new Book();
    	book.setBid(Integer.parseInt(rs.getString("bid")));
        book.setBname(rs.getString("bname"));
        book.setBprice(Integer.parseInt(rs.getString("bprice")));
        return book;
    }
}
