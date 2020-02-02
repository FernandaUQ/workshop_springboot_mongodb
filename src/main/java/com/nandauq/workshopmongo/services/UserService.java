package com.nandauq.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nandauq.workshopmongo.domain.User;
import com.nandauq.workshopmongo.repository.UserRepository;
import com.nandauq.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired // instancia automaticamente
	private UserRepository repo;
	
	public List <User> findAll(){
		return repo.findAll();
		
	}
	
	public User findById (String id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	
}
