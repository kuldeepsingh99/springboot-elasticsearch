package com.portal.auto.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.portal.auto.bean.Contacts;
import com.portal.auto.service.ContactService;

@Controller
@RequestMapping("user")
public class CustomerController {

	@Autowired
	public ContactService contactService;
	
	
	@RequestMapping(path = "/savecontact", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody Contacts saveContact(@RequestBody Contacts contact) {
		Contacts con = contactService.save(contact);
		return con;
	}
	
	@RequestMapping(path = "/deletecontact", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody void deletecontact(@RequestBody Contacts contact) {
		contactService.delete(contact);
	}
	
	@RequestMapping(path = "/findContact", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody Contacts findContact(@RequestBody Contacts contact) {
		Contacts con= contactService.findOne(contact.getId());
		return con;
	}
	
	@RequestMapping(path = "/findAllContact", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Contacts> findAllContact() {
		Iterable<Contacts> con = contactService.findAll();
		List<Contacts> list = new ArrayList<Contacts>();
		
		Iterator<Contacts> it = con.iterator();
		while(it.hasNext()){
			Contacts tmp = it.next();
			list.add(tmp);
		}
		return list;
	}
	
	@RequestMapping(path = "/findByEmail", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Contacts> findByEmail(@RequestBody Contacts contact) {
		List<Contacts> con = contactService.findByTitle(contact.getEmail());
		return con;
	}
}
