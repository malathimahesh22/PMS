package com.pms.gateway.api.contract;

import java.util.List;

import com.pms.gateway.api.response.ListResponse;

public interface LoginService {
	public abstract ListResponse<List<String>> getResponse(Integer id); 
}
