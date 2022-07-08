package com.service;

import com.model.Proyect;
import com.model.User;

public interface ProyectService {

	public Proyect saveProyect(User user, String description);

	public Proyect findProyectById(int id);

}
