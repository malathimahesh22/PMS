package com.pms.gatewayservice.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.pms.gatewayservice.exception.NoDataFoundException;
import com.pms.gatewayservice.response.ListResponse;
import com.pms.gatewayservice.util.GatewayConstants;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class LoginService {


	public ListResponse<List<String>> getResponse(Integer test) {
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
