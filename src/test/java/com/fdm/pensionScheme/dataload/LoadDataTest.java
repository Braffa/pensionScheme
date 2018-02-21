package com.fdm.pensionScheme.dataload;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

import com.fdm.pensionScheme.beans.Employee;

public class LoadDataTest {
	
	LoadData loadData = new LoadData();

	@Test
	public void loadDataTest1() {

		try {
			List<Employee> lOfEmployees = loadData.readFile("src/test/resources/employee.csv");
			for (Employee employee : lOfEmployees) {
				System.out.println(employee.toString());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
