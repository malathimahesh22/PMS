package com.pms.gatewayservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.gatewayservice.model.LoginDetails;

public interface LoginUserDetailsRepo extends JpaRepository<LoginDetails, Integer>{

	LoginDetails findByUserName (String userName);
}
