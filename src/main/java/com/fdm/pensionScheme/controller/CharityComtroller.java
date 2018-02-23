package com.fdm.pensionScheme.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fdm.pensionScheme.beans.Charity;
import com.fdm.pensionScheme.beans.Employee;
import com.fdm.pensionScheme.dataload.LoadCharityData;
import com.fdm.pensionScheme.dataload.LoadEmployeeData;
import com.fdm.pensionScheme.form.CharityForm;
import com.fdm.pensionScheme.form.EmployeeForm;

@Controller
public class CharityComtroller {

	@RequestMapping(value = "/charity", method = RequestMethod.GET)
	public ModelAndView getCharities(@RequestParam String empId, Map<String, Object> model) {
		System.out.println("Got here - getCharities  " + empId);


		CharityForm charityForm = new CharityForm();
		List<Charity> lOfCharities = getAllCharities();
		charityForm.setEmpId(empId);
		charityForm.setCharities(lOfCharities);
		return new ModelAndView("charity", "charityForm", charityForm);

	}

	
	@RequestMapping(value = "/asignCharities", method = RequestMethod.POST)
	public ModelAndView assignCharities(@ModelAttribute("chId") String charityId, 
			@ModelAttribute("empId") String empId, 
			BindingResult result, ModelMap model) {
		System.out.println("Get here- asignCharities");
		System.out.println("charity id " + charityId);
		System.out.println("empId " + empId);
		
		List<Employee> employees = assignCharity(empId, charityId);
		
		EmployeeForm employeeForm = new EmployeeForm();
		employeeForm.setEmployees(employees);
		
		
		return new ModelAndView("employee", "employeeForm", employeeForm);

	}
	
	private List<Employee> assignCharity(String empId, String charityId) {
		LoadEmployeeData loadEmployeeData = new LoadEmployeeData();
		List<Employee> lOfEmployees = new ArrayList<Employee>();
		
		try {
			lOfEmployees = loadEmployeeData.readFile("src/test/resources/employee.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		Charity selectedCharity = getCharityById(charityId);
		
		for(Employee emp : lOfEmployees) {
			if(emp.getNiNumber().equals(empId)) {
				emp.addCharities(selectedCharity);
				
			}
		}
	
		return lOfEmployees;
	}
		
	private List<Charity> getAllCharities() {

		LoadCharityData loadCharityData = new LoadCharityData();
		List<Charity> lOfCharities = new ArrayList<Charity>();
		try {
			lOfCharities = loadCharityData.readFile("src/test/resources/charity.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lOfCharities;
	}
	
	@SuppressWarnings("unused")
	private Charity getCharityById (String charityId) {
		
		List<Charity> lOfCharities = getAllCharities();
		
		for(Charity ch :lOfCharities ) {
			if(String.valueOf(ch.getCharityId()).equals(charityId)) return ch;
	}
		return null;
		
	}
}
