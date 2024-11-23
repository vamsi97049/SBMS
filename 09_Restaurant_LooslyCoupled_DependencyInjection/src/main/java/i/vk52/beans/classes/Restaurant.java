package i.vk52.beans.classes;

public class Restaurant {
	private Ipayment payMode;
	public Restaurant() {
		System.out.println("Restaurant::Instantiation Successful");
	}
	public void setPayMode(Ipayment payMode) {
		this.payMode = payMode;
	}
	public void payment(int amount) {
		payMode.pay(amount);
		System.out.println("..........Payment Successfull......");
	}
}
