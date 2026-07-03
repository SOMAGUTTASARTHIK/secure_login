package com.atlas.securelogin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.atlas.securelogin.service.SecureService;
import com.atlas.securelogin.service.dto.LoginRequestDto;
import com.atlas.securelogin.service.dto.SecureRequestDto;
import com.atlas.securelogin.service.dto.SecureResponseDto;

@RestController
@RequestMapping("/api/auth")
public class SecureController {

	private final SecureService secureService;

	public SecureController(SecureService secureService) {
		this.secureService = secureService;
	}

	@PostMapping("/register")
	public ResponseEntity<SecureResponseDto> register(@RequestBody SecureRequestDto requestDto) {
		SecureResponseDto response = secureService.register(requestDto);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/login")
	public ResponseEntity<SecureResponseDto> login(@RequestBody LoginRequestDto loginRequest) {
		SecureResponseDto response = secureService.login(loginRequest.getEmailId(), loginRequest.getPassword());
		return ResponseEntity.ok(response);
	}
}
