package i.vk.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="USER_INFO")
@Entity
public class User {
	@Id
	@Column(name="user_id") // Giving custom name  ( optional )
	private Integer id; 
	// If do no use @Column then variable name taken as column name
	
	private String name;
	private String gender;
	private String country;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate createdAr; // To know when record is createdo
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDate lastUpdated; // To track updates on record.
	
	
}
