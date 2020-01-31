package com.nandauq.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nandauq.workshopmongo.domain.User;
import com.nandauq.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired // instancia automaticamente
	private UserRepository repo;
	
	public List <User> findAll(){
		return repo.findAll();
		
	}
}
