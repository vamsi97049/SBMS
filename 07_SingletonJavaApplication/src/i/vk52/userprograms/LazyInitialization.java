package i.vk52.userprograms;

public class LazyInitialization {
	// static memeber executed only once during loading process of a class
	private static BookStore bookStore = null;
	
	// private constructor
	private LazyInitialization() {}
	
	// check and evaluate
	private BookStore getInstance() {
		if(bookStore==null) { // instance will be created when it is needed.
			bookStore = new BookStore();
		}
		return bookStore;
	}
}
