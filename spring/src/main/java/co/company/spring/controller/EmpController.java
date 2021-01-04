package co.company.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.company.spring.dao.Dept;
import co.company.spring.dao.Emp;
import co.company.spring.dao.EmpMapper;
import co.company.spring.dao.EmpSearch;
import co.company.spring.dao.Jobs;
import co.company.spring.emp.service.EmpService;
import co.company.spring.users.controller.EmpValidator;

@Controller
public class EmpController {
	@Autowired
	EmpService service;

	@RequestMapping("/ajax/jobSelect")
	@ResponseBody
	public List<Jobs> jobSelect() {
		return service.jobSelect();
	}

	@ModelAttribute("jobs")
	public List<Jobs> jobs(){
		return service.jobSelect();
	}
	@ModelAttribute("depts")
	public List<Dept> depts(){
		return service.deptSelect();
	}
	
	
	@RequestMapping(value = "/empSelect", method = RequestMethod.GET)
	public ModelAndView select(EmpSearch emp) {
		ModelAndView mav = new ModelAndView();
		// 조회
		mav.addObject("list", service.getEmpList(null)); // null 전체 조회
		mav.setViewName("emp/select");
		return mav;
	}

	@GetMapping("/empinsertForm")
	public String insertform(Model model, Emp emp) {
//		model.addAttribute("jobs", dao.jobSelect());
//		model.addAttribute("depts", dao.deptSelect());
		return "emp/insert"; // forward
	}

	@GetMapping("/empUpdateForm")
	public String updateForm(Model model, Emp emp) {
		model.addAttribute("emp", service.getEmp(emp));
		model.addAttribute("jobs", service.jobSelect());
		model.addAttribute("depts", service.deptSelect());
		return "emp/insert"; // forward
	}

	@PostMapping("/empInsert")
	public String insert(Model model, Emp emp, Errors errors) {
		
		new EmpValidator().validate(emp,errors);
		if(errors.hasErrors()){
			return"emp/insert";
		}
		
		if (emp.getEmployeeId() == null)
			service.insertEmp(emp);
		else
			service.updateEmp(emp);
		return "emp/insertOutput";
	}

}
