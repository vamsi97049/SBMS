package i.vk.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import i.vk.dto.AdminUser;
import jakarta.transaction.Transactional;

public interface AdminUserRepo extends CrudRepository<AdminUser,Integer> {
	// CUSTOM QUERY METHODS WITH HQL, TO PERFORM CRUD OPERATIONS 
	
	// CREATE     (   C   )
	@Modifying
	@Transactional
	@Query(value="INSERT INTO AdminUser (adminId, adminPassword, adminLogPin) VALUES (:adminId, :adminPassword, :adminLogPin)",nativeQuery=true)
	public void saveAdminRecord(int adminId,String adminPassword,String adminLogPin);

	// READ       (   R   ) 
	@Query("FROM AdminUser where adminId=:adminId")
	public AdminUser readRecordById(int adminId);
	
	@Modifying
	@Transactional
	@Query("UPDATE AdminUser SET adminPassword=:password, adminLogPin=:logPin WHERE adminId=:adminId")
	public void updateRecordById(int adminId, String password,String logPin);
	
	
	// DELETE       (   D   )
	
	@Transactional
	@Modifying
	@Query("DELETE AdminUser WHERE adminId=:adminId")
	public void deleteRecordById(int adminId);
	
	
	// READ ALL METHOD
	@Query("FROM AdminUser")
	public List<AdminUser> readRecords();
	
	

}
