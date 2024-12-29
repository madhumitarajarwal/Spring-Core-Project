package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.rays.dto.PersonDTO;
import com.rays.service.PersonServiceInt;

@Component("testPersonService")
public class TestPersonService {
	
	@Autowired
	public PersonServiceInt service=null;
	
	public static void main(String[] args) {
	ApplicationContext context=	new ClassPathXmlApplicationContext("person.xml");
	    TestPersonService service = (TestPersonService) context.getBean("testPersonService");
	    service.testAdd();
	    
	}
   public void testAdd() {
	  PersonDTO dto= new PersonDTO();
	  dto.setId(1);
	  dto.setName("mita");
	  dto.setCity("Pune");
	  dto.setState("Mumbai");
	  
	  long pk=service.add(dto);
	  System.out.println(" data inserted"+pk);
   }
	public void testUpdate() {
		PersonDTO dto= new PersonDTO();
		dto.setId(1);
		 dto.setName("akrati");
		  dto.setCity("Bhopal");
		  dto.setState("MP");
		  service.update(dto);
		  System.out.println("updatedddd");
	}
	private void testDelete() {
		PersonDTO dto= new PersonDTO();

		service.delete(1);
	}
	
	public void testSearch() {
		
	PersonDTO dto = new PersonDTO();
	
	   List<PersonDTO> list= service.search(dto, 0, 5);
	  Iterator it= list.iterator();
	  
	  while(it.hasNext()) {
		  dto=(PersonDTO)it.next();
		  System.out.println(dto.getId());
		  System.out.println("/t" + dto.getName());
		  System.out.println("/t" + dto.getCity());
		  System.out.println("/t"+dto.getState());
	  }
	}
}
