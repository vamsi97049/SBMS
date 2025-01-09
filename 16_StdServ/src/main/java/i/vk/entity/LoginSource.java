package i.vk.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import i.vk.configurations.MultipleOfTen;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class LoginSource {
	@Id
	@NotEmpty(message = "Enter email id")
	private String emailId;
	@NotEmpty(message = "Enter Password")
	@Size(min=6,max=32,message = "Length should be 6-32 char's only")
	@Pattern(
	        regexp = "^(?=.*[A-Z])(?=.*\\d)[^~&%\\-_{}\\[\\]:;'\"\\(\\)]*$",
	        message = "Invalid Password pattern"
	    )
	private String password;
	@NotNull(message="Please specify the role")
	@MultipleOfTen(message = "Invalid role") // custom annotation to check value is multiple of 10 or not
	private int role;
	@NotNull(message = "Lock Status can not be empty")
	private int isLocked;
	@NotNull(message = "Suspended status can not be empty")
	private int isSuspended;
	
	@Column(nullable = true)
	private int otp;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate createdOn;
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDate lastUpdateOn;
}
