package com.unico.online.users.controller;

import com.unico.online.users.dto.UserDTO;
import com.unico.online.users.service.UserService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping( "/users" )
@RestController
@AllArgsConstructor
public class UsersController {
	
	UserService service;
	
	
	@GetMapping( value = "/v1" )
	public List<UserDTO> findAll() {
		return service.findAll();
	}

	@PostMapping(value = "/v1")
	public UserDTO saveUser(@RequestBody UserDTO dto){
		return service.saveUser(dto);
	}

	@PutMapping(value = "/v1")
	public UserDTO updateUser(@RequestBody UserDTO dto){
		return service.updateUser(dto);
	}

	@DeleteMapping(value = "/v1/{userId}")
	public boolean delete(@PathVariable String userId){
		return service.delete(userId);
	}
}
