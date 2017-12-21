package com.portal.auto.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.portal.auto.bean.Contacts;

public interface ContactService {

	Contacts save(Contacts contact);

    void delete(Contacts contact);

    Contacts findOne(String id);

    Iterable<Contacts> findAll();

    Page<Contacts> findByAuthor(String author, PageRequest pageRequest);

    List<Contacts> findByTitle(String title);
}
