package com.example.demo.controller;

import com.google.common.collect.ImmutableMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class HealthCheckController {

	private static final Map<String, String> status = ImmutableMap.of("status", "up");

	@GetMapping
	public ResponseEntity<Map<String, String>> root(){
		return ResponseEntity.ok(status);
	}

	@GetMapping("health")
	public ResponseEntity<Map<String, String>> health(){
		return ResponseEntity.ok(status);
	}
}
