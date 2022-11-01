package com.backend.backend.Controllers;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.Repository.TutorialRepository;
import com.backend.backend.Repository.UserRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;


import io.jsonwebtoken.lang.Arrays;

import com.backend.backend.Model.Tutorial;
import com.backend.backend.Model.User;
import com.backend.backend.Messages.*;
import com.backend.backend.Service.*;
import com.backend.backend.Helper.*;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/estudiante")
	@PreAuthorize("hasRole('ESTUDIANTE') or hasRole('CORDINADOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/cordinador")
	@PreAuthorize("hasRole('CORDINADOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@Autowired
	//private UserRepository userRepository;
	private TutorialRepository tutorialRepository;
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Tutorial>fetchUsers(){
		return tutorialRepository.findAll();
	}
	/*public List<User> fetchUsers() {
		return userRepository.findAll();
	}*/
	@Autowired
	ExcelService fileService;
	@PostMapping("/upload")
	@PreAuthorize("hasRole('ADMIN')")
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		if (ExcelHelper.hasExcelFormat(file)) {
			try {
			  fileService.save(file);
	  
			  message = "Uploaded the file successfully: " + file.getOriginalFilename();
			  System.out.println(message);
			  ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			  return message;
			  
			} catch (Exception e) {
			  message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			  System.out.println(message);
			  ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			  return message;
			  
			}
			
		  }
		  		message = "Please upload an excel file!";
				  System.out.println(message);
   			 ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
				  return message;
	}
}
