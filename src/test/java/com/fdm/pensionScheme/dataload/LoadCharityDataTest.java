package com.fdm.pensionScheme.dataload;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.fdm.pensionScheme.beans.Charity;

public class LoadCharityDataTest {
	
	LoadCharityData loadData = new LoadCharityData();

	@Test
	public void loadDataAsListTest() {
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
	
	@Test
	public void loadDataAsMapTest() {
		Map<Integer, Charity> mOfCharities = new HashMap<Integer, Charity>();
		try {
			mOfCharities = loadData.readFileAsMap("src/test/resources/charity.csv");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals("Should be 10 Charities", 10, mOfCharities.size());
		Charity charity = mOfCharities.get(2000);
		assertEquals("", 2000, charity.getCharityId());
		assertEquals("", "RSPCA", charity.getCharityName());
		
		charity = mOfCharities.get(2001);
		assertEquals("", 2001, charity.getCharityId());
		assertEquals("", "OXFAM", charity.getCharityName());
	}

}
