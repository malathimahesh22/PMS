package com.pms.gatewayservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.gatewayservice.response.ListResponse;
import com.pms.gatewayservice.services.LoginService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/login")
@Api
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@GetMapping("/getResponse")
	public ListResponse<List<String>> getResponse(@RequestParam Integer testParam){
		return loginService.getResponse(testParam);
	
	}
	
	
}
