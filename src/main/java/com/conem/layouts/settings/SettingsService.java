package com.conem.layouts.settings;

import org.springframework.stereotype.Service;

import com.conem.layouts.config.WebMvcConfig;

@Service
public class SettingsService {

	private WebMvcConfig properties;

	public SettingsService(WebMvcConfig properties) {
		super();
		this.properties = properties;
	}
	
	
	public void  setDashboardDays(int dashBoardDaysShow) {
		properties.setDashBoardDaysShow(dashBoardDaysShow);
	}
	
	public int getDashboardDays() {
		return properties.getDashBoardDaysShow();
	}
	
}
