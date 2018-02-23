package com.fdm.pensionScheme.dataload;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fdm.pensionScheme.beans.Employee;

public class LoadEmployeeDataTest {
	
	LoadEmployeeData loadData = new LoadEmployeeData();

	@Test
	public void loadDataTest1() {
		List<Employee> lOfEmployees = new ArrayList<Employee>();

		try {
			lOfEmployees = loadData.readFile("src/test/resources/employee.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals("Should be 10 Charities", 10, lOfEmployees.size());
		Employee employee = lOfEmployees.get(0);
		
		assertEquals("", "John", employee.getFirstName());
		assertEquals("", "Cena", employee.getLastName());
		assertEquals("", "JZ486469B", employee.getNiNumber());

		assertEquals("", 12, employee.getDateOfBirth().getDayOfMonth());
		assertEquals("", 9, employee.getDateOfBirth().getMonthValue());
		assertEquals("", 1993, employee.getDateOfBirth().getYear());
		
		assertEquals("", 20, employee.getEmploymentStartDate().getDayOfMonth());
		assertEquals("", 3, employee.getEmploymentStartDate().getMonthValue());
		assertEquals("", 2018, employee.getEmploymentStartDate().getYear());
		
		assertEquals("", 24000.0, employee.getSalary(), 0);
		assertEquals("", 5, employee.getEmployeeContribution(), 0);
		assertEquals("", 8, employee.getEmployerContribution(), 0);
		assertEquals("", 0, employee.getCharities().size());
	}

}
