package co.company.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import co.company.spring.config.DBConfiguration;
import co.company.spring.dao.Emp;
import co.company.spring.dao.EmpDAOJdbcTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DBConfiguration.class })
public class EmpDAOJdbcTemplateClient {
	@Autowired
	EmpDAOJdbcTemplate empDAO;

	@Test
	public void empdaotest() {
		System.out.print(empDAO.getListMap());
	}
	
	@Test
	public void inserttest() {
		Emp emp = new Emp();
		emp.setEmployeeId("1000");
		emp.setLastName("jjunn");
		emp.setEmail("aa@a.a");
		empDAO.insert(emp);
		
	}
}
