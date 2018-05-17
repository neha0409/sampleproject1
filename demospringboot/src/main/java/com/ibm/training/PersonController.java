package com.ibm.training;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/persons")
public class PersonController {
	@Autowired
	PersonService pservice;
	
	@RequestMapping("/all")
	public Collection<Person> getAll(){
		return pservice.getAllPersons();
	}
	
	@RequestMapping("{id}")
	public Person getPerson(@PathVariable ("id") String id){
		return pservice.getPerson(id);
	}
	
	@RequestMapping("/insert")
	public Person getPerson(@RequestBody Person p) {
		 pservice.addPerson(p);
		 return p;
	}
	
	@RequestMapping("/delete/{id}")
	public int deletePerson(@PathVariable ("id") String id) {
		return pservice.deletePerson(id);
	}
	
	@RequestMapping("/update")
	public void updatePerson(@RequestBody Person p) {
		pservice.updatePerson(p);
	} 
}


