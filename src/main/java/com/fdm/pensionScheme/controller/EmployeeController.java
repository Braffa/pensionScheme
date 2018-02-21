package com.fdm.pensionScheme.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdm.pensionScheme.beans.Charity;
import com.fdm.pensionScheme.beans.Employee;
import com.fdm.pensionScheme.dataload.LoadCharityData;
import com.fdm.pensionScheme.dataload.LoadEmployeeData;

@Controller
public class EmployeeController {
	
	@RequestMapping(value = "/employee")
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
		return "employee";
		
	}
	@RequestMapping(value = "/charity")
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
		return "charity";
		
	}
}
