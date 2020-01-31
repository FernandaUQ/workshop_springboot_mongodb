package com.nandauq.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nandauq.workshopmongo.domain.User;

@Repository 
public interface UserRepository extends MongoRepository<User, String>{
	
}
