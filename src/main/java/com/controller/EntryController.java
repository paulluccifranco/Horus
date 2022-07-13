package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Entry;
import com.model.Proyect;
import com.service.EntryService;
import com.service.ProyectService;
import com.service.UserService;
import com.util.JWTService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RequestMapping(value = "/horus/api")
public class EntryController {

	@Autowired
	ProyectService proyectService;
	@Autowired
	UserService userService;
	@Autowired
	EntryService entryService;
	@Autowired
	JWTService jwtService;

	@GetMapping(value = "/entry/{key}")
	public ResponseEntity<List<Entry>> getEntries(@PathVariable String key) {
		int proyectId = jwtService.validateUserJWT(key);
		Proyect proyect = proyectService.findProyectById(proyectId);
		return new ResponseEntity<List<Entry>>(proyect.getEntries(), HttpStatus.OK);
	}

	@PostMapping(value = "/entry/{key}")
	public ResponseEntity<String> postEntry(@PathVariable String key, @RequestBody String entry) {
		int proyectId = jwtService.validateUserJWT(key);
		Proyect proyect = proyectService.findProyectById(proyectId);
		entryService.saveEntry(proyect, entry);
		return new ResponseEntity<String>("Entrada guardada con exito", HttpStatus.OK);
	}

}
