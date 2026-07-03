package com.atlas.securelogin.service;

import com.atlas.securelogin.service.dto.SecureRequestDto;
import com.atlas.securelogin.service.dto.SecureResponseDto;

public interface SecureService {

	SecureResponseDto login(String emailId, String password);

	SecureResponseDto register(SecureRequestDto secureRequestDto);

}
