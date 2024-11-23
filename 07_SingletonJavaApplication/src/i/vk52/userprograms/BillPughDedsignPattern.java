package i.vk52.userprograms;

public class BillPughDedsignPattern {
	private BillPughDedsignPattern() {} // prevents instatiation from other classes.
	
	private static class InstanceHelper{
		private static final BookStore bookStore = new BookStore();
	}
	
	public static BookStore getInstance() {
		return InstanceHelper.bookStore;
	}
}