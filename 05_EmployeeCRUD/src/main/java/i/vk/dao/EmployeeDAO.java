package i.vk.dao;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import i.vk.dto.EmployeeDTO;
import i.vk.repository.DataSourceProvider;

@Repository
public class EmployeeDAO {
	// GETTING CONNECTION
	private DataSourceProvider conn;

	public EmployeeDAO(DataSourceProvider conn) {
		this.conn = conn;
	}

	// SAVE NEW RECORD
	public String saveEntry(EmployeeDTO e) {
		if (!conn.existsById(e.getEmployeeID())) {
			conn.save(e);
			return "Employee Record details are captured.";
		}
		return e.getEmployeeID() + " is existing user.";
	}

	// GET USER BY ID
	public EmployeeDTO getUserById(String eid) {
		Optional<EmployeeDTO> record = conn.findById(eid);

		return record.get();
	}

	// DELETE USER BY ID
	public String deleterEmployee(String eid) {
		if (!conn.existsById(eid)) {
			return "Employee not found with id :: " + eid + ", Please check once.";
		}
		conn.deleteById(eid);
		return "Record deleted from DB";
	}

	// UPDATE USER BY ID
	public String updateEmployee(EmployeeDTO e) {
		conn.save(e);
		return "Record updated. Please check once.";
	}
}
