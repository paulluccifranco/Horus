package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Proyect;

@Repository
public interface ProyectRepo extends JpaRepository<Proyect, Integer> {

}
