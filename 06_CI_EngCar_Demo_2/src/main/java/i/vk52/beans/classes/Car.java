package i.vk52.beans.classes;

public class Car {

	private Engine eng;

	public Car() {
		System.out.println("Car:: Instantiation Successful");
	}

	public Car(Engine eng) {
		this.eng = eng;
	}

	public void drive() {
		int status = eng.start();
		if (status == 1) {
			System.out.println("Journey Started...");
		} else {
			System.out.println("Engine problem...");
		}
	}
}
