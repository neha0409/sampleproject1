package com.ibm.training;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;//when we use any of the property we use autowired annotation
	
	public Collection<Person> findAllPersons(){
	return jdbcTemplate.query("select * from person",    //we use query here as we get more then one person
			new BeanPropertyRowMapper<Person>(Person.class));
	}

	public Person findPerson(String id) {
	return jdbcTemplate.queryForObject("select * from person where pid=?",new BeanPropertyRowMapper<Person>(Person.class),id);
	}
	
	public void addPerson(Person person) {
	jdbcTemplate.update("insert into person values(?,?,?,?)",person.getId(),person.getFirstName(),person.getLastName(),person.getAge());
	}
	
	public int deletePerson(String id) {
	return jdbcTemplate.update("delete from person where pid=?",id);
	}
	
	public void updatePerson(Person person) {
	jdbcTemplate.update("update person set firstName=?, lastName=?, age=? where pid=?", person.getFirstName(), person.getLastName(), person.getAge(),person.getId());
		} 	
}
