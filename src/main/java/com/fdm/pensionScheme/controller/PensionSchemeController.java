package com.fdm.pensionScheme.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdm.pensionScheme.beans.Employee;
import com.fdm.pensionScheme.dataload.LoadData;

@RestController
public class PensionSchemeController {

	@GetMapping("/pensionscheme")
	public List<Employee> getAllEmpoyees() {
		LoadData loadData = new LoadData();
		List<Employee> lOfEmployees = new ArrayList<Employee>();
		
		try {
			lOfEmployees = loadData.readFile("src/test/resources/employee.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lOfEmployees;
	}
}
