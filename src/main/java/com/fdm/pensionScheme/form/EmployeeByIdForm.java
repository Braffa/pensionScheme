package com.fdm.pensionScheme.form;

import java.time.LocalDate;
import java.util.HashSet;

import com.fdm.pensionScheme.beans.Charity;

public class EmployeeByIdForm {

	String firstName;
	String lastName;
	String niNumber;
	LocalDate dateOfBirth;
	LocalDate employmentStartDate;
	double salary;
	double employeeContribution;
	double employerContribution;
	
	HashSet<Charity> charities; 
	
	public EmployeeByIdForm () {
		
	}

	public EmployeeByIdForm(String firstName, String lastName, String niNumber, LocalDate dateOfBirth,
			LocalDate employmentStartDate, double salary, double employeeContribution, double employerContribution,
			HashSet<Charity> charities) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.niNumber = niNumber;
		this.dateOfBirth = dateOfBirth;
		this.employmentStartDate = employmentStartDate;
		this.salary = salary;
		this.employeeContribution = employeeContribution;
		this.employerContribution = employerContribution;
		this.charities = charities;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNiNumber() {
		return niNumber;
	}

	public void setNiNumber(String niNumber) {
		this.niNumber = niNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getEmploymentStartDate() {
		return employmentStartDate;
	}

	public void setEmploymentStartDate(LocalDate employmentStartDate) {
		this.employmentStartDate = employmentStartDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getEmployeeContribution() {
		return employeeContribution;
	}

	public void setEmployeeContribution(double employeeContribution) {
		this.employeeContribution = employeeContribution;
	}

	public double getEmployerContribution() {
		return employerContribution;
	}

	public void setEmployerContribution(double employerContribution) {
		this.employerContribution = employerContribution;
	}

	public HashSet<Charity> getCharities() {
		return charities;
	}

	public void setCharities(HashSet<Charity> charities) {
		this.charities = charities;
	}

	
	
}
