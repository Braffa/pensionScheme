package com.fdm.pensionScheme.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdm.pensionScheme.beans.Employee;
import com.fdm.pensionScheme.dataload.LoadData;

@Controller
public class EmployeeController {
	
	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hey Dave you got it to work";
	
	@RequestMapping(value = "/employee")
	public String welcome(Map<String, Object> model) {
		System.out.println("Got here");
		LoadData loadData = new LoadData();
		List<Employee> lOfEmployees = new ArrayList<Employee>();
		
		try {
			lOfEmployees = loadData.readFile("/Users/dave/Downloads/pensionScheme/src/test/resources/employee.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.put("message", this.message);
		model.put("lOfEmployees",  lOfEmployees);
		return "employee";
		
	}

/*	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}*/
}
