package com.bank;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BankController {
	
	/*
	 * 
	 * REST - Representational State transfer 
	 * Client - Server architecture
	 * 
	 * CRUD - Create Read Update Delete
	 * 
	 * User - Account 
	 * 
	 * HTTP 
	 * 
	 * GET - Read
	 * POST- Create
	 * PUT - Update
	 * DELETE - Delete
	 * 
	 * https://spring.io/guides/gs/rest-service/
	 * */
	
	@GetMapping
	public String getUser() {// Welcome page, non-rest
		return "Get user executed";
	}
	
	@PostMapping
	public String createAccount(){
		return "Post account executed";
	}
	
	@PutMapping
	public String updateAccount(){
		return "Update account Executed";
	}
	
	@DeleteMapping
	public String deleteAccount(){
		return "Delete account executed";
	}
}
