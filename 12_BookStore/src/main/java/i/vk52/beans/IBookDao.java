package i.vk52.beans;

import java.util.List;

public interface IBookDao {
	public void saveBookDetails(int bid,String bname,int bprice);
	public List<Book> getDataFromDB();
}
