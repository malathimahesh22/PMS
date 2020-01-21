package com.pms.gateway.services.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.gateway.services.model.LoginDetails;

public interface LoginUserDetailsRepo extends JpaRepository<LoginDetails, Integer>{

	LoginDetails findByUserName (String userName);
}
