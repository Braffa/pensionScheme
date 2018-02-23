package com.fdm.pensionScheme.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fdm.pensionScheme.beans.Charity;
import com.fdm.pensionScheme.beans.Employee;
import com.fdm.pensionScheme.dataload.LoadCharityData;
import com.fdm.pensionScheme.dataload.LoadEmployeeData;
import com.fdm.pensionScheme.form.EmployeeForm;

@Controller
@Scope("session")
public class EmployeeController {
	
	@RequestMapping(value = "/employee")
	public ModelAndView welcome(HttpServletRequest request, Map<String, Object> model) {
		System.out.println("Got here");
		   
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
		request.getSession().setAttribute("lOfCharities", lOfCharities);
		request.getSession().setAttribute("lOfEmployees", lOfEmployees);
		
		EmployeeForm employeeForm = new EmployeeForm();
		employeeForm.setEmployees(lOfEmployees);
		
		return new ModelAndView("employee", "employeeForm", employeeForm);
		
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
