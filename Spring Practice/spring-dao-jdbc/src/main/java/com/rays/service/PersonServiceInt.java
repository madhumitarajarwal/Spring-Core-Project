package com.rays.service;

import java.util.List;

import com.rays.dto.PersonDTO;

public interface PersonServiceInt {
	
	public long add(PersonDTO dto);
	public void update(PersonDTO dto);
	public void delete(long id);
	public PersonDTO findByPk(long pk);
	public List search(PersonDTO dto);
	public List search(PersonDTO dto,int pageNo,int pageSize);

}
