package com.nandauq.workshopmongo.resources;


import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nandauq.workshopmongo.domain.User;
import com.nandauq.workshopmongo.dto.UserDTO;
import com.nandauq.workshopmongo.services.UserService;

@RestController         //indicando que é rest
@RequestMapping (value = "/users")   // caminho   
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping (method=RequestMethod.GET) //ou getmmaping
	public ResponseEntity <List<UserDTO>> findAll (){	
		List<User> list = service.findAll();
		List <UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping (value = "/{id}", method=RequestMethod.GET) //ou getmmaping
	public ResponseEntity <UserDTO> findById (@PathVariable String id){	
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO (obj));
	}
	
	
}
 