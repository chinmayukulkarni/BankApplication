package com.bank;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String getUser(@RequestParam (value ="name") String userName, @RequestParam (value="dob") String dob,@RequestParam (value="address") String address,@RequestParam(value="adhar") String adhar) {// Welcome page, non-rest
		
		
		String accountNumner = createAccount(userName, accountNumber);
		if(!accountNumber.equalsIgnoreCase("kulkarni"))
			throw new RuntimeException("You are not Kulkarni");
		return "Get user executed, with user: "+ userName+" "+accountNumber;
	}
	
	private String createAccount(String userName, String lastName) {
		// TODO Auto-generated method stub
		return null;
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
