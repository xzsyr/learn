package com.xzsyr.zuul.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class EmployFallBack implements FallbackProvider{

	@Override
	public ClientHttpResponse fallbackResponse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRoute() {
		//指定要处理的 service。
		return null;
	}

	@Override
	public ClientHttpResponse fallbackResponse(Throwable cause) {
		// TODO Auto-generated method stub
		return null;
	}

}
