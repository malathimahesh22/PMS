package com.pms.gateway.services.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.gateway.services.model.TokenDetail;

@Repository
public interface TokenRepo extends JpaRepository<TokenDetail, Integer> {

	TokenDetail findByToken(String header);
	TokenDetail findByUserId(Integer urseId);
}
