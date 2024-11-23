package i.vk52.userprograms;

public class UserLoginClass {
	public static void main(String[] args) {
		BookStore bookStore1 = BookST.getInstance();
		BookStore bookStore2 = BookST.getInstance();
		BookStore bookStore3 = BookST.getInstance();
		BookStore bookStore4 = BookST.getInstance();
		BookStore bookStore5 = BookST.getInstance();
		System.out.println(bookStore1.hashCode());
		System.out.println(bookStore2.hashCode());
		System.out.println(bookStore3.hashCode());
		System.out.println(bookStore4.hashCode());
		System.out.println(bookStore5.hashCode());
	}
}
