package com.rays.dao;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.rays.dto.PersonDTO;


@Repository
public class PersonDAOJDBCImp implements PersonDAOInt {
	
	private JdbcTemplate jdbcTemplate;
	
@Autowired
public void setDataSource(DataSource datasource) {
	this.jdbcTemplate=new JdbcTemplate(datasource);
}


public long add(PersonDTO dto) {
	
	String sql= " insert into person values (?,?,?,?)";
	 int pk = jdbcTemplate.update(sql,dto.getId(),dto.getName(),dto.getCity(),dto.getState());
	return pk;
	
}


public void update(PersonDTO dto) {
	String sql= " update person set name=?, city=? ,state=? ,id=? ";
	 int i = jdbcTemplate.update(sql,dto.getName(),dto.getCity(),dto.getState(),dto.getId());
	 
}

public void delete (long id) {
	String sql="delete from person where id=?";
	Object[] param = {id};
	int i = jdbcTemplate.update(sql,param);
}

public List search(PersonDTO dto, int PageNO,int PageSize) {
	String sql=" select id,name,city,state from limit "+ PageNO + "," + PageSize ;
	List l=jdbcTemplate.query(sql, new PersonMapper());
	return l;
}

public List search(PersonDTO dto) {
	String sql="select id,name,city,state form person";
	List l=jdbcTemplate.query(sql, new PersonMapper());
	return l;
	
	
}

public PersonDTO findByPK(long pk) {
	String sql= "select * from person where id=?";
	Object[] param= {pk};
	List list=jdbcTemplate.query(sql,param,new PersonMapper());
	PersonDTO dto=null;
	
	if(list.size()>0) {
		dto=(PersonDTO) list.get(0);
		
	}
	return dto;
}

}





