package i.vk.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Repository
@Table(name = "user_tble")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    
    
    @NotEmpty(message = "Name is mandatory")
    private String name;
    
    @NotEmpty(message = "Email id mandatory")
    @Column(unique = true)
    @Email(message = "Enter Valid Emails Id")
    private String email;
    
    @NotNull(message = "Phone Number is mandatory")
    private Long phone;
    
    @CreationTimestamp
    @Column(updatable=false)
    private LocalDate createdOn;
    
    @UpdateTimestamp
    @Column(insertable=false)
    private LocalDate updatedOn;
}
