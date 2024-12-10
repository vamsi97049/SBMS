package i.vk.emprepo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import i.vk.dto.Emp;
import jakarta.transaction.Transactional;

public interface EmpRepo extends CrudRepository<Emp, String> {
	// Save New Entry
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO SBMS52.EMP (employee_id,employee_name,email_id,mobile_number) VALUES (?,?,?,?)", nativeQuery = true)
	public void recordSaver(String employeeId, String employeeName, String employeeEmailId, Long mobileNumber);
	
	@Query(value="SELECT * FROM SBMS52.EMP WHERE employee_id=?",nativeQuery=true)
	public Emp getRecord(String employeeId);
	
	
	@Query(
    value="UPDATE SBMS52.EMP SET employee_name=:name,email_id=:email,mobile_number=:mobile WHERE employee_id=:eid",
    nativeQuery=true)
	public void updateRecordById(String eid,String name,String email,Long mobile);
	
	@Transactional
	@Modifying
	@Query(value="DELETE FROM EMP WHERE employee_id=?",nativeQuery=true)
	public void deleteRecordById(String eid);
	
	@Transactional
	@Modifying
	@Query(value="INSERT INTO EMP (employee_id, email_id, employee_name, mobile_number)"
			    +"VALUES (?, ?, ?, ?), (?, ?, ?, ?), (?, ?, ?, ?)", nativeQuery=true)
	public void saveAllRecords(String eid1,String ename1,String email1,Long mobile1,
			                   String eid2,String ename2,String email2,Long mobile2,
			                   String eid3,String ename3,String email3,Long mobile3);
	
	
	@Query(value="SELECT * FROM SBMS52.EMP",nativeQuery=true)
	public List<Emp> getAllRecords();
	
	
}
