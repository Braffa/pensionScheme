package com.fdm.pensionScheme.controller;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fdm.pensionScheme.beans.Charity;
import com.fdm.pensionScheme.beans.Employee;
import com.fdm.pensionScheme.dataload.LoadCharityData;
import com.fdm.pensionScheme.dataload.LoadEmployeeData;
import com.fdm.pensionScheme.form.EmployeeByIdForm;
import com.fdm.pensionScheme.form.EmployeeForm;

@Controller
@Scope("session")
public class EmployeeController {

    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello World";
    }

	@RequestMapping(value = "/employee")
	public ModelAndView emplyeeAsMap(HttpServletRequest request, Map<String, Object> model) {
		LoadEmployeeData loadEmployeeData = new LoadEmployeeData();
		Map<String, Employee> mOfEmployees = new HashMap<String, Employee>();
		LoadCharityData loadCharityData = new LoadCharityData();
		Map<Integer, Charity> mOfCharities = new HashMap<Integer, Charity>();
		try {
			mOfEmployees = loadEmployeeData.readFileAsMap("src/test/resources/employee.csv");
			mOfCharities = loadCharityData.readFileAsMap("src/test/resources/charity.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("mOfCharities", mOfCharities);
		request.getSession().setAttribute("mOfEmployees", mOfEmployees);
		List<Employee> lOfEmployees = new ArrayList<Employee>();
		for (Map.Entry<String, Employee> entry : mOfEmployees.entrySet()) {
			lOfEmployees.add(entry.getValue());
		}
		EmployeeForm employeeForm = new EmployeeForm();
		employeeForm.setEmployees(lOfEmployees);
		return new ModelAndView("employee", "employeeForm", employeeForm);
	}

	@RequestMapping(value = "/employeelist")
	public String getEmployees(Map<String, Object> model) {
		LoadEmployeeData loadEmployeeData = new LoadEmployeeData();
		List<Employee> lOfEmployees = new ArrayList<Employee>();
		try {
			lOfEmployees = loadEmployeeData.readFile("src/test/resources/employee.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		model.put("lOfEmployees", lOfEmployees);
		return "employeelist";
	}

	@RequestMapping(value = "/charitylist")
	public String getCharities(Map<String, Object> model) {
		LoadCharityData loadCharityData = new LoadCharityData();
		List<Charity> lOfCharities = new ArrayList<Charity>();
		try {
			lOfCharities = loadCharityData.readFile("src/test/resources/charity.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		model.put("lOfCharities", lOfCharities);
		return "charitylist";
	}
	
	@RequestMapping(value = "/employeeById")
	public ModelAndView getEmplyee(HttpServletRequest request, Map<String, Object> model) {
		LoadEmployeeData loadEmployeeData = new LoadEmployeeData();
		Map<String, Employee> mOfEmployees = new HashMap<String, Employee>();
		try {
			mOfEmployees = loadEmployeeData.readFileAsMap("src/test/resources/employee.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Employee employee = mOfEmployees.get("BB372909G");
		EmployeeByIdForm employeeByIdForm = new EmployeeByIdForm();
		employeeByIdForm.setFirstName(employee.getFirstName());
		employeeByIdForm.setLastName(employee.getLastName());
		
		employeeByIdForm.setNiNumber(employee.getNiNumber());
		employeeByIdForm.setDateOfBirth(employee.getDateOfBirth());
		employeeByIdForm.setEmploymentStartDate(employee.getEmploymentStartDate());
		employeeByIdForm.setSalary(employee.getSalary());
		employeeByIdForm.setEmployeeContribution(employee.getEmployeeContribution());
		employeeByIdForm.setEmployerContribution(employee.getEmployerContribution());
		employeeByIdForm.setCharities(employee.getCharities());

		return new ModelAndView("employee", "EmployeeByIdForm", employeeByIdForm);
	}
}
