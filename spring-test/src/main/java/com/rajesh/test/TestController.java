 package com.rajesh.test;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@Value("${my.greeting: Apple Greeting}")
	String greetingFromConfig;
	
	@Value("${app.description}")
	String description;
	
	@Value("Apple Greeting")
	String staticGreetingCard;
	
	@Value("${my.list.values}")
	List<String> listValues;

	@Autowired
	private DBSettings dbSettings;
	
	@GetMapping("greeting")
	public String greetPeople() {
		return description + dbSettings.getConnection() + dbSettings.getHost() + dbSettings.getPort();
	}
}
