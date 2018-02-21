package com.fdm.pensionScheme.beans;

public class Charity {

	String charityName;
	String charityId;

	public Charity(String charityName, String charityId) {
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

	public String getCharityId() {
		return charityId;
	}

	public void setCharityId(String charityId) {
		this.charityId = charityId;
	}

	@Override
	public String toString() {
		return "Charity [charityName=" + charityName + ", charityId=" + charityId + "]";
	}

}
