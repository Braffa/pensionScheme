package com.fdm.pensionScheme.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fdm.pensionScheme.beans.Charity;
import com.fdm.pensionScheme.beans.Employee;
import com.fdm.pensionScheme.form.CharityForm;
import com.fdm.pensionScheme.form.EmployeeForm;

@Controller
@Scope("session")
public class CharityComtroller {

	@RequestMapping(value = "/charity", method = RequestMethod.GET)
	public ModelAndView getCharities(HttpSession session, @RequestParam String empId, Map<String, Object> model) {
		Map<Integer, Charity> mOfCharities = (Map<Integer, Charity>)session.getAttribute("mOfCharities");
		List<Charity> lOfCharities = new ArrayList<Charity>();
		for (Map.Entry<Integer, Charity> entry : mOfCharities.entrySet()) {
			lOfCharities.add(entry.getValue());
		}
		CharityForm charityForm = new CharityForm();
		charityForm.setEmpId(empId);
		charityForm.setCharities(lOfCharities);
		return new ModelAndView("charity", "charityForm", charityForm);
	}

	@RequestMapping(value = "/asignCharities", method = RequestMethod.POST)
	public ModelAndView assignMyCharities(HttpSession session, @ModelAttribute("chId") String charityId, 
			@ModelAttribute("empId") String empId, 
			BindingResult result, ModelMap model) {
		System.out.println("Get here- asignCharities");
		System.out.println("charity id " + charityId);
		System.out.println("empId " + empId);
		
		Map<Integer, Charity> mOfCharities = (Map<Integer, Charity>)session.getAttribute("mOfCharities");
		int reqCharity = Integer.parseInt(charityId);
		Charity ch = mOfCharities.get(reqCharity);
		
		Map<String, Employee> mOfEmployees = (Map<String, Employee>)session.getAttribute("mOfEmployees");
		Employee e = mOfEmployees.get(empId);
		e.getCharities().add(ch);
		List<Employee> lOfEmployees = new ArrayList<Employee>();
		for (Map.Entry<String, Employee> entry : mOfEmployees.entrySet()) {
			lOfEmployees.add(entry.getValue());
		}
		EmployeeForm employeeForm = new EmployeeForm();
		employeeForm.setEmployees(lOfEmployees);
		return new ModelAndView("employee", "employeeForm", employeeForm);
	}
	
}
