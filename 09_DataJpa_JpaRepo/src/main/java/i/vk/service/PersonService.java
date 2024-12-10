package i.vk.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import i.vk.entiry.Person;
import i.vk.repo.PersonRepo;

@Service
public class PersonService {
	@Autowired
	private PersonRepo repo;
	
	public void getPersonsByPagination() {
		int pageSize = 2;
		int pageNo = 2;
		
		PageRequest pagination = PageRequest.of(pageNo-1,pageSize);
		Page<Person> all = repo.findAll(pagination);
		List<Person> content = all.getContent();
		content.forEach(System.out::println);
	}

	public void getPersonsByQBE(String gender, String country) {
		Person p = new Person();
		if(gender!=null) {
			p.setGender(gender);
		}
		if(country!=null) {
			p.setCountry(country);
		}
		Example<Person> example = Example.of(p); 
		// Based on non-null properties JpaRepo generates dynamic query
		// Used for applying filters ( dynamic )
		
		List<Person> all = repo.findAll(example);
		all.forEach(System.out::println);
	}

	public void getPersons() {
//		Sort sort = Sort.by(Sort.Order.asc("name"),Sort.Order.desc("age"));
		Sort sort = Sort.by("age").descending();
		List<Person> all = repo.findAll(sort);
		all.forEach(System.out::println);
	}

	public void savePerson() {
		Person p1 = new Person(1001, "Vamsi Krishna", 24, "Male", "IND");
		Person p2 = new Person(1002, "Dinesh Kumar", 26, "Male", "USA");
		Person p3 = new Person(1003, "Nagurvali", 26, "Male", "UAE");
		Person p4 = new Person(1004, "Nagulmeerabi", 25, "Female", "UAE");
		Person p5 = new Person(1005, "Rajashekar Reddy", 24, "Male", "IND");
		Person p6 = new Person(1006, "vamsi", 18, "Male", "AUS");
		repo.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
	}
}
