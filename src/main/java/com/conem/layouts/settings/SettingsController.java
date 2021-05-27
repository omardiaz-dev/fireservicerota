package com.conem.layouts.settings;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.conem.layouts.account.AccountService;

@Controller
public class SettingsController {
	
	SettingsService settingsService;

	public SettingsController(SettingsService settingsService) {
		super();
		this.settingsService = settingsService;
	}

	@GetMapping("/settings")
	String getSettings(Model model) {
		model.addAttribute("messageOmar", "Omar Diaz");

		if (AccountService.isAdmin()) {
			model.addAttribute("admin", "TRUE");
		} else {
			model.addAttribute("admin", "FALSE");
		}

		model.addAttribute("dashboardDays", settingsService.getDashboardDays());

		return "home/settings";
	}
	
	
	@RequestMapping(value = "settings", method = RequestMethod.POST)
	String setSettings(Model model, @RequestParam(defaultValue = "") String dashboardDays) {
		model.addAttribute("messageOmar", "Omar Diaz");

		if (AccountService.isAdmin()) {
			model.addAttribute("admin", "TRUE");
		} else {
			model.addAttribute("admin", "FALSE");
		}

		settingsService.setDashboardDays(Integer.parseInt(dashboardDays));
		model.addAttribute("dashboardDays", settingsService.getDashboardDays());

		return "home/settings";
	}
	    

}
