package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Proyect;
import com.model.User;
import com.service.EntryService;
import com.service.ProyectService;
import com.service.UserService;
import com.util.JWTService;

@RestController
@RequestMapping(value = "/horus/api")
public class ProyectController {
	@Autowired
	ProyectService proyectService;
	@Autowired
	UserService userService;
	@Autowired
	EntryService entryService;
	@Autowired
	JWTService jwtService;

	@PostMapping(value = "/createProyect")
	public String createProyect(@RequestBody String description) {
		User user = userService.findUserById(1);
		Proyect proyect = proyectService.saveProyect(user, description);
		String key = jwtService.generateJWTToken(proyect.getId(), description);
		return key;

	}

}
