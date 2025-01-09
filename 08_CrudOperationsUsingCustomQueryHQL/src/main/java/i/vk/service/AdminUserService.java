package i.vk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import i.vk.dto.AdminUser;
import i.vk.repo.AdminUserRepo;

@Service
public class AdminUserService {
	AdminUserRepo repo;

	public AdminUserService(AdminUserRepo repo) {
		this.repo = repo;
	}

	// CREATE ( C )
	public void saveAdminRecord() {
		repo.saveAdminRecord(970448, "Wi_@13029", "LaT#95.11");
	}

	// READ ( R )
	public void readRecordById() {
		AdminUser record = repo.readRecordById(970448);
		System.out.println(record);
	}

	// UPDATE ( U )
	public void updateRecordById() {
		repo.updateRecordById(970499, "Ayaaan_3@2_Khaan", "Lat#00.98");
	}

	// DELETE ( D )
	public void deleteRecordById() {
		repo.deleteRecordById(970499);
	}

	public void readAllRecords() {
		List<AdminUser> records = repo.readRecords();
		records.forEach(System.out::println);
	}
}
