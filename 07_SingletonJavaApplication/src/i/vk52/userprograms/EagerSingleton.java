package i.vk52.userprograms;

public class EagerSingleton {
	public static final BookStore bookStore = new BookStore();
	
	// singleton constructor
	private EagerSingleton() {} 
	
	public static BookStore getInstance() {
		return bookStore;
	}
}
