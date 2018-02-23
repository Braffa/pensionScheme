package com.fdm.pensionScheme.controller;

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
		System.out.println("Got here - getCharities  " + empId);

		List<Employee> lOfEmployees  = (List<Employee>)session.getAttribute("lOfEmployees");
		for (Employee e : lOfEmployees) {
			System.out.println(e.toString());
		}

		List<Charity> lOfMyCharities = (List<Charity>)session.getAttribute("lOfCharities");
		for (Charity c : lOfMyCharities) {
			System.out.println(c.toString());
		}

		CharityForm charityForm = new CharityForm();
		charityForm.setEmpId(empId);
		charityForm.setCharities(lOfMyCharities);
		return new ModelAndView("charity", "charityForm", charityForm);

	}

	@RequestMapping(value = "/asignCharities", method = RequestMethod.POST)
	public ModelAndView assignMyCharities(HttpSession session, @ModelAttribute("chId") String charityId, 
			@ModelAttribute("empId") String empId, 
			BindingResult result, ModelMap model) {
		System.out.println("Get here- asignCharities");
		System.out.println("charity id " + charityId);
		System.out.println("empId " + empId);
		
		List<Employee> lOfMyEmployees  = (List<Employee>)session.getAttribute("lOfEmployees");
		List<Charity> lOfMyCharities = (List<Charity>)session.getAttribute("lOfCharities");
		
		Charity ch = new Charity();
		int reqCharity = Integer.parseInt(charityId);
		for (Charity c : lOfMyCharities) {
			if (c.getCharityId() == reqCharity) {
				ch.setCharityId(c.getCharityId());
				ch.setCharityName(c.getCharityName());
				break;
			}
		}
		for (Employee e : lOfMyEmployees) {
			if (e.getNiNumber().equals(empId)) {
				List<Charity> chars = e.getCharities();
				chars.add(ch);
				e.setCharities(chars);
				break;
			}
		}
		
		EmployeeForm employeeForm = new EmployeeForm();
		employeeForm.setEmployees(lOfMyEmployees);
		
		
		return new ModelAndView("employee", "employeeForm", employeeForm);

	}
	
}
