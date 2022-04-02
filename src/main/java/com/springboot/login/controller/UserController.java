package com.springboot.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.login.model.Users;
import com.springboot.login.service.UserService;

@RestController
@RequestMapping(value = "api/")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value = "users")
	public ResponseEntity<?> getAllUser() {
		try {
			return ResponseEntity.ok(userService.getAllUsers());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping(value = "user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") String id) {
		try {
			return ResponseEntity.ok(userService.getById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PostMapping(value = "user")
	public ResponseEntity<?> add(@RequestBody Users user) throws Exception {
		try {
			userService.addUser(user);
			return ResponseEntity.ok("user has been added.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping(value = "user")
	public ResponseEntity<?> update(@RequestBody Users user) throws Exception {
		try {
			userService.updateUser(user);
			return ResponseEntity.ok("user has been updated.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping(value = "user/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		try {
			userService.deleteUser(id);
			return ResponseEntity.ok("user has been deleted.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
}
