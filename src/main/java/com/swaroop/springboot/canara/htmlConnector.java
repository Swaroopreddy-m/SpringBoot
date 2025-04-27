package com.swaroop.springboot.canara;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class htmlConnector {
	
        @GetMapping("/canara")
	    public String start() { 
	 return "DynamicBuilder";
	    }
        
        @PostMapping("/passwordchange")
public String change() { 
	 return "DynamicBuilder";
}
}
