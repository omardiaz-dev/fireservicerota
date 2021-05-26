package com.conem.layouts.company.branch.truck;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.conem.layouts.Application;
import com.conem.layouts.account.AccountService;

@Controller
public class TruckController {
	
	TruckService truckService;
	
	TruckController(TruckService truckService){
		this.truckService = truckService;
	}

	@GetMapping(value = "dashboardResume")
	public String dashboardResumeList(Model model,@RequestParam(defaultValue = "") String date, @RequestParam(defaultValue = "") String action) {
	
		if (Application.ACTION_CANCEL.equals(action)) {
			return "redirect:/"+".";
		}
		
		if (AccountService.isAdmin()){
    		model.addAttribute("admin", "TRUE");
    	}else {
    		model.addAttribute("admin", "FALSE");
    	}
		
		List<List<HourAvailability>> week = truckService.getInformationWeek(date);
		
		model.addAttribute("hourAvailability", week);
		model.addAttribute("messageTask", "Details of truck availability for the given date ");
		model.addAttribute("hourAvailabilitys", week);
		model.addAttribute("week", week);
		model.addAttribute("dashBoardHeader",truckService.getHTMLTableHeader());
		return "dashboardResume/dashboardResume";
	}
}
