package com.rays.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.rays.dao.UserDAOHibImp;
import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;

@Service
public class UserServiceImp implements UserServiceInt {
	
	@Autowired
	private UserDAOHibImp dao=null;
   
	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) { 
		long pk=dao.add(dto);
		return pk;
	}
    
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {
		dao.update(dto);
		
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public UserDTO delete(long id) {
		UserDTO deletedUser=dao.delete(id);
		return deletedUser;
	}
	@Transactional(readOnly = true)
	public UserDTO findByLogin(String login) {
		// TODO Auto-generated method stub
		return dao.findByLogin(login);
	}
	@Transactional(readOnly=true)
	public UserDTO auth(String login, String password) {
		UserDTO user=dao.auth(login, password);
		return user;
	}
	@Transactional(readOnly=true)
	public List search(UserDTO dto) {
		return dao.search(dto);
	}
	@Transactional(readOnly=true)
	public List search(UserDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}
	@Transactional(readOnly=true)
	public UserDTO findByPk(long pk) {
		return dao.findByPk(pk);
	}


}
