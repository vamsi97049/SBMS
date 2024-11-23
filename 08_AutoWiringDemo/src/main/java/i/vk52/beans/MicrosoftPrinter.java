package i.vk52.beans;

public class MicrosoftPrinter implements Iprinter {
	public MicrosoftPrinter() {
		System.out.println("MicrosoftPrinter::Instantiation successful");
	}
	@Override
	public void print() {
		System.out.println("MicrosoftPrinter Printing Receipt");
	}
}
