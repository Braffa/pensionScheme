package com.fdm.pensionScheme.dataload;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fdm.pensionScheme.beans.Employee;

public class LoadData {

	public List<Employee>  readFile(String filePath) throws FileNotFoundException {
		List<Employee> lOfEmployees = new ArrayList<Employee>();
		Scanner in = new Scanner(new FileReader(filePath));
		while (in.hasNextLine()) {
			String line = in.nextLine().trim();
			String[] employeeDetails = parseLine(line);
			Employee employee = createEmployee(employeeDetails);
			lOfEmployees.add(employee);
		}
		in.close();
		return lOfEmployees;
	}

	private String[] parseLine(String line) {
		String[] fields = new String[8];
		Scanner scan = new Scanner(line).useDelimiter(",");
		int index = 0;
		try {
			while (scan.hasNext()) {
				String field = scan.next().trim();
				fields[index] = field;
				index++;
			}
		} catch (IndexOutOfBoundsException e) {
			return new String[1];
		}
		scan.close();
		return fields;
	}

	private Employee createEmployee(String[] employeeDetails) {
		String firstName = employeeDetails[0];
		String lastName = employeeDetails[1];
		String niNumber = employeeDetails[2];

		LocalDate dateOfBirth = getDate(employeeDetails[3]);
		LocalDate employmentStartDate = getDate(employeeDetails[3]);

		double salary = Double.parseDouble(employeeDetails[5]);
		double employeeContribution = Double.parseDouble(employeeDetails[6]);
		double employerContribution = Double.parseDouble(employeeDetails[7]);

		return new Employee(firstName, lastName, niNumber, dateOfBirth, employmentStartDate, salary,
				employeeContribution, employerContribution);


	}

	private LocalDate getDate(String strDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(strDate, formatter);
	}
}
