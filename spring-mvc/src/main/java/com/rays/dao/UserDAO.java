package com.rays.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;


import com.rays.dto.UserDTO;

@Repository
public class UserDAO {
	
	@Autowired
	public SessionFactory sessionFactory;
	
	public long add(UserDTO dto)throws DataAccessException{
		long pk=(long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}
	public void update(UserDTO dto)throws DataAccessException{
		sessionFactory.getCurrentSession().update(dto);
	}
	public UserDTO delete(long id)throws DataAccessException{
		UserDTO dto=findByPk(id);
		sessionFactory.getCurrentSession().delete(dto);
		return dto;
		}
	public UserDTO findByPk(long pk) throws DataAccessException {
		UserDTO dto = null;
		dto = (UserDTO) sessionFactory.getCurrentSession().get(UserDTO.class, pk);
		return dto;
	}
	public UserDTO authenticate(String login,String pasword) {
		UserDTO dto=null;
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Restrictions.eq("login", login));
		criteria.add(Restrictions.eq("password", pasword));
		List list = criteria.list();
		if (list.size() == 1) {
			dto = (UserDTO) list.get(0);
		}
		return dto;
	}
	public UserDTO findByLogin(String login) throws DataAccessException {
		UserDTO dto = null;
		System.out.println("login " + login);
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Restrictions.eq("login", login));
		List list = criteria.list();
		if (list.size() == 1) {
			dto = (UserDTO) list.get(0);
		}
		return dto;
	}
	public List search(UserDTO dto, int pageNo, int pageSize)throws DataAccessException {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		if (dto != null) {
			if ( dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
			}
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				criteria.add(Restrictions.like("lastName", dto.getLastName() + "%"));
			}
			if (dto.getLogin() != null && dto.getLogin().length() > 0) {
				criteria.add(Restrictions.like("login", dto.getLogin() + "%"));
			}
			if (dto.getDob() != null) {
				criteria.add(Restrictions.like("dob", dto.getDob()));
			}
		}
		if (pageSize > 0) {
			
			System.out.println("search dao");
			pageNo = (pageNo - 1) * pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}
		List list = criteria.list();
		return list;
	}

}
