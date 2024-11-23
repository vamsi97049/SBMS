package i.vk52.beans;

public class Motor {
	// default constructor 
	public Motor() {
		System.out.println("Motor:: 0-param constructor");
	}
	
	//  init method 
	public void start() {
		System.out.println("Inside Start method");
		System.out.println("StartMethod::ExecutionEntryPoint");
	}
	
	// service method
	public void service() {
		System.out.println("Inside Service method ");
		System.out.println("Motor is running");
	}
	
	// destroy method
	public void stop() {
		System.out.println("Inside Destroy method");
		System.out.println("DestroyMethod::ExecutionEndPoint");

	}
}
