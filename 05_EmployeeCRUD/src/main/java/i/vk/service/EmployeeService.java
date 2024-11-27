package i.vk.service;

import org.springframework.stereotype.Service;

import i.vk.dao.EmployeeDAO;
import i.vk.dto.EmployeeDTO;

@Service
public class EmployeeService {
	private EmployeeDAO dao;
	public EmployeeService(EmployeeDAO dao) {
		this.dao = dao;
	}
	// save  service 
	public String saveEmployee(EmployeeDTO e) {
		return dao.saveEntry(e);
	}
	// find user by id
	public  EmployeeDTO getUserById(String eid) {
		return dao.getUserById(eid);
	}
	// delete employee
	public String deleteEmployee(String eid) {
		return dao.deleterEmployee(eid);
	}
	// UPDATE EMPLOYEE 
	public String updateEmployee(EmployeeDTO e) {
		return dao.updateEmployee(e);
	}
}
