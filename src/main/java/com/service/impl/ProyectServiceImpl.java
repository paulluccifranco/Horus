package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Proyect;
import com.model.User;
import com.repository.ProyectRepo;
import com.service.ProyectService;

@Service
@Transactional
public class ProyectServiceImpl implements ProyectService {

	@Autowired
	private ProyectRepo proyectRepo;

	@Override
	public Proyect saveProyect(User user, String description) {
		Proyect proyect = new Proyect();
		proyect.setDescription(description);
		proyect.setUser(user);
		return proyectRepo.save(proyect);
	}

	@Override
	public Proyect findProyectById(int id) {
		return proyectRepo.findById(id).orElse(null);
	}

}
