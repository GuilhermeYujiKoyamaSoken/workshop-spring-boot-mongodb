package com.guilhermeyuji.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.guilhermeyuji.workshopmongodb.domain.Post;
import com.guilhermeyuji.workshopmongodb.domain.User;
import com.guilhermeyuji.workshopmongodb.repository.PostRepository;
import com.guilhermeyuji.workshopmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, "Partiu viagem", sdf.parse("21/03/2022"), "Vou viajar para São Paulo. Abraços!", maria);
		Post post2 = new Post(null, "Bom dia", sdf.parse("23/03/20122"), "Acordei feliz hoje!", maria);

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post1, post2));

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
	}

}
