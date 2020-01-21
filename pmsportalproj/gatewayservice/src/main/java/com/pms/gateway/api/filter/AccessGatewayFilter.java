package com.pms.gateway.api.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.pms.gateway.util.TokenValidation;
import com.pms.gateway.services.util.TokenValidation;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 */
@Configuration
@Slf4j
public class AccessGatewayFilter implements GlobalFilter {

	@Autowired
	private TokenValidation tokenValidation;

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		log.debug("check token and user permission....");
		ServerHttpRequest request = exchange.getRequest();
		
		if (exchange.getRequest().getMethod().equals("OPTIONS")) {
			exchange.getResponse().setStatusCode(HttpStatus.OK);
			return Mono.empty();
		}
		if (exchange.getRequest().getPath().toString().contains("login")
				|| exchange.getRequest().getPath().toString().contains("logout") ||
				exchange.getRequest().getPath().toString().contains("refreshtoken")) {
			log.debug("Login Method Called");
			exchange.getResponse().setStatusCode(HttpStatus.OK);
			return Mono.empty();
		} else {
			String header = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
			if (header == null || header.isEmpty()) {
				log.debug("Header Not Available");
				return unauthorized(exchange);
			} else {
				Integer userId = /*tokenValidation.validateToken(header);*/ 0;
//				if (userId == null) {
//					log.debug("unauthorized");
//					return unauthorized(exchange);
//				}
				ServerHttpRequest.Builder builder = request.mutate();
				builder.header("userId", userId.toString());
				return chain.filter(exchange.mutate().request(builder.build()).build());
			}
		}
	}

	/**
	 *
	 * @param
	 * @throws IOException
	 */
	private Mono<Void> unauthorized(ServerWebExchange serverWebExchange) {
		try {
			serverWebExchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
			String jsonO = "{ \"status\" : 401, \"message\" : \"Token Expired\", \"error\" : true}";
			ObjectMapper mapper = new ObjectMapper();
			JsonNode actualObj = mapper.readTree(jsonO);
			String gsonObject = actualObj.toString();
			DataBuffer buffer = serverWebExchange.getResponse().bufferFactory().wrap(gsonObject.getBytes());
			return serverWebExchange.getResponse().writeWith(Flux.just(buffer));
		} catch (IOException e) {
		}
		return null;
	}

}
