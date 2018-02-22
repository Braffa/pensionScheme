package com.fdm.pensionScheme.form;

import java.util.ArrayList;
import java.util.List;

import com.fdm.pensionScheme.beans.Charity;

public class CharityForm {

	
	List<Charity> charities = new ArrayList<>();
	
	String empId;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public List<Charity> getCharities() {
		return charities;
	}

	public void setCharities(List<Charity> charities) {
		this.charities = charities;
	}
	
}
