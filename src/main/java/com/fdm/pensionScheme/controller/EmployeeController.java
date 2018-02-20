package com.fdm.pensionScheme.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdm.pensionScheme.beans.Employee;
import com.fdm.pensionScheme.dataload.LoadData;

@Controller
public class EmployeeController {
	
	@RequestMapping(value = "/employee")
	public String getEmployee(Model model) {
		System.out.println("Got here");
		LoadData loadData = new LoadData();
		List<Employee> lOfEmployees = new ArrayList<Employee>();
		
		try {
			lOfEmployees = loadData.readFile("/Users/dave/Downloads/pensionScheme/src/test/resources/employee.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAllAttributes(lOfEmployees );
		return "employee";
		
	}

}
