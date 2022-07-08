package com.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Entry;
import com.model.Proyect;
import com.repository.EntryRepo;
import com.service.EntryService;

@Service
@Transactional
public class EntryServiceImpl implements EntryService {

	@Autowired
	EntryRepo entryRepo;

	@Override
	public Entry saveEntry(Proyect proyect, String data) {
		Entry entry = new Entry();
		entry.setData(data);
		entry.setProyect(proyect);
		entry.setDate(new Date());
		return entryRepo.save(entry);
	}

}
