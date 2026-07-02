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
import com.msedcl.mvc.main.entity.CONSUMER_FROM_VW;
import com.msedcl.mvc.main.repository.ConsumerlistFromVW;
import com.msedcl.mvc.main.service.AllStatusCodesServiceImpl;
import com.msedcl.mvc.main.service.ConsumerlistService;

@Controller
public class UIActionController {
	
	private final AllStatusCodesServiceImpl allStatuscodesImpl;
	private final ConsumerlistService consumerlistFromVWImpl;


	UIActionController(AllStatusCodesServiceImpl allStatuscodesImpl,ConsumerlistService consumerlistFromVWImpl) {
		this.allStatuscodesImpl = allStatuscodesImpl;
		this.consumerlistFromVWImpl =consumerlistFromVWImpl;
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
     //   List<CONSUMER_FROM_VW> lst =consumerlistFromVWImpl.getAllConsList();
        List<CONSUMER_FROM_VW> lst =consumerlistFromVWImpl.getAllConsListByWfAction(statusCode);
        
  	  model.addAttribute("statusList", allStatuscodesImpl.getAllStausCodes()); // DB call
      model.addAttribute("recordCount", lst.size());

        model.addAttribute("records", lst);

        
        return "conslist";
    }

}
