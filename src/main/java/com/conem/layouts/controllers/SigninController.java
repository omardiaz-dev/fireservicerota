package com.conem.layouts.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SigninController {

	@GetMapping("signin")
	@RequestMapping(value = "signin")
	public String signin() {
		System.out.println("signin");
        return "signin/signin";
    }
	

}
