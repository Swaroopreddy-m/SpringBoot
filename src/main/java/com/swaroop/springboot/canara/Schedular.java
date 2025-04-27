package com.swaroop.springboot.canara;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Schedular {
	@GetMapping("/Schedular")
	public String connector() {
		
		return "EndPage";
	}

}
