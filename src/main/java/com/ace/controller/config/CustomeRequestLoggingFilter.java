package com.ace.controller.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.CommonsRequestLoggingFilter;

public class CustomeRequestLoggingFilter 
extends CommonsRequestLoggingFilter {

  public CustomeRequestLoggingFilter() {
      super.setIncludeQueryString(true);
      super.setIncludePayload(true);
      super.setIncludeHeaders(true);
      super.setIncludeClientInfo(true);
      
      super.setMaxPayloadLength(10000);
  }
  
  @Override
	protected void beforeRequest(HttpServletRequest request, String message) {
		
		super.beforeRequest(request, message);
	}
  
  @Override
	protected void afterRequest(HttpServletRequest request, String message) {
		// TODO Auto-generated method stub
		super.afterRequest(request, message);
	}
}