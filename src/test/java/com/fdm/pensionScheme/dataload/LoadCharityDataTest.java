package com.fdm.pensionScheme.dataload;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fdm.pensionScheme.beans.Charity;

public class LoadCharityDataTest {
	
	LoadCharityData loadData = new LoadCharityData();

	@Test
	public void loadDataTest1() {
		List<Charity> lOfCharities = new ArrayList<Charity>();
		try {
			lOfCharities = loadData.readFile("src/test/resources/charity.csv");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals("Should be 10 Charities", 10, lOfCharities.size());
		Charity charity = lOfCharities.get(0);
		
		assertEquals("", 2000, charity.getCharityId());
		assertEquals("", "RSPCA", charity.getCharityName());
	}

}
