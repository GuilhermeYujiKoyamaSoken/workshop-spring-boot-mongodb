package com.guilhermeyuji.workshopmongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guilhermeyuji.workshopmongodb.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria Silva", "mariasilva@gmail.com");
		User messi = new User("2", "Lionel Messi", "lionelmessi10@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, messi));
		return ResponseEntity.ok().body(list);
	}
}
