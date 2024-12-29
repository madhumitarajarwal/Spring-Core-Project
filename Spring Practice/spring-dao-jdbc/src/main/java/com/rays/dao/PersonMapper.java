package com.rays.dao;

import java.sql.ResultSet;

import org.springframework.jdbc.core.RowMapper;

import com.rays.dto.PersonDTO;

public class PersonMapper implements RowMapper<PersonDTO> {
	public PersonDTO mapRow (ResultSet rs,int rownum) {
		PersonDTO person =new PersonDTO();
		person.setId(1);
		person.setName("madhumita");
		person.setCity("indore");
		person.setState("Mp");
		return person;
		
		
	}
   
}
