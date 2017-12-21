package com.portal.auto.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.portal.auto.bean.Contacts;

public interface ContactRepository extends ElasticsearchRepository <Contacts, String>{

	Page<Contacts> findByName(String author, Pageable pageable);

    List<Contacts> findByEmail(String title);
}
