package i.vk.dto;

import org.springframework.stereotype.Repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Repository
@AllArgsConstructor
@NoArgsConstructor
@Setter 
@Getter
@Entity
public class EmployeeDTO {
	
	// personal details
	@Id
	private String employeeID;
	private String employeeName;
	private int age;
	private String gender;
	
	// employee details
	private String jobTitle;
	private String departmentName;
	private double salary;
	private String hireDate;
	private String employeeStatus;
	private boolean workStatus;
	
	@Override
	public String toString() {
		return "Employee Details\n----------------\n" +
		           "Employee ID: " + employeeID + "\n" +
		           "Employee Name: " + employeeName + "\n" +
		           "Age: " + age + "\n" +
		           "Gender: " + gender + "\n" +
		           "Job Title: " + jobTitle + "\n" +
		           "Department: " + departmentName + "\n" +
		           "Salary: " + salary + "\n" +
		           "Hire Date: " + hireDate + "\n" +
		           "Status: " + employeeStatus + "\n" +
		           "Work Status: " + (workStatus ? "Active" : "Inactive");
	}
}
