package com.fdm.pensionScheme.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fdm.pensionScheme.beans.Charity;
import com.fdm.pensionScheme.beans.Employee;
import com.fdm.pensionScheme.dataload.LoadCharityData;
import com.fdm.pensionScheme.dataload.LoadEmployeeData;
import com.fdm.pensionScheme.form.EmployeeForm;

@Controller
public class EmployeeController {
	
	@RequestMapping(value = "/employee")
	public ModelAndView welcome(Map<String, Object> model) {
		System.out.println("Got here");
		
		LoadEmployeeData loadEmployeeData = new LoadEmployeeData();
		List<Employee> lOfEmployees = new ArrayList<Employee>();
		
		try {
			lOfEmployees = loadEmployeeData.readFile("src/test/resources/employee.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		EmployeeForm employeeForm = new EmployeeForm();
		employeeForm.setEmployees(lOfEmployees);
		System.out.println(lOfEmployees.size());
		
		return new ModelAndView("employee", "employeeForm", employeeForm);
	//	model.put("lOfEmployees",  lOfEmployees);
	//	return "employee";
		
	}
	
	@RequestMapping(value = "/employeelist")
	public String getEmployees(Map<String, Object> model) {
		
		LoadEmployeeData loadEmployeeData = new LoadEmployeeData();
		List<Employee> lOfEmployees = new ArrayList<Employee>();
		
		LoadCharityData loadCharityData = new LoadCharityData();
		List<Charity> lOfCharities = new ArrayList<Charity>();
		
		try {
			lOfEmployees = loadEmployeeData.readFile("src/test/resources/employee.csv");
			lOfCharities = loadCharityData.readFile("src/test/resources/charity.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.put("lOfEmployees",  lOfEmployees);
		model.put("lOfCharities",  lOfCharities);
		return "employeelist";
		
	}
	
	@RequestMapping(value = "/charitylist")
	public String getCharities(Map<String, Object> model) {

		LoadCharityData loadCharityData = new LoadCharityData();
		List<Charity> lOfCharities = new ArrayList<Charity>();
		
		try {
			lOfCharities = loadCharityData.readFile("src/test/resources/charity.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.put("lOfCharities",  lOfCharities);
		return "charitylist";
		
	}
}
