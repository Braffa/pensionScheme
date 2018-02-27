package com.fdm.pensionScheme.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@GetMapping("/mappedemployees")
	public Map<String, Employee> getMapOfEmpoyees() {
		LoadEmployeeData loadData = new LoadEmployeeData();
		Map<String, Employee> mOfEmployees = new HashMap<String, Employee>();
		
		try {
			mOfEmployees = loadData.readFileAsMap("src/test/resources/employee.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mOfEmployees;
	}
	
	@GetMapping("/mappedcharities")
	public Map<Integer, Charity>  getMapOfCharities() {
		LoadCharityData loadData = new LoadCharityData();
		Map<Integer, Charity> mOfCharities = new HashMap<Integer, Charity>();
		
		try {
			mOfCharities = loadData.readFileAsMap("src/test/resources/charity.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mOfCharities;
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
