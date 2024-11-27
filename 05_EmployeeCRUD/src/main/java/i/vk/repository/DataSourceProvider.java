package i.vk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import i.vk.dto.EmployeeDTO;

public interface DataSourceProvider extends JpaRepository<EmployeeDTO,String> {
	// JpaRepository will take care about implementation
}
