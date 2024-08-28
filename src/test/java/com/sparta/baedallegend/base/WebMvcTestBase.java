package com.sparta.baedallegend.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.baedallegend.auth.controller.AuthController;
import com.sparta.baedallegend.global.config.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = {
	AuthController.class
})
@Import(SecurityConfig.class)
@AutoConfigureMockMvc
public abstract class WebMvcTestBase extends TestBase {

	@Autowired
	protected MockMvc mockMvc;

	@Autowired
	protected ObjectMapper objectMapper;

}