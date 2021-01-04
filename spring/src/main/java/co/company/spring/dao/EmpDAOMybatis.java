package co.company.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpDAOMybatis {
	
	@Autowired SqlSession sqlSession;
	
	public List<Emp> getEmpList(){
		return sqlSession.selectList("EmpDAOMybatis.getEmpList");
	}
	
	
}
