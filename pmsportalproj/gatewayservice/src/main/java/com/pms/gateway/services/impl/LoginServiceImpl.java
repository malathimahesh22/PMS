package com.pms.gateway.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.pms.gateway.api.contract.LoginService;
import com.pms.gateway.api.exception.NoDataFoundException;
import com.pms.gateway.api.response.ListResponse;
import com.pms.gateway.services.util.GatewayConstants;


@Service
public class LoginServiceImpl  implements LoginService{@Override
	
	
	public ListResponse<List<String>> getResponse(Integer id) {
		// TODO Auto-generated method stub
		ListResponse<List<String>> response = new ListResponse<List<String>>();
		List<String> mcList = new ArrayList<String>();
		if (mcList == null || mcList.size() == 0)
			throw new NoDataFoundException(GatewayConstants.NOT_AVAILABLE);

		//mcList.forEach(vc -> list.add(function(vc)));
		response.setData(mcList);
		//response.setTotalRecords();
		response.setStatus(HttpServletResponse.SC_OK);
		response.setMessage(GatewayConstants.AVAILABLE);
		return response;
	}
	}


	

