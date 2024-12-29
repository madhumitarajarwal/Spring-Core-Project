package com.rays.dao;

import java.util.List;

import com.rays.dto.PersonDTO;

public interface PersonDAOInt {
	
	public  long add(PersonDTO dto);

	public void update(PersonDTO dto);

	public void delete(long id);

	public PersonDTO findByPK(long pk);

	public List search(PersonDTO dto);

	public List search(PersonDTO dto, int pageNo, int pageSize);

}
