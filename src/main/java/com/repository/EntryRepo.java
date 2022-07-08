package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Entry;

@Repository
public interface EntryRepo extends JpaRepository<Entry, Integer> {

}
