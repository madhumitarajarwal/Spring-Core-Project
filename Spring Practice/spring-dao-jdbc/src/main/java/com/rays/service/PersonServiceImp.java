package com.rays.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.PersonDAOInt;
import com.rays.dto.PersonDTO;

@Service
public class PersonServiceImp implements PersonServiceInt {
	
	@Autowired
	private PersonDAOInt dao=null;
	
	@Transactional(propagation=Propagation.REQUIRED)
   public long add(PersonDTO dto) {
		  long pk=dao.add(dto);
		return pk;
	}

   @Transactional(propagation=Propagation.REQUIRED)
	public void update(PersonDTO dto) {
		dao.update(dto);
		
	}
   
   @Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}
   
   @Transactional(readOnly = true)
	public PersonDTO findByPk(long pk) {
		return dao.findByPK(pk);
	}
   
   @Transactional(readOnly=true)
	public List search(PersonDTO dto) {
		return dao.search(dto);
	}
   
   @Transactional(readOnly=true)
	public List search(PersonDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}


}
