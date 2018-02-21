package com.fdm.pensionScheme.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdm.pensionScheme.beans.Charity;
import com.fdm.pensionScheme.beans.Employee;
import com.fdm.pensionScheme.dataload.LoadCharityData;
import com.fdm.pensionScheme.dataload.LoadEmployeeData;

@Controller
public class EmployeeController {
	
	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hey Dave you got it to work";
	
	@RequestMapping(value = "/employee")
	public String welcome(Map<String, Object> model) {
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
		model.put("message", this.message);
		model.put("lOfEmployees",  lOfEmployees);
		model.put("lOfCharities",  lOfCharities);
		return "employee";
		
	}

}
