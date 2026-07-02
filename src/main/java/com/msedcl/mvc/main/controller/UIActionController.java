package com.msedcl.mvc.main.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.msedcl.mvc.main.dto.*;
import com.msedcl.mvc.main.service.AllStatusCodesServiceImpl;

@Controller
public class UIActionController {
	
	private final AllStatusCodesServiceImpl allStatuscodesImpl;

	UIActionController(AllStatusCodesServiceImpl allStatuscodesImpl) {
		this.allStatuscodesImpl = allStatuscodesImpl;
	}
	@SuppressWarnings("static-access")
	@GetMapping("/search")
	public String showSearchPage(Model model) {
		
		  
		
	   // model.addAttribute("searchCriteria", new SearchDTO());
	  model.addAttribute("statusList", allStatuscodesImpl.getAllStausCodes()); // DB call
	//	  model.addAttribute("statusList", statusList); // DB call
		  return "conslist";
	}
	
	 // Form submit zala ki POST
    @PostMapping("/search")
    public String handleSearch(@RequestParam("statusCode") String statusCode, 
                               Model model) {
        
        System.out.println("Selected Status Codexx: " + statusCode); // 122, 135, etc yeil
        return "/";
    }

}
