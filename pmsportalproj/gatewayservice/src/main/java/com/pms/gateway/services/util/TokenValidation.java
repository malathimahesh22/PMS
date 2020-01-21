package com.pms.gateway.services.util;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.gateway.api.exception.BadDataExceptionHandler;
import com.pms.gateway.services.model.TokenDetail;
import com.pms.gateway.services.repo.TokenRepo;

@Service
public class TokenValidation {

	@Autowired
	private TokenRepo tokenRepo;

	/**
	 * A Function to Validate token information with header and expire time limit.
	 * 
	 * 
	 * @param header as Bearer in JSON input type
	 */

	public Integer validateToken(String header) {
		TokenDetail token = tokenRepo.findByToken(header);
		if (token == null)
			return null;
		if (null == token.getIsRemember() || 0 == token.getIsRemember()) {
			if (LocalDateTime.now().isAfter(token.getTokenExpiryTime())) {
				tokenRepo.delete(token);
				return null;
			}
			LocalDateTime tokenExtendTime = token.getTokenExpiryTime().minusMinutes(5);
			if (tokenExtendTime.isBefore(LocalDateTime.now())) {
				token.setTokenExpiryTime(LocalDateTime.now().plusMinutes(15));
				tokenRepo.save(token);
			}
		}
		return token.getUserId();
	}
	public Boolean deleteToken(String header) {
		TokenDetail token = tokenRepo.findByToken(header);
		if (token!=null) {
			 tokenRepo.delete(token);
		}else {
			throw new BadDataExceptionHandler(GatewayConstants.USER_NOT_FOUND);
		}
		return true;
	}

}
