package i.vk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import i.vk.dto.Emp;
import i.vk.emprepo.EmpRepo;

@Service
public class EmployeeAshokITService {
	private EmpRepo empRepo;

	public EmployeeAshokITService(EmpRepo empRepo) {
		this.empRepo = empRepo;
	}
	
	public void saveEmployee() {
		empRepo.recordSaver("VK801984","Kamparaju Aadhya","aadhya23@gmail.com",6304492756L);
	}
	
	public void updateRecordById() {
		empRepo.updateRecordById("VK801984", "Balagala Aadya verma", "aadhya24@gmail.com",6304492755L);
	}
	
	public void getRecord() {
		Emp record = empRepo.getRecord("VK801984");
		System.out.println(record);	
	}
	
	public void deleteRecordById() {
		empRepo.deleteRecordById("VK801984");
	}
	
	public void saveAllRecords() {
		empRepo.saveAllRecords(
				"VK801989", "Kamparaju Aadya verma", "aadhya24@gmail.com",6304492755L,
				"VK801988", "Pathallapalli Adhitya verma", "pathallapalli987@gmail.com",9502634085L,
				"VK801987", "Sirivella Kailash verma", "kailaashh73.99@gmail.com",9503498420L);
		}
	
	public void getAllRecords(){
		List<Emp> allRecords = empRepo.getAllRecords();
		allRecords.forEach(System.out::println);
	}
}
