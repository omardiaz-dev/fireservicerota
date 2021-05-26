package com.conem.layouts.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	public static String uploadDirectory=System.getProperty("user.dir")+"/uploads";
	
	@GetMapping("/upload")
	public String uploadPage(Model model) {
		return "uploadView";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(Model model, @RequestParam("files") MultipartFile[] files,@RequestParam(defaultValue = "") String company_id) {
		System.out.println(uploadDirectory);
		StringBuilder filesNames = new StringBuilder();
		for (MultipartFile file:files) {
			Path fileNameAndPath = Paths.get(uploadDirectory,file.getOriginalFilename());
			try {
				Files.write(fileNameAndPath, file.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		model.addAttribute("messageOmar","Archivos agregados: " + filesNames.toString());
		return "uploadView";
	}
}
