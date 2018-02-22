package com.fdm.pensionScheme.form;

import java.util.ArrayList;
import java.util.List;

import com.fdm.pensionScheme.beans.Charity;

public class CharityForm {

	
	List<Charity> charities = new ArrayList<>();

	public List<Charity> getCharities() {
		return charities;
	}

	public void setCharities(List<Charity> charities) {
		this.charities = charities;
	}
	
}
