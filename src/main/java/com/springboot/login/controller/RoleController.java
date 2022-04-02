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

import com.springboot.login.model.Roles;
import com.springboot.login.service.RoleService;

@RestController
@RequestMapping(value = "api/")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@GetMapping(value = "roles")
	public ResponseEntity<?> getAllRole() {
		try {
			return ResponseEntity.ok(roleService.getAllRoles());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping(value = "role/{id}")
	public ResponseEntity<?> getRoleById(@PathVariable String id) {
		try {
			return ResponseEntity.ok(roleService.getById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PostMapping(value = "role")
	public ResponseEntity<?> addRole(@RequestBody Roles role) throws Exception {
		try {
			roleService.addRole(role);
			return ResponseEntity.ok("role has been added.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping(value = "role")
	public ResponseEntity<?> updateRole(@RequestBody Roles role) throws Exception {
		try {
			roleService.updateRole(role);
			return ResponseEntity.ok("role has been updated.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping(value = "role/{id}")
	public ResponseEntity<?> deleteRoleById(@PathVariable String id) {
		try {
			roleService.deleteRole(id);
			return ResponseEntity.ok("role has been deleted.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
