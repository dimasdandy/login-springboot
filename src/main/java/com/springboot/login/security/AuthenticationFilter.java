package com.springboot.login.security;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.login.dto.login.LoginReqDto;
import com.springboot.login.dto.login.LoginResDto;
import com.springboot.login.dto.login.LoginResDtoData;
import com.springboot.login.model.Users;
import com.springboot.login.service.UserService;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
	private ObjectMapper objectMapper;
	private UserService userService;
	private JwtBuilderComponent jwtBuilderComponent;

	public AuthenticationFilter(AuthenticationManager authenticationManager, ObjectMapper objectMapper,
			UserService usersService, JwtBuilderComponent jwtBuilderComponent) {
		super.setFilterProcessesUrl("/api/login");
		this.authenticationManager = authenticationManager;
		this.userService = usersService;
		this.objectMapper = objectMapper;
		this.jwtBuilderComponent = jwtBuilderComponent;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		Users user = new Users();
		LoginReqDto loginReqDto = new LoginReqDto();

		try {
			loginReqDto = objectMapper.readValue(request.getInputStream(), LoginReqDto.class);
			user.setUsername(loginReqDto.getUsername());
			user.setPassword(loginReqDto.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		response.setContentType("application/json");
		LoginResDto res = new LoginResDto();

		try {
			Users user = userService.getByUsername(authResult.getName());
			HashMap<String, Object> mapUser = new HashMap<>();
			mapUser.put("id", user.getId());
			String token = jwtBuilderComponent.generateToken(mapUser, Duration.ofHours(1), null);

			LoginResDtoData resData = new LoginResDtoData();
			resData.setToken(token);
			res.setData(resData);
			res.setMsg("Login success!");

		} catch (Exception e) {
			res.setMsg(e.getMessage());
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			e.printStackTrace();
		}
		response.getWriter().append(objectMapper.writeValueAsString(res));
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		LoginResDto res = new LoginResDto();
		res.setMsg("Wrong username or password!");
		response.setContentType("application/json");
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.getWriter().append(objectMapper.writeValueAsString(res));
	}
}
