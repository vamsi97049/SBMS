package i.vk52.beans.classes;

/*
 * 
 * This class represents Bean Class
 * And we will attch this bean class information
 * to Ioc container using xml file by using 
 * fully-qualified name of this class
 *
 */
public class Teacher {  // Bean class definition
	
	
	private int tId;
	private String tName;
	private String subject;
	private int experience;
	private int salary;
	
	// Note :   
	// Default constructor plays vital role
	// in case of instantiation during Ioc container invocation.
	public Teacher() {
		System.out.println("Instantiation successful...");
	}
	
	
	public Teacher(int tId, String tName, String subject, int experience, int salary) {
		super();
		this.tId = tId;
		this.tName = tName;
		this.subject = subject;
		this.experience = experience;
		this.salary = salary;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
