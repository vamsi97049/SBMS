package i.vk52.beans.classes;

public class DebitCard implements Ipayment {
	public DebitCard() {
		System.out.println("DebitCard::Instantiation Successful");
	}
	
	@Override
	public void pay(int amount) {
		if(amount!=0) {
			System.out.println("Amount Recieved :: "+amount+" using DebitCard");
		}else {
			System.out.println("Payment Failled");
		}
	}
	
}
