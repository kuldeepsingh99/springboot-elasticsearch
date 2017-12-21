package com.portal.auto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.portal.auto.bean.Contacts;
import com.portal.auto.dao.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	public Contacts save(Contacts contact) {
		return contactRepository.save(contact);
	}

	public void delete(Contacts contact) {
		contactRepository.delete(contact);
	}

	public Contacts findOne(String id) {
		return contactRepository.findOne(id);
	}

	public Iterable<Contacts> findAll() {
		return contactRepository.findAll();
	}

	public Page<Contacts> findByAuthor(String author, PageRequest pageRequest) {
		return contactRepository.findByName(author, pageRequest);
	}

	public List<Contacts> findByTitle(String title) {
		return contactRepository.findByEmail(title);
	}

}
