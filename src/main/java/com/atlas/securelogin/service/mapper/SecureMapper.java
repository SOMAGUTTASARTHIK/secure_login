package com.atlas.securelogin.service.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.atlas.securelogin.repository.entity.SecureEntity;
import com.atlas.securelogin.service.dto.SecureRequestDto;
import com.atlas.securelogin.service.dto.SecureResponseDto;

@Component
public class SecureMapper {

	public SecureEntity toEntity(SecureRequestDto dto) {
		if (dto == null) {
			return null;
		}
		SecureEntity secureEntity = new SecureEntity();
		secureEntity.setFirstName(dto.getFirstName());
		secureEntity.setLastName(dto.getLastName());
		secureEntity.setEmailId(dto.getEmailId());
		secureEntity.setPassword(dto.getPassword());
		secureEntity.setMobileNumber(dto.getMobileNumber());
		if (dto.getDateOfBirth() != null) {
			secureEntity.setDateOfBirth(dto.getDateOfBirth());
		}

		secureEntity.setStatus("ACTIVE");
		secureEntity.setCreateAt(LocalDateTime.now());
		secureEntity.setUpdateAt(LocalDateTime.now());
		// last_login → stays NULL here, updated on login

		return secureEntity;
	}

	public SecureResponseDto toDto(SecureEntity secureEntity) {
		if (secureEntity == null) {
			return null;
		}
		SecureResponseDto secureResponseDto = new SecureResponseDto();
		secureResponseDto.setFirstName(secureEntity.getFirstName());
		secureResponseDto.setLastName(secureEntity.getLastName());
		secureResponseDto.setEmailId(secureEntity.getEmailId());
		secureResponseDto.setPassword(secureEntity.getPassword());
		secureResponseDto.setMobileNumber(secureEntity.getMobileNumber());

		if (secureEntity.getDateOfBirth() != null) {
			secureResponseDto.setDateOfBirth(secureEntity.getDateOfBirth());
		}
		return secureResponseDto;
	}
}
