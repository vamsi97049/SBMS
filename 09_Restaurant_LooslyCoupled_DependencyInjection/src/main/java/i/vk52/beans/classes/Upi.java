package i.vk52.beans.classes;

public class Upi implements Ipayment {
	public Upi() {
		System.out.println("UPI::Instantiation successful");
	}
	
	@Override
	public void pay(int amount) {
		if(amount!=0) {
			System.out.println("Amount Recieved :: "+amount+" using UPI");
		}else {
			System.out.println("Payment Failled");
		}
	}
	
}
