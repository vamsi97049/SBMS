package i.vk52.beans.classes;

public class CreditCard implements Ipayment {

	public CreditCard() {
		System.out.println("CreditCard::Instantiation Successful");
	}

	@Override
	public void pay(int amount) {
		if(amount!=0) {
			System.out.println("Amount Recieved :: "+amount+" using CreditCard");
		}else {
			System.out.println("Payment Failled");
		}
	}
	
	
	
}
