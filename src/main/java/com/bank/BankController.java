package com.bank;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {
	 @RequestMapping("/")
	    public String welcome() {//Welcome page, non-rest
	        return "Hello World";
	    }
}
