package com.fdm.pensionScheme.beans;

public class Charity {

	int charityId;
	String charityName;

	public Charity(int charityId, String charityName) {
		super();
		this.charityName = charityName;
		this.charityId = charityId;
	}

	public String getCharityName() {
		return charityName;
	}

	public void setCharityName(String charityName) {
		this.charityName = charityName;
	}

	public int getCharityId() {
		return charityId;
	}

	public void setCharityId(int charityId) {
		this.charityId = charityId;
	}

	@Override
	public String toString() {
		return "Charity [charityId=" + charityId + ", charityName=" + charityName + "]";
	}



}
