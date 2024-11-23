package i.vk52.beans;

public class SonyPrinter implements Iprinter {
	public SonyPrinter() {
		System.out.println("SonyPrinter::Instatiation successful");
	}
	@Override
	public void print() {
		System.out.println("SonyPrinter printing receipt");
	}
}
