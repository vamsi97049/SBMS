package i.vk.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Repository
@Entity
public class LoginSource {
	
	public LoginSource() {
		this.isPasswordUpdated=1;
	}
	
	@Id
	private String userId;
	private String password;
	
	private Integer isPasswordUpdated;
	private Integer OTP;
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate createdOn;
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDate updatedOn;
}
