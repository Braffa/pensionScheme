package com.fdm.pensionScheme.dataload;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fdm.pensionScheme.beans.Charity;
import com.fdm.pensionScheme.beans.Employee;

public class LoadCharityData {

	public List<Charity>  readFile(String filePath) throws FileNotFoundException {
		List<Charity> lOfCharities = new ArrayList<Charity>();
		Scanner in = new Scanner(new FileReader(filePath));
		while (in.hasNextLine()) {
			String line = in.nextLine().trim();
			String[] charityDetails = parseLine(line);
			Charity charity = createCharity(charityDetails);
			lOfCharities.add(charity);
		}
		in.close();
		return lOfCharities;
	}

	private String[] parseLine(String line) {
		String[] fields = new String[2];
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

	private Charity createCharity(String[] charityDetails) {
		String charityName = charityDetails[0];
		int charityId = Integer.parseInt(charityDetails[1]);
		return new Charity(charityId, charityName);
	}
}
