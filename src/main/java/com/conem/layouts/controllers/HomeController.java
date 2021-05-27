package com.conem.layouts.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.conem.layouts.account.AccountService;
import com.conem.layouts.settings.SettingsService;

import java.security.Principal;

@Controller
class HomeController {

	
	SettingsService settingsService;
	
    public HomeController(SettingsService settingsService) {
		super();
		this.settingsService = settingsService;
	}

	@ModelAttribute("module")
    String module() {
        return "home";
    }

    @GetMapping("/")
    String index(Model model,Principal principal) {
    	model.addAttribute("messageOmar", "Omar Diaz");
    	
    	if (AccountService.isAdmin()){
    		model.addAttribute("admin", "TRUE");
    	}else {
    		model.addAttribute("admin", "FALSE");
    	}
    
        return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
    }
    
    
    
  
    
   
    
    
}
