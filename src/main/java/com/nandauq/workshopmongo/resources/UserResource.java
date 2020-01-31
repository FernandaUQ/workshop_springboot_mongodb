package com.nandauq.workshopmongo.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nandauq.workshopmongo.domain.User;
import com.nandauq.workshopmongo.services.UserService;

@RestController         //indicando que é rest
@RequestMapping (value = "/users")   // caminho   
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping (method=RequestMethod.GET) //ou getmmaping
	public ResponseEntity <List<User>> findAll (){	
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
}
 