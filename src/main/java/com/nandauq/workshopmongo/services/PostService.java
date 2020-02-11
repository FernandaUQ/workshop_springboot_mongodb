package com.nandauq.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nandauq.workshopmongo.domain.Post;
import com.nandauq.workshopmongo.repository.PostRepository;
import com.nandauq.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired // instancia automaticamente
	private PostRepository repo;
	
	
	public Post findById (String id) {
		Optional<Post> post = repo.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle (String text){
		return repo.searchTitle(text);
	}
}
	