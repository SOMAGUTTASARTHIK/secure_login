package com.atlas.securelogin.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atlas.securelogin.exception.BadRequestException;
import com.atlas.securelogin.repository.entity.SecureEntity;
import com.atlas.securelogin.repository.entity.SecureEntityRepository;
import com.atlas.securelogin.service.SecureService;
import com.atlas.securelogin.service.dto.SecureRequestDto;
import com.atlas.securelogin.service.dto.SecureResponseDto;
import com.atlas.securelogin.service.mapper.SecureMapper;

@Service

public class SecureServiceImpl implements SecureService {

	private final SecureEntityRepository secureEntityRepository;
	private final SecureMapper secureMapper;

	@Autowired
	public SecureServiceImpl(SecureEntityRepository secureEntityRepository, SecureMapper secureMapper) {
		this.secureEntityRepository = secureEntityRepository;
		this.secureMapper = secureMapper;
	}

	@Override
	public SecureResponseDto login(String emailId, String password) {
		Optional<SecureEntity> entityOpt = secureEntityRepository.findByEmailId(emailId);
		return entityOpt.map(secureMapper::toDto).orElseThrow(() -> new RuntimeException("Invalid credentials"));
	}

	@Override
	public SecureResponseDto register(SecureRequestDto secureRequestDto) {

		if (secureEntityRepository.findByEmailId(secureRequestDto.getEmailId()).isPresent()) {
			throw new BadRequestException("Email already registered");
		}
		SecureEntity entity = secureMapper.toEntity(secureRequestDto);
		SecureEntity savedEntity = secureEntityRepository.save(entity);
		return secureMapper.toDto(savedEntity);
	}
}
