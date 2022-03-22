package com.guilhermeyuji.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilhermeyuji.workshopmongodb.domain.User;
import com.guilhermeyuji.workshopmongodb.dto.UserDTO;
import com.guilhermeyuji.workshopmongodb.repository.UserRepository;
import com.guilhermeyuji.workshopmongodb.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User Insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fomDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
