package i.vk;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import i.vk.dto.EmployeeDTO;
import i.vk.service.EmployeeService;

@SpringBootApplication
public class Application {

	public static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		EmployeeService service = context.getBean(EmployeeService.class);
		System.out.println("\tEnter the option :: ");
		System.out.println("\t1)New Employee  2)Get Employee Details");
		System.out.println("\t3)Delete Employee  4)Update Employee Details");
		int chs = scan.nextInt();
		switch (chs) {
		case 1: {
			save(service);
			break;
		}
		case 2: {
			getEmployee(service);
			break;
		}
		case 3: {
			deleteEmployee(service);
			break;
		}
		case 4: {
			updateEmployeeById(service);
			break;
		}
		}
	}

	private static void updateEmployeeById(EmployeeService service) {
		System.out.print("Enter Employee ID :: ");
		String eid = scan.next();
		EmployeeDTO emp = service.getUserById(eid);
		if (emp.getEmployeeID()==eid) {
			System.out.print("Enter Employee Name :: ");
			String name = scan.next();
			System.out.print("Enter Age :: ");
			int age = scan.nextInt();
			System.out.print("Enter Gender :: ");
			String gender = scan.next();
			System.out.print("Enter Job Title :: ");
			String jobTitle = scan.next();
			System.out.print("Enter Department Name :: ");
			String departmentName = scan.next();
			System.out.print("Enter Salary :: ");
			double salary = scan.nextDouble();
			System.out.print("Enter Hire Date (YYYY-MM-DD) :: ");
			String hireDate = scan.next();
			System.out.print("Enter Employee Status (Active/Inactive) :: ");
			String employeeStatus = scan.next();
			System.out.print("Enter Work Status (true for active, false for inactive) :: ");
			boolean workStatus = scan.nextBoolean();
			EmployeeDTO newEmployee = new EmployeeDTO(eid, name, age, gender, jobTitle, departmentName, salary,
					hireDate, employeeStatus, workStatus);
			String result = service.updateEmployee(newEmployee);
			System.out.println(result);
		} else {
			System.out.println("Employee with this ID already exists.");
		}

	
	}

	public static void deleteEmployee(EmployeeService service) {
		System.out.print("Enter Employee ID :: ");
		String eid = scan.next();
		String result = service.deleteEmployee(eid);
		System.out.println(result);
	}

	public static void getEmployee(EmployeeService service) {
		System.out.print("Enter Employee ID :: ");
		String eid = scan.next();
		EmployeeDTO record = service.getUserById(eid);
		System.out.println(record);
	}

	public static void save(EmployeeService service) {
		System.out.print("Enter Employee ID :: ");
		String eid = scan.next();
		EmployeeDTO record = service.getUserById(eid);

		if (record==null) { // Check if the record doesn't exist
			System.out.print("Enter Employee Name :: ");
			String name = scan.next();
			System.out.print("Enter Age :: ");
			int age = scan.nextInt();
			System.out.print("Enter Gender :: ");
			String gender = scan.next();
			System.out.print("Enter Job Title :: ");
			String jobTitle = scan.next();
			System.out.print("Enter Department Name :: ");
			String departmentName = scan.next();
			System.out.print("Enter Salary :: ");
			double salary = scan.nextDouble();
			System.out.print("Enter Hire Date (YYYY-MM-DD) :: ");
			String hireDate = scan.next();
			System.out.print("Enter Employee Status (Active/Inactive) :: ");
			String employeeStatus = scan.next();
			System.out.print("Enter Work Status (true for active, false for inactive) :: ");
			boolean workStatus = scan.nextBoolean();
			EmployeeDTO newEmployee = new EmployeeDTO(eid, name, age, gender, jobTitle, departmentName, salary,
					hireDate, employeeStatus, workStatus);
			String result = service.saveEmployee(newEmployee);
			System.out.println(result);
		} else {
			System.out.println("Employee with this ID already exists.");
		}
	}

}
