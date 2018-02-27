package com.fdm.pensionScheme.controller;


import static org.assertj.core.api.Assertions.assertThat;
/*
 * https://dzone.com/articles/testing-spring-mvc-with-spring-boot-14-part-1
 */
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fdm.pensionScheme.beans.Charity;
import com.fdm.pensionScheme.beans.Employee;

@RunWith(SpringRunner.class)

@WebMvcTest(controllers = EmployeeController.class)
public class EmployeeControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void employeeByIdTest() throws Exception {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dob = LocalDate.parse("08/10/1967", formatter);
		LocalDate startDate = LocalDate.parse("12/09/2017", formatter);
		HashSet<Charity> charities = new HashSet<Charity>(); 

		MvcResult result = mockMvc.perform(get("/employeeById")).andExpect(status().isOk())
				.andExpect(view().name("employee"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("EmployeeByIdForm"))
				.andExpect(model().attribute("EmployeeByIdForm", hasProperty("firstName", is("Teddy"))))
				.andExpect(model().attribute("EmployeeByIdForm", hasProperty("lastName", is("Sheringham"))))
				.andExpect(model().attribute("EmployeeByIdForm", hasProperty("niNumber", is("BB372909G"))))
				.andExpect(model().attribute("EmployeeByIdForm", hasProperty("dateOfBirth", is(dob))))
				.andExpect(model().attribute("EmployeeByIdForm", hasProperty("employmentStartDate", is(startDate))))
				.andExpect(model().attribute("EmployeeByIdForm", hasProperty("salary", is(35000.0))))
				.andExpect(model().attribute("EmployeeByIdForm", hasProperty("employeeContribution", is(3.0))))
				.andExpect(model().attribute("EmployeeByIdForm", hasProperty("employerContribution", is(9.0))))
				.andExpect(model().attribute("EmployeeByIdForm", hasProperty("charities", is(charities))))
				.andReturn();
		
        MockHttpServletResponse mockResponse=result.getResponse();

        //assertThat(mockResponse.getContentType()).isEqualTo("text/html;charset=UTF-8");
        
        Collection<String> responseHeaders = mockResponse.getHeaderNames();

       // assertNotNull(responseHeaders);
       // assertEquals(1, responseHeaders.size());
       // assertEquals("Check for Content-Type header", "Content-Type", responseHeaders.iterator().next());

	}

	@Test
	public void employeelistTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/employee")).andExpect(status().isOk())
				// .andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(view().name("employee")).andExpect(MockMvcResultMatchers.view().name("employee"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("employeeForm"))
				.andExpect(model().attribute("employeeForm", hasProperty("employees", is(new ArrayList<Employee>()))))
				.andExpect(content().string(Matchers.containsString("")))
				.andDo(print());

	}
}
