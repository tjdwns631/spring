package co.company.spring.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.company.spring.dao.Dept;
import co.company.spring.dao.Emp;
import co.company.spring.dao.EmpMapper;
import co.company.spring.dao.EmpSearch;
import co.company.spring.dao.Jobs;
import co.company.spring.emp.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired EmpMapper dao;
	
	@Override
	public List<Emp> getEmpList(EmpSearch emp) {
		// TODO Auto-generated method stub
		return dao.getEmpList(emp);
	}

	@Override
	public int getCount(EmpSearch emp) {
		// TODO Auto-generated method stub
		return dao.getCount(emp);
	}

	@Override
	public List<Map<String, Object>> getStatDept() {
		// TODO Auto-generated method stub
		return dao.getStatDept();
	}

	@Override
	public int updateEmp(Emp emp) {
		// TODO Auto-generated method stub
		return dao.updateEmp(emp);
	}

	@Override
	public Emp getEmp(Emp emp) {
		// TODO Auto-generated method stub
		return dao.getEmp(emp);
	}

	@Override
	public int insertEmp(Emp emp) {
		// TODO Auto-generated method stub
		return dao.insertEmp(emp);
	}

	@Override
	public void insertEmpProc(Emp emp) {
		// TODO Auto-generated method stub
		dao.insertEmpProc(emp);
	}

	@Override
	public int deleteEmp(Emp emp) {
		// TODO Auto-generated method stub
		return dao.deleteEmp(emp);
	}

	@Override
	public int deleteMultiEmp(EmpSearch emp) {
		// TODO Auto-generated method stub
		return dao.deleteMultiEmp(emp);
	}

	@Override
	public List<Jobs> jobSelect() {
		// TODO Auto-generated method stub
		return dao.jobSelect();
	}

	@Override
	public List<Dept> deptSelect() {
		// TODO Auto-generated method stub
		return dao.deptSelect();
	}
	

}
