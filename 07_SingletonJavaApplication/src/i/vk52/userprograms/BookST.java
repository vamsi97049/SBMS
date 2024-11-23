package i.vk52.userprograms;

public class BookST {
	// Eager evolution
    private static final BookStore bookStore = new BookStore();
    private BookST() {}
    public static BookStore getInstance() {
        return bookStore;
    }
}
