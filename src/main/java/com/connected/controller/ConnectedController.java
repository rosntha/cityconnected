package com.connected.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.connected.service.ConnectedService;

@RestController
public class ConnectedController {
	@Autowired
	private ConnectedService connectedService;
	
	@GetMapping("/connected")
	public String isConnected(@RequestParam String origin, @RequestParam String destination) {
		return connectedService.isConnected(origin,destination);
	}
	
	
}
