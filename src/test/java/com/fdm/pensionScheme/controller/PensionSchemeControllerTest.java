package com.fdm.pensionScheme.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import com.fdm.pensionScheme.PensionSchemeApplication;

@RunWith(SpringRunner.class)
// @SpringBootTest(classes = Application.class)
@SpringBootTest(classes = PensionSchemeApplication.class)
@WebAppConfiguration
public class PensionSchemeControllerTest {
	
	 private MediaType contentType = new MediaType("application", "json", Charset.forName("UTF-8"));;

	private MockMvc mockMvc;

	private HttpMessageConverter mappingJackson2HttpMessageConverter;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private PensionSchemeController pensionSchemeController;

	@Autowired
	void setConverters(HttpMessageConverter<?>[] converters) {

		this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
				.filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().orElse(null);

		assertNotNull("the JSON message converter must not be null", this.mappingJackson2HttpMessageConverter);
	}

	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

	}

	@Test
	public void readBookmarks() throws Exception {
		mockMvc.perform(get("/pensionscheme")).andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$.[0].firstName", is("John")))
				.andExpect(jsonPath("$.[0].lastName", is("Cena")))
				.andExpect(jsonPath("$.[0].niNumber", is("JZ486469B")))
				.andExpect(jsonPath("$.[0].dateOfBirth.year", is(1993)))
				.andExpect(jsonPath("$.[0].dateOfBirth.monthValue", is(9)))
				.andExpect(jsonPath("$.[0].dateOfBirth.dayOfMonth", is(12)))
				.andExpect(jsonPath("$.[0].employmentStartDate.year", is(2018)))
				.andExpect(jsonPath("$.[0].employmentStartDate.monthValue", is(3)))
				.andExpect(jsonPath("$.[0].employmentStartDate.dayOfMonth", is(20)))
				.andExpect(jsonPath("$.[0].salary", is(24000.0)))
				.andExpect(jsonPath("$.[0].employeeContribution", is(5.0)))
				.andExpect(jsonPath("$.[0].employerContribution", is(8.0)))
				.andDo(print());
		
		//John, Cena, JZ486469B, 12/09/1993, 20/03/2018, 24000, 5, 8
	}
}
