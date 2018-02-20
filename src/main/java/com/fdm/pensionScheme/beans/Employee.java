package com.fdm.pensionScheme.beans;

import java.time.LocalDate;

public class Employee {

	String firstName;
	String lastName;
	String niNumber;
	LocalDate dateOfBirth;
	LocalDate employmentStartDate;
	double salary;
	double employeeContribution;
	double employerContribution;

	public Employee(String firstName, String lastName, String niNumber, LocalDate dateOfBirth,
			LocalDate employmentStartDate, double salary, double employeeContribution, double employerContribution) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.niNumber = niNumber;
		this.dateOfBirth = dateOfBirth;
		this.employmentStartDate = employmentStartDate;
		this.salary = salary;
		this.employeeContribution = employeeContribution;
		this.employerContribution = employerContribution;
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

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", niNumber=" + niNumber
				+ ", dateOfBirth=" + dateOfBirth + ", employmentStartDate=" + employmentStartDate + ", salary=" + salary
				+ ", employeeContribution=" + employeeContribution + ", employerContribution=" + employerContribution
				+ "]";
	}

}