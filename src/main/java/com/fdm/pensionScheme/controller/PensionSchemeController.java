package com.fdm.pensionScheme.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdm.pensionScheme.beans.Charity;
import com.fdm.pensionScheme.beans.Employee;
import com.fdm.pensionScheme.dataload.LoadCharityData;
import com.fdm.pensionScheme.dataload.LoadEmployeeData;

@RestController
public class PensionSchemeController {

	@GetMapping("/pensionscheme")
	public List<Employee> getAllEmpoyees() {
		LoadEmployeeData loadData = new LoadEmployeeData();
		List<Employee> lOfEmployees = new ArrayList<Employee>();
		
		try {
			lOfEmployees = loadData.readFile("src/test/resources/employee.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lOfEmployees;
	}
	
	@GetMapping("/charities")
	public List<Charity> getAllCharities() {
		LoadCharityData loadData = new LoadCharityData();
		List<Charity> lOfCharities = new ArrayList<Charity>();
		
		try {
			lOfCharities = loadData.readFile("src/test/resources/charity.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lOfCharities;
	}
}
