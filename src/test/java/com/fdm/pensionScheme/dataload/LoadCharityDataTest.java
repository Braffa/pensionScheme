package com.fdm.pensionScheme.dataload;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

import com.fdm.pensionScheme.beans.Charity;

public class LoadCharityDataTest {
	
	LoadCharityData loadData = new LoadCharityData();

	@Test
	public void loadDataTest1() {

		try {
			List<Charity> lOfCharities = loadData.readFile("src/test/resources/charity.csv");
			for (Charity charity : lOfCharities) {
				System.out.println(charity.toString());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
