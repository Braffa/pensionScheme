package com.fdm.pensionScheme.form;

import java.util.ArrayList;
import java.util.List;

import com.fdm.pensionScheme.beans.*;

public class EmployeeForm {

	
	List<Employee> employees = new ArrayList<Employee>();

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
}
