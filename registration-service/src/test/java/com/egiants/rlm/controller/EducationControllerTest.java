package com.egiants.rlm.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.Console;
import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.egiants.rlm.RegistrationServiceApplication;
import com.egiants.rlm.entity.Education;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { RegistrationServiceApplication.class, })
@AutoConfigureMockMvc
@ActiveProfiles("test")

public class EducationControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnUsers() throws Exception {
		this.mockMvc.perform(get("/education")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].emailId", is("user@gmail.com")));

	}
	// @Test
	// public void shouldDeleteUser() throws Exception {
	// this.mockMvc.perform(delete("/users/user/hakhil@gmail.com")).andDo(print()).andExpect(status().isOk())
	// .andExpect(content()
	// .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	// .andExpect(content().string(containsString("true")));;
	//
	//
	// }
	// @Test
	// public void testAddUser() throws Exception {
	//
	// this.mockMvc.perform(post("/users/user/save")
	// .contentType(MediaType.APPLICATION_JSON)
	// .param("emailAddress", "akhil123@gmail.com")
	// .param("firstName", "akhil")
	// .param("lastName", "beerelli")
	// .param("password", "akhil")
	// .param("phonenumber","1234567"))
	// .andDo(print())
	// .andExpect(status().isOk());
	//
	//
	// }
	//

}