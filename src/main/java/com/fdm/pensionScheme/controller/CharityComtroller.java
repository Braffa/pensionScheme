package com.fdm.pensionScheme.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fdm.pensionScheme.beans.Charity;
import com.fdm.pensionScheme.dataload.LoadCharityData;
import com.fdm.pensionScheme.form.CharityForm;

@Controller
public class CharityComtroller {

	@RequestMapping(value = "/charity", method = RequestMethod.GET)
	public ModelAndView getCharities(@RequestParam String empId, Map<String, Object> model) {
		System.out.println("Got here -Charities");

		// model.put("charties", charities);
		// model.put("empId",empId);

		CharityForm charityForm = new CharityForm();

		LoadCharityData loadCharityData = new LoadCharityData();
		List<Charity> lOfCharities = new ArrayList<Charity>();
		try {
			lOfCharities = loadCharityData.readFile("src/test/resources/charity.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		charityForm.setCharities(lOfCharities);
		return new ModelAndView("charity", "charityForm", charityForm);

	}

	@RequestMapping(value = "/asignCharities", method = RequestMethod.POST, consumes = "application/json")
	public String assignCharities(@RequestBody CharityForm charityForm,

			ModelMap model) {
		System.out.println("Get here- assigning charities");
		System.out.println(charityForm);
		System.out.println(charityForm.getCharities());

		return "assigned";

	}
}
