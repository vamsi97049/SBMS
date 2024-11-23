package i.vk52.beans;

public class ATM {
	private Iprinter printer;
	public ATM() {
		System.out.println("ATM:: 0-param constrcutor");
	}
	public void setPrinter(Iprinter printer) {
		this.printer = printer;
	}
	public void withdraw() {
		System.out.println("Withdraw successful please collect your receipt");
		// print receipt
		printer.print();
	}
}
