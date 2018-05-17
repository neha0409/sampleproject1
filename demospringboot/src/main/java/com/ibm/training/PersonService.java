package com.ibm.training;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	@Autowired
	PersonDaoImpl personDaoImpl;	
	
	/*Hashtable<String, Person> ht=new Hashtable<>();
	public PersonService() {
		Person p=new Person("1","neha","singh",21);
		Person p1=new Person("2","ashima","agarwal",21);
		Person p2=new Person("3","megha","varma",21);
		ht.put("1", p);
		ht.put("2", p1);
		ht.put("3", p2);
		}*/
	public Collection<Person> getAllPersons(){
		return personDaoImpl.findAllPersons();
	}
	/*public Person getPerson(String id) {      //we get only one person on the basis of the id
		return ht.get(id);
		}*/

	public Person getPerson(String id) {
		return personDaoImpl.findPerson(id);
	}
	
	public void addPerson(Person p) {
		 personDaoImpl.addPerson(p);
	}

	public int deletePerson(String id) {
		return personDaoImpl.deletePerson(id);
	}
	
	public void updatePerson(Person p) {
	   	 personDaoImpl.updatePerson(p);
	       } 
	
}
