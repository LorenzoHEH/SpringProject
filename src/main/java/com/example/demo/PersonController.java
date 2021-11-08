package com.example.demo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PersonController {
	private final AllPersonUseCase allPersonsUseCase;

	@GetMapping("/persons")
	public Map<String, Object> getPersons() {
		return allPersonsUseCase.getPersons();
	}
}
