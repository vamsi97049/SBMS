package i.vk52.beans;

public class BookDaoImpl implements IBookDao {
	JdbTemp temp;	
	
	public void setTemp(JdbTemp temp) {
		this.temp = temp;
	}
	
	@Override
	public void insertRecord(int bid, String bname, int bprice) {
		String sql = "INSERT INTO bookstore (bid, bname, bprice) VALUES (?, ?, ?)";
		temp.getJdbcTemplate().update(sql,bid,bname,bprice);
	}

}
