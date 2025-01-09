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
public class AdminUser {
	@Id
	private int adminId;
	private String adminPassword;
	private String adminLogPin;
	@Override
    public String toString() {
        return "AdminUser\n" +
        	   "----------------------------------------"+
               "\nadminId :: " + adminId +
               "\nadminPassword :: " + adminPassword +
               "\nadminLogPin :: " + adminLogPin+
               "\n----------------------------------------";
    }
}
