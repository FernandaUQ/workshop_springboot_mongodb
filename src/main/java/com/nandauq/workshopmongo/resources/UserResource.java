package com.nandauq.workshopmongo.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nandauq.workshopmongo.domain.Post;
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
	
	@RequestMapping (method=RequestMethod.POST)
	public ResponseEntity <Void> insert (@RequestBody UserDTO objDto){	
		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		}
	
	@RequestMapping (value = "/{id}", method=RequestMethod.DELETE) //ou getmmaping
	public ResponseEntity <Void> delete (@PathVariable String id){	
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping (value = "/{id}",method=RequestMethod.PUT)
	public ResponseEntity <Void> update (@RequestBody UserDTO objDto, @PathVariable String id){	
		User obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.Update(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.noContent().build();
		}
	
	@RequestMapping (value = "/{id}/posts", method=RequestMethod.GET) //ou getmmaping
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id){	
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getPosts());
	}
	
	
}
 