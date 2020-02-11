package com.nandauq.workshopmongo.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nandauq.workshopmongo.domain.Post;
import com.nandauq.workshopmongo.resources.util.URL;
import com.nandauq.workshopmongo.services.PostService;

@RestController         //indicando que é rest
@RequestMapping (value = "/posts")   // caminho   
public class PostResource {
	
	@Autowired
	private PostService service;

	@RequestMapping (value = "/{id}", method=RequestMethod.GET) //ou getmmaping
	public ResponseEntity <Post> findById (@PathVariable String id){	
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping (value = "/titlesearch", method=RequestMethod.GET) //ou getmmaping
	public ResponseEntity <List<Post>> findByTitle (@RequestParam(value="text", defaultValue = "") String text){
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
}
 