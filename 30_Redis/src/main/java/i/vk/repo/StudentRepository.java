package i.vk.repo;

import org.springframework.data.repository.CrudRepository;

import i.vk.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

}